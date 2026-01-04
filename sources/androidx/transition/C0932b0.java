package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import p273f0.C9603h0;

/* renamed from: androidx.transition.b0 */
/* loaded from: classes.dex */
public class C0932b0 {

    /* renamed from: a */
    public static final C0944h0 f4837a = new C0942g0();

    /* renamed from: b */
    public static final Property<View, Float> f4838b = new a(Float.class, "translationAlpha");

    /* renamed from: c */
    public static final Property<View, Rect> f4839c = new b(Rect.class, "clipBounds");

    /* renamed from: androidx.transition.b0$a */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(C0932b0.m5786c(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Float f10) {
            C0932b0.m5791h(view, f10.floatValue());
        }
    }

    /* renamed from: androidx.transition.b0$b */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return C9603h0.m59909t(view);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Rect rect) {
            C9603h0.m59916w0(view, rect);
        }
    }

    /* renamed from: a */
    public static void m5784a(View view) {
        f4837a.mo5801a(view);
    }

    /* renamed from: b */
    public static InterfaceC0930a0 m5785b(View view) {
        return new C0965z(view);
    }

    /* renamed from: c */
    public static float m5786c(View view) {
        return f4837a.mo5808b(view);
    }

    /* renamed from: d */
    public static InterfaceC0950k0 m5787d(View view) {
        return new C0948j0(view);
    }

    /* renamed from: e */
    public static void m5788e(View view) {
        f4837a.mo5802c(view);
    }

    /* renamed from: f */
    public static void m5789f(View view, Matrix matrix) {
        f4837a.mo5809d(view, matrix);
    }

    /* renamed from: g */
    public static void m5790g(View view, int i10, int i11, int i12, int i13) {
        f4837a.mo5810e(view, i10, i11, i12, i13);
    }

    /* renamed from: h */
    public static void m5791h(View view, float f10) {
        f4837a.mo5811f(view, f10);
    }

    /* renamed from: i */
    public static void m5792i(View view, int i10) {
        f4837a.mo5812g(view, i10);
    }

    /* renamed from: j */
    public static void m5793j(View view, Matrix matrix) {
        f4837a.mo5813h(view, matrix);
    }

    /* renamed from: k */
    public static void m5794k(View view, Matrix matrix) {
        f4837a.mo5814i(view, matrix);
    }
}
