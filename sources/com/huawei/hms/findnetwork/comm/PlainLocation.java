package com.huawei.hms.findnetwork.comm;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.findnetwork.comm.request.bean.poiinfo.PoiInfo;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class PlainLocation {

    @SerializedName("accuracy")
    public float accuracy;

    @SerializedName("bearing")
    private float bearing;

    @SerializedName(JsbMapKeyNames.H5_LOC_LAT)
    public double latitude;

    @SerializedName(JsbMapKeyNames.H5_LOC_LON)
    public double longitude;

    @SerializedName("speed")
    private double speed;

    @SerializedName("status")
    public int status;

    @SerializedName("buildingId")
    private String buildingId = "";

    @SerializedName("floor")
    private int floor = -100;

    @SerializedName("floorAcc")
    private int floorAcc = 0;

    @SerializedName("indoor")
    private int indoor = 0;

    @SerializedName("floorInfo")
    private String floorInfo = "";

    @SerializedName("sessionId")
    private String sessionId = "";

    @SerializedName("poiInfoList")
    private List<PoiInfo> poiInfoList = new ArrayList();

    public float getAccuracy() {
        return this.accuracy;
    }

    public float getBearing() {
        return this.bearing;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getFloorAcc() {
        return this.floorAcc;
    }

    public String getFloorInfo() {
        return this.floorInfo;
    }

    public int getIndoor() {
        return this.indoor;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public List<PoiInfo> getPoiInfoList() {
        return this.poiInfoList;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setBearing(float f10) {
        this.bearing = f10;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setFloor(int i10) {
        this.floor = i10;
    }

    public void setFloorAcc(int i10) {
        this.floorAcc = i10;
    }

    public void setFloorInfo(String str) {
        this.floorInfo = str;
    }

    public void setIndoor(int i10) {
        this.indoor = i10;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setPoiInfoList(List<PoiInfo> list) {
        this.poiInfoList = list;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSpeed(double d10) {
        this.speed = d10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
