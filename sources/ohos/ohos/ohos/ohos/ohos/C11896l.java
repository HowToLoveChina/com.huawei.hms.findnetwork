package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ohos.ohos.ohos.ohos.ohos.l */
/* loaded from: classes9.dex */
public class C11896l implements Parcelable {
    public static final Parcelable.Creator<C11896l> CREATOR = new a();

    /* renamed from: a */
    public b f55088a;

    /* renamed from: b */
    public String f55089b;

    /* renamed from: c */
    public String f55090c;

    /* renamed from: d */
    public String f55091d;

    /* renamed from: e */
    public String f55092e;

    /* renamed from: f */
    public int f55093f;

    /* renamed from: g */
    public String f55094g;

    /* renamed from: h */
    public List<String> f55095h;

    /* renamed from: i */
    public String f55096i;

    /* renamed from: j */
    public String f55097j;

    /* renamed from: k */
    public String f55098k;

    /* renamed from: l */
    public String f55099l;

    /* renamed from: m */
    public String f55100m;

    /* renamed from: n */
    public String f55101n;

    /* renamed from: o */
    public String f55102o;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.l$a */
    public static class a implements Parcelable.Creator<C11896l> {
        @Override // android.os.Parcelable.Creator
        public C11896l createFromParcel(Parcel parcel) {
            return new C11896l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11896l[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11896l[i10];
            }
            return null;
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.l$b */
    public enum b {
        UNKNOWN,
        PAGE,
        SERVICE,
        PROVIDER,
        WEB
    }

    public C11896l() {
        this.f55088a = b.UNKNOWN;
        this.f55089b = "";
        this.f55090c = "";
        this.f55091d = "";
        this.f55092e = "";
        this.f55093f = 0;
        this.f55095h = new ArrayList(0);
        this.f55096i = "";
        this.f55097j = "";
    }

    /* renamed from: a */
    public String mo71382a() {
        return this.f55099l;
    }

    /* renamed from: c */
    public String mo71383c() {
        return this.f55096i;
    }

    /* renamed from: d */
    public String mo71384d() {
        return this.f55097j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo71385e() {
        return this.f55094g;
    }

    /* renamed from: f */
    public String mo71386f() {
        return this.f55091d;
    }

    /* renamed from: g */
    public String mo71387g() {
        return this.f55098k;
    }

    /* renamed from: h */
    public String mo71433h() {
        return this.f55090c;
    }

    /* renamed from: i */
    public int mo71388i() {
        return this.f55093f;
    }

    /* renamed from: j */
    public List<String> mo71389j() {
        return this.f55095h;
    }

    /* renamed from: l */
    public String mo71390l() {
        return this.f55101n;
    }

    /* renamed from: m */
    public String mo71391m() {
        return this.f55100m;
    }

    /* renamed from: n */
    public b mo71392n() {
        return this.f55088a;
    }

    /* renamed from: o */
    public String mo71393o() {
        return this.f55102o;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f55090c);
        parcel.writeString(this.f55091d);
        parcel.writeString(this.f55092e);
        parcel.writeString(this.f55094g);
        parcel.writeInt(this.f55093f);
        parcel.writeInt(this.f55088a.ordinal());
        parcel.writeInt(this.f55095h.size());
        Iterator<String> it = this.f55095h.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
        parcel.writeString(this.f55096i);
        parcel.writeString(this.f55097j);
        parcel.writeString(this.f55089b);
        parcel.writeString(this.f55098k);
        parcel.writeString(this.f55099l);
        parcel.writeString(this.f55100m);
        parcel.writeString(this.f55101n);
        parcel.writeString(this.f55102o);
    }

    public C11896l(Parcel parcel) {
        b bVar = b.UNKNOWN;
        this.f55088a = bVar;
        this.f55089b = "";
        this.f55090c = "";
        this.f55091d = "";
        this.f55092e = "";
        this.f55093f = 0;
        this.f55095h = new ArrayList(0);
        this.f55096i = "";
        this.f55097j = "";
        this.f55090c = parcel.readString();
        this.f55091d = parcel.readString();
        this.f55092e = parcel.readString();
        this.f55094g = parcel.readString();
        this.f55093f = parcel.readInt();
        int i10 = parcel.readInt();
        if (i10 >= 0 && i10 < b.values().length) {
            bVar = b.values()[i10];
        }
        this.f55088a = bVar;
        int i11 = parcel.readInt();
        if (i11 > 1024) {
            return;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            this.f55095h.add(parcel.readString());
        }
        this.f55096i = parcel.readString();
        this.f55097j = parcel.readString();
        this.f55089b = parcel.readString();
        this.f55098k = parcel.readString();
        this.f55099l = parcel.readString();
        this.f55100m = parcel.readString();
        this.f55101n = parcel.readString();
        this.f55102o = parcel.readString();
    }
}
