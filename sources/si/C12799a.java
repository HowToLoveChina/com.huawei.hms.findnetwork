package si;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.drive.C5281eb;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import si.AbstractC12800b;

/* renamed from: si.a */
/* loaded from: classes.dex */
public class C12799a extends AbstractC12800b {

    /* renamed from: l */
    public static final byte[] f58481l = {13, 10};

    /* renamed from: m */
    public static final byte[] f58482m = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: n */
    public static final byte[] f58483n = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: o */
    public static final byte[] f58484o = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, BaseType.Float, BaseType.Double, 13, BaseType.Vector, BaseType.Obj, BaseType.Union, BaseType.Array, BaseType.Vector64, BaseType.MaxBaseType, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.f29565i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: g */
    public final byte[] f58485g;

    /* renamed from: h */
    public final byte[] f58486h;

    /* renamed from: i */
    public final byte[] f58487i;

    /* renamed from: j */
    public final int f58488j;

    /* renamed from: k */
    public final int f58489k;

    public C12799a() {
        this(0);
    }

    /* renamed from: o */
    public static byte[] m76789o(String str) {
        return new C12799a().m76801d(str);
    }

    /* renamed from: p */
    public static byte[] m76790p(byte[] bArr, boolean z10, boolean z11) {
        return m76791q(bArr, z10, z11, Integer.MAX_VALUE);
    }

    /* renamed from: q */
    public static byte[] m76791q(byte[] bArr, boolean z10, boolean z11, int i10) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C12799a c12799a = z10 ? new C12799a(z11) : new C12799a(0, f58481l, z11);
        long jM76807k = c12799a.m76807k(bArr);
        if (jM76807k <= i10) {
            return c12799a.m76803g(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jM76807k + ") than the specified maximum size of " + i10);
    }

    /* renamed from: r */
    public static String m76792r(byte[] bArr) {
        return C5281eb.m31709a(m76790p(bArr, false, true));
    }

    @Override // si.AbstractC12800b
    /* renamed from: c */
    public void mo76793c(byte[] bArr, int i10, int i11, AbstractC12800b.a aVar) {
        byte b10;
        if (aVar.f58501f) {
            return;
        }
        if (i11 < 0) {
            aVar.f58501f = true;
        }
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            byte[] bArrM76805i = m76805i(this.f58488j, aVar);
            int i13 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 == this.f58491b) {
                aVar.f58501f = true;
                break;
            }
            if (b11 >= 0) {
                byte[] bArr2 = f58484o;
                if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                    int i14 = (aVar.f58503h + 1) % 4;
                    aVar.f58503h = i14;
                    int i15 = (aVar.f58496a << 6) + b10;
                    aVar.f58496a = i15;
                    if (i14 == 0) {
                        int i16 = aVar.f58499d;
                        bArrM76805i[i16] = (byte) ((i15 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                        bArrM76805i[i16 + 1] = (byte) ((i15 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                        aVar.f58499d = i16 + 3;
                        bArrM76805i[i16 + 2] = (byte) (i15 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                    }
                }
            }
            i12++;
            i10 = i13;
        }
        if (!aVar.f58501f || aVar.f58503h == 0) {
            return;
        }
        byte[] bArrM76805i2 = m76805i(this.f58488j, aVar);
        int i17 = aVar.f58503h;
        if (i17 != 1) {
            if (i17 == 2) {
                m76798u(4, aVar);
                int i18 = aVar.f58496a >> 4;
                aVar.f58496a = i18;
                int i19 = aVar.f58499d;
                aVar.f58499d = i19 + 1;
                bArrM76805i2[i19] = (byte) (i18 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                return;
            }
            if (i17 != 3) {
                throw new IllegalStateException("Impossible modulus " + aVar.f58503h);
            }
            m76798u(2, aVar);
            int i20 = aVar.f58496a;
            int i21 = i20 >> 2;
            aVar.f58496a = i21;
            int i22 = aVar.f58499d;
            bArrM76805i2[i22] = (byte) ((i20 >> 10) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            aVar.f58499d = i22 + 2;
            bArrM76805i2[i22 + 1] = (byte) (i21 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        }
    }

    @Override // si.AbstractC12800b
    /* renamed from: f */
    public void mo76794f(byte[] bArr, int i10, int i11, AbstractC12800b.a aVar) {
        if (aVar.f58501f) {
            return;
        }
        if (i11 < 0) {
            m76796s(aVar);
        } else {
            m76797t(bArr, i10, i11, aVar);
        }
    }

    @Override // si.AbstractC12800b
    /* renamed from: l */
    public boolean mo76795l(byte b10) {
        if (b10 >= 0) {
            byte[] bArr = this.f58486h;
            if (b10 < bArr.length && bArr[b10] != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: s */
    public final void m76796s(AbstractC12800b.a aVar) {
        aVar.f58501f = true;
        if (aVar.f58503h == 0 && this.f58492c == 0) {
            return;
        }
        byte[] bArrM76805i = m76805i(this.f58489k, aVar);
        int i10 = aVar.f58499d;
        int i11 = aVar.f58503h;
        if (i11 != 0) {
            if (i11 == 1) {
                byte[] bArr = this.f58485g;
                int i12 = aVar.f58496a;
                bArrM76805i[i10] = bArr[(i12 >> 2) & 63];
                int i13 = i10 + 2;
                aVar.f58499d = i13;
                bArrM76805i[i10 + 1] = bArr[(i12 << 4) & 63];
                if (bArr == f58482m) {
                    byte b10 = this.f58491b;
                    bArrM76805i[i13] = b10;
                    aVar.f58499d = i10 + 4;
                    bArrM76805i[i10 + 3] = b10;
                }
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Impossible modulus " + aVar.f58503h);
                }
                byte[] bArr2 = this.f58485g;
                int i14 = aVar.f58496a;
                bArrM76805i[i10] = bArr2[(i14 >> 10) & 63];
                bArrM76805i[i10 + 1] = bArr2[(i14 >> 4) & 63];
                int i15 = i10 + 3;
                aVar.f58499d = i15;
                bArrM76805i[i10 + 2] = bArr2[(i14 << 2) & 63];
                if (bArr2 == f58482m) {
                    aVar.f58499d = i10 + 4;
                    bArrM76805i[i15] = this.f58491b;
                }
            }
        }
        int i16 = aVar.f58502g;
        int i17 = aVar.f58499d;
        int i18 = i16 + (i17 - i10);
        aVar.f58502g = i18;
        if (this.f58492c <= 0 || i18 <= 0) {
            return;
        }
        byte[] bArr3 = this.f58487i;
        System.arraycopy(bArr3, 0, bArrM76805i, i17, bArr3.length);
        aVar.f58499d += this.f58487i.length;
    }

    /* renamed from: t */
    public final void m76797t(byte[] bArr, int i10, int i11, AbstractC12800b.a aVar) {
        int i12 = 0;
        while (i12 < i11) {
            byte[] bArrM76805i = m76805i(this.f58489k, aVar);
            int i13 = (aVar.f58503h + 1) % 3;
            aVar.f58503h = i13;
            int i14 = i10 + 1;
            int i15 = bArr[i10];
            if (i15 < 0) {
                i15 += 256;
            }
            int i16 = (aVar.f58496a << 8) + i15;
            aVar.f58496a = i16;
            if (i13 == 0) {
                int i17 = aVar.f58499d;
                byte[] bArr2 = this.f58485g;
                bArrM76805i[i17] = bArr2[(i16 >> 18) & 63];
                bArrM76805i[i17 + 1] = bArr2[(i16 >> 12) & 63];
                int i18 = i17 + 3;
                bArrM76805i[i17 + 2] = bArr2[(i16 >> 6) & 63];
                int i19 = i17 + 4;
                aVar.f58499d = i19;
                bArrM76805i[i18] = bArr2[i16 & 63];
                int i20 = aVar.f58502g + 4;
                aVar.f58502g = i20;
                int i21 = this.f58492c;
                if (i21 > 0 && i21 <= i20) {
                    byte[] bArr3 = this.f58487i;
                    System.arraycopy(bArr3, 0, bArrM76805i, i19, bArr3.length);
                    aVar.f58499d += this.f58487i.length;
                    aVar.f58502g = 0;
                }
            }
            i12++;
            i10 = i14;
        }
    }

    /* renamed from: u */
    public final long m76798u(int i10, AbstractC12800b.a aVar) {
        if ((aVar.f58496a & i10) == 0) {
            return r0 >> i10;
        }
        throw new IllegalArgumentException("Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible value");
    }

    public C12799a(int i10, byte[] bArr) {
        this(i10, bArr, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12799a(int i10, byte[] bArr, boolean z10) {
        int length;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        super(3, 4, i10, length);
        this.f58486h = f58484o;
        if (bArr != null) {
            if (m76800b(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + C5281eb.m31713b(bArr) + "]");
            }
            if (i10 > 0) {
                this.f58489k = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f58487i = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f58489k = 4;
                this.f58487i = null;
            }
        } else {
            this.f58489k = 4;
            this.f58487i = null;
        }
        this.f58488j = this.f58489k - 1;
        this.f58485g = z10 ? f58483n : f58482m;
    }

    public C12799a(boolean z10) {
        this(76, f58481l, z10);
    }

    public C12799a(int i10) {
        this(i10, f58481l);
    }
}
