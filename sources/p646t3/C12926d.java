package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0021a;
import p005a4.C0041u;
import p005a4.C0043w;
import p005a4.InterfaceC0036p;
import p631s3.AbstractC12685h;
import p831z3.C14099f;
import p831z3.C14101g;
import p831z3.C14103h;
import p831z3.C14125y;

/* renamed from: t3.d */
/* loaded from: classes.dex */
public class C12926d extends AbstractC12685h<C14099f> {

    /* renamed from: t3.d$a */
    public class a extends AbstractC12685h.b<InterfaceC0036p, C14099f> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC0036p mo76328a(C14099f c14099f) throws GeneralSecurityException {
            return new C0021a(c14099f.m84571R().m11698u(), c14099f.m84572S().m84600O());
        }
    }

    /* renamed from: t3.d$b */
    public class b extends AbstractC12685h.a<C14101g, C14099f> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14099f mo76324a(C14101g c14101g) throws GeneralSecurityException {
            return C14099f.m84567U().m84576y(c14101g.m84586P()).m84575x(AbstractC1920i.m11682f(C0041u.m161c(c14101g.m84585O()))).m84577z(C12926d.this.m77598k()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14101g mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14101g.m84584Q(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14101g c14101g) throws GeneralSecurityException {
            C0043w.m165a(c14101g.m84585O());
            C12926d.this.m77601n(c14101g.m84586P());
        }
    }

    public C12926d() {
        super(C14099f.class, new a(InterfaceC0036p.class));
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14101g, C14099f> mo76319e() {
        return new b(C14101g.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: k */
    public int m77598k() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C14099f mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14099f.m84568V(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14099f c14099f) throws GeneralSecurityException {
        C0043w.m167c(c14099f.m84573T(), m77598k());
        C0043w.m165a(c14099f.m84571R().size());
        m77601n(c14099f.m84572S());
    }

    /* renamed from: n */
    public final void m77601n(C14103h c14103h) throws GeneralSecurityException {
        if (c14103h.m84600O() < 12 || c14103h.m84600O() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
