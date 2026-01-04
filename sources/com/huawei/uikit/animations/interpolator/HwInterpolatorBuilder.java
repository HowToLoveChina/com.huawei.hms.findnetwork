package com.huawei.uikit.animations.interpolator;

import android.view.animation.Interpolator;
import p322h0.C10076a;

/* loaded from: classes6.dex */
public class HwInterpolatorBuilder {

    /* renamed from: a */
    private static final float f41016a = 0.33f;

    /* renamed from: b */
    private static final float f41017b = 0.0f;

    /* renamed from: c */
    private static final float f41018c = 0.67f;

    /* renamed from: d */
    private static final float f41019d = 1.0f;

    /* renamed from: e */
    private static final float f41020e = 0.4f;

    /* renamed from: f */
    private static final float f41021f = 0.0f;

    /* renamed from: g */
    private static final float f41022g = 1.0f;

    /* renamed from: h */
    private static final float f41023h = 1.0f;

    /* renamed from: i */
    private static final float f41024i = 0.4f;

    /* renamed from: j */
    private static final float f41025j = 0.0f;

    /* renamed from: k */
    private static final float f41026k = 0.2f;

    /* renamed from: l */
    private static final float f41027l = 1.0f;

    /* renamed from: m */
    private static final float f41028m = 0.2f;

    /* renamed from: n */
    private static final float f41029n = 0.0f;

    /* renamed from: o */
    private static final float f41030o = 0.2f;

    /* renamed from: p */
    private static final float f41031p = 1.0f;

    /* renamed from: q */
    private static final float f41032q = 0.33f;

    /* renamed from: r */
    private static final float f41033r = 3.0f;

    /* renamed from: s */
    private static final float f41034s = 0.5f;

    /* renamed from: t */
    private static final float f41035t = 1.0f;

    private HwInterpolatorBuilder() {
    }

    public static Interpolator createFastOutLinearInInterpolator() {
        return C10076a.m62701a(0.4f, 0.0f, 1.0f, 1.0f);
    }

    public static Interpolator createFastOutSlowInInterpolator() {
        return C10076a.m62701a(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static Interpolator createFrictionCurveInterpolator() {
        return C10076a.m62701a(0.2f, 0.0f, 0.2f, 1.0f);
    }

    public static Interpolator createOneShotInterpolator() {
        return C10076a.m62701a(0.33f, f41033r, f41034s, 1.0f);
    }

    public static Interpolator createSharpCurveInterpolator() {
        return C10076a.m62701a(0.33f, 0.0f, f41018c, 1.0f);
    }
}
