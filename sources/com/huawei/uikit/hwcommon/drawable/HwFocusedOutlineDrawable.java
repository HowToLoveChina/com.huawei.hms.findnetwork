package com.huawei.uikit.hwcommon.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

@TargetApi(26)
/* loaded from: classes7.dex */
public class HwFocusedOutlineDrawable extends HwOutlineDrawable {

    /* renamed from: x */
    private static final String f42068x = "HwFocusedOutlineDrawable";

    /* renamed from: v */
    private View f42069v;

    /* renamed from: w */
    private boolean f42070w;

    public HwFocusedOutlineDrawable(Context context, Drawable drawable, View view, View view2, boolean z10) {
        super(context, drawable, view2, z10);
        this.f42070w = true;
        this.f42069v = view;
    }

    @Override // com.huawei.uikit.hwcommon.drawable.HwOutlineDrawable
    public boolean isDrawOutline() {
        return this.f42070w ? this.f42069v.hasWindowFocus() && this.f42069v.isFocused() : this.f42069v.isFocused();
    }

    public void setWindowFocusSensitive(boolean z10) {
        this.f42070w = z10;
    }
}
