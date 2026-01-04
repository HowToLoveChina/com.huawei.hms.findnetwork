package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class PostOpDescReq extends BasicBaseReq {
    private long eventTime;
    private boolean isStored;
    private String opDesc;

    public PostOpDescReq() {
        super("opDesc");
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getOpDesc() {
        return this.opDesc;
    }

    public boolean isStored() {
        return this.isStored;
    }

    public void setEventTime(long j10) {
        this.eventTime = j10;
    }

    public void setOpDesc(String str) {
        this.opDesc = str;
    }

    public void setStored(boolean z10) {
        this.isStored = z10;
    }
}
