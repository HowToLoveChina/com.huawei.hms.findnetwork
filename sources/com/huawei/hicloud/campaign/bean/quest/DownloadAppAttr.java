package com.huawei.hicloud.campaign.bean.quest;

import java.util.List;

/* loaded from: classes6.dex */
public class DownloadAppAttr {
    private String adSlotId;
    private int adType;
    private List<String> appPackages;
    private String appSource;

    public String getAdSlotId() {
        return this.adSlotId;
    }

    public int getAdType() {
        return this.adType;
    }

    public List<String> getAppPackages() {
        return this.appPackages;
    }

    public String getAppSource() {
        return this.appSource;
    }

    public void setAdSlotId(String str) {
        this.adSlotId = str;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setAppPackages(List<String> list) {
        this.appPackages = list;
    }

    public void setAppSource(String str) {
        this.appSource = str;
    }
}
