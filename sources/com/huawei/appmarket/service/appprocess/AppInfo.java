package com.huawei.appmarket.service.appprocess;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new C4586a();

    /* renamed from: a */
    public String f21101a;

    /* renamed from: b */
    public String f21102b;

    /* renamed from: c */
    public String f21103c;

    /* renamed from: d */
    public String f21104d;

    /* renamed from: e */
    public String f21105e;

    /* renamed from: f */
    public String f21106f;

    /* renamed from: com.huawei.appmarket.service.appprocess.AppInfo$a */
    public class C4586a implements Parcelable.Creator<AppInfo> {
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

    public AppInfo(Parcel parcel) {
        this.f21101a = parcel.readString();
        this.f21102b = parcel.readString();
        this.f21103c = parcel.readString();
        this.f21104d = parcel.readString();
        this.f21105e = parcel.readString();
        this.f21106f = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "package name: " + this.f21101a + ", app name:" + this.f21102b + ", icon Url:" + this.f21103c + ", app size:" + this.f21104d + ", downloadparam:" + this.f21106f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21101a);
        parcel.writeString(this.f21102b);
        parcel.writeString(this.f21103c);
        parcel.writeString(this.f21104d);
        parcel.writeString(this.f21105e);
        parcel.writeString(this.f21106f);
    }
}
