package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0041u;
import p005a4.C0043w;
import p005a4.C0045y;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p831z3.C14110k0;
import p831z3.C14112l0;
import p831z3.C14125y;

/* renamed from: t3.l */
/* loaded from: classes.dex */
public class C12934l extends AbstractC12685h<C14110k0> {

    /* renamed from: t3.l$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14110k0> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14110k0 c14110k0) throws GeneralSecurityException {
            return new C0045y(c14110k0.m84639P().m11698u());
        }
    }

    /* renamed from: t3.l$b */
    public class b extends AbstractC12685h.a<C14112l0, C14110k0> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14110k0 mo76324a(C14112l0 c14112l0) throws GeneralSecurityException {
            return C14110k0.m84635R().m84642y(C12934l.this.m77659j()).m84641x(AbstractC1920i.m11682f(C0041u.m161c(32))).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14112l0 mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14112l0.m84655N(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14112l0 c14112l0) throws GeneralSecurityException {
        }
    }

    public C12934l() {
        super(C14110k0.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: l */
    public static void m77658l(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12934l(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14112l0, C14110k0> mo76319e() {
        return new b(C14112l0.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: j */
    public int m77659j() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C14110k0 mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14110k0.m84636S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14110k0 c14110k0) throws GeneralSecurityException {
        C0043w.m167c(c14110k0.m84640Q(), m77659j());
        if (c14110k0.m84639P().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
