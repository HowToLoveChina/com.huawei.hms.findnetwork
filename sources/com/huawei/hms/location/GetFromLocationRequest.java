package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class GetFromLocationRequest implements IMessageEntity {

    @Packed
    private double latitude;

    @Packed
    private double longitude;

    @Packed
    private int maxResults;

    public GetFromLocationRequest(double d10, double d11, int i10) {
        this.latitude = d10;
        this.longitude = d11;
        this.maxResults = i10;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setMaxResults(int i10) {
        this.maxResults = i10;
    }
}
