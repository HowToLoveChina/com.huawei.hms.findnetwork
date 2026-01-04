package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0030j;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p831z3.C14118r;
import p831z3.C14119s;
import p831z3.C14125y;

/* renamed from: t3.h */
/* loaded from: classes.dex */
public class C12930h extends AbstractC12685h<C14118r> {

    /* renamed from: t3.h$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14118r> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14118r c14118r) throws GeneralSecurityException {
            return new C0030j(c14118r.m84702P().m11698u());
        }
    }

    /* renamed from: t3.h$b */
    public class b extends AbstractC12685h.a<C14119s, C14118r> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14118r mo76324a(C14119s c14119s) throws GeneralSecurityException {
            return C14118r.m84698R().m84705y(C12930h.this.m77634j()).m84704x(AbstractC1920i.m11682f(C0041u.m161c(32))).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14119s mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14119s.m84707N(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14119s c14119s) throws GeneralSecurityException {
        }
    }

    public C12930h() {
        super(C14118r.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: l */
    public static void m77633l(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12930h(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14119s, C14118r> mo76319e() {
        return new b(C14119s.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: j */
    public int m77634j() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C14118r mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14118r.m84699S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14118r c14118r) throws GeneralSecurityException {
        C0043w.m167c(c14118r.m84703Q(), m77634j());
        if (c14118r.m84702P().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
