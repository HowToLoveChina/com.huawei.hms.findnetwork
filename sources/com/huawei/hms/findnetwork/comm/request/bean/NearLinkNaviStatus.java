package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public enum NearLinkNaviStatus {
    INIT_SUCCEED(0),
    REQUEST_AR_POSE(1),
    ON_RANGE_RESULT(2),
    ENABLE_FINDER_SUCCEED(3);

    private int status;

    NearLinkNaviStatus(int i10) {
        this.status = i10;
    }

    public int getType() {
        return this.status;
    }
}
