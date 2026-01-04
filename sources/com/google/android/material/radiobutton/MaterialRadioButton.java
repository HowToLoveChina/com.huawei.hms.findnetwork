package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.C0662c;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p276f3.C9649c;
import p416k3.C10981a;
import p760x2.C13689a;

/* loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g */
    public static final int f8553g = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h */
    public static final int[][] f8554h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e */
    public ColorStateList f8555e;

    /* renamed from: f */
    public boolean f8556f;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f8555e == null) {
            int iM82290d = C13689a.m82290d(this, R$attr.colorControlActivated);
            int iM82290d2 = C13689a.m82290d(this, R$attr.colorOnSurface);
            int iM82290d3 = C13689a.m82290d(this, R$attr.colorSurface);
            int[][] iArr = f8554h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = C13689a.m82294h(iM82290d3, iM82290d, 1.0f);
            iArr2[1] = C13689a.m82294h(iM82290d3, iM82290d2, 0.54f);
            iArr2[2] = C13689a.m82294h(iM82290d3, iM82290d2, 0.38f);
            iArr2[3] = C13689a.m82294h(iM82290d3, iM82290d2, 0.38f);
            this.f8555e = new ColorStateList(iArr, iArr2);
        }
        return this.f8555e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8556f && C0662c.m4040b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f8556f = z10;
        if (z10) {
            C0662c.m4041c(this, getMaterialThemeColorsTintList());
        } else {
            C0662c.m4041c(this, null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8553g;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.MaterialRadioButton, i10, i11, new int[0]);
        int i12 = R$styleable.MaterialRadioButton_buttonTint;
        if (typedArrayM10770h.hasValue(i12)) {
            C0662c.m4041c(this, C9649c.m60265a(context2, typedArrayM10770h, i12));
        }
        this.f8556f = typedArrayM10770h.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayM10770h.recycle();
    }
}
