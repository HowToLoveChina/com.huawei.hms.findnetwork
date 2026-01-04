package com.huawei.hicloud.request.cbs.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSBackupReq extends CBSBaseReq {
    private List<CallLogBean> callLogList;
    private List<SmsBean> smsList;
    private String type;

    public CBSBackupReq() {
    }

    public List<CallLogBean> getCallLogList() {
        return this.callLogList;
    }

    public List<SmsBean> getSmsList() {
        return this.smsList;
    }

    public String getType() {
        return this.type;
    }

    public void setCallLogList(List<CallLogBean> list) {
        this.callLogList = list;
    }

    public void setSmsList(List<SmsBean> list) {
        this.smsList = list;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CBSBackupReq(int i10, String str) {
        super(i10, str);
    }

    public CBSBackupReq(int i10, String str, List<CallLogBean> list) {
        super(i10, str);
        this.callLogList = list;
        this.smsList = new ArrayList();
    }

    public CBSBackupReq(List<SmsBean> list, int i10, String str) {
        super(i10, str);
        this.smsList = list;
        this.callLogList = new ArrayList();
    }
}
