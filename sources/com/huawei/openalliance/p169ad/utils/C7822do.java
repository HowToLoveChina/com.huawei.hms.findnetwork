package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.C6982bz;

/* renamed from: com.huawei.openalliance.ad.utils.do */
/* loaded from: classes2.dex */
public class C7822do {
    /* renamed from: a */
    public static void m48379a(Context context, int i10, int i11, boolean z10, int i12, int i13, RelativeLayout.LayoutParams layoutParams) {
        int iM48326f;
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.rightMargin = i12;
        layoutParams.setMarginEnd(i12);
        layoutParams.topMargin = i13;
        if (i11 != 0) {
            layoutParams.topMargin = i13 + i10;
            return;
        }
        if (!z10) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + i10);
            layoutParams.rightMargin += i10;
        }
        if (C6982bz.m41152b(context)) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + AbstractC7811dd.m48326f(context));
            iM48326f = layoutParams.rightMargin + AbstractC7811dd.m48326f(context);
        } else {
            layoutParams.setMarginEnd(AbstractC7811dd.m48326f(context));
            iM48326f = AbstractC7811dd.m48326f(context);
        }
        layoutParams.rightMargin = iM48326f;
        layoutParams.topMargin += AbstractC7741ao.m47535a(context, 12.0f);
    }

    /* renamed from: a */
    public static void m48380a(ViewGroup viewGroup) {
        boolean z10;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 < childCount) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt != null && childAt.getVisibility() == 0) {
                    z10 = true;
                    break;
                }
                i11++;
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10 || viewGroup.getVisibility() == 0) {
            if (z10) {
                return;
            }
            i10 = 8;
            if (viewGroup.getVisibility() == 8) {
                return;
            }
        }
        viewGroup.setVisibility(i10);
    }

    /* renamed from: a */
    public static void m48381a(ProgressBar progressBar, int i10) {
        if (progressBar != null) {
            if (i10 == 100) {
                progressBar.setVisibility(8);
                return;
            }
            if (progressBar.getVisibility() == 8) {
                progressBar.setVisibility(0);
            }
            progressBar.setProgress(i10);
        }
    }

    /* renamed from: a */
    public static boolean m48382a(int i10, int i11, float f10, float f11) {
        if (i10 != 0 || f11 < i11) {
            return 1 == i10 && Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) i11);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m48383a(View view, int i10, int i11, int i12) {
        if (view == null || view.getVisibility() == i10) {
            return false;
        }
        view.setVisibility(i10);
        boolean z10 = i10 == 0;
        float f10 = z10 ? 0.0f : 1.0f;
        float f11 = z10 ? 1.0f : 0.0f;
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f10, f11);
        alphaAnimation.setDuration(i11);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        if (i12 > 0) {
            alphaAnimation.setStartOffset(i12);
        }
        view.startAnimation(alphaAnimation);
        return true;
    }

    /* renamed from: a */
    public static boolean m48384a(View view, boolean z10) {
        int i10 = z10 ? 0 : 8;
        if (view == null || view.getVisibility() == i10) {
            return false;
        }
        view.setVisibility(i10);
        return true;
    }
}
