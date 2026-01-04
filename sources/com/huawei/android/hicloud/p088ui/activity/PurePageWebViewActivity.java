package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import hu.C10342a;
import java.util.ArrayList;
import java.util.List;
import je.C10794j;
import mu.C11525b;
import org.json.JSONException;
import p015ak.C0203a;
import p015ak.C0209d;
import p015ak.C0219i;
import p336he.C10150a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PurePageWebViewActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: C */
    public String f15816C;

    /* renamed from: p */
    public NotchFitLinearLayout f15817p;

    /* renamed from: q */
    public WebView f15818q;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f15819r;

    /* renamed from: s */
    public HwProgressBar f15820s;

    /* renamed from: t */
    public NotchFitLinearLayout f15821t;

    /* renamed from: u */
    public NotchFitLinearLayout f15822u;

    /* renamed from: v */
    public HwColumnLinearLayout f15823v;

    /* renamed from: w */
    public HwColumnLinearLayout f15824w;

    /* renamed from: x */
    public AutoSizeButton f15825x;

    /* renamed from: z */
    public boolean f15827z;

    /* renamed from: y */
    public String f15826y = "";

    /* renamed from: A */
    public String f15814A = "";

    /* renamed from: B */
    public boolean f15815B = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.PurePageWebViewActivity$a */
    public class C3446a extends WebViewClient {
        public C3446a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C11839m.m70686d("PurePageWebViewActivity", "onPageFinished: " + str);
            super.onPageFinished(webView, str);
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(PurePageWebViewActivity.this.f15814A)) {
                PurePageWebViewActivity purePageWebViewActivity = PurePageWebViewActivity.this;
                purePageWebViewActivity.m21975T1(purePageWebViewActivity.f15814A);
            } else if (!TextUtils.isEmpty(title) && !title.equals(str)) {
                PurePageWebViewActivity.this.m21975T1(title);
            } else {
                PurePageWebViewActivity purePageWebViewActivity2 = PurePageWebViewActivity.this;
                purePageWebViewActivity2.m21975T1(purePageWebViewActivity2.f15814A);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C11839m.m70686d("PurePageWebViewActivity", "onPageStarted: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C11839m.m70686d("PurePageWebViewActivity", "shouldOverrideUrlLoading, url: " + str);
            if (TextUtils.isEmpty(str)) {
                C11839m.m70687e("PurePageWebViewActivity", "shouldOverrideUrlLoading, url is empty");
                return false;
            }
            if (webView == null) {
                C11839m.m70687e("PurePageWebViewActivity", "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("https") || str.startsWith("http")) {
                C11839m.m70687e("PurePageWebViewActivity", "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            C10794j.m65686m(PurePageWebViewActivity.this, str);
            return true;
        }
    }

    /* renamed from: N1 */
    private void m21967N1(WebSettings webSettings) {
        try {
            if (21 >= C0219i.m1463a()) {
                C11839m.m70688i("PurePageWebViewActivity", "dark mode is not support");
            } else {
                webSettings.setForceDark(0);
            }
        } catch (Exception e10) {
            C11839m.m70687e("PurePageWebViewActivity", "initDarkMode exception:" + e10.getMessage());
        }
    }

    /* renamed from: B1 */
    public void m21968B1() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e("PurePageWebViewActivity", "getActionBar is empty");
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
        C10150a.m63212b(actionBar, new ColorDrawable(getColor(R$color.emui_color_bg)));
        C11839m.m70686d("PurePageWebViewActivity", "setActionBarExBackground white");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: D1 */
    public void mo20612D1() {
    }

    /* renamed from: M1 */
    public boolean m21969M1() {
        if (C0209d.m1333z1(this)) {
            return false;
        }
        C11839m.m70687e("PurePageWebViewActivity", "net is not connected");
        m21978W1();
        return true;
    }

    /* renamed from: O1 */
    public void m21970O1() {
        m21971P1();
        m21976U1();
        m21968B1();
        if (!C0209d.m1333z1(this)) {
            m21978W1();
        } else {
            m21977V1();
            m21981Z1();
        }
    }

    /* renamed from: P1 */
    public void m21971P1() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f15826y = hiCloudSafeIntent.getStringExtra("url");
        this.f15814A = hiCloudSafeIntent.getStringExtra("title");
        this.f15827z = hiCloudSafeIntent.getBooleanExtra("isEnableJs", false);
        this.f15816C = hiCloudSafeIntent.getStringExtra("return_page_name");
    }

    /* renamed from: Q1 */
    public boolean m21972Q1() {
        try {
            setContentView(R$layout.activity_purepage_webview);
            this.f15819r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.operation_webview_mian);
            this.f15823v = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_loading);
            this.f15824w = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_error);
            this.f15821t = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.h5_operation_nonet);
            this.f15825x = (AutoSizeButton) C12809f.m76829b(this, R$id.h5_operation_no_net_btn);
            this.f15821t.setOnClickListener(this);
            this.f15825x.setOnClickListener(this);
            this.f15822u = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.operation_error_url_layout);
            this.f15820s = (HwProgressBar) C12809f.m76829b(this, R$id.external_webview_progress);
            this.f15817p = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_operation_webview);
            WebView webView = (WebView) C12809f.m76829b(this, R$id.operation_webview);
            this.f15818q = webView;
            if (webView == null) {
                C11839m.m70687e("PurePageWebViewActivity", "initView is null");
                finish();
                return false;
            }
            C12808e.m76824c(this);
            C12808e.m76826e(this.f15819r);
            C11842p.m70874v1(this, this.f15825x);
            mo19005p1();
            C11842p.m70760Q1(this, this.f15822u);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("PurePageWebViewActivity", "initView error: " + e10.getMessage());
            finish();
            return false;
        }
    }

    /* renamed from: R1 */
    public boolean m21973R1(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("PurePageWebViewActivity", "url is empty");
            return false;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            C11839m.m70687e("PurePageWebViewActivity", "uri is null");
            return false;
        }
        String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return true;
        }
        C11839m.m70687e("PurePageWebViewActivity", "illegal scheme:" + scheme);
        return false;
    }

    /* renamed from: S1 */
    public final boolean m21974S1() {
        if (TextUtils.isEmpty(this.f15816C) || C0203a.m1124a(this.f15816C, this)) {
            return false;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("android.intent.action.VIEW");
        intent.setClassName(this, this.f15816C);
        intent.addFlags(536870912);
        if (!C10342a.m63676b(this, intent)) {
            return false;
        }
        finish();
        return true;
    }

    /* renamed from: T1 */
    public void m21975T1(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e("PurePageWebViewActivity", "getActionBar is empty");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = getString(R$string.app_name);
        }
        actionBar.setTitle(str);
    }

    /* renamed from: U1 */
    public void m21976U1() {
        WebView webView = this.f15818q;
        if (webView == null) {
            C11839m.m70687e("PurePageWebViewActivity", "webview is null.");
            finish();
            return;
        }
        C11525b.m68802f(webView);
        WebSettings settings = this.f15818q.getSettings();
        if (settings == null) {
            C11839m.m70687e("PurePageWebViewActivity", "WebSettings is null.");
            finish();
            return;
        }
        settings.setJavaScriptEnabled(this.f15827z);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        if (!this.f15815B) {
            m21967N1(settings);
        } else if (C11842p.m70732H0(this)) {
            try {
                settings.setForceDark(2);
            } catch (Exception e10) {
                C11839m.m70687e("PurePageWebViewActivity", "initDarkMode exception:" + e10.getMessage());
            }
        }
        this.f15818q.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.android.hicloud.ui.activity.PurePageWebViewActivity.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i10) {
                super.onProgressChanged(webView2, i10);
                PurePageWebViewActivity.this.m21969M1();
                C11839m.m70688i("PurePageWebViewActivity", "onProgressChanged,progress:" + i10);
                HwProgressBar hwProgressBar = PurePageWebViewActivity.this.f15820s;
                if (hwProgressBar == null) {
                    C11839m.m70689w("PurePageWebViewActivity", "onProgressChanged mTitleBar is null. Progress:" + i10);
                    return;
                }
                if (i10 == 100) {
                    hwProgressBar.setVisibility(8);
                } else {
                    hwProgressBar.setVisibility(0);
                    PurePageWebViewActivity.this.f15820s.setProgress(i10);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
                String url = webView2.getUrl();
                if (!TextUtils.isEmpty(PurePageWebViewActivity.this.f15814A)) {
                    PurePageWebViewActivity purePageWebViewActivity = PurePageWebViewActivity.this;
                    purePageWebViewActivity.m21975T1(purePageWebViewActivity.f15814A);
                } else if (!TextUtils.isEmpty(str) && !str.equals(url)) {
                    PurePageWebViewActivity.this.m21975T1(str);
                } else {
                    PurePageWebViewActivity purePageWebViewActivity2 = PurePageWebViewActivity.this;
                    purePageWebViewActivity2.m21975T1(purePageWebViewActivity2.f15814A);
                }
            }
        });
        this.f15818q.setWebViewClient(new C3446a());
    }

    /* renamed from: V1 */
    public void m21977V1() {
        HwColumnLinearLayout hwColumnLinearLayout = this.f15823v;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f15824w;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15821t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        WebView webView = this.f15818q;
        if (webView != null) {
            webView.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15822u;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: W1 */
    public void m21978W1() {
        HwColumnLinearLayout hwColumnLinearLayout = this.f15823v;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f15824w;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15821t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(0);
        }
        WebView webView = this.f15818q;
        if (webView != null) {
            webView.setVisibility(8);
        }
        m22365E1(com.huawei.hicloud.sync.R$string.app_name);
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15822u;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: X1 */
    public void m21979X1() {
        NotchFitLinearLayout notchFitLinearLayout = this.f15822u;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(0);
        }
        HwColumnLinearLayout hwColumnLinearLayout = this.f15823v;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f15824w;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15821t;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
        WebView webView = this.f15818q;
        if (webView != null) {
            webView.setVisibility(8);
        }
    }

    /* renamed from: Y1 */
    public void m21980Y1() {
        WebView webView = this.f15818q;
        if (webView != null) {
            webView.setVisibility(0);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15821t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout = this.f15823v;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f15824w;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15822u;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: Z1 */
    public void m21981Z1() {
        if (this.f15818q == null) {
            C11839m.m70687e("PurePageWebViewActivity", "mWebView is null, finish");
            finish();
        } else if (StringUtil.isBlank(this.f15826y)) {
            C11839m.m70687e("PurePageWebViewActivity", "startLoadWebView url is invalid.");
            m21979X1();
        } else if (m21973R1(this.f15826y)) {
            m21980Y1();
            this.f15818q.loadUrl(this.f15826y);
        } else {
            C11839m.m70687e("PurePageWebViewActivity", "url is invalid");
            m21979X1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15819r);
        arrayList.add(this.f15817p);
        arrayList.add(this.f15823v);
        arrayList.add(this.f15824w);
        arrayList.add(this.f15821t);
        arrayList.add(this.f15822u);
        return arrayList;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i("PurePageWebViewActivity", "onBackPressed");
        WebView webView = this.f15818q;
        if (webView != null && webView.canGoBack()) {
            this.f15818q.goBack();
        } else {
            if (m21974S1()) {
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == com.huawei.android.p073ds.R$id.h5_operation_no_net_btn) {
            C11829c.m70612r1(this);
            return;
        }
        if (id2 == com.huawei.android.p073ds.R$id.h5_operation_nonet) {
            this.f15821t.setVisibility(8);
            if (C0209d.m1333z1(this)) {
                m21981Z1();
            } else {
                m21978W1();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f15825x);
        C11842p.m70760Q1(this, this.f15822u);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        C11839m.m70688i("PurePageWebViewActivity", "onCreate");
        if (m21972Q1()) {
            m21970O1();
            C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "PurePageWebViewActivity");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("PurePageWebViewActivity", "onDestroy");
        WebView webView = this.f15818q;
        if (webView != null) {
            webView.setVisibility(8);
            this.f15818q.removeAllViews();
            this.f15818q.destroy();
        }
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C11839m.m70688i("PurePageWebViewActivity", "onNewIntent");
        setIntent(intent);
        m21970O1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f15821t.getVisibility() == 0 || this.f15823v.getVisibility() == 0) {
                this.f15823v.setVisibility(8);
                this.f15818q.setVisibility(8);
                finish();
                return true;
            }
            WebView webView = this.f15818q;
            if (webView != null && webView.canGoBack()) {
                this.f15818q.goBack();
                return true;
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70688i("PurePageWebViewActivity", "onResume");
        super.onResume();
    }
}
