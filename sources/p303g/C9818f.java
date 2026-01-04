package p303g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuC0416m;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import java.util.ArrayList;
import p303g.AbstractC9814b;
import p438l.C11213g;
import p793y.InterfaceMenuC13895a;
import p793y.InterfaceMenuItemC13896b;

/* renamed from: g.f */
/* loaded from: classes.dex */
public class C9818f extends ActionMode {

    /* renamed from: a */
    public final Context f48251a;

    /* renamed from: b */
    public final AbstractC9814b f48252b;

    /* renamed from: g.f$a */
    public static class a implements AbstractC9814b.a {

        /* renamed from: a */
        public final ActionMode.Callback f48253a;

        /* renamed from: b */
        public final Context f48254b;

        /* renamed from: c */
        public final ArrayList<C9818f> f48255c = new ArrayList<>();

        /* renamed from: d */
        public final C11213g<Menu, Menu> f48256d = new C11213g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f48254b = context;
            this.f48253a = callback;
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: a */
        public boolean mo2160a(AbstractC9814b abstractC9814b, MenuItem menuItem) {
            return this.f48253a.onActionItemClicked(m61010e(abstractC9814b), new MenuItemWrapperICS(this.f48254b, (InterfaceMenuItemC13896b) menuItem));
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: b */
        public void mo2161b(AbstractC9814b abstractC9814b) {
            this.f48253a.onDestroyActionMode(m61010e(abstractC9814b));
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: c */
        public boolean mo2162c(AbstractC9814b abstractC9814b, Menu menu) {
            return this.f48253a.onPrepareActionMode(m61010e(abstractC9814b), m61011f(menu));
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: d */
        public boolean mo2163d(AbstractC9814b abstractC9814b, Menu menu) {
            return this.f48253a.onCreateActionMode(m61010e(abstractC9814b), m61011f(menu));
        }

        /* renamed from: e */
        public ActionMode m61010e(AbstractC9814b abstractC9814b) {
            int size = this.f48255c.size();
            for (int i10 = 0; i10 < size; i10++) {
                C9818f c9818f = this.f48255c.get(i10);
                if (c9818f != null && c9818f.f48252b == abstractC9814b) {
                    return c9818f;
                }
            }
            C9818f c9818f2 = new C9818f(this.f48254b, abstractC9814b);
            this.f48255c.add(c9818f2);
            return c9818f2;
        }

        /* renamed from: f */
        public final Menu m61011f(Menu menu) {
            Menu menu2 = this.f48256d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuC0416m menuC0416m = new MenuC0416m(this.f48254b, (InterfaceMenuC13895a) menu);
            this.f48256d.put(menu, menuC0416m);
            return menuC0416m;
        }
    }

    public C9818f(Context context, AbstractC9814b abstractC9814b) {
        this.f48251a = context;
        this.f48252b = abstractC9814b;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f48252b.mo2285c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f48252b.mo2286d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuC0416m(this.f48251a, (InterfaceMenuC13895a) this.f48252b.mo2287e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f48252b.mo2288f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f48252b.mo2289g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f48252b.m61000h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f48252b.mo2290i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f48252b.m61001j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f48252b.mo2291k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f48252b.mo2292l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f48252b.mo2293m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f48252b.mo2295o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f48252b.m61002p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f48252b.mo2297r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f48252b.mo2298s(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f48252b.mo2294n(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f48252b.mo2296q(i10);
    }
}
