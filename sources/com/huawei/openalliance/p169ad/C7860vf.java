package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.StatusChangeMethods;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.views.PPSRewardView;

/* renamed from: com.huawei.openalliance.ad.vf */
/* loaded from: classes8.dex */
public class C7860vf implements InterfaceC7069l {

    /* renamed from: a */
    private final PPSRewardView f36244a;

    public C7860vf(PPSRewardView pPSRewardView) {
        this.f36244a = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: a */
    public void mo42626a(AppDownloadTask appDownloadTask) {
        this.f36244a.m49599d();
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: b */
    public void mo42628b(AppDownloadTask appDownloadTask) {
        AbstractC7185ho.m43820b("RewardViewOSCL", StatusChangeMethods.STATUS_CHANGE);
        if (appDownloadTask != null) {
            EnumC7062e enumC7062eM42077i = appDownloadTask.m42077i();
            AbstractC7185ho.m43820b("RewardViewOSCL", "status:" + enumC7062eM42077i);
            if (EnumC7062e.DOWNLOADING == enumC7062eM42077i) {
                this.f36244a.m49597b("3");
            }
        }
        this.f36244a.m49599d();
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: c */
    public void mo42630c(String str) {
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: a */
    public void mo42627a(String str) {
        this.f36244a.m49599d();
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: b */
    public void mo42629b(String str) {
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7068k
    /* renamed from: a */
    public void mo38799a(String str, int i10) {
    }
}
