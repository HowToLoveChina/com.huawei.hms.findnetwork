package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ohos.ohos.ohos.ohos.ohos.C11896l;

/* renamed from: ohos.ohos.ohos.ohos.ohos.c */
/* loaded from: classes9.dex */
public class C11887c extends C11896l implements Parcelable {
    public static final Parcelable.Creator<C11887c> CREATOR = new a();

    /* renamed from: A */
    public String f54950A;

    /* renamed from: B */
    public String f54951B;

    /* renamed from: C */
    public String f54952C;

    /* renamed from: D */
    public String f54953D;

    /* renamed from: E */
    public String f54954E;

    /* renamed from: F */
    public String f54955F;

    /* renamed from: G */
    public String f54956G;

    /* renamed from: H */
    public String f54957H;

    /* renamed from: I */
    public String f54958I;

    /* renamed from: J */
    public String f54959J;

    /* renamed from: K */
    public int f54960K;

    /* renamed from: L */
    public boolean f54961L;

    /* renamed from: M */
    public boolean f54962M;

    /* renamed from: N */
    public int f54963N;

    /* renamed from: O */
    public b f54964O;

    /* renamed from: P */
    public c f54965P;

    /* renamed from: Q */
    public List<String> f54966Q;

    /* renamed from: R */
    public List<String> f54967R;

    /* renamed from: S */
    public List<String> f54968S;

    /* renamed from: T */
    public boolean f54969T;

    /* renamed from: U */
    public boolean f54970U;

    /* renamed from: V */
    public String f54971V;

    /* renamed from: W */
    public String f54972W;

    /* renamed from: X */
    public String f54973X;

    /* renamed from: Y */
    public String f54974Y;

    /* renamed from: Z */
    public boolean f54975Z;

    /* renamed from: a0 */
    public C11895k f54976a0;

    /* renamed from: b0 */
    public int f54977b0;

    /* renamed from: c0 */
    public int f54978c0;

    /* renamed from: d0 */
    public int f54979d0;

    /* renamed from: e0 */
    public int f54980e0;

    /* renamed from: f0 */
    public int f54981f0;

    /* renamed from: g0 */
    public int f54982g0;

    /* renamed from: h0 */
    public int f54983h0;

    /* renamed from: i0 */
    public int f54984i0;

    /* renamed from: p */
    public String f54985p;

    /* renamed from: q */
    public String f54986q;

    /* renamed from: r */
    public String f54987r;

    /* renamed from: s */
    public String f54988s;

    /* renamed from: t */
    public C11896l.b f54989t;

    /* renamed from: u */
    public String f54990u;

    /* renamed from: v */
    public boolean f54991v;

    /* renamed from: w */
    public boolean f54992w;

    /* renamed from: x */
    public String f54993x;

    /* renamed from: y */
    public String f54994y;

    /* renamed from: z */
    public String f54995z;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.c$a */
    public static class a implements Parcelable.Creator<C11887c> {
        @Override // android.os.Parcelable.Creator
        public C11887c createFromParcel(Parcel parcel) {
            return new C11887c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11887c[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11887c[i10];
            }
            return null;
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.c$b */
    public enum b {
        UNSPECIFIED,
        LANDSCAPE,
        PORTRAIT
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.c$c */
    public enum c {
        SINGLETON,
        STANDARD
    }

    public C11887c() {
        this.f54985p = "";
        this.f54986q = "";
        this.f54987r = "";
        this.f54988s = "";
        this.f54989t = C11896l.b.UNKNOWN;
        this.f54990u = "";
        this.f54991v = false;
        this.f54992w = true;
        this.f54993x = "";
        this.f54994y = "";
        this.f54995z = "";
        this.f54950A = "";
        this.f54951B = "";
        this.f54952C = "";
        this.f54953D = "";
        this.f54954E = "";
        this.f54960K = 0;
        this.f54961L = false;
        this.f54962M = false;
        this.f54963N = 0;
        this.f54964O = b.UNSPECIFIED;
        this.f54965P = c.SINGLETON;
        this.f54966Q = new ArrayList(0);
        this.f54967R = new ArrayList(0);
        this.f54968S = new ArrayList(0);
        this.f54969T = false;
        this.f54970U = false;
        this.f54971V = "";
        this.f54972W = "";
        this.f54973X = "";
        this.f54974Y = "";
        this.f54975Z = true;
        this.f54976a0 = new C11895k();
        this.f54977b0 = 0;
        this.f54978c0 = 0;
        this.f54979d0 = 0;
        this.f54980e0 = 0;
        this.f54981f0 = 0;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: a */
    public String mo71382a() {
        return this.f54955F;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: c */
    public String mo71383c() {
        return this.f54985p;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: d */
    public String mo71384d() {
        return this.f54986q;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: e */
    public String mo71385e() {
        return this.f54958I;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: f */
    public String mo71386f() {
        return this.f54950A;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: g */
    public String mo71387g() {
        return this.f54994y;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: i */
    public int mo71388i() {
        return this.f54963N;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: j */
    public List<String> mo71389j() {
        return this.f54966Q;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: l */
    public String mo71390l() {
        return this.f54957H;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: m */
    public String mo71391m() {
        return this.f54956G;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: n */
    public C11896l.b mo71392n() {
        return this.f54989t;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l
    /* renamed from: o */
    public String mo71393o() {
        return this.f54959J;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.C11896l, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f54987r);
        parcel.writeString(this.f54988s);
        parcel.writeString(this.f54993x);
        parcel.writeString(this.f54994y);
        parcel.writeString(this.f54995z);
        parcel.writeString(this.f54950A);
        parcel.writeString(this.f54951B);
        parcel.writeString(this.f54952C);
        parcel.writeString(this.f54953D);
        parcel.writeString(this.f54954E);
        parcel.writeString(this.f54955F);
        parcel.writeString(this.f54956G);
        parcel.writeString(this.f54957H);
        parcel.writeString(this.f54958I);
        parcel.writeString(this.f54959J);
        parcel.writeInt(this.f54960K);
        parcel.writeInt(this.f54963N);
        parcel.writeBoolean(this.f54991v);
        parcel.writeBoolean(this.f54961L);
        parcel.writeBoolean(this.f54962M);
        parcel.writeInt(this.f54989t.ordinal());
        parcel.writeInt(this.f54964O.ordinal());
        parcel.writeInt(this.f54965P.ordinal());
        parcel.writeInt(this.f54966Q.size());
        Iterator<String> it = this.f54966Q.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
        parcel.writeInt(this.f54967R.size());
        Iterator<String> it2 = this.f54967R.iterator();
        while (it2.hasNext()) {
            parcel.writeString(it2.next());
        }
        parcel.writeInt(this.f54968S.size());
        Iterator<String> it3 = this.f54968S.iterator();
        while (it3.hasNext()) {
            parcel.writeString(it3.next());
        }
        parcel.writeBoolean(this.f54969T);
        parcel.writeBoolean(this.f54970U);
        parcel.writeString(this.f54971V);
        parcel.writeString(this.f54972W);
        parcel.writeString(this.f54973X);
        parcel.writeString(this.f54974Y);
        parcel.writeBoolean(this.f54975Z);
        parcel.writeString(this.f54985p);
        parcel.writeString(this.f54986q);
        parcel.writeString(this.f54990u);
        if (this.f54976a0 != null) {
            parcel.writeInt(1);
            this.f54976a0.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f54977b0);
        parcel.writeInt(this.f54978c0);
        parcel.writeInt(this.f54979d0);
        parcel.writeInt(this.f54980e0);
        parcel.writeInt(this.f54981f0);
        parcel.writeInt(this.f54983h0);
        parcel.writeInt(this.f54984i0);
        parcel.writeInt(this.f54982g0);
        parcel.writeBoolean(this.f54992w);
    }

    public C11887c(Parcel parcel) {
        this.f54985p = "";
        this.f54986q = "";
        this.f54987r = "";
        this.f54988s = "";
        C11896l.b bVar = C11896l.b.UNKNOWN;
        this.f54989t = bVar;
        this.f54990u = "";
        this.f54991v = false;
        this.f54992w = true;
        this.f54993x = "";
        this.f54994y = "";
        this.f54995z = "";
        this.f54950A = "";
        this.f54951B = "";
        this.f54952C = "";
        this.f54953D = "";
        this.f54954E = "";
        this.f54960K = 0;
        this.f54961L = false;
        this.f54962M = false;
        this.f54963N = 0;
        b bVar2 = b.UNSPECIFIED;
        this.f54964O = bVar2;
        this.f54965P = c.SINGLETON;
        this.f54966Q = new ArrayList(0);
        this.f54967R = new ArrayList(0);
        this.f54968S = new ArrayList(0);
        this.f54969T = false;
        this.f54970U = false;
        this.f54971V = "";
        this.f54972W = "";
        this.f54973X = "";
        this.f54974Y = "";
        this.f54975Z = true;
        this.f54976a0 = new C11895k();
        this.f54977b0 = 0;
        this.f54978c0 = 0;
        this.f54979d0 = 0;
        this.f54980e0 = 0;
        this.f54981f0 = 0;
        this.f54987r = parcel.readString();
        this.f54988s = parcel.readString();
        this.f54993x = parcel.readString();
        this.f54994y = parcel.readString();
        this.f54995z = parcel.readString();
        this.f54950A = parcel.readString();
        this.f54951B = parcel.readString();
        this.f54952C = parcel.readString();
        this.f54953D = parcel.readString();
        this.f54954E = parcel.readString();
        this.f54955F = parcel.readString();
        this.f54956G = parcel.readString();
        this.f54957H = parcel.readString();
        this.f54958I = parcel.readString();
        this.f54959J = parcel.readString();
        this.f54960K = parcel.readInt();
        this.f54963N = parcel.readInt();
        this.f54991v = parcel.readBoolean();
        this.f54961L = parcel.readBoolean();
        this.f54962M = parcel.readBoolean();
        int i10 = parcel.readInt();
        if (i10 < 0 || i10 >= C11896l.b.values().length) {
            this.f54989t = bVar;
        } else {
            this.f54989t = C11896l.b.values()[i10];
        }
        int i11 = parcel.readInt();
        if (i11 < 0 || i11 >= b.values().length) {
            this.f54964O = bVar2;
        } else {
            this.f54964O = b.values()[i11];
        }
        int i12 = parcel.readInt();
        this.f54965P = (i12 < 0 || i12 >= c.values().length) ? c.STANDARD : c.values()[i12];
        int i13 = parcel.readInt();
        if (i13 > 1024) {
            return;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            this.f54966Q.add(parcel.readString());
        }
        int i15 = parcel.readInt();
        if (i15 > 50) {
            return;
        }
        for (int i16 = 0; i16 < i15; i16++) {
            this.f54967R.add(parcel.readString());
        }
        int i17 = parcel.readInt();
        if (i17 > 1024) {
            return;
        }
        for (int i18 = 0; i18 < i17; i18++) {
            this.f54968S.add(parcel.readString());
        }
        this.f54969T = parcel.readBoolean();
        this.f54970U = parcel.readBoolean();
        this.f54971V = parcel.readString();
        this.f54972W = parcel.readString();
        this.f54973X = parcel.readString();
        this.f54974Y = parcel.readString();
        this.f54975Z = parcel.readBoolean();
        this.f54985p = parcel.readString();
        this.f54986q = parcel.readString();
        this.f54990u = parcel.readString();
        this.f54976a0 = parcel.readInt() != 0 ? C11895k.CREATOR.createFromParcel(parcel) : null;
        this.f54977b0 = parcel.readInt();
        this.f54978c0 = parcel.readInt();
        this.f54979d0 = parcel.readInt();
        this.f54980e0 = parcel.readInt();
        this.f54981f0 = parcel.readInt();
        this.f54983h0 = parcel.readInt();
        this.f54984i0 = parcel.readInt();
        this.f54982g0 = parcel.readInt();
        this.f54992w = parcel.readBoolean();
    }
}
