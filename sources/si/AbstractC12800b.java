package si;

import com.huawei.hms.drive.C5281eb;
import java.util.Arrays;

/* renamed from: si.b */
/* loaded from: classes.dex */
public abstract class AbstractC12800b {

    /* renamed from: a */
    @Deprecated
    public final byte f58490a;

    /* renamed from: b */
    public final byte f58491b;

    /* renamed from: c */
    public final int f58492c;

    /* renamed from: d */
    public final int f58493d;

    /* renamed from: e */
    public final int f58494e;

    /* renamed from: f */
    public final int f58495f;

    /* renamed from: si.b$a */
    public static class a {

        /* renamed from: a */
        public int f58496a;

        /* renamed from: b */
        public long f58497b;

        /* renamed from: c */
        public byte[] f58498c;

        /* renamed from: d */
        public int f58499d;

        /* renamed from: e */
        public int f58500e;

        /* renamed from: f */
        public boolean f58501f;

        /* renamed from: g */
        public int f58502g;

        /* renamed from: h */
        public int f58503h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.f58498c), Integer.valueOf(this.f58502g), Boolean.valueOf(this.f58501f), Integer.valueOf(this.f58496a), Long.valueOf(this.f58497b), Integer.valueOf(this.f58503h), Integer.valueOf(this.f58499d), Integer.valueOf(this.f58500e));
        }
    }

    public AbstractC12800b(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, (byte) 61);
    }

    /* renamed from: a */
    public int m76799a(a aVar) {
        if (aVar.f58498c != null) {
            return aVar.f58499d - aVar.f58500e;
        }
        return 0;
    }

    /* renamed from: b */
    public boolean m76800b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b10 : bArr) {
            if (this.f58491b == b10 || mo76795l(b10)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public abstract void mo76793c(byte[] bArr, int i10, int i11, a aVar);

    /* renamed from: d */
    public byte[] m76801d(String str) {
        return m76802e(C5281eb.m31711a(str));
    }

    /* renamed from: e */
    public byte[] m76802e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        mo76793c(bArr, 0, bArr.length, aVar);
        mo76793c(bArr, 0, -1, aVar);
        int i10 = aVar.f58499d;
        byte[] bArr2 = new byte[i10];
        m76808m(bArr2, 0, i10, aVar);
        return bArr2;
    }

    /* renamed from: f */
    public abstract void mo76794f(byte[] bArr, int i10, int i11, a aVar);

    /* renamed from: g */
    public byte[] m76803g(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : m76804h(bArr, 0, bArr.length);
    }

    /* renamed from: h */
    public byte[] m76804h(byte[] bArr, int i10, int i11) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        mo76794f(bArr, i10, i11, aVar);
        mo76794f(bArr, i10, -1, aVar);
        int i12 = aVar.f58499d - aVar.f58500e;
        byte[] bArr2 = new byte[i12];
        m76808m(bArr2, 0, i12, aVar);
        return bArr2;
    }

    /* renamed from: i */
    public byte[] m76805i(int i10, a aVar) {
        byte[] bArr = aVar.f58498c;
        return (bArr == null || bArr.length < aVar.f58499d + i10) ? m76809n(aVar) : bArr;
    }

    /* renamed from: j */
    public int m76806j() {
        return 8192;
    }

    /* renamed from: k */
    public long m76807k(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f58493d;
        long j10 = (((length + i10) - 1) / i10) * this.f58494e;
        int i11 = this.f58492c;
        return i11 > 0 ? j10 + ((((i11 + j10) - 1) / i11) * this.f58495f) : j10;
    }

    /* renamed from: l */
    public abstract boolean mo76795l(byte b10);

    /* renamed from: m */
    public int m76808m(byte[] bArr, int i10, int i11, a aVar) {
        if (aVar.f58498c == null) {
            return aVar.f58501f ? -1 : 0;
        }
        int iMin = Math.min(m76799a(aVar), i11);
        System.arraycopy(aVar.f58498c, aVar.f58500e, bArr, i10, iMin);
        int i12 = aVar.f58500e + iMin;
        aVar.f58500e = i12;
        if (i12 >= aVar.f58499d) {
            aVar.f58498c = null;
        }
        return iMin;
    }

    /* renamed from: n */
    public final byte[] m76809n(a aVar) {
        byte[] bArr = aVar.f58498c;
        if (bArr == null) {
            aVar.f58498c = new byte[m76806j()];
            aVar.f58499d = 0;
            aVar.f58500e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f58498c = bArr2;
        }
        return aVar.f58498c;
    }

    public AbstractC12800b(int i10, int i11, int i12, int i13, byte b10) {
        this.f58490a = (byte) 61;
        this.f58493d = i10;
        this.f58494e = i11;
        this.f58492c = (i12 <= 0 || i13 <= 0) ? 0 : (i12 / i11) * i11;
        this.f58495f = i13;
        this.f58491b = b10;
    }
}
