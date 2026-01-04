package p270ey;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.OutputStream;
import p270ey.InterfaceC9572a;

/* renamed from: ey.c */
/* loaded from: classes9.dex */
public abstract class AbstractC9574c<E extends InterfaceC9572a> extends OutputStream {

    /* renamed from: a */
    public final byte[] f47670a = new byte[1];

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f47670a;
        bArr[0] = (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        write(bArr, 0, 1);
    }
}
