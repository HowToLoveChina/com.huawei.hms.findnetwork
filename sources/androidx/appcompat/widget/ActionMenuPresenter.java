package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.AbstractC0405b;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.C0413j;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.InterfaceC0417n;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.SubMenuC0419p;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;
import p303g.C9813a;
import p757x.C13669a;

/* loaded from: classes.dex */
class ActionMenuPresenter extends AbstractC0405b implements ActionProvider.InterfaceC0652a {

    /* renamed from: A */
    public RunnableC0432c f1800A;

    /* renamed from: B */
    public C0431b f1801B;

    /* renamed from: C */
    public final C0434e f1802C;

    /* renamed from: D */
    public int f1803D;

    /* renamed from: k */
    public OverflowMenuButton f1804k;

    /* renamed from: l */
    public Drawable f1805l;

    /* renamed from: m */
    public boolean f1806m;

    /* renamed from: n */
    public boolean f1807n;

    /* renamed from: o */
    public boolean f1808o;

    /* renamed from: p */
    public int f1809p;

    /* renamed from: q */
    public int f1810q;

    /* renamed from: r */
    public int f1811r;

    /* renamed from: s */
    public boolean f1812s;

    /* renamed from: t */
    public boolean f1813t;

    /* renamed from: u */
    public boolean f1814u;

    /* renamed from: v */
    public boolean f1815v;

    /* renamed from: w */
    public int f1816w;

    /* renamed from: x */
    public final SparseBooleanArray f1817x;

    /* renamed from: y */
    public C0433d f1818y;

    /* renamed from: z */
    public C0430a f1819z;

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.InterfaceC0435a {

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton$a */
        public class C0428a extends AbstractViewOnTouchListenerC0546u {

            /* renamed from: j */
            public final /* synthetic */ ActionMenuPresenter f1821j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0428a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f1821j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
            /* renamed from: b */
            public InterfaceC0417n mo2324b() {
                C0433d c0433d = ActionMenuPresenter.this.f1818y;
                if (c0433d == null) {
                    return null;
                }
                return c0433d.m2501c();
            }

            @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
            /* renamed from: c */
            public boolean mo2325c() {
                ActionMenuPresenter.this.m2580N();
                return true;
            }

            @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
            /* renamed from: d */
            public boolean mo2582d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f1800A != null) {
                    return false;
                }
                actionMenuPresenter.m2571E();
                return true;
            }
        }

        public OverflowMenuButton(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0531i0.m3033a(this, getContentDescription());
            setOnTouchListener(new C0428a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0435a
        /* renamed from: a */
        public boolean mo2317a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0435a
        /* renamed from: b */
        public boolean mo2318b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.m2580N();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C13669a.m82225f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0429a();

        /* renamed from: a */
        public int f1823a;

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$SavedState$a */
        public class C0429a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1823a);
        }

        public SavedState(Parcel parcel) {
            this.f1823a = parcel.readInt();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$a */
    public class C0430a extends C0413j {
        public C0430a(Context context, SubMenuC0419p subMenuC0419p, View view) {
            super(context, subMenuC0419p, view, false, R$attr.actionOverflowMenuStyle);
            if (!((C0411h) subMenuC0419p.getItem()).m2479l()) {
                View view2 = ActionMenuPresenter.this.f1804k;
                m2504f(view2 == null ? (View) ActionMenuPresenter.this.f1593i : view2);
            }
            m2508j(ActionMenuPresenter.this.f1802C);
        }

        @Override // androidx.appcompat.view.menu.C0413j
        /* renamed from: e */
        public void mo2503e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f1819z = null;
            actionMenuPresenter.f1803D = 0;
            super.mo2503e();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$b */
    public class C0431b extends ActionMenuItemView.AbstractC0397b {
        public C0431b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.AbstractC0397b
        /* renamed from: a */
        public InterfaceC0417n mo2326a() {
            C0430a c0430a = ActionMenuPresenter.this.f1819z;
            if (c0430a != null) {
                return c0430a.m2501c();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$c */
    public class RunnableC0432c implements Runnable {

        /* renamed from: a */
        public C0433d f1826a;

        public RunnableC0432c(C0433d c0433d) {
            this.f1826a = c0433d;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f1587c != null) {
                ActionMenuPresenter.this.f1587c.m2368d();
            }
            View view = (View) ActionMenuPresenter.this.f1593i;
            if (view != null && view.getWindowToken() != null && this.f1826a.m2511m()) {
                ActionMenuPresenter.this.f1818y = this.f1826a;
            }
            ActionMenuPresenter.this.f1800A = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$d */
    public class C0433d extends C0413j {
        public C0433d(Context context, MenuBuilder menuBuilder, View view, boolean z10) {
            super(context, menuBuilder, view, z10, R$attr.actionOverflowMenuStyle);
            m2506h(8388613);
            m2508j(ActionMenuPresenter.this.f1802C);
        }

        @Override // androidx.appcompat.view.menu.C0413j
        /* renamed from: e */
        public void mo2503e() {
            if (ActionMenuPresenter.this.f1587c != null) {
                ActionMenuPresenter.this.f1587c.close();
            }
            ActionMenuPresenter.this.f1818y = null;
            super.mo2503e();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$e */
    public class C0434e implements InterfaceC0414k.a {
        public C0434e() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: a */
        public void mo2158a(MenuBuilder menuBuilder, boolean z10) {
            if (menuBuilder instanceof SubMenuC0419p) {
                menuBuilder.mo2341F().m2370e(false);
            }
            InterfaceC0414k.a aVarM2424p = ActionMenuPresenter.this.m2424p();
            if (aVarM2424p != null) {
                aVarM2424p.mo2158a(menuBuilder, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: b */
        public boolean mo2159b(MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.f1587c) {
                return false;
            }
            ActionMenuPresenter.this.f1803D = ((SubMenuC0419p) menuBuilder).getItem().getItemId();
            InterfaceC0414k.a aVarM2424p = ActionMenuPresenter.this.m2424p();
            if (aVarM2424p != null) {
                return aVarM2424p.mo2159b(menuBuilder);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f1817x = new SparseBooleanArray();
        this.f1802C = new C0434e();
    }

    /* renamed from: B */
    public boolean m2568B() {
        return m2572F() | m2571E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    public final View m2569C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1593i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof InterfaceC0415l.a) && ((InterfaceC0415l.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: D */
    public Drawable m2570D() {
        OverflowMenuButton overflowMenuButton = this.f1804k;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f1806m) {
            return this.f1805l;
        }
        return null;
    }

    /* renamed from: E */
    public boolean m2571E() {
        Object obj;
        RunnableC0432c runnableC0432c = this.f1800A;
        if (runnableC0432c != null && (obj = this.f1593i) != null) {
            ((View) obj).removeCallbacks(runnableC0432c);
            this.f1800A = null;
            return true;
        }
        C0433d c0433d = this.f1818y;
        if (c0433d == null) {
            return false;
        }
        c0433d.m2500b();
        return true;
    }

    /* renamed from: F */
    public boolean m2572F() {
        C0430a c0430a = this.f1819z;
        if (c0430a == null) {
            return false;
        }
        c0430a.m2500b();
        return true;
    }

    /* renamed from: G */
    public boolean m2573G() {
        return this.f1800A != null || m2574H();
    }

    /* renamed from: H */
    public boolean m2574H() {
        C0433d c0433d = this.f1818y;
        return c0433d != null && c0433d.m2502d();
    }

    /* renamed from: I */
    public void m2575I(Configuration configuration) {
        if (!this.f1812s) {
            this.f1811r = C9813a.m60992b(this.f1586b).m60995d();
        }
        MenuBuilder menuBuilder = this.f1587c;
        if (menuBuilder != null) {
            menuBuilder.mo2348M(true);
        }
    }

    /* renamed from: J */
    public void m2576J(boolean z10) {
        this.f1815v = z10;
    }

    /* renamed from: K */
    public void m2577K(ActionMenuView actionMenuView) {
        this.f1593i = actionMenuView;
        actionMenuView.mo2328b(this.f1587c);
    }

    /* renamed from: L */
    public void m2578L(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f1804k;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.f1806m = true;
            this.f1805l = drawable;
        }
    }

    /* renamed from: M */
    public void m2579M(boolean z10) {
        this.f1807n = z10;
        this.f1808o = true;
    }

    /* renamed from: N */
    public boolean m2580N() {
        MenuBuilder menuBuilder;
        if (!this.f1807n || m2574H() || (menuBuilder = this.f1587c) == null || this.f1593i == null || this.f1800A != null || menuBuilder.m2338B().isEmpty()) {
            return false;
        }
        RunnableC0432c runnableC0432c = new RunnableC0432c(new C0433d(this.f1586b, this.f1587c, this.f1804k, true));
        this.f1800A = runnableC0432c;
        ((View) this.f1593i).post(runnableC0432c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b, androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        m2568B();
        super.mo2413a(menuBuilder, z10);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b, androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        int size;
        super.mo2414b(z10);
        ((View) this.f1593i).requestLayout();
        MenuBuilder menuBuilder = this.f1587c;
        if (menuBuilder != null) {
            ArrayList<C0411h> arrayListM2389u = menuBuilder.m2389u();
            int size2 = arrayListM2389u.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ActionProvider actionProviderMo2408b = arrayListM2389u.get(i10).mo2408b();
                if (actionProviderMo2408b != null) {
                    actionProviderMo2408b.m3937i(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f1587c;
        ArrayList<C0411h> arrayListM2338B = menuBuilder2 != null ? menuBuilder2.m2338B() : null;
        if (!this.f1807n || arrayListM2338B == null || ((size = arrayListM2338B.size()) != 1 ? size <= 0 : !(!arrayListM2338B.get(0).isActionViewExpanded()))) {
            OverflowMenuButton overflowMenuButton = this.f1804k;
            if (overflowMenuButton != null) {
                Object parent = overflowMenuButton.getParent();
                Object obj = this.f1593i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1804k);
                }
            }
        } else {
            if (this.f1804k == null) {
                this.f1804k = new OverflowMenuButton(this.f1585a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1804k.getParent();
            if (viewGroup != this.f1593i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1804k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1593i;
                actionMenuView.addView(this.f1804k, actionMenuView.m2590F());
            }
        }
        ((ActionMenuView) this.f1593i).setOverflowReserved(this.f1807n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: c */
    public boolean mo2439c() {
        ArrayList<C0411h> arrayListM2342G;
        int size;
        int i10;
        int iM2585L;
        boolean z10;
        int i11;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f1587c;
        View view = null;
        ?? r32 = 0;
        if (menuBuilder != null) {
            arrayListM2342G = menuBuilder.m2342G();
            size = arrayListM2342G.size();
        } else {
            arrayListM2342G = null;
            size = 0;
        }
        int i12 = actionMenuPresenter.f1811r;
        int i13 = actionMenuPresenter.f1810q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1593i;
        boolean z11 = false;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            C0411h c0411h = arrayListM2342G.get(i16);
            if (c0411h.m2482o()) {
                i14++;
            } else if (c0411h.m2481n()) {
                i15++;
            } else {
                z11 = true;
            }
            if (actionMenuPresenter.f1815v && c0411h.isActionViewExpanded()) {
                i12 = 0;
            }
        }
        if (actionMenuPresenter.f1807n && (z11 || i15 + i14 > i12)) {
            i12--;
        }
        int i17 = i12 - i14;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1817x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1813t) {
            int i18 = actionMenuPresenter.f1816w;
            iM2585L = i13 / i18;
            i10 = i18 + ((i13 % i18) / iM2585L);
        } else {
            i10 = 0;
            iM2585L = 0;
        }
        int i19 = 0;
        int i20 = 0;
        while (i19 < size) {
            C0411h c0411h2 = arrayListM2342G.get(i19);
            if (c0411h2.m2482o()) {
                View viewMo2425q = actionMenuPresenter.mo2425q(c0411h2, view, viewGroup);
                if (actionMenuPresenter.f1813t) {
                    iM2585L -= ActionMenuView.m2585L(viewMo2425q, i10, iM2585L, iMakeMeasureSpec, r32);
                } else {
                    viewMo2425q.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewMo2425q.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i20 == 0) {
                    i20 = measuredWidth;
                }
                int groupId = c0411h2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                c0411h2.m2488u(true);
                z10 = r32;
                i11 = size;
            } else if (c0411h2.m2481n()) {
                int groupId2 = c0411h2.getGroupId();
                boolean z12 = sparseBooleanArray.get(groupId2);
                boolean z13 = (i17 > 0 || z12) && i13 > 0 && (!actionMenuPresenter.f1813t || iM2585L > 0);
                boolean z14 = z13;
                i11 = size;
                if (z13) {
                    View viewMo2425q2 = actionMenuPresenter.mo2425q(c0411h2, null, viewGroup);
                    if (actionMenuPresenter.f1813t) {
                        int iM2585L2 = ActionMenuView.m2585L(viewMo2425q2, i10, iM2585L, iMakeMeasureSpec, 0);
                        iM2585L -= iM2585L2;
                        if (iM2585L2 == 0) {
                            z14 = false;
                        }
                    } else {
                        viewMo2425q2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z15 = z14;
                    int measuredWidth2 = viewMo2425q2.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i20 == 0) {
                        i20 = measuredWidth2;
                    }
                    z13 = z15 & (!actionMenuPresenter.f1813t ? i13 + i20 <= 0 : i13 < 0);
                }
                if (z13 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z12) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i21 = 0; i21 < i19; i21++) {
                        C0411h c0411h3 = arrayListM2342G.get(i21);
                        if (c0411h3.getGroupId() == groupId2) {
                            if (c0411h3.m2479l()) {
                                i17++;
                            }
                            c0411h3.m2488u(false);
                        }
                    }
                }
                if (z13) {
                    i17--;
                }
                c0411h2.m2488u(z13);
                z10 = false;
            } else {
                z10 = r32;
                i11 = size;
                c0411h2.m2488u(z10);
            }
            i19++;
            r32 = z10;
            size = i11;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b, androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: g */
    public void mo2418g(Context context, MenuBuilder menuBuilder) {
        super.mo2418g(context, menuBuilder);
        Resources resources = context.getResources();
        C9813a c9813aM60992b = C9813a.m60992b(context);
        if (!this.f1808o) {
            this.f1807n = c9813aM60992b.m60999h();
        }
        if (!this.f1814u) {
            this.f1809p = c9813aM60992b.m60994c();
        }
        if (!this.f1812s) {
            this.f1811r = c9813aM60992b.m60995d();
        }
        int measuredWidth = this.f1809p;
        if (this.f1807n) {
            if (this.f1804k == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f1585a);
                this.f1804k = overflowMenuButton;
                if (this.f1806m) {
                    overflowMenuButton.setImageDrawable(this.f1805l);
                    this.f1805l = null;
                    this.f1806m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1804k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1804k.getMeasuredWidth();
        } else {
            this.f1804k = null;
        }
        this.f1810q = measuredWidth;
        this.f1816w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: h */
    public void mo2440h(Parcelable parcelable) {
        int i10;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f1823a) > 0 && (menuItemFindItem = this.f1587c.findItem(i10)) != null) {
            mo2419i((SubMenuC0419p) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b, androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        boolean z10 = false;
        if (!subMenuC0419p.hasVisibleItems()) {
            return false;
        }
        SubMenuC0419p subMenuC0419p2 = subMenuC0419p;
        while (subMenuC0419p2.m2515i0() != this.f1587c) {
            subMenuC0419p2 = (SubMenuC0419p) subMenuC0419p2.m2515i0();
        }
        View viewM2569C = m2569C(subMenuC0419p2.getItem());
        if (viewM2569C == null) {
            return false;
        }
        this.f1803D = subMenuC0419p.getItem().getItemId();
        int size = subMenuC0419p.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = subMenuC0419p.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        C0430a c0430a = new C0430a(this.f1586b, subMenuC0419p, viewM2569C);
        this.f1819z = c0430a;
        c0430a.m2505g(z10);
        this.f1819z.m2509k();
        super.mo2419i(subMenuC0419p);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.InterfaceC0652a
    /* renamed from: j */
    public void mo2581j(boolean z10) {
        if (z10) {
            super.mo2419i(null);
            return;
        }
        MenuBuilder menuBuilder = this.f1587c;
        if (menuBuilder != null) {
            menuBuilder.m2370e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: k */
    public Parcelable mo2442k() {
        SavedState savedState = new SavedState();
        savedState.f1823a = this.f1803D;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b
    /* renamed from: m */
    public void mo2421m(C0411h c0411h, InterfaceC0415l.a aVar) {
        aVar.mo2320e(c0411h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1593i);
        if (this.f1801B == null) {
            this.f1801B = new C0431b();
        }
        actionMenuItemView.setPopupCallback(this.f1801B);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b
    /* renamed from: o */
    public boolean mo2423o(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f1804k) {
            return false;
        }
        return super.mo2423o(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b
    /* renamed from: q */
    public View mo2425q(C0411h c0411h, View view, ViewGroup viewGroup) {
        View actionView = c0411h.getActionView();
        if (actionView == null || c0411h.m2477j()) {
            actionView = super.mo2425q(c0411h, view, viewGroup);
        }
        actionView.setVisibility(c0411h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b
    /* renamed from: r */
    public InterfaceC0415l mo2426r(ViewGroup viewGroup) {
        InterfaceC0415l interfaceC0415l = this.f1593i;
        InterfaceC0415l interfaceC0415lMo2426r = super.mo2426r(viewGroup);
        if (interfaceC0415l != interfaceC0415lMo2426r) {
            ((ActionMenuView) interfaceC0415lMo2426r).setPresenter(this);
        }
        return interfaceC0415lMo2426r;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0405b
    /* renamed from: t */
    public boolean mo2428t(int i10, C0411h c0411h) {
        return c0411h.m2479l();
    }
}
