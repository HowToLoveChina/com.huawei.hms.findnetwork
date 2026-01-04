package com.huawei.hicloud.request.basic.bean;

import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSSyncRecordsRsp extends CBSBaseResp {
    private String cursor;
    private List<CBSSyncRecordOperation> opRecordList;
    private int opStoreDays;
    private String opTimeTag;
    private String userTimeZone;

    public String getCursor() {
        return this.cursor;
    }

    public List<CBSSyncRecordOperation> getOpRecordList() {
        return this.opRecordList;
    }

    public int getOpStoreDays() {
        return this.opStoreDays;
    }

    public String getOpTimeTag() {
        return this.opTimeTag;
    }

    public String getUserTimeZone() {
        return this.userTimeZone;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setOpRecordList(List<CBSSyncRecordOperation> list) {
        this.opRecordList = list;
    }

    public void setOpStoreDays(int i10) {
        this.opStoreDays = i10;
    }

    public void setOpTimeTag(String str) {
        this.opTimeTag = str;
    }

    public void setUserTimeZone(String str) {
        this.userTimeZone = str;
    }
}
