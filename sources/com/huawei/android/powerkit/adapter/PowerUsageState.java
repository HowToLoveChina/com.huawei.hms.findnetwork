package com.huawei.android.powerkit.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PowerUsageState implements Parcelable {
    public static final Parcelable.Creator<PowerUsageState> CREATOR = new C4318a();

    /* renamed from: a */
    public String f19701a;

    /* renamed from: b */
    public long f19702b;

    /* renamed from: c */
    public long f19703c;

    /* renamed from: d */
    public long f19704d;

    /* renamed from: e */
    public long f19705e;

    /* renamed from: com.huawei.android.powerkit.adapter.PowerUsageState$a */
    public static class C4318a implements Parcelable.Creator<PowerUsageState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PowerUsageState createFromParcel(Parcel parcel) {
            return new PowerUsageState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PowerUsageState[] newArray(int i10) {
            return new PowerUsageState[i10];
        }
    }

    public PowerUsageState(Parcel parcel) {
        this.f19701a = parcel.readString();
        this.f19702b = parcel.readLong();
        this.f19703c = parcel.readLong();
        this.f19704d = parcel.readLong();
        this.f19705e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "name: " + this.f19701a + "\" mFgTime: " + this.f19702b + "\" mFgTotalPower:" + this.f19704d + "\" mBgTime: " + this.f19703c + "\" mBgTotalPower:" + this.f19705e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19701a);
        parcel.writeLong(this.f19702b);
        parcel.writeLong(this.f19703c);
        parcel.writeLong(this.f19704d);
        parcel.writeLong(this.f19705e);
    }
}
