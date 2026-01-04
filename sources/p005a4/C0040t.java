package p005a4;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import p631s3.InterfaceC12692o;
import p797y3.InterfaceC13908a;

/* renamed from: a4.t */
/* loaded from: classes.dex */
public class C0040t implements InterfaceC12692o {

    /* renamed from: a */
    public final InterfaceC13908a f104a;

    /* renamed from: b */
    public final int f105b;

    public C0040t(InterfaceC13908a interfaceC13908a, int i10) throws GeneralSecurityException {
        this.f104a = interfaceC13908a;
        this.f105b = i10;
        if (i10 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        interfaceC13908a.mo152a(new byte[0], i10);
    }

    @Override // p631s3.InterfaceC12692o
    /* renamed from: a */
    public void mo157a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!C0027g.m112b(mo158b(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // p631s3.InterfaceC12692o
    /* renamed from: b */
    public byte[] mo158b(byte[] bArr) throws GeneralSecurityException {
        return this.f104a.mo152a(bArr, this.f105b);
    }
}
