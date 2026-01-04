package bz;

import java.security.SecureRandom;

/* renamed from: bz.a */
/* loaded from: classes9.dex */
public class C1358a implements InterfaceC1361d {

    /* renamed from: a */
    public final SecureRandom f5853a;

    /* renamed from: b */
    public final boolean f5854b;

    /* renamed from: bz.a$a */
    public class a implements InterfaceC1360c {

        /* renamed from: a */
        public final /* synthetic */ int f5855a;

        public a(int i10) {
            this.f5855a = i10;
        }

        @Override // bz.InterfaceC1360c
        /* renamed from: a */
        public byte[] mo7857a() {
            if (!(C1358a.this.f5853a instanceof C1363f)) {
                SecureRandom unused = C1358a.this.f5853a;
                return C1358a.this.f5853a.generateSeed((this.f5855a + 7) / 8);
            }
            byte[] bArr = new byte[(this.f5855a + 7) / 8];
            C1358a.this.f5853a.nextBytes(bArr);
            return bArr;
        }

        @Override // bz.InterfaceC1360c
        /* renamed from: b */
        public int mo7858b() {
            return this.f5855a;
        }
    }

    public C1358a(SecureRandom secureRandom, boolean z10) {
        this.f5853a = secureRandom;
        this.f5854b = z10;
    }

    @Override // bz.InterfaceC1361d
    public InterfaceC1360c get(int i10) {
        return new a(i10);
    }
}
