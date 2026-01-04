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
public class PPSSplashTwistClickView extends C8136l {

    /* renamed from: g */
    private LinearLayout f37145g;

    public PPSSplashTwistClickView(Context context) {
        super(context);
        m49669a(context);
    }

    /* renamed from: a */
    private void m49669a(Context context) {
        String str;
        AbstractC7185ho.m43820b("PPSSplashTwistClickView", "init");
        try {
            View viewInflate = View.inflate(context, C6849R.layout.hiad_layout_splash_twist_click, this);
            this.f37923a = viewInflate;
            this.f37931f = (ImageView) viewInflate.findViewById(C6849R.id.hiad_click_phone_jpg);
            this.f37145g = (LinearLayout) this.f37923a.findViewById(C6849R.id.twist_click_area);
            this.f37924b = (TextView) this.f37923a.findViewById(C6849R.id.hiad_click_twist_string);
            this.f37925c = (TextView) this.f37923a.findViewById(C6849R.id.hiad_click_twist_desc);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("PPSSplashTwistClickView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("PPSSplashTwistClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.f37145g;
    }

    @Override // com.huawei.openalliance.p169ad.views.C8136l
    public String getViewTag() {
        return "PPSSplashTwistClickView";
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m49669a(context);
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m49669a(context);
    }
}
