package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class NsSeginfo {
    private String fileid;
    private String range;

    public NsSeginfo(String str, String str2) {
        this.fileid = str;
        this.range = str2;
    }

    public String getFileId() {
        return this.fileid;
    }

    public String getRange() {
        return this.range;
    }

    public void setFileId(String str) {
        this.fileid = str;
    }

    public void setRange(String str) {
        this.range = str;
    }
}
