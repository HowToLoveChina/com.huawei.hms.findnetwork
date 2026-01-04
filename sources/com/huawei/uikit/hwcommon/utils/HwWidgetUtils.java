package com.huawei.uikit.hwcommon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.huawei.uikit.hwcommon.C8709R;
import com.huawei.uikit.hwcommon.drawable.HwAnimatedGradientDrawable;
import com.huawei.uikit.hwcommon.widget.HwClickEffectEntry;

/* loaded from: classes7.dex */
public class HwWidgetUtils {
    private HwWidgetUtils() {
    }

    public static HwClickEffectEntry getClickEffectEntry(Context context, int i10) {
        return getClickEffectEntry(context, null, i10);
    }

    public static HwAnimatedGradientDrawable getHwAnimatedGradientDrawable(Context context, HwClickEffectEntry hwClickEffectEntry) {
        if (context == null || hwClickEffectEntry == null) {
            return null;
        }
        HwAnimatedGradientDrawable hwAnimatedGradientDrawable = new HwAnimatedGradientDrawable(context);
        hwAnimatedGradientDrawable.setColor(hwClickEffectEntry.getClickEffectColor());
        hwAnimatedGradientDrawable.setMaxRectAlpha(hwClickEffectEntry.getClickEffectAlpha());
        hwAnimatedGradientDrawable.setMinRectScale(hwClickEffectEntry.getClickEffectMinRecScale());
        hwAnimatedGradientDrawable.setMaxRectScale(hwClickEffectEntry.getClickEffectMaxRecScale());
        hwAnimatedGradientDrawable.setForceDoScaleAnim(hwClickEffectEntry.isClickEffectForceDoScaleAnim());
        hwAnimatedGradientDrawable.setCornerRadius(hwClickEffectEntry.getClickEffectCornerRadius());
        return hwAnimatedGradientDrawable;
    }

    public static HwClickEffectEntry getClickEffectEntry(Context context, AttributeSet attributeSet, int i10) {
        HwClickEffectEntry hwClickEffectEntry = new HwClickEffectEntry();
        Resources.Theme theme = context.getTheme();
        if (theme != null) {
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C8709R.styleable.HwClickEffect, i10, C8709R.style.Widget_Emui_HwClickEffectStyle_Light);
            hwClickEffectEntry.setClickEffectColor(typedArrayObtainStyledAttributes.getColor(C8709R.styleable.HwClickEffect_hwClickEffectColor, hwClickEffectEntry.getClickEffectColor()));
            hwClickEffectEntry.setClickEffectAlpha(typedArrayObtainStyledAttributes.getFloat(C8709R.styleable.HwClickEffect_hwClickEffectAlpha, hwClickEffectEntry.getClickEffectAlpha()));
            hwClickEffectEntry.setClickEffectMinRecScale(typedArrayObtainStyledAttributes.getFloat(C8709R.styleable.HwClickEffect_hwClickEffectMinRecScale, hwClickEffectEntry.getClickEffectMinRecScale()));
            hwClickEffectEntry.setClickEffectMaxRecScale(typedArrayObtainStyledAttributes.getFloat(C8709R.styleable.HwClickEffect_hwClickEffectMaxRecScale, hwClickEffectEntry.getClickEffectMaxRecScale()));
            hwClickEffectEntry.setClickEffectCornerRadius(typedArrayObtainStyledAttributes.getDimension(C8709R.styleable.HwClickEffect_hwClickEffectCornerRadius, hwClickEffectEntry.getClickEffectCornerRadius()));
            hwClickEffectEntry.setIsClickEffectForceDoScaleAnim(typedArrayObtainStyledAttributes.getBoolean(C8709R.styleable.HwClickEffect_hwClickEffectForceDoScaleAnim, hwClickEffectEntry.isClickEffectForceDoScaleAnim()));
            typedArrayObtainStyledAttributes.recycle();
        }
        return hwClickEffectEntry;
    }

    public static HwAnimatedGradientDrawable getHwAnimatedGradientDrawable(Context context, int i10) {
        return getHwAnimatedGradientDrawable(context, getClickEffectEntry(context, i10));
    }
}
