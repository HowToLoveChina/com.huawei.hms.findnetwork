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
import p831z3.C14098e0;
import p831z3.C14100f0;
import p831z3.C14125y;

/* renamed from: t3.i */
/* loaded from: classes.dex */
public class C12931i extends AbstractC12685h<C14098e0> {

    /* renamed from: t3.i$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14098e0> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14098e0 c14098e0) throws GeneralSecurityException {
            String strM84581O = c14098e0.m84557P().m84581O();
            return C12691n.m76356a(strM84581O).mo76355b(strM84581O);
        }
    }

    /* renamed from: t3.i$b */
    public class b extends AbstractC12685h.a<C14100f0, C14098e0> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14098e0 mo76324a(C14100f0 c14100f0) throws GeneralSecurityException {
            return C14098e0.m84554R().m84560x(c14100f0).m84561y(C12931i.this.m77642j()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14100f0 mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14100f0.m84580P(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14100f0 c14100f0) throws GeneralSecurityException {
        }
    }

    public C12931i() {
        super(C14098e0.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: l */
    public static void m77641l(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12931i(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14100f0, C14098e0> mo76319e() {
        return new b(C14100f0.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.REMOTE;
    }

    /* renamed from: j */
    public int m77642j() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C14098e0 mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14098e0.m84555S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14098e0 c14098e0) throws GeneralSecurityException {
        C0043w.m167c(c14098e0.m84558Q(), m77642j());
    }
}
