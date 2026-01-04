package cz;

import az.C1081e;
import bz.InterfaceC1360c;
import com.huawei.hms.network.embedded.C5914f2;
import p271ez.C9575a;
import p271ez.C9576b;
import p302fz.C9811c;
import uy.C13294h;
import uy.InterfaceC13287a;

/* renamed from: cz.a */
/* loaded from: classes9.dex */
public class C8965a implements InterfaceC8966b {

    /* renamed from: j */
    public static final byte[] f45470j = C9811c.m60984a("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");

    /* renamed from: a */
    public InterfaceC1360c f45471a;

    /* renamed from: b */
    public InterfaceC13287a f45472b;

    /* renamed from: c */
    public int f45473c;

    /* renamed from: d */
    public int f45474d;

    /* renamed from: e */
    public int f45475e;

    /* renamed from: f */
    public byte[] f45476f;

    /* renamed from: g */
    public byte[] f45477g;

    /* renamed from: h */
    public long f45478h = 0;

    /* renamed from: i */
    public boolean f45479i;

    public C8965a(InterfaceC13287a interfaceC13287a, int i10, int i11, InterfaceC1360c interfaceC1360c, byte[] bArr, byte[] bArr2) throws IllegalStateException, C13294h, IllegalArgumentException {
        this.f45479i = false;
        this.f45471a = interfaceC1360c;
        this.f45472b = interfaceC13287a;
        this.f45473c = i10;
        this.f45475e = i11;
        this.f45474d = (interfaceC13287a.mo79738c() * 8) + i10;
        this.f45479i = m56739m(interfaceC13287a);
        if (i11 > 256) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (m56738l(interfaceC13287a, i10) < i11) {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        }
        if (interfaceC1360c.mo7858b() < i11) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        m56731e(m56737k(), bArr2, bArr);
    }

    @Override // cz.InterfaceC8966b
    /* renamed from: a */
    public void mo56727a(byte[] bArr) throws IllegalStateException, C13294h, IllegalArgumentException {
        m56732f(bArr);
    }

    @Override // cz.InterfaceC8966b
    /* renamed from: b */
    public int mo56728b(byte[] bArr, byte[] bArr2, boolean z10) throws IllegalStateException, C13294h, IllegalArgumentException {
        byte[] bArrM56730d;
        boolean z11 = this.f45479i;
        long j10 = this.f45478h;
        if (z11) {
            if (j10 > 2147483648L) {
                return -1;
            }
            if (C8967c.m56741a(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else {
            if (j10 > 140737488355328L) {
                return -1;
            }
            if (C8967c.m56741a(bArr, C5914f2.f26733f)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z10) {
            m56732f(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArrM56730d = m56730d(bArr2, this.f45474d);
            m56733g(bArrM56730d, this.f45476f, this.f45477g);
        } else {
            bArrM56730d = new byte[this.f45474d / 8];
        }
        int length = this.f45477g.length;
        byte[] bArr3 = new byte[length];
        this.f45472b.mo79739d(true, new C1081e(m56736j(this.f45476f)));
        for (int i10 = 0; i10 <= bArr.length / length; i10++) {
            int i11 = i10 * length;
            int length2 = bArr.length - i11 > length ? length : bArr.length - (this.f45477g.length * i10);
            if (length2 != 0) {
                m56734h(this.f45477g);
                this.f45472b.mo79737b(this.f45477g, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i11, length2);
            }
        }
        m56733g(bArrM56730d, this.f45476f, this.f45477g);
        this.f45478h++;
        return bArr.length * 8;
    }

    /* renamed from: c */
    public final void m56729c(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws IllegalStateException, C13294h, IllegalArgumentException {
        int iMo79738c = this.f45472b.mo79738c();
        byte[] bArr5 = new byte[iMo79738c];
        int length = bArr4.length / iMo79738c;
        byte[] bArr6 = new byte[iMo79738c];
        this.f45472b.mo79739d(true, new C1081e(m56736j(bArr2)));
        this.f45472b.mo79737b(bArr3, 0, bArr5, 0);
        for (int i10 = 0; i10 < length; i10++) {
            C9576b.m59766a(iMo79738c, bArr5, 0, bArr4, i10 * iMo79738c, bArr6, 0);
            this.f45472b.mo79737b(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public final byte[] m56730d(byte[] bArr, int i10) throws IllegalStateException, C13294h, IllegalArgumentException {
        int iMo79738c = this.f45472b.mo79738c();
        int length = bArr.length;
        int i11 = i10 / 8;
        byte[] bArr2 = new byte[((((length + 9) + iMo79738c) - 1) / iMo79738c) * iMo79738c];
        m56735i(bArr2, length, 0);
        m56735i(bArr2, i11, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[length + 8] = -128;
        int i12 = this.f45473c;
        int i13 = (i12 / 8) + iMo79738c;
        byte[] bArr3 = new byte[i13];
        byte[] bArr4 = new byte[iMo79738c];
        byte[] bArr5 = new byte[iMo79738c];
        int i14 = i12 / 8;
        byte[] bArr6 = new byte[i14];
        System.arraycopy(f45470j, 0, bArr6, 0, i14);
        int i15 = 0;
        while (true) {
            int i16 = i15 * iMo79738c;
            if (i16 * 8 >= this.f45473c + (iMo79738c * 8)) {
                break;
            }
            m56735i(bArr5, i15, 0);
            m56729c(bArr4, bArr6, bArr5, bArr2);
            int i17 = i13 - i16;
            if (i17 > iMo79738c) {
                i17 = iMo79738c;
            }
            System.arraycopy(bArr4, 0, bArr3, i16, i17);
            i15++;
        }
        byte[] bArr7 = new byte[iMo79738c];
        System.arraycopy(bArr3, 0, bArr6, 0, i14);
        System.arraycopy(bArr3, i14, bArr7, 0, iMo79738c);
        byte[] bArr8 = new byte[i11];
        this.f45472b.mo79739d(true, new C1081e(m56736j(bArr6)));
        int i18 = 0;
        while (true) {
            int i19 = i18 * iMo79738c;
            if (i19 >= i11) {
                return bArr8;
            }
            this.f45472b.mo79737b(bArr7, 0, bArr7, 0);
            int i20 = i11 - i19;
            if (i20 > iMo79738c) {
                i20 = iMo79738c;
            }
            System.arraycopy(bArr7, 0, bArr8, i19, i20);
            i18++;
        }
    }

    /* renamed from: e */
    public final void m56731e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalStateException, C13294h, IllegalArgumentException {
        byte[] bArrM56730d = m56730d(C9575a.m59761d(bArr, bArr2, bArr3), this.f45474d);
        int iMo79738c = this.f45472b.mo79738c();
        byte[] bArr4 = new byte[(this.f45473c + 7) / 8];
        this.f45476f = bArr4;
        byte[] bArr5 = new byte[iMo79738c];
        this.f45477g = bArr5;
        m56733g(bArrM56730d, bArr4, bArr5);
        this.f45478h = 1L;
    }

    /* renamed from: f */
    public final void m56732f(byte[] bArr) throws IllegalStateException, C13294h, IllegalArgumentException {
        m56733g(m56730d(C9575a.m59760c(m56737k(), bArr), this.f45474d), this.f45476f, this.f45477g);
        this.f45478h = 1L;
    }

    /* renamed from: g */
    public final void m56733g(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalStateException, C13294h, IllegalArgumentException {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this.f45472b.mo79738c()];
        int iMo79738c = this.f45472b.mo79738c();
        this.f45472b.mo79739d(true, new C1081e(m56736j(bArr2)));
        int i10 = 0;
        while (true) {
            int i11 = i10 * iMo79738c;
            if (i11 >= bArr.length) {
                C9576b.m59767b(bArr.length, bArr, bArr4);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            } else {
                m56734h(bArr3);
                this.f45472b.mo79737b(bArr3, 0, bArr5, 0);
                int i12 = length - i11;
                if (i12 > iMo79738c) {
                    i12 = iMo79738c;
                }
                System.arraycopy(bArr5, 0, bArr4, i11, i12);
                i10++;
            }
        }
    }

    /* renamed from: h */
    public final void m56734h(byte[] bArr) {
        int i10 = 1;
        for (int i11 = 1; i11 <= bArr.length; i11++) {
            int i12 = (bArr[bArr.length - i11] & 255) + i10;
            i10 = i12 > 255 ? 1 : 0;
            bArr[bArr.length - i11] = (byte) i12;
        }
    }

    /* renamed from: i */
    public final void m56735i(byte[] bArr, int i10, int i11) {
        bArr[i11] = (byte) (i10 >> 24);
        bArr[i11 + 1] = (byte) (i10 >> 16);
        bArr[i11 + 2] = (byte) (i10 >> 8);
        bArr[i11 + 3] = (byte) i10;
    }

    /* renamed from: j */
    public byte[] m56736j(byte[] bArr) {
        if (!this.f45479i) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        m56740n(bArr, 0, bArr2, 0);
        m56740n(bArr, 7, bArr2, 8);
        m56740n(bArr, 14, bArr2, 16);
        return bArr2;
    }

    /* renamed from: k */
    public final byte[] m56737k() {
        byte[] bArrMo7857a = this.f45471a.mo7857a();
        if (bArrMo7857a.length >= (this.f45475e + 7) / 8) {
            return bArrMo7857a;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    /* renamed from: l */
    public final int m56738l(InterfaceC13287a interfaceC13287a, int i10) {
        if (m56739m(interfaceC13287a) && i10 == 168) {
            return 112;
        }
        if (interfaceC13287a.mo79736a().equals("AES")) {
            return i10;
        }
        return -1;
    }

    /* renamed from: m */
    public final boolean m56739m(InterfaceC13287a interfaceC13287a) {
        return interfaceC13287a.mo79736a().equals("DESede") || interfaceC13287a.mo79736a().equals("TDEA");
    }

    /* renamed from: n */
    public final void m56740n(byte[] bArr, int i10, byte[] bArr2, int i11) {
        bArr2[i11] = (byte) (bArr[i10] & 254);
        int i12 = i10 + 1;
        bArr2[i11 + 1] = (byte) ((bArr[i10] << 7) | ((bArr[i12] & 252) >>> 1));
        int i13 = bArr[i12] << 6;
        int i14 = i10 + 2;
        bArr2[i11 + 2] = (byte) (i13 | ((bArr[i14] & 248) >>> 2));
        int i15 = bArr[i14] << 5;
        int i16 = i10 + 3;
        bArr2[i11 + 3] = (byte) (i15 | ((bArr[i16] & 240) >>> 3));
        int i17 = bArr[i16] << 4;
        int i18 = i10 + 4;
        bArr2[i11 + 4] = (byte) (i17 | ((bArr[i18] & 224) >>> 4));
        int i19 = bArr[i18] << 3;
        int i20 = i10 + 5;
        bArr2[i11 + 5] = (byte) (i19 | ((bArr[i20] & 192) >>> 5));
        int i21 = i10 + 6;
        bArr2[i11 + 6] = (byte) ((bArr[i20] << 2) | ((bArr[i21] & 128) >>> 6));
        int i22 = i11 + 7;
        bArr2[i22] = (byte) (bArr[i21] << 1);
        while (i11 <= i22) {
            byte b10 = bArr2[i11];
            bArr2[i11] = (byte) (((((b10 >> 7) ^ ((((((b10 >> 1) ^ (b10 >> 2)) ^ (b10 >> 3)) ^ (b10 >> 4)) ^ (b10 >> 5)) ^ (b10 >> 6))) ^ 1) & 1) | (b10 & 254));
            i11++;
        }
    }
}
