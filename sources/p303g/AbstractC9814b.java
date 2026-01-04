package p303g;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: g.b */
/* loaded from: classes.dex */
public abstract class AbstractC9814b {

    /* renamed from: a */
    public Object f48236a;

    /* renamed from: b */
    public boolean f48237b;

    /* renamed from: g.b$a */
    public interface a {
        /* renamed from: a */
        boolean mo2160a(AbstractC9814b abstractC9814b, MenuItem menuItem);

        /* renamed from: b */
        void mo2161b(AbstractC9814b abstractC9814b);

        /* renamed from: c */
        boolean mo2162c(AbstractC9814b abstractC9814b, Menu menu);

        /* renamed from: d */
        boolean mo2163d(AbstractC9814b abstractC9814b, Menu menu);
    }

    /* renamed from: c */
    public abstract void mo2285c();

    /* renamed from: d */
    public abstract View mo2286d();

    /* renamed from: e */
    public abstract Menu mo2287e();

    /* renamed from: f */
    public abstract MenuInflater mo2288f();

    /* renamed from: g */
    public abstract CharSequence mo2289g();

    /* renamed from: h */
    public Object m61000h() {
        return this.f48236a;
    }

    /* renamed from: i */
    public abstract CharSequence mo2290i();

    /* renamed from: j */
    public boolean m61001j() {
        return this.f48237b;
    }

    /* renamed from: k */
    public abstract void mo2291k();

    /* renamed from: l */
    public abstract boolean mo2292l();

    /* renamed from: m */
    public abstract void mo2293m(View view);

    /* renamed from: n */
    public abstract void mo2294n(int i10);

    /* renamed from: o */
    public abstract void mo2295o(CharSequence charSequence);

    /* renamed from: p */
    public void m61002p(Object obj) {
        this.f48236a = obj;
    }

    /* renamed from: q */
    public abstract void mo2296q(int i10);

    /* renamed from: r */
    public abstract void mo2297r(CharSequence charSequence);

    /* renamed from: s */
    public void mo2298s(boolean z10) {
        this.f48237b = z10;
    }
}
