package com.huawei.android.hicloud.hisync.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DiskFileItem implements Parcelable {
    public static final Parcelable.Creator<DiskFileItem> CREATOR = new C2804a();

    /* renamed from: a */
    public String f12243a = null;

    /* renamed from: b */
    public String f12244b = null;

    /* renamed from: com.huawei.android.hicloud.hisync.model.DiskFileItem$a */
    public class C2804a implements Parcelable.Creator<DiskFileItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DiskFileItem createFromParcel(Parcel parcel) {
            DiskFileItem diskFileItem = new DiskFileItem();
            diskFileItem.m16401a(parcel.readString());
            diskFileItem.m16402c(parcel.readString());
            return diskFileItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DiskFileItem[] newArray(int i10) {
            return new DiskFileItem[i10];
        }
    }

    /* renamed from: a */
    public void m16401a(String str) {
        this.f12243a = str;
    }

    /* renamed from: c */
    public void m16402c(String str) {
        this.f12244b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12243a);
        parcel.writeString(this.f12244b);
    }
}
