package bz;

import cz.C8965a;
import cz.InterfaceC8966b;
import java.security.SecureRandom;
import uy.InterfaceC13287a;

/* renamed from: bz.g */
/* loaded from: classes9.dex */
public class C1364g {

    /* renamed from: a */
    public final SecureRandom f5862a;

    /* renamed from: b */
    public final InterfaceC1361d f5863b;

    /* renamed from: c */
    public byte[] f5864c;

    /* renamed from: d */
    public int f5865d = 256;

    /* renamed from: e */
    public int f5866e = 256;

    /* renamed from: bz.g$a */
    public static class a implements InterfaceC1359b {

        /* renamed from: a */
        public final InterfaceC13287a f5867a;

        /* renamed from: b */
        public final int f5868b;

        /* renamed from: c */
        public final byte[] f5869c;

        /* renamed from: d */
        public final byte[] f5870d;

        /* renamed from: e */
        public final int f5871e;

        public a(InterfaceC13287a interfaceC13287a, int i10, byte[] bArr, byte[] bArr2, int i11) {
            this.f5867a = interfaceC13287a;
            this.f5868b = i10;
            this.f5869c = bArr;
            this.f5870d = bArr2;
            this.f5871e = i11;
        }

        @Override // bz.InterfaceC1359b
        /* renamed from: a */
        public InterfaceC8966b mo7859a(InterfaceC1360c interfaceC1360c) {
            return new C8965a(this.f5867a, this.f5868b, this.f5871e, interfaceC1360c, this.f5870d, this.f5869c);
        }

        @Override // bz.InterfaceC1359b
        /* renamed from: b */
        public String mo7860b() {
            return "CTR-DRBG-" + this.f5867a.mo79736a() + this.f5868b;
        }
    }

    public C1364g(SecureRandom secureRandom, boolean z10) {
        this.f5862a = secureRandom;
        this.f5863b = new C1358a(secureRandom, z10);
    }

    /* renamed from: a */
    public C1363f m7862a(InterfaceC13287a interfaceC13287a, int i10, byte[] bArr, boolean z10) {
        return new C1363f(this.f5862a, this.f5863b.get(this.f5866e), new a(interfaceC13287a, i10, bArr, this.f5864c, this.f5865d), z10);
    }

    /* renamed from: b */
    public C1364g m7863b(int i10) {
        this.f5866e = i10;
        return this;
    }
}
