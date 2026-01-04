package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ohos.ohos.ohos.ohos.ohos.C11896l;

/* renamed from: ohos.ohos.ohos.ohos.ohos.z */
/* loaded from: classes9.dex */
public class C11902z extends C11896l implements Parcelable {
    public static final Parcelable.Creator<C11902z> CREATOR = new a();

    /* renamed from: A */
    public String f55119A;

    /* renamed from: B */
    public String f55120B;

    /* renamed from: C */
    public String f55121C;

    /* renamed from: D */
    public String f55122D;

    /* renamed from: E */
    public String f55123E;

    /* renamed from: F */
    public String f55124F;

    /* renamed from: p */
    public C11896l.b f55125p;

    /* renamed from: q */
    public String f55126q;

    /* renamed from: r */
    public String f55127r;

    /* renamed from: s */
    public String f55128s;

    /* renamed from: t */
    public String f55129t;

    /* renamed from: u */
    public String f55130u;

    /* renamed from: v */
    public String f55131v;

    /* renamed from: w */
    public int f55132w;

    /* renamed from: x */
    public String f55133x;

    /* renamed from: y */
    public List<String> f55134y;

    /* renamed from: z */
    public String f55135z;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.z$a */
    public static class a implements Parcelable.Creator<C11902z> {
        @Override // android.os.Parcelable.Creator
        public C11902z createFromParcel(Parcel parcel) {
            return new C11902z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11902z[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11902z[i10];
            }
            return null;
        }
    }

    public C11902z() {
        this.f55125p = C11896l.b.UNKNOWN;
        this.f55126q = "";
        this.f55127r = "";
        this.f55128s = "";
        this.f55129t = "";
        this.f55130u = "";
        this.f55131v = "";
        this.f55132w = 0;
        this.f55134y = new ArrayList(0);
        this.f55135z = "";
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: a */
    public String mo71382a() {
        return this.f55120B;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: c */
    public String mo71383c() {
        return this.f55128s;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: d */
    public String mo71384d() {
        return this.f55127r;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: e */
    public String mo71385e() {
        return this.f55133x;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: f */
    public String mo71386f() {
        return this.f55130u;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: g */
    public String mo71387g() {
        return this.f55119A;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: h */
    public String mo71433h() {
        return this.f55129t;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: i */
    public int mo71388i() {
        return this.f55132w;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: j */
    public List<String> mo71389j() {
        return this.f55134y;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: l */
    public String mo71390l() {
        return this.f55122D;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: m */
    public String mo71391m() {
        return this.f55121C;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: n */
    public C11896l.b mo71392n() {
        return this.f55125p;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: o */
    public String mo71393o() {
        return this.f55123E;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f55129t);
        parcel.writeString(this.f55130u);
        parcel.writeString(this.f55131v);
        parcel.writeString(this.f55133x);
        parcel.writeInt(this.f55132w);
        parcel.writeInt(this.f55125p.ordinal());
        parcel.writeInt(this.f55134y.size());
        Iterator<String> it = this.f55134y.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
        parcel.writeString(this.f55128s);
        parcel.writeString(this.f55135z);
        parcel.writeString(this.f55127r);
        parcel.writeString(this.f55126q);
        parcel.writeString(this.f55119A);
        parcel.writeString(this.f55120B);
        parcel.writeString(this.f55121C);
        parcel.writeString(this.f55122D);
        parcel.writeString(this.f55123E);
        parcel.writeString(this.f55124F);
    }

    public C11902z(Parcel parcel) {
        C11896l.b bVar = C11896l.b.UNKNOWN;
        this.f55125p = bVar;
        this.f55126q = "";
        this.f55127r = "";
        this.f55128s = "";
        this.f55129t = "";
        this.f55130u = "";
        this.f55131v = "";
        this.f55132w = 0;
        this.f55134y = new ArrayList(0);
        this.f55135z = "";
        this.f55129t = parcel.readString();
        this.f55130u = parcel.readString();
        this.f55131v = parcel.readString();
        this.f55133x = parcel.readString();
        this.f55132w = parcel.readInt();
        int i10 = parcel.readInt();
        if (i10 >= 0 && i10 < C11896l.b.values().length) {
            bVar = C11896l.b.values()[i10];
        }
        this.f55125p = bVar;
        int i11 = parcel.readInt();
        if (i11 > 1024) {
            return;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            this.f55134y.add(parcel.readString());
        }
        this.f55128s = parcel.readString();
        this.f55135z = parcel.readString();
        this.f55127r = parcel.readString();
        this.f55126q = parcel.readString();
        this.f55119A = parcel.readString();
        this.f55120B = parcel.readString();
        this.f55121C = parcel.readString();
        this.f55122D = parcel.readString();
        this.f55123E = parcel.readString();
        this.f55124F = parcel.readString();
    }
}
