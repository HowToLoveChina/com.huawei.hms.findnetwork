package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class ActivityEntry implements Serializable {
    private static final long serialVersionUID = -6279788643765844623L;
    private String cId;
    private String cType;
    private DlAppCampInfo campaignInfo;
    private String resource;
    private String url;

    public DlAppCampInfo getCampaignInfo() {
        return this.campaignInfo;
    }

    public String getResource() {
        return this.resource;
    }

    public String getUrl() {
        return this.url;
    }

    public String getcId() {
        return this.cId;
    }

    public String getcType() {
        return this.cType;
    }

    public void setCampaignInfo(DlAppCampInfo dlAppCampInfo) {
        this.campaignInfo = dlAppCampInfo;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setcId(String str) {
        this.cId = str;
    }

    public void setcType(String str) {
        this.cType = str;
    }
}
