package p463lz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import p351hz.C10366e;

/* renamed from: lz.d */
/* loaded from: classes9.dex */
public final class C11382d extends AbstractC11380b {

    /* renamed from: c */
    public final DataInputStream f53113c;

    public C11382d(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f53113c = dataInputStream;
        if (dataInputStream.readUnsignedByte() != 0) {
            throw new C10366e();
        }
        this.f53110b = dataInputStream.readInt();
        this.f53109a = -1;
    }

    @Override // p463lz.AbstractC11380b
    /* renamed from: f */
    public void mo68244f() throws IOException {
        if ((this.f53109a & (-16777216)) == 0) {
            this.f53110b = (this.f53110b << 8) | this.f53113c.readUnsignedByte();
            this.f53109a <<= 8;
        }
    }

    /* renamed from: g */
    public boolean m68248g() {
        return this.f53110b == 0;
    }
}
