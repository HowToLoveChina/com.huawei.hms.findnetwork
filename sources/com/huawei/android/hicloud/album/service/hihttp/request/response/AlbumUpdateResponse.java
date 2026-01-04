package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class AlbumUpdateResponse extends BaseResponse {
    private AlbumFailList[] failList;
    private String[] successList;

    public AlbumFailList[] getFailList() {
        return this.failList;
    }

    public String[] getSuccessList() {
        return this.successList;
    }

    public void setFailList(AlbumFailList[] albumFailListArr) {
        this.failList = albumFailListArr;
    }

    public void setSuccessList(String[] strArr) {
        this.successList = strArr;
    }
}
