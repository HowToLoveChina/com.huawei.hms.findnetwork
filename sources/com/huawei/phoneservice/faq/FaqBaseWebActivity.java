package com.huawei.phoneservice.faq;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.base.util.IntentCheckUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.utils.C8417g;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes4.dex */
public abstract class FaqBaseWebActivity extends FaqBaseActivity {

    /* renamed from: C */
    public C8272d f38509C;

    /* renamed from: E */
    public WebView f38511E;

    /* renamed from: F */
    public FaqNoticeView f38512F;

    /* renamed from: H */
    public ProgressBar f38514H;

    /* renamed from: J */
    public ViewGroup f38516J;

    /* renamed from: K */
    public ValueCallback<Uri> f38517K;

    /* renamed from: L */
    public ValueCallback<Uri[]> f38518L;

    /* renamed from: M */
    public FullscreenHolder f38519M;

    /* renamed from: N */
    public WebChromeClient.CustomViewCallback f38520N;

    /* renamed from: P */
    public int f38522P;

    /* renamed from: W */
    public static final FrameLayout.LayoutParams f38506W = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: V */
    public static final int f38505V = 2054;

    /* renamed from: A */
    public boolean f38507A = false;

    /* renamed from: B */
    public String f38508B = null;

    /* renamed from: D */
    public String f38510D = null;

    /* renamed from: G */
    public Handler f38513G = new Handler();

    /* renamed from: I */
    public Queue<String> f38515I = new LinkedList();

    /* renamed from: O */
    public Map<String, String> f38521O = new HashMap();

    /* renamed from: Q */
    public String f38523Q = NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D;

    /* renamed from: R */
    public String f38524R = "com.huawei.gallery";

    /* renamed from: S */
    public Runnable f38525S = new RunnableC8269a();

    /* renamed from: T */
    public WebChromeClient f38526T = new WebChromeClient() { // from class: com.huawei.phoneservice.faq.FaqBaseWebActivity.2
        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return new TextView(FaqBaseWebActivity.this);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (FaqBaseWebActivity.this.f38519M != null) {
                if (FaqBaseWebActivity.this.f38520N != null) {
                    FaqBaseWebActivity.this.f38520N.onCustomViewHidden();
                }
                FrameLayout frameLayout = (FrameLayout) FaqBaseWebActivity.this.getWindow().getDecorView();
                FaqBaseWebActivity.this.f38519M.removeAllViews();
                frameLayout.removeView(FaqBaseWebActivity.this.f38519M);
                FaqBaseWebActivity.this.f38519M = null;
                FaqBaseWebActivity.this.setRequestedOrientation(1);
                FaqBaseWebActivity.this.m51651a(true);
                FaqBaseWebActivity.this.f38511E.setVisibility(0);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            String str;
            super.onProgressChanged(webView, i10);
            FaqBaseWebActivity.this.mo51669b(i10);
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            if (faqBaseWebActivity.f38514H == null || (str = faqBaseWebActivity.f38508B) == null || !str.equals(webView.getUrl())) {
                return;
            }
            FaqBaseWebActivity.this.f38514H.setProgress(i10, true);
            if (i10 >= 80) {
                FaqBaseWebActivity.this.f38514H.setVisibility(8);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (!TextUtils.isEmpty(FaqBaseWebActivity.this.f38510D) || TextUtils.isEmpty(str)) {
                return;
            }
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            if (faqBaseWebActivity.f38507A) {
                return;
            }
            faqBaseWebActivity.setTitle(str);
            FaqBaseWebActivity.this.f38521O.put(webView.getUrl(), str);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (FaqBaseWebActivity.this.f38519M != null) {
                if (FaqBaseWebActivity.this.f38520N != null) {
                    FaqBaseWebActivity.this.f38520N.onCustomViewHidden();
                    return;
                }
                return;
            }
            FaqBaseWebActivity.this.f38511E.setVisibility(8);
            FaqBaseWebActivity.this.f38520N = customViewCallback;
            FaqBaseWebActivity.this.setRequestedOrientation(6);
            FaqBaseWebActivity.this.m51651a(false);
            FrameLayout frameLayout = (FrameLayout) FaqBaseWebActivity.this.getWindow().getDecorView();
            FaqBaseWebActivity.this.f38519M = new FullscreenHolder(FaqBaseWebActivity.this);
            FullscreenHolder fullscreenHolder = FaqBaseWebActivity.this.f38519M;
            FrameLayout.LayoutParams layoutParams = FaqBaseWebActivity.f38506W;
            fullscreenHolder.addView(view, layoutParams);
            frameLayout.addView(FaqBaseWebActivity.this.f38519M, layoutParams);
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) throws Throwable {
            if (FaqBaseWebActivity.this.f38518L != null) {
                FaqBaseWebActivity.this.f38518L.onReceiveValue(null);
                FaqBaseWebActivity.this.f38518L = null;
            }
            FaqBaseWebActivity.this.f38518L = valueCallback;
            Intent intentCreateGalleryIntent = IntentCheckUtils.createGalleryIntent(FaqBaseWebActivity.this.getApplicationContext());
            if (intentCreateGalleryIntent == null) {
                FaqLogger.m51840e("FaqBaseWebActivity", "GalleryIntent is null");
                FaqBaseWebActivity.this.m52015a("onShowFileChooserFail");
                return false;
            }
            try {
                FaqBaseWebActivity.this.startActivityForResult(intentCreateGalleryIntent, 100);
                return true;
            } catch (ActivityNotFoundException e10) {
                FaqBaseWebActivity.this.f38518L = null;
                FaqLogger.m51842e("FaqBaseWebActivity", e10);
                return false;
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) throws Throwable {
            FaqBaseWebActivity.this.f38517K = valueCallback;
            Intent intentCreateGalleryIntent = IntentCheckUtils.createGalleryIntent(FaqBaseWebActivity.this.getApplicationContext());
            if (intentCreateGalleryIntent == null) {
                FaqLogger.m51840e("FaqBaseWebActivity", "GalleryIntent is null");
                FaqBaseWebActivity.this.m52015a("openFileChooserFail");
            } else {
                try {
                    FaqBaseWebActivity.this.startActivityForResult(Intent.createChooser(intentCreateGalleryIntent, "choose image"), 0);
                } catch (ActivityNotFoundException unused) {
                    FaqLogger.m51840e("FaqBaseWebActivity", "choose image openFileChooser failed");
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) throws Throwable {
            FaqBaseWebActivity.this.f38517K = valueCallback;
            Intent intentCreateGalleryIntent = IntentCheckUtils.createGalleryIntent(FaqBaseWebActivity.this.getApplicationContext());
            if (intentCreateGalleryIntent == null) {
                FaqLogger.m51840e("FaqBaseWebActivity", "GalleryIntent is null");
                FaqBaseWebActivity.this.m52015a("openFileChooserAcceptTypeFail");
            } else {
                try {
                    FaqBaseWebActivity.this.startActivityForResult(Intent.createChooser(intentCreateGalleryIntent, "choose image"), 0);
                } catch (ActivityNotFoundException unused) {
                    FaqLogger.m51840e("FaqBaseWebActivity", "choose image openFileChooser failed");
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) throws Throwable {
            FaqBaseWebActivity.this.f38517K = valueCallback;
            Intent intentCreateGalleryIntent = IntentCheckUtils.createGalleryIntent(FaqBaseWebActivity.this.getApplicationContext());
            if (intentCreateGalleryIntent == null) {
                FaqLogger.m51840e("FaqBaseWebActivity", "GalleryIntent is null");
                FaqBaseWebActivity.this.m52015a("openFileChooserCaptureFail");
            } else {
                try {
                    FaqBaseWebActivity.this.startActivityForResult(Intent.createChooser(intentCreateGalleryIntent, "choose image"), 0);
                } catch (ActivityNotFoundException unused) {
                    FaqLogger.m51840e("FaqBaseWebActivity", "choose image openFileChooser failed");
                }
            }
        }
    };

    /* renamed from: U */
    public WebViewClient f38527U = new C8270b();

    public static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundResource(R.color.black);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.FaqBaseWebActivity$a */
    public class RunnableC8269a implements Runnable {
        public RunnableC8269a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            Handler handler = faqBaseWebActivity.f38513G;
            if (handler != null) {
                handler.removeCallbacks(faqBaseWebActivity.f38525S);
            }
            FaqBaseWebActivity.this.m51666H0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.FaqBaseWebActivity$b */
    public class C8270b extends WebViewClient {
        public C8270b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String str2;
            super.onPageFinished(webView, str);
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            faqBaseWebActivity.f38513G.removeCallbacks(faqBaseWebActivity.f38525S);
            FaqBaseWebActivity faqBaseWebActivity2 = FaqBaseWebActivity.this;
            if (faqBaseWebActivity2.f38514H != null && (str2 = faqBaseWebActivity2.f38508B) != null && str2.equals(str)) {
                FaqBaseWebActivity.this.f38514H.setVisibility(8);
                FaqBaseWebActivity.this.f38514H.setProgress(0);
            }
            FaqBaseWebActivity faqBaseWebActivity3 = FaqBaseWebActivity.this;
            if (!faqBaseWebActivity3.f38507A) {
                faqBaseWebActivity3.f38511E.setVisibility(0);
                FaqBaseWebActivity.this.f38512F.setVisibility(8);
            }
            FaqBaseWebActivity.this.mo51665G0();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            faqBaseWebActivity.f38507A = false;
            faqBaseWebActivity.f38508B = str;
            faqBaseWebActivity.mo51670b(str);
            super.onPageStarted(webView, str, bitmap);
            FaqBaseWebActivity faqBaseWebActivity2 = FaqBaseWebActivity.this;
            faqBaseWebActivity2.f38513G.postDelayed(faqBaseWebActivity2.f38525S, 20000L);
            ProgressBar progressBar = FaqBaseWebActivity.this.f38514H;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            if (TextUtils.isEmpty(FaqBaseWebActivity.this.f38510D)) {
                if (FaqBaseWebActivity.this.f38521O.containsKey(str)) {
                    FaqBaseWebActivity faqBaseWebActivity3 = FaqBaseWebActivity.this;
                    faqBaseWebActivity3.setTitle((CharSequence) faqBaseWebActivity3.f38521O.get(str));
                    return;
                }
                String title = webView.getTitle();
                if (!TextUtils.isEmpty(title) && webView.getUrl() != null && !webView.getUrl().contains(title)) {
                    FaqBaseWebActivity.this.f38521O.put(webView.getUrl(), title);
                    FaqBaseWebActivity.this.setTitle(title);
                } else {
                    try {
                        FaqBaseWebActivity faqBaseWebActivity4 = FaqBaseWebActivity.this;
                        faqBaseWebActivity4.setTitle(faqBaseWebActivity4.getResources().getString(R$string.faq_sdk_common_loading));
                    } catch (Exception unused) {
                        Log.e("FaqBaseWebActivity", "NotFoundException");
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            faqBaseWebActivity.f38507A = true;
            if (TextUtils.isEmpty(faqBaseWebActivity.f38510D)) {
                FaqBaseWebActivity.this.setTitle("");
            }
            FaqBaseWebActivity.this.f38512F.m52468g(FaqCommonUtils.isConnectionAvailable(FaqBaseWebActivity.this) ? FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR : FaqConstants.FaqErrorCode.INTERNET_ERROR);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            FaqWebActivityUtil.onReceivedSslError(sslErrorHandler);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return FaqBaseWebActivity.this.mo51675z0(str);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.FaqBaseWebActivity$c */
    public class ViewOnClickListenerC8271c implements View.OnClickListener {
        public ViewOnClickListenerC8271c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqBaseWebActivity faqBaseWebActivity = FaqBaseWebActivity.this;
            faqBaseWebActivity.f38513G.removeCallbacks(faqBaseWebActivity.f38525S);
            FaqBaseWebActivity.this.f38511E.clearView();
            FaqBaseWebActivity.this.f38511E.removeAllViews();
            FaqBaseWebActivity.this.mo51677f();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.FaqBaseWebActivity$d */
    public static final class C8272d {

        /* renamed from: a */
        public WeakReference<Activity> f38531a;

        public C8272d(Activity activity) {
            this.f38531a = new WeakReference<>(activity);
        }

        @JavascriptInterface
        public void returnMainActivity() {
            Activity activity;
            WeakReference<Activity> weakReference = this.f38531a;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.finish();
        }

        @JavascriptInterface
        public void runBackKey(String str) {
            WeakReference<Activity> weakReference;
            Activity activity;
            if ("N".equals(str) || (weakReference = this.f38531a) == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m51651a(boolean z10) {
        getWindow().getDecorView().setSystemUiVisibility(z10 ? this.f38522P : f38505V);
        getWindow().setFlags(z10 ? 0 : 1024, 1024);
    }

    /* renamed from: s0 */
    private void m51656s0(int i10, int i11) {
        ValueCallback<Uri[]> valueCallback;
        if (i10 == 0) {
            ValueCallback<Uri> valueCallback2 = this.f38517K;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
                this.f38517K = null;
                return;
            }
            return;
        }
        if (i10 != 100 || (valueCallback = this.f38518L) == null) {
            return;
        }
        valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i11, null));
        this.f38518L = null;
    }

    /* renamed from: B0 */
    public void m51661B0(String str) throws Throwable {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            FaqLogger.m51840e("FaqBaseWebActivity", "startActivity Exception");
        }
        finish();
    }

    /* renamed from: D0 */
    public void m51662D0(String str) throws Throwable {
        if (str != null) {
            try {
                str = URLDecoder.decode(str, Constants.UTF_8);
            } catch (UnsupportedEncodingException e10) {
                FaqLogger.m51840e("FaqBaseWebActivity", e10.getMessage());
            }
            if (C8417g.m52397c(this)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str.contains(Constants.QUESTION_STR) ? "&" : Constants.QUESTION_STR);
                sb2.append("Hicare_Theme=DARK&themeName=dark");
                str = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(str.contains(Constants.QUESTION_STR) ? "&" : Constants.QUESTION_STR);
            sb3.append("lang=");
            sb3.append(FaqLanguageUtils.getLanguage());
            str = sb3.toString();
        }
        if (FaqWebActivityUtil.isInWhiteList(str, this)) {
            this.f38511E.loadUrl(str);
        } else {
            m51661B0(str);
        }
    }

    /* renamed from: E0 */
    public void mo51663E0() {
        WebSettings settings = this.f38511E.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        FaqWebActivityUtil.initWebView(this.f38511E);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        this.f38511E.setHorizontalScrollBarEnabled(false);
        this.f38511E.setWebViewClient(this.f38527U);
        this.f38511E.setWebChromeClient(this.f38526T);
        this.f38511E.setBackgroundColor(0);
    }

    /* renamed from: F0 */
    public boolean m51664F0() throws Throwable {
        String str;
        if (!"CN".equals(SdkFaqManager.getSdk().getSdk("country"))) {
            str = "share to other because countryCode is " + SdkFaqManager.getSdk().getSdk("country");
        } else {
            if (!TextUtils.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WECHATID)) || !TextUtils.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WEIBOID))) {
                return false;
            }
            str = "share to other because both weChatId and weiboId are empty. ";
        }
        FaqLogger.m51836d("FaqBaseWebActivity", str);
        return true;
    }

    /* renamed from: G0 */
    public abstract void mo51665G0();

    /* renamed from: H0 */
    public void m51666H0() throws Throwable {
        FaqLogger.m51846i("FaqBaseWebActivity", "onPageTimeOut :" + this.f38508B);
    }

    /* renamed from: I0 */
    public void m51667I0() {
        Queue<String> queue = this.f38515I;
        if (queue == null || queue.size() <= 0) {
            return;
        }
        String strPoll = this.f38515I.poll();
        this.f38510D = strPoll;
        setTitle(strPoll);
    }

    /* renamed from: V */
    public void mo51668V() {
        this.f38507A = false;
        this.f38508B = null;
        this.f38510D = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("url"))) {
                this.f38508B = intent.getStringExtra("url");
            }
            try {
                if (intent.getIntExtra("title", 0) != 0) {
                    this.f38510D = getResources().getString(intent.getIntExtra("title", 0));
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(this.f38510D) || TextUtils.isEmpty(intent.getStringExtra("title"))) {
                return;
            }
            this.f38510D = intent.getStringExtra("title");
        }
    }

    /* renamed from: b */
    public abstract void mo51669b(int i10);

    /* renamed from: b */
    public abstract void mo51670b(String str);

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        FaqNoticeView faqNoticeView = this.f38512F;
        if (faqNoticeView != null) {
            faqNoticeView.setOnClickListener(new ViewOnClickListenerC8271c());
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        this.f38516J = (ViewGroup) findViewById(R.id.content);
        this.f38512F = (FaqNoticeView) findViewById(R$id.notice_view);
        this.f38514H = (ProgressBar) findViewById(R$id.wvProgressbar);
        this.f38511E = (WebView) findViewById(R$id.common_web_view);
        this.f38509C = new C8272d(this);
        mo51663E0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @TargetApi(21)
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (intent == null) {
            m51656s0(i10, i11);
        } else {
            m51673t0(i10, i11, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.f38511E.canGoBack()) {
            super.onBackPressed();
            return;
        }
        if (this.f38507A) {
            this.f38511E.setVisibility(8);
            this.f38511E.clearView();
            this.f38511E.removeAllViews();
            this.f38512F.setVisibility(8);
        }
        this.f38511E.goBack();
        m51667I0();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        mo51668V();
        if (!TextUtils.isEmpty(this.f38510D)) {
            setTitle(this.f38510D);
        }
        super.onCreate(bundle);
        this.f38522P = getWindow().getDecorView().getSystemUiVisibility();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        View decorView;
        if (this.f38511E != null) {
            this.f38513G.removeCallbacks(this.f38525S);
            if (this.f38511E.getParent() != null) {
                this.f38516J.removeView(this.f38511E);
            }
        }
        FaqWebActivityUtil.destroyWeb(this.f38511E);
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (decorView instanceof ViewGroup)) {
            ((ViewGroup) decorView).removeAllViews();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !this.f38511E.canGoBack()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.f38507A) {
            this.f38511E.setVisibility(8);
            this.f38511E.clearView();
            this.f38511E.removeAllViews();
            this.f38512F.setVisibility(8);
        }
        this.f38511E.goBack();
        m51667I0();
        return true;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        String str = this.f38510D;
        if (str != null) {
            this.f38515I.add(str);
        }
        mo51668V();
        mo51671h0();
        mo51677f();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        WebView webView = this.f38511E;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WebView webView = this.f38511E;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* renamed from: t0 */
    public final void m51673t0(int i10, int i11, Intent intent) {
        if (i10 == 0) {
            if (this.f38517K == null) {
                return;
            }
            this.f38517K.onReceiveValue(i11 == -1 ? intent.getData() : null);
            this.f38517K = null;
            return;
        }
        if (i10 != 100 || this.f38518L == null) {
            return;
        }
        if (FaqWebActivityUtil.isSafeImagePath(getApplicationContext(), intent.getData())) {
            this.f38518L.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i11, intent));
        } else {
            this.f38518L.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i11, null));
        }
        this.f38518L = null;
    }

    /* renamed from: u0 */
    public void m51674u0(WebView webView) {
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        if (hitTestResult == null || hitTestResult.getType() != 7) {
            return;
        }
        this.f38507A = false;
    }

    /* renamed from: z0 */
    public abstract boolean mo51675z0(String str);
}
