package p596r;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: r.f */
/* loaded from: classes.dex */
public class C12439f implements InterfaceC12437d {

    /* renamed from: d */
    public AbstractC12449p f57308d;

    /* renamed from: f */
    public int f57310f;

    /* renamed from: g */
    public int f57311g;

    /* renamed from: a */
    public InterfaceC12437d f57305a = null;

    /* renamed from: b */
    public boolean f57306b = false;

    /* renamed from: c */
    public boolean f57307c = false;

    /* renamed from: e */
    public a f57309e = a.UNKNOWN;

    /* renamed from: h */
    public int f57312h = 1;

    /* renamed from: i */
    public C12440g f57313i = null;

    /* renamed from: j */
    public boolean f57314j = false;

    /* renamed from: k */
    public List<InterfaceC12437d> f57315k = new ArrayList();

    /* renamed from: l */
    public List<C12439f> f57316l = new ArrayList();

    /* renamed from: r.f$a */
    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public C12439f(AbstractC12449p abstractC12449p) {
        this.f57308d = abstractC12449p;
    }

    @Override // p596r.InterfaceC12437d
    /* renamed from: a */
    public void mo74634a(InterfaceC12437d interfaceC12437d) {
        Iterator<C12439f> it = this.f57316l.iterator();
        while (it.hasNext()) {
            if (!it.next().f57314j) {
                return;
            }
        }
        this.f57307c = true;
        InterfaceC12437d interfaceC12437d2 = this.f57305a;
        if (interfaceC12437d2 != null) {
            interfaceC12437d2.mo74634a(this);
        }
        if (this.f57306b) {
            this.f57308d.mo74634a(this);
            return;
        }
        C12439f c12439f = null;
        int i10 = 0;
        for (C12439f c12439f2 : this.f57316l) {
            if (!(c12439f2 instanceof C12440g)) {
                i10++;
                c12439f = c12439f2;
            }
        }
        if (c12439f != null && i10 == 1 && c12439f.f57314j) {
            C12440g c12440g = this.f57313i;
            if (c12440g != null) {
                if (!c12440g.f57314j) {
                    return;
                } else {
                    this.f57310f = this.f57312h * c12440g.f57311g;
                }
            }
            mo74659d(c12439f.f57311g + this.f57310f);
        }
        InterfaceC12437d interfaceC12437d3 = this.f57305a;
        if (interfaceC12437d3 != null) {
            interfaceC12437d3.mo74634a(this);
        }
    }

    /* renamed from: b */
    public void m74657b(InterfaceC12437d interfaceC12437d) {
        this.f57315k.add(interfaceC12437d);
        if (this.f57314j) {
            interfaceC12437d.mo74634a(interfaceC12437d);
        }
    }

    /* renamed from: c */
    public void m74658c() {
        this.f57316l.clear();
        this.f57315k.clear();
        this.f57314j = false;
        this.f57311g = 0;
        this.f57307c = false;
        this.f57306b = false;
    }

    /* renamed from: d */
    public void mo74659d(int i10) {
        if (this.f57314j) {
            return;
        }
        this.f57314j = true;
        this.f57311g = i10;
        for (InterfaceC12437d interfaceC12437d : this.f57315k) {
            interfaceC12437d.mo74634a(interfaceC12437d);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f57308d.f57358b.m73653v());
        sb2.append(":");
        sb2.append(this.f57309e);
        sb2.append("(");
        sb2.append(this.f57314j ? Integer.valueOf(this.f57311g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f57316l.size());
        sb2.append(":d=");
        sb2.append(this.f57315k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
