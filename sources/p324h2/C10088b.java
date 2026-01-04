package p324h2;

import p630s2.C12676k;
import p829z1.InterfaceC14083v;

/* renamed from: h2.b */
/* loaded from: classes.dex */
public class C10088b implements InterfaceC14083v<byte[]> {

    /* renamed from: a */
    public final byte[] f49263a;

    public C10088b(byte[] bArr) {
        this.f49263a = (byte[]) C12676k.m76276d(bArr);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public void mo60254a() {
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f49263a;
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<byte[]> mo60255c() {
        return byte[].class;
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return this.f49263a.length;
    }
}
