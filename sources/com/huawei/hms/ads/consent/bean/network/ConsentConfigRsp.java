package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentConfigRsp {
    private List<AdProvider> companies;
    private int isNeedConsent;
    private int retcode;

    @OuterVisible
    public ConsentConfigRsp(com.huawei.openalliance.p169ad.beans.server.ConsentConfigRsp consentConfigRsp) {
        this.retcode = -1;
        if (consentConfigRsp != null) {
            this.retcode = consentConfigRsp.m40945a();
            this.isNeedConsent = consentConfigRsp.m40946b();
            this.companies = consentConfigRsp.m40947c();
        }
    }

    @OuterVisible
    public List<AdProvider> getCompanies() {
        return this.companies;
    }

    @OuterVisible
    public int getIsNeedConsent() {
        return this.isNeedConsent;
    }

    @OuterVisible
    public int getRetcode() {
        return this.retcode;
    }

    @OuterVisible
    public void setCompanies(List<AdProvider> list) {
        this.companies = list;
    }

    @OuterVisible
    public void setIsNeedConsent(int i10) {
        this.isNeedConsent = i10;
    }

    @OuterVisible
    public void setRetcode(int i10) {
        this.retcode = i10;
    }
}
