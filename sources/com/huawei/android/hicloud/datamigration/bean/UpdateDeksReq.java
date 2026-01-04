package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class UpdateDeksReq extends CutBaseReq {
    private DekInfo deks;
    private String strDataVer;
    private String strGuid;
    private String unstrDataVer;
    private String unstrGuid;

    public UpdateDeksReq() {
        setCmd("common.datamigration.updatedek");
    }

    public DekInfo getDeks() {
        return this.deks;
    }

    public String getStrDataVer() {
        return this.strDataVer;
    }

    public String getStrGuid() {
        return this.strGuid;
    }

    public String getUnstrDataVer() {
        return this.unstrDataVer;
    }

    public String getUnstrGuid() {
        return this.unstrGuid;
    }

    public void setDeks(DekInfo dekInfo) {
        this.deks = dekInfo;
    }

    public void setStrDataVer(String str) {
        this.strDataVer = str;
    }

    public void setStrGuid(String str) {
        this.strGuid = str;
    }

    public void setUnstrDataVer(String str) {
        this.unstrDataVer = str;
    }

    public void setUnstrGuid(String str) {
        this.unstrGuid = str;
    }
}
