package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$id;
import com.google.android.material.circularreveal.C1709a;
import com.google.android.material.circularreveal.C1710b;
import com.google.android.material.circularreveal.InterfaceC1711c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import java.util.List;
import p045c3.C1382a;
import p273f0.C9603h0;
import p666u2.C13110a;
import p666u2.C13111b;
import p666u2.C13112c;
import p666u2.C13113d;
import p666u2.C13114e;
import p666u2.C13117h;
import p666u2.C13118i;
import p666u2.C13119j;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c */
    public final Rect f9056c;

    /* renamed from: d */
    public final RectF f9057d;

    /* renamed from: e */
    public final RectF f9058e;

    /* renamed from: f */
    public final int[] f9059f;

    /* renamed from: g */
    public float f9060g;

    /* renamed from: h */
    public float f9061h;

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$a */
    public class C1890a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f9062a;

        /* renamed from: b */
        public final /* synthetic */ View f9063b;

        /* renamed from: c */
        public final /* synthetic */ View f9064c;

        public C1890a(boolean z10, View view, View view2) {
            this.f9062a = z10;
            this.f9063b = view;
            this.f9064c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f9062a) {
                return;
            }
            this.f9063b.setVisibility(4);
            this.f9064c.setAlpha(1.0f);
            this.f9064c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f9062a) {
                this.f9063b.setVisibility(0);
                this.f9064c.setAlpha(0.0f);
                this.f9064c.setVisibility(4);
            }
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$b */
    public class C1891b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ View f9066a;

        public C1891b(View view) {
            this.f9066a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9066a.invalidate();
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$c */
    public class C1892c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1711c f9068a;

        /* renamed from: b */
        public final /* synthetic */ Drawable f9069b;

        public C1892c(InterfaceC1711c interfaceC1711c, Drawable drawable) {
            this.f9068a = interfaceC1711c;
            this.f9069b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9068a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f9068a.setCircularRevealOverlayDrawable(this.f9069b);
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$d */
    public class C1893d extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1711c f9071a;

        public C1893d(InterfaceC1711c interfaceC1711c) {
            this.f9071a = interfaceC1711c;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InterfaceC1711c.e revealInfo = this.f9071a.getRevealInfo();
            revealInfo.f7870c = Float.MAX_VALUE;
            this.f9071a.setRevealInfo(revealInfo);
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$e */
    public static class C1894e {

        /* renamed from: a */
        public C13117h f9073a;

        /* renamed from: b */
        public C13119j f9074b;
    }

    public FabTransformationBehavior() {
        this.f9056c = new Rect();
        this.f9057d = new RectF();
        this.f9058e = new RectF();
        this.f9059f = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /* renamed from: J */
    public AnimatorSet mo11431J(View view, View view2, boolean z10, boolean z11) {
        C1894e c1894eMo11452e0 = mo11452e0(view2.getContext(), z10);
        if (z10) {
            this.f9060g = view.getTranslationX();
            this.f9061h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m11445X(view, view2, z10, z11, c1894eMo11452e0, arrayList, arrayList2);
        RectF rectF = this.f9057d;
        m11450c0(view, view2, z10, z11, c1894eMo11452e0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        m11444W(view, view2, z10, c1894eMo11452e0, arrayList);
        m11447Z(view, view2, z10, z11, c1894eMo11452e0, arrayList, arrayList2);
        m11446Y(view, view2, z10, z11, c1894eMo11452e0, fWidth, fHeight, arrayList, arrayList2);
        m11443V(view, view2, z10, z11, c1894eMo11452e0, arrayList, arrayList2);
        m11442U(view, view2, z10, z11, c1894eMo11452e0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        C13111b.m78887a(animatorSet, arrayList);
        animatorSet.addListener(new C1890a(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
        }
        return animatorSet;
    }

    /* renamed from: K */
    public final ViewGroup m11432K(View view) {
        View viewFindViewById = view.findViewById(R$id.mtrl_child_content_container);
        return viewFindViewById != null ? m11453f0(viewFindViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? m11453f0(((ViewGroup) view).getChildAt(0)) : m11453f0(view);
    }

    /* renamed from: L */
    public final void m11433L(View view, C1894e c1894e, C13118i c13118i, C13118i c13118i2, float f10, float f11, float f12, float f13, RectF rectF) {
        float fM11440S = m11440S(c1894e, c13118i, f10, f12);
        float fM11440S2 = m11440S(c1894e, c13118i2, f11, f13);
        Rect rect = this.f9056c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f9057d;
        rectF2.set(rect);
        RectF rectF3 = this.f9058e;
        m11441T(view, rectF3);
        rectF3.offset(fM11440S, fM11440S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    /* renamed from: M */
    public final void m11434M(View view, RectF rectF) {
        m11441T(view, rectF);
        rectF.offset(this.f9060g, this.f9061h);
    }

    /* renamed from: N */
    public final Pair<C13118i, C13118i> m11435N(float f10, float f11, boolean z10, C1894e c1894e) {
        C13118i c13118iM78903h;
        C13118i c13118iM78903h2;
        if (f10 == 0.0f || f11 == 0.0f) {
            c13118iM78903h = c1894e.f9073a.m78903h("translationXLinear");
            c13118iM78903h2 = c1894e.f9073a.m78903h("translationYLinear");
        } else if ((!z10 || f11 >= 0.0f) && (z10 || f11 <= 0.0f)) {
            c13118iM78903h = c1894e.f9073a.m78903h("translationXCurveDownwards");
            c13118iM78903h2 = c1894e.f9073a.m78903h("translationYCurveDownwards");
        } else {
            c13118iM78903h = c1894e.f9073a.m78903h("translationXCurveUpwards");
            c13118iM78903h2 = c1894e.f9073a.m78903h("translationYCurveUpwards");
        }
        return new Pair<>(c13118iM78903h, c13118iM78903h2);
    }

    /* renamed from: O */
    public final float m11436O(View view, View view2, C13119j c13119j) {
        RectF rectF = this.f9057d;
        RectF rectF2 = this.f9058e;
        m11434M(view, rectF);
        m11441T(view2, rectF2);
        rectF2.offset(-m11438Q(view, view2, c13119j), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    /* renamed from: P */
    public final float m11437P(View view, View view2, C13119j c13119j) {
        RectF rectF = this.f9057d;
        RectF rectF2 = this.f9058e;
        m11434M(view, rectF);
        m11441T(view2, rectF2);
        rectF2.offset(0.0f, -m11439R(view, view2, c13119j));
        return rectF.centerY() - rectF2.top;
    }

    /* renamed from: Q */
    public final float m11438Q(View view, View view2, C13119j c13119j) {
        float fCenterX;
        float fCenterX2;
        float f10;
        RectF rectF = this.f9057d;
        RectF rectF2 = this.f9058e;
        m11434M(view, rectF);
        m11441T(view2, rectF2);
        int i10 = c13119j.f59617a & 7;
        if (i10 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i10 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i10 != 5) {
                f10 = 0.0f;
                return f10 + c13119j.f59618b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f10 = fCenterX - fCenterX2;
        return f10 + c13119j.f59618b;
    }

    /* renamed from: R */
    public final float m11439R(View view, View view2, C13119j c13119j) {
        float fCenterY;
        float fCenterY2;
        float f10;
        RectF rectF = this.f9057d;
        RectF rectF2 = this.f9058e;
        m11434M(view, rectF);
        m11441T(view2, rectF2);
        int i10 = c13119j.f59617a & 112;
        if (i10 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i10 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i10 != 80) {
                f10 = 0.0f;
                return f10 + c13119j.f59619c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f10 = fCenterY - fCenterY2;
        return f10 + c13119j.f59619c;
    }

    /* renamed from: S */
    public final float m11440S(C1894e c1894e, C13118i c13118i, float f10, float f11) {
        long jM78912c = c13118i.m78912c();
        long jM78913d = c13118i.m78913d();
        C13118i c13118iM78903h = c1894e.f9073a.m78903h("expansion");
        return C13110a.m78884a(f10, f11, c13118i.m78914e().getInterpolation((((c13118iM78903h.m78912c() + c13118iM78903h.m78913d()) + 17) - jM78912c) / jM78913d));
    }

    /* renamed from: T */
    public final void m11441T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f9059f);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    /* renamed from: U */
    public final void m11442U(View view, View view2, boolean z10, boolean z11, C1894e c1894e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupM11432K;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof InterfaceC1711c) && C1710b.f7854j == 0) || (viewGroupM11432K = m11432K(view2)) == null) {
                return;
            }
            if (z10) {
                if (!z11) {
                    C13113d.f59603a.set(viewGroupM11432K, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupM11432K, C13113d.f59603a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupM11432K, C13113d.f59603a, 0.0f);
            }
            c1894e.f9073a.m78903h("contentFade").m78911a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: V */
    public final void m11443V(View view, View view2, boolean z10, boolean z11, C1894e c1894e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof InterfaceC1711c) {
            InterfaceC1711c interfaceC1711c = (InterfaceC1711c) view2;
            int iM11451d0 = m11451d0(view);
            int i10 = 16777215 & iM11451d0;
            if (z10) {
                if (!z11) {
                    interfaceC1711c.setCircularRevealScrimColor(iM11451d0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC1711c, InterfaceC1711c.d.f7867a, i10);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC1711c, InterfaceC1711c.d.f7867a, iM11451d0);
            }
            objectAnimatorOfInt.setEvaluator(C13112c.m78888b());
            c1894e.f9073a.m78903h(RemoteMessageConst.Notification.COLOR).m78911a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    /* renamed from: W */
    public final void m11444W(View view, View view2, boolean z10, C1894e c1894e, List<Animator> list) {
        float fM11438Q = m11438Q(view, view2, c1894e.f9074b);
        float fM11439R = m11439R(view, view2, c1894e.f9074b);
        Pair<C13118i, C13118i> pairM11435N = m11435N(fM11438Q, fM11439R, z10, c1894e);
        C13118i c13118i = (C13118i) pairM11435N.first;
        C13118i c13118i2 = (C13118i) pairM11435N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z10) {
            fM11438Q = this.f9060g;
        }
        fArr[0] = fM11438Q;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z10) {
            fM11439R = this.f9061h;
        }
        fArr2[0] = fM11439R;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        c13118i.m78911a(objectAnimatorOfFloat);
        c13118i2.m78911a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    /* renamed from: X */
    public final void m11445X(View view, View view2, boolean z10, boolean z11, C1894e c1894e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fM59913v = C9603h0.m59913v(view2) - C9603h0.m59913v(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-fM59913v);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fM59913v);
        }
        c1894e.f9073a.m78903h("elevation").m78911a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Y */
    public final void m11446Y(View view, View view2, boolean z10, boolean z11, C1894e c1894e, float f10, float f11, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animatorM10178a;
        if (view2 instanceof InterfaceC1711c) {
            InterfaceC1711c interfaceC1711c = (InterfaceC1711c) view2;
            float fM11436O = m11436O(view, view2, c1894e.f9074b);
            float fM11437P = m11437P(view, view2, c1894e.f9074b);
            ((FloatingActionButton) view).m10462i(this.f9056c);
            float fWidth = this.f9056c.width() / 2.0f;
            C13118i c13118iM78903h = c1894e.f9073a.m78903h("expansion");
            if (z10) {
                if (!z11) {
                    interfaceC1711c.setRevealInfo(new InterfaceC1711c.e(fM11436O, fM11437P, fWidth));
                }
                if (z11) {
                    fWidth = interfaceC1711c.getRevealInfo().f7870c;
                }
                animatorM10178a = C1709a.m10178a(interfaceC1711c, fM11436O, fM11437P, C1382a.m7930b(fM11436O, fM11437P, 0.0f, 0.0f, f10, f11));
                animatorM10178a.addListener(new C1893d(interfaceC1711c));
                m11449b0(view2, c13118iM78903h.m78912c(), (int) fM11436O, (int) fM11437P, fWidth, list);
            } else {
                float f12 = interfaceC1711c.getRevealInfo().f7870c;
                Animator animatorM10178a2 = C1709a.m10178a(interfaceC1711c, fM11436O, fM11437P, fWidth);
                int i10 = (int) fM11436O;
                int i11 = (int) fM11437P;
                m11449b0(view2, c13118iM78903h.m78912c(), i10, i11, f12, list);
                m11448a0(view2, c13118iM78903h.m78912c(), c13118iM78903h.m78913d(), c1894e.f9073a.m78904i(), i10, i11, fWidth, list);
                animatorM10178a = animatorM10178a2;
            }
            c13118iM78903h.m78911a(animatorM10178a);
            list.add(animatorM10178a);
            list2.add(C1709a.m10179b(interfaceC1711c));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Z */
    public final void m11447Z(View view, View view2, boolean z10, boolean z11, C1894e c1894e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof InterfaceC1711c) && (view instanceof ImageView)) {
            InterfaceC1711c interfaceC1711c = (InterfaceC1711c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, C13114e.f59604b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, C13114e.f59604b, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            }
            objectAnimatorOfInt.addUpdateListener(new C1891b(view2));
            c1894e.f9073a.m78903h("iconFade").m78911a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new C1892c(interfaceC1711c, drawable));
        }
    }

    /* renamed from: a0 */
    public final void m11448a0(View view, long j10, long j11, long j12, int i10, int i11, float f10, List<Animator> list) {
        long j13 = j10 + j11;
        if (j13 < j12) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(j13);
            animatorCreateCircularReveal.setDuration(j12 - j13);
            list.add(animatorCreateCircularReveal);
        }
    }

    /* renamed from: b0 */
    public final void m11449b0(View view, long j10, int i10, int i11, float f10, List<Animator> list) {
        if (j10 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j10);
            list.add(animatorCreateCircularReveal);
        }
    }

    /* renamed from: c0 */
    public final void m11450c0(View view, View view2, boolean z10, boolean z11, C1894e c1894e, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fM11438Q = m11438Q(view, view2, c1894e.f9074b);
        float fM11439R = m11439R(view, view2, c1894e.f9074b);
        Pair<C13118i, C13118i> pairM11435N = m11435N(fM11438Q, fM11439R, z10, c1894e);
        C13118i c13118i = (C13118i) pairM11435N.first;
        C13118i c13118i2 = (C13118i) pairM11435N.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-fM11438Q);
                view2.setTranslationY(-fM11439R);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            m11433L(view2, c1894e, c13118i, c13118i2, -fM11438Q, -fM11439R, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fM11438Q);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fM11439R);
        }
        c13118i.m78911a(objectAnimatorOfFloat);
        c13118i2.m78911a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    /* renamed from: d0 */
    public final int m11451d0(View view) {
        ColorStateList colorStateListM59905r = C9603h0.m59905r(view);
        if (colorStateListM59905r != null) {
            return colorStateListM59905r.getColorForState(view.getDrawableState(), colorStateListM59905r.getDefaultColor());
        }
        return 0;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: e */
    public boolean mo3731e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    /* renamed from: e0 */
    public abstract C1894e mo11452e0(Context context, boolean z10);

    /* renamed from: f0 */
    public final ViewGroup m11453f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: g */
    public void mo3733g(CoordinatorLayout.C0594e c0594e) {
        if (c0594e.f3281h == 0) {
            c0594e.f3281h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9056c = new Rect();
        this.f9057d = new RectF();
        this.f9058e = new RectF();
        this.f9059f = new int[2];
    }
}
