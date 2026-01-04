package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class IdentityInfo implements Parcelable {
    public static final Parcelable.Creator<IdentityInfo> CREATOR = new C8896a();

    /* renamed from: a */
    public String f45329a;

    /* renamed from: b */
    public String f45330b;

    /* renamed from: com.huawei.wearengine.p2p.IdentityInfo$a */
    public class C8896a implements Parcelable.Creator<IdentityInfo> {
        @Override // android.os.Parcelable.Creator
        public IdentityInfo createFromParcel(Parcel parcel) {
            IdentityInfo identityInfo = new IdentityInfo();
            if (parcel != null) {
                identityInfo.m56563c(parcel.readString());
                identityInfo.m56562a(parcel.readString());
            }
            return identityInfo;
        }

        @Override // android.os.Parcelable.Creator
        public IdentityInfo[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new IdentityInfo[0] : new IdentityInfo[i10];
        }
    }

    public IdentityInfo() {
        this(null, null);
    }

    /* renamed from: a */
    public void m56562a(String str) {
        this.f45330b = str;
    }

    /* renamed from: c */
    public void m56563c(String str) {
        this.f45329a = str;
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
        parcel.writeString(this.f45329a);
        parcel.writeString(this.f45330b);
    }

    public IdentityInfo(String str, String str2) {
        this.f45329a = str;
        this.f45330b = str2;
    }
}
