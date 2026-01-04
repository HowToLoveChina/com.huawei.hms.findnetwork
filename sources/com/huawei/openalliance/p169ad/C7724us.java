package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.DialogClickType;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.C8150t;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j;

/* renamed from: com.huawei.openalliance.ad.us */
/* loaded from: classes8.dex */
public class C7724us implements InterfaceC8107aa {

    /* renamed from: a */
    private InterfaceC8117j f35790a;

    /* renamed from: b */
    private boolean f35791b;

    public C7724us(InterfaceC8117j interfaceC8117j, boolean z10) {
        this.f35790a = interfaceC8117j;
        this.f35791b = z10;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: a */
    public void mo38705a() {
        AbstractC7185ho.m43820b("RewardTPopListener", "onPopUpClick");
        this.f35790a.mo49492d();
        this.f35790a.mo49485a(true, DialogClickType.POP_UP);
        this.f35790a.mo49482a("128");
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: b */
    public void mo38706b() {
        AbstractC7185ho.m43820b("RewardTPopListener", "onCancelClick");
        this.f35790a.mo49482a("129");
        this.f35790a.mo49485a(true, "cancel");
        AppDownloadButton appDownloadButton = this.f35790a.getAppDownloadButton();
        if (appDownloadButton != null) {
            appDownloadButton.m48710f();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
    /* renamed from: c */
    public void mo38707c() {
        C8150t popUpView;
        AbstractC7185ho.m43821b("RewardTPopListener", "onNonBtnAreaClick, is clickable: %s", Boolean.valueOf(this.f35791b));
        if (this.f35791b && (popUpView = this.f35790a.getPopUpView()) != null) {
            this.f35790a.mo49481a((Integer) 1);
            this.f35790a.mo49486a(21, popUpView.getClickInfo());
            this.f35790a.mo49485a(false, DialogClickType.NO_BUTTON_AREA);
        }
    }
}
