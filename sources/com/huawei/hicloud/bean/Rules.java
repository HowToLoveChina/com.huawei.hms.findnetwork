package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class Rules {
    private String encoding;
    private String gradeCode;

    /* renamed from: id */
    private String f22233id;
    private int maxWResolution;
    private String mimeType;
    private long minFileSize;

    public String getEncoding() {
        return this.encoding;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getId() {
        return this.f22233id;
    }

    public int getMaxWResolution() {
        return this.maxWResolution;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public long getMinFileSize() {
        return this.minFileSize;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setId(String str) {
        this.f22233id = str;
    }

    public void setMaxWResolution(int i10) {
        this.maxWResolution = i10;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setMinFileSize(long j10) {
        this.minFileSize = j10;
    }

    public String toString() {
        return "Rules{id='" + this.f22233id + "', mimeType='" + this.mimeType + "', encoding='" + this.encoding + "', minFileSize=" + this.minFileSize + ", maxWResolution=" + this.maxWResolution + ", gradeCode='" + this.gradeCode + "'}";
    }
}
