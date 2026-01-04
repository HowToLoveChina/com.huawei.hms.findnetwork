package p831z3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0;

/* renamed from: z3.y */
/* loaded from: classes.dex */
public final class C14125y extends AbstractC1968z<C14125y, b> implements InterfaceC1954t0 {
    private static final C14125y DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile InterfaceC1898a1<C14125y> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private AbstractC1920i value_ = AbstractC1920i.f9147b;

    /* renamed from: z3.y$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f63136a;

        static {
            int[] iArr = new int[AbstractC1968z.f.values().length];
            f63136a = iArr;
            try {
                iArr[AbstractC1968z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63136a[AbstractC1968z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63136a[AbstractC1968z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63136a[AbstractC1968z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63136a[AbstractC1968z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63136a[AbstractC1968z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63136a[AbstractC1968z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: z3.y$b */
    public static final class b extends AbstractC1968z.a<C14125y, b> implements InterfaceC1954t0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: x */
        public b m84757x(c cVar) {
            m12402r();
            ((C14125y) this.f9423b).m84754V(cVar);
            return this;
        }

        /* renamed from: y */
        public b m84758y(String str) {
            m12402r();
            ((C14125y) this.f9423b).m84755W(str);
            return this;
        }

        /* renamed from: z */
        public b m84759z(AbstractC1920i abstractC1920i) {
            m12402r();
            ((C14125y) this.f9423b).m84756X(abstractC1920i);
            return this;
        }

        public b() {
            super(C14125y.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: z3.y$c */
    public enum c implements C1900b0.c {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);


        /* renamed from: h */
        public static final C1900b0.d<c> f63143h = new a();

        /* renamed from: a */
        public final int f63145a;

        /* renamed from: z3.y$c$a */
        public class a implements C1900b0.d<c> {
            @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c mo11497a(int i10) {
                return c.m84760b(i10);
            }
        }

        c(int i10) {
            this.f63145a = i10;
        }

        /* renamed from: b */
        public static c m84760b(int i10) {
            if (i10 == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i10 == 1) {
                return SYMMETRIC;
            }
            if (i10 == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i10 == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i10 != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.c
        /* renamed from: a0 */
        public final int mo11496a0() {
            if (this != UNRECOGNIZED) {
                return this.f63145a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C14125y c14125y = new C14125y();
        DEFAULT_INSTANCE = c14125y;
        AbstractC1968z.m12384K(C14125y.class, c14125y);
    }

    /* renamed from: Q */
    public static C14125y m84749Q() {
        return DEFAULT_INSTANCE;
    }

    /* renamed from: U */
    public static b m84750U() {
        return DEFAULT_INSTANCE.m12394r();
    }

    /* renamed from: R */
    public c m84751R() {
        c cVarM84760b = c.m84760b(this.keyMaterialType_);
        return cVarM84760b == null ? c.UNRECOGNIZED : cVarM84760b;
    }

    /* renamed from: S */
    public String m84752S() {
        return this.typeUrl_;
    }

    /* renamed from: T */
    public AbstractC1920i m84753T() {
        return this.value_;
    }

    /* renamed from: V */
    public final void m84754V(c cVar) {
        this.keyMaterialType_ = cVar.mo11496a0();
    }

    /* renamed from: W */
    public final void m84755W(String str) {
        str.getClass();
        this.typeUrl_ = str;
    }

    /* renamed from: X */
    public final void m84756X(AbstractC1920i abstractC1920i) {
        abstractC1920i.getClass();
        this.value_ = abstractC1920i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1968z
    /* renamed from: u */
    public final Object mo12397u(AbstractC1968z.f fVar, Object obj, Object obj2) {
        int i10 = a.f63136a[fVar.ordinal()];
        a aVar = null;
        switch (i10) {
            case 1:
                return new C14125y();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1968z.m12378D(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC1898a1<C14125y> bVar = PARSER;
                if (bVar == null) {
                    synchronized (C14125y.class) {
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
