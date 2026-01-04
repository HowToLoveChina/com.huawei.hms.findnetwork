package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;

/* loaded from: classes2.dex */
public class PPSSplashTwistView extends C8136l {
    public PPSSplashTwistView(Context context) {
        super(context);
        m49670a(context);
    }

    /* renamed from: a */
    private void m49670a(Context context) {
        String str;
        AbstractC7185ho.m43820b("PPSSplashTwistView", "init");
        try {
            View viewInflate = View.inflate(context, C6849R.layout.hiad_layout_splash_twist, this);
            this.f37923a = viewInflate;
            this.f37931f = (ImageView) viewInflate.findViewById(C6849R.id.hiad_phone_jpg);
            this.f37924b = (TextView) this.f37923a.findViewById(C6849R.id.hiad_twist_interact_string);
            this.f37925c = (TextView) this.f37923a.findViewById(C6849R.id.hiad_twist_desc);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("PPSSplashTwistView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("PPSSplashTwistView", str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.C8136l
    public String getViewTag() {
        return "PPSSplashTwistView";
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m49670a(context);
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m49670a(context);
    }
}
