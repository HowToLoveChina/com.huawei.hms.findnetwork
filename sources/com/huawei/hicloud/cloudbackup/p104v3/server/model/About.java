package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class About extends C11707b {

    @InterfaceC4648p
    private String acceptEncoding;

    @InterfaceC4648p
    private Integer applistStrategy;

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private Integer backupTimes;

    @InterfaceC4648p
    private C11707b bakSourceStrategy;

    @InterfaceC4648p
    private List<String> baseAppid;

    @InterfaceC4648p
    private Integer baseBakNumber;

    @InterfaceC4648p
    private Integer bmType;

    @InterfaceC4648p
    private Integer cloudOperationType;

    @InterfaceC4648p
    private Integer countLeftInInterim;

    @InterfaceC4648p
    private Integer disableInterimReason;

    @InterfaceC4648p
    private Integer divideStrategy;

    @InterfaceC4648p
    private Integer enableAppDuplicator;

    @InterfaceC4648p
    private Long fileIdListMaxLen;

    @InterfaceC4648p
    private C11707b fileSourceStrategy;

    @InterfaceC4648p
    private Integer freeUserInterimMaxTimes;

    @InterfaceC4648p
    private String gradeCode;

    @InterfaceC4648p
    private List<Integer> grayFlowStrategy;

    @InterfaceC4648p
    private Integer interimExpirationDeleteTime;

    @InterfaceC4648p
    private Integer interimExtraRetentionTime;

    @InterfaceC4648p
    private Long lastBackupEndTime;

    @InterfaceC4648p
    private C11707b lockByDelDeviceStrategy;

    @InterfaceC4648p
    private boolean manualBypassOnFault;

    @InterfaceC4648p
    private Long maxAttachmentUploadSize;

    @InterfaceC4648p
    private Integer maxBatchNumber;

    @InterfaceC4648p
    private Integer operationControl;

    @InterfaceC4648p
    private Integer refEffeDays;

    @InterfaceC4648p
    private Integer refEffeDelayDays;

    @InterfaceC4648p
    private Integer refurQuotaExhausted;

    @InterfaceC4648p
    private Long serverTime;

    @InterfaceC4648p
    private Status status;

    @InterfaceC4648p
    private Integer times;

    @InterfaceC4648p
    private C11707b uploadTargetStrategy;

    @InterfaceC4648p
    private User user;

    public String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public Integer getApplistStrategy() {
        return this.applistStrategy;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public Integer getBackupTimes() {
        return this.backupTimes;
    }

    public C11707b getBakSourceStrategy() {
        return this.bakSourceStrategy;
    }

    public List<String> getBaseAppid() {
        return this.baseAppid;
    }

    public Integer getBaseBakNumber() {
        return this.baseBakNumber;
    }

    public Integer getBmType() {
        return this.bmType;
    }

    public Integer getCloudOperationType() {
        return this.cloudOperationType;
    }

    public Integer getCountLeftInInterim() {
        return this.countLeftInInterim;
    }

    public Integer getDisableInterimReason() {
        return this.disableInterimReason;
    }

    public Integer getDivideStrategy() {
        return this.divideStrategy;
    }

    public Integer getEnableAppDuplicator() {
        Integer num = this.enableAppDuplicator;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Long getFileIdListMaxLen() {
        return this.fileIdListMaxLen;
    }

    public C11707b getFileSourceStrategy() {
        return this.fileSourceStrategy;
    }

    public Integer getFreeUserInterimMaxTimes() {
        return this.freeUserInterimMaxTimes;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public List<Integer> getGrayFlowStrategy() {
        return this.grayFlowStrategy;
    }

    public Integer getInterimExpirationDeleteTime() {
        return this.interimExpirationDeleteTime;
    }

    public Integer getInterimExtraRetentionTime() {
        return this.interimExtraRetentionTime;
    }

    public Long getLastBackupEndTime() {
        return this.lastBackupEndTime;
    }

    public C11707b getLockByDelDeviceStrategy() {
        return this.lockByDelDeviceStrategy;
    }

    public Long getMaxAttachmentUploadSize() {
        return this.maxAttachmentUploadSize;
    }

    public Integer getMaxBatchNumber() {
        return this.maxBatchNumber;
    }

    public Integer getOperationControl() {
        return this.operationControl;
    }

    public Integer getRefEffeDays() {
        return this.refEffeDays;
    }

    public Integer getRefEffeDelayDays() {
        return this.refEffeDelayDays;
    }

    public Integer getRefurQuotaExhausted() {
        return this.refurQuotaExhausted;
    }

    public Long getServerTime() {
        return this.serverTime;
    }

    public Status getStatus() {
        return this.status;
    }

    public Integer getTimes() {
        return this.times;
    }

    public C11707b getUploadTargetStrategy() {
        return this.uploadTargetStrategy;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isManualBypassOnFault() {
        return this.manualBypassOnFault;
    }

    public void setAcceptEncoding(String str) {
        this.acceptEncoding = str;
    }

    public void setApplistStrategy(Integer num) {
        this.applistStrategy = num;
    }

    public void setBackupDeviceId(String str) {
        this.backupDeviceId = str;
    }

    public About setBackupTimes(Integer num) {
        this.backupTimes = num;
        return this;
    }

    public About setBakSourceStrategy(C11707b c11707b) {
        this.bakSourceStrategy = c11707b;
        return this;
    }

    public void setBaseAppid(List<String> list) {
        this.baseAppid = list;
    }

    public void setBaseBakNumber(Integer num) {
        this.baseBakNumber = num;
    }

    public void setBmType(Integer num) {
        this.bmType = num;
    }

    public void setCloudOperationType(Integer num) {
        this.cloudOperationType = num;
    }

    public void setCountLeftInInterim(Integer num) {
        this.countLeftInInterim = num;
    }

    public void setDisableInterimReason(Integer num) {
        this.disableInterimReason = num;
    }

    public void setDivideStrategy(Integer num) {
        this.divideStrategy = num;
    }

    public void setFileIdListMaxLen(Long l10) {
        this.fileIdListMaxLen = l10;
    }

    public About setFileSourceStrategy(C11707b c11707b) {
        this.fileSourceStrategy = c11707b;
        return this;
    }

    public void setFreeUserInterimMaxTimes(Integer num) {
        this.freeUserInterimMaxTimes = num;
    }

    public About setGradeCode(String str) {
        this.gradeCode = str;
        return this;
    }

    public void setGrayFlowStrategy(List<Integer> list) {
        this.grayFlowStrategy = list;
    }

    public void setInterimExpirationDeleteTime(Integer num) {
        this.interimExpirationDeleteTime = num;
    }

    public void setInterimExtraRetentionTime(Integer num) {
        this.interimExtraRetentionTime = num;
    }

    public void setLockByDelDeviceStrategy(C11707b c11707b) {
        this.lockByDelDeviceStrategy = c11707b;
    }

    public void setManualBypassOnFault(boolean z10) {
        this.manualBypassOnFault = z10;
    }

    public About setMaxAttachmentUploadSize(Long l10) {
        this.maxAttachmentUploadSize = l10;
        return this;
    }

    public About setMaxBatchNumber(Integer num) {
        this.maxBatchNumber = num;
        return this;
    }

    public void setRefEffeDays(Integer num) {
        this.refEffeDays = num;
    }

    public void setRefEffeDelayDays(Integer num) {
        this.refEffeDelayDays = num;
    }

    public About setRefurQuotaExhausted(Integer num) {
        this.refurQuotaExhausted = num;
        return this;
    }

    public About setServerTime(Long l10) {
        this.serverTime = l10;
        return this;
    }

    public About setStatus(Status status) {
        this.status = status;
        return this;
    }

    public About setTimes(Integer num) {
        this.times = num;
        return this;
    }

    public About setUploadTargetStrategy(C11707b c11707b) {
        this.uploadTargetStrategy = c11707b;
        return this;
    }

    public About setUser(User user) {
        this.user = user;
        return this;
    }

    public static final class Status extends C11707b {

        @InterfaceC4648p
        private Integer vfsCut;

        public Integer getVfsCut() {
            return this.vfsCut;
        }

        public Status setVfsCut(Integer num) {
            this.vfsCut = num;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public Status set(String str, Object obj) {
            return (Status) super.set(str, obj);
        }
    }

    public static final class User extends C11707b {

        @InterfaceC4648p
        private String category;

        @InterfaceC4648p
        private String displayName;

        @InterfaceC4648p
        private String profilePhotoLink;

        @InterfaceC4648p
        private String userId;

        public String getCategory() {
            return this.category;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getProfilePhotoLink() {
            return this.profilePhotoLink;
        }

        public String getUserId() {
            return this.userId;
        }

        public User setCategory(String str) {
            this.category = str;
            return this;
        }

        public User setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public User setProfilePhotoLink(String str) {
            this.profilePhotoLink = str;
            return this;
        }

        public User setUserId(String str) {
            this.userId = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public User set(String str, Object obj) {
            return (User) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public About set(String str, Object obj) {
        return (About) super.set(str, obj);
    }
}
