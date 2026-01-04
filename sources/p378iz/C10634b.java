package p378iz;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: iz.b */
/* loaded from: classes9.dex */
public class C10634b extends AbstractC10633a {
    public C10634b(int i10) {
        super(i10);
    }

    /* renamed from: a */
    public void m65133a(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            byte[] bArr2 = this.f51097b;
            int i13 = this.f51096a;
            int i14 = this.f51098c;
            byte b11 = (byte) (b10 + bArr2[(i13 + i14) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA]);
            bArr[i10] = b11;
            this.f51098c = i14 - 1;
            bArr2[i14 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA] = b11;
            i10++;
        }
    }
}
