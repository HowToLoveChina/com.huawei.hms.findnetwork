package p542p2;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import p564q2.InterfaceC12275b;

/* renamed from: p2.e */
/* loaded from: classes.dex */
public abstract class AbstractC12078e<Z> extends AbstractC12083j<ImageView, Z> implements InterfaceC12275b.a {

    /* renamed from: i */
    public Animatable f55896i;

    public AbstractC12078e(ImageView imageView) {
        super(imageView);
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: c */
    public void mo53348c(Z z10, InterfaceC12275b<? super Z> interfaceC12275b) {
        if (interfaceC12275b == null || !interfaceC12275b.mo73799a(z10, this)) {
            m72235p(z10);
        } else {
            m72233m(z10);
        }
    }

    @Override // p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: f */
    public void mo72226f(Drawable drawable) {
        super.mo72226f(drawable);
        m72235p(null);
        m72234n(drawable);
    }

    @Override // p542p2.AbstractC12083j, p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: g */
    public void mo72227g(Drawable drawable) {
        super.mo72227g(drawable);
        m72235p(null);
        m72234n(drawable);
    }

    @Override // p542p2.AbstractC12083j, p542p2.AbstractC12074a, p542p2.InterfaceC12082i
    /* renamed from: h */
    public void mo66338h(Drawable drawable) {
        super.mo66338h(drawable);
        Animatable animatable = this.f55896i;
        if (animatable != null) {
            animatable.stop();
        }
        m72235p(null);
        m72234n(drawable);
    }

    /* renamed from: m */
    public final void m72233m(Z z10) {
        if (!(z10 instanceof Animatable)) {
            this.f55896i = null;
            return;
        }
        Animatable animatable = (Animatable) z10;
        this.f55896i = animatable;
        animatable.start();
    }

    /* renamed from: n */
    public void m72234n(Drawable drawable) {
        ((ImageView) this.f55901b).setImageDrawable(drawable);
    }

    /* renamed from: o */
    public abstract void mo72228o(Z z10);

    @Override // p542p2.AbstractC12074a, com.bumptech.glide.manager.InterfaceC1615m
    public void onStart() {
        Animatable animatable = this.f55896i;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // p542p2.AbstractC12074a, com.bumptech.glide.manager.InterfaceC1615m
    public void onStop() {
        Animatable animatable = this.f55896i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* renamed from: p */
    public final void m72235p(Z z10) {
        mo72228o(z10);
        m72233m(z10);
    }
}
