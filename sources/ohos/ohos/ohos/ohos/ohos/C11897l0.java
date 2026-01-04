package ohos.ohos.ohos.ohos.ohos;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* renamed from: ohos.ohos.ohos.ohos.ohos.l0 */
/* loaded from: classes9.dex */
public class C11897l0 implements Parcelable {
    public static final Parcelable.Creator<C11897l0> CREATOR = new a();

    /* renamed from: a */
    public String f55109a;

    /* renamed from: b */
    public int f55110b;

    /* renamed from: c */
    public C11898o f55111c;

    /* renamed from: d */
    public Set<String> f55112d;

    /* renamed from: e */
    public String f55113e;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.l0$a */
    public static class a implements Parcelable.Creator<C11897l0> {
        @Override // android.os.Parcelable.Creator
        public C11897l0 createFromParcel(Parcel parcel) {
            return new C11897l0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11897l0[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11897l0[i10];
            }
            return null;
        }
    }

    public C11897l0() {
        this.f55110b = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C11897l0)) {
            return false;
        }
        C11897l0 c11897l0 = (C11897l0) obj;
        return Objects.equals(this.f55109a, c11897l0.f55109a) && Objects.equals(this.f55113e, c11897l0.f55113e) && Objects.equals(this.f55111c, c11897l0.f55111c) && Objects.equals(this.f55112d, c11897l0.f55112d);
    }

    public int hashCode() {
        String str = this.f55109a;
        int iHashCode = str != null ? str.hashCode() : 0;
        C11898o c11898o = this.f55111c;
        if (c11898o != null) {
            iHashCode += c11898o.hashCode();
        }
        Set<String> set = this.f55112d;
        if (set != null) {
            iHashCode += set.hashCode();
        }
        String str2 = this.f55113e;
        return str2 != null ? iHashCode + str2.hashCode() : iHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f55109a);
        parcel.writeInt(-1);
        parcel.writeInt(-1);
        parcel.writeInt(this.f55110b);
        if (this.f55111c == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(1);
            C11898o c11898o = this.f55111c;
            parcel.writeString(c11898o.f55115b);
            parcel.writeString(c11898o.f55116c);
            parcel.writeString(c11898o.f55114a);
        }
        parcel.writeInt(-1);
        parcel.writeString(this.f55113e);
        parcel.writeInt(-1);
    }

    public C11897l0(Intent intent) {
        if (intent != null) {
            this.f55109a = intent.getAction();
            this.f55110b = intent.getFlags();
            this.f55113e = intent.getPackage();
            if (intent.getCategories() != null) {
                this.f55112d = new HashSet(intent.getCategories());
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                this.f55111c = new C11898o("", component.getPackageName(), component.getClassName());
            }
        }
    }

    public C11897l0(Parcel parcel) {
        String[] strArr;
        this.f55109a = parcel.readString();
        parcel.readInt();
        C11898o c11898oCreateFromParcel = null;
        this.f55112d = null;
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
            this.f55112d = new HashSet(Arrays.asList(strArr));
        }
        this.f55110b = parcel.readInt();
        this.f55111c = null;
        if (parcel.readInt() != 1) {
            this.f55111c = c11898oCreateFromParcel;
        } else if (parcel.readInt() != 0) {
            c11898oCreateFromParcel = C11898o.CREATOR.createFromParcel(parcel);
            this.f55111c = c11898oCreateFromParcel;
        }
        parcel.readInt();
        this.f55113e = parcel.readString();
    }
}
