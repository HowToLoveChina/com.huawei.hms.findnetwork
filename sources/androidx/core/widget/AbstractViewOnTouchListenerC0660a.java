package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import p273f0.C9603h0;

/* renamed from: androidx.core.widget.a */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0660a implements View.OnTouchListener {

    /* renamed from: r */
    public static final int f3485r = ViewConfiguration.getTapTimeout();

    /* renamed from: c */
    public final View f3488c;

    /* renamed from: d */
    public Runnable f3489d;

    /* renamed from: g */
    public int f3492g;

    /* renamed from: h */
    public int f3493h;

    /* renamed from: l */
    public boolean f3497l;

    /* renamed from: m */
    public boolean f3498m;

    /* renamed from: n */
    public boolean f3499n;

    /* renamed from: o */
    public boolean f3500o;

    /* renamed from: p */
    public boolean f3501p;

    /* renamed from: q */
    public boolean f3502q;

    /* renamed from: a */
    public final a f3486a = new a();

    /* renamed from: b */
    public final Interpolator f3487b = new AccelerateInterpolator();

    /* renamed from: e */
    public float[] f3490e = {0.0f, 0.0f};

    /* renamed from: f */
    public float[] f3491f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i */
    public float[] f3494i = {0.0f, 0.0f};

    /* renamed from: j */
    public float[] f3495j = {0.0f, 0.0f};

    /* renamed from: k */
    public float[] f3496k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: androidx.core.widget.a$a */
    public static class a {

        /* renamed from: a */
        public int f3503a;

        /* renamed from: b */
        public int f3504b;

        /* renamed from: c */
        public float f3505c;

        /* renamed from: d */
        public float f3506d;

        /* renamed from: j */
        public float f3512j;

        /* renamed from: k */
        public int f3513k;

        /* renamed from: e */
        public long f3507e = Long.MIN_VALUE;

        /* renamed from: i */
        public long f3511i = -1;

        /* renamed from: f */
        public long f3508f = 0;

        /* renamed from: g */
        public int f3509g = 0;

        /* renamed from: h */
        public int f3510h = 0;

        /* renamed from: a */
        public void m4020a() {
            if (this.f3508f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fM4026g = m4026g(m4024e(jCurrentAnimationTimeMillis));
            long j10 = jCurrentAnimationTimeMillis - this.f3508f;
            this.f3508f = jCurrentAnimationTimeMillis;
            float f10 = j10 * fM4026g;
            this.f3509g = (int) (this.f3505c * f10);
            this.f3510h = (int) (f10 * this.f3506d);
        }

        /* renamed from: b */
        public int m4021b() {
            return this.f3509g;
        }

        /* renamed from: c */
        public int m4022c() {
            return this.f3510h;
        }

        /* renamed from: d */
        public int m4023d() {
            float f10 = this.f3505c;
            return (int) (f10 / Math.abs(f10));
        }

        /* renamed from: e */
        public final float m4024e(long j10) {
            if (j10 < this.f3507e) {
                return 0.0f;
            }
            long j11 = this.f3511i;
            if (j11 < 0 || j10 < j11) {
                return AbstractViewOnTouchListenerC0660a.m3998e((j10 - r0) / this.f3503a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f3512j;
            return (1.0f - f10) + (f10 * AbstractViewOnTouchListenerC0660a.m3998e((j10 - j11) / this.f3513k, 0.0f, 1.0f));
        }

        /* renamed from: f */
        public int m4025f() {
            float f10 = this.f3506d;
            return (int) (f10 / Math.abs(f10));
        }

        /* renamed from: g */
        public final float m4026g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        /* renamed from: h */
        public boolean m4027h() {
            return this.f3511i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f3511i + ((long) this.f3513k);
        }

        /* renamed from: i */
        public void m4028i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3513k = AbstractViewOnTouchListenerC0660a.m3999f((int) (jCurrentAnimationTimeMillis - this.f3507e), 0, this.f3504b);
            this.f3512j = m4024e(jCurrentAnimationTimeMillis);
            this.f3511i = jCurrentAnimationTimeMillis;
        }

        /* renamed from: j */
        public void m4029j(int i10) {
            this.f3504b = i10;
        }

        /* renamed from: k */
        public void m4030k(int i10) {
            this.f3503a = i10;
        }

        /* renamed from: l */
        public void m4031l(float f10, float f11) {
            this.f3505c = f10;
            this.f3506d = f11;
        }

        /* renamed from: m */
        public void m4032m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3507e = jCurrentAnimationTimeMillis;
            this.f3511i = -1L;
            this.f3508f = jCurrentAnimationTimeMillis;
            this.f3512j = 0.5f;
            this.f3509g = 0;
            this.f3510h = 0;
        }
    }

    /* renamed from: androidx.core.widget.a$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC0660a abstractViewOnTouchListenerC0660a = AbstractViewOnTouchListenerC0660a.this;
            if (abstractViewOnTouchListenerC0660a.f3500o) {
                if (abstractViewOnTouchListenerC0660a.f3498m) {
                    abstractViewOnTouchListenerC0660a.f3498m = false;
                    abstractViewOnTouchListenerC0660a.f3486a.m4032m();
                }
                a aVar = AbstractViewOnTouchListenerC0660a.this.f3486a;
                if (aVar.m4027h() || !AbstractViewOnTouchListenerC0660a.this.m4018u()) {
                    AbstractViewOnTouchListenerC0660a.this.f3500o = false;
                    return;
                }
                AbstractViewOnTouchListenerC0660a abstractViewOnTouchListenerC0660a2 = AbstractViewOnTouchListenerC0660a.this;
                if (abstractViewOnTouchListenerC0660a2.f3499n) {
                    abstractViewOnTouchListenerC0660a2.f3499n = false;
                    abstractViewOnTouchListenerC0660a2.m4002c();
                }
                aVar.m4020a();
                AbstractViewOnTouchListenerC0660a.this.mo4007j(aVar.m4021b(), aVar.m4022c());
                C9603h0.m59886h0(AbstractViewOnTouchListenerC0660a.this.f3488c, this);
            }
        }
    }

    public AbstractViewOnTouchListenerC0660a(View view) {
        this.f3488c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        m4012o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        m4013p(f12, f12);
        m4009l(1);
        m4011n(Float.MAX_VALUE, Float.MAX_VALUE);
        m4016s(0.2f, 0.2f);
        m4017t(1.0f, 1.0f);
        m4008k(f3485r);
        m4015r(500);
        m4014q(500);
    }

    /* renamed from: e */
    public static float m3998e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    /* renamed from: f */
    public static int m3999f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    /* renamed from: a */
    public abstract boolean mo4000a(int i10);

    /* renamed from: b */
    public abstract boolean mo4001b(int i10);

    /* renamed from: c */
    public void m4002c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f3488c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: d */
    public final float m4003d(int i10, float f10, float f11, float f12) {
        float fM4005h = m4005h(this.f3490e[i10], f11, this.f3491f[i10], f10);
        if (fM4005h == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f3494i[i10];
        float f14 = this.f3495j[i10];
        float f15 = this.f3496k[i10];
        float f16 = f13 * f12;
        return fM4005h > 0.0f ? m3998e(fM4005h * f16, f14, f15) : -m3998e((-fM4005h) * f16, f14, f15);
    }

    /* renamed from: g */
    public final float m4004g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f3492g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f3500o && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    /* renamed from: h */
    public final float m4005h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float fM3998e = m3998e(f10 * f11, 0.0f, f12);
        float fM4004g = m4004g(f11 - f13, fM3998e) - m4004g(f13, fM3998e);
        if (fM4004g < 0.0f) {
            interpolation = -this.f3487b.getInterpolation(-fM4004g);
        } else {
            if (fM4004g <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f3487b.getInterpolation(fM4004g);
        }
        return m3998e(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: i */
    public final void m4006i() {
        if (this.f3498m) {
            this.f3500o = false;
        } else {
            this.f3486a.m4028i();
        }
    }

    /* renamed from: j */
    public abstract void mo4007j(int i10, int i11);

    /* renamed from: k */
    public AbstractViewOnTouchListenerC0660a m4008k(int i10) {
        this.f3493h = i10;
        return this;
    }

    /* renamed from: l */
    public AbstractViewOnTouchListenerC0660a m4009l(int i10) {
        this.f3492g = i10;
        return this;
    }

    /* renamed from: m */
    public AbstractViewOnTouchListenerC0660a m4010m(boolean z10) {
        if (this.f3501p && !z10) {
            m4006i();
        }
        this.f3501p = z10;
        return this;
    }

    /* renamed from: n */
    public AbstractViewOnTouchListenerC0660a m4011n(float f10, float f11) {
        float[] fArr = this.f3491f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    /* renamed from: o */
    public AbstractViewOnTouchListenerC0660a m4012o(float f10, float f11) {
        float[] fArr = this.f3496k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f3501p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.m4006i()
            goto L58
        L1a:
            r5.f3499n = r2
            r5.f3497l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f3488c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.m4003d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f3488c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.m4003d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f3486a
            r7.m4031l(r0, r6)
            boolean r6 = r5.f3500o
            if (r6 != 0) goto L58
            boolean r6 = r5.m4018u()
            if (r6 == 0) goto L58
            r5.m4019v()
        L58:
            boolean r6 = r5.f3502q
            if (r6 == 0) goto L61
            boolean r5 = r5.f3500o
            if (r5 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AbstractViewOnTouchListenerC0660a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public AbstractViewOnTouchListenerC0660a m4013p(float f10, float f11) {
        float[] fArr = this.f3495j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* renamed from: q */
    public AbstractViewOnTouchListenerC0660a m4014q(int i10) {
        this.f3486a.m4029j(i10);
        return this;
    }

    /* renamed from: r */
    public AbstractViewOnTouchListenerC0660a m4015r(int i10) {
        this.f3486a.m4030k(i10);
        return this;
    }

    /* renamed from: s */
    public AbstractViewOnTouchListenerC0660a m4016s(float f10, float f11) {
        float[] fArr = this.f3490e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    /* renamed from: t */
    public AbstractViewOnTouchListenerC0660a m4017t(float f10, float f11) {
        float[] fArr = this.f3494i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* renamed from: u */
    public boolean m4018u() {
        a aVar = this.f3486a;
        int iM4025f = aVar.m4025f();
        int iM4023d = aVar.m4023d();
        return (iM4025f != 0 && mo4001b(iM4025f)) || (iM4023d != 0 && mo4000a(iM4023d));
    }

    /* renamed from: v */
    public final void m4019v() {
        int i10;
        if (this.f3489d == null) {
            this.f3489d = new b();
        }
        this.f3500o = true;
        this.f3498m = true;
        if (this.f3497l || (i10 = this.f3493h) <= 0) {
            this.f3489d.run();
        } else {
            C9603h0.m59888i0(this.f3488c, this.f3489d, i10);
        }
        this.f3497l = true;
    }
}
