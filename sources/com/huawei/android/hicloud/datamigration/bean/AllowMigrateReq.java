package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class AllowMigrateReq extends CutBaseReq {
    private int allowStatus;
    private String country;
    private String userId;

    public AllowMigrateReq() {
        setCmd("common.datamigration.allow");
    }

    public int getAllowStatus() {
        return this.allowStatus;
    }

    public String getCountry() {
        return this.country;
    }

    public String getUserID() {
        return this.userId;
    }

    public void setAllowStatus(int i10) {
        this.allowStatus = i10;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setUserID(String str) {
        this.userId = str;
    }
}
