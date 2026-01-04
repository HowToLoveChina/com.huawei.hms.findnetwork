package kz;

import java.io.IOException;
import kz.AbstractC11204a;
import p411jz.C10962a;
import p463lz.AbstractC11380b;

/* renamed from: kz.b */
/* loaded from: classes9.dex */
public final class C11205b extends AbstractC11204a {

    /* renamed from: m */
    public final C10962a f52585m;

    /* renamed from: n */
    public final AbstractC11380b f52586n;

    /* renamed from: o */
    public final c f52587o;

    /* renamed from: p */
    public final b f52588p;

    /* renamed from: q */
    public final b f52589q;

    /* renamed from: kz.b$b */
    public class b extends AbstractC11204a.a {
        public b() {
            super();
        }

        /* renamed from: b */
        public int m67257b(int i10) throws IOException {
            return C11205b.this.f52586n.m68240b(this.f52575a, 0) == 0 ? C11205b.this.f52586n.m68241c(this.f52576b[i10]) + 2 : C11205b.this.f52586n.m68240b(this.f52575a, 1) == 0 ? C11205b.this.f52586n.m68241c(this.f52577c[i10]) + 10 : C11205b.this.f52586n.m68241c(this.f52578d) + 18;
        }
    }

    /* renamed from: kz.b$c */
    public class c extends AbstractC11204a.b {

        /* renamed from: d */
        public final a[] f52591d;

        /* renamed from: kz.b$c$a */
        public class a extends AbstractC11204a.b.a {
            public a() {
                super();
            }

            /* renamed from: b */
            public void m67260b() throws IOException {
                int iM68240b = 1;
                if (C11205b.this.f52565c.m67262b()) {
                    do {
                        iM68240b = C11205b.this.f52586n.m68240b(this.f52583a, iM68240b) | (iM68240b << 1);
                    } while (iM68240b < 256);
                } else {
                    int iM66161c = C11205b.this.f52585m.m66161c(C11205b.this.f52564b[0]);
                    int i10 = 256;
                    int i11 = 1;
                    do {
                        iM66161c <<= 1;
                        int i12 = iM66161c & i10;
                        int iM68240b2 = C11205b.this.f52586n.m68240b(this.f52583a, i10 + i12 + i11);
                        i11 = (i11 << 1) | iM68240b2;
                        i10 &= (~i12) ^ (0 - iM68240b2);
                    } while (i11 < 256);
                    iM68240b = i11;
                }
                C11205b.this.f52585m.m66166h((byte) iM68240b);
                C11205b.this.f52565c.m67264d();
            }
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f52591d = new a[1 << (i10 + i11)];
            int i12 = 0;
            while (true) {
                a[] aVarArr = this.f52591d;
                if (i12 >= aVarArr.length) {
                    return;
                }
                aVarArr[i12] = new a();
                i12++;
            }
        }

        /* renamed from: b */
        public void m67258b() throws IOException {
            this.f52591d[m67249a(C11205b.this.f52585m.m66161c(0), C11205b.this.f52585m.m66162d())].m67260b();
        }

        /* renamed from: c */
        public void m67259c() {
            int i10 = 0;
            while (true) {
                a[] aVarArr = this.f52591d;
                if (i10 >= aVarArr.length) {
                    return;
                }
                aVarArr[i10].m67250a();
                i10++;
            }
        }
    }

    public C11205b(C10962a c10962a, AbstractC11380b abstractC11380b, int i10, int i11, int i12) {
        super(i12);
        this.f52588p = new b();
        this.f52589q = new b();
        this.f52585m = c10962a;
        this.f52586n = abstractC11380b;
        this.f52587o = new c(i10, i11);
        mo67247b();
    }

    @Override // kz.AbstractC11204a
    /* renamed from: b */
    public void mo67247b() {
        super.mo67247b();
        this.f52587o.m67259c();
        this.f52588p.m67248a();
        this.f52589q.m67248a();
    }

    /* renamed from: e */
    public void m67253e() throws IOException {
        this.f52585m.m66168j();
        while (this.f52585m.m66164f()) {
            int iM66162d = this.f52585m.m66162d() & this.f52563a;
            if (this.f52586n.m68240b(this.f52566d[this.f52565c.m67261a()], iM66162d) == 0) {
                this.f52587o.m67258b();
            } else {
                this.f52585m.m66167i(this.f52564b[0], this.f52586n.m68240b(this.f52567e, this.f52565c.m67261a()) == 0 ? m67254f(iM66162d) : m67255g(iM66162d));
            }
        }
        this.f52586n.mo68244f();
    }

    /* renamed from: f */
    public final int m67254f(int i10) throws IOException {
        this.f52565c.m67266f();
        int[] iArr = this.f52564b;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        int iM67257b = this.f52588p.m67257b(i10);
        int iM68241c = this.f52586n.m68241c(this.f52572j[AbstractC11204a.m67246a(iM67257b)]);
        if (iM68241c < 4) {
            this.f52564b[0] = iM68241c;
        } else {
            int i11 = iM68241c >> 1;
            int[] iArr2 = this.f52564b;
            int i12 = (2 | (iM68241c & 1)) << (i11 - 1);
            iArr2[0] = i12;
            if (iM68241c < 14) {
                iArr2[0] = this.f52586n.m68243e(this.f52573k[iM68241c - 4]) | i12;
            } else {
                iArr2[0] = (this.f52586n.m68242d(i11 - 5) << 4) | i12;
                int[] iArr3 = this.f52564b;
                iArr3[0] = this.f52586n.m68243e(this.f52574l) | iArr3[0];
            }
        }
        return iM67257b;
    }

    /* renamed from: g */
    public final int m67255g(int i10) throws IOException {
        int i11;
        if (this.f52586n.m68240b(this.f52568f, this.f52565c.m67261a()) != 0) {
            if (this.f52586n.m68240b(this.f52569g, this.f52565c.m67261a()) == 0) {
                i11 = this.f52564b[1];
            } else {
                if (this.f52586n.m68240b(this.f52570h, this.f52565c.m67261a()) == 0) {
                    i11 = this.f52564b[2];
                } else {
                    int[] iArr = this.f52564b;
                    int i12 = iArr[3];
                    iArr[3] = iArr[2];
                    i11 = i12;
                }
                int[] iArr2 = this.f52564b;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.f52564b;
            iArr3[1] = iArr3[0];
            iArr3[0] = i11;
        } else if (this.f52586n.m68240b(this.f52571i[this.f52565c.m67261a()], i10) == 0) {
            this.f52565c.m67267g();
            return 1;
        }
        this.f52565c.m67265e();
        return this.f52589q.m67257b(i10);
    }

    /* renamed from: h */
    public boolean m67256h() {
        return this.f52564b[0] == -1;
    }
}
