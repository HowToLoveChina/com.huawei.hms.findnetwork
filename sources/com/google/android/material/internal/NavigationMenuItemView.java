package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.widget.C0531i0;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.C0669j;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;
import p757x.C13669a;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements InterfaceC0415l.a {

    /* renamed from: F */
    public static final int[] f8229F = {R.attr.state_checked};

    /* renamed from: A */
    public C0411h f8230A;

    /* renamed from: B */
    public ColorStateList f8231B;

    /* renamed from: C */
    public boolean f8232C;

    /* renamed from: D */
    public Drawable f8233D;

    /* renamed from: E */
    public final C9582a f8234E;

    /* renamed from: v */
    public int f8235v;

    /* renamed from: w */
    public boolean f8236w;

    /* renamed from: x */
    public boolean f8237x;

    /* renamed from: y */
    public final CheckedTextView f8238y;

    /* renamed from: z */
    public FrameLayout f8239z;

    /* renamed from: com.google.android.material.internal.NavigationMenuItemView$a */
    public class C1765a extends C9582a {
        public C1765a() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61063S(NavigationMenuItemView.this.f8237x);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f8239z == null) {
                this.f8239z = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.f8239z.removeAllViews();
            this.f8239z.addView(view);
        }
    }

    /* renamed from: B */
    public final void m10554B() {
        if (m10557E()) {
            this.f8238y.setVisibility(8);
            FrameLayout frameLayout = this.f8239z;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.f8239z.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f8238y.setVisibility(0);
        FrameLayout frameLayout2 = this.f8239z;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.f8239z.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: C */
    public final StateListDrawable m10555C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R$attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f8229F, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    /* renamed from: D */
    public void m10556D() {
        FrameLayout frameLayout = this.f8239z;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f8238y.setCompoundDrawables(null, null, null, null);
    }

    /* renamed from: E */
    public final boolean m10557E() {
        return this.f8230A.getTitle() == null && this.f8230A.getIcon() == null && this.f8230A.getActionView() != null;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: d */
    public boolean mo2319d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: e */
    public void mo2320e(C0411h c0411h, int i10) throws Resources.NotFoundException {
        this.f8230A = c0411h;
        if (c0411h.getItemId() > 0) {
            setId(c0411h.getItemId());
        }
        setVisibility(c0411h.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            C9603h0.m59910t0(this, m10555C());
        }
        setCheckable(c0411h.isCheckable());
        setChecked(c0411h.isChecked());
        setEnabled(c0411h.isEnabled());
        setTitle(c0411h.getTitle());
        setIcon(c0411h.getIcon());
        setActionView(c0411h.getActionView());
        setContentDescription(c0411h.getContentDescription());
        C0531i0.m3033a(this, c0411h.getTooltipText());
        m10554B();
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    public C0411h getItemData() {
        return this.f8230A;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        C0411h c0411h = this.f8230A;
        if (c0411h != null && c0411h.isCheckable() && this.f8230A.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8229F);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.f8237x != z10) {
            this.f8237x = z10;
            this.f8234E.sendAccessibilityEvent(this.f8238y, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.f8238y.setChecked(z10);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        if (drawable != null) {
            if (this.f8232C) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C13669a.m82231l(drawable).mutate();
                C13669a.m82228i(drawable, this.f8231B);
            }
            int i10 = this.f8235v;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.f8236w) {
            if (this.f8233D == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                this.f8233D = drawable2;
                if (drawable2 != null) {
                    int i11 = this.f8235v;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.f8233D;
        }
        C0669j.m4075i(this.f8238y, drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.f8238y.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.f8235v = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.f8231B = colorStateList;
        this.f8232C = colorStateList != null;
        C0411h c0411h = this.f8230A;
        if (c0411h != null) {
            setIcon(c0411h.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.f8238y.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.f8236w = z10;
    }

    public void setTextAppearance(int i10) {
        C0669j.m4080n(this.f8238y, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f8238y.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f8238y.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        C1765a c1765a = new C1765a();
        this.f8234E = c1765a;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.f8238y = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        C9603h0.m59902p0(checkedTextView, c1765a);
    }
}
