package p235ds;

import as.C1016d;
import es.C9549n;
import gu.C10048b;
import gu.C10049c;
import gu.C10050d;
import gu.C10051e;

/* renamed from: ds.a */
/* loaded from: classes8.dex */
public final class C9300a {

    /* renamed from: a */
    public C9549n f46656a;

    /* renamed from: b */
    public C9549n f46657b;

    /* renamed from: c */
    public C9549n f46658c;

    /* renamed from: d */
    public C9549n f46659d;

    /* renamed from: e */
    public C10050d f46660e;

    public C9300a() {
        m58598a();
    }

    /* renamed from: a */
    public final void m58598a() {
        this.f46656a = new C9549n("LocationCaptainA");
        this.f46657b = new C9549n("LocationIronMan");
        this.f46658c = new C9549n("LocationCaptainM");
        this.f46659d = new C9549n("LocationJarvis");
        if (this.f46656a.m59624b("LocationCaptainA").isEmpty() || this.f46657b.m59624b("LocationIronMan").isEmpty() || this.f46658c.m59624b("LocationCaptainM").isEmpty() || this.f46659d.m59624b("LocationSpiderMan").isEmpty()) {
            C1016d.m6186f("RootKey", "generate new root and work key");
            this.f46656a.m59627e("LocationCaptainA", C10049c.m62476a(C10048b.m62472d(32)));
            this.f46657b.m59627e("LocationIronMan", C10049c.m62476a(C10048b.m62472d(32)));
            this.f46658c.m59627e("LocationCaptainM", C10049c.m62476a(C10048b.m62472d(32)));
            this.f46659d.m59627e("LocationSpiderMan", C10049c.m62476a(C10048b.m62472d(32)));
        }
        this.f46660e = C10050d.m62478e(this.f46656a.m59624b("LocationCaptainA"), this.f46657b.m59624b("LocationIronMan"), this.f46658c.m59624b("LocationCaptainM"), this.f46659d.m59624b("LocationSpiderMan"));
        if (this.f46659d.m59624b("LocationJarvis").isEmpty()) {
            this.f46659d.m59627e("LocationJarvis", C10051e.m62485c(C10048b.m62473e(32), this.f46660e));
        }
    }

    /* renamed from: b */
    public final String m58599b() {
        String str;
        if (this.f46660e == null) {
            str = "rootKeyUtil is null";
        } else {
            if (!this.f46659d.m59624b("LocationJarvis").isEmpty()) {
                return C10051e.m62483a(this.f46659d.m59624b("LocationJarvis"), this.f46660e);
            }
            str = "workKey is null";
        }
        C1016d.m6183c("RootKey", str);
        return "";
    }
}
