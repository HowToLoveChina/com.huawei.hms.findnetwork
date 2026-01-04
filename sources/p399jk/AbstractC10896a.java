package p399jk;

import android.text.TextUtils;
import android.util.Log;
import ck.C1443a;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: jk.a */
/* loaded from: classes6.dex */
public abstract class AbstractC10896a {
    private static final String DEFAULT_FORMAT_TAG = "Cloud[%s]%s.%s";
    private static final int LEN_CONST = 2;
    private static final Pattern M_PATTERN = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    private static final char STAR = '*';
    private static final String TAG_PREFIX = "Base";

    public static String convertMsg(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public static void m65885d(String str, String str2) {
        if (C1443a.f6214b.booleanValue()) {
            Log.d(formatTag(TAG_PREFIX, str), convertMsg(str2));
        }
    }

    /* renamed from: e */
    public static void m65886e(String str, String str2) {
        Log.e(formatTag(TAG_PREFIX, str), convertMsg(str2));
    }

    public static String formatTag(String str, String str2) {
        return String.format(Locale.ENGLISH, DEFAULT_FORMAT_TAG, "16.0.0.300", str, str2);
    }

    /* renamed from: i */
    public static void m65887i(String str, String str2) {
        Log.i(formatTag(TAG_PREFIX, str), convertMsg(str2));
    }

    public static String proguardMsg(String str) {
        if (TextUtils.isEmpty(str) || C1443a.f6214b.booleanValue()) {
            return str;
        }
        int length = str.length();
        int i10 = 1;
        if (1 == length) {
            return String.valueOf(STAR);
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (M_PATTERN.matcher(String.valueOf(cCharAt)).matches()) {
                if (i10 % 2 == 0) {
                    cCharAt = '*';
                }
                i10++;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    /* renamed from: w */
    public static void m65888w(String str, String str2) {
        Log.w(formatTag(TAG_PREFIX, str), convertMsg(str2));
    }
}
