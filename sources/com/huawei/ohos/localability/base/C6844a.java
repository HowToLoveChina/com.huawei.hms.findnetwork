package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import ht.C10341d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.ohos.localability.base.a */
/* loaded from: classes8.dex */
public class C6844a implements Parcelable {
    public static final Parcelable.Creator<C6844a> CREATOR = new a();

    /* renamed from: a */
    public String f31526a;

    /* renamed from: b */
    public boolean f31527b;

    /* renamed from: c */
    public boolean f31528c;

    /* renamed from: d */
    public boolean f31529d;

    /* renamed from: e */
    public String f31530e;

    /* renamed from: f */
    public String f31531f;

    /* renamed from: g */
    public String f31532g;

    /* renamed from: h */
    public String f31533h;

    /* renamed from: i */
    public String f31534i;

    /* renamed from: j */
    public int f31535j;

    /* renamed from: k */
    public int f31536k;

    /* renamed from: l */
    public int f31537l;

    /* renamed from: m */
    public int f31538m;

    /* renamed from: n */
    public boolean f31539n;

    /* renamed from: o */
    public List<String> f31540o;

    /* renamed from: p */
    public List<C10341d> f31541p;

    /* renamed from: com.huawei.ohos.localability.base.a$a */
    public class a implements Parcelable.Creator<C6844a> {
        @Override // android.os.Parcelable.Creator
        public C6844a createFromParcel(Parcel parcel) {
            return new C6844a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C6844a[] newArray(int i10) {
            if (i10 >= 0) {
                return new C6844a[i10];
            }
            return null;
        }
    }

    public C6844a() {
        this.f31526a = "";
        this.f31527b = false;
        this.f31528c = true;
        this.f31529d = false;
        this.f31530e = "";
        this.f31531f = "";
        this.f31532g = "";
        this.f31533h = "";
        this.f31534i = "";
        this.f31535j = 0;
        this.f31536k = 0;
        this.f31537l = 0;
        this.f31538m = 0;
        this.f31539n = true;
        this.f31540o = new ArrayList(0);
        this.f31541p = new ArrayList(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31526a);
        parcel.writeString(this.f31530e);
        parcel.writeString(this.f31531f);
        parcel.writeString(this.f31532g);
        parcel.writeString(this.f31533h);
        parcel.writeString(this.f31534i);
        parcel.writeBoolean(this.f31527b);
        parcel.writeInt(this.f31535j);
        parcel.writeInt(this.f31537l);
        parcel.writeInt(this.f31538m);
        parcel.writeInt(this.f31536k);
        parcel.writeBoolean(this.f31539n);
        parcel.writeInt(this.f31540o.size());
        Iterator<String> it = this.f31540o.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
        parcel.writeInt(this.f31541p.size());
        for (C10341d c10341d : this.f31541p) {
            parcel.writeString(c10341d.f50029a);
            parcel.writeString(c10341d.f50030b);
        }
        parcel.writeBoolean(this.f31528c);
        parcel.writeBoolean(this.f31529d);
    }

    public C6844a(Parcel parcel) {
        this.f31526a = "";
        this.f31527b = false;
        this.f31528c = true;
        this.f31529d = false;
        this.f31530e = "";
        this.f31531f = "";
        this.f31532g = "";
        this.f31533h = "";
        this.f31534i = "";
        this.f31535j = 0;
        this.f31536k = 0;
        this.f31537l = 0;
        this.f31538m = 0;
        this.f31539n = true;
        this.f31540o = new ArrayList(0);
        this.f31541p = new ArrayList(0);
        this.f31526a = parcel.readString();
        this.f31530e = parcel.readString();
        this.f31531f = parcel.readString();
        this.f31532g = parcel.readString();
        this.f31533h = parcel.readString();
        this.f31534i = parcel.readString();
        this.f31527b = parcel.readBoolean();
        this.f31535j = parcel.readInt();
        this.f31537l = parcel.readInt();
        this.f31538m = parcel.readInt();
        this.f31536k = parcel.readInt();
        this.f31539n = parcel.readBoolean();
        int i10 = parcel.readInt();
        if (i10 > 1024) {
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this.f31540o.add(parcel.readString());
        }
        int i12 = parcel.readInt();
        if (i12 > 1024) {
            return;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            this.f31541p.add(new C10341d(parcel.readString(), parcel.readString()));
        }
        this.f31528c = parcel.readBoolean();
        this.f31529d = parcel.readBoolean();
    }
}
