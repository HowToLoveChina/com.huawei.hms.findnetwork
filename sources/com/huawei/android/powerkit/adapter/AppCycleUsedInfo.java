package com.huawei.android.powerkit.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AppCycleUsedInfo implements Parcelable {
    public static final Parcelable.Creator<AppCycleUsedInfo> CREATOR = new C4315a();

    /* renamed from: a */
    public String f19697a;

    /* renamed from: b */
    public long f19698b;

    /* renamed from: c */
    public int f19699c;

    /* renamed from: com.huawei.android.powerkit.adapter.AppCycleUsedInfo$a */
    public static class C4315a implements Parcelable.Creator<AppCycleUsedInfo> {
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
        this.f19698b = 0L;
        this.f19699c = 0;
        this.f19697a = parcel.readString();
        this.f19698b = parcel.readLong();
        this.f19699c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19697a);
        parcel.writeLong(this.f19698b);
        parcel.writeInt(this.f19699c);
    }
}
