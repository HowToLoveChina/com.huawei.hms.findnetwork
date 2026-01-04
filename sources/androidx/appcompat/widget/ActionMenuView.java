package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.InterfaceC0399b, InterfaceC0415l {

    /* renamed from: A */
    public InterfaceC0438d f1830A;

    /* renamed from: p */
    public MenuBuilder f1831p;

    /* renamed from: q */
    public Context f1832q;

    /* renamed from: r */
    public int f1833r;

    /* renamed from: s */
    public boolean f1834s;

    /* renamed from: t */
    public ActionMenuPresenter f1835t;

    /* renamed from: u */
    public InterfaceC0414k.a f1836u;

    /* renamed from: v */
    public MenuBuilder.InterfaceC0398a f1837v;

    /* renamed from: w */
    public boolean f1838w;

    /* renamed from: x */
    public int f1839x;

    /* renamed from: y */
    public int f1840y;

    /* renamed from: z */
    public int f1841z;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a */
        @ViewDebug.ExportedProperty
        public boolean f1842a;

        /* renamed from: b */
        @ViewDebug.ExportedProperty
        public int f1843b;

        /* renamed from: c */
        @ViewDebug.ExportedProperty
        public int f1844c;

        /* renamed from: d */
        @ViewDebug.ExportedProperty
        public boolean f1845d;

        /* renamed from: e */
        @ViewDebug.ExportedProperty
        public boolean f1846e;

        /* renamed from: f */
        public boolean f1847f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1842a = layoutParams.f1842a;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f1842a = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$a */
    public interface InterfaceC0435a {
        /* renamed from: a */
        boolean mo2317a();

        /* renamed from: b */
        boolean mo2318b();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$b */
    public static class C0436b implements InterfaceC0414k.a {
        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: a */
        public void mo2158a(MenuBuilder menuBuilder, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: b */
        public boolean mo2159b(MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$c */
    public class C0437c implements MenuBuilder.InterfaceC0398a {
        public C0437c() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: a */
        public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
            InterfaceC0438d interfaceC0438d = ActionMenuView.this.f1830A;
            return interfaceC0438d != null && interfaceC0438d.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: b */
        public void mo2105b(MenuBuilder menuBuilder) {
            MenuBuilder.InterfaceC0398a interfaceC0398a = ActionMenuView.this.f1837v;
            if (interfaceC0398a != null) {
                interfaceC0398a.mo2105b(menuBuilder);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$d */
    public interface InterfaceC0438d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x004c  */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2585L(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$LayoutParams r0 = (androidx.appcompat.widget.ActionMenuView.LayoutParams) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.m2321r()
            if (r9 == 0) goto L28
            r9 = r2
            goto L29
        L28:
            r9 = r1
        L29:
            if (r7 <= 0) goto L4c
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4c
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L45
            int r4 = r4 + 1
        L45:
            if (r9 == 0) goto L4a
            if (r4 >= r3) goto L4a
            goto L4d
        L4a:
            r3 = r4
            goto L4d
        L4c:
            r3 = r1
        L4d:
            boolean r7 = r0.f1842a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f1845d = r1
            r0.f1843b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.m2585L(android.view.View, int, int, int, int):int");
    }

    /* renamed from: B */
    public void m2586B() {
        ActionMenuPresenter actionMenuPresenter = this.f1835t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m2568B();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: C */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: D */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: E */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
        }
        return layoutParams2;
    }

    /* renamed from: F */
    public LayoutParams m2590F() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f1842a = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    /* renamed from: G */
    public boolean m2591G(int i10) {
        boolean zMo2317a = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof InterfaceC0435a)) {
            zMo2317a = ((InterfaceC0435a) childAt).mo2317a();
        }
        return (i10 <= 0 || !(childAt2 instanceof InterfaceC0435a)) ? zMo2317a : zMo2317a | ((InterfaceC0435a) childAt2).mo2318b();
    }

    /* renamed from: H */
    public boolean m2592H() {
        ActionMenuPresenter actionMenuPresenter = this.f1835t;
        return actionMenuPresenter != null && actionMenuPresenter.m2571E();
    }

    /* renamed from: I */
    public boolean m2593I() {
        ActionMenuPresenter actionMenuPresenter = this.f1835t;
        return actionMenuPresenter != null && actionMenuPresenter.m2573G();
    }

    /* renamed from: J */
    public boolean m2594J() {
        ActionMenuPresenter actionMenuPresenter = this.f1835t;
        return actionMenuPresenter != null && actionMenuPresenter.m2574H();
    }

    /* renamed from: K */
    public boolean m2595K() {
        return this.f1834s;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* renamed from: M */
    public final void m2596M(int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        int i14;
        int i15;
        boolean z11;
        boolean z12;
        int i16;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i17 = size - paddingLeft;
        int i18 = this.f1840y;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = i18 + (i20 / i19);
        int childCount = getChildCount();
        int iMax = 0;
        int i22 = 0;
        boolean z13 = false;
        int i23 = 0;
        int iMax2 = 0;
        int i24 = 0;
        long j10 = 0;
        while (i22 < childCount) {
            View childAt = getChildAt(i22);
            int i25 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i26 = i23 + 1;
                if (z14) {
                    int i27 = this.f1841z;
                    i16 = i26;
                    r14 = 0;
                    childAt.setPadding(i27, 0, i27, 0);
                } else {
                    i16 = i26;
                    r14 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1847f = r14;
                layoutParams.f1844c = r14;
                layoutParams.f1843b = r14;
                layoutParams.f1845d = r14;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = r14;
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = r14;
                layoutParams.f1846e = z14 && ((ActionMenuItemView) childAt).m2321r();
                int iM2585L = m2585L(childAt, i21, layoutParams.f1842a ? 1 : i19, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iM2585L);
                if (layoutParams.f1845d) {
                    i24++;
                }
                if (layoutParams.f1842a) {
                    z13 = true;
                }
                i19 -= iM2585L;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iM2585L == 1) {
                    j10 |= 1 << i22;
                    iMax = iMax;
                }
                i23 = i16;
            }
            i22++;
            size2 = i25;
        }
        int i28 = size2;
        boolean z15 = z13 && i23 == 2;
        boolean z16 = false;
        while (i24 > 0 && i19 > 0) {
            int i29 = Integer.MAX_VALUE;
            int i30 = 0;
            int i31 = 0;
            long j11 = 0;
            while (i31 < childCount) {
                boolean z17 = z16;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i31).getLayoutParams();
                int i32 = iMax;
                if (layoutParams2.f1845d) {
                    int i33 = layoutParams2.f1843b;
                    if (i33 < i29) {
                        j11 = 1 << i31;
                        i29 = i33;
                        i30 = 1;
                    } else if (i33 == i29) {
                        i30++;
                        j11 |= 1 << i31;
                    }
                }
                i31++;
                iMax = i32;
                z16 = z17;
            }
            z10 = z16;
            i14 = iMax;
            j10 |= j11;
            if (i30 > i19) {
                i12 = mode;
                i13 = i17;
                break;
            }
            int i34 = i29 + 1;
            int i35 = 0;
            while (i35 < childCount) {
                View childAt2 = getChildAt(i35);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                int i36 = i17;
                int i37 = mode;
                long j12 = 1 << i35;
                if ((j11 & j12) == 0) {
                    if (layoutParams3.f1843b == i34) {
                        j10 |= j12;
                    }
                    z12 = z15;
                } else {
                    if (z15 && layoutParams3.f1846e && i19 == 1) {
                        int i38 = this.f1841z;
                        z12 = z15;
                        childAt2.setPadding(i38 + i21, 0, i38, 0);
                    } else {
                        z12 = z15;
                    }
                    layoutParams3.f1843b++;
                    layoutParams3.f1847f = true;
                    i19--;
                }
                i35++;
                mode = i37;
                i17 = i36;
                z15 = z12;
            }
            iMax = i14;
            z16 = true;
        }
        i12 = mode;
        i13 = i17;
        z10 = z16;
        i14 = iMax;
        boolean z18 = !z13 && i23 == 1;
        if (i19 <= 0 || j10 == 0 || (i19 >= i23 - 1 && !z18 && iMax2 <= 1)) {
            i15 = 0;
            z11 = z10;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (z18) {
                i15 = 0;
            } else {
                i15 = 0;
                if ((j10 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f1846e) {
                    fBitCount -= 0.5f;
                }
                int i39 = childCount - 1;
                if ((j10 & (1 << i39)) != 0 && !((LayoutParams) getChildAt(i39).getLayoutParams()).f1846e) {
                    fBitCount -= 0.5f;
                }
            }
            int i40 = fBitCount > 0.0f ? (int) ((i19 * i21) / fBitCount) : i15;
            z11 = z10;
            for (int i41 = i15; i41 < childCount; i41++) {
                if ((j10 & (1 << i41)) != 0) {
                    View childAt3 = getChildAt(i41);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f1844c = i40;
                        layoutParams4.f1847f = true;
                        if (i41 == 0 && !layoutParams4.f1846e) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = (-i40) / 2;
                        }
                        z11 = true;
                    } else if (layoutParams4.f1842a) {
                        layoutParams4.f1844c = i40;
                        layoutParams4.f1847f = true;
                        ((LinearLayout.LayoutParams) layoutParams4).rightMargin = (-i40) / 2;
                        z11 = true;
                    } else {
                        if (i41 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = i40 / 2;
                        }
                        if (i41 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams4).rightMargin = i40 / 2;
                        }
                    }
                }
            }
        }
        if (z11) {
            for (int i42 = i15; i42 < childCount; i42++) {
                View childAt4 = getChildAt(i42);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1847f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f1843b * i21) + layoutParams5.f1844c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i13, i12 != 1073741824 ? i14 : i28);
    }

    /* renamed from: N */
    public MenuBuilder m2597N() {
        return this.f1831p;
    }

    /* renamed from: O */
    public void m2598O(InterfaceC0414k.a aVar, MenuBuilder.InterfaceC0398a interfaceC0398a) {
        this.f1836u = aVar;
        this.f1837v = interfaceC0398a;
    }

    /* renamed from: P */
    public boolean m2599P() {
        ActionMenuPresenter actionMenuPresenter = this.f1835t;
        return actionMenuPresenter != null && actionMenuPresenter.m2580N();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0399b
    /* renamed from: a */
    public boolean mo2327a(C0411h c0411h) {
        return this.f1831p.m2349N(c0411h, 0);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l
    /* renamed from: b */
    public void mo2328b(MenuBuilder menuBuilder) {
        this.f1831p = menuBuilder;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1831p == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1831p = menuBuilder;
            menuBuilder.mo2357V(new C0437c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1835t = actionMenuPresenter;
            actionMenuPresenter.m2579M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1835t;
            InterfaceC0414k.a c0436b = this.f1836u;
            if (c0436b == null) {
                c0436b = new C0436b();
            }
            actionMenuPresenter2.mo2417f(c0436b);
            this.f1831p.m2366c(this.f1835t, this.f1832q);
            this.f1835t.m2577K(this);
        }
        return this.f1831p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1835t.m2570D();
    }

    public int getPopupTheme() {
        return this.f1833r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1835t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo2414b(false);
            if (this.f1835t.m2574H()) {
                this.f1835t.m2571E();
                this.f1835t.m2580N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2586B();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        if (!this.f1838w) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i12 - i10;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean zM3056b = C0535k0.m3056b(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1842a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m2591G(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM3056b) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    m2591G(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int iMax = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (zM3056b) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1842a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1842a) {
                int i27 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft2 = i27 + measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        MenuBuilder menuBuilder;
        boolean z10 = this.f1838w;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.f1838w = z11;
        if (z10 != z11) {
            this.f1839x = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.f1838w && (menuBuilder = this.f1831p) != null && size != this.f1839x) {
            this.f1839x = size;
            menuBuilder.mo2348M(true);
        }
        int childCount = getChildCount();
        if (this.f1838w && childCount > 0) {
            m2596M(i10, i11);
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i12).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i10, i11);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f1835t.m2576J(z10);
    }

    public void setOnMenuItemClickListener(InterfaceC0438d interfaceC0438d) {
        this.f1830A = interfaceC0438d;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1835t.m2578L(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f1834s = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f1833r != i10) {
            this.f1833r = i10;
            if (i10 == 0) {
                this.f1832q = getContext();
            } else {
                this.f1832q = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1835t = actionMenuPresenter;
        actionMenuPresenter.m2577K(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f1840y = (int) (56.0f * f10);
        this.f1841z = (int) (f10 * 4.0f);
        this.f1832q = context;
        this.f1833r = 0;
    }
}
