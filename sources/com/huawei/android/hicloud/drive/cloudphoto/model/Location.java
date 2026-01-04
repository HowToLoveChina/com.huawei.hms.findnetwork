package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Location extends C11707b {

    @InterfaceC4648p
    private Double altitude;

    @InterfaceC4648p
    private Double latitude;

    @InterfaceC4648p
    private Double longitude;

    public Double getAltitude() {
        return this.altitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setAltitude(Double d10) {
        this.altitude = d10;
    }

    public void setLatitude(Double d10) {
        this.latitude = d10;
    }

    public void setLongitude(Double d10) {
        this.longitude = d10;
    }
}
