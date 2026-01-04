package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.vb */
/* loaded from: classes8.dex */
public final class C6131vb {

    /* renamed from: h */
    public static final int f28796h = 8192;

    /* renamed from: i */
    public static final int f28797i = 1024;

    /* renamed from: a */
    public final byte[] f28798a;

    /* renamed from: b */
    public int f28799b;

    /* renamed from: c */
    public int f28800c;

    /* renamed from: d */
    public boolean f28801d;

    /* renamed from: e */
    public boolean f28802e;

    /* renamed from: f */
    public C6131vb f28803f;

    /* renamed from: g */
    public C6131vb f28804g;

    public C6131vb() {
        this.f28798a = new byte[8192];
        this.f28802e = true;
        this.f28801d = false;
    }

    /* renamed from: a */
    public final C6131vb m35700a(int i10) {
        C6131vb c6131vbM35760a;
        if (i10 <= 0 || i10 > this.f28800c - this.f28799b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            c6131vbM35760a = m35705c();
        } else {
            c6131vbM35760a = C6144wb.m35760a();
            System.arraycopy(this.f28798a, this.f28799b, c6131vbM35760a.f28798a, 0, i10);
        }
        c6131vbM35760a.f28800c = c6131vbM35760a.f28799b + i10;
        this.f28799b += i10;
        this.f28804g.m35701a(c6131vbM35760a);
        return c6131vbM35760a;
    }

    /* renamed from: b */
    public final C6131vb m35704b() {
        C6131vb c6131vb = this.f28803f;
        C6131vb c6131vb2 = c6131vb != this ? c6131vb : null;
        C6131vb c6131vb3 = this.f28804g;
        c6131vb3.f28803f = c6131vb;
        this.f28803f.f28804g = c6131vb3;
        this.f28803f = null;
        this.f28804g = null;
        return c6131vb2;
    }

    /* renamed from: c */
    public final C6131vb m35705c() {
        this.f28801d = true;
        return new C6131vb(this.f28798a, this.f28799b, this.f28800c, true, false);
    }

    /* renamed from: d */
    public final C6131vb m35706d() {
        return new C6131vb((byte[]) this.f28798a.clone(), this.f28799b, this.f28800c, false, true);
    }

    public C6131vb(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.f28798a = bArr;
        this.f28799b = i10;
        this.f28800c = i11;
        this.f28801d = z10;
        this.f28802e = z11;
    }

    /* renamed from: a */
    public final C6131vb m35701a(C6131vb c6131vb) {
        c6131vb.f28804g = this;
        c6131vb.f28803f = this.f28803f;
        this.f28803f.f28804g = c6131vb;
        this.f28803f = c6131vb;
        return c6131vb;
    }

    /* renamed from: a */
    public final void m35702a() {
        C6131vb c6131vb = this.f28804g;
        if (c6131vb == this) {
            throw new IllegalStateException();
        }
        if (c6131vb.f28802e) {
            int i10 = this.f28800c - this.f28799b;
            if (i10 > (8192 - c6131vb.f28800c) + (c6131vb.f28801d ? 0 : c6131vb.f28799b)) {
                return;
            }
            m35703a(c6131vb, i10);
            m35704b();
            C6144wb.m35761a(this);
        }
    }

    /* renamed from: a */
    public final void m35703a(C6131vb c6131vb, int i10) {
        if (!c6131vb.f28802e) {
            throw new IllegalArgumentException();
        }
        int i11 = c6131vb.f28800c;
        int i12 = i11 + i10;
        if (i12 > 8192) {
            if (c6131vb.f28801d) {
                throw new IllegalArgumentException();
            }
            int i13 = c6131vb.f28799b;
            if (i12 - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = c6131vb.f28798a;
            System.arraycopy(bArr, i13, bArr, 0, i11 - i13);
            c6131vb.f28800c -= c6131vb.f28799b;
            c6131vb.f28799b = 0;
        }
        System.arraycopy(this.f28798a, this.f28799b, c6131vb.f28798a, c6131vb.f28800c, i10);
        c6131vb.f28800c += i10;
        this.f28799b += i10;
    }
}
