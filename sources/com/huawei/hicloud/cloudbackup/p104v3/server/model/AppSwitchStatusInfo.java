package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppSwitchStatusInfo extends C11707b {

    @InterfaceC4648p
    private String backupAppName;

    @InterfaceC4648p
    private C4644l createTime;

    @InterfaceC4648p
    private Boolean switchStatus;

    @InterfaceC4648p
    private C4644l updateTime;

    public String getBackupAppName() {
        return this.backupAppName;
    }

    public C4644l getCreateTime() {
        return this.createTime;
    }

    public Boolean getSwitchStatus() {
        return this.switchStatus;
    }

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public AppSwitchStatusInfo setBackupAppName(String str) {
        this.backupAppName = str;
        return this;
    }

    public AppSwitchStatusInfo setCreateTime(C4644l c4644l) {
        this.createTime = c4644l;
        return this;
    }

    public AppSwitchStatusInfo setSwitchStatus(Boolean bool) {
        this.switchStatus = bool;
        return this;
    }

    public AppSwitchStatusInfo setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }
}
