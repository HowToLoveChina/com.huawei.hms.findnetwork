package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.transition.AutoTransition;
import androidx.transition.C0956q;
import androidx.transition.TransitionSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.badge.C1652a;
import com.google.android.material.internal.C1782m;
import java.util.HashSet;
import p211d.C8968a;
import p215d3.C8997a;
import p243e0.C9372g;
import p243e0.InterfaceC9370e;
import p273f0.C9603h0;
import p304g0.C9832l;
import p356i3.C10427h;
import p356i3.C10432m;
import p666u2.C13110a;

/* loaded from: classes.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements InterfaceC0415l {

    /* renamed from: C */
    public static final int[] f8455C = {R.attr.state_checked};

    /* renamed from: D */
    public static final int[] f8456D = {-16842910};

    /* renamed from: A */
    public NavigationBarPresenter f8457A;

    /* renamed from: B */
    public MenuBuilder f8458B;

    /* renamed from: a */
    public final TransitionSet f8459a;

    /* renamed from: b */
    public final View.OnClickListener f8460b;

    /* renamed from: c */
    public final InterfaceC9370e<NavigationBarItemView> f8461c;

    /* renamed from: d */
    public final SparseArray<View.OnTouchListener> f8462d;

    /* renamed from: e */
    public int f8463e;

    /* renamed from: f */
    public NavigationBarItemView[] f8464f;

    /* renamed from: g */
    public int f8465g;

    /* renamed from: h */
    public int f8466h;

    /* renamed from: i */
    public ColorStateList f8467i;

    /* renamed from: j */
    public int f8468j;

    /* renamed from: k */
    public ColorStateList f8469k;

    /* renamed from: l */
    public final ColorStateList f8470l;

    /* renamed from: m */
    public int f8471m;

    /* renamed from: n */
    public int f8472n;

    /* renamed from: o */
    public Drawable f8473o;

    /* renamed from: p */
    public int f8474p;

    /* renamed from: q */
    public final SparseArray<C1652a> f8475q;

    /* renamed from: r */
    public int f8476r;

    /* renamed from: s */
    public int f8477s;

    /* renamed from: t */
    public boolean f8478t;

    /* renamed from: u */
    public int f8479u;

    /* renamed from: v */
    public int f8480v;

    /* renamed from: w */
    public int f8481w;

    /* renamed from: x */
    public C10432m f8482x;

    /* renamed from: y */
    public boolean f8483y;

    /* renamed from: z */
    public ColorStateList f8484z;

    /* renamed from: com.google.android.material.navigation.NavigationBarMenuView$a */
    public class ViewOnClickListenerC1794a implements View.OnClickListener {
        public ViewOnClickListenerC1794a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0411h itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.f8458B.m2350O(itemData, NavigationBarMenuView.this.f8457A, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(Context context) {
        super(context);
        this.f8461c = new C9372g(5);
        this.f8462d = new SparseArray<>(5);
        this.f8465g = 0;
        this.f8466h = 0;
        this.f8475q = new SparseArray<>(5);
        this.f8476r = -1;
        this.f8477s = -1;
        this.f8483y = false;
        this.f8470l = m10822e(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f8459a = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.f8459a = autoTransition;
            autoTransition.m5766t0(0);
            autoTransition.mo5727a0(C8997a.m56855d(getContext(), R$attr.motionDurationLong1, getResources().getInteger(R$integer.material_motion_duration_long_1)));
            autoTransition.mo5731c0(C8997a.m56856e(getContext(), R$attr.motionEasingStandard, C13110a.f59598b));
            autoTransition.m5758l0(new C1782m());
        }
        this.f8460b = new ViewOnClickListenerC1794a();
        C9603h0.m59833A0(this, 1);
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemViewMo58738b = this.f8461c.mo58738b();
        return navigationBarItemViewMo58738b == null ? mo9812g(getContext()) : navigationBarItemViewMo58738b;
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) {
        C1652a c1652a;
        int id2 = navigationBarItemView.getId();
        if (m10825i(id2) && (c1652a = this.f8475q.get(id2)) != null) {
            navigationBarItemView.setBadge(c1652a);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l
    /* renamed from: b */
    public void mo2328b(MenuBuilder menuBuilder) {
        this.f8458B = menuBuilder;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: d */
    public void m10821d() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f8461c.mo58737a(navigationBarItemView);
                    navigationBarItemView.m10802h();
                }
            }
        }
        if (this.f8458B.size() == 0) {
            this.f8465g = 0;
            this.f8466h = 0;
            this.f8464f = null;
            return;
        }
        m10826j();
        this.f8464f = new NavigationBarItemView[this.f8458B.size()];
        boolean zM10824h = m10824h(this.f8463e, this.f8458B.m2342G().size());
        for (int i10 = 0; i10 < this.f8458B.size(); i10++) {
            this.f8457A.m10832m(true);
            this.f8458B.getItem(i10).setCheckable(true);
            this.f8457A.m10832m(false);
            NavigationBarItemView newItem = getNewItem();
            this.f8464f[i10] = newItem;
            newItem.setIconTintList(this.f8467i);
            newItem.setIconSize(this.f8468j);
            newItem.setTextColor(this.f8470l);
            newItem.setTextAppearanceInactive(this.f8471m);
            newItem.setTextAppearanceActive(this.f8472n);
            newItem.setTextColor(this.f8469k);
            int i11 = this.f8476r;
            if (i11 != -1) {
                newItem.setItemPaddingTop(i11);
            }
            int i12 = this.f8477s;
            if (i12 != -1) {
                newItem.setItemPaddingBottom(i12);
            }
            newItem.setActiveIndicatorWidth(this.f8479u);
            newItem.setActiveIndicatorHeight(this.f8480v);
            newItem.setActiveIndicatorMarginHorizontal(this.f8481w);
            newItem.setActiveIndicatorDrawable(m10823f());
            newItem.setActiveIndicatorResizeable(this.f8483y);
            newItem.setActiveIndicatorEnabled(this.f8478t);
            Drawable drawable = this.f8473o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f8474p);
            }
            newItem.setShifting(zM10824h);
            newItem.setLabelVisibilityMode(this.f8463e);
            C0411h c0411h = (C0411h) this.f8458B.getItem(i10);
            newItem.mo2320e(c0411h, 0);
            newItem.setItemPosition(i10);
            int itemId = c0411h.getItemId();
            newItem.setOnTouchListener(this.f8462d.get(itemId));
            newItem.setOnClickListener(this.f8460b);
            int i13 = this.f8465g;
            if (i13 != 0 && itemId == i13) {
                this.f8466h = i10;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.f8458B.size() - 1, this.f8466h);
        this.f8466h = iMin;
        this.f8458B.getItem(iMin).setChecked(true);
    }

    /* renamed from: e */
    public ColorStateList m10822e(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM56742a = C8968a.m56742a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateListM56742a.getDefaultColor();
        int[] iArr = f8456D;
        return new ColorStateList(new int[][]{iArr, f8455C, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListM56742a.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    /* renamed from: f */
    public final Drawable m10823f() {
        if (this.f8482x == null || this.f8484z == null) {
            return null;
        }
        C10427h c10427h = new C10427h(this.f8482x);
        c10427h.m64002b0(this.f8484z);
        return c10427h;
    }

    /* renamed from: g */
    public abstract NavigationBarItemView mo9812g(Context context);

    public SparseArray<C1652a> getBadgeDrawables() {
        return this.f8475q;
    }

    public ColorStateList getIconTintList() {
        return this.f8467i;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f8484z;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f8478t;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f8480v;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f8481w;
    }

    public C10432m getItemActiveIndicatorShapeAppearance() {
        return this.f8482x;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f8479u;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f8473o : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f8474p;
    }

    public int getItemIconSize() {
        return this.f8468j;
    }

    public int getItemPaddingBottom() {
        return this.f8477s;
    }

    public int getItemPaddingTop() {
        return this.f8476r;
    }

    public int getItemTextAppearanceActive() {
        return this.f8472n;
    }

    public int getItemTextAppearanceInactive() {
        return this.f8471m;
    }

    public ColorStateList getItemTextColor() {
        return this.f8469k;
    }

    public int getLabelVisibilityMode() {
        return this.f8463e;
    }

    public MenuBuilder getMenu() {
        return this.f8458B;
    }

    public int getSelectedItemId() {
        return this.f8465g;
    }

    public int getSelectedItemPosition() {
        return this.f8466h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: h */
    public boolean m10824h(int i10, int i11) {
        if (i10 == -1) {
            if (i11 <= 3) {
                return false;
            }
        } else if (i10 != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: i */
    public final boolean m10825i(int i10) {
        return i10 != -1;
    }

    /* renamed from: j */
    public final void m10826j() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.f8458B.size(); i10++) {
            hashSet.add(Integer.valueOf(this.f8458B.getItem(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.f8475q.size(); i11++) {
            int iKeyAt = this.f8475q.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.f8475q.delete(iKeyAt);
            }
        }
    }

    /* renamed from: k */
    public void m10827k(SparseArray<C1652a> sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int iKeyAt = sparseArray.keyAt(i10);
            if (this.f8475q.indexOfKey(iKeyAt) < 0) {
                this.f8475q.append(iKeyAt, sparseArray.get(iKeyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(this.f8475q.get(navigationBarItemView.getId()));
            }
        }
    }

    /* renamed from: l */
    public void m10828l(int i10) {
        int size = this.f8458B.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.f8458B.getItem(i11);
            if (i10 == item.getItemId()) {
                this.f8465g = i10;
                this.f8466h = i11;
                item.setChecked(true);
                return;
            }
        }
    }

    /* renamed from: m */
    public void m10829m() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.f8458B;
        if (menuBuilder == null || this.f8464f == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.f8464f.length) {
            m10821d();
            return;
        }
        int i10 = this.f8465g;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.f8458B.getItem(i11);
            if (item.isChecked()) {
                this.f8465g = item.getItemId();
                this.f8466h = i11;
            }
        }
        if (i10 != this.f8465g && (transitionSet = this.f8459a) != null) {
            C0956q.m5832a(this, transitionSet);
        }
        boolean zM10824h = m10824h(this.f8463e, this.f8458B.m2342G().size());
        for (int i12 = 0; i12 < size; i12++) {
            this.f8457A.m10832m(true);
            this.f8464f[i12].setLabelVisibilityMode(this.f8463e);
            this.f8464f[i12].setShifting(zM10824h);
            this.f8464f[i12].mo2320e((C0411h) this.f8458B.getItem(i12), 0);
            this.f8457A.m10832m(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C9832l.m61042A0(accessibilityNodeInfo).m61067W(C9832l.b.m61126b(1, this.f8458B.m2342G().size(), false, 1));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f8467i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f8484z = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(m10823f());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f8478t = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.f8480v = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i10);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.f8481w = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i10);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.f8483y = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(C10432m c10432m) {
        this.f8482x = c10432m;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(m10823f());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f8479u = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i10);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f8473o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.f8474p = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i10);
            }
        }
    }

    public void setItemIconSize(int i10) {
        this.f8468j = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i10);
            }
        }
    }

    public void setItemPaddingBottom(int i10) {
        this.f8477s = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i10);
            }
        }
    }

    public void setItemPaddingTop(int i10) {
        this.f8476r = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i10);
            }
        }
    }

    public void setItemTextAppearanceActive(int i10) throws Resources.NotFoundException {
        this.f8472n = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.f8469k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i10) throws Resources.NotFoundException {
        this.f8471m = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.f8469k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8469k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f8464f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.f8463e = i10;
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.f8457A = navigationBarPresenter;
    }
}
