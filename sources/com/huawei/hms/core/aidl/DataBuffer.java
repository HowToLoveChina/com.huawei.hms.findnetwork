package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new C5160a();
    public String URI;

    /* renamed from: a */
    private int f23563a;

    /* renamed from: b */
    private Bundle f23564b;
    public Bundle header;

    /* renamed from: com.huawei.hms.core.aidl.DataBuffer$a */
    public class C5160a implements Parcelable.Creator<DataBuffer> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (C5160a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer[] newArray(int i10) {
            return new DataBuffer[i10];
        }
    }

    public /* synthetic */ DataBuffer(Parcel parcel, C5160a c5160a) {
        this(parcel);
    }

    /* renamed from: a */
    private static ClassLoader m30758a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f23564b = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f23564b;
    }

    public int getBodySize() {
        return this.f23564b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.f23563a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f23563a);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.f23564b);
    }

    private DataBuffer(Parcel parcel) {
        this.header = null;
        this.f23563a = 1;
        this.f23564b = null;
        m30759a(parcel);
    }

    /* renamed from: a */
    private void m30759a(Parcel parcel) {
        this.f23563a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(m30758a(Bundle.class));
        this.f23564b = parcel.readBundle(m30758a(Bundle.class));
    }

    public DataBuffer() {
        this.header = null;
        this.f23563a = 1;
        this.f23564b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f23563a = 1;
        this.f23564b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i10) {
        this.header = null;
        this.f23564b = null;
        this.URI = str;
        this.f23563a = i10;
    }
}
