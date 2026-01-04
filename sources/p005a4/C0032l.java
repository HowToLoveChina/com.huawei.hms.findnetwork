package p005a4;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import p631s3.InterfaceC12678a;
import p631s3.InterfaceC12692o;

/* renamed from: a4.l */
/* loaded from: classes.dex */
public final class C0032l implements InterfaceC12678a {

    /* renamed from: a */
    public final InterfaceC0036p f81a;

    /* renamed from: b */
    public final InterfaceC12692o f82b;

    /* renamed from: c */
    public final int f83c;

    public C0032l(InterfaceC0036p interfaceC0036p, InterfaceC12692o interfaceC12692o, int i10) {
        this.f81a = interfaceC0036p;
        this.f82b = interfaceC12692o;
        this.f83c = i10;
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: a */
    public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrMo82a = this.f81a.mo82a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return C0027g.m111a(bArrMo82a, this.f82b.mo158b(C0027g.m111a(bArr2, bArrMo82a, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: b */
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f83c;
        if (length < i10) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i10);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.f83c, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.f82b.mo157a(bArrCopyOfRange2, C0027g.m111a(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        return this.f81a.mo83b(bArrCopyOfRange);
    }
}
