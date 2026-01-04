package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.core.view.ActionProvider;
import p211d.C8968a;
import p757x.C13669a;
import p793y.InterfaceMenuItemC13896b;

/* renamed from: androidx.appcompat.view.menu.h */
/* loaded from: classes.dex */
public final class C0411h implements InterfaceMenuItemC13896b {

    /* renamed from: A */
    public View f1657A;

    /* renamed from: B */
    public ActionProvider f1658B;

    /* renamed from: C */
    public MenuItem.OnActionExpandListener f1659C;

    /* renamed from: E */
    public ContextMenu.ContextMenuInfo f1661E;

    /* renamed from: a */
    public final int f1662a;

    /* renamed from: b */
    public final int f1663b;

    /* renamed from: c */
    public final int f1664c;

    /* renamed from: d */
    public final int f1665d;

    /* renamed from: e */
    public CharSequence f1666e;

    /* renamed from: f */
    public CharSequence f1667f;

    /* renamed from: g */
    public Intent f1668g;

    /* renamed from: h */
    public char f1669h;

    /* renamed from: j */
    public char f1671j;

    /* renamed from: l */
    public Drawable f1673l;

    /* renamed from: n */
    public MenuBuilder f1675n;

    /* renamed from: o */
    public SubMenuC0419p f1676o;

    /* renamed from: p */
    public Runnable f1677p;

    /* renamed from: q */
    public MenuItem.OnMenuItemClickListener f1678q;

    /* renamed from: r */
    public CharSequence f1679r;

    /* renamed from: s */
    public CharSequence f1680s;

    /* renamed from: z */
    public int f1687z;

    /* renamed from: i */
    public int f1670i = 4096;

    /* renamed from: k */
    public int f1672k = 4096;

    /* renamed from: m */
    public int f1674m = 0;

    /* renamed from: t */
    public ColorStateList f1681t = null;

    /* renamed from: u */
    public PorterDuff.Mode f1682u = null;

    /* renamed from: v */
    public boolean f1683v = false;

    /* renamed from: w */
    public boolean f1684w = false;

    /* renamed from: x */
    public boolean f1685x = false;

    /* renamed from: y */
    public int f1686y = 16;

    /* renamed from: D */
    public boolean f1660D = false;

    /* renamed from: androidx.appcompat.view.menu.h$a */
    public class a implements ActionProvider.InterfaceC0653b {
        public a() {
        }

        @Override // androidx.core.view.ActionProvider.InterfaceC0653b
        public void onActionProviderVisibilityChanged(boolean z10) {
            C0411h c0411h = C0411h.this;
            c0411h.f1675n.m2347L(c0411h);
        }
    }

    public C0411h(MenuBuilder menuBuilder, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f1675n = menuBuilder;
        this.f1662a = i11;
        this.f1663b = i10;
        this.f1664c = i12;
        this.f1665d = i13;
        this.f1666e = charSequence;
        this.f1687z = i14;
    }

    /* renamed from: d */
    public static void m2468d(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    /* renamed from: A */
    public boolean m2469A() {
        return this.f1675n.mo2345J() && m2474g() != 0;
    }

    /* renamed from: B */
    public boolean m2470B() {
        return (this.f1687z & 4) == 4;
    }

    @Override // p793y.InterfaceMenuItemC13896b
    /* renamed from: a */
    public InterfaceMenuItemC13896b mo2407a(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.f1658B;
        if (actionProvider2 != null) {
            actionProvider2.m3936h();
        }
        this.f1657A = null;
        this.f1658B = actionProvider;
        this.f1675n.mo2348M(true);
        ActionProvider actionProvider3 = this.f1658B;
        if (actionProvider3 != null) {
            actionProvider3.mo2406j(new a());
        }
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b
    /* renamed from: b */
    public ActionProvider mo2408b() {
        return this.f1658B;
    }

    /* renamed from: c */
    public void m2471c() {
        this.f1675n.m2346K(this);
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1687z & 8) == 0) {
            return false;
        }
        if (this.f1657A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1659C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1675n.mo2372f(this);
        }
        return false;
    }

    /* renamed from: e */
    public final Drawable m2472e(Drawable drawable) {
        if (drawable != null && this.f1685x && (this.f1683v || this.f1684w)) {
            drawable = C13669a.m82231l(drawable).mutate();
            if (this.f1683v) {
                C13669a.m82228i(drawable, this.f1681t);
            }
            if (this.f1684w) {
                C13669a.m82229j(drawable, this.f1682u);
            }
            this.f1685x = false;
        }
        return drawable;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public boolean expandActionView() {
        if (!m2477j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1659C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1675n.mo2382m(this);
        }
        return false;
    }

    /* renamed from: f */
    public int m2473f() {
        return this.f1665d;
    }

    /* renamed from: g */
    public char m2474g() {
        return this.f1675n.mo2344I() ? this.f1671j : this.f1669h;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public View getActionView() {
        View view = this.f1657A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.f1658B;
        if (actionProvider == null) {
            return null;
        }
        View viewMo2404d = actionProvider.mo2404d(this);
        this.f1657A = viewMo2404d;
        return viewMo2404d;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1672k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1671j;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1679r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1663b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1673l;
        if (drawable != null) {
            return m2472e(drawable);
        }
        if (this.f1674m == 0) {
            return null;
        }
        Drawable drawableM56743b = C8968a.m56743b(this.f1675n.m2391w(), this.f1674m);
        this.f1674m = 0;
        this.f1673l = drawableM56743b;
        return m2472e(drawableM56743b);
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1681t;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1682u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1668g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1662a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1661E;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1670i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1669h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1664c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1676o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1666e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1667f;
        return charSequence != null ? charSequence : this.f1666e;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1680s;
    }

    /* renamed from: h */
    public String m2475h() {
        char cM2474g = m2474g();
        if (cM2474g == 0) {
            return "";
        }
        Resources resources = this.f1675n.m2391w().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f1675n.m2391w()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i10 = this.f1675n.mo2344I() ? this.f1672k : this.f1670i;
        m2468d(sb2, i10, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        m2468d(sb2, i10, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        m2468d(sb2, i10, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        m2468d(sb2, i10, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        m2468d(sb2, i10, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        m2468d(sb2, i10, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (cM2474g == '\b') {
            sb2.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (cM2474g == '\n') {
            sb2.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (cM2474g != ' ') {
            sb2.append(cM2474g);
        } else {
            sb2.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1676o != null;
    }

    /* renamed from: i */
    public CharSequence m2476i(InterfaceC0415l.a aVar) {
        return (aVar == null || !aVar.mo2319d()) ? getTitle() : getTitleCondensed();
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1660D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1686y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1686y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1686y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.f1658B;
        return (actionProvider == null || !actionProvider.mo2405g()) ? (this.f1686y & 8) == 0 : (this.f1686y & 8) == 0 && this.f1658B.mo2403b();
    }

    /* renamed from: j */
    public boolean m2477j() {
        ActionProvider actionProvider;
        if ((this.f1687z & 8) == 0) {
            return false;
        }
        if (this.f1657A == null && (actionProvider = this.f1658B) != null) {
            this.f1657A = actionProvider.mo2404d(this);
        }
        return this.f1657A != null;
    }

    /* renamed from: k */
    public boolean m2478k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1678q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f1675n;
        if (menuBuilder.mo2376h(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.f1677p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1668g != null) {
            try {
                this.f1675n.m2391w().startActivity(this.f1668g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        ActionProvider actionProvider = this.f1658B;
        return actionProvider != null && actionProvider.mo2401e();
    }

    /* renamed from: l */
    public boolean m2479l() {
        return (this.f1686y & 32) == 32;
    }

    /* renamed from: m */
    public boolean m2480m() {
        return (this.f1686y & 4) != 0;
    }

    /* renamed from: n */
    public boolean m2481n() {
        return (this.f1687z & 1) == 1;
    }

    /* renamed from: o */
    public boolean m2482o() {
        return (this.f1687z & 2) == 2;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    /* renamed from: p */
    public InterfaceMenuItemC13896b setActionView(int i10) {
        Context contextM2391w = this.f1675n.m2391w();
        setActionView(LayoutInflater.from(contextM2391w).inflate(i10, (ViewGroup) new LinearLayout(contextM2391w), false));
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    /* renamed from: q */
    public InterfaceMenuItemC13896b setActionView(View view) {
        int i10;
        this.f1657A = view;
        this.f1658B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f1662a) > 0) {
            view.setId(i10);
        }
        this.f1675n.m2346K(this);
        return this;
    }

    /* renamed from: r */
    public void m2485r(boolean z10) {
        this.f1660D = z10;
        this.f1675n.mo2348M(false);
    }

    /* renamed from: s */
    public void m2486s(boolean z10) {
        int i10 = this.f1686y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f1686y = i11;
        if (i10 != i11) {
            this.f1675n.mo2348M(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f1671j == c10) {
            return this;
        }
        this.f1671j = Character.toLowerCase(c10);
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f1686y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f1686y = i11;
        if (i10 != i11) {
            this.f1675n.mo2348M(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f1686y & 4) != 0) {
            this.f1675n.m2359X(this);
        } else {
            m2486s(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f1686y |= 16;
        } else {
            this.f1686y &= -17;
        }
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1674m = 0;
        this.f1673l = drawable;
        this.f1685x = true;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1681t = colorStateList;
        this.f1683v = true;
        this.f1685x = true;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1682u = mode;
        this.f1684w = true;
        this.f1685x = true;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1668g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f1669h == c10) {
            return this;
        }
        this.f1669h = c10;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1659C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1678q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1669h = c10;
        this.f1671j = Character.toLowerCase(c11);
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1687z = i10;
        this.f1675n.m2346K(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1666e = charSequence;
        this.f1675n.mo2348M(false);
        SubMenuC0419p subMenuC0419p = this.f1676o;
        if (subMenuC0419p != null) {
            subMenuC0419p.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1667f = charSequence;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (m2492y(z10)) {
            this.f1675n.m2347L(this);
        }
        return this;
    }

    /* renamed from: t */
    public void m2487t(boolean z10) {
        this.f1686y = (z10 ? 4 : 0) | (this.f1686y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f1666e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* renamed from: u */
    public void m2488u(boolean z10) {
        if (z10) {
            this.f1686y |= 32;
        } else {
            this.f1686y &= -33;
        }
    }

    /* renamed from: v */
    public void m2489v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1661E = contextMenuInfo;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    /* renamed from: w */
    public InterfaceMenuItemC13896b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    /* renamed from: x */
    public void m2491x(SubMenuC0419p subMenuC0419p) {
        this.f1676o = subMenuC0419p;
        subMenuC0419p.setHeaderTitle(getTitle());
    }

    /* renamed from: y */
    public boolean m2492y(boolean z10) {
        int i10 = this.f1686y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f1686y = i11;
        return i10 != i11;
    }

    /* renamed from: z */
    public boolean m2493z() {
        return this.f1675n.m2339C();
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC13896b setContentDescription(CharSequence charSequence) {
        this.f1679r = charSequence;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC13896b setTooltipText(CharSequence charSequence) {
        this.f1680s = charSequence;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f1671j == c10 && this.f1672k == i10) {
            return this;
        }
        this.f1671j = Character.toLowerCase(c10);
        this.f1672k = KeyEvent.normalizeMetaState(i10);
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f1669h == c10 && this.f1670i == i10) {
            return this;
        }
        this.f1669h = c10;
        this.f1670i = KeyEvent.normalizeMetaState(i10);
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1669h = c10;
        this.f1670i = KeyEvent.normalizeMetaState(i10);
        this.f1671j = Character.toLowerCase(c11);
        this.f1672k = KeyEvent.normalizeMetaState(i11);
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1673l = null;
        this.f1674m = i10;
        this.f1685x = true;
        this.f1675n.mo2348M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f1675n.m2391w().getString(i10));
    }
}
