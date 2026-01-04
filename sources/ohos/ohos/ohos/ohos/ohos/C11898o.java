package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* renamed from: ohos.ohos.ohos.ohos.ohos.o */
/* loaded from: classes9.dex */
public class C11898o implements Parcelable {
    public static final Parcelable.Creator<C11898o> CREATOR = new a();

    /* renamed from: a */
    public String f55114a;

    /* renamed from: b */
    public String f55115b;

    /* renamed from: c */
    public String f55116c;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.o$a */
    public static class a implements Parcelable.Creator<C11898o> {
        @Override // android.os.Parcelable.Creator
        public C11898o createFromParcel(Parcel parcel) {
            return new C11898o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11898o[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11898o[i10];
            }
            return null;
        }
    }

    public C11898o() {
        this.f55114a = "";
        this.f55115b = "";
        this.f55116c = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11898o)) {
            return false;
        }
        C11898o c11898o = (C11898o) obj;
        return Objects.equals(this.f55114a, c11898o.f55114a) && Objects.equals(this.f55115b, c11898o.f55115b) && Objects.equals(this.f55116c, c11898o.f55116c);
    }

    public int hashCode() {
        return Objects.hash(this.f55114a, this.f55115b, this.f55116c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f55115b);
        parcel.writeString(this.f55116c);
        parcel.writeString(this.f55114a);
    }

    public C11898o(Parcel parcel) {
        this.f55114a = "";
        this.f55115b = "";
        this.f55116c = "";
        this.f55115b = parcel.readString();
        this.f55116c = parcel.readString();
        this.f55114a = parcel.readString();
    }

    public C11898o(String str, String str2, String str3) {
        this.f55114a = str;
        this.f55115b = str2;
        this.f55116c = str3;
    }
}
