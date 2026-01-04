package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import p273f0.C9603h0;
import p273f0.C9614n;
import p273f0.C9625s0;
import p827z.C14059a;

/* loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d */
    public final Rect f7434d;

    /* renamed from: e */
    public final Rect f7435e;

    /* renamed from: f */
    public int f7436f;

    /* renamed from: g */
    public int f7437g;

    public HeaderScrollingViewBehavior() {
        this.f7434d = new Rect();
        this.f7435e = new Rect();
        this.f7436f = 0;
    }

    /* renamed from: N */
    public static int m9587N(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    /* renamed from: F */
    public void mo9588F(CoordinatorLayout coordinatorLayout, View view, int i10) {
        View viewMo9549H = mo9549H(coordinatorLayout.m3718v(view));
        if (viewMo9549H == null) {
            super.mo9588F(coordinatorLayout, view, i10);
            this.f7436f = 0;
            return;
        }
        CoordinatorLayout.C0594e c0594e = (CoordinatorLayout.C0594e) view.getLayoutParams();
        Rect rect = this.f7434d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0594e).leftMargin, viewMo9549H.getBottom() + ((ViewGroup.MarginLayoutParams) c0594e).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0594e).rightMargin, ((coordinatorLayout.getHeight() + viewMo9549H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin);
        C9625s0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && C9603h0.m59917x(coordinatorLayout) && !C9603h0.m59917x(view)) {
            rect.left += lastWindowInsets.m60158j();
            rect.right -= lastWindowInsets.m60159k();
        }
        Rect rect2 = this.f7435e;
        C9614n.m60101a(m9587N(c0594e.f3276c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
        int iM9589I = m9589I(viewMo9549H);
        view.layout(rect2.left, rect2.top - iM9589I, rect2.right, rect2.bottom - iM9589I);
        this.f7436f = rect2.top - viewMo9549H.getBottom();
    }

    /* renamed from: H */
    public abstract View mo9549H(List<View> list);

    /* renamed from: I */
    public final int m9589I(View view) {
        if (this.f7437g == 0) {
            return 0;
        }
        float fMo9550J = mo9550J(view);
        int i10 = this.f7437g;
        return C14059a.m84263b((int) (fMo9550J * i10), 0, i10);
    }

    /* renamed from: J */
    public float mo9550J(View view) {
        return 1.0f;
    }

    /* renamed from: K */
    public final int m9590K() {
        return this.f7437g;
    }

    /* renamed from: L */
    public int mo9551L(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: M */
    public final int m9591M() {
        return this.f7436f;
    }

    /* renamed from: O */
    public final void m9592O(int i10) {
        this.f7437g = i10;
    }

    /* renamed from: P */
    public boolean m9593P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: m */
    public boolean mo3739m(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        View viewMo9549H;
        C9625s0 lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (viewMo9549H = mo9549H(coordinatorLayout.m3718v(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (C9603h0.m59917x(viewMo9549H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.m60160l() + lastWindowInsets.m60157i();
        }
        int iMo9551L = size + mo9551L(viewMo9549H);
        int measuredHeight = viewMo9549H.getMeasuredHeight();
        if (m9593P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iMo9551L -= measuredHeight;
        }
        coordinatorLayout.m3699N(view, i10, i11, View.MeasureSpec.makeMeasureSpec(iMo9551L, i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7434d = new Rect();
        this.f7435e = new Rect();
        this.f7436f = 0;
    }
}
