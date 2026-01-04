package p031b7;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* renamed from: b7.k */
/* loaded from: classes2.dex */
public class C1130k {

    /* renamed from: b7.k$a */
    public class a implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            if (Pattern.matches("^[^\\\\/:*?<>\"|\\[\\]\\{\\}]+$", charSequence.toString())) {
                return null;
            }
            return "";
        }
    }

    /* renamed from: a */
    public static InputFilter m6916a() {
        return new InputFilter.LengthFilter(100);
    }

    /* renamed from: b */
    public static InputFilter m6917b() {
        return new InputFilter.LengthFilter(20);
    }

    /* renamed from: c */
    public static InputFilter m6918c() {
        return new a();
    }
}
