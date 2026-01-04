package p508o3;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import p468m3.C11397c;
import p508o3.C11799d;
import p543p3.C12084a;
import p565q3.C12277a;
import p565q3.C12279c;

/* renamed from: o3.e */
/* loaded from: classes.dex */
public abstract class EnumC11800e extends Enum<EnumC11800e> implements C11799d.c {

    /* renamed from: a */
    public static final EnumC11800e f54679a = new a("MURMUR128_MITZ_32", 0);

    /* renamed from: b */
    public static final EnumC11800e f54680b = new EnumC11800e("MURMUR128_MITZ_64", 1) { // from class: o3.e.b
        public b(String str, int i10) {
            super(str, i10, null);
        }

        @Override // p508o3.C11799d.c
        /* renamed from: a */
        public <T> boolean mo70333a(T t10, InterfaceC11801f<? super T> interfaceC11801f, int i10, c cVar) {
            long jM70338a = cVar.m70338a();
            byte[] bArrMo70350h = C11806k.m70353a().mo70309b(t10, interfaceC11801f).mo70350h();
            long jM70335e = m70335e(bArrMo70350h);
            long jM70336f = m70336f(bArrMo70350h);
            long j10 = jM70335e;
            boolean zM70340c = false;
            for (int i11 = 0; i11 < i10; i11++) {
                zM70340c |= cVar.m70340c((Long.MAX_VALUE & j10) % jM70338a);
                j10 += jM70336f;
            }
            return zM70340c;
        }

        /* renamed from: e */
        public final long m70335e(byte[] bArr) {
            return C12279c.m73803a(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        /* renamed from: f */
        public final long m70336f(byte[] bArr) {
            return C12279c.m73803a(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }
    };

    /* renamed from: c */
    public static final /* synthetic */ EnumC11800e[] f54681c = m70334b();

    /* renamed from: o3.e$a */
    public enum a extends EnumC11800e {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // p508o3.C11799d.c
        /* renamed from: a */
        public <T> boolean mo70333a(T t10, InterfaceC11801f<? super T> interfaceC11801f, int i10, c cVar) {
            long jM70338a = cVar.m70338a();
            long jMo70347d = C11806k.m70353a().mo70309b(t10, interfaceC11801f).mo70347d();
            int i11 = (int) jMo70347d;
            int i12 = (int) (jMo70347d >>> 32);
            boolean zM70340c = false;
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                zM70340c |= cVar.m70340c(i14 % jM70338a);
            }
            return zM70340c;
        }
    }

    /* renamed from: o3.e$b */
    public enum b extends EnumC11800e {
        public b(String str, int i10) {
            super(str, i10, null);
        }

        @Override // p508o3.C11799d.c
        /* renamed from: a */
        public <T> boolean mo70333a(T t10, InterfaceC11801f<? super T> interfaceC11801f, int i10, c cVar) {
            long jM70338a = cVar.m70338a();
            byte[] bArrMo70350h = C11806k.m70353a().mo70309b(t10, interfaceC11801f).mo70350h();
            long jM70335e = m70335e(bArrMo70350h);
            long jM70336f = m70336f(bArrMo70350h);
            long j10 = jM70335e;
            boolean zM70340c = false;
            for (int i11 = 0; i11 < i10; i11++) {
                zM70340c |= cVar.m70340c((Long.MAX_VALUE & j10) % jM70338a);
                j10 += jM70336f;
            }
            return zM70340c;
        }

        /* renamed from: e */
        public final long m70335e(byte[] bArr) {
            return C12279c.m73803a(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        /* renamed from: f */
        public final long m70336f(byte[] bArr) {
            return C12279c.m73803a(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }
    }

    public EnumC11800e(String str, int i10) {
        super(str, i10);
    }

    /* renamed from: b */
    public static /* synthetic */ EnumC11800e[] m70334b() {
        return new EnumC11800e[]{f54679a, f54680b};
    }

    public static EnumC11800e valueOf(String str) {
        return (EnumC11800e) Enum.valueOf(EnumC11800e.class, str);
    }

    public static EnumC11800e[] values() {
        return (EnumC11800e[]) f54681c.clone();
    }

    public /* synthetic */ EnumC11800e(String str, int i10, a aVar) {
        this(str, i10);
    }

    /* renamed from: o3.e$c */
    public static final class c {

        /* renamed from: a */
        public final AtomicLongArray f54682a;

        /* renamed from: b */
        public final InterfaceC11808m f54683b;

        public c(long j10) {
            C11397c.m68305b(j10 > 0, "data length is zero!");
            this.f54682a = new AtomicLongArray(C12277a.m73801a(C12084a.m72252a(j10, 64L, RoundingMode.CEILING)));
            this.f54683b = C11809n.m70358a();
        }

        /* renamed from: d */
        public static long[] m70337d(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = atomicLongArray.get(i10);
            }
            return jArr;
        }

        /* renamed from: a */
        public long m70338a() {
            return this.f54682a.length() * 64;
        }

        /* renamed from: b */
        public boolean m70339b(long j10) {
            return ((1 << ((int) j10)) & this.f54682a.get((int) (j10 >>> 6))) != 0;
        }

        /* renamed from: c */
        public boolean m70340c(long j10) {
            long j11;
            long j12;
            if (m70339b(j10)) {
                return false;
            }
            int i10 = (int) (j10 >>> 6);
            long j13 = 1 << ((int) j10);
            do {
                j11 = this.f54682a.get(i10);
                j12 = j11 | j13;
                if (j11 == j12) {
                    return false;
                }
            } while (!this.f54682a.compareAndSet(i10, j11, j12));
            this.f54683b.mo70356b();
            return true;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(m70337d(this.f54682a), m70337d(((c) obj).f54682a));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(m70337d(this.f54682a));
        }

        public c(long[] jArr) {
            C11397c.m68305b(jArr.length > 0, "data length is zero!");
            this.f54682a = new AtomicLongArray(jArr);
            this.f54683b = C11809n.m70358a();
            long jBitCount = 0;
            for (long j10 : jArr) {
                jBitCount += Long.bitCount(j10);
            }
            this.f54683b.mo70357c(jBitCount);
        }
    }
}
