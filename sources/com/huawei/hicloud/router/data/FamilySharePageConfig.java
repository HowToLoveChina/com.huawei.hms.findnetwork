package com.huawei.hicloud.router.data;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class FamilySharePageConfig {

    @SerializedName("cloud_space_usage")
    private CloudSpaceUsageConfig cloudSpaceUsageConfig;
    private String date;

    @SerializedName("share_family")
    private FamilyShareResource familyShareResource;

    /* renamed from: id */
    private String f22857id;
    private String version;

    public CloudSpaceUsageConfig getCloudSpaceUsageConfig() {
        return this.cloudSpaceUsageConfig;
    }

    public String getDate() {
        return this.date;
    }

    public FamilyShareResource getFamilyShareResource() {
        return this.familyShareResource;
    }

    public String getId() {
        return this.f22857id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCloudSpaceUsageConfig(CloudSpaceUsageConfig cloudSpaceUsageConfig) {
        this.cloudSpaceUsageConfig = cloudSpaceUsageConfig;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setFamilyShareResource(FamilyShareResource familyShareResource) {
        this.familyShareResource = familyShareResource;
    }

    public void setId(String str) {
        this.f22857id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
