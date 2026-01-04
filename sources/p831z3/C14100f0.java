package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.f0 */
/* loaded from: classes.dex */
public final class C14100f0 extends AbstractC1968z<C14100f0, b> implements InterfaceC1954t0 {
    private static final C14100f0 DEFAULT_INSTANCE;
    public static final int KEY_URI_FIELD_NUMBER = 1;
    private static volatile InterfaceC1898a1<C14100f0> PARSER;
    private String keyUri_ = "";

    /* renamed from: z3.f0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63095a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63095a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63095a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63095a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63095a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63095a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63095a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63095a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.f0$b */
    public static final class b extends AbstractC1968z.a<C14100f0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C14100f0.DEFAULT_INSTANCE);
        }
    }

    static {
        C14100f0 c14100f0 = new C14100f0();
        DEFAULT_INSTANCE = c14100f0;
        AbstractC1968z.m12384K(C14100f0.class, c14100f0);
    }

    /* renamed from: N */
    public static C14100f0 m84579N() {
        return DEFAULT_INSTANCE;
    }

    /* renamed from: P */
    public static C14100f0 m84580P(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14100f0) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: O */
    public String m84581O() {
        return this.keyUri_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63095a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14100f0();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"keyUri_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14100f0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14100f0.class) {
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
