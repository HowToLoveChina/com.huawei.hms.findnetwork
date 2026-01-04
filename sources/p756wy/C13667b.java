package p756wy;

import az.C1081e;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p271ez.AbstractC9578d;
import p722vy.C13501a;
import uy.C13293g;
import uy.C13294h;
import uy.C13296j;
import uy.InterfaceC13287a;
import uy.InterfaceC13288b;

/* renamed from: wy.b */
/* loaded from: classes9.dex */
public class C13667b implements InterfaceC13287a {

    /* renamed from: c */
    public static final byte[] f61551c = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, BaseType.MaxBaseType, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, BaseType.Float, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, -128, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, BaseType.Obj, 75, 112, 86, -99, 53, 30, 36, BaseType.Vector, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, PublicSuffixDatabase.f29565i, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, 127, BaseType.Array, -39, 92, 65, 31, BaseType.Union, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, BaseType.Vector64, -72, -27, -76, -80, -119, 105, -105, 74, BaseType.Double, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: d */
    public static final int[] f61552d = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    /* renamed from: e */
    public static final int[] f61553e = {-1548633402, 1453994832, 1736282519, -1301273892};

    /* renamed from: a */
    public final int[] f61554a = new int[4];

    /* renamed from: b */
    public int[] f61555b;

    @Override // uy.InterfaceC13287a
    /* renamed from: a */
    public String mo79736a() {
        return "SM4";
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: b */
    public int mo79737b(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, C13294h {
        if (this.f61555b == null) {
            throw new IllegalStateException("SM4 not initialised");
        }
        if (i10 + 16 > bArr.length) {
            throw new C13294h("input buffer too short");
        }
        if (i11 + 16 > bArr2.length) {
            throw new C13296j("output buffer too short");
        }
        this.f61554a[0] = AbstractC9578d.m59769a(bArr, i10);
        this.f61554a[1] = AbstractC9578d.m59769a(bArr, i10 + 4);
        this.f61554a[2] = AbstractC9578d.m59769a(bArr, i10 + 8);
        this.f61554a[3] = AbstractC9578d.m59769a(bArr, i10 + 12);
        for (int i12 = 0; i12 < 32; i12 += 4) {
            int[] iArr = this.f61554a;
            iArr[0] = m82208e(iArr, this.f61555b[i12]);
            int[] iArr2 = this.f61554a;
            iArr2[1] = m82209f(iArr2, this.f61555b[i12 + 1]);
            int[] iArr3 = this.f61554a;
            iArr3[2] = m82210g(iArr3, this.f61555b[i12 + 2]);
            int[] iArr4 = this.f61554a;
            iArr4[3] = m82211h(iArr4, this.f61555b[i12 + 3]);
        }
        AbstractC9578d.m59770b(this.f61554a[3], bArr2, i11);
        AbstractC9578d.m59770b(this.f61554a[2], bArr2, i11 + 4);
        AbstractC9578d.m59770b(this.f61554a[1], bArr2, i11 + 8);
        AbstractC9578d.m59770b(this.f61554a[0], bArr2, i11 + 12);
        return 16;
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: c */
    public int mo79738c() {
        return 16;
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: d */
    public void mo79739d(boolean z10, InterfaceC13288b interfaceC13288b) throws IllegalArgumentException {
        if (!(interfaceC13288b instanceof C1081e)) {
            throw new IllegalArgumentException("invalid parameter passed to SM4 init - " + interfaceC13288b.getClass().getName());
        }
        byte[] bArrM6455a = ((C1081e) interfaceC13288b).m6455a();
        if (bArrM6455a.length != 16) {
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        this.f61555b = m82216m(z10, bArrM6455a);
        C13293g.m79741a(new C13501a(mo79736a(), 128, interfaceC13288b, C13668c.m82219a(z10)));
    }

    /* renamed from: e */
    public final int m82208e(int[] iArr, int i10) {
        return m82214k((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i10) ^ iArr[0];
    }

    /* renamed from: f */
    public final int m82209f(int[] iArr, int i10) {
        return m82214k((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i10) ^ iArr[1];
    }

    /* renamed from: g */
    public final int m82210g(int[] iArr, int i10) {
        return m82214k((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i10) ^ iArr[2];
    }

    /* renamed from: h */
    public final int m82211h(int[] iArr, int i10) {
        return m82214k((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i10) ^ iArr[3];
    }

    /* renamed from: i */
    public final int m82212i(int i10) {
        return m82217n(i10, 24) ^ (((m82217n(i10, 2) ^ i10) ^ m82217n(i10, 10)) ^ m82217n(i10, 18));
    }

    /* renamed from: j */
    public final int m82213j(int i10) {
        return m82217n(i10, 23) ^ (m82217n(i10, 13) ^ i10);
    }

    /* renamed from: k */
    public final int m82214k(int i10) {
        return m82212i(m82218o(i10));
    }

    /* renamed from: l */
    public final int m82215l(int i10) {
        return m82213j(m82218o(i10));
    }

    /* renamed from: m */
    public final int[] m82216m(boolean z10, byte[] bArr) {
        int[] iArr = new int[32];
        int[] iArr2 = {AbstractC9578d.m59769a(bArr, 0), AbstractC9578d.m59769a(bArr, 4), AbstractC9578d.m59769a(bArr, 8), AbstractC9578d.m59769a(bArr, 12)};
        int i10 = iArr2[0];
        int[] iArr3 = f61553e;
        int[] iArr4 = {i10 ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
        if (z10) {
            int i11 = iArr4[0];
            int i12 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr5 = f61552d;
            int iM82215l = i11 ^ m82215l(i12 ^ iArr5[0]);
            iArr[0] = iM82215l;
            int iM82215l2 = m82215l((iM82215l ^ (iArr4[2] ^ iArr4[3])) ^ iArr5[1]) ^ iArr4[1];
            iArr[1] = iM82215l2;
            int iM82215l3 = m82215l((iM82215l2 ^ (iArr4[3] ^ iArr[0])) ^ iArr5[2]) ^ iArr4[2];
            iArr[2] = iM82215l3;
            iArr[3] = m82215l((iM82215l3 ^ (iArr[0] ^ iArr[1])) ^ iArr5[3]) ^ iArr4[3];
            for (int i13 = 4; i13 < 32; i13++) {
                iArr[i13] = iArr[i13 - 4] ^ m82215l(((iArr[i13 - 3] ^ iArr[i13 - 2]) ^ iArr[i13 - 1]) ^ f61552d[i13]);
            }
        } else {
            int i14 = iArr4[0];
            int i15 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr6 = f61552d;
            int iM82215l4 = i14 ^ m82215l(i15 ^ iArr6[0]);
            iArr[31] = iM82215l4;
            int iM82215l5 = m82215l((iM82215l4 ^ (iArr4[2] ^ iArr4[3])) ^ iArr6[1]) ^ iArr4[1];
            iArr[30] = iM82215l5;
            int iM82215l6 = m82215l((iM82215l5 ^ (iArr4[3] ^ iArr[31])) ^ iArr6[2]) ^ iArr4[2];
            iArr[29] = iM82215l6;
            iArr[28] = m82215l((iM82215l6 ^ (iArr[31] ^ iArr[30])) ^ iArr6[3]) ^ iArr4[3];
            for (int i16 = 27; i16 >= 0; i16--) {
                iArr[i16] = iArr[i16 + 4] ^ m82215l(((iArr[i16 + 3] ^ iArr[i16 + 2]) ^ iArr[i16 + 1]) ^ f61552d[31 - i16]);
            }
        }
        return iArr;
    }

    /* renamed from: n */
    public final int m82217n(int i10, int i11) {
        return (i10 << i11) | (i10 >>> (-i11));
    }

    /* renamed from: o */
    public final int m82218o(int i10) {
        byte[] bArr = f61551c;
        return (bArr[i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA] & 255) | ((bArr[(i10 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA] & 255) << 24) | ((bArr[(i10 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA] & 255) << 16) | ((bArr[(i10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA] & 255) << 8);
    }

    @Override // uy.InterfaceC13287a
    public void reset() {
    }
}
