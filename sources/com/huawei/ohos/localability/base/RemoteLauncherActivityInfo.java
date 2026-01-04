package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class RemoteLauncherActivityInfo implements Parcelable {
    public static final Parcelable.Creator<RemoteLauncherActivityInfo> CREATOR = new C6843a();

    /* renamed from: a */
    public String f31521a;

    /* renamed from: b */
    public String f31522b;

    /* renamed from: c */
    public int[] f31523c;

    /* renamed from: d */
    public String f31524d;

    /* renamed from: e */
    public String f31525e;

    /* renamed from: com.huawei.ohos.localability.base.RemoteLauncherActivityInfo$a */
    public class C6843a implements Parcelable.Creator<RemoteLauncherActivityInfo> {
        @Override // android.os.Parcelable.Creator
        public RemoteLauncherActivityInfo createFromParcel(Parcel parcel) {
            return new RemoteLauncherActivityInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public RemoteLauncherActivityInfo[] newArray(int i10) {
            if (i10 >= 0) {
                return new RemoteLauncherActivityInfo[i10];
            }
            return null;
        }
    }

    public /* synthetic */ RemoteLauncherActivityInfo(Parcel parcel, C6843a c6843a) {
        this.f31521a = parcel.readString();
        this.f31522b = parcel.readString();
        this.f31523c = parcel.createIntArray();
        this.f31524d = parcel.readString();
        this.f31525e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31521a);
        parcel.writeString(this.f31522b);
        parcel.writeIntArray(this.f31523c);
        parcel.writeString(this.f31524d);
        parcel.writeString(this.f31525e);
    }
}
