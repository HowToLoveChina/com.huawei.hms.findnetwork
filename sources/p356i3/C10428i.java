package p356i3;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.C1788s;

/* renamed from: i3.i */
/* loaded from: classes.dex */
public class C10428i {
    /* renamed from: a */
    public static C10423d m64039a(int i10) {
        return i10 != 0 ? i10 != 1 ? m64040b() : new C10424e() : new C10431l();
    }

    /* renamed from: b */
    public static C10423d m64040b() {
        return new C10431l();
    }

    /* renamed from: c */
    public static C10425f m64041c() {
        return new C10425f();
    }

    /* renamed from: d */
    public static void m64042d(View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof C10427h) {
            ((C10427h) background).m64001a0(f10);
        }
    }

    /* renamed from: e */
    public static void m64043e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof C10427h) {
            m64044f(view, (C10427h) background);
        }
    }

    /* renamed from: f */
    public static void m64044f(View view, C10427h c10427h) {
        if (c10427h.m63994S()) {
            c10427h.m64007f0(C1788s.m10787h(view));
        }
    }
}
