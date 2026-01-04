package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.huawei.hms.hatool.c0 */
/* loaded from: classes8.dex */
public class C5520c0 {
    /* renamed from: a */
    public static boolean m32464a(Context context) {
        return System.currentTimeMillis() - C5522d.m32475a(context, "Privacy_MY", "flashKeyTime", -1L) > 43200000;
    }

    /* renamed from: a */
    public static boolean m32465a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (context.checkSelfPermission(str) == 0) {
            return false;
        }
        C5571v.m32797f("hmsSdk", "not have read phone permission!");
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public static boolean m32466a(Context context, String str, int i10) {
        String str2 = C5522d.m32482c(context, str) + ".xml";
        File file = new File(context.getFilesDir(), "../shared_prefs/" + str2);
        if (!file.exists()) {
            String str3 = context.getPackageName() + "_" + str2;
            file = new File(context.getFilesDir(), "../../shared_prefs/" + str3);
        }
        long length = file.length();
        if (length <= i10) {
            return false;
        }
        C5571v.m32792c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i10)));
        return true;
    }

    /* renamed from: a */
    public static boolean m32467a(String str, long j10, long j11) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j10 - Long.parseLong(str) > j11;
        } catch (NumberFormatException unused) {
            C5571v.m32797f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
