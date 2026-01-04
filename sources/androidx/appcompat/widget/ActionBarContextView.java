package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import p273f0.C9603h0;
import p273f0.C9615n0;
import p303g.AbstractC9814b;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: i */
    public CharSequence f1751i;

    /* renamed from: j */
    public CharSequence f1752j;

    /* renamed from: k */
    public View f1753k;

    /* renamed from: l */
    public View f1754l;

    /* renamed from: m */
    public View f1755m;

    /* renamed from: n */
    public LinearLayout f1756n;

    /* renamed from: o */
    public TextView f1757o;

    /* renamed from: p */
    public TextView f1758p;

    /* renamed from: q */
    public int f1759q;

    /* renamed from: r */
    public int f1760r;

    /* renamed from: s */
    public boolean f1761s;

    /* renamed from: t */
    public int f1762t;

    /* renamed from: androidx.appcompat.widget.ActionBarContextView$a */
    public class ViewOnClickListenerC0423a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ AbstractC9814b f1763a;

        public ViewOnClickListenerC0423a(AbstractC9814b abstractC9814b) {
            this.f1763a = abstractC9814b;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1763a.mo2285c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    /* renamed from: f */
    public /* bridge */ /* synthetic */ C9615n0 mo2521f(int i10, long j10) {
        return super.mo2521f(i10, j10);
    }

    /* renamed from: g */
    public void m2527g() {
        if (this.f1753k == null) {
            m2531k();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1752j;
    }

    public CharSequence getTitle() {
        return this.f1751i;
    }

    /* renamed from: h */
    public void m2528h(AbstractC9814b abstractC9814b) {
        View view = this.f1753k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f1762t, (ViewGroup) this, false);
            this.f1753k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f1753k);
        }
        View viewFindViewById = this.f1753k.findViewById(R$id.action_mode_close_button);
        this.f1754l = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0423a(abstractC9814b));
        MenuBuilder menuBuilder = (MenuBuilder) abstractC9814b.mo2287e();
        ActionMenuPresenter actionMenuPresenter = this.f1733d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m2568B();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1733d = actionMenuPresenter2;
        actionMenuPresenter2.m2579M(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.m2366c(this.f1733d, this.f1731b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1733d.mo2426r(this);
        this.f1732c = actionMenuView;
        C9603h0.m59910t0(actionMenuView, null);
        addView(this.f1732c, layoutParams);
    }

    /* renamed from: i */
    public final void m2529i() {
        if (this.f1756n == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1756n = linearLayout;
            this.f1757o = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f1758p = (TextView) this.f1756n.findViewById(R$id.action_bar_subtitle);
            if (this.f1759q != 0) {
                this.f1757o.setTextAppearance(getContext(), this.f1759q);
            }
            if (this.f1760r != 0) {
                this.f1758p.setTextAppearance(getContext(), this.f1760r);
            }
        }
        this.f1757o.setText(this.f1751i);
        this.f1758p.setText(this.f1752j);
        boolean z10 = !TextUtils.isEmpty(this.f1751i);
        boolean z11 = !TextUtils.isEmpty(this.f1752j);
        this.f1758p.setVisibility(z11 ? 0 : 8);
        this.f1756n.setVisibility((z10 || z11) ? 0 : 8);
        if (this.f1756n.getParent() == null) {
            addView(this.f1756n);
        }
    }

    /* renamed from: j */
    public boolean m2530j() {
        return this.f1761s;
    }

    /* renamed from: k */
    public void m2531k() {
        removeAllViews();
        this.f1755m = null;
        this.f1732c = null;
        this.f1733d = null;
        View view = this.f1754l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    /* renamed from: l */
    public boolean m2532l() {
        ActionMenuPresenter actionMenuPresenter = this.f1733d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.m2580N();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1733d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m2571E();
            this.f1733d.m2572F();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zM3056b = C0535k0.m3056b(this);
        int paddingRight = zM3056b ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1753k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1753k.getLayoutParams();
            int i14 = zM3056b ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zM3056b ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iM2518d = AbsActionBarView.m2518d(paddingRight, i14, zM3056b);
            paddingRight = AbsActionBarView.m2518d(iM2518d + m2520e(this.f1753k, iM2518d, paddingTop, paddingTop2, zM3056b), i15, zM3056b);
        }
        int iM2520e = paddingRight;
        LinearLayout linearLayout = this.f1756n;
        if (linearLayout != null && this.f1755m == null && linearLayout.getVisibility() != 8) {
            iM2520e += m2520e(this.f1756n, iM2520e, paddingTop, paddingTop2, zM3056b);
        }
        int i16 = iM2520e;
        View view2 = this.f1755m;
        if (view2 != null) {
            m2520e(view2, i16, paddingTop, paddingTop2, zM3056b);
        }
        int paddingLeft = zM3056b ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1732c;
        if (actionMenuView != null) {
            m2520e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zM3056b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.f1734e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1753k;
        if (view != null) {
            int iM2519c = m2519c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1753k.getLayoutParams();
            paddingLeft = iM2519c - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1732c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = m2519c(this.f1732c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1756n;
        if (linearLayout != null && this.f1755m == null) {
            if (this.f1761s) {
                this.f1756n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1756n.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f1756n.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = m2519c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1755m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i12 = layoutParams.width;
            int i13 = i12 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i12 >= 0) {
                paddingLeft = Math.min(i12, paddingLeft);
            }
            int i14 = layoutParams.height;
            int i15 = i14 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i14 >= 0) {
                iMin = Math.min(i14, iMin);
            }
            this.f1755m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f1734e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i10) {
        this.f1734e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1755m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1755m = view;
        if (view != null && (linearLayout = this.f1756n) != null) {
            removeView(linearLayout);
            this.f1756n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1752j = charSequence;
        m2529i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1751i = charSequence;
        m2529i();
        C9603h0.m59908s0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f1761s) {
            requestLayout();
        }
        this.f1761s = z10;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, R$styleable.ActionMode, i10, 0);
        C9603h0.m59910t0(this, c0523e0M2946v.m2953g(R$styleable.ActionMode_background));
        this.f1759q = c0523e0M2946v.m2960n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f1760r = c0523e0M2946v.m2960n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f1734e = c0523e0M2946v.m2959m(R$styleable.ActionMode_height, 0);
        this.f1762t = c0523e0M2946v.m2960n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        c0523e0M2946v.m2966w();
    }
}
