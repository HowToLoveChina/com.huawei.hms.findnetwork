package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class QueryUploadParamReq extends CheckFileExistV2Req {
    private String completePath;
    private int hasBucketId;
    private String scheme;
    private String type;
    private String userAgent;

    public QueryUploadParamReq() {
        super(46, "QueryUploadParamReq");
        this.scheme = "https";
        this.hasBucketId = 1;
    }

    public String getCompletePath() {
        return this.completePath;
    }

    public int getHasBucketId() {
        return this.hasBucketId;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getType() {
        return this.type;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public QueryUploadParamReq setCompletePath(String str) {
        this.completePath = str;
        return this;
    }

    public QueryUploadParamReq setHasBucketId(int i10) {
        this.hasBucketId = i10;
        return this;
    }

    public QueryUploadParamReq setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public QueryUploadParamReq setType(String str) {
        this.type = str;
        return this;
    }

    public QueryUploadParamReq setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.server.model.CheckFileExistV2Req
    public QueryUploadParamReq setMD5(String str) {
        return (QueryUploadParamReq) super.setMD5(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.model.CheckFileExistV2Req
    public QueryUploadParamReq setPath(String str) {
        return (QueryUploadParamReq) super.setPath(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.model.CheckFileExistV2Req
    public QueryUploadParamReq setSha256(String str) {
        return (QueryUploadParamReq) super.setSha256(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.model.CheckFileExistV2Req
    public QueryUploadParamReq setSize(long j10) {
        return (QueryUploadParamReq) super.setSize(j10);
    }
}
