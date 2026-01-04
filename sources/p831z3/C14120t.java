package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.t */
/* loaded from: classes.dex */
public final class C14120t extends AbstractC1968z<C14120t, b> implements InterfaceC1954t0 {
    private static final C14120t DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile InterfaceC1898a1<C14120t> PARSER;
    private AbstractC1920i encryptedKeyset_ = AbstractC1920i.f9147b;
    private C14096d0 keysetInfo_;

    /* renamed from: z3.t$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63123a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63123a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63123a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63123a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63123a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63123a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63123a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63123a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.t$b */
    public static final class b extends AbstractC1968z.a<C14120t, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84716x(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14120t) this.f9423b).m84714S(abstractC1920i);
            return this;
        }

        /* renamed from: y */
        public b m84717y(C14096d0 c14096d0) {
            m12402r();
            ((C14120t) this.f9423b).m84715T(c14096d0);
            return this;
        }

        public b() {
            super(C14120t.DEFAULT_INSTANCE);
        }
    }

    static {
        C14120t c14120t = new C14120t();
        DEFAULT_INSTANCE = c14120t;
        AbstractC1968z.m12384K(C14120t.class, c14120t);
    }

    /* renamed from: Q */
    public static b m84711Q() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: R */
    public static C14120t m84712R(byte[] bArr, C1944q c1944q) throws C1903c0 {
        return (C14120t) AbstractC1968z.m12380F(DEFAULT_INSTANCE, bArr, c1944q);
    }

    /* renamed from: P */
    public AbstractC1920i m84713P() {
        return this.encryptedKeyset_;
    }

    /* renamed from: S */
    public final void m84714S(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.encryptedKeyset_ = abstractC1920i;
    }

    /* renamed from: T */
    public final void m84715T(C14096d0 c14096d0) {
        c14096d0.getClass();
        this.keysetInfo_ = c14096d0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63123a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14120t();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14120t> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14120t.class) {
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
