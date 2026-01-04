package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.push.HandlerC6287f;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* renamed from: a */
    private final Messenger f29606a = new Messenger(new HandlerC6287f(new C6280b(this, null)));

    /* renamed from: com.huawei.hms.push.HmsMessageService$a */
    public class RunnableC6279a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f29607a;

        /* renamed from: b */
        final /* synthetic */ String f29608b;

        public RunnableC6279a(String str, String str2) {
            this.f29607a = str;
            this.f29608b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = HmsMessageService.this.getApplicationContext();
            if (this.f29608b.equals(BaseUtils.getLocalToken(applicationContext, this.f29607a))) {
                return;
            }
            HMSLog.m36988i("HmsMessageService", "receive a new token, refresh the local token");
            BaseUtils.saveToken(applicationContext, this.f29607a, this.f29608b);
        }
    }

    /* renamed from: com.huawei.hms.push.HmsMessageService$b */
    public class C6280b implements HandlerC6287f.a {
        private C6280b() {
        }

        @Override // com.huawei.hms.push.HandlerC6287f.a
        /* renamed from: a */
        public void mo36482a(Message message) {
            if (message == null) {
                HMSLog.m36986e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.m36988i("HmsMessageService", "handle message start...");
            Bundle data = Message.obtain(message).getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.putExtra(RemoteMessageConst.INPUT_TYPE, data.getInt(RemoteMessageConst.INPUT_TYPE, -1));
                HmsMessageService.this.handleIntentMessage(intent);
            }
        }

        public /* synthetic */ C6280b(HmsMessageService hmsMessageService, RunnableC6279a runnableC6279a) {
            this();
        }
    }

    /* renamed from: a */
    private void m36477a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AsyncExec.submitSeqIO(new RunnableC6279a(str2, str));
    }

    /* renamed from: b */
    private void m36479b(Intent intent) throws JSONException {
        HMSLog.m36988i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(stringExtra);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String strOptString = jSONObject.optString("transactionId");
                String strOptString2 = jSONObject.optString(RemoteMessageConst.MSGID);
                int iOptInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                if (ErrorEnum.SUCCESS.getInternalCode() == iOptInt) {
                    m36480b(strOptString, strOptString2);
                } else {
                    m36481b(strOptString, strOptString2, iOptInt);
                }
            }
        } catch (JSONException unused) {
            HMSLog.m36989w("HmsMessageService", "parse batch response failed.");
        }
    }

    public void doMsgReceived(Intent intent) {
        onMessageReceived(new RemoteMessage(m36473a(intent)));
    }

    public void handleIntentMessage(Intent intent) {
        if (intent == null) {
            HMSLog.m36986e("HmsMessageService", "receive message is null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra(RemoteMessageConst.MSGTYPE);
            String stringExtra3 = intent.getStringExtra("transaction_id");
            if ("new_token".equals(stringExtra2)) {
                HMSLog.m36988i("HmsMessageService", "onNewToken");
                m36476a(intent, stringExtra3);
            } else if ("received_message".equals(stringExtra2)) {
                HMSLog.m36988i("HmsMessageService", "onMessageReceived, message id:" + stringExtra);
                m36478a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
                doMsgReceived(intent);
            } else if ("sent_message".equals(stringExtra2)) {
                m36480b(stringExtra3, stringExtra);
            } else if ("send_error".equals(stringExtra2)) {
                m36481b(stringExtra3, stringExtra, intent.getIntExtra(VastAttribute.ERROR, ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
            } else if (VastAttribute.DELIVERY.equals(stringExtra2)) {
                int intExtra = intent.getIntExtra(VastAttribute.ERROR, ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                HMSLog.m36988i("HmsMessageService", "onMessageDelivery, message id:" + stringExtra + ", status:" + intExtra + ", transactionId: " + stringExtra3);
                m36478a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                onMessageDelivered(stringExtra, new SendException(intExtra));
            } else if ("server_deleted_message".equals(stringExtra2)) {
                HMSLog.m36988i("HmsMessageService", "delete message, message id:" + stringExtra);
                onDeletedMessages();
            } else if ("batchSent".equals(stringExtra2)) {
                m36479b(intent);
            } else {
                HMSLog.m36986e("HmsMessageService", "Receive unknown message: " + stringExtra2);
            }
        } catch (RuntimeException e10) {
            HMSLog.m36986e("HmsMessageService", "handle intent RuntimeException: " + e10.getMessage());
        } catch (Exception e11) {
            HMSLog.m36986e("HmsMessageService", "handle intent exception: " + e11.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.m36988i("HmsMessageService", "start to bind");
        return this.f29606a.getBinder();
    }

    public void onDeletedMessages() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        HMSLog.m36988i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        HMSLog.m36988i("HmsMessageService", "start to command , startId = " + i11);
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exc) {
    }

    public void onNewToken(String str, Bundle bundle) {
    }

    public void onTokenError(Exception exc, Bundle bundle) {
    }

    /* renamed from: a */
    private Bundle m36473a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("message_id", intent.getStringExtra("message_id"));
        bundle.putByteArray(RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(RemoteMessageConst.MSGBODY));
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
        if (intent.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) == 1) {
            bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
        }
        return bundle;
    }

    /* renamed from: a */
    private void m36476a(Intent intent, String str) {
        ErrorEnum errorEnum = ErrorEnum.SUCCESS;
        int intExtra = intent.getIntExtra(VastAttribute.ERROR, errorEnum.getInternalCode());
        m36478a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        String stringExtra = intent.getStringExtra("subjectId");
        String stringExtra2 = intent.getStringExtra("message_proxy_type");
        HMSLog.m36988i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == errorEnum.getInternalCode()) {
            HMSLog.m36988i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
            m36474a(intent, bundle, stringExtra);
            return;
        }
        HMSLog.m36988i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
        m36475a(intent, bundle, stringExtra, intExtra);
    }

    /* renamed from: b */
    private void m36480b(String str, String str2) {
        HMSLog.m36988i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        m36478a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    /* renamed from: b */
    private void m36481b(String str, String str2, int i10) {
        HMSLog.m36988i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i10 + ", transactionId: " + str);
        m36478a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i10);
        onSendError(str2, new SendException(i10));
    }

    /* renamed from: a */
    private synchronized void m36475a(Intent intent, Bundle bundle, String str, int i10) {
        try {
            Context applicationContext = getApplicationContext();
            boolean z10 = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
            if (bundle.isEmpty() && z10) {
                HMSLog.m36988i("HmsMessageService", "onTokenError to host app.");
                onTokenError(new BaseException(i10));
                BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
            }
            if (TextUtils.isEmpty(str)) {
                String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
                if (subjectIds != null && subjectIds.length != 0) {
                    for (int i11 = 0; i11 < subjectIds.length; i11++) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(SUBJECT_ID, subjectIds[i11]);
                        HMSLog.m36988i("HmsMessageService", "onTokenError to sub app, subjectId:" + subjectIds[i11]);
                        onTokenError(new BaseException(i10), bundle2);
                    }
                    BaseUtils.clearSubjectIds(applicationContext);
                }
                HMSLog.m36988i("HmsMessageService", "onTokenError to host app with bundle.");
                onTokenError(new BaseException(i10), bundle);
                return;
            }
            HMSLog.m36988i("HmsMessageService", "onTokenError to sub app, subjectId:" + str);
            onTokenError(new BaseException(i10), bundle);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    private synchronized void m36474a(Intent intent, Bundle bundle, String str) {
        try {
            String stringExtra = intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN);
            m36477a(stringExtra, str);
            Context applicationContext = getApplicationContext();
            boolean z10 = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
            if (bundle.isEmpty() && z10) {
                HMSLog.m36988i("HmsMessageService", "onNewToken to host app.");
                onNewToken(stringExtra);
                BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
            }
            if (TextUtils.isEmpty(str)) {
                String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
                if (subjectIds != null && subjectIds.length != 0) {
                    for (int i10 = 0; i10 < subjectIds.length; i10++) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(SUBJECT_ID, subjectIds[i10]);
                        HMSLog.m36988i("HmsMessageService", "onNewToken to sub app, subjectId:" + subjectIds[i10]);
                        onNewToken(stringExtra, bundle2);
                        m36477a(stringExtra, subjectIds[i10]);
                    }
                    BaseUtils.clearSubjectIds(applicationContext);
                }
                HMSLog.m36988i("HmsMessageService", "onNewToken to host app with bundle.");
                bundle.putString("belongId", intent.getStringExtra("belongId"));
                onNewToken(stringExtra, bundle);
                return;
            }
            HMSLog.m36988i("HmsMessageService", "onNewToken to sub app, subjectId:" + str);
            onNewToken(stringExtra, bundle);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    private void m36478a(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        PushBiUtil.reportExit(getApplicationContext(), str, str2, i10);
    }
}
