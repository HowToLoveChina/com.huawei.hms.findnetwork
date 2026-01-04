package p761x3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
import p005a4.C0039s;
import p005a4.C0040t;
import p005a4.C0041u;
import p005a4.C0043w;
import p631s3.AbstractC12685h;
import p631s3.C12695r;
import p631s3.InterfaceC12692o;
import p831z3.C14122v;
import p831z3.C14123w;
import p831z3.C14124x;
import p831z3.C14125y;
import p831z3.EnumC14121u;

/* renamed from: x3.b */
/* loaded from: classes.dex */
public final class C13691b extends AbstractC12685h<C14122v> {

    /* renamed from: x3.b$a */
    public class a extends AbstractC12685h.b<InterfaceC12692o, C14122v> {
        public a(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC12692o mo76328a(C14122v c14122v) throws GeneralSecurityException {
            EnumC14121u enumC14121uM84743O = c14122v.m84730S().m84743O();
            SecretKeySpec secretKeySpec = new SecretKeySpec(c14122v.m84729R().m11698u(), "HMAC");
            int iM84744P = c14122v.m84730S().m84744P();
            int i10 = c.f61623a[enumC14121uM84743O.ordinal()];
            if (i10 == 1) {
                return new C0040t(new C0039s("HMACSHA1", secretKeySpec), iM84744P);
            }
            if (i10 == 2) {
                return new C0040t(new C0039s("HMACSHA256", secretKeySpec), iM84744P);
            }
            if (i10 == 3) {
                return new C0040t(new C0039s("HMACSHA512", secretKeySpec), iM84744P);
            }
            throw new GeneralSecurityException("unknown hash");
        }
    }

    /* renamed from: x3.b$b */
    public class b extends AbstractC12685h.a<C14123w, C14122v> {
        public b(Class cls) {
            super(cls);
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C14122v mo76324a(C14123w c14123w) throws GeneralSecurityException {
            return C14122v.m84725U().m84735z(C13691b.this.m82311k()).m84734y(c14123w.m84740P()).m84733x(AbstractC1920i.m11682f(C0041u.m161c(c14123w.m84739O()))).build();
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C14123w mo76326c(AbstractC1920i abstractC1920i) throws C1903c0 {
            return C14123w.m84738Q(abstractC1920i, C1944q.m12103b());
        }

        @Override // p631s3.AbstractC12685h.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void mo76327d(C14123w c14123w) throws GeneralSecurityException {
            if (c14123w.m84739O() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            C13691b.m82310o(c14123w.m84740P());
        }
    }

    /* renamed from: x3.b$c */
    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f61623a;

        static {
            int[] iArr = new int[EnumC14121u.values().length];
            f61623a = iArr;
            try {
                iArr[EnumC14121u.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61623a[EnumC14121u.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61623a[EnumC14121u.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C13691b() {
        super(C14122v.class, new a(InterfaceC12692o.class));
    }

    /* renamed from: m */
    public static void m82309m(boolean z10) throws GeneralSecurityException {
        C12695r.m76388q(new C13691b(), z10);
    }

    /* renamed from: o */
    public static void m82310o(C14124x c14124x) throws GeneralSecurityException {
        if (c14124x.m84744P() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i10 = c.f61623a[c14124x.m84743O().ordinal()];
        if (i10 == 1) {
            if (c14124x.m84744P() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i10 == 2) {
            if (c14124x.m84744P() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i10 != 3) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (c14124x.m84744P() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: c */
    public String mo76317c() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: e */
    public AbstractC12685h.a<C14123w, C14122v> mo76319e() {
        return new b(C14123w.class);
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: f */
    public C14125y.c mo76320f() {
        return C14125y.c.SYMMETRIC;
    }

    /* renamed from: k */
    public int m82311k() {
        return 0;
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C14122v mo76321g(AbstractC1920i abstractC1920i) throws C1903c0 {
        return C14122v.m84726V(abstractC1920i, C1944q.m12103b());
    }

    @Override // p631s3.AbstractC12685h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void mo76323i(C14122v c14122v) throws GeneralSecurityException {
        C0043w.m167c(c14122v.m84731T(), m82311k());
        if (c14122v.m84729R().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        m82310o(c14122v.m84730S());
    }
}
