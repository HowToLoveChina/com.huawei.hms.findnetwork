package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SpacePositionMgr {

    @SerializedName("bannerConfigs")
    private BannerSpacePositionConfig[] bannerSpacePositionConfigs;

    public BannerSpacePositionConfig[] getBannerSpacePositionConfigs() {
        return this.bannerSpacePositionConfigs;
    }

    public void setBannerSpacePositionConfigs(BannerSpacePositionConfig[] bannerSpacePositionConfigArr) {
        this.bannerSpacePositionConfigs = bannerSpacePositionConfigArr;
    }
}
