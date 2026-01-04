package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p793y.InterfaceMenuC13895a;

/* renamed from: androidx.appcompat.view.menu.m */
/* loaded from: classes.dex */
public class MenuC0416m extends AbstractC0406c implements Menu {

    /* renamed from: d */
    public final InterfaceMenuC13895a f1703d;

    public MenuC0416m(Context context, InterfaceMenuC13895a interfaceMenuC13895a) {
        super(context);
        if (interfaceMenuC13895a == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1703d = interfaceMenuC13895a;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m2429c(this.f1703d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f1703d.addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr[i14] = m2429c(menuItemArr2[i14]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m2430d(this.f1703d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        m2431e();
        this.f1703d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f1703d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        return m2429c(this.f1703d.findItem(i10));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return m2429c(this.f1703d.getItem(i10));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f1703d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return this.f1703d.isShortcutKey(i10, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return this.f1703d.performIdentifierAction(i10, i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return this.f1703d.performShortcut(i10, keyEvent, i11);
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        m2432f(i10);
        this.f1703d.removeGroup(i10);
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        m2433g(i10);
        this.f1703d.removeItem(i10);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        this.f1703d.setGroupCheckable(i10, z10, z11);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        this.f1703d.setGroupEnabled(i10, z10);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        this.f1703d.setGroupVisible(i10, z10);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1703d.setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1703d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return m2429c(this.f1703d.add(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return m2430d(this.f1703d.addSubMenu(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return m2429c(this.f1703d.add(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return m2430d(this.f1703d.addSubMenu(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return m2429c(this.f1703d.add(i10, i11, i12, i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return m2430d(this.f1703d.addSubMenu(i10, i11, i12, i13));
    }
}
