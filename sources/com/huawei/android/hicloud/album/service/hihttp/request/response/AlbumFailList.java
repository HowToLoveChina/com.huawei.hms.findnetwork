package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class AlbumFailList {
    private String albumId;
    private String albumName;
    private int errCode;
    private String errMsg;
    private String existAlbumId;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getExistAlbumId() {
        return this.existAlbumId;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setExistAlbumId(String str) {
        this.existAlbumId = str;
    }

    public String toString() {
        return this.albumId + " " + this.errCode + " " + this.errMsg;
    }
}
