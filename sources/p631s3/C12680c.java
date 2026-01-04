package p631s3;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import p831z3.C14094c0;
import p831z3.EnumC14106i0;

/* renamed from: s3.c */
/* loaded from: classes.dex */
public final class C12680c {

    /* renamed from: a */
    public static final byte[] f58192a = new byte[0];

    /* renamed from: s3.c$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58193a;

        static {
            int[] iArr = new int[EnumC14106i0.values().length];
            f58193a = iArr;
            try {
                iArr[EnumC14106i0.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58193a[EnumC14106i0.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58193a[EnumC14106i0.TINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f58193a[EnumC14106i0.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a */
    public static byte[] m76302a(C14094c0.c cVar) throws GeneralSecurityException {
        int i10 = a.f58193a[cVar.m84497T().ordinal()];
        if (i10 == 1 || i10 == 2) {
            return ByteBuffer.allocate(5).put((byte) 0).putInt(cVar.m84496S()).array();
        }
        if (i10 == 3) {
            return ByteBuffer.allocate(5).put((byte) 1).putInt(cVar.m84496S()).array();
        }
        if (i10 == 4) {
            return f58192a;
        }
        throw new GeneralSecurityException("unknown output prefix type");
    }
}
