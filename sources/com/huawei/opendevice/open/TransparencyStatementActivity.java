package com.huawei.opendevice.open;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toolbar;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7844w;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q;
import com.huawei.openalliance.p169ad.views.web.C8182e;
import com.huawei.openalliance.p169ad.views.web.PureWebView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes2.dex */
public class TransparencyStatementActivity extends AbstractActivityC6905e implements PureWebView.InterfaceC8175a {

    /* renamed from: D */
    public PureWebView f38451D;

    /* renamed from: E */
    public TextView f38452E;

    /* renamed from: F */
    public boolean f38453F = false;

    /* renamed from: G */
    public int f38454G = 1;

    /* renamed from: H */
    public String f38455H;

    /* renamed from: com.huawei.opendevice.open.TransparencyStatementActivity$a */
    public static class C8254a {

        /* renamed from: a */
        public final Context f38456a;

        public C8254a(Context context) {
            this.f38456a = context;
        }

        @JavascriptInterface
        public int getDeviceType() {
            return C7844w.m48512a(this.f38456a).m48518c();
        }

        @JavascriptInterface
        public boolean isDarkMode() {
            return AbstractC7811dd.m48342r(this.f38456a);
        }
    }

    /* renamed from: com.huawei.opendevice.open.TransparencyStatementActivity$b */
    public class RunnableC8255b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f38457a;

        public RunnableC8255b(String str) {
            this.f38457a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TransparencyStatementActivity.this.f38451D == null) {
                return;
            }
            TransparencyStatementActivity.this.f38451D.m50667a(this.f38457a, 10000L);
        }
    }

    /* renamed from: com.huawei.opendevice.open.TransparencyStatementActivity$c */
    public class RunnableC8256c implements Runnable {
        public RunnableC8256c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TransparencyStatementActivity.this.f38452E != null) {
                TransparencyStatementActivity.this.f38452E.setVisibility(0);
            }
        }
    }

    /* renamed from: com.huawei.opendevice.open.TransparencyStatementActivity$d */
    public class C8257d extends C8182e {
        public C8257d(InterfaceC8124q interfaceC8124q) {
            super(interfaceC8124q);
        }

        @Override // com.huawei.openalliance.p169ad.views.web.C8182e, android.webkit.WebViewClient
        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AbstractC7185ho.m43818a("Transparency", "WebResourceRequest url=%s", webResourceRequest.getUrl().toString());
            if (!TransparencyStatementActivity.this.f38453F) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            TransparencyStatementActivity.this.m51562a(webResourceRequest.getUrl().toString());
            return true;
        }

        @Override // com.huawei.openalliance.p169ad.views.web.C8182e, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!TransparencyStatementActivity.this.f38453F) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            TransparencyStatementActivity.this.m51562a(str);
            return true;
        }
    }

    @TargetApi(29)
    /* renamed from: b */
    private void m51563b(int i10) {
        PureWebView pureWebView = this.f38451D;
        if (pureWebView == null || pureWebView.getWebView() == null) {
            AbstractC7185ho.m43820b("Transparency", "webView is null");
            return;
        }
        WebSettings settings = this.f38451D.getWebView().getSettings();
        if (settings != null) {
            settings.setForceDark(i10);
        }
    }

    /* renamed from: f */
    private void m51569f() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        if (m51575g()) {
            m51574d(actionBar);
        }
        actionBar.setTitle(m51573C());
    }

    /* renamed from: h */
    private void m51570h() {
        PureWebView pureWebView = (PureWebView) findViewById(C6849R.id.webview);
        this.f38451D = pureWebView;
        if (pureWebView == null) {
            AbstractC7185ho.m43823c("Transparency", "get webview error.");
            return;
        }
        pureWebView.setWebViewClient(new C8257d(this.f38451D));
        this.f38451D.setOnLoadFinishedListener(this);
        this.f38451D.setProcessBarNeedHide(this.f38453F);
        this.f38451D.mo50322a(new C8254a(this), "HwPPSTransparency");
        Resources resources = getResources();
        if (resources == null) {
            AbstractC7185ho.m43823c("Transparency", "resources is null");
        } else {
            onConfigurationChanged(resources.getConfiguration());
        }
    }

    /* renamed from: i */
    private void m51571i() {
        if (this.f38455H == null) {
            this.f38455H = m51576j();
        }
        m51562a(this.f38455H);
    }

    @TargetApi(21)
    /* renamed from: k */
    private void m51572k() {
        if (this.f38453F || !m51575g()) {
            return;
        }
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            Resources resources = getResources();
            int i10 = C6849R.color.hiad_emui_color_subbg;
            window.setNavigationBarColor(resources.getColor(i10));
            window.setStatusBarColor(getResources().getColor(i10));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("Transparency", "setStatusAndNavigationBarColor error. %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: C */
    public int m51573C() {
        return C6849R.string.hiad_choices_whythisad;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        AbstractC7185ho.m43820b("Transparency", "initLayout");
        try {
            m51565c();
            setContentView(C6849R.layout.transparency_activity_layout);
        } catch (Throwable unused) {
            AbstractC7185ho.m43820b("Transparency", "set content view error");
        }
        m51572k();
        m51566d();
        m51570h();
        m51571i();
    }

    @TargetApi(21)
    /* renamed from: d */
    public final void m51574d(ActionBar actionBar) {
        View viewInflate = getLayoutInflater().inflate(C6849R.layout.action_bar_title_layout, (ViewGroup) null);
        try {
            try {
                actionBar.setDisplayShowCustomEnabled(true);
                actionBar.setCustomView(viewInflate);
                Toolbar toolbar = (Toolbar) viewInflate.getParent();
                if (toolbar != null) {
                    toolbar.setBackgroundColor(getResources().getColor(C6849R.color.hiad_emui_color_subbg));
                }
            } finally {
                viewInflate.setVisibility(8);
                actionBar.setDisplayShowCustomEnabled(false);
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("Transparency", "setCustomToolBar error.");
        }
    }

    /* renamed from: g */
    public final boolean m51575g() {
        return C6982bz.m41152b(this);
    }

    /* renamed from: j */
    public final String m51576j() {
        String stringExtra = new SafeIntent(getIntent()).getStringExtra(MapKeyNames.DSA_URL);
        AbstractC7185ho.m43821b("Transparency", "statement url:%s", AbstractC7819dl.m48375a(stringExtra));
        return stringExtra;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (this.f38453F) {
            m51563b(2);
            return;
        }
        int i10 = configuration.uiMode & 48;
        AbstractC7185ho.m43820b("Transparency", "currentNightMode=" + i10);
        if (32 == i10) {
            m51563b(2);
        } else {
            m51563b(0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean zM48576j = C7845x.m48576j(this);
        this.f38453F = zM48576j;
        if (zM48576j) {
            setTheme(C6849R.style.HiAdThemeNoActionBarFullScreen);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            super.onBackPressed();
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("Transparency", "onOptionsItemSelected ex: " + th2.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        super.onResume();
        int i10 = this.f38454G;
        if (i10 == -1 || i10 == -2) {
            m51571i();
        }
    }

    /* renamed from: c */
    private void m51565c() {
        Resources resources;
        int i10;
        View decorView = getWindow().getDecorView();
        if (decorView == null) {
            return;
        }
        if (this.f38453F || !m51575g()) {
            resources = getResources();
            i10 = C6849R.color.emui_color_bg;
        } else {
            resources = getResources();
            i10 = C6849R.color.hiad_emui_color_subbg;
        }
        decorView.setBackgroundColor(resources.getColor(i10));
    }

    /* renamed from: d */
    private void m51566d() {
        if (this.f38453F) {
            m51567e();
        } else {
            m51569f();
        }
    }

    /* renamed from: e */
    private void m51567e() {
        TextView textView = (TextView) findViewById(C6849R.id.web_appbar_tv);
        this.f38452E = textView;
        if (textView == null) {
            AbstractC7185ho.m43823c("Transparency", "get text view failed");
        } else {
            textView.setText(m51573C());
            this.f38452E.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.web.PureWebView.InterfaceC8175a
    /* renamed from: a */
    public void mo50669a(int i10) {
        this.f38454G = i10;
        if (this.f38453F && i10 == 0) {
            AbstractC7817dj.m48363a(new RunnableC8256c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m51562a(String str) {
        AbstractC7817dj.m48363a(new RunnableC8255b(str));
    }
}
