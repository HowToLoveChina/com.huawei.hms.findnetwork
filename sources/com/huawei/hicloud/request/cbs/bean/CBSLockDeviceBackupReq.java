package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSLockDeviceBackupReq extends CBSBaseIdReq {
    private String backupId;
    private int lockType;

    public CBSLockDeviceBackupReq(int i10, String str) {
        super(i10, str);
        this.lockType = 0;
    }

    public String getBackupId() {
        return this.backupId;
    }

    public int getLockType() {
        return this.lockType;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setLockType(int i10) {
        this.lockType = i10;
    }

    public CBSLockDeviceBackupReq(int i10, String str, int i11) {
        super(i10, str);
        this.lockType = i11;
    }
}
