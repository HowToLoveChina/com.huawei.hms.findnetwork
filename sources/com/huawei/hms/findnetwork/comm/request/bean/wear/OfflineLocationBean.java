package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.result.StandbyDeviceResult;
import com.huawei.hms.findnetwork.comm.util.CollectionUtil;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.comm.util.VerifyUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class OfflineLocationBean {
    public static final int CLOUD_DISCONNECT_LOCATION = 3;
    public static final int LOCAL_DISCONNECT_LOCATION = 4;
    public static final int LOCAL_USER_QUERY_LOCATION = 5;
    public static final int NULL_LOCATION = 0;
    public static final int OFFLINE_LOCATION = 1;
    public static final int STANDBY_LOCATION = 6;
    public static final int USER_QUERY_LOCATION = 2;
    private String aaid;
    private float accuracy;
    private String batteryDescription;
    private int batteryLevel;
    private String buildingId;
    private long disconnectTime;
    private String fid;
    private int floor;
    private int floorAcc;
    private String floorInfo;
    private long foundTime;
    private int indoor;
    private double latitude;
    private double longitude;
    private int mCloudLocationType;
    private String mStandbyDevice;
    private String publicKeyHash;
    private long queryTime;
    private int status;
    private int totalCount;

    public OfflineLocationBean() {
        this.floor = -100;
        this.buildingId = "";
        this.floorInfo = "";
        this.indoor = 0;
        this.floorAcc = 0;
        this.mCloudLocationType = 0;
    }

    public String getAaid() {
        return this.aaid;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getBatteryDescription() {
        return this.batteryDescription;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public int getCloudLocationType() {
        return this.mCloudLocationType;
    }

    public long getDisconnectTime() {
        return this.disconnectTime;
    }

    public String getFid() {
        return this.fid;
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

    public long getFoundTime() {
        return this.foundTime;
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

    public String getMaskedStandbyDevice() {
        ArrayList arrayList = new ArrayList();
        List<StandbyDeviceResult> objectList = JsonUtils.getObjectList(this.mStandbyDevice, StandbyDeviceResult.class);
        if (CollectionUtil.isEmpty(objectList)) {
            return JsonUtils.object2Json(arrayList);
        }
        for (StandbyDeviceResult standbyDeviceResult : objectList) {
            arrayList.add("sequence=" + standbyDeviceResult.getSequence() + ", fid=" + MaskUtil.maskSn(standbyDeviceResult.getFid()) + ", status=" + standbyDeviceResult.getStatus());
        }
        return JsonUtils.object2Json(arrayList);
    }

    public String getPublicKeyHash() {
        return this.publicKeyHash;
    }

    public long getQueryTime() {
        return this.queryTime;
    }

    public String getStandbyDevice() {
        return this.mStandbyDevice;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setAaid(String str) {
        this.aaid = str;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setBatteryDescription(String str) {
        this.batteryDescription = str;
    }

    public void setBatteryLevel(int i10) {
        this.batteryLevel = i10;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setCloudLocationType(int i10) {
        this.mCloudLocationType = i10;
    }

    public void setDisconnectTime(long j10) {
        this.disconnectTime = j10;
    }

    public void setFid(String str) {
        this.fid = str;
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

    public void setFoundTime(long j10) {
        this.foundTime = j10;
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

    public void setPublicKeyHash(String str) {
        this.publicKeyHash = str;
    }

    public void setQueryTime(long j10) {
        this.queryTime = j10;
    }

    public void setStandbyDevice(String str) {
        this.mStandbyDevice = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setTotalCount(int i10) {
        this.totalCount = i10;
    }

    public String toString() {
        return "OfflineLocationBean{fid='" + MaskUtil.maskSn(this.fid) + "', accuracy=" + this.accuracy + ", hasFloor= " + VerifyUtil.verifyFloor(this.floor) + ", indoor=" + this.indoor + ", foundTime=" + this.foundTime + ", status=" + this.status + ", queryTime=" + this.queryTime + ", disconnectTime=" + this.disconnectTime + ", mCloudLocationType=" + this.mCloudLocationType + ", batteryLevel=" + this.batteryLevel + ", batteryDescription='" + this.batteryDescription + ", aaid='" + MaskUtil.maskCommon(this.aaid) + "', standbyDevice=" + getMaskedStandbyDevice() + '}';
    }

    public OfflineLocationBean(String str, double d10, double d11, int i10, String str2, float f10, long j10, int i11, int i12, String str3, int i13, int i14) {
        this.fid = str;
        this.longitude = d10;
        this.latitude = d11;
        this.floor = i10;
        this.buildingId = str2;
        this.accuracy = f10;
        this.foundTime = j10;
        this.status = i11;
        this.mCloudLocationType = i12;
        this.floorInfo = str3;
        this.indoor = i13;
        this.floorAcc = i14;
    }
}
