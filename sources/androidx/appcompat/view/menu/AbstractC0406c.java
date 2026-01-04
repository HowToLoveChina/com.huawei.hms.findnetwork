package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import p438l.C11213g;
import p793y.InterfaceMenuItemC13896b;
import p793y.InterfaceSubMenuC13897c;

/* renamed from: androidx.appcompat.view.menu.c */
/* loaded from: classes.dex */
public abstract class AbstractC0406c {

    /* renamed from: a */
    public final Context f1595a;

    /* renamed from: b */
    public C11213g<InterfaceMenuItemC13896b, MenuItem> f1596b;

    /* renamed from: c */
    public C11213g<InterfaceSubMenuC13897c, SubMenu> f1597c;

    public AbstractC0406c(Context context) {
        this.f1595a = context;
    }

    /* renamed from: c */
    public final MenuItem m2429c(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC13896b)) {
            return menuItem;
        }
        InterfaceMenuItemC13896b interfaceMenuItemC13896b = (InterfaceMenuItemC13896b) menuItem;
        if (this.f1596b == null) {
            this.f1596b = new C11213g<>();
        }
        MenuItem menuItem2 = this.f1596b.get(interfaceMenuItemC13896b);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f1595a, interfaceMenuItemC13896b);
        this.f1596b.put(interfaceMenuItemC13896b, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    /* renamed from: d */
    public final SubMenu m2430d(SubMenu subMenu) {
        if (!(subMenu instanceof InterfaceSubMenuC13897c)) {
            return subMenu;
        }
        InterfaceSubMenuC13897c interfaceSubMenuC13897c = (InterfaceSubMenuC13897c) subMenu;
        if (this.f1597c == null) {
            this.f1597c = new C11213g<>();
        }
        SubMenu subMenu2 = this.f1597c.get(interfaceSubMenuC13897c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuC0420q subMenuC0420q = new SubMenuC0420q(this.f1595a, interfaceSubMenuC13897c);
        this.f1597c.put(interfaceSubMenuC13897c, subMenuC0420q);
        return subMenuC0420q;
    }

    /* renamed from: e */
    public final void m2431e() {
        C11213g<InterfaceMenuItemC13896b, MenuItem> c11213g = this.f1596b;
        if (c11213g != null) {
            c11213g.clear();
        }
        C11213g<InterfaceSubMenuC13897c, SubMenu> c11213g2 = this.f1597c;
        if (c11213g2 != null) {
            c11213g2.clear();
        }
    }

    /* renamed from: f */
    public final void m2432f(int i10) {
        if (this.f1596b == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.f1596b.size()) {
            if (this.f1596b.m67331i(i11).getGroupId() == i10) {
                this.f1596b.mo67333k(i11);
                i11--;
            }
            i11++;
        }
    }

    /* renamed from: g */
    public final void m2433g(int i10) {
        if (this.f1596b == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f1596b.size(); i11++) {
            if (this.f1596b.m67331i(i11).getItemId() == i10) {
                this.f1596b.mo67333k(i11);
                return;
            }
        }
    }
}
