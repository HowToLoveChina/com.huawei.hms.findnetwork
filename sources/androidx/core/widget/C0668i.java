package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: androidx.core.widget.i */
/* loaded from: classes.dex */
public final class C0668i {

    /* renamed from: androidx.core.widget.i$a */
    public static class a {
        /* renamed from: a */
        public static void m4062a(PopupWindow popupWindow, View view, int i10, int i11, int i12) {
            popupWindow.showAsDropDown(view, i10, i11, i12);
        }
    }

    /* renamed from: androidx.core.widget.i$b */
    public static class b {
        /* renamed from: a */
        public static boolean m4063a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        /* renamed from: b */
        public static int m4064b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        /* renamed from: c */
        public static void m4065c(PopupWindow popupWindow, boolean z10) {
            popupWindow.setOverlapAnchor(z10);
        }

        /* renamed from: d */
        public static void m4066d(PopupWindow popupWindow, int i10) {
            popupWindow.setWindowLayoutType(i10);
        }
    }

    /* renamed from: a */
    public static void m4059a(PopupWindow popupWindow, boolean z10) {
        b.m4065c(popupWindow, z10);
    }

    /* renamed from: b */
    public static void m4060b(PopupWindow popupWindow, int i10) {
        b.m4066d(popupWindow, i10);
    }

    /* renamed from: c */
    public static void m4061c(PopupWindow popupWindow, View view, int i10, int i11, int i12) {
        a.m4062a(popupWindow, view, i10, i11, i12);
    }
}
