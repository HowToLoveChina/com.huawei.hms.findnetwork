package com.hihonor.android.powerkit.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AppCycleUsedInfo implements Parcelable {
    public static final Parcelable.Creator<AppCycleUsedInfo> CREATOR = new C2084a();

    /* renamed from: a */
    public String f9451a;

    /* renamed from: b */
    public long f9452b;

    /* renamed from: c */
    public int f9453c;

    /* renamed from: com.hihonor.android.powerkit.adapter.AppCycleUsedInfo$a */
    public class C2084a implements Parcelable.Creator<AppCycleUsedInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppCycleUsedInfo createFromParcel(Parcel parcel) {
            return new AppCycleUsedInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCycleUsedInfo[] newArray(int i10) {
            return new AppCycleUsedInfo[i10];
        }
    }

    public AppCycleUsedInfo(Parcel parcel) {
        this.f9452b = 0L;
        this.f9453c = 0;
        this.f9451a = parcel.readString();
        this.f9452b = parcel.readLong();
        this.f9453c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9451a);
        parcel.writeLong(this.f9452b);
        parcel.writeInt(this.f9453c);
    }
}
