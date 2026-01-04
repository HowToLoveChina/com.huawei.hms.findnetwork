package p755wx;

import com.huawei.hms.network.embedded.C6090s9;
import p022ay.C1057g;
import sx.C12875e;

/* renamed from: wx.c */
/* loaded from: classes9.dex */
public final class C13654c {

    /* renamed from: d */
    public static final C1057g f61377d = C1057g.m6364k(":");

    /* renamed from: e */
    public static final C1057g f61378e = C1057g.m6364k(C6090s9.f28233e);

    /* renamed from: f */
    public static final C1057g f61379f = C1057g.m6364k(C6090s9.f28234f);

    /* renamed from: g */
    public static final C1057g f61380g = C1057g.m6364k(C6090s9.f28235g);

    /* renamed from: h */
    public static final C1057g f61381h = C1057g.m6364k(C6090s9.f28236h);

    /* renamed from: i */
    public static final C1057g f61382i = C1057g.m6364k(C6090s9.f28237i);

    /* renamed from: a */
    public final C1057g f61383a;

    /* renamed from: b */
    public final C1057g f61384b;

    /* renamed from: c */
    public final int f61385c;

    public C13654c(String str, String str2) {
        this(C1057g.m6364k(str), C1057g.m6364k(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C13654c)) {
            return false;
        }
        C13654c c13654c = (C13654c) obj;
        return this.f61383a.equals(c13654c.f61383a) && this.f61384b.equals(c13654c.f61384b);
    }

    public int hashCode() {
        return ((527 + this.f61383a.hashCode()) * 31) + this.f61384b.hashCode();
    }

    public String toString() {
        return C12875e.m77260q("%s: %s", this.f61383a.m6374I(), this.f61384b.m6374I());
    }

    public C13654c(C1057g c1057g, String str) {
        this(c1057g, C1057g.m6364k(str));
    }

    public C13654c(C1057g c1057g, C1057g c1057g2) {
        this.f61383a = c1057g;
        this.f61384b = c1057g2;
        this.f61385c = c1057g.m6370E() + 32 + c1057g2.m6370E();
    }
}
