package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.n */
/* loaded from: classes.dex */
public final class C14114n extends AbstractC1968z<C14114n, b> implements InterfaceC1954t0 {
    private static final C14114n DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile InterfaceC1898a1<C14114n> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC1920i keyValue_ = AbstractC1920i.f9147b;
    private int version_;

    /* renamed from: z3.n$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63117a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63117a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63117a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63117a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63117a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63117a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63117a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63117a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.n$b */
    public static final class b extends AbstractC1968z.a<C14114n, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84672x(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14114n) this.f9423b).m84668T(abstractC1920i);
            return this;
        }

        /* renamed from: y */
        public b m84673y(int i10) {
            m12402r();
            ((C14114n) this.f9423b).m84669U(i10);
            return this;
        }

        public b() {
            super(C14114n.DEFAULT_INSTANCE);
        }
    }

    static {
        C14114n c14114n = new C14114n();
        DEFAULT_INSTANCE = c14114n;
        AbstractC1968z.m12384K(C14114n.class, c14114n);
    }

    /* renamed from: R */
    public static b m84666R() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: S */
    public static C14114n m84667S(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14114n) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public void m84668T(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.keyValue_ = abstractC1920i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public void m84669U(int i10) {
        this.version_ = i10;
    }

    /* renamed from: P */
    public AbstractC1920i m84670P() {
        return this.keyValue_;
    }

    /* renamed from: Q */
    public int m84671Q() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63117a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14114n();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14114n> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14114n.class) {
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
