package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.widget.C0523e0;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0415l.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    public C0411h f1510a;

    /* renamed from: b */
    public ImageView f1511b;

    /* renamed from: c */
    public RadioButton f1512c;

    /* renamed from: d */
    public TextView f1513d;

    /* renamed from: e */
    public CheckBox f1514e;

    /* renamed from: f */
    public TextView f1515f;

    /* renamed from: g */
    public ImageView f1516g;

    /* renamed from: h */
    public ImageView f1517h;

    /* renamed from: i */
    public LinearLayout f1518i;

    /* renamed from: j */
    public Drawable f1519j;

    /* renamed from: k */
    public int f1520k;

    /* renamed from: l */
    public Context f1521l;

    /* renamed from: m */
    public boolean f1522m;

    /* renamed from: n */
    public Drawable f1523n;

    /* renamed from: o */
    public boolean f1524o;

    /* renamed from: p */
    public LayoutInflater f1525p;

    /* renamed from: q */
    public boolean f1526q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f1525p == null) {
            this.f1525p = LayoutInflater.from(getContext());
        }
        return this.f1525p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f1516g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    /* renamed from: a */
    public final void m2329a(View view) {
        m2330b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1517h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1517h.getLayoutParams();
        rect.top += this.f1517h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: b */
    public final void m2330b(View view, int i10) {
        LinearLayout linearLayout = this.f1518i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    /* renamed from: c */
    public final void m2331c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1514e = checkBox;
        m2329a(checkBox);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: d */
    public boolean mo2319d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: e */
    public void mo2320e(C0411h c0411h, int i10) {
        this.f1510a = c0411h;
        setVisibility(c0411h.isVisible() ? 0 : 8);
        setTitle(c0411h.m2476i(this));
        setCheckable(c0411h.isCheckable());
        m2334h(c0411h.m2469A(), c0411h.m2474g());
        setIcon(c0411h.getIcon());
        setEnabled(c0411h.isEnabled());
        setSubMenuArrowVisible(c0411h.hasSubMenu());
        setContentDescription(c0411h.getContentDescription());
    }

    /* renamed from: f */
    public final void m2332f() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1511b = imageView;
        m2330b(imageView, 0);
    }

    /* renamed from: g */
    public final void m2333g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1512c = radioButton;
        m2329a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    public C0411h getItemData() {
        return this.f1510a;
    }

    /* renamed from: h */
    public void m2334h(boolean z10, char c10) {
        int i10 = (z10 && this.f1510a.m2469A()) ? 0 : 8;
        if (i10 == 0) {
            this.f1515f.setText(this.f1510a.m2475h());
        }
        if (this.f1515f.getVisibility() != i10) {
            this.f1515f.setVisibility(i10);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        C9603h0.m59910t0(this, this.f1519j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f1513d = textView;
        int i10 = this.f1520k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f1521l, i10);
        }
        this.f1515f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f1516g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1523n);
        }
        this.f1517h = (ImageView) findViewById(R$id.group_divider);
        this.f1518i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1511b != null && this.f1522m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1511b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f1512c == null && this.f1514e == null) {
            return;
        }
        if (this.f1510a.m2480m()) {
            if (this.f1512c == null) {
                m2333g();
            }
            compoundButton = this.f1512c;
            view = this.f1514e;
        } else {
            if (this.f1514e == null) {
                m2331c();
            }
            compoundButton = this.f1514e;
            view = this.f1512c;
        }
        if (z10) {
            compoundButton.setChecked(this.f1510a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1514e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1512c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f1510a.m2480m()) {
            if (this.f1512c == null) {
                m2333g();
            }
            compoundButton = this.f1512c;
        } else {
            if (this.f1514e == null) {
                m2331c();
            }
            compoundButton = this.f1514e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f1526q = z10;
        this.f1522m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f1517h;
        if (imageView != null) {
            imageView.setVisibility((this.f1524o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f1510a.m2493z() || this.f1526q;
        if (z10 || this.f1522m) {
            ImageView imageView = this.f1511b;
            if (imageView == null && drawable == null && !this.f1522m) {
                return;
            }
            if (imageView == null) {
                m2332f();
            }
            if (drawable == null && !this.f1522m) {
                this.f1511b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1511b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1511b.getVisibility() != 0) {
                this.f1511b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1513d.getVisibility() != 8) {
                this.f1513d.setVisibility(8);
            }
        } else {
            this.f1513d.setText(charSequence);
            if (this.f1513d.getVisibility() != 0) {
                this.f1513d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        C0523e0 c0523e0M2946v = C0523e0.m2946v(getContext(), attributeSet, R$styleable.MenuView, i10, 0);
        this.f1519j = c0523e0M2946v.m2953g(R$styleable.MenuView_android_itemBackground);
        this.f1520k = c0523e0M2946v.m2960n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f1522m = c0523e0M2946v.m2947a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f1521l = context;
        this.f1523n = c0523e0M2946v.m2953g(R$styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f1524o = typedArrayObtainStyledAttributes.hasValue(0);
        c0523e0M2946v.m2966w();
        typedArrayObtainStyledAttributes.recycle();
    }
}
