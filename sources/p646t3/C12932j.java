package p646t3;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p831z3.C14090a0;

/* renamed from: t3.j */
/* loaded from: classes.dex */
public final class C12932j implements InterfaceC12678a {

    /* renamed from: c */
    public static final byte[] f58963c = new byte[0];

    /* renamed from: a */
    public final C14090a0 f58964a;

    /* renamed from: b */
    public final InterfaceC12678a f58965b;

    public C12932j(C14090a0 c14090a0, InterfaceC12678a interfaceC12678a) {
        this.f58964a = c14090a0;
        this.f58965b = interfaceC12678a;
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: a */
    public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrMo11460j = C12695r.m76386o(this.f58964a).mo11460j();
        return m77649c(this.f58965b.mo88a(bArrMo11460j, f58963c), ((InterfaceC12678a) C12695r.m76380i(this.f58964a.m84457S(), bArrMo11460j, InterfaceC12678a.class)).mo88a(bArr, bArr2));
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: b */
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i10 = byteBufferWrap.getInt();
            if (i10 <= 0 || i10 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i10];
            byteBufferWrap.get(bArr3, 0, i10);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((InterfaceC12678a) C12695r.m76380i(this.f58964a.m84457S(), this.f58965b.mo89b(bArr3, f58963c), InterfaceC12678a.class)).mo89b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e10) {
            throw new GeneralSecurityException("invalid ciphertext", e10);
        }
    }

    /* renamed from: c */
    public final byte[] m77649c(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }
}
