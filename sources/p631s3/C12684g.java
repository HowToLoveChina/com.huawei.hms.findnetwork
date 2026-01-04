package p631s3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import p831z3.C14090a0;
import p831z3.EnumC14106i0;

/* renamed from: s3.g */
/* loaded from: classes.dex */
public final class C12684g {

    /* renamed from: a */
    public final C14090a0 f58197a;

    /* renamed from: s3.g$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58198a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f58199b;

        static {
            int[] iArr = new int[b.values().length];
            f58199b = iArr;
            try {
                iArr[b.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58199b[b.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58199b[b.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f58199b[b.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EnumC14106i0.values().length];
            f58198a = iArr2;
            try {
                iArr2[EnumC14106i0.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f58198a[EnumC14106i0.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f58198a[EnumC14106i0.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f58198a[EnumC14106i0.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: s3.g$b */
    public enum b {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    public C12684g(C14090a0 c14090a0) {
        this.f58197a = c14090a0;
    }

    /* renamed from: a */
    public static C12684g m76312a(String str, byte[] bArr, b bVar) {
        return new C12684g(C14090a0.m84453U().m84461y(str).m84462z(AbstractC1920i.m11682f(bArr)).m84460x(m76313c(bVar)).build());
    }

    /* renamed from: c */
    public static EnumC14106i0 m76313c(b bVar) {
        int i10 = a.f58199b[bVar.ordinal()];
        if (i10 == 1) {
            return EnumC14106i0.TINK;
        }
        if (i10 == 2) {
            return EnumC14106i0.LEGACY;
        }
        if (i10 == 3) {
            return EnumC14106i0.RAW;
        }
        if (i10 == 4) {
            return EnumC14106i0.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    /* renamed from: b */
    public C14090a0 m76314b() {
        return this.f58197a;
    }
}
