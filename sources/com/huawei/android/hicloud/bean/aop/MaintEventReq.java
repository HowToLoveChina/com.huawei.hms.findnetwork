package com.huawei.android.hicloud.bean.aop;

/* loaded from: classes2.dex */
public class MaintEventReq {
    private String activityId;
    private String businessTraceId;
    private int errorCode;
    private String errorMsg;
    private String eventExt;
    private String eventId;

    public String getActivityId() {
        return this.activityId;
    }

    public String getBusinessTraceId() {
        return this.businessTraceId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getEventExt() {
        return this.eventExt;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setBusinessTraceId(String str) {
        this.businessTraceId = str;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setEventExt(String str) {
        this.eventExt = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }
}
