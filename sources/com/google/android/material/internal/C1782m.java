package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.C0959t;
import androidx.transition.Transition;
import java.util.Map;

/* renamed from: com.google.android.material.internal.m */
/* loaded from: classes.dex */
public class C1782m extends Transition {

    /* renamed from: com.google.android.material.internal.m$a */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ TextView f8402a;

        public a(TextView textView) {
            this.f8402a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f8402a.setScaleX(fFloatValue);
            this.f8402a.setScaleY(fFloatValue);
        }
    }

    /* renamed from: j0 */
    private void m10762j0(C0959t c0959t) {
        View view = c0959t.f4889b;
        if (view instanceof TextView) {
            c0959t.f4888a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m10762j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m10762j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        if (c0959t == null || c0959t2 == null || !(c0959t.f4889b instanceof TextView)) {
            return null;
        }
        View view = c0959t2.f4889b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = c0959t.f4888a;
        Map<String, Object> map2 = c0959t2.f4888a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
