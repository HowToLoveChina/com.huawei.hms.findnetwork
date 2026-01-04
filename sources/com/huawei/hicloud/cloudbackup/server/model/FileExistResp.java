package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class FileExistResp extends BaseResponse {
    private int apkType;
    private boolean exist;

    public int getApkType() {
        return this.apkType;
    }

    public boolean isExist() {
        return this.exist;
    }

    public boolean isStandard() {
        return this.apkType == 1;
    }

    public FileExistResp setApkType(int i10) {
        this.apkType = i10;
        return this;
    }

    public FileExistResp setExist(boolean z10) {
        this.exist = z10;
        return this;
    }
}
