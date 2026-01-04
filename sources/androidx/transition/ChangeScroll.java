package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* renamed from: K */
    public static final String[] f4703K = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    /* renamed from: j0 */
    private void m5653j0(C0959t c0959t) {
        c0959t.f4888a.put("android:changeScroll:x", Integer.valueOf(c0959t.f4889b.getScrollX()));
        c0959t.f4888a.put("android:changeScroll:y", Integer.valueOf(c0959t.f4889b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    /* renamed from: G */
    public String[] mo5617G() {
        return f4703K;
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m5653j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m5653j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (c0959t == null || c0959t2 == null) {
            return null;
        }
        View view = c0959t2.f4889b;
        int iIntValue = ((Integer) c0959t.f4888a.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) c0959t2.f4888a.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) c0959t.f4888a.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) c0959t2.f4888a.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return C0958s.m5839c(objectAnimatorOfInt, objectAnimatorOfInt2);
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
