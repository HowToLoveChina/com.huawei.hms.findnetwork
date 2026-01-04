package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class InformCreateRequest extends C11707b {

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private List<InformRecord> recordList;

    @InterfaceC4648p
    private String userId;

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public List<InformRecord> getRecordList() {
        return this.recordList;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setRecordList(List<InformRecord> list) {
        this.recordList = list;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
