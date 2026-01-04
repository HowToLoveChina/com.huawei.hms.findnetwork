package com.huawei.android.hicloud.album.service.hihttp.request.response;

import java.util.Map;

/* loaded from: classes2.dex */
public class FileCopyResponse extends BaseResponse {
    private Map<String, FileFailRet> failList;
    private FileCopyRet[] successList;

    public Map<String, FileFailRet> getFailList() {
        return this.failList;
    }

    public FileCopyRet[] getSuccessList() {
        return this.successList;
    }

    public void setFailList(Map<String, FileFailRet> map) {
        this.failList = map;
    }

    public void setSuccessList(FileCopyRet[] fileCopyRetArr) {
        this.successList = fileCopyRetArr;
    }
}
