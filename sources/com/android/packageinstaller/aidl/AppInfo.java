package com.android.packageinstaller.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new C1513a();

    /* renamed from: a */
    public String f6499a;

    /* renamed from: b */
    public int f6500b;

    /* renamed from: c */
    public String f6501c;

    /* renamed from: com.android.packageinstaller.aidl.AppInfo$a */
    public class C1513a implements Parcelable.Creator<AppInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppInfo[] newArray(int i10) {
            return new AppInfo[i10];
        }
    }

    public AppInfo() {
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
        parcel.writeString(this.f6499a);
        parcel.writeInt(this.f6500b);
        parcel.writeString(this.f6501c);
    }

    public AppInfo(String str, int i10) {
        this.f6499a = str;
        this.f6500b = i10;
    }

    public AppInfo(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        this.f6499a = parcel.readString();
        this.f6500b = parcel.readInt();
        this.f6501c = parcel.readString();
    }
}
