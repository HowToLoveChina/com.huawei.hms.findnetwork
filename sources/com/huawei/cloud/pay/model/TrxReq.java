package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class TrxReq extends Request {
    private String cursor;
    private String version;

    public TrxReq(String str) {
        super("queryTrxPage");
        this.version = str;
    }

    public String getTimeStamp() {
        return this.cursor;
    }

    public String getVersion() {
        return this.version;
    }

    public void setTimeStamp(String str) {
        this.cursor = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public TrxReq(String str, String str2) {
        super("queryTrxPage");
        this.cursor = str;
        this.version = str2;
    }
}
