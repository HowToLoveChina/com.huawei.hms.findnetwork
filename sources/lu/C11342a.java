package lu;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.appgallery.agd.api.AgdConstant;
import java.util.Locale;

/* renamed from: lu.a */
/* loaded from: classes5.dex */
public class C11342a {

    /* renamed from: a */
    public static final String f53056a = "EncodeUtil";

    /* renamed from: b */
    public static final char[] f53057b = {',', '.', '-', '_'};

    /* renamed from: c */
    public static final String[] f53058c = new String[256];

    static {
        for (char c10 = 0; c10 < 255; c10 = (char) (c10 + 1)) {
            if ((c10 < '0' || c10 > '9') && ((c10 < 'A' || c10 > 'Z') && (c10 < 'a' || c10 > 'z'))) {
                f53058c[c10] = m68143e(c10).intern();
            } else {
                f53058c[c10] = null;
            }
        }
    }

    /* renamed from: a */
    public static String m68139a(char c10) {
        return c10 < 255 ? f53058c[c10] : m68143e(c10);
    }

    /* renamed from: b */
    public static String m68140b(char[] cArr, Character ch2) {
        if (m68142d(ch2.charValue(), cArr)) {
            return "" + ch2;
        }
        if (m68139a(ch2.charValue()) == null) {
            return "" + ch2;
        }
        String hexString = Integer.toHexString(ch2.charValue());
        if (ch2.charValue() < 256) {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + AgdConstant.INSTALL_TYPE_DEFAULT.substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: c */
    public static String m68141c(char[] cArr, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(m68140b(cArr, Character.valueOf(str.charAt(i10))));
        }
        return sb2.toString();
    }

    /* renamed from: d */
    public static boolean m68142d(char c10, char[] cArr) {
        for (char c11 : cArr) {
            if (c10 == c11) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static String m68143e(char c10) {
        return Integer.toHexString(c10);
    }

    /* renamed from: f */
    public static String m68144f(String str) {
        return m68145g(str, f53057b);
    }

    /* renamed from: g */
    public static String m68145g(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return m68141c(cArr, str);
        } catch (Exception e10) {
            Log.e(f53056a, "encode js: " + e10.getMessage());
            return "";
        }
    }
}
