package p626ry;

import java.util.regex.Pattern;

/* renamed from: ry.b */
/* loaded from: classes9.dex */
public class C12653b {

    /* renamed from: a */
    public static final Pattern f58122a = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    /* renamed from: a */
    public static boolean m76181a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m76182b(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
