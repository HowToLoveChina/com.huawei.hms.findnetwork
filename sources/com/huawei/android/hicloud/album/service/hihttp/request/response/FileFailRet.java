package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class FileFailRet {
    private int errCode;
    private String errMsg;
    private String fileName;
    private String hash;
    private String uniqueId;

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getHash() {
        return this.hash;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String toString() {
        return this.uniqueId + " " + this.errCode + " " + this.errMsg;
    }
}
