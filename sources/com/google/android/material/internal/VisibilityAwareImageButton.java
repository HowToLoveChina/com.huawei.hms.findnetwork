package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a */
    public int f8251a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public final void m10567b(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f8251a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f8251a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        m10567b(i10, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8251a = getVisibility();
    }
}
