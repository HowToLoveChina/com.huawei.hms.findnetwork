package com.huawei.cloud.pay.model;

import com.huawei.hicloud.notification.constants.HNConstants;

/* loaded from: classes5.dex */
public class UIConfigReq extends Request {
    private String cfgType;
    private String country;
    private String defaultLanguage;
    private String version;

    public UIConfigReq(String str, String str2, String str3) {
        super("getClientUIConfig");
        this.version = str;
        this.country = str2;
        this.cfgType = str3;
        this.defaultLanguage = HNConstants.Language.EN_STANDARD;
    }

    public String getCfgType() {
        return this.cfgType;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCfgType(String str) {
        this.cfgType = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDefaultLanguage(String str) {
        this.defaultLanguage = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
