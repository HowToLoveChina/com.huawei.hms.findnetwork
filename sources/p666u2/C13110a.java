package p666u2;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import p562q0.C12268a;
import p562q0.C12269b;
import p562q0.C12270c;

/* renamed from: u2.a */
/* loaded from: classes.dex */
public class C13110a {

    /* renamed from: a */
    public static final TimeInterpolator f59597a = new LinearInterpolator();

    /* renamed from: b */
    public static final TimeInterpolator f59598b = new C12269b();

    /* renamed from: c */
    public static final TimeInterpolator f59599c = new C12268a();

    /* renamed from: d */
    public static final TimeInterpolator f59600d = new C12270c();

    /* renamed from: e */
    public static final TimeInterpolator f59601e = new DecelerateInterpolator();

    /* renamed from: a */
    public static float m78884a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    /* renamed from: b */
    public static float m78885b(float f10, float f11, float f12, float f13, float f14) {
        return f14 < f12 ? f10 : f14 > f13 ? f11 : m78884a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    /* renamed from: c */
    public static int m78886c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }
}
