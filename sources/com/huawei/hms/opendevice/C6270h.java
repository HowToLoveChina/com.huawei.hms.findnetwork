package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* renamed from: com.huawei.hms.opendevice.h */
/* loaded from: classes8.dex */
public final class C6270h {
    /* renamed from: a */
    public static String m36430a(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 61300300);
    }

    /* renamed from: a */
    public static void m36431a(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 61300300);
    }

    /* renamed from: a */
    public static void m36433a(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 61300300);
    }

    /* renamed from: a */
    public static void m36432a(Context context, String str, String str2, int i10) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i10, 61300300);
    }
}
