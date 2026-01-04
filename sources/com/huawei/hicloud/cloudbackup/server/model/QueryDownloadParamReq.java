package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class QueryDownloadParamReq extends BaseRequest {
    private String path;
    private String scheme;

    public QueryDownloadParamReq() {
        super(47, "QueryDownloadParamReq");
        this.scheme = "https";
    }

    public String getPath() {
        return this.path;
    }

    public String getScheme() {
        return this.scheme;
    }

    public QueryDownloadParamReq setPath(String str) {
        this.path = str;
        return this;
    }

    public QueryDownloadParamReq setScheme(String str) {
        this.scheme = str;
        return this;
    }
}
