package p412k;

import android.graphics.drawable.Drawable;

/* renamed from: k.e */
/* loaded from: classes.dex */
public class C10967e extends Drawable {

    /* renamed from: a */
    public static final double f51952a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a */
    public static float m66196a(float f10, float f11, boolean z10) {
        return z10 ? (float) (f10 + ((1.0d - f51952a) * f11)) : f10;
    }

    /* renamed from: b */
    public static float m66197b(float f10, float f11, boolean z10) {
        return z10 ? (float) ((f10 * 1.5f) + ((1.0d - f51952a) * f11)) : f10 * 1.5f;
    }
}
