package sy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: sy.e */
/* loaded from: classes9.dex */
public abstract class AbstractC12881e implements InterfaceC12878b {
    @Override // sy.InterfaceC12878b
    /* renamed from: a */
    public abstract AbstractC12885i mo77274a();

    /* renamed from: b */
    public byte[] m77282b() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mo77274a().m77302e(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InterfaceC12878b) {
            return mo77274a().m77303g(((InterfaceC12878b) obj).mo77274a());
        }
        return false;
    }

    public int hashCode() {
        return mo77274a().hashCode();
    }
}
