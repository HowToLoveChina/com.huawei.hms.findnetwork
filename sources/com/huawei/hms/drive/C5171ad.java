package com.huawei.hms.drive;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.drive.ad */
/* loaded from: classes8.dex */
public class C5171ad {

    /* renamed from: a */
    private static final Pattern f23568a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    private static String m30798a(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                sb2.append(m30797a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static void m30799a(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, m30798a(str2, z10));
    }

    /* renamed from: a */
    private static String m30797a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i10 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (f23568a.matcher(String.valueOf(cCharAt)).matches()) {
                if (i10 % 2 == 0) {
                    cCharAt = '*';
                }
                i10++;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }
}
