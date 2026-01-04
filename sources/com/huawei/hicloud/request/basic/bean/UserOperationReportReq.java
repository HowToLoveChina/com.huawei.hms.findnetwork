package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class UserOperationReportReq extends BasicBaseReq {
    private String opRecordList;

    public UserOperationReportReq() {
        super("postOperationRecord");
    }

    public String getOpRecordList() {
        return this.opRecordList;
    }

    public void setOpRecordList(String str) {
        this.opRecordList = str;
    }
}
