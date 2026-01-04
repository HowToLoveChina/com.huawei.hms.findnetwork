package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class SyncRecordsReq extends BasicBaseReq {
    private String cursor;
    private int dataType;
    private CBSSyncRecordDeviceInfo deviceInfo;
    private String opTimeTag;
    private int queryType;

    public SyncRecordsReq(int i10, CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo, String str) {
        super("GetOperationRecordReq");
        this.queryType = 2;
        this.dataType = i10;
        this.deviceInfo = cBSSyncRecordDeviceInfo;
        this.opTimeTag = str;
    }

    public String getCursor() {
        return this.cursor;
    }

    public int getDataType() {
        return this.dataType;
    }

    public CBSSyncRecordDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public String getOpTimeTag() {
        return this.opTimeTag;
    }

    public int getQueryType() {
        return this.queryType;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setDataType(int i10) {
        this.dataType = i10;
    }

    public void setDeviceInfo(CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo) {
        this.deviceInfo = cBSSyncRecordDeviceInfo;
    }

    public void setOpTimeTag(String str) {
        this.opTimeTag = str;
    }

    public void setQueryType(int i10) {
        this.queryType = i10;
    }

    public SyncRecordsReq(int i10, String str) {
        super("GetOperationRecordReq");
        this.queryType = 2;
        this.dataType = i10;
        this.opTimeTag = str;
    }
}
