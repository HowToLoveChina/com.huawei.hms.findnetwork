package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hicloud.request.basic.bean.VisionDeviceInfo;

/* loaded from: classes2.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() { // from class: com.huawei.android.hicloud.album.service.vo.DeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    };
    private String deviceAliasName;
    private String deviceId;
    private int deviceType;
    private String terminalType;
    private String wiseDevType;
    private String wiseProdId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceAliasName() {
        return this.deviceAliasName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public String getWiseDevType() {
        return this.wiseDevType;
    }

    public String getWiseProdId() {
        return this.wiseProdId;
    }

    public void readFromParcel(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.deviceType = parcel.readInt();
        this.deviceAliasName = parcel.readString();
        this.terminalType = parcel.readString();
        this.wiseDevType = parcel.readString();
        this.wiseProdId = parcel.readString();
    }

    public void setDeviceAliasName(String str) {
        this.deviceAliasName = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public void setWiseDevType(String str) {
        this.wiseDevType = str;
    }

    public void setWiseProdId(String str) {
        this.wiseProdId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceId);
        parcel.writeInt(this.deviceType);
        parcel.writeString(this.deviceAliasName);
        parcel.writeString(this.terminalType);
        parcel.writeString(this.wiseDevType);
        parcel.writeString(this.wiseProdId);
    }

    public DeviceInfo() {
    }

    private DeviceInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public DeviceInfo(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        deviceInfo.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        readFromParcel(parcelObtain);
        parcelObtain.recycle();
    }

    public DeviceInfo(VisionDeviceInfo visionDeviceInfo) {
        this.deviceId = visionDeviceInfo.getDeviceID();
        this.deviceType = visionDeviceInfo.getDeviceType();
        this.deviceAliasName = visionDeviceInfo.getDeviceAliasName();
        this.terminalType = visionDeviceInfo.getTerminalType();
        this.wiseDevType = visionDeviceInfo.getWiseDevType();
        this.wiseProdId = visionDeviceInfo.getWiseProdId();
    }
}
