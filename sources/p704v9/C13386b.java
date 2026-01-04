package p704v9;

import java.util.Objects;

/* renamed from: v9.b */
/* loaded from: classes3.dex */
public class C13386b implements Comparable<C13386b> {

    /* renamed from: a */
    public int f60337a;

    /* renamed from: b */
    public String f60338b;

    /* renamed from: c */
    public int f60339c;

    /* renamed from: d */
    public String f60340d = "";

    /* renamed from: e */
    public String f60341e = "";

    /* renamed from: f */
    public String f60342f = "";

    /* renamed from: g */
    public String f60343g = "";

    /* renamed from: h */
    public int f60344h;

    /* renamed from: i */
    public long f60345i;

    /* renamed from: j */
    public String f60346j;

    /* renamed from: k */
    public String f60347k;

    /* renamed from: l */
    public String f60348l;

    public C13386b(int i10) {
        this.f60337a = i10;
    }

    /* renamed from: A */
    public void m80383A(String str) {
        this.f60338b = str;
    }

    /* renamed from: B */
    public void m80384B(String str) {
        this.f60341e = str;
    }

    /* renamed from: C */
    public void m80385C(int i10) {
        this.f60339c = i10;
    }

    /* renamed from: D */
    public void m80386D(int i10) {
        this.f60344h = i10;
    }

    /* renamed from: E */
    public void m80387E(String str) {
        this.f60342f = str;
    }

    /* renamed from: F */
    public void m80388F(String str) {
        this.f60343g = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C13386b c13386b) {
        int i10 = this.f60339c;
        int i11 = c13386b.f60339c;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    /* renamed from: b */
    public String m80390b() {
        return this.f60340d;
    }

    /* renamed from: e */
    public long m80391e() {
        return this.f60345i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C13386b c13386b = (C13386b) obj;
        return this.f60337a == c13386b.f60337a && this.f60339c == c13386b.f60339c && this.f60344h == c13386b.f60344h && this.f60345i == c13386b.f60345i && Objects.equals(this.f60338b, c13386b.f60338b) && Objects.equals(this.f60340d, c13386b.f60340d) && Objects.equals(this.f60341e, c13386b.f60341e) && Objects.equals(this.f60342f, c13386b.f60342f) && Objects.equals(this.f60343g, c13386b.f60343g);
    }

    /* renamed from: f */
    public String m80392f() {
        return this.f60346j;
    }

    /* renamed from: h */
    public String m80393h() {
        return this.f60347k;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f60337a), this.f60338b, Integer.valueOf(this.f60339c), this.f60340d, this.f60341e, this.f60342f, this.f60343g, Integer.valueOf(this.f60344h), Long.valueOf(this.f60345i));
    }

    /* renamed from: i */
    public String m80394i() {
        return this.f60348l;
    }

    /* renamed from: k */
    public String m80395k() {
        return this.f60338b;
    }

    /* renamed from: p */
    public int m80396p() {
        return this.f60337a;
    }

    /* renamed from: q */
    public String m80397q() {
        return this.f60341e;
    }

    /* renamed from: r */
    public int m80398r() {
        return this.f60339c;
    }

    /* renamed from: s */
    public int m80399s() {
        return this.f60344h;
    }

    /* renamed from: t */
    public String m80400t() {
        return this.f60342f;
    }

    /* renamed from: u */
    public String m80401u() {
        return this.f60343g;
    }

    /* renamed from: v */
    public void m80402v(String str) {
        this.f60340d = str;
    }

    /* renamed from: w */
    public void m80403w(long j10) {
        this.f60345i = j10;
    }

    /* renamed from: x */
    public void m80404x(String str) {
        this.f60346j = str;
    }

    /* renamed from: y */
    public void m80405y(String str) {
        this.f60347k = str;
    }

    /* renamed from: z */
    public void m80406z(String str) {
        this.f60348l = str;
    }
}
