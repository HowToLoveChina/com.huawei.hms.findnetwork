package p246e3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import p002a1.AbstractC0002a;
import p562q0.C12269b;
import p666u2.C13112c;
import p760x2.C13689a;

/* renamed from: e3.d */
/* loaded from: classes.dex */
public final class C9396d extends AbstractC9400h<ObjectAnimator> {

    /* renamed from: l */
    public static final int[] f46928l = {0, 1350, 2700, 4050};

    /* renamed from: m */
    public static final int[] f46929m = {667, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, 3367, 4717};

    /* renamed from: n */
    public static final int[] f46930n = {1000, 2350, 3700, 5050};

    /* renamed from: o */
    public static final Property<C9396d, Float> f46931o = new c(Float.class, "animationFraction");

    /* renamed from: p */
    public static final Property<C9396d, Float> f46932p = new d(Float.class, "completeEndFraction");

    /* renamed from: d */
    public ObjectAnimator f46933d;

    /* renamed from: e */
    public ObjectAnimator f46934e;

    /* renamed from: f */
    public final C12269b f46935f;

    /* renamed from: g */
    public final AbstractC9394b f46936g;

    /* renamed from: h */
    public int f46937h;

    /* renamed from: i */
    public float f46938i;

    /* renamed from: j */
    public float f46939j;

    /* renamed from: k */
    public AbstractC0002a f46940k;

    /* renamed from: e3.d$a */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            C9396d c9396d = C9396d.this;
            c9396d.f46937h = (c9396d.f46937h + 4) % C9396d.this.f46936g.f46920c.length;
        }
    }

    /* renamed from: e3.d$b */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            C9396d.this.mo58873a();
            C9396d c9396d = C9396d.this;
            AbstractC0002a abstractC0002a = c9396d.f46940k;
            if (abstractC0002a != null) {
                abstractC0002a.mo2a(c9396d.f46968a);
            }
        }
    }

    /* renamed from: e3.d$c */
    public class c extends Property<C9396d, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(C9396d c9396d) {
            return Float.valueOf(c9396d.m58879o());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(C9396d c9396d, Float f10) {
            c9396d.m58884t(f10.floatValue());
        }
    }

    /* renamed from: e3.d$d */
    public class d extends Property<C9396d, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(C9396d c9396d) {
            return Float.valueOf(c9396d.m58880p());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(C9396d c9396d, Float f10) {
            c9396d.m58885u(f10.floatValue());
        }
    }

    public C9396d(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f46937h = 0;
        this.f46940k = null;
        this.f46936g = circularProgressIndicatorSpec;
        this.f46935f = new C12269b();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: a */
    public void mo58873a() {
        ObjectAnimator objectAnimator = this.f46933d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: c */
    public void mo58874c() {
        m58883s();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: d */
    public void mo58875d(AbstractC0002a abstractC0002a) {
        this.f46940k = abstractC0002a;
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: f */
    public void mo58876f() {
        ObjectAnimator objectAnimator = this.f46934e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f46968a.isVisible()) {
            this.f46934e.start();
        } else {
            mo58873a();
        }
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: g */
    public void mo58877g() {
        m58881q();
        m58883s();
        this.f46933d.start();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: h */
    public void mo58878h() {
        this.f46940k = null;
    }

    /* renamed from: o */
    public final float m58879o() {
        return this.f46938i;
    }

    /* renamed from: p */
    public final float m58880p() {
        return this.f46939j;
    }

    /* renamed from: q */
    public final void m58881q() {
        if (this.f46933d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f46931o, 0.0f, 1.0f);
            this.f46933d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f46933d.setInterpolator(null);
            this.f46933d.setRepeatCount(-1);
            this.f46933d.addListener(new a());
        }
        if (this.f46934e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f46932p, 0.0f, 1.0f);
            this.f46934e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f46934e.setInterpolator(this.f46935f);
            this.f46934e.addListener(new b());
        }
    }

    /* renamed from: r */
    public final void m58882r(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            float fM58926b = m58926b(i10, f46930n[i11], 333);
            if (fM58926b >= 0.0f && fM58926b <= 1.0f) {
                int i12 = i11 + this.f46937h;
                int[] iArr = this.f46936g.f46920c;
                int length = i12 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                this.f46970c[0] = C13112c.m78888b().evaluate(this.f46935f.getInterpolation(fM58926b), Integer.valueOf(C13689a.m82287a(iArr[length], this.f46968a.getAlpha())), Integer.valueOf(C13689a.m82287a(this.f46936g.f46920c[length2], this.f46968a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* renamed from: s */
    public void m58883s() {
        this.f46937h = 0;
        this.f46970c[0] = C13689a.m82287a(this.f46936g.f46920c[0], this.f46968a.getAlpha());
        this.f46939j = 0.0f;
    }

    /* renamed from: t */
    public void m58884t(float f10) {
        this.f46938i = f10;
        int i10 = (int) (f10 * 5400.0f);
        m58886v(i10);
        m58882r(i10);
        this.f46968a.invalidateSelf();
    }

    /* renamed from: u */
    public final void m58885u(float f10) {
        this.f46939j = f10;
    }

    /* renamed from: v */
    public final void m58886v(int i10) {
        float[] fArr = this.f46969b;
        float f10 = this.f46938i;
        fArr[0] = (f10 * 1520.0f) - 20.0f;
        fArr[1] = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            float fM58926b = m58926b(i10, f46928l[i11], 667);
            float[] fArr2 = this.f46969b;
            fArr2[1] = fArr2[1] + (this.f46935f.getInterpolation(fM58926b) * 250.0f);
            float fM58926b2 = m58926b(i10, f46929m[i11], 667);
            float[] fArr3 = this.f46969b;
            fArr3[0] = fArr3[0] + (this.f46935f.getInterpolation(fM58926b2) * 250.0f);
        }
        float[] fArr4 = this.f46969b;
        float f11 = fArr4[0];
        float f12 = fArr4[1];
        float f13 = f11 + ((f12 - f11) * this.f46939j);
        fArr4[0] = f13;
        fArr4[0] = f13 / 360.0f;
        fArr4[1] = f12 / 360.0f;
    }
}
