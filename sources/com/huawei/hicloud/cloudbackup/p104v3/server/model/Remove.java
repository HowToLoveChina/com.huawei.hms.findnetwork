package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Remove extends C11707b {

    @InterfaceC4648p
    private long deleteTime = -1;

    @InterfaceC4648p
    private List<Device4Del> device4Dels;

    @InterfaceC4648p
    private String nextCursor;

    public static final class Device4Del extends C11707b {

        @InterfaceC4648p
        private String appVersion;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private C4644l bakUpdateTime;

        @InterfaceC4648p
        private C4644l createTime;

        @InterfaceC4648p
        private String device;

        @InterfaceC4648p
        private String deviceCategory;

        @InterfaceC4648p
        private String deviceDisplayName;

        @InterfaceC4648p
        private String deviceIconUrl;

        @InterfaceC4648p
        private String devicePathName;

        @InterfaceC4648p
        private String deviceSpace;

        @InterfaceC4648p
        private String terminalOS;

        @InterfaceC4648p
        private String terminalType;

        @InterfaceC4648p
        private C4644l updateTime;

        public String getAppVersion() {
            return this.appVersion;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public C4644l getBakUpdateTime() {
            return this.bakUpdateTime;
        }

        public C4644l getCreateTime() {
            return this.createTime;
        }

        public String getDevice() {
            return this.device;
        }

        public String getDeviceCategory() {
            return this.deviceCategory;
        }

        public String getDeviceDisplayName() {
            return this.deviceDisplayName;
        }

        public String getDeviceIconUrl() {
            return this.deviceIconUrl;
        }

        public String getDevicePathName() {
            return this.devicePathName;
        }

        public String getDeviceSpace() {
            return this.deviceSpace;
        }

        public String getTerminalOS() {
            return this.terminalOS;
        }

        public String getTerminalType() {
            return this.terminalType;
        }

        public C4644l getUpdateTime() {
            return this.updateTime;
        }

        public void setAppVersion(String str) {
            this.appVersion = str;
        }

        public void setBackupDeviceId(String str) {
            this.backupDeviceId = str;
        }

        public void setBakUpdateTime(C4644l c4644l) {
            this.bakUpdateTime = c4644l;
        }

        public void setCreateTime(C4644l c4644l) {
            this.createTime = c4644l;
        }

        public void setDevice(String str) {
            this.device = str;
        }

        public void setDeviceCategory(String str) {
            this.deviceCategory = str;
        }

        public void setDeviceDisplayName(String str) {
            this.deviceDisplayName = str;
        }

        public void setDeviceIconUrl(String str) {
            this.deviceIconUrl = str;
        }

        public void setDevicePathName(String str) {
            this.devicePathName = str;
        }

        public void setDeviceSpace(String str) {
            this.deviceSpace = str;
        }

        public void setTerminalOS(String str) {
            this.terminalOS = str;
        }

        public void setTerminalType(String str) {
            this.terminalType = str;
        }

        public void setUpdateTime(C4644l c4644l) {
            this.updateTime = c4644l;
        }
    }

    public static class QuerySwitch extends C11707b {

        @InterfaceC4648p
        private Integer clearTime;

        @InterfaceC4648p
        private Integer status;

        public Integer getClearTime() {
            return this.clearTime;
        }

        public Integer getStatus() {
            return this.status;
        }

        public void setClearTime(Integer num) {
            this.clearTime = num;
        }

        public void setStatus(Integer num) {
            this.status = num;
        }
    }

    public static class RefreshSwitch extends C11707b {

        @InterfaceC4648p
        private Integer clearTime;

        @InterfaceC4648p
        private Integer status;

        public Integer getClearTime() {
            return this.clearTime;
        }

        public Integer getStatus() {
            return this.status;
        }

        public RefreshSwitch setClearTime(Integer num) {
            this.clearTime = num;
            return this;
        }

        public RefreshSwitch setStatus(Integer num) {
            this.status = num;
            return this;
        }
    }

    public long getDeleteTime() {
        return this.deleteTime;
    }

    public List<Device4Del> getDevice4Dels() {
        return this.device4Dels;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public void setDeleteTime(long j10) {
        this.deleteTime = j10;
    }

    public void setDevice4Dels(List<Device4Del> list) {
        this.device4Dels = list;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }
}
