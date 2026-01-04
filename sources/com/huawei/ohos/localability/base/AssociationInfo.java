package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class AssociationInfo implements Parcelable {
    public static final Parcelable.Creator<AssociationInfo> CREATOR = new C6827a();

    /* renamed from: a */
    public String f31435a;

    /* renamed from: b */
    public String f31436b;

    /* renamed from: c */
    public boolean f31437c;

    /* renamed from: d */
    public String f31438d;

    /* renamed from: com.huawei.ohos.localability.base.AssociationInfo$a */
    public class C6827a implements Parcelable.Creator<AssociationInfo> {
        @Override // android.os.Parcelable.Creator
        public AssociationInfo createFromParcel(Parcel parcel) {
            return new AssociationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AssociationInfo[] newArray(int i10) {
            if (i10 >= 0) {
                return new AssociationInfo[i10];
            }
            return null;
        }
    }

    public AssociationInfo() {
        this.f31435a = "";
        this.f31436b = "";
        this.f31437c = false;
        this.f31438d = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31435a);
        parcel.writeString(this.f31436b);
        parcel.writeBoolean(this.f31437c);
        parcel.writeString(this.f31438d);
    }

    public AssociationInfo(Parcel parcel) {
        this.f31435a = "";
        this.f31436b = "";
        this.f31437c = false;
        this.f31438d = "";
        this.f31435a = parcel.readString();
        this.f31436b = parcel.readString();
        this.f31437c = parcel.readBoolean();
        this.f31438d = parcel.readString();
    }
}
