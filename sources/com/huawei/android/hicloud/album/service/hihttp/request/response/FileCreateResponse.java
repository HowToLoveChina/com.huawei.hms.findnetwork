package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class FileCreateResponse extends BaseResponse {
    String fileName;
    String sdsctime;
    String uniqueId;

    public String getFileName() {
        return this.fileName;
    }

    public String getSdsctime() {
        return this.sdsctime;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setSdsctime(String str) {
        this.sdsctime = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
