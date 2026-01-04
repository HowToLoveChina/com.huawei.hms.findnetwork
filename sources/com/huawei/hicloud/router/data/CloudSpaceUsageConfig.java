package com.huawei.hicloud.router.data;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes.dex */
public class CloudSpaceUsageConfig {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CloudSpaceUsageLanguage cloudSpaceUsageLanguage;

    @SerializedName("items")
    private List<CloudSpaceUsageItemColor> itemColorList;

    public CloudSpaceUsageLanguage getCloudSpaceUsageLanguage() {
        return this.cloudSpaceUsageLanguage;
    }

    public List<CloudSpaceUsageItemColor> getItemColorList() {
        return this.itemColorList;
    }

    public void setCloudSpaceUsageLanguage(CloudSpaceUsageLanguage cloudSpaceUsageLanguage) {
        this.cloudSpaceUsageLanguage = cloudSpaceUsageLanguage;
    }

    public void setItemColorList(List<CloudSpaceUsageItemColor> list) {
        this.itemColorList = list;
    }
}
