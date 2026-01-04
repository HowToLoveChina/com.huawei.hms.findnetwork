package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class ReportArgsStr {

    @SerializedName("eventReq")
    private MaintEventReq eventReq;

    public MaintEventReq getEventReq() {
        return this.eventReq;
    }

    public void setEventReq(MaintEventReq maintEventReq) {
        this.eventReq = maintEventReq;
    }
}
