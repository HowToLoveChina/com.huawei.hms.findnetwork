package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ActionProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p303g.InterfaceC9815c;
import p793y.InterfaceMenuItemC13896b;

/* loaded from: classes.dex */
public class MenuItemWrapperICS extends AbstractC0406c implements MenuItem {

    /* renamed from: d */
    public final InterfaceMenuItemC13896b f1554d;

    /* renamed from: e */
    public Method f1555e;

    public static class CollapsibleActionViewWrapper extends FrameLayout implements InterfaceC9815c {

        /* renamed from: a */
        public final CollapsibleActionView f1556a;

        /* JADX WARN: Multi-variable type inference failed */
        public CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f1556a = (CollapsibleActionView) view;
            addView(view);
        }

        /* renamed from: a */
        public View m2396a() {
            return (View) this.f1556a;
        }

        @Override // p303g.InterfaceC9815c
        /* renamed from: c */
        public void mo2397c() {
            this.f1556a.onActionViewExpanded();
        }

        @Override // p303g.InterfaceC9815c
        /* renamed from: f */
        public void mo2398f() {
            this.f1556a.onActionViewCollapsed();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$a */
    public class C0400a extends ActionProvider {

        /* renamed from: d */
        public final android.view.ActionProvider f1557d;

        public C0400a(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f1557d = actionProvider;
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: a */
        public boolean mo2399a() {
            return this.f1557d.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: c */
        public View mo2400c() {
            return this.f1557d.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: e */
        public boolean mo2401e() {
            return this.f1557d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: f */
        public void mo2402f(SubMenu subMenu) {
            this.f1557d.onPrepareSubMenu(MenuItemWrapperICS.this.m2430d(subMenu));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$b */
    public class ActionProviderVisibilityListenerC0401b extends C0400a implements ActionProvider.VisibilityListener {

        /* renamed from: f */
        public ActionProvider.InterfaceC0653b f1559f;

        public ActionProviderVisibilityListenerC0401b(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: b */
        public boolean mo2403b() {
            return this.f1557d.isVisible();
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: d */
        public View mo2404d(MenuItem menuItem) {
            return this.f1557d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: g */
        public boolean mo2405g() {
            return this.f1557d.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        /* renamed from: j */
        public void mo2406j(ActionProvider.InterfaceC0653b interfaceC0653b) {
            this.f1559f = interfaceC0653b;
            android.view.ActionProvider actionProvider = this.f1557d;
            if (interfaceC0653b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            ActionProvider.InterfaceC0653b interfaceC0653b = this.f1559f;
            if (interfaceC0653b != null) {
                interfaceC0653b.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$c */
    public class MenuItemOnActionExpandListenerC0402c implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        public final MenuItem.OnActionExpandListener f1561a;

        public MenuItemOnActionExpandListenerC0402c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1561a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1561a.onMenuItemActionCollapse(MenuItemWrapperICS.this.m2429c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1561a.onMenuItemActionExpand(MenuItemWrapperICS.this.m2429c(menuItem));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$d */
    public class MenuItemOnMenuItemClickListenerC0403d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        public final MenuItem.OnMenuItemClickListener f1563a;

        public MenuItemOnMenuItemClickListenerC0403d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1563a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1563a.onMenuItemClick(MenuItemWrapperICS.this.m2429c(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, InterfaceMenuItemC13896b interfaceMenuItemC13896b) {
        super(context);
        if (interfaceMenuItemC13896b == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1554d = interfaceMenuItemC13896b;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1554d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1554d.expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider actionProviderMo2408b = this.f1554d.mo2408b();
        if (actionProviderMo2408b instanceof C0400a) {
            return ((C0400a) actionProviderMo2408b).f1557d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1554d.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).m2396a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1554d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1554d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1554d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1554d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1554d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1554d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1554d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1554d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1554d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1554d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1554d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1554d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1554d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m2430d(this.f1554d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1554d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1554d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1554d.getTooltipText();
    }

    /* renamed from: h */
    public void m2395h(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f1555e == null) {
                this.f1555e = this.f1554d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1555e.invoke(this.f1554d, Boolean.valueOf(z10));
        } catch (Exception e10) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1554d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1554d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1554d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1554d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1554d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1554d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ActionProviderVisibilityListenerC0401b actionProviderVisibilityListenerC0401b = new ActionProviderVisibilityListenerC0401b(this.f1595a, actionProvider);
        InterfaceMenuItemC13896b interfaceMenuItemC13896b = this.f1554d;
        if (actionProvider == null) {
            actionProviderVisibilityListenerC0401b = null;
        }
        interfaceMenuItemC13896b.mo2407a(actionProviderVisibilityListenerC0401b);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.f1554d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f1554d.setAlphabeticShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f1554d.setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f1554d.setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1554d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f1554d.setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1554d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1554d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1554d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1554d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f1554d.setNumericShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1554d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC0402c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1554d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new MenuItemOnMenuItemClickListenerC0403d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1554d.setShortcut(c10, c11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        this.f1554d.setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i10) {
        this.f1554d.setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1554d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1554d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1554d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        return this.f1554d.setVisible(z10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f1554d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1554d.setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f1554d.setNumericShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1554d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f1554d.setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i10) {
        this.f1554d.setActionView(i10);
        View actionView = this.f1554d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1554d.setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
