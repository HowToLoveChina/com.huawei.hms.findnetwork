package com.huawei.uikit.animations.drawable;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.uikit.animations.interpolator.HwInterpolatorBuilder;
import com.huawei.uikit.hwanimations.C8701R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes6.dex */
public class HwHoverAndPressAnimatedDrawable extends GradientDrawable {
    private static final int DURATION_HOVER = 250;
    private static final int DURATION_PRESS = 100;
    private static final int INVALID_SIZE = -1;
    private ObjectAnimator mAlphaEnterAnim;
    private ObjectAnimator mAlphaExitAnim;
    private Interpolator mHoveredInterpolator;
    private boolean mIsHovered;
    private boolean mIsPressed;
    private Interpolator mPressedInterpolator;
    private aauaf mState;

    public static class aauaf extends Drawable.ConstantState {

        /* renamed from: a */
        boolean f40925a;

        /* renamed from: b */
        int f40926b;

        /* renamed from: c */
        int f40927c;

        /* renamed from: d */
        int f40928d;

        /* renamed from: e */
        ColorStateList f40929e;

        /* renamed from: f */
        int f40930f;

        /* renamed from: g */
        float f40931g;

        /* renamed from: h */
        float[] f40932h;

        /* renamed from: i */
        int f40933i;

        /* renamed from: j */
        int f40934j;

        /* renamed from: a */
        private static int m53753a(Resources resources, int i10) {
            if (resources != null) {
                i10 = resources.getDisplayMetrics().densityDpi;
            }
            return i10 == 0 ? RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE : i10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new HwHoverAndPressAnimatedDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            if (m53753a(resources, this.f40928d) != this.f40928d) {
                this = new aauaf(this, resources);
            }
            return new HwHoverAndPressAnimatedDrawable(this);
        }

        private aauaf() {
            this.f40925a = false;
            this.f40928d = RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE;
            this.f40930f = 0;
            this.f40931g = 0.0f;
            this.f40932h = null;
            this.f40933i = -1;
            this.f40934j = -1;
        }

        private aauaf(aauaf aauafVar, Resources resources) {
            this.f40925a = false;
            this.f40928d = RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE;
            this.f40930f = 0;
            this.f40931g = 0.0f;
            this.f40932h = null;
            this.f40933i = -1;
            this.f40934j = -1;
            this.f40930f = aauafVar.f40930f;
            this.f40931g = aauafVar.f40931g;
            float[] fArr = aauafVar.f40932h;
            if (fArr != null) {
                this.f40932h = (float[]) fArr.clone();
            }
            this.f40929e = aauafVar.f40929e;
            this.f40933i = aauafVar.f40933i;
            this.f40934j = aauafVar.f40934j;
            this.f40927c = aauafVar.f40927c;
            this.f40926b = aauafVar.f40926b;
            this.f40925a = aauafVar.f40925a;
            this.f40928d = m53753a(resources, aauafVar.f40928d);
        }
    }

    private void clearEffect() {
        ObjectAnimator objectAnimator = this.mAlphaEnterAnim;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mAlphaEnterAnim.end();
        }
        ObjectAnimator objectAnimator2 = this.mAlphaExitAnim;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.mAlphaExitAnim.end();
        }
        this.mAlphaExitAnim = null;
        this.mAlphaEnterAnim = null;
        this.mIsHovered = false;
        this.mIsPressed = false;
        setAlpha(0);
        invalidateSelf();
    }

    private void preInflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, C8701R.styleable.HwHoverAndPressEffect) : theme.obtainStyledAttributes(attributeSet, C8701R.styleable.HwHoverAndPressEffect, 0, 0);
        int color = typedArrayObtainAttributes.getColor(C8701R.styleable.HwHoverAndPressEffect_hwHoveredColor, 0);
        int color2 = typedArrayObtainAttributes.getColor(C8701R.styleable.HwHoverAndPressEffect_hwPressedColor, 0);
        if (color2 != 0) {
            this.mState.f40925a = true;
        }
        int iAlpha = Color.alpha(color);
        int iAlpha2 = Color.alpha(color2);
        this.mState.f40929e = ColorStateList.valueOf(this.mState.f40925a ? Color.rgb(Color.red(color2), Color.green(color2), Color.blue(color2)) : Color.rgb(Color.red(color), Color.green(color), Color.blue(color)));
        aauaf aauafVar = this.mState;
        aauafVar.f40927c = iAlpha;
        aauafVar.f40926b = iAlpha2;
        typedArrayObtainAttributes.recycle();
    }

    private void setHoveredAnimation(boolean z10) {
        if (this.mIsHovered != z10) {
            this.mIsHovered = z10;
            if (!z10) {
                startExitAnim(0, 250, this.mHoveredInterpolator);
            } else {
                if (this.mIsPressed) {
                    return;
                }
                startEnterAnim(this.mState.f40927c, 250, this.mHoveredInterpolator);
            }
        }
    }

    private void setPressedAnimation(boolean z10) {
        if (this.mIsPressed != z10) {
            this.mIsPressed = z10;
            if (z10) {
                startEnterAnim(this.mState.f40926b, 100, this.mPressedInterpolator);
            } else {
                startExitAnim(this.mIsHovered ? this.mState.f40927c : 0, 100, this.mPressedInterpolator);
            }
        }
    }

    private void startEnterAnim(int i10, int i11, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, TopAnimatorConfig.AnimatorType.ALPHA, i10);
        this.mAlphaEnterAnim = objectAnimatorOfInt;
        objectAnimatorOfInt.setAutoCancel(true);
        this.mAlphaEnterAnim.setDuration(i11);
        this.mAlphaEnterAnim.setInterpolator(interpolator);
        this.mAlphaEnterAnim.start();
    }

    private void startExitAnim(int i10, int i11, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, TopAnimatorConfig.AnimatorType.ALPHA, i10);
        this.mAlphaExitAnim = objectAnimatorOfInt;
        objectAnimatorOfInt.setAutoCancel(true);
        this.mAlphaExitAnim.setDuration(i11);
        this.mAlphaExitAnim.setInterpolator(interpolator);
        this.mAlphaExitAnim.start();
    }

    private void updateLocalStates() {
        this.mState.f40931g = getCornerRadius();
        this.mState.f40930f = getShape();
        this.mState.f40933i = getIntrinsicWidth();
        this.mState.f40934j = getIntrinsicHeight();
        try {
            this.mState.f40932h = getCornerRadii();
        } catch (NullPointerException unused) {
            this.mState.f40932h = null;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getColor() != null && this.mState.f40929e != null && getColor().getDefaultColor() != this.mState.f40929e.getDefaultColor()) {
            setColor(this.mState.f40929e);
        }
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        preInflate(resources, attributeSet, theme);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        setColor(this.mState.f40929e);
        updateLocalStates();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (super.mutate() == this) {
            aauaf aauafVar = new aauaf(this.mState, null);
            this.mState = aauafVar;
            aauafVar.f40929e = getColor();
            updateLocalStates();
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onStateChange(int[] r9) {
        /*
            r8 = this;
            int r0 = r9.length
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L5:
            r5 = 1
            if (r1 >= r0) goto L27
            r6 = r9[r1]
            r7 = 16842910(0x101009e, float:2.3694E-38)
            if (r6 != r7) goto L10
            goto L23
        L10:
            r7 = 16842919(0x10100a7, float:2.3694026E-38)
            if (r6 != r7) goto L17
            r4 = r5
            goto L24
        L17:
            r7 = 16843623(0x1010367, float:2.3696E-38)
            if (r6 != r7) goto L1e
            r3 = r5
            goto L24
        L1e:
            r7 = 16842908(0x101009c, float:2.3693995E-38)
            if (r6 != r7) goto L24
        L23:
            r2 = r5
        L24:
            int r1 = r1 + 1
            goto L5
        L27:
            if (r2 != 0) goto L2d
            r8.clearEffect()
            return r5
        L2d:
            r8.setHoveredAnimation(r3)
            com.huawei.uikit.animations.drawable.HwHoverAndPressAnimatedDrawable$aauaf r9 = r8.mState
            boolean r9 = r9.f40925a
            if (r9 == 0) goto L39
            r8.setPressedAnimation(r4)
        L39:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.animations.drawable.HwHoverAndPressAnimatedDrawable.onStateChange(int[]):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (!z10) {
            clearEffect();
        }
        return visible;
    }

    public HwHoverAndPressAnimatedDrawable() {
        this(new aauaf());
    }

    private HwHoverAndPressAnimatedDrawable(aauaf aauafVar) {
        this.mHoveredInterpolator = HwInterpolatorBuilder.createFrictionCurveInterpolator();
        this.mPressedInterpolator = HwInterpolatorBuilder.createSharpCurveInterpolator();
        this.mIsHovered = false;
        this.mIsPressed = false;
        this.mState = aauafVar;
        setShape(aauafVar.f40930f);
        setSize(aauafVar.f40933i, aauafVar.f40934j);
        setBounds(new Rect(0, 0, aauafVar.f40933i, aauafVar.f40934j));
        setColor(aauafVar.f40929e);
        float[] fArr = aauafVar.f40932h;
        if (this.mState.f40932h == null) {
            setCornerRadius(aauafVar.f40931g);
        } else {
            setCornerRadii(fArr);
        }
        setAlpha(0);
    }
}
