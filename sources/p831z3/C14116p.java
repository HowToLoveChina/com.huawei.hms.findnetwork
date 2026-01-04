package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.p */
/* loaded from: classes.dex */
public final class C14116p extends AbstractC1968z<C14116p, b> implements InterfaceC1954t0 {
    private static final C14116p DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14116p> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC1920i keyValue_ = AbstractC1920i.f9147b;
    private int version_;

    /* renamed from: z3.p$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63119a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63119a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63119a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63119a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63119a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63119a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63119a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63119a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.p$b */
    public static final class b extends AbstractC1968z.a<C14116p, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84686x(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14116p) this.f9423b).m84682T(abstractC1920i);
            return this;
        }

        /* renamed from: y */
        public b m84687y(int i10) {
            m12402r();
            ((C14116p) this.f9423b).m84683U(i10);
            return this;
        }

        public b() {
            super(C14116p.DEFAULT_INSTANCE);
        }
    }

    static {
        C14116p c14116p = new C14116p();
        DEFAULT_INSTANCE = c14116p;
        AbstractC1968z.m12384K(C14116p.class, c14116p);
    }

    /* renamed from: R */
    public static b m84680R() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: S */
    public static C14116p m84681S(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14116p) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: T */
    public void m84682T(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.keyValue_ = abstractC1920i;
    }

    /* renamed from: U */
    public void m84683U(int i10) {
        this.version_ = i10;
    }

    /* renamed from: P */
    public AbstractC1920i m84684P() {
        return this.keyValue_;
    }

    /* renamed from: Q */
    public int m84685Q() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63119a[fVar.ordinal()]) {
            case 1:
                return new C14116p();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14116p> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14116p.class) {
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
