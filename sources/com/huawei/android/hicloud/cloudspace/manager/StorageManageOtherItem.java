package com.huawei.android.hicloud.cloudspace.manager;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class StorageManageOtherItem implements Parcelable {
    public static final Parcelable.Creator<StorageManageOtherItem> CREATOR = new C2741a();

    /* renamed from: a */
    public long f11842a;

    /* renamed from: b */
    public int f11843b;

    /* renamed from: c */
    public long f11844c;

    /* renamed from: d */
    public int f11845d;

    /* renamed from: e */
    public long f11846e;

    /* renamed from: f */
    public int f11847f;

    /* renamed from: g */
    public long f11848g;

    /* renamed from: h */
    public int f11849h;

    /* renamed from: com.huawei.android.hicloud.cloudspace.manager.StorageManageOtherItem$a */
    public class C2741a implements Parcelable.Creator<StorageManageOtherItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StorageManageOtherItem createFromParcel(Parcel parcel) {
            return new StorageManageOtherItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StorageManageOtherItem[] newArray(int i10) {
            return new StorageManageOtherItem[i10];
        }
    }

    public StorageManageOtherItem() {
        this.f11842a = 0L;
        this.f11843b = 0;
        this.f11844c = 0L;
        this.f11845d = 0;
        this.f11846e = 0L;
        this.f11847f = 0;
        this.f11848g = 0L;
        this.f11849h = 0;
    }

    /* renamed from: a */
    public int m15494a() {
        return this.f11845d;
    }

    /* renamed from: c */
    public long m15495c() {
        return this.f11846e;
    }

    /* renamed from: d */
    public int m15496d() {
        return this.f11849h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public long m15497e() {
        return this.f11848g;
    }

    /* renamed from: f */
    public int m15498f() {
        return this.f11843b;
    }

    /* renamed from: g */
    public void m15499g(int i10) {
        this.f11845d = i10;
    }

    /* renamed from: h */
    public void m15500h(long j10) {
        this.f11846e = j10;
    }

    /* renamed from: i */
    public void m15501i(int i10) {
        this.f11849h = i10;
    }

    /* renamed from: j */
    public void m15502j(long j10) {
        this.f11848g = j10;
    }

    /* renamed from: l */
    public void m15503l(int i10) {
        this.f11843b = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f11842a);
        parcel.writeInt(this.f11843b);
        parcel.writeLong(this.f11844c);
        parcel.writeInt(this.f11845d);
        parcel.writeLong(this.f11846e);
        parcel.writeInt(this.f11847f);
        parcel.writeLong(this.f11848g);
        parcel.writeInt(this.f11849h);
    }

    public StorageManageOtherItem(Parcel parcel) {
        this.f11842a = 0L;
        this.f11843b = 0;
        this.f11844c = 0L;
        this.f11845d = 0;
        this.f11846e = 0L;
        this.f11847f = 0;
        this.f11848g = 0L;
        this.f11849h = 0;
        this.f11842a = parcel.readLong();
        this.f11843b = parcel.readInt();
        this.f11844c = parcel.readLong();
        this.f11845d = parcel.readInt();
        this.f11846e = parcel.readLong();
        this.f11847f = parcel.readInt();
        this.f11848g = parcel.readLong();
        this.f11849h = parcel.readInt();
    }
}
