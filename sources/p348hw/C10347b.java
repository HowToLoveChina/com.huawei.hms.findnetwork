package p348hw;

/* renamed from: hw.b */
/* loaded from: classes9.dex */
public class C10347b {

    /* renamed from: a */
    public final double f50041a;

    /* renamed from: b */
    public final double f50042b;

    public C10347b(double d10, double d11) {
        this.f50041a = d10;
        this.f50042b = d11;
    }

    /* renamed from: a */
    public double m63713a(C10347b c10347b) {
        return Math.sqrt((this.f50041a * c10347b.f50041a) + (this.f50042b * c10347b.f50042b));
    }

    /* renamed from: b */
    public C10347b m63714b(C10347b c10347b) {
        return new C10347b(this.f50041a + c10347b.f50041a, this.f50042b + c10347b.f50042b);
    }

    /* renamed from: c */
    public C10347b m63715c() {
        return new C10347b(this.f50041a, -this.f50042b);
    }

    /* renamed from: d */
    public C10347b m63716d(double d10) {
        return new C10347b(this.f50041a / d10, this.f50042b / d10);
    }

    /* renamed from: e */
    public double m63717e() {
        return this.f50041a;
    }

    /* renamed from: f */
    public C10347b m63718f(C10347b c10347b) {
        double d10 = this.f50041a;
        double d11 = c10347b.f50041a;
        double d12 = this.f50042b;
        double d13 = c10347b.f50042b;
        return new C10347b((d10 * d11) - (d12 * d13), (d10 * d13) + (d12 * d11));
    }

    /* renamed from: g */
    public C10347b m63719g(double d10) {
        return new C10347b(this.f50041a * d10, d10 * this.f50042b);
    }

    /* renamed from: h */
    public C10347b m63720h(C10347b c10347b) {
        return new C10347b(this.f50041a - c10347b.f50041a, this.f50042b - c10347b.f50042b);
    }
}
