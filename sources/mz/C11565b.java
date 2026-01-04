package mz;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: mz.b */
/* loaded from: classes9.dex */
public final class C11565b implements InterfaceC11569f {

    /* renamed from: a */
    public final boolean f53624a;

    /* renamed from: b */
    public int f53625b;

    public C11565b(boolean z10, int i10) {
        this.f53624a = z10;
        this.f53625b = i10 + 4;
    }

    @Override // mz.InterfaceC11569f
    /* renamed from: a */
    public int mo69042a(byte[] bArr, int i10, int i11) {
        int i12 = (i11 + i10) - 4;
        int i13 = i10;
        while (i13 <= i12) {
            int i14 = i13 + 1;
            int i15 = bArr[i14];
            if ((i15 & 248) == 240) {
                int i16 = i13 + 3;
                int i17 = bArr[i16];
                if ((i17 & 248) == 248) {
                    int i18 = ((i15 & 7) << 19) | ((bArr[i13] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 11) | ((i17 & 7) << 8);
                    int i19 = i13 + 2;
                    int i20 = (i18 | (bArr[i19] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA)) << 1;
                    int i21 = this.f53624a ? i20 + ((this.f53625b + i13) - i10) : i20 - ((this.f53625b + i13) - i10);
                    bArr[i14] = (byte) (240 | ((i21 >>> 20) & 7));
                    bArr[i13] = (byte) (i21 >>> 12);
                    bArr[i16] = (byte) (((i21 >>> 9) & 7) | 248);
                    bArr[i19] = (byte) (i21 >>> 1);
                    i13 = i19;
                }
            }
            i13 += 2;
        }
        int i22 = i13 - i10;
        this.f53625b += i22;
        return i22;
    }
}
