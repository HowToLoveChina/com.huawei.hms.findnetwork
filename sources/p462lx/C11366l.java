package p462lx;

import com.huawei.hms.network.embedded.C6130va;
import java.io.IOException;
import java.io.OutputStream;
import mx.C11557q;
import p300fx.C9782d;
import p594qx.C12427f;

/* renamed from: lx.l */
/* loaded from: classes9.dex */
public class C11366l extends AbstractC11356b<C9782d> {
    public C11366l(C11364j c11364j, C11557q c11557q, char[] cArr, boolean z10) throws IOException {
        super(c11364j, c11557q, cArr, z10);
    }

    @Override // p462lx.AbstractC11356b, java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }

    /* renamed from: x */
    public final long m68203x(C11557q c11557q) {
        return c11557q.m69010u() ? (C12427f.m74615e(c11557q.m69001l()) & C6130va.f28792s) << 16 : c11557q.m68996g();
    }

    @Override // p462lx.AbstractC11356b
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C9782d mo68164v(OutputStream outputStream, C11557q c11557q, char[] cArr, boolean z10) throws IOException {
        C9782d c9782d = new C9782d(cArr, m68203x(c11557q), z10);
        m68169w(c9782d.m60853e());
        return c9782d;
    }

    @Override // p462lx.AbstractC11356b, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // p462lx.AbstractC11356b, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        super.write(bArr, i10, i11);
    }
}
