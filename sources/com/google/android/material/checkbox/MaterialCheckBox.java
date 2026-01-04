package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.C0662c;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import p276f3.C9649c;
import p416k3.C10981a;
import p757x.C13669a;
import p760x2.C13689a;

/* loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: h */
    public static final int f7742h = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: i */
    public static final int[][] f7743i = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e */
    public ColorStateList f7744e;

    /* renamed from: f */
    public boolean f7745f;

    /* renamed from: g */
    public boolean f7746g;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f7744e == null) {
            int[][] iArr = f7743i;
            int[] iArr2 = new int[iArr.length];
            int iM82290d = C13689a.m82290d(this, R$attr.colorControlActivated);
            int iM82290d2 = C13689a.m82290d(this, R$attr.colorSurface);
            int iM82290d3 = C13689a.m82290d(this, R$attr.colorOnSurface);
            iArr2[0] = C13689a.m82294h(iM82290d2, iM82290d, 1.0f);
            iArr2[1] = C13689a.m82294h(iM82290d2, iM82290d3, 0.54f);
            iArr2[2] = C13689a.m82294h(iM82290d2, iM82290d3, 0.38f);
            iArr2[3] = C13689a.m82294h(iM82290d2, iM82290d3, 0.38f);
            this.f7744e = new ColorStateList(iArr, iArr2);
        }
        return this.f7744e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f7745f && C0662c.m4040b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawableM4039a;
        if (!this.f7746g || !TextUtils.isEmpty(getText()) || (drawableM4039a = C0662c.m4039a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableM4039a.getIntrinsicWidth()) / 2) * (C1788s.m10788i(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableM4039a.getBounds();
            C13669a.m82225f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f7746g = z10;
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f7745f = z10;
        if (z10) {
            C0662c.m4041c(this, getMaterialThemeColorsTintList());
        } else {
            C0662c.m4041c(this, null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7742h;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.MaterialCheckBox, i10, i11, new int[0]);
        int i12 = R$styleable.MaterialCheckBox_buttonTint;
        if (typedArrayM10770h.hasValue(i12)) {
            C0662c.m4041c(this, C9649c.m60265a(context2, typedArrayM10770h, i12));
        }
        this.f7745f = typedArrayM10770h.getBoolean(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f7746g = typedArrayM10770h.getBoolean(R$styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        typedArrayM10770h.recycle();
    }
}
