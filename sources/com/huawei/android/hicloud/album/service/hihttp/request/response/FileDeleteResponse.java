package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class FileDeleteResponse extends BaseResponse {
    private FileFailRet[] failList;
    private String[] successList;

    public FileFailRet[] getFailList() {
        return this.failList;
    }

    public String[] getSuccessList() {
        return this.successList;
    }

    public void setFailList(FileFailRet[] fileFailRetArr) {
        this.failList = fileFailRetArr;
    }

    public void setSuccessList(String[] strArr) {
        this.successList = strArr;
    }
}
