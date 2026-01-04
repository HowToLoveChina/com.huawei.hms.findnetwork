package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import p004a3.InterfaceC0019a;
import p273f0.C9603h0;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a */
    public int f9049a;

    /* renamed from: com.google.android.material.transformation.ExpandableBehavior$a */
    public class ViewTreeObserverOnPreDrawListenerC1888a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        public final /* synthetic */ View f9050a;

        /* renamed from: b */
        public final /* synthetic */ int f9051b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC0019a f9052c;

        public ViewTreeObserverOnPreDrawListenerC1888a(View view, int i10, InterfaceC0019a interfaceC0019a) {
            this.f9050a = view;
            this.f9051b = i10;
            this.f9052c = interfaceC0019a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f9050a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f9049a == this.f9051b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                InterfaceC0019a interfaceC0019a = this.f9052c;
                expandableBehavior.mo11429H((View) interfaceC0019a, this.f9050a, interfaceC0019a.mo75a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f9049a = 0;
    }

    /* renamed from: F */
    public final boolean m11427F(boolean z10) {
        if (!z10) {
            return this.f9049a == 1;
        }
        int i10 = this.f9049a;
        return i10 == 0 || i10 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: G */
    public InterfaceC0019a m11428G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listM3718v = coordinatorLayout.m3718v(view);
        int size = listM3718v.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = listM3718v.get(i10);
            if (mo3731e(coordinatorLayout, view, view2)) {
                return (InterfaceC0019a) view2;
            }
        }
        return null;
    }

    /* renamed from: H */
    public abstract boolean mo11429H(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: e */
    public abstract boolean mo3731e(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: h */
    public boolean mo3734h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        InterfaceC0019a interfaceC0019a = (InterfaceC0019a) view2;
        if (!m11427F(interfaceC0019a.mo75a())) {
            return false;
        }
        this.f9049a = interfaceC0019a.mo75a() ? 1 : 2;
        return mo11429H((View) interfaceC0019a, view, interfaceC0019a.mo75a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: l */
    public boolean mo3738l(CoordinatorLayout coordinatorLayout, View view, int i10) {
        InterfaceC0019a interfaceC0019aM11428G;
        if (C9603h0.m59864T(view) || (interfaceC0019aM11428G = m11428G(coordinatorLayout, view)) == null || !m11427F(interfaceC0019aM11428G.mo75a())) {
            return false;
        }
        int i11 = interfaceC0019aM11428G.mo75a() ? 1 : 2;
        this.f9049a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1888a(view, i11, interfaceC0019aM11428G));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9049a = 0;
    }
}
