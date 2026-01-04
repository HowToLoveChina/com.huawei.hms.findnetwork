package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.openalliance.p169ad.views.RewardVideoView;

/* renamed from: com.huawei.openalliance.ad.uq */
/* loaded from: classes8.dex */
public class C7722uq {

    /* renamed from: a */
    private InterfaceC7416lz f35788a = new C7405lo();

    /* renamed from: a */
    public void m47413a() {
        this.f35788a.mo45623j();
    }

    /* renamed from: b */
    public void m47415b() {
        this.f35788a.mo45613b();
    }

    /* renamed from: c */
    public void m47416c() {
        InterfaceC7416lz interfaceC7416lz = this.f35788a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45618e();
        }
    }

    /* renamed from: d */
    public void m47417d() {
        this.f35788a.mo45610a(EnumC7480mo.CLICK);
    }

    /* renamed from: a */
    public void m47414a(PPSRewardView pPSRewardView, IRewardAd iRewardAd, RewardVideoView rewardVideoView) {
        ContentRecord contentRecordM46793a = C7580pn.m46793a((C7305h) iRewardAd);
        if (contentRecordM46793a == null || contentRecordM46793a.m41506b(pPSRewardView.getContext()) == null) {
            AbstractC7185ho.m43823c("RewardOmProxy", "there is no reward ad or om is null");
            return;
        }
        AbstractC7185ho.m43820b("RewardOmProxy", "init om");
        this.f35788a.mo45607a(pPSRewardView.getContext(), contentRecordM46793a, pPSRewardView, true);
        this.f35788a.mo45616c();
        m47412a(rewardVideoView, this.f35788a);
    }

    /* renamed from: a */
    private void m47412a(RewardVideoView rewardVideoView, InterfaceC7416lz interfaceC7416lz) {
        if (rewardVideoView != null) {
            rewardVideoView.m49902a(interfaceC7416lz);
        }
    }
}
