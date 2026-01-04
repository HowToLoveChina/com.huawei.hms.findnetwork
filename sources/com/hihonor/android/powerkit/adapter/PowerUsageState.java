package com.hihonor.android.powerkit.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PowerUsageState implements Parcelable {
    public static final Parcelable.Creator<PowerUsageState> CREATOR = new C2087a();

    /* renamed from: a */
    public String f9456a;

    /* renamed from: b */
    public long f9457b;

    /* renamed from: c */
    public long f9458c;

    /* renamed from: d */
    public long f9459d;

    /* renamed from: e */
    public long f9460e;

    /* renamed from: com.hihonor.android.powerkit.adapter.PowerUsageState$a */
    public class C2087a implements Parcelable.Creator<PowerUsageState> {
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
        this.f9456a = parcel.readString();
        this.f9457b = parcel.readLong();
        this.f9458c = parcel.readLong();
        this.f9459d = parcel.readLong();
        this.f9460e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "name: " + this.f9456a + "\" mFgTime: " + this.f9457b + "\" mFgTotalPower:" + this.f9459d + "\" mBgTime: " + this.f9458c + "\" mBgTotalPower:" + this.f9460e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9456a);
        parcel.writeLong(this.f9457b);
        parcel.writeLong(this.f9458c);
        parcel.writeLong(this.f9459d);
        parcel.writeLong(this.f9460e);
    }
}
