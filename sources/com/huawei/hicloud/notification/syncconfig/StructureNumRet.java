package com.huawei.hicloud.notification.syncconfig;

import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import java.util.List;

/* loaded from: classes6.dex */
public class StructureNumRet {
    private List<DriveConfigService> driveConfigServices;
    private String numStr;
    private List<SyncConfigService> syncConfigServices;

    public List<DriveConfigService> getDriveConfigServices() {
        return this.driveConfigServices;
    }

    public String getNumStr() {
        return this.numStr;
    }

    public List<SyncConfigService> getSyncConfigServices() {
        return this.syncConfigServices;
    }

    public void setDriveConfigServices(List<DriveConfigService> list) {
        this.driveConfigServices = list;
    }

    public void setNumStr(String str) {
        this.numStr = str;
    }

    public void setSyncConfigServices(List<SyncConfigService> list) {
        this.syncConfigServices = list;
    }
}
