package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.huawei.ohos.localability.base.e */
/* loaded from: classes8.dex */
public class C6847e implements Parcelable {
    public static final Parcelable.Creator<C6847e> CREATOR = new a();

    /* renamed from: a */
    public String f31569a;

    /* renamed from: b */
    public int f31570b;

    /* renamed from: c */
    public String f31571c;

    /* renamed from: d */
    public String f31572d;

    /* renamed from: e */
    public String f31573e;

    /* renamed from: f */
    public String f31574f;

    /* renamed from: g */
    public int f31575g;

    /* renamed from: h */
    public int f31576h;

    /* renamed from: com.huawei.ohos.localability.base.e$a */
    public class a implements Parcelable.Creator<C6847e> {
        @Override // android.os.Parcelable.Creator
        public C6847e createFromParcel(Parcel parcel) {
            return new C6847e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C6847e[] newArray(int i10) {
            if (i10 >= 0) {
                return new C6847e[i10];
            }
            return null;
        }
    }

    public C6847e(Parcel parcel) {
        this.f31570b = -1;
        this.f31569a = parcel.readString();
        this.f31570b = parcel.readInt();
        this.f31571c = parcel.readString();
        this.f31572d = parcel.readString();
        this.f31573e = parcel.readString();
        this.f31574f = parcel.readString();
        parcel.readInt();
        parcel.readInt();
        this.f31575g = parcel.readInt();
        this.f31576h = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31569a);
        parcel.writeInt(this.f31570b);
        parcel.writeString(this.f31571c);
        parcel.writeString(this.f31572d);
        parcel.writeString(this.f31573e);
        parcel.writeString(this.f31574f);
        parcel.writeInt(this.f31575g);
        parcel.writeInt(this.f31576h);
    }
}
