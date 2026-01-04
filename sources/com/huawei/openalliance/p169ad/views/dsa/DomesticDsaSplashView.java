package com.huawei.openalliance.p169ad.views.dsa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class DomesticDsaSplashView extends DomesticDsaView {
    public DomesticDsaSplashView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.dsa.DomesticDsaView, com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: a */
    public void mo50092a(Context context) {
        super.mo50092a(context);
        View view = this.f37756c;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int iM47535a = AbstractC7741ao.m47535a(getContext(), 12.0f);
            layoutParams.setMargins(iM47535a, iM47535a, iM47535a, iM47535a);
            this.f37756c.setLayoutParams(layoutParams);
            this.f37756c.setElevation(AbstractC7741ao.m47535a(getContext(), 5.0f));
        }
    }

    public DomesticDsaSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DomesticDsaSplashView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public DomesticDsaSplashView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
