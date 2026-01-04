package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.C0336j;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.SubMenuC0419p;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p211d.C8968a;
import p273f0.C9603h0;
import p273f0.C9614n;
import p273f0.C9620q;
import p273f0.C9624s;
import p273f0.InterfaceC9622r;
import p273f0.InterfaceC9628u;
import p303g.InterfaceC9815c;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC9622r {

    /* renamed from: A */
    public ColorStateList f2199A;

    /* renamed from: B */
    public boolean f2200B;

    /* renamed from: C */
    public boolean f2201C;

    /* renamed from: D */
    public final ArrayList<View> f2202D;

    /* renamed from: E */
    public final ArrayList<View> f2203E;

    /* renamed from: F */
    public final int[] f2204F;

    /* renamed from: G */
    public final C9624s f2205G;

    /* renamed from: H */
    public ArrayList<MenuItem> f2206H;

    /* renamed from: I */
    public final ActionMenuView.InterfaceC0438d f2207I;

    /* renamed from: J */
    public C0529h0 f2208J;

    /* renamed from: K */
    public ActionMenuPresenter f2209K;

    /* renamed from: L */
    public C0511f f2210L;

    /* renamed from: M */
    public InterfaceC0414k.a f2211M;

    /* renamed from: N */
    public MenuBuilder.InterfaceC0398a f2212N;

    /* renamed from: O */
    public boolean f2213O;

    /* renamed from: P */
    public OnBackInvokedCallback f2214P;

    /* renamed from: Q */
    public OnBackInvokedDispatcher f2215Q;

    /* renamed from: R */
    public boolean f2216R;

    /* renamed from: S */
    public final Runnable f2217S;

    /* renamed from: a */
    public ActionMenuView f2218a;

    /* renamed from: b */
    public TextView f2219b;

    /* renamed from: c */
    public TextView f2220c;

    /* renamed from: d */
    public ImageButton f2221d;

    /* renamed from: e */
    public ImageView f2222e;

    /* renamed from: f */
    public Drawable f2223f;

    /* renamed from: g */
    public CharSequence f2224g;

    /* renamed from: h */
    public ImageButton f2225h;

    /* renamed from: i */
    public View f2226i;

    /* renamed from: j */
    public Context f2227j;

    /* renamed from: k */
    public int f2228k;

    /* renamed from: l */
    public int f2229l;

    /* renamed from: m */
    public int f2230m;

    /* renamed from: n */
    public int f2231n;

    /* renamed from: o */
    public int f2232o;

    /* renamed from: p */
    public int f2233p;

    /* renamed from: q */
    public int f2234q;

    /* renamed from: r */
    public int f2235r;

    /* renamed from: s */
    public int f2236s;

    /* renamed from: t */
    public C0550y f2237t;

    /* renamed from: u */
    public int f2238u;

    /* renamed from: v */
    public int f2239v;

    /* renamed from: w */
    public int f2240w;

    /* renamed from: x */
    public CharSequence f2241x;

    /* renamed from: y */
    public CharSequence f2242y;

    /* renamed from: z */
    public ColorStateList f2243z;

    /* renamed from: androidx.appcompat.widget.Toolbar$a */
    public class C0506a implements ActionMenuView.InterfaceC0438d {
        public C0506a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0438d
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f2205G.m60142d(menuItem)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$b */
    public class RunnableC0507b implements Runnable {
        public RunnableC0507b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.m2854R();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$c */
    public class C0508c implements MenuBuilder.InterfaceC0398a {
        public C0508c() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: a */
        public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
            MenuBuilder.InterfaceC0398a interfaceC0398a = Toolbar.this.f2212N;
            return interfaceC0398a != null && interfaceC0398a.mo2102a(menuBuilder, menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: b */
        public void mo2105b(MenuBuilder menuBuilder) {
            if (!Toolbar.this.f2218a.m2594J()) {
                Toolbar.this.f2205G.m60143e(menuBuilder);
            }
            MenuBuilder.InterfaceC0398a interfaceC0398a = Toolbar.this.f2212N;
            if (interfaceC0398a != null) {
                interfaceC0398a.mo2105b(menuBuilder);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$d */
    public class ViewOnClickListenerC0509d implements View.OnClickListener {
        public ViewOnClickListenerC0509d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.m2860f();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$e */
    public static class C0510e {
        /* renamed from: a */
        public static OnBackInvokedDispatcher m2884a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        /* renamed from: b */
        public static OnBackInvokedCallback m2885b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new C0336j(runnable);
        }

        /* renamed from: c */
        public static void m2886c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(Constants.MILLON, (OnBackInvokedCallback) obj2);
        }

        /* renamed from: d */
        public static void m2887d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$f */
    public class C0511f implements InterfaceC0414k {

        /* renamed from: a */
        public MenuBuilder f2251a;

        /* renamed from: b */
        public C0411h f2252b;

        public C0511f() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: a */
        public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: b */
        public void mo2414b(boolean z10) {
            if (this.f2252b != null) {
                MenuBuilder menuBuilder = this.f2251a;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f2251a.getItem(i10) == this.f2252b) {
                            return;
                        }
                    }
                }
                mo2415d(this.f2251a, this.f2252b);
            }
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: c */
        public boolean mo2439c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: d */
        public boolean mo2415d(MenuBuilder menuBuilder, C0411h c0411h) {
            KeyEvent.Callback callback = Toolbar.this.f2226i;
            if (callback instanceof InterfaceC9815c) {
                ((InterfaceC9815c) callback).mo2398f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2226i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2225h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2226i = null;
            toolbar3.m2856a();
            this.f2252b = null;
            Toolbar.this.requestLayout();
            c0411h.m2485r(false);
            Toolbar.this.m2855S();
            return true;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: e */
        public boolean mo2416e(MenuBuilder menuBuilder, C0411h c0411h) {
            Toolbar.this.m2862h();
            ViewParent parent = Toolbar.this.f2225h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2225h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2225h);
            }
            Toolbar.this.f2226i = c0411h.getActionView();
            this.f2252b = c0411h;
            ViewParent parent2 = Toolbar.this.f2226i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2226i);
                }
                LayoutParams layoutParamsGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                layoutParamsGenerateDefaultLayoutParams.f1145a = (toolbar4.f2231n & 112) | 8388611;
                layoutParamsGenerateDefaultLayoutParams.f2244b = 2;
                toolbar4.f2226i.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2226i);
            }
            Toolbar.this.m2847K();
            Toolbar.this.requestLayout();
            c0411h.m2485r(true);
            KeyEvent.Callback callback = Toolbar.this.f2226i;
            if (callback instanceof InterfaceC9815c) {
                ((InterfaceC9815c) callback).mo2397c();
            }
            Toolbar.this.m2855S();
            return true;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: g */
        public void mo2418g(Context context, MenuBuilder menuBuilder) {
            C0411h c0411h;
            MenuBuilder menuBuilder2 = this.f2251a;
            if (menuBuilder2 != null && (c0411h = this.f2252b) != null) {
                menuBuilder2.mo2372f(c0411h);
            }
            this.f2251a = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: h */
        public void mo2440h(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: i */
        public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k
        /* renamed from: k */
        public Parcelable mo2442k() {
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$g */
    public interface InterfaceC0512g {
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    /* renamed from: A */
    public void m2837A() {
        Iterator<MenuItem> it = this.f2206H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        m2845I();
    }

    /* renamed from: B */
    public final boolean m2838B(View view) {
        return view.getParent() == this || this.f2203E.contains(view);
    }

    /* renamed from: C */
    public boolean m2839C() {
        ActionMenuView actionMenuView = this.f2218a;
        return actionMenuView != null && actionMenuView.m2593I();
    }

    /* renamed from: D */
    public boolean m2840D() {
        ActionMenuView actionMenuView = this.f2218a;
        return actionMenuView != null && actionMenuView.m2594J();
    }

    /* renamed from: E */
    public final int m2841E(View view, int i10, int[] iArr, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int iM2872r = m2872r(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM2872r, iMax + measuredWidth, view.getMeasuredHeight() + iM2872r);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    /* renamed from: F */
    public final int m2842F(View view, int i10, int[] iArr, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iM2872r = m2872r(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM2872r, iMax, view.getMeasuredHeight() + iM2872r);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    /* renamed from: G */
    public final int m2843G(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + iMax + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    /* renamed from: H */
    public final void m2844H(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: I */
    public final void m2845I() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f2205G.m60140b(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f2206H = currentMenuItems2;
    }

    /* renamed from: J */
    public final void m2846J() {
        removeCallbacks(this.f2217S);
        post(this.f2217S);
    }

    /* renamed from: K */
    public void m2847K() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).f2244b != 2 && childAt != this.f2218a) {
                removeViewAt(childCount);
                this.f2203E.add(childAt);
            }
        }
    }

    /* renamed from: L */
    public void m2848L(int i10, int i11) {
        m2863i();
        this.f2237t.m3188g(i10, i11);
    }

    /* renamed from: M */
    public void m2849M(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.f2218a == null) {
            return;
        }
        m2866l();
        MenuBuilder menuBuilderM2597N = this.f2218a.m2597N();
        if (menuBuilderM2597N == menuBuilder) {
            return;
        }
        if (menuBuilderM2597N != null) {
            menuBuilderM2597N.m2352Q(this.f2209K);
            menuBuilderM2597N.m2352Q(this.f2210L);
        }
        if (this.f2210L == null) {
            this.f2210L = new C0511f();
        }
        actionMenuPresenter.m2576J(true);
        if (menuBuilder != null) {
            menuBuilder.m2366c(actionMenuPresenter, this.f2227j);
            menuBuilder.m2366c(this.f2210L, this.f2227j);
        } else {
            actionMenuPresenter.mo2418g(this.f2227j, null);
            this.f2210L.mo2418g(this.f2227j, null);
            actionMenuPresenter.mo2414b(true);
            this.f2210L.mo2414b(true);
        }
        this.f2218a.setPopupTheme(this.f2228k);
        this.f2218a.setPresenter(actionMenuPresenter);
        this.f2209K = actionMenuPresenter;
        m2855S();
    }

    /* renamed from: N */
    public void m2850N(Context context, int i10) {
        this.f2230m = i10;
        TextView textView = this.f2220c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    /* renamed from: O */
    public void m2851O(Context context, int i10) {
        this.f2229l = i10;
        TextView textView = this.f2219b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    /* renamed from: P */
    public final boolean m2852P() {
        if (!this.f2213O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (m2853Q(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Q */
    public final boolean m2853Q(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: R */
    public boolean m2854R() {
        ActionMenuView actionMenuView = this.f2218a;
        return actionMenuView != null && actionMenuView.m2599P();
    }

    /* renamed from: S */
    public void m2855S() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherM2884a = C0510e.m2884a(this);
            boolean z10 = m2877x() && onBackInvokedDispatcherM2884a != null && C9603h0.m59863S(this) && this.f2216R;
            if (z10 && this.f2215Q == null) {
                if (this.f2214P == null) {
                    this.f2214P = C0510e.m2885b(new Runnable() { // from class: androidx.appcompat.widget.f0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2330a.m2860f();
                        }
                    });
                }
                C0510e.m2886c(onBackInvokedDispatcherM2884a, this.f2214P);
                this.f2215Q = onBackInvokedDispatcherM2884a;
                return;
            }
            if (z10 || (onBackInvokedDispatcher = this.f2215Q) == null) {
                return;
            }
            C0510e.m2887d(onBackInvokedDispatcher, this.f2214P);
            this.f2215Q = null;
        }
    }

    /* renamed from: a */
    public void m2856a() {
        for (int size = this.f2203E.size() - 1; size >= 0; size--) {
            addView(this.f2203E.get(size));
        }
        this.f2203E.clear();
    }

    /* renamed from: b */
    public final void m2857b(List<View> list, int i10) {
        boolean z10 = C9603h0.m59832A(this) == 1;
        int childCount = getChildCount();
        int iM60102b = C9614n.m60102b(i10, C9603h0.m59832A(this));
        list.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2244b == 0 && m2853Q(childAt) && m2871q(layoutParams.f1145a) == iM60102b) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f2244b == 0 && m2853Q(childAt2) && m2871q(layoutParams2.f1145a) == iM60102b) {
                list.add(childAt2);
            }
        }
    }

    @Override // p273f0.InterfaceC9622r
    /* renamed from: c */
    public void mo1914c(InterfaceC9628u interfaceC9628u) {
        this.f2205G.m60139a(interfaceC9628u);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* renamed from: d */
    public final void m2858d(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParamsGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        layoutParamsGenerateDefaultLayoutParams.f2244b = 1;
        if (!z10 || this.f2226i == null) {
            addView(view, layoutParamsGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.f2203E.add(view);
        }
    }

    /* renamed from: e */
    public boolean m2859e() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2218a) != null && actionMenuView.m2595K();
    }

    /* renamed from: f */
    public void m2860f() {
        C0511f c0511f = this.f2210L;
        C0411h c0411h = c0511f == null ? null : c0511f.f2252b;
        if (c0411h != null) {
            c0411h.collapseActionView();
        }
    }

    /* renamed from: g */
    public void m2861g() {
        ActionMenuView actionMenuView = this.f2218a;
        if (actionMenuView != null) {
            actionMenuView.m2586B();
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f2225h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f2225h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        C0550y c0550y = this.f2237t;
        if (c0550y != null) {
            return c0550y.m3182a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f2239v;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        C0550y c0550y = this.f2237t;
        if (c0550y != null) {
            return c0550y.m3183b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        C0550y c0550y = this.f2237t;
        if (c0550y != null) {
            return c0550y.m3184c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        C0550y c0550y = this.f2237t;
        if (c0550y != null) {
            return c0550y.m3185d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f2238u;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder menuBuilderM2597N;
        ActionMenuView actionMenuView = this.f2218a;
        return (actionMenuView == null || (menuBuilderM2597N = actionMenuView.m2597N()) == null || !menuBuilderM2597N.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f2239v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return C9603h0.m59832A(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return C9603h0.m59832A(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2238u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f2222e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f2222e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m2865k();
        return this.f2218a.getMenu();
    }

    public View getNavButtonView() {
        return this.f2221d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2221d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2221d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f2209K;
    }

    public Drawable getOverflowIcon() {
        m2865k();
        return this.f2218a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f2227j;
    }

    public int getPopupTheme() {
        return this.f2228k;
    }

    public CharSequence getSubtitle() {
        return this.f2242y;
    }

    public final TextView getSubtitleTextView() {
        return this.f2220c;
    }

    public CharSequence getTitle() {
        return this.f2241x;
    }

    public int getTitleMarginBottom() {
        return this.f2236s;
    }

    public int getTitleMarginEnd() {
        return this.f2234q;
    }

    public int getTitleMarginStart() {
        return this.f2233p;
    }

    public int getTitleMarginTop() {
        return this.f2235r;
    }

    public final TextView getTitleTextView() {
        return this.f2219b;
    }

    public InterfaceC0543r getWrapper() {
        if (this.f2208J == null) {
            this.f2208J = new C0529h0(this, true);
        }
        return this.f2208J;
    }

    /* renamed from: h */
    public void m2862h() {
        if (this.f2225h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f2225h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f2223f);
            this.f2225h.setContentDescription(this.f2224g);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f1145a = (this.f2231n & 112) | 8388611;
            layoutParamsGenerateDefaultLayoutParams.f2244b = 2;
            this.f2225h.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.f2225h.setOnClickListener(new ViewOnClickListenerC0509d());
        }
    }

    /* renamed from: i */
    public final void m2863i() {
        if (this.f2237t == null) {
            this.f2237t = new C0550y();
        }
    }

    /* renamed from: j */
    public final void m2864j() {
        if (this.f2222e == null) {
            this.f2222e = new AppCompatImageView(getContext());
        }
    }

    /* renamed from: k */
    public final void m2865k() {
        m2866l();
        if (this.f2218a.m2597N() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f2218a.getMenu();
            if (this.f2210L == null) {
                this.f2210L = new C0511f();
            }
            this.f2218a.setExpandedActionViewsExclusive(true);
            menuBuilder.m2366c(this.f2210L, this.f2227j);
            m2855S();
        }
    }

    /* renamed from: l */
    public final void m2866l() {
        if (this.f2218a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f2218a = actionMenuView;
            actionMenuView.setPopupTheme(this.f2228k);
            this.f2218a.setOnMenuItemClickListener(this.f2207I);
            this.f2218a.m2598O(this.f2211M, new C0508c());
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f1145a = (this.f2231n & 112) | 8388613;
            this.f2218a.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            m2858d(this.f2218a, false);
        }
    }

    /* renamed from: m */
    public final void m2867m() {
        if (this.f2221d == null) {
            this.f2221d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f1145a = (this.f2231n & 112) | 8388611;
            this.f2221d.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2855S();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2217S);
        m2855S();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2201C = false;
        }
        if (!this.f2201C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2201C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2201C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.f2204F;
        boolean zM3056b = C0535k0.m3056b(this);
        int i12 = !zM3056b ? 1 : 0;
        if (m2853Q(this.f2221d)) {
            m2844H(this.f2221d, i10, 0, i11, 0, this.f2232o);
            measuredWidth = this.f2221d.getMeasuredWidth() + m2874u(this.f2221d);
            iMax = Math.max(0, this.f2221d.getMeasuredHeight() + m2875v(this.f2221d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2221d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m2853Q(this.f2225h)) {
            m2844H(this.f2225h, i10, 0, i11, 0, this.f2232o);
            measuredWidth = this.f2225h.getMeasuredWidth() + m2874u(this.f2225h);
            iMax = Math.max(iMax, this.f2225h.getMeasuredHeight() + m2875v(this.f2225h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2225h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zM3056b ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (m2853Q(this.f2218a)) {
            m2844H(this.f2218a, i10, iMax3, i11, 0, this.f2232o);
            measuredWidth2 = this.f2218a.getMeasuredWidth() + m2874u(this.f2218a);
            iMax = Math.max(iMax, this.f2218a.getMeasuredHeight() + m2875v(this.f2218a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2218a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i12] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (m2853Q(this.f2226i)) {
            iMax4 += m2843G(this.f2226i, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f2226i.getMeasuredHeight() + m2875v(this.f2226i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2226i.getMeasuredState());
        }
        if (m2853Q(this.f2222e)) {
            iMax4 += m2843G(this.f2222e, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f2222e.getMeasuredHeight() + m2875v(this.f2222e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2222e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((LayoutParams) childAt.getLayoutParams()).f2244b == 0 && m2853Q(childAt)) {
                iMax4 += m2843G(childAt, i10, iMax4, i11, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + m2875v(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i14 = this.f2235r + this.f2236s;
        int i15 = this.f2233p + this.f2234q;
        if (m2853Q(this.f2219b)) {
            m2843G(this.f2219b, i10, iMax4 + i15, i11, i14, iArr);
            int measuredWidth3 = this.f2219b.getMeasuredWidth() + m2874u(this.f2219b);
            measuredHeight = this.f2219b.getMeasuredHeight() + m2875v(this.f2219b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2219b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (m2853Q(this.f2220c)) {
            iMax2 = Math.max(iMax2, m2843G(this.f2220c, i10, iMax4 + i15, i11, measuredHeight + i14, iArr));
            measuredHeight += this.f2220c.getMeasuredHeight() + m2875v(this.f2220c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2220c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, (-16777216) & iCombineMeasuredStates2), m2852P() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f2218a;
        MenuBuilder menuBuilderM2597N = actionMenuView != null ? actionMenuView.m2597N() : null;
        int i10 = savedState.f2245d;
        if (i10 != 0 && this.f2210L != null && menuBuilderM2597N != null && (menuItemFindItem = menuBuilderM2597N.findItem(i10)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f2246e) {
            m2846J();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        m2863i();
        this.f2237t.m3187f(i10 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0411h c0411h;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0511f c0511f = this.f2210L;
        if (c0511f != null && (c0411h = c0511f.f2252b) != null) {
            savedState.f2245d = c0411h.getItemId();
        }
        savedState.f2246e = m2840D();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2200B = false;
        }
        if (!this.f2200B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2200B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2200B = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ActionBar.LayoutParams ? new LayoutParams((ActionBar.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* renamed from: q */
    public final int m2871q(int i10) {
        int iM59832A = C9603h0.m59832A(this);
        int iM60102b = C9614n.m60102b(i10, iM59832A) & 7;
        return (iM60102b == 1 || iM60102b == 3 || iM60102b == 5) ? iM60102b : iM59832A == 1 ? 5 : 3;
    }

    /* renamed from: r */
    public final int m2872r(View view, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int iM2873s = m2873s(layoutParams.f1145a);
        if (iM2873s == 48) {
            return getPaddingTop() - i11;
        }
        if (iM2873s == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    /* renamed from: s */
    public final int m2873s(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f2240w & 112;
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f2216R != z10) {
            this.f2216R = z10;
            m2855S();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(C8968a.m56743b(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.f2213O = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f2239v) {
            this.f2239v = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f2238u) {
            this.f2238u = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(C8968a.m56743b(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(C8968a.m56743b(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m2867m();
        this.f2221d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(InterfaceC0512g interfaceC0512g) {
    }

    public void setOverflowIcon(Drawable drawable) {
        m2865k();
        this.f2218a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f2228k != i10) {
            this.f2228k = i10;
            if (i10 == 0) {
                this.f2227j = getContext();
            } else {
                this.f2227j = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f2236s = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f2234q = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f2233p = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f2235r = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    @Override // p273f0.InterfaceC9622r
    /* renamed from: t */
    public void mo1923t(InterfaceC9628u interfaceC9628u) {
        this.f2205G.m60144f(interfaceC9628u);
    }

    /* renamed from: u */
    public final int m2874u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C9620q.m60124b(marginLayoutParams) + C9620q.m60123a(marginLayoutParams);
    }

    /* renamed from: v */
    public final int m2875v(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: w */
    public final int m2876w(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int measuredWidth = 0;
        while (i12 < size) {
            View view = list.get(i12);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i10;
            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i11;
            int iMax = Math.max(0, i13);
            int iMax2 = Math.max(0, i14);
            int iMax3 = Math.max(0, -i13);
            int iMax4 = Math.max(0, -i14);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i12++;
            i11 = iMax4;
            i10 = iMax3;
        }
        return measuredWidth;
    }

    /* renamed from: x */
    public boolean m2877x() {
        C0511f c0511f = this.f2210L;
        return (c0511f == null || c0511f.f2252b == null) ? false : true;
    }

    /* renamed from: y */
    public boolean m2878y() {
        ActionMenuView actionMenuView = this.f2218a;
        return actionMenuView != null && actionMenuView.m2592H();
    }

    /* renamed from: z */
    public void m2879z(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b */
        public int f2244b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2244b = 0;
        }

        /* renamed from: a */
        public void m2880a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f2244b = 0;
            this.f1145a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f2244b = 0;
            this.f2244b = layoutParams.f2244b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2244b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2244b = 0;
            m2880a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2244b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2862h();
        }
        ImageButton imageButton = this.f2225h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            m2862h();
            this.f2225h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f2225h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f2223f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2864j();
            if (!m2838B(this.f2222e)) {
                m2858d(this.f2222e, true);
            }
        } else {
            ImageView imageView = this.f2222e;
            if (imageView != null && m2838B(imageView)) {
                removeView(this.f2222e);
                this.f2203E.remove(this.f2222e);
            }
        }
        ImageView imageView2 = this.f2222e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2864j();
        }
        ImageView imageView = this.f2222e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2867m();
        }
        ImageButton imageButton = this.f2221d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            C0531i0.m3033a(this.f2221d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2867m();
            if (!m2838B(this.f2221d)) {
                m2858d(this.f2221d, true);
            }
        } else {
            ImageButton imageButton = this.f2221d;
            if (imageButton != null && m2838B(imageButton)) {
                removeView(this.f2221d);
                this.f2203E.remove(this.f2221d);
            }
        }
        ImageButton imageButton2 = this.f2221d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2220c;
            if (textView != null && m2838B(textView)) {
                removeView(this.f2220c);
                this.f2203E.remove(this.f2220c);
            }
        } else {
            if (this.f2220c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2220c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2220c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f2230m;
                if (i10 != 0) {
                    this.f2220c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f2199A;
                if (colorStateList != null) {
                    this.f2220c.setTextColor(colorStateList);
                }
            }
            if (!m2838B(this.f2220c)) {
                m2858d(this.f2220c, true);
            }
        }
        TextView textView2 = this.f2220c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2242y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f2199A = colorStateList;
        TextView textView = this.f2220c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2219b;
            if (textView != null && m2838B(textView)) {
                removeView(this.f2219b);
                this.f2203E.remove(this.f2219b);
            }
        } else {
            if (this.f2219b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2219b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2219b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f2229l;
                if (i10 != 0) {
                    this.f2219b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f2243z;
                if (colorStateList != null) {
                    this.f2219b.setTextColor(colorStateList);
                }
            }
            if (!m2838B(this.f2219b)) {
                m2858d(this.f2219b, true);
            }
        }
        TextView textView2 = this.f2219b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2241x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f2243z = colorStateList;
        TextView textView = this.f2219b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0505a();

        /* renamed from: d */
        public int f2245d;

        /* renamed from: e */
        public boolean f2246e;

        /* renamed from: androidx.appcompat.widget.Toolbar$SavedState$a */
        public class C0505a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2245d = parcel.readInt();
            this.f2246e = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2245d);
            parcel.writeInt(this.f2246e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2240w = 8388627;
        this.f2202D = new ArrayList<>();
        this.f2203E = new ArrayList<>();
        this.f2204F = new int[2];
        this.f2205G = new C9624s(new Runnable() { // from class: androidx.appcompat.widget.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2333a.m2837A();
            }
        });
        this.f2206H = new ArrayList<>();
        this.f2207I = new C0506a();
        this.f2217S = new RunnableC0507b();
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context2, attributeSet, iArr, i10, 0);
        C9603h0.m59898n0(this, context, iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        this.f2229l = c0523e0M2946v.m2960n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f2230m = c0523e0M2946v.m2960n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f2240w = c0523e0M2946v.m2958l(R$styleable.Toolbar_android_gravity, this.f2240w);
        this.f2231n = c0523e0M2946v.m2958l(R$styleable.Toolbar_buttonGravity, 48);
        int iM2951e = c0523e0M2946v.m2951e(R$styleable.Toolbar_titleMargin, 0);
        int i11 = R$styleable.Toolbar_titleMargins;
        iM2951e = c0523e0M2946v.m2965s(i11) ? c0523e0M2946v.m2951e(i11, iM2951e) : iM2951e;
        this.f2236s = iM2951e;
        this.f2235r = iM2951e;
        this.f2234q = iM2951e;
        this.f2233p = iM2951e;
        int iM2951e2 = c0523e0M2946v.m2951e(R$styleable.Toolbar_titleMarginStart, -1);
        if (iM2951e2 >= 0) {
            this.f2233p = iM2951e2;
        }
        int iM2951e3 = c0523e0M2946v.m2951e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iM2951e3 >= 0) {
            this.f2234q = iM2951e3;
        }
        int iM2951e4 = c0523e0M2946v.m2951e(R$styleable.Toolbar_titleMarginTop, -1);
        if (iM2951e4 >= 0) {
            this.f2235r = iM2951e4;
        }
        int iM2951e5 = c0523e0M2946v.m2951e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iM2951e5 >= 0) {
            this.f2236s = iM2951e5;
        }
        this.f2232o = c0523e0M2946v.m2952f(R$styleable.Toolbar_maxButtonHeight, -1);
        int iM2951e6 = c0523e0M2946v.m2951e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iM2951e7 = c0523e0M2946v.m2951e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iM2952f = c0523e0M2946v.m2952f(R$styleable.Toolbar_contentInsetLeft, 0);
        int iM2952f2 = c0523e0M2946v.m2952f(R$styleable.Toolbar_contentInsetRight, 0);
        m2863i();
        this.f2237t.m3186e(iM2952f, iM2952f2);
        if (iM2951e6 != Integer.MIN_VALUE || iM2951e7 != Integer.MIN_VALUE) {
            this.f2237t.m3188g(iM2951e6, iM2951e7);
        }
        this.f2238u = c0523e0M2946v.m2951e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2239v = c0523e0M2946v.m2951e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2223f = c0523e0M2946v.m2953g(R$styleable.Toolbar_collapseIcon);
        this.f2224g = c0523e0M2946v.m2962p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceM2962p = c0523e0M2946v.m2962p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceM2962p)) {
            setTitle(charSequenceM2962p);
        }
        CharSequence charSequenceM2962p2 = c0523e0M2946v.m2962p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceM2962p2)) {
            setSubtitle(charSequenceM2962p2);
        }
        this.f2227j = getContext();
        setPopupTheme(c0523e0M2946v.m2960n(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableM2953g = c0523e0M2946v.m2953g(R$styleable.Toolbar_navigationIcon);
        if (drawableM2953g != null) {
            setNavigationIcon(drawableM2953g);
        }
        CharSequence charSequenceM2962p3 = c0523e0M2946v.m2962p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceM2962p3)) {
            setNavigationContentDescription(charSequenceM2962p3);
        }
        Drawable drawableM2953g2 = c0523e0M2946v.m2953g(R$styleable.Toolbar_logo);
        if (drawableM2953g2 != null) {
            setLogo(drawableM2953g2);
        }
        CharSequence charSequenceM2962p4 = c0523e0M2946v.m2962p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceM2962p4)) {
            setLogoDescription(charSequenceM2962p4);
        }
        int i12 = R$styleable.Toolbar_titleTextColor;
        if (c0523e0M2946v.m2965s(i12)) {
            setTitleTextColor(c0523e0M2946v.m2949c(i12));
        }
        int i13 = R$styleable.Toolbar_subtitleTextColor;
        if (c0523e0M2946v.m2965s(i13)) {
            setSubtitleTextColor(c0523e0M2946v.m2949c(i13));
        }
        int i14 = R$styleable.Toolbar_menu;
        if (c0523e0M2946v.m2965s(i14)) {
            m2879z(c0523e0M2946v.m2960n(i14, 0));
        }
        c0523e0M2946v.m2966w();
    }
}
