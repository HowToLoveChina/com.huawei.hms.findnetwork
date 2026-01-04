package p303g;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import p303g.AbstractC9814b;

/* renamed from: g.e */
/* loaded from: classes.dex */
public class C9817e extends AbstractC9814b implements MenuBuilder.InterfaceC0398a {

    /* renamed from: c */
    public Context f48244c;

    /* renamed from: d */
    public ActionBarContextView f48245d;

    /* renamed from: e */
    public AbstractC9814b.a f48246e;

    /* renamed from: f */
    public WeakReference<View> f48247f;

    /* renamed from: g */
    public boolean f48248g;

    /* renamed from: h */
    public boolean f48249h;

    /* renamed from: i */
    public MenuBuilder f48250i;

    public C9817e(Context context, ActionBarContextView actionBarContextView, AbstractC9814b.a aVar, boolean z10) {
        this.f48244c = context;
        this.f48245d = actionBarContextView;
        this.f48246e = aVar;
        MenuBuilder menuBuilderM2358W = new MenuBuilder(actionBarContextView.getContext()).m2358W(1);
        this.f48250i = menuBuilderM2358W;
        menuBuilderM2358W.mo2357V(this);
        this.f48249h = z10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
    /* renamed from: a */
    public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f48246e.mo2160a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
    /* renamed from: b */
    public void mo2105b(MenuBuilder menuBuilder) {
        mo2291k();
        this.f48245d.m2532l();
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: c */
    public void mo2285c() {
        if (this.f48248g) {
            return;
        }
        this.f48248g = true;
        this.f48246e.mo2161b(this);
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: d */
    public View mo2286d() {
        WeakReference<View> weakReference = this.f48247f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: e */
    public Menu mo2287e() {
        return this.f48250i;
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: f */
    public MenuInflater mo2288f() {
        return new SupportMenuInflater(this.f48245d.getContext());
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: g */
    public CharSequence mo2289g() {
        return this.f48245d.getSubtitle();
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: i */
    public CharSequence mo2290i() {
        return this.f48245d.getTitle();
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: k */
    public void mo2291k() {
        this.f48246e.mo2162c(this, this.f48250i);
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: l */
    public boolean mo2292l() {
        return this.f48245d.m2530j();
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: m */
    public void mo2293m(View view) {
        this.f48245d.setCustomView(view);
        this.f48247f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: n */
    public void mo2294n(int i10) {
        mo2295o(this.f48244c.getString(i10));
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: o */
    public void mo2295o(CharSequence charSequence) {
        this.f48245d.setSubtitle(charSequence);
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: q */
    public void mo2296q(int i10) {
        mo2297r(this.f48244c.getString(i10));
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: r */
    public void mo2297r(CharSequence charSequence) {
        this.f48245d.setTitle(charSequence);
    }

    @Override // p303g.AbstractC9814b
    /* renamed from: s */
    public void mo2298s(boolean z10) {
        super.mo2298s(z10);
        this.f48245d.setTitleOptional(z10);
    }
}
