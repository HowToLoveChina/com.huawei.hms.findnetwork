package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import p723w.C13503b;

/* renamed from: androidx.appcompat.widget.a0 */
/* loaded from: classes.dex */
public class C0515a0 {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f2259a = new ThreadLocal<>();

    /* renamed from: b */
    public static final int[] f2260b = {-16842910};

    /* renamed from: c */
    public static final int[] f2261c = {R.attr.state_focused};

    /* renamed from: d */
    public static final int[] f2262d = {R.attr.state_activated};

    /* renamed from: e */
    public static final int[] f2263e = {R.attr.state_pressed};

    /* renamed from: f */
    public static final int[] f2264f = {R.attr.state_checked};

    /* renamed from: g */
    public static final int[] f2265g = {R.attr.state_selected};

    /* renamed from: h */
    public static final int[] f2266h = {-16842919, -16842908};

    /* renamed from: i */
    public static final int[] f2267i = new int[0];

    /* renamed from: j */
    public static final int[] f2268j = new int[1];

    /* renamed from: a */
    public static void m2890a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public static int m2891b(Context context, int i10) {
        ColorStateList colorStateListM2894e = m2894e(context, i10);
        if (colorStateListM2894e != null && colorStateListM2894e.isStateful()) {
            return colorStateListM2894e.getColorForState(f2260b, colorStateListM2894e.getDefaultColor());
        }
        TypedValue typedValueM2895f = m2895f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM2895f, true);
        return m2893d(context, i10, typedValueM2895f.getFloat());
    }

    /* renamed from: c */
    public static int m2892c(Context context, int i10) {
        int[] iArr = f2268j;
        iArr[0] = i10;
        C0523e0 c0523e0M2945u = C0523e0.m2945u(context, null, iArr);
        try {
            return c0523e0M2945u.m2948b(0, 0);
        } finally {
            c0523e0M2945u.m2966w();
        }
    }

    /* renamed from: d */
    public static int m2893d(Context context, int i10, float f10) {
        return C13503b.m81226j(m2892c(context, i10), Math.round(Color.alpha(r0) * f10));
    }

    /* renamed from: e */
    public static ColorStateList m2894e(Context context, int i10) {
        int[] iArr = f2268j;
        iArr[0] = i10;
        C0523e0 c0523e0M2945u = C0523e0.m2945u(context, null, iArr);
        try {
            return c0523e0M2945u.m2949c(0);
        } finally {
            c0523e0M2945u.m2966w();
        }
    }

    /* renamed from: f */
    public static TypedValue m2895f() {
        ThreadLocal<TypedValue> threadLocal = f2259a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
