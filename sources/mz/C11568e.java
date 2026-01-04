package mz;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: mz.e */
/* loaded from: classes9.dex */
public final class C11568e implements InterfaceC11569f {

    /* renamed from: a */
    public final boolean f53631a;

    /* renamed from: b */
    public int f53632b;

    public C11568e(boolean z10, int i10) {
        this.f53631a = z10;
        this.f53632b = i10;
    }

    @Override // mz.InterfaceC11569f
    /* renamed from: a */
    public int mo69042a(byte[] bArr, int i10, int i11) {
        int i12 = (i11 + i10) - 4;
        int i13 = i10;
        while (i13 <= i12) {
            int i14 = bArr[i13];
            if ((i14 == 64 && (bArr[i13 + 1] & 192) == 0) || (i14 == 127 && (bArr[i13 + 1] & 192) == 192)) {
                int i15 = i13 + 1;
                int i16 = i13 + 2;
                int i17 = i13 + 3;
                int i18 = (((((i14 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 24) | ((bArr[i15] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 16)) | ((bArr[i16] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 8)) | (bArr[i17] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA)) << 2;
                int i19 = this.f53631a ? i18 + ((this.f53632b + i13) - i10) : i18 - ((this.f53632b + i13) - i10);
                int i20 = (((0 - ((i19 >>> 24) & 1)) << 22) & 1073741823) | ((i19 >>> 2) & 4194303) | 1073741824;
                bArr[i13] = (byte) (i20 >>> 24);
                bArr[i15] = (byte) (i20 >>> 16);
                bArr[i16] = (byte) (i20 >>> 8);
                bArr[i17] = (byte) i20;
            }
            i13 += 4;
        }
        int i21 = i13 - i10;
        this.f53632b += i21;
        return i21;
    }
}
