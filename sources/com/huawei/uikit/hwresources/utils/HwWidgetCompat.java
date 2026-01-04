package com.huawei.uikit.hwresources.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes4.dex */
public class HwWidgetCompat {
    public static final float AUXILIARY_FONT_SIZE_LARGE = 3.2f;
    public static final float AUXILIARY_FONT_SIZE_MEDIUM = 2.0f;
    public static final float AUXILIARY_FONT_SIZE_SMALL = 1.75f;

    private HwWidgetCompat() {
    }

    public static Context wrapContext(Context context, int i10, int i11) {
        return context.getTheme().resolveAttribute(i10, new TypedValue(), false) ? context : new ContextThemeWrapper(context, i11);
    }
}
