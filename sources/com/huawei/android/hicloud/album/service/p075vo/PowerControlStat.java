package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class PowerControlStat implements Parcelable {
    public static final Parcelable.Creator<PowerControlStat> CREATOR = new Parcelable.Creator<PowerControlStat>() { // from class: com.huawei.android.hicloud.album.service.vo.PowerControlStat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PowerControlStat createFromParcel(Parcel parcel) {
            return new PowerControlStat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PowerControlStat[] newArray(int i10) {
            return new PowerControlStat[i10];
        }
    };
    private long availablePower;
    private int availableTime;
    private int batteryStatus;
    private long exemptionPower;
    private String gradeCode;
    private int isCloudPowerControl;
    private int needControl;
    private int netType;
    private String reportReason;
    private int uploadTime;
    private long powerOverTime = 0;
    private long power = 0;
    private long wifiSize = 0;
    private long mobileSize = 0;
    private int controlType = 0;
    private double discountWifi = 0.4d;
    private double discountMobile = 1.0d;

    public PowerControlStat() {
    }

    private void readFromParcel(Parcel parcel) {
        this.powerOverTime = parcel.readLong();
        this.power = parcel.readLong();
        this.wifiSize = parcel.readLong();
        this.mobileSize = parcel.readLong();
        this.discountWifi = parcel.readDouble();
        this.discountMobile = parcel.readDouble();
        this.controlType = parcel.readInt();
        this.isCloudPowerControl = parcel.readInt();
        this.needControl = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAvailablePower() {
        return this.availablePower;
    }

    public int getAvailableTime() {
        return this.availableTime;
    }

    public int getBatteryStatus() {
        return this.batteryStatus;
    }

    public int getControlType() {
        return this.controlType;
    }

    public double getDiscountMobile() {
        return this.discountMobile;
    }

    public double getDiscountWifi() {
        return this.discountWifi;
    }

    public long getExemptionPower() {
        return this.exemptionPower;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public long getMobileSize() {
        return this.mobileSize;
    }

    public int getNetType() {
        return this.netType;
    }

    public long getPower() {
        return this.power;
    }

    public long getPowerOverTime() {
        return this.powerOverTime;
    }

    public String getReportReason() {
        return this.reportReason;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public long getWifiSize() {
        return this.wifiSize;
    }

    public int isCloudPowerControl() {
        return this.isCloudPowerControl;
    }

    public int isNeedControl() {
        return this.needControl;
    }

    public void setAvailablePower(long j10) {
        this.availablePower = j10;
    }

    public void setAvailableTime(int i10) {
        this.availableTime = i10;
    }

    public void setBatteryStatus(int i10) {
        this.batteryStatus = i10;
    }

    public void setCloudPowerControl(int i10) {
        this.isCloudPowerControl = i10;
    }

    public void setControlType(int i10) {
        this.controlType = i10;
    }

    public void setDiscountMobile(double d10) {
        this.discountMobile = d10;
    }

    public void setDiscountWifi(double d10) {
        this.discountWifi = d10;
    }

    public void setExemptionPower(long j10) {
        this.exemptionPower = j10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setMobileSize(long j10) {
        this.mobileSize = j10;
    }

    public void setNeedControl(int i10) {
        this.needControl = i10;
    }

    public void setNetType(int i10) {
        this.netType = i10;
    }

    public void setPower(long j10) {
        this.power = j10;
    }

    public void setPowerOverTime(long j10) {
        this.powerOverTime = j10;
    }

    public void setReportReason(String str) {
        this.reportReason = str;
    }

    public void setUploadTime(int i10) {
        this.uploadTime = i10;
    }

    public void setWifiSize(long j10) {
        this.wifiSize = j10;
    }

    public String toString() {
        return "Stat{powerOverTime=" + this.powerOverTime + ", power=" + this.power + ", wifiSize=" + this.wifiSize + ", mobileSize=" + this.mobileSize + ", discountWifi=" + this.discountWifi + ", discountMobile=" + this.discountMobile + ", controlType=" + this.controlType + ", isCloudPowerControl=" + this.isCloudPowerControl + ", needControl=" + this.needControl + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.powerOverTime);
        parcel.writeLong(this.power);
        parcel.writeLong(this.wifiSize);
        parcel.writeLong(this.mobileSize);
        parcel.writeDouble(this.discountWifi);
        parcel.writeDouble(this.discountMobile);
        parcel.writeInt(this.controlType);
        parcel.writeInt(this.isCloudPowerControl);
        parcel.writeInt(this.needControl);
    }

    public PowerControlStat(Parcel parcel) {
        readFromParcel(parcel);
    }
}
