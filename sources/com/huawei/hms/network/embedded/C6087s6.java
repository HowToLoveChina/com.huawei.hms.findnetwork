package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.s6 */
/* loaded from: classes8.dex */
public final class C6087s6 {

    /* renamed from: n */
    public static final C6087s6 f28182n = new a().m35273c().m35270a();

    /* renamed from: o */
    public static final C6087s6 f28183o = new a().m35277f().m35272b(Integer.MAX_VALUE, TimeUnit.SECONDS).m35270a();

    /* renamed from: a */
    public final boolean f28184a;

    /* renamed from: b */
    public final boolean f28185b;

    /* renamed from: c */
    public final int f28186c;

    /* renamed from: d */
    public final int f28187d;

    /* renamed from: e */
    public final boolean f28188e;

    /* renamed from: f */
    public final boolean f28189f;

    /* renamed from: g */
    public final boolean f28190g;

    /* renamed from: h */
    public final int f28191h;

    /* renamed from: i */
    public final int f28192i;

    /* renamed from: j */
    public final boolean f28193j;

    /* renamed from: k */
    public final boolean f28194k;

    /* renamed from: l */
    public final boolean f28195l;

    /* renamed from: m */
    public String f28196m;

    /* renamed from: com.huawei.hms.network.embedded.s6$a */
    public static final class a {

        /* renamed from: a */
        public boolean f28197a;

        /* renamed from: b */
        public boolean f28198b;

        /* renamed from: c */
        public int f28199c = -1;

        /* renamed from: d */
        public int f28200d = -1;

        /* renamed from: e */
        public int f28201e = -1;

        /* renamed from: f */
        public boolean f28202f;

        /* renamed from: g */
        public boolean f28203g;

        /* renamed from: h */
        public boolean f28204h;

        /* renamed from: a */
        public a m35269a(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f28199c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i10);
        }

        /* renamed from: b */
        public a m35271b() {
            this.f28204h = true;
            return this;
        }

        /* renamed from: c */
        public a m35273c() {
            this.f28197a = true;
            return this;
        }

        /* renamed from: d */
        public a m35275d() {
            this.f28198b = true;
            return this;
        }

        /* renamed from: e */
        public a m35276e() {
            this.f28203g = true;
            return this;
        }

        /* renamed from: f */
        public a m35277f() {
            this.f28202f = true;
            return this;
        }

        /* renamed from: a */
        public C6087s6 m35270a() {
            return new C6087s6(this);
        }

        /* renamed from: b */
        public a m35272b(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f28200d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }

        /* renamed from: c */
        public a m35274c(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f28201e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i10);
        }
    }

    public C6087s6(a aVar) {
        this.f28184a = aVar.f28197a;
        this.f28185b = aVar.f28198b;
        this.f28186c = aVar.f28199c;
        this.f28187d = -1;
        this.f28188e = false;
        this.f28189f = false;
        this.f28190g = false;
        this.f28191h = aVar.f28200d;
        this.f28192i = aVar.f28201e;
        this.f28193j = aVar.f28202f;
        this.f28194k = aVar.f28203g;
        this.f28195l = aVar.f28204h;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.network.embedded.C6087s6 m35255a(com.huawei.hms.network.embedded.C5971j7 r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6087s6.m35255a(com.huawei.hms.network.embedded.j7):com.huawei.hms.network.embedded.s6");
    }

    /* renamed from: m */
    private String m35256m() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f28184a) {
            sb2.append("no-cache, ");
        }
        if (this.f28185b) {
            sb2.append("no-store, ");
        }
        if (this.f28186c != -1) {
            sb2.append("max-age=");
            sb2.append(this.f28186c);
            sb2.append(", ");
        }
        if (this.f28187d != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f28187d);
            sb2.append(", ");
        }
        if (this.f28188e) {
            sb2.append("private, ");
        }
        if (this.f28189f) {
            sb2.append("public, ");
        }
        if (this.f28190g) {
            sb2.append("must-revalidate, ");
        }
        if (this.f28191h != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f28191h);
            sb2.append(", ");
        }
        if (this.f28192i != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f28192i);
            sb2.append(", ");
        }
        if (this.f28193j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f28194k) {
            sb2.append("no-transform, ");
        }
        if (this.f28195l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* renamed from: b */
    public boolean m35258b() {
        return this.f28188e;
    }

    /* renamed from: c */
    public boolean m35259c() {
        return this.f28189f;
    }

    /* renamed from: d */
    public int m35260d() {
        return this.f28186c;
    }

    /* renamed from: e */
    public int m35261e() {
        return this.f28191h;
    }

    /* renamed from: f */
    public int m35262f() {
        return this.f28192i;
    }

    /* renamed from: g */
    public boolean m35263g() {
        return this.f28190g;
    }

    /* renamed from: h */
    public boolean m35264h() {
        return this.f28184a;
    }

    /* renamed from: i */
    public boolean m35265i() {
        return this.f28185b;
    }

    /* renamed from: j */
    public boolean m35266j() {
        return this.f28194k;
    }

    /* renamed from: k */
    public boolean m35267k() {
        return this.f28193j;
    }

    /* renamed from: l */
    public int m35268l() {
        return this.f28187d;
    }

    public String toString() {
        String str = this.f28196m;
        if (str != null) {
            return str;
        }
        String strM35256m = m35256m();
        this.f28196m = strM35256m;
        return strM35256m;
    }

    public C6087s6(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f28184a = z10;
        this.f28185b = z11;
        this.f28186c = i10;
        this.f28187d = i11;
        this.f28188e = z12;
        this.f28189f = z13;
        this.f28190g = z14;
        this.f28191h = i12;
        this.f28192i = i13;
        this.f28193j = z15;
        this.f28194k = z16;
        this.f28195l = z17;
        this.f28196m = str;
    }

    /* renamed from: a */
    public boolean m35257a() {
        return this.f28195l;
    }
}
