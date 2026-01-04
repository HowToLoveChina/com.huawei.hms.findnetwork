package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.a0 */
/* loaded from: classes.dex */
public final class C14090a0 extends AbstractC1968z<C14090a0, b> implements InterfaceC1954t0 {
    private static final C14090a0 DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile InterfaceC1898a1<C14090a0> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private AbstractC1920i value_ = AbstractC1920i.f9147b;

    /* renamed from: z3.a0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63085a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63085a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63085a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63085a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63085a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63085a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63085a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63085a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.a0$b */
    public static final class b extends AbstractC1968z.a<C14090a0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84460x(EnumC14106i0 enumC14106i0) {
            m12402r();
            ((C14090a0) this.f9423b).m84459V(enumC14106i0);
            return this;
        }

        /* renamed from: y */
        public b m84461y(String str) {
            m12402r();
            ((C14090a0) this.f9423b).m84454W(str);
            return this;
        }

        /* renamed from: z */
        public b m84462z(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14090a0) this.f9423b).m84455X(abstractC1920i);
            return this;
        }

        public b() {
            super(C14090a0.DEFAULT_INSTANCE);
        }
    }

    static {
        C14090a0 c14090a0 = new C14090a0();
        DEFAULT_INSTANCE = c14090a0;
        AbstractC1968z.m12384K(C14090a0.class, c14090a0);
    }

    /* renamed from: Q */
    public static C14090a0 m84452Q() {
        return DEFAULT_INSTANCE;
    }

    /* renamed from: U */
    public static b m84453U() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: W */
    public void m84454W(String str) {
        str.getClass();
        this.typeUrl_ = str;
    }

    /* renamed from: X */
    public void m84455X(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.value_ = abstractC1920i;
    }

    /* renamed from: R */
    public EnumC14106i0 m84456R() {
        EnumC14106i0 enumC14106i0M84621b = EnumC14106i0.m84621b(this.outputPrefixType_);
        return enumC14106i0M84621b == null ? EnumC14106i0.UNRECOGNIZED : enumC14106i0M84621b;
    }

    /* renamed from: S */
    public String m84457S() {
        return this.typeUrl_;
    }

    /* renamed from: T */
    public AbstractC1920i m84458T() {
        return this.value_;
    }

    /* renamed from: V */
    public final void m84459V(EnumC14106i0 enumC14106i0) {
        this.outputPrefixType_ = enumC14106i0.mo11496a0();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63085a[fVar.ordinal()]) {
            case 1:
                return new C14090a0();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14090a0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14090a0.class) {
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
