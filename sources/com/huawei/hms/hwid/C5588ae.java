package com.huawei.hms.hwid;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.UIUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.ae */
/* loaded from: classes8.dex */
public class C5588ae extends TaskApiCall<C5623u, Intent> {
    public C5588ae(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5623u c5623u, ResponseErrorCode responseErrorCode, String str, C8941i<Intent> c8941i) throws IntentSender.SendIntentException {
        if (responseErrorCode == null) {
            C5602as.m32910b("NoticeTaskApiCall", "header is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        if (responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0) {
            C5602as.m32910b("NoticeTaskApiCall", "Jos Notice onResult success.", true);
            m32864a(responseErrorCode.getParcelable(), c5623u, responseErrorCode, c8941i);
        } else {
            C5602as.m32911c("NoticeTaskApiCall", "Jos Notice onResult failed, ErrCode" + responseErrorCode.getErrorCode(), true);
        }
        if (c5623u != null) {
            HiAnalyticsClient.reportExit(c5623u.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    /* renamed from: a */
    private void m32864a(Parcelable parcelable, C5623u c5623u, ResponseErrorCode responseErrorCode, C8941i<Intent> c8941i) throws IntentSender.SendIntentException {
        Activity currentActivity = ActivityMgr.INST.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
            C5602as.m32910b("NoticeTaskApiCall", "launchNoticeActivity failed, activity is invalid", true);
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                currentActivity.startActivity((Intent) parcelable);
            } catch (Exception unused) {
                C5602as.m32912d("NoticeTaskApiCall", "Jos Notice startActivity meet exception", true);
            }
        } else if (parcelable instanceof PendingIntent) {
            PendingIntent pendingIntent = (PendingIntent) parcelable;
            try {
                if (UIUtil.isBackground(c5623u.getContext())) {
                    C5602as.m32910b("NoticeTaskApiCall", "ui isBackground.", true);
                    c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), pendingIntent)));
                } else {
                    currentActivity.startIntentSender(pendingIntent.getIntentSender(), null, 0, 0, 0);
                }
            } catch (IntentSender.SendIntentException unused2) {
                C5602as.m32912d("NoticeTaskApiCall", "Jos Notice startIntentSender meet exception", true);
            }
        }
    }
}
