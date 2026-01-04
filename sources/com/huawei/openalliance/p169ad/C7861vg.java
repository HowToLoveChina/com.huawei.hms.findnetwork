package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.DialogClickType;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa;

/* renamed from: com.huawei.openalliance.ad.vg */
/* loaded from: classes8.dex */
public class C7861vg implements InterfaceC8107aa {

    /* renamed from: a */
    private final boolean f36245a;

    /* renamed from: b */
    private final PPSRewardView f36246b;

    public C7861vg(PPSRewardView pPSRewardView, boolean z10) {
        this.f36245a = z10;
        this.f36246b = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: a */
    public void mo38705a() {
        AppDownloadButton appDownloadButton = this.f36246b.getAppDetailView().getAppDownloadButton();
        if (appDownloadButton != null) {
            appDownloadButton.m48702a(this.f36246b.getPopUpView().getClickInfo());
            appDownloadButton.setNeedShowConfirmDialog(false);
            appDownloadButton.setSource(16);
            appDownloadButton.performClick();
            this.f36246b.mo49482a("128");
        }
        this.f36246b.mo49485a(true, DialogClickType.POP_UP);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: b */
    public void mo38706b() {
        this.f36246b.mo49482a("129");
        this.f36246b.mo49485a(true, "cancel");
        AppDownloadButton appDownloadButton = this.f36246b.getAppDetailView().getAppDownloadButton();
        if (appDownloadButton != null) {
            appDownloadButton.m48710f();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: c */
    public void mo38707c() {
        AbstractC7185ho.m43821b("RewardViewPUCL", "popUpView, non button area clicked, is clickable: %s", Boolean.valueOf(this.f36245a));
        if (this.f36245a) {
            PPSRewardView pPSRewardView = this.f36246b;
            pPSRewardView.m49594a(pPSRewardView.getPopUpView().getClickInfo());
        }
    }
}
