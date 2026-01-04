package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.o */
/* loaded from: classes.dex */
public final class C14115o extends AbstractC1968z<C14115o, b> implements InterfaceC1954t0 {
    private static final C14115o DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14115o> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int keySize_;
    private int version_;

    /* renamed from: z3.o$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63118a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63118a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63118a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63118a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63118a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63118a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63118a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63118a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.o$b */
    public static final class b extends AbstractC1968z.a<C14115o, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C14115o.DEFAULT_INSTANCE);
        }
    }

    static {
        C14115o c14115o = new C14115o();
        DEFAULT_INSTANCE = c14115o;
        AbstractC1968z.m12384K(C14115o.class, c14115o);
    }

    /* renamed from: O */
    public static C14115o m84675O(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14115o) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: N */
    public int m84676N() {
        return this.keySize_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63118a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14115o();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"version_", "keySize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14115o> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14115o.class) {
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
