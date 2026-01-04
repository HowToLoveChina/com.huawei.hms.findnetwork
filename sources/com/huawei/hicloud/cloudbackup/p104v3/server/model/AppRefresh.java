package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;

/* loaded from: classes6.dex */
public class AppRefresh extends AppFinish {

    @InterfaceC4648p
    private Integer backupAppStatus;

    public Integer getBackupAppStatus() {
        return this.backupAppStatus;
    }

    public AppFinish setBackupAppStatus(Integer num) {
        this.backupAppStatus = num;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public /* bridge */ /* synthetic */ AppFinish setProperties(Map map) {
        return setProperties((Map<String, String>) map);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public AppRefresh setAppTotalSize(Long l10) {
        return (AppRefresh) super.setAppTotalSize(l10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public AppRefresh setFileCount(Integer num) {
        return (AppRefresh) super.setFileCount(num);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public AppRefresh setPackageVersion(String str) {
        return (AppRefresh) super.setPackageVersion(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public AppRefresh setProperties(Map<String, String> map) {
        return (AppRefresh) super.setProperties(map);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public AppRefresh setRuntimeType(Integer num) {
        return (AppRefresh) super.setRuntimeType(num);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish
    public AppRefresh setUpdateTime(C4644l c4644l) {
        return (AppRefresh) super.setUpdateTime(c4644l);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish, ni.C11707b, com.huawei.cloud.base.util.C4646n
    public AppRefresh set(String str, Object obj) {
        return (AppRefresh) super.set(str, obj);
    }
}
