package com.huawei.uikit.hwrecyclerview.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwanimations.C8701R;
import com.huawei.uikit.hwgraphiceffect.widget.HwShadowEngine;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import java.util.List;

/* loaded from: classes4.dex */
public class HwItemTouchHelper extends HwItemTouchHelperEx {
    public static final int TYPE_HEADER = 1;

    /* renamed from: e0 */
    private static final int f43491e0 = 150;

    /* renamed from: f0 */
    private static final float f43492f0 = 0.05f;

    /* renamed from: g0 */
    private static final int f43493g0 = 2;

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ HwItemTouchHelperEx.Callback f43494a;

        /* renamed from: b */
        final /* synthetic */ View f43495b;

        /* renamed from: c */
        final /* synthetic */ HwShadowEngine f43496c;

        public bzrwd(HwItemTouchHelperEx.Callback callback, View view, HwShadowEngine hwShadowEngine) {
            this.f43494a = callback;
            this.f43495b = view;
            this.f43496c = hwShadowEngine;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.05f) + 1.0f;
            this.f43494a.updateSelectedScale(fFloatValue);
            this.f43495b.setScaleX(fFloatValue);
            this.f43495b.setScaleY(fFloatValue);
            HwShadowEngine hwShadowEngine = this.f43496c;
            if (hwShadowEngine != null) {
                hwShadowEngine.setShadowEnabled(true);
            }
        }
    }

    public HwItemTouchHelper(HwItemTouchHelperEx.Callback callback) {
        super(callback);
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx
    public void scaleItemAccordingOverlapping(RecyclerView.AbstractC0833c0 abstractC0833c0, List<RecyclerView.AbstractC0833c0> list, HwItemTouchHelperEx.Callback callback, float f10, float f11) {
        super.scaleItemAccordingOverlapping(abstractC0833c0, list, callback, f10, f11);
        if (abstractC0833c0 == null || list == null || callback == null) {
            return;
        }
        int boundingBoxMargin = callback.getBoundingBoxMargin();
        int iRound = Math.round(f10 + f11) - boundingBoxMargin;
        int height = abstractC0833c0.f4327a.getHeight() + iRound + (boundingBoxMargin * 2);
        for (int i10 = 0; i10 < list.size(); i10++) {
            View view = list.get(i10).f4327a;
            int height2 = view.getHeight();
            int bottom = (iRound >= view.getBottom() || height <= view.getBottom()) ? 0 : view.getBottom() - iRound;
            if (height > view.getTop() && view.getTop() > iRound) {
                bottom = height - view.getTop();
            }
            if (!isMovingToDesignatedPos() && callback.canScaleOverlappedItem(abstractC0833c0)) {
                float f12 = 1.0f - ((bottom / height2) * 0.05f);
                view.setScaleX(f12);
                view.setScaleY(f12);
            }
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx
    public void startDragSelectedAnimation(View view, HwItemTouchHelperEx.Callback callback, HwShadowEngine hwShadowEngine) {
        super.startDragSelectedAnimation(view, callback, hwShadowEngine);
        if (view == null || callback == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), C8701R.interpolator.cubic_bezier_interpolator_type_20_80));
        valueAnimatorOfFloat.addUpdateListener(new bzrwd(callback, view, hwShadowEngine));
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.start();
    }
}
