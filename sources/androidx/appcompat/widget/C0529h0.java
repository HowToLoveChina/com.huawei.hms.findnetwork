package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0404a;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import p211d.C8968a;
import p273f0.C9603h0;
import p273f0.C9615n0;
import p273f0.C9619p0;

/* renamed from: androidx.appcompat.widget.h0 */
/* loaded from: classes.dex */
public class C0529h0 implements InterfaceC0543r {

    /* renamed from: a */
    public Toolbar f2336a;

    /* renamed from: b */
    public int f2337b;

    /* renamed from: c */
    public View f2338c;

    /* renamed from: d */
    public View f2339d;

    /* renamed from: e */
    public Drawable f2340e;

    /* renamed from: f */
    public Drawable f2341f;

    /* renamed from: g */
    public Drawable f2342g;

    /* renamed from: h */
    public boolean f2343h;

    /* renamed from: i */
    public CharSequence f2344i;

    /* renamed from: j */
    public CharSequence f2345j;

    /* renamed from: k */
    public CharSequence f2346k;

    /* renamed from: l */
    public Window.Callback f2347l;

    /* renamed from: m */
    public boolean f2348m;

    /* renamed from: n */
    public ActionMenuPresenter f2349n;

    /* renamed from: o */
    public int f2350o;

    /* renamed from: p */
    public int f2351p;

    /* renamed from: q */
    public Drawable f2352q;

    /* renamed from: androidx.appcompat.widget.h0$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final C0404a f2353a;

        public a() {
            this.f2353a = new C0404a(C0529h0.this.f2336a.getContext(), 0, R.id.home, 0, 0, C0529h0.this.f2344i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0529h0 c0529h0 = C0529h0.this;
            Window.Callback callback = c0529h0.f2347l;
            if (callback == null || !c0529h0.f2348m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f2353a);
        }
    }

    /* renamed from: androidx.appcompat.widget.h0$b */
    public class b extends C9619p0 {

        /* renamed from: a */
        public boolean f2355a = false;

        /* renamed from: b */
        public final /* synthetic */ int f2356b;

        public b(int i10) {
            this.f2356b = i10;
        }

        @Override // p273f0.C9619p0, p273f0.InterfaceC9617o0
        /* renamed from: a */
        public void mo2522a(View view) {
            this.f2355a = true;
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: b */
        public void mo2156b(View view) {
            if (this.f2355a) {
                return;
            }
            C0529h0.this.f2336a.setVisibility(this.f2356b);
        }

        @Override // p273f0.C9619p0, p273f0.InterfaceC9617o0
        /* renamed from: c */
        public void mo2157c(View view) {
            C0529h0.this.f2336a.setVisibility(0);
        }
    }

    public C0529h0(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    /* renamed from: A */
    public void m3000A(CharSequence charSequence) {
        this.f2345j = charSequence;
        if ((this.f2337b & 8) != 0) {
            this.f2336a.setSubtitle(charSequence);
        }
    }

    /* renamed from: B */
    public void m3001B(CharSequence charSequence) {
        this.f2343h = true;
        m3002C(charSequence);
    }

    /* renamed from: C */
    public final void m3002C(CharSequence charSequence) {
        this.f2344i = charSequence;
        if ((this.f2337b & 8) != 0) {
            this.f2336a.setTitle(charSequence);
            if (this.f2343h) {
                C9603h0.m59908s0(this.f2336a.getRootView(), charSequence);
            }
        }
    }

    /* renamed from: D */
    public final void m3003D() {
        if ((this.f2337b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2346k)) {
                this.f2336a.setNavigationContentDescription(this.f2351p);
            } else {
                this.f2336a.setNavigationContentDescription(this.f2346k);
            }
        }
    }

    /* renamed from: E */
    public final void m3004E() {
        if ((this.f2337b & 4) == 0) {
            this.f2336a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f2336a;
        Drawable drawable = this.f2342g;
        if (drawable == null) {
            drawable = this.f2352q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    /* renamed from: F */
    public final void m3005F() {
        Drawable drawable;
        int i10 = this.f2337b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f2341f) == null) {
            drawable = this.f2340e;
        }
        this.f2336a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: a */
    public void mo3006a(Menu menu, InterfaceC0414k.a aVar) {
        if (this.f2349n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f2336a.getContext());
            this.f2349n = actionMenuPresenter;
            actionMenuPresenter.m2427s(R$id.action_menu_presenter);
        }
        this.f2349n.mo2417f(aVar);
        this.f2336a.m2849M((MenuBuilder) menu, this.f2349n);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: b */
    public boolean mo3007b() {
        return this.f2336a.m2840D();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: c */
    public void mo3008c() {
        this.f2348m = true;
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public void collapseActionView() {
        this.f2336a.m2860f();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: d */
    public boolean mo3009d() {
        return this.f2336a.m2859e();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: e */
    public boolean mo3010e() {
        return this.f2336a.m2839C();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: f */
    public boolean mo3011f() {
        return this.f2336a.m2878y();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: g */
    public boolean mo3012g() {
        return this.f2336a.m2854R();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public Context getContext() {
        return this.f2336a.getContext();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public CharSequence getTitle() {
        return this.f2336a.getTitle();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: h */
    public void mo3013h() {
        this.f2336a.m2861g();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: i */
    public void mo3014i(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2338c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2336a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2338c);
            }
        }
        this.f2338c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f2350o != 2) {
            return;
        }
        this.f2336a.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2338c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.f1145a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: j */
    public boolean mo3015j() {
        return this.f2336a.m2877x();
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: k */
    public void mo3016k(int i10) {
        View view;
        int i11 = this.f2337b ^ i10;
        this.f2337b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    m3003D();
                }
                m3004E();
            }
            if ((i11 & 3) != 0) {
                m3005F();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f2336a.setTitle(this.f2344i);
                    this.f2336a.setSubtitle(this.f2345j);
                } else {
                    this.f2336a.setTitle((CharSequence) null);
                    this.f2336a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f2339d) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                this.f2336a.addView(view);
            } else {
                this.f2336a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: l */
    public void mo3017l(int i10) {
        m3028w(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: m */
    public int mo3018m() {
        return this.f2350o;
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: n */
    public C9615n0 mo3019n(int i10, long j10) {
        return C9603h0.m59879e(this.f2336a).m60108b(i10 == 0 ? 1.0f : 0.0f).m60111f(j10).m60113h(new b(i10));
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: o */
    public void mo3020o(boolean z10) {
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: p */
    public int mo3021p() {
        return this.f2337b;
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: q */
    public void mo3022q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: r */
    public void mo3023r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    /* renamed from: s */
    public void mo3024s(boolean z10) {
        this.f2336a.setCollapsible(z10);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public void setVisibility(int i10) {
        this.f2336a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public void setWindowCallback(Window.Callback callback) {
        this.f2347l = callback;
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2343h) {
            return;
        }
        m3002C(charSequence);
    }

    /* renamed from: t */
    public final int m3025t() {
        if (this.f2336a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2352q = this.f2336a.getNavigationIcon();
        return 15;
    }

    /* renamed from: u */
    public void m3026u(View view) {
        View view2 = this.f2339d;
        if (view2 != null && (this.f2337b & 16) != 0) {
            this.f2336a.removeView(view2);
        }
        this.f2339d = view;
        if (view == null || (this.f2337b & 16) == 0) {
            return;
        }
        this.f2336a.addView(view);
    }

    /* renamed from: v */
    public void m3027v(int i10) {
        if (i10 == this.f2351p) {
            return;
        }
        this.f2351p = i10;
        if (TextUtils.isEmpty(this.f2336a.getNavigationContentDescription())) {
            m3029x(this.f2351p);
        }
    }

    /* renamed from: w */
    public void m3028w(Drawable drawable) {
        this.f2341f = drawable;
        m3005F();
    }

    /* renamed from: x */
    public void m3029x(int i10) {
        m3030y(i10 == 0 ? null : getContext().getString(i10));
    }

    /* renamed from: y */
    public void m3030y(CharSequence charSequence) {
        this.f2346k = charSequence;
        m3003D();
    }

    /* renamed from: z */
    public void m3031z(Drawable drawable) {
        this.f2342g = drawable;
        m3004E();
    }

    public C0529h0(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f2350o = 0;
        this.f2351p = 0;
        this.f2336a = toolbar;
        this.f2344i = toolbar.getTitle();
        this.f2345j = toolbar.getSubtitle();
        this.f2343h = this.f2344i != null;
        this.f2342g = toolbar.getNavigationIcon();
        C0523e0 c0523e0M2946v = C0523e0.m2946v(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f2352q = c0523e0M2946v.m2953g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence charSequenceM2962p = c0523e0M2946v.m2962p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceM2962p)) {
                m3001B(charSequenceM2962p);
            }
            CharSequence charSequenceM2962p2 = c0523e0M2946v.m2962p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceM2962p2)) {
                m3000A(charSequenceM2962p2);
            }
            Drawable drawableM2953g = c0523e0M2946v.m2953g(R$styleable.ActionBar_logo);
            if (drawableM2953g != null) {
                m3028w(drawableM2953g);
            }
            Drawable drawableM2953g2 = c0523e0M2946v.m2953g(R$styleable.ActionBar_icon);
            if (drawableM2953g2 != null) {
                setIcon(drawableM2953g2);
            }
            if (this.f2342g == null && (drawable = this.f2352q) != null) {
                m3031z(drawable);
            }
            mo3016k(c0523e0M2946v.m2957k(R$styleable.ActionBar_displayOptions, 0));
            int iM2960n = c0523e0M2946v.m2960n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iM2960n != 0) {
                m3026u(LayoutInflater.from(this.f2336a.getContext()).inflate(iM2960n, (ViewGroup) this.f2336a, false));
                mo3016k(this.f2337b | 16);
            }
            int iM2959m = c0523e0M2946v.m2959m(R$styleable.ActionBar_height, 0);
            if (iM2959m > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2336a.getLayoutParams();
                layoutParams.height = iM2959m;
                this.f2336a.setLayoutParams(layoutParams);
            }
            int iM2951e = c0523e0M2946v.m2951e(R$styleable.ActionBar_contentInsetStart, -1);
            int iM2951e2 = c0523e0M2946v.m2951e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iM2951e >= 0 || iM2951e2 >= 0) {
                this.f2336a.m2848L(Math.max(iM2951e, 0), Math.max(iM2951e2, 0));
            }
            int iM2960n2 = c0523e0M2946v.m2960n(R$styleable.ActionBar_titleTextStyle, 0);
            if (iM2960n2 != 0) {
                Toolbar toolbar2 = this.f2336a;
                toolbar2.m2851O(toolbar2.getContext(), iM2960n2);
            }
            int iM2960n3 = c0523e0M2946v.m2960n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iM2960n3 != 0) {
                Toolbar toolbar3 = this.f2336a;
                toolbar3.m2850N(toolbar3.getContext(), iM2960n3);
            }
            int iM2960n4 = c0523e0M2946v.m2960n(R$styleable.ActionBar_popupTheme, 0);
            if (iM2960n4 != 0) {
                this.f2336a.setPopupTheme(iM2960n4);
            }
        } else {
            this.f2337b = m3025t();
        }
        c0523e0M2946v.m2966w();
        m3027v(i10);
        this.f2346k = this.f2336a.getNavigationContentDescription();
        this.f2336a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.InterfaceC0543r
    public void setIcon(Drawable drawable) {
        this.f2340e = drawable;
        m3005F();
    }
}
