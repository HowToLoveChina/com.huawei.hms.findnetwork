package p631s3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.io.IOException;
import java.security.GeneralSecurityException;
import p831z3.C14094c0;
import p831z3.C14096d0;
import p831z3.C14120t;

/* renamed from: s3.i */
/* loaded from: classes.dex */
public final class C12686i {

    /* renamed from: a */
    public final C14094c0 f58210a;

    public C12686i(C14094c0 c14094c0) {
        this.f58210a = c14094c0;
    }

    /* renamed from: a */
    public static void m76330a(C14120t c14120t) throws GeneralSecurityException {
        if (c14120t == null || c14120t.m84713P().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* renamed from: b */
    public static void m76331b(C14094c0 c14094c0) throws GeneralSecurityException {
        if (c14094c0 == null || c14094c0.m84479S() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* renamed from: c */
    public static C14094c0 m76332c(C14120t c14120t, InterfaceC12678a interfaceC12678a) throws GeneralSecurityException {
        try {
            C14094c0 c14094c0M84475W = C14094c0.m84475W(interfaceC12678a.mo89b(c14120t.m84713P().m11698u(), new byte[0]), C1944q.m12103b());
            m76331b(c14094c0M84475W);
            return c14094c0M84475W;
        } catch (C1903c0 unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* renamed from: d */
    public static C14120t m76333d(C14094c0 c14094c0, InterfaceC12678a interfaceC12678a) throws GeneralSecurityException {
        byte[] bArrMo88a = interfaceC12678a.mo88a(c14094c0.mo11460j(), new byte[0]);
        try {
            if (C14094c0.m84475W(interfaceC12678a.mo89b(bArrMo88a, new byte[0]), C1944q.m12103b()).equals(c14094c0)) {
                return C14120t.m84711Q().m84716x(AbstractC1920i.m11682f(bArrMo88a)).m84717y(C12696s.m76397b(c14094c0)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (C1903c0 unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* renamed from: e */
    public static final C12686i m76334e(C14094c0 c14094c0) throws GeneralSecurityException {
        m76331b(c14094c0);
        return new C12686i(c14094c0);
    }

    /* renamed from: j */
    public static final C12686i m76335j(InterfaceC12688k interfaceC12688k, InterfaceC12678a interfaceC12678a) throws GeneralSecurityException, IOException {
        C14120t c14120tMo76351a = interfaceC12688k.mo76351a();
        m76330a(c14120tMo76351a);
        return new C12686i(m76332c(c14120tMo76351a, interfaceC12678a));
    }

    /* renamed from: f */
    public C14094c0 m76336f() {
        return this.f58210a;
    }

    /* renamed from: g */
    public C14096d0 m76337g() {
        return C12696s.m76397b(this.f58210a);
    }

    /* renamed from: h */
    public <P> P m76338h(Class<P> cls) throws GeneralSecurityException {
        Class<?> clsM76376e = C12695r.m76376e(cls);
        if (clsM76376e != null) {
            return (P) m76339i(cls, clsM76376e);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    /* renamed from: i */
    public final <B, P> P m76339i(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        return (P) C12695r.m76391t(C12695r.m76382k(this, cls2), cls);
    }

    /* renamed from: k */
    public void m76340k(InterfaceC12689l interfaceC12689l, InterfaceC12678a interfaceC12678a) throws GeneralSecurityException, IOException {
        interfaceC12689l.mo76353b(m76333d(this.f58210a, interfaceC12678a));
    }

    public String toString() {
        return m76337g().toString();
    }
}
