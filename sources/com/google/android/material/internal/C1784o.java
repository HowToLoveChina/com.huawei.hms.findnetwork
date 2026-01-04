package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.C0523e0;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* renamed from: com.google.android.material.internal.o */
/* loaded from: classes.dex */
public final class C1784o {

    /* renamed from: a */
    public static final int[] f8404a = {R$attr.colorPrimary};

    /* renamed from: b */
    public static final int[] f8405b = {R$attr.colorPrimaryVariant};

    /* renamed from: a */
    public static void m10763a(Context context) {
        m10767e(context, f8404a, "Theme.AppCompat");
    }

    /* renamed from: b */
    public static void m10764b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i10, i11);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z10) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R$attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                m10765c(context);
            }
        }
        m10763a(context);
    }

    /* renamed from: c */
    public static void m10765c(Context context) {
        m10767e(context, f8405b, "Theme.MaterialComponents");
    }

    /* renamed from: d */
    public static void m10766d(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        boolean zM10768f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i10, i11);
        if (!typedArrayObtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zM10768f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zM10768f = m10768f(context, attributeSet, iArr, i10, i11, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zM10768f) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    /* renamed from: e */
    public static void m10767e(Context context, int[] iArr, String str) {
        if (m10769g(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    /* renamed from: f */
    public static boolean m10768f(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        for (int i12 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i12, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    /* renamed from: g */
    public static boolean m10769g(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    /* renamed from: h */
    public static TypedArray m10770h(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        m10764b(context, attributeSet, i10, i11);
        m10766d(context, attributeSet, iArr, i10, i11, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
    }

    /* renamed from: i */
    public static C0523e0 m10771i(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        m10764b(context, attributeSet, i10, i11);
        m10766d(context, attributeSet, iArr, i10, i11, iArr2);
        return C0523e0.m2946v(context, attributeSet, iArr, i10, i11);
    }
}
