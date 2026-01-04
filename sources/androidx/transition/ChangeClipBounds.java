package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* renamed from: K */
    public static final String[] f4696K = {"android:clipBounds:clip"};

    /* renamed from: androidx.transition.ChangeClipBounds$a */
    public class C0896a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ View f4697a;

        public C0896a(View view) {
            this.f4697a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C9603h0.m59916w0(this.f4697a, null);
        }
    }

    public ChangeClipBounds() {
    }

    /* renamed from: j0 */
    private void m5643j0(C0959t c0959t) {
        View view = c0959t.f4889b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rectM59909t = C9603h0.m59909t(view);
        c0959t.f4888a.put("android:clipBounds:clip", rectM59909t);
        if (rectM59909t == null) {
            c0959t.f4888a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: G */
    public String[] mo5617G() {
        return f4696K;
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m5643j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m5643j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        ObjectAnimator objectAnimatorOfObject = null;
        if (c0959t != null && c0959t2 != null && c0959t.f4888a.containsKey("android:clipBounds:clip") && c0959t2.f4888a.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) c0959t.f4888a.get("android:clipBounds:clip");
            Rect rect2 = (Rect) c0959t2.f4888a.get("android:clipBounds:clip");
            boolean z10 = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) c0959t.f4888a.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) c0959t2.f4888a.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            C9603h0.m59916w0(c0959t2.f4889b, rect);
            objectAnimatorOfObject = ObjectAnimator.ofObject(c0959t2.f4889b, (Property<View, V>) C0932b0.f4839c, (TypeEvaluator) new C0951l(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z10) {
                objectAnimatorOfObject.addListener(new C0896a(c0959t2.f4889b));
            }
        }
        return objectAnimatorOfObject;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
