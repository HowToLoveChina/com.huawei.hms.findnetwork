package sk;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import com.hihonor.android.view.DisplaySideRegionEx;
import com.hihonor.android.view.WindowManagerEx;
import com.huawei.android.view.WindowManagerEx;
import p015ak.C0209d;
import p399jk.AbstractC10896a;

/* renamed from: sk.d */
/* loaded from: classes6.dex */
public class ViewOnApplyWindowInsetsListenerC12807d implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Rect safeInsets;
        int i10;
        Rect safeInsets2;
        int i11;
        AbstractC10896a.m65887i("SideModeOnApplyWindowInsetsListener", "onApplyWindowInsets");
        if (C0209d.m1277l1()) {
            DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
            if (displaySideRegion != null && (safeInsets2 = displaySideRegion.getSafeInsets()) != null && (i11 = safeInsets2.left) > 0) {
                C12808e.m76825d(i11);
            }
        } else {
            com.huawei.android.view.DisplaySideRegionEx displaySideRegion2 = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
            if (displaySideRegion2 != null && (safeInsets = displaySideRegion2.getSafeInsets()) != null && (i10 = safeInsets.left) > 0) {
                C12808e.m76825d(i10);
            }
        }
        return view.onApplyWindowInsets(windowInsets);
    }
}
