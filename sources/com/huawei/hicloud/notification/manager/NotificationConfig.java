package com.huawei.hicloud.notification.manager;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.DriveConfig;
import com.huawei.hicloud.bean.SilenceDurationBean;
import com.huawei.hicloud.bean.SyncConfig;
import com.huawei.hicloud.notification.config.CBPushNotificationObject;
import com.huawei.hicloud.notification.config.FullFrequency;
import com.huawei.hicloud.notification.config.StInvalidNotice;
import com.huawei.hicloud.notification.config.SyncLimitConfig;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.ForcedUpgradeNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.HiCloudRiskRule;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.SystemParameter;
import java.util.List;

/* loaded from: classes6.dex */
public class NotificationConfig {

    @SerializedName("cloudphoto_first_sync")
    private SyncLimitConfig cloudphotoFirstSync;
    private String date;

    @SerializedName("driveConfig")
    private DriveConfig driveConfig;
    private FullFrequency frequency;

    @SerializedName("HiCloudPullNewNotice")
    private CBPushNotificationObject hiCloudPullNewNotice;

    @SerializedName("HiCloudRiskControlNotice")
    private HiCloudRiskRule hiCloudRiskRule;

    @SerializedName("NotNeedInit")
    private SpaceNotifyConfig hiCloudSpaceNotice;

    @SerializedName("HiCloudSpaceNoticeV2")
    private ExtraNotifyConfig hiCloudSpaceNoticeV2;

    @SerializedName("HiCloudUpgradeNotice")
    private ForcedUpgradeNotifyConfig hiCloudUpgradeNotice;

    /* renamed from: id */
    private String f22667id;

    @SerializedName("recommended_open_device")
    private List<String> recommendedOpenDevice;

    @SerializedName("unValidDuration")
    private SilenceDurationBean silenceDurationBean;

    @SerializedName("ST_invalid_notice")
    private StInvalidNotice stInvalidNotice;

    @SerializedName("music_backup_device")
    private List<String> supportMusicDeviceType;

    @SerializedName("music_backup_devicelist")
    private List<String> supportMusicDevicelistType;

    @SerializedName("syncConfig")
    private SyncConfig syncConfig;

    @SerializedName("SystemParameter")
    private SystemParameter systemParameter;
    private String version;

    public SyncLimitConfig getCloudphotoFirstSync() {
        return this.cloudphotoFirstSync;
    }

    public String getDate() {
        return this.date;
    }

    public DriveConfig getDriveConfig() {
        return this.driveConfig;
    }

    public FullFrequency getFrequency() {
        return this.frequency;
    }

    public CBPushNotificationObject getHiCloudPullNewNotice() {
        return this.hiCloudPullNewNotice;
    }

    public HiCloudRiskRule getHiCloudRiskRule() {
        return this.hiCloudRiskRule;
    }

    public SpaceNotifyConfig getHiCloudSpaceNotice() {
        return this.hiCloudSpaceNotice;
    }

    public ExtraNotifyConfig getHiCloudSpaceNoticeV2() {
        return this.hiCloudSpaceNoticeV2;
    }

    public ForcedUpgradeNotifyConfig getHiCloudUpgradeNotice() {
        return this.hiCloudUpgradeNotice;
    }

    public String getId() {
        return this.f22667id;
    }

    public List<String> getRecommendedOpenDevice() {
        return this.recommendedOpenDevice;
    }

    public StInvalidNotice getStInvalidNotice() {
        return this.stInvalidNotice;
    }

    public List<String> getSupportMusicDeviceType() {
        return this.supportMusicDeviceType;
    }

    public List<String> getSupportMusicDevicelistType() {
        return this.supportMusicDevicelistType;
    }

    public SyncConfig getSyncConfig() {
        return this.syncConfig;
    }

    public SystemParameter getSystemParameter() {
        return this.systemParameter;
    }

    public SilenceDurationBean getUnValidDuration() {
        return this.silenceDurationBean;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCloudphotoFirstSync(SyncLimitConfig syncLimitConfig) {
        this.cloudphotoFirstSync = syncLimitConfig;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDriveConfig(DriveConfig driveConfig) {
        this.driveConfig = driveConfig;
    }

    public void setFrequency(FullFrequency fullFrequency) {
        this.frequency = fullFrequency;
    }

    public void setHiCloudPullNewNotice(CBPushNotificationObject cBPushNotificationObject) {
        this.hiCloudPullNewNotice = cBPushNotificationObject;
    }

    public void setHiCloudRiskRule(HiCloudRiskRule hiCloudRiskRule) {
        this.hiCloudRiskRule = hiCloudRiskRule;
    }

    public void setHiCloudSpaceNotice(SpaceNotifyConfig spaceNotifyConfig) {
        this.hiCloudSpaceNotice = spaceNotifyConfig;
    }

    public void setHiCloudSpaceNoticeV2(ExtraNotifyConfig extraNotifyConfig) {
        this.hiCloudSpaceNoticeV2 = extraNotifyConfig;
    }

    public void setHiCloudUpgradeNotice(ForcedUpgradeNotifyConfig forcedUpgradeNotifyConfig) {
        this.hiCloudUpgradeNotice = forcedUpgradeNotifyConfig;
    }

    public void setId(String str) {
        this.f22667id = str;
    }

    public void setRecommendedOpenDevice(List<String> list) {
        this.recommendedOpenDevice = list;
    }

    public void setStInvalidNotice(StInvalidNotice stInvalidNotice) {
        this.stInvalidNotice = stInvalidNotice;
    }

    public void setSupportMusicDeviceType(List<String> list) {
        this.supportMusicDeviceType = list;
    }

    public void setSupportMusicDevicelistType(List<String> list) {
        this.supportMusicDevicelistType = list;
    }

    public void setSyncConfig(SyncConfig syncConfig) {
        this.syncConfig = syncConfig;
    }

    public void setSystemParameter(SystemParameter systemParameter) {
        this.systemParameter = systemParameter;
    }

    public void setUnValidDuration(SilenceDurationBean silenceDurationBean) {
        this.silenceDurationBean = silenceDurationBean;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
