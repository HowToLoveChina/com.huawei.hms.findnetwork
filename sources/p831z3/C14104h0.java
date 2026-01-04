package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.h0 */
/* loaded from: classes.dex */
public final class C14104h0 extends AbstractC1968z<C14104h0, b> implements InterfaceC1954t0 {
    private static final C14104h0 DEFAULT_INSTANCE;
    public static final int DEK_TEMPLATE_FIELD_NUMBER = 2;
    public static final int KEK_URI_FIELD_NUMBER = 1;
    private static volatile InterfaceC1898a1<C14104h0> PARSER;
    private C14090a0 dekTemplate_;
    private String kekUri_ = "";

    /* renamed from: z3.h0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63099a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63099a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63099a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63099a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63099a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63099a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63099a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63099a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.h0$b */
    public static final class b extends AbstractC1968z.a<C14104h0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C14104h0.DEFAULT_INSTANCE);
        }
    }

    static {
        C14104h0 c14104h0 = new C14104h0();
        DEFAULT_INSTANCE = c14104h0;
        AbstractC1968z.m12384K(C14104h0.class, c14104h0);
    }

    /* renamed from: N */
    public static C14104h0 m84602N() {
        return DEFAULT_INSTANCE;
    }

    /* renamed from: Q */
    public static C14104h0 m84603Q(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14104h0) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: O */
    public C14090a0 m84604O() {
        C14090a0 c14090a0 = this.dekTemplate_;
        return c14090a0 == null ? C14090a0.m84452Q() : c14090a0;
    }

    /* renamed from: P */
    public String m84605P() {
        return this.kekUri_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63099a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14104h0();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"kekUri_", "dekTemplate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14104h0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14104h0.class) {
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
