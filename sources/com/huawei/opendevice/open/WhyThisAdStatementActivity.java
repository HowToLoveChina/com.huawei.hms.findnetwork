package com.huawei.opendevice.open;

import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class WhyThisAdStatementActivity extends AbstractActivityC8258a {

    /* renamed from: L */
    public Context f38461L;

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a
    /* renamed from: C */
    public String mo51556C() {
        return "whyThisAdThird";
    }

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a
    /* renamed from: D */
    public int mo51557D() {
        return C6849R.layout.opendevice_web;
    }

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a
    /* renamed from: E */
    public int mo51577E() {
        return !C6982bz.m41148a(getContext()).mo41175d() ? C6849R.string.hiad_choices_whythisad : super.mo51577E();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: a */
    public void mo49761a(String str, String str2, String str3) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49762b() {
    }

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a
    /* renamed from: e */
    public void mo51559e(InterfaceC8260c interfaceC8260c) {
        C8264g.m51618m(this, interfaceC8260c);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    public String getCurrentPageUrl() {
        return null;
    }

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context applicationContext = getApplicationContext();
        this.f38461L = applicationContext;
        boolean zM41152b = C6982bz.m41152b(applicationContext);
        boolean zM47588j = AbstractC7741ao.m47588j(this.f38461L);
        if (zM41152b && zM47588j) {
            AbstractC7741ao.m47564b(this.f38461L, Constants.WHY_THIS_AD_DEFAULT_URL);
            finish();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49763b(String str) {
    }
}
