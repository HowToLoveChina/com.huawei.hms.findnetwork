package p698v3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import p005a4.C0024d;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12684g;
import p631s3.C12695r;
import p631s3.InterfaceC12681d;
import p831z3.C14116p;
import p831z3.C14117q;
import p831z3.C14125y;

/* renamed from: v3.a */
/* loaded from: classes.dex */
public final class C13329a extends AbstractC12685h<C14116p> {

    /* renamed from: v3.a$a */
    public class a extends AbstractC12685h.b<InterfaceC12681d, C14116p> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12681d mo76328a(C14116p c14116p) throws GeneralSecurityException {
            return new C0024d(c14116p.m84684P().m11698u());
        }
    }

    /* renamed from: v3.a$b */
    public class b extends AbstractC12685h.a<C14117q, C14116p> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14116p mo76324a(C14117q c14117q) throws GeneralSecurityException {
            return C14116p.m84680R().m84686x(AbstractC1920i.m11682f(C0041u.m161c(c14117q.m84693O()))).m84687y(C13329a.this.m79935l()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14117q mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14117q.m84691Q(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14117q c14117q) throws GeneralSecurityException {
            if (c14117q.m84693O() == 64) {
                return;
            }
            throw new InvalidAlgorithmParameterException("invalid key size: " + c14117q.m84693O() + ". Valid keys must have 64 bytes.");
        }
    }

    public C13329a() {
        super(C14116p.class, new a(InterfaceC12681d.class));
    }

    /* renamed from: j */
    public static final C12684g m79932j() {
        return m79933k(64, C12684g.b.TINK);
    }

    /* renamed from: k */
    private static C12684g m79933k(int i10, C12684g.b bVar) {
        return C12684g.m76312a(new C13329a().mo76317c(), C14117q.m84690P().m84694x(i10).build().mo11460j(), bVar);
    }

    /* renamed from: n */
    public static void m79934n(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C13329a(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14117q, C14116p> mo76319e() {
        return new b(C14117q.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: l */
    public int m79935l() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C14116p mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14116p.m84681S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14116p c14116p) throws GeneralSecurityException {
        C0043w.m167c(c14116p.m84685Q(), m79935l());
        if (c14116p.m84684P().size() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + c14116p.m84684P().size() + ". Valid keys must have 64 bytes.");
    }
}
