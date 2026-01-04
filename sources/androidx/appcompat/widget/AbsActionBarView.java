package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import p273f0.C9603h0;
import p273f0.C9615n0;
import p273f0.InterfaceC9617o0;

/* loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: a */
    public final C0421a f1730a;

    /* renamed from: b */
    public final Context f1731b;

    /* renamed from: c */
    public ActionMenuView f1732c;

    /* renamed from: d */
    public ActionMenuPresenter f1733d;

    /* renamed from: e */
    public int f1734e;

    /* renamed from: f */
    public C9615n0 f1735f;

    /* renamed from: g */
    public boolean f1736g;

    /* renamed from: h */
    public boolean f1737h;

    /* renamed from: androidx.appcompat.widget.AbsActionBarView$a */
    public class C0421a implements InterfaceC9617o0 {

        /* renamed from: a */
        public boolean f1738a = false;

        /* renamed from: b */
        public int f1739b;

        public C0421a() {
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: a */
        public void mo2522a(View view) {
            this.f1738a = true;
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: b */
        public void mo2156b(View view) {
            if (this.f1738a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f1735f = null;
            AbsActionBarView.super.setVisibility(this.f1739b);
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: c */
        public void mo2157c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f1738a = false;
        }

        /* renamed from: d */
        public C0421a m2523d(C9615n0 c9615n0, int i10) {
            AbsActionBarView.this.f1735f = c9615n0;
            this.f1739b = i10;
            return this;
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: d */
    public static int m2518d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    /* renamed from: c */
    public int m2519c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    /* renamed from: e */
    public int m2520e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    /* renamed from: f */
    public C9615n0 mo2521f(int i10, long j10) {
        C9615n0 c9615n0 = this.f1735f;
        if (c9615n0 != null) {
            c9615n0.m60109c();
        }
        if (i10 != 0) {
            C9615n0 c9615n0M60108b = C9603h0.m59879e(this).m60108b(0.0f);
            c9615n0M60108b.m60111f(j10);
            c9615n0M60108b.m60113h(this.f1730a.m2523d(c9615n0M60108b, i10));
            return c9615n0M60108b;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C9615n0 c9615n0M60108b2 = C9603h0.m59879e(this).m60108b(1.0f);
        c9615n0M60108b2.m60111f(j10);
        c9615n0M60108b2.m60113h(this.f1730a.m2523d(c9615n0M60108b2, i10));
        return c9615n0M60108b2;
    }

    public int getAnimatedVisibility() {
        return this.f1735f != null ? this.f1730a.f1739b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1734e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1733d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m2575I(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1737h = false;
        }
        if (!this.f1737h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1737h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1737h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1736g = false;
        }
        if (!this.f1736g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1736g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1736g = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f1734e = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            C9615n0 c9615n0 = this.f1735f;
            if (c9615n0 != null) {
                c9615n0.m60109c();
            }
            super.setVisibility(i10);
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1730a = new C0421a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1731b = context;
        } else {
            this.f1731b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
