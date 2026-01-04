package p300fx;

import java.security.SecureRandom;
import p349hx.C10357b;
import p376ix.C10631a;

/* renamed from: fx.d */
/* loaded from: classes9.dex */
public class C9782d implements InterfaceC9781c {

    /* renamed from: a */
    public final C10357b f48112a = new C10357b();

    /* renamed from: b */
    public byte[] f48113b;

    public C9782d(char[] cArr, long j10, boolean z10) throws C10631a {
        m60854f(cArr, j10, z10);
    }

    @Override // p300fx.InterfaceC9781c
    /* renamed from: a */
    public int mo60839a(byte[] bArr, int i10, int i11) throws C10631a {
        if (i11 < 0) {
            throw new C10631a("invalid length specified to decrpyt data");
        }
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            bArr[i12] = m60850b(bArr[i12]);
        }
        return i11;
    }

    /* renamed from: b */
    public byte m60850b(byte b10) {
        byte bM63775b = (byte) ((this.f48112a.m63775b() & 255) ^ b10);
        this.f48112a.m63777d(b10);
        return bM63775b;
    }

    /* renamed from: c */
    public int m60851c(byte[] bArr) throws C10631a {
        bArr.getClass();
        return mo60839a(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public byte[] m60852d() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i10 = 0; i10 < 12; i10++) {
            bArr[i10] = m60850b((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    /* renamed from: e */
    public byte[] m60853e() {
        return this.f48113b;
    }

    /* renamed from: f */
    public final void m60854f(char[] cArr, long j10, boolean z10) throws C10631a {
        if (cArr == null || cArr.length <= 0) {
            throw new C10631a("input password is null or empty, cannot initialize standard encrypter");
        }
        this.f48112a.m63776c(cArr, z10);
        this.f48113b = m60852d();
        this.f48112a.m63776c(cArr, z10);
        byte[] bArr = this.f48113b;
        bArr[11] = (byte) (j10 >>> 24);
        bArr[10] = (byte) (j10 >>> 16);
        m60851c(bArr);
    }
}
