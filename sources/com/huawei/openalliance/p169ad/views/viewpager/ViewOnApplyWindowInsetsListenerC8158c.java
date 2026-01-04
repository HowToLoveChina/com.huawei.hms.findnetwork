package com.huawei.openalliance.p169ad.views.viewpager;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;

@SuppressLint({"NewApi"})
/* renamed from: com.huawei.openalliance.ad.views.viewpager.c */
/* loaded from: classes2.dex */
class ViewOnApplyWindowInsetsListenerC8158c implements View.OnApplyWindowInsetsListener {

    /* renamed from: a */
    private final Rect f38193a = new Rect();

    /* renamed from: b */
    private C8160e f38194b;

    public ViewOnApplyWindowInsetsListenerC8158c(C8160e c8160e) {
        this.f38194b = c8160e;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (windowInsetsOnApplyWindowInsets.isConsumed()) {
            return windowInsetsOnApplyWindowInsets;
        }
        Rect rect = this.f38193a;
        rect.left = windowInsetsOnApplyWindowInsets.getSystemWindowInsetLeft();
        rect.top = windowInsetsOnApplyWindowInsets.getSystemWindowInsetTop();
        rect.right = windowInsetsOnApplyWindowInsets.getSystemWindowInsetRight();
        rect.bottom = windowInsetsOnApplyWindowInsets.getSystemWindowInsetBottom();
        int childCount = this.f38194b.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = this.f38194b.getChildAt(i10).dispatchApplyWindowInsets(windowInsetsOnApplyWindowInsets);
            rect.left = Math.min(windowInsetsDispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
            rect.top = Math.min(windowInsetsDispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
            rect.right = Math.min(windowInsetsDispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
            rect.bottom = Math.min(windowInsetsDispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
        }
        return windowInsetsOnApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
    }
}
