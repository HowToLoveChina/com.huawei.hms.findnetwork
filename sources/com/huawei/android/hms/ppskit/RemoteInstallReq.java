package com.huawei.android.hms.ppskit;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class RemoteInstallReq implements Parcelable {
    public static final Parcelable.Creator<RemoteInstallReq> CREATOR = new C4309a();

    /* renamed from: a */
    public String f19681a;

    /* renamed from: b */
    public String f19682b;

    /* renamed from: c */
    public String f19683c;

    /* renamed from: d */
    public String f19684d;

    /* renamed from: e */
    public String f19685e;

    /* renamed from: f */
    public int f19686f;

    /* renamed from: com.huawei.android.hms.ppskit.RemoteInstallReq$a */
    public static class C4309a implements Parcelable.Creator<RemoteInstallReq> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteInstallReq createFromParcel(Parcel parcel) {
            return new RemoteInstallReq(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RemoteInstallReq[] newArray(int i10) {
            return new RemoteInstallReq[i10];
        }
    }

    public RemoteInstallReq() {
    }

    public RemoteInstallReq(Parcel parcel) {
        m25927a(parcel);
    }

    /* renamed from: a */
    public final void m25927a(Parcel parcel) {
        this.f19681a = parcel.readString();
        this.f19682b = parcel.readString();
        this.f19683c = parcel.readString();
        this.f19684d = parcel.readString();
        this.f19685e = parcel.readString();
        this.f19686f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19681a);
        parcel.writeString(this.f19682b);
        parcel.writeString(this.f19683c);
        parcel.writeString(this.f19684d);
        parcel.writeString(this.f19685e);
        parcel.writeInt(this.f19686f);
    }

    public RemoteInstallReq(String str, String str2, String str3, String str4, String str5, int i10) {
        this.f19681a = str;
        this.f19682b = str2;
        this.f19683c = str3;
        this.f19684d = str4;
        this.f19685e = str5;
        this.f19686f = i10;
    }
}
