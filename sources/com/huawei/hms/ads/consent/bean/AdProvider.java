package com.huawei.hms.ads.consent.bean;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
/* loaded from: classes8.dex */
public class AdProvider {

    /* renamed from: id */
    private String f23174id = "";
    private String name = "";
    private String serviceArea = "";
    private String privacyPolicyUrl = "";

    @OuterVisible
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdProvider adProvider = (AdProvider) obj;
        return this.f23174id.equals(adProvider.f23174id) && this.name.equals(adProvider.name) && this.serviceArea.equals(adProvider.serviceArea) && this.privacyPolicyUrl.equals(adProvider.privacyPolicyUrl);
    }

    @OuterVisible
    public String getId() {
        return this.f23174id;
    }

    @OuterVisible
    public String getName() {
        return this.name;
    }

    @OuterVisible
    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    @OuterVisible
    public String getServiceArea() {
        return this.serviceArea;
    }

    @OuterVisible
    public int hashCode() {
        return (((((this.f23174id.hashCode() * 31) + this.name.hashCode()) * 31) + this.serviceArea.hashCode()) * 31) + this.privacyPolicyUrl.hashCode();
    }

    @OuterVisible
    public void setId(String str) {
        this.f23174id = str;
    }

    @OuterVisible
    public void setName(String str) {
        this.name = str;
    }

    @OuterVisible
    public void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    @OuterVisible
    public void setServiceArea(String str) {
        this.serviceArea = str;
    }

    @OuterVisible
    public boolean valid() {
        return (TextUtils.isEmpty(this.f23174id) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.privacyPolicyUrl)) ? false : true;
    }

    @OuterVisible
    public boolean validPart() {
        return (TextUtils.isEmpty(this.f23174id) || TextUtils.isEmpty(this.name)) ? false : true;
    }
}
