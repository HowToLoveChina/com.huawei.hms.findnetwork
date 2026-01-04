package com.huawei.phoneservice.faq.p174ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.huawei.phoneservice.faq.FaqCommonWebActivity;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$menu;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.utils.C8412b;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.C8416f;
import com.huawei.phoneservice.faq.utils.C8417g;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.BadgeHelper;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class FaqCategoryWebActivity extends FaqCommonWebActivity implements View.OnClickListener {

    /* renamed from: X */
    public C8366b f38922X;

    /* renamed from: a0 */
    public BadgeHelper f38925a0;

    /* renamed from: d0 */
    public String f38928d0;

    /* renamed from: e0 */
    public String f38929e0;

    /* renamed from: f0 */
    public String f38930f0;

    /* renamed from: g0 */
    public String f38931g0;

    /* renamed from: Y */
    public boolean f38923Y = true;

    /* renamed from: Z */
    public boolean f38924Z = true;

    /* renamed from: b0 */
    public boolean f38926b0 = false;

    /* renamed from: c0 */
    public boolean f38927c0 = false;

    /* renamed from: h0 */
    public FaqNoticeView.InterfaceC8428b f38932h0 = new C8365a();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryWebActivity$a */
    public class C8365a implements FaqNoticeView.InterfaceC8428b {
        public C8365a() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqNoticeView.InterfaceC8428b
        /* renamed from: a */
        public void mo52087a() throws Throwable {
            C8412b.m52367a(FaqCategoryWebActivity.this);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryWebActivity$b */
    public final class C8366b {

        /* renamed from: a */
        public WeakReference<Activity> f38934a;

        public C8366b(Activity activity) {
            this.f38934a = new WeakReference<>(activity);
        }

        @JavascriptInterface
        public String faqParameters() throws Throwable {
            WeakReference<Activity> weakReference = this.f38934a;
            String map = (weakReference == null ? null : weakReference.get()) != null ? FaqSdk.getSdk().getMap() : null;
            FaqLogger.m51840e("FaqCategoryWebActivity", "faqParameters  " + map);
            return map;
        }

        @JavascriptInterface
        public boolean feedbackAvailable() {
            return !ModuleConfigUtils.feedbackVisible() && C8416f.m52392d();
        }

        @JavascriptInterface
        public String getSystemLanguage() {
            return FaqLanguageUtils.getLanguage();
        }

        @JavascriptInterface
        public boolean isDarkMode() {
            return C8417g.m52397c(FaqCategoryWebActivity.this);
        }

        @JavascriptInterface
        public void problemsSuggestions() throws Throwable {
            WeakReference<Activity> weakReference = this.f38934a;
            if ((weakReference == null ? null : weakReference.get()) != null) {
                FaqCategoryWebActivity faqCategoryWebActivity = FaqCategoryWebActivity.this;
                C8412b.m52368b(faqCategoryWebActivity, faqCategoryWebActivity.f38925a0);
            }
            FaqLogger.m51840e("FaqCategoryWebActivity", "problemsSuggestions");
        }

        @JavascriptInterface
        public void productSuggestions() throws Throwable {
            WeakReference<Activity> weakReference = this.f38934a;
            if ((weakReference == null ? null : weakReference.get()) != null) {
                FaqCategoryWebActivity faqCategoryWebActivity = FaqCategoryWebActivity.this;
                C8412b.m52371e(faqCategoryWebActivity, faqCategoryWebActivity.f38925a0);
            }
            FaqLogger.m51840e("FaqCategoryWebActivity", "productSuggestions");
        }

        @JavascriptInterface
        public void setShowShare(boolean z10, String str, String str2, String str3, String str4) throws Throwable {
            FaqCategoryWebActivity.this.f38928d0 = str2;
            FaqCategoryWebActivity.this.f38930f0 = str;
            FaqCategoryWebActivity.this.f38926b0 = z10;
            FaqCategoryWebActivity.this.f38931g0 = str4;
            FaqCategoryWebActivity.this.f38929e0 = str3;
            FaqCategoryWebActivity.this.invalidateOptionsMenu();
            FaqLogger.m51840e("FaqCategoryWebActivity", "setShowShare " + z10);
        }

        @JavascriptInterface
        public void setShowSpot(boolean z10) throws Throwable {
            FaqCategoryWebActivity.this.f38927c0 = z10;
            FaqCategoryWebActivity.this.invalidateOptionsMenu();
            FaqLogger.m51840e("FaqCategoryWebActivity", "setShowSpot " + z10);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryWebActivity$c */
    public static class C8367c implements DownloadListener {

        /* renamed from: a */
        public WeakReference<WebView> f38936a;

        public C8367c(WebView webView) {
            this.f38936a = new WeakReference<>(webView);
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) throws Throwable {
            FaqLogger.m51840e("FaqCategoryWebActivity", "onDownloadStart url:" + str);
            try {
                WebView webView = this.f38936a.get();
                if (webView != null) {
                    String url = webView.getUrl();
                    Context context = webView.getContext();
                    if (context != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.BROWSABLE");
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                    }
                    if (TextUtils.isEmpty(url)) {
                        url = "";
                    }
                    if (webView.getVisibility() != 0 || TextUtils.equals(url, str)) {
                        if (webView.canGoBack()) {
                            webView.goBack();
                        } else if (context instanceof Activity) {
                            ((Activity) context).onBackPressed();
                        }
                    }
                }
            } catch (Throwable th2) {
                FaqLogger.m51842e("FaqCategoryWebActivity", th2);
            }
        }
    }

    /* renamed from: R0 */
    private void m52101R0() {
        this.f38923Y = C8412b.m52370d("6");
        this.f38924Z = C8412b.m52370d("7");
        invalidateOptionsMenu();
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: E0 */
    public void mo51663E0() {
        this.f38508B = ModuleConfigUtils.getFaqOpenTypeConfig()[1];
        super.mo51663E0();
        C8366b c8366b = new C8366b(this);
        this.f38922X = c8366b;
        this.f38511E.addJavascriptInterface(c8366b, "faqJSInterface");
        this.f38507A = false;
        WebView webView = this.f38511E;
        webView.setDownloadListener(new C8367c(webView));
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: G0 */
    public void mo51665G0() throws Throwable {
        FaqLogger.m51836d("FaqCategoryWebActivity", "onPageFinish  " + this.f38511E.getUrl());
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: b */
    public void mo51670b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f38511E.removeJavascriptInterface("faqJSInterface");
            this.f38511E.getSettings().setJavaScriptEnabled(false);
            this.f38507A = true;
        } else {
            this.f38511E.getSettings().setJavaScriptEnabled(true);
            FaqWebActivityUtil.removeWebViewJavascriptInterface(this.f38511E);
            this.f38511E.addJavascriptInterface(this.f38922X, "faqJSInterface");
            this.f38507A = false;
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        FaqNoticeView faqNoticeView;
        FaqConstants.FaqErrorCode faqErrorCode;
        m52101R0();
        this.f38925a0 = new BadgeHelper(this);
        if (FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38511E.setVisibility(4);
            if (FaqWebActivityUtil.isUrl(this.f38508B)) {
                this.f38512F.setVisibility(4);
                if (this.f38508B.equals(this.f38511E.getUrl())) {
                    this.f38511E.reload();
                    return;
                } else if (FaqWebActivityUtil.isInWhiteList(this.f38508B, this)) {
                    this.f38511E.loadUrl(this.f38508B);
                    return;
                } else {
                    FaqWebActivityUtil.goToBrowserWebUrl(this, this.f38508B, true);
                    return;
                }
            }
            this.f38512F.setCallback(this.f38932h0);
            faqNoticeView = this.f38512F;
            faqErrorCode = FaqConstants.FaqErrorCode.LOAD_DATA_ERROR;
        } else {
            faqNoticeView = this.f38512F;
            faqErrorCode = FaqConstants.FaqErrorCode.INTERNET_ERROR;
        }
        faqNoticeView.m52468g(faqErrorCode);
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.f38511E;
        if (webView == null || !webView.canGoBack()) {
            finish();
            return;
        }
        this.f38511E.goBack();
        boolean zCanGoBack = this.f38511E.canGoBack();
        this.f38926b0 = false;
        if (zCanGoBack) {
            invalidateOptionsMenu();
            return;
        }
        this.f38927c0 = true;
        this.f38512F.setVisibility(8);
        invalidateOptionsMenu();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!NoDoubleClickUtil.isDoubleClick(view) && view.getId() == R$id.notice_view) {
            mo51677f();
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != getResources().getConfiguration().orientation) {
            FaqLanguageUtils.changeAppLanguage(this, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE), SdkFaqManager.getSdk().getSdk("country"), configuration);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        if (menuItem.getItemId() == R$id.faq_sdk_upload_log) {
            C8416f.m52390b(this);
            return true;
        }
        if (menuItem.getItemId() != R$id.faq_sdk_menu_sendto) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return false;
        }
        WebView webView = this.f38511E;
        if (webView != null && !TextUtils.isEmpty(webView.getTitle()) && !TextUtils.isEmpty(this.f38511E.getUrl())) {
            if (m51664F0()) {
                C8414d.m52381c(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), this, this.f38930f0, this.f38929e0);
            } else {
                FaqShareActivity.m52260p0(this, this.f38930f0, this.f38929e0, SdkFaqManager.getSdk().getSdk("country"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WECHATID), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WEIBOID), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_PICID), this.f38931g0);
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R$menu.faq_sdk_faq_web_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.faq_sdk_upload_log);
        MenuItem menuItemFindItem2 = menu.findItem(R$id.faq_sdk_menu_sendto);
        if (!this.f38926b0) {
            boolean z10 = this.f38927c0;
            menuItemFindItem2.setVisible(false);
            if (z10) {
                if (TextUtils.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH))) {
                    this.f38924Z = false;
                }
                menuItemFindItem.setVisible(this.f38924Z);
            }
            return super.onPrepareOptionsMenu(menu);
        }
        menuItemFindItem2.setVisible(true);
        menuItemFindItem.setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: z0 */
    public boolean mo51675z0(String str) throws Throwable {
        StringBuilder sb2;
        String str2;
        if (FaqWebActivityUtil.isUrl(str)) {
            if (FaqWebActivityUtil.isInWhiteList(str, this)) {
                return false;
            }
            FaqWebActivityUtil.goToBrowserWebUrl(this, str, false);
            return true;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "ActivityNotFoundException";
            sb2.append(str2);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("FaqCategoryWebActivity", sb2.toString());
            return true;
        } catch (IllegalArgumentException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "IllegalArgumentException";
            sb2.append(str2);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("FaqCategoryWebActivity", sb2.toString());
            return true;
        }
        return true;
    }
}
