package p349hx;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p594qx.C12427f;

/* renamed from: hx.b */
/* loaded from: classes9.dex */
public class C10357b {

    /* renamed from: b */
    public static final int[] f50096b = new int[256];

    /* renamed from: a */
    public final int[] f50097a = new int[3];

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10;
            for (int i12 = 0; i12 < 8; i12++) {
                i11 = (i11 & 1) == 1 ? (i11 >>> 1) ^ (-306674912) : i11 >>> 1;
            }
            f50096b[i10] = i11;
        }
    }

    /* renamed from: a */
    public final int m63774a(int i10, byte b10) {
        return (i10 >>> 8) ^ f50096b[(i10 ^ b10) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA];
    }

    /* renamed from: b */
    public byte m63775b() {
        int i10 = this.f50097a[2] | 2;
        return (byte) ((i10 * (i10 ^ 1)) >>> 8);
    }

    /* renamed from: c */
    public void m63776c(char[] cArr, boolean z10) {
        int[] iArr = this.f50097a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (byte b10 : C12427f.m74611a(cArr, z10)) {
            m63777d((byte) (b10 & 255));
        }
    }

    /* renamed from: d */
    public void m63777d(byte b10) {
        int[] iArr = this.f50097a;
        iArr[0] = m63774a(iArr[0], b10);
        int[] iArr2 = this.f50097a;
        int i10 = iArr2[1] + (iArr2[0] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        iArr2[1] = i10;
        int i11 = (i10 * 134775813) + 1;
        iArr2[1] = i11;
        iArr2[2] = m63774a(iArr2[2], (byte) (i11 >> 24));
    }
}
