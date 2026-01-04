package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    public C1649a f7445a;

    /* renamed from: b */
    public int f7446b;

    /* renamed from: c */
    public int f7447c;

    public ViewOffsetBehavior() {
        this.f7446b = 0;
        this.f7447c = 0;
    }

    /* renamed from: E */
    public int mo9540E() {
        C1649a c1649a = this.f7445a;
        if (c1649a != null) {
            return c1649a.m9602c();
        }
        return 0;
    }

    /* renamed from: F */
    public void mo9588F(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        coordinatorLayout.m3698M(v10, i10);
    }

    /* renamed from: G */
    public boolean mo9541G(int i10) {
        C1649a c1649a = this.f7445a;
        if (c1649a != null) {
            return c1649a.m9605f(i10);
        }
        this.f7446b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: l */
    public boolean mo3738l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        mo9588F(coordinatorLayout, v10, i10);
        if (this.f7445a == null) {
            this.f7445a = new C1649a(v10);
        }
        this.f7445a.m9603d();
        this.f7445a.m9600a();
        int i11 = this.f7446b;
        if (i11 != 0) {
            this.f7445a.m9605f(i11);
            this.f7446b = 0;
        }
        int i12 = this.f7447c;
        if (i12 == 0) {
            return true;
        }
        this.f7445a.m9604e(i12);
        this.f7447c = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7446b = 0;
        this.f7447c = 0;
    }
}
