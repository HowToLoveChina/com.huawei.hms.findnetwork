package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.C1784o;

/* renamed from: com.google.android.material.appbar.b */
/* loaded from: classes.dex */
public class C1650b {

    /* renamed from: a */
    public static final int[] f7455a = {R.attr.stateListAnimator};

    /* renamed from: a */
    public static void m9606a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* renamed from: b */
    public static void m9607b(View view, float f10) throws Resources.NotFoundException {
        int integer = view.getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j10 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j10));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f10).setDuration(j10));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    /* renamed from: c */
    public static void m9608c(View view, AttributeSet attributeSet, int i10, int i11) {
        Context context = view.getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, f7455a, i10, i11, new int[0]);
        try {
            if (typedArrayM10770h.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayM10770h.getResourceId(0, 0)));
            }
        } finally {
            typedArrayM10770h.recycle();
        }
    }
}
