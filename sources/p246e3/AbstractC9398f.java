package p246e3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p002a1.AbstractC0002a;
import p666u2.C13110a;

/* renamed from: e3.f */
/* loaded from: classes.dex */
public abstract class AbstractC9398f extends Drawable implements Animatable {

    /* renamed from: o */
    public static final Property<AbstractC9398f, Float> f46949o = new c(Float.class, "growFraction");

    /* renamed from: a */
    public final Context f46950a;

    /* renamed from: b */
    public final AbstractC9394b f46951b;

    /* renamed from: d */
    public ValueAnimator f46953d;

    /* renamed from: e */
    public ValueAnimator f46954e;

    /* renamed from: f */
    public boolean f46955f;

    /* renamed from: g */
    public boolean f46956g;

    /* renamed from: h */
    public float f46957h;

    /* renamed from: i */
    public List<AbstractC0002a> f46958i;

    /* renamed from: j */
    public AbstractC0002a f46959j;

    /* renamed from: k */
    public boolean f46960k;

    /* renamed from: l */
    public float f46961l;

    /* renamed from: n */
    public int f46963n;

    /* renamed from: m */
    public final Paint f46962m = new Paint();

    /* renamed from: c */
    public C9393a f46952c = new C9393a();

    /* renamed from: e3.f$a */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            AbstractC9398f.this.m58915e();
        }
    }

    /* renamed from: e3.f$b */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            AbstractC9398f.super.setVisible(false, false);
            AbstractC9398f.this.m58914d();
        }
    }

    /* renamed from: e3.f$c */
    public class c extends Property<AbstractC9398f, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(AbstractC9398f abstractC9398f) {
            return Float.valueOf(abstractC9398f.m58917g());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(AbstractC9398f abstractC9398f, Float f10) {
            abstractC9398f.m58919m(f10.floatValue());
        }
    }

    public AbstractC9398f(Context context, AbstractC9394b abstractC9394b) {
        this.f46950a = context;
        this.f46951b = abstractC9394b;
        setAlpha(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: d */
    public final void m58914d() {
        AbstractC0002a abstractC0002a = this.f46959j;
        if (abstractC0002a != null) {
            abstractC0002a.mo2a(this);
        }
        List<AbstractC0002a> list = this.f46958i;
        if (list == null || this.f46960k) {
            return;
        }
        Iterator<AbstractC0002a> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo2a(this);
        }
    }

    /* renamed from: e */
    public final void m58915e() {
        AbstractC0002a abstractC0002a = this.f46959j;
        if (abstractC0002a != null) {
            abstractC0002a.m3b(this);
        }
        List<AbstractC0002a> list = this.f46958i;
        if (list == null || this.f46960k) {
            return;
        }
        Iterator<AbstractC0002a> it = list.iterator();
        while (it.hasNext()) {
            it.next().m3b(this);
        }
    }

    /* renamed from: f */
    public final void m58916f(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f46960k;
        this.f46960k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f46960k = z10;
    }

    /* renamed from: g */
    public float m58917g() {
        if (this.f46951b.m58857b() || this.f46951b.m58856a()) {
            return (this.f46956g || this.f46955f) ? this.f46957h : this.f46961l;
        }
        return 1.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f46963n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: h */
    public boolean mo58896h() {
        return mo58900p(false, false, false);
    }

    /* renamed from: i */
    public boolean mo58897i() {
        ValueAnimator valueAnimator = this.f46954e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f46956g;
    }

    public boolean isRunning() {
        return mo58898j() || mo58897i();
    }

    /* renamed from: j */
    public boolean mo58898j() {
        ValueAnimator valueAnimator = this.f46953d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f46955f;
    }

    /* renamed from: k */
    public final void m58918k() {
        if (this.f46953d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f46949o, 0.0f, 1.0f);
            this.f46953d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f46953d.setInterpolator(C13110a.f59598b);
            m58921o(this.f46953d);
        }
        if (this.f46954e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f46949o, 1.0f, 0.0f);
            this.f46954e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f46954e.setInterpolator(C13110a.f59598b);
            m58920n(this.f46954e);
        }
    }

    /* renamed from: l */
    public void mo58899l(AbstractC0002a abstractC0002a) {
        if (this.f46958i == null) {
            this.f46958i = new ArrayList();
        }
        if (this.f46958i.contains(abstractC0002a)) {
            return;
        }
        this.f46958i.add(abstractC0002a);
    }

    /* renamed from: m */
    public void m58919m(float f10) {
        if (this.f46961l != f10) {
            this.f46961l = f10;
            invalidateSelf();
        }
    }

    /* renamed from: n */
    public final void m58920n(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f46954e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f46954e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    /* renamed from: o */
    public final void m58921o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f46953d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f46953d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    /* renamed from: p */
    public boolean mo58900p(boolean z10, boolean z11, boolean z12) {
        return mo58901q(z10, z11, z12 && this.f46952c.m58855a(this.f46950a.getContentResolver()) > 0.0f);
    }

    /* renamed from: q */
    public boolean mo58901q(boolean z10, boolean z11, boolean z12) {
        m58918k();
        if (!isVisible() && !z10) {
            return false;
        }
        ValueAnimator valueAnimator = z10 ? this.f46953d : this.f46954e;
        if (!z12) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                m58916f(valueAnimator);
            }
            return super.setVisible(z10, false);
        }
        if (z12 && valueAnimator.isRunning()) {
            return false;
        }
        boolean z13 = !z10 || super.setVisible(z10, false);
        if (!(z10 ? this.f46951b.m58857b() : this.f46951b.m58856a())) {
            m58916f(valueAnimator);
            return z13;
        }
        if (z11 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z13;
    }

    /* renamed from: r */
    public boolean mo58902r(AbstractC0002a abstractC0002a) {
        List<AbstractC0002a> list = this.f46958i;
        if (list == null || !list.contains(abstractC0002a)) {
            return false;
        }
        this.f46958i.remove(abstractC0002a);
        if (!this.f46958i.isEmpty()) {
            return true;
        }
        this.f46958i = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f46963n = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f46962m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return mo58900p(z10, z11, true);
    }

    public void start() {
        mo58901q(true, true, false);
    }

    public void stop() {
        mo58901q(false, true, false);
    }
}
