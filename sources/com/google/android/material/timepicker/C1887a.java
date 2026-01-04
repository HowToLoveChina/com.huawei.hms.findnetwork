package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.google.android.material.timepicker.a */
/* loaded from: classes.dex */
public class C1887a implements InputFilter {

    /* renamed from: a */
    public int f9048a;

    public C1887a(int i10) {
        this.f9048a = i10;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        try {
            StringBuilder sb2 = new StringBuilder(spanned);
            sb2.replace(i12, i13, charSequence.subSequence(i10, i11).toString());
            if (Integer.parseInt(sb2.toString()) <= this.f9048a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
