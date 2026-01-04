package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import p273f0.C9603h0;
import p757x.C13669a;

/* renamed from: com.google.android.material.textfield.f */
/* loaded from: classes.dex */
public class C1867f {
    /* renamed from: a */
    public static void m11325a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = C13669a.m82231l(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                C13669a.m82228i(drawable, colorStateList);
            } else {
                C13669a.m82228i(drawable, ColorStateList.valueOf(colorStateList.getColorForState(m11326b(textInputLayout, checkableImageButton), colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                C13669a.m82229j(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    /* renamed from: b */
    public static int[] m11326b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton) {
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    /* renamed from: c */
    public static void m11327c(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(m11326b(textInputLayout, checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = C13669a.m82231l(drawable).mutate();
        C13669a.m82228i(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    /* renamed from: d */
    public static void m11328d(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zM59859O = C9603h0.m59859O(checkableImageButton);
        boolean z10 = onLongClickListener != null;
        boolean z11 = zM59859O || z10;
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(zM59859O);
        checkableImageButton.setPressable(zM59859O);
        checkableImageButton.setLongClickable(z10);
        C9603h0.m59833A0(checkableImageButton, z11 ? 1 : 2);
    }

    /* renamed from: e */
    public static void m11329e(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        m11328d(checkableImageButton, onLongClickListener);
    }

    /* renamed from: f */
    public static void m11330f(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m11328d(checkableImageButton, onLongClickListener);
    }
}
