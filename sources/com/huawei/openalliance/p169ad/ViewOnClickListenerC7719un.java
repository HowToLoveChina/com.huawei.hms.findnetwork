package com.huawei.openalliance.p169ad;

import android.view.View;
import com.huawei.openalliance.p169ad.activity.ComplianceActivity;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.views.PPSRewardView;

/* renamed from: com.huawei.openalliance.ad.un */
/* loaded from: classes8.dex */
public class ViewOnClickListenerC7719un implements View.OnClickListener {

    /* renamed from: a */
    private final IRewardAd f35780a;

    /* renamed from: b */
    private final PPSRewardView f35781b;

    public ViewOnClickListenerC7719un(PPSRewardView pPSRewardView, IRewardAd iRewardAd) {
        this.f35780a = iRewardAd;
        this.f35781b = pPSRewardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IRewardAd iRewardAd = this.f35780a;
        if (iRewardAd == null) {
            AbstractC7185ho.m43823c("RewardChoiceViewOCL", "AdInfo is null or contentData is null");
        } else if (AbstractC7760bg.m47767a(iRewardAd.getCompliance())) {
            AbstractC7807d.m48214a(this.f35781b.getContext(), this.f35780a);
        } else {
            ComplianceActivity.m38595a(this.f35781b.getContext(), view, C7580pn.m46793a((C7305h) this.f35780a), true);
        }
    }
}
