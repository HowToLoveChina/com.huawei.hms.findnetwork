package p596r;

import java.util.ArrayList;
import p561q.C12259f;

/* renamed from: r.m */
/* loaded from: classes.dex */
public class C12446m {

    /* renamed from: h */
    public static int f57332h;

    /* renamed from: c */
    public AbstractC12449p f57335c;

    /* renamed from: d */
    public AbstractC12449p f57336d;

    /* renamed from: f */
    public int f57338f;

    /* renamed from: g */
    public int f57339g;

    /* renamed from: a */
    public int f57333a = 0;

    /* renamed from: b */
    public boolean f57334b = false;

    /* renamed from: e */
    public ArrayList<AbstractC12449p> f57337e = new ArrayList<>();

    public C12446m(AbstractC12449p abstractC12449p, int i10) {
        this.f57335c = null;
        this.f57336d = null;
        int i11 = f57332h;
        this.f57338f = i11;
        f57332h = i11 + 1;
        this.f57335c = abstractC12449p;
        this.f57336d = abstractC12449p;
        this.f57339g = i10;
    }

    /* renamed from: a */
    public void m74678a(AbstractC12449p abstractC12449p) {
        this.f57337e.add(abstractC12449p);
        this.f57336d = abstractC12449p;
    }

    /* renamed from: b */
    public long m74679b(C12259f c12259f, int i10) {
        AbstractC12449p abstractC12449p = this.f57335c;
        if (abstractC12449p instanceof C12436c) {
            if (((C12436c) abstractC12449p).f57362f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(abstractC12449p instanceof C12445l)) {
                return 0L;
            }
        } else if (!(abstractC12449p instanceof C12447n)) {
            return 0L;
        }
        C12439f c12439f = (i10 == 0 ? c12259f.f56756e : c12259f.f56758f).f57364h;
        C12439f c12439f2 = (i10 == 0 ? c12259f.f56756e : c12259f.f56758f).f57365i;
        boolean zContains = abstractC12449p.f57364h.f57316l.contains(c12439f);
        boolean zContains2 = this.f57335c.f57365i.f57316l.contains(c12439f2);
        long jMo74638j = this.f57335c.mo74638j();
        if (!zContains || !zContains2) {
            if (zContains) {
                return Math.max(m74681d(this.f57335c.f57364h, r12.f57310f), this.f57335c.f57364h.f57310f + jMo74638j);
            }
            if (!zContains2) {
                return (r12.f57364h.f57310f + this.f57335c.mo74638j()) - this.f57335c.f57365i.f57310f;
            }
            return Math.max(-m74680c(this.f57335c.f57365i, r12.f57310f), (-this.f57335c.f57365i.f57310f) + jMo74638j);
        }
        long jM74681d = m74681d(this.f57335c.f57364h, 0L);
        long jM74680c = m74680c(this.f57335c.f57365i, 0L);
        long j10 = jM74681d - jMo74638j;
        AbstractC12449p abstractC12449p2 = this.f57335c;
        int i11 = abstractC12449p2.f57365i.f57310f;
        if (j10 >= (-i11)) {
            j10 += i11;
        }
        int i12 = abstractC12449p2.f57364h.f57310f;
        long j11 = ((-jM74680c) - jMo74638j) - i12;
        if (j11 >= i12) {
            j11 -= i12;
        }
        float fM73644s = abstractC12449p2.f57358b.m73644s(i10);
        float f10 = fM73644s > 0.0f ? (long) ((j11 / fM73644s) + (j10 / (1.0f - fM73644s))) : 0L;
        long j12 = ((long) ((f10 * fM73644s) + 0.5f)) + jMo74638j + ((long) ((f10 * (1.0f - fM73644s)) + 0.5f));
        AbstractC12449p abstractC12449p3 = this.f57335c;
        return (abstractC12449p3.f57364h.f57310f + j12) - abstractC12449p3.f57365i.f57310f;
    }

    /* renamed from: c */
    public final long m74680c(C12439f c12439f, long j10) {
        AbstractC12449p abstractC12449p = c12439f.f57308d;
        if (abstractC12449p instanceof C12444k) {
            return j10;
        }
        int size = c12439f.f57315k.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            InterfaceC12437d interfaceC12437d = c12439f.f57315k.get(i10);
            if (interfaceC12437d instanceof C12439f) {
                C12439f c12439f2 = (C12439f) interfaceC12437d;
                if (c12439f2.f57308d != abstractC12449p) {
                    jMin = Math.min(jMin, m74680c(c12439f2, c12439f2.f57310f + j10));
                }
            }
        }
        if (c12439f != abstractC12449p.f57365i) {
            return jMin;
        }
        long jMo74638j = j10 - abstractC12449p.mo74638j();
        return Math.min(Math.min(jMin, m74680c(abstractC12449p.f57364h, jMo74638j)), jMo74638j - abstractC12449p.f57364h.f57310f);
    }

    /* renamed from: d */
    public final long m74681d(C12439f c12439f, long j10) {
        AbstractC12449p abstractC12449p = c12439f.f57308d;
        if (abstractC12449p instanceof C12444k) {
            return j10;
        }
        int size = c12439f.f57315k.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            InterfaceC12437d interfaceC12437d = c12439f.f57315k.get(i10);
            if (interfaceC12437d instanceof C12439f) {
                C12439f c12439f2 = (C12439f) interfaceC12437d;
                if (c12439f2.f57308d != abstractC12449p) {
                    jMax = Math.max(jMax, m74681d(c12439f2, c12439f2.f57310f + j10));
                }
            }
        }
        if (c12439f != abstractC12449p.f57364h) {
            return jMax;
        }
        long jMo74638j = j10 + abstractC12449p.mo74638j();
        return Math.max(Math.max(jMax, m74681d(abstractC12449p.f57365i, jMo74638j)), jMo74638j - abstractC12449p.f57365i.f57310f);
    }
}
