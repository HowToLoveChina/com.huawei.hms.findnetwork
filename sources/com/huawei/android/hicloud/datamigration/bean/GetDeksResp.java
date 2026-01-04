package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class GetDeksResp extends CutBaseResp {
    private DekInfo deks;
    private Progress progress;

    public DekInfo getDeks() {
        return this.deks;
    }

    public Progress getProgress() {
        return this.progress;
    }

    public void setDeks(DekInfo dekInfo) {
        this.deks = dekInfo;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
