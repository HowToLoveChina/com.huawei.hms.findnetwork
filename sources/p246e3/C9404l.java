package p246e3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.R$animator;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;
import p002a1.AbstractC0002a;
import p002a1.C0003b;
import p760x2.C13689a;

/* renamed from: e3.l */
/* loaded from: classes.dex */
public final class C9404l extends AbstractC9400h<ObjectAnimator> {

    /* renamed from: l */
    public static final int[] f46984l = {533, 567, 850, 750};

    /* renamed from: m */
    public static final int[] f46985m = {1267, 1000, 333, 0};

    /* renamed from: n */
    public static final Property<C9404l, Float> f46986n = new c(Float.class, "animationFraction");

    /* renamed from: d */
    public ObjectAnimator f46987d;

    /* renamed from: e */
    public ObjectAnimator f46988e;

    /* renamed from: f */
    public final Interpolator[] f46989f;

    /* renamed from: g */
    public final AbstractC9394b f46990g;

    /* renamed from: h */
    public int f46991h;

    /* renamed from: i */
    public boolean f46992i;

    /* renamed from: j */
    public float f46993j;

    /* renamed from: k */
    public AbstractC0002a f46994k;

    /* renamed from: e3.l$a */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            C9404l c9404l = C9404l.this;
            c9404l.f46991h = (c9404l.f46991h + 1) % C9404l.this.f46990g.f46920c.length;
            C9404l.this.f46992i = true;
        }
    }

    /* renamed from: e3.l$b */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            C9404l.this.mo58873a();
            C9404l c9404l = C9404l.this;
            AbstractC0002a abstractC0002a = c9404l.f46994k;
            if (abstractC0002a != null) {
                abstractC0002a.mo2a(c9404l.f46968a);
            }
        }
    }

    /* renamed from: e3.l$c */
    public class c extends Property<C9404l, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(C9404l c9404l) {
            return Float.valueOf(c9404l.m58952n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(C9404l c9404l, Float f10) {
            c9404l.m58957r(f10.floatValue());
        }
    }

    public C9404l(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f46991h = 0;
        this.f46994k = null;
        this.f46990g = linearProgressIndicatorSpec;
        this.f46989f = new Interpolator[]{C0003b.m4a(context, R$animator.linear_indeterminate_line1_head_interpolator), C0003b.m4a(context, R$animator.linear_indeterminate_line1_tail_interpolator), C0003b.m4a(context, R$animator.linear_indeterminate_line2_head_interpolator), C0003b.m4a(context, R$animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* renamed from: n */
    public float m58952n() {
        return this.f46993j;
    }

    /* renamed from: o */
    private void m58953o() {
        if (this.f46987d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f46986n, 0.0f, 1.0f);
            this.f46987d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f46987d.setInterpolator(null);
            this.f46987d.setRepeatCount(-1);
            this.f46987d.addListener(new a());
        }
        if (this.f46988e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f46986n, 1.0f);
            this.f46988e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.f46988e.setInterpolator(null);
            this.f46988e.addListener(new b());
        }
    }

    /* renamed from: p */
    private void m58954p() {
        if (this.f46992i) {
            Arrays.fill(this.f46970c, C13689a.m82287a(this.f46990g.f46920c[this.f46991h], this.f46968a.getAlpha()));
            this.f46992i = false;
        }
    }

    /* renamed from: s */
    private void m58955s(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            this.f46969b[i11] = Math.max(0.0f, Math.min(1.0f, this.f46989f[i11].getInterpolation(m58926b(i10, f46985m[i11], f46984l[i11]))));
        }
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: a */
    public void mo58873a() {
        ObjectAnimator objectAnimator = this.f46987d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: c */
    public void mo58874c() {
        m58956q();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: d */
    public void mo58875d(AbstractC0002a abstractC0002a) {
        this.f46994k = abstractC0002a;
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: f */
    public void mo58876f() {
        ObjectAnimator objectAnimator = this.f46988e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        mo58873a();
        if (this.f46968a.isVisible()) {
            this.f46988e.setFloatValues(this.f46993j, 1.0f);
            this.f46988e.setDuration((long) ((1.0f - this.f46993j) * 1800.0f));
            this.f46988e.start();
        }
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: g */
    public void mo58877g() {
        m58953o();
        m58956q();
        this.f46987d.start();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: h */
    public void mo58878h() {
        this.f46994k = null;
    }

    /* renamed from: q */
    public void m58956q() {
        this.f46991h = 0;
        int iM82287a = C13689a.m82287a(this.f46990g.f46920c[0], this.f46968a.getAlpha());
        int[] iArr = this.f46970c;
        iArr[0] = iM82287a;
        iArr[1] = iM82287a;
    }

    /* renamed from: r */
    public void m58957r(float f10) {
        this.f46993j = f10;
        m58955s((int) (f10 * 1800.0f));
        m58954p();
        this.f46968a.invalidateSelf();
    }
}
