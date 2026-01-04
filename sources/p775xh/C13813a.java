package p775xh;

import com.huawei.secure.android.common.util.SafeString;
import java.util.Locale;

/* renamed from: xh.a */
/* loaded from: classes4.dex */
public class C13813a {
    /* renamed from: a */
    public static String m82851a(CharSequence charSequence, boolean z10) {
        return m82852b(charSequence, z10, "is", "get");
    }

    /* renamed from: b */
    public static String m82852b(CharSequence charSequence, boolean z10, String str, String str2) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = charSequence.toString();
        if (!z10 || !string.startsWith("is") || charSequence.length() <= 2 || Character.isLowerCase(charSequence.charAt(2))) {
            if (!z10) {
                str = str2;
            }
            return m82853c(str, string);
        }
        return str + SafeString.substring(string, 2);
    }

    /* renamed from: c */
    public static String m82853c(String str, String str2) {
        if (str2.length() == 0) {
            return str;
        }
        if (str.length() == 0) {
            return str2;
        }
        char cCharAt = str2.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            if (str2.length() > 1 && Character.isUpperCase(str2.charAt(1))) {
                return String.format(Locale.ENGLISH, "%s%s", str, str2);
            }
            boolean z10 = str2.length() > 2 && (Character.isTitleCase(str2.charAt(1)) || Character.isUpperCase(str2.charAt(1)));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[2];
            objArr[0] = Character.valueOf(z10 ? Character.toUpperCase(cCharAt) : Character.toTitleCase(cCharAt));
            objArr[1] = str2.subSequence(1, str2.length());
            str2 = String.format(locale, "%s%s", objArr);
        }
        return String.format(Locale.ENGLISH, "%s%s", str, str2);
    }
}
