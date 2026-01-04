package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import p005a4.C0023c;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12684g;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p831z3.C14111l;
import p831z3.C14113m;
import p831z3.C14125y;

/* renamed from: t3.f */
/* loaded from: classes.dex */
public final class C12928f extends AbstractC12685h<C14111l> {

    /* renamed from: t3.f$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14111l> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c */
        public InterfaceC12678a mo76328a(C14111l c14111l) throws GeneralSecurityException {
            return new C0023c(c14111l.m84650P().m11698u());
        }
    }

    /* renamed from: t3.f$b */
    public class b extends AbstractC12685h.a<C14113m, C14111l> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e */
        public C14111l mo76324a(C14113m c14113m) throws GeneralSecurityException {
            return C14111l.m84646R().m84652x(AbstractC1920i.m11682f(C0041u.m161c(c14113m.m84660O()))).m84653y(C12928f.this.m77617l()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f */
        public C14113m mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14113m.m84659Q(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g */
        public void mo76327d(C14113m c14113m) throws GeneralSecurityException {
            C0043w.m165a(c14113m.m84660O());
        }
    }

    public C12928f() {
        super(C14111l.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: j */
    public static final C12684g m77614j() {
        return m77615k(32, C12684g.b.TINK);
    }

    /* renamed from: k */
    public static C12684g m77615k(int i10, C12684g.b bVar) {
        return C12684g.m76312a(new C12928f().mo76317c(), C14113m.m84658P().m84662x(i10).build().mo11460j(), bVar);
    }

    /* renamed from: n */
    public static void m77616n(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C12928f(), z10);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14113m, C14111l> mo76319e() {
        return new b(C14113m.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: l */
    public int m77617l() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: m */
    public C14111l mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14111l.m84647S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: o */
    public void mo76323i(C14111l c14111l) throws GeneralSecurityException {
        C0043w.m167c(c14111l.m84651Q(), m77617l());
        C0043w.m165a(c14111l.m84650P().size());
    }
}
