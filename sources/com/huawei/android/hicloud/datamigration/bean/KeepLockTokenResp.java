package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class KeepLockTokenResp extends CutBaseResp {
    private int expire;
    private String lockToken;

    public int getExpire() {
        return this.expire;
    }

    public String getLockToken() {
        return this.lockToken;
    }

    public void setExpire(int i10) {
        this.expire = i10;
    }

    public void setLockToken(String str) {
        this.lockToken = str;
    }
}
