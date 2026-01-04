package com.huawei.hms.ads.consent.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentSyncBase {
    protected List<String> adProviderIds;
    protected int consentStatus;

    @OuterVisible
    public ConsentSyncBase() {
    }

    @OuterVisible
    public ConsentSyncBase(List<String> list, int i10) {
        this.adProviderIds = list;
        this.consentStatus = i10;
    }

    @OuterVisible
    public List<String> getAdProviderIds() {
        return this.adProviderIds;
    }

    @OuterVisible
    public int getConsentStatus() {
        return this.consentStatus;
    }

    @OuterVisible
    public void setAdProviderIds(List<String> list) {
        this.adProviderIds = list;
    }

    @OuterVisible
    public void setConsentStatus(int i10) {
        this.consentStatus = i10;
    }
}
