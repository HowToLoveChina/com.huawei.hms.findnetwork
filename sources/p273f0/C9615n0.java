package p273f0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: f0.n0 */
/* loaded from: classes.dex */
public final class C9615n0 {

    /* renamed from: a */
    public final WeakReference<View> f47726a;

    /* renamed from: b */
    public Runnable f47727b = null;

    /* renamed from: c */
    public Runnable f47728c = null;

    /* renamed from: d */
    public int f47729d = -1;

    /* renamed from: f0.n0$a */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9617o0 f47730a;

        /* renamed from: b */
        public final /* synthetic */ View f47731b;

        public a(InterfaceC9617o0 interfaceC9617o0, View view) {
            this.f47730a = interfaceC9617o0;
            this.f47731b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f47730a.mo2522a(this.f47731b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f47730a.mo2156b(this.f47731b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f47730a.mo2157c(this.f47731b);
        }
    }

    /* renamed from: f0.n0$b */
    public static class b {
        /* renamed from: a */
        public static ViewPropertyAnimator m60119a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    public C9615n0(View view) {
        this.f47726a = new WeakReference<>(view);
    }

    /* renamed from: b */
    public C9615n0 m60108b(float f10) {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    /* renamed from: c */
    public void m60109c() {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: d */
    public long m60110d() {
        View view = this.f47726a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* renamed from: f */
    public C9615n0 m60111f(long j10) {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    /* renamed from: g */
    public C9615n0 m60112g(Interpolator interpolator) {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: h */
    public C9615n0 m60113h(InterfaceC9617o0 interfaceC9617o0) {
        View view = this.f47726a.get();
        if (view != null) {
            m60114i(view, interfaceC9617o0);
        }
        return this;
    }

    /* renamed from: i */
    public final void m60114i(View view, InterfaceC9617o0 interfaceC9617o0) {
        if (interfaceC9617o0 != null) {
            view.animate().setListener(new a(interfaceC9617o0, view));
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: j */
    public C9615n0 m60115j(long j10) {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    /* renamed from: k */
    public C9615n0 m60116k(final InterfaceC9621q0 interfaceC9621q0) {
        final View view = this.f47726a.get();
        if (view != null) {
            b.m60119a(view.animate(), interfaceC9621q0 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: f0.m0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    interfaceC9621q0.mo2284a(view);
                }
            } : null);
        }
        return this;
    }

    /* renamed from: l */
    public void m60117l() {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: m */
    public C9615n0 m60118m(float f10) {
        View view = this.f47726a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
