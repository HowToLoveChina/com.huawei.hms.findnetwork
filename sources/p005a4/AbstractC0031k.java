package p005a4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;
import p631s3.InterfaceC12678a;

/* renamed from: a4.k */
/* loaded from: classes.dex */
public abstract class AbstractC0031k implements InterfaceC12678a {

    /* renamed from: a */
    public final AbstractC0029i f79a;

    /* renamed from: b */
    public final AbstractC0029i f80b;

    public AbstractC0031k(byte[] bArr) throws InvalidKeyException {
        this.f79a = mo128g(bArr, 1);
        this.f80b = mo128g(bArr, 0);
    }

    /* renamed from: f */
    public static byte[] m129f(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining % 16;
        int i11 = (i10 == 0 ? iRemaining : (iRemaining + 16) - i10) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i11 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i11);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: a */
    public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631 - this.f79a.mo118g()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + this.f79a.mo118g() + 16);
        m131d(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: b */
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return m130c(ByteBuffer.wrap(bArr), bArr2);
    }

    /* renamed from: c */
    public final byte[] m130c(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() < this.f79a.mo118g() + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr2 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr2);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        byte[] bArr3 = new byte[this.f79a.mo118g()];
        byteBuffer.get(bArr3);
        if (bArr == null) {
            bArr = new byte[0];
        }
        try {
            C0037q.m150f(m132e(bArr3), m129f(bArr, byteBuffer), bArr2);
            byteBuffer.position(iPosition);
            return this.f79a.m125e(byteBuffer);
        } catch (GeneralSecurityException e10) {
            throw new AEADBadTagException(e10.toString());
        }
    }

    /* renamed from: d */
    public final void m131d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr.length + this.f79a.mo118g() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBuffer.position();
        this.f79a.m126f(byteBuffer, bArr);
        byteBuffer.position(iPosition);
        byte[] bArr3 = new byte[this.f79a.mo118g()];
        byteBuffer.get(bArr3);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrM145a = C0037q.m145a(m132e(bArr3), m129f(bArr2, byteBuffer));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(bArrM145a);
    }

    /* renamed from: e */
    public final byte[] m132e(byte[] bArr) throws GeneralSecurityException {
        ByteBuffer byteBufferM124c = this.f80b.m124c(bArr, 0);
        byte[] bArr2 = new byte[32];
        byteBufferM124c.get(bArr2);
        return bArr2;
    }

    /* renamed from: g */
    public abstract AbstractC0029i mo128g(byte[] bArr, int i10) throws InvalidKeyException;
}
