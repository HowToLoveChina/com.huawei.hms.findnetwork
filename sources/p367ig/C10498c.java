package p367ig;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: ig.c */
/* loaded from: classes4.dex */
public class C10498c implements CharSequence {

    /* renamed from: a */
    public final CharSequence f50664a;

    /* renamed from: b */
    public final boolean f50665b;

    public C10498c(CharSequence charSequence) {
        this.f50665b = 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault());
        this.f50664a = charSequence;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f50665b ? '*' : (char) 8226;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f50664a.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f50664a.subSequence(i10, i11);
    }
}
