package com.huawei.hms.drive;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.drive.ai */
/* loaded from: classes8.dex */
public final class C5176ai {

    /* renamed from: a */
    public static final C5176ai f23584a = new a().m30832a().m30835c();

    /* renamed from: b */
    public static final C5176ai f23585b = new a().m30834b().m30833a(Integer.MAX_VALUE, TimeUnit.SECONDS).m30835c();

    /* renamed from: c */
    String f23586c;

    /* renamed from: d */
    private final boolean f23587d;

    /* renamed from: e */
    private final boolean f23588e;

    /* renamed from: f */
    private final int f23589f;

    /* renamed from: g */
    private final int f23590g;

    /* renamed from: h */
    private final boolean f23591h;

    /* renamed from: i */
    private final boolean f23592i;

    /* renamed from: j */
    private final boolean f23593j;

    /* renamed from: k */
    private final int f23594k;

    /* renamed from: l */
    private final int f23595l;

    /* renamed from: m */
    private final boolean f23596m;

    /* renamed from: n */
    private final boolean f23597n;

    /* renamed from: o */
    private final boolean f23598o;

    /* renamed from: com.huawei.hms.drive.ai$a */
    public static final class a {

        /* renamed from: a */
        boolean f23599a;

        /* renamed from: b */
        boolean f23600b;

        /* renamed from: c */
        int f23601c = -1;

        /* renamed from: d */
        int f23602d = -1;

        /* renamed from: e */
        int f23603e = -1;

        /* renamed from: f */
        boolean f23604f;

        /* renamed from: g */
        boolean f23605g;

        /* renamed from: h */
        boolean f23606h;

        /* renamed from: a */
        public a m30832a() {
            this.f23599a = true;
            return this;
        }

        /* renamed from: b */
        public a m30834b() {
            this.f23604f = true;
            return this;
        }

        /* renamed from: c */
        public C5176ai m30835c() {
            return new C5176ai(this);
        }

        /* renamed from: a */
        public a m30833a(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f23602d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }
    }

    private C5176ai(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f23587d = z10;
        this.f23588e = z11;
        this.f23589f = i10;
        this.f23590g = i11;
        this.f23591h = z12;
        this.f23592i = z13;
        this.f23593j = z14;
        this.f23594k = i12;
        this.f23595l = i13;
        this.f23596m = z15;
        this.f23597n = z16;
        this.f23598o = z17;
        this.f23586c = str;
    }

    /* renamed from: j */
    private String m30822j() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f23587d) {
            sb2.append("no-cache, ");
        }
        if (this.f23588e) {
            sb2.append("no-store, ");
        }
        if (this.f23589f != -1) {
            sb2.append("max-age=");
            sb2.append(this.f23589f);
            sb2.append(", ");
        }
        if (this.f23590g != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f23590g);
            sb2.append(", ");
        }
        if (this.f23591h) {
            sb2.append("private, ");
        }
        if (this.f23592i) {
            sb2.append("public, ");
        }
        if (this.f23593j) {
            sb2.append("must-revalidate, ");
        }
        if (this.f23594k != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f23594k);
            sb2.append(", ");
        }
        if (this.f23595l != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f23595l);
            sb2.append(", ");
        }
        if (this.f23596m) {
            sb2.append("only-if-cached, ");
        }
        if (this.f23597n) {
            sb2.append("no-transform, ");
        }
        if (this.f23598o) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* renamed from: a */
    public boolean m30823a() {
        return this.f23587d;
    }

    /* renamed from: b */
    public boolean m30824b() {
        return this.f23588e;
    }

    /* renamed from: c */
    public int m30825c() {
        return this.f23589f;
    }

    /* renamed from: d */
    public boolean m30826d() {
        return this.f23591h;
    }

    /* renamed from: e */
    public boolean m30827e() {
        return this.f23592i;
    }

    /* renamed from: f */
    public boolean m30828f() {
        return this.f23593j;
    }

    /* renamed from: g */
    public int m30829g() {
        return this.f23594k;
    }

    /* renamed from: h */
    public int m30830h() {
        return this.f23595l;
    }

    /* renamed from: i */
    public boolean m30831i() {
        return this.f23596m;
    }

    public String toString() {
        String str = this.f23586c;
        if (str != null) {
            return str;
        }
        String strM30822j = m30822j();
        this.f23586c = strM30822j;
        return strM30822j;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0042  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.drive.C5176ai m30821a(com.huawei.hms.drive.C5190aw r22) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5176ai.m30821a(com.huawei.hms.drive.aw):com.huawei.hms.drive.ai");
    }

    public C5176ai(a aVar) {
        this.f23587d = aVar.f23599a;
        this.f23588e = aVar.f23600b;
        this.f23589f = aVar.f23601c;
        this.f23590g = -1;
        this.f23591h = false;
        this.f23592i = false;
        this.f23593j = false;
        this.f23594k = aVar.f23602d;
        this.f23595l = aVar.f23603e;
        this.f23596m = aVar.f23604f;
        this.f23597n = aVar.f23605g;
        this.f23598o = aVar.f23606h;
    }
}
