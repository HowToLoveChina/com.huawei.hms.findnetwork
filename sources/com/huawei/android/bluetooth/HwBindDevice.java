package com.huawei.android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public class HwBindDevice implements Parcelable {
    public static final Parcelable.Creator<HwBindDevice> CREATOR = new C2158a();
    private static final String TAG = "HwBindDevice";
    private String mBellType;
    private String mConnectivity;
    private String mDeviceBtMac;
    private String mDeviceId;
    private String mDeviceName;
    private String mDeviceType;
    private String mFindCapability;
    private String mFindSupport;
    private String mHbkP;
    private String mIrk;
    private String mModelId;
    private String mSubDeviceType;
    private String mSubModelId;
    private String mTimeStamp;
    private String mWearDetect;

    /* renamed from: com.huawei.android.bluetooth.HwBindDevice$a */
    public class C2158a implements Parcelable.Creator<HwBindDevice> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HwBindDevice createFromParcel(Parcel parcel) {
            return new HwBindDevice(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HwBindDevice[] newArray(int i10) {
            return new HwBindDevice[i10];
        }
    }

    public /* synthetic */ HwBindDevice(Parcel parcel, C2158a c2158a) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HwBindDevice) {
            return Objects.equals(this.mDeviceBtMac, ((HwBindDevice) obj).getDeviceBtMac());
        }
        return false;
    }

    public String getBellType() {
        return this.mBellType;
    }

    public String getConnectivity() {
        return this.mConnectivity;
    }

    public String getDeviceBtMac() {
        return this.mDeviceBtMac;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getDeviceType() {
        return this.mDeviceType;
    }

    public String getFindCapability() {
        return this.mFindCapability;
    }

    public String getFindSupport() {
        return this.mFindSupport;
    }

    public String getHbkP() {
        return this.mHbkP;
    }

    public String getIrk() {
        return this.mIrk;
    }

    public String getModelId() {
        return this.mModelId;
    }

    public String getSubDeviceType() {
        return this.mSubDeviceType;
    }

    public String getSubModelId() {
        return this.mSubModelId;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getWearDetect() {
        return this.mWearDetect;
    }

    public int hashCode() {
        String str = this.mDeviceBtMac;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public void setBellType(String str) {
        this.mBellType = str;
    }

    public void setConnectivity(String str) {
        this.mConnectivity = str;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public void setDeviceType(String str) {
        this.mDeviceType = str;
    }

    public void setFindCapability(String str) {
        this.mFindCapability = str;
    }

    public void setFindSupport(String str) {
        this.mFindSupport = str;
    }

    public void setHbkP(String str) {
        this.mHbkP = str;
    }

    public void setIrk(String str) {
        this.mIrk = str;
    }

    public void setModelId(String str) {
        this.mModelId = str;
    }

    public void setSubDeviceType(String str) {
        this.mSubDeviceType = str;
    }

    public void setSubModelId(String str) {
        this.mSubModelId = str;
    }

    public void setTimeStamp(String str) {
        this.mTimeStamp = str;
    }

    public void setWearDetect(String str) {
        this.mWearDetect = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mDeviceBtMac);
        parcel.writeString(this.mDeviceId);
        parcel.writeString(this.mDeviceType);
        parcel.writeString(this.mModelId);
        parcel.writeString(this.mSubModelId);
        parcel.writeString(this.mDeviceName);
        parcel.writeString(this.mSubDeviceType);
        parcel.writeString(this.mWearDetect);
        parcel.writeString(this.mFindSupport);
        parcel.writeString(this.mFindCapability);
        parcel.writeString(this.mBellType);
        parcel.writeString(this.mConnectivity);
        parcel.writeString(this.mIrk);
        parcel.writeString(this.mHbkP);
    }

    private HwBindDevice(Parcel parcel) {
        this.mDeviceBtMac = parcel.readString();
        this.mDeviceId = parcel.readString();
        this.mDeviceType = parcel.readString();
        this.mModelId = parcel.readString();
        this.mSubModelId = parcel.readString();
        this.mDeviceName = parcel.readString();
        this.mSubDeviceType = parcel.readString();
        this.mTimeStamp = parcel.readString();
        this.mWearDetect = parcel.readString();
        this.mFindSupport = parcel.readString();
        this.mFindCapability = parcel.readString();
        this.mBellType = parcel.readString();
        this.mConnectivity = parcel.readString();
        this.mIrk = parcel.readString();
        this.mHbkP = parcel.readString();
    }

    public HwBindDevice(String str) {
        this.mDeviceBtMac = str;
    }
}
