package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* renamed from: com.google.android.material.textfield.e */
/* loaded from: classes.dex */
public abstract class AbstractC1866e {

    /* renamed from: a */
    public TextInputLayout f8946a;

    /* renamed from: b */
    public Context f8947b;

    /* renamed from: c */
    public CheckableImageButton f8948c;

    /* renamed from: d */
    public final int f8949d;

    public AbstractC1866e(TextInputLayout textInputLayout, int i10) {
        this.f8946a = textInputLayout;
        this.f8947b = textInputLayout.getContext();
        this.f8948c = textInputLayout.getEndIconView();
        this.f8949d = i10;
    }

    /* renamed from: a */
    public abstract void mo11273a();

    /* renamed from: b */
    public boolean mo11321b(int i10) {
        return true;
    }

    /* renamed from: c */
    public void mo11274c(boolean z10) {
    }

    /* renamed from: d */
    public boolean mo11322d() {
        return false;
    }
}
