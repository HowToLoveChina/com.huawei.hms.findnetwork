package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class DeviceDataFrameParcel implements Parcelable {
    public static final Parcelable.Creator<DeviceDataFrameParcel> CREATOR = new C8889a();

    /* renamed from: a */
    public String f45290a;

    /* renamed from: b */
    public String f45291b;

    /* renamed from: c */
    public byte[] f45292c;

    /* renamed from: com.huawei.wearengine.device.DeviceDataFrameParcel$a */
    public class C8889a implements Parcelable.Creator<DeviceDataFrameParcel> {
        @Override // android.os.Parcelable.Creator
        public DeviceDataFrameParcel createFromParcel(Parcel parcel) {
            DeviceDataFrameParcel deviceDataFrameParcel = new DeviceDataFrameParcel();
            if (parcel != null) {
                deviceDataFrameParcel.m56545d(parcel.readString());
                deviceDataFrameParcel.m56543a(parcel.readString());
                deviceDataFrameParcel.m56544c(parcel.createByteArray());
            }
            return deviceDataFrameParcel;
        }

        @Override // android.os.Parcelable.Creator
        public DeviceDataFrameParcel[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new DeviceDataFrameParcel[0] : new DeviceDataFrameParcel[i10];
        }
    }

    /* renamed from: a */
    public void m56543a(String str) {
        this.f45291b = str;
    }

    /* renamed from: c */
    public void m56544c(byte[] bArr) {
        if (bArr != null) {
            this.f45292c = (byte[]) bArr.clone();
        } else {
            this.f45292c = null;
        }
    }

    /* renamed from: d */
    public void m56545d(String str) {
        this.f45290a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.f45290a);
        parcel.writeString(this.f45291b);
        parcel.writeByteArray(this.f45292c);
    }
}
