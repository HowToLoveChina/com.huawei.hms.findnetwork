package com.huawei.android.hicloud.security.bean;

import java.io.File;

/* loaded from: classes3.dex */
public class UniqueReq {
    private File file;
    private int keyType;
    private long length;
    private String traceID;

    public UniqueReq(File file, int i10, long j10) {
        this.file = file;
        this.keyType = i10;
        this.length = j10;
    }

    public File getFile() {
        return this.file;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public long getLength() {
        return this.length;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setLength(long j10) {
        this.length = j10;
    }

    public void setTraceID(String str) {
        this.traceID = str;
    }
}
