package com.huawei.uikit.hwviewpager.widget;

import android.view.View;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: classes9.dex */
public class HwPageFlipTransformer implements HwViewPager.PageTransformer {

    /* renamed from: a */
    private HwViewPager f44598a;

    public HwPageFlipTransformer(HwViewPager hwViewPager) {
        this.f44598a = hwViewPager;
        hwViewPager.setAutoRtlLayoutEnabled(true);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.PageTransformer
    public void transformPage(View view, float f10) {
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        if (Float.compare(f10, -1.0f) < 0 || Float.compare(f10, 1.0f) > 0) {
            view.setTranslationX(0.0f);
            return;
        }
        if ((Float.compare(f10, 0.0f) > 0 || !this.f44598a.getReverseDrawingOrder()) && (Float.compare(f10, 0.0f) <= 0 || this.f44598a.getReverseDrawingOrder())) {
            view.setTranslationX(0.0f);
        } else if (this.f44598a.isRtlLayout()) {
            view.setTranslationX(width * f10);
        } else {
            view.setTranslationX(width * (-f10));
        }
    }
}
