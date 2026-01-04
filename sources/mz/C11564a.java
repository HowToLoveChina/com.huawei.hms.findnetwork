package mz;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: mz.a */
/* loaded from: classes9.dex */
public final class C11564a implements InterfaceC11569f {

    /* renamed from: a */
    public final boolean f53622a;

    /* renamed from: b */
    public int f53623b;

    public C11564a(boolean z10, int i10) {
        this.f53622a = z10;
        this.f53623b = i10 + 8;
    }

    @Override // mz.InterfaceC11569f
    /* renamed from: a */
    public int mo69042a(byte[] bArr, int i10, int i11) {
        int i12 = (i11 + i10) - 4;
        int i13 = i10;
        while (i13 <= i12) {
            if ((bArr[i13 + 3] & 255) == 235) {
                int i14 = i13 + 2;
                int i15 = i13 + 1;
                int i16 = ((((bArr[i14] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 16) | ((bArr[i15] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 8)) | (bArr[i13] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA)) << 2;
                int i17 = this.f53622a ? i16 + ((this.f53623b + i13) - i10) : i16 - ((this.f53623b + i13) - i10);
                bArr[i14] = (byte) (i17 >>> 18);
                bArr[i15] = (byte) (i17 >>> 10);
                bArr[i13] = (byte) (i17 >>> 2);
            }
            i13 += 4;
        }
        int i18 = i13 - i10;
        this.f53623b += i18;
        return i18;
    }
}
