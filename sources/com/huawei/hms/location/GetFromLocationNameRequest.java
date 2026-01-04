package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class GetFromLocationNameRequest implements IMessageEntity {

    @Packed
    private String locationName;

    @Packed
    private double lowerLeftLatitude;

    @Packed
    private double lowerLeftLongitude;

    @Packed
    private int maxResults;

    @Packed
    private double upperRightLatitude;

    @Packed
    private double upperRightLongitude;

    public GetFromLocationNameRequest(String str, int i10) {
        this.locationName = str;
        this.maxResults = i10;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLowerLeftLatitude() {
        return this.lowerLeftLatitude;
    }

    public double getLowerLeftLongitude() {
        return this.lowerLeftLongitude;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public double getUpperRightLatitude() {
        return this.upperRightLatitude;
    }

    public double getUpperRightLongitude() {
        return this.upperRightLongitude;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLowerLeftLatitude(double d10) {
        this.lowerLeftLatitude = d10;
    }

    public void setLowerLeftLongitude(double d10) {
        this.lowerLeftLongitude = d10;
    }

    public void setMaxResults(int i10) {
        this.maxResults = i10;
    }

    public void setUpperRightLatitude(double d10) {
        this.upperRightLatitude = d10;
    }

    public void setUpperRightLongitude(double d10) {
        this.upperRightLongitude = d10;
    }

    public GetFromLocationNameRequest(String str, int i10, double d10, double d11, double d12, double d13) {
        this.locationName = str;
        this.maxResults = i10;
        this.lowerLeftLatitude = d10;
        this.lowerLeftLongitude = d11;
        this.upperRightLatitude = d12;
        this.upperRightLongitude = d13;
    }
}
