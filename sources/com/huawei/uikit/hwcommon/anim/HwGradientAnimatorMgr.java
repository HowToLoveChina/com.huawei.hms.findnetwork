package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.util.Pair;
import androidx.annotation.Keep;
import com.huawei.uikit.hwcommon.drawable.HwDrawableWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public class HwGradientAnimatorMgr implements HwDrawableWrapper.OnStateChangedListener {

    /* renamed from: d */
    private static final int f42032d = 50;

    /* renamed from: e */
    private static final int f42033e = 16;

    /* renamed from: a */
    private Map<String, Pair<Integer, Integer>> f42034a = new HashMap(16);

    /* renamed from: b */
    private OnAnimatorListener f42035b;

    /* renamed from: c */
    private Animator f42036c;

    public interface OnAnimatorListener {
        void onAnimationCancel(Animator animator, String str);

        void onAnimationEnd(Animator animator, String str);

        void onAnimationStart(Animator animator, String str);

        void onAnimationUpdate(Animator animator, String str, int i10);

        boolean onPrepareAnimation(int[] iArr, int[] iArr2, int i10, int i11, Map<String, Pair<Integer, Integer>> map);
    }

    public class bzrwd implements Animator.AnimatorListener {
        public bzrwd() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (HwGradientAnimatorMgr.this.f42035b != null) {
                Iterator it = HwGradientAnimatorMgr.this.f42034a.keySet().iterator();
                while (it.hasNext()) {
                    HwGradientAnimatorMgr.this.f42035b.onAnimationCancel(animator, (String) it.next());
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HwGradientAnimatorMgr.this.f42035b != null) {
                Iterator it = HwGradientAnimatorMgr.this.f42034a.keySet().iterator();
                while (it.hasNext()) {
                    HwGradientAnimatorMgr.this.f42035b.onAnimationEnd(animator, (String) it.next());
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (HwGradientAnimatorMgr.this.f42035b != null) {
                Iterator it = HwGradientAnimatorMgr.this.f42034a.keySet().iterator();
                while (it.hasNext()) {
                    HwGradientAnimatorMgr.this.f42035b.onAnimationStart(animator, (String) it.next());
                }
            }
        }
    }

    public Animator getAnimator(Map<String, Pair<Integer, Integer>> map) {
        this.f42034a = map;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "GradientValue", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(HwFocusClickAnimatorUtil.getFrictionInterpolator());
        objectAnimatorOfFloat.setDuration(50L);
        objectAnimatorOfFloat.addListener(new bzrwd());
        return objectAnimatorOfFloat;
    }

    public OnAnimatorListener getOnAnimatorListener() {
        return this.f42035b;
    }

    @Override // com.huawei.uikit.hwcommon.drawable.HwDrawableWrapper.OnStateChangedListener
    public void onStateChanged(int[] iArr, int[] iArr2, int i10, int i11) {
        if (this.f42035b == null || iArr == null || iArr2 == null) {
            return;
        }
        HashMap map = new HashMap(16);
        if (this.f42035b.onPrepareAnimation(iArr, iArr2, i10, i11, map)) {
            Animator animator = this.f42036c;
            if (animator != null && animator.isRunning()) {
                this.f42036c.cancel();
            }
            Animator animator2 = getAnimator(map);
            this.f42036c = animator2;
            animator2.start();
        }
    }

    @Keep
    public void setGradientValue(float f10) {
        if (this.f42035b == null || this.f42036c == null) {
            return;
        }
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        for (Map.Entry<String, Pair<Integer, Integer>> entry : this.f42034a.entrySet()) {
            Pair<Integer, Integer> value = entry.getValue();
            this.f42035b.onAnimationUpdate(this.f42036c, entry.getKey(), ((Integer) argbEvaluator.evaluate(f10, value.first, value.second)).intValue());
        }
    }

    public void setOnAnimatorListener(OnAnimatorListener onAnimatorListener) {
        this.f42035b = onAnimatorListener;
    }
}
