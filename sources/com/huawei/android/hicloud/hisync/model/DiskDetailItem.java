package com.huawei.android.hicloud.hisync.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DiskDetailItem implements Parcelable {
    public static final Parcelable.Creator<DiskDetailItem> CREATOR = new C2803a();

    /* renamed from: a */
    public String f12240a = null;

    /* renamed from: b */
    public String f12241b = null;

    /* renamed from: c */
    public String f12242c = null;

    /* renamed from: com.huawei.android.hicloud.hisync.model.DiskDetailItem$a */
    public class C2803a implements Parcelable.Creator<DiskDetailItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DiskDetailItem createFromParcel(Parcel parcel) {
            DiskDetailItem diskDetailItem = new DiskDetailItem();
            diskDetailItem.m16396d(parcel.readString());
            diskDetailItem.m16397e(parcel.readString());
            diskDetailItem.m16398f(parcel.readString());
            return diskDetailItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DiskDetailItem[] newArray(int i10) {
            return new DiskDetailItem[i10];
        }
    }

    /* renamed from: a */
    public String m16394a() {
        return this.f12241b;
    }

    /* renamed from: c */
    public String m16395c() {
        return this.f12242c;
    }

    /* renamed from: d */
    public void m16396d(String str) {
        this.f12240a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m16397e(String str) {
        this.f12241b = str;
    }

    /* renamed from: f */
    public void m16398f(String str) {
        this.f12242c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12240a);
        parcel.writeString(this.f12241b);
        parcel.writeString(this.f12242c);
    }
}
