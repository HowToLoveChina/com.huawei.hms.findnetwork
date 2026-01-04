package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.user.model.User;
import ni.C11707b;
import p765x7.C13719a;

/* loaded from: classes3.dex */
public class About extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String dataVersion;

    @InterfaceC4648p
    private String domain;

    @InterfaceC4648p
    private String fullUploadCursor;

    @InterfaceC4648p
    private Integer maxBatchGetNumber;

    @InterfaceC4648p
    private Integer maxBatchNumber;

    @InterfaceC4648p
    private Integer maxBatchUpdateNumber;

    @InterfaceC4648p
    private String maxFileUploadSize;

    @InterfaceC4648p
    private Integer maxShareNumber;

    @InterfaceC4648p
    private Integer maxThumbnailSize;

    @InterfaceC4648p
    private Long serverTime;

    @InterfaceC4648p
    private Status status;

    @InterfaceC4648p
    private User user;

    public static class Status extends C11707b {

        @InterfaceC4648p
        private Integer countdownDays;

        @InterfaceC4648p
        private C4644l deleteTime;

        @InterfaceC4648p
        private String suspend;

        @InterfaceC4648p
        private Long suspendCursor;

        @InterfaceC4648p
        private C4644l suspendTime;

        @InterfaceC4648p
        private Integer v2cut;

        public String getBigSuspendCursor() {
            return C13719a.m82474b(this.suspendCursor);
        }

        public Integer getCountdownDays() {
            return this.countdownDays;
        }

        public C4644l getDeleteTime() {
            return this.deleteTime;
        }

        public String getSuspend() {
            return this.suspend;
        }

        public String getSuspendCursor() {
            Long l10 = this.suspendCursor;
            return l10 == null ? "" : String.valueOf(l10);
        }

        public C4644l getSuspendTime() {
            return this.suspendTime;
        }

        public Integer getV2cut() {
            return this.v2cut;
        }

        public void setCountdownDays(Integer num) {
            this.countdownDays = num;
        }

        public Status setDeleteTime(C4644l c4644l) {
            this.deleteTime = c4644l;
            return this;
        }

        public void setSuspend(String str) {
            this.suspend = str;
        }

        public Status setSuspendCursor(Long l10) {
            this.suspendCursor = l10;
            return this;
        }

        public void setSuspendTime(C4644l c4644l) {
            this.suspendTime = c4644l;
        }

        public void setV2cut(Integer num) {
            this.v2cut = num;
        }
    }

    public String getCategory() {
        return this.category;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getFullUploadCursor() {
        return this.fullUploadCursor;
    }

    public Integer getMaxBatchGetNumber() {
        return this.maxBatchGetNumber;
    }

    public Integer getMaxBatchNumber() {
        return this.maxBatchNumber;
    }

    public Integer getMaxBatchUpdateNumber() {
        return this.maxBatchUpdateNumber;
    }

    public String getMaxFileUploadSize() {
        return this.maxFileUploadSize;
    }

    public Integer getMaxShareNumber() {
        return this.maxShareNumber;
    }

    public Integer getMaxThumbnailSize() {
        return this.maxThumbnailSize;
    }

    public Long getServerTime() {
        return this.serverTime;
    }

    public Status getStatus() {
        return this.status;
    }

    public User getUser() {
        return this.user;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public About setFullUploadCursor(String str) {
        this.fullUploadCursor = str;
        return this;
    }

    public void setMaxBatchGetNumber(Integer num) {
        this.maxBatchGetNumber = num;
    }

    public About setMaxBatchNumber(Integer num) {
        this.maxBatchNumber = num;
        return this;
    }

    public void setMaxBatchUpdateNumber(Integer num) {
        this.maxBatchUpdateNumber = num;
    }

    public void setMaxFileUploadSize(String str) {
        this.maxFileUploadSize = str;
    }

    public void setMaxShareNumber(Integer num) {
        this.maxShareNumber = num;
    }

    public void setMaxThumbnailSize(Integer num) {
        this.maxThumbnailSize = num;
    }

    public void setServerTime(Long l10) {
        this.serverTime = l10;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
