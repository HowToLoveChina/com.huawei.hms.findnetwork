package com.huawei.uikit.hwclickanimation.anim;

import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.huawei.dynamicanimation.AbstractC4672b;
import com.huawei.dynamicanimation.C4681k;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import p493nj.C11714a;
import p493nj.C11716c;
import p524oj.C11906a;

/* loaded from: classes7.dex */
public class HwSpringBackHelper {

    /* renamed from: A */
    private static final int f41686A = 3;

    /* renamed from: B */
    private static final long f41687B = -1;

    /* renamed from: C */
    private static final float f41688C = 1.0f;

    /* renamed from: D */
    private static final float f41689D = -1.0f;

    /* renamed from: E */
    private static final float f41690E = 0.5f;

    /* renamed from: F */
    private static final float f41691F = 1.0E-6f;

    /* renamed from: r */
    private static final String f41692r = "HwSpringBackHelper";

    /* renamed from: s */
    private static final float f41693s = 228.0f;

    /* renamed from: t */
    private static final float f41694t = 30.0f;

    /* renamed from: u */
    private static final float f41695u = 0.5f;

    /* renamed from: v */
    private static final float f41696v = 0.5f;

    /* renamed from: w */
    private static final float f41697w = 1000.0f;

    /* renamed from: x */
    private static final int f41698x = 0;

    /* renamed from: y */
    private static final int f41699y = 1;

    /* renamed from: z */
    private static final int f41700z = 2;

    /* renamed from: b */
    private int f41702b;

    /* renamed from: c */
    private int f41703c;

    /* renamed from: d */
    private int f41704d;

    /* renamed from: e */
    private long f41705e;

    /* renamed from: f */
    private long f41706f;

    /* renamed from: i */
    private C11714a f41709i;

    /* renamed from: j */
    private float f41710j;

    /* renamed from: k */
    private bzrwd f41711k;

    /* renamed from: l */
    private int f41712l;

    /* renamed from: m */
    private int f41713m;

    /* renamed from: n */
    private View f41714n;

    /* renamed from: o */
    private int f41715o;

    /* renamed from: a */
    private C11716c f41701a = null;

    /* renamed from: g */
    private boolean f41707g = true;

    /* renamed from: h */
    private int f41708h = 0;

    /* renamed from: p */
    private double f41716p = 1.0d;

    /* renamed from: q */
    private float f41717q = -1.0f;

    public class HwSoftLightAnimSpringBackHelper {

        /* renamed from: g */
        private static final long f41718g = 300;

        /* renamed from: h */
        private static final long f41719h = 200;

        /* renamed from: i */
        private static final int f41720i = 200;

        /* renamed from: j */
        private static final int f41721j = 100;

        /* renamed from: k */
        private static final int f41722k = 50;

        /* renamed from: l */
        private static final int f41723l = 0;

        /* renamed from: m */
        private static final float f41724m = 0.85f;

        /* renamed from: n */
        private static final float f41725n = 0.2f;

        /* renamed from: o */
        private static final float f41726o = 0.2f;

        /* renamed from: p */
        private static final float f41727p = 0.0f;

        /* renamed from: q */
        private static final float f41728q = 1.0f;

        /* renamed from: a */
        private HwCubicBezierInterpolator f41729a;

        /* renamed from: b */
        private int f41730b;

        /* renamed from: c */
        private int f41731c;

        /* renamed from: d */
        private int f41732d;

        /* renamed from: e */
        private int f41733e;

        public HwSoftLightAnimSpringBackHelper() {
        }

        public float computeAlpha() {
            if (this.f41733e <= 0) {
                return 0.0f;
            }
            float fCurrentAnimationTimeMillis = ((AnimationUtils.currentAnimationTimeMillis() - HwSpringBackHelper.this.f41705e) - this.f41732d) / this.f41733e;
            if (HwSpringBackHelper.this.f41702b > this.f41731c) {
                return fCurrentAnimationTimeMillis;
            }
            if (HwSpringBackHelper.this.f41703c > this.f41731c) {
                return 0.0f;
            }
            return 1.0f - fCurrentAnimationTimeMillis;
        }

        public void flingInSoftLightMode(View view, int i10, int i11) {
            if (i11 == 0) {
                HwSpringBackHelper.this.abortAnimation();
                return;
            }
            HwSpringBackHelper.this.f41708h = 2;
            this.f41729a = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
            HwSpringBackHelper.this.f41707g = false;
            HwSpringBackHelper.this.f41705e = AnimationUtils.currentAnimationTimeMillis();
            if (i10 >= i11) {
                HwSpringBackHelper.this.f41706f = 300L;
                HwSpringBackHelper.this.f41703c = i10 - ((int) ((i10 - i11) * f41724m));
                HwSpringBackHelper.this.f41704d = i11;
                this.f41733e = 200;
                this.f41731c = 0;
            } else {
                HwSpringBackHelper.this.f41706f = 200L;
                HwSpringBackHelper.this.f41703c = i10;
                int i12 = i11 - ((int) ((i11 - i10) * f41724m));
                this.f41731c = i12;
                HwSpringBackHelper.this.f41704d = i12;
                this.f41732d = 50;
                this.f41733e = 100;
            }
            HwSpringBackHelper hwSpringBackHelper = HwSpringBackHelper.this;
            hwSpringBackHelper.f41702b = hwSpringBackHelper.f41703c;
            HwSpringBackHelper.this.f41714n = view;
            this.f41730b = i11;
        }

        public boolean isContinueScrolling() {
            if (HwSpringBackHelper.this.isFinished()) {
                return false;
            }
            if (HwSpringBackHelper.this.f41706f <= 0) {
                HwSpringBackHelper.this.abortAnimation();
                return false;
            }
            float fCurrentAnimationTimeMillis = (AnimationUtils.currentAnimationTimeMillis() - HwSpringBackHelper.this.f41705e) / HwSpringBackHelper.this.f41706f;
            if (fCurrentAnimationTimeMillis <= 1.0f) {
                HwSpringBackHelper.this.f41707g = false;
                HwSpringBackHelper.this.f41703c = (int) (r1.f41702b - (this.f41729a.getInterpolation(fCurrentAnimationTimeMillis) * (HwSpringBackHelper.this.f41702b - HwSpringBackHelper.this.f41704d)));
                if (AnimationUtils.currentAnimationTimeMillis() - HwSpringBackHelper.this.f41705e > this.f41733e + this.f41732d) {
                    HwSpringBackHelper.this.f41704d = this.f41730b;
                }
            } else {
                HwSpringBackHelper.this.f41707g = true;
                HwSpringBackHelper hwSpringBackHelper = HwSpringBackHelper.this;
                hwSpringBackHelper.f41703c = hwSpringBackHelper.f41704d;
                HwSpringBackHelper.this.abortAnimation();
            }
            return !HwSpringBackHelper.this.f41707g;
        }
    }

    public class bzrwd extends C4681k {

        /* renamed from: g */
        private static final float f41735g = 0.001f;

        /* renamed from: a */
        private float f41736a;

        /* renamed from: b */
        private long f41737b;

        /* renamed from: c */
        private float f41738c;

        /* renamed from: d */
        private float f41739d;

        /* renamed from: e */
        private float f41740e;

        public bzrwd(float f10, float f11, float f12, float f13, float f14) {
            super(f10, f11, f41735g);
            this.f41738c = f12;
            this.f41739d = f12;
            this.f41740e = f13;
            this.f41736a = f14;
            setValueThreshold(0.5f);
            snap(0.0f);
            setEndPosition(this.f41740e - this.f41738c, f14, -1L);
            this.f41737b = AnimationUtils.currentAnimationTimeMillis();
        }

        /* renamed from: a */
        public boolean m54106a() {
            float fCurrentAnimationTimeMillis = (AnimationUtils.currentAnimationTimeMillis() - this.f41737b) / HwSpringBackHelper.f41697w;
            this.f41736a = getVelocity(fCurrentAnimationTimeMillis);
            float position = getPosition(fCurrentAnimationTimeMillis);
            float f10 = this.f41738c;
            float f11 = position + f10;
            this.f41739d = f11;
            if (!isAtEquilibrium(f11 - f10, this.f41736a)) {
                Log.d(HwSpringBackHelper.f41692r, "isAtEquilibrium is false.");
                return false;
            }
            this.f41739d = getEndPosition() + this.f41738c;
            this.f41736a = 0.0f;
            return true;
        }
    }

    public void abortAnimation() {
        this.f41708h = 0;
        this.f41710j = 0.0f;
        this.f41707g = true;
    }

    public boolean computeScrollOffset() {
        boolean z10;
        if (this.f41707g) {
            return false;
        }
        if (this.f41708h == 3) {
            bzrwd bzrwdVar = this.f41711k;
            if (bzrwdVar != null) {
                this.f41707g = bzrwdVar.m54106a();
                this.f41703c = (int) this.f41711k.f41739d;
                this.f41710j = this.f41711k.f41736a;
            } else {
                Log.e(f41692r, "computeScrollOffset mSpringModel is null");
                this.f41707g = true;
            }
            if (this.f41707g) {
                abortAnimation();
            }
            z10 = this.f41707g;
        } else {
            if (this.f41706f <= 0) {
                abortAnimation();
                return false;
            }
            float fCurrentAnimationTimeMillis = (AnimationUtils.currentAnimationTimeMillis() - this.f41705e) / this.f41706f;
            if (fCurrentAnimationTimeMillis <= 1.0f) {
                this.f41707g = false;
                if (this.f41708h == 2) {
                    this.f41703c = this.f41702b + ((int) (this.f41709i.m69893g(fCurrentAnimationTimeMillis).m28689b() * this.f41716p));
                    float fM28688a = this.f41709i.m69893g(fCurrentAnimationTimeMillis).m28688a();
                    this.f41710j = fM28688a;
                    int i10 = this.f41703c;
                    int i11 = this.f41712l;
                    if (i10 > i11 || fM28688a >= 0.0f) {
                        int i12 = this.f41713m;
                        if (i10 >= i12 && fM28688a > 0.0f) {
                            this.f41715o = i10 - i12;
                            overFling(this.f41714n, i12);
                        }
                    } else {
                        this.f41715o = i10 - i11;
                        overFling(this.f41714n, i11);
                    }
                } else {
                    this.f41703c = (int) (this.f41702b - (this.f41701a.getInterpolation(fCurrentAnimationTimeMillis) * (this.f41702b - this.f41704d)));
                }
            } else {
                this.f41703c = this.f41704d;
                abortAnimation();
            }
            z10 = this.f41707g;
        }
        return !z10;
    }

    public HwSoftLightAnimSpringBackHelper createHwSoftLightAnimSpringBackHelper() {
        return new HwSoftLightAnimSpringBackHelper();
    }

    public void fling(View view, int i10, int i11, int i12, int i13) {
        if (i11 == 0) {
            abortAnimation();
            return;
        }
        this.f41708h = 2;
        if (Float.compare(this.f41717q, -1.0f) == 0) {
            this.f41709i = new C11714a(i11, 0.5f);
        } else {
            this.f41709i = new C11714a(i11, this.f41717q);
        }
        this.f41706f = (long) this.f41709i.m69894b();
        this.f41707g = false;
        this.f41705e = AnimationUtils.currentAnimationTimeMillis();
        this.f41703c = i10;
        this.f41702b = i10;
        this.f41712l = i12;
        this.f41713m = i13;
        this.f41714n = view;
        this.f41710j = i11;
        this.f41715o = 0;
        this.f41704d = (int) (i10 + this.f41709i.m69895c() + 0.5f);
    }

    public float getCurrVelocity() {
        return this.f41710j;
    }

    public int getCurrentOffset() {
        return this.f41703c;
    }

    public int getDynamicCurvedRateDelta(int i10, int i11, int i12) {
        return Math.round(i11 * new C11906a(i10 * 0.5f).m71440a(Math.abs(i12)));
    }

    public int getFinalPositon() {
        return this.f41704d;
    }

    public float getFriction() {
        return this.f41717q;
    }

    public int getStartPosition() {
        return this.f41702b;
    }

    public boolean isFinished() {
        return this.f41707g;
    }

    public void overFling(View view, int i10) {
        this.f41708h = 3;
        this.f41703c = i10;
        if (this.f41714n == null) {
            if (view == null) {
                Log.e(f41692r, "overFling: the target view is null.");
                abortAnimation();
                return;
            }
            this.f41714n = view;
        }
        if (this.f41710j == 0.0f) {
            abortAnimation();
            return;
        }
        float scrollY = this.f41715o;
        if (this.f41714n != null) {
            scrollY += r0.getScrollY();
        }
        this.f41711k = new bzrwd(f41693s, 30.0f, scrollY, i10, this.f41710j);
        this.f41703c = (int) scrollY;
        this.f41707g = false;
    }

    public void setFactor(double d10) {
        this.f41716p = d10;
        this.f41704d = ((int) Math.round((this.f41704d - this.f41702b) * d10)) + this.f41702b;
    }

    public void setFriction(float f10) {
        this.f41717q = f10;
    }

    public boolean springBack(int i10, int i11, int i12) {
        this.f41708h = 1;
        int i13 = 0;
        this.f41707g = false;
        this.f41705e = AnimationUtils.currentAnimationTimeMillis();
        this.f41702b = i10;
        if (i10 < i11) {
            i13 = i10 - i11;
            this.f41704d = i11;
        } else if (i10 > i12) {
            i13 = i10 - i12;
            this.f41704d = i12;
        } else {
            abortAnimation();
        }
        C11716c c11716c = new C11716c(AbstractC4672b.f21509C, f41693s, 30.0f, i13);
        this.f41701a = c11716c;
        this.f41706f = (long) c11716c.m69894b();
        return !this.f41707g;
    }

    /* renamed from: a */
    private boolean m54092a(double d10, double d11) {
        return Math.abs(d10 - d11) < 9.999999974752427E-7d;
    }

    public void overFling(float f10, int i10, int i11) {
        this.f41708h = 3;
        this.f41703c = i11;
        if (Float.compare(f10, 0.0f) == 0) {
            abortAnimation();
            return;
        }
        this.f41711k = new bzrwd(f41693s, 30.0f, i10, i11, f10);
        this.f41703c = i10;
        this.f41710j = f10;
        this.f41707g = false;
        this.f41705e = AnimationUtils.currentAnimationTimeMillis();
    }
}
