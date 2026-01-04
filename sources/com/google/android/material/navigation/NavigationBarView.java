package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.C0523e0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p273f0.C9603h0;
import p276f3.C9649c;
import p307g3.C9876b;
import p356i3.C10427h;
import p356i3.C10428i;
import p356i3.C10432m;
import p416k3.C10981a;
import p757x.C13669a;

/* loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: a */
    public final C1804a f8492a;

    /* renamed from: b */
    public final NavigationBarMenuView f8493b;

    /* renamed from: c */
    public final NavigationBarPresenter f8494c;

    /* renamed from: d */
    public ColorStateList f8495d;

    /* renamed from: e */
    public MenuInflater f8496e;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1796a();

        /* renamed from: d */
        public Bundle f8497d;

        /* renamed from: com.google.android.material.navigation.NavigationBarView$SavedState$a */
        public class C1796a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* renamed from: a */
        public final void m10839a(Parcel parcel, ClassLoader classLoader) {
            this.f8497d = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f8497d);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m10839a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarView$a */
    public class C1797a implements MenuBuilder.InterfaceC0398a {
        public C1797a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: a */
        public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
            NavigationBarView.m10835a(NavigationBarView.this);
            NavigationBarView.m10836b(NavigationBarView.this);
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: b */
        public void mo2105b(MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarView$b */
    public interface InterfaceC1798b {
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarView$c */
    public interface InterfaceC1799c {
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f8494c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R$styleable.NavigationBarView;
        int i12 = R$styleable.NavigationBarView_itemTextAppearanceInactive;
        int i13 = R$styleable.NavigationBarView_itemTextAppearanceActive;
        C0523e0 c0523e0M10771i = C1784o.m10771i(context2, attributeSet, iArr, i10, i11, i12, i13);
        C1804a c1804a = new C1804a(context2, getClass(), getMaxItemCount());
        this.f8492a = c1804a;
        NavigationBarMenuView navigationBarMenuViewMo9814d = mo9814d(context2);
        this.f8493b = navigationBarMenuViewMo9814d;
        navigationBarPresenter.m10831l(navigationBarMenuViewMo9814d);
        navigationBarPresenter.m10830j(1);
        navigationBarMenuViewMo9814d.setPresenter(navigationBarPresenter);
        c1804a.m2364b(navigationBarPresenter);
        navigationBarPresenter.mo2418g(getContext(), c1804a);
        int i14 = R$styleable.NavigationBarView_itemIconTint;
        if (c0523e0M10771i.m2965s(i14)) {
            navigationBarMenuViewMo9814d.setIconTintList(c0523e0M10771i.m2949c(i14));
        } else {
            navigationBarMenuViewMo9814d.setIconTintList(navigationBarMenuViewMo9814d.m10822e(R.attr.textColorSecondary));
        }
        setItemIconSize(c0523e0M10771i.m2952f(R$styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (c0523e0M10771i.m2965s(i12)) {
            setItemTextAppearanceInactive(c0523e0M10771i.m2960n(i12, 0));
        }
        if (c0523e0M10771i.m2965s(i13)) {
            setItemTextAppearanceActive(c0523e0M10771i.m2960n(i13, 0));
        }
        int i15 = R$styleable.NavigationBarView_itemTextColor;
        if (c0523e0M10771i.m2965s(i15)) {
            setItemTextColor(c0523e0M10771i.m2949c(i15));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            C9603h0.m59910t0(this, m10837c(context2));
        }
        int i16 = R$styleable.NavigationBarView_itemPaddingTop;
        if (c0523e0M10771i.m2965s(i16)) {
            setItemPaddingTop(c0523e0M10771i.m2952f(i16, 0));
        }
        int i17 = R$styleable.NavigationBarView_itemPaddingBottom;
        if (c0523e0M10771i.m2965s(i17)) {
            setItemPaddingBottom(c0523e0M10771i.m2952f(i17, 0));
        }
        if (c0523e0M10771i.m2965s(R$styleable.NavigationBarView_elevation)) {
            setElevation(c0523e0M10771i.m2952f(r10, 0));
        }
        C13669a.m82228i(getBackground().mutate(), C9649c.m60266b(context2, c0523e0M10771i, R$styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(c0523e0M10771i.m2958l(R$styleable.NavigationBarView_labelVisibilityMode, -1));
        int iM2960n = c0523e0M10771i.m2960n(R$styleable.NavigationBarView_itemBackground, 0);
        if (iM2960n != 0) {
            navigationBarMenuViewMo9814d.setItemBackgroundRes(iM2960n);
        } else {
            setItemRippleColor(C9649c.m60266b(context2, c0523e0M10771i, R$styleable.NavigationBarView_itemRippleColor));
        }
        int iM2960n2 = c0523e0M10771i.m2960n(R$styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (iM2960n2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iM2960n2, R$styleable.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(C9649c.m60265a(context2, typedArrayObtainStyledAttributes, R$styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(C10432m.m64046b(context2, typedArrayObtainStyledAttributes.getResourceId(R$styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m64093m());
            typedArrayObtainStyledAttributes.recycle();
        }
        int i18 = R$styleable.NavigationBarView_menu;
        if (c0523e0M10771i.m2965s(i18)) {
            m10838e(c0523e0M10771i.m2960n(i18, 0));
        }
        c0523e0M10771i.m2966w();
        addView(navigationBarMenuViewMo9814d);
        c1804a.mo2357V(new C1797a());
    }

    /* renamed from: a */
    public static /* synthetic */ InterfaceC1798b m10835a(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC1799c m10836b(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.f8496e == null) {
            this.f8496e = new SupportMenuInflater(getContext());
        }
        return this.f8496e;
    }

    /* renamed from: c */
    public final C10427h m10837c(Context context) {
        C10427h c10427h = new C10427h();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            c10427h.m64002b0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        c10427h.m63992Q(context);
        return c10427h;
    }

    /* renamed from: d */
    public abstract NavigationBarMenuView mo9814d(Context context);

    /* renamed from: e */
    public void m10838e(int i10) {
        this.f8494c.m10832m(true);
        getMenuInflater().inflate(i10, this.f8492a);
        this.f8494c.m10832m(false);
        this.f8494c.mo2414b(true);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f8493b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f8493b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f8493b.getItemActiveIndicatorMarginHorizontal();
    }

    public C10432m getItemActiveIndicatorShapeAppearance() {
        return this.f8493b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f8493b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f8493b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f8493b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f8493b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f8493b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f8493b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f8493b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f8495d;
    }

    public int getItemTextAppearanceActive() {
        return this.f8493b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f8493b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f8493b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f8493b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f8492a;
    }

    public InterfaceC0415l getMenuView() {
        return this.f8493b;
    }

    public NavigationBarPresenter getPresenter() {
        return this.f8494c;
    }

    public int getSelectedItemId() {
        return this.f8493b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64043e(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8492a.m2354S(savedState.f8497d);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f8497d = bundle;
        this.f8492a.m2356U(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        C10428i.m64042d(this, f10);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f8493b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f8493b.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.f8493b.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.f8493b.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(C10432m c10432m) {
        this.f8493b.setItemActiveIndicatorShapeAppearance(c10432m);
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f8493b.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f8493b.setItemBackground(drawable);
        this.f8495d = null;
    }

    public void setItemBackgroundResource(int i10) {
        this.f8493b.setItemBackgroundRes(i10);
        this.f8495d = null;
    }

    public void setItemIconSize(int i10) {
        this.f8493b.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f8493b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i10) {
        this.f8493b.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(int i10) {
        this.f8493b.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.f8495d == colorStateList) {
            if (colorStateList != null || this.f8493b.getItemBackground() == null) {
                return;
            }
            this.f8493b.setItemBackground(null);
            return;
        }
        this.f8495d = colorStateList;
        if (colorStateList == null) {
            this.f8493b.setItemBackground(null);
        } else {
            this.f8493b.setItemBackground(new RippleDrawable(C9876b.m61322a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(int i10) throws Resources.NotFoundException {
        this.f8493b.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceInactive(int i10) throws Resources.NotFoundException {
        this.f8493b.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8493b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f8493b.getLabelVisibilityMode() != i10) {
            this.f8493b.setLabelVisibilityMode(i10);
            this.f8494c.mo2414b(false);
        }
    }

    public void setOnItemReselectedListener(InterfaceC1798b interfaceC1798b) {
    }

    public void setOnItemSelectedListener(InterfaceC1799c interfaceC1799c) {
    }

    public void setSelectedItemId(int i10) {
        MenuItem menuItemFindItem = this.f8492a.findItem(i10);
        if (menuItemFindItem == null || this.f8492a.m2350O(menuItemFindItem, this.f8494c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
