package com.huawei.android.hicloud.drive.cloudphoto.model;

import java.io.File;

/* loaded from: classes3.dex */
public class CompressInfo {
    private File compressFile;
    private Long compressedSize;
    private String encoding;
    private Integer type;

    public File getCompressFile() {
        return this.compressFile;
    }

    public Long getCompressedSize() {
        return this.compressedSize;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Integer getType() {
        return this.type;
    }

    public void setCompressFile(File file) {
        this.compressFile = file;
    }

    public void setCompressedSize(Long l10) {
        this.compressedSize = l10;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public String toReportString() {
        return "CompressInfo{encoding='" + this.encoding + "', type=" + this.type + ", compressedSize=" + this.compressedSize + '}';
    }

    public String toString() {
        return "CompressInfo{compressPath='" + this.compressFile + "', encoding='" + this.encoding + "', type=" + this.type + ", compressedSize=" + this.compressedSize + '}';
    }
}
