package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.e */
/* loaded from: classes.dex */
public final class C14097e extends AbstractC1968z<C14097e, b> implements InterfaceC1954t0 {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final C14097e DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14097e> PARSER;
    private C14101g aesCtrKeyFormat_;
    private C14123w hmacKeyFormat_;

    /* renamed from: z3.e$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63092a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63092a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63092a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63092a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63092a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63092a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63092a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63092a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.e$b */
    public static final class b extends AbstractC1968z.a<C14097e, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C14097e.DEFAULT_INSTANCE);
        }
    }

    static {
        C14097e c14097e = new C14097e();
        DEFAULT_INSTANCE = c14097e;
        AbstractC1968z.m12384K(C14097e.class, c14097e);
    }

    /* renamed from: P */
    public static C14097e m84548P(AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (C14097e) AbstractC1968z.m12379E(DEFAULT_INSTANCE, abstractC1920i, c1944q);
    }

    /* renamed from: N */
    public C14101g m84549N() {
        C14101g c14101g = this.aesCtrKeyFormat_;
        return c14101g == null ? C14101g.m84583N() : c14101g;
    }

    /* renamed from: O */
    public C14123w m84550O() {
        C14123w c14123w = this.hmacKeyFormat_;
        return c14123w == null ? C14123w.m84737N() : c14123w;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63092a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14097e();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14097e> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14097e.class) {
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
