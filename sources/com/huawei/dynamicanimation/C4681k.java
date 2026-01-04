package com.huawei.dynamicanimation;

import android.os.SystemClock;
import java.math.BigDecimal;

/* renamed from: com.huawei.dynamicanimation.k */
/* loaded from: classes5.dex */
public class C4681k extends AbstractC4679i {
    private static final float CURRENT_TIME = -1.0f;
    public static final float DEFAULT_DAMPING = 15.0f;
    private static final float DEFAULT_ESTIMATE_DURATION = 500.0f;
    public static final float DEFAULT_MASS = 1.0f;
    public static final float DEFAULT_STIFFNESS = 800.0f;
    public static final float DEFAULT_VALUE_THRESHOLD = new BigDecimal("1").divide(new BigDecimal("1000")).floatValue();
    private static final int DIST_NUM = 16;
    private static final float EPSILON = 1.0E-6f;
    private static final int INVALID = -1;
    public static final float MAXIMUM_DAMPING = 99.0f;
    public static final float MAXIMUM_MASS = 1.0f;
    public static final float MAXIMUM_STIFFNESS = 999.0f;
    private static final float MAX_ITERATION_NUM = 999.0f;
    public static final float MINIMUM_DAMPING = 1.0f;
    public static final float MINIMUM_MASS = 1.0f;
    public static final float MINIMUM_STIFFNESS = 1.0f;
    private static final int MULTIPLE_FOUR = 4;
    private static final int MULTIPLE_TWO = 2;
    private static final double ONE_SECOND_D = 1000.0d;
    private static final float ONE_SECOND_F = 1000.0f;
    private float mDamping;
    private float mMass;
    private f mSolution;
    private float mStiffness;

    /* renamed from: com.huawei.dynamicanimation.k$b */
    public class b extends f {
        public b() {
            super();
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: b */
        public float mo28692b() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: d */
        public float mo28693d(float f10) {
            return this.f21579c;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: e */
        public float mo28694e() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: g */
        public float mo28695g() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: h */
        public float mo28696h(float f10) {
            return this.f21577a;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: j */
        public float mo28697j(float f10) {
            return this.f21578b;
        }
    }

    /* renamed from: com.huawei.dynamicanimation.k$c */
    public class c extends f {

        /* renamed from: g */
        public float f21563g;

        /* renamed from: h */
        public float f21564h;

        /* renamed from: i */
        public float f21565i;

        public c(float f10, float f11, float f12) {
            super();
            this.f21563g = f10;
            this.f21564h = f11;
            this.f21565i = f12;
            m28698k();
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: b */
        public float mo28692b() {
            return this.f21580d;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: d */
        public float mo28693d(float f10) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f21565i * f10);
            float f11 = this.f21565i;
            float f12 = this.f21563g;
            float f13 = this.f21564h;
            float f14 = (f11 * f11 * (f12 + (f10 * f13)) * fPow) + (f13 * 2.0f * f11 * fPow);
            this.f21579c = f14;
            return f14;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: e */
        public float mo28694e() {
            float f10 = this.f21564h;
            float f11 = 0.0f;
            if (f10 != 0.0f) {
                float f12 = this.f21565i;
                if (f12 != 0.0f) {
                    float f13 = (-((f10 / f12) + this.f21563g)) / f10;
                    if (f13 >= 0.0f && !Float.isInfinite(f13)) {
                        f11 = f13;
                    }
                    return mo28696h(f11);
                }
            }
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: g */
        public float mo28695g() {
            return Math.abs(mo28694e());
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: h */
        public float mo28696h(float f10) {
            float fPow = (float) ((this.f21563g + (this.f21564h * f10)) * Math.pow(2.718281828459045d, this.f21565i * f10));
            this.f21577a = fPow;
            return fPow;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: j */
        public float mo28697j(float f10) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f21565i * f10);
            float f11 = this.f21565i;
            float f12 = this.f21563g;
            float f13 = this.f21564h;
            float f14 = (f11 * (f12 + (f10 * f13)) * fPow) + (f13 * fPow);
            this.f21578b = f14;
            return f14;
        }

        /* renamed from: k */
        public final void m28698k() {
            float f10 = this.f21564h;
            if (f10 != 0.0f) {
                float f11 = this.f21565i;
                if (f11 == 0.0f) {
                    return;
                }
                m28702c(0.0f, (-(((2.0f * f10) / f11) + this.f21563g)) / f10);
            }
        }
    }

    /* renamed from: com.huawei.dynamicanimation.k$d */
    public class d extends f {

        /* renamed from: g */
        public float f21567g;

        /* renamed from: h */
        public float f21568h;

        /* renamed from: i */
        public float f21569i;

        /* renamed from: j */
        public float f21570j;

        public d(float f10, float f11, float f12, float f13) {
            super();
            this.f21567g = f10;
            this.f21568h = f11;
            this.f21569i = f12;
            this.f21570j = f13;
            m28699k();
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: b */
        public float mo28692b() {
            return this.f21580d;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: d */
        public float mo28693d(float f10) {
            float f11 = this.f21567g;
            float f12 = this.f21569i;
            float fPow = f11 * f12 * f12 * ((float) Math.pow(2.718281828459045d, f12 * f10));
            float f13 = this.f21568h;
            float f14 = this.f21570j;
            float fPow2 = fPow + (f13 * f14 * f14 * ((float) Math.pow(2.718281828459045d, f14 * f10)));
            this.f21579c = fPow2;
            return fPow2;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: e */
        public float mo28694e() {
            float f10 = 0.0f;
            if (Math.abs(this.f21569i - this.f21570j) < C4681k.EPSILON) {
                return 0.0f;
            }
            float fLog = (((float) Math.log(Math.abs(this.f21567g * this.f21569i))) - ((float) Math.log(Math.abs((-this.f21568h) * this.f21570j)))) / (this.f21570j - this.f21569i);
            if (fLog >= 0.0f && !Float.isInfinite(fLog)) {
                f10 = fLog;
            }
            return mo28696h(f10);
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: g */
        public float mo28695g() {
            return Math.abs(mo28694e());
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: h */
        public float mo28696h(float f10) {
            float fPow = (this.f21567g * ((float) Math.pow(2.718281828459045d, this.f21569i * f10))) + (this.f21568h * ((float) Math.pow(2.718281828459045d, this.f21570j * f10)));
            this.f21577a = fPow;
            return fPow;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: j */
        public float mo28697j(float f10) {
            float fPow = (this.f21567g * this.f21569i * ((float) Math.pow(2.718281828459045d, r1 * f10))) + (this.f21568h * this.f21570j * ((float) Math.pow(2.718281828459045d, r2 * f10)));
            this.f21578b = fPow;
            return fPow;
        }

        /* renamed from: k */
        public final void m28699k() {
            if (Math.abs(this.f21569i - this.f21570j) < C4681k.EPSILON) {
                return;
            }
            float f10 = this.f21567g;
            float f11 = this.f21569i;
            float fLog = (float) Math.log(Math.abs(f10 * f11 * f11));
            float f12 = -this.f21568h;
            float f13 = this.f21570j;
            m28702c(0.0f, (fLog - ((float) Math.log(Math.abs((f12 * f13) * f13)))) / (this.f21570j - this.f21569i));
        }
    }

    /* renamed from: com.huawei.dynamicanimation.k$e */
    public class e extends f {

        /* renamed from: g */
        public float f21572g;

        /* renamed from: h */
        public float f21573h;

        /* renamed from: i */
        public float f21574i;

        /* renamed from: j */
        public float f21575j;

        public e(float f10, float f11, float f12, float f13) {
            super();
            this.f21572g = f10;
            this.f21573h = f11;
            this.f21574i = f12;
            this.f21575j = f13;
            m28700k();
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: b */
        public float mo28692b() {
            return this.f21580d;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: d */
        public float mo28693d(float f10) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f21575j * f10);
            float fCos = (float) Math.cos(this.f21574i * f10);
            float fSin = (float) Math.sin(this.f21574i * f10);
            float f11 = this.f21575j;
            float f12 = this.f21573h;
            float f13 = this.f21574i;
            float f14 = this.f21572g;
            float f15 = (f11 * fPow * (((f12 * f13) * fCos) - ((f14 * f13) * fSin))) + ((((((-f12) * f13) * f13) * fSin) - (((f14 * f13) * f13) * fCos)) * fPow) + (f11 * f11 * fPow * ((f12 * fSin) + (f14 * fCos))) + (f11 * fPow * (((f12 * f13) * fCos) - ((f14 * f13) * fSin)));
            this.f21579c = f15;
            return f15;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: e */
        public float mo28694e() {
            if (C4681k.this.mDamping == 0.0f || C4681k.this.mMass == 0.0f || C4681k.this.mStiffness == 0.0f || this.f21572g == 0.0f) {
                return 0.0f;
            }
            float fSqrt = (float) Math.sqrt((C4681k.this.mDamping * C4681k.this.mDamping) / ((C4681k.this.mMass * 4.0f) * C4681k.this.mStiffness));
            float fSqrt2 = (float) (((float) Math.sqrt(C4681k.this.mStiffness / C4681k.this.mMass)) * Math.sqrt(1.0f - (fSqrt * fSqrt)));
            float fAtan = (float) Math.atan(this.f21573h / this.f21572g);
            float fAtan2 = (float) Math.atan(fSqrt2 / (fSqrt * r2));
            if (fSqrt2 == 0.0f) {
                return 0.0f;
            }
            return mo28696h((float) ((((Math.acos(0.0d) + fAtan2) + fAtan) % 3.141592653589793d) / fSqrt2));
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: g */
        public float mo28695g() {
            float fSqrt = (float) Math.sqrt((C4681k.this.mDamping * C4681k.this.mDamping) / ((C4681k.this.mMass * 4.0f) * C4681k.this.mStiffness));
            float fSqrt2 = (float) (((float) Math.sqrt(C4681k.this.mStiffness / C4681k.this.mMass)) * Math.sqrt(1.0f - (fSqrt * fSqrt)));
            float fAcos = (float) (((Math.acos(0.0d) + ((float) Math.atan(fSqrt2 / (fSqrt * r1)))) + ((float) Math.atan(this.f21573h / this.f21572g))) % 3.141592653589793d);
            float fAbs = Math.abs(mo28696h(fAcos / fSqrt2));
            int i10 = 0;
            do {
                float f10 = (float) (fAcos + ((i10 * 3.141592653589793d) / fSqrt2));
                float fAbs2 = Math.abs(mo28696h(f10));
                if (fAbs < fAbs2) {
                    fAbs = fAbs2;
                }
                if (f10 >= mo28692b()) {
                    break;
                }
                i10++;
            } while (i10 < 999.0f);
            if (i10 >= 999.0f) {
                return -1.0f;
            }
            return fAbs;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: h */
        public float mo28696h(float f10) {
            float fPow = ((float) Math.pow(2.718281828459045d, this.f21575j * f10)) * ((this.f21572g * ((float) Math.cos(this.f21574i * f10))) + (this.f21573h * ((float) Math.sin(this.f21574i * f10))));
            this.f21577a = fPow;
            return fPow;
        }

        @Override // com.huawei.dynamicanimation.C4681k.f
        /* renamed from: j */
        public float mo28697j(float f10) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f21575j * f10);
            float fCos = (float) Math.cos(this.f21574i * f10);
            float fSin = (float) Math.sin(this.f21574i * f10);
            float f11 = this.f21573h;
            float f12 = this.f21574i;
            float f13 = this.f21572g;
            float f14 = ((((f11 * f12) * fCos) - ((f12 * f13) * fSin)) * fPow) + (this.f21575j * fPow * ((f11 * fSin) + (f13 * fCos)));
            this.f21578b = f14;
            return f14;
        }

        /* renamed from: k */
        public final void m28700k() {
            float fSqrt = (float) Math.sqrt((C4681k.this.mDamping * C4681k.this.mDamping) / ((C4681k.this.mMass * 4.0f) * C4681k.this.mStiffness));
            float fSqrt2 = ((float) Math.sqrt(1.0f - (fSqrt * fSqrt))) * ((float) Math.sqrt(C4681k.this.mStiffness / C4681k.this.mMass));
            float fAtan = (float) Math.atan(this.f21573h / this.f21572g);
            if (Float.isNaN(fAtan)) {
                this.f21580d = 0.0f;
                return;
            }
            float fAcos = ((((float) Math.acos(0.0d)) + fAtan) % 3.1415927f) / this.f21574i;
            float fMo28697j = mo28697j(fAcos);
            float fAcos2 = (((((float) Math.acos(0.0d)) + ((float) Math.atan(fSqrt2 / (fSqrt * r1)))) + fAtan) % 3.1415927f) / fSqrt2;
            float f10 = (6.2831855f / fSqrt2) / 2.0f;
            int i10 = 0;
            float f11 = 0.0f;
            while (true) {
                if (!C4681k.this.almostGreaterThan(Math.abs(fMo28697j), C4681k.this.mVelocityThreshold, 0.0f)) {
                    break;
                }
                int i11 = i10 + 1;
                if (i10 >= 999.0f) {
                    i10 = i11;
                    break;
                }
                fAcos += f10;
                fMo28697j = mo28697j(fAcos);
                f11 += f10;
                fAcos2 += f10;
                i10 = i11;
            }
            float fM28701a = -1.0f;
            if (i10 >= 999.0f) {
                this.f21580d = -1.0f;
                return;
            }
            if ((f11 <= fAcos2 && fAcos2 < fAcos) || Math.abs(f11 - fAcos) < C4681k.EPSILON) {
                fM28701a = m28701a(fAcos2, f10 + fAcos2);
            } else if (f11 < fAcos && fAcos < fAcos2) {
                fM28701a = m28701a(Math.max(0.0f, fAcos2 - f10), fAcos2);
            }
            this.f21580d = fM28701a;
        }
    }

    /* renamed from: com.huawei.dynamicanimation.k$f */
    public abstract class f {

        /* renamed from: e */
        public float[] f21581e = new float[17];

        /* renamed from: a */
        public float f21577a = 0.0f;

        /* renamed from: b */
        public float f21578b = 0.0f;

        /* renamed from: c */
        public float f21579c = 0.0f;

        /* renamed from: d */
        public float f21580d = 0.0f;

        public f() {
        }

        /* renamed from: a */
        public float m28701a(float f10, float f11) {
            float f12 = (f11 - f10) / 16.0f;
            float f13 = C4681k.this.mValueThreshold;
            for (int i10 = 0; i10 < 17; i10++) {
                this.f21581e[i10] = mo28696h((i10 * f12) + f10);
            }
            boolean z10 = true;
            int i11 = 1;
            while (true) {
                if (i11 >= 17) {
                    z10 = false;
                    break;
                }
                float[] fArr = this.f21581e;
                float f14 = fArr[i11 - 1];
                float f15 = C4681k.this.mValueThreshold;
                float f16 = fArr[i11];
                if ((f14 - f15) * (f16 - f15) < 0.0f) {
                    f13 = f15;
                    break;
                }
                if ((f14 + f15) * (f16 + f15) < 0.0f) {
                    f13 = -f15;
                    break;
                }
                i11++;
            }
            if (!z10) {
                return f10;
            }
            float fM28704i = m28704i(f13, f10, f11);
            while (true) {
                float f17 = fM28704i;
                float f18 = f11;
                f11 = f17;
                if (Math.abs(mo28696h(f11)) >= C4681k.this.mValueThreshold || f18 - f11 < 0.0625f) {
                    break;
                }
                float f19 = (f11 - f10) / 16.0f;
                for (int i12 = 0; i12 < 17; i12++) {
                    this.f21581e[i12] = mo28696h((i12 * f19) + f10);
                }
                fM28704i = m28704i(f13, f10, f11);
            }
            float fMo28696h = mo28696h(f11);
            float fMo28697j = mo28697j(f11);
            float f20 = 0.0f;
            while (C4681k.this.almostGreaterThan(Math.abs(fMo28696h), C4681k.this.mValueThreshold, 0.0f)) {
                float f21 = 1.0f + f20;
                if (f20 >= 999.0f || fMo28697j == 0.0f) {
                    f20 = f21;
                    break;
                }
                f11 -= fMo28696h / fMo28697j;
                fMo28696h = mo28696h(f11);
                fMo28697j = mo28697j(f11);
                f20 = f21;
            }
            return m28703f(f20, f11);
        }

        /* renamed from: b */
        public abstract float mo28692b();

        /* renamed from: c */
        public void m28702c(float f10, float f11) {
            int i10 = 0;
            if (f11 >= 0.0f && !Float.isInfinite(f11) && !Float.isNaN(f11)) {
                float fMo28696h = mo28696h(f11);
                int i11 = 0;
                while (C4681k.this.almostLessThan(Math.abs(fMo28696h), C4681k.this.mValueThreshold, 0.0f)) {
                    i11++;
                    if (i11 > 999.0f) {
                        break;
                    }
                    f11 = (f11 + f10) / 2.0f;
                    fMo28696h = mo28696h(f11);
                }
                if (i11 > 999.0f) {
                    this.f21580d = f11;
                    return;
                }
                f10 = f11;
            }
            float fMo28696h2 = mo28696h(f10);
            float fMo28697j = mo28697j(f10);
            while (C4681k.this.almostGreaterThan(Math.abs(fMo28696h2), C4681k.this.mValueThreshold, 0.0f)) {
                i10++;
                if (i10 > 999.0f) {
                    break;
                }
                f10 -= fMo28696h2 / fMo28697j;
                if (f10 < 0.0f || Float.isNaN(f10) || Float.isInfinite(f10)) {
                    this.f21580d = 0.0f;
                    return;
                } else {
                    fMo28696h2 = mo28696h(f10);
                    fMo28697j = mo28697j(f10);
                }
            }
            if (i10 > 999.0f) {
                this.f21580d = -1.0f;
            } else {
                this.f21580d = f10;
            }
        }

        /* renamed from: d */
        public abstract float mo28693d(float f10);

        /* renamed from: e */
        public abstract float mo28694e();

        /* renamed from: f */
        public final float m28703f(float f10, float f11) {
            if (f10 <= 999.0f) {
                return f11;
            }
            return -1.0f;
        }

        /* renamed from: g */
        public abstract float mo28695g();

        /* renamed from: h */
        public abstract float mo28696h(float f10);

        /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
        /* renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final float m28704i(float r10, float r11, float r12) {
            /*
                r9 = this;
                float r0 = r12 - r11
                r1 = 1098907648(0x41800000, float:16.0)
                float r0 = r0 / r1
                java.math.BigDecimal r1 = new java.math.BigDecimal
                float r2 = r12 + r11
                double r2 = (double) r2
                r1.<init>(r2)
                java.math.BigDecimal r2 = new java.math.BigDecimal
                java.lang.String r3 = "2"
                r2.<init>(r3)
                java.math.BigDecimal r1 = r1.divide(r2)
                float r1 = r1.floatValue()
                float r1 = r9.mo28697j(r1)
                r2 = 0
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                r3 = 1
                if (r1 <= 0) goto L28
                r1 = r3
                goto L29
            L28:
                r1 = 0
            L29:
                r4 = 17
                if (r3 >= r4) goto L5d
                float[] r4 = r9.f21581e
                r5 = r4[r3]
                int r6 = r3 + (-1)
                r4 = r4[r6]
                float r7 = r5 - r4
                if (r1 == 0) goto L4a
                int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r8 < 0) goto L4a
                int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r9 != 0) goto L45
            L41:
                float r9 = (float) r6
            L42:
                float r9 = r9 * r0
                float r11 = r11 + r9
                return r11
            L45:
                float r9 = (float) r6
                float r10 = r10 - r4
                float r10 = r10 / r7
                float r9 = r9 + r10
                goto L42
            L4a:
                if (r1 != 0) goto L5a
                int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r4 > 0) goto L5a
                int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r9 != 0) goto L55
                goto L41
            L55:
                float r9 = (float) r3
                float r5 = r5 - r10
                float r5 = r5 / r7
                float r9 = r9 - r5
                goto L42
            L5a:
                int r3 = r3 + 1
                goto L29
            L5d:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.dynamicanimation.C4681k.f.m28704i(float, float, float):float");
        }

        /* renamed from: j */
        public abstract float mo28697j(float f10);
    }

    public C4681k(float f10, float f11, float f12) {
        this.mMass = 1.0f;
        this.mStiffness = 800.0f;
        this.mDamping = 15.0f;
        super.setValueThreshold(f12);
        this.mMass = 1.0f;
        this.mStiffness = Math.min(Math.max(1.0f, f10), 999.0f);
        this.mDamping = Math.min(Math.max(1.0f, f11), 99.0f);
        this.mSolution = null;
        this.mStartPosition = 0.0f;
        this.mEndPosition = 0.0f;
        this.mStartVelocity = 0.0f;
        this.mStartTime = 0L;
    }

    private boolean almostEqual(float f10, float f11, float f12) {
        return f10 > f11 - f12 && f10 < f11 + f12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean almostGreaterThan(float f10, float f11, float f12) {
        return f10 > f11 - f12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean almostLessThan(float f10, float f11, float f12) {
        return f10 < f11 - f12;
    }

    private boolean almostZero(float f10, float f11) {
        return almostEqual(f10, 0.0f, f11);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getAcceleration(float f10) {
        if (f10 < 0.0f) {
            f10 = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / ONE_SECOND_D);
        }
        f fVar = this.mSolution;
        if (fVar != null) {
            return fVar.mo28693d(f10);
        }
        return 0.0f;
    }

    public float getDamping() {
        return this.mDamping;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getEstimatedDuration() {
        float fMo28692b = this.mSolution.mo28692b();
        return Float.compare(fMo28692b, -1.0f) == 0 ? DEFAULT_ESTIMATE_DURATION : fMo28692b * ONE_SECOND_F;
    }

    public float getFirstExtremumX() {
        f fVar = this.mSolution;
        if (fVar != null) {
            return fVar.mo28694e();
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getMaxAbsX() {
        f fVar = this.mSolution;
        if (fVar != null) {
            return fVar.mo28695g();
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getPosition(float f10) {
        if (f10 < 0.0f) {
            f10 = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / ONE_SECOND_D);
        }
        f fVar = this.mSolution;
        if (fVar != null) {
            return this.mEndPosition + fVar.mo28696h(f10);
        }
        return 0.0f;
    }

    public float getStiffness() {
        return this.mStiffness;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getVelocity(float f10) {
        if (f10 < 0.0f) {
            f10 = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / ONE_SECOND_D);
        }
        f fVar = this.mSolution;
        if (fVar != null) {
            return fVar.mo28697j(f10);
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public boolean isAtEquilibrium(float f10) {
        if (f10 < 0.0f) {
            f10 = SystemClock.elapsedRealtime() - (getStartTime() / ONE_SECOND_F);
        }
        return almostEqual(getPosition(f10), this.mEndPosition, this.mValueThreshold) && almostZero(getVelocity(f10), this.mValueThreshold);
    }

    public C4681k reconfigure(float f10, float f11, float f12, float f13) {
        super.setValueThreshold(f13);
        this.mMass = Math.min(Math.max(1.0f, f10), 1.0f);
        this.mStiffness = Math.min(Math.max(1.0f, f11), 999.0f);
        this.mDamping = Math.min(Math.max(1.0f, f12), 99.0f);
        this.mStartPosition = getPosition(-1.0f);
        float velocity = getVelocity(-1.0f);
        this.mStartVelocity = velocity;
        this.mSolution = solve(this.mStartPosition - this.mEndPosition, velocity);
        this.mStartTime = SystemClock.elapsedRealtime();
        return this;
    }

    public C4681k setDamping(float f10) {
        return reconfigure(this.mMass, this.mStiffness, f10, this.mValueThreshold);
    }

    public C4681k setEndPosition(float f10, float f11, long j10) {
        float fMin = Math.min(99999.0f, Math.max(-99999.0f, f10));
        float fMin2 = Math.min(99999.0f, Math.max(-99999.0f, f11));
        if (j10 <= 0) {
            j10 = SystemClock.elapsedRealtime();
        }
        if (fMin == this.mEndPosition && almostZero(fMin2, this.mValueThreshold)) {
            return this;
        }
        float f12 = this.mEndPosition;
        if (this.mSolution != null) {
            if (almostZero(fMin2, this.mValueThreshold)) {
                fMin2 = this.mSolution.mo28697j((j10 - this.mStartTime) / ONE_SECOND_F);
            }
            float fMo28696h = this.mSolution.mo28696h((j10 - this.mStartTime) / ONE_SECOND_F);
            if (almostZero(fMin2, this.mValueThreshold)) {
                fMin2 = 0.0f;
            }
            if (almostZero(fMo28696h, this.mValueThreshold)) {
                fMo28696h = 0.0f;
            }
            f12 = fMo28696h + this.mEndPosition;
            if (almostZero(f12 - fMin, this.mValueThreshold) && almostZero(fMin2, this.mValueThreshold)) {
                return this;
            }
        }
        this.mEndPosition = fMin;
        this.mStartPosition = f12;
        this.mStartVelocity = fMin2;
        this.mSolution = solve(f12 - fMin, fMin2);
        this.mStartTime = j10;
        return this;
    }

    public C4681k setEndValue(float f10, float f11) {
        if (f10 == this.mEndPosition && almostZero(f11, this.mValueThreshold)) {
            return this;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartPosition = 0.0f;
        this.mEndPosition = f10;
        this.mStartVelocity = f11;
        this.mSolution = solve(0.0f - f10, f11);
        return this;
    }

    public void setMass(float f10) {
        reconfigure(f10, this.mStiffness, this.mDamping, this.mValueThreshold);
    }

    public C4681k setStiffness(float f10) {
        return reconfigure(this.mMass, f10, this.mDamping, this.mValueThreshold);
    }

    public C4681k snap(float f10) {
        float fMin = Math.min(0.0f, Math.max(0.0f, f10));
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartPosition = 0.0f;
        this.mEndPosition = fMin;
        this.mStartVelocity = 0.0f;
        this.mSolution = new b();
        return this;
    }

    public f solve(float f10, float f11) {
        float f12 = this.mDamping;
        float f13 = this.mMass;
        float f14 = f12 * f12;
        float f15 = 4.0f * f13 * this.mStiffness;
        float f16 = f14 - f15;
        int iCompare = Float.compare(f14, f15);
        if (iCompare == 0) {
            float f17 = (-f12) / (f13 * 2.0f);
            return new c(f10, f11 - (f17 * f10), f17);
        }
        if (iCompare <= 0) {
            float f18 = f13 * 2.0f;
            float fSqrt = (float) (Math.sqrt(f15 - f14) / f18);
            float f19 = (-f12) / f18;
            return new e(f10, (f11 - (f19 * f10)) / fSqrt, fSqrt, f19);
        }
        double d10 = -f12;
        double d11 = f16;
        double d12 = f13 * 2.0f;
        float fSqrt2 = (float) ((d10 - Math.sqrt(d11)) / d12);
        float fSqrt3 = (float) ((d10 + Math.sqrt(d11)) / d12);
        float f20 = (f11 - (fSqrt2 * f10)) / (fSqrt3 - fSqrt2);
        return new d(f10 - f20, f20, fSqrt2, fSqrt3);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getAcceleration() {
        return getAcceleration(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getPosition() {
        return getPosition(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getVelocity() {
        return getVelocity(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public C4681k setValueThreshold(float f10) {
        return reconfigure(this.mMass, this.mStiffness, this.mDamping, f10);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public boolean isAtEquilibrium() {
        return isAtEquilibrium(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public boolean isAtEquilibrium(float f10, float f11) {
        return Math.abs(f11) < this.mVelocityThreshold && Math.abs(f10 - this.mEndPosition) < this.mValueThreshold;
    }
}
