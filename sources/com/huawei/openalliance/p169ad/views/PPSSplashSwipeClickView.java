package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;

/* loaded from: classes2.dex */
public class PPSSplashSwipeClickView extends C8135k {

    /* renamed from: h */
    private LinearLayout f37144h;

    public PPSSplashSwipeClickView(Context context) {
        super(context);
        m49667a(context);
    }

    /* renamed from: a */
    private void m49667a(Context context) {
        String str;
        AbstractC7185ho.m43820b("PPSSplashSwipeClickView", "init");
        try {
            View viewInflate = View.inflate(context, C6849R.layout.hiad_layout_splash_swipe_click, this);
            this.f37923a = viewInflate;
            this.f37144h = (LinearLayout) viewInflate.findViewById(C6849R.id.swipe_click_area);
            this.f37928f = (ImageView) this.f37923a.findViewById(C6849R.id.hiad_click_arrow);
            this.f37924b = (TextView) this.f37923a.findViewById(C6849R.id.hiad_click_swipe_string);
            this.f37925c = (TextView) this.f37923a.findViewById(C6849R.id.hiad_click_swipe_desc);
            this.f37929g = (ScanningView) this.f37923a.findViewById(C6849R.id.hiad_scanning_view);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("PPSSplashSwipeClickView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("PPSSplashSwipeClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.f37144h;
    }

    @Override // com.huawei.openalliance.p169ad.views.C8135k
    public String getViewTag() {
        return "PPSSplashSwipeClickView";
    }

    public PPSSplashSwipeClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m49667a(context);
    }

    public PPSSplashSwipeClickView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m49667a(context);
    }
}
