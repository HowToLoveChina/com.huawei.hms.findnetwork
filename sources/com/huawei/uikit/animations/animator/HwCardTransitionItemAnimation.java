package com.huawei.uikit.animations.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.animation.LinearInterpolator;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
public class HwCardTransitionItemAnimation {

    /* renamed from: A */
    private static final int f40682A = 0;

    /* renamed from: B */
    private static final int f40683B = 1;

    /* renamed from: C */
    private static final int f40684C = 2;

    /* renamed from: D */
    private static final int f40685D = 255;

    /* renamed from: E */
    private static final int f40686E = -1;

    /* renamed from: F */
    private static final float f40687F = 0.0f;

    /* renamed from: G */
    private static final float f40688G = 0.0f;

    /* renamed from: H */
    private static final float f40689H = 0.28f;

    /* renamed from: I */
    private static final float f40690I = 0.57f;

    /* renamed from: J */
    private static final float f40691J = 1.0f;

    /* renamed from: s */
    private static final int f40692s = 350;

    /* renamed from: t */
    private static final float f40693t = 0.2f;

    /* renamed from: u */
    private static final float f40694u = 0.2f;

    /* renamed from: v */
    private static final float f40695v = 0.33f;

    /* renamed from: w */
    private static final float f40696w = 0.67f;

    /* renamed from: x */
    private static final float f40697x = 0.0f;

    /* renamed from: y */
    private static final float f40698y = 1.0f;

    /* renamed from: z */
    private static final int f40699z = 2;

    /* renamed from: b */
    private int f40701b;

    /* renamed from: f */
    private HwCubicBezierInterpolator f40705f;

    /* renamed from: g */
    private HwCubicBezierInterpolator f40706g;

    /* renamed from: h */
    private Drawable f40707h;

    /* renamed from: i */
    private ViewGroup f40708i;

    /* renamed from: j */
    private View f40709j;

    /* renamed from: k */
    private View f40710k;

    /* renamed from: l */
    private ViewGroupOverlay f40711l;

    /* renamed from: o */
    private View f40714o;

    /* renamed from: p */
    private ViewGroup f40715p;

    /* renamed from: q */
    private int[] f40716q;

    /* renamed from: a */
    private float f40700a = 0.0f;

    /* renamed from: c */
    private boolean f40702c = true;

    /* renamed from: d */
    private Set<Integer> f40703d = new HashSet();

    /* renamed from: e */
    private Set<Integer> f40704e = new HashSet();

    /* renamed from: m */
    private RectF f40712m = new RectF();

    /* renamed from: n */
    private RectF f40713n = new RectF();

    /* renamed from: r */
    private final AnimatorListenerAdapter f40717r = new bzrwd();

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ boolean f40718a;

        public aauaf(boolean z10) {
            this.f40718a = z10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || valueAnimator.getDuration() == 0) {
                return;
            }
            float currentPlayTime = valueAnimator.getCurrentPlayTime() / valueAnimator.getDuration();
            HwCardTransitionItemAnimation.this.m53603a(currentPlayTime, this.f40718a);
            HwCardTransitionItemAnimation.this.m53611b(currentPlayTime, this.f40718a);
            if (HwCardTransitionItemAnimation.this.f40702c) {
                HwCardTransitionItemAnimation.this.m53615c(currentPlayTime, this.f40718a);
            }
        }
    }

    public class bzrwd extends AnimatorListenerAdapter {
        public bzrwd() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HwCardTransitionItemAnimation.this.f40711l != null) {
                HwCardTransitionItemAnimation.this.f40711l.remove(HwCardTransitionItemAnimation.this.f40707h);
            }
            if (HwCardTransitionItemAnimation.this.f40709j != null) {
                HwCardTransitionItemAnimation.this.f40709j.setVisibility(0);
            }
            if (HwCardTransitionItemAnimation.this.f40702c) {
                HwCardTransitionItemAnimation.this.m53614c();
            }
        }
    }

    /* renamed from: a */
    private float m53598a(float f10, float f11, float f12) {
        if (f11 >= f10 || f11 >= f12) {
            return 0.0f;
        }
        if (f10 >= f12) {
            return 1.0f;
        }
        return (f10 - f11) / (f12 - f11);
    }

    public void startEnterAnimation(ViewGroup viewGroup, View view, boolean z10, View view2) {
        this.f40702c = z10;
        m53605a(viewGroup, view, false, view2);
    }

    public void startExitAnimation(ViewGroup viewGroup, View view, boolean z10, View view2) {
        this.f40702c = z10;
        m53605a(viewGroup, view, true, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m53611b(float f10, boolean z10) {
        float fWidth;
        float fHeight;
        float fCenterX;
        float fCenterY;
        float interpolation = this.f40705f.getInterpolation(f10);
        RectF rectF = new RectF(this.f40712m);
        RectF rectF2 = new RectF(this.f40713n);
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        if (rectF.width() == 0.0f || rectF.height() == 0.0f) {
            return;
        }
        if (z10) {
            float f11 = 1.0f - interpolation;
            fWidth = (((fWidth2 - rectF.width()) * f11) / rectF.width()) + 1.0f;
            fHeight = (((fHeight2 - rectF.height()) * f11) / rectF.height()) + 1.0f;
            fCenterX = rectF2.centerX() - ((rectF2.centerX() - rectF.centerX()) * interpolation);
            fCenterY = rectF2.centerY() - ((rectF2.centerY() - rectF.centerY()) * interpolation);
        } else {
            fWidth = (((fWidth2 - rectF.width()) * interpolation) / rectF.width()) + 1.0f;
            fHeight = (((fHeight2 - rectF.height()) * interpolation) / rectF.height()) + 1.0f;
            fCenterX = rectF.centerX() - ((rectF.centerX() - rectF2.centerX()) * interpolation);
            fCenterY = rectF.centerY() - ((rectF.centerY() - rectF2.centerY()) * interpolation);
        }
        float fWidth3 = (rectF.width() * fWidth) / 2.0f;
        float f12 = fCenterX - fWidth3;
        float fHeight3 = (rectF.height() * fHeight) / 2.0f;
        float f13 = fCenterY - fHeight3;
        float f14 = fCenterX + fWidth3;
        new RectF().set(f12, f13, f14, fCenterY + fHeight3);
        float fHeight4 = (rectF.height() * fWidth) + f13;
        Rect rect = new Rect();
        rect.set((int) f12, (int) f13, (int) f14, (int) fHeight4);
        this.f40707h.setBounds(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m53614c() {
        ViewGroup viewGroup = this.f40708i;
        if (viewGroup == null || viewGroup.getChildCount() == 0 || this.f40701b == -1) {
            return;
        }
        Iterator<Integer> it = this.f40703d.iterator();
        while (it.hasNext()) {
            View childAt = this.f40708i.getChildAt(it.next().intValue());
            if (childAt != null) {
                childAt.setTranslationY(0.0f);
            }
        }
        Iterator<Integer> it2 = this.f40704e.iterator();
        while (it2.hasNext()) {
            View childAt2 = this.f40708i.getChildAt(it2.next().intValue());
            if (childAt2 != null) {
                childAt2.setTranslationY(0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m53605a(ViewGroup viewGroup, View view, boolean z10, View view2) {
        if (viewGroup == null || view == null || view.getWidth() == 0 || view2 == null || view2.getWidth() == 0 || view2.getHeight() == 0) {
            return;
        }
        View rootView = viewGroup.getRootView();
        this.f40714o = rootView;
        if (rootView instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) rootView;
            this.f40715p = viewGroup2;
            ViewGroupOverlay overlay = viewGroup2.getOverlay();
            this.f40711l = overlay;
            if (overlay == null) {
                return;
            }
            this.f40708i = viewGroup;
            this.f40709j = view;
            this.f40710k = view2;
            this.f40700a = view.getHeight();
            int[] iArr = new int[2];
            this.f40716q = iArr;
            this.f40710k.getLocationInWindow(iArr);
            Drawable drawableM53600a = m53600a(this.f40710k);
            this.f40707h = drawableM53600a;
            if (drawableM53600a == null) {
                return;
            }
            if (this.f40702c) {
                m53604a(this.f40708i, this.f40709j);
            }
            this.f40709j.setVisibility(4);
            this.f40711l.add(this.f40707h);
            this.f40706g = m53610b();
            this.f40705f = m53602a();
            this.f40713n.set(new RectF(this.f40715p.getLeft(), this.f40714o.getTop(), this.f40714o.getRight(), this.f40714o.getBottom()));
            this.f40712m.set(new RectF(this.f40716q[0], r5[1], r7 + this.f40710k.getWidth(), this.f40716q[1] + this.f40710k.getHeight()));
            m53607a(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m53615c(float f10, boolean z10) {
        float f11;
        float interpolation = this.f40705f.getInterpolation(f10);
        if (z10) {
            f11 = this.f40700a * (1.0f - interpolation);
        } else {
            f11 = this.f40700a * interpolation;
        }
        Iterator<Integer> it = this.f40703d.iterator();
        while (it.hasNext()) {
            View childAt = this.f40708i.getChildAt(it.next().intValue());
            if (childAt != null) {
                childAt.setTranslationY(-f11);
            }
        }
        Iterator<Integer> it2 = this.f40704e.iterator();
        while (it2.hasNext()) {
            View childAt2 = this.f40708i.getChildAt(it2.next().intValue());
            if (childAt2 != null) {
                childAt2.setTranslationY(f11);
            }
        }
    }

    /* renamed from: b */
    private int m53608b(float f10, float f11, float f12) {
        return (int) (m53599a(f10, f11, f12, this.f40706g) * 255.0f);
    }

    /* renamed from: b */
    private HwCubicBezierInterpolator m53610b() {
        return new HwCubicBezierInterpolator(f40695v, 0.0f, f40696w, 1.0f);
    }

    /* renamed from: a */
    private void m53607a(boolean z10) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(350L);
        valueAnimatorOfFloat.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new aauaf(z10));
        valueAnimatorOfFloat.addListener(this.f40717r);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m53603a(float f10, boolean z10) {
        int iM53608b;
        if (z10) {
            iM53608b = m53608b(f10, f40690I, 1.0f);
        } else {
            iM53608b = 255 - m53608b(f10, 0.0f, f40689H);
        }
        this.f40707h.setAlpha(iM53608b);
    }

    /* renamed from: a */
    private float m53599a(float f10, float f11, float f12, HwCubicBezierInterpolator hwCubicBezierInterpolator) {
        if (hwCubicBezierInterpolator != null) {
            return hwCubicBezierInterpolator.getInterpolation(m53598a(f10, f11, f12));
        }
        return m53598a(f10, f11, f12);
    }

    /* renamed from: a */
    private void m53604a(ViewGroup viewGroup, View view) {
        this.f40701b = -1;
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null && childAt == view) {
                this.f40701b = i10;
                break;
            }
            i10++;
        }
        if (this.f40701b == -1) {
            return;
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            if (viewGroup.getChildAt(i11) != null) {
                if (i11 < this.f40701b) {
                    this.f40703d.add(Integer.valueOf(i11));
                }
                if (i11 > this.f40701b) {
                    this.f40704e.add(Integer.valueOf(i11));
                }
            }
        }
    }

    /* renamed from: a */
    private Drawable m53600a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            width = view.getLayoutParams().width;
        }
        if (height <= 0) {
            height = view.getLayoutParams().height;
        }
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        int[] iArr = this.f40716q;
        int i10 = iArr[0];
        int i11 = iArr[1];
        Rect rect = new Rect(i10, i11, width + i10, height + i11);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getResources(), bitmapCreateBitmap);
        bitmapDrawable.setBounds(rect);
        return bitmapDrawable;
    }

    /* renamed from: a */
    private HwCubicBezierInterpolator m53602a() {
        return new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
    }
}
