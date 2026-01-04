package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.p1 */
/* loaded from: classes8.dex */
public final class C6043p1 {

    /* renamed from: m */
    public static final int f27655m = -1;

    /* renamed from: n */
    public static final boolean f27656n = false;

    /* renamed from: a */
    public final boolean f27657a;

    /* renamed from: b */
    public final boolean f27658b;

    /* renamed from: c */
    public final int f27659c;

    /* renamed from: d */
    public final int f27660d;

    /* renamed from: e */
    public final boolean f27661e;

    /* renamed from: f */
    public final boolean f27662f;

    /* renamed from: g */
    public final boolean f27663g;

    /* renamed from: h */
    public final int f27664h;

    /* renamed from: i */
    public final int f27665i;

    /* renamed from: j */
    public final boolean f27666j;

    /* renamed from: k */
    public final boolean f27667k;

    /* renamed from: l */
    public final boolean f27668l;

    public C6043p1(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17) {
        this.f27657a = z10;
        this.f27658b = z11;
        this.f27661e = z12;
        this.f27659c = i10;
        this.f27660d = i11;
        this.f27662f = z13;
        this.f27667k = z16;
        this.f27663g = z14;
        this.f27664h = i12;
        this.f27665i = i13;
        this.f27668l = z17;
        this.f27666j = z15;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.network.embedded.C6043p1 parse(com.huawei.hms.network.base.common.Headers r31) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6043p1.parse(com.huawei.hms.network.base.common.Headers):com.huawei.hms.network.embedded.p1");
    }

    public boolean immutable() {
        return this.f27668l;
    }

    public boolean isPrivate() {
        return this.f27661e;
    }

    public boolean isPublic() {
        return this.f27662f;
    }

    public int maxAgeSeconds() {
        return this.f27659c;
    }

    public int maxStaleSeconds() {
        return this.f27664h;
    }

    public int minFreshSeconds() {
        return this.f27665i;
    }

    public boolean mustRevalidate() {
        return this.f27663g;
    }

    public boolean noCache() {
        return this.f27657a;
    }

    public boolean noStore() {
        return this.f27658b;
    }

    public boolean noTransform() {
        return this.f27667k;
    }

    public boolean onlyIfCached() {
        return this.f27666j;
    }

    public int sMaxAgeSeconds() {
        return this.f27660d;
    }
}
