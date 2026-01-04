package com.huawei.hms.support.api.entity.location.geocoder;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class GeocoderRequest extends LocationBaseRequest {

    @Packed
    private String country;

    @Packed
    private String language;

    @Packed
    private double latitude;

    @Packed
    private String locationName;

    @Packed
    private double longitude;

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

    public GeocoderRequest(Context context, double d10, double d11, int i10) {
        super(context);
        this.latitude = d10;
        this.longitude = d11;
        this.maxResults = i10;
    }

    public String getCountry() {
        return this.country;
    }

    public String getLanguage() {
        return this.language;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLongitude() {
        return this.longitude;
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

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
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

    public GeocoderRequest(Context context, String str, int i10) {
        super(context);
        this.locationName = str;
        this.maxResults = i10;
    }
}
