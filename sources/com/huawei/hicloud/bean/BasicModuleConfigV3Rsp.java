package com.huawei.hicloud.bean;

import com.google.gson.Gson;
import com.huawei.hicloud.base.bean.QueryDevConfAgreementRsp;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class BasicModuleConfigV3Rsp extends BasicBaseResp implements Serializable {
    public static final int COUNTRY_SITE_CHANGED = 5;
    public static final int COUNTRY_SITE_OFFLINE = 6;
    public static final int FORCE_UPGRADE_SERVER_CODE = 9;
    public static final int JSON_FORMAT_ERROR = 4;
    public static final int MATCH_SUCCESS = 0;
    public static final int NO_COUNTRY_CODE = 2;
    public static final int NO_COUNTRY_CODE_MATCH = 3;
    public static final int TERM_NO_SIGN = 8;
    public static final int TERM_SERVER_ERROR = 7;
    private static final long serialVersionUID = 1;
    private boolean addressBookDefaultToggle;
    private int allowStatus;
    private boolean backupEnable;
    private boolean blockedDownEnable;
    private boolean blockedUpEnable;
    private boolean browserDefaultToggle;
    private boolean browserEnable;
    private boolean calendarDefaultToggle;
    private boolean calendarEnable;
    private boolean callLogDownEnable;
    private boolean callLogUpEnable;
    private boolean cloudBackupDefaultToggle;
    private boolean cloudPhotoDefaultToggle;
    private int cloudbackupV2Status;
    private boolean cloudphotoManager;
    private boolean cloudphotoShare;
    private boolean contactEnable;
    private int dataState;
    private int dataSyncV2Status;
    private int dataType;
    private DriveConfig driveConfig;
    private boolean dsStartSticky;
    private String emailAddress;
    private boolean familyShareEnable;
    private int forceGradeErrorCode;
    private int forcedUpdate;
    private boolean galleryEnable;
    private boolean guideSwitch;
    private boolean inRedList;
    private boolean isDbankEnable;
    private boolean isGetToggleFromServer = false;
    private boolean keyParamHeader;
    private QueryDevConfAgreementRsp mQueryDevConfAgreementRsp;
    private SyncConfig mSyncConfig;
    private int matchResult;
    private boolean newUser;
    private boolean notepadDefaultToggle;
    private boolean notesEnable;
    private boolean phoneFinderEnable;
    private boolean recordingDownEnable;
    private boolean recordingUpEnable;
    private boolean smsDownEnable;
    private boolean smsUpEnable;
    private boolean storageManageEnable;
    private HashMap<String, Boolean> syncDynamicFuncFieldMap;
    private HashMap<String, Boolean> syncDynamicToggleFieldMap;
    private int upgradeType;
    private String userStatus;
    private boolean wlanDefaultToggle;
    private boolean wlanEnable;

    public int getAllowStatus() {
        return this.allowStatus;
    }

    public int getCloudbackupV2Status() {
        return this.cloudbackupV2Status;
    }

    public int getDataState() {
        return this.dataState;
    }

    public int getDataSyncV2Status() {
        return this.dataSyncV2Status;
    }

    public int getDataType() {
        return this.dataType;
    }

    public DriveConfig getDriveConfig() {
        return this.driveConfig;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public int getForceGradeErrorCode() {
        return this.forceGradeErrorCode;
    }

    public int getForcedUpdate() {
        return this.forcedUpdate;
    }

    public int getMatchResult() {
        return this.matchResult;
    }

    public QueryDevConfAgreementRsp getQueryDevConfAgreementRsp() {
        return this.mQueryDevConfAgreementRsp;
    }

    public SyncConfig getSyncConfig() {
        return this.mSyncConfig;
    }

    public HashMap<String, Boolean> getSyncDynamicFuncFieldMap() {
        return this.syncDynamicFuncFieldMap;
    }

    public HashMap<String, Boolean> getSyncDynamicToggleFieldMap() {
        return this.syncDynamicToggleFieldMap;
    }

    public int getUpgradeType() {
        return this.upgradeType;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public boolean isAddressBookDefaultToggle() {
        return this.addressBookDefaultToggle;
    }

    public boolean isBackupEnable() {
        return this.backupEnable;
    }

    public boolean isBlockedDownEnable() {
        return this.blockedDownEnable;
    }

    public boolean isBlockedUpEnable() {
        return this.blockedUpEnable;
    }

    public boolean isBrowserDefaultToggle() {
        return this.browserDefaultToggle;
    }

    public boolean isBrowserEnable() {
        return this.browserEnable;
    }

    public boolean isCalendarDefaultToggle() {
        return this.calendarDefaultToggle;
    }

    public boolean isCalendarEnable() {
        return this.calendarEnable;
    }

    public boolean isCallLogDownEnable() {
        return this.callLogDownEnable;
    }

    public boolean isCallLogUpEnable() {
        return this.callLogUpEnable;
    }

    public boolean isCloudBackupDefaultToggle() {
        return this.cloudBackupDefaultToggle;
    }

    public boolean isCloudPhotoDefaultToggle() {
        return this.cloudPhotoDefaultToggle;
    }

    public boolean isCloudphotoManager() {
        return this.cloudphotoManager;
    }

    public boolean isCloudphotoShare() {
        return this.cloudphotoShare;
    }

    public boolean isContactEnable() {
        return this.contactEnable;
    }

    public boolean isDbankEnable() {
        return this.isDbankEnable;
    }

    public boolean isDsStartSticky() {
        return this.dsStartSticky;
    }

    public boolean isFamilyShareEnable() {
        return this.familyShareEnable;
    }

    public boolean isGalleryEnable() {
        return this.galleryEnable;
    }

    public boolean isGetToggleFromServer() {
        return this.isGetToggleFromServer;
    }

    public boolean isGuideSwitch() {
        return this.guideSwitch;
    }

    public boolean isInRedList() {
        return this.inRedList;
    }

    public boolean isKeyParamHeader() {
        return this.keyParamHeader;
    }

    public boolean isNewUser() {
        return this.newUser;
    }

    public boolean isNotepadDefaultToggle() {
        return this.notepadDefaultToggle;
    }

    public boolean isNotesEnable() {
        return this.notesEnable;
    }

    public boolean isPhoneFinderEnable() {
        return this.phoneFinderEnable;
    }

    public boolean isRecordingDownEnable() {
        return this.recordingDownEnable;
    }

    public boolean isRecordingUpEnable() {
        return this.recordingUpEnable;
    }

    public boolean isSmsDownEnable() {
        return this.smsDownEnable;
    }

    public boolean isSmsUpEnable() {
        return this.smsUpEnable;
    }

    public boolean isStorageManageEnable() {
        return this.storageManageEnable;
    }

    public boolean isWlanDefaultToggle() {
        return this.wlanDefaultToggle;
    }

    public boolean isWlanEnable() {
        return this.wlanEnable;
    }

    public void setAddressBookDefaultToggle(boolean z10) {
        this.addressBookDefaultToggle = z10;
    }

    public void setAllowStatus(int i10) {
        this.allowStatus = i10;
    }

    public void setBackupEnable(boolean z10) {
        this.backupEnable = z10;
    }

    public void setBlockedDownEnable(boolean z10) {
        this.blockedDownEnable = z10;
    }

    public void setBlockedUpEnable(boolean z10) {
        this.blockedUpEnable = z10;
    }

    public void setBrowserDefaultToggle(boolean z10) {
        this.browserDefaultToggle = z10;
    }

    public void setBrowserEnable(boolean z10) {
        this.browserEnable = z10;
    }

    public void setCalendarDefaultToggle(boolean z10) {
        this.calendarDefaultToggle = z10;
    }

    public void setCalendarEnable(boolean z10) {
        this.calendarEnable = z10;
    }

    public void setCallLogDownEnable(boolean z10) {
        this.callLogDownEnable = z10;
    }

    public void setCallLogUpEnable(boolean z10) {
        this.callLogUpEnable = z10;
    }

    public void setCloudBackupDefaultToggle(boolean z10) {
        this.cloudBackupDefaultToggle = z10;
    }

    public void setCloudPhotoDefaultToggle(boolean z10) {
        this.cloudPhotoDefaultToggle = z10;
    }

    public void setCloudbackupV2Status(int i10) {
        this.cloudbackupV2Status = i10;
    }

    public void setCloudphotoManager(boolean z10) {
        this.cloudphotoManager = z10;
    }

    public void setCloudphotoShare(boolean z10) {
        this.cloudphotoShare = z10;
    }

    public void setContactEnable(boolean z10) {
        this.contactEnable = z10;
    }

    public void setDataState(int i10) {
        this.dataState = i10;
    }

    public void setDataSyncV2Status(int i10) {
        this.dataSyncV2Status = i10;
    }

    public void setDataType(int i10) {
        this.dataType = i10;
    }

    public void setDbankEnable(boolean z10) {
        this.isDbankEnable = z10;
    }

    public void setDriveConfig(DriveConfig driveConfig) {
        this.driveConfig = driveConfig;
    }

    public void setDsStartSticky(boolean z10) {
        this.dsStartSticky = z10;
    }

    public void setEmailAddress(String str) {
        this.emailAddress = str;
    }

    public void setFamilyShareEnable(boolean z10) {
        this.familyShareEnable = z10;
    }

    public void setForceGradeErrorCode(int i10) {
        this.forceGradeErrorCode = i10;
    }

    public void setForcedUpdate(int i10) {
        this.forcedUpdate = i10;
    }

    public void setGalleryEnable(boolean z10) {
        this.galleryEnable = z10;
    }

    public void setGetToggleFromServer(boolean z10) {
        this.isGetToggleFromServer = z10;
    }

    public void setGuideSwitch(boolean z10) {
        this.guideSwitch = z10;
    }

    public void setInRedList(boolean z10) {
        this.inRedList = z10;
    }

    public void setKeyParamHeader(boolean z10) {
        this.keyParamHeader = z10;
    }

    public void setMatchResult(int i10) {
        this.matchResult = i10;
    }

    public void setNewUser(boolean z10) {
        this.newUser = z10;
    }

    public void setNotepadDefaultToggle(boolean z10) {
        this.notepadDefaultToggle = z10;
    }

    public void setNotesEnable(boolean z10) {
        this.notesEnable = z10;
    }

    public void setPhoneFinderEnable(boolean z10) {
        this.phoneFinderEnable = z10;
    }

    public void setQueryDevConfAgreementRsp(QueryDevConfAgreementRsp queryDevConfAgreementRsp) {
        this.mQueryDevConfAgreementRsp = queryDevConfAgreementRsp;
    }

    public void setRecordingDownEnable(boolean z10) {
        this.recordingDownEnable = z10;
    }

    public void setRecordingUpEnable(boolean z10) {
        this.recordingUpEnable = z10;
    }

    public void setSmsDownEnable(boolean z10) {
        this.smsDownEnable = z10;
    }

    public void setSmsUpEnable(boolean z10) {
        this.smsUpEnable = z10;
    }

    public void setStorageManageEnable(boolean z10) {
        this.storageManageEnable = z10;
    }

    public void setSyncConfig(SyncConfig syncConfig) {
        this.mSyncConfig = syncConfig;
    }

    public void setSyncDynamicFuncFieldMap(HashMap<String, Boolean> map) {
        this.syncDynamicFuncFieldMap = map;
    }

    public void setSyncDynamicToggleFieldMap(HashMap<String, Boolean> map) {
        this.syncDynamicToggleFieldMap = map;
    }

    public void setUpgradeType(int i10) {
        this.upgradeType = i10;
    }

    public void setUserStatus(String str) {
        this.userStatus = str;
    }

    public void setWlanDefaultToggle(boolean z10) {
        this.wlanDefaultToggle = z10;
    }

    public void setWlanEnable(boolean z10) {
        this.wlanEnable = z10;
    }

    @Override // com.huawei.hicloud.bean.BasicBaseResp
    public String toString() {
        return new Gson().toJson(this);
    }
}
