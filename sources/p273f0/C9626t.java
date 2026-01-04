package p273f0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.view.ActionProvider;
import p793y.InterfaceMenuItemC13896b;

/* renamed from: f0.t */
/* loaded from: classes.dex */
public final class C9626t {

    /* renamed from: f0.t$a */
    public static class a {
        /* renamed from: a */
        public static int m60214a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        /* renamed from: b */
        public static CharSequence m60215b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        /* renamed from: c */
        public static ColorStateList m60216c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        /* renamed from: d */
        public static PorterDuff.Mode m60217d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        /* renamed from: e */
        public static int m60218e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        /* renamed from: f */
        public static CharSequence m60219f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        /* renamed from: g */
        public static MenuItem m60220g(MenuItem menuItem, char c10, int i10) {
            return menuItem.setAlphabeticShortcut(c10, i10);
        }

        /* renamed from: h */
        public static MenuItem m60221h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        /* renamed from: i */
        public static MenuItem m60222i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        /* renamed from: j */
        public static MenuItem m60223j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        /* renamed from: k */
        public static MenuItem m60224k(MenuItem menuItem, char c10, int i10) {
            return menuItem.setNumericShortcut(c10, i10);
        }

        /* renamed from: l */
        public static MenuItem m60225l(MenuItem menuItem, char c10, char c11, int i10, int i11) {
            return menuItem.setShortcut(c10, c11, i10, i11);
        }

        /* renamed from: m */
        public static MenuItem m60226m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    /* renamed from: a */
    public static MenuItem m60207a(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            return ((InterfaceMenuItemC13896b) menuItem).mo2407a(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: b */
    public static void m60208b(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            ((InterfaceMenuItemC13896b) menuItem).setAlphabeticShortcut(c10, i10);
        } else {
            a.m60220g(menuItem, c10, i10);
        }
    }

    /* renamed from: c */
    public static void m60209c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            ((InterfaceMenuItemC13896b) menuItem).setContentDescription(charSequence);
        } else {
            a.m60221h(menuItem, charSequence);
        }
    }

    /* renamed from: d */
    public static void m60210d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            ((InterfaceMenuItemC13896b) menuItem).setIconTintList(colorStateList);
        } else {
            a.m60222i(menuItem, colorStateList);
        }
    }

    /* renamed from: e */
    public static void m60211e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            ((InterfaceMenuItemC13896b) menuItem).setIconTintMode(mode);
        } else {
            a.m60223j(menuItem, mode);
        }
    }

    /* renamed from: f */
    public static void m60212f(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            ((InterfaceMenuItemC13896b) menuItem).setNumericShortcut(c10, i10);
        } else {
            a.m60224k(menuItem, c10, i10);
        }
    }

    /* renamed from: g */
    public static void m60213g(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC13896b) {
            ((InterfaceMenuItemC13896b) menuItem).setTooltipText(charSequence);
        } else {
            a.m60226m(menuItem, charSequence);
        }
    }
}
