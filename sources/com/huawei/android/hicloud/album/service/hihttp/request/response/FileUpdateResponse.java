package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class FileUpdateResponse extends BaseResponse {
    private FileFailRet[] failList;
    private FileSuccessRet[] successList;

    public FileFailRet[] getFailList() {
        return this.failList;
    }

    public FileSuccessRet[] getSuccessList() {
        return this.successList;
    }

    public void setFailList(FileFailRet[] fileFailRetArr) {
        this.failList = fileFailRetArr;
    }

    public void setSuccessList(FileSuccessRet[] fileSuccessRetArr) {
        this.successList = fileSuccessRetArr;
    }
}
