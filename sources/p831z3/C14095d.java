package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.d */
/* loaded from: classes.dex */
public final class C14095d extends AbstractC1968z<C14095d, b> implements InterfaceC1954t0 {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final C14095d DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile InterfaceC1898a1<C14095d> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private C14099f aesCtrKey_;
    private C14122v hmacKey_;
    private int version_;

    /* renamed from: z3.d$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63090a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63090a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63090a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63090a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63090a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63090a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63090a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63090a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.d$b */
    public static final class b extends AbstractC1968z.a<C14095d, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84519x(C14099f c14099f) {
            m12402r();
            ((C14095d) this.f9423b).m84517V(c14099f);
            return this;
        }

        /* renamed from: y */
        public b m84520y(C14122v c14122v) {
            m12402r();
            ((C14095d) this.f9423b).m84518W(c14122v);
            return this;
        }

        /* renamed from: z */
        public b m84521z(int i10) {
            m12402r();
            ((C14095d) this.f9423b).m84513X(i10);
            return this;
        }

        public b() {
            super(C14095d.DEFAULT_INSTANCE);
        }
    }

    static {
        C14095d c14095d = new C14095d();
        DEFAULT_INSTANCE = c14095d;
        AbstractC1968z.m12384K(C14095d.class, c14095d);
    }

    /* renamed from: T */
    public static b m84511T() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: U */
    public static C14095d m84512U(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14095d) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m84513X(int i10) {
        this.version_ = i10;
    }

    /* renamed from: Q */
    public C14099f m84514Q() {
        C14099f c14099f = this.aesCtrKey_;
        return c14099f == null ? C14099f.m84566Q() : c14099f;
    }

    /* renamed from: R */
    public C14122v m84515R() {
        C14122v c14122v = this.hmacKey_;
        return c14122v == null ? C14122v.m84724Q() : c14122v;
    }

    /* renamed from: S */
    public int m84516S() {
        return this.version_;
    }

    /* renamed from: V */
    public final void m84517V(C14099f c14099f) {
        c14099f.getClass();
        this.aesCtrKey_ = c14099f;
    }

    /* renamed from: W */
    public final void m84518W(C14122v c14122v) {
        c14122v.getClass();
        this.hmacKey_ = c14122v;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63090a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14095d();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14095d> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14095d.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1968z.b<>(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } finally {
                        }
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
