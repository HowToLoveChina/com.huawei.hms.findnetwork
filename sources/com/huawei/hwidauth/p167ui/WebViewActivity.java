package com.huawei.hwidauth.p167ui;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.hms.hwid.R$color;
import com.huawei.android.hms.hwid.R$drawable;
import com.huawei.android.hms.hwid.R$id;
import com.huawei.android.hms.hwid.R$layout;
import com.huawei.android.hms.hwid.R$string;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.common.utils.PresetUtil;
import com.huawei.hms.common.utils.UriCheckUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hwcloudjs.p165g.C6664a;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.secure.android.common.activity.SafeActivity;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.modelmsg.SendAuth;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import com.tencent.p204mm.opensdk.openapi.WXAPIFactory;
import hu.C10343b;
import iq.C10587a;
import iq.C10594h;
import iq.C10599m;
import iq.C10600n;
import iq.C10601o;
import iq.InterfaceC10595i;
import iq.InterfaceC10596j;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lu.C11342a;
import lu.C11347f;
import org.json.JSONException;
import org.json.JSONObject;
import p460lq.C11335b;
import p497nq.C11742a;
import p497nq.InterfaceC11743b;
import p530oq.C11988a;
import p587qq.AbstractC12388f;
import p587qq.AsyncTaskC12383a;
import p587qq.InterfaceC12384b;
import p621rq.AbstractC12615a;
import p640sq.C12824c;
import p640sq.C12827f;
import p640sq.C12828g;
import p640sq.C12829h;
import p640sq.C12830i;
import p640sq.C12831j;
import p640sq.C12836o;
import p640sq.C12838q;
import p640sq.C12839r;
import p640sq.C12841t;
import p640sq.C12844w;
import p640sq.C12845x;
import p658tq.C13056a;

/* loaded from: classes8.dex */
public class WebViewActivity extends SafeActivity implements InterfaceC11743b, InterfaceC6722g {

    /* renamed from: b */
    public SafeWebView f31038b;

    /* renamed from: d */
    public ProgressBar f31040d;

    /* renamed from: e */
    public RelativeLayout f31041e;

    /* renamed from: h */
    public ActionBar f31044h;

    /* renamed from: j */
    public C6723h f31046j;

    /* renamed from: k */
    public C12828g f31047k;

    /* renamed from: n */
    public ValueCallback<?> f31050n;

    /* renamed from: o */
    public Uri f31051o;

    /* renamed from: p */
    public int f31052p;

    /* renamed from: q */
    public AlertDialog f31053q;

    /* renamed from: r */
    public AlertDialog f31054r;

    /* renamed from: s */
    public AlertDialog f31055s;

    /* renamed from: t */
    public PermissionRequest f31056t;

    /* renamed from: u */
    public String f31057u;

    /* renamed from: c */
    public TextView f31039c = null;

    /* renamed from: f */
    public String f31042f = "0";

    /* renamed from: g */
    public String f31043g = "";

    /* renamed from: i */
    public List<String> f31045i = new ArrayList();

    /* renamed from: l */
    public boolean f31048l = false;

    /* renamed from: m */
    public boolean f31049m = false;

    /* renamed from: v */
    public Handler f31058v = new HandlerC6710k(Looper.getMainLooper());

    public class AuthWebChromeClient extends WebChromeClient {

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$AuthWebChromeClient$a */
        public class RunnableC6699a implements Runnable {
            public RunnableC6699a() {
            }

            @Override // java.lang.Runnable
            @TargetApi(21)
            public void run() {
                if (WebViewActivity.this.m38122i()) {
                    WebViewActivity.this.f31046j.m38249x(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
                } else {
                    WebViewActivity.this.f31056t.grant(WebViewActivity.this.f31056t.getResources());
                }
            }
        }

        private AuthWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            C12836o.m77097b("WebViewActivity", "onConsoleMessage: message = " + consoleMessage.message(), false);
            C12836o.m77097b("WebViewActivity", "onConsoleMessage: sourceId = " + consoleMessage.sourceId(), false);
            C12836o.m77097b("WebViewActivity", "onConsoleMessage: lineNumber = " + consoleMessage.lineNumber(), false);
            C12836o.m77097b("WebViewActivity", "onConsoleMessage: messageLevel = " + consoleMessage.messageLevel(), false);
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            try {
                C12836o.m77097b("WebViewActivity", "onPermissionRequest:" + Arrays.toString(permissionRequest.getResources()), true);
                WebViewActivity.this.f31056t = permissionRequest;
                for (String str : permissionRequest.getResources()) {
                    if ("android.webkit.resource.VIDEO_CAPTURE".equals(str)) {
                        WebViewActivity.this.runOnUiThread(new RunnableC6699a());
                        return;
                    }
                }
            } catch (NullPointerException e10) {
                C12836o.m77097b("WebViewActivity", "openFileChooser  e" + e10.getClass().getSimpleName(), true);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            if (WebViewActivity.this.f31040d == null) {
                C12836o.m77099d("WebViewActivity", "mProgressBar is null.", true);
                return;
            }
            WebViewActivity.this.f31040d.setProgress(i10);
            if (i10 == 100) {
                WebViewActivity.this.f31040d.setVisibility(8);
            } else {
                WebViewActivity.this.f31040d.setVisibility(0);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            C12836o.m77097b("WebViewActivity", "enter onReceivedTitle", true);
            C12836o.m77097b("WebViewActivity", "enter onReceivedTitle : " + str, false);
            String str2 = " ";
            if (TextUtils.isEmpty(str)) {
                str = " ";
            }
            if (!str.startsWith("http")) {
                str2 = str;
            } else if ("from_other_app_signin".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) {
                WebViewActivity.this.m38123i0(" ");
            }
            if (webView.getUrl() == null || str2.equalsIgnoreCase(FeedbackWebConstants.AUTHORIZATION)) {
                return;
            }
            C12836o.m77097b("WebViewActivity", "url:" + webView.getUrl(), false);
            WebViewActivity.this.m38123i0(str2);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) throws IllegalAccessException, IllegalArgumentException {
            C12836o.m77097b("WebViewActivity", "onShowFileChooser For Android > 5.0 " + Build.VERSION.SDK_INT, true);
            WebViewActivity.this.f31050n = valueCallback;
            if (!WebViewActivity.this.f31046j.m38219h0()) {
                WebViewActivity.this.f31052p = 1002;
                C12836o.m77097b("WebViewActivity", "onShowFileChooser showChoosePicDialog", true);
                WebViewActivity.this.m38066a(1002);
                return true;
            }
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.m38130n0(webViewActivity.getString(R$string.hwid_string_not_support_split));
            if (valueCallback != null) {
                try {
                    valueCallback.onReceiveValue(new Uri[0]);
                } catch (Exception e10) {
                    C12836o.m77097b("WebViewActivity", "openFileChooser  e" + e10.getClass().getSimpleName(), true);
                }
            }
            C12836o.m77097b("WebViewActivity", "onShowFileChooser return", true);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) throws IllegalAccessException, IllegalArgumentException {
            C12836o.m77097b("WebViewActivity", " openFileChooser < 3.0 " + Build.VERSION.SDK_INT, true);
            WebViewActivity.this.m38136t(valueCallback);
        }

        public /* synthetic */ AuthWebChromeClient(WebViewActivity webViewActivity, ViewOnClickListenerC6704e viewOnClickListenerC6704e) {
            this();
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) throws IllegalAccessException, IllegalArgumentException {
            C12836o.m77097b("WebViewActivity", "openFileChooser For Android 3.0+ " + Build.VERSION.SDK_INT, true);
            WebViewActivity.this.m38136t(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) throws IllegalAccessException, IllegalArgumentException {
            C12836o.m77097b("WebViewActivity", "openFileChooser For Android > 4.1 " + Build.VERSION.SDK_INT, true);
            if (WebViewActivity.this.f31046j.m38219h0()) {
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.m38130n0(webViewActivity.getString(R$string.hwid_string_not_support_split));
                if (valueCallback != null) {
                    try {
                        valueCallback.onReceiveValue(null);
                        return;
                    } catch (Exception e10) {
                        C12836o.m77097b("WebViewActivity", "openFileChooser  e" + e10.getClass().getSimpleName(), true);
                        return;
                    }
                }
                return;
            }
            WebViewActivity.this.m38136t(valueCallback);
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$a */
    public class RunnableC6700a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31061a;

        public RunnableC6700a(String str) {
            this.f31061a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WebViewActivity.this.f31038b != null) {
                WebViewActivity.this.f31038b.loadUrl(this.f31061a);
            }
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$b */
    public class RunnableC6701b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31063a;

        /* renamed from: b */
        public final /* synthetic */ String f31064b;

        /* renamed from: c */
        public final /* synthetic */ String f31065c;

        public RunnableC6701b(String str, String str2, String str3) {
            this.f31063a = str;
            this.f31064b = str2;
            this.f31065c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.m38084B(webViewActivity.f31038b, this.f31063a, C12824c.m77005h(WebViewActivity.this.f31046j.m38182D(this.f31064b, this.f31065c)));
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$c */
    public class RunnableC6702c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31067a;

        /* renamed from: b */
        public final /* synthetic */ String f31068b;

        public RunnableC6702c(String str, String str2) {
            this.f31067a = str;
            this.f31068b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewActivity.this.f31038b.postUrl(this.f31067a, C12824c.m77005h(WebViewActivity.this.f31046j.m38182D("-1", this.f31068b)));
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$d */
    public class RunnableC6703d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f31070a;

        /* renamed from: b */
        public final /* synthetic */ String f31071b;

        public RunnableC6703d(int i10, String str) {
            this.f31070a = i10;
            this.f31071b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WebViewActivity.this.f31041e != null && WebViewActivity.this.f31041e.getVisibility() == 0) {
                WebViewActivity.this.f31041e.setVisibility(8);
            }
            WebViewActivity.this.f31046j.m38226l(this.f31070a, this.f31071b, "");
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$e */
    public class ViewOnClickListenerC6704e implements View.OnClickListener {
        public ViewOnClickListenerC6704e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.f31046j.m38226l(6, "User cancel", "");
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$f */
    public class C6705f implements InterfaceC12384b {
        public C6705f() {
        }

        @Override // p587qq.InterfaceC12384b
        /* renamed from: a */
        public void mo38146a(Bundle bundle) {
            Uri uri = (Uri) bundle.getParcelable("request_pic_uri_tag");
            C12836o.m77097b("WebViewActivity", "startCompressPic onSuccess", true);
            WebViewActivity.this.m38093I(uri);
        }

        @Override // p587qq.InterfaceC12384b
        /* renamed from: b */
        public void mo38147b(Bundle bundle) {
            C12836o.m77097b("WebViewActivity", "startCompressPic onError", true);
            WebViewActivity.this.m38093I(null);
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$g */
    public class C6706g implements InterfaceC6719d {
        public C6706g() {
        }

        @Override // com.huawei.hwidauth.p167ui.InterfaceC6719d
        /* renamed from: a */
        public void mo38148a() {
            C12836o.m77097b("WebViewActivity", "clickCancel", true);
            WebViewActivity.this.m38093I(null);
        }

        @Override // com.huawei.hwidauth.p167ui.InterfaceC6719d
        /* renamed from: b */
        public void mo38149b() throws IllegalAccessException, IllegalArgumentException {
            C12836o.m77097b("WebViewActivity", "clickCamera", true);
            if (WebViewActivity.this.m38122i()) {
                WebViewActivity.this.m38055H(0);
            } else {
                WebViewActivity.this.m38124j();
            }
        }

        @Override // com.huawei.hwidauth.p167ui.InterfaceC6719d
        /* renamed from: c */
        public void mo38150c() throws IllegalAccessException, IllegalArgumentException {
            C12836o.m77097b("WebViewActivity", "clickPhoto", true);
            boolean z10 = WebViewActivity.this.checkSelfPermission(C12824c.m76999b()) == 0;
            C12836o.m77097b("WebViewActivity", "clickPhoto hasStoragePer" + z10, true);
            if (z10) {
                WebViewActivity.this.m38125k();
            } else {
                WebViewActivity.this.m38055H(1);
            }
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$h */
    public class DialogInterfaceOnCancelListenerC6707h implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC6707h() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C12836o.m77097b("WebViewActivity", "dialog cancel", true);
            WebViewActivity.this.m38093I(null);
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$i */
    public class DialogInterfaceOnClickListenerC6708i implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f31077a;

        public DialogInterfaceOnClickListenerC6708i(int i10) {
            this.f31077a = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            int i11 = this.f31077a;
            if (i11 == 0) {
                C12836o.m77097b("WebViewActivity", "startCamera", true);
                WebViewActivity.this.f31046j.m38249x(1006);
            } else {
                if (i11 != 1) {
                    return;
                }
                C12836o.m77097b("WebViewActivity", "startGallery", true);
                WebViewActivity.this.f31046j.m38187H(1007);
            }
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$j */
    public class RunnableC6709j implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f31079a;

        public RunnableC6709j(boolean z10) {
            this.f31079a = z10;
        }

        @Override // java.lang.Runnable
        @TargetApi(21)
        public void run() {
            if (this.f31079a) {
                C12836o.m77097b("WebViewActivity", "onPermissionRequest: granted", true);
                WebViewActivity.this.f31056t.grant(WebViewActivity.this.f31056t.getResources());
            } else {
                C12836o.m77097b("WebViewActivity", "onPermissionRequest: deny", true);
                WebViewActivity.this.f31056t.deny();
            }
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$k */
    public class HandlerC6710k extends Handler {
        public HandlerC6710k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            if (message.what == 1001) {
                WebViewActivity.this.f31046j.m38199T(WebViewActivity.this.f31042f);
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$l */
    public class ViewOnClickListenerC6711l implements View.OnClickListener {
        public ViewOnClickListenerC6711l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.f31046j.m38226l(6, "User cancel", "");
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$m */
    public class RunnableC6712m implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31083a;

        public RunnableC6712m(String str) {
            this.f31083a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WebViewActivity.this.f31038b != null) {
                WebViewActivity.this.f31038b.loadUrl(WebViewActivity.this.m38126k0(this.f31083a));
            }
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$o */
    public class C6714o extends Thread {
        public C6714o() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            C12839r.m77113k(WebViewActivity.this);
        }

        public /* synthetic */ C6714o(WebViewActivity webViewActivity, ViewOnClickListenerC6704e viewOnClickListenerC6704e) {
            this();
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$p */
    public final class C6715p {
        public C6715p() {
        }

        @JavascriptInterface
        public void authCancel(String str) {
            C12836o.m77097b("WebViewActivity", "js call authCancel parameter:" + str, false);
            C12836o.m77097b("WebViewActivity", "js call authCancel", true);
            WebViewActivity.this.f31046j.m38226l(6, "User cancel", "");
        }

        @JavascriptInterface
        public void authSuccCloseH5(String str) {
            C12836o.m77097b("WebViewActivity", "js call auth suc parameter:" + str, false);
            C12836o.m77097b("WebViewActivity", "js call auth suc.", true);
            WebViewActivity.this.f31046j.m38226l(200, "Sign In Success", "");
        }

        @JavascriptInterface
        public String getAuthInfo() {
            return WebViewActivity.this.f31046j.m38214f(WebViewActivity.this.f31038b, WebViewActivity.this.getPackageName());
        }
    }

    /* renamed from: H */
    public void m38055H(int i10) throws IllegalAccessException, IllegalArgumentException {
        C12836o.m77097b("WebViewActivity", "init showPermissionTipDialog", true);
        AlertDialog alertDialogCreate = m38094K(i10).create();
        this.f31055s = alertDialogCreate;
        C12844w.m77132d(alertDialogCreate);
        this.f31055s.setCanceledOnTouchOutside(false);
        this.f31055s.setCancelable(false);
        C12836o.m77097b("WebViewActivity", "show showPermissionTipDialog", true);
        if (isFinishing()) {
            return;
        }
        C12844w.m77132d(this.f31055s);
        this.f31055s.show();
    }

    @TargetApi(23)
    /* renamed from: V */
    private void m38063V() {
        if (!C12829h.m77056a()) {
            C12836o.m77097b("WebViewActivity", "is below EMUI10.0.", true);
            return;
        }
        Window window = getWindow();
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(systemUiVisibility | 9472);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        m38067a0();
    }

    /* renamed from: a0 */
    private void m38067a0() {
        View childAt = ((ViewGroup) getWindow().findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
    }

    /* renamed from: A */
    public final void m38082A(SafeWebView safeWebView, String str, Map map) {
        if (safeWebView != null && m38099X(str) && safeWebView.m53594c(str)) {
            safeWebView.loadUrl(str, map);
        } else {
            this.f31046j.m38226l(2015, "webview or url is invalid.", "");
        }
    }

    /* renamed from: A0 */
    public final void m38083A0() {
        C12836o.m77097b("WebViewActivity", "handleAuthListUrl start.", true);
        String strMo76122f = AbstractC12615a.m76116a().mo76122f();
        C12836o.m77097b("WebViewActivity", "authAppListUrl：" + strMo76122f, false);
        m38084B(this.f31038b, strMo76122f, C12824c.m77005h(this.f31046j.m38180C(C12824c.m77007j(this))));
    }

    /* renamed from: B */
    public final void m38084B(SafeWebView safeWebView, String str, byte[] bArr) {
        if (safeWebView != null && m38099X(str) && safeWebView.m53594c(str)) {
            safeWebView.postUrl(str, bArr);
        } else {
            this.f31046j.m38226l(2015, "webview or url is invalid.", "");
        }
    }

    /* renamed from: B0 */
    public final void m38085B0() {
        C12836o.m77097b("WebViewActivity", "handleOtherAppSignInUrl start.", true);
        C6723h c6723h = this.f31046j;
        String strM38234p0 = c6723h.m38234p0(c6723h.m38193N());
        C12836o.m77097b("WebViewActivity", "handleOtherAppSignInUrl：" + strM38234p0, false);
        m38142y(this.f31038b, strM38234p0);
    }

    /* renamed from: C */
    public final void m38086C(String str, String str2, String str3) {
        if (!C12824c.m77018u(this) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C12836o.m77097b("WebViewActivity", "WXApp not Installed or parms invalid", true);
            new Handler(getMainLooper()).post(new RunnableC6702c(AbstractC12615a.m76116a().mo76124h(), str3));
            return;
        }
        C11742a.m70048a().m70051d(this);
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, str, true);
        iwxapiCreateWXAPI.registerApp(str);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = str2;
        req.state = str3;
        iwxapiCreateWXAPI.sendReq(req);
    }

    /* renamed from: C0 */
    public final void m38087C0() {
        C12836o.m77097b("WebViewActivity", "handleSignInUrl start.", true);
        String strM38213e0 = this.f31046j.m38213e0(C12824c.m77007j(this));
        C12836o.m77097b("WebViewActivity", "handleSignInUrl sigInUrl：" + strM38213e0, false);
        HashMap<String, String> mapM38207b0 = this.f31046j.m38207b0(strM38213e0);
        C12836o.m77097b("WebViewActivity", "signInHeaders", true);
        C12836o.m77097b("WebViewActivity", "signInHeaders：" + mapM38207b0, false);
        m38082A(this.f31038b, strM38213e0, mapM38207b0);
    }

    /* renamed from: D */
    public final void m38088D(ArrayList<String> arrayList) {
        URL url;
        C12836o.m77097b("WebViewActivity", "checkAcceptThirdPartyCookies ==", true);
        if ("from_other_app_signin".equalsIgnoreCase(this.f31046j.m38208c())) {
            try {
                url = new URL(this.f31046j.m38193N().replaceAll("[\\\\#]", "/"));
            } catch (MalformedURLException unused) {
                C12836o.m77097b("WebViewActivity", "MalformedURLException", true);
                url = null;
            }
            String host = url != null ? url.getHost() : "";
            C12836o.m77097b("WebViewActivity", "checkAcceptThirdPartyCookies host== " + host, false);
            if (arrayList.contains(host)) {
                C12836o.m77097b("WebViewActivity", "checkAcceptThirdPartyCookies contain", true);
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.f31038b, true);
            } else {
                C12836o.m77097b("WebViewActivity", "checkAcceptThirdPartyCookies not contain", true);
                this.f31046j.m38226l(6, "checkAcceptThirdPartyCookies not contain", "");
            }
        }
    }

    /* renamed from: D0 */
    public final void m38089D0() {
        C12836o.m77097b("WebViewActivity", "setWebViewSafeSettings ==", true);
        WebSettings settings = this.f31038b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setMixedContentMode(1);
        settings.setGeolocationEnabled(false);
        settings.setAllowContentAccess(false);
        settings.setDomStorageEnabled(true);
        this.f31038b.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f31038b.removeJavascriptInterface("accessibility");
        this.f31038b.removeJavascriptInterface("accessibilityTraversal");
    }

    /* renamed from: E0 */
    public final void m38090E0() {
        this.f31039c = (TextView) findViewById(R$id.hwid_auth_title_text);
        ImageView imageView = (ImageView) findViewById(R$id.hwid_auth_close_imageview);
        if (imageView != null) {
            imageView.setOnClickListener(new ViewOnClickListenerC6711l());
        }
    }

    /* renamed from: F0 */
    public final void m38091F0() {
        try {
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        } catch (Exception unused) {
            C12836o.m77099d("WebViewActivity", "hideActionbar Exception", true);
        }
    }

    /* renamed from: G0 */
    public final void m38092G0() {
        C12830i.m77070d(m38115e());
        C12836o.m77097b("WebViewActivity", "deleteFiles....successful", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: I */
    public final void m38093I(Uri uri) {
        C12836o.m77097b("WebViewActivity", "uploadCardPic RESULTCODE", true);
        ValueCallback<?> valueCallback = this.f31050n;
        if (valueCallback != null) {
            try {
                int i10 = this.f31052p;
                if (i10 == 1001) {
                    valueCallback.onReceiveValue(uri);
                } else if (i10 == 1002) {
                    valueCallback.onReceiveValue(uri == null ? new Uri[0] : new Uri[]{uri});
                }
            } catch (Exception e10) {
                C12836o.m77097b("WebViewActivity", "Exception e" + e10.getClass().getSimpleName(), true);
            }
            this.f31050n = null;
        }
    }

    /* renamed from: K */
    public final AlertDialog.Builder m38094K(int i10) {
        C12836o.m77097b("WebViewActivity", "createPermissionDialog", true);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, C12844w.m77129a(this));
        builder.setTitle(getResources().getString(R$string.hwid_string_permission_tip_640));
        builder.setNeutralButton(getResources().getString(R$string.hwid_string_permission_ok_640), new DialogInterfaceOnClickListenerC6708i(i10));
        if (i10 == 0) {
            C12836o.m77097b("WebViewActivity", "show camera text", true);
            builder.setMessage(getResources().getString(R$string.hwid_string_camera_permission_description_640));
        } else if (i10 == 1) {
            builder.setMessage(getResources().getString(R$string.hwid_string_storage_permission_description_640));
            C12836o.m77097b("WebViewActivity", "show gallery text", true);
        }
        return builder;
    }

    /* renamed from: O */
    public boolean m38095O() {
        return this.f31048l;
    }

    /* renamed from: R */
    public final void m38096R(String str) {
        C12836o.m77097b("WebViewActivity", "enter getDevAuthCode", true);
        this.f31058v.sendEmptyMessage(1001);
    }

    /* renamed from: S */
    public final void m38097S(boolean z10) {
        runOnUiThread(new RunnableC6709j(z10));
    }

    /* renamed from: T */
    public boolean m38098T() {
        return this.f31049m;
    }

    /* renamed from: X */
    public final boolean m38099X(String str) {
        String strM77145a = C12845x.m77145a(str);
        if (!TextUtils.isEmpty(str) && m38113c0(strM77145a)) {
            return true;
        }
        C12836o.m77097b("WebViewActivity", "is not a right url", true);
        return false;
    }

    /* renamed from: Y */
    public final boolean m38100Y(boolean z10) {
        C12836o.m77097b("WebViewActivity", "checkNeedUpdatePic isResultOK = " + z10, true);
        if (this.f31050n == null) {
            return false;
        }
        if (z10 && this.f31051o != null) {
            return true;
        }
        C12836o.m77097b("WebViewActivity", "checkNeedUpdatePic onReceiveValue = null mTmpPicUri = " + this.f31051o, false);
        m38093I(null);
        return false;
    }

    /* renamed from: a */
    public void m38101a() {
        C12836o.m77097b("WebViewActivity", "loadWebViewUrl start.", true);
        m38134r0();
        String strM38208c = this.f31046j.m38208c();
        strM38208c.hashCode();
        switch (strM38208c) {
            case "scan_code_login":
                C12836o.m77099d("WebViewActivity", "scan_code_login", true);
                m38145z0();
                break;
            case "from_open_realNameInfo":
            case "from_open_childInfo":
            case "from_qr_authorize":
                m38137t0();
                break;
            case "from_open_auth_app_list":
                C12836o.m77099d("WebViewActivity", "from_open_auth_app_list", true);
                m38083A0();
                break;
            case "from_open_center_mng_new":
                C12836o.m77099d("WebViewActivity", "from_open_center_mng_new", true);
                m38118f0(AbstractC12615a.m76116a().mo76120d());
                break;
            case "from_open_center_mng":
                C12836o.m77099d("WebViewActivity", "from_open_center_mng", true);
                m38118f0(AbstractC12615a.m76116a().mo76120d());
                break;
            case "verify_password":
                C12836o.m77099d("WebViewActivity", "verify_password", true);
                m38143y0();
                break;
            case "verify_password_new":
                C12836o.m77099d("WebViewActivity", "verify_password_new", true);
                m38143y0();
                break;
            case "from_signin":
                C12836o.m77099d("WebViewActivity", "from_signin", true);
                m38087C0();
                break;
            case "from_v3_signin":
                C12836o.m77099d("WebViewActivity", "from_v3_signin", true);
                m38087C0();
                break;
            case "open_personal_info":
                C12836o.m77099d("WebViewActivity", "open_personal_info", true);
                m38138u0();
                break;
            case "from_other_app_signin":
                C12836o.m77099d("WebViewActivity", "from_other_app_signin", true);
                m38085B0();
                break;
            default:
                C12836o.m77099d("WebViewActivity", "from error", true);
                this.f31046j.m38226l(6, "User cancel", "");
                finish();
                break;
        }
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: b */
    public void mo38107b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runOnUiThread(new RunnableC6700a(str));
    }

    /* renamed from: b0 */
    public final void m38109b0(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        boolean z11;
        C12836o.m77097b("WebViewActivity", "enter  showRefuseDailog", true);
        boolean z12 = false;
        if (z10) {
            z11 = checkSelfPermission("android.permission.CAMERA") != 0;
        } else {
            z12 = checkSelfPermission(C12824c.m76999b()) != 0;
            z11 = false;
        }
        AlertDialog.Builder builderM77131c = C12844w.m77131c(this, z12 ? getResources().getString(R$string.hwid_string_pic_permission_show_520, C12838q.m77102a(this), getResources().getString(R$string.hwid_string_permission_storage)) : z11 ? getResources().getString(R$string.hwid_string_pic_permission_show_520, C12838q.m77102a(this), getResources().getString(R$string.hwid_string_permission_camera)) : "", getResources().getString(R$string.hwid_string_permission_use_appeal), null);
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialogCreate = builderM77131c.create();
        C12844w.m77132d(alertDialogCreate);
        C12836o.m77097b("WebViewActivity", "enter  showRefuseDailog show", true);
        alertDialogCreate.show();
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: c */
    public void mo38110c(int i10, Intent intent) {
        C12836o.m77097b("WebViewActivity", "exit resultCode", true);
        setResult(i10, intent);
        finish();
    }

    /* renamed from: c0 */
    public final boolean m38113c0(String str) {
        return "https".equalsIgnoreCase(str) || "http".equalsIgnoreCase(str) || C6664a.f30905c.equalsIgnoreCase(str) || "mqq".equalsIgnoreCase(str) || "weixin".equalsIgnoreCase(str);
    }

    @Override // p497nq.InterfaceC11743b
    /* renamed from: d */
    public void mo38114d(Intent intent) {
        C12836o.m77097b("WebViewActivity", "WeixinAuthHandler receive:", true);
        if (-1 == intent.getIntExtra(MapKeyNames.RESULT_CODE, 0)) {
            C12836o.m77097b("WebViewActivity", "get weChat code success", true);
            String stringExtra = intent.getStringExtra("code");
            String stringExtra2 = intent.getStringExtra(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            String strMo76124h = AbstractC12615a.m76116a().mo76124h();
            C12836o.m77097b("WebViewActivity", "weChatCodeAuthUrl: " + strMo76124h, false);
            new Handler(getMainLooper()).post(new RunnableC6701b(strMo76124h, stringExtra, stringExtra2));
        } else {
            C12836o.m77099d("WebViewActivity", "not allowed to login with weChat", true);
        }
        C11742a.m70048a().m70052e();
    }

    /* renamed from: e */
    public final String m38115e() {
        try {
            return getDir("hwId", 0).getCanonicalPath() + "/";
        } catch (IOException e10) {
            C12836o.m77099d("WebViewActivity", "IOException:" + e10.getClass().getSimpleName(), true);
            return "";
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: e0 */
    public final void m38116e0() {
        ProgressBar progressBar;
        C12836o.m77097b("WebViewActivity", "initViews", true);
        if (C12824c.m77015r("com.huawei.android.app.ActionBarEx")) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R$id.hwid_auth_top_view);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ActionBar actionBar = getActionBar();
            this.f31044h = actionBar;
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(false);
                m38123i0(" ");
                ActionBarEx.setStartIcon(this.f31044h, true, (Drawable) null, new ViewOnClickListenerC6704e());
            }
        } else {
            C12836o.m77097b("WebViewActivity", "initViews else", true);
            m38121h0();
            m38091F0();
            m38090E0();
        }
        this.f31040d = (ProgressBar) findViewById(R$id.hwid_auth_Progressbar);
        if (C12824c.m77011n() && (progressBar = this.f31040d) != null) {
            progressBar.setProgressDrawable(getDrawable(R$drawable.hwid_auth_progress_horizontal_emui5));
        }
        this.f31041e = (RelativeLayout) findViewById(R$id.hwid_auth_loading);
        C12836o.m77097b("WebViewActivity", "create webview", true);
        this.f31038b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        m38128l0();
    }

    /* renamed from: f */
    public final void m38117f() {
        if ("from_other_app_signin".equals(this.f31046j.m38208c())) {
            C12836o.m77097b("WebViewActivity", "onBackPressed setDiyTitle:", true);
            m38123i0("");
        }
    }

    /* renamed from: f0 */
    public final void m38118f0(String str) {
        C12836o.m77097b("WebViewActivity", "handleCenterUrl start.", true);
        String strMo76127k = AbstractC12615a.m76116a().mo76127k();
        C12836o.m77097b("WebViewActivity", "centerUrl：" + strMo76127k, false);
        m38144z(this.f31038b, strMo76127k, this.f31046j.m38216g(C12824c.m77007j(this), str));
    }

    /* renamed from: g */
    public final String m38119g() {
        return "javascript:goBack()";
    }

    /* renamed from: h */
    public final void m38120h() throws IllegalAccessException, IllegalArgumentException {
        C12836o.m77097b("WebViewActivity", "showNoNetworkDialog", true);
        AlertDialog alertDialogCreate = C12844w.m77137i(this).create();
        this.f31054r = alertDialogCreate;
        alertDialogCreate.setCancelable(false);
        if (isFinishing()) {
            return;
        }
        C12844w.m77132d(this.f31054r);
        this.f31054r.show();
    }

    /* renamed from: h0 */
    public final void m38121h0() {
        C12836o.m77097b("WebViewActivity", "setStatusBarColor ==", true);
        Window window = getWindow();
        window.clearFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R$color.hwid_auth_black_100_percent));
    }

    /* renamed from: i */
    public final boolean m38122i() {
        boolean z10 = checkSelfPermission("android.permission.CAMERA") == 0;
        C12836o.m77097b("WebViewActivity", "clickCamera hasCameraPer: " + z10, true);
        return !z10;
    }

    /* renamed from: i0 */
    public final void m38123i0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = " ";
        }
        TextView textView = this.f31039c;
        if (textView != null) {
            textView.setText(str);
        } else {
            setTitle(str);
        }
    }

    /* renamed from: j */
    public final void m38124j() {
        if (this.f31051o == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(3);
        String str = getPackageName() + ".hwidauth.fileProvider";
        C12836o.m77097b("WebViewActivity", "start Camera authority = " + str, false);
        Uri uriForFile = FileProvider.getUriForFile(this, str, new File(this.f31051o.getPath()));
        C12836o.m77097b("WebViewActivity", "startCamera tmpCropUri = " + uriForFile, false);
        intent.putExtra("output", uriForFile);
        String systemAppPackage = PresetUtil.getSystemAppPackage(this, intent);
        if (!TextUtils.isEmpty(systemAppPackage)) {
            C12836o.m77097b("WebViewActivity", "start Camare, packageName = " + systemAppPackage, true);
            intent.setPackage(systemAppPackage);
        }
        try {
            startActivityForResult(intent, 1003);
        } catch (Exception e10) {
            C12836o.m77099d("WebViewActivity", "startCamera :" + e10.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: k */
    public final void m38125k() {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        String systemAppPackage = PresetUtil.getSystemAppPackage(this, intent);
        if (!TextUtils.isEmpty(systemAppPackage)) {
            C12836o.m77097b("WebViewActivity", "start Gallery, packageName = " + systemAppPackage, true);
            intent.setPackage(systemAppPackage);
        }
        try {
            startActivityForResult(intent, 1004);
        } catch (Exception e10) {
            C12836o.m77099d("WebViewActivity", "startGallery" + e10.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: k0 */
    public final String m38126k0(String str) {
        return "javascript:getDevAuthCodeCallback('" + C11342a.m68144f(str) + "')";
    }

    /* renamed from: l */
    public final String m38127l() {
        return "verify_password_new".equalsIgnoreCase(this.f31046j.m38208c()) ? "accountPickerH5.chkUserPassword_v3" : "accountPickerH5.chkUserPassword_v2";
    }

    /* renamed from: l0 */
    public final void m38128l0() {
        C12836o.m77097b("WebViewActivity", "init WebView.", true);
        if (this.f31038b == null) {
            C12836o.m77099d("WebViewActivity", "WebView is null.", true);
            return;
        }
        ArrayList<String> arrayListM68112p = C11335b.m68098g().m68112p(this);
        this.f31038b.setWhitelistNotMathcSubDomain((String[]) arrayListM68112p.toArray(new String[arrayListM68112p.size()]));
        m38088D(arrayListM68112p);
        m38132p0();
        m38089D0();
        m38129m0();
    }

    /* renamed from: m0 */
    public final void m38129m0() {
        C12836o.m77097b("WebViewActivity", "webViewPerformanceSetting ==", true);
        SafeWebView safeWebView = this.f31038b;
        if (safeWebView == null) {
            C12836o.m77099d("WebViewActivity", "mWebView is null.", true);
        } else {
            safeWebView.setLayerType(2, null);
        }
    }

    /* renamed from: n0 */
    public final void m38130n0(String str) {
        Toast.makeText(this, str, 1).show();
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException {
        C12836o.m77097b("WebViewActivity", "onActivityResult " + i10 + " resultCode " + i11, true);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1004 || i10 == 1003) {
            m38133r(i10, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C12836o.m77097b("WebViewActivity", "onBackPressed", true);
        try {
            SafeWebView safeWebView = this.f31038b;
            if (safeWebView == null || !safeWebView.canGoBack()) {
                this.f31046j.m38226l(6, "User cancel", "");
                super.onBackPressed();
                return;
            }
            String url = this.f31038b.getUrl();
            boolean z10 = false;
            C12836o.m77097b("WebViewActivity", "currentUrl:" + url, false);
            if (!TextUtils.isEmpty(url)) {
                String[] strArrSplit = url.split("\\?");
                if (strArrSplit.length > 0 && (strArrSplit[0].endsWith("wapLogin.html") || strArrSplit[0].endsWith("welcome.html"))) {
                    this.f31046j.m38226l(6, "User cancel", "");
                    super.onBackPressed();
                    return;
                }
            }
            Iterator<String> it = this.f31045i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(url) && url.startsWith(next)) {
                    z10 = true;
                    break;
                }
            }
            C12836o.m77097b("WebViewActivity", "goBackUseWap:" + z10, true);
            if (!z10) {
                this.f31038b.goBack();
                return;
            }
            m38117f();
            this.f31038b.loadUrl(m38119g());
        } catch (RuntimeException unused) {
            C12836o.m77099d("WebViewActivity", "catch Exception throw by FragmentManager!", true);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        super.onCreate(bundle);
        C12836o.m77097b("WebViewActivity", "enter onCreate", true);
        Intent intent = getIntent();
        if (intent == null) {
            C12836o.m77099d("WebViewActivity", "intent is null.", true);
            mo38106b();
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if (safeIntent.m53582g()) {
            C12836o.m77099d("WebViewActivity", "has intent bomb.", true);
            mo38106b();
            return;
        }
        C12824c.m77009l(this);
        setContentView(R$layout.hwid_auth_webview);
        C12831j.m77077a(this);
        C12824c.m77002e(this);
        C11347f.m68158b(this);
        this.f31038b = (SafeWebView) findViewById(R$id.hwid_auth_webView);
        this.f31047k = new C12828g();
        C6723h c6723h = new C6723h(this, this);
        this.f31046j = c6723h;
        c6723h.init(safeIntent);
        m38116e0();
        m38063V();
        this.f31046j.m38185F();
        C12827f.m77030c(this).m77050v();
        C12836o.m77097b("WebViewActivity", "out onCreate", true);
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C12836o.m77099d("WebViewActivity", "onDestroy", true);
        AlertDialog alertDialog = this.f31054r;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f31054r.dismiss();
        }
        AlertDialog alertDialog2 = this.f31053q;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.f31053q.dismiss();
        }
        AlertDialog alertDialog3 = this.f31055s;
        if (alertDialog3 != null && alertDialog3.isShowing()) {
            this.f31055s.dismiss();
        }
        C11988a.m72133k(getApplicationContext()).m72142i("fileDownLoadLastUpdate", String.valueOf(System.currentTimeMillis()));
        m38092G0();
        SafeWebView safeWebView = this.f31038b;
        if (safeWebView != null) {
            safeWebView.stopLoading();
            this.f31038b.setVisibility(8);
            this.f31038b.removeAllViews();
            this.f31038b.clearFormData();
            this.f31038b.clearHistory();
            this.f31038b.destroy();
        }
        this.f31038b = null;
        C11742a.m70048a().m70052e();
        new C6714o(this, null).start();
    }

    @Override // android.app.Activity
    public void onPause() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C12841t.m77121c(getWindow());
        super.onPause();
        SafeWebView safeWebView = this.f31038b;
        if (safeWebView != null) {
            safeWebView.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) throws IllegalAccessException, IllegalArgumentException {
        C12836o.m77097b("WebViewActivity", "onRequestPermissionsResult requestCode = " + i10, true);
        if (i10 == 1006) {
            if (this.f31046j.m38253z(iArr)) {
                m38124j();
                return;
            } else {
                m38109b0(true);
                m38093I(null);
                return;
            }
        }
        if (i10 == 1007) {
            if (this.f31046j.m38253z(iArr)) {
                m38125k();
                return;
            } else {
                m38109b0(false);
                m38093I(null);
                return;
            }
        }
        if (i10 == 1008) {
            if (this.f31046j.m38253z(iArr)) {
                m38097S(true);
            } else {
                m38097S(false);
            }
        }
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C12841t.m77119a(getWindow());
        super.onResume();
        SafeWebView safeWebView = this.f31038b;
        if (safeWebView != null) {
            safeWebView.onResume();
        }
    }

    /* renamed from: p */
    public final String m38131p(Context context) {
        C12836o.m77097b("WebViewActivity", "enter getUAExtra", true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("; phoneservice; hwidOAuthSDK_ver=");
        sb2.append("6.12.0.302");
        sb2.append("; app=");
        sb2.append(context.getPackageName());
        sb2.append("; app_ver=");
        sb2.append(C12824c.m77019v(this));
        sb2.append("; noNeedClientNonce");
        sb2.append("; supportChooseFile=true");
        if (C12824c.m77018u(this)) {
            sb2.append("; wechatinstalled");
        }
        if ("from_other_app_signin".equalsIgnoreCase(this.f31046j.m38208c())) {
            sb2.append("; service=");
            sb2.append(this.f31046j.m38211d0());
            sb2.append("; X-Huawei-Client-Info=");
            C6723h c6723h = this.f31046j;
            sb2.append(c6723h.m38232o0(c6723h.m38193N()));
        }
        sb2.append("; faceRealnameSupport");
        sb2.append("; androidVersionCode=");
        sb2.append(Build.VERSION.SDK_INT);
        return sb2.toString();
    }

    /* renamed from: p0 */
    public final void m38132p0() {
        C12836o.m77097b("WebViewActivity", "webViewSetting start.", true);
        this.f31038b.setWebViewClient(new C6720e(this.f31046j, this, this.f31038b, this.f31047k, this));
        this.f31038b.setWebChromeClient(new AuthWebChromeClient(this, null));
        this.f31038b.addJavascriptInterface(new C6713n(), "webLoader");
        this.f31038b.addJavascriptInterface(new C6715p(), "hwop");
        if (C12844w.m77138j(this)) {
            this.f31038b.setBackgroundColor(getResources().getColor(R$color.hwid_auth_black_100_percent));
        } else {
            this.f31038b.setBackgroundColor(0);
        }
    }

    /* renamed from: r */
    public final void m38133r(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException {
        C12836o.m77097b("WebViewActivity", "dealRequestGalleryAndCamera start.", true);
        if (!C12824c.m76979A(this)) {
            m38093I(null);
            m38120h();
            return;
        }
        if (i10 == 1004 && intent != null && intent.getData() != null) {
            this.f31051o = intent.getData();
        }
        if (m38100Y(-1 == i11 && UriCheckUtils.isUriValid(i10 == 1004 ? 1 : 0, this.f31051o))) {
            m38135s(this.f31051o);
        }
    }

    /* renamed from: r0 */
    public final void m38134r0() {
        SafeWebView safeWebView = this.f31038b;
        if (safeWebView == null) {
            C12836o.m77099d("WebViewActivity", "mWebView is null.", true);
            return;
        }
        WebSettings settings = safeWebView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + m38131p(this));
        C12836o.m77097b("WebViewActivity", "getUserAgentString:" + settings.getUserAgentString(), false);
    }

    /* renamed from: s */
    public final void m38135s(Uri uri) {
        C12836o.m77097b("WebViewActivity", "startCompressPic", true);
        new AsyncTaskC12383a(this, uri, new C6705f()).execute(1);
    }

    /* renamed from: t */
    public final void m38136t(ValueCallback<Uri> valueCallback) throws IllegalAccessException, IllegalArgumentException {
        this.f31050n = valueCallback;
        this.f31052p = 1001;
        C12836o.m77097b("WebViewActivity", "localOpenFileChoose", true);
        C12836o.m77097b("WebViewActivity", "localOpenFileChoose showChoosePicDialog", true);
        m38066a(1001);
    }

    /* renamed from: t0 */
    public final void m38137t0() {
        String strM38208c = this.f31046j.m38208c();
        strM38208c.hashCode();
        switch (strM38208c) {
            case "from_open_realNameInfo":
                C12836o.m77099d("WebViewActivity", "open_realNameInfo", true);
                m38139v0();
                break;
            case "from_open_childInfo":
                C12836o.m77099d("WebViewActivity", "open_childInfo", true);
                m38141x0();
                break;
            case "from_qr_authorize":
                C12836o.m77099d("WebViewActivity", "qr_authorize", true);
                m38140w0();
                break;
            default:
                C12836o.m77097b("WebViewActivity", "dealOtherOper not match", true);
                break;
        }
    }

    /* renamed from: u0 */
    public final void m38138u0() {
        C12836o.m77097b("WebViewActivity", "handleOpenPersonalUrl start.", true);
        String strMo76127k = AbstractC12615a.m76116a().mo76127k();
        C12836o.m77097b("WebViewActivity", "atRemoteLoginUrl：" + strMo76127k, false);
        m38144z(this.f31038b, strMo76127k, this.f31046j.m38212e(this));
    }

    /* renamed from: v0 */
    public final void m38139v0() {
        C12836o.m77097b("WebViewActivity", "handleOpenRealNameInfoUrl start.", true);
        String strMo76127k = AbstractC12615a.m76116a().mo76127k();
        C12836o.m77097b("WebViewActivity", "atRemoteLoginUrl：" + strMo76127k, false);
        m38144z(this.f31038b, strMo76127k, this.f31046j.m38178B(this));
    }

    /* renamed from: w0 */
    public final void m38140w0() {
        C12836o.m77097b("WebViewActivity", "handleQrAurhorizeUrl start.", true);
        String strM38194O = this.f31046j.m38194O(this);
        C12836o.m77097b("WebViewActivity", "qrAurhorizeUrl：" + strM38194O, false);
        m38142y(this.f31038b, strM38194O);
    }

    /* renamed from: x0 */
    public final void m38141x0() {
        C12836o.m77097b("WebViewActivity", "handleOpenChildInfoUrl start.", true);
        String strMo76127k = AbstractC12615a.m76116a().mo76127k();
        C12836o.m77097b("WebViewActivity", "atRemoteLoginUrl：" + strMo76127k, false);
        m38144z(this.f31038b, strMo76127k, this.f31046j.m38188I(this));
    }

    /* renamed from: y */
    public final void m38142y(SafeWebView safeWebView, String str) {
        if (safeWebView != null && m38099X(str) && safeWebView.m53594c(str)) {
            safeWebView.loadUrl(str);
        } else {
            this.f31046j.m38226l(2015, "webview or url is invalid.", "");
        }
    }

    /* renamed from: y0 */
    public final void m38143y0() {
        C12836o.m77097b("WebViewActivity", "handleVerifyPasswordUrl start.", true);
        String str = AbstractC12615a.m76116a().mo76126j() + this.f31046j.m38189J(C12824c.m77007j(this));
        this.f31043g = C12824c.m76995Q();
        String str2 = str + "&clientNonce=" + this.f31043g;
        C12836o.m77097b("WebViewActivity", "verifyPasswordUrl：" + str2, false);
        m38082A(this.f31038b, str2, this.f31046j.m38191L());
    }

    /* renamed from: z */
    public final void m38144z(SafeWebView safeWebView, String str, String str2) {
        if (safeWebView == null || !m38099X(str) || !safeWebView.m53594c(str)) {
            this.f31046j.m38226l(2015, "webview or url is invalid.", "");
            return;
        }
        safeWebView.loadUrl(str + str2);
    }

    /* renamed from: z0 */
    public final void m38145z0() {
        C12836o.m77097b("WebViewActivity", "handleAuthListUrl start.", true);
        String str = AbstractC12615a.m76116a().mo76125i() + this.f31046j.m38195P(C12824c.m77007j(this));
        C12836o.m77097b("WebViewActivity", "qrLoginUrl：" + str, false);
        m38082A(this.f31038b, str, this.f31046j.m38204Y(str));
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: b */
    public void mo38106b() {
        C12836o.m77097b("WebViewActivity", "exitApp finish", true);
        finish();
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: c */
    public void mo38111c(String str) {
        this.f31057u = str;
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: b */
    public void mo38108b(boolean z10) {
        this.f31048l = z10;
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: c */
    public void mo38112c(boolean z10) {
        this.f31049m = z10;
    }

    /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n */
    public final class C6713n {

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$a */
        public class a implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31086a;

            /* renamed from: b */
            public final /* synthetic */ String f31087b;

            public a(String str, String str2) {
                this.f31086a = str;
                this.f31087b = str2;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38161k(this.f31086a, this.f31087b);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "verifyResult get allowlist failed.", true);
                WebViewActivity.this.f31046j.m38226l(7, "match allowlist failed", "");
                WebViewActivity.this.finish();
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$b */
        public class b implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31089a;

            public b(String str) {
                this.f31089a = str;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38158h(this.f31089a);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "getDevAuthCode get allowlist failed from file.", true);
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.mo38104a(webViewActivity.f31046j.m38190K("1", "9999"));
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$c */
        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f31091a;

            public c(String str) {
                this.f31091a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                C12836o.m77097b("WebViewActivity", "checkUserPasswordResult finish WebViewActivity", true);
                String strM38127l = WebViewActivity.this.m38127l();
                if ((!"verify_password".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c()) && !"verify_password_new".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) || TextUtils.isEmpty(this.f31091a)) {
                    WebViewActivity.this.f31046j.m38226l(7, this.f31091a, "");
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    C13056a.m78783c(webViewActivity, 907115003, 7, "token is empty or mPresenter.getFrom() is not verify_password", webViewActivity.f31046j.m38200U(), strM38127l, "api_ret");
                    WebViewActivity.this.finish();
                    return;
                }
                InterfaceC10596j interfaceC10596jM76980B = C12824c.m76980B();
                C10600n c10600n = new C10600n(200, "check password success.");
                c10600n.m64999e(true);
                C10587a c10587a = new C10587a(this.f31091a, c10600n);
                if (interfaceC10596jM76980B != null) {
                    interfaceC10596jM76980B.onResult(c10587a);
                    WebViewActivity webViewActivity2 = WebViewActivity.this;
                    C13056a.m78783c(webViewActivity2, 907115003, 200, "check password Success", webViewActivity2.f31046j.m38200U(), strM38127l, "api_ret");
                    WebViewActivity.this.finish();
                }
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$d */
        public class d implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31093a;

            public d(String str) {
                this.f31093a = str;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38158h(this.f31093a);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "getDevAuthCode get allowlist failed.", true);
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.mo38104a(webViewActivity.f31046j.m38190K("1", "9999"));
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$e */
        public class e implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31095a;

            /* renamed from: b */
            public final /* synthetic */ String f31096b;

            public e(String str, String str2) {
                this.f31095a = str;
                this.f31096b = str2;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38159i(this.f31095a, this.f31096b);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "getDevAuthCode get allowlist failed from file.", true);
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.mo38104a(webViewActivity.f31046j.m38190K("1", "9999"));
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$f */
        public class f implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31098a;

            /* renamed from: b */
            public final /* synthetic */ String f31099b;

            public f(String str, String str2) {
                this.f31098a = str;
                this.f31099b = str2;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38159i(this.f31098a, this.f31099b);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "getDevAuthCode with two params get allowlist failed.", true);
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.mo38104a(webViewActivity.f31046j.m38190K("1", "9999"));
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$g */
        public class g implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f31101a;

            public g(String str) {
                this.f31101a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                C12836o.m77097b("WebViewActivity", "intoApp finish WebViewActivity", true);
                if (TextUtils.isEmpty(this.f31101a)) {
                    WebViewActivity.this.f31046j.m38226l(7, "", "");
                    C12836o.m77099d("WebViewActivity", "enter intoApp returnMsg is null ", true);
                    WebViewActivity.this.finish();
                    return;
                }
                if ("scan_code_login".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c()) && !this.f31101a.equalsIgnoreCase("OK")) {
                    C10600n c10600n = new C10600n("atExpired".equalsIgnoreCase(this.f31101a) ? 2008 : 404, this.f31101a);
                    C10594h c10594h = new C10594h(c10600n);
                    c10600n.m64999e(false);
                    C6713n.this.m38157g(C12824c.m76984F(), c10594h, this.f31101a, 907115008, "accountPickerH5.qrCodeAuthLogin", 404);
                    return;
                }
                if (this.f31101a.equalsIgnoreCase("OK")) {
                    C6713n.this.m38162l(this.f31101a);
                    return;
                }
                if ("open_personal_info".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c()) && this.f31101a.equalsIgnoreCase("atExpired")) {
                    C10600n c10600n2 = new C10600n(2008, this.f31101a);
                    C10601o c10601o = new C10601o(c10600n2);
                    c10600n2.m64999e(false);
                    C6713n.this.m38157g(C12824c.m76985G(), c10601o, this.f31101a, 907115006, "accountPickerH5.openPersonalInfo", 404);
                    return;
                }
                if (("verify_password".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c()) || "verify_password_new".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) && this.f31101a.equalsIgnoreCase("atExpired")) {
                    String strM38127l = WebViewActivity.this.m38127l();
                    C10600n c10600n3 = new C10600n(2008, this.f31101a);
                    C10587a c10587a = new C10587a("", c10600n3);
                    c10600n3.m64999e(false);
                    C6713n.this.m38157g(C12824c.m76980B(), c10587a, this.f31101a, 907115003, strM38127l, 404);
                    return;
                }
                if (WebViewActivity.this.f31046j.m38209c0()) {
                    Intent intent = new Intent();
                    intent.putExtra("retValue", this.f31101a);
                    WebViewActivity.this.setResult(8, intent);
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    C13056a.m78783c(webViewActivity, 907115001, 200, this.f31101a, webViewActivity.f31046j.m38200U(), "accountPickerH5.signIn_v3", "api_ret");
                    WebViewActivity.this.mo38106b();
                    return;
                }
                if (WebViewActivity.this.f31046j.m38205Z()) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("retValue", this.f31101a);
                    WebViewActivity.this.setResult(8, intent2);
                    WebViewActivity webViewActivity2 = WebViewActivity.this;
                    C13056a.m78783c(webViewActivity2, 907115001, 200, this.f31101a, webViewActivity2.f31046j.m38200U(), "accountPickerH5.signIn_pageFromOtherApp", "api_ret");
                    WebViewActivity.this.mo38106b();
                    return;
                }
                if ((!"from_open_realNameInfo".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c()) && !"from_open_childInfo".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) || !this.f31101a.equalsIgnoreCase("atExpired")) {
                    WebViewActivity.this.f31046j.m38226l(7, this.f31101a, "");
                    return;
                }
                C10600n c10600n4 = new C10600n(2008, this.f31101a);
                C10601o c10601o2 = new C10601o(c10600n4);
                c10600n4.m64999e(false);
                if (!"from_open_childInfo".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) {
                    C6713n.this.m38157g(C12824c.m76987I(), c10601o2, this.f31101a, 907115010, "accountPickerH5.openRealNameInfo", 404);
                    return;
                }
                C12836o.m77097b("WebViewActivity", "enter intoApp = OPEN_CHILD_INFO ", true);
                C12836o.m77097b("WebViewActivity", "enter intoApp = OPEN_CHILD_INFO " + this.f31101a, false);
                C6713n.this.m38157g(C12824c.m76988J(), c10601o2, this.f31101a, 907115012, "accountPickerH5.openChildAccountDetailInfo", 2008);
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$h */
        public class h implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31103a;

            public h(String str) {
                this.f31103a = str;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38160j(this.f31103a);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "setForbiddenGoBackUrl get allowlist failed from file.", true);
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$i */
        public class i implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31105a;

            public i(String str) {
                this.f31105a = str;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38160j(this.f31105a);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                C12836o.m77097b("WebViewActivity", "setForbiddenGoBackUrl get allowlist failed.", true);
            }
        }

        /* renamed from: com.huawei.hwidauth.ui.WebViewActivity$n$j */
        public class j implements AbstractC12388f.d {

            /* renamed from: a */
            public final /* synthetic */ String f31107a;

            /* renamed from: b */
            public final /* synthetic */ String f31108b;

            public j(String str, String str2) {
                this.f31107a = str;
                this.f31108b = str2;
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38164a(C10343b c10343b) {
                C6713n.this.m38161k(this.f31107a, this.f31108b);
            }

            @Override // p587qq.AbstractC12388f.d
            /* renamed from: a */
            public void mo38163a(int i10, String str) {
                WebViewActivity.this.f31046j.m38226l(7, "match allowlist failed", "");
                WebViewActivity.this.finish();
            }
        }

        public C6713n() {
        }

        @JavascriptInterface
        public void callWeChatAuthorize(String str, String str2, String str3) {
            C12824c.m77021x(str);
            WebViewActivity.this.m38086C(str, str2, str3);
        }

        /* renamed from: g */
        public final void m38157g(InterfaceC10596j interfaceC10596j, InterfaceC10595i interfaceC10595i, String str, int i10, String str2, int i11) {
            if (interfaceC10596j == null || interfaceC10595i == null) {
                WebViewActivity webViewActivity = WebViewActivity.this;
                C13056a.m78783c(webViewActivity, i10, 404, "resultCallBack is null", webViewActivity.f31046j.m38200U(), str2, "api_ret");
            } else {
                interfaceC10596j.onResult(interfaceC10595i);
                WebViewActivity webViewActivity2 = WebViewActivity.this;
                C13056a.m78783c(webViewActivity2, i10, i11, str, webViewActivity2.f31046j.m38200U(), str2, "api_ret");
                WebViewActivity.this.finish();
            }
        }

        @JavascriptInterface
        public void getDevAuthCode(String str) {
            C12836o.m77097b("WebViewActivity", "getDevAuthCode " + str, false);
            WebViewActivity.this.f31042f = "0";
            if (C12827f.m77030c(WebViewActivity.this).m77041k()) {
                m38158h(str);
            } else if (C12827f.m77030c(WebViewActivity.this).m77045p()) {
                C12827f.m77030c(WebViewActivity.this).m77039f(new b(str));
            } else {
                C12827f.m77030c(WebViewActivity.this).m77044o(new d(str));
            }
        }

        /* renamed from: h */
        public final void m38158h(String str) {
            if (C12827f.m77030c(WebViewActivity.this).m77042l("getDevAuthCode", WebViewActivity.this.f31057u, WebViewActivity.this.f31038b)) {
                WebViewActivity.this.m38096R(str);
                return;
            }
            C12836o.m77097b("WebViewActivity", "getDevAuthCode allowlist match result: false", true);
            C13056a.m78783c(WebViewActivity.this, 907115013, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "interface getDevAuthCode check allowlist failed, url is " + WebViewActivity.this.f31057u, WebViewActivity.this.f31046j.m38200U(), "accountPickerH5.getDevAuthCode", "api_ret");
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.mo38104a(webViewActivity.f31046j.m38190K("1", "9999"));
        }

        /* renamed from: i */
        public final void m38159i(String str, String str2) {
            if (C12827f.m77030c(WebViewActivity.this).m77042l("getDevAuthCode", WebViewActivity.this.f31057u, WebViewActivity.this.f31038b)) {
                try {
                    WebViewActivity.this.f31042f = new JSONObject(str2).getString("oprType");
                } catch (JSONException unused) {
                    WebViewActivity.this.f31042f = "-1";
                    C12836o.m77099d("WebViewActivity", "JSONException", true);
                }
                WebViewActivity.this.m38096R(str);
                return;
            }
            C12836o.m77097b("WebViewActivity", "getDevAuthCode with two params allowlist match result: false", true);
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.mo38104a(webViewActivity.f31046j.m38190K("1", "9999"));
            C13056a.m78783c(WebViewActivity.this, 907115013, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "interface getDevAuthCode check allowlist failed, url is " + WebViewActivity.this.f31057u, WebViewActivity.this.f31046j.m38200U(), "accountPickerH5.getDevAuthCode", "api_ret");
        }

        @JavascriptInterface
        public void intoApp(String str) {
            C12836o.m77097b("WebViewActivity", "enter intoApp", true);
            C12836o.m77097b("WebViewActivity", "enter intoApp returnMsg = " + str, false);
            new Handler(WebViewActivity.this.getMainLooper()).post(new g(str));
        }

        /* renamed from: j */
        public final void m38160j(String str) {
            if (!C12827f.m77030c(WebViewActivity.this).m77042l("setForbiddenGoBackUrl", WebViewActivity.this.f31057u, WebViewActivity.this.f31038b)) {
                C12836o.m77097b("WebViewActivity", "setForbiddenGoBackUrl allowlist match result: false", true);
            } else {
                if (TextUtils.isEmpty(str) || WebViewActivity.this.f31045i.contains(str)) {
                    return;
                }
                WebViewActivity.this.f31045i.add(str);
            }
        }

        /* renamed from: k */
        public final void m38161k(String str, String str2) {
            if (C12827f.m77030c(WebViewActivity.this).m77042l("verifyResult", WebViewActivity.this.f31057u, WebViewActivity.this.f31038b)) {
                WebViewActivity.this.runOnUiThread(new c(str2));
                return;
            }
            C12836o.m77097b("WebViewActivity", "verifyResult allowlist match result: false", true);
            C13056a.m78783c(WebViewActivity.this, 907115013, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "interface verifyResult check allowlist failed, url is " + WebViewActivity.this.f31057u, WebViewActivity.this.f31046j.m38200U(), WebViewActivity.this.m38127l(), "api_ret");
            WebViewActivity.this.f31046j.m38226l(7, "match allowlist failed", "");
            WebViewActivity.this.finish();
        }

        /* renamed from: l */
        public final void m38162l(String str) {
            C12836o.m77097b("WebViewActivity", "handleSuccessMsg start.", true);
            if (WebViewActivity.this.m38095O()) {
                C10600n c10600n = new C10600n(501, str);
                C10599m c10599m = new C10599m(c10600n);
                c10600n.m64999e(true);
                m38157g(C12824c.m76990L(), c10599m, str, 907115004, "accountPickerH5.deleteAccount", 200);
                return;
            }
            if (WebViewActivity.this.m38098T()) {
                C10600n c10600n2 = new C10600n(502, str);
                C10599m c10599m2 = new C10599m(c10600n2);
                c10600n2.m64999e(true);
                m38157g(C12824c.m76990L(), c10599m2, str, 907115004, "accountPickerH5.appealSelf", 200);
                return;
            }
            if ("from_open_realNameInfo".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) {
                C10600n c10600n3 = new C10600n(503, str);
                C10601o c10601o = new C10601o(c10600n3);
                c10600n3.m64999e(true);
                m38157g(C12824c.m76987I(), c10601o, str, 907115010, "accountPickerH5.openRealNameInfo", 200);
                return;
            }
            if ("from_open_childInfo".equalsIgnoreCase(WebViewActivity.this.f31046j.m38208c())) {
                C10600n c10600n4 = new C10600n(504, str);
                C10601o c10601o2 = new C10601o(c10600n4);
                c10600n4.m64999e(true);
                m38157g(C12824c.m76987I(), c10601o2, str, 907115012, "accountPickerH5.openChildAccountDetailInfo", 200);
                return;
            }
            WebViewActivity.this.f31046j.m38226l(7, str, "");
            C12836o.m77097b("WebViewActivity", "enter intoApp returnMsg = " + str, false);
            WebViewActivity.this.finish();
        }

        @JavascriptInterface
        public void setForbiddenGoBackUrl(String str) {
            C12836o.m77097b("WebViewActivity", "setForbiddenGoBackUrl:" + str, false);
            if (C12827f.m77030c(WebViewActivity.this).m77041k()) {
                m38160j(str);
            } else if (C12827f.m77030c(WebViewActivity.this).m77045p()) {
                C12827f.m77030c(WebViewActivity.this).m77039f(new h(str));
            } else {
                C12827f.m77030c(WebViewActivity.this).m77044o(new i(str));
            }
        }

        @JavascriptInterface
        public void verifyResult(String str, String str2) {
            C12836o.m77097b("WebViewActivity", "checkUserPasswordResult start", true);
            if (C12827f.m77030c(WebViewActivity.this).m77041k()) {
                m38161k(str, str2);
            } else if (C12827f.m77030c(WebViewActivity.this).m77045p()) {
                C12827f.m77030c(WebViewActivity.this).m77039f(new j(str, str2));
            } else {
                C12827f.m77030c(WebViewActivity.this).m77044o(new a(str, str2));
            }
        }

        @JavascriptInterface
        public void getDevAuthCode(String str, String str2) {
            C12836o.m77097b("WebViewActivity", "getDevAuthCode " + str + "--param==" + str2, false);
            if (C12827f.m77030c(WebViewActivity.this).m77041k()) {
                m38159i(str, str2);
            } else if (C12827f.m77030c(WebViewActivity.this).m77045p()) {
                C12827f.m77030c(WebViewActivity.this).m77039f(new e(str, str2));
            } else {
                C12827f.m77030c(WebViewActivity.this).m77044o(new f(str, str2));
            }
        }
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: a */
    public void mo38104a(String str) {
        C12836o.m77097b("WebViewActivity", "callbackForJs ==", true);
        runOnUiThread(new RunnableC6712m(str));
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: a */
    public void mo38105a(boolean z10) {
        C12836o.m77097b("WebViewActivity", "setLoading loading =" + z10, true);
        RelativeLayout relativeLayout = this.f31041e;
        if (relativeLayout != null && z10) {
            relativeLayout.setVisibility(0);
            return;
        }
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f31041e.setVisibility(8);
        }
        m38101a();
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: a */
    public void mo38102a(int i10, Intent intent) {
        C12836o.m77097b("WebViewActivity", "exitApp finish", true);
        if (TextUtils.isEmpty(this.f31046j.m38215f0())) {
            C12836o.m77097b("WebViewActivity", "exitApp finish", true);
            finish();
        } else {
            setResult(i10, intent);
            finish();
        }
    }

    @Override // com.huawei.hwidauth.p167ui.InterfaceC6722g
    /* renamed from: a */
    public void mo38103a(int i10, String str) {
        runOnUiThread(new RunnableC6703d(i10, str));
    }

    /* renamed from: a */
    public void m38066a(int i10) throws IllegalAccessException, IllegalArgumentException {
        C12836o.m77097b("WebViewActivity", "enter -showChoosePicDialog", true);
        Uri uriM77107e = C12839r.m77107e(this);
        this.f31051o = uriM77107e;
        if (uriM77107e == null) {
            C12836o.m77097b("WebViewActivity", "showChoosePicDialog mTmpPicUri null", true);
            return;
        }
        this.f31052p = i10;
        AlertDialog alertDialogCreate = new AlertDialogBuilderC6716a(this, this.f31051o, new C6706g()).create();
        this.f31053q = alertDialogCreate;
        C12844w.m77132d(alertDialogCreate);
        this.f31053q.setCanceledOnTouchOutside(false);
        this.f31053q.setCancelable(false);
        this.f31053q.setOnCancelListener(new DialogInterfaceOnCancelListenerC6707h());
        C12836o.m77097b("WebViewActivity", "show showChoosePicDialog", true);
        if (isFinishing()) {
            return;
        }
        C12844w.m77132d(this.f31053q);
        this.f31053q.show();
    }
}
