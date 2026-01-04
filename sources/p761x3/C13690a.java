package p761x3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0038r;
import p005a4.C0040t;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12692o;
import p831z3.C14089a;
import p831z3.C14091b;
import p831z3.C14093c;
import p831z3.C14125y;

/* renamed from: x3.a */
/* loaded from: classes.dex */
public final class C13690a extends AbstractC12685h<C14089a> {

    /* renamed from: x3.a$a */
    public class a extends AbstractC12685h.b<InterfaceC12692o, C14089a> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12692o mo76328a(C14089a c14089a) throws GeneralSecurityException {
            return new C0040t(new C0038r(c14089a.m84439Q().m11698u()), c14089a.m84440R().m84470O());
        }
    }

    /* renamed from: x3.a$b */
    public class b extends AbstractC12685h.a<C14091b, C14089a> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14089a mo76324a(C14091b c14091b) throws GeneralSecurityException {
            return C14089a.m84437T().m84447z(0).m84445x(AbstractC1920i.m11682f(C0041u.m161c(c14091b.m84465N()))).m84446y(c14091b.m84466O()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14091b mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14091b.m84464P(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14091b c14091b) throws GeneralSecurityException {
            C13690a.m82299p(c14091b.m84466O());
            C13690a.m82300q(c14091b.m84465N());
        }
    }

    public C13690a() {
        super(C14089a.class, new a(InterfaceC12692o.class));
    }

    /* renamed from: n */
    public static void m82298n(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C13690a(), z10);
    }

    /* renamed from: p */
    public static void m82299p(C14093c c14093c) throws GeneralSecurityException {
        if (c14093c.m84470O() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (c14093c.m84470O() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* renamed from: q */
    public static void m82300q(int i10) throws GeneralSecurityException {
        if (i10 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14091b, C14089a> mo76319e() {
        return new b(C14091b.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: l */
    public int m82301l() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C14089a mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14089a.m84438U(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14089a c14089a) throws GeneralSecurityException {
        C0043w.m167c(c14089a.m84441S(), m82301l());
        m82300q(c14089a.m84439Q().size());
        m82299p(c14089a.m84440R());
    }
}
