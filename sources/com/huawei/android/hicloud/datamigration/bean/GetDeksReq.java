package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class GetDeksReq extends CutBaseReq {
    private String encTempKey;
    private Progress progress;

    public GetDeksReq() {
        setCmd("common.datamigration.getdek");
    }

    public String getEncTempKey() {
        return this.encTempKey;
    }

    public Progress getProgress() {
        return this.progress;
    }

    public void setEncTempKey(String str) {
        this.encTempKey = str;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
