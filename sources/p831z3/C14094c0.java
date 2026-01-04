package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;
import java.util.Collections;
import java.util.List;

/* renamed from: z3.c0 */
/* loaded from: classes.dex */
public final class C14094c0 extends AbstractC1968z<C14094c0, b> implements InterfaceC1954t0 {
    private static final C14094c0 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14094c0> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private C1900b0.i<c> key_ = AbstractC1968z.m12386v();
    private int primaryKeyId_;

    /* renamed from: z3.c0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63089a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63089a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63089a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63089a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63089a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63089a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63089a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63089a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.c0$b */
    public static final class b extends AbstractC1968z.a<C14094c0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: A */
        public List<c> m84483A() {
            return Collections.unmodifiableList(((C14094c0) this.f9423b).m84480T());
        }

        /* renamed from: B */
        public b m84484B(int i10) {
            m12402r();
            ((C14094c0) this.f9423b).m84482X(i10);
            return this;
        }

        /* renamed from: x */
        public b m84485x(c cVar) {
            m12402r();
            ((C14094c0) this.f9423b).m84476P(cVar);
            return this;
        }

        /* renamed from: y */
        public c m84486y(int i10) {
            return ((C14094c0) this.f9423b).m84478R(i10);
        }

        /* renamed from: z */
        public int m84487z() {
            return ((C14094c0) this.f9423b).m84479S();
        }

        public b() {
            super(C14094c0.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: z3.c0$c */
    public static final class c extends AbstractC1968z<c, a> implements InterfaceC1954t0 {
        private static final c DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile InterfaceC1898a1<c> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private C14125y keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        /* renamed from: z3.c0$c$a */
        public static final class a extends AbstractC1968z.a<c, a> implements InterfaceC1954t0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            /* renamed from: A */
            public a m84503A(EnumC14126z enumC14126z) {
                m12402r();
                ((c) this.f9423b).m84502a0(enumC14126z);
                return this;
            }

            /* renamed from: x */
            public a m84504x(C14125y c14125y) {
                m12402r();
                ((c) this.f9423b).m84500X(c14125y);
                return this;
            }

            /* renamed from: y */
            public a m84505y(int i10) {
                m12402r();
                ((c) this.f9423b).m84501Y(i10);
                return this;
            }

            /* renamed from: z */
            public a m84506z(EnumC14106i0 enumC14106i0) {
                m12402r();
                ((c) this.f9423b).m84494Z(enumC14106i0);
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

        /* renamed from: W */
        public static a m84493W() {
            return DEFAULT_INSTANCE.m12394r();
        }

        /* renamed from: Z */
        public void m84494Z(EnumC14106i0 enumC14106i0) {
            this.outputPrefixType_ = enumC14106i0.mo11496a0();
        }

        /* renamed from: R */
        public C14125y m84495R() {
            C14125y c14125y = this.keyData_;
            return c14125y == null ? C14125y.m84749Q() : c14125y;
        }

        /* renamed from: S */
        public int m84496S() {
            return this.keyId_;
        }

        /* renamed from: T */
        public EnumC14106i0 m84497T() {
            EnumC14106i0 enumC14106i0M84621b = EnumC14106i0.m84621b(this.outputPrefixType_);
            return enumC14106i0M84621b == null ? EnumC14106i0.UNRECOGNIZED : enumC14106i0M84621b;
        }

        /* renamed from: U */
        public EnumC14126z m84498U() {
            EnumC14126z enumC14126zM84762b = EnumC14126z.m84762b(this.status_);
            return enumC14126zM84762b == null ? EnumC14126z.UNRECOGNIZED : enumC14126zM84762b;
        }

        /* renamed from: V */
        public boolean m84499V() {
            return this.keyData_ != null;
        }

        /* renamed from: X */
        public final void m84500X(C14125y c14125y) {
            c14125y.getClass();
            this.keyData_ = c14125y;
        }

        /* renamed from: Y */
        public final void m84501Y(int i10) {
            this.keyId_ = i10;
        }

        /* renamed from: a0 */
        public final void m84502a0(EnumC14126z enumC14126z) {
            this.status_ = enumC14126z.mo11496a0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
        /* renamed from: u */
        public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
            switch (a.f63089a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(null);
                case 3:
                    return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
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
        C14094c0 c14094c0 = new C14094c0();
        DEFAULT_INSTANCE = c14094c0;
        AbstractC1968z.m12384K(C14094c0.class, c14094c0);
    }

    /* renamed from: V */
    public static b m84474V() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: W */
    public static C14094c0 m84475W(byte[] bArr, C1944q c1944q) throws C1903c0 {
        return (C14094c0) AbstractC1968z.m12380F(DEFAULT_INSTANCE, bArr, c1944q);
    }

    /* renamed from: P */
    public final void m84476P(c cVar) {
        cVar.getClass();
        m84477Q();
        this.key_.add(cVar);
    }

    /* renamed from: Q */
    public final void m84477Q() {
        if (this.key_.mo11499b0()) {
            return;
        }
        this.key_ = AbstractC1968z.m12377B(this.key_);
    }

    /* renamed from: R */
    public c m84478R(int i10) {
        return this.key_.get(i10);
    }

    /* renamed from: S */
    public int m84479S() {
        return this.key_.size();
    }

    /* renamed from: T */
    public List<c> m84480T() {
        return this.key_;
    }

    /* renamed from: U */
    public int m84481U() {
        return this.primaryKeyId_;
    }

    /* renamed from: X */
    public final void m84482X(int i10) {
        this.primaryKeyId_ = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63089a[fVar.ordinal()]) {
            case 1:
                return new C14094c0();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14094c0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14094c0.class) {
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
