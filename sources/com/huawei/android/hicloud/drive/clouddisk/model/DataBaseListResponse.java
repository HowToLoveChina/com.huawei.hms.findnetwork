package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBaseListResponse extends DataBasesResponse {

    @InterfaceC4648p
    private List<DataBasesResponse> databases;

    @InterfaceC4648p
    private String nextCursor;

    public List<DataBasesResponse> getDatabases() {
        return this.databases;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public void setDatabases(List<DataBasesResponse> list) {
        this.databases = list;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }
}
