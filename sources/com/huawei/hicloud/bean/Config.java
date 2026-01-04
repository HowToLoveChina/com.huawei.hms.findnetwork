package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class Config {
    private String content;
    private String etag;
    private FileInfo file;
    private int type;

    public String getContent() {
        return this.content;
    }

    public String getEtag() {
        return this.etag;
    }

    public FileInfo getFile() {
        return this.file;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setFile(FileInfo fileInfo) {
        this.file = fileInfo;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
