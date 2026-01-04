package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class ScanFilterParcel implements Parcelable {
    public static final Parcelable.Creator<ScanFilterParcel> CREATOR = new C8890a();

    /* renamed from: a */
    public int f45293a;

    /* renamed from: b */
    public String f45294b;

    /* renamed from: com.huawei.wearengine.device.ScanFilterParcel$a */
    public class C8890a implements Parcelable.Creator<ScanFilterParcel> {
        @Override // android.os.Parcelable.Creator
        public ScanFilterParcel createFromParcel(Parcel parcel) {
            ScanFilterParcel scanFilterParcel = new ScanFilterParcel();
            if (parcel != null) {
                scanFilterParcel.m56547c(parcel.readInt());
                scanFilterParcel.m56546a(parcel.readString());
            }
            return scanFilterParcel;
        }

        @Override // android.os.Parcelable.Creator
        public ScanFilterParcel[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new ScanFilterParcel[0] : new ScanFilterParcel[i10];
        }
    }

    /* renamed from: a */
    public void m56546a(String str) {
        this.f45294b = str;
    }

    /* renamed from: c */
    public void m56547c(int i10) {
        this.f45293a = i10;
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
        parcel.writeString(this.f45294b);
        parcel.writeInt(this.f45293a);
    }
}
