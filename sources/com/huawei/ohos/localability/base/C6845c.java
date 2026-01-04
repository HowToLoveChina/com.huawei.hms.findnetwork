package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* renamed from: com.huawei.ohos.localability.base.c */
/* loaded from: classes8.dex */
public class C6845c implements Parcelable {
    public static final Parcelable.Creator<C6845c> CREATOR = new a();

    /* renamed from: a */
    public String f31542a;

    /* renamed from: b */
    public String f31543b;

    /* renamed from: c */
    public String f31544c;

    /* renamed from: com.huawei.ohos.localability.base.c$a */
    public class a implements Parcelable.Creator<C6845c> {
        @Override // android.os.Parcelable.Creator
        public C6845c createFromParcel(Parcel parcel) {
            return new C6845c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C6845c[] newArray(int i10) {
            if (i10 >= 0) {
                return new C6845c[i10];
            }
            return null;
        }
    }

    public C6845c() {
        this.f31542a = "";
        this.f31543b = "";
        this.f31544c = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6845c)) {
            return false;
        }
        C6845c c6845c = (C6845c) obj;
        return Objects.equals(this.f31542a, c6845c.f31542a) && Objects.equals(this.f31543b, c6845c.f31543b) && Objects.equals(this.f31544c, c6845c.f31544c);
    }

    public int hashCode() {
        return Objects.hash(this.f31542a, this.f31543b, this.f31544c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31543b);
        parcel.writeString(this.f31544c);
        parcel.writeString(this.f31542a);
    }

    public C6845c(Parcel parcel) {
        this.f31542a = "";
        this.f31543b = "";
        this.f31544c = "";
        this.f31543b = parcel.readString();
        this.f31544c = parcel.readString();
        this.f31542a = parcel.readString();
    }
}
