package com.huawei.hms.iap.util;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.iap.util.c */
/* loaded from: classes8.dex */
public class C5661c {
    /* renamed from: a */
    public static int m33025a(Intent intent, String str, int i10) {
        try {
            return intent.getIntExtra(str, i10);
        } catch (Throwable th2) {
            HMSLog.m36986e("IntentUtils", "safeGetIntExtra failed, " + th2.getMessage());
            return i10;
        }
    }

    /* renamed from: a */
    public static String m33026a(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable th2) {
            HMSLog.m36986e("IntentUtils", "safeGetStringExtra failed, " + th2.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public static String m33027a(Intent intent, String str, String str2) {
        String strM33026a = m33026a(intent, str);
        return TextUtils.isEmpty(strM33026a) ? str2 : strM33026a;
    }

    /* renamed from: a */
    public static boolean m33028a(Intent intent, String str, boolean z10) {
        try {
            return intent.getBooleanExtra(str, z10);
        } catch (Throwable th2) {
            HMSLog.m36986e("IntentUtils", "safeGetBooleanExtra failed, " + th2.getMessage());
            return z10;
        }
    }
}
