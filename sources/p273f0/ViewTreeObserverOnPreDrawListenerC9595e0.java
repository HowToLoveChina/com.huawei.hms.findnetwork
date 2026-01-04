package p273f0;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: f0.e0 */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC9595e0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final View f47701a;

    /* renamed from: b */
    public ViewTreeObserver f47702b;

    /* renamed from: c */
    public final Runnable f47703c;

    public ViewTreeObserverOnPreDrawListenerC9595e0(View view, Runnable runnable) {
        this.f47701a = view;
        this.f47702b = view.getViewTreeObserver();
        this.f47703c = runnable;
    }

    /* renamed from: a */
    public static ViewTreeObserverOnPreDrawListenerC9595e0 m59820a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC9595e0 viewTreeObserverOnPreDrawListenerC9595e0 = new ViewTreeObserverOnPreDrawListenerC9595e0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC9595e0);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC9595e0);
        return viewTreeObserverOnPreDrawListenerC9595e0;
    }

    /* renamed from: b */
    public void m59821b() {
        if (this.f47702b.isAlive()) {
            this.f47702b.removeOnPreDrawListener(this);
        } else {
            this.f47701a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f47701a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m59821b();
        this.f47703c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f47702b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m59821b();
    }
}
