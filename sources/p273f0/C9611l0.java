package p273f0;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* renamed from: f0.l0 */
/* loaded from: classes.dex */
public final class C9611l0 {

    /* renamed from: f0.l0$a */
    public static class a {
        /* renamed from: a */
        public static boolean m60092a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
            return viewParent.onNestedFling(view, f10, f11, z10);
        }

        /* renamed from: b */
        public static boolean m60093b(ViewParent viewParent, View view, float f10, float f11) {
            return viewParent.onNestedPreFling(view, f10, f11);
        }

        /* renamed from: c */
        public static void m60094c(ViewParent viewParent, View view, int i10, int i11, int[] iArr) {
            viewParent.onNestedPreScroll(view, i10, i11, iArr);
        }

        /* renamed from: d */
        public static void m60095d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13) {
            viewParent.onNestedScroll(view, i10, i11, i12, i13);
        }

        /* renamed from: e */
        public static void m60096e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.onNestedScrollAccepted(view, view2, i10);
        }

        /* renamed from: f */
        public static boolean m60097f(ViewParent viewParent, View view, View view2, int i10) {
            return viewParent.onStartNestedScroll(view, view2, i10);
        }

        /* renamed from: g */
        public static void m60098g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    /* renamed from: a */
    public static boolean m60085a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
        try {
            return a.m60092a(viewParent, view, f10, f11, z10);
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e10);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m60086b(ViewParent viewParent, View view, float f10, float f11) {
        try {
            return a.m60093b(viewParent, view, f10, f11);
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e10);
            return false;
        }
    }

    /* renamed from: c */
    public static void m60087c(ViewParent viewParent, View view, int i10, int i11, int[] iArr, int i12) {
        if (viewParent instanceof InterfaceC9636y) {
            ((InterfaceC9636y) viewParent).mo2550o(view, i10, i11, iArr, i12);
            return;
        }
        if (i12 == 0) {
            try {
                a.m60094c(viewParent, view, i10, i11, iArr);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e10);
            }
        }
    }

    /* renamed from: d */
    public static void m60088d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (viewParent instanceof InterfaceC9638z) {
            ((InterfaceC9638z) viewParent).mo2545j(view, i10, i11, i12, i13, i14, iArr);
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (viewParent instanceof InterfaceC9636y) {
            ((InterfaceC9636y) viewParent).mo2546k(view, i10, i11, i12, i13, i14);
            return;
        }
        if (i14 == 0) {
            try {
                a.m60095d(viewParent, view, i10, i11, i12, i13);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e10);
            }
        }
    }

    /* renamed from: e */
    public static void m60089e(ViewParent viewParent, View view, View view2, int i10, int i11) {
        if (viewParent instanceof InterfaceC9636y) {
            ((InterfaceC9636y) viewParent).mo2548m(view, view2, i10, i11);
            return;
        }
        if (i11 == 0) {
            try {
                a.m60096e(viewParent, view, view2, i10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e10);
            }
        }
    }

    /* renamed from: f */
    public static boolean m60090f(ViewParent viewParent, View view, View view2, int i10, int i11) {
        if (viewParent instanceof InterfaceC9636y) {
            return ((InterfaceC9636y) viewParent).mo2547l(view, view2, i10, i11);
        }
        if (i11 != 0) {
            return false;
        }
        try {
            return a.m60097f(viewParent, view, view2, i10);
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e10);
            return false;
        }
    }

    /* renamed from: g */
    public static void m60091g(ViewParent viewParent, View view, int i10) {
        if (viewParent instanceof InterfaceC9636y) {
            ((InterfaceC9636y) viewParent).mo2549n(view, i10);
            return;
        }
        if (i10 == 0) {
            try {
                a.m60098g(viewParent, view);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e10);
            }
        }
    }
}
