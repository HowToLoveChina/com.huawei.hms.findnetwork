package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {

    /* renamed from: a */
    public final EdgeEffect f3453a;

    /* renamed from: androidx.core.widget.EdgeEffectCompat$a */
    public static class C0654a {
        /* renamed from: a */
        public static void m3948a(EdgeEffect edgeEffect, float f10, float f11) {
            edgeEffect.onPull(f10, f11);
        }
    }

    /* renamed from: androidx.core.widget.EdgeEffectCompat$b */
    public static class C0655b {
        /* renamed from: a */
        public static EdgeEffect m3949a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        /* renamed from: b */
        public static float m3950b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        /* renamed from: c */
        public static float m3951c(EdgeEffect edgeEffect, float f10, float f11) {
            try {
                return edgeEffect.onPullDistance(f10, f11);
            } catch (Throwable unused) {
                edgeEffect.onPull(f10, f11);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f3453a = new EdgeEffect(context);
    }

    /* renamed from: a */
    public static EdgeEffect m3944a(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? C0655b.m3949a(context, attributeSet) : new EdgeEffect(context);
    }

    /* renamed from: b */
    public static float m3945b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C0655b.m3950b(edgeEffect);
        }
        return 0.0f;
    }

    /* renamed from: c */
    public static void m3946c(EdgeEffect edgeEffect, float f10, float f11) {
        C0654a.m3948a(edgeEffect, f10, f11);
    }

    /* renamed from: d */
    public static float m3947d(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C0655b.m3951c(edgeEffect, f10, f11);
        }
        m3946c(edgeEffect, f10, f11);
        return f10;
    }
}
