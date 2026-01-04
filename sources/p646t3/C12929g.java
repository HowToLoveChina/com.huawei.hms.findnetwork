package p646t3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p667u3.C13121a;
import p831z3.C14114n;
import p831z3.C14115o;
import p831z3.C14125y;

/* renamed from: t3.g */
/* loaded from: classes.dex */
public final class C12929g extends AbstractC12685h<C14114n> {

    /* renamed from: t3.g$a */
    public class a extends AbstractC12685h.b<InterfaceC12678a, C14114n> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12678a mo76328a(C14114n c14114n) throws GeneralSecurityException {
            return new C13121a(c14114n.m84670P().m11698u());
        }
    }

    /* renamed from: t3.g$b */
    public class b extends AbstractC12685h.a<C14115o, C14114n> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14114n mo76324a(C14115o c14115o) {
            return C14114n.m84666R().m84672x(AbstractC1920i.m11682f(C0041u.m161c(c14115o.m84676N()))).m84673y(C12929g.this.m77626k()).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14115o mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14115o.m84675O(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14115o c14115o) throws GeneralSecurityException {
            C0043w.m165a(c14115o.m84676N());
        }
    }

    public C12929g() {
        super(C14114n.class, new a(InterfaceC12678a.class));
    }

    /* renamed from: j */
    public static boolean m77624j() throws NoSuchPaddingException, NoSuchAlgorithmException {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    /* renamed from: m */
    public static void m77625m(boolean z10) throws GeneralSecurityException {
        if (m77624j()) {
            C12695r.m76388q(new C12929g(), z10);
        }
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14115o, C14114n> mo76319e() {
        return new b(C14115o.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: k */
    public int m77626k() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C14114n mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14114n.m84667S(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14114n c14114n) throws GeneralSecurityException {
        C0043w.m167c(c14114n.m84671Q(), m77626k());
        C0043w.m165a(c14114n.m84670P().size());
    }
}
