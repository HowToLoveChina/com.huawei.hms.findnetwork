package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p793y.InterfaceSubMenuC13897c;

/* renamed from: androidx.appcompat.view.menu.q */
/* loaded from: classes.dex */
public class SubMenuC0420q extends MenuC0416m implements SubMenu {

    /* renamed from: e */
    public final InterfaceSubMenuC13897c f1729e;

    public SubMenuC0420q(Context context, InterfaceSubMenuC13897c interfaceSubMenuC13897c) {
        super(context, interfaceSubMenuC13897c);
        this.f1729e = interfaceSubMenuC13897c;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f1729e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return m2429c(this.f1729e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        this.f1729e.setHeaderIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        this.f1729e.setHeaderTitle(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f1729e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.f1729e.setIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1729e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1729e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1729e.setIcon(drawable);
        return this;
    }
}
