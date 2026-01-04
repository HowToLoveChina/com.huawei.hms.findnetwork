package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C6051p9;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    public boolean f1741a;

    /* renamed from: b */
    public View f1742b;

    /* renamed from: c */
    public View f1743c;

    /* renamed from: d */
    public View f1744d;

    /* renamed from: e */
    public Drawable f1745e;

    /* renamed from: f */
    public Drawable f1746f;

    /* renamed from: g */
    public Drawable f1747g;

    /* renamed from: h */
    public boolean f1748h;

    /* renamed from: i */
    public boolean f1749i;

    /* renamed from: j */
    public int f1750j;

    /* renamed from: androidx.appcompat.widget.ActionBarContainer$a */
    public static class C0422a {
        /* renamed from: a */
        public static void m2526a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final int m2524a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: b */
    public final boolean m2525b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1745e;
        if (drawable != null && drawable.isStateful()) {
            this.f1745e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1746f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1746f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1747g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1747g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1742b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1745e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1746f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1747g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1743c = findViewById(R$id.action_bar);
        this.f1744d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1741a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f1742b;
        boolean z11 = true;
        boolean z12 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            view.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f1748h) {
            Drawable drawable2 = this.f1747g;
            if (drawable2 == null) {
                return;
            } else {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            if (this.f1745e == null) {
                z11 = false;
            } else if (this.f1743c.getVisibility() == 0) {
                this.f1745e.setBounds(this.f1743c.getLeft(), this.f1743c.getTop(), this.f1743c.getRight(), this.f1743c.getBottom());
            } else {
                View view2 = this.f1744d;
                if (view2 == null || view2.getVisibility() != 0) {
                    this.f1745e.setBounds(0, 0, 0, 0);
                } else {
                    this.f1745e.setBounds(this.f1744d.getLeft(), this.f1744d.getTop(), this.f1744d.getRight(), this.f1744d.getBottom());
                }
            }
            this.f1749i = z12;
            if (z12 && (drawable = this.f1746f) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else if (!z11) {
                return;
            }
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f1743c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f1750j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f1743c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f1742b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!m2525b(this.f1743c) ? m2524a(this.f1743c) : !m2525b(this.f1744d) ? m2524a(this.f1744d) : 0) + m2524a(this.f1742b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1745e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1745e);
        }
        this.f1745e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1743c;
            if (view != null) {
                this.f1745e.setBounds(view.getLeft(), this.f1743c.getTop(), this.f1743c.getRight(), this.f1743c.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f1748h ? !(this.f1745e != null || this.f1746f != null) : this.f1747g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        C0422a.m2526a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1747g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1747g);
        }
        this.f1747g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1748h && (drawable2 = this.f1747g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1748h ? !(this.f1745e != null || this.f1746f != null) : this.f1747g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        C0422a.m2526a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1746f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1746f);
        }
        this.f1746f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1749i && (drawable2 = this.f1746f) != null) {
                drawable2.setBounds(this.f1742b.getLeft(), this.f1742b.getTop(), this.f1742b.getRight(), this.f1742b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f1748h ? !(this.f1745e != null || this.f1746f != null) : this.f1747g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        C0422a.m2526a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1742b;
        if (view != null) {
            removeView(view);
        }
        this.f1742b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f1741a = z10;
        setDescendantFocusability(z10 ? ARImageMetadata.HOT_PIXEL_MODE : C6051p9.f27764p);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f1745e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1746f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1747g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1745e && !this.f1748h) || (drawable == this.f1746f && this.f1749i) || ((drawable == this.f1747g && this.f1748h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C9603h0.m59910t0(this, new C0514a(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f1745e = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f1746f = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f1750j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R$id.split_action_bar) {
            this.f1748h = true;
            this.f1747g = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1748h ? this.f1745e != null || this.f1746f != null : this.f1747g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
