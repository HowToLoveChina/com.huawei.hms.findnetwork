package com.huawei.hms.iap.util;

import android.content.Intent;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class IapClientHelper {
    /* renamed from: a */
    private static int m33009a(Intent intent, String str, int i10) {
        if (intent != null) {
            return C5661c.m33025a(intent, str, i10);
        }
        HMSLog.m36986e("IapClientHelper", "parseIntDataFromIntent: intent is null.");
        return -1;
    }

    @Deprecated
    public static int parseAccountFlagFromIntent(Intent intent) {
        return m33009a(intent, CommonConstant.KEY_ACCOUNT_FLAG, 0);
    }

    public static String parseCarrierIdFromIntent(Intent intent) {
        return m33010a(intent, CommonConstant.KEY_CARRIER_ID, (String) null);
    }

    public static String parseCountryFromIntent(Intent intent) {
        return m33010a(intent, "country", (String) null);
    }

    public static int parseRespCodeFromIntent(Intent intent) {
        return m33009a(intent, "returnCode", -1);
    }

    public static String parseRespMessageFromIntent(Intent intent) {
        return m33010a(intent, "errMsg", "");
    }

    /* renamed from: a */
    private static String m33010a(Intent intent, String str, String str2) {
        if (intent != null) {
            return C5661c.m33027a(intent, str, str2);
        }
        HMSLog.m36988i("IapClientHelper", "parseStringDataFromIntent: intent is null.");
        return str2;
    }
}
