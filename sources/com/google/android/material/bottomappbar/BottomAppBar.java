package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p276f3.C9649c;
import p356i3.C10427h;
import p356i3.C10428i;
import p356i3.C10432m;
import p416k3.C10981a;
import p666u2.InterfaceC13120k;
import p757x.C13669a;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.InterfaceC0591b {

    /* renamed from: s0 */
    public static final int f7520s0 = R$style.Widget_MaterialComponents_BottomAppBar;

    /* renamed from: T */
    public Integer f7521T;

    /* renamed from: U */
    public final int f7522U;

    /* renamed from: V */
    public final C10427h f7523V;

    /* renamed from: W */
    public Animator f7524W;

    /* renamed from: a0 */
    public Animator f7525a0;

    /* renamed from: b0 */
    public int f7526b0;

    /* renamed from: c0 */
    public int f7527c0;

    /* renamed from: d0 */
    public boolean f7528d0;

    /* renamed from: e0 */
    public final boolean f7529e0;

    /* renamed from: f0 */
    public final boolean f7530f0;

    /* renamed from: g0 */
    public final boolean f7531g0;

    /* renamed from: h0 */
    public int f7532h0;

    /* renamed from: i0 */
    public ArrayList<InterfaceC1670j> f7533i0;

    /* renamed from: j0 */
    public int f7534j0;

    /* renamed from: k0 */
    public boolean f7535k0;

    /* renamed from: l0 */
    public boolean f7536l0;

    /* renamed from: m0 */
    public Behavior f7537m0;

    /* renamed from: n0 */
    public int f7538n0;

    /* renamed from: o0 */
    public int f7539o0;

    /* renamed from: p0 */
    public int f7540p0;

    /* renamed from: q0 */
    public AnimatorListenerAdapter f7541q0;

    /* renamed from: r0 */
    public InterfaceC13120k<FloatingActionButton> f7542r0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1660a();

        /* renamed from: d */
        public int f7548d;

        /* renamed from: e */
        public boolean f7549e;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$a */
        public class C1660a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7548d);
            parcel.writeInt(this.f7549e ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7548d = parcel.readInt();
            this.f7549e = parcel.readInt() != 0;
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$a */
    public class C1661a extends AnimatorListenerAdapter {
        public C1661a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.f7535k0) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.m9772M0(bottomAppBar.f7526b0, BottomAppBar.this.f7536l0);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$b */
    public class C1662b implements InterfaceC13120k<FloatingActionButton> {
        public C1662b() {
        }

        @Override // p666u2.InterfaceC13120k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void mo9790a(FloatingActionButton floatingActionButton) {
            BottomAppBar.this.f7523V.m64003c0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // p666u2.InterfaceC13120k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo9791b(FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().m9805l() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().m9811r(translationX);
                BottomAppBar.this.f7523V.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().m9800f() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().m9806m(fMax);
                BottomAppBar.this.f7523V.invalidateSelf();
            }
            BottomAppBar.this.f7523V.m64003c0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$c */
    public class C1663c implements C1788s.e {
        public C1663c() {
        }

        @Override // com.google.android.material.internal.C1788s.e
        /* renamed from: a */
        public C9625s0 mo9794a(View view, C9625s0 c9625s0, C1788s.f fVar) {
            boolean z10;
            if (BottomAppBar.this.f7529e0) {
                BottomAppBar.this.f7538n0 = c9625s0.m60157i();
            }
            boolean z11 = false;
            if (BottomAppBar.this.f7530f0) {
                z10 = BottomAppBar.this.f7540p0 != c9625s0.m60158j();
                BottomAppBar.this.f7540p0 = c9625s0.m60158j();
            } else {
                z10 = false;
            }
            if (BottomAppBar.this.f7531g0) {
                boolean z12 = BottomAppBar.this.f7539o0 != c9625s0.m60159k();
                BottomAppBar.this.f7539o0 = c9625s0.m60159k();
                z11 = z12;
            }
            if (z10 || z11) {
                BottomAppBar.this.m9761B0();
                BottomAppBar.this.m9777R0();
                BottomAppBar.this.m9776Q0();
            }
            return c9625s0;
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$d */
    public class C1664d extends AnimatorListenerAdapter {
        public C1664d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.m9765F0();
            BottomAppBar.this.f7524W = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.m9766G0();
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$e */
    public class C1665e extends FloatingActionButton.AbstractC1757b {

        /* renamed from: a */
        public final /* synthetic */ int f7554a;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$e$a */
        public class a extends FloatingActionButton.AbstractC1757b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.AbstractC1757b
            /* renamed from: b */
            public void mo9796b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.m9765F0();
            }
        }

        public C1665e(int i10) {
            this.f7554a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.AbstractC1757b
        /* renamed from: a */
        public void mo9795a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.m9770K0(this.f7554a));
            floatingActionButton.m10471s(new a());
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$f */
    public class C1666f extends AnimatorListenerAdapter {
        public C1666f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.m9765F0();
            BottomAppBar.this.f7535k0 = false;
            BottomAppBar.this.f7525a0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.m9766G0();
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$g */
    public class C1667g extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f7558a;

        /* renamed from: b */
        public final /* synthetic */ ActionMenuView f7559b;

        /* renamed from: c */
        public final /* synthetic */ int f7560c;

        /* renamed from: d */
        public final /* synthetic */ boolean f7561d;

        public C1667g(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f7559b = actionMenuView;
            this.f7560c = i10;
            this.f7561d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7558a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f7558a) {
                return;
            }
            boolean z10 = BottomAppBar.this.f7534j0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.m9775P0(bottomAppBar.f7534j0);
            BottomAppBar.this.m9781V0(this.f7559b, this.f7560c, this.f7561d, z10);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$h */
    public class RunnableC1668h implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ActionMenuView f7563a;

        /* renamed from: b */
        public final /* synthetic */ int f7564b;

        /* renamed from: c */
        public final /* synthetic */ boolean f7565c;

        public RunnableC1668h(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f7563a = actionMenuView;
            this.f7564b = i10;
            this.f7565c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7563a.setTranslationX(BottomAppBar.this.m9769J0(r0, this.f7564b, this.f7565c));
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$i */
    public class C1669i extends AnimatorListenerAdapter {
        public C1669i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f7541q0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonM9767H0 = BottomAppBar.this.m9767H0();
            if (floatingActionButtonM9767H0 != null) {
                floatingActionButtonM9767H0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$j */
    public interface InterfaceC1670j {
        /* renamed from: a */
        void m9797a(BottomAppBar bottomAppBar);

        /* renamed from: b */
        void m9798b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(Context context) {
        this(context, null);
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f7538n0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return m9770K0(this.f7526b0);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().m9800f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f7540p0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f7539o0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1671a getTopEdgeTreatment() {
        return (C1671a) this.f7523V.m63980E().m64060p();
    }

    /* renamed from: A0 */
    public final void m9760A0(FloatingActionButton floatingActionButton) {
        floatingActionButton.m10458e(this.f7541q0);
        floatingActionButton.m10459f(new C1669i());
        floatingActionButton.m10460g(this.f7542r0);
    }

    /* renamed from: B0 */
    public final void m9761B0() {
        Animator animator = this.f7525a0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f7524W;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    /* renamed from: C0 */
    public void m9762C0(int i10, List<Animator> list) {
        FloatingActionButton floatingActionButtonM9767H0 = m9767H0();
        if (floatingActionButtonM9767H0 == null || floatingActionButtonM9767H0.m10467n()) {
            return;
        }
        m9766G0();
        floatingActionButtonM9767H0.m10465l(new C1665e(i10));
    }

    /* renamed from: D0 */
    public final void m9763D0(int i10, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(m9767H0(), "translationX", m9770K0(i10));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    /* renamed from: E0 */
    public final void m9764E0(int i10, boolean z10, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, TopAnimatorConfig.AnimatorType.ALPHA, 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - m9769J0(actionMenuView, i10, z10)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, TopAnimatorConfig.AnimatorType.ALPHA, 0.0f);
            objectAnimatorOfFloat.addListener(new C1667g(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* renamed from: F0 */
    public final void m9765F0() {
        ArrayList<InterfaceC1670j> arrayList;
        int i10 = this.f7532h0 - 1;
        this.f7532h0 = i10;
        if (i10 != 0 || (arrayList = this.f7533i0) == null) {
            return;
        }
        Iterator<InterfaceC1670j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().m9798b(this);
        }
    }

    /* renamed from: G0 */
    public final void m9766G0() {
        ArrayList<InterfaceC1670j> arrayList;
        int i10 = this.f7532h0;
        this.f7532h0 = i10 + 1;
        if (i10 != 0 || (arrayList = this.f7533i0) == null) {
            return;
        }
        Iterator<InterfaceC1670j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().m9797a(this);
        }
    }

    /* renamed from: H0 */
    public final FloatingActionButton m9767H0() {
        View viewM9768I0 = m9768I0();
        if (viewM9768I0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewM9768I0;
        }
        return null;
    }

    /* renamed from: I0 */
    public final View m9768I0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).m3719w(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* renamed from: J0 */
    public int m9769J0(ActionMenuView actionMenuView, int i10, boolean z10) {
        if (i10 != 1 || !z10) {
            return 0;
        }
        boolean zM10788i = C1788s.m10788i(this);
        int measuredWidth = zM10788i ? getMeasuredWidth() : 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f1145a & 8388615) == 8388611) {
                measuredWidth = zM10788i ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zM10788i ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zM10788i ? this.f7539o0 : -this.f7540p0));
    }

    /* renamed from: K0 */
    public final float m9770K0(int i10) {
        boolean zM10788i = C1788s.m10788i(this);
        if (i10 == 1) {
            return ((getMeasuredWidth() / 2) - (this.f7522U + (zM10788i ? this.f7540p0 : this.f7539o0))) * (zM10788i ? -1 : 1);
        }
        return 0.0f;
    }

    /* renamed from: L0 */
    public final boolean m9771L0() {
        FloatingActionButton floatingActionButtonM9767H0 = m9767H0();
        return floatingActionButtonM9767H0 != null && floatingActionButtonM9767H0.m10468o();
    }

    /* renamed from: M0 */
    public final void m9772M0(int i10, boolean z10) {
        if (!C9603h0.m59864T(this)) {
            this.f7535k0 = false;
            m9775P0(this.f7534j0);
            return;
        }
        Animator animator = this.f7525a0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!m9771L0()) {
            i10 = 0;
            z10 = false;
        }
        m9764E0(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f7525a0 = animatorSet;
        animatorSet.addListener(new C1666f());
        this.f7525a0.start();
    }

    /* renamed from: N0 */
    public final void m9773N0(int i10) {
        if (this.f7526b0 == i10 || !C9603h0.m59864T(this)) {
            return;
        }
        Animator animator = this.f7524W;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f7527c0 == 1) {
            m9763D0(i10, arrayList);
        } else {
            m9762C0(i10, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f7524W = animatorSet;
        animatorSet.addListener(new C1664d());
        this.f7524W.start();
    }

    /* renamed from: O0 */
    public final Drawable m9774O0(Drawable drawable) {
        if (drawable == null || this.f7521T == null) {
            return drawable;
        }
        Drawable drawableM82231l = C13669a.m82231l(drawable.mutate());
        C13669a.m82227h(drawableM82231l, this.f7521T.intValue());
        return drawableM82231l;
    }

    /* renamed from: P0 */
    public void m9775P0(int i10) {
        if (i10 != 0) {
            this.f7534j0 = 0;
            getMenu().clear();
            m2879z(i10);
        }
    }

    /* renamed from: Q0 */
    public final void m9776Q0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f7525a0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (m9771L0()) {
            m9780U0(actionMenuView, this.f7526b0, this.f7536l0);
        } else {
            m9780U0(actionMenuView, 0, false);
        }
    }

    /* renamed from: R0 */
    public final void m9777R0() {
        getTopEdgeTreatment().m9811r(getFabTranslationX());
        View viewM9768I0 = m9768I0();
        this.f7523V.m64003c0((this.f7536l0 && m9771L0()) ? 1.0f : 0.0f);
        if (viewM9768I0 != null) {
            viewM9768I0.setTranslationY(getFabTranslationY());
            viewM9768I0.setTranslationX(getFabTranslationX());
        }
    }

    /* renamed from: S0 */
    public void m9778S0(int i10, int i11) {
        this.f7534j0 = i11;
        this.f7535k0 = true;
        m9772M0(i10, this.f7536l0);
        m9773N0(i10);
        this.f7526b0 = i10;
    }

    /* renamed from: T0 */
    public boolean m9779T0(int i10) {
        float f10 = i10;
        if (f10 == getTopEdgeTreatment().m9804k()) {
            return false;
        }
        getTopEdgeTreatment().m9810q(f10);
        this.f7523V.invalidateSelf();
        return true;
    }

    /* renamed from: U0 */
    public final void m9780U0(ActionMenuView actionMenuView, int i10, boolean z10) {
        m9781V0(actionMenuView, i10, z10, false);
    }

    /* renamed from: V0 */
    public final void m9781V0(ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        RunnableC1668h runnableC1668h = new RunnableC1668h(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(runnableC1668h);
        } else {
            runnableC1668h.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.f7523V.m63984I();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().m9800f();
    }

    public int getFabAlignmentMode() {
        return this.f7526b0;
    }

    public int getFabAnimationMode() {
        return this.f7527c0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().m9802i();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().m9803j();
    }

    public boolean getHideOnScroll() {
        return this.f7528d0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64044f(this, this.f7523V);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            m9761B0();
            m9777R0();
        }
        m9776Q0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7526b0 = savedState.f7548d;
        this.f7536l0 = savedState.f7549e;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7548d = this.f7526b0;
        savedState.f7549e = this.f7536l0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        C13669a.m82228i(this.f7523V, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().m9806m(f10);
            this.f7523V.invalidateSelf();
            m9777R0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.f7523V.m64001a0(f10);
        getBehavior().m9709I(this, this.f7523V.m63979D() - this.f7523V.m63978C());
    }

    public void setFabAlignmentMode(int i10) {
        m9778S0(i10, 0);
    }

    public void setFabAnimationMode(int i10) {
        this.f7527c0 = i10;
    }

    public void setFabCornerSize(float f10) {
        if (f10 != getTopEdgeTreatment().m9801g()) {
            getTopEdgeTreatment().m9807n(f10);
            this.f7523V.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().m9808o(f10);
            this.f7523V.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().m9809p(f10);
            this.f7523V.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f7528d0 = z10;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(m9774O0(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f7521T = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.InterfaceC0591b
    public Behavior getBehavior() {
        if (this.f7537m0 == null) {
            this.f7537m0 = new Behavior();
        }
        return this.f7537m0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e */
        public final Rect f7543e;

        /* renamed from: f */
        public WeakReference<BottomAppBar> f7544f;

        /* renamed from: g */
        public int f7545g;

        /* renamed from: h */
        public final View.OnLayoutChangeListener f7546h;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$Behavior$a */
        public class ViewOnLayoutChangeListenerC1659a implements View.OnLayoutChangeListener {
            public ViewOnLayoutChangeListenerC1659a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f7544f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.m10463j(Behavior.this.f7543e);
                int iHeight = Behavior.this.f7543e.height();
                bottomAppBar.m9779T0(iHeight);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().m64062r().mo63966a(new RectF(Behavior.this.f7543e)));
                CoordinatorLayout.C0594e c0594e = (CoordinatorLayout.C0594e) view.getLayoutParams();
                if (Behavior.this.f7545g == 0) {
                    ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) c0594e).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) c0594e).rightMargin = bottomAppBar.getRightInset();
                    if (C1788s.m10788i(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) c0594e).leftMargin += bottomAppBar.f7522U;
                    } else {
                        ((ViewGroup.MarginLayoutParams) c0594e).rightMargin += bottomAppBar.f7522U;
                    }
                }
            }
        }

        public Behavior() {
            this.f7546h = new ViewOnLayoutChangeListenerC1659a();
            this.f7543e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public boolean mo3738l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            this.f7544f = new WeakReference<>(bottomAppBar);
            View viewM9768I0 = bottomAppBar.m9768I0();
            if (viewM9768I0 != null && !C9603h0.m59864T(viewM9768I0)) {
                CoordinatorLayout.C0594e c0594e = (CoordinatorLayout.C0594e) viewM9768I0.getLayoutParams();
                c0594e.f3277d = 49;
                this.f7545g = ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin;
                if (viewM9768I0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewM9768I0;
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.f7546h);
                    bottomAppBar.m9760A0(floatingActionButton);
                }
                bottomAppBar.m9777R0();
            }
            coordinatorLayout.m3698M(bottomAppBar, i10);
            return super.mo3738l(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public boolean mo3723A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.mo3723A(coordinatorLayout, bottomAppBar, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7546h = new ViewOnLayoutChangeListenerC1659a();
            this.f7543e = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7520s0;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        C10427h c10427h = new C10427h();
        this.f7523V = c10427h;
        this.f7532h0 = 0;
        this.f7534j0 = 0;
        this.f7535k0 = false;
        this.f7536l0 = true;
        this.f7541q0 = new C1661a();
        this.f7542r0 = new C1662b();
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.BottomAppBar, i10, i11, new int[0]);
        ColorStateList colorStateListM60265a = C9649c.m60265a(context2, typedArrayM10770h, R$styleable.BottomAppBar_backgroundTint);
        int i12 = R$styleable.BottomAppBar_navigationIconTint;
        if (typedArrayM10770h.hasValue(i12)) {
            setNavigationIconTint(typedArrayM10770h.getColor(i12, -1));
        }
        int dimensionPixelSize = typedArrayM10770h.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayM10770h.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayM10770h.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayM10770h.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.f7526b0 = typedArrayM10770h.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f7527c0 = typedArrayM10770h.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.f7528d0 = typedArrayM10770h.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.f7529e0 = typedArrayM10770h.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.f7530f0 = typedArrayM10770h.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.f7531g0 = typedArrayM10770h.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayM10770h.recycle();
        this.f7522U = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        c10427h.setShapeAppearanceModel(C10432m.m64045a().m64084B(new C1671a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m64093m());
        c10427h.m64013i0(2);
        c10427h.m64005e0(Paint.Style.FILL);
        c10427h.m63992Q(context2);
        setElevation(dimensionPixelSize);
        C13669a.m82228i(c10427h, colorStateListM60265a);
        C9603h0.m59910t0(this, c10427h);
        C1788s.m10780a(this, attributeSet, i10, i11, new C1663c());
    }
}
