package com.huawei.hms.push;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.push.task.SubscribeNotificationTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import p208cq.C8941i;
import p208cq.C8943k;

/* loaded from: classes8.dex */
public class NotificationSubscription {
    public static final int NOTIFICATION_SUBSCRIBE_REQUEST_CODE = 1001;

    /* renamed from: d */
    private static final String f29617d = "NotificationSubscription";

    /* renamed from: a */
    private Activity f29618a;

    /* renamed from: b */
    private Context f29619b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f29620c;

    private NotificationSubscription(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f29619b = activity.getApplicationContext();
        this.f29618a = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(activity, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        this.f29620c = huaweiApi;
        huaweiApi.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<SubscribeResult> m36491a(List<String> list) {
        String strReportEntry = PushBiUtil.reportEntry(this.f29619b, PushNaming.SUBSCRIBE_NOTIFICATION);
        if (list == null || list.isEmpty() || list.size() > 3) {
            Context context = this.f29619b;
            ErrorEnum errorEnum = ErrorEnum.ERROR_ARGUMENTS_INVALID;
            PushBiUtil.reportExit(context, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, errorEnum);
            HMSLog.m36986e(f29617d, "Invalid entityIds: entityId list should not be empty or more than max size");
            return m36490a(errorEnum.toApiException());
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Context context2 = this.f29619b;
            ErrorEnum errorEnum2 = ErrorEnum.ERROR_MAIN_THREAD;
            PushBiUtil.reportExit(context2, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, errorEnum2);
            return m36490a(errorEnum2.toApiException());
        }
        if (!((NotificationManager) this.f29619b.getSystemService("notification")).areNotificationsEnabled()) {
            HMSLog.m36988i(f29617d, "App disabled notification");
            Context context3 = this.f29619b;
            ErrorEnum errorEnum3 = ErrorEnum.ERROR_NOTIFICATION_DISABLED;
            PushBiUtil.reportExit(context3, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, errorEnum3);
            return m36490a(errorEnum3.toApiException());
        }
        try {
            if (C6306v.m36619a(this.f29619b) != ErrorEnum.SUCCESS) {
                return m36490a(ErrorEnum.ERROR_NO_TOKEN.toApiException());
            }
            if (-1 != this.f29619b.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f29619b.getPackageName()) && C6288g.m36525a(this.f29619b) == -1) {
                HMSLog.m36986e(f29617d, "no network");
                return m36490a(ErrorEnum.ERROR_NO_NETWORK.toApiException());
            }
            Task taskDoWrite = this.f29620c.doWrite(new SubscribeNotificationTask(this.f29618a, PushNaming.SUBSCRIBE_NOTIFICATION, m36492b(list), strReportEntry));
            C8943k.m56661a(taskDoWrite);
            return taskDoWrite;
        } catch (Exception e10) {
            if (e10.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e10.getCause();
                PushBiUtil.reportExit(this.f29619b, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, apiException.getStatusCode());
                return m36490a(apiException);
            }
            Context context4 = this.f29619b;
            ErrorEnum errorEnum4 = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit(context4, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, errorEnum4);
            return m36490a(errorEnum4.toApiException());
        }
    }

    /* renamed from: b */
    private SubscribeNotificationReq m36492b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        SubscribeNotificationReq subscribeNotificationReq = new SubscribeNotificationReq();
        subscribeNotificationReq.setEntityIds(jSONArray.toString());
        subscribeNotificationReq.setToken(BaseUtils.getLocalToken(this.f29619b, null));
        return subscribeNotificationReq;
    }

    public static NotificationSubscription getInstance(Activity activity) {
        return new NotificationSubscription(activity);
    }

    public static SubscribeResult getSubscribeResult(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            stringExtra = intent.getStringExtra(C2126b.ERROR_MESSAGE_INFO);
        } catch (Throwable unused) {
            HMSLog.m36986e(f29617d, "get subscribe result occurs exception");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("subscribedItems");
            if (!TextUtils.isEmpty(stringExtra2)) {
                List<SubscribedItem> listM36504a = C6283b.m36504a(stringExtra2);
                SubscribeResult subscribeResult = new SubscribeResult();
                subscribeResult.setSubscribedItems(listM36504a);
                return subscribeResult;
            }
            return null;
        }
        SubscribeResult subscribeResult2 = new SubscribeResult();
        subscribeResult2.setErrorMsg(stringExtra);
        HMSLog.m36986e(f29617d, "get subscribe error msg:" + stringExtra);
        return subscribeResult2;
    }

    public Task<SubscribeResult> requestSubscribeNotification(List<String> list) {
        HMSLog.m36988i(f29617d, "invoke request subscribe notification");
        return m36491a(list);
    }

    /* renamed from: a */
    private Task<SubscribeResult> m36490a(Exception exc) {
        C8941i c8941i = new C8941i();
        c8941i.m56657c(exc);
        return c8941i.m56656b();
    }
}
