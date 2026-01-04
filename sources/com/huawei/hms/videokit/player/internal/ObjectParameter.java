package com.huawei.hms.videokit.player.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class ObjectParameter implements Parcelable {
    public static final Parcelable.Creator<ObjectParameter> CREATOR = new C6564a();

    /* renamed from: a */
    private int f30484a;

    /* renamed from: b */
    private int[] f30485b;

    /* renamed from: c */
    private String[] f30486c;

    /* renamed from: d */
    private List<String> f30487d;

    /* renamed from: e */
    private String f30488e;

    /* renamed from: f */
    private String f30489f;

    /* renamed from: g */
    private Parcelable[] f30490g;

    /* renamed from: h */
    private Parcelable f30491h;

    /* renamed from: com.huawei.hms.videokit.player.internal.ObjectParameter$a */
    public class C6564a implements Parcelable.Creator<ObjectParameter> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObjectParameter createFromParcel(Parcel parcel) {
            return new ObjectParameter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObjectParameter[] newArray(int i10) {
            return new ObjectParameter[i10];
        }
    }

    public ObjectParameter() {
        this.f30484a = -1;
        this.f30485b = null;
        this.f30486c = null;
        this.f30487d = null;
        this.f30488e = "";
        this.f30489f = "";
        this.f30490g = null;
        this.f30491h = null;
    }

    /* renamed from: a */
    public int m37398a(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i10;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "type:" + this.f30484a + ",baseData:" + this.f30488e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30484a);
        parcel.writeString(this.f30488e);
        parcel.writeString(this.f30489f);
        int i11 = this.f30484a;
        if (i11 == 6) {
            parcel.writeValue(this.f30485b);
            return;
        }
        if (i11 == 7) {
            parcel.writeValue(this.f30486c);
            return;
        }
        if (i11 == 8) {
            parcel.writeParcelableArray(this.f30490g, i10);
        } else if (i11 == 5) {
            parcel.writeParcelable(this.f30491h, i10);
        } else if (i11 == 10) {
            parcel.writeStringList(this.f30487d);
        }
    }

    public ObjectParameter(Parcel parcel) {
        StringBuilder sb2;
        this.f30484a = -1;
        this.f30485b = null;
        this.f30486c = null;
        this.f30487d = null;
        this.f30488e = "";
        this.f30489f = "";
        this.f30490g = null;
        this.f30491h = null;
        this.f30484a = parcel.readInt();
        this.f30488e = parcel.readString();
        String string = parcel.readString();
        this.f30489f = string;
        int i10 = this.f30484a;
        if (i10 == 6) {
            this.f30485b = (int[]) parcel.readValue(Integer.class.getClassLoader());
            return;
        }
        if (i10 == 7) {
            this.f30486c = (String[]) parcel.readValue(String.class.getClassLoader());
            return;
        }
        if (i10 == 8) {
            try {
                this.f30490g = parcel.readParcelableArray(Class.forName(string).getClassLoader());
                return;
            } catch (ClassNotFoundException unused) {
                sb2 = new StringBuilder();
            }
        } else {
            if (i10 != 5) {
                if (i10 == 10) {
                    ArrayList arrayList = new ArrayList();
                    this.f30487d = arrayList;
                    parcel.readStringList(arrayList);
                    return;
                }
                return;
            }
            try {
                this.f30491h = parcel.readParcelable(Class.forName(string).getClassLoader());
                return;
            } catch (ClassNotFoundException unused2) {
                sb2 = new StringBuilder();
            }
        }
        sb2.append("readParcelableArray not found：");
        sb2.append(this.f30489f);
        Log.e("ObjectParameter", sb2.toString());
    }

    /* renamed from: a */
    public Object m37399a() {
        switch (this.f30484a) {
            case 0:
                return Integer.valueOf(m37398a(this.f30488e, -1));
            case 1:
                return Long.valueOf(this.f30488e);
            case 2:
                return Float.valueOf(this.f30488e);
            case 3:
                return Double.valueOf(this.f30488e);
            case 4:
                return this.f30488e;
            case 5:
                return this.f30491h;
            case 6:
                return this.f30485b;
            case 7:
                return this.f30486c;
            case 8:
                return this.f30490g;
            case 9:
                return Boolean.valueOf(this.f30488e);
            case 10:
                return this.f30487d;
            default:
                return null;
        }
    }
}
