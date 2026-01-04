package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12691n;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p831z3.C14102g0;
import p831z3.C14104h0;
import p831z3.C14125y;

/* renamed from: t3.k */
/* loaded from: classes.dex */
public class C12933k extends AbstractC12685h<C14102g0> {

    /* renamed from: t3.k$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14102g0> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14102g0 c14102g0) throws GeneralSecurityException {
            String strM84605P = c14102g0.m84593P().m84605P();
            return new C12932j(c14102g0.m84593P().m84604O(), C12691n.m76356a(strM84605P).mo76355b(strM84605P));
        }
    }

    /* renamed from: t3.k$b */
    public class b extends AbstractC12685h.a<C14104h0, C14102g0> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14102g0 mo76324a(C14104h0 c14104h0) throws GeneralSecurityException {
            return C14102g0.m84590R().m84596x(c14104h0).m84597y(C12933k.this.m77651j()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14104h0 mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14104h0.m84603Q(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14104h0 c14104h0) throws GeneralSecurityException {
        }
    }

    public C12933k() {
        super(C14102g0.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: l */
    public static void m77650l(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12933k(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14104h0, C14102g0> mo76319e() {
        return new b(C14104h0.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.REMOTE;
    }

    /* renamed from: j */
    public int m77651j() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C14102g0 mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14102g0.m84591S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14102g0 c14102g0) throws GeneralSecurityException {
        C0043w.m167c(c14102g0.m84594Q(), m77651j());
    }
}
