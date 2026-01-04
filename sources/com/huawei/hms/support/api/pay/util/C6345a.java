package com.huawei.hms.support.api.pay.util;

import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.support.api.pay.util.a */
/* loaded from: classes8.dex */
public class C6345a {
    /* renamed from: a */
    public static int m36675a(Intent intent, String str, int i10) {
        try {
            return intent.getIntExtra(str, i10);
        } catch (Throwable th2) {
            HMSLog.m36986e("IntentUtils", "safeGetIntExtra failed, " + th2.getMessage());
            return i10;
        }
    }

    /* renamed from: a */
    public static long m36676a(Intent intent, String str, long j10) {
        try {
            return intent.getLongExtra(str, j10);
        } catch (Throwable th2) {
            HMSLog.m36986e("IntentUtils", "safeGetLongExtra failed, " + th2.getMessage());
            return j10;
        }
    }

    /* renamed from: a */
    public static String m36677a(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable th2) {
            HMSLog.m36986e("IntentUtils", "safeGetStringExtra failed, " + th2.getMessage());
            return "";
        }
    }
}
