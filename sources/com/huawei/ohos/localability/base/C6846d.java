package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.ohos.localability.base.d */
/* loaded from: classes8.dex */
public class C6846d implements Parcelable {
    public static final Parcelable.Creator<C6846d> CREATOR = new a();

    /* renamed from: a */
    public String f31545a;

    /* renamed from: b */
    public String f31546b;

    /* renamed from: c */
    public String f31547c;

    /* renamed from: d */
    public int f31548d;

    /* renamed from: e */
    public boolean f31549e;

    /* renamed from: f */
    public String f31550f;

    /* renamed from: g */
    public String f31551g;

    /* renamed from: h */
    public String f31552h;

    /* renamed from: i */
    public int f31553i;

    /* renamed from: j */
    public String f31554j;

    /* renamed from: k */
    public int f31555k;

    /* renamed from: l */
    public int f31556l;

    /* renamed from: m */
    public int f31557m;

    /* renamed from: n */
    public String f31558n;

    /* renamed from: o */
    public boolean f31559o;

    /* renamed from: p */
    public boolean f31560p;

    /* renamed from: q */
    public boolean f31561q;

    /* renamed from: r */
    public boolean f31562r;

    /* renamed from: s */
    public boolean f31563s;

    /* renamed from: t */
    public String f31564t;

    /* renamed from: u */
    public String f31565u;

    /* renamed from: v */
    public boolean f31566v;

    /* renamed from: w */
    public String f31567w;

    /* renamed from: x */
    public List<C6847e> f31568x = new ArrayList(0);

    /* renamed from: com.huawei.ohos.localability.base.d$a */
    public class a implements Parcelable.Creator<C6846d> {
        @Override // android.os.Parcelable.Creator
        public C6846d createFromParcel(Parcel parcel) {
            return new C6846d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C6846d[] newArray(int i10) {
            if (i10 >= 0) {
                return new C6846d[i10];
            }
            return null;
        }
    }

    public C6846d(Parcel parcel) {
        this.f31545a = "";
        this.f31546b = "";
        this.f31547c = "";
        this.f31548d = -1;
        this.f31549e = false;
        this.f31550f = "";
        this.f31551g = "";
        this.f31552h = "";
        this.f31553i = 0;
        this.f31554j = "";
        this.f31555k = 0;
        this.f31556l = 0;
        this.f31557m = 0;
        this.f31558n = "";
        this.f31559o = false;
        this.f31560p = false;
        this.f31561q = false;
        this.f31562r = true;
        this.f31563s = false;
        this.f31564t = "";
        this.f31565u = "";
        this.f31566v = false;
        this.f31545a = parcel.readString();
        this.f31546b = parcel.readString();
        this.f31551g = parcel.readString();
        this.f31554j = parcel.readString();
        this.f31553i = parcel.readInt();
        this.f31556l = parcel.readInt();
        this.f31557m = parcel.readInt();
        this.f31555k = parcel.readInt();
        this.f31558n = parcel.readString();
        this.f31559o = parcel.readBoolean();
        this.f31560p = parcel.readBoolean();
        this.f31561q = parcel.readBoolean();
        this.f31562r = parcel.readBoolean();
        this.f31563s = parcel.readBoolean();
        this.f31564t = parcel.readString();
        this.f31547c = parcel.readString();
        this.f31548d = parcel.readInt();
        this.f31550f = parcel.readString();
        this.f31552h = parcel.readString();
        this.f31549e = parcel.readBoolean();
        this.f31565u = parcel.readString();
        this.f31566v = parcel.readBoolean();
        this.f31567w = parcel.readString();
        int i10 = parcel.readInt();
        if (i10 > 1024) {
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this.f31568x.add(parcel.readInt() != 0 ? C6847e.CREATOR.createFromParcel(parcel) : null);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31545a);
        parcel.writeString(this.f31546b);
        parcel.writeString(this.f31551g);
        parcel.writeString(this.f31554j);
        parcel.writeInt(this.f31553i);
        parcel.writeInt(this.f31555k);
        parcel.writeInt(this.f31556l);
        parcel.writeInt(this.f31556l);
        parcel.writeString(this.f31558n);
        parcel.writeBoolean(this.f31559o);
        parcel.writeBoolean(this.f31560p);
        parcel.writeBoolean(this.f31561q);
        parcel.writeBoolean(this.f31562r);
        parcel.writeBoolean(this.f31563s);
        parcel.writeString(this.f31564t);
        parcel.writeString(this.f31547c);
        parcel.writeInt(this.f31548d);
        parcel.writeString(this.f31550f);
        parcel.writeString(this.f31552h);
        parcel.writeBoolean(this.f31549e);
        parcel.writeString(this.f31565u);
        parcel.writeBoolean(this.f31566v);
        parcel.writeString(this.f31567w);
    }
}
