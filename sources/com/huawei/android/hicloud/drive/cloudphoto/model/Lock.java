package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Lock extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private Integer lockInterval;

    @InterfaceC4648p("x-hw-lock")
    private String sessionId;

    public String getCategory() {
        return this.category;
    }

    public Integer getLockInterval() {
        return this.lockInterval;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setLockInterval(Integer num) {
        this.lockInterval = num;
    }

    public void setSessionID(String str) {
        this.sessionId = str;
    }
}
