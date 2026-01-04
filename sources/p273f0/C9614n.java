package p273f0;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: f0.n */
/* loaded from: classes.dex */
public final class C9614n {

    /* renamed from: f0.n$a */
    public static class a {
        /* renamed from: a */
        public static void m60103a(int i10, int i11, int i12, Rect rect, int i13, int i14, Rect rect2, int i15) {
            Gravity.apply(i10, i11, i12, rect, i13, i14, rect2, i15);
        }

        /* renamed from: b */
        public static void m60104b(int i10, int i11, int i12, Rect rect, Rect rect2, int i13) {
            Gravity.apply(i10, i11, i12, rect, rect2, i13);
        }

        /* renamed from: c */
        public static void m60105c(int i10, Rect rect, Rect rect2, int i11) {
            Gravity.applyDisplay(i10, rect, rect2, i11);
        }
    }

    /* renamed from: a */
    public static void m60101a(int i10, int i11, int i12, Rect rect, Rect rect2, int i13) {
        a.m60104b(i10, i11, i12, rect, rect2, i13);
    }

    /* renamed from: b */
    public static int m60102b(int i10, int i11) {
        return Gravity.getAbsoluteGravity(i10, i11);
    }
}
