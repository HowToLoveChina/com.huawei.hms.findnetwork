package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0234s;
import p287fe.C9685a;
import p336he.C10150a;
import p399jk.AbstractC10896a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12808e;
import sk.C12809f;
import sm.C12817a;

/* loaded from: classes3.dex */
public class NoticeBeforeBackupActivity extends HiCloudBaseWebViewActivity {

    /* renamed from: a0 */
    public boolean f15628a0 = true;

    /* renamed from: b0 */
    public boolean f15629b0 = false;

    /* renamed from: c0 */
    public C13149f f15630c0 = new C13149f();

    /* renamed from: d0 */
    public long f15631d0 = Long.MAX_VALUE;

    /* renamed from: e0 */
    public int f15632e0 = 0;

    /* renamed from: f0 */
    public int f15633f0 = 0;

    /* renamed from: com.huawei.android.hicloud.ui.activity.NoticeBeforeBackupActivity$a */
    public class C3419a extends C12817a {
        public C3419a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C11839m.m70688i("NoticeBeforeBackupActivity", "onPageFinished.");
            NoticeBeforeBackupActivity.this.mo20597g2();
            super.onPageFinished(webView, str);
            NoticeBeforeBackupActivity.this.f15631d0 = System.currentTimeMillis();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C11839m.m70688i("NoticeBeforeBackupActivity", "onPageStarted.");
            NoticeBeforeBackupActivity.this.mo20624d2();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C11829c.m70580h(str, NoticeBeforeBackupActivity.this.f14930T)) {
                C11839m.m70687e("NoticeBeforeBackupActivity", "shouldOverrideUrlLoading check url host invalid, return");
                NoticeBeforeBackupActivity noticeBeforeBackupActivity = NoticeBeforeBackupActivity.this;
                noticeBeforeBackupActivity.mo20592U1(C11829c.m70560a0(noticeBeforeBackupActivity.f14947z), Arrays.toString(NoticeBeforeBackupActivity.this.f14930T));
                NoticeBeforeBackupActivity.this.mo20596f2();
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                C11839m.m70687e("NoticeBeforeBackupActivity", "shouldOverrideUrlLoading, url is empty");
                return false;
            }
            if (webView == null) {
                C11839m.m70687e("NoticeBeforeBackupActivity", "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("https") || str.startsWith("http")) {
                C11839m.m70687e("NoticeBeforeBackupActivity", "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            NoticeBeforeBackupActivity noticeBeforeBackupActivity2 = NoticeBeforeBackupActivity.this;
            noticeBeforeBackupActivity2.m21694n2(noticeBeforeBackupActivity2, str);
            return true;
        }
    }

    /* renamed from: B1 */
    private void m21689B1() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70689w("NoticeBeforeBackupActivity", "getActionBar is empty");
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.f15633f0 = R$string.cloudpay_cloud_backup_item_title;
        this.f15632e0 = R$drawable.cloud_space_guide_back_icon;
        C11829c.m70627w1(getApplicationContext(), getWindow());
        C10150a.m63212b(actionBar, new ColorDrawable(getColor(R$color.pay_activity_harmony_bg)));
        C11839m.m70686d("NoticeBeforeBackupActivity", "setActionBarExBackground white");
    }

    /* renamed from: l2 */
    private void m21693l2() {
        super.mo20590Q1();
        m21689B1();
        if (!C11829c.m70580h(this.f14947z, this.f14930T) && !this.f14931U) {
            C11839m.m70687e("NoticeBeforeBackupActivity", "check url host invalid, return");
            mo20592U1(C11829c.m70560a0(this.f14947z), Arrays.toString(this.f14930T));
            mo20596f2();
            return;
        }
        this.f14912B = mo20620X1();
        mo20594b2();
        if (!C0209d.m1333z1(this)) {
            mo20595e2();
        } else {
            mo20624d2();
            mo20598h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n2 */
    public void m21694n2(Activity activity, String str) {
        if (activity == null || str == null) {
            return;
        }
        C11839m.m70688i("NoticeBeforeBackupActivity", "jump to third app");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.putExtra("isFromNoticeBeforeBackupActivity", true);
            intent.setComponent(null);
            intent.setSelector(null);
            this.f15629b0 = activity.startActivityIfNeeded(intent, -1);
        } catch (ActivityNotFoundException unused) {
            AbstractC10896a.m65886e("NoticeBeforeBackupActivity", "ActivityNotFoundException:" + str);
            this.f15629b0 = false;
        }
    }

    /* renamed from: q2 */
    public static void m21695q2(SafeIntent safeIntent, long j10) {
        String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.DATA_TYPE_ID);
        String stringExtra2 = safeIntent.getStringExtra("scene_id");
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(safeIntent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f)));
        linkedHashMapM79499C.put("scene_id", stringExtra2);
        linkedHashMapM79499C.put("notify_id", stringExtra);
        linkedHashMapM79499C.put("is_auto_backup", safeIntent.getStringExtra("is_auto_backup"));
        linkedHashMapM79499C.put("exposure_time", Long.valueOf(j10));
        C13225d.m79490f1().m79591l0("action_code_backup_before_exposure_time", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "action_code_backup_before_exposure_time", "4", "81", linkedHashMapM79499C);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: S1 */
    public boolean mo20591S1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("NoticeBeforeBackupActivity", "initView");
        setContentView(R$layout.activity_notice_before_backup_webview);
        this.f14939r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.notice_before_backup_main);
        NotchFitLinearLayout notchFitLinearLayout = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.h5_operation_nonet);
        this.f14941t = notchFitLinearLayout;
        notchFitLinearLayout.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.h5_operation_no_net_btn);
        this.f14946y = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f14943v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.operation_error_url_layout);
        this.f14944w = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_loading);
        this.f14945x = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_error);
        this.f14940s = (HwProgressBar) C12809f.m76829b(this, R$id.external_webview_progress);
        this.f14938q = (SafeWebView) C12809f.m76829b(this, R$id.notice_before_backup_webview);
        this.f14937p = (NotchFitLinearLayout) C12809f.m76829b(this, com.huawei.hicloud.sync.R$id.ll_notice_before_backup_webview);
        if (this.f14938q == null) {
            C11839m.m70687e("NoticeBeforeBackupActivity", "initView is null");
            finish();
            return false;
        }
        C12808e.m76824c(this);
        C12808e.m76826e(this.f14939r);
        C11842p.m70874v1(this, this.f14946y);
        C11842p.m70760Q1(this, this.f14943v);
        mo19005p1();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: b2 */
    public void mo20594b2() {
        super.mo20594b2();
        WebSettings settings = this.f14938q.getSettings();
        if (settings == null) {
            C11839m.m70687e("NoticeBeforeBackupActivity", "WebSettings is null.");
            finish();
            return;
        }
        settings.setDomStorageEnabled(false);
        settings.setAllowFileAccess(false);
        mo20593Z1(this.f14938q);
        String[] strArr = this.f14930T;
        if (strArr == null || strArr.length == 0) {
            this.f14938q.setWhitelistWithPath(new String[]{this.f14912B});
        } else {
            this.f14938q.setWhitelist(strArr);
        }
        SafeWebView safeWebView = this.f14938q;
        safeWebView.addJavascriptInterface(new C9685a(safeWebView, this.f14930T, this), "hidiskOperation");
        this.f14938q.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.android.hicloud.ui.activity.NoticeBeforeBackupActivity.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                NoticeBeforeBackupActivity.this.mo20613M1();
                C11839m.m70688i("NoticeBeforeBackupActivity", "onProgressChanged,progress:" + i10);
                NoticeBeforeBackupActivity noticeBeforeBackupActivity = NoticeBeforeBackupActivity.this;
                HwProgressBar hwProgressBar = noticeBeforeBackupActivity.f14940s;
                if (hwProgressBar == null) {
                    C11839m.m70689w("NoticeBeforeBackupActivity", "onProgressChanged mTitleBar is null. Progress:" + i10);
                    return;
                }
                if (i10 == 100) {
                    noticeBeforeBackupActivity.f15628a0 = false;
                    NoticeBeforeBackupActivity.this.f14940s.setVisibility(8);
                } else {
                    hwProgressBar.setVisibility(0);
                    NoticeBeforeBackupActivity.this.f14940s.setProgress(i10);
                }
            }
        });
        this.f14938q.m53596e(new C3419a(), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: d2 */
    public void mo20624d2() {
        C11839m.m70688i("NoticeBeforeBackupActivity", "showLoadingView");
        C12809f.m76843p(this.f14944w, true);
        C12809f.m76843p(this.f14945x, false);
        C12809f.m76843p(this.f14941t, false);
        C12809f.m76843p(this.f14938q, false);
        C12809f.m76843p(this.f14943v, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: h2 */
    public void mo20598h2() {
        C11839m.m70688i("NoticeBeforeBackupActivity", "startLoadWebView begin.");
        super.mo20598h2();
        if (TextUtils.isEmpty(this.f14912B)) {
            C11839m.m70687e("NoticeBeforeBackupActivity", "startLoadWebView url is invalid.");
            mo20596f2();
            return;
        }
        if (m21699r2(this.f14912B, "lang=")) {
            this.f14912B += "&lang=" + C0234s.m1625c();
        }
        if (m21699r2(this.f14912B, "isDarkMode=")) {
            this.f14912B += "&isDarkMode=" + C11842p.m70732H0(this);
        }
        this.f14938q.loadUrl(this.f14912B);
        C11839m.m70688i("NoticeBeforeBackupActivity", "startLoadWebView end.");
    }

    /* renamed from: m2 */
    public final boolean m21696m2() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            return false;
        }
        return actionBar.getTitle().equals(getResources().getString(R$string.space_usage_suggestion_title));
    }

    /* renamed from: o2 */
    public final void m21697o2() {
        if (getActionBar() == null) {
            C11839m.m70689w("NoticeBeforeBackupActivity", "getActionBar is empty");
        } else {
            invalidateOptionsMenu();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        if (m21696m2()) {
            m21698p2(R$string.cloudpay_cloud_backup_item_title, R$drawable.cloud_space_guide_back_icon);
            mo20598h2();
        }
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m21697o2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i("NoticeBeforeBackupActivity", "onCreate enter.");
        this.f15630c0.m79065c(this, new SafeIntent(getIntent()), C13222a.m79465g(this));
        mo20591S1();
        m21693l2();
        C11839m.m70688i("NoticeBeforeBackupActivity", "onCreate end.");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        C11839m.m70688i("NoticeBeforeBackupActivity", "onCreateOptionsMenu");
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70689w("NoticeBeforeBackupActivity", "getActionBar is empty");
            return true;
        }
        int i10 = this.f15633f0;
        if (i10 > 0) {
            actionBar.setTitle(i10);
        }
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("NoticeBeforeBackupActivity", "onDestroy enter.");
        if (this.f15631d0 == Long.MAX_VALUE) {
            C11839m.m70689w("NoticeBeforeBackupActivity", "webview load failed, no exposure time.");
        } else {
            m21695q2(new SafeIntent(getIntent()), System.currentTimeMillis() - this.f15631d0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (!m21696m2()) {
            finish();
            return true;
        }
        m21698p2(R$string.cloudpay_cloud_backup_item_title, R$drawable.cloud_space_guide_back_icon);
        mo20598h2();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70688i("NoticeBeforeBackupActivity", "onResume");
        super.onResume();
        if (!this.f15629b0 || m21696m2()) {
            return;
        }
        C11839m.m70688i("NoticeBeforeBackupActivity", "isJumpToThirdApp,begin to reload url");
        mo20598h2();
        this.f15629b0 = false;
        invalidateOptionsMenu();
        m21689B1();
    }

    /* renamed from: p2 */
    public void m21698p2(int i10, int i11) {
        if (getActionBar() == null) {
            C11839m.m70689w("NoticeBeforeBackupActivity", "getActionBar is empty");
            return;
        }
        this.f15633f0 = i10;
        this.f15632e0 = i11;
        invalidateOptionsMenu();
    }

    /* renamed from: r2 */
    public final boolean m21699r2(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return !new URL(str).getQuery().contains(str2);
        } catch (MalformedURLException unused) {
            C11839m.m70687e("NoticeBeforeBackupActivity", "parse url error.");
            return false;
        }
    }
}
