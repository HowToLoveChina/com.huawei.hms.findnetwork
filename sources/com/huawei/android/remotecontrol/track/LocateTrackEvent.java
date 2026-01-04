package com.huawei.android.remotecontrol.track;

import android.content.ContentValues;
import android.content.Context;
import p013ah.C0198c;

/* loaded from: classes4.dex */
public class LocateTrackEvent {
    private String floor;
    private String floorAcc;
    private boolean isUpdate;
    private String locCpTransId;
    private String locFenceTime;
    private String locSessionId;
    private int locationRouter;
    private int locationTime;
    private String trackAccuracy;
    private String trackCapabilityIslockscreen;
    private String trackLatitude;
    private String trackLatitudeWGS;
    private String trackLocateType;
    private String trackLongtitude;
    private String trackLongtitudeWGS;
    private String trackMaptype;
    private long trackUTC;

    public void cap2ContentValues(Context context, ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("track_lontitude", C0198c.m1098b(context, this.trackLongtitude));
        contentValues.put("track_latitude", C0198c.m1098b(context, this.trackLatitude));
        contentValues.put("track_lontitudeWGS", C0198c.m1098b(context, this.trackLongtitudeWGS));
        contentValues.put("track_latitudeWGS", C0198c.m1098b(context, this.trackLatitudeWGS));
        contentValues.put("track_accuracy", C0198c.m1098b(context, this.trackAccuracy));
        contentValues.put("track_map_type", C0198c.m1098b(context, this.trackMaptype));
        contentValues.put("track_capability_islockscreen", C0198c.m1098b(context, this.trackCapabilityIslockscreen));
        contentValues.put("track_locate_type", C0198c.m1098b(context, this.trackLocateType));
        contentValues.put("track_locate_isupdate", String.valueOf(this.isUpdate));
        contentValues.put("track_utc_time", Long.valueOf(this.trackUTC));
    }

    public String getFloor() {
        return this.floor;
    }

    public String getFloorAcc() {
        return this.floorAcc;
    }

    public String getLocCpTransId() {
        return this.locCpTransId;
    }

    public String getLocFenceTime() {
        return this.locFenceTime;
    }

    public String getLocSessionId() {
        return this.locSessionId;
    }

    public int getLocationRouter() {
        return this.locationRouter;
    }

    public int getLocationTime() {
        return this.locationTime;
    }

    public String getTrackAccuracy() {
        return this.trackAccuracy;
    }

    public String getTrackCapabilityIslockscreen() {
        return this.trackCapabilityIslockscreen;
    }

    public String getTrackLatitude() {
        return this.trackLatitude;
    }

    public String getTrackLatitudeWGS() {
        return this.trackLatitudeWGS;
    }

    public String getTrackLocateType() {
        return this.trackLocateType;
    }

    public String getTrackLongtitude() {
        return this.trackLongtitude;
    }

    public String getTrackLongtitudeWGS() {
        return this.trackLongtitudeWGS;
    }

    public String getTrackMaptype() {
        return this.trackMaptype;
    }

    public long getTrackUTC() {
        return this.trackUTC;
    }

    public boolean isUpdate() {
        return this.isUpdate;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setFloorAcc(String str) {
        this.floorAcc = str;
    }

    public void setLocCpTransId(String str) {
        this.locCpTransId = str;
    }

    public void setLocFenceTime(String str) {
        this.locFenceTime = str;
    }

    public void setLocSessionId(String str) {
        this.locSessionId = str;
    }

    public void setLocationRouter(int i10) {
        this.locationRouter = i10;
    }

    public void setLocationTime(int i10) {
        this.locationTime = i10;
    }

    public void setTrackAccuracy(String str) {
        this.trackAccuracy = str;
    }

    public void setTrackCapabilityIslockscreen(String str) {
        this.trackCapabilityIslockscreen = str;
    }

    public void setTrackLatitude(String str) {
        this.trackLatitude = str;
    }

    public void setTrackLatitudeWGS(String str) {
        this.trackLatitudeWGS = str;
    }

    public void setTrackLocateType(String str) {
        this.trackLocateType = str;
    }

    public void setTrackLongtitude(String str) {
        this.trackLongtitude = str;
    }

    public void setTrackLongtitudeWGS(String str) {
        this.trackLongtitudeWGS = str;
    }

    public void setTrackMaptype(String str) {
        this.trackMaptype = str;
    }

    public void setTrackUTC(long j10) {
        this.trackUTC = j10;
    }

    public void setUpdate(boolean z10) {
        this.isUpdate = z10;
    }
}
