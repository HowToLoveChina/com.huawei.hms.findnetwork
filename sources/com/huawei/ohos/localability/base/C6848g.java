package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* renamed from: com.huawei.ohos.localability.base.g */
/* loaded from: classes8.dex */
public class C6848g implements Parcelable {
    public static final Parcelable.Creator<C6848g> CREATOR = new a();

    /* renamed from: a */
    public String f31577a;

    /* renamed from: b */
    public int f31578b;

    /* renamed from: c */
    public C6845c f31579c;

    /* renamed from: d */
    public Set<String> f31580d;

    /* renamed from: e */
    public String f31581e;

    /* renamed from: com.huawei.ohos.localability.base.g$a */
    public class a implements Parcelable.Creator<C6848g> {
        @Override // android.os.Parcelable.Creator
        public C6848g createFromParcel(Parcel parcel) {
            return new C6848g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C6848g[] newArray(int i10) {
            if (i10 >= 0) {
                return new C6848g[i10];
            }
            return null;
        }
    }

    public C6848g() {
        this.f31578b = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6848g)) {
            return false;
        }
        C6848g c6848g = (C6848g) obj;
        return Objects.equals(this.f31577a, c6848g.f31577a) && Objects.equals(this.f31581e, c6848g.f31581e) && Objects.equals(this.f31579c, c6848g.f31579c) && Objects.equals(this.f31580d, c6848g.f31580d);
    }

    public int hashCode() {
        String str = this.f31577a;
        int iHashCode = str != null ? str.hashCode() : 0;
        C6845c c6845c = this.f31579c;
        if (c6845c != null) {
            iHashCode += c6845c.hashCode();
        }
        Set<String> set = this.f31580d;
        if (set != null) {
            iHashCode += set.hashCode();
        }
        String str2 = this.f31581e;
        return str2 != null ? iHashCode + str2.hashCode() : iHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31577a);
        parcel.writeInt(-1);
        parcel.writeInt(-1);
        parcel.writeInt(this.f31578b);
        if (this.f31579c == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(1);
            C6845c c6845c = this.f31579c;
            parcel.writeString(c6845c.f31543b);
            parcel.writeString(c6845c.f31544c);
            parcel.writeString(c6845c.f31542a);
        }
        parcel.writeInt(-1);
        parcel.writeString(this.f31581e);
        parcel.writeInt(-1);
    }

    public C6848g(Parcel parcel) {
        String[] strArr;
        this.f31577a = parcel.readString();
        parcel.readInt();
        C6845c c6845cCreateFromParcel = null;
        this.f31580d = null;
        if (parcel.readInt() == 1) {
            int i10 = parcel.readInt();
            if (i10 < 0 || i10 > 512000) {
                strArr = new String[0];
            } else {
                strArr = new String[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    strArr[i11] = parcel.readString();
                }
            }
            this.f31580d = new HashSet(Arrays.asList(strArr));
        }
        this.f31578b = parcel.readInt();
        this.f31579c = null;
        if (parcel.readInt() != 1) {
            this.f31579c = c6845cCreateFromParcel;
        } else if (parcel.readInt() != 0) {
            c6845cCreateFromParcel = C6845c.CREATOR.createFromParcel(parcel);
            this.f31579c = c6845cCreateFromParcel;
        }
        parcel.readInt();
        this.f31581e = parcel.readString();
    }
}
