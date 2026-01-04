package sy;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import p271ez.C9575a;

/* renamed from: sy.a */
/* loaded from: classes9.dex */
public abstract class AbstractC12877a extends AbstractC12885i implements InterfaceC12878b {

    /* renamed from: b */
    public static final AbstractC12890n f58652b = new a(AbstractC12877a.class, 3);

    /* renamed from: c */
    public static final char[] f58653c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final byte[] f58654a;

    /* renamed from: sy.a$a */
    public static class a extends AbstractC12890n {
        public a(Class cls, int i10) {
            super(cls, i10);
        }
    }

    public AbstractC12877a(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i10 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f58654a = C9575a.m59765h(bArr, (byte) i10);
    }

    @Override // sy.AbstractC12885i
    /* renamed from: c */
    public boolean mo77271c(AbstractC12885i abstractC12885i) {
        if (!(abstractC12885i instanceof AbstractC12877a)) {
            return false;
        }
        byte[] bArr = this.f58654a;
        byte[] bArr2 = ((AbstractC12877a) abstractC12885i).f58654a;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i10 = length - 1;
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        int i12 = bArr[0] & 255;
        byte b10 = bArr[i10];
        int i13 = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA << i12;
        return ((byte) (b10 & i13)) == ((byte) (bArr2[i10] & i13));
    }

    @Override // sy.AbstractC12885i
    /* renamed from: h */
    public AbstractC12885i mo77272h() {
        return new C12891o(this.f58654a, false);
    }

    @Override // sy.AbstractC12885i, sy.AbstractC12881e
    public int hashCode() {
        byte[] bArr = this.f58654a;
        if (bArr.length < 2) {
            return 1;
        }
        int i10 = bArr[0] & 255;
        int length = bArr.length - 1;
        return (C9575a.m59764g(bArr, 0, length) * 257) ^ ((byte) ((HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA << i10) & bArr[length]));
    }

    /* renamed from: i */
    public String m77273i() {
        try {
            byte[] bArrM77282b = m77282b();
            StringBuffer stringBuffer = new StringBuffer((bArrM77282b.length * 2) + 1);
            stringBuffer.append('#');
            for (int i10 = 0; i10 != bArrM77282b.length; i10++) {
                byte b10 = bArrM77282b[i10];
                char[] cArr = f58653c;
                stringBuffer.append(cArr[(b10 >>> 4) & 15]);
                stringBuffer.append(cArr[b10 & BaseType.Obj]);
            }
            return stringBuffer.toString();
        } catch (IOException e10) {
            throw new C12884h("Internal error encoding BitString: " + e10.getMessage(), e10);
        }
    }

    public String toString() {
        return m77273i();
    }

    public AbstractC12877a(byte[] bArr, boolean z10) {
        if (z10) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            }
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i10 = bArr[0] & 255;
            if (i10 > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i10 > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.f58654a = bArr;
    }
}
