package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.v */
/* loaded from: classes.dex */
public final class C14122v extends AbstractC1968z<C14122v, b> implements InterfaceC1954t0 {
    private static final C14122v DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14122v> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC1920i keyValue_ = AbstractC1920i.f9147b;
    private C14124x params_;
    private int version_;

    /* renamed from: z3.v$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63133a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63133a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63133a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63133a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63133a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63133a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63133a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63133a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.v$b */
    public static final class b extends AbstractC1968z.a<C14122v, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84733x(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14122v) this.f9423b).m84727W(abstractC1920i);
            return this;
        }

        /* renamed from: y */
        public b m84734y(C14124x c14124x) {
            m12402r();
            ((C14122v) this.f9423b).m84732X(c14124x);
            return this;
        }

        /* renamed from: z */
        public b m84735z(int i10) {
            m12402r();
            ((C14122v) this.f9423b).m84728Y(i10);
            return this;
        }

        public b() {
            super(C14122v.DEFAULT_INSTANCE);
        }
    }

    static {
        C14122v c14122v = new C14122v();
        DEFAULT_INSTANCE = c14122v;
        AbstractC1968z.m12384K(C14122v.class, c14122v);
    }

    /* renamed from: Q */
    public static C14122v m84724Q() {
        return DEFAULT_INSTANCE;
    }

    /* renamed from: U */
    public static b m84725U() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: V */
    public static C14122v m84726V(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14122v) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: W */
    public void m84727W(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.keyValue_ = abstractC1920i;
    }

    /* renamed from: Y */
    public void m84728Y(int i10) {
        this.version_ = i10;
    }

    /* renamed from: R */
    public AbstractC1920i m84729R() {
        return this.keyValue_;
    }

    /* renamed from: S */
    public C14124x m84730S() {
        C14124x c14124x = this.params_;
        return c14124x == null ? C14124x.m84742N() : c14124x;
    }

    /* renamed from: T */
    public int m84731T() {
        return this.version_;
    }

    /* renamed from: X */
    public final void m84732X(C14124x c14124x) {
        c14124x.getClass();
        this.params_ = c14124x;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63133a[fVar.ordinal()]) {
            case 1:
                return new C14122v();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14122v> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14122v.class) {
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
