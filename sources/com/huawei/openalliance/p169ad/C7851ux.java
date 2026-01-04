package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.openalliance.p169ad.views.interfaces.C8109b;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8111d;

/* renamed from: com.huawei.openalliance.ad.ux */
/* loaded from: classes8.dex */
public class C7851ux implements InterfaceC8111d {

    /* renamed from: a */
    private final PPSRewardView f36222a;

    public C7851ux(PPSRewardView pPSRewardView) {
        this.f36222a = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8111d
    /* renamed from: a */
    public void mo48626a(boolean z10, boolean z11, String str, boolean z12) {
        AbstractC7185ho.m43818a("RewardViewECCL", "onCardClick, isAppRelated: %s, isHanlded: %s, destination: %s, isButtonClicked: %s", Boolean.valueOf(z10), Boolean.valueOf(z11), str, Boolean.valueOf(z12));
        C8109b c8109b = new C8109b(z10, true, str, 20);
        if (!z10) {
            this.f36222a.m49596b(new C8109b(false, z11, str, 20));
        } else if ("app".equals(str)) {
            this.f36222a.m49597b("4");
            this.f36222a.m49596b(c8109b);
            if (!z12) {
                this.f36222a.getEndCardView().m50501d();
            }
        } else {
            PPSRewardView pPSRewardView = this.f36222a;
            if (z12) {
                pPSRewardView.m49596b(c8109b);
                this.f36222a.m49597b("3");
            } else {
                pPSRewardView.m49596b(new C8109b(true, false, str, 20));
            }
        }
        this.f36222a.setClickInfo(null);
    }
}
