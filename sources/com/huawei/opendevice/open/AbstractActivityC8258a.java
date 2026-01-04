package com.huawei.opendevice.open;

import android.R;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7763bj;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.utils.C7824dq;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w;
import com.huawei.openalliance.p169ad.views.web.C8182e;
import com.huawei.openalliance.p169ad.views.web.NetworkLoadStatusView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.opendevice.open.a */
/* loaded from: classes2.dex */
public abstract class AbstractActivityC8258a extends AbstractActivityC6906f implements InterfaceC8130w, NetworkLoadStatusView.InterfaceC8168a, InterfaceC8260c, InterfaceC8263f {

    /* renamed from: D */
    public NetworkLoadStatusView f38462D;

    /* renamed from: E */
    public WebView f38463E;

    /* renamed from: F */
    public View f38464F;

    /* renamed from: G */
    public ProgressBar f38465G;

    /* renamed from: H */
    public String f38466H;

    /* renamed from: I */
    public WebChromeClient f38467I = new c(this, null);

    /* renamed from: J */
    public boolean f38468J = false;

    /* renamed from: K */
    public C8262e f38469K = new C8262e();

    /* renamed from: com.huawei.opendevice.open.a$a */
    public static class a {

        /* renamed from: a */
        public Context f38470a;

        public a(Context context) {
            this.f38470a = context;
        }

        @JavascriptInterface
        public String getPkgName() {
            return this.f38470a.getPackageName();
        }

        @JavascriptInterface
        public boolean isDarkMode() {
            return AbstractC7811dd.m48342r(this.f38470a);
        }

        @JavascriptInterface
        public boolean isEMuiVersion10() {
            return C7845x.m48547c();
        }

        @JavascriptInterface
        public int queryApiLevel() {
            return Build.VERSION.SDK_INT;
        }

        @JavascriptInterface
        public String queryThemeColor() throws Resources.NotFoundException {
            String strM48343s = AbstractC7811dd.m48343s(this.f38470a);
            return TextUtils.isEmpty(strM48343s) ? "#FF007DFF" : strM48343s;
        }

        @JavascriptInterface
        public boolean showMore() {
            return C6982bz.m41157g(this.f38470a) && C7845x.m48547c();
        }
    }

    /* renamed from: com.huawei.opendevice.open.a$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f38471a;

        /* renamed from: b */
        public final /* synthetic */ Toolbar f38472b;

        public b(View view, Toolbar toolbar) {
            this.f38471a = view;
            this.f38472b = toolbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TypedValue typedValue = new TypedValue();
                int iMax = Math.max(this.f38471a.getHeight(), AbstractActivityC8258a.this.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, AbstractActivityC8258a.this.getResources().getDisplayMetrics()) : 0);
                if (iMax > 0) {
                    this.f38472b.setMinimumHeight(iMax);
                }
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("BaseWebActivity", "set toolBar min height error.");
            }
        }
    }

    /* renamed from: com.huawei.opendevice.open.a$c */
    public class c extends WebChromeClient {
        private c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            C7822do.m48381a(AbstractActivityC8258a.this.f38465G, i10);
            super.onProgressChanged(webView, i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }

        public /* synthetic */ c(AbstractActivityC8258a abstractActivityC8258a, b bVar) {
            this();
        }
    }

    /* renamed from: com.huawei.opendevice.open.a$d */
    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f38475a;

        public d(View view) {
            this.f38475a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractActivityC8258a abstractActivityC8258a;
            WebView webView;
            if (this.f38475a.getId() == C6849R.id.privacy_set_network) {
                Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                AbstractC7811dd.m48294a(AbstractActivityC8258a.this, intent);
            } else {
                if (!C7845x.m48570h(AbstractActivityC8258a.this) || (webView = (abstractActivityC8258a = AbstractActivityC8258a.this).f38463E) == null) {
                    return;
                }
                webView.loadUrl(abstractActivityC8258a.f38466H);
            }
        }
    }

    /* renamed from: com.huawei.opendevice.open.a$e */
    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f38477a;

        public e(String str) {
            this.f38477a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = AbstractActivityC8258a.this.f38463E;
            if (webView != null) {
                webView.loadUrl(this.f38477a);
            }
        }
    }

    /* renamed from: com.huawei.opendevice.open.a$f */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractActivityC8258a.this.mo49759a();
        }
    }

    /* renamed from: com.huawei.opendevice.open.a$g */
    public static class g implements InterfaceC8263f {

        /* renamed from: a */
        public WeakReference<InterfaceC8263f> f38480a;

        public g(InterfaceC8263f interfaceC8263f) {
            this.f38480a = new WeakReference<>(interfaceC8263f);
        }

        @Override // com.huawei.opendevice.open.InterfaceC8263f
        /* renamed from: a */
        public void mo51584a(C8262e c8262e) {
            InterfaceC8263f interfaceC8263f = this.f38480a.get();
            if (interfaceC8263f != null) {
                interfaceC8263f.mo51584a(c8262e);
            }
        }
    }

    /* renamed from: i */
    private void m51582i() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null && m51588f()) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (mo51577E() != 0) {
                if (this.f38468J) {
                    actionBar.setTitle(mo51577E());
                } else {
                    View viewInflate = getLayoutInflater().inflate(C6849R.layout.action_bar_title_layout, (ViewGroup) null);
                    actionBar.setDisplayShowTitleEnabled(false);
                    actionBar.setDisplayShowCustomEnabled(true);
                    actionBar.setCustomView(viewInflate);
                    m51579a(viewInflate);
                    ((TextView) findViewById(C6849R.id.custom_action_bar_title)).setText(mo51577E());
                }
            }
        }
        this.f38464F = findViewById(C6849R.id.content_statement);
        this.f38463E = (WebView) findViewById(C6849R.id.content_webview);
        this.f38465G = (ProgressBar) findViewById(C6849R.id.web_progress);
        m51590g(this.f38463E);
        m51587d(this.f38463E);
        C8182e c8182e = new C8182e(this);
        c8182e.m50693a(this.f38465G);
        WebView webView = this.f38463E;
        if (webView != null) {
            webView.setWebChromeClient(this.f38467I);
            this.f38463E.setWebViewClient(c8182e);
            this.f38463E.addJavascriptInterface(new a(getContext()), Constants.HW_PPS_PRIVACY_JS_NAME);
        }
        mo51559e(this);
        C8264g.m51611f(new g(this));
        NetworkLoadStatusView networkLoadStatusView = (NetworkLoadStatusView) findViewById(C6849R.id.status_view);
        this.f38462D = networkLoadStatusView;
        if (networkLoadStatusView != null) {
            networkLoadStatusView.setState(1);
            this.f38462D.setOnEmptyClickListener(this);
            this.f38462D.setClickable(true);
        }
    }

    /* renamed from: j */
    private void m51583j() {
    }

    /* renamed from: C */
    public String mo51556C() {
        return null;
    }

    /* renamed from: D */
    public int mo51557D() {
        return 0;
    }

    /* renamed from: E */
    public int mo51577E() {
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: a */
    public void mo49759a() {
        if (this.f38462D == null) {
            return;
        }
        this.f38462D.setState(!C7845x.m48570h(this) ? -2 : -1);
    }

    /* renamed from: c */
    public final void m51586c(Activity activity, int i10) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, i10);
            activity.getWindow().setAttributes(attributes);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("BaseWebActivity", "setLayoutMode error");
        }
    }

    /* renamed from: d */
    public void m51587d(WebView webView) {
        C7824dq.m48387a(webView);
        onConfigurationChanged(getResources().getConfiguration());
    }

    /* renamed from: e */
    public void mo51559e(InterfaceC8260c interfaceC8260c) {
    }

    /* renamed from: g */
    public final void m51590g(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.setBackgroundColor(0);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    public Context getContext() {
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.views.web.NetworkLoadStatusView.InterfaceC8168a
    public void onClick(View view) {
        AbstractC7817dj.m48363a(new d(view));
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i10 = configuration.uiMode & 48;
        AbstractC7185ho.m43820b("BaseWebActivity", "currentNightMode=" + i10);
        m51578a(32 == i10 ? 2 : 0);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb2;
        String str;
        AbstractC7763bj.m47798a(this);
        AbstractC7811dd.m48331h(this);
        super.onCreate(bundle);
        this.f38468J = C6982bz.m41152b(this);
        try {
            m51586c(this, 1);
            setContentView(mo51557D());
            m51582i();
            m51583j();
            AbstractC7811dd.m48295a(this.f38464F, this);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onCreate ";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("BaseWebActivity", sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "onCreate ex: ";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("BaseWebActivity", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C8264g.m51611f(null);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        AbstractC7185ho.m43820b("BaseWebActivity", "onKeyDown");
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        StringBuilder sb2;
        String str;
        try {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            super.onBackPressed();
            return true;
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onOptionsItemSelected ";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("BaseWebActivity", sb2.toString());
            return false;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "onOptionsItemSelected ex: ";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("BaseWebActivity", sb2.toString());
            return false;
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f38469K != null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("BaseWebActivity", "onPause, record privacy close time.");
            }
            this.f38469K.m51598f(AbstractC7741ao.m47566c());
            this.f38469K.m51596d(mo51556C());
        }
        new C6928i(getApplicationContext()).m39203a(this.f38469K);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f38469K != null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("BaseWebActivity", "onResume, record privacy open time.");
            }
            this.f38469K.m51594b(AbstractC7741ao.m47566c());
        }
    }

    @TargetApi(29)
    /* renamed from: a */
    private void m51578a(int i10) {
        WebSettings settings;
        WebView webView = this.f38463E;
        if (webView == null || (settings = webView.getSettings()) == null) {
            return;
        }
        settings.setForceDark(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w
    /* renamed from: c */
    public void mo49764c() {
        NetworkLoadStatusView networkLoadStatusView = this.f38462D;
        if (networkLoadStatusView == null) {
            return;
        }
        if (networkLoadStatusView.getCurrentState() == 1 && C7845x.m48570h(this)) {
            this.f38462D.setState(0);
        }
        this.f38462D.setState(1);
    }

    /* renamed from: f */
    public boolean m51588f() {
        return true;
    }

    @Override // com.huawei.opendevice.open.InterfaceC8260c
    /* renamed from: g */
    public void mo51589g() {
        AbstractC7185ho.m43826d("BaseWebActivity", "onGrsFailed");
        AbstractC7817dj.m48363a(new f());
    }

    @TargetApi(21)
    /* renamed from: a */
    private void m51579a(View view) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            Toolbar toolbar = (Toolbar) view.getParent();
            if (toolbar != null) {
                toolbar.setLayoutParams(layoutParams);
            }
            view.post(new b(view, toolbar));
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("BaseWebActivity", "setCustomToolBar error.");
        }
    }

    @Override // com.huawei.opendevice.open.InterfaceC8263f
    /* renamed from: a */
    public void mo51584a(C8262e c8262e) {
        AbstractC7185ho.m43820b("BaseWebActivity", "onPrivacyInfoUpdate.");
        this.f38469K.m51595c(c8262e);
    }

    @Override // com.huawei.opendevice.open.InterfaceC8260c
    /* renamed from: a */
    public void mo51585a(String str) {
        AbstractC7185ho.m43820b("BaseWebActivity", "onGrsSuccess");
        this.f38466H = str;
        AbstractC7817dj.m48363a(new e(str));
    }
}
