package com.huawei.android.hicloud.security.bean;

/* loaded from: classes3.dex */
public class SliceDecryptReq {
    private String desFile;
    private String efek;

    /* renamed from: iv */
    private String f12725iv;
    private long offset;
    private String srcFile;
    private String traceID;
    private int type;

    public String getDesFile() {
        return this.desFile;
    }

    public String getEfek() {
        return this.efek;
    }

    public String getIv() {
        return this.f12725iv;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getSrcFile() {
        return this.srcFile;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public int getType() {
        return this.type;
    }

    public void setDesFile(String str) {
        this.desFile = str;
    }

    public void setEfek(String str) {
        this.efek = str;
    }

    public void setIv(String str) {
        this.f12725iv = str;
    }

    public void setOffset(long j10) {
        this.offset = j10;
    }

    public void setSrcFile(String str) {
        this.srcFile = str;
    }

    public void setTraceID(String str) {
        this.traceID = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
