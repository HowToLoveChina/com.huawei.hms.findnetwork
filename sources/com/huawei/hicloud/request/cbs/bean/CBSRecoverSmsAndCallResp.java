package com.huawei.hicloud.request.cbs.bean;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class CBSRecoverSmsAndCallResp extends CBSBaseResp {
    private ArrayList<CallLogBean> callLogList;
    private int more;
    private ArrayList<SmsBean> smsList;
    private int total;

    public ArrayList<CallLogBean> getCallLogList() {
        return this.callLogList;
    }

    public int getMore() {
        return this.more;
    }

    public ArrayList<SmsBean> getSmsList() {
        return this.smsList;
    }

    public int getTotal() {
        return this.total;
    }

    public void setCallLogList(ArrayList<CallLogBean> arrayList) {
        this.callLogList = arrayList;
    }

    public void setMore(int i10) {
        this.more = i10;
    }

    public void setSmsList(ArrayList<SmsBean> arrayList) {
        this.smsList = arrayList;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }
}
