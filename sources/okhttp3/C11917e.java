package okhttp3;

import java.util.concurrent.TimeUnit;

/* renamed from: okhttp3.e */
/* loaded from: classes9.dex */
public final class C11917e {

    /* renamed from: n */
    public static final C11917e f55246n = new a().m71559c().m71557a();

    /* renamed from: o */
    public static final C11917e f55247o = new a().m71560d().m71558b(Integer.MAX_VALUE, TimeUnit.SECONDS).m71557a();

    /* renamed from: a */
    public final boolean f55248a;

    /* renamed from: b */
    public final boolean f55249b;

    /* renamed from: c */
    public final int f55250c;

    /* renamed from: d */
    public final int f55251d;

    /* renamed from: e */
    public final boolean f55252e;

    /* renamed from: f */
    public final boolean f55253f;

    /* renamed from: g */
    public final boolean f55254g;

    /* renamed from: h */
    public final int f55255h;

    /* renamed from: i */
    public final int f55256i;

    /* renamed from: j */
    public final boolean f55257j;

    /* renamed from: k */
    public final boolean f55258k;

    /* renamed from: l */
    public final boolean f55259l;

    /* renamed from: m */
    public String f55260m;

    /* renamed from: okhttp3.e$a */
    public static final class a {

        /* renamed from: a */
        public boolean f55261a;

        /* renamed from: b */
        public boolean f55262b;

        /* renamed from: c */
        public int f55263c = -1;

        /* renamed from: d */
        public int f55264d = -1;

        /* renamed from: e */
        public int f55265e = -1;

        /* renamed from: f */
        public boolean f55266f;

        /* renamed from: g */
        public boolean f55267g;

        /* renamed from: h */
        public boolean f55268h;

        /* renamed from: a */
        public C11917e m71557a() {
            return new C11917e(this);
        }

        /* renamed from: b */
        public a m71558b(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f55264d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }

        /* renamed from: c */
        public a m71559c() {
            this.f55261a = true;
            return this;
        }

        /* renamed from: d */
        public a m71560d() {
            this.f55266f = true;
            return this;
        }
    }

    public C11917e(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f55248a = z10;
        this.f55249b = z11;
        this.f55250c = i10;
        this.f55251d = i11;
        this.f55252e = z12;
        this.f55253f = z13;
        this.f55254g = z14;
        this.f55255h = i12;
        this.f55256i = i13;
        this.f55257j = z15;
        this.f55258k = z16;
        this.f55259l = z17;
        this.f55260m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0042  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okhttp3.C11917e m71546k(okhttp3.C11955v r22) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C11917e.m71546k(okhttp3.v):okhttp3.e");
    }

    /* renamed from: a */
    public final String m71547a() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f55248a) {
            sb2.append("no-cache, ");
        }
        if (this.f55249b) {
            sb2.append("no-store, ");
        }
        if (this.f55250c != -1) {
            sb2.append("max-age=");
            sb2.append(this.f55250c);
            sb2.append(", ");
        }
        if (this.f55251d != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f55251d);
            sb2.append(", ");
        }
        if (this.f55252e) {
            sb2.append("private, ");
        }
        if (this.f55253f) {
            sb2.append("public, ");
        }
        if (this.f55254g) {
            sb2.append("must-revalidate, ");
        }
        if (this.f55255h != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f55255h);
            sb2.append(", ");
        }
        if (this.f55256i != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f55256i);
            sb2.append(", ");
        }
        if (this.f55257j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f55258k) {
            sb2.append("no-transform, ");
        }
        if (this.f55259l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* renamed from: b */
    public boolean m71548b() {
        return this.f55252e;
    }

    /* renamed from: c */
    public boolean m71549c() {
        return this.f55253f;
    }

    /* renamed from: d */
    public int m71550d() {
        return this.f55250c;
    }

    /* renamed from: e */
    public int m71551e() {
        return this.f55255h;
    }

    /* renamed from: f */
    public int m71552f() {
        return this.f55256i;
    }

    /* renamed from: g */
    public boolean m71553g() {
        return this.f55254g;
    }

    /* renamed from: h */
    public boolean m71554h() {
        return this.f55248a;
    }

    /* renamed from: i */
    public boolean m71555i() {
        return this.f55249b;
    }

    /* renamed from: j */
    public boolean m71556j() {
        return this.f55257j;
    }

    public String toString() {
        String str = this.f55260m;
        if (str != null) {
            return str;
        }
        String strM71547a = m71547a();
        this.f55260m = strM71547a;
        return strM71547a;
    }

    public C11917e(a aVar) {
        this.f55248a = aVar.f55261a;
        this.f55249b = aVar.f55262b;
        this.f55250c = aVar.f55263c;
        this.f55251d = -1;
        this.f55252e = false;
        this.f55253f = false;
        this.f55254g = false;
        this.f55255h = aVar.f55264d;
        this.f55256i = aVar.f55265e;
        this.f55257j = aVar.f55266f;
        this.f55258k = aVar.f55267g;
        this.f55259l = aVar.f55268h;
    }
}
