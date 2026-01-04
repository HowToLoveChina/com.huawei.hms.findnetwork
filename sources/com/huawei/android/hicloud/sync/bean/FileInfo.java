package com.huawei.android.hicloud.sync.bean;

/* loaded from: classes3.dex */
public class FileInfo {
    private String createTime;
    private String fileType;
    private String luid;
    private String name;
    private String service;
    private String type;
    private String uuid;

    public FileInfo() {
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getLuid() {
        return this.luid;
    }

    public String getName() {
        return this.name;
    }

    public String getService() {
        return this.service;
    }

    public String getType() {
        return this.type;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setLuid(String str) {
        this.luid = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public FileInfo(String str, String str2, String str3, String str4, String str5) {
        this.service = str;
        this.type = str2;
        this.luid = str3;
        this.name = str4;
        this.uuid = str5;
    }
}
