package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class CBSUpdateBackupRecordBaseReq extends CBSBaseIdsReq {
    private long endTime;

    public CBSUpdateBackupRecordBaseReq() {
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }

    public CBSUpdateBackupRecordBaseReq(String str, int i10, String str2) {
        this.backupId = str;
        this.deviceId = str2;
        this.deviceType = i10;
        this.endTime = System.currentTimeMillis();
    }
}
