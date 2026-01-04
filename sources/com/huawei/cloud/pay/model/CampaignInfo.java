package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class CampaignInfo implements Serializable {
    private static final long serialVersionUID = 4029236158190597354L;
    private String adId;
    private String cId;
    private String cType;
    private String tid;
    private String version;

    public String getAdId() {
        return this.adId;
    }

    public String getTid() {
        return this.tid;
    }

    public String getVersion() {
        return this.version;
    }

    public String getcId() {
        return this.cId;
    }

    public String getcType() {
        return this.cType;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setcId(String str) {
        this.cId = str;
    }

    public void setcType(String str) {
        this.cType = str;
    }
}
