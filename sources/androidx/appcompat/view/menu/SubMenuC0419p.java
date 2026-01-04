package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

/* renamed from: androidx.appcompat.view.menu.p */
/* loaded from: classes.dex */
public class SubMenuC0419p extends MenuBuilder implements SubMenu {

    /* renamed from: B */
    public MenuBuilder f1727B;

    /* renamed from: C */
    public C0411h f1728C;

    public SubMenuC0419p(Context context, MenuBuilder menuBuilder, C0411h c0411h) {
        super(context);
        this.f1727B = menuBuilder;
        this.f1728C = c0411h;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: F */
    public MenuBuilder mo2341F() {
        return this.f1727B.mo2341F();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: H */
    public boolean mo2343H() {
        return this.f1727B.mo2343H();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: I */
    public boolean mo2344I() {
        return this.f1727B.mo2344I();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: J */
    public boolean mo2345J() {
        return this.f1727B.mo2345J();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: V */
    public void mo2357V(MenuBuilder.InterfaceC0398a interfaceC0398a) {
        this.f1727B.mo2357V(interfaceC0398a);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: f */
    public boolean mo2372f(C0411h c0411h) {
        return this.f1727B.mo2372f(c0411h);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f1728C;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: h */
    public boolean mo2376h(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo2376h(menuBuilder, menuItem) || this.f1727B.mo2376h(menuBuilder, menuItem);
    }

    /* renamed from: i0 */
    public Menu m2515i0() {
        return this.f1727B;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: m */
    public boolean mo2382m(C0411h c0411h) {
        return this.f1727B.mo2382m(c0411h);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f1727B.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m2361Z(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m2367c0(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m2369d0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1728C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1727B.setQwertyMode(z10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: v */
    public String mo2390v() {
        C0411h c0411h = this.f1728C;
        int itemId = c0411h != null ? c0411h.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo2390v() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) super.m2360Y(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) super.m2365b0(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.f1728C.setIcon(i10);
        return this;
    }
}
