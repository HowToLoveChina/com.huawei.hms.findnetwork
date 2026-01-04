package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSQueryDownLoadParamReq extends CBSBaseReq {
    private String path;
    private String scheme;

    public CBSQueryDownLoadParamReq() {
    }

    public String getPath() {
        return this.path;
    }

    public String getScheme() {
        return this.scheme;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public CBSQueryDownLoadParamReq(String str) {
        this.cmd = 47;
        this.info = "QueryDownloadParamReq";
        this.path = str;
        this.scheme = "https";
    }
}
