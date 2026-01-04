package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class DataBasesResponse extends C11707b {

    @InterfaceC4648p
    private Integer databaseId;

    @InterfaceC4648p
    private Integer mode;

    public Integer getDatabaseId() {
        return this.databaseId;
    }

    public Integer getMode() {
        return this.mode;
    }

    public void setDatabaseId(Integer num) {
        this.databaseId = num;
    }

    public void setMode(Integer num) {
        this.mode = num;
    }
}
