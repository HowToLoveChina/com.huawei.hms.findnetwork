package p856zu;

import mv.SafeBytes;

/* renamed from: zu.b */
/* loaded from: classes9.dex */
public class C14381b {

    /* renamed from: a */
    public byte[] f63752a;

    /* renamed from: b */
    public byte[] m_key;

    /* renamed from: c */
    public enumEncryptAlgorithm m_algorithm = enumEncryptAlgorithm.UNKNOWN;

    /* renamed from: a */
    public enumEncryptAlgorithm getAlgorithm() {
        return this.m_algorithm;
    }

    /* renamed from: b */
    public byte[] m85609b() {
        return SafeBytes.doClone(this.m_key);
    }

    /* renamed from: c */
    public byte[] m85610c() {
        return SafeBytes.doClone(this.f63752a);
    }

    /* renamed from: d */
    public void setAlgorithm(enumEncryptAlgorithm enumEncryptAlgorithm) {
        this.m_algorithm = enumEncryptAlgorithm;
    }

    /* renamed from: e */
    public void setKey(byte[] bArr) {
        this.m_key = SafeBytes.doClone(bArr);
    }

    /* renamed from: f */
    public void m85613f(byte[] bArr) {
        this.f63752a = SafeBytes.doClone(bArr);
    }
}
