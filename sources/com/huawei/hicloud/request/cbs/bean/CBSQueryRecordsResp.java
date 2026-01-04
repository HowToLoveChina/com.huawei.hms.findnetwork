package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSQueryRecordsResp extends CBSBaseResp {
    private List<CBSBackupRecord> backupRecords;

    public List<CBSBackupRecord> getBackupRecords() {
        return this.backupRecords;
    }

    public void setBackupRecords(List<CBSBackupRecord> list) {
        this.backupRecords = list;
    }
}
