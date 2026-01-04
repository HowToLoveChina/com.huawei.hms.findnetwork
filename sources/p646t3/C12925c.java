package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0032l;
import p005a4.C0043w;
import p005a4.InterfaceC0036p;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p631s3.InterfaceC12692o;
import p761x3.C13691b;
import p831z3.C14095d;
import p831z3.C14097e;
import p831z3.C14099f;
import p831z3.C14125y;

/* renamed from: t3.c */
/* loaded from: classes.dex */
public final class C12925c extends AbstractC12685h<C14095d> {

    /* renamed from: t3.c$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14095d> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14095d c14095d) throws GeneralSecurityException {
            return new C0032l((InterfaceC0036p) new C12926d().m76318d(c14095d.m84514Q(), InterfaceC0036p.class), (InterfaceC12692o) new C13691b().m76318d(c14095d.m84515R(), InterfaceC12692o.class), c14095d.m84515R().m84730S().m84744P());
        }
    }

    /* renamed from: t3.c$b */
    public class b extends AbstractC12685h.a<C14097e, C14095d> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14095d mo76324a(C14097e c14097e) throws GeneralSecurityException {
            C14099f c14099fMo76324a = new C12926d().mo76319e().mo76324a(c14097e.m84549N());
            return C14095d.m84511T().m84519x(c14099fMo76324a).m84520y(new C13691b().mo76319e().mo76324a(c14097e.m84550O())).m84521z(C12925c.this.m77590j()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14097e mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14097e.m84548P(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14097e c14097e) throws GeneralSecurityException {
            new C12926d().mo76319e().mo76327d(c14097e.m84549N());
            new C13691b().mo76319e().mo76327d(c14097e.m84550O());
            C0043w.m165a(c14097e.m84549N().m84585O());
        }
    }

    public C12925c() {
        super(C14095d.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: l */
    public static void m77589l(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12925c(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14097e, C14095d> mo76319e() {
        return new b(C14097e.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: j */
    public int m77590j() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C14095d mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14095d.m84512U(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14095d c14095d) throws GeneralSecurityException {
        C0043w.m167c(c14095d.m84516S(), m77590j());
        new C12926d().mo76323i(c14095d.m84514Q());
        new C13691b().mo76323i(c14095d.m84515R());
    }
}
