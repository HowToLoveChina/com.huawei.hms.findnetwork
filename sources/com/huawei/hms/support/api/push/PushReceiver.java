package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.AbstractC6282a;
import com.huawei.hms.push.AbstractC6285d;
import com.huawei.hms.push.C6298q;
import com.huawei.hms.push.C6299r;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class PushReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$b */
    public static class RunnableC6350b implements Runnable {

        /* renamed from: a */
        private Context f29874a;

        /* renamed from: b */
        private Intent f29875b;

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.f29875b.getPackage());
            try {
                JSONObject jSONObjectM36709b = PushReceiver.m36709b(this.f29875b);
                String string = JsonUtil.getString(jSONObjectM36709b, "moduleName", "");
                int i10 = JsonUtil.getInt(jSONObjectM36709b, "msgType", 0);
                int internalCode = JsonUtil.getInt(jSONObjectM36709b, "status", 0);
                if (ErrorEnum.SUCCESS.getInternalCode() != internalCode) {
                    internalCode = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                Bundle bundle = new Bundle();
                if ("Push".equals(string) && i10 == 1) {
                    bundle.putString(RemoteMessageConst.MSGTYPE, VastAttribute.DELIVERY);
                    bundle.putString("message_id", JsonUtil.getString(jSONObjectM36709b, RemoteMessageConst.MSGID, ""));
                    bundle.putInt(VastAttribute.ERROR, internalCode);
                    bundle.putString("transaction_id", JsonUtil.getString(jSONObjectM36709b, "transactionId", ""));
                } else {
                    if (this.f29875b.getExtras() != null) {
                        bundle.putAll(this.f29875b.getExtras());
                    }
                    bundle.putString(RemoteMessageConst.MSGTYPE, "received_message");
                    bundle.putString("message_id", this.f29875b.getStringExtra("msgIdStr"));
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, this.f29875b.getByteArrayExtra("msg_data"));
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, AbstractC6282a.m36503a(this.f29875b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                    bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                    bundle.putString("message_proxy_type", this.f29875b.getStringExtra("message_proxy_type"));
                }
                if (new C6299r().m36598a(this.f29874a, bundle, intent)) {
                    HMSLog.m36988i("PushReceiver", "receive " + this.f29875b.getAction() + " and start service success");
                    return;
                }
                HMSLog.m36986e("PushReceiver", "receive " + this.f29875b.getAction() + " and start service failed");
            } catch (RuntimeException unused) {
                HMSLog.m36986e("PushReceiver", "handle push message occur exception.");
            }
        }

        private RunnableC6350b(Context context, Intent intent) {
            this.f29874a = context;
            this.f29875b = intent;
        }
    }

    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$c */
    public static class RunnableC6351c implements Runnable {

        /* renamed from: a */
        private Context f29876a;

        /* renamed from: b */
        private Intent f29877b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.f29877b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    HMSLog.m36988i("PushReceiver", "receive a push token: " + this.f29876a.getPackageName());
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.f29877b.getPackage());
                    Bundle bundle = new Bundle();
                    bundle.putString(RemoteMessageConst.MSGTYPE, "new_token");
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, AbstractC6282a.m36503a(byteArrayExtra));
                    bundle.putString("transaction_id", this.f29877b.getStringExtra("transaction_id"));
                    bundle.putString("subjectId", this.f29877b.getStringExtra("subjectId"));
                    bundle.putInt(VastAttribute.ERROR, this.f29877b.getIntExtra(VastAttribute.ERROR, ErrorEnum.SUCCESS.getInternalCode()));
                    bundle.putString("belongId", this.f29877b.getStringExtra("belongId"));
                    if (new C6299r().m36598a(this.f29876a, bundle, intent)) {
                        return;
                    }
                    HMSLog.m36986e("PushReceiver", "receive " + this.f29877b.getAction() + " and start service failed");
                    return;
                }
                HMSLog.m36988i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.m36986e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.m36986e("PushReceiver", "handle push token error");
            }
        }

        private RunnableC6351c(Context context, Intent intent) {
            this.f29876a = context;
            this.f29877b = intent;
        }
    }

    /* renamed from: b */
    private void m36711b(Context context, Intent intent) {
        try {
            if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                C6298q.m36594a().execute(new RunnableC6351c(context, intent));
            } else {
                HMSLog.m36988i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m36986e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m36986e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        HMSLog.m36988i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                m36711b(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                m36708a(context, intent);
            } else {
                HMSLog.m36988i("PushReceiver", "message can't be recognised.");
            }
        } catch (Exception unused) {
            HMSLog.m36986e("PushReceiver", "intent has some error");
        }
    }

    /* renamed from: a */
    private void m36708a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                C6298q.m36594a().execute(new RunnableC6350b(context, intent));
            } else {
                HMSLog.m36988i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m36986e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m36986e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    /* renamed from: b */
    private static JSONObject m36710b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    /* renamed from: a */
    private static JSONObject m36707a(byte[] bArr) {
        try {
            return new JSONObject(AbstractC6282a.m36503a(bArr));
        } catch (JSONException unused) {
            HMSLog.m36989w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static JSONObject m36709b(Intent intent) throws RuntimeException {
        JSONObject jSONObjectM36707a = m36707a(intent.getByteArrayExtra("msg_data"));
        JSONObject jSONObjectM36706a = m36706a(jSONObjectM36707a);
        String string = JsonUtil.getString(jSONObjectM36706a, "data", null);
        if (AbstractC6285d.m36510a(jSONObjectM36706a, m36710b(jSONObjectM36706a), string)) {
            return jSONObjectM36707a;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m36706a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
