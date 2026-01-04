package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.e0 */
/* loaded from: classes.dex */
public final class C14098e0 extends AbstractC1968z<C14098e0, b> implements InterfaceC1954t0 {
    private static final C14098e0 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14098e0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private C14100f0 params_;
    private int version_;

    /* renamed from: z3.e0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63093a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63093a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63093a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63093a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63093a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63093a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63093a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63093a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.e0$b */
    public static final class b extends AbstractC1968z.a<C14098e0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84560x(C14100f0 c14100f0) {
            m12402r();
            ((C14098e0) this.f9423b).m84559T(c14100f0);
            return this;
        }

        /* renamed from: y */
        public b m84561y(int i10) {
            m12402r();
            ((C14098e0) this.f9423b).m84556U(i10);
            return this;
        }

        public b() {
            super(C14098e0.DEFAULT_INSTANCE);
        }
    }

    static {
        C14098e0 c14098e0 = new C14098e0();
        DEFAULT_INSTANCE = c14098e0;
        AbstractC1968z.m12384K(C14098e0.class, c14098e0);
    }

    /* renamed from: R */
    public static b m84554R() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: S */
    public static C14098e0 m84555S(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14098e0) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public void m84556U(int i10) {
        this.version_ = i10;
    }

    /* renamed from: P */
    public C14100f0 m84557P() {
        C14100f0 c14100f0 = this.params_;
        return c14100f0 == null ? C14100f0.m84579N() : c14100f0;
    }

    /* renamed from: Q */
    public int m84558Q() {
        return this.version_;
    }

    /* renamed from: T */
    public final void m84559T(C14100f0 c14100f0) {
        c14100f0.getClass();
        this.params_ = c14100f0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63093a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14098e0();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14098e0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14098e0.class) {
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
