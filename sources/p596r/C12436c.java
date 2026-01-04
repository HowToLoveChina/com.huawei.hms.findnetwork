package p596r;

import java.util.ArrayList;
import java.util.Iterator;
import p561q.C12257d;
import p561q.C12258e;
import p561q.C12259f;

/* renamed from: r.c */
/* loaded from: classes.dex */
public class C12436c extends AbstractC12449p {

    /* renamed from: k */
    public ArrayList<AbstractC12449p> f57294k;

    /* renamed from: l */
    public int f57295l;

    public C12436c(C12258e c12258e, int i10) {
        super(c12258e);
        this.f57294k = new ArrayList<>();
        this.f57362f = i10;
        m74640q();
    }

    /* JADX WARN: Removed duplicated region for block: B:389:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0153  */
    @Override // p596r.AbstractC12449p, p596r.InterfaceC12437d
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo74634a(p596r.InterfaceC12437d r27) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p596r.C12436c.mo74634a(r.d):void");
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: d */
    public void mo74635d() {
        Iterator<AbstractC12449p> it = this.f57294k.iterator();
        while (it.hasNext()) {
            it.next().mo74635d();
        }
        int size = this.f57294k.size();
        if (size < 1) {
            return;
        }
        C12258e c12258e = this.f57294k.get(0).f57358b;
        C12258e c12258e2 = this.f57294k.get(size - 1).f57358b;
        if (this.f57362f == 0) {
            C12257d c12257d = c12258e.f56734Q;
            C12257d c12257d2 = c12258e2.f56738S;
            C12439f c12439fM74697i = m74697i(c12257d, 0);
            int iM73529f = c12257d.m73529f();
            C12258e c12258eM74641r = m74641r();
            if (c12258eM74641r != null) {
                iM73529f = c12258eM74641r.f56734Q.m73529f();
            }
            if (c12439fM74697i != null) {
                m74693b(this.f57364h, c12439fM74697i, iM73529f);
            }
            C12439f c12439fM74697i2 = m74697i(c12257d2, 0);
            int iM73529f2 = c12257d2.m73529f();
            C12258e c12258eM74642s = m74642s();
            if (c12258eM74642s != null) {
                iM73529f2 = c12258eM74642s.f56738S.m73529f();
            }
            if (c12439fM74697i2 != null) {
                m74693b(this.f57365i, c12439fM74697i2, -iM73529f2);
            }
        } else {
            C12257d c12257d3 = c12258e.f56736R;
            C12257d c12257d4 = c12258e2.f56740T;
            C12439f c12439fM74697i3 = m74697i(c12257d3, 1);
            int iM73529f3 = c12257d3.m73529f();
            C12258e c12258eM74641r2 = m74641r();
            if (c12258eM74641r2 != null) {
                iM73529f3 = c12258eM74641r2.f56736R.m73529f();
            }
            if (c12439fM74697i3 != null) {
                m74693b(this.f57364h, c12439fM74697i3, iM73529f3);
            }
            C12439f c12439fM74697i4 = m74697i(c12257d4, 1);
            int iM73529f4 = c12257d4.m73529f();
            C12258e c12258eM74642s2 = m74642s();
            if (c12258eM74642s2 != null) {
                iM73529f4 = c12258eM74642s2.f56740T.m73529f();
            }
            if (c12439fM74697i4 != null) {
                m74693b(this.f57365i, c12439fM74697i4, -iM73529f4);
            }
        }
        this.f57364h.f57305a = this;
        this.f57365i.f57305a = this;
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: e */
    public void mo74636e() {
        for (int i10 = 0; i10 < this.f57294k.size(); i10++) {
            this.f57294k.get(i10).mo74636e();
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: f */
    public void mo74637f() {
        this.f57359c = null;
        Iterator<AbstractC12449p> it = this.f57294k.iterator();
        while (it.hasNext()) {
            it.next().mo74637f();
        }
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: j */
    public long mo74638j() {
        int size = this.f57294k.size();
        long jMo74638j = 0;
        for (int i10 = 0; i10 < size; i10++) {
            jMo74638j = jMo74638j + r4.f57364h.f57310f + this.f57294k.get(i10).mo74638j() + r4.f57365i.f57310f;
        }
        return jMo74638j;
    }

    @Override // p596r.AbstractC12449p
    /* renamed from: m */
    public boolean mo74639m() {
        int size = this.f57294k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f57294k.get(i10).mo74639m()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: q */
    public final void m74640q() {
        C12258e c12258e;
        C12258e c12258e2 = this.f57358b;
        C12258e c12258eM73572N = c12258e2.m73572N(this.f57362f);
        while (true) {
            C12258e c12258e3 = c12258eM73572N;
            c12258e = c12258e2;
            c12258e2 = c12258e3;
            if (c12258e2 == null) {
                break;
            } else {
                c12258eM73572N = c12258e2.m73572N(this.f57362f);
            }
        }
        this.f57358b = c12258e;
        this.f57294k.add(c12258e.m73576P(this.f57362f));
        C12258e c12258eM73568L = c12258e.m73568L(this.f57362f);
        while (c12258eM73568L != null) {
            this.f57294k.add(c12258eM73568L.m73576P(this.f57362f));
            c12258eM73568L = c12258eM73568L.m73568L(this.f57362f);
        }
        Iterator<AbstractC12449p> it = this.f57294k.iterator();
        while (it.hasNext()) {
            AbstractC12449p next = it.next();
            int i10 = this.f57362f;
            if (i10 == 0) {
                next.f57358b.f56752c = this;
            } else if (i10 == 1) {
                next.f57358b.f56754d = this;
            }
        }
        if (this.f57362f == 0 && ((C12259f) this.f57358b.m73570M()).m73687V1() && this.f57294k.size() > 1) {
            ArrayList<AbstractC12449p> arrayList = this.f57294k;
            this.f57358b = arrayList.get(arrayList.size() - 1).f57358b;
        }
        this.f57295l = this.f57362f == 0 ? this.f57358b.m73548B() : this.f57358b.m73586U();
    }

    /* renamed from: r */
    public final C12258e m74641r() {
        for (int i10 = 0; i10 < this.f57294k.size(); i10++) {
            AbstractC12449p abstractC12449p = this.f57294k.get(i10);
            if (abstractC12449p.f57358b.m73592X() != 8) {
                return abstractC12449p.f57358b;
            }
        }
        return null;
    }

    /* renamed from: s */
    public final C12258e m74642s() {
        for (int size = this.f57294k.size() - 1; size >= 0; size--) {
            AbstractC12449p abstractC12449p = this.f57294k.get(size);
            if (abstractC12449p.f57358b.m73592X() != 8) {
                return abstractC12449p.f57358b;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f57362f == 0 ? "horizontal : " : "vertical : ");
        Iterator<AbstractC12449p> it = this.f57294k.iterator();
        while (it.hasNext()) {
            AbstractC12449p next = it.next();
            sb2.append("<");
            sb2.append(next);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
