package p463lz;

import java.io.DataInputStream;
import java.io.IOException;
import p351hz.C10364c;
import p351hz.C10366e;

/* renamed from: lz.c */
/* loaded from: classes9.dex */
public final class C11381c extends AbstractC11380b {

    /* renamed from: c */
    public final byte[] f53111c;

    /* renamed from: d */
    public int f53112d;

    public C11381c(int i10, C10364c c10364c) {
        byte[] bArrM63795a = c10364c.m63795a(i10 - 5, false);
        this.f53111c = bArrM63795a;
        this.f53112d = bArrM63795a.length;
    }

    @Override // p463lz.AbstractC11380b
    /* renamed from: f */
    public void mo68244f() throws IOException {
        int i10 = this.f53109a;
        if (((-16777216) & i10) == 0) {
            try {
                int i11 = this.f53110b << 8;
                byte[] bArr = this.f53111c;
                int i12 = this.f53112d;
                this.f53112d = i12 + 1;
                this.f53110b = i11 | (bArr[i12] & 255);
                this.f53109a = i10 << 8;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new C10366e();
            }
        }
    }

    /* renamed from: g */
    public boolean m68245g() {
        return this.f53112d == this.f53111c.length && this.f53110b == 0;
    }

    /* renamed from: h */
    public void m68246h(DataInputStream dataInputStream, int i10) throws IOException {
        if (i10 < 5) {
            throw new C10366e();
        }
        if (dataInputStream.readUnsignedByte() != 0) {
            throw new C10366e();
        }
        this.f53110b = dataInputStream.readInt();
        this.f53109a = -1;
        int i11 = i10 - 5;
        byte[] bArr = this.f53111c;
        int length = bArr.length - i11;
        this.f53112d = length;
        dataInputStream.readFully(bArr, length, i11);
    }

    /* renamed from: i */
    public void m68247i(C10364c c10364c) {
        c10364c.m63796c(this.f53111c);
    }
}
