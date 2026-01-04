package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class LockTokenResp extends CutBaseResp {
    private int expire;
    private String lockToken;
    private int verifyStatus;

    public int getExpire() {
        return this.expire;
    }

    public String getLockToken() {
        return this.lockToken;
    }

    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    public void setExpire(int i10) {
        this.expire = i10;
    }

    public void setLockToken(String str) {
        this.lockToken = str;
    }

    public void setVerifyStatus(int i10) {
        this.verifyStatus = i10;
    }
}
