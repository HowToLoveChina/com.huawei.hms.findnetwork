package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0531i0;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements InterfaceC0415l.a, View.OnClickListener, ActionMenuView.InterfaceC0435a {

    /* renamed from: h */
    public C0411h f1495h;

    /* renamed from: i */
    public CharSequence f1496i;

    /* renamed from: j */
    public Drawable f1497j;

    /* renamed from: k */
    public MenuBuilder.InterfaceC0399b f1498k;

    /* renamed from: l */
    public AbstractViewOnTouchListenerC0546u f1499l;

    /* renamed from: m */
    public AbstractC0397b f1500m;

    /* renamed from: n */
    public boolean f1501n;

    /* renamed from: o */
    public boolean f1502o;

    /* renamed from: p */
    public int f1503p;

    /* renamed from: q */
    public int f1504q;

    /* renamed from: r */
    public int f1505r;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    public class C0396a extends AbstractViewOnTouchListenerC0546u {
        public C0396a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        /* renamed from: b */
        public InterfaceC0417n mo2324b() {
            AbstractC0397b abstractC0397b = ActionMenuItemView.this.f1500m;
            if (abstractC0397b != null) {
                return abstractC0397b.mo2326a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        /* renamed from: c */
        public boolean mo2325c() {
            InterfaceC0417n interfaceC0417nMo2324b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.InterfaceC0399b interfaceC0399b = actionMenuItemView.f1498k;
            return interfaceC0399b != null && interfaceC0399b.mo2327a(actionMenuItemView.f1495h) && (interfaceC0417nMo2324b = mo2324b()) != null && interfaceC0417nMo2324b.isShowing();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$b */
    public static abstract class AbstractC0397b {
        /* renamed from: a */
        public abstract InterfaceC0417n mo2326a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0435a
    /* renamed from: a */
    public boolean mo2317a() {
        return m2321r();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0435a
    /* renamed from: b */
    public boolean mo2318b() {
        return m2321r() && this.f1495h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: d */
    public boolean mo2319d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: e */
    public void mo2320e(C0411h c0411h, int i10) {
        this.f1495h = c0411h;
        setIcon(c0411h.getIcon());
        setTitle(c0411h.m2476i(this));
        setId(c0411h.getItemId());
        setVisibility(c0411h.isVisible() ? 0 : 8);
        setEnabled(c0411h.isEnabled());
        if (c0411h.hasSubMenu() && this.f1499l == null) {
            this.f1499l = new C0396a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    public C0411h getItemData() {
        return this.f1495h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.InterfaceC0399b interfaceC0399b = this.f1498k;
        if (interfaceC0399b != null) {
            interfaceC0399b.mo2327a(this.f1495h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1501n = m2322s();
        m2323t();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean zM2321r = m2321r();
        if (zM2321r && (i12 = this.f1504q) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1503p) : this.f1503p;
        if (mode != 1073741824 && this.f1503p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (zM2321r || this.f1497j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1497j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractViewOnTouchListenerC0546u abstractViewOnTouchListenerC0546u;
        if (this.f1495h.hasSubMenu() && (abstractViewOnTouchListenerC0546u = this.f1499l) != null && abstractViewOnTouchListenerC0546u.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: r */
    public boolean m2321r() {
        return !TextUtils.isEmpty(getText());
    }

    /* renamed from: s */
    public final boolean m2322s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f1502o != z10) {
            this.f1502o = z10;
            C0411h c0411h = this.f1495h;
            if (c0411h != null) {
                c0411h.m2471c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1497j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f1505r;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        m2323t();
    }

    public void setItemInvoker(MenuBuilder.InterfaceC0399b interfaceC0399b) {
        this.f1498k = interfaceC0399b;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f1504q = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(AbstractC0397b abstractC0397b) {
        this.f1500m = abstractC0397b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1496i = charSequence;
        m2323t();
    }

    /* renamed from: t */
    public final void m2323t() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1496i);
        if (this.f1497j != null && (!this.f1495h.m2470B() || (!this.f1501n && !this.f1502o))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f1496i : null);
        CharSequence contentDescription = this.f1495h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f1495h.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1495h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            C0531i0.m3033a(this, z12 ? null : this.f1495h.getTitle());
        } else {
            C0531i0.m3033a(this, tooltipText);
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f1501n = m2322s();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i10, 0);
        this.f1503p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1505r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1504q = -1;
        setSaveEnabled(false);
    }
}
