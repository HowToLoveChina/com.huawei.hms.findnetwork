package p305g1;

/* renamed from: g1.e */
/* loaded from: classes.dex */
public final class C9840e {

    /* renamed from: a */
    public int f48357a;

    /* renamed from: b */
    public int f48358b;

    /* renamed from: c */
    public int f48359c;

    /* renamed from: d */
    public long f48360d;

    /* renamed from: e */
    public String f48361e;

    /* renamed from: f */
    public String f48362f;

    /* renamed from: g */
    public String f48363g;

    /* renamed from: h */
    public int f48364h;

    /* renamed from: i */
    public C9840e f48365i;

    public C9840e() {
    }

    /* renamed from: a */
    public boolean m61173a(C9840e c9840e) {
        int i10 = this.f48358b;
        if (i10 != 1) {
            if (i10 != 15) {
                if (i10 == 12) {
                    return c9840e.f48361e.equals(this.f48361e) && c9840e.f48362f.equals(this.f48362f);
                }
                if (i10 != 13) {
                    switch (i10) {
                        case 3:
                        case 4:
                            if (c9840e.f48359c != this.f48359c) {
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            if (!c9840e.f48361e.equals(this.f48361e) || !c9840e.f48362f.equals(this.f48362f) || !c9840e.f48363g.equals(this.f48363g)) {
                                break;
                            }
                            break;
                    }
                    return false;
                }
            }
            return c9840e.f48360d == this.f48360d;
        }
        return c9840e.f48361e.equals(this.f48361e);
    }

    /* renamed from: b */
    public void m61174b(int i10) {
        this.f48358b = 3;
        this.f48359c = i10;
        this.f48364h = (3 + i10) & Integer.MAX_VALUE;
    }

    /* renamed from: c */
    public void m61175c(int i10, String str, String str2, String str3) {
        this.f48358b = i10;
        this.f48361e = str;
        this.f48362f = str2;
        this.f48363g = str3;
        if (i10 != 1 && i10 != 7 && i10 != 8) {
            if (i10 == 12) {
                this.f48364h = (i10 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i10 != 13) {
                this.f48364h = (i10 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.f48364h = (i10 + str.hashCode()) & Integer.MAX_VALUE;
    }

    public C9840e(int i10, C9840e c9840e) {
        this.f48357a = i10;
        this.f48358b = c9840e.f48358b;
        this.f48359c = c9840e.f48359c;
        this.f48360d = c9840e.f48360d;
        this.f48361e = c9840e.f48361e;
        this.f48362f = c9840e.f48362f;
        this.f48363g = c9840e.f48363g;
        this.f48364h = c9840e.f48364h;
    }
}
