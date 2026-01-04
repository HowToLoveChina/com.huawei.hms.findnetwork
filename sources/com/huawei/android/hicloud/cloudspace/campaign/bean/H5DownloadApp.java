package com.huawei.android.hicloud.cloudspace.campaign.bean;

import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;

/* loaded from: classes2.dex */
public class H5DownloadApp {
    private AdInfo agd;
    private String appSource;
    private INativeAd pps;
    private String questId;

    public AdInfo getAgd() {
        return this.agd;
    }

    public String getAppSource() {
        return this.appSource;
    }

    public INativeAd getPps() {
        return this.pps;
    }

    public String getQuestId() {
        return this.questId;
    }

    public void setAgd(AdInfo adInfo) {
        this.agd = adInfo;
    }

    public void setAppSource(String str) {
        this.appSource = str;
    }

    public void setPps(INativeAd iNativeAd) {
        this.pps = iNativeAd;
    }

    public void setQuestId(String str) {
        this.questId = str;
    }
}
