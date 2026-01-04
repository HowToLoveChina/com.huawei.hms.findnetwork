package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import java.util.List;

/* loaded from: classes6.dex */
public class HiCloudSysParamMap {
    public static final int ASSET_REFUND_STATUS_DEFAULT = 2;
    public static final int CLOUD_PHOTO_ASSET_REFUND_PERIOD_DEFAULT = 7;
    public static final int CLOUD_PHOTO_THUMB_FIX_DEFAULT = 5000;
    public static final int WEAK_NETWORK_RSSI_THRESHOLD_DEFAULT = -75;
    public static final int WEAK_NETWORK_RSSI_THRESHOLD_MAX_CHECK = -60;
    private int UBACacheSum;
    private long UBACacheTime;
    private int UBARepFlag;
    private int UBARepMaxNum;
    private long UBARepOutdatetime;
    private long UBARepPeriod;
    private String aTRequestSuppressionPolicy;
    private String agAdItemUrls;
    private int agReportSwitch;
    private int appRecomendStatus;
    private String assetRefundStatus;
    private String autoIdentifyInvitationCode;

    @SerializedName("BackupCheckQuicKit")
    private String backupCheckQuicKit;

    @SerializedName("backupHomepageNotificationCard")
    private String backupHomepageNotificationCard;
    private int businessSupportDeduct;
    private String cloudAlbumClientResourcesConfig;
    private int cloudBackupIncompleteInterval;
    private int cloudPhotoAssetRefundPeriod;
    private String cloudPhotoFileRetryErrorCode;
    private int cloudPhotoThumbFixMaxSize;
    private int cloudSpaceBannerV2Limit;
    private String cloudSyncFileRetryErrorCode;
    private String compatibleFeatures;
    private String cpuOffloadSleepDuration;
    private String customerHelpURL;
    private String dataExpiresDownloadPage;

    @SerializedName("destopPopupPolicy")
    private String destopPopupPolicy;
    private String enableQuicDomainList;
    private int enableVoucher;
    private String entryTrustConfigList;

    @SerializedName("extendDataRetentionDeeplink")
    private String extendDataUri;
    private String fileManAdvId;
    private String findDeviceCountryCode;
    private String findWebViewSetting;

    @SerializedName("firstTimeOverview")
    private String firstTimeOverview;
    private String galleryFrequencyList;
    private int galleryReportFrequency;

    @SerializedName("gradeMemberPrivilege")
    private String gradeMemberPrivilege;

    @SerializedName("grayScaleUserLabels")
    private List<String> grayScaleUserTags;
    private String hmsVerBlockList;
    private int homePageCardRefreshTime;
    private int homepageBannerNum;

    @SerializedName("homepagePackageExpiresCards")
    private String homepagePackageExpiresCards;

    @SerializedName("homepagePackageExpiresCardsEx")
    private String homepagePackageExpiresCardsEx;
    private int iap4Enabled;
    private String iapPayTypePolicy;

    @SerializedName("iapUnsubscribeRetention")
    private String iapUnsubscribeRetention;
    private int isReturnKeySHA256;
    private int locateInterval;
    private String mapPreUrl;
    private String mobileHwJpgCompressSo;
    private String msgCentryMenu;

    @SerializedName("newBusinessModelConfig")
    private String newBusinessModelConfig;
    private int newDeviceGiftMainPop;
    private String notepadAppInfos;
    private String noticeSuppressEndTimeList;
    private String noticeSuppressStartTimeList;
    private int notifyRestrain;

    @SerializedName("npsDisplayPolicy")
    private String npsDisplayPolicy;
    private String overSizePictures;
    private String padOfflineMarkerUrl;
    private String padOnlineMarkerUrl;
    private long pendantPeriod;
    private int phoneCentralRandomMin;
    private String phoneCentralTime;
    private String phoneOfflineMarkerUrl;
    private String phoneOnlineMarkerUrl;
    private int photoPickerAmountLimit;
    private int photoPickerImageSizeLimit;
    private int photoPickerVideoDurationLimit;
    private int photoPickerVideoSizeLimit;
    private String pictureCompressConfig;
    private String privacyStatementPath;

    @SerializedName("pushPublicKeys")
    private String pushPublicKeys;
    private String pushUrlHostAllowList;
    private String releaseSpaceMuteBeginTime;
    private String releaseSpaceMuteEndTime;
    private int releaseSpaceNoticeFrequency;
    private int releaseSpaceNoticeLimit;
    private float releaseSpaceSize;
    private String scenarioConditionsForGallerySpaceFull;
    private String snsSuppressEndTimeList;
    private String snsSuppressStartTimeList;

    @SerializedName("SpaceExperienceGiftPackagePackageId")
    private String spaceExperienceGiftPackagePackageId;

    @SerializedName("SpaceExperienceGiftPackageSubscribePage")
    private String spaceExperienceGiftPackageSubscribePage;

    @SerializedName("SpaceExperienceGiftPackageSuccessPage")
    private String spaceExperienceGiftPackageSuccessPage;

    @SerializedName("storageLimitStatusThreshold")
    private String storageLimitStatusThreshold;
    private String syncAssetRefundIds;
    private String syncFailRetryPolicy;
    private String syncFlowControlRetryPolicy;
    private String syncSuppressionPolicy;
    private long taskActivityValidity;
    private long taskTimeValidity;
    private int toolEcologyFlag;
    private String ubaConcernedKeyList;
    private String viewHowToExportData;
    private String webViewUrlHostAllowList;
    private int findNetworkPKCheckInterval = 24;
    private int resourceScanTaskCreateInterval = 30;
    private int isSupportIap4 = -1;
    private int businessShowCardEntry = 0;
    private int aboutResopnseCacheTime = 5;
    private int getUserDeviceInfoInterval = 24;
    private int isCloudPhotoPowerControl = 0;
    private int isOnlinePlayAvaliable = 0;
    private int enableHwIdSuggest = 1;
    private int spaceUsageRatioOf2TPackage = 99;
    private int enhanceAtAuthentication = 0;
    private int albumClientPreloadCount = 2000;
    private int albumClientClearInterval = 7;
    private int downloadOMConfigFileAcceptEncoding = 0;
    public int configFileFlowControlInteval = 30;
    private int spaceCleanExpireTime = 30;
    private int spaceCleanRedRemindSpace = 50;
    private int spaceCleanRedRemindPeriod = 7;
    private int spaceCleanRemoveDeviceNoBackTime = 3;
    private long spaceCleanDiskBigFileThreshold = 52428800;
    private int spaceCleanBigFileMaxNum = 200;
    private long spaceCleanDupFileThreshold = 2097152;
    private int spaceCleanDupFileMaxNum = 200;
    private String versionRangeSupportCloseBackup = "";
    private int syncAssetRefundPeriod = 7;
    private int defaultSNLength = 8;
    private int enableWeakNetworkControl = 0;
    private int weakNetworkRssiThreshold = -75;
    private int enableForcedDownloadThumbnail = 0;
    private int cloudPhotoFileRetryInterval = 24;
    private long spaceReminderFailInterval = -1;
    private int spaceReminderFailTimes = -1;
    private int nearLinkMinIgnoreBleTime = 10;
    private int nearLinkWakeUpDuration = ErrorCode.ERROR_REWARD_AD_NO;
    private int nearLinkMaxDistance = 500;
    private int cloudSyncFileRetryInterval = 24;
    private int cloudSyncFileRetryCount = 10;
    private int albumSmartChargeLevel = -1;
    private Integer lastBackupOverMonth = 3;

    @SerializedName("pkgPriceCacheTime")
    private int pkgPriceCacheTime = -1;
    private int spaceCleanPopupSwitch = 1;

    public String getATRequestSuppressionPolicy() {
        return this.aTRequestSuppressionPolicy;
    }

    public int getAboutResopnseCacheTime() {
        return this.aboutResopnseCacheTime;
    }

    public int getAcceptEncodingType() {
        return this.downloadOMConfigFileAcceptEncoding;
    }

    public String getAgAdItemUrls() {
        return this.agAdItemUrls;
    }

    public int getAgReportSwitch() {
        return this.agReportSwitch;
    }

    public int getAlbumClientClearInterval() {
        return this.albumClientClearInterval;
    }

    public int getAlbumClientPreloadCount() {
        return this.albumClientPreloadCount;
    }

    public int getAlbumSmartChargeLevel() {
        return this.albumSmartChargeLevel;
    }

    public int getAppRecomendStatus() {
        return this.appRecomendStatus;
    }

    public String getAssetRefundStatus() {
        return this.assetRefundStatus;
    }

    public String getAutoIdentifyInvitationCode() {
        return this.autoIdentifyInvitationCode;
    }

    public String getBackupCheckQuicKit() {
        return this.backupCheckQuicKit;
    }

    public String getBackupHomepageNotificationCard() {
        return this.backupHomepageNotificationCard;
    }

    public int getBusinessShowCardEntry() {
        return this.businessShowCardEntry;
    }

    public int getBusinessSupportDeduct() {
        return this.businessSupportDeduct;
    }

    public String getCloudAlbumClientResourcesConfig() {
        return this.cloudAlbumClientResourcesConfig;
    }

    public int getCloudBackupIncompleteInterval() {
        return this.cloudBackupIncompleteInterval;
    }

    public int getCloudPhotoAssetRefundPeriod() {
        if (this.cloudPhotoAssetRefundPeriod <= 0) {
            this.cloudPhotoAssetRefundPeriod = 7;
        }
        return this.cloudPhotoAssetRefundPeriod;
    }

    public String getCloudPhotoFileRetryErrorCode() {
        return this.cloudPhotoFileRetryErrorCode;
    }

    public int getCloudPhotoFileRetryInterval() {
        return this.cloudPhotoFileRetryInterval;
    }

    public int getCloudPhotoThumbFixMaxSize() {
        if (this.cloudPhotoThumbFixMaxSize <= 0) {
            this.cloudPhotoThumbFixMaxSize = 5000;
        }
        return this.cloudPhotoThumbFixMaxSize;
    }

    public int getCloudSpaceBannerV2Limit() {
        return this.cloudSpaceBannerV2Limit;
    }

    public int getCloudSyncFileRetryCount() {
        return this.cloudSyncFileRetryCount;
    }

    public String getCloudSyncFileRetryErrorCode() {
        return this.cloudSyncFileRetryErrorCode;
    }

    public int getCloudSyncFileRetryInterval() {
        return this.cloudSyncFileRetryInterval;
    }

    public String getCompatibleFeatures() {
        return this.compatibleFeatures;
    }

    public String getCpuOffloadSleepDuration() {
        return this.cpuOffloadSleepDuration;
    }

    public String getCustomerHelpURL() {
        return this.customerHelpURL;
    }

    public String getDataExpiresDownloadPage() {
        return this.dataExpiresDownloadPage;
    }

    public int getDefaultSNLength() {
        return this.defaultSNLength;
    }

    public String getDestopPopupPolicy() {
        return this.destopPopupPolicy;
    }

    public int getDownloadOMConfigFileFlowControl() {
        return this.configFileFlowControlInteval;
    }

    public int getEnableForcedDownloadThumbnail() {
        return this.enableForcedDownloadThumbnail;
    }

    public int getEnableHwIdSuggest() {
        return this.enableHwIdSuggest;
    }

    public String getEnableQuicDomainList() {
        return this.enableQuicDomainList;
    }

    public int getEnableVoucher() {
        return this.enableVoucher;
    }

    public int getEnableWeakNetworkControl() {
        return this.enableWeakNetworkControl;
    }

    public int getEnhanceAtAuthentication() {
        return this.enhanceAtAuthentication;
    }

    public String getEntryTrustConfigList() {
        return this.entryTrustConfigList;
    }

    public String getExtendDataUri() {
        return this.extendDataUri;
    }

    public String getFileManAdvId() {
        return this.fileManAdvId;
    }

    public String getFindDeviceCountryCode() {
        return this.findDeviceCountryCode;
    }

    public int getFindNetworkPKCheckInterval() {
        return this.findNetworkPKCheckInterval;
    }

    public String getFindWebViewSetting() {
        return this.findWebViewSetting;
    }

    public String getFirstTimeOverview() {
        return this.firstTimeOverview;
    }

    public String getGalleryFrequencyList() {
        return this.galleryFrequencyList;
    }

    public int getGalleryReportFrequency() {
        return this.galleryReportFrequency;
    }

    public String getGradeMemberPrivilege() {
        return this.gradeMemberPrivilege;
    }

    public List<String> getGrayScaleUserTags() {
        return this.grayScaleUserTags;
    }

    public String getHmsVerBlockList() {
        return this.hmsVerBlockList;
    }

    public int getHomePageCardRefreshTime() {
        return this.homePageCardRefreshTime;
    }

    public int getHomepageBannerNum() {
        return this.homepageBannerNum;
    }

    public String getHomepagePackageExpiresCards() {
        return this.homepagePackageExpiresCards;
    }

    public String getHomepagePackageExpiresCardsEx() {
        return this.homepagePackageExpiresCardsEx;
    }

    public int getIap4Enabled() {
        return this.iap4Enabled;
    }

    public String getIapPayTypePolicy() {
        return this.iapPayTypePolicy;
    }

    public String getIapUnsubscribeRetention() {
        return this.iapUnsubscribeRetention;
    }

    public boolean getIsReturnKeySHA256() {
        return this.isReturnKeySHA256 != 0;
    }

    public int getIsSupportIap4() {
        return this.isSupportIap4;
    }

    public Integer getLastBackupOverMonth() {
        return this.lastBackupOverMonth;
    }

    public int getLocateInterval() {
        return this.locateInterval;
    }

    public String getMapPreUrl() {
        return this.mapPreUrl;
    }

    public String getMobileHwJpgCompressSo() {
        return this.mobileHwJpgCompressSo;
    }

    public String getMsgCentryMenu() {
        return this.msgCentryMenu;
    }

    public int getNearLinkMaxDistance() {
        return this.nearLinkMaxDistance;
    }

    public int getNearLinkMinIgnoreBleTime() {
        return this.nearLinkMinIgnoreBleTime;
    }

    public int getNearLinkWakeUpDuration() {
        return this.nearLinkWakeUpDuration;
    }

    public String getNewBusinessModelConfig() {
        return this.newBusinessModelConfig;
    }

    public int getNewDeviceGiftMainPop() {
        return this.newDeviceGiftMainPop;
    }

    public String getNotepadAppInfos() {
        return this.notepadAppInfos;
    }

    public String getNoticeSuppressEndTimeList() {
        return this.noticeSuppressEndTimeList;
    }

    public String getNoticeSuppressStartTimeList() {
        return this.noticeSuppressStartTimeList;
    }

    public int getNotifyRestrain() {
        return this.notifyRestrain;
    }

    public String getNpsDisplayPolicy() {
        return this.npsDisplayPolicy;
    }

    public String getOverSizePictures() {
        return this.overSizePictures;
    }

    public String getPadOfflineMarkerUrl() {
        return this.padOfflineMarkerUrl;
    }

    public String getPadOnlineMarkerUrl() {
        return this.padOnlineMarkerUrl;
    }

    public long getPendantPeriod() {
        return this.pendantPeriod;
    }

    public int getPhoneCentralRandomMin() {
        return this.phoneCentralRandomMin;
    }

    public String getPhoneCentralTime() {
        return this.phoneCentralTime;
    }

    public String getPhoneOfflineMarkerUrl() {
        return this.phoneOfflineMarkerUrl;
    }

    public String getPhoneOnlineMarkerUrl() {
        return this.phoneOnlineMarkerUrl;
    }

    public int getPhotoPickerAmountLimit() {
        return this.photoPickerAmountLimit;
    }

    public int getPhotoPickerImageSizeLimit() {
        return this.photoPickerImageSizeLimit;
    }

    public int getPhotoPickerVideoDurationLimit() {
        return this.photoPickerVideoDurationLimit;
    }

    public int getPhotoPickerVideoSizeLimit() {
        return this.photoPickerVideoSizeLimit;
    }

    public String getPictureCompressConfig() {
        return this.pictureCompressConfig;
    }

    public int getPkgPriceCacheTime() {
        return this.pkgPriceCacheTime;
    }

    public String getPrivacyStatementPath() {
        return this.privacyStatementPath;
    }

    public String getPushPublicKeys() {
        return this.pushPublicKeys;
    }

    public String getPushUrlHostAllowList() {
        return this.pushUrlHostAllowList;
    }

    public String getReleaseSpaceMuteBeginTime() {
        return this.releaseSpaceMuteBeginTime;
    }

    public String getReleaseSpaceMuteEndTime() {
        return this.releaseSpaceMuteEndTime;
    }

    public int getReleaseSpaceNoticeFrequency() {
        return this.releaseSpaceNoticeFrequency;
    }

    public int getReleaseSpaceNoticeLimit() {
        return this.releaseSpaceNoticeLimit;
    }

    public float getReleaseSpaceSize() {
        return this.releaseSpaceSize;
    }

    public int getResourceScanTaskCreateInterval() {
        return this.resourceScanTaskCreateInterval;
    }

    public String getScenarioConditionsForGallerySpaceFull() {
        return this.scenarioConditionsForGallerySpaceFull;
    }

    public String getSnsSuppressEndTimeList() {
        return this.snsSuppressEndTimeList;
    }

    public String getSnsSuppressStartTimeList() {
        return this.snsSuppressStartTimeList;
    }

    public int getSpaceCleanBigFileMaxNum() {
        return this.spaceCleanBigFileMaxNum;
    }

    public long getSpaceCleanDiskBigFileThreshold() {
        return this.spaceCleanDiskBigFileThreshold;
    }

    public int getSpaceCleanDupFileMaxNum() {
        return this.spaceCleanDupFileMaxNum;
    }

    public long getSpaceCleanDupFileThreshold() {
        return this.spaceCleanDupFileThreshold;
    }

    public int getSpaceCleanExpireTime() {
        return this.spaceCleanExpireTime;
    }

    public int getSpaceCleanPopupSwitch() {
        return this.spaceCleanPopupSwitch;
    }

    public int getSpaceCleanRedRemindPeriod() {
        return this.spaceCleanRedRemindPeriod;
    }

    public int getSpaceCleanRedRemindSpace() {
        return this.spaceCleanRedRemindSpace;
    }

    public int getSpaceCleanRemoveDeviceNoBackTime() {
        return this.spaceCleanRemoveDeviceNoBackTime;
    }

    public String getSpaceExperienceGiftPackagePackageId() {
        return this.spaceExperienceGiftPackagePackageId;
    }

    public String getSpaceExperienceGiftPackageSubscribePage() {
        return this.spaceExperienceGiftPackageSubscribePage;
    }

    public String getSpaceExperienceGiftPackageSuccessPage() {
        return this.spaceExperienceGiftPackageSuccessPage;
    }

    public long getSpaceReminderFailInterval() {
        return this.spaceReminderFailInterval;
    }

    public int getSpaceReminderFailTimes() {
        return this.spaceReminderFailTimes;
    }

    public int getSpaceUsageRatioOf2TPackage() {
        return this.spaceUsageRatioOf2TPackage;
    }

    public String getStorageLimitStatusThreshold() {
        return this.storageLimitStatusThreshold;
    }

    public String getSyncAssetRefundIds() {
        return this.syncAssetRefundIds;
    }

    public int getSyncAssetRefundPeriod() {
        return this.syncAssetRefundPeriod;
    }

    public String getSyncFailRetryPolicy() {
        return this.syncFailRetryPolicy;
    }

    public String getSyncFlowControlRetryPolicy() {
        return this.syncFlowControlRetryPolicy;
    }

    public String getSyncSuppressionPolicy() {
        return this.syncSuppressionPolicy;
    }

    public long getTaskActivityValidity() {
        return this.taskActivityValidity;
    }

    public long getTaskTimeValidity() {
        return this.taskTimeValidity;
    }

    public int getToolEcologyFlag() {
        return this.toolEcologyFlag;
    }

    public int getUBACacheSum() {
        return this.UBACacheSum;
    }

    public long getUBACacheTime() {
        return this.UBACacheTime;
    }

    public boolean getUBARepFlag() {
        return this.UBARepFlag != 0;
    }

    public int getUBARepMaxNum() {
        return this.UBARepMaxNum;
    }

    public long getUBARepOutdatetime() {
        return this.UBARepOutdatetime;
    }

    public long getUBARepPeriod() {
        return this.UBARepPeriod;
    }

    public String getUbaConcernedKeyList() {
        return this.ubaConcernedKeyList;
    }

    public int getUserDeviceInfoInterval() {
        return this.getUserDeviceInfoInterval;
    }

    public String getVersionRangeSupportCloseBackup() {
        return this.versionRangeSupportCloseBackup;
    }

    public String getViewHowToExportData() {
        return this.viewHowToExportData;
    }

    public int getWeakNetworkRssiThreshold() {
        return this.weakNetworkRssiThreshold;
    }

    public String getWebViewUrlHostAllowList() {
        return this.webViewUrlHostAllowList;
    }

    public int isCloudPhotoPowerControl() {
        return this.isCloudPhotoPowerControl;
    }

    public boolean isOMUseDefaultFlowControl() {
        return this.configFileFlowControlInteval != 30;
    }

    public boolean isOMUseDefaultGzip() {
        return this.downloadOMConfigFileAcceptEncoding != 1;
    }

    public boolean isOnlinePlayAvaliable() {
        return this.isOnlinePlayAvaliable == 0;
    }

    public void setATRequestSuppressionPolicy(String str) {
        this.aTRequestSuppressionPolicy = str;
    }

    public void setAboutResopnseCacheTime(int i10) {
        this.aboutResopnseCacheTime = i10;
    }

    public void setAcceptEncodingType(int i10) {
        this.downloadOMConfigFileAcceptEncoding = i10;
    }

    public void setAgAdItemUrls(String str) {
        this.agAdItemUrls = str;
    }

    public void setAgReportSwitch(int i10) {
        this.agReportSwitch = i10;
    }

    public void setAlbumClientClearInterval(int i10) {
        this.albumClientClearInterval = i10;
    }

    public void setAlbumClientPreloadCount(int i10) {
        this.albumClientPreloadCount = i10;
    }

    public void setAlbumSmartChargeLevel(int i10) {
        this.albumSmartChargeLevel = i10;
    }

    public void setAppRecomendStatus(int i10) {
        this.appRecomendStatus = i10;
    }

    public void setAssetRefundStatus(String str) {
        this.assetRefundStatus = str;
    }

    public void setAutoIdentifyInvitationCode(String str) {
        this.autoIdentifyInvitationCode = str;
    }

    public void setBackupHomepageNotificationCard(String str) {
        this.backupHomepageNotificationCard = str;
    }

    public void setBusinessShowCardEntry(int i10) {
        this.businessShowCardEntry = i10;
    }

    public void setBusinessSupportDeduct(int i10) {
        this.businessSupportDeduct = i10;
    }

    public void setCloudAlbumClientResourcesConfig(String str) {
        this.cloudAlbumClientResourcesConfig = str;
    }

    public void setCloudBackupIncompleteInterval(int i10) {
        this.cloudBackupIncompleteInterval = i10;
    }

    public void setCloudPhotoFileRetryErrorCode(String str) {
        this.cloudPhotoFileRetryErrorCode = str;
    }

    public void setCloudPhotoFileRetryInterval(int i10) {
        this.cloudPhotoFileRetryInterval = i10;
    }

    public void setCloudPhotoPowerControl(int i10) {
        this.isCloudPhotoPowerControl = i10;
    }

    public void setCloudSpaceBannerV2Limit(int i10) {
        this.cloudSpaceBannerV2Limit = i10;
    }

    public void setCloudSyncFileRetryCount(int i10) {
        this.cloudSyncFileRetryCount = i10;
    }

    public void setCloudSyncFileRetryErrorCode(String str) {
        this.cloudSyncFileRetryErrorCode = str;
    }

    public void setCloudSyncFileRetryInterval(int i10) {
        this.cloudSyncFileRetryInterval = i10;
    }

    public void setCompatibleFeatures(String str) {
        this.compatibleFeatures = str;
    }

    public void setCpuOffloadSleepDuration(String str) {
        this.cpuOffloadSleepDuration = str;
    }

    public void setCustomerHelpURL(String str) {
        this.customerHelpURL = str;
    }

    public void setDataExpiresDownloadPage(String str) {
        this.dataExpiresDownloadPage = str;
    }

    public void setDestopPopupPolicy(String str) {
        this.destopPopupPolicy = str;
    }

    public void setEnableForcedDownloadThumbnail(int i10) {
        this.enableForcedDownloadThumbnail = i10;
    }

    public void setEnableHwIdSuggest(int i10) {
        this.enableHwIdSuggest = i10;
    }

    public void setEnableQuicDomainList(String str) {
        this.enableQuicDomainList = str;
    }

    public void setEnableVoucher(int i10) {
        this.enableVoucher = i10;
    }

    public void setEnableWeakNetworkControl(int i10) {
        this.enableWeakNetworkControl = i10;
    }

    public void setEnhanceAtAuthentication(int i10) {
        this.enhanceAtAuthentication = i10;
    }

    public void setEntryTrustConfigList(String str) {
        this.entryTrustConfigList = str;
    }

    public void setExtendDataUri(String str) {
        this.extendDataUri = str;
    }

    public void setFileManAdvId(String str) {
        this.fileManAdvId = str;
    }

    public void setFindDeviceCountryCode(String str) {
        this.findDeviceCountryCode = str;
    }

    public void setFindNetworkPKCheckInterval(int i10) {
        this.findNetworkPKCheckInterval = i10;
    }

    public void setFindWebViewSetting(String str) {
        this.findWebViewSetting = str;
    }

    public void setFirstTimeOverview(String str) {
        this.firstTimeOverview = str;
    }

    public void setGalleryFrequencyList(String str) {
        this.galleryFrequencyList = str;
    }

    public void setGalleryReportFrequency(int i10) {
        this.galleryReportFrequency = i10;
    }

    public void setGradeMemberPrivilege(String str) {
        this.gradeMemberPrivilege = str;
    }

    public void setGrayScaleUserTags(List<String> list) {
        this.grayScaleUserTags = list;
    }

    public void setHmsVerBlockList(String str) {
        this.hmsVerBlockList = str;
    }

    public void setHomePageCardRefreshTime(int i10) {
        this.homePageCardRefreshTime = i10;
    }

    public void setHomepageBannerNum(int i10) {
        this.homepageBannerNum = i10;
    }

    public void setHomepagePackageExpiresCards(String str) {
        this.homepagePackageExpiresCards = str;
    }

    public void setHomepagePackageExpiresCardsEx(String str) {
        this.homepagePackageExpiresCardsEx = str;
    }

    public void setIap4Enabled(int i10) {
        this.iap4Enabled = i10;
    }

    public void setIapPayTypePolicy(String str) {
        this.iapPayTypePolicy = str;
    }

    public void setIapUnsubscribeRetention(String str) {
        this.iapUnsubscribeRetention = str;
    }

    public void setIsReturnKeySHA256(int i10) {
        this.isReturnKeySHA256 = i10;
    }

    public void setIsSupportIap4(int i10) {
        this.isSupportIap4 = i10;
    }

    public void setLastBackupOverMonth(Integer num) {
        this.lastBackupOverMonth = num;
    }

    public void setLocateInterval(int i10) {
        this.locateInterval = i10;
    }

    public void setMapPreUrl(String str) {
        this.mapPreUrl = str;
    }

    public void setMobileHwJpgCompressSo(String str) {
        this.mobileHwJpgCompressSo = str;
    }

    public void setMsgCentryMenu(String str) {
        this.msgCentryMenu = str;
    }

    public void setNearLinkMaxDistance(int i10) {
        this.nearLinkMaxDistance = i10;
    }

    public void setNearLinkMinIgnoreBleTime(int i10) {
        this.nearLinkMinIgnoreBleTime = i10;
    }

    public void setNearLinkWakeUpDuration(int i10) {
        this.nearLinkWakeUpDuration = i10;
    }

    public void setNewBusinessModelConfig(String str) {
        this.newBusinessModelConfig = str;
    }

    public void setNewDeviceGiftMainPop(int i10) {
        this.newDeviceGiftMainPop = i10;
    }

    public void setNotepadAppInfos(String str) {
        this.notepadAppInfos = str;
    }

    public void setNoticeSuppressEndTimeList(String str) {
        this.noticeSuppressEndTimeList = str;
    }

    public void setNoticeSuppressStartTimeList(String str) {
        this.noticeSuppressStartTimeList = str;
    }

    public void setNotifyRestrain(int i10) {
        this.notifyRestrain = i10;
    }

    public void setNpsDisplayPolicy(String str) {
        this.npsDisplayPolicy = str;
    }

    public void setOnlinePlayAvaliable(int i10) {
        this.isOnlinePlayAvaliable = i10;
    }

    public void setOverSizePictures(String str) {
        this.overSizePictures = str;
    }

    public void setPadOfflineMarkerUrl(String str) {
        this.padOfflineMarkerUrl = str;
    }

    public void setPadOnlineMarkerUrl(String str) {
        this.padOnlineMarkerUrl = str;
    }

    public void setPendantPeriod(long j10) {
        this.pendantPeriod = j10;
    }

    public void setPhoneCentralRandomMin(int i10) {
        this.phoneCentralRandomMin = i10;
    }

    public void setPhoneCentralTime(String str) {
        this.phoneCentralTime = str;
    }

    public void setPhoneOfflineMarkerUrl(String str) {
        this.phoneOfflineMarkerUrl = str;
    }

    public void setPhoneOnlineMarkerUrl(String str) {
        this.phoneOnlineMarkerUrl = str;
    }

    public void setPhotoPickerAmountLimit(int i10) {
        this.photoPickerAmountLimit = i10;
    }

    public void setPhotoPickerImageSizeLimit(int i10) {
        this.photoPickerImageSizeLimit = i10;
    }

    public void setPhotoPickerVideoDurationLimit(int i10) {
        this.photoPickerVideoDurationLimit = i10;
    }

    public void setPhotoPickerVideoSizeLimit(int i10) {
        this.photoPickerVideoSizeLimit = i10;
    }

    public void setPictureCompressConfig(String str) {
        this.pictureCompressConfig = str;
    }

    public void setPkgPriceCacheTime(int i10) {
        this.pkgPriceCacheTime = i10;
    }

    public void setPrivacyStatementPath(String str) {
        this.privacyStatementPath = str;
    }

    public void setPushPublicKeys(String str) {
        this.pushPublicKeys = str;
    }

    public void setPushUrlHostAllowList(String str) {
        this.pushUrlHostAllowList = str;
    }

    public void setReleaseSpaceMuteBeginTime(String str) {
        this.releaseSpaceMuteBeginTime = str;
    }

    public void setReleaseSpaceMuteEndTime(String str) {
        this.releaseSpaceMuteEndTime = str;
    }

    public void setReleaseSpaceNoticeFrequency(int i10) {
        this.releaseSpaceNoticeFrequency = i10;
    }

    public void setReleaseSpaceNoticeLimit(int i10) {
        this.releaseSpaceNoticeLimit = i10;
    }

    public void setReleaseSpaceSize(float f10) {
        this.releaseSpaceSize = f10;
    }

    public void setResourceScanTaskCreateInterval(int i10) {
        this.resourceScanTaskCreateInterval = i10;
    }

    public void setScenarioConditionsForGallerySpaceFull(String str) {
        this.scenarioConditionsForGallerySpaceFull = str;
    }

    public void setSnsSuppressEndTimeList(String str) {
        this.snsSuppressEndTimeList = str;
    }

    public void setSnsSuppressStartTimeList(String str) {
        this.snsSuppressStartTimeList = str;
    }

    public void setSpaceCleanBigFileMaxNum(int i10) {
        this.spaceCleanBigFileMaxNum = i10;
    }

    public void setSpaceCleanDiskBigFileThreshold(long j10) {
        this.spaceCleanDiskBigFileThreshold = j10;
    }

    public void setSpaceCleanDupFileMaxNum(int i10) {
        this.spaceCleanDupFileMaxNum = i10;
    }

    public void setSpaceCleanDupFileThreshold(long j10) {
        this.spaceCleanDupFileThreshold = j10;
    }

    public void setSpaceCleanExpireTime(int i10) {
        this.spaceCleanExpireTime = i10;
    }

    public void setSpaceCleanPopupSwitch(int i10) {
        this.spaceCleanPopupSwitch = i10;
    }

    public void setSpaceCleanRedRemindPeriod(int i10) {
        this.spaceCleanRedRemindPeriod = i10;
    }

    public void setSpaceCleanRedRemindSpace(int i10) {
        this.spaceCleanRedRemindSpace = i10;
    }

    public void setSpaceCleanRemoveDeviceNoBackTime(int i10) {
        this.spaceCleanRemoveDeviceNoBackTime = i10;
    }

    public void setSpaceExperienceGiftPackagePackageId(String str) {
        this.spaceExperienceGiftPackagePackageId = str;
    }

    public void setSpaceExperienceGiftPackageSubscribePage(String str) {
        this.spaceExperienceGiftPackageSubscribePage = str;
    }

    public void setSpaceExperienceGiftPackageSuccessPage(String str) {
        this.spaceExperienceGiftPackageSuccessPage = str;
    }

    public void setSpaceReminderFailInterval(long j10) {
        this.spaceReminderFailInterval = j10;
    }

    public void setSpaceReminderFailTimes(int i10) {
        this.spaceReminderFailTimes = i10;
    }

    public void setSpaceUsageRatioOf2TPackage(int i10) {
        this.spaceUsageRatioOf2TPackage = i10;
    }

    public void setStorageLimitStatusThreshold(String str) {
        this.storageLimitStatusThreshold = str;
    }

    public void setSyncAssetRefundIds(String str) {
        this.syncAssetRefundIds = str;
    }

    public void setSyncAssetRefundPeriod(int i10) {
        this.syncAssetRefundPeriod = i10;
    }

    public void setSyncFailRetryPolicy(String str) {
        this.syncFailRetryPolicy = str;
    }

    public void setSyncFlowControlRetryPolicy(String str) {
        this.syncFlowControlRetryPolicy = str;
    }

    public void setSyncSuppressionPolicy(String str) {
        this.syncSuppressionPolicy = str;
    }

    public void setTaskActivityValidity(long j10) {
        this.taskActivityValidity = j10;
    }

    public void setTaskTimeValidity(long j10) {
        this.taskTimeValidity = j10;
    }

    public void setToolEcologyFlag(int i10) {
        this.toolEcologyFlag = i10;
    }

    public void setUBACacheSum(int i10) {
        this.UBACacheSum = i10;
    }

    public void setUBACacheTime(long j10) {
        this.UBACacheTime = j10;
    }

    public void setUBARepFlag(int i10) {
        this.UBARepFlag = i10;
    }

    public void setUBARepMaxNum(int i10) {
        this.UBARepMaxNum = i10;
    }

    public void setUBARepOutdatetime(long j10) {
        this.UBARepOutdatetime = j10;
    }

    public void setUBARepPeriod(long j10) {
        this.UBARepPeriod = j10;
    }

    public void setUbaConcernedKeyList(String str) {
        this.ubaConcernedKeyList = str;
    }

    public void setUserDeviceInfoInterval(int i10) {
        this.getUserDeviceInfoInterval = i10;
    }

    public void setVersionRangeSupportCloseBackup(String str) {
        this.versionRangeSupportCloseBackup = str;
    }

    public void setWeakNetworkRssiThreshold(int i10) {
        this.weakNetworkRssiThreshold = i10;
    }

    public void setWebViewUrlHostAllowList(String str) {
        this.webViewUrlHostAllowList = str;
    }
}
