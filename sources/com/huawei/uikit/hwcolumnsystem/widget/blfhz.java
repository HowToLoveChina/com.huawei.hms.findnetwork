package com.huawei.uikit.hwcolumnsystem.widget;

import android.content.Context;
import android.util.Pair;

/* loaded from: classes7.dex */
class blfhz extends bqmxo {

    /* renamed from: a0 */
    private static final int f41964a0 = 520;

    /* renamed from: b0 */
    private static final int f41965b0 = 840;

    /* renamed from: c0 */
    private static final int f41966c0 = 4;

    /* renamed from: d0 */
    private static final int f41967d0 = 8;

    /* renamed from: e0 */
    private static final int f41968e0 = 12;

    /* renamed from: f0 */
    private static final int f41969f0 = 1;

    /* renamed from: g0 */
    private static final int f41970g0 = 2;

    /* renamed from: n */
    private static final int f41971n = 32;

    /* renamed from: o */
    private static final int f41972o = 16;

    /* renamed from: l */
    private int f41984l;

    /* renamed from: m */
    private int f41985m;

    /* renamed from: p */
    private static final int[] f41973p = {4, 8, 12};

    /* renamed from: q */
    private static final int[] f41974q = {4, 6, 8};

    /* renamed from: r */
    private static final int[] f41975r = {4, 6, 8};

    /* renamed from: s */
    private static final int[] f41976s = {2, 3, 4};

    /* renamed from: t */
    private static final int[] f41977t = {4, 6, 8};

    /* renamed from: u */
    private static final int[] f41978u = {2, 3, 4};

    /* renamed from: v */
    private static final int[] f41979v = {4, 6, 8};

    /* renamed from: w */
    private static final int[] f41980w = {4, 6, 8};

    /* renamed from: x */
    private static final int[] f41981x = {4, 6, 8};

    /* renamed from: y */
    private static final int[] f41982y = {4, 6, 6};

    /* renamed from: z */
    private static final int[] f41983z = {4, 6, 6};

    /* renamed from: A */
    private static final int[] f41938A = {4, 6, 8};

    /* renamed from: B */
    private static final int[] f41939B = {4, 6, 8};

    /* renamed from: C */
    private static final int[] f41940C = {4, 6, 8};

    /* renamed from: D */
    private static final int[] f41941D = {4, 6, 8};

    /* renamed from: E */
    private static final int[] f41942E = {2, 2, 2};

    /* renamed from: F */
    private static final int[] f41943F = {4, 6, 6};

    /* renamed from: G */
    private static final int[] f41944G = {2, 2, 2};

    /* renamed from: H */
    private static final int[] f41945H = {4, 6, 6};

    /* renamed from: I */
    private static final int[] f41946I = {4, 6, 10};

    /* renamed from: J */
    private static final int[] f41947J = {4, 6, 10};

    /* renamed from: K */
    private static final int[] f41948K = {-2, 8, 12};

    /* renamed from: L */
    private static final int[] f41949L = {-2, 8, 12};

    /* renamed from: M */
    private static final int[] f41950M = {4, 6, 6};

    /* renamed from: N */
    private static final int[] f41951N = {4, 6, 6};

    /* renamed from: O */
    private static final int[] f41952O = {-2, 8, 8};

    /* renamed from: P */
    private static final int[] f41953P = {-2, 8, 8};

    /* renamed from: Q */
    private static final int[] f41954Q = {4, 6, 10};

    /* renamed from: R */
    private static final int[] f41955R = {4, 6, 10};

    /* renamed from: S */
    private static final int[] f41956S = {4, 6, 8};

    /* renamed from: T */
    private static final int[] f41957T = {4, 6, 8};

    /* renamed from: U */
    private static final int[] f41958U = {4, 6, 6};

    /* renamed from: V */
    private static final int[] f41959V = {4, 6, 6};

    /* renamed from: W */
    private static final int[] f41960W = {-2, 6, 6};

    /* renamed from: X */
    private static final int[] f41961X = {-2, 6, 6};

    /* renamed from: Y */
    private static final int[][] f41962Y = {new int[]{4, 6, 8}, new int[]{2, 3, 4}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 6}, new int[]{2, 2, 2}, new int[]{4, 6, 6}, new int[]{-2, 8, 8}, new int[]{4, 6, 10}, new int[]{-2, 8, 12}, new int[]{2, 2, 2}, new int[]{4, 6, 8}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{2, 3, 4}, new int[]{4, 6, 8}, new int[]{-2, 6, 6}, new int[]{4, 6, 10}, new int[]{4, 6, 6}};

    /* renamed from: Z */
    private static final int[][] f41963Z = {new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 6}, new int[]{4, 6, 6}, new int[]{4, 6, 6}, new int[]{-2, 8, 8}, new int[]{4, 6, 10}, new int[]{-2, 8, 12}, new int[]{4, 6, 6}, new int[]{4, 6, 8}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{-2, 6, 6}, new int[]{4, 6, 10}, new int[]{4, 6, 6}};

    public blfhz(Context context) {
        super(context);
        this.f41984l = 32;
        this.f41985m = 16;
        this.f41992a = f41964a0;
        this.f41993b = f41965b0;
    }

    /* renamed from: q */
    private int m54185q() {
        return m54188a(this.f41985m);
    }

    /* renamed from: r */
    private int m54186r() {
        return m54188a(this.f41984l);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: a */
    public Pair<Integer, String> mo54151a(int i10, String[] strArr, float f10) {
        String str;
        int i11;
        if (i10 >= m54189a(f41965b0, f10)) {
            str = strArr[2];
            i11 = 12;
        } else if (i10 >= m54189a(f41964a0, f10)) {
            str = strArr[1];
            i11 = 8;
        } else {
            str = strArr[0];
            i11 = 4;
        }
        return new Pair<>(Integer.valueOf(i11), str);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: b */
    public int mo54155b(int i10, int i11, int i12) {
        return 0;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: c */
    public bzrwd mo54158c() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41976s;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41977t[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: d */
    public bzrwd mo54160d() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41978u;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41979v[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: e */
    public bzrwd mo54162e() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41980w;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41981x[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: f */
    public bzrwd mo54163f() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41940C;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41941D[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: g */
    public bzrwd mo54164g() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41974q;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41975r[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: h */
    public bzrwd mo54165h() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41938A;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41939B[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: i */
    public bzrwd mo54166i() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41948K;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41949L[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: j */
    public bzrwd mo54167j() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41952O;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41953P[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: k */
    public bzrwd mo54168k() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41944G;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41945H[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: l */
    public bzrwd mo54169l() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41946I;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41947J[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: m */
    public bzrwd mo54170m() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41950M;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41951N[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: n */
    public bzrwd mo54171n() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41942E;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41943F[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: o */
    public int mo54172o() {
        return f41973p[this.f41994c];
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: b */
    public bzrwd mo54156b() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41982y;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41983z[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: c */
    public bzrwd mo54159c(int i10, int i11, int i12) {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41954Q;
        int i13 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i13], f41955R[i13]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: d */
    public bzrwd mo54161d(int i10, int i11, int i12) {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41958U;
        int i13 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i13], f41959V[i13]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: a */
    public Pair<Integer, Integer> mo54150a(float f10) {
        int i10;
        int i11;
        if (f10 > 840.0f || m54191a(f10, 840.0f)) {
            i10 = 12;
            i11 = 2;
        } else if (f10 > 520.0f || m54191a(f10, 520.0f)) {
            i10 = 8;
            i11 = 1;
        } else {
            i10 = 4;
            i11 = 0;
        }
        return new Pair<>(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: b */
    public boolean mo54157b(int i10) {
        return i10 >= 0 && i10 < f41962Y.length && i10 < f41963Z.length;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: a */
    public bzrwd mo54153a(int i10, int i11, int i12) {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41956S;
        int i13 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i13], f41957T[i13]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: a */
    public bzrwd mo54152a() {
        int iM54186r = m54186r();
        int iM54185q = m54185q();
        int[] iArr = f41960W;
        int i10 = this.f41994c;
        return new bzrwd(iM54186r, iM54185q, iArr[i10], f41961X[i10]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    /* renamed from: a */
    public bzrwd mo54154a(int i10, Pair<Integer, Integer> pair, int i11, int i12, float f10) {
        return new bzrwd(m54186r(), m54185q(), f41962Y[i11][i12], f41963Z[i11][i12]);
    }
}
