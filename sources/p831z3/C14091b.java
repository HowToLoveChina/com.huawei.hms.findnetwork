package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.b */
/* loaded from: classes.dex */
public final class C14091b extends AbstractC1968z<C14091b, b> implements InterfaceC1954t0 {
    private static final C14091b DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14091b> PARSER;
    private int keySize_;
    private C14093c params_;

    /* renamed from: z3.b$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63086a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63086a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63086a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63086a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63086a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63086a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63086a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63086a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.b$b */
    public static final class b extends AbstractC1968z.a<C14091b, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C14091b.DEFAULT_INSTANCE);
        }
    }

    static {
        C14091b c14091b = new C14091b();
        DEFAULT_INSTANCE = c14091b;
        AbstractC1968z.m12384K(C14091b.class, c14091b);
    }

    /* renamed from: P */
    public static C14091b m84464P(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14091b) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: N */
    public int m84465N() {
        return this.keySize_;
    }

    /* renamed from: O */
    public C14093c m84466O() {
        C14093c c14093c = this.params_;
        return c14093c == null ? C14093c.m84469N() : c14093c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        switch (a.f63086a[fVar.ordinal()]) {
            case 1:
                return new C14091b();
            case 2:
                return new b(null);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"keySize_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14091b> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14091b.class) {
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
