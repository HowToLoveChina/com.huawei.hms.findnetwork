package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.y */
/* loaded from: classes.dex */
public class C0550y {

    /* renamed from: a */
    public int f2437a = 0;

    /* renamed from: b */
    public int f2438b = 0;

    /* renamed from: c */
    public int f2439c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f2440d = Integer.MIN_VALUE;

    /* renamed from: e */
    public int f2441e = 0;

    /* renamed from: f */
    public int f2442f = 0;

    /* renamed from: g */
    public boolean f2443g = false;

    /* renamed from: h */
    public boolean f2444h = false;

    /* renamed from: a */
    public int m3182a() {
        return this.f2443g ? this.f2437a : this.f2438b;
    }

    /* renamed from: b */
    public int m3183b() {
        return this.f2437a;
    }

    /* renamed from: c */
    public int m3184c() {
        return this.f2438b;
    }

    /* renamed from: d */
    public int m3185d() {
        return this.f2443g ? this.f2438b : this.f2437a;
    }

    /* renamed from: e */
    public void m3186e(int i10, int i11) {
        this.f2444h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f2441e = i10;
            this.f2437a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f2442f = i11;
            this.f2438b = i11;
        }
    }

    /* renamed from: f */
    public void m3187f(boolean z10) {
        if (z10 == this.f2443g) {
            return;
        }
        this.f2443g = z10;
        if (!this.f2444h) {
            this.f2437a = this.f2441e;
            this.f2438b = this.f2442f;
            return;
        }
        if (z10) {
            int i10 = this.f2440d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f2441e;
            }
            this.f2437a = i10;
            int i11 = this.f2439c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f2442f;
            }
            this.f2438b = i11;
            return;
        }
        int i12 = this.f2439c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f2441e;
        }
        this.f2437a = i12;
        int i13 = this.f2440d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f2442f;
        }
        this.f2438b = i13;
    }

    /* renamed from: g */
    public void m3188g(int i10, int i11) {
        this.f2439c = i10;
        this.f2440d = i11;
        this.f2444h = true;
        if (this.f2443g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f2437a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f2438b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f2437a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f2438b = i11;
        }
    }
}
