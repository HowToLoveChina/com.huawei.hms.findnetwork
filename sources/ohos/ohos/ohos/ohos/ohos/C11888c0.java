package ohos.ohos.ohos.ohos.ohos;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* renamed from: ohos.ohos.ohos.ohos.ohos.c0 */
/* loaded from: classes9.dex */
public class C11888c0 extends C11897l0 {
    public static final Parcelable.Creator<C11888c0> CREATOR = new a();

    /* renamed from: f */
    public String f55003f;

    /* renamed from: g */
    public int f55004g;

    /* renamed from: h */
    public C11898o f55005h;

    /* renamed from: i */
    public Set<String> f55006i;

    /* renamed from: j */
    public String f55007j;

    /* renamed from: k */
    public C11901y f55008k;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.c0$a */
    public static class a implements Parcelable.Creator<C11888c0> {
        @Override // android.os.Parcelable.Creator
        public C11888c0 createFromParcel(Parcel parcel) {
            return new C11888c0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11888c0[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11888c0[i10];
            }
            return null;
        }
    }

    public C11888c0(Intent intent) {
        if (intent != null) {
            this.f55003f = intent.getAction();
            this.f55004g = intent.getFlags();
            this.f55007j = intent.getPackage();
            if (intent.getCategories() != null) {
                this.f55006i = new HashSet(intent.getCategories());
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                this.f55005h = new C11898o("", component.getPackageName(), component.getClassName());
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                C11901y c11901y = new C11901y(null);
                Set<String> setKeySet = extras.keySet();
                if (setKeySet != null) {
                    for (String str : setKeySet) {
                        Object obj = extras.get(str);
                        if (obj != null && !(obj instanceof Serializable)) {
                            throw new IllegalArgumentException("the type or contained type is not support to transport when acquireohos : " + obj.getClass());
                        }
                        c11901y.f55118a.put(str, obj);
                        Log.i("ConvertOhosintent", "key: " + str + " value: " + obj.toString());
                    }
                }
                this.f55008k = c11901y;
            }
        }
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11897l0, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11897l0
    public boolean equals(Object obj) {
        if (!(obj instanceof C11888c0)) {
            return false;
        }
        C11888c0 c11888c0 = (C11888c0) obj;
        return Objects.equals(this.f55003f, c11888c0.f55003f) && Objects.equals(this.f55007j, c11888c0.f55007j) && Objects.equals(this.f55005h, c11888c0.f55005h) && Objects.equals(this.f55006i, c11888c0.f55006i);
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11897l0
    public int hashCode() {
        String str = this.f55003f;
        int iHashCode = str != null ? str.hashCode() : 0;
        C11898o c11898o = this.f55005h;
        if (c11898o != null) {
            iHashCode += c11898o.hashCode();
        }
        Set<String> set = this.f55006i;
        if (set != null) {
            iHashCode += set.hashCode();
        }
        String str2 = this.f55007j;
        return str2 != null ? iHashCode + str2.hashCode() : iHashCode;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11897l0, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.f55003f);
        parcel.writeInt(-1);
        parcel.writeInt(-1);
        parcel.writeInt(this.f55004g);
        if (this.f55005h == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(1);
            C11898o c11898o = this.f55005h;
            parcel.writeString(c11898o.f55115b);
            parcel.writeString(c11898o.f55116c);
            parcel.writeString(c11898o.f55114a);
        }
        if (this.f55008k == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(1);
            this.f55008k.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.f55007j);
        parcel.writeInt(-1);
    }

    public C11888c0(Parcel parcel) {
        String[] strArr;
        if (parcel == null) {
            return;
        }
        this.f55003f = parcel.readString();
        parcel.readInt();
        this.f55006i = null;
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
            this.f55006i = new HashSet(Arrays.asList(strArr));
        }
        this.f55004g = parcel.readInt();
        this.f55005h = null;
        if (parcel.readInt() != 1) {
            this.f55005h = null;
        } else if (parcel.readInt() != 0) {
            this.f55005h = C11898o.CREATOR.createFromParcel(parcel);
        }
        this.f55008k = null;
        if (parcel.readInt() == 1 && parcel.readInt() != 0) {
            this.f55008k = C11901y.CREATOR.createFromParcel(parcel);
        }
        this.f55007j = parcel.readString();
    }
}
