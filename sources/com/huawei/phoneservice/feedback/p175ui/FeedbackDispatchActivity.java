package com.huawei.phoneservice.feedback.p175ui;

import android.R;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqOnDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.base.util.IntentCheckUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes5.dex */
public class FeedbackDispatchActivity extends FeedBaseActivity {

    /* renamed from: W */
    public static final FrameLayout.LayoutParams f39802W = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: X */
    public static final int f39803X = 2054;

    /* renamed from: D */
    public int f39805D;

    /* renamed from: G */
    public ViewGroup f39808G;

    /* renamed from: H */
    public WebView f39809H;

    /* renamed from: I */
    public ProgressBar f39810I;

    /* renamed from: J */
    public FeedbackNoticeView f39811J;

    /* renamed from: M */
    public boolean f39814M;

    /* renamed from: N */
    public ValueCallback<Uri[]> f39815N;

    /* renamed from: O */
    public ValueCallback<Uri> f39816O;

    /* renamed from: P */
    public C8546e f39817P;

    /* renamed from: Q */
    public WebChromeClient.CustomViewCallback f39818Q;

    /* renamed from: C */
    public Handler f39804C = new Handler();

    /* renamed from: E */
    public String f39806E = NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D;

    /* renamed from: F */
    public String f39807F = "com.huawei.gallery";

    /* renamed from: K */
    public String f39812K = null;

    /* renamed from: L */
    public String f39813L = null;

    /* renamed from: R */
    public Map<String, String> f39819R = new HashMap();

    /* renamed from: S */
    public Queue<String> f39820S = new LinkedList();

    /* renamed from: T */
    public WebChromeClient f39821T = new C8542a();

    /* renamed from: U */
    public WebViewClient f39822U = new C8543b();

    /* renamed from: V */
    public Runnable f39823V = new RunnableC8544c();

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDispatchActivity$a */
    public class C8542a extends WebChromeClient {
        public C8542a() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return new TextView(FeedbackDispatchActivity.this);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (FeedbackDispatchActivity.this.f39817P != null) {
                if (FeedbackDispatchActivity.this.f39818Q != null) {
                    FeedbackDispatchActivity.this.f39818Q.onCustomViewHidden();
                }
                FrameLayout frameLayout = (FrameLayout) FeedbackDispatchActivity.this.getWindow().getDecorView();
                FeedbackDispatchActivity.this.f39817P.removeAllViews();
                frameLayout.removeView(FeedbackDispatchActivity.this.f39817P);
                FeedbackDispatchActivity.this.f39817P = null;
                FeedbackDispatchActivity.this.setRequestedOrientation(1);
                FeedbackDispatchActivity.this.m52984H0(true);
                FeedbackDispatchActivity.this.f39809H.setVisibility(0);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            if (i10 > 10) {
                FeedbackDispatchActivity.this.f39809H.setVisibility(0);
            }
            if (FeedbackDispatchActivity.this.f39810I == null || FeedbackDispatchActivity.this.f39812K == null || !FeedbackDispatchActivity.this.f39812K.equals(webView.getUrl())) {
                return;
            }
            FeedbackDispatchActivity.this.f39810I.setProgress(i10, true);
            if (i10 >= 80) {
                FeedbackDispatchActivity.this.f39810I.setVisibility(8);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (!TextUtils.isEmpty(FeedbackDispatchActivity.this.f39813L) || TextUtils.isEmpty(str) || FeedbackDispatchActivity.this.f39814M) {
                return;
            }
            FeedbackDispatchActivity.this.setTitle(str);
            FeedbackDispatchActivity.this.f39819R.put(webView.getUrl(), str);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (FeedbackDispatchActivity.this.f39817P != null) {
                if (FeedbackDispatchActivity.this.f39818Q != null) {
                    FeedbackDispatchActivity.this.f39818Q.onCustomViewHidden();
                    return;
                }
                return;
            }
            FeedbackDispatchActivity.this.f39818Q = customViewCallback;
            FeedbackDispatchActivity.this.f39809H.setVisibility(8);
            FeedbackDispatchActivity.this.setRequestedOrientation(6);
            FeedbackDispatchActivity.this.m52984H0(false);
            FrameLayout frameLayout = (FrameLayout) FeedbackDispatchActivity.this.getWindow().getDecorView();
            FeedbackDispatchActivity.this.f39817P = new C8546e(FeedbackDispatchActivity.this);
            C8546e c8546e = FeedbackDispatchActivity.this.f39817P;
            FrameLayout.LayoutParams layoutParams = FeedbackDispatchActivity.f39802W;
            c8546e.addView(view, layoutParams);
            frameLayout.addView(FeedbackDispatchActivity.this.f39817P, layoutParams);
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) throws Throwable {
            if (FeedbackDispatchActivity.this.f39815N != null) {
                FeedbackDispatchActivity.this.f39815N.onReceiveValue(null);
                FeedbackDispatchActivity.this.f39815N = null;
            }
            FeedbackDispatchActivity.this.f39815N = valueCallback;
            Intent intentCreateGalleryIntent = IntentCheckUtils.createGalleryIntent(FeedbackDispatchActivity.this.getApplicationContext());
            if (intentCreateGalleryIntent == null) {
                FeedbackDispatchActivity.this.m52966e0("onShowFileChooser Fail");
                return false;
            }
            try {
                FeedbackDispatchActivity.this.startActivityForResult(intentCreateGalleryIntent, 100);
                return true;
            } catch (ActivityNotFoundException e10) {
                FeedbackDispatchActivity.this.f39815N = null;
                FaqLogger.m51842e("FeedDispatchActivity", e10);
                return false;
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDispatchActivity$b */
    public class C8543b extends WebViewClient {
        public C8543b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            FeedbackDispatchActivity feedbackDispatchActivity = FeedbackDispatchActivity.this;
            feedbackDispatchActivity.f39804C.removeCallbacks(feedbackDispatchActivity.f39823V);
            if (FeedbackDispatchActivity.this.f39810I != null && FeedbackDispatchActivity.this.f39812K != null && FeedbackDispatchActivity.this.f39812K.equals(str)) {
                FeedbackDispatchActivity.this.f39810I.setVisibility(8);
                FeedbackDispatchActivity.this.f39810I.setProgress(0);
            }
            if (FeedbackDispatchActivity.this.f39814M) {
                return;
            }
            FeedbackDispatchActivity.this.f39809H.setVisibility(0);
            FeedbackDispatchActivity.this.f39811J.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) throws Throwable {
            FeedbackDispatchActivity.this.f39814M = false;
            FeedbackDispatchActivity.this.f39812K = str;
            FeedbackDispatchActivity.this.m52989M0(str);
            super.onPageStarted(webView, str, bitmap);
            FeedbackDispatchActivity feedbackDispatchActivity = FeedbackDispatchActivity.this;
            feedbackDispatchActivity.f39804C.postDelayed(feedbackDispatchActivity.f39823V, 20000L);
            if (FeedbackDispatchActivity.this.f39810I != null) {
                FeedbackDispatchActivity.this.f39810I.setVisibility(0);
            }
            if (TextUtils.isEmpty(FeedbackDispatchActivity.this.f39813L)) {
                if (FeedbackDispatchActivity.this.f39819R.containsKey(str)) {
                    FeedbackDispatchActivity feedbackDispatchActivity2 = FeedbackDispatchActivity.this;
                    feedbackDispatchActivity2.setTitle((CharSequence) feedbackDispatchActivity2.f39819R.get(str));
                    return;
                }
                String title = webView.getTitle();
                if (!TextUtils.isEmpty(title) && webView.getUrl() != null && !webView.getUrl().contains(title)) {
                    FeedbackDispatchActivity.this.f39819R.put(webView.getUrl(), title);
                    FeedbackDispatchActivity.this.setTitle(title);
                    return;
                }
                try {
                    FeedbackDispatchActivity feedbackDispatchActivity3 = FeedbackDispatchActivity.this;
                    feedbackDispatchActivity3.setTitle(feedbackDispatchActivity3.getResources().getString(R$string.feedback_sdk_common_loading));
                } catch (Resources.NotFoundException e10) {
                    FaqLogger.m51840e("FeedDispatchActivity", e10.getMessage());
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) throws Throwable {
            super.onReceivedError(webView, i10, str, str2);
            FeedbackDispatchActivity.this.f39814M = true;
            if (TextUtils.isEmpty(FeedbackDispatchActivity.this.f39813L)) {
                FeedbackDispatchActivity.this.setTitle("");
            }
            FeedbackDispatchActivity.this.f39811J.m53143g(FaqCommonUtils.isConnectionAvailable(FeedbackDispatchActivity.this) ? FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR : FaqConstants.FaqErrorCode.INTERNET_ERROR);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) throws Throwable {
            if (FaqWebActivityUtil.isInWhiteList(str, FeedbackDispatchActivity.this)) {
                return false;
            }
            FaqWebActivityUtil.goToBrowserWebUrl(FeedbackDispatchActivity.this, str, false);
            return true;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDispatchActivity$c */
    public class RunnableC8544c implements Runnable {
        public RunnableC8544c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            FeedbackDispatchActivity feedbackDispatchActivity = FeedbackDispatchActivity.this;
            Handler handler = feedbackDispatchActivity.f39804C;
            if (handler != null) {
                handler.removeCallbacks(feedbackDispatchActivity.f39823V);
            }
            FeedbackDispatchActivity.this.m52998T0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDispatchActivity$d */
    public class ViewOnClickListenerC8545d implements View.OnClickListener {
        public ViewOnClickListenerC8545d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqOnDoubleClickUtil.conClick(view);
            FeedbackDispatchActivity feedbackDispatchActivity = FeedbackDispatchActivity.this;
            feedbackDispatchActivity.f39804C.removeCallbacks(feedbackDispatchActivity.f39823V);
            FeedbackDispatchActivity.this.f39809H.clearView();
            FeedbackDispatchActivity.this.f39809H.removeAllViews();
            FeedbackDispatchActivity.this.mo52896j0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDispatchActivity$e */
    public static class C8546e extends FrameLayout {
        public C8546e(Context context) {
            super(context);
            setBackgroundResource(R.color.black);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m52984H0(boolean z10) {
        getWindow().getDecorView().setSystemUiVisibility(z10 ? this.f39805D : f39803X);
        getWindow().setFlags(z10 ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0 */
    public void m52989M0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f39809H.getSettings().setJavaScriptEnabled(false);
            this.f39814M = true;
        } else {
            this.f39809H.getSettings().setJavaScriptEnabled(true);
            FaqWebActivityUtil.removeWebViewJavascriptInterface(this.f39809H);
            this.f39814M = false;
        }
    }

    /* renamed from: S0 */
    private void m52995S0() {
        WebSettings settings = this.f39809H.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        FaqWebActivityUtil.initWebView(this.f39809H);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        this.f39809H.setHorizontalScrollBarEnabled(false);
        this.f39809H.setWebViewClient(this.f39822U);
        this.f39809H.setWebChromeClient(this.f39821T);
    }

    /* renamed from: V */
    private void m52996V() throws Throwable {
        this.f39814M = false;
        this.f39812K = null;
        this.f39813L = null;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            if (!TextUtils.isEmpty(safeIntent.getStringExtra("url"))) {
                this.f39812K = safeIntent.getStringExtra("url");
            }
            if (safeIntent.getIntExtra("title", 0) != 0) {
                this.f39813L = getResources().getString(safeIntent.getIntExtra("title", 0));
            }
            if (!TextUtils.isEmpty(this.f39813L) || TextUtils.isEmpty(safeIntent.getStringExtra("title"))) {
                return;
            }
            this.f39813L = safeIntent.getStringExtra("title");
        } catch (Resources.NotFoundException | ClassCastException e10) {
            FaqLogger.m51840e("FeedDispatchActivity", e10.getMessage());
        }
    }

    /* renamed from: T0 */
    public void m52998T0() throws Throwable {
        FaqLogger.m51846i("FeedDispatchActivity", "onPageTimeOut :" + this.f39812K);
    }

    /* renamed from: U0 */
    public void m52999U0() {
        Queue<String> queue = this.f39820S;
        if (queue == null || queue.size() <= 0) {
            return;
        }
        String strPoll = this.f39820S.poll();
        this.f39813L = strPoll;
        setTitle(strPoll);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_dispatch_layout;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        String[] feedbackOpenTypeConfig = ModuleConfigUtils.getFeedbackOpenTypeConfig();
        String str = feedbackOpenTypeConfig[0];
        String str2 = feedbackOpenTypeConfig[1];
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f39811J.m53143g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            return;
        }
        if (FaqConstants.OPEN_TYPE_OUT.equals(str)) {
            if (!FaqStringUtil.isEmpty(str2)) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    FaqLogger.print("FeedDispatchActivity", "startActivity Exception");
                }
            }
            finish();
            return;
        }
        if (!FaqConstants.OPEN_TYPE_IN.equals(str) || FaqStringUtil.isEmpty(str2)) {
            return;
        }
        if (FaqWebActivityUtil.isInWhiteList(str2, this)) {
            this.f39809H.loadUrl(str2);
        } else {
            FaqWebActivityUtil.goToBrowserWebUrl(this, str2, true);
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39811J.setOnClickListener(new ViewOnClickListenerC8545d());
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        this.f39808G = (ViewGroup) findViewById(R.id.content);
        this.f39809H = (WebView) findViewById(R$id.feedback_dispatch_web_view);
        this.f39810I = (ProgressBar) findViewById(R$id.fbsdkProgressbar);
        this.f39811J = (FeedbackNoticeView) findViewById(R$id.feedback_dispatch_noticeView);
        m52995S0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @TargetApi(21)
    public void onActivityResult(int i10, int i11, Intent intent) {
        ValueCallback<Uri[]> valueCallback;
        ValueCallback<Uri[]> valueCallback2;
        super.onActivityResult(i10, i11, intent);
        if (intent != null) {
            if (i10 == 0) {
                if (this.f39816O != null) {
                    this.f39816O.onReceiveValue(i11 == -1 ? new SafeIntent(intent).getData() : null);
                    this.f39816O = null;
                    return;
                }
                return;
            }
            if (i10 != 100 || (valueCallback = this.f39815N) == null) {
                return;
            }
            valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i11, intent));
            this.f39815N = null;
        }
        if (i10 == 0) {
            ValueCallback<Uri> valueCallback3 = this.f39816O;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(null);
                this.f39816O = null;
                return;
            }
            return;
        }
        if (i10 != 100 || (valueCallback2 = this.f39815N) == null) {
            return;
        }
        valueCallback2.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i11, null));
        this.f39815N = null;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        m52996V();
        if (!TextUtils.isEmpty(this.f39813L)) {
            setTitle(this.f39813L);
        }
        super.onCreate(bundle);
        this.f39805D = getWindow().getDecorView().getSystemUiVisibility();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws Throwable {
        if (this.f39809H != null) {
            this.f39804C.removeCallbacks(this.f39823V);
            if (this.f39809H.getParent() != null) {
                this.f39808G.removeView(this.f39809H);
            }
        }
        FaqWebActivityUtil.destroyWeb(this.f39809H);
        Window window = getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            if (decorView instanceof ViewGroup) {
                ((ViewGroup) decorView).removeAllViews();
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !this.f39809H.canGoBack()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.f39814M) {
            this.f39809H.setVisibility(8);
            this.f39809H.clearView();
            this.f39809H.removeAllViews();
            this.f39811J.setVisibility(8);
        }
        this.f39809H.goBack();
        m52999U0();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        WebView webView = this.f39809H;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        setTitle(getTitle());
        super.onResume();
        WebView webView = this.f39809H;
        if (webView != null) {
            webView.onResume();
        }
    }
}
