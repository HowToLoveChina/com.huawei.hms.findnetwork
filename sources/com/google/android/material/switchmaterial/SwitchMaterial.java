package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import p416k3.C10981a;
import p760x2.C13689a;

/* loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: b0 */
    public static final int f8690b0 = R$style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: c0 */
    public static final int[][] f8691c0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: U */
    public final ElevationOverlayProvider f8692U;

    /* renamed from: V */
    public ColorStateList f8693V;

    /* renamed from: W */
    public ColorStateList f8694W;

    /* renamed from: a0 */
    public boolean f8695a0;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() throws Resources.NotFoundException {
        if (this.f8693V == null) {
            int iM82290d = C13689a.m82290d(this, R$attr.colorSurface);
            int iM82290d2 = C13689a.m82290d(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.f8692U.m10412e()) {
                dimension += C1788s.m10787h(this);
            }
            int iM10410c = this.f8692U.m10410c(iM82290d, dimension);
            int[][] iArr = f8691c0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = C13689a.m82294h(iM82290d, iM82290d2, 1.0f);
            iArr2[1] = iM10410c;
            iArr2[2] = C13689a.m82294h(iM82290d, iM82290d2, 0.38f);
            iArr2[3] = iM10410c;
            this.f8693V = new ColorStateList(iArr, iArr2);
        }
        return this.f8693V;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f8694W == null) {
            int[][] iArr = f8691c0;
            int[] iArr2 = new int[iArr.length];
            int iM82290d = C13689a.m82290d(this, R$attr.colorSurface);
            int iM82290d2 = C13689a.m82290d(this, R$attr.colorControlActivated);
            int iM82290d3 = C13689a.m82290d(this, R$attr.colorOnSurface);
            iArr2[0] = C13689a.m82294h(iM82290d, iM82290d2, 0.54f);
            iArr2[1] = C13689a.m82294h(iM82290d, iM82290d3, 0.32f);
            iArr2[2] = C13689a.m82294h(iM82290d, iM82290d2, 0.12f);
            iArr2[3] = C13689a.m82294h(iM82290d, iM82290d3, 0.12f);
            this.f8694W = new ColorStateList(iArr, iArr2);
        }
        return this.f8694W;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8695a0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f8695a0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f8695a0 = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8690b0;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        this.f8692U = new ElevationOverlayProvider(context2);
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.SwitchMaterial, i10, i11, new int[0]);
        this.f8695a0 = typedArrayM10770h.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayM10770h.recycle();
    }
}
