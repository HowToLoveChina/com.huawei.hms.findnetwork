package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import p273f0.C9603h0;
import p383j3.InterfaceC10701a;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC10701a {

    /* renamed from: a */
    public TextView f8677a;

    /* renamed from: b */
    public Button f8678b;

    /* renamed from: c */
    public int f8679c;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    public static void m11026c(View view, int i10, int i11) {
        if (C9603h0.m59866V(view)) {
            C9603h0.m59839D0(view, C9603h0.m59842F(view), i10, C9603h0.m59840E(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    @Override // p383j3.InterfaceC10701a
    /* renamed from: a */
    public void mo11027a(int i10, int i11) {
        this.f8677a.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.f8677a.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.f8678b.getVisibility() == 0) {
            this.f8678b.setAlpha(0.0f);
            this.f8678b.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    @Override // p383j3.InterfaceC10701a
    /* renamed from: b */
    public void mo11028b(int i10, int i11) {
        this.f8677a.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.f8677a.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.f8678b.getVisibility() == 0) {
            this.f8678b.setAlpha(1.0f);
            this.f8678b.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    /* renamed from: d */
    public final boolean m11029d(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f8677a.getPaddingTop() == i11 && this.f8677a.getPaddingBottom() == i12) {
            return z10;
        }
        m11026c(this.f8677a, i11, i12);
        return true;
    }

    public Button getActionView() {
        return this.f8678b;
    }

    public TextView getMessageView() {
        return this.f8677a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8677a = (TextView) findViewById(R$id.snackbar_text);
        this.f8678b = (Button) findViewById(R$id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        super.onMeasure(i10, i11);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        boolean z10 = this.f8677a.getLayout().getLineCount() > 1;
        if (!z10 || this.f8679c <= 0 || this.f8678b.getMeasuredWidth() <= this.f8679c) {
            if (!z10) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!m11029d(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!m11029d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f8679c = i10;
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
