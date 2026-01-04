package com.huawei.openalliance.p169ad.views;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;

/* renamed from: com.huawei.openalliance.ad.views.y */
/* loaded from: classes2.dex */
public class C8186y {

    /* renamed from: a */
    private static int f38400a = 80;

    /* renamed from: b */
    private ValueAnimator f38401b;

    /* renamed from: c */
    private AnimatorSet f38402c;

    /* renamed from: d */
    private Bitmap f38403d;

    /* renamed from: e */
    private float f38404e;

    /* renamed from: f */
    private float f38405f;

    /* renamed from: g */
    private float f38406g;

    /* renamed from: h */
    private float f38407h;

    /* renamed from: i */
    private float f38408i;

    /* renamed from: j */
    private float f38409j;

    public C8186y(float[][] fArr, int[] iArr, Bitmap bitmap, final View view) {
        this.f38403d = bitmap;
        this.f38408i = bitmap.getWidth();
        this.f38409j = bitmap.getHeight();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, view.getWidth() * fArr[0][0]), Keyframe.ofFloat(1.0f, (view.getWidth() * fArr[0][1]) - (this.f38408i / 2.0f)));
        Property property = View.TRANSLATION_Y;
        Keyframe[] keyframeArr = new Keyframe[2];
        keyframeArr[0] = Keyframe.ofFloat(0.0f, view.getHeight() * fArr[1][0]);
        keyframeArr[1] = Keyframe.ofFloat(1.0f, fArr[1][1] < 0.0f ? (view.getHeight() * fArr[1][1]) - this.f38409j : view.getHeight() * fArr[1][1]);
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfKeyframe, PropertyValuesHolder.ofKeyframe(property, keyframeArr), PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0.0f, fArr[2][0]), Keyframe.ofFloat(1.0f, fArr[2][1])), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0.0f, fArr[2][0]), Keyframe.ofFloat(1.0f, fArr[2][1])));
        this.f38401b = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.setInterpolator(new InterpolatorC7160gq(1.0f, 0.0f, 1.0f, 1.0f));
        this.f38401b.setDuration(iArr[1] + f38400a);
        this.f38401b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.y.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    C8186y.this.f38404e = ((Float) valueAnimator.getAnimatedValue(View.TRANSLATION_X.getName())).floatValue();
                    C8186y.this.f38405f = ((Float) valueAnimator.getAnimatedValue(View.TRANSLATION_Y.getName())).floatValue();
                    C8186y.this.f38406g = ((Float) valueAnimator.getAnimatedValue(View.SCALE_X.getName())).floatValue();
                    C8186y.this.f38407h = ((Float) valueAnimator.getAnimatedValue(View.SCALE_Y.getName())).floatValue();
                    view.postInvalidate();
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("ParticleAnimator", "onAnimationUpdate: %s", th2.getClass().getSimpleName());
                }
            }
        });
        this.f38402c = new AnimatorSet();
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f));
        ValueAnimator valueAnimatorOfPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfKeyframe2);
        valueAnimatorOfPropertyValuesHolder2.setDuration(iArr[0]);
        ValueAnimator valueAnimatorOfPropertyValuesHolder3 = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfKeyframe2);
        valueAnimatorOfPropertyValuesHolder3.setDuration(((1400 - iArr[0]) - iArr[1]) - f38400a);
        this.f38402c.playSequentially(valueAnimatorOfPropertyValuesHolder2, this.f38401b, valueAnimatorOfPropertyValuesHolder3);
    }

    /* renamed from: b */
    public float m50716b() {
        return this.f38404e;
    }

    /* renamed from: c */
    public float m50717c() {
        return this.f38405f;
    }

    /* renamed from: d */
    public float m50718d() {
        return this.f38404e + (this.f38408i * this.f38406g);
    }

    /* renamed from: e */
    public float m50719e() {
        return this.f38405f + (this.f38409j * this.f38407h);
    }

    /* renamed from: f */
    public Bitmap m50720f() {
        return this.f38403d;
    }

    /* renamed from: a */
    public AnimatorSet m50715a() {
        return this.f38402c;
    }
}
