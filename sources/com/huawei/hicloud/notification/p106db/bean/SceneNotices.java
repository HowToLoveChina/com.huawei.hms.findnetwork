package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class SceneNotices {

    @SerializedName("clearLocalSpaces")
    private ClearLocalSpace[] clearLocalSpaces;

    @SerializedName("clearOverMonths")
    private ClearOverMonths[] clearOverMonths;

    @SerializedName("cloudBackupClears")
    private CloudBackupClears[] cloudBackupClears;

    @SerializedName("cloudSpaceFull")
    private CommonCard[] cloudSpaceFulls;

    @SerializedName("galleryReleaseSpaces")
    private GalleryReleaseSpace[] galleryReleaseSpaces;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage language;

    @SerializedName("twoHundredGuids")
    private CommonCard[] twoHundredGuids;

    public ClearLocalSpace[] getClearLocalSpaces() {
        return this.clearLocalSpaces;
    }

    public ClearOverMonths[] getClearOverMonths() {
        return this.clearOverMonths;
    }

    public CloudBackupClears[] getCloudBackupClears() {
        return this.cloudBackupClears;
    }

    public CommonCard[] getCloudSpaceFulls() {
        return this.cloudSpaceFulls;
    }

    public GalleryReleaseSpace[] getGalleryReleaseSpaces() {
        return this.galleryReleaseSpaces;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public CommonCard[] getTwoHundredGuids() {
        return this.twoHundredGuids;
    }

    public void setClearLocalSpaces(ClearLocalSpace[] clearLocalSpaceArr) {
        this.clearLocalSpaces = clearLocalSpaceArr;
    }

    public void setClearOverMonths(ClearOverMonths[] clearOverMonthsArr) {
        this.clearOverMonths = clearOverMonthsArr;
    }

    public SceneNotices setCloudBackupClears(CloudBackupClears[] cloudBackupClearsArr) {
        this.cloudBackupClears = cloudBackupClearsArr;
        return this;
    }

    public void setCloudSpaceFulls(CommonCard[] commonCardArr) {
        this.cloudSpaceFulls = commonCardArr;
    }

    public void setGalleryReleaseSpaces(GalleryReleaseSpace[] galleryReleaseSpaceArr) {
        this.galleryReleaseSpaces = galleryReleaseSpaceArr;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }

    public void setTwoHundredGuids(CommonCard[] commonCardArr) {
        this.twoHundredGuids = commonCardArr;
    }
}
