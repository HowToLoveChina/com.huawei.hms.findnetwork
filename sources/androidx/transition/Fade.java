package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class Fade extends Visibility {

    /* renamed from: androidx.transition.Fade$a */
    public class C0906a extends C0955p {

        /* renamed from: a */
        public final /* synthetic */ View f4737a;

        public C0906a(View view) {
            this.f4737a = view;
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            C0932b0.m5791h(this.f4737a, 1.0f);
            C0932b0.m5784a(this.f4737a);
            transition.mo5721V(this);
        }
    }

    /* renamed from: androidx.transition.Fade$b */
    public static class C0907b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final View f4739a;

        /* renamed from: b */
        public boolean f4740b = false;

        public C0907b(View view) {
            this.f4739a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0932b0.m5791h(this.f4739a, 1.0f);
            if (this.f4740b) {
                this.f4739a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (C9603h0.m59860P(this.f4739a) && this.f4739a.getLayerType() == 0) {
                this.f4740b = true;
                this.f4739a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i10) {
        m5775q0(i10);
    }

    /* renamed from: s0 */
    public static float m5677s0(C0959t c0959t, float f10) {
        Float f11;
        return (c0959t == null || (f11 = (Float) c0959t.f4888a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        super.mo5621l(c0959t);
        c0959t.f4888a.put("android:fade:transitionAlpha", Float.valueOf(C0932b0.m5786c(c0959t.f4889b)));
    }

    @Override // androidx.transition.Visibility
    /* renamed from: m0 */
    public Animator mo5674m0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        float fM5677s0 = m5677s0(c0959t, 0.0f);
        return m5678r0(view, fM5677s0 != 1.0f ? fM5677s0 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    /* renamed from: o0 */
    public Animator mo5675o0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        C0932b0.m5788e(view);
        return m5678r0(view, m5677s0(c0959t, 1.0f), 0.0f);
    }

    /* renamed from: r0 */
    public final Animator m5678r0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        C0932b0.m5791h(view, f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, C0932b0.f4838b, f11);
        objectAnimatorOfFloat.addListener(new C0907b(view));
        mo5726a(new C0906a(view));
        return objectAnimatorOfFloat;
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4869f);
        m5775q0(TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, m5771k0()));
        typedArrayObtainStyledAttributes.recycle();
    }
}
