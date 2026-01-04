package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import p243e0.C9371f;
import p243e0.InterfaceC9370e;
import p438l.C11210d;
import p438l.C11213g;

/* renamed from: androidx.recyclerview.widget.u */
/* loaded from: classes.dex */
public class C0882u {

    /* renamed from: a */
    public final C11213g<RecyclerView.AbstractC0833c0, a> f4643a = new C11213g<>();

    /* renamed from: b */
    public final C11210d<RecyclerView.AbstractC0833c0> f4644b = new C11210d<>();

    /* renamed from: androidx.recyclerview.widget.u$a */
    public static class a {

        /* renamed from: d */
        public static InterfaceC9370e<a> f4645d = new C9371f(20);

        /* renamed from: a */
        public int f4646a;

        /* renamed from: b */
        public RecyclerView.AbstractC0843m.c f4647b;

        /* renamed from: c */
        public RecyclerView.AbstractC0843m.c f4648c;

        /* renamed from: a */
        public static void m5606a() {
            while (f4645d.mo58738b() != null) {
            }
        }

        /* renamed from: b */
        public static a m5607b() {
            a aVarMo58738b = f4645d.mo58738b();
            return aVarMo58738b == null ? new a() : aVarMo58738b;
        }

        /* renamed from: c */
        public static void m5608c(a aVar) {
            aVar.f4646a = 0;
            aVar.f4647b = null;
            aVar.f4648c = null;
            f4645d.mo58737a(aVar);
        }
    }

    /* renamed from: androidx.recyclerview.widget.u$b */
    public interface b {
        /* renamed from: a */
        void mo5180a(RecyclerView.AbstractC0833c0 abstractC0833c0);

        /* renamed from: b */
        void mo5181b(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2);

        /* renamed from: c */
        void mo5182c(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2);

        /* renamed from: d */
        void mo5183d(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2);
    }

    /* renamed from: a */
    public void m5589a(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar) {
        a aVarM5607b = this.f4643a.get(abstractC0833c0);
        if (aVarM5607b == null) {
            aVarM5607b = a.m5607b();
            this.f4643a.put(abstractC0833c0, aVarM5607b);
        }
        aVarM5607b.f4646a |= 2;
        aVarM5607b.f4647b = cVar;
    }

    /* renamed from: b */
    public void m5590b(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        a aVarM5607b = this.f4643a.get(abstractC0833c0);
        if (aVarM5607b == null) {
            aVarM5607b = a.m5607b();
            this.f4643a.put(abstractC0833c0, aVarM5607b);
        }
        aVarM5607b.f4646a |= 1;
    }

    /* renamed from: c */
    public void m5591c(long j10, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        this.f4644b.m67300l(j10, abstractC0833c0);
    }

    /* renamed from: d */
    public void m5592d(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar) {
        a aVarM5607b = this.f4643a.get(abstractC0833c0);
        if (aVarM5607b == null) {
            aVarM5607b = a.m5607b();
            this.f4643a.put(abstractC0833c0, aVarM5607b);
        }
        aVarM5607b.f4648c = cVar;
        aVarM5607b.f4646a |= 8;
    }

    /* renamed from: e */
    public void m5593e(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar) {
        a aVarM5607b = this.f4643a.get(abstractC0833c0);
        if (aVarM5607b == null) {
            aVarM5607b = a.m5607b();
            this.f4643a.put(abstractC0833c0, aVarM5607b);
        }
        aVarM5607b.f4647b = cVar;
        aVarM5607b.f4646a |= 4;
    }

    /* renamed from: f */
    public void m5594f() {
        this.f4643a.clear();
        this.f4644b.m67293c();
    }

    /* renamed from: g */
    public RecyclerView.AbstractC0833c0 m5595g(long j10) {
        return this.f4644b.m67296g(j10);
    }

    /* renamed from: h */
    public boolean m5596h(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        a aVar = this.f4643a.get(abstractC0833c0);
        return (aVar == null || (aVar.f4646a & 1) == 0) ? false : true;
    }

    /* renamed from: i */
    public boolean m5597i(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        a aVar = this.f4643a.get(abstractC0833c0);
        return (aVar == null || (aVar.f4646a & 4) == 0) ? false : true;
    }

    /* renamed from: j */
    public void m5598j() {
        a.m5606a();
    }

    /* renamed from: k */
    public void m5599k(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        m5604p(abstractC0833c0);
    }

    /* renamed from: l */
    public final RecyclerView.AbstractC0843m.c m5600l(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        a aVarM67335m;
        RecyclerView.AbstractC0843m.c cVar;
        int iM67328f = this.f4643a.m67328f(abstractC0833c0);
        if (iM67328f >= 0 && (aVarM67335m = this.f4643a.m67335m(iM67328f)) != null) {
            int i11 = aVarM67335m.f4646a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                aVarM67335m.f4646a = i12;
                if (i10 == 4) {
                    cVar = aVarM67335m.f4647b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarM67335m.f4648c;
                }
                if ((i12 & 12) == 0) {
                    this.f4643a.mo67333k(iM67328f);
                    a.m5608c(aVarM67335m);
                }
                return cVar;
            }
        }
        return null;
    }

    /* renamed from: m */
    public RecyclerView.AbstractC0843m.c m5601m(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        return m5600l(abstractC0833c0, 8);
    }

    /* renamed from: n */
    public RecyclerView.AbstractC0843m.c m5602n(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        return m5600l(abstractC0833c0, 4);
    }

    /* renamed from: o */
    public void m5603o(b bVar) {
        for (int size = this.f4643a.size() - 1; size >= 0; size--) {
            RecyclerView.AbstractC0833c0 abstractC0833c0M67331i = this.f4643a.m67331i(size);
            a aVarMo67333k = this.f4643a.mo67333k(size);
            int i10 = aVarMo67333k.f4646a;
            if ((i10 & 3) == 3) {
                bVar.mo5180a(abstractC0833c0M67331i);
            } else if ((i10 & 1) != 0) {
                RecyclerView.AbstractC0843m.c cVar = aVarMo67333k.f4647b;
                if (cVar == null) {
                    bVar.mo5180a(abstractC0833c0M67331i);
                } else {
                    bVar.mo5182c(abstractC0833c0M67331i, cVar, aVarMo67333k.f4648c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.mo5181b(abstractC0833c0M67331i, aVarMo67333k.f4647b, aVarMo67333k.f4648c);
            } else if ((i10 & 12) == 12) {
                bVar.mo5183d(abstractC0833c0M67331i, aVarMo67333k.f4647b, aVarMo67333k.f4648c);
            } else if ((i10 & 4) != 0) {
                bVar.mo5182c(abstractC0833c0M67331i, aVarMo67333k.f4647b, null);
            } else if ((i10 & 8) != 0) {
                bVar.mo5181b(abstractC0833c0M67331i, aVarMo67333k.f4647b, aVarMo67333k.f4648c);
            }
            a.m5608c(aVarMo67333k);
        }
    }

    /* renamed from: p */
    public void m5604p(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        a aVar = this.f4643a.get(abstractC0833c0);
        if (aVar == null) {
            return;
        }
        aVar.f4646a &= -2;
    }

    /* renamed from: q */
    public void m5605q(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        int iM67303o = this.f4644b.m67303o() - 1;
        while (true) {
            if (iM67303o < 0) {
                break;
            }
            if (abstractC0833c0 == this.f4644b.m67304p(iM67303o)) {
                this.f4644b.m67302n(iM67303o);
                break;
            }
            iM67303o--;
        }
        a aVarRemove = this.f4643a.remove(abstractC0833c0);
        if (aVarRemove != null) {
            a.m5608c(aVarRemove);
        }
    }
}
