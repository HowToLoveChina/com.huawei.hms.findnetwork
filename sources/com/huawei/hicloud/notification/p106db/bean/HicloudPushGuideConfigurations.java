package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class HicloudPushGuideConfigurations {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private HiCloudPushGuideLanguage language;

    @SerializedName("popConfig")
    private HicloudPushGuidPopConfig popConfig;

    public HiCloudPushGuideLanguage getLanguage() {
        return this.language;
    }

    public HicloudPushGuidPopConfig getPopConfig() {
        return this.popConfig;
    }

    public void setLanguage(HiCloudPushGuideLanguage hiCloudPushGuideLanguage) {
        this.language = hiCloudPushGuideLanguage;
    }

    public void setPopConfig(HicloudPushGuidPopConfig hicloudPushGuidPopConfig) {
        this.popConfig = hicloudPushGuidPopConfig;
    }
}
