package com.huawei.android.hicloud.p088ui.extend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.huawei.hicloud.sync.R$style;
import com.huawei.hicloud.sync.R$styleable;
import p015ak.C0209d;

/* loaded from: classes3.dex */
public class AutoStyleButton extends AutoSizeButton {
    public AutoStyleButton(Context context) {
        super(context);
    }

    /* renamed from: e */
    public static boolean m23936e(Context context) {
        if (context instanceof Activity) {
            return context.getClass().isAnnotationPresent(AutoStyleButtonAnnotation.class);
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m23937f(Context context) {
        return C0209d.m1220W0() && m23936e(context);
    }

    /* renamed from: g */
    public static Context m23938g(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoStyleButton_Style, 0, 0);
        boolean zM23937f = m23937f(context);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(zM23937f ? R$styleable.AutoStyleButton_Style_newStyle : R$styleable.AutoStyleButton_Style_defStyle, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId <= 0) {
            resourceId = zM23937f ? R$style.Widget_Emui_HwButton_HiCloud_Emphasize : R$style.Widget_Emui_HwButton_HiCloud;
        }
        Resources.Theme themeNewTheme = context.getResources().newTheme();
        themeNewTheme.applyStyle(resourceId, true);
        return new ContextThemeWrapper(context, themeNewTheme);
    }

    public AutoStyleButton(Context context, AttributeSet attributeSet) {
        super(m23938g(context, attributeSet), attributeSet);
    }

    public AutoStyleButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
