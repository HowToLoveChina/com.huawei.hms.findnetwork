package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSUpdateFullBackupRecordReq extends CBSUpdateBackupRecordReq {
    int incType;

    public CBSUpdateFullBackupRecordReq() {
    }

    public int getIncType() {
        return this.incType;
    }

    public void setIncType(int i10) {
        this.incType = i10;
    }

    public CBSUpdateFullBackupRecordReq(String str, String str2, int i10, int i11, int i12, int i13, String str3) {
        super(str, str2, i10, i11, i13, str3);
        this.cmd = 25;
        this.info = "UpdateBackupRecordReq";
        this.incType = i12;
    }
}
