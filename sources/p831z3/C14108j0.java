package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

@Deprecated
/* renamed from: z3.j0 */
/* loaded from: classes.dex */
public final class C14108j0 extends AbstractC1968z<C14108j0, b> implements InterfaceC1954t0 {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    private static final C14108j0 DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    private static volatile InterfaceC1898a1<C14108j0> PARSER;
    private String configName_ = "";
    private C1900b0.i<C14092b0> entry_ = AbstractC1968z.m12386v();

    /* renamed from: z3.j0$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63111a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63111a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63111a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63111a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63111a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63111a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63111a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63111a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.j0$b */
    public static final class b extends AbstractC1968z.a<C14108j0, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C14108j0.DEFAULT_INSTANCE);
        }
    }

    static {
        C14108j0 c14108j0 = new C14108j0();
        DEFAULT_INSTANCE = c14108j0;
        AbstractC1968z.m12384K(C14108j0.class, c14108j0);
    }

    /* renamed from: N */
    public static C14108j0 m84628N() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63111a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14108j0();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"configName_", "entry_", C14092b0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14108j0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14108j0.class) {
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
