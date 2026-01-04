package sy;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;

/* renamed from: sy.o */
/* loaded from: classes9.dex */
public class C12891o extends AbstractC12877a {
    public C12891o(byte[] bArr) {
        this(bArr, 0);
    }

    @Override // sy.AbstractC12885i
    /* renamed from: d */
    public void mo77279d(C12883g c12883g, boolean z10) throws IOException {
        byte[] bArr = this.f58654a;
        int i10 = bArr[0] & 255;
        int length = bArr.length - 1;
        byte b10 = bArr[length];
        byte b11 = (byte) ((HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA << i10) & b10);
        if (b10 == b11) {
            c12883g.m77298i(z10, 3, bArr);
        } else {
            c12883g.m77299j(z10, 3, bArr, 0, length, b11);
        }
    }

    @Override // sy.AbstractC12885i
    /* renamed from: f */
    public int mo77280f(boolean z10) {
        return C12883g.m77292e(z10, this.f58654a.length);
    }

    @Override // sy.AbstractC12877a, sy.AbstractC12885i
    /* renamed from: h */
    public AbstractC12885i mo77272h() {
        return this;
    }

    public C12891o(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    public C12891o(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }
}
