package p508o3;

import com.google.flatbuffers.reflection.BaseType;
import java.io.Serializable;
import p468m3.C11397c;

/* renamed from: o3.h */
/* loaded from: classes.dex */
public abstract class AbstractC11803h {

    /* renamed from: a */
    public static final char[] f54686a = "0123456789abcdef".toCharArray();

    /* renamed from: o3.h$a */
    public static final class a extends AbstractC11803h implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: b */
        public final byte[] f54687b;

        public a(byte[] bArr) {
            this.f54687b = (byte[]) C11397c.m68310g(bArr);
        }

        @Override // p508o3.AbstractC11803h
        /* renamed from: b */
        public byte[] mo70345b() {
            return (byte[]) this.f54687b.clone();
        }

        @Override // p508o3.AbstractC11803h
        /* renamed from: c */
        public int mo70346c() {
            byte[] bArr = this.f54687b;
            C11397c.m68312i(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.f54687b;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // p508o3.AbstractC11803h
        /* renamed from: d */
        public long mo70347d() {
            byte[] bArr = this.f54687b;
            C11397c.m68312i(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return m70351j();
        }

        @Override // p508o3.AbstractC11803h
        /* renamed from: e */
        public int mo70348e() {
            return this.f54687b.length * 8;
        }

        @Override // p508o3.AbstractC11803h
        /* renamed from: f */
        public boolean mo70349f(AbstractC11803h abstractC11803h) {
            if (this.f54687b.length != abstractC11803h.mo70350h().length) {
                return false;
            }
            boolean z10 = true;
            int i10 = 0;
            while (true) {
                byte[] bArr = this.f54687b;
                if (i10 >= bArr.length) {
                    return z10;
                }
                z10 &= bArr[i10] == abstractC11803h.mo70350h()[i10];
                i10++;
            }
        }

        @Override // p508o3.AbstractC11803h
        /* renamed from: h */
        public byte[] mo70350h() {
            return this.f54687b;
        }

        /* renamed from: j */
        public long m70351j() {
            long j10 = this.f54687b[0] & 255;
            for (int i10 = 1; i10 < Math.min(this.f54687b.length, 8); i10++) {
                j10 |= (this.f54687b[i10] & 255) << (i10 * 8);
            }
            return j10;
        }
    }

    /* renamed from: g */
    public static AbstractC11803h m70344g(byte[] bArr) {
        return new a(bArr);
    }

    /* renamed from: b */
    public abstract byte[] mo70345b();

    /* renamed from: c */
    public abstract int mo70346c();

    /* renamed from: d */
    public abstract long mo70347d();

    /* renamed from: e */
    public abstract int mo70348e();

    public final boolean equals(Object obj) {
        if (!(obj instanceof AbstractC11803h)) {
            return false;
        }
        AbstractC11803h abstractC11803h = (AbstractC11803h) obj;
        return mo70348e() == abstractC11803h.mo70348e() && mo70349f(abstractC11803h);
    }

    /* renamed from: f */
    public abstract boolean mo70349f(AbstractC11803h abstractC11803h);

    /* renamed from: h */
    public byte[] mo70350h() {
        return mo70345b();
    }

    public final int hashCode() {
        if (mo70348e() >= 32) {
            return mo70346c();
        }
        byte[] bArrMo70350h = mo70350h();
        int i10 = bArrMo70350h[0] & 255;
        for (int i11 = 1; i11 < bArrMo70350h.length; i11++) {
            i10 |= (bArrMo70350h[i11] & 255) << (i11 * 8);
        }
        return i10;
    }

    public final String toString() {
        byte[] bArrMo70350h = mo70350h();
        StringBuilder sb2 = new StringBuilder(bArrMo70350h.length * 2);
        for (byte b10 : bArrMo70350h) {
            char[] cArr = f54686a;
            sb2.append(cArr[(b10 >> 4) & 15]);
            sb2.append(cArr[b10 & BaseType.Obj]);
        }
        return sb2.toString();
    }
}
