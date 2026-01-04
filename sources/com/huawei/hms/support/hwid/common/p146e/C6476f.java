package com.huawei.hms.support.hwid.common.p146e;

import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.common.C6462a;

/* renamed from: com.huawei.hms.support.hwid.common.e.f */
/* loaded from: classes8.dex */
public class C6476f {
    /* renamed from: a */
    public static void m36902a(String str, String str2, String str3) {
        m36901a(str, str2, 0, str3);
    }

    /* renamed from: a */
    public static void m36901a(String str, String str2, int i10, String str3) {
        C6477g.m36904a("HiAnalyticsUtil", "report:" + str2 + "|" + str + "|" + str3 + "|HiAnalyticsStatus:" + C6472b.m36869a(i10) + "|" + i10 + "|" + AuthInternalPickerConstant.HMS_SDK_VERSION, false);
        HiAnalyticsClient.reportExit(C6462a.m36833a().m36836b(), str2, str, str3, C6472b.m36869a(i10), i10, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }
}
