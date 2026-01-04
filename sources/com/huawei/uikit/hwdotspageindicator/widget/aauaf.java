package com.huawei.uikit.hwdotspageindicator.widget;

import android.graphics.RectF;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
class aauaf {

    /* renamed from: A */
    private static final int f42559A = 1;

    /* renamed from: B */
    private static final int f42560B = 2;

    /* renamed from: C */
    private static final int f42561C = 1;

    /* renamed from: D */
    private static final int f42562D = 2;

    /* renamed from: E */
    private static final int f42563E = 0;

    /* renamed from: F */
    private static final int f42564F = 3;

    /* renamed from: G */
    private static final int f42565G = 3;

    /* renamed from: H */
    private static final float f42566H = 2.0f;

    /* renamed from: I */
    private static final float f42567I = 8.0f;

    /* renamed from: J */
    private static final float f42568J = 0.0f;

    /* renamed from: y */
    private static final int f42569y = -1;

    /* renamed from: z */
    private static final int f42570z = 0;

    /* renamed from: a */
    private int f42571a;

    /* renamed from: b */
    private boolean f42572b;

    /* renamed from: c */
    private int f42573c;

    /* renamed from: d */
    private int f42574d;

    /* renamed from: e */
    private int f42575e;

    /* renamed from: f */
    private int f42576f;

    /* renamed from: g */
    private float[] f42577g;

    /* renamed from: h */
    private float f42578h;

    /* renamed from: i */
    private float f42579i;

    /* renamed from: j */
    private float f42580j;

    /* renamed from: k */
    private float f42581k;

    /* renamed from: l */
    private float f42582l;

    /* renamed from: m */
    private float f42583m;

    /* renamed from: n */
    private int f42584n;

    /* renamed from: o */
    private int f42585o;

    /* renamed from: p */
    private boolean f42586p;

    /* renamed from: t */
    private float[][] f42590t;

    /* renamed from: u */
    private float[][] f42591u;

    /* renamed from: v */
    private float[][] f42592v;

    /* renamed from: w */
    private float[][] f42593w;

    /* renamed from: x */
    private ConcurrentHashMap<Integer, Float> f42594x;

    /* renamed from: s */
    private int f42589s = -1;

    /* renamed from: q */
    private RectF f42587q = new RectF();

    /* renamed from: r */
    private RectF f42588r = new RectF();

    /* renamed from: A */
    public int m54503A() {
        return this.f42585o;
    }

    /* renamed from: B */
    public int m54504B() {
        return this.f42589s;
    }

    /* renamed from: C */
    public ConcurrentHashMap<Integer, Float> m54505C() {
        return this.f42594x;
    }

    /* renamed from: D */
    public boolean m54506D() {
        return this.f42586p;
    }

    /* renamed from: E */
    public boolean m54507E() {
        return this.f42572b;
    }

    /* renamed from: F */
    public boolean m54508F() {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.f42594x;
        return concurrentHashMap == null || concurrentHashMap.size() == 0;
    }

    /* renamed from: a */
    public void m54516a(float[] fArr) {
        this.f42577g = fArr;
    }

    /* renamed from: b */
    public void m54528b(RectF rectF) {
        if (rectF == null) {
            return;
        }
        if (this.f42587q == null) {
            this.f42587q = new RectF();
        }
        RectF rectF2 = this.f42587q;
        rectF2.left = rectF.left;
        rectF2.top = rectF.top;
        rectF2.right = rectF.right;
        rectF2.bottom = rectF.bottom;
    }

    /* renamed from: c */
    public aauaf m54533c() {
        aauaf aauafVar = new aauaf();
        aauafVar.m54576r(m54586x());
        aauafVar.m54575q(m54585w());
        aauafVar.m54516a(m54544e());
        aauafVar.m54534c(m54537d());
        aauafVar.m54540d(m54549g());
        aauafVar.m54564l(m54588z());
        aauafVar.m54583u(m54504B());
        aauafVar.m54535c(m54507E());
        aauafVar.m54579s(m54587y());
        aauafVar.m54556i(m54572p());
        aauafVar.m54543e(m54552h());
        aauafVar.m54581t(m54503A());
        aauafVar.m54569n(m54578s());
        aauafVar.m54517a(m54548f());
        aauafVar.m54530b(m54557i());
        aauafVar.m54541d(m54577r());
        aauafVar.m54536c(m54560j());
        aauafVar.m54558j(m54574q());
        if (m54580t() != null && aauafVar.m54580t() != null) {
            RectF rectFM54580t = aauafVar.m54580t();
            RectF rectFM54580t2 = m54580t();
            rectFM54580t.left = rectFM54580t2.left;
            rectFM54580t.top = rectFM54580t2.top;
            rectFM54580t.right = rectFM54580t2.right;
            rectFM54580t.bottom = rectFM54580t2.bottom;
        }
        if (m54566m() != null && aauafVar.m54566m() != null) {
            RectF rectFM54566m = aauafVar.m54566m();
            RectF rectFM54566m2 = m54566m();
            rectFM54566m.left = rectFM54566m2.left;
            rectFM54566m.top = rectFM54566m2.top;
            rectFM54566m.right = rectFM54566m2.right;
            rectFM54566m.bottom = rectFM54566m2.bottom;
        }
        return aauafVar;
    }

    /* renamed from: d */
    public float m54537d() {
        return this.f42578h;
    }

    /* renamed from: e */
    public float[] m54544e() {
        return this.f42577g;
    }

    /* renamed from: f */
    public void m54547f(float f10) {
        m54500a();
        if (this.f42572b) {
            this.f42588r.left = f10;
        } else {
            this.f42588r.right = f10;
        }
    }

    /* renamed from: g */
    public float m54549g() {
        return this.f42579i;
    }

    /* renamed from: h */
    public float m54552h() {
        return this.f42580j;
    }

    /* renamed from: i */
    public void m54556i(float f10) {
        this.f42582l = f10;
    }

    /* renamed from: j */
    public void m54558j(float f10) {
        this.f42583m = f10;
    }

    /* renamed from: k */
    public void m54562k(float f10) {
        m54500a();
        this.f42588r.bottom = f10;
    }

    /* renamed from: l */
    public void m54564l(float f10) {
        this.f42581k = f10;
    }

    /* renamed from: m */
    public RectF m54566m() {
        return this.f42588r;
    }

    /* renamed from: n */
    public void m54569n(int i10) {
        this.f42584n = i10;
    }

    /* renamed from: o */
    public void m54571o(int i10) {
        this.f42576f = i10;
    }

    /* renamed from: p */
    public void m54573p(int i10) {
        this.f42575e = i10;
    }

    /* renamed from: q */
    public void m54575q(int i10) {
        this.f42574d = i10;
    }

    /* renamed from: r */
    public void m54576r(int i10) {
        this.f42571a = i10;
    }

    /* renamed from: s */
    public void m54579s(int i10) {
        if (i10 > 0) {
            this.f42573c = i10;
        }
    }

    /* renamed from: t */
    public RectF m54580t() {
        return this.f42587q;
    }

    /* renamed from: u */
    public int m54582u() {
        return this.f42576f;
    }

    /* renamed from: v */
    public int m54584v() {
        return this.f42575e;
    }

    /* renamed from: w */
    public int m54585w() {
        return this.f42574d;
    }

    /* renamed from: x */
    public int m54586x() {
        return this.f42571a;
    }

    /* renamed from: y */
    public int m54587y() {
        return this.f42573c;
    }

    /* renamed from: z */
    public float m54588z() {
        return this.f42581k;
    }

    /* renamed from: a */
    public void m54515a(RectF rectF) {
        this.f42588r = rectF;
    }

    /* renamed from: d */
    public void m54540d(float f10) {
        this.f42579i = f10;
    }

    /* renamed from: e */
    public void m54543e(float f10) {
        this.f42580j = f10;
    }

    /* renamed from: g */
    public void m54551g(float f10) {
        m54500a();
        if (this.f42572b) {
            this.f42588r.right = f10;
        } else {
            this.f42588r.left = f10;
        }
    }

    /* renamed from: h */
    public void m54554h(float f10) {
        m54500a();
        this.f42588r.top = f10;
    }

    /* renamed from: i */
    public float[][] m54557i() {
        return this.f42591u;
    }

    /* renamed from: j */
    public float[][] m54560j() {
        return this.f42592v;
    }

    /* renamed from: l */
    public float m54563l() {
        RectF rectF = this.f42588r;
        if (rectF != null) {
            return this.f42572b ? rectF.left : rectF.right;
        }
        return 0.0f;
    }

    /* renamed from: m */
    public void m54567m(int i10) {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.f42594x;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
        }
    }

    /* renamed from: n */
    public float m54568n() {
        RectF rectF = this.f42588r;
        if (rectF != null) {
            return this.f42572b ? rectF.right : rectF.left;
        }
        return 0.0f;
    }

    /* renamed from: o */
    public float m54570o() {
        RectF rectF = this.f42588r;
        if (rectF != null) {
            return rectF.top;
        }
        return 0.0f;
    }

    /* renamed from: p */
    public float m54572p() {
        return this.f42582l;
    }

    /* renamed from: q */
    public float m54574q() {
        return this.f42583m;
    }

    /* renamed from: r */
    public float[][] m54577r() {
        return this.f42593w;
    }

    /* renamed from: s */
    public int m54578s() {
        return this.f42584n;
    }

    /* renamed from: t */
    public void m54581t(int i10) {
        this.f42585o = i10;
    }

    /* renamed from: u */
    public void m54583u(int i10) {
        this.f42589s = i10;
    }

    /* renamed from: a */
    public void m54513a(float f10, float f11, float f12, float f13) {
        m54551g(f10);
        m54554h(f11);
        m54547f(f12);
        m54562k(f13);
    }

    /* renamed from: d */
    public void m54541d(float[][] fArr) {
        this.f42593w = fArr;
    }

    /* renamed from: e */
    public float[] m54545e(boolean z10, int i10) {
        float fM54522b;
        float[] fArr = new float[this.f42573c];
        for (int i11 = 0; i11 < this.f42573c; i11++) {
            if (z10) {
                fM54522b = m54510a(i11, i10);
            } else {
                fM54522b = m54522b(i11, i10);
            }
            fArr[i11] = fM54522b;
        }
        return fArr;
    }

    /* renamed from: i */
    public float m54555i(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42592v, iM54502k)) {
            return 0.0f;
        }
        return this.f42592v[iM54502k][this.f42572b ? 1 : 0];
    }

    /* renamed from: j */
    public float[] m54559j(int i10) {
        float[] fArr = new float[this.f42573c];
        for (int i11 = 0; i11 < this.f42573c; i11++) {
            fArr[i11] = m54510a(i11, i10);
        }
        return fArr;
    }

    /* renamed from: k */
    public float m54561k() {
        RectF rectF = this.f42588r;
        if (rectF != null) {
            return rectF.bottom;
        }
        return 0.0f;
    }

    /* renamed from: d */
    public float m54538d(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42593w, iM54502k)) {
            return 0.0f;
        }
        return this.f42593w[iM54502k][2];
    }

    /* renamed from: h */
    public float m54553h(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42592v, iM54502k)) {
            return 0.0f;
        }
        return this.f42592v[iM54502k][!this.f42572b ? 1 : 0];
    }

    /* renamed from: l */
    public float[] m54565l(int i10) {
        float[] fArr = new float[this.f42573c];
        for (int i11 = 0; i11 < this.f42573c; i11++) {
            fArr[i11] = m54522b(i11, i10);
        }
        return fArr;
    }

    /* renamed from: k */
    private int m54502k(int i10) {
        return this.f42572b ? (this.f42573c - 1) - i10 : i10;
    }

    /* renamed from: f */
    public float[][] m54548f() {
        return this.f42590t;
    }

    /* renamed from: f */
    public float m54546f(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42592v, iM54502k)) {
            return 0.0f;
        }
        return this.f42592v[iM54502k][2];
    }

    /* renamed from: g */
    public float m54550g(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42593w, iM54502k)) {
            return 0.0f;
        }
        return this.f42593w[iM54502k][this.f42572b ? 1 : 0];
    }

    /* renamed from: a */
    public void m54517a(float[][] fArr) {
        this.f42590t = fArr;
    }

    /* renamed from: b */
    public void m54526b(float f10, float f11, float f12, float f13) {
        if (this.f42587q == null) {
            this.f42587q = new RectF();
        }
        RectF rectF = this.f42587q;
        rectF.left = f10;
        rectF.top = f11;
        rectF.right = f12;
        rectF.bottom = f13;
    }

    /* renamed from: d */
    public float m54539d(boolean z10, int i10) {
        return z10 ? m54550g(i10) : m54555i(i10);
    }

    /* renamed from: e */
    public float m54542e(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42593w, iM54502k)) {
            return 0.0f;
        }
        return this.f42593w[iM54502k][!this.f42572b ? 1 : 0];
    }

    /* renamed from: a */
    public boolean m54519a(boolean z10, int i10, float[] fArr) {
        if (this.f42590t == null || this.f42591u == null || fArr == null || fArr.length != this.f42573c) {
            return true;
        }
        for (int i11 = 0; i11 < this.f42573c; i11++) {
            if (i10 != i11) {
                if (Math.abs((z10 ? m54510a(i11, i10) : m54522b(i11, i10)) - fArr[i11]) > 1.0f) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m54518a(boolean z10, int i10, float f10, float f11) {
        float fM54539d = m54539d(z10, i10);
        float fM54532c = m54532c(z10, i10);
        float fAbs = Math.abs(fM54539d - f10);
        float fAbs2 = Math.abs(fM54532c - f11);
        float fAbs3 = Math.abs(fM54532c - fM54539d) / 8.0f;
        return (Float.compare(fAbs, fAbs3) < 0) && (Float.compare(fAbs2, fAbs3) < 0);
    }

    /* renamed from: b */
    public void m54527b(int i10, float f10) {
        float[] fArr = this.f42577g;
        if (fArr == null || i10 < 0 || i10 >= fArr.length) {
            return;
        }
        fArr[i10] = f10;
    }

    /* renamed from: b */
    public void m54529b(boolean z10) {
        this.f42586p = z10;
    }

    /* renamed from: b */
    public void m54530b(float[][] fArr) {
        this.f42591u = fArr;
    }

    /* renamed from: b */
    public void m54524b() {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.f42594x;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* renamed from: b */
    public void m54525b(float f10) {
        int i10 = this.f42573c;
        Class cls = Float.TYPE;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) cls, i10, 3);
        this.f42591u = fArr;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) cls, i10, 3);
        this.f42592v = fArr2;
        float[] fArr3 = fArr2[0];
        fArr3[0] = f10;
        float f11 = this.f42583m;
        fArr3[1] = f10 + f11;
        float f12 = (f11 / 2.0f) + f10;
        fArr3[2] = f12;
        float[] fArr4 = fArr[0];
        fArr4[1] = (this.f42580j / 2.0f) + f10;
        fArr4[0] = f12;
        fArr4[2] = f12;
        int i11 = 1;
        while (true) {
            int i12 = this.f42573c;
            if (i11 >= i12) {
                return;
            }
            float[][] fArr5 = this.f42592v;
            float[] fArr6 = fArr5[i11];
            int i13 = i11 - 1;
            float[] fArr7 = fArr5[i13];
            float f13 = fArr7[0];
            float f14 = this.f42585o;
            float f15 = this.f42580j;
            fArr6[0] = f13 + f14 + f15;
            fArr6[1] = fArr7[1] + f14 + f15;
            fArr6[2] = fArr7[2] + f14 + f15;
            float[][] fArr8 = this.f42591u;
            float[] fArr9 = fArr8[i11];
            fArr9[1] = fArr8[i13][1] + f14 + f15;
            float f16 = (r10 * i11) + f10;
            float f17 = this.f42583m;
            float f18 = (i11 * f15) + f16 + (f17 / 2.0f);
            fArr9[0] = f18;
            fArr9[2] = f16 + f17 + (f15 / 2.0f) + (i13 * f15);
            if (i11 == i12 - 1) {
                fArr9[1] = f18;
            }
            i11++;
        }
    }

    /* renamed from: a */
    public void m54514a(int i10, float f10) {
        if (this.f42594x == null) {
            this.f42594x = new ConcurrentHashMap<>();
        }
        this.f42594x.put(Integer.valueOf(i10), Float.valueOf(f10));
    }

    /* renamed from: a */
    public void m54512a(float f10) {
        int i10 = this.f42573c;
        Class cls = Float.TYPE;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) cls, i10, 3);
        this.f42590t = fArr;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) cls, i10, 3);
        this.f42593w = fArr2;
        float[] fArr3 = fArr2[0];
        fArr3[0] = f10;
        float f11 = this.f42582l;
        float f12 = f10 + f11;
        fArr3[1] = f12;
        fArr3[2] = (f12 + f10) / 2.0f;
        float[] fArr4 = fArr[0];
        float f13 = this.f42579i;
        fArr4[1] = f10 + f13;
        float f14 = (f11 / 2.0f) + f10;
        fArr4[0] = f14;
        fArr4[2] = f14;
        float f15 = f13 * 2.0f;
        int i11 = 1;
        while (true) {
            int i12 = this.f42573c;
            if (i11 >= i12) {
                return;
            }
            float[][] fArr5 = this.f42593w;
            float[] fArr6 = fArr5[i11];
            int i13 = i11 - 1;
            float[] fArr7 = fArr5[i13];
            float f16 = fArr7[0];
            float f17 = this.f42584n;
            fArr6[0] = f16 + f17 + f15;
            fArr6[1] = fArr7[1] + f17 + f15;
            fArr6[2] = fArr7[2] + f17 + f15;
            float[][] fArr8 = this.f42590t;
            float[] fArr9 = fArr8[i11];
            fArr9[1] = fArr8[i13][1] + f17 + f15;
            float f18 = (r11 * i11) + f10;
            float f19 = this.f42582l;
            float f20 = (i11 * f15) + f18 + (f19 / 2.0f);
            fArr9[0] = f20;
            fArr9[2] = f18 + f19 + this.f42579i + (i13 * f15);
            if (i11 == i12 - 1) {
                fArr9[1] = f20;
            }
            i11++;
        }
    }

    /* renamed from: c */
    public void m54535c(boolean z10) {
        this.f42572b = z10;
    }

    /* renamed from: b */
    public float m54522b(int i10, int i11) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42591u, iM54502k)) {
            return 0.0f;
        }
        if (i10 > i11) {
            return this.f42591u[iM54502k][this.f42572b ? (char) 1 : (char) 2];
        }
        if (i10 < i11) {
            return this.f42591u[iM54502k][this.f42572b ? (char) 2 : (char) 1];
        }
        return this.f42591u[iM54502k][0];
    }

    /* renamed from: c */
    public void m54534c(float f10) {
        this.f42578h = f10;
    }

    /* renamed from: c */
    public void m54536c(float[][] fArr) {
        this.f42592v = fArr;
    }

    /* renamed from: c */
    public float m54531c(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42591u, iM54502k)) {
            return 0.0f;
        }
        return this.f42591u[iM54502k][this.f42572b ? (char) 2 : (char) 1];
    }

    /* renamed from: a */
    public float[] m54520a(boolean z10, int i10) {
        return z10 ? m54559j(i10) : m54565l(i10);
    }

    /* renamed from: a */
    public float m54510a(int i10, int i11) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42590t, iM54502k)) {
            return 0.0f;
        }
        if (i10 > i11) {
            return this.f42590t[iM54502k][this.f42572b ? (char) 1 : (char) 2];
        }
        if (i10 < i11) {
            return this.f42590t[iM54502k][this.f42572b ? (char) 2 : (char) 1];
        }
        return this.f42590t[iM54502k][0];
    }

    /* renamed from: b */
    public float m54521b(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42591u, iM54502k)) {
            return 0.0f;
        }
        return this.f42591u[iM54502k][this.f42572b ? (char) 1 : (char) 2];
    }

    /* renamed from: c */
    public float m54532c(boolean z10, int i10) {
        return z10 ? m54542e(i10) : m54553h(i10);
    }

    /* renamed from: b */
    public float m54523b(boolean z10, int i10) {
        return z10 ? m54538d(i10) : m54546f(i10);
    }

    /* renamed from: a */
    public float m54509a(int i10) {
        int iM54502k = m54502k(i10);
        if (m54501a(this.f42591u, iM54502k)) {
            return 0.0f;
        }
        return this.f42591u[iM54502k][0];
    }

    /* renamed from: a */
    public float m54511a(boolean z10) {
        if (z10) {
            return (this.f42582l / 2.0f) - this.f42579i;
        }
        return (this.f42583m - this.f42580j) / 2.0f;
    }

    /* renamed from: a */
    private boolean m54501a(float[][] fArr, int i10) {
        return fArr == null || i10 < 0 || i10 >= fArr.length;
    }

    /* renamed from: a */
    private void m54500a() {
        if (this.f42588r == null) {
            this.f42588r = new RectF();
        }
    }
}
