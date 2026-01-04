package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.TextView;
import ca.C1398a;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.ads.jsb.PPSJsBridge;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import mu.C11525b;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0234s;
import p015ak.C0241z;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p529op.C11983e;
import p674ub.C13149f;
import p684un.C13222a;
import sk.C12808e;
import sk.C12809f;
import uk.C13206d;

/* loaded from: classes3.dex */
public class HiCloudBaseWebViewActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public boolean f14911A;

    /* renamed from: G */
    public long f14917G;

    /* renamed from: L */
    public boolean f14922L;

    /* renamed from: M */
    public int f14923M;

    /* renamed from: Y */
    public String f14935Y;

    /* renamed from: Z */
    public PPSJsBridge f14936Z;

    /* renamed from: p */
    public NotchFitLinearLayout f14937p;

    /* renamed from: q */
    public SafeWebView f14938q;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f14939r;

    /* renamed from: s */
    public HwProgressBar f14940s;

    /* renamed from: t */
    public NotchFitLinearLayout f14941t;

    /* renamed from: u */
    public TextView f14942u;

    /* renamed from: v */
    public NotchFitLinearLayout f14943v;

    /* renamed from: w */
    public HwColumnLinearLayout f14944w;

    /* renamed from: x */
    public HwColumnLinearLayout f14945x;

    /* renamed from: y */
    public AutoSizeButton f14946y;

    /* renamed from: z */
    public String f14947z = "";

    /* renamed from: B */
    public String f14912B = "";

    /* renamed from: C */
    public String f14913C = "";

    /* renamed from: D */
    public String f14914D = "";

    /* renamed from: E */
    public String f14915E = "";

    /* renamed from: F */
    public String f14916F = "";

    /* renamed from: H */
    public String f14918H = "";

    /* renamed from: I */
    public String f14919I = "";

    /* renamed from: J */
    public String f14920J = "";

    /* renamed from: K */
    public int f14921K = -1;

    /* renamed from: N */
    public String f14924N = "";

    /* renamed from: O */
    public boolean f14925O = false;

    /* renamed from: P */
    public boolean f14926P = false;

    /* renamed from: Q */
    public boolean f14927Q = false;

    /* renamed from: R */
    public boolean f14928R = false;

    /* renamed from: S */
    public String f14929S = "";

    /* renamed from: T */
    public String[] f14930T = null;

    /* renamed from: U */
    public boolean f14931U = false;

    /* renamed from: V */
    public boolean f14932V = false;

    /* renamed from: W */
    public boolean f14933W = false;

    /* renamed from: X */
    public boolean f14934X = false;

    /* renamed from: P1 */
    private void m20611P1(WebSettings webSettings) {
        try {
            if (21 >= C0219i.m1463a()) {
                C11839m.m70688i("HiCloudBaseWebViewActivity", "dark mode is not support");
            } else {
                webSettings.setForceDark(0);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "initDarkMode exception:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: D1 */
    public void mo20612D1() {
    }

    /* renamed from: M1 */
    public boolean mo20613M1() {
        if (C0209d.m1333z1(this)) {
            return false;
        }
        C11839m.m70687e("HiCloudBaseWebViewActivity", "net is not connected");
        mo20595e2();
        return true;
    }

    /* renamed from: N1 */
    public void m20614N1(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("HiCloudBaseWebViewActivity", "script null" + str);
            return;
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.evaluateJavascript(str, null);
            C11839m.m70688i("HiCloudBaseWebViewActivity", "evaluateJavascript:" + str);
        }
    }

    /* renamed from: O1 */
    public void m20615O1() {
        String strM8021n = C1398a.m8021n();
        if (TextUtils.isEmpty(strM8021n)) {
            return;
        }
        m20614N1(String.format(Locale.ENGLISH, "%s()", strM8021n));
    }

    /* renamed from: Q1 */
    public void mo20590Q1() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f14947z = hiCloudSafeIntent.getStringExtra("url");
        this.f14911A = hiCloudSafeIntent.getBooleanExtra("useMargin", false);
        this.f14916F = hiCloudSafeIntent.getStringExtra("channel_refer");
        this.f14918H = hiCloudSafeIntent.getStringExtra("srcChannel");
        this.f14921K = hiCloudSafeIntent.getIntExtra("aop_from_where", -1);
        this.f14919I = hiCloudSafeIntent.getStringExtra("salChannel");
        this.f14924N = hiCloudSafeIntent.getStringExtra("title");
        this.f14925O = hiCloudSafeIntent.getBooleanExtra("title_priority", false);
        this.f14915E = hiCloudSafeIntent.getStringExtra("entranChannel");
        this.f14922L = hiCloudSafeIntent.getBooleanExtra("isEnableJs", false);
        this.f14920J = hiCloudSafeIntent.getStringExtra("activityCode");
        this.f14923M = hiCloudSafeIntent.getIntExtra("launch_web_type", -1);
        this.f14926P = hiCloudSafeIntent.getBooleanExtra("no_need_param", false);
        this.f14927Q = hiCloudSafeIntent.getBooleanExtra("if_use_browser_when_url_not_in_white_list", false);
        this.f14931U = hiCloudSafeIntent.getBooleanExtra("if_local_html_file", false);
        this.f14933W = hiCloudSafeIntent.getBooleanExtra("is_activity_need_back_to_main", false);
        this.f14932V = hiCloudSafeIntent.getBooleanExtra("is_support_orientation", false);
        this.f14934X = hiCloudSafeIntent.getBooleanExtra("is_support_dark_mode", false);
        this.f14930T = C11829c.m70529L();
        m20622a2();
        m20616R1();
    }

    /* renamed from: R1 */
    public void m20616R1() {
        try {
            this.f14917G = Long.parseLong(Uri.parse(this.f14947z).getQueryParameter("timeoutms"));
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "initTimeOut error: " + e10.toString());
            this.f14917G = 30000L;
        }
        try {
            this.f14935Y = Uri.parse(this.f14947z).getQueryParameter("actionbar");
        } catch (Exception e11) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "actionBarType error: " + e11.getMessage());
        }
    }

    /* renamed from: S1 */
    public boolean mo20591S1() {
        try {
            setContentView(R$layout.activity_opertaion_webview);
            this.f14939r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.operation_webview_mian);
            this.f14944w = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_loading);
            this.f14945x = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_error);
            this.f14941t = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.h5_operation_nonet);
            this.f14942u = (TextView) C12809f.m76829b(this, R$id.net_error_text);
            this.f14946y = (AutoSizeButton) C12809f.m76829b(this, R$id.h5_operation_no_net_btn);
            this.f14941t.setOnClickListener(this);
            this.f14946y.setOnClickListener(this);
            this.f14943v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.operation_error_url_layout);
            this.f14940s = (HwProgressBar) C12809f.m76829b(this, R$id.external_webview_progress);
            this.f14937p = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_operation_webview);
            SafeWebView safeWebView = (SafeWebView) C12809f.m76829b(this, R$id.operation_webview);
            this.f14938q = safeWebView;
            if (safeWebView == null) {
                C11839m.m70687e("HiCloudBaseWebViewActivity", "initView is null");
                finish();
                return false;
            }
            C12808e.m76824c(this);
            C12808e.m76826e(this.f14939r);
            C11842p.m70874v1(this, this.f14946y);
            mo19005p1();
            C11842p.m70760Q1(this, this.f14943v);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "initView error: " + e10.getMessage());
            finish();
            return false;
        }
    }

    /* renamed from: T1 */
    public boolean m20617T1(String str) {
        if (this.f14931U) {
            C11839m.m70688i("HiCloudBaseWebViewActivity", "local html, no need check valid");
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "url is empty");
            return false;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "uri is null");
            return false;
        }
        String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return true;
        }
        C11839m.m70687e("HiCloudBaseWebViewActivity", "illegal scheme:" + scheme);
        return false;
    }

    /* renamed from: U1 */
    public void mo20592U1(String str, String str2) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_CURRENT_URL, this.f14947z);
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_CURRENT_HOST, str);
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_WHITE_LIST, str2);
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_WHITE_LIST_CHECK_RESULT, String.valueOf(false));
        NotificationReportUtil.reportWiseMarketingOperaitonResult("0022", map, String.valueOf(false));
    }

    /* renamed from: V1 */
    public String m20618V1() {
        String strM20619W1 = m20619W1();
        if (TextUtils.isEmpty(strM20619W1)) {
            return null;
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        return strM20619W1 + "&backUpTime=" + safeIntent.getStringExtra("backUpTime") + "&needSpace=" + safeIntent.getStringExtra("needSpace") + "&nowSpace=" + safeIntent.getStringExtra("nowSpace") + "&drawCloudSpace=" + safeIntent.getStringExtra("drawCloudSpace");
    }

    /* renamed from: W1 */
    public String m20619W1() {
        if (!m20617T1(this.f14947z)) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "url is invalid");
            return null;
        }
        if (this.f14926P) {
            return this.f14947z;
        }
        String strM1631i = C0234s.m1631i();
        if (TextUtils.isEmpty(strM1631i)) {
            strM1631i = HNUtil.getCurrentBaseLanguage();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("srcAppId=");
        arrayList.add("srcChannel=");
        arrayList.add("salChannel=");
        arrayList.add("activityCode=");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f14914D);
        arrayList2.add(this.f14918H);
        arrayList2.add(this.f14919I);
        arrayList2.add(this.f14920J);
        StringBuilder sb2 = new StringBuilder(C13206d.m79403c(this.f14947z, FaqConstants.FAQ_EMUI_LANGUAGE, strM1631i));
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (!this.f14947z.contains((CharSequence) arrayList.get(i10))) {
                sb2.append("&");
                sb2.append((String) arrayList.get(i10));
                sb2.append((String) arrayList2.get(i10));
            }
        }
        return sb2.toString();
    }

    /* renamed from: X1 */
    public String mo20620X1() {
        if (!m20617T1(this.f14947z)) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "url is invalid");
            return null;
        }
        C11839m.m70686d("HiCloudBaseWebViewActivity", "processLoadWebViewForRenew url = " + this.f14947z + ", srcChannel = " + this.f14918H + ", salChannel = " + this.f14919I);
        return this.f14947z;
    }

    /* renamed from: Y1 */
    public void m20621Y1(ActionBar actionBar) {
        if (actionBar == null || TextUtils.isEmpty(this.f14935Y)) {
            return;
        }
        if (C0241z.m1685c(this.f14935Y) == 1) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.show();
        } else if (C0241z.m1685c(this.f14935Y) == 2) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.show();
        } else if (C0241z.m1685c(this.f14935Y) == 3) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /* renamed from: Z1 */
    public void mo20593Z1(SafeWebView safeWebView) {
        WebSettings settings = safeWebView.getSettings();
        if (settings == null) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "WebSettings is null.");
            return;
        }
        String userAgentString = settings.getUserAgentString();
        String str = "HiDiskCloudService/com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)";
        safeWebView.getSettings().setUserAgentString(userAgentString + "; " + str);
    }

    /* renamed from: a2 */
    public void m20622a2() {
        if (this.f14932V) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* renamed from: b2 */
    public void mo20594b2() {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView == null) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "webview is null.");
            finish();
            return;
        }
        C11525b.m68802f(safeWebView);
        WebSettings settings = this.f14938q.getSettings();
        if (settings == null) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "WebSettings is null.");
            finish();
            return;
        }
        settings.setJavaScriptEnabled(this.f14922L);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        String str = this.f14912B;
        if (str != null) {
            String strM79402b = C13206d.m79402b(str.toLowerCase(Locale.ENGLISH), "darkmode");
            if (!TextUtils.isEmpty(strM79402b) && C0241z.m1685c(strM79402b) == 0) {
                m20611P1(settings);
                return;
            }
            if (C11842p.m70732H0(this)) {
                try {
                    settings.setForceDark(2);
                } catch (Exception e10) {
                    C11839m.m70687e("HiCloudBaseWebViewActivity", "initDarkMode exception:" + e10.getMessage());
                }
            }
        }
    }

    /* renamed from: c2 */
    public void m20623c2() {
        C11839m.m70688i("HiCloudBaseWebViewActivity", "showErrorView");
        HwColumnLinearLayout hwColumnLinearLayout = this.f14944w;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f14945x;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(0);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f14943v;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14939r);
        arrayList.add(this.f14937p);
        arrayList.add(this.f14944w);
        arrayList.add(this.f14945x);
        arrayList.add(this.f14941t);
        arrayList.add(this.f14943v);
        return arrayList;
    }

    /* renamed from: d2 */
    public void mo20624d2() {
        HwColumnLinearLayout hwColumnLinearLayout = this.f14944w;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f14945x;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f14943v;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: e2 */
    public void mo20595e2() {
        HwColumnLinearLayout hwColumnLinearLayout = this.f14944w;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f14945x;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
        if (notchFitLinearLayout != null && this.f14942u != null) {
            notchFitLinearLayout.setVisibility(0);
            this.f14942u.setText(getString(R$string.network_unavailable));
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
        m22365E1(R$string.app_name);
        NotchFitLinearLayout notchFitLinearLayout2 = this.f14943v;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: f2 */
    public void mo20596f2() {
        NotchFitLinearLayout notchFitLinearLayout = this.f14943v;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(0);
        }
        HwColumnLinearLayout hwColumnLinearLayout = this.f14944w;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f14945x;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f14941t;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
    }

    /* renamed from: g2 */
    public void mo20597g2() {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(0);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout = this.f14944w;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f14945x;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f14943v;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: h2 */
    public void mo20598h2() {
        if (this.f14938q == null) {
            C11839m.m70687e("HiCloudBaseWebViewActivity", "mwebview is null, finish");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            C11839m.m70688i("HiCloudBaseWebViewActivity", "onBackPressed");
            SafeWebView safeWebView = this.f14938q;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.f14938q.goBack();
                return;
            }
            if (this.f14933W) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(getPackageName(), NotifyConstants.Action.ACTION_MAIN_ACTIVITY));
                startActivity(intent);
                new HwAnimationReflection(this).m15927c(2);
            }
            super.onBackPressed();
        } catch (Exception e10) {
            C11839m.m70688i("HiCloudBaseWebViewActivity", "onBackPressed error: " + e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.h5_operation_no_net_btn) {
            C11829c.m70612r1(this);
            return;
        }
        if (id2 == R$id.h5_operation_nonet) {
            this.f14941t.setVisibility(8);
            if (C0209d.m1333z1(this)) {
                mo20598h2();
            } else {
                mo20595e2();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m20622a2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new C13149f().m79065c(this, getIntent(), C13222a.m79465g(this));
        C11839m.m70688i("HiCloudBaseWebViewActivity", "onCreate");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("HiCloudBaseWebViewActivity", "ondestroy");
        C11983e.m72121b().m72125e(this.f14936Z);
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
            this.f14938q.removeAllViews();
            this.f14938q.destroy();
        }
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        C11839m.m70688i("HiCloudBaseWebViewActivity", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70688i("HiCloudBaseWebViewActivity", "onResume");
        super.onResume();
    }
}
