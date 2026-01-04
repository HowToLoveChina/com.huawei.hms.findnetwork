package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7527nv;
import com.huawei.openalliance.p169ad.InterfaceC6998co;
import com.huawei.openalliance.p169ad.InterfaceC7542oj;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.HiAdWidgets;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7824dq;
import com.huawei.openalliance.p169ad.views.ViewOnClickListenerC8081d;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSWebView extends RelativeLayout implements InterfaceC8130w {

    /* renamed from: A */
    private View.OnTouchListener f37207A;

    /* renamed from: B */
    private RelativeLayout.LayoutParams f37208B;

    /* renamed from: a */
    private ViewOnClickListenerC8081d.a f37209a;

    /* renamed from: b */
    private WebView f37210b;

    /* renamed from: c */
    private ViewOnClickListenerC8081d f37211c;

    /* renamed from: d */
    private View f37212d;

    /* renamed from: e */
    private InterfaceC7542oj f37213e;

    /* renamed from: f */
    private ActionBar f37214f;

    /* renamed from: g */
    private AdLandingPageData f37215g;

    /* renamed from: h */
    private C8185x f37216h;

    /* renamed from: i */
    private View f37217i;

    /* renamed from: j */
    private ProgressBar f37218j;

    /* renamed from: k */
    private PPSAppDetailView f37219k;

    /* renamed from: l */
    private RelativeLayout.LayoutParams f37220l;

    /* renamed from: m */
    private TextView f37221m;

    /* renamed from: n */
    private int f37222n;

    /* renamed from: o */
    private boolean f37223o;

    /* renamed from: p */
    private boolean f37224p;

    /* renamed from: q */
    private boolean f37225q;

    /* renamed from: r */
    private int f37226r;

    /* renamed from: s */
    private int f37227s;

    /* renamed from: t */
    private int f37228t;

    /* renamed from: u */
    private String f37229u;

    /* renamed from: v */
    private boolean f37230v;

    /* renamed from: w */
    private InterfaceC6998co f37231w;

    /* renamed from: x */
    private boolean f37232x;

    /* renamed from: y */
    private boolean f37233y;

    /* renamed from: z */
    private View.OnKeyListener f37234z;

    /* renamed from: com.huawei.openalliance.ad.views.PPSWebView$1 */
    public class ViewOnKeyListenerC80341 implements View.OnKeyListener {
        public ViewOnKeyListenerC80341() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i10 != 4 || PPSWebView.this.f37210b == null || !PPSWebView.this.f37210b.canGoBack() || !C7775bv.m47831e(PPSWebView.this.f37210b.getContext())) {
                return false;
            }
            PPSWebView.this.f37210b.goBack();
            return true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSWebView$2 */
    public class ViewOnTouchListenerC80352 implements View.OnTouchListener {
        public ViewOnTouchListenerC80352() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent != null && motionEvent.getAction() == 0) {
                PPSWebView.m49738b(PPSWebView.this);
                PPSWebView.this.f37226r = (int) motionEvent.getRawX();
                PPSWebView.this.f37227s = (int) motionEvent.getRawY();
            }
            if (motionEvent == null || 1 != motionEvent.getAction()) {
                return false;
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (AbstractC7811dd.m48299a(PPSWebView.this.f37226r, PPSWebView.this.f37227s, rawX, rawY, PPSWebView.this.f37228t)) {
                return false;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSWebView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
            }
            PPSWebView.this.f37213e.mo46238a(rawX, rawY);
            return false;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSWebView$3 */
    public class ViewOnClickListenerC80363 implements View.OnClickListener {
        public ViewOnClickListenerC80363() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PPSWebView.this.m49752h();
            PPSWebView.this.loadPage();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSWebView$a */
    public class C8037a extends WebChromeClient {
        private C8037a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (PPSWebView.this.f37212d != null) {
                if (i10 == 100) {
                    PPSWebView.this.f37212d.setVisibility(8);
                } else {
                    if (PPSWebView.this.f37212d.getVisibility() == 8) {
                        PPSWebView.this.f37212d.setVisibility(0);
                    }
                    if (PPSWebView.this.f37233y) {
                        ((HwProgressBar) PPSWebView.this.f37212d).setProgress(i10, true);
                    } else {
                        ((C8084e) PPSWebView.this.f37212d).setProgress(i10);
                    }
                }
            }
            super.onProgressChanged(webView, i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            String strMo46249c = PPSWebView.this.f37213e.mo46249c(str);
            boolean zIsShowPageTitle = PPSWebView.this.f37215g != null ? PPSWebView.this.f37215g.isShowPageTitle() : false;
            if (PPSWebView.this.f37211c != null) {
                PPSWebView.this.f37211c.m50097a(zIsShowPageTitle);
                PPSWebView.this.f37211c.setTitle(strMo46249c);
            } else if (PPSWebView.this.f37214f != null) {
                PPSWebView.this.f37214f.setTitle(zIsShowPageTitle ? strMo46249c : " ");
            }
            super.onReceivedTitle(webView, strMo46249c);
        }

        public /* synthetic */ C8037a(PPSWebView pPSWebView, ViewOnKeyListenerC80341 viewOnKeyListenerC80341) {
            this();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSWebView$b */
    public class C8038b extends WebChromeClient {
        private C8038b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (PPSWebView.this.f37218j != null && PPSWebView.this.f37221m != null) {
                if (i10 == 100) {
                    PPSWebView.this.f37218j.setVisibility(8);
                    PPSWebView.this.f37221m.setVisibility(8);
                } else {
                    if (PPSWebView.this.f37218j.getVisibility() == 8) {
                        PPSWebView.this.f37218j.setVisibility(0);
                    }
                    if (PPSWebView.this.f37221m.getVisibility() == 8) {
                        PPSWebView.this.f37221m.setVisibility(0);
                    }
                }
            }
            super.onProgressChanged(webView, i10);
        }

        public /* synthetic */ C8038b(PPSWebView pPSWebView, ViewOnKeyListenerC80341 viewOnKeyListenerC80341) {
            this();
        }
    }

    @OuterVisible
    public PPSWebView(Context context) {
        super(context);
        this.f37222n = 0;
        this.f37223o = false;
        this.f37224p = false;
        this.f37225q = false;
        this.f37226r = 0;
        this.f37227s = 0;
        this.f37232x = false;
        this.f37233y = false;
        this.f37234z = new View.OnKeyListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.1
            public ViewOnKeyListenerC80341() {
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i10, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i10 != 4 || PPSWebView.this.f37210b == null || !PPSWebView.this.f37210b.canGoBack() || !C7775bv.m47831e(PPSWebView.this.f37210b.getContext())) {
                    return false;
                }
                PPSWebView.this.f37210b.goBack();
                return true;
            }
        };
        this.f37207A = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.2
            public ViewOnTouchListenerC80352() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    PPSWebView.m49738b(PPSWebView.this);
                    PPSWebView.this.f37226r = (int) motionEvent.getRawX();
                    PPSWebView.this.f37227s = (int) motionEvent.getRawY();
                }
                if (motionEvent == null || 1 != motionEvent.getAction()) {
                    return false;
                }
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (AbstractC7811dd.m48299a(PPSWebView.this.f37226r, PPSWebView.this.f37227s, rawX, rawY, PPSWebView.this.f37228t)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSWebView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                }
                PPSWebView.this.f37213e.mo46238a(rawX, rawY);
                return false;
            }
        };
        m49735a(context);
    }

    /* renamed from: b */
    public static /* synthetic */ int m49738b(PPSWebView pPSWebView) {
        int i10 = pPSWebView.f37222n;
        pPSWebView.f37222n = i10 + 1;
        return i10;
    }

    /* renamed from: g */
    private void m49749g() {
        View view = this.f37217i;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.3
                public ViewOnClickListenerC80363() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PPSWebView.this.m49752h();
                    PPSWebView.this.loadPage();
                }
            });
        }
    }

    @OuterVisible
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
    }

    @OuterVisible
    public void destroy() {
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.destroy();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    public String getCurrentPageUrl() {
        return this.f37229u;
    }

    public ViewOnClickListenerC8081d getCustomEmuiActionBar() {
        return this.f37211c;
    }

    @OuterVisible
    public WebSettings getSettings() {
        WebView webView = this.f37210b;
        if (webView != null) {
            return webView.getSettings();
        }
        return null;
    }

    public PPSAppDetailView getTopDetailView() {
        return this.f37219k;
    }

    public InterfaceC7542oj getWebDetailPresenter() {
        return this.f37213e;
    }

    public long getWebHasShownTime() {
        return this.f37213e.mo46256k();
    }

    public WebView getWebView() {
        return this.f37210b;
    }

    @OuterVisible
    public void loadPage() {
        if (this.f37215g != null) {
            this.f37213e.mo46239a(this.f37210b);
            this.f37213e.mo46243a(this.f37215g.getLandingUrl(), this.f37210b);
            this.f37229u = this.f37215g.getLandingUrl();
        }
    }

    @OuterVisible
    public void onResume() {
        this.f37213e.mo46251c(System.currentTimeMillis());
        if (this.f37223o) {
            return;
        }
        this.f37223o = true;
        this.f37213e.mo46236a();
    }

    @OuterVisible
    public void onStop() {
        this.f37213e.mo46237a(this.f37222n);
    }

    @OuterVisible
    public void setAdLandingPageData(AdLandingPageData adLandingPageData) {
        this.f37215g = adLandingPageData;
        this.f37213e.mo46240a(adLandingPageData);
    }

    @OuterVisible
    public void setErrorPageView(View view) throws Resources.NotFoundException {
        if (view == null) {
            return;
        }
        m49737a(view);
    }

    @OuterVisible
    public void setPPSWebEventCallback(IPPSWebEventCallback iPPSWebEventCallback) {
        this.f37213e.mo46241a(iPPSWebEventCallback);
    }

    public void setRealOpenTime(long j10) {
        this.f37213e.mo46252d(j10);
    }

    public void setScrollListener(View.OnScrollChangeListener onScrollChangeListener) {
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setOnScrollChangeListener(onScrollChangeListener);
        }
    }

    @OuterVisible
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setWebChromeClient(webChromeClient);
        }
    }

    public void setWebViewBackgroundColor(int i10) {
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setBackgroundColor(i10);
        }
    }

    @OuterVisible
    public void setWebViewClient(WebViewClient webViewClient) {
        this.f37216h.m50709a(webViewClient);
    }

    public PPSWebView(Context context, ActionBar actionBar, AdLandingPageData adLandingPageData, ViewOnClickListenerC8081d.a aVar, boolean z10, boolean z11) throws Resources.NotFoundException {
        super(context);
        this.f37222n = 0;
        this.f37223o = false;
        this.f37224p = false;
        this.f37225q = false;
        this.f37226r = 0;
        this.f37227s = 0;
        this.f37232x = false;
        this.f37233y = false;
        this.f37234z = new View.OnKeyListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.1
            public ViewOnKeyListenerC80341() {
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i10, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i10 != 4 || PPSWebView.this.f37210b == null || !PPSWebView.this.f37210b.canGoBack() || !C7775bv.m47831e(PPSWebView.this.f37210b.getContext())) {
                    return false;
                }
                PPSWebView.this.f37210b.goBack();
                return true;
            }
        };
        this.f37207A = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.2
            public ViewOnTouchListenerC80352() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    PPSWebView.m49738b(PPSWebView.this);
                    PPSWebView.this.f37226r = (int) motionEvent.getRawX();
                    PPSWebView.this.f37227s = (int) motionEvent.getRawY();
                }
                if (motionEvent == null || 1 != motionEvent.getAction()) {
                    return false;
                }
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (AbstractC7811dd.m48299a(PPSWebView.this.f37226r, PPSWebView.this.f37227s, rawX, rawY, PPSWebView.this.f37228t)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSWebView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                }
                PPSWebView.this.f37213e.mo46238a(rawX, rawY);
                return false;
            }
        };
        this.f37225q = false;
        this.f37230v = z11;
        this.f37215g = adLandingPageData;
        this.f37209a = aVar;
        this.f37214f = actionBar;
        m49740b(context);
        this.f37213e = new C7527nv(context, adLandingPageData, this);
        m49736a(context, z10);
    }

    /* renamed from: e */
    private void m49746e() {
        RelativeLayout.LayoutParams layoutParams = this.f37220l;
        if (layoutParams != null) {
            addView(this.f37219k, layoutParams);
        }
        WebView webView = this.f37210b;
        if (webView != null) {
            addView(webView, this.f37208B);
        }
    }

    /* renamed from: f */
    private void m49748f() throws Resources.NotFoundException {
        ImageView imageView = (ImageView) findViewById(C6849R.id.hiad_id_load_fail_img);
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(C6849R.drawable.hiad_ic_load_fail);
            if (AbstractC7811dd.m48315c()) {
                imageView.setImageBitmap(C7752az.m47693b(drawable));
            }
        }
    }

    /* renamed from: h */
    public void m49752h() {
        View view = this.f37217i;
        if (view != null) {
            view.setVisibility(8);
        }
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: c */
    public void mo49764c() {
    }

    /* renamed from: d */
    public void m49765d() {
        Context context = getContext();
        TextView textView = new TextView(context);
        this.f37221m = textView;
        int i10 = C6849R.id.trial_play_loading_text;
        textView.setId(i10);
        this.f37221m.setText(C6849R.string.hiad_loading_tips);
        this.f37221m.setTextSize(1, 14.0f);
        this.f37221m.setTextColor(context.getResources().getColor(C6849R.color.hiad_50_percent_white));
        this.f37218j = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f37221m, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(AbstractC7741ao.m47535a(context, 72.0f), AbstractC7741ao.m47535a(context, 72.0f));
        layoutParams2.setMargins(0, 0, 0, AbstractC7741ao.m47535a(context, 16.0f));
        layoutParams2.addRule(2, i10);
        layoutParams2.addRule(13);
        addView(this.f37218j, layoutParams2);
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setWebChromeClient(new C8038b());
        }
    }

    @OuterVisible
    public PPSWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37222n = 0;
        this.f37223o = false;
        this.f37224p = false;
        this.f37225q = false;
        this.f37226r = 0;
        this.f37227s = 0;
        this.f37232x = false;
        this.f37233y = false;
        this.f37234z = new View.OnKeyListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.1
            public ViewOnKeyListenerC80341() {
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i10, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i10 != 4 || PPSWebView.this.f37210b == null || !PPSWebView.this.f37210b.canGoBack() || !C7775bv.m47831e(PPSWebView.this.f37210b.getContext())) {
                    return false;
                }
                PPSWebView.this.f37210b.goBack();
                return true;
            }
        };
        this.f37207A = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.2
            public ViewOnTouchListenerC80352() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    PPSWebView.m49738b(PPSWebView.this);
                    PPSWebView.this.f37226r = (int) motionEvent.getRawX();
                    PPSWebView.this.f37227s = (int) motionEvent.getRawY();
                }
                if (motionEvent == null || 1 != motionEvent.getAction()) {
                    return false;
                }
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (AbstractC7811dd.m48299a(PPSWebView.this.f37226r, PPSWebView.this.f37227s, rawX, rawY, PPSWebView.this.f37228t)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSWebView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                }
                PPSWebView.this.f37213e.mo46238a(rawX, rawY);
                return false;
            }
        };
        m49735a(context);
    }

    /* renamed from: c */
    private void m49742c(Context context) {
        this.f37210b = C7824dq.m48386a(context);
        this.f37208B = new RelativeLayout.LayoutParams(-1, -1);
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setId(C6849R.id.hiad_webview);
            this.f37210b.requestFocus();
            this.f37210b.setWebChromeClient(new C8037a());
            WebView webView2 = this.f37210b;
            C8185x c8185x = new C8185x(this);
            this.f37216h = c8185x;
            webView2.setWebViewClient(c8185x);
            this.f37210b.setOnKeyListener(this.f37234z);
            this.f37210b.setOnTouchListener(this.f37207A);
        }
    }

    /* renamed from: d */
    private void m49744d(Context context) {
        PPSAppDetailView pPSAppDetailView = new PPSAppDetailView(context);
        this.f37219k = pPSAppDetailView;
        pPSAppDetailView.setId(C6849R.id.hiad_landing_top_app_detail);
        this.f37219k.setVisibility(8);
        this.f37220l = new RelativeLayout.LayoutParams(-1, -2);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: a */
    public void mo49759a() {
        View view = this.f37217i;
        if (view != null) {
            view.setVisibility(0);
        }
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.setVisibility(4);
        }
        View view2 = this.f37212d;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49762b() {
        WebView webView = this.f37210b;
        if (webView != null) {
            webView.loadUrl("about:blank");
        }
        View view = this.f37212d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @OuterVisible
    public PPSWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37222n = 0;
        this.f37223o = false;
        this.f37224p = false;
        this.f37225q = false;
        this.f37226r = 0;
        this.f37227s = 0;
        this.f37232x = false;
        this.f37233y = false;
        this.f37234z = new View.OnKeyListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.1
            public ViewOnKeyListenerC80341() {
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i102, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i102 != 4 || PPSWebView.this.f37210b == null || !PPSWebView.this.f37210b.canGoBack() || !C7775bv.m47831e(PPSWebView.this.f37210b.getContext())) {
                    return false;
                }
                PPSWebView.this.f37210b.goBack();
                return true;
            }
        };
        this.f37207A = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.2
            public ViewOnTouchListenerC80352() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    PPSWebView.m49738b(PPSWebView.this);
                    PPSWebView.this.f37226r = (int) motionEvent.getRawX();
                    PPSWebView.this.f37227s = (int) motionEvent.getRawY();
                }
                if (motionEvent == null || 1 != motionEvent.getAction()) {
                    return false;
                }
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (AbstractC7811dd.m48299a(PPSWebView.this.f37226r, PPSWebView.this.f37227s, rawX, rawY, PPSWebView.this.f37228t)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSWebView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                }
                PPSWebView.this.f37213e.mo46238a(rawX, rawY);
                return false;
            }
        };
        m49735a(context);
    }

    /* renamed from: a */
    private void m49735a(Context context) {
        this.f37225q = true;
        this.f37213e = new C7527nv(context, this);
        this.f37228t = ViewConfiguration.get(context).getScaledTouchSlop();
        m49740b(context);
        try {
            m49736a(context, false);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PPSWebView", "init webview error");
        }
    }

    /* renamed from: b */
    private void m49740b(Context context) {
        InterfaceC6998co interfaceC6998coM41148a = C6982bz.m41148a(context);
        this.f37231w = interfaceC6998coM41148a;
        boolean zMo41178g = interfaceC6998coM41148a.mo41178g();
        this.f37232x = zMo41178g;
        this.f37233y = zMo41178g && this.f37231w.mo41172a(HiAdWidgets.HW_PROGRESS_BAR);
        AbstractC7185ho.m43821b("PPSWebView", "isHmOS: %s, useHmProgressBar: %s", Boolean.valueOf(this.f37232x), Boolean.valueOf(this.f37233y));
    }

    @OuterVisible
    @TargetApi(21)
    public PPSWebView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37222n = 0;
        this.f37223o = false;
        this.f37224p = false;
        this.f37225q = false;
        this.f37226r = 0;
        this.f37227s = 0;
        this.f37232x = false;
        this.f37233y = false;
        this.f37234z = new View.OnKeyListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.1
            public ViewOnKeyListenerC80341() {
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i102, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i102 != 4 || PPSWebView.this.f37210b == null || !PPSWebView.this.f37210b.canGoBack() || !C7775bv.m47831e(PPSWebView.this.f37210b.getContext())) {
                    return false;
                }
                PPSWebView.this.f37210b.goBack();
                return true;
            }
        };
        this.f37207A = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSWebView.2
            public ViewOnTouchListenerC80352() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    PPSWebView.m49738b(PPSWebView.this);
                    PPSWebView.this.f37226r = (int) motionEvent.getRawX();
                    PPSWebView.this.f37227s = (int) motionEvent.getRawY();
                }
                if (motionEvent == null || 1 != motionEvent.getAction()) {
                    return false;
                }
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (AbstractC7811dd.m48299a(PPSWebView.this.f37226r, PPSWebView.this.f37227s, rawX, rawY, PPSWebView.this.f37228t)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSWebView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                }
                PPSWebView.this.f37213e.mo46238a(rawX, rawY);
                return false;
            }
        };
        m49735a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x010f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m49736a(android.content.Context r9, boolean r10) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSWebView.m49736a(android.content.Context, boolean):void");
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49763b(String str) {
        this.f37229u = str;
    }

    /* renamed from: a */
    private void m49737a(View view) throws Resources.NotFoundException {
        View view2 = this.f37217i;
        if (view2 != null) {
            removeView(view2);
        }
        this.f37217i = view;
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ViewOnClickListenerC8081d viewOnClickListenerC8081d = this.f37211c;
            if (viewOnClickListenerC8081d != null) {
                layoutParams.addRule(3, viewOnClickListenerC8081d.getId());
            }
            addView(this.f37217i, layoutParams);
            this.f37217i.setVisibility(8);
        }
        m49749g();
        m49748f();
    }

    /* renamed from: a */
    public void m49760a(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("PPSWebView", "load page url is empty.");
        } else if (this.f37215g != null) {
            this.f37213e.mo46239a(this.f37210b);
            this.f37213e.mo46243a(str, this.f37210b);
            this.f37229u = str;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: a */
    public void mo49761a(String str, String str2, String str3) {
        this.f37213e.mo46244a(str, str2, str3);
    }
}
