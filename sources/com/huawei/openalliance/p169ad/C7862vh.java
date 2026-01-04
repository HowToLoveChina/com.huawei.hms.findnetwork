package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa;

/* renamed from: com.huawei.openalliance.ad.vh */
/* loaded from: classes8.dex */
public class C7862vh implements InterfaceC8107aa {

    /* renamed from: a */
    private final PPSRewardView f36247a;

    public C7862vh(PPSRewardView pPSRewardView) {
        this.f36247a = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: a */
    public void mo38705a() {
        AppDownloadButton appDownloadButton = this.f36247a.getAppDetailView().getAppDownloadButton();
        this.f36247a.m49598c("128");
        if (appDownloadButton != null) {
            appDownloadButton.m48702a(this.f36247a.getWebPopUpView().getClickInfo());
            appDownloadButton.setSource(5);
            appDownloadButton.performClick();
        }
        this.f36247a.m49606o();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: b */
    public void mo38706b() {
        this.f36247a.m49598c("129");
        AppDownloadButton appDownloadButton = this.f36247a.getAppDetailView().getAppDownloadButton();
        if (appDownloadButton != null) {
            appDownloadButton.m48710f();
        }
        this.f36247a.m49606o();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: c */
    public void mo38707c() {
    }
}
