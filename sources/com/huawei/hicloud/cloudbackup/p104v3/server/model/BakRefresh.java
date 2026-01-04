package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BakRefresh extends C11707b {

    @InterfaceC4648p
    private String appsUnbacked;

    @InterfaceC4648p
    private Integer backupStatus;

    @InterfaceC4648p
    private List<String> cloudControlAction;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Integer recoverFlag;

    @InterfaceC4648p
    private String unSuccessRecoverSummary;

    @InterfaceC4648p
    private String unSuccessSummary;

    @InterfaceC4648p
    private C4644l updateTime;

    public String getAppsUnbacked() {
        return this.appsUnbacked;
    }

    public Integer getBackupStatus() {
        return this.backupStatus;
    }

    public List<String> getCloudControlAction() {
        return this.cloudControlAction;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Integer getRecoverFlag() {
        return this.recoverFlag;
    }

    public String getUnSuccessRecoverSummary() {
        return this.unSuccessRecoverSummary;
    }

    public String getUnSuccessSummary() {
        return this.unSuccessSummary;
    }

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public BakRefresh setAppsUnbacked(String str) {
        this.appsUnbacked = str;
        return this;
    }

    public BakRefresh setBackupStatus(Integer num) {
        this.backupStatus = num;
        return this;
    }

    public BakRefresh setCloudControlAction(List<String> list) {
        this.cloudControlAction = list;
        return this;
    }

    public BakRefresh setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public BakRefresh setRecoverFlag(Integer num) {
        this.recoverFlag = num;
        return this;
    }

    public BakRefresh setUnSuccessRecoverSummary(String str) {
        this.unSuccessRecoverSummary = str;
        return this;
    }

    public BakRefresh setUnSuccessSummary(String str) {
        this.unSuccessSummary = str;
        return this;
    }

    public BakRefresh setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }

    public static class Summary extends C11707b {

        @InterfaceC4648p
        private Long appCount;

        @InterfaceC4648p
        private List<String> appList;

        @InterfaceC4648p
        private C4644l beginTime;

        @InterfaceC4648p
        private C4644l endTime;

        @InterfaceC4648p
        private String message;

        @InterfaceC4648p
        private String recDeviceDisplayName;

        @InterfaceC4648p
        private String recDeviceTerminal;

        @InterfaceC4648p
        private Integer retCode;

        @InterfaceC4648p
        private C4644l startTime;

        @InterfaceC4648p
        private Long totalSize;

        public Long getAppCount() {
            return this.appCount;
        }

        public List<String> getAppList() {
            return this.appList;
        }

        public C4644l getBeginTime() {
            return this.beginTime;
        }

        public C4644l getEndTime() {
            return this.endTime;
        }

        public String getMessage() {
            return this.message;
        }

        public String getRecDeviceDisplayName() {
            return this.recDeviceDisplayName;
        }

        public String getRecDeviceTerminal() {
            return this.recDeviceTerminal;
        }

        public Integer getRetCode() {
            return this.retCode;
        }

        public C4644l getStartTime() {
            return this.startTime;
        }

        public Long getTotalSize() {
            return this.totalSize;
        }

        public Summary setAppCount(Long l10) {
            this.appCount = l10;
            return this;
        }

        public Summary setAppList(List<String> list) {
            this.appList = list;
            return this;
        }

        public Summary setBeginTime(C4644l c4644l) {
            this.beginTime = c4644l;
            return this;
        }

        public Summary setEndTime(C4644l c4644l) {
            this.endTime = c4644l;
            return this;
        }

        public Summary setMessage(String str) {
            this.message = str;
            return this;
        }

        public Summary setRecDeviceDisplayName(String str) {
            this.recDeviceDisplayName = str;
            return this;
        }

        public Summary setRecDeviceTerminal(String str) {
            this.recDeviceTerminal = str;
            return this;
        }

        public Summary setRetCode(Integer num) {
            this.retCode = num;
            return this;
        }

        public Summary setStartTime(C4644l c4644l) {
            this.startTime = c4644l;
            return this;
        }

        public Summary setTotalSize(Long l10) {
            this.totalSize = l10;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public Summary set(String str, Object obj) {
            return (Summary) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public BakRefresh set(String str, Object obj) {
        return (BakRefresh) super.set(str, obj);
    }
}
