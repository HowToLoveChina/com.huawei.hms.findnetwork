package com.huawei.android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public class HwFindDevice implements Parcelable {
    public static final Parcelable.Creator<HwFindDevice> CREATOR = new C2159a();
    private static final String TAG = "HwFindDevice";
    private String mConnectivity;
    private String mDeviceBtMac;
    private String mDeviceId;
    private String mHbkP;
    private String mIrk;

    /* renamed from: com.huawei.android.bluetooth.HwFindDevice$a */
    public class C2159a implements Parcelable.Creator<HwFindDevice> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HwFindDevice createFromParcel(Parcel parcel) {
            return new HwFindDevice(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HwFindDevice[] newArray(int i10) {
            return new HwFindDevice[i10];
        }
    }

    public /* synthetic */ HwFindDevice(Parcel parcel, C2159a c2159a) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HwFindDevice) {
            return Objects.equals(this.mDeviceBtMac, ((HwFindDevice) obj).getDeviceBtMac());
        }
        return false;
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

    public String getHbkP() {
        return this.mHbkP;
    }

    public String getIrk() {
        return this.mIrk;
    }

    public int hashCode() {
        String str = this.mDeviceBtMac;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public void setConnectivity(String str) {
        this.mConnectivity = str;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setHbkP(String str) {
        this.mHbkP = str;
    }

    public void setIrk(String str) {
        this.mIrk = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mDeviceBtMac);
        parcel.writeString(this.mDeviceId);
        parcel.writeString(this.mConnectivity);
        parcel.writeString(this.mIrk);
        parcel.writeString(this.mHbkP);
    }

    private HwFindDevice(Parcel parcel) {
        this.mDeviceBtMac = parcel.readString();
        this.mDeviceId = parcel.readString();
        this.mConnectivity = parcel.readString();
        this.mIrk = parcel.readString();
        this.mHbkP = parcel.readString();
    }

    public HwFindDevice(String str) {
        this.mDeviceBtMac = str;
    }
}
