package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;

/* loaded from: classes2.dex */
public class PPSSplashSwipeView extends C8135k {
    public PPSSplashSwipeView(Context context) {
        super(context);
        m49668a(context);
    }

    /* renamed from: a */
    private void m49668a(Context context) {
        String str;
        AbstractC7185ho.m43820b("PPSSplashSwipeView", "init");
        try {
            View viewInflate = View.inflate(context, C6849R.layout.hiad_layout_splash_swipe, this);
            this.f37923a = viewInflate;
            this.f37924b = (TextView) viewInflate.findViewById(C6849R.id.hiad_swipe_interact_string);
            this.f37925c = (TextView) this.f37923a.findViewById(C6849R.id.hiad_swipe_desc);
            this.f37928f = (ImageView) this.f37923a.findViewById(C6849R.id.hiad_arrow);
            this.f37929g = (ScanningView) this.f37923a.findViewById(C6849R.id.scanning_view);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("PPSSplashSwipeView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("PPSSplashSwipeView", str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.C8135k
    public String getViewTag() {
        return "PPSSplashSwipeView";
    }

    public PPSSplashSwipeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m49668a(context);
    }

    public PPSSplashSwipeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m49668a(context);
    }
}
