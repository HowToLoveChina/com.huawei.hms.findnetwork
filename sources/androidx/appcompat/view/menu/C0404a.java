package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ActionProvider;
import p757x.C13669a;
import p793y.InterfaceMenuItemC13896b;

/* renamed from: androidx.appcompat.view.menu.a */
/* loaded from: classes.dex */
public class C0404a implements InterfaceMenuItemC13896b {

    /* renamed from: a */
    public final int f1565a;

    /* renamed from: b */
    public final int f1566b;

    /* renamed from: c */
    public final int f1567c;

    /* renamed from: d */
    public CharSequence f1568d;

    /* renamed from: e */
    public CharSequence f1569e;

    /* renamed from: f */
    public Intent f1570f;

    /* renamed from: g */
    public char f1571g;

    /* renamed from: i */
    public char f1573i;

    /* renamed from: k */
    public Drawable f1575k;

    /* renamed from: l */
    public Context f1576l;

    /* renamed from: m */
    public MenuItem.OnMenuItemClickListener f1577m;

    /* renamed from: n */
    public CharSequence f1578n;

    /* renamed from: o */
    public CharSequence f1579o;

    /* renamed from: h */
    public int f1572h = 4096;

    /* renamed from: j */
    public int f1574j = 4096;

    /* renamed from: p */
    public ColorStateList f1580p = null;

    /* renamed from: q */
    public PorterDuff.Mode f1581q = null;

    /* renamed from: r */
    public boolean f1582r = false;

    /* renamed from: s */
    public boolean f1583s = false;

    /* renamed from: t */
    public int f1584t = 16;

    public C0404a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f1576l = context;
        this.f1565a = i11;
        this.f1566b = i10;
        this.f1567c = i13;
        this.f1568d = charSequence;
    }

    @Override // p793y.InterfaceMenuItemC13896b
    /* renamed from: a */
    public InterfaceMenuItemC13896b mo2407a(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // p793y.InterfaceMenuItemC13896b
    /* renamed from: b */
    public ActionProvider mo2408b() {
        return null;
    }

    /* renamed from: c */
    public final void m2409c() {
        Drawable drawable = this.f1575k;
        if (drawable != null) {
            if (this.f1582r || this.f1583s) {
                Drawable drawableM82231l = C13669a.m82231l(drawable);
                this.f1575k = drawableM82231l;
                Drawable drawableMutate = drawableM82231l.mutate();
                this.f1575k = drawableMutate;
                if (this.f1582r) {
                    C13669a.m82228i(drawableMutate, this.f1580p);
                }
                if (this.f1583s) {
                    C13669a.m82229j(this.f1575k, this.f1581q);
                }
            }
        }
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC13896b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC13896b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC13896b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1574j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1573i;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1578n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1566b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1575k;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1580p;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1581q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1570f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1565a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1572h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1571g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1567c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1568d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1569e;
        return charSequence != null ? charSequence : this.f1568d;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1579o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1584t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1584t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1584t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1584t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f1573i = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f1584t = (z10 ? 1 : 0) | (this.f1584t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f1584t = (z10 ? 2 : 0) | (this.f1584t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f1584t = (z10 ? 16 : 0) | (this.f1584t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1575k = drawable;
        m2409c();
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1580p = colorStateList;
        this.f1582r = true;
        m2409c();
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1581q = mode;
        this.f1583s = true;
        m2409c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1570f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f1571g = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1577m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1571g = c10;
        this.f1573i = Character.toLowerCase(c11);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1568d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1569e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f1584t = (this.f1584t & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f1573i = Character.toLowerCase(c10);
        this.f1574j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC13896b setContentDescription(CharSequence charSequence) {
        this.f1578n = charSequence;
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f1571g = c10;
        this.f1572h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f1568d = this.f1576l.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC13896b setTooltipText(CharSequence charSequence) {
        this.f1579o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1575k = ContextCompat.getDrawable(this.f1576l, i10);
        m2409c();
        return this;
    }

    @Override // p793y.InterfaceMenuItemC13896b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1571g = c10;
        this.f1572h = KeyEvent.normalizeMetaState(i10);
        this.f1573i = Character.toLowerCase(c11);
        this.f1574j = KeyEvent.normalizeMetaState(i11);
        return this;
    }
}
