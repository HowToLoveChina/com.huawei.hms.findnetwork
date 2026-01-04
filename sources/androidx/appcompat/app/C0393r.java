package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.InterfaceC0543r;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p273f0.C9603h0;
import p273f0.C9615n0;
import p273f0.C9619p0;
import p273f0.InterfaceC9617o0;
import p273f0.InterfaceC9621q0;
import p303g.AbstractC9814b;
import p303g.C9813a;
import p303g.C9819g;

/* renamed from: androidx.appcompat.app.r */
/* loaded from: classes.dex */
public class C0393r extends ActionBar implements ActionBarOverlayLayout.InterfaceC0427d {

    /* renamed from: E */
    public static final Interpolator f1400E = new AccelerateInterpolator();

    /* renamed from: F */
    public static final Interpolator f1401F = new DecelerateInterpolator();

    /* renamed from: A */
    public boolean f1402A;

    /* renamed from: a */
    public Context f1406a;

    /* renamed from: b */
    public Context f1407b;

    /* renamed from: c */
    public Activity f1408c;

    /* renamed from: d */
    public ActionBarOverlayLayout f1409d;

    /* renamed from: e */
    public ActionBarContainer f1410e;

    /* renamed from: f */
    public InterfaceC0543r f1411f;

    /* renamed from: g */
    public ActionBarContextView f1412g;

    /* renamed from: h */
    public View f1413h;

    /* renamed from: i */
    public ScrollingTabContainerView f1414i;

    /* renamed from: l */
    public boolean f1417l;

    /* renamed from: m */
    public d f1418m;

    /* renamed from: n */
    public AbstractC9814b f1419n;

    /* renamed from: o */
    public AbstractC9814b.a f1420o;

    /* renamed from: p */
    public boolean f1421p;

    /* renamed from: r */
    public boolean f1423r;

    /* renamed from: u */
    public boolean f1426u;

    /* renamed from: v */
    public boolean f1427v;

    /* renamed from: w */
    public boolean f1428w;

    /* renamed from: y */
    public C9819g f1430y;

    /* renamed from: z */
    public boolean f1431z;

    /* renamed from: j */
    public ArrayList<Object> f1415j = new ArrayList<>();

    /* renamed from: k */
    public int f1416k = -1;

    /* renamed from: q */
    public ArrayList<ActionBar.InterfaceC0345a> f1422q = new ArrayList<>();

    /* renamed from: s */
    public int f1424s = 0;

    /* renamed from: t */
    public boolean f1425t = true;

    /* renamed from: x */
    public boolean f1429x = true;

    /* renamed from: B */
    public final InterfaceC9617o0 f1403B = new a();

    /* renamed from: C */
    public final InterfaceC9617o0 f1404C = new b();

    /* renamed from: D */
    public final InterfaceC9621q0 f1405D = new c();

    /* renamed from: androidx.appcompat.app.r$a */
    public class a extends C9619p0 {
        public a() {
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: b */
        public void mo2156b(View view) {
            View view2;
            C0393r c0393r = C0393r.this;
            if (c0393r.f1425t && (view2 = c0393r.f1413h) != null) {
                view2.setTranslationY(0.0f);
                C0393r.this.f1410e.setTranslationY(0.0f);
            }
            C0393r.this.f1410e.setVisibility(8);
            C0393r.this.f1410e.setTransitioning(false);
            C0393r c0393r2 = C0393r.this;
            c0393r2.f1430y = null;
            c0393r2.m2281x();
            ActionBarOverlayLayout actionBarOverlayLayout = C0393r.this.f1409d;
            if (actionBarOverlayLayout != null) {
                C9603h0.m59896m0(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.r$b */
    public class b extends C9619p0 {
        public b() {
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: b */
        public void mo2156b(View view) {
            C0393r c0393r = C0393r.this;
            c0393r.f1430y = null;
            c0393r.f1410e.requestLayout();
        }
    }

    /* renamed from: androidx.appcompat.app.r$c */
    public class c implements InterfaceC9621q0 {
        public c() {
        }

        @Override // p273f0.InterfaceC9621q0
        /* renamed from: a */
        public void mo2284a(View view) {
            ((View) C0393r.this.f1410e.getParent()).invalidate();
        }
    }

    /* renamed from: androidx.appcompat.app.r$d */
    public class d extends AbstractC9814b implements MenuBuilder.InterfaceC0398a {

        /* renamed from: c */
        public final Context f1435c;

        /* renamed from: d */
        public final MenuBuilder f1436d;

        /* renamed from: e */
        public AbstractC9814b.a f1437e;

        /* renamed from: f */
        public WeakReference<View> f1438f;

        public d(Context context, AbstractC9814b.a aVar) {
            this.f1435c = context;
            this.f1437e = aVar;
            MenuBuilder menuBuilderM2358W = new MenuBuilder(context).m2358W(1);
            this.f1436d = menuBuilderM2358W;
            menuBuilderM2358W.mo2357V(this);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: a */
        public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
            AbstractC9814b.a aVar = this.f1437e;
            if (aVar != null) {
                return aVar.mo2160a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: b */
        public void mo2105b(MenuBuilder menuBuilder) {
            if (this.f1437e == null) {
                return;
            }
            mo2291k();
            C0393r.this.f1412g.m2532l();
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: c */
        public void mo2285c() {
            C0393r c0393r = C0393r.this;
            if (c0393r.f1418m != this) {
                return;
            }
            if (C0393r.m2260w(c0393r.f1426u, c0393r.f1427v, false)) {
                this.f1437e.mo2161b(this);
            } else {
                C0393r c0393r2 = C0393r.this;
                c0393r2.f1419n = this;
                c0393r2.f1420o = this.f1437e;
            }
            this.f1437e = null;
            C0393r.this.m2280v(false);
            C0393r.this.f1412g.m2527g();
            C0393r c0393r3 = C0393r.this;
            c0393r3.f1409d.setHideOnContentScrollEnabled(c0393r3.f1402A);
            C0393r.this.f1418m = null;
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: d */
        public View mo2286d() {
            WeakReference<View> weakReference = this.f1438f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: e */
        public Menu mo2287e() {
            return this.f1436d;
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: f */
        public MenuInflater mo2288f() {
            return new SupportMenuInflater(this.f1435c);
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: g */
        public CharSequence mo2289g() {
            return C0393r.this.f1412g.getSubtitle();
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: i */
        public CharSequence mo2290i() {
            return C0393r.this.f1412g.getTitle();
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: k */
        public void mo2291k() {
            if (C0393r.this.f1418m != this) {
                return;
            }
            this.f1436d.m2377h0();
            try {
                this.f1437e.mo2162c(this, this.f1436d);
            } finally {
                this.f1436d.m2375g0();
            }
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: l */
        public boolean mo2292l() {
            return C0393r.this.f1412g.m2530j();
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: m */
        public void mo2293m(View view) {
            C0393r.this.f1412g.setCustomView(view);
            this.f1438f = new WeakReference<>(view);
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: n */
        public void mo2294n(int i10) {
            mo2295o(C0393r.this.f1406a.getResources().getString(i10));
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: o */
        public void mo2295o(CharSequence charSequence) {
            C0393r.this.f1412g.setSubtitle(charSequence);
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: q */
        public void mo2296q(int i10) {
            mo2297r(C0393r.this.f1406a.getResources().getString(i10));
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: r */
        public void mo2297r(CharSequence charSequence) {
            C0393r.this.f1412g.setTitle(charSequence);
        }

        @Override // p303g.AbstractC9814b
        /* renamed from: s */
        public void mo2298s(boolean z10) {
            super.mo2298s(z10);
            C0393r.this.f1412g.setTitleOptional(z10);
        }

        /* renamed from: t */
        public boolean m2299t() {
            this.f1436d.m2377h0();
            try {
                return this.f1437e.mo2163d(this, this.f1436d);
            } finally {
                this.f1436d.m2375g0();
            }
        }
    }

    public C0393r(Activity activity, boolean z10) {
        this.f1408c = activity;
        View decorView = activity.getWindow().getDecorView();
        m2264D(decorView);
        if (z10) {
            return;
        }
        this.f1413h = decorView.findViewById(R.id.content);
    }

    /* renamed from: w */
    public static boolean m2260w(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: A */
    public final InterfaceC0543r m2261A(View view) {
        if (view instanceof InterfaceC0543r) {
            return (InterfaceC0543r) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }

    /* renamed from: B */
    public int m2262B() {
        return this.f1411f.mo3018m();
    }

    /* renamed from: C */
    public final void m2263C() {
        if (this.f1428w) {
            this.f1428w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1409d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m2273M(false);
        }
    }

    /* renamed from: D */
    public final void m2264D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f1409d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1411f = m2261A(view.findViewById(R$id.action_bar));
        this.f1412g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f1410e = actionBarContainer;
        InterfaceC0543r interfaceC0543r = this.f1411f;
        if (interfaceC0543r == null || this.f1412g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1406a = interfaceC0543r.getContext();
        boolean z10 = (this.f1411f.mo3021p() & 4) != 0;
        if (z10) {
            this.f1417l = true;
        }
        C9813a c9813aM60992b = C9813a.m60992b(this.f1406a);
        m2270J(c9813aM60992b.m60993a() || z10);
        m2268H(c9813aM60992b.m60998g());
        TypedArray typedArrayObtainStyledAttributes = this.f1406a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            m2269I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m2267G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: E */
    public void m2265E(boolean z10) {
        m2266F(z10 ? 4 : 0, 4);
    }

    /* renamed from: F */
    public void m2266F(int i10, int i11) {
        int iMo3021p = this.f1411f.mo3021p();
        if ((i11 & 4) != 0) {
            this.f1417l = true;
        }
        this.f1411f.mo3016k((i10 & i11) | ((~i11) & iMo3021p));
    }

    /* renamed from: G */
    public void m2267G(float f10) {
        C9603h0.m59918x0(this.f1410e, f10);
    }

    /* renamed from: H */
    public final void m2268H(boolean z10) {
        this.f1423r = z10;
        if (z10) {
            this.f1410e.setTabContainer(null);
            this.f1411f.mo3014i(this.f1414i);
        } else {
            this.f1411f.mo3014i(null);
            this.f1410e.setTabContainer(this.f1414i);
        }
        boolean z11 = m2262B() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f1414i;
        if (scrollingTabContainerView != null) {
            if (z11) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1409d;
                if (actionBarOverlayLayout != null) {
                    C9603h0.m59896m0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f1411f.mo3024s(!this.f1423r && z11);
        this.f1409d.setHasNonEmbeddedTabs(!this.f1423r && z11);
    }

    /* renamed from: I */
    public void m2269I(boolean z10) {
        if (z10 && !this.f1409d.m2557w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f1402A = z10;
        this.f1409d.setHideOnContentScrollEnabled(z10);
    }

    /* renamed from: J */
    public void m2270J(boolean z10) {
        this.f1411f.mo3020o(z10);
    }

    /* renamed from: K */
    public final boolean m2271K() {
        return C9603h0.m59864T(this.f1410e);
    }

    /* renamed from: L */
    public final void m2272L() {
        if (this.f1428w) {
            return;
        }
        this.f1428w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1409d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        m2273M(false);
    }

    /* renamed from: M */
    public final void m2273M(boolean z10) {
        if (m2260w(this.f1426u, this.f1427v, this.f1428w)) {
            if (this.f1429x) {
                return;
            }
            this.f1429x = true;
            m2283z(z10);
            return;
        }
        if (this.f1429x) {
            this.f1429x = false;
            m2282y(z10);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0427d
    /* renamed from: a */
    public void mo2274a() {
        if (this.f1427v) {
            this.f1427v = false;
            m2273M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0427d
    /* renamed from: b */
    public void mo2275b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0427d
    /* renamed from: c */
    public void mo2276c(boolean z10) {
        this.f1425t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0427d
    /* renamed from: d */
    public void mo2277d() {
        if (this.f1427v) {
            return;
        }
        this.f1427v = true;
        m2273M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0427d
    /* renamed from: e */
    public void mo2278e() {
        C9819g c9819g = this.f1430y;
        if (c9819g != null) {
            c9819g.m61012a();
            this.f1430y = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0427d
    /* renamed from: f */
    public void mo2279f(int i10) {
        this.f1424s = i10;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: h */
    public boolean mo1975h() {
        InterfaceC0543r interfaceC0543r = this.f1411f;
        if (interfaceC0543r == null || !interfaceC0543r.mo3015j()) {
            return false;
        }
        this.f1411f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: i */
    public void mo1976i(boolean z10) {
        if (z10 == this.f1421p) {
            return;
        }
        this.f1421p = z10;
        int size = this.f1422q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1422q.get(i10).m1989a(z10);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: j */
    public int mo1977j() {
        return this.f1411f.mo3021p();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: k */
    public Context mo1978k() {
        if (this.f1407b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1406a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f1407b = new ContextThemeWrapper(this.f1406a, i10);
            } else {
                this.f1407b = this.f1406a;
            }
        }
        return this.f1407b;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: m */
    public void mo1980m(Configuration configuration) {
        m2268H(C9813a.m60992b(this.f1406a).m60998g());
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: o */
    public boolean mo1982o(int i10, KeyEvent keyEvent) {
        Menu menuMo2287e;
        d dVar = this.f1418m;
        if (dVar == null || (menuMo2287e = dVar.mo2287e()) == null) {
            return false;
        }
        menuMo2287e.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuMo2287e.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: r */
    public void mo1985r(boolean z10) {
        if (this.f1417l) {
            return;
        }
        m2265E(z10);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: s */
    public void mo1986s(boolean z10) {
        C9819g c9819g;
        this.f1431z = z10;
        if (z10 || (c9819g = this.f1430y) == null) {
            return;
        }
        c9819g.m61012a();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: t */
    public void mo1987t(CharSequence charSequence) {
        this.f1411f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: u */
    public AbstractC9814b mo1988u(AbstractC9814b.a aVar) {
        d dVar = this.f1418m;
        if (dVar != null) {
            dVar.mo2285c();
        }
        this.f1409d.setHideOnContentScrollEnabled(false);
        this.f1412g.m2531k();
        d dVar2 = new d(this.f1412g.getContext(), aVar);
        if (!dVar2.m2299t()) {
            return null;
        }
        this.f1418m = dVar2;
        dVar2.mo2291k();
        this.f1412g.m2528h(dVar2);
        m2280v(true);
        return dVar2;
    }

    /* renamed from: v */
    public void m2280v(boolean z10) {
        C9615n0 c9615n0Mo2521f;
        C9615n0 c9615n0Mo2521f2;
        if (z10) {
            m2272L();
        } else {
            m2263C();
        }
        if (!m2271K()) {
            if (z10) {
                this.f1411f.setVisibility(4);
                this.f1412g.setVisibility(0);
                return;
            } else {
                this.f1411f.setVisibility(0);
                this.f1412g.setVisibility(8);
                return;
            }
        }
        if (z10) {
            c9615n0Mo2521f = this.f1411f.mo3019n(4, 100L);
            c9615n0Mo2521f2 = this.f1412g.mo2521f(0, 200L);
        } else {
            C9615n0 c9615n0Mo3019n = this.f1411f.mo3019n(0, 200L);
            c9615n0Mo2521f = this.f1412g.mo2521f(8, 100L);
            c9615n0Mo2521f2 = c9615n0Mo3019n;
        }
        C9819g c9819g = new C9819g();
        c9819g.m61015d(c9615n0Mo2521f, c9615n0Mo2521f2);
        c9819g.m61019h();
    }

    /* renamed from: x */
    public void m2281x() {
        AbstractC9814b.a aVar = this.f1420o;
        if (aVar != null) {
            aVar.mo2161b(this.f1419n);
            this.f1419n = null;
            this.f1420o = null;
        }
    }

    /* renamed from: y */
    public void m2282y(boolean z10) {
        View view;
        C9819g c9819g = this.f1430y;
        if (c9819g != null) {
            c9819g.m61012a();
        }
        if (this.f1424s != 0 || (!this.f1431z && !z10)) {
            this.f1403B.mo2156b(null);
            return;
        }
        this.f1410e.setAlpha(1.0f);
        this.f1410e.setTransitioning(true);
        C9819g c9819g2 = new C9819g();
        float f10 = -this.f1410e.getHeight();
        if (z10) {
            this.f1410e.getLocationInWindow(new int[]{0, 0});
            f10 -= r5[1];
        }
        C9615n0 c9615n0M60118m = C9603h0.m59879e(this.f1410e).m60118m(f10);
        c9615n0M60118m.m60116k(this.f1405D);
        c9819g2.m61014c(c9615n0M60118m);
        if (this.f1425t && (view = this.f1413h) != null) {
            c9819g2.m61014c(C9603h0.m59879e(view).m60118m(f10));
        }
        c9819g2.m61017f(f1400E);
        c9819g2.m61016e(250L);
        c9819g2.m61018g(this.f1403B);
        this.f1430y = c9819g2;
        c9819g2.m61019h();
    }

    /* renamed from: z */
    public void m2283z(boolean z10) {
        View view;
        View view2;
        C9819g c9819g = this.f1430y;
        if (c9819g != null) {
            c9819g.m61012a();
        }
        this.f1410e.setVisibility(0);
        if (this.f1424s == 0 && (this.f1431z || z10)) {
            this.f1410e.setTranslationY(0.0f);
            float f10 = -this.f1410e.getHeight();
            if (z10) {
                this.f1410e.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f1410e.setTranslationY(f10);
            C9819g c9819g2 = new C9819g();
            C9615n0 c9615n0M60118m = C9603h0.m59879e(this.f1410e).m60118m(0.0f);
            c9615n0M60118m.m60116k(this.f1405D);
            c9819g2.m61014c(c9615n0M60118m);
            if (this.f1425t && (view2 = this.f1413h) != null) {
                view2.setTranslationY(f10);
                c9819g2.m61014c(C9603h0.m59879e(this.f1413h).m60118m(0.0f));
            }
            c9819g2.m61017f(f1401F);
            c9819g2.m61016e(250L);
            c9819g2.m61018g(this.f1404C);
            this.f1430y = c9819g2;
            c9819g2.m61019h();
        } else {
            this.f1410e.setAlpha(1.0f);
            this.f1410e.setTranslationY(0.0f);
            if (this.f1425t && (view = this.f1413h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f1404C.mo2156b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1409d;
        if (actionBarOverlayLayout != null) {
            C9603h0.m59896m0(actionBarOverlayLayout);
        }
    }

    public C0393r(Dialog dialog) {
        m2264D(dialog.getWindow().getDecorView());
    }
}
