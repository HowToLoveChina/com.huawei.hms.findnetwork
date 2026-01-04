package p305g1;

/* renamed from: g1.a */
/* loaded from: classes.dex */
public class C9836a {

    /* renamed from: a */
    public byte[] f48327a;

    /* renamed from: b */
    public int f48328b;

    public C9836a() {
        this.f48327a = new byte[64];
    }

    /* renamed from: a */
    public final void m61144a(int i10) {
        byte[] bArr = this.f48327a;
        int length = bArr.length * 2;
        int i11 = this.f48328b;
        int i12 = i10 + i11;
        if (length <= i12) {
            length = i12;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        this.f48327a = bArr2;
    }

    /* renamed from: b */
    public C9836a m61145b(int i10, int i11) {
        int i12 = this.f48328b;
        if (i12 + 2 > this.f48327a.length) {
            m61144a(2);
        }
        byte[] bArr = this.f48327a;
        bArr[i12] = (byte) i10;
        bArr[i12 + 1] = (byte) i11;
        this.f48328b = i12 + 2;
        return this;
    }

    /* renamed from: c */
    public C9836a m61146c(int i10, int i11) {
        int i12 = this.f48328b;
        if (i12 + 3 > this.f48327a.length) {
            m61144a(3);
        }
        byte[] bArr = this.f48327a;
        bArr[i12] = (byte) i10;
        bArr[i12 + 1] = (byte) (i11 >>> 8);
        bArr[i12 + 2] = (byte) i11;
        this.f48328b = i12 + 3;
        return this;
    }

    /* renamed from: d */
    public C9836a m61147d(int i10) {
        int i11 = this.f48328b;
        int i12 = i11 + 1;
        if (i12 > this.f48327a.length) {
            m61144a(1);
        }
        this.f48327a[i11] = (byte) i10;
        this.f48328b = i12;
        return this;
    }

    /* renamed from: e */
    public C9836a m61148e(byte[] bArr, int i10, int i11) {
        if (this.f48328b + i11 > this.f48327a.length) {
            m61144a(i11);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i10, this.f48327a, this.f48328b, i11);
        }
        this.f48328b += i11;
        return this;
    }

    /* renamed from: f */
    public C9836a m61149f(int i10) {
        int i11 = this.f48328b;
        if (i11 + 4 > this.f48327a.length) {
            m61144a(4);
        }
        byte[] bArr = this.f48327a;
        bArr[i11] = (byte) (i10 >>> 24);
        bArr[i11 + 1] = (byte) (i10 >>> 16);
        bArr[i11 + 2] = (byte) (i10 >>> 8);
        bArr[i11 + 3] = (byte) i10;
        this.f48328b = i11 + 4;
        return this;
    }

    /* renamed from: g */
    public C9836a m61150g(int i10) {
        int i11 = this.f48328b;
        if (i11 + 2 > this.f48327a.length) {
            m61144a(2);
        }
        byte[] bArr = this.f48327a;
        bArr[i11] = (byte) (i10 >>> 8);
        bArr[i11 + 1] = (byte) i10;
        this.f48328b = i11 + 2;
        return this;
    }

    /* renamed from: h */
    public C9836a m61151h(String str) {
        int length = str.length();
        int i10 = this.f48328b;
        if (i10 + 2 + length > this.f48327a.length) {
            m61144a(length + 2);
        }
        byte[] bArr = this.f48327a;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (length >>> 8);
        int i12 = i10 + 2;
        bArr[i11] = (byte) length;
        int i13 = 0;
        while (i13 < length) {
            char cCharAt = str.charAt(i13);
            if ((cCharAt < 1 || cCharAt > 127) && (cCharAt < 19968 || cCharAt > 40959)) {
                throw new UnsupportedOperationException();
            }
            bArr[i12] = (byte) cCharAt;
            i13++;
            i12++;
        }
        this.f48328b = i12;
        return this;
    }

    public C9836a(int i10) {
        this.f48327a = new byte[i10];
    }
}
