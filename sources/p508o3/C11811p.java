package p508o3;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p565q3.C12281e;

/* renamed from: o3.p */
/* loaded from: classes.dex */
public final class C11811p extends AbstractC11796a implements Serializable {

    /* renamed from: b */
    public static final InterfaceC11804i f54690b = new C11811p(0);

    /* renamed from: c */
    public static final InterfaceC11804i f54691c = new C11811p(C11806k.f54688a);
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int f54692a;

    /* renamed from: o3.p$a */
    public static final class a extends AbstractC11798c {

        /* renamed from: d */
        public long f54693d;

        /* renamed from: e */
        public long f54694e;

        /* renamed from: f */
        public int f54695f;

        public a(int i10) {
            super(16);
            long j10 = i10;
            this.f54693d = j10;
            this.f54694e = j10;
            this.f54695f = 0;
        }

        /* renamed from: n */
        public static long m70363n(long j10) {
            long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
            long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
            return j12 ^ (j12 >>> 33);
        }

        /* renamed from: o */
        public static long m70364o(long j10) {
            return Long.rotateLeft(j10 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        /* renamed from: p */
        public static long m70365p(long j10) {
            return Long.rotateLeft(j10 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // p508o3.AbstractC11798c
        /* renamed from: g */
        public AbstractC11803h mo70316g() {
            long j10 = this.f54693d;
            int i10 = this.f54695f;
            long j11 = j10 ^ i10;
            long j12 = this.f54694e ^ i10;
            long j13 = j11 + j12;
            this.f54693d = j13;
            this.f54694e = j12 + j13;
            this.f54693d = m70363n(j13);
            long jM70363n = m70363n(this.f54694e);
            long j14 = this.f54693d + jM70363n;
            this.f54693d = j14;
            this.f54694e = jM70363n + j14;
            return AbstractC11803h.m70344g(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f54693d).putLong(this.f54694e).array());
        }

        @Override // p508o3.AbstractC11798c
        /* renamed from: j */
        public void mo70319j(ByteBuffer byteBuffer) {
            m70366m(byteBuffer.getLong(), byteBuffer.getLong());
            this.f54695f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // p508o3.AbstractC11798c
        /* renamed from: k */
        public void mo70320k(ByteBuffer byteBuffer) {
            long jM73806b;
            long jM73806b2;
            long jM73806b3;
            long jM73806b4;
            long jM73806b5;
            long jM73806b6;
            long jM73806b7;
            this.f54695f += byteBuffer.remaining();
            long jM73806b8 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    jM73806b = 0;
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 2:
                    jM73806b2 = 0;
                    jM73806b = jM73806b2 ^ (C12281e.m73806b(byteBuffer.get(1)) << 8);
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 3:
                    jM73806b3 = 0;
                    jM73806b2 = (C12281e.m73806b(byteBuffer.get(2)) << 16) ^ jM73806b3;
                    jM73806b = jM73806b2 ^ (C12281e.m73806b(byteBuffer.get(1)) << 8);
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 4:
                    jM73806b4 = 0;
                    jM73806b3 = jM73806b4 ^ (C12281e.m73806b(byteBuffer.get(3)) << 24);
                    jM73806b2 = (C12281e.m73806b(byteBuffer.get(2)) << 16) ^ jM73806b3;
                    jM73806b = jM73806b2 ^ (C12281e.m73806b(byteBuffer.get(1)) << 8);
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 5:
                    jM73806b5 = 0;
                    jM73806b4 = jM73806b5 ^ (C12281e.m73806b(byteBuffer.get(4)) << 32);
                    jM73806b3 = jM73806b4 ^ (C12281e.m73806b(byteBuffer.get(3)) << 24);
                    jM73806b2 = (C12281e.m73806b(byteBuffer.get(2)) << 16) ^ jM73806b3;
                    jM73806b = jM73806b2 ^ (C12281e.m73806b(byteBuffer.get(1)) << 8);
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 6:
                    jM73806b6 = 0;
                    jM73806b5 = (C12281e.m73806b(byteBuffer.get(5)) << 40) ^ jM73806b6;
                    jM73806b4 = jM73806b5 ^ (C12281e.m73806b(byteBuffer.get(4)) << 32);
                    jM73806b3 = jM73806b4 ^ (C12281e.m73806b(byteBuffer.get(3)) << 24);
                    jM73806b2 = (C12281e.m73806b(byteBuffer.get(2)) << 16) ^ jM73806b3;
                    jM73806b = jM73806b2 ^ (C12281e.m73806b(byteBuffer.get(1)) << 8);
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 7:
                    jM73806b6 = C12281e.m73806b(byteBuffer.get(6)) << 48;
                    jM73806b5 = (C12281e.m73806b(byteBuffer.get(5)) << 40) ^ jM73806b6;
                    jM73806b4 = jM73806b5 ^ (C12281e.m73806b(byteBuffer.get(4)) << 32);
                    jM73806b3 = jM73806b4 ^ (C12281e.m73806b(byteBuffer.get(3)) << 24);
                    jM73806b2 = (C12281e.m73806b(byteBuffer.get(2)) << 16) ^ jM73806b3;
                    jM73806b = jM73806b2 ^ (C12281e.m73806b(byteBuffer.get(1)) << 8);
                    jM73806b7 = jM73806b ^ C12281e.m73806b(byteBuffer.get(0));
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 8:
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 9:
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 10:
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(9)) << 8;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 11:
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(10)) << 16;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(9)) << 8;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 12:
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(11)) << 24;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(10)) << 16;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(9)) << 8;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 13:
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(12)) << 32;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(11)) << 24;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(10)) << 16;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(9)) << 8;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 14:
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(13)) << 40;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(12)) << 32;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(11)) << 24;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(10)) << 16;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(9)) << 8;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                case 15:
                    jM73806b8 = C12281e.m73806b(byteBuffer.get(14)) << 48;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(13)) << 40;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(12)) << 32;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(11)) << 24;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(10)) << 16;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(9)) << 8;
                    jM73806b8 ^= C12281e.m73806b(byteBuffer.get(8));
                    jM73806b7 = byteBuffer.getLong();
                    this.f54693d = m70364o(jM73806b7) ^ this.f54693d;
                    this.f54694e ^= m70365p(jM73806b8);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        /* renamed from: m */
        public final void m70366m(long j10, long j11) {
            long jM70364o = m70364o(j10) ^ this.f54693d;
            this.f54693d = jM70364o;
            long jRotateLeft = Long.rotateLeft(jM70364o, 27);
            long j12 = this.f54694e;
            this.f54693d = ((jRotateLeft + j12) * 5) + 1390208809;
            long jM70365p = m70365p(j11) ^ j12;
            this.f54694e = jM70365p;
            this.f54694e = ((Long.rotateLeft(jM70365p, 31) + this.f54693d) * 5) + 944331445;
        }
    }

    public C11811p(int i10) {
        this.f54692a = i10;
    }

    @Override // p508o3.InterfaceC11804i
    /* renamed from: c */
    public InterfaceC11805j mo70352c() {
        return new a(this.f54692a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11811p) && this.f54692a == ((C11811p) obj).f54692a;
    }

    public int hashCode() {
        return this.f54692a ^ C11811p.class.hashCode();
    }

    public String toString() {
        int i10 = this.f54692a;
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Hashing.murmur3_128(");
        sb2.append(i10);
        sb2.append(")");
        return sb2.toString();
    }
}
