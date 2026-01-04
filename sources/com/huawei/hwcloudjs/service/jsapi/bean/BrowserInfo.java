package com.huawei.hwcloudjs.service.jsapi.bean;

import com.huawei.hwcloudjs.support.enables.NoProguard;

@NoProguard
/* loaded from: classes8.dex */
public class BrowserInfo {
    private String browserType;
    private String clientVersion;
    private String clientVersionCode;

    public String getBrowserType() {
        return this.browserType;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public String getClientVersionCode() {
        return this.clientVersionCode;
    }

    public void setBrowserType(String str) {
        this.browserType = str;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setClientVersionCode(String str) {
        this.clientVersionCode = str;
    }
}
