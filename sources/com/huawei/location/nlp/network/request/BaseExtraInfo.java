package com.huawei.location.nlp.network.request;

import android.location.Location;

/* loaded from: classes8.dex */
public class BaseExtraInfo {
    private Location extraPosition;
    private Integer resultCode;

    public Location getExtraPosition() {
        return this.extraPosition;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public void setExtraPosition(Location location) {
        this.extraPosition = location;
    }

    public void setResultCode(Integer num) {
        this.resultCode = num;
    }
}
