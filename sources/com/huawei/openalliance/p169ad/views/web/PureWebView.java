package com.huawei.openalliance.p169ad.views.web;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7527nv;
import com.huawei.openalliance.p169ad.InterfaceC7542oj;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7824dq;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q;
import com.huawei.openalliance.p169ad.views.web.PureNetworkLoadStatusView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class PureWebView extends RelativeLayout implements InterfaceC8124q, PureNetworkLoadStatusView.InterfaceC8171a, PureNetworkLoadStatusView.InterfaceC8172b {

    /* renamed from: a */
    private ProgressBar f38322a;

    /* renamed from: b */
    private PureNetworkLoadStatusView f38323b;

    /* renamed from: c */
    private WebView f38324c;

    /* renamed from: d */
    private String f38325d;

    /* renamed from: e */
    private InterfaceC7542oj f38326e;

    /* renamed from: f */
    private C8180c f38327f;

    /* renamed from: g */
    private Handler f38328g;

    /* renamed from: h */
    private long f38329h;

    /* renamed from: i */
    private boolean f38330i;

    /* renamed from: j */
    private int f38331j;

    /* renamed from: k */
    private InterfaceC8175a f38332k;

    /* renamed from: l */
    private Runnable f38333l;

    /* renamed from: com.huawei.openalliance.ad.views.web.PureWebView$a */
    public interface InterfaceC8175a {
        /* renamed from: a */
        void mo50669a(int i10);
    }

    /* renamed from: com.huawei.openalliance.ad.views.web.PureWebView$b */
    public class C8176b extends WebChromeClient {
        private C8176b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            PureWebView.this.m50656a(i10);
            super.onProgressChanged(webView, i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.web.PureWebView$c */
    public static class RunnableC8177c implements Runnable {

        /* renamed from: a */
        private final WeakReference<PureWebView> f38340a;

        public RunnableC8177c(PureWebView pureWebView) {
            this.f38340a = new WeakReference<>(pureWebView);
        }

        @Override // java.lang.Runnable
        public void run() {
            PureWebView pureWebView = this.f38340a.get();
            if (pureWebView != null && pureWebView.f38331j < 100) {
                pureWebView.mo49759a();
                if (pureWebView.f38324c != null) {
                    pureWebView.f38324c.stopLoading();
                }
            }
        }
    }

    public PureWebView(Context context) {
        super(context);
        this.f38330i = false;
        m50658a(context);
    }

    /* renamed from: e */
    public void m50668e() {
        WebView webView = getWebView();
        if (webView == null) {
            return;
        }
        webView.setBackgroundColor(0);
        C7824dq.m48387a(this.f38324c);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    public String getCurrentPageUrl() {
        return this.f38325d;
    }

    public WebView getWebView() {
        return this.f38324c;
    }

    public void setOnLoadFinishedListener(InterfaceC8175a interfaceC8175a) {
        this.f38332k = interfaceC8175a;
    }

    public void setProcessBarNeedHide(boolean z10) {
        this.f38330i = z10;
        ProgressBar progressBar = this.f38322a;
        if (progressBar != null) {
            progressBar.setVisibility(z10 ? 8 : 0);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f38327f.m50683a(webViewClient);
    }

    public PureWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38330i = false;
        m50658a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49762b() {
        WebView webView = this.f38324c;
        if (webView != null) {
            webView.loadUrl("about:blank");
        }
        ProgressBar progressBar = this.f38322a;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: c */
    public void mo49764c() {
        AbstractC7185ho.m43817a("PureWebView", "showPageFinishPage");
        PureNetworkLoadStatusView pureNetworkLoadStatusView = this.f38323b;
        if (pureNetworkLoadStatusView == null) {
            return;
        }
        int currentState = pureNetworkLoadStatusView.getCurrentState();
        AbstractC7185ho.m43818a("PureWebView", "state:%s", Integer.valueOf(currentState));
        if (this.f38323b.getCurrentState() == 1 && C7845x.m48570h(getContext())) {
            this.f38323b.setState(0);
            WebView webView = this.f38324c;
            if (webView != null) {
                webView.setVisibility(0);
                this.f38324c.requestFocus();
            }
        }
        InterfaceC8175a interfaceC8175a = this.f38332k;
        if (interfaceC8175a != null) {
            interfaceC8175a.mo50669a(currentState);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q
    /* renamed from: d */
    public void mo50324d() {
        WebView webView = this.f38324c;
        if (webView != null) {
            webView.destroy();
        }
        this.f38324c = null;
    }

    public PureWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f38330i = false;
    }

    /* renamed from: b */
    private void m50662b(Context context) {
        AbstractC7185ho.m43820b("PureWebView", "initPureWebView.");
        try {
            AbstractC7185ho.m43821b("PureWebView", "api version is %s.", Integer.valueOf(Build.VERSION.SDK_INT));
            m50665c(context);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PureWebView", "init pure web view err: %s.", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    private void m50665c(Context context) {
        AbstractC7185ho.m43820b("PureWebView", "safeInitPureWebView");
        try {
            if (context.isDeviceProtectedStorage()) {
                View.inflate(context, C6849R.layout.pure_web_layout_without_webview, this);
                LinearLayout linearLayout = (LinearLayout) findViewById(C6849R.id.replace_layout);
                Context context2 = (Context) AbstractC7791ck.m48057a(context, "createCredentialProtectedStorageContext", (Class<?>[]) null, (Object[]) null);
                WebView webView = new WebView(context2);
                this.f38324c = webView;
                webView.setVerticalScrollBarEnabled(true);
                this.f38324c.setClipToPadding(true);
                this.f38324c.setVerticalScrollbarThumbDrawable(context2.getDrawable(C6849R.drawable.hiad_scrollbar_thumb));
                this.f38324c.setId(C6849R.id.content_webview);
                linearLayout.addView(this.f38324c, new LinearLayout.LayoutParams(-1, -1));
            } else {
                AbstractC7185ho.m43820b("PureWebView", "context is not in DeviceProtectedStorage.");
                View.inflate(context, C6849R.layout.pure_web_layout, this);
                this.f38324c = (WebView) findViewById(C6849R.id.content_webview);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PureWebView", "safe init pure web view err: %s.", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: a */
    public void mo49759a() {
        if (this.f38323b == null) {
            return;
        }
        this.f38323b.setState(!C7845x.m48570h(getContext()) ? -2 : -1);
    }

    @TargetApi(21)
    public PureWebView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f38330i = false;
        m50658a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50656a(int i10) {
        ProgressBar progressBar;
        AbstractC7185ho.m43817a("PureWebView", "handleProgressChanged:" + i10);
        this.f38331j = i10;
        if (this.f38330i || (progressBar = this.f38322a) == null) {
            return;
        }
        if (i10 == 100) {
            progressBar.setVisibility(8);
            return;
        }
        if (progressBar.getVisibility() == 8) {
            this.f38322a.setVisibility(0);
        }
        this.f38322a.setProgress(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: b */
    public void mo49763b(String str) {
        this.f38325d = str;
    }

    /* renamed from: a */
    private void m50657a(long j10) {
        if (this.f38328g == null) {
            this.f38328g = new Handler(Looper.getMainLooper());
        }
        this.f38328g.removeCallbacks(this.f38333l);
        this.f38328g.postDelayed(this.f38333l, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m50663b(String str, long j10) {
        AbstractC7185ho.m43817a("PureWebView", "startLoad");
        this.f38331j = 0;
        PureNetworkLoadStatusView pureNetworkLoadStatusView = this.f38323b;
        if (pureNetworkLoadStatusView != null) {
            pureNetworkLoadStatusView.setState(1);
        }
        WebView webView = this.f38324c;
        if (webView != null) {
            webView.setVisibility(4);
        }
        if (j10 > 0) {
            m50657a(j10);
        }
        this.f38326e.mo46243a(str, getWebView());
    }

    /* renamed from: a */
    private void m50658a(Context context) {
        m50662b(context);
        this.f38322a = (ProgressBar) findViewById(C6849R.id.web_progress);
        this.f38323b = (PureNetworkLoadStatusView) findViewById(C6849R.id.status_view);
        this.f38333l = new RunnableC8177c(this);
        PureNetworkLoadStatusView pureNetworkLoadStatusView = this.f38323b;
        if (pureNetworkLoadStatusView != null) {
            pureNetworkLoadStatusView.setState(1);
            this.f38323b.setOnEmptyClickListener(this);
            this.f38323b.setClickable(true);
            this.f38323b.setOnConfigurationChangedListener(this);
        }
        this.f38326e = new C7527nv(context, this);
        this.f38324c.setWebChromeClient(new C8176b());
        WebView webView = this.f38324c;
        C8180c c8180c = new C8180c(this);
        this.f38327f = c8180c;
        webView.setWebViewClient(c8180c);
        this.f38327f.m50684a(this.f38326e);
    }

    @Override // com.huawei.openalliance.p169ad.views.web.PureNetworkLoadStatusView.InterfaceC8172b
    /* renamed from: a */
    public void mo50653a(final View view) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.PureWebView.1
            @Override // java.lang.Runnable
            public void run() {
                if (view.getId() == C6849R.id.privacy_set_network) {
                    Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                    intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    AbstractC7811dd.m48294a(PureWebView.this.getContext(), intent);
                } else if (C7845x.m48570h(PureWebView.this.getContext())) {
                    PureWebView pureWebView = PureWebView.this;
                    pureWebView.m50663b(pureWebView.getCurrentPageUrl(), PureWebView.this.f38329h);
                } else if (PureWebView.this.f38323b != null) {
                    PureWebView.this.f38323b.setState(-2);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.web.PureNetworkLoadStatusView.InterfaceC8171a
    /* renamed from: a */
    public void mo50652a(PureNetworkLoadStatusView pureNetworkLoadStatusView) {
        WebView webView;
        View rootView;
        if (pureNetworkLoadStatusView == null || (webView = this.f38324c) == null || (rootView = webView.getRootView()) == null || rootView.getParent() != null) {
            return;
        }
        pureNetworkLoadStatusView.addView(rootView);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q
    /* renamed from: a */
    public void mo50322a(Object obj, String str) {
        this.f38326e.mo46242a(obj, str, getWebView());
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q
    /* renamed from: a */
    public void mo50323a(String str) {
        m50667a(str, 0L);
    }

    /* renamed from: a */
    public void m50667a(final String str, final long j10) {
        this.f38329h = j10;
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.PureWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PureWebView.this.f38325d = str;
                PureWebView.this.m50668e();
                PureWebView.this.m50663b(str, j10);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: a */
    public void mo49761a(String str, String str2, String str3) {
    }
}
