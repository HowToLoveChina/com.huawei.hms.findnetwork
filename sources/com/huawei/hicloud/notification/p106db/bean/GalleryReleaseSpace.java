package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class GalleryReleaseSpace {

    @SerializedName("ablumSyncConfig")
    private AblumSyncConfig ablumSyncConfig;

    @SerializedName("activityId")
    private String activityId;

    @SerializedName("activityType")
    private String activityType;

    @SerializedName("basicConfig")
    private BasicConfig basicConfig;

    @SerializedName("localClearSpace")
    private String localClearSpace;

    @SerializedName("localPhotoSpace")
    private String localPhotoSpace;

    public AblumSyncConfig getAblumSyncConfig() {
        return this.ablumSyncConfig;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public BasicConfig getBasicConfig() {
        return this.basicConfig;
    }

    public String getLocalClearSpace() {
        return this.localClearSpace;
    }

    public String getLocalPhotoSpace() {
        return this.localPhotoSpace;
    }

    public void setAblumSyncConfig(AblumSyncConfig ablumSyncConfig) {
        this.ablumSyncConfig = ablumSyncConfig;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setBasicConfig(BasicConfig basicConfig) {
        this.basicConfig = basicConfig;
    }

    public void setLocalClearSpace(String str) {
        this.localClearSpace = str;
    }

    public void setLocalPhotoSpace(String str) {
        this.localPhotoSpace = str;
    }
}
