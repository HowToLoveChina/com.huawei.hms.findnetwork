package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: androidx.appcompat.widget.s */
/* loaded from: classes.dex */
public class C0544s {

    /* renamed from: a */
    public static final int[] f2412a = {R.attr.state_checked};

    /* renamed from: b */
    public static final int[] f2413b = new int[0];

    /* renamed from: c */
    public static final Rect f2414c = new Rect();

    /* renamed from: androidx.appcompat.widget.s$a */
    public static class a {
        /* renamed from: a */
        public static Insets m3145a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    /* renamed from: a */
    public static boolean m3140a(Drawable drawable) {
        return true;
    }

    /* renamed from: b */
    public static void m3141b(Drawable drawable) {
        String name = drawable.getClass().getName();
        if (Build.VERSION.SDK_INT >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        m3142c(drawable);
    }

    /* renamed from: c */
    public static void m3142c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f2412a);
        } else {
            drawable.setState(f2413b);
        }
        drawable.setState(state);
    }

    /* renamed from: d */
    public static Rect m3143d(Drawable drawable) {
        Insets insetsM3145a = a.m3145a(drawable);
        return new Rect(insetsM3145a.left, insetsM3145a.top, insetsM3145a.right, insetsM3145a.bottom);
    }

    /* renamed from: e */
    public static PorterDuff.Mode m3144e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
