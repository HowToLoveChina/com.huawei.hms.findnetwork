package p322h0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: h0.a */
/* loaded from: classes.dex */
public final class C10076a {

    /* renamed from: h0.a$a */
    public static class a {
        /* renamed from: a */
        public static PathInterpolator m62703a(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        /* renamed from: b */
        public static PathInterpolator m62704b(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        /* renamed from: c */
        public static PathInterpolator m62705c(Path path) {
            return new PathInterpolator(path);
        }
    }

    /* renamed from: a */
    public static Interpolator m62701a(float f10, float f11, float f12, float f13) {
        return a.m62704b(f10, f11, f12, f13);
    }

    /* renamed from: b */
    public static Interpolator m62702b(Path path) {
        return a.m62705c(path);
    }
}
