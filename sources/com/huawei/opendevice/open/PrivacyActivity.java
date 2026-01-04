package com.huawei.opendevice.open;

import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.CountryConfig;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class PrivacyActivity extends AbstractActivityC8258a {

    /* renamed from: L */
    public boolean f38450L = false;

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a
    /* renamed from: C */
    public String mo51556C() {
        if (C6982bz.m41148a(this).mo41175d()) {
            return "privacyThirdCN";
        }
        return "privacy" + m51558F(new CountryCodeBean(this).m39390a(), null);
    }

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a
    /* renamed from: D */
    public int mo51557D() {
        return C6849R.layout.opendevice_web;
    }

    /* renamed from: F */
    public final String m51558F(String str, String[] strArr) {
        if (CountryConfig.isDR1(str, strArr)) {
            return "CN";
        }
        if (CountryConfig.isDR2(str, strArr)) {
            return "HK";
        }
        if (CountryConfig.isDR3(str, strArr)) {
            return "EU";
        }
        if (CountryConfig.isDR4(str, strArr)) {
            return "RU";
        }
        AbstractC7185ho.m43823c("PrivacyActivity", "getSiteCode error, countryCode not belong to any site.");
        return "UNKNOWN";
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
        C8264g.m51610e(this, interfaceC8260c);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    public String getCurrentPageUrl() {
        return null;
    }

    @Override // com.huawei.opendevice.open.AbstractActivityC8258a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean zM41152b = C6982bz.m41152b(this);
        this.f38450L = zM41152b;
        AbstractC7185ho.m43821b("PrivacyActivity", "onCreate, isInnerDevice: %s", Boolean.valueOf(zM41152b));
        if (this.f38450L && AbstractC7741ao.m47588j(this)) {
            AbstractC7741ao.m47564b(this, Constants.HMS_PRIVACY);
            finish();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49763b(String str) {
    }
}
