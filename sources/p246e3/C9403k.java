package p246e3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;
import p002a1.AbstractC0002a;
import p562q0.C12269b;
import p760x2.C13689a;

/* renamed from: e3.k */
/* loaded from: classes.dex */
public final class C9403k extends AbstractC9400h<ObjectAnimator> {

    /* renamed from: j */
    public static final Property<C9403k, Float> f46976j = new b(Float.class, "animationFraction");

    /* renamed from: d */
    public ObjectAnimator f46977d;

    /* renamed from: e */
    public C12269b f46978e;

    /* renamed from: f */
    public final AbstractC9394b f46979f;

    /* renamed from: g */
    public int f46980g;

    /* renamed from: h */
    public boolean f46981h;

    /* renamed from: i */
    public float f46982i;

    /* renamed from: e3.k$a */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            C9403k c9403k = C9403k.this;
            c9403k.f46980g = (c9403k.f46980g + 1) % C9403k.this.f46979f.f46920c.length;
            C9403k.this.f46981h = true;
        }
    }

    /* renamed from: e3.k$b */
    public class b extends Property<C9403k, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(C9403k c9403k) {
            return Float.valueOf(c9403k.m58939n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(C9403k c9403k, Float f10) {
            c9403k.m58944r(f10.floatValue());
        }
    }

    public C9403k(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f46980g = 1;
        this.f46979f = linearProgressIndicatorSpec;
        this.f46978e = new C12269b();
    }

    /* renamed from: n */
    public float m58939n() {
        return this.f46982i;
    }

    /* renamed from: o */
    private void m58940o() {
        if (this.f46977d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f46976j, 0.0f, 1.0f);
            this.f46977d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f46977d.setInterpolator(null);
            this.f46977d.setRepeatCount(-1);
            this.f46977d.addListener(new a());
        }
    }

    /* renamed from: s */
    private void m58941s(int i10) {
        this.f46969b[0] = 0.0f;
        float fM58926b = m58926b(i10, 0, 667);
        float[] fArr = this.f46969b;
        float interpolation = this.f46978e.getInterpolation(fM58926b);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f46969b;
        float interpolation2 = this.f46978e.getInterpolation(fM58926b + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f46969b[5] = 1.0f;
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: a */
    public void mo58873a() {
        ObjectAnimator objectAnimator = this.f46977d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: c */
    public void mo58874c() {
        m58943q();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: d */
    public void mo58875d(AbstractC0002a abstractC0002a) {
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: f */
    public void mo58876f() {
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: g */
    public void mo58877g() {
        m58940o();
        m58943q();
        this.f46977d.start();
    }

    @Override // p246e3.AbstractC9400h
    /* renamed from: h */
    public void mo58878h() {
    }

    /* renamed from: p */
    public final void m58942p() {
        if (!this.f46981h || this.f46969b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.f46970c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = C13689a.m82287a(this.f46979f.f46920c[this.f46980g], this.f46968a.getAlpha());
        this.f46981h = false;
    }

    /* renamed from: q */
    public void m58943q() {
        this.f46981h = true;
        this.f46980g = 1;
        Arrays.fill(this.f46970c, C13689a.m82287a(this.f46979f.f46920c[0], this.f46968a.getAlpha()));
    }

    /* renamed from: r */
    public void m58944r(float f10) {
        this.f46982i = f10;
        m58941s((int) (f10 * 333.0f));
        m58942p();
        this.f46968a.invalidateSelf();
    }
}
