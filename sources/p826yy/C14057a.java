package p826yy;

import az.C1082f;
import p271ez.C9575a;
import uy.AbstractC13295i;
import uy.C13294h;
import uy.InterfaceC13287a;
import uy.InterfaceC13288b;

/* renamed from: yy.a */
/* loaded from: classes9.dex */
public class C14057a extends AbstractC13295i implements InterfaceC14058b {

    /* renamed from: a */
    public byte[] f62843a;

    /* renamed from: b */
    public byte[] f62844b;

    /* renamed from: c */
    public byte[] f62845c;

    /* renamed from: d */
    public int f62846d;

    /* renamed from: e */
    public InterfaceC13287a f62847e;

    /* renamed from: f */
    public boolean f62848f;

    public C14057a(InterfaceC13287a interfaceC13287a) {
        this.f62847e = interfaceC13287a;
        int iMo79738c = interfaceC13287a.mo79738c();
        this.f62846d = iMo79738c;
        this.f62843a = new byte[iMo79738c];
        this.f62844b = new byte[iMo79738c];
        this.f62845c = new byte[iMo79738c];
    }

    /* renamed from: g */
    public static InterfaceC14058b m84259g(InterfaceC13287a interfaceC13287a) {
        return new C14057a(interfaceC13287a);
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: a */
    public String mo79736a() {
        return this.f62847e.mo79736a() + "/CBC";
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: b */
    public int mo79737b(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, C13294h {
        return this.f62848f ? m84261f(bArr, i10, bArr2, i11) : m84260e(bArr, i10, bArr2, i11);
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: c */
    public int mo79738c() {
        return this.f62847e.mo79738c();
    }

    @Override // uy.InterfaceC13287a
    /* renamed from: d */
    public void mo79739d(boolean z10, InterfaceC13288b interfaceC13288b) throws IllegalArgumentException {
        boolean z11 = this.f62848f;
        this.f62848f = z10;
        if (interfaceC13288b instanceof C1082f) {
            C1082f c1082f = (C1082f) interfaceC13288b;
            byte[] bArrM6456a = c1082f.m6456a();
            if (bArrM6456a.length != this.f62846d) {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
            System.arraycopy(bArrM6456a, 0, this.f62843a, 0, bArrM6456a.length);
            interfaceC13288b = c1082f.m6457b();
        } else {
            C9575a.m59762e(this.f62843a, (byte) 0);
        }
        reset();
        if (interfaceC13288b != null) {
            this.f62847e.mo79739d(z10, interfaceC13288b);
        } else if (z11 != z10) {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
    }

    /* renamed from: e */
    public final int m84260e(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, C13294h {
        int i12 = this.f62846d;
        if (i10 + i12 > bArr.length) {
            throw new C13294h("input buffer too short");
        }
        System.arraycopy(bArr, i10, this.f62845c, 0, i12);
        int iMo79737b = this.f62847e.mo79737b(bArr, i10, bArr2, i11);
        for (int i13 = 0; i13 < this.f62846d; i13++) {
            int i14 = i11 + i13;
            bArr2[i14] = (byte) (bArr2[i14] ^ this.f62844b[i13]);
        }
        byte[] bArr3 = this.f62844b;
        this.f62844b = this.f62845c;
        this.f62845c = bArr3;
        return iMo79737b;
    }

    /* renamed from: f */
    public final int m84261f(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, C13294h {
        if (this.f62846d + i10 > bArr.length) {
            throw new C13294h("input buffer too short");
        }
        for (int i12 = 0; i12 < this.f62846d; i12++) {
            byte[] bArr3 = this.f62844b;
            bArr3[i12] = (byte) (bArr3[i12] ^ bArr[i10 + i12]);
        }
        int iMo79737b = this.f62847e.mo79737b(this.f62844b, 0, bArr2, i11);
        byte[] bArr4 = this.f62844b;
        System.arraycopy(bArr2, i11, bArr4, 0, bArr4.length);
        return iMo79737b;
    }

    @Override // uy.InterfaceC13287a
    public void reset() {
        byte[] bArr = this.f62843a;
        System.arraycopy(bArr, 0, this.f62844b, 0, bArr.length);
        C9575a.m59762e(this.f62845c, (byte) 0);
        this.f62847e.reset();
    }
}
