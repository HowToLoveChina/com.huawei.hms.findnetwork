package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.d0 */
/* loaded from: classes.dex */
public final class C14096d0 extends AbstractC1968z<C14096d0, b> implements InterfaceC1954t0 {
    private static final C14096d0 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14096d0> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private C1900b0.i<c> keyInfo_ = AbstractC1968z.m12386v();
    private int primaryKeyId_;

    /* renamed from: z3.d0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63091a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63091a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63091a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63091a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63091a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63091a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63091a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63091a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.d0$b */
    public static final class b extends AbstractC1968z.a<C14096d0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84530x(c cVar) {
            m12402r();
            ((C14096d0) this.f9423b).m84527P(cVar);
            return this;
        }

        /* renamed from: y */
        public b m84531y(int i10) {
            m12402r();
            ((C14096d0) this.f9423b).m84526T(i10);
            return this;
        }

        public b() {
            super(C14096d0.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: z3.d0$c */
    public static final class c extends AbstractC1968z<c, a> implements InterfaceC1954t0 {
        private static final c DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile InterfaceC1898a1<c> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;
        private String typeUrl_ = "";

        /* renamed from: z3.d0$c$a */
        public static final class a extends AbstractC1968z.a<c, a> implements InterfaceC1954t0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            /* renamed from: A */
            public a m84543A(String str) {
                m12402r();
                ((c) this.f9423b).m84541W(str);
                return this;
            }

            /* renamed from: x */
            public a m84544x(int i10) {
                m12402r();
                ((c) this.f9423b).m84538T(i10);
                return this;
            }

            /* renamed from: y */
            public a m84545y(EnumC14106i0 enumC14106i0) {
                m12402r();
                ((c) this.f9423b).m84539U(enumC14106i0);
                return this;
            }

            /* renamed from: z */
            public a m84546z(EnumC14126z enumC14126z) {
                m12402r();
                ((c) this.f9423b).m84540V(enumC14126z);
                return this;
            }

            public a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            AbstractC1968z.m12384K(c.class, cVar);
        }

        /* renamed from: S */
        public static a m84537S() {
            return DEFAULT_INSTANCE.m12394r();
        }

        /* renamed from: T */
        public void m84538T(int i10) {
            this.keyId_ = i10;
        }

        /* renamed from: U */
        public void m84539U(EnumC14106i0 enumC14106i0) {
            this.outputPrefixType_ = enumC14106i0.mo11496a0();
        }

        /* renamed from: V */
        public void m84540V(EnumC14126z enumC14126z) {
            this.status_ = enumC14126z.mo11496a0();
        }

        /* renamed from: W */
        public void m84541W(String str) {
            str.getClass();
            this.typeUrl_ = str;
        }

        /* renamed from: R */
        public int m84542R() {
            return this.keyId_;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
        /* renamed from: u */
        public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
            switch (a.f63091a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(null);
                case 3:
                    return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    InterfaceC1898a1<c> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (c.class) {
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

    static {
        C14096d0 c14096d0 = new C14096d0();
        DEFAULT_INSTANCE = c14096d0;
        AbstractC1968z.m12384K(C14096d0.class, c14096d0);
    }

    /* renamed from: S */
    public static b m84525S() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: T */
    public void m84526T(int i10) {
        this.primaryKeyId_ = i10;
    }

    /* renamed from: P */
    public final void m84527P(c cVar) {
        cVar.getClass();
        m84528Q();
        this.keyInfo_.add(cVar);
    }

    /* renamed from: Q */
    public final void m84528Q() {
        if (this.keyInfo_.mo11499b0()) {
            return;
        }
        this.keyInfo_ = AbstractC1968z.m12377B(this.keyInfo_);
    }

    /* renamed from: R */
    public c m84529R(int i10) {
        return this.keyInfo_.get(i10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63091a[fVar.ordinal()]) {
            case 1:
                return new C14096d0();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14096d0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14096d0.class) {
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
