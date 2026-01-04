package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class FileFinish extends C11707b {

    @InterfaceC4648p
    private String assetId;

    @InterfaceC4648p
    private C4644l finishTime;

    @InterfaceC4648p
    private String versionId;

    public String getAssetId() {
        return this.assetId;
    }

    public C4644l getFinishTime() {
        return this.finishTime;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public FileFinish setAssetId(String str) {
        this.assetId = str;
        return this;
    }

    public FileFinish setFinishTime(C4644l c4644l) {
        this.finishTime = c4644l;
        return this;
    }

    public FileFinish setVersionId(String str) {
        this.versionId = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public FileFinish set(String str, Object obj) {
        return (FileFinish) super.set(str, obj);
    }
}
