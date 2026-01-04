package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.a */
/* loaded from: classes.dex */
public final class C14089a extends AbstractC1968z<C14089a, b> implements InterfaceC1954t0 {
    private static final C14089a DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile InterfaceC1898a1<C14089a> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC1920i keyValue_ = AbstractC1920i.f9147b;
    private C14093c params_;
    private int version_;

    /* renamed from: z3.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63084a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63084a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63084a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63084a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63084a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63084a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63084a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63084a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.a$b */
    public static final class b extends AbstractC1968z.a<C14089a, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84445x(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14089a) this.f9423b).m84442V(abstractC1920i);
            return this;
        }

        /* renamed from: y */
        public b m84446y(C14093c c14093c) {
            m12402r();
            ((C14089a) this.f9423b).m84443W(c14093c);
            return this;
        }

        /* renamed from: z */
        public b m84447z(int i10) {
            m12402r();
            ((C14089a) this.f9423b).m84444X(i10);
            return this;
        }

        public b() {
            super(C14089a.DEFAULT_INSTANCE);
        }
    }

    static {
        C14089a c14089a = new C14089a();
        DEFAULT_INSTANCE = c14089a;
        AbstractC1968z.m12384K(C14089a.class, c14089a);
    }

    /* renamed from: T */
    public static b m84437T() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: U */
    public static C14089a m84438U(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14089a) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: Q */
    public AbstractC1920i m84439Q() {
        return this.keyValue_;
    }

    /* renamed from: R */
    public C14093c m84440R() {
        C14093c c14093c = this.params_;
        return c14093c == null ? C14093c.m84469N() : c14093c;
    }

    /* renamed from: S */
    public int m84441S() {
        return this.version_;
    }

    /* renamed from: V */
    public final void m84442V(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.keyValue_ = abstractC1920i;
    }

    /* renamed from: W */
    public final void m84443W(C14093c c14093c) {
        c14093c.getClass();
        this.params_ = c14093c;
    }

    /* renamed from: X */
    public final void m84444X(int i10) {
        this.version_ = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63084a[fVar.ordinal()]) {
            case 1:
                return new C14089a();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14089a> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14089a.class) {
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
