package bz;

import cz.InterfaceC8966b;
import java.security.SecureRandom;

/* renamed from: bz.f */
/* loaded from: classes9.dex */
public class C1363f extends SecureRandom {

    /* renamed from: a */
    public final InterfaceC1359b f5857a;

    /* renamed from: b */
    public final boolean f5858b;

    /* renamed from: c */
    public final SecureRandom f5859c;

    /* renamed from: d */
    public final InterfaceC1360c f5860d;

    /* renamed from: e */
    public InterfaceC8966b f5861e;

    public C1363f(SecureRandom secureRandom, InterfaceC1360c interfaceC1360c, InterfaceC1359b interfaceC1359b, boolean z10) {
        this.f5859c = secureRandom;
        this.f5860d = interfaceC1360c;
        this.f5857a = interfaceC1359b;
        this.f5858b = z10;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i10) {
        return C1362e.m7861a(this.f5860d, i10);
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return this.f5857a.mo7860b();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.f5861e == null) {
                    this.f5861e = this.f5857a.mo7859a(this.f5860d);
                }
                if (this.f5861e.mo56728b(bArr, null, this.f5858b) < 0) {
                    this.f5861e.mo56727a(null);
                    this.f5861e.mo56728b(bArr, null, this.f5858b);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j10) {
        synchronized (this) {
            try {
                SecureRandom secureRandom = this.f5859c;
                if (secureRandom != null) {
                    secureRandom.setSeed(j10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
        synchronized (this) {
            try {
                SecureRandom secureRandom = this.f5859c;
                if (secureRandom != null) {
                    secureRandom.setSeed(bArr);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
