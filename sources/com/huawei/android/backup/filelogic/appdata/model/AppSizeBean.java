package com.huawei.android.backup.filelogic.appdata.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AppSizeBean implements Parcelable {
    public static final Parcelable.Creator<AppSizeBean> CREATOR = new C2106a();

    /* renamed from: a */
    public String f9518a;

    /* renamed from: b */
    public long f9519b;

    /* renamed from: c */
    public long f9520c;

    /* renamed from: d */
    public long f9521d;

    /* renamed from: e */
    public long f9522e;

    /* renamed from: f */
    public long f9523f;

    /* renamed from: g */
    public boolean f9524g;

    /* renamed from: com.huawei.android.backup.filelogic.appdata.model.AppSizeBean$a */
    public class C2106a implements Parcelable.Creator<AppSizeBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppSizeBean createFromParcel(Parcel parcel) {
            return new AppSizeBean(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppSizeBean[] newArray(int i10) {
            return new AppSizeBean[i10];
        }
    }

    public /* synthetic */ AppSizeBean(Parcel parcel, C2106a c2106a) {
        this(parcel);
    }

    /* renamed from: a */
    public long m12595a() {
        return this.f9520c;
    }

    /* renamed from: c */
    public void m12596c(long j10) {
        this.f9519b = j10;
    }

    /* renamed from: d */
    public void m12597d(long j10) {
        this.f9520c = j10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m12598e(long j10) {
        this.f9522e = j10;
    }

    /* renamed from: f */
    public void m12599f(long j10) {
        this.f9523f = j10;
    }

    /* renamed from: g */
    public void m12600g(long j10) {
        this.f9521d = j10;
    }

    /* renamed from: h */
    public void m12601h(boolean z10) {
        this.f9524g = z10;
    }

    public String toString() {
        return "packageName " + this.f9518a + ", apkSize " + this.f9519b + ", appDataSize " + this.f9520c + ", appTwinDataSize " + this.f9521d + ", appExternalDataSize " + this.f9522e + ", appExternalTwinDataSize " + this.f9523f + ", isBundleApp " + this.f9524g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.f9518a);
        parcel.writeLong(this.f9519b);
        parcel.writeLong(this.f9520c);
        parcel.writeLong(this.f9521d);
        parcel.writeLong(this.f9522e);
        parcel.writeLong(this.f9523f);
        parcel.writeByte(this.f9524g ? (byte) 1 : (byte) 0);
    }

    public AppSizeBean(Parcel parcel) {
        this.f9518a = parcel.readString();
        this.f9519b = parcel.readLong();
        this.f9520c = parcel.readLong();
        this.f9521d = parcel.readLong();
        this.f9522e = parcel.readLong();
        this.f9523f = parcel.readLong();
        this.f9524g = parcel.readByte() == 1;
    }

    public AppSizeBean(String str) {
        this.f9518a = str;
    }

    public AppSizeBean(String str, long j10, long j11, long j12, long j13) {
        this.f9518a = str;
        this.f9520c = j10;
        this.f9521d = j11;
        this.f9522e = j12;
        this.f9523f = j13;
    }
}
