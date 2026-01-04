package p787xt;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* renamed from: xt.a */
/* loaded from: classes5.dex */
public class C13865a {

    /* renamed from: a */
    public static final Pattern f62148a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    public static String m83187a(String str) {
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
            if (f62148a.matcher(String.valueOf(cCharAt)).matches()) {
                if (i10 % 2 == 0) {
                    cCharAt = '*';
                }
                i10++;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m83188b(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                sb2.append(m83187a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public static void m83189c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(m83192f(str), m83188b(str2, false));
    }

    /* renamed from: d */
    public static void m83190d(String str, String str2, Throwable th2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(m83192f(str), str2 + " , throwable message : " + th2.getMessage());
    }

    /* renamed from: e */
    public static void m83191e(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(m83192f(str), m83188b(str2, z10));
    }

    /* renamed from: f */
    public static String m83192f(String str) {
        return "SecurityComp10300302: " + str;
    }

    /* renamed from: g */
    public static void m83193g(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(m83192f(str), m83188b(str2, false));
    }
}
