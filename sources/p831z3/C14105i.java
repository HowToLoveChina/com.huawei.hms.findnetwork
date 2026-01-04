package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.i */
/* loaded from: classes.dex */
public final class C14105i extends AbstractC1968z<C14105i, b> implements InterfaceC1954t0 {
    private static final C14105i DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14105i> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC1920i keyValue_ = AbstractC1920i.f9147b;
    private C14109k params_;
    private int version_;

    /* renamed from: z3.i$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63100a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63100a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63100a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63100a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63100a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63100a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63100a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63100a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.i$b */
    public static final class b extends AbstractC1968z.a<C14105i, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84618x(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14105i) this.f9423b).m84612V(abstractC1920i);
            return this;
        }

        /* renamed from: y */
        public b m84619y(C14109k c14109k) {
            m12402r();
            ((C14105i) this.f9423b).m84617W(c14109k);
            return this;
        }

        /* renamed from: z */
        public b m84620z(int i10) {
            m12402r();
            ((C14105i) this.f9423b).m84613X(i10);
            return this;
        }

        public b() {
            super(C14105i.DEFAULT_INSTANCE);
        }
    }

    static {
        C14105i c14105i = new C14105i();
        DEFAULT_INSTANCE = c14105i;
        AbstractC1968z.m12384K(C14105i.class, c14105i);
    }

    /* renamed from: T */
    public static b m84610T() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: U */
    public static C14105i m84611U(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14105i) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m84612V(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.keyValue_ = abstractC1920i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m84613X(int i10) {
        this.version_ = i10;
    }

    /* renamed from: Q */
    public AbstractC1920i m84614Q() {
        return this.keyValue_;
    }

    /* renamed from: R */
    public C14109k m84615R() {
        C14109k c14109k = this.params_;
        return c14109k == null ? C14109k.m84630N() : c14109k;
    }

    /* renamed from: S */
    public int m84616S() {
        return this.version_;
    }

    /* renamed from: W */
    public final void m84617W(C14109k c14109k) {
        c14109k.getClass();
        this.params_ = c14109k;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63100a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14105i();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14105i> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14105i.class) {
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
