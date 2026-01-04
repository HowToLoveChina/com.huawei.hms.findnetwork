package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p276f3.C9648b;
import p723w.C13503b;
import p760x2.C13689a;

/* loaded from: classes.dex */
public class ElevationOverlayProvider {

    /* renamed from: f */
    public static final int f8065f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a */
    public final boolean f8066a;

    /* renamed from: b */
    public final int f8067b;

    /* renamed from: c */
    public final int f8068c;

    /* renamed from: d */
    public final int f8069d;

    /* renamed from: e */
    public final float f8070e;

    public ElevationOverlayProvider(Context context) {
        this(C9648b.m60261b(context, R$attr.elevationOverlayEnabled, false), C13689a.m82288b(context, R$attr.elevationOverlayColor, 0), C13689a.m82288b(context, R$attr.elevationOverlayAccentColor, 0), C13689a.m82288b(context, R$attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    public float m10408a(float f10) {
        if (this.f8070e <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    /* renamed from: b */
    public int m10409b(int i10, float f10) {
        int i11;
        float fM10408a = m10408a(f10);
        int iAlpha = Color.alpha(i10);
        int iM82294h = C13689a.m82294h(C13503b.m81226j(i10, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), this.f8067b, fM10408a);
        if (fM10408a > 0.0f && (i11 = this.f8068c) != 0) {
            iM82294h = C13689a.m82293g(iM82294h, C13503b.m81226j(i11, f8065f));
        }
        return C13503b.m81226j(iM82294h, iAlpha);
    }

    /* renamed from: c */
    public int m10410c(int i10, float f10) {
        return (this.f8066a && m10413f(i10)) ? m10409b(i10, f10) : i10;
    }

    /* renamed from: d */
    public int m10411d(float f10) {
        return m10410c(this.f8069d, f10);
    }

    /* renamed from: e */
    public boolean m10412e() {
        return this.f8066a;
    }

    /* renamed from: f */
    public final boolean m10413f(int i10) {
        return C13503b.m81226j(i10, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) == this.f8069d;
    }

    public ElevationOverlayProvider(boolean z10, int i10, int i11, int i12, float f10) {
        this.f8066a = z10;
        this.f8067b = i10;
        this.f8068c = i11;
        this.f8069d = i12;
        this.f8070e = f10;
    }
}
