package p784xq;

import as.C1016d;

/* renamed from: xq.a */
/* loaded from: classes8.dex */
public final class C13845a implements Cloneable {

    /* renamed from: a */
    public long f62105a;

    /* renamed from: b */
    public float f62106b;

    /* renamed from: c */
    public float f62107c;

    /* renamed from: d */
    public float f62108d;

    public C13845a() {
        this(0);
    }

    /* renamed from: c */
    public final float m83107c() {
        return this.f62107c;
    }

    public final Object clone() throws CloneNotSupportedException {
        C13845a c13845a = new C13845a();
        try {
            return super.clone() instanceof C13845a ? (C13845a) super.clone() : c13845a;
        } catch (CloneNotSupportedException unused) {
            C1016d.m6183c("SensorRecord", "Clone Not Supported Exception");
            return c13845a;
        }
    }

    /* renamed from: d */
    public final void m83108d(float f10) {
        this.f62108d = f10;
    }

    /* renamed from: f */
    public final float m83109f() {
        return this.f62108d;
    }

    /* renamed from: g */
    public final float m83110g() {
        return this.f62106b;
    }

    /* renamed from: i */
    public final void m83111i(float f10) {
        this.f62107c = f10;
    }

    /* renamed from: j */
    public final long m83112j() {
        return this.f62105a;
    }

    /* renamed from: k */
    public final void m83113k(float f10) {
        this.f62106b = f10;
    }

    /* renamed from: l */
    public final void m83114l(long j10) {
        this.f62105a = j10;
    }

    public final String toString() {
        return "time: " + this.f62105a + " x:" + this.f62106b + " y:" + this.f62107c + " z:" + this.f62108d;
    }

    public C13845a(int i10) {
        this.f62106b = 0.0f;
        this.f62107c = 0.0f;
        this.f62108d = 0.0f;
    }
}
