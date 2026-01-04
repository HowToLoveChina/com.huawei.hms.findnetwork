package p300fx;

import java.security.SecureRandom;
import p319gx.C10058a;
import p349hx.C10356a;
import p376ix.C10631a;
import p502nx.EnumC11761a;

/* renamed from: fx.a */
/* loaded from: classes9.dex */
public class C9779a implements InterfaceC9781c {

    /* renamed from: a */
    public C10356a f48102a;

    /* renamed from: b */
    public C10058a f48103b;

    /* renamed from: d */
    public boolean f48105d;

    /* renamed from: g */
    public final byte[] f48108g;

    /* renamed from: h */
    public final byte[] f48109h;

    /* renamed from: i */
    public byte[] f48110i;

    /* renamed from: j */
    public byte[] f48111j;

    /* renamed from: c */
    public final SecureRandom f48104c = new SecureRandom();

    /* renamed from: e */
    public int f48106e = 1;

    /* renamed from: f */
    public int f48107f = 0;

    public C9779a(char[] cArr, EnumC11761a enumC11761a, boolean z10) throws C10631a {
        if (cArr == null || cArr.length == 0) {
            throw new C10631a("input password is empty or null");
        }
        if (enumC11761a != EnumC11761a.KEY_STRENGTH_128 && enumC11761a != EnumC11761a.KEY_STRENGTH_256) {
            throw new C10631a("Invalid AES key strength");
        }
        this.f48105d = false;
        this.f48109h = new byte[16];
        this.f48108g = new byte[16];
        m60844f(cArr, enumC11761a, z10);
    }

    @Override // p300fx.InterfaceC9781c
    /* renamed from: a */
    public int mo60839a(byte[] bArr, int i10, int i11) throws C10631a {
        int i12;
        if (this.f48105d) {
            throw new C10631a("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (i11 % 16 != 0) {
            this.f48105d = true;
        }
        int i13 = i10;
        while (true) {
            int i14 = i10 + i11;
            if (i13 >= i14) {
                return i11;
            }
            int i15 = i13 + 16;
            this.f48107f = i15 <= i14 ? 16 : i14 - i13;
            C9780b.m60849e(this.f48108g, this.f48106e);
            this.f48102a.m63769e(this.f48108g, this.f48109h);
            int i16 = 0;
            while (true) {
                i12 = this.f48107f;
                if (i16 < i12) {
                    int i17 = i13 + i16;
                    bArr[i17] = (byte) (bArr[i17] ^ this.f48109h[i16]);
                    i16++;
                }
            }
            this.f48103b.m62532g(bArr, i13, i12);
            this.f48106e++;
            i13 = i15;
        }
    }

    /* renamed from: b */
    public final byte[] m60840b(int i10) throws C10631a {
        if (i10 != 8 && i10 != 16) {
            throw new C10631a("invalid salt size, cannot generate salt");
        }
        int i11 = i10 == 8 ? 2 : 4;
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < i11; i12++) {
            int iNextInt = this.f48104c.nextInt();
            int i13 = i12 * 4;
            bArr[i13] = (byte) (iNextInt >> 24);
            bArr[i13 + 1] = (byte) (iNextInt >> 16);
            bArr[i13 + 2] = (byte) (iNextInt >> 8);
            bArr[i13 + 3] = (byte) iNextInt;
        }
        return bArr;
    }

    /* renamed from: c */
    public byte[] m60841c() {
        return this.f48110i;
    }

    /* renamed from: d */
    public byte[] m60842d() {
        byte[] bArr = new byte[10];
        System.arraycopy(this.f48103b.m62529d(), 0, bArr, 0, 10);
        return bArr;
    }

    /* renamed from: e */
    public byte[] m60843e() {
        return this.f48111j;
    }

    /* renamed from: f */
    public final void m60844f(char[] cArr, EnumC11761a enumC11761a, boolean z10) throws C10631a {
        byte[] bArrM60840b = m60840b(enumC11761a.m70089k());
        this.f48111j = bArrM60840b;
        byte[] bArrM60845a = C9780b.m60845a(bArrM60840b, cArr, enumC11761a, z10);
        this.f48110i = C9780b.m60846b(bArrM60845a, enumC11761a);
        this.f48102a = C9780b.m60847c(bArrM60845a, enumC11761a);
        this.f48103b = C9780b.m60848d(bArrM60845a, enumC11761a);
    }
}
