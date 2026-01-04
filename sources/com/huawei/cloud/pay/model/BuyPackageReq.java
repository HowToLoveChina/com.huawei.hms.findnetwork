package com.huawei.cloud.pay.model;

import android.os.Build;
import java.util.Map;

/* loaded from: classes5.dex */
public class BuyPackageReq extends Request {
    private Map<String, String> campaignExt;
    private String deviceCode;

    /* renamed from: id */
    private String f21395id;
    private String version;

    public BuyPackageReq(String str, Map<String, String> map) {
        super("createOrder");
        this.f21395id = str;
        this.deviceCode = Build.MODEL;
        this.version = "4.0";
        this.campaignExt = map;
    }

    public Map<String, String> getCampaignExt() {
        return this.campaignExt;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public String getId() {
        return this.f21395id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCampaignExt(Map<String, String> map) {
        this.campaignExt = map;
    }

    public void setDeviceCode(String str) {
        this.deviceCode = str;
    }

    public void setId(String str) {
        this.f21395id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
