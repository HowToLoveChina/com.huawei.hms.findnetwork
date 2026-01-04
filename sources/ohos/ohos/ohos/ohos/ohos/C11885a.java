package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import p625rx.C12646m;

/* renamed from: ohos.ohos.ohos.ohos.ohos.a */
/* loaded from: classes9.dex */
public class C11885a implements Parcelable {
    public static final Parcelable.Creator<C11885a> CREATOR = new a();

    /* renamed from: a */
    public C11896l f54940a;

    /* renamed from: b */
    public String f54941b;

    /* renamed from: c */
    public String f54942c;

    /* renamed from: d */
    public b f54943d;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.a$a */
    public static class a implements Parcelable.Creator<C11885a> {
        @Override // android.os.Parcelable.Creator
        public C11885a createFromParcel(Parcel parcel) {
            return new C11885a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11885a[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11885a[i10];
            }
            return null;
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.a$b */
    public enum b {
        UNKNOWN,
        PAGE,
        SERVICE,
        DATA,
        WEB
    }

    public C11885a() {
        this.f54941b = "";
        this.f54942c = "";
        this.f54943d = b.UNKNOWN;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(1);
        this.f54940a.writeToParcel(parcel, i10);
        parcel.writeInt(1);
        parcel.writeString(this.f54941b);
        parcel.writeString(this.f54942c);
        if (this.f54943d == b.UNKNOWN) {
            parcel.writeInt(-1);
            return;
        }
        int length = b.values().length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.f54943d == b.values()[i11]) {
                parcel.writeInt(b.values()[i11].ordinal());
            }
        }
    }

    public C11885a(Parcel parcel) {
        C11896l c11896l;
        this.f54941b = "";
        this.f54942c = "";
        b bVar = b.UNKNOWN;
        this.f54943d = bVar;
        if (parcel.readInt() != 0) {
            c11896l = (C11896l) (C12646m.m76178f() ? C11896l.CREATOR : C11887c.CREATOR).createFromParcel(parcel);
        } else {
            c11896l = null;
        }
        this.f54940a = c11896l;
        if (parcel.readInt() != 0) {
            this.f54941b = parcel.readString();
            this.f54942c = parcel.readString();
            int i10 = parcel.readInt();
            if (i10 <= -1 || i10 >= b.values().length) {
                this.f54943d = bVar;
            } else {
                this.f54943d = b.values()[i10];
            }
        }
    }
}
