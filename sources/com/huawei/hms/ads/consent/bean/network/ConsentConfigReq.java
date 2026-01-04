package com.huawei.hms.ads.consent.bean.network;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentConfigReq {
    private String consentVersion;
    private String countryCode;
    private Integer debugFlag;
    private String langCode;
    private String pkgName;

    @OuterVisible
    public String getConsentVersion() {
        return this.consentVersion;
    }

    @OuterVisible
    public String getCountryCode() {
        return this.countryCode;
    }

    @OuterVisible
    public Integer getDebugFlag() {
        return this.debugFlag;
    }

    @OuterVisible
    public String getLangCode() {
        return this.langCode;
    }

    @OuterVisible
    public String getPkgName() {
        return this.pkgName;
    }

    @OuterVisible
    public void setConsentVersion(String str) {
        this.consentVersion = str;
    }

    @OuterVisible
    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    @OuterVisible
    public void setDebugFlag(Integer num) {
        this.debugFlag = num;
    }

    @OuterVisible
    public void setLangCode(String str) {
        this.langCode = str;
    }

    @OuterVisible
    public void setPkgName(String str) {
        this.pkgName = str;
    }
}
