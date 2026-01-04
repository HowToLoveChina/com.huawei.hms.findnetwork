package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class AlbumBatchId extends C11707b {

    @InterfaceC4648p
    private C4644l batchTime;

    @InterfaceC4648p
    private String category;

    /* renamed from: id */
    @InterfaceC4648p
    private Integer f12217id;

    public C4644l getBatchTime() {
        return this.batchTime;
    }

    public String getCategory() {
        return this.category;
    }

    public Integer getId() {
        return this.f12217id;
    }

    public void setBatchTime(C4644l c4644l) {
        this.batchTime = c4644l;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setId(Integer num) {
        this.f12217id = num;
    }
}
