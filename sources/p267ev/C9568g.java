package p267ev;

import mv.SafeBytes;

/* renamed from: ev.g */
/* loaded from: classes9.dex */
public class C9568g {

    /* renamed from: a */
    public byte[] f47497a;

    /* renamed from: b */
    public byte[] f47498b;

    /* renamed from: c */
    public EnumC9566e f47499c = EnumC9566e.UNKNOWN;

    /* renamed from: a */
    public EnumC9566e m59696a() {
        return this.f47499c;
    }

    /* renamed from: b */
    public byte[] m59697b() {
        return SafeBytes.doClone(this.f47497a);
    }

    /* renamed from: c */
    public byte[] m59698c() {
        return SafeBytes.doClone(this.f47498b);
    }

    /* renamed from: d */
    public void m59699d(EnumC9566e enumC9566e) {
        this.f47499c = enumC9566e;
    }

    /* renamed from: e */
    public void m59700e(byte[] bArr) {
        this.f47497a = SafeBytes.doClone(bArr);
    }

    /* renamed from: f */
    public void m59701f(byte[] bArr) {
        this.f47498b = SafeBytes.doClone(bArr);
    }
}
