package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NewBusinessModelConfigBean {

    @SerializedName("dataDownloadPage")
    private String dataDownloadPage;

    @SerializedName("dataRetentionTime")
    private Integer dataRetentionTime = 60;

    @SerializedName("databaseListSla")
    private Integer databaseListSla;

    @SerializedName("deleteLocalAlbumDataFaq")
    private String deleteLocalAlbumDataFaq;

    @SerializedName("galleryDeleteCloudOnlyFaq")
    private String galleryFaqDeleteCloudOnly;

    @SerializedName("galleryDeleteLocalOnlyFaq")
    private String galleryFaqDeleteLocalOnly;

    @SerializedName("syncCardItemsNumber")
    private Integer syncCardItemsNumber;

    @SerializedName("upgradePackageCardLink")
    private String upgradePackageCardLink;

    @SerializedName("userBenefitsPage")
    private String userBenefitsPage;

    public String getDataDownloadPage() {
        return this.dataDownloadPage;
    }

    public Integer getDataRetentionTime() {
        return this.dataRetentionTime;
    }

    public Integer getDatabaseListSla() {
        return this.databaseListSla;
    }

    public String getDeleteLocalAlbumDataFaq() {
        return this.deleteLocalAlbumDataFaq;
    }

    public String getGalleryFaqDeleteCloudOnly() {
        return this.galleryFaqDeleteCloudOnly;
    }

    public String getGalleryFaqDeleteLocalOnly() {
        return this.galleryFaqDeleteLocalOnly;
    }

    public Integer getSyncCardItemsNumber() {
        return this.syncCardItemsNumber;
    }

    public String getUpgradePackageCardLink() {
        return this.upgradePackageCardLink;
    }

    public String getUserBenefitsPage() {
        return this.userBenefitsPage;
    }

    public void setDataDownloadPage(String str) {
        this.dataDownloadPage = str;
    }

    public void setDataRetentionTime(Integer num) {
        this.dataRetentionTime = num;
    }

    public void setDatabaseListSla(Integer num) {
        this.databaseListSla = num;
    }

    public void setDeleteLocalAlbumDataFaq(String str) {
        this.deleteLocalAlbumDataFaq = str;
    }

    public void setGalleryFaqDeleteCloudOnly(String str) {
        this.galleryFaqDeleteCloudOnly = str;
    }

    public void setGalleryFaqDeleteLocalOnly(String str) {
        this.galleryFaqDeleteLocalOnly = str;
    }

    public void setSyncCardItemsNumber(Integer num) {
        this.syncCardItemsNumber = num;
    }

    public void setUpgradePackageCardLink(String str) {
        this.upgradePackageCardLink = str;
    }

    public void setUserBenefitsPage(String str) {
        this.userBenefitsPage = str;
    }
}
