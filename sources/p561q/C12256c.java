package p561q;

import java.util.ArrayList;
import p561q.C12258e;

/* renamed from: q.c */
/* loaded from: classes.dex */
public class C12256c {

    /* renamed from: a */
    public C12258e f56660a;

    /* renamed from: b */
    public C12258e f56661b;

    /* renamed from: c */
    public C12258e f56662c;

    /* renamed from: d */
    public C12258e f56663d;

    /* renamed from: e */
    public C12258e f56664e;

    /* renamed from: f */
    public C12258e f56665f;

    /* renamed from: g */
    public C12258e f56666g;

    /* renamed from: h */
    public ArrayList<C12258e> f56667h;

    /* renamed from: i */
    public int f56668i;

    /* renamed from: j */
    public int f56669j;

    /* renamed from: k */
    public float f56670k = 0.0f;

    /* renamed from: l */
    public int f56671l;

    /* renamed from: m */
    public int f56672m;

    /* renamed from: n */
    public int f56673n;

    /* renamed from: o */
    public boolean f56674o;

    /* renamed from: p */
    public int f56675p;

    /* renamed from: q */
    public boolean f56676q;

    /* renamed from: r */
    public boolean f56677r;

    /* renamed from: s */
    public boolean f56678s;

    /* renamed from: t */
    public boolean f56679t;

    /* renamed from: u */
    public boolean f56680u;

    /* renamed from: v */
    public boolean f56681v;

    public C12256c(C12258e c12258e, int i10, boolean z10) {
        this.f56660a = c12258e;
        this.f56675p = i10;
        this.f56676q = z10;
    }

    /* renamed from: c */
    public static boolean m73521c(C12258e c12258e, int i10) {
        int i11;
        return c12258e.m73592X() != 8 && c12258e.f56751b0[i10] == C12258e.b.MATCH_CONSTRAINT && ((i11 = c12258e.f56796y[i10]) == 0 || i11 == 3);
    }

    /* renamed from: a */
    public void m73522a() {
        if (!this.f56681v) {
            m73523b();
        }
        this.f56681v = true;
    }

    /* renamed from: b */
    public final void m73523b() {
        int i10 = this.f56675p * 2;
        C12258e c12258e = this.f56660a;
        this.f56674o = true;
        C12258e c12258e2 = c12258e;
        boolean z10 = false;
        while (!z10) {
            this.f56668i++;
            C12258e[] c12258eArr = c12258e.f56733P0;
            int i11 = this.f56675p;
            C12258e c12258e3 = null;
            c12258eArr[i11] = null;
            c12258e.f56731O0[i11] = null;
            if (c12258e.m73592X() != 8) {
                this.f56671l++;
                C12258e.b bVarM73656w = c12258e.m73656w(this.f56675p);
                C12258e.b bVar = C12258e.b.MATCH_CONSTRAINT;
                if (bVarM73656w != bVar) {
                    this.f56672m += c12258e.m73558G(this.f56675p);
                }
                int iM73529f = this.f56672m + c12258e.f56746Y[i10].m73529f();
                this.f56672m = iM73529f;
                int i12 = i10 + 1;
                this.f56672m = iM73529f + c12258e.f56746Y[i12].m73529f();
                int iM73529f2 = this.f56673n + c12258e.f56746Y[i10].m73529f();
                this.f56673n = iM73529f2;
                this.f56673n = iM73529f2 + c12258e.f56746Y[i12].m73529f();
                if (this.f56661b == null) {
                    this.f56661b = c12258e;
                }
                this.f56663d = c12258e;
                C12258e.b[] bVarArr = c12258e.f56751b0;
                int i13 = this.f56675p;
                if (bVarArr[i13] == bVar) {
                    int i14 = c12258e.f56796y[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f56669j++;
                        float f10 = c12258e.f56729N0[i13];
                        if (f10 > 0.0f) {
                            this.f56670k += f10;
                        }
                        if (m73521c(c12258e, i13)) {
                            if (f10 < 0.0f) {
                                this.f56677r = true;
                            } else {
                                this.f56678s = true;
                            }
                            if (this.f56667h == null) {
                                this.f56667h = new ArrayList<>();
                            }
                            this.f56667h.add(c12258e);
                        }
                        if (this.f56665f == null) {
                            this.f56665f = c12258e;
                        }
                        C12258e c12258e4 = this.f56666g;
                        if (c12258e4 != null) {
                            c12258e4.f56731O0[this.f56675p] = c12258e;
                        }
                        this.f56666g = c12258e;
                    }
                    if (this.f56675p == 0) {
                        if (c12258e.f56792w != 0 || c12258e.f56798z != 0 || c12258e.f56702A != 0) {
                            this.f56674o = false;
                        }
                    } else if (c12258e.f56794x != 0 || c12258e.f56706C != 0 || c12258e.f56708D != 0) {
                        this.f56674o = false;
                    }
                    if (c12258e.f56759f0 != 0.0f) {
                        this.f56674o = false;
                        this.f56680u = true;
                    }
                }
            }
            if (c12258e2 != c12258e) {
                c12258e2.f56733P0[this.f56675p] = c12258e;
            }
            C12257d c12257d = c12258e.f56746Y[i10 + 1].f56687f;
            if (c12257d != null) {
                C12258e c12258e5 = c12257d.f56685d;
                C12257d c12257d2 = c12258e5.f56746Y[i10].f56687f;
                if (c12257d2 != null && c12257d2.f56685d == c12258e) {
                    c12258e3 = c12258e5;
                }
            }
            if (c12258e3 == null) {
                c12258e3 = c12258e;
                z10 = true;
            }
            c12258e2 = c12258e;
            c12258e = c12258e3;
        }
        C12258e c12258e6 = this.f56661b;
        if (c12258e6 != null) {
            this.f56672m -= c12258e6.f56746Y[i10].m73529f();
        }
        C12258e c12258e7 = this.f56663d;
        if (c12258e7 != null) {
            this.f56672m -= c12258e7.f56746Y[i10 + 1].m73529f();
        }
        this.f56662c = c12258e;
        if (this.f56675p == 0 && this.f56676q) {
            this.f56664e = c12258e;
        } else {
            this.f56664e = this.f56660a;
        }
        this.f56679t = this.f56678s && this.f56677r;
    }
}
