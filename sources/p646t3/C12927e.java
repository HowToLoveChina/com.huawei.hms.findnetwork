package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0022b;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p831z3.C14105i;
import p831z3.C14107j;
import p831z3.C14125y;

/* renamed from: t3.e */
/* loaded from: classes.dex */
public final class C12927e extends AbstractC12685h<C14105i> {

    /* renamed from: t3.e$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14105i> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14105i c14105i) throws GeneralSecurityException {
            return new C0022b(c14105i.m84614Q().m11698u(), c14105i.m84615R().m84631O());
        }
    }

    /* renamed from: t3.e$b */
    public class b extends AbstractC12685h.a<C14107j, C14105i> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14105i mo76324a(C14107j c14107j) throws GeneralSecurityException {
            return C14105i.m84610T().m84618x(AbstractC1920i.m11682f(C0041u.m161c(c14107j.m84625N()))).m84619y(c14107j.m84626O()).m84620z(C12927e.this.m77607j()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14107j mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14107j.m84624P(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14107j c14107j) throws GeneralSecurityException {
            C0043w.m165a(c14107j.m84625N());
            if (c14107j.m84626O().m84631O() != 12 && c14107j.m84626O().m84631O() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
        }
    }

    public C12927e() {
        super(C14105i.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: l */
    public static void m77606l(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12927e(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14107j, C14105i> mo76319e() {
        return new b(C14107j.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: j */
    public int m77607j() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C14105i mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14105i.m84611U(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14105i c14105i) throws GeneralSecurityException {
        C0043w.m167c(c14105i.m84616S(), m77607j());
        C0043w.m165a(c14105i.m84614Q().size());
        if (c14105i.m84615R().m84631O() != 12 && c14105i.m84615R().m84631O() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
