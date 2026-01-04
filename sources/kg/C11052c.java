package kg;

import ag.C0194d;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.feedback.FeedbackSdkProcessor;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import mg.C11465a;
import mg.C11466b;
import mg.InterfaceC11467c;
import ng.C11702i;
import ng.C11703j;
import p015ak.C0209d;
import p373iu.C10620h;
import p422k9.C11018a;
import p575qe.C12347f;
import p616rk.C12515a;
import p655te.C13009a;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;
import sm.C12817a;
import tm.C13040c;

/* renamed from: kg.c */
/* loaded from: classes4.dex */
public class C11052c extends C12817a {

    /* renamed from: a */
    public final Activity f52213a;

    /* renamed from: b */
    public final boolean f52214b;

    /* renamed from: c */
    public final String f52215c;

    /* renamed from: d */
    public boolean f52216d = true;

    /* renamed from: e */
    public boolean f52217e = false;

    /* renamed from: f */
    public InterfaceC11467c f52218f;

    /* renamed from: g */
    public C0194d f52219g;

    /* renamed from: kg.c$a */
    public static class a extends AbstractC9478g {

        /* renamed from: a */
        public Activity f52220a;

        /* renamed from: b */
        public WebView f52221b;

        /* renamed from: c */
        public String f52222c;

        /* renamed from: d */
        public C11052c f52223d;

        public a(Activity activity, WebView webView, String str, C11052c c11052c) {
            this.f52220a = activity;
            this.f52221b = webView;
            this.f52222c = str;
            this.f52223d = c11052c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            this.f52223d.m66616i(this.f52221b, -1, this.f52222c);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f52220a == null) {
                C13981a.m83988e("WapWebViewClient", "activity null");
                return;
            }
            if (!C11702i.m69796l(this.f52222c)) {
                C13981a.m83988e("WapWebViewClient", "isAccDomain false");
                this.f52220a.runOnUiThread(new Runnable() { // from class: kg.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f52210a.lambda$call$0();
                    }
                });
                return;
            }
            final String str = "javascript:autoLogin(\"10055832\",\"" + C11702i.m69786b() + "\")";
            this.f52220a.runOnUiThread(new Runnable() { // from class: kg.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f52211a.m66621e(str);
                }
            });
        }

        /* renamed from: e */
        public final /* synthetic */ void m66621e(String str) {
            C13981a.m83989i("WapWebViewClient", "js autoLogin");
            this.f52221b.loadUrl(str);
        }
    }

    public C11052c(Activity activity, boolean z10, String str) {
        this.f52213a = activity;
        this.f52214b = z10;
        this.f52215c = str;
    }

    /* renamed from: b */
    public final void m66609b(Activity activity, WebView webView, String str, C11052c c11052c) {
        C12515a.m75110o().m75172d(new a(activity, webView, str, c11052c));
    }

    /* renamed from: c */
    public void m66610c() {
        C0194d c0194d = this.f52219g;
        if (c0194d != null) {
            c0194d.m1088j();
        }
    }

    /* renamed from: d */
    public final boolean m66611d(String str) throws UnsupportedEncodingException {
        String strM80790C;
        Map<String, String> mapM69822r = C11703j.m69822r(str);
        if (mapM69822r.size() <= 0) {
            C13981a.m83988e("WapWebViewClient", "url parsed is empty");
            return false;
        }
        String str2 = mapM69822r.get(Constants.CONTENT_SERVER_REALM);
        if (TextUtils.isEmpty(str2)) {
            C13981a.m83988e("WapWebViewClient", "action is empty");
            return false;
        }
        strM80790C = C13452e.m80781L().m80790C();
        str2.hashCode();
        switch (str2) {
            case "logout":
                C11702i.m69785a();
                C13009a.m78310e(this.f52213a, "app_findphone_main_click_logout", "findphone_logout", strM80790C);
                C12797b.m76777l(this.f52213a, "success", null, "01020", 1, "0", "logout", C13452e.m80781L().m80971t0(), C13009a.m78313h(this.f52214b));
                this.f52213a.finish();
                break;
            case "feedback":
                m66612e();
                C13009a.m78310e(this.f52213a, "app_findphone_main_click_feedback", "findphone_suggestions", strM80790C);
                break;
            case "customer":
                if (AbstractC12139d.m72769h(this.f52213a)) {
                    if (this.f52219g == null) {
                        this.f52219g = new C0194d();
                    }
                    this.f52219g.m1084e(this.f52213a.getApplicationContext());
                }
                FeedbackSdkProcessor.getInstance(this.f52213a, new C11018a()).jumpToSdkView(this.f52213a, 1, false);
                C13009a.m78310e(this.f52213a, "app_findphone_main_click_help", "findphone_help_service", strM80790C);
                C13981a.m83989i("WapWebViewClient", "start help and service activity");
                break;
            case "setting":
                C13981a.m83989i("WapWebViewClient", "startActivity MoreSettingActivity");
                if ("com.huawei.android.findmyphone".equals(this.f52215c)) {
                    m66615h(this.f52213a, mapM69822r);
                    C13009a.m78310e(this.f52213a, "app_findphone_main_click_setting", "findphone_setting", strM80790C);
                    break;
                }
                break;
        }
        C13981a.m83989i("WapWebViewClient", "switch over");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z10) {
        C13981a.m83989i("WapWebViewClient", "url in doUpdateVisitedHistory is:" + C11703j.m69807c(str));
        if (m66614g(webView, str)) {
            this.f52217e = true;
            webView.clearHistory();
        } else {
            this.f52217e = false;
            String strM69811g = C11703j.m69811g(str);
            if ("/CAS/mobile/standard/login.html".equals(strM69811g) || "/CAS/mobile/standard/wapLogin.html".equals(strM69811g)) {
                webView.clearHistory();
                C11702i.m69802r(this.f52213a, false);
            }
        }
        super.doUpdateVisitedHistory(webView, str, z10);
    }

    /* renamed from: e */
    public void m66612e() {
        FeedbackSdkProcessor.getInstance(this.f52213a, new C11018a()).jumpToSdkView(this.f52213a, 2, false);
    }

    /* renamed from: f */
    public boolean m66613f() {
        return this.f52217e;
    }

    /* renamed from: g */
    public final boolean m66614g(WebView webView, String str) {
        if (!C11702i.m69797m(str)) {
            return false;
        }
        if (str.endsWith("#/home")) {
            return true;
        }
        if (!str.endsWith("#/eu")) {
            return false;
        }
        C11702i.m69785a();
        return true;
    }

    /* renamed from: h */
    public final void m66615h(Activity activity, Map<String, String> map) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.findmyphone.action.SETTING");
            C0209d.m1302r2(intent, "com.huawei.android.findmyphone");
            intent.putExtra("isSystemAcc", this.f52214b);
            intent.putExtra(JsbMapKeyNames.H5_USER_ID, C11702i.m69795k());
            intent.putExtra(HwPayConstant.KEY_USER_NAME, map.get(HwPayConstant.KEY_USER_NAME));
            intent.putExtra("userPic", map.get("userPic"));
            activity.startActivity(intent);
        } catch (Exception unused) {
            C13981a.m83988e("WapWebViewClient", "startActivity MoreSettingActivity exception!");
        }
    }

    /* renamed from: i */
    public final void m66616i(WebView webView, int i10, String str) {
        if (webView == null) {
            return;
        }
        webView.loadUrl("about:blank");
        C11465a c11465a = new C11465a(C11466b.c.LOAD_FINISH);
        c11465a.m68576g(str);
        c11465a.m68574e(i10);
        InterfaceC11467c interfaceC11467c = this.f52218f;
        if (interfaceC11467c != null) {
            interfaceC11467c.mo68580a(c11465a);
        }
    }

    /* renamed from: j */
    public void m66617j(InterfaceC11467c interfaceC11467c) {
        this.f52218f = interfaceC11467c;
    }

    /* renamed from: k */
    public void m66618k() {
        this.f52216d = true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C13981a.m83987d("WapWebViewClient", "onPageFinished url is " + C11703j.m69807c(str));
        if (this.f52216d && this.f52214b && "/CAS/mobile/atLogin.html".equals(C11703j.m69811g(str))) {
            this.f52216d = false;
            m66609b(this.f52213a, webView, str, this);
        }
        C11465a c11465a = new C11465a(C11466b.c.LOAD_FINISH);
        c11465a.m68576g(str);
        c11465a.m68575f(System.currentTimeMillis());
        InterfaceC11467c interfaceC11467c = this.f52218f;
        if (interfaceC11467c != null) {
            interfaceC11467c.mo68582c(c11465a);
        }
        Activity activity = this.f52213a;
        if (activity instanceof WapFindPhoneActivity) {
            WapFindPhoneActivity wapFindPhoneActivity = (WapFindPhoneActivity) activity;
            if (C0209d.m1333z1(wapFindPhoneActivity)) {
                wapFindPhoneActivity.m27849l5(C11703j.m69823s(str, webView.getTitle()));
            } else {
                C13981a.m83988e("WapWebViewClient", "net is not connected");
                wapFindPhoneActivity.m27699l2();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C13981a.m83989i("WapWebViewClient", "onPageStarted url is:" + C11703j.m69807c(str));
        if (!TextUtils.isEmpty(str) && str.endsWith("/CAS/mobile/standard/wapLogin.html")) {
            m66616i(webView, -1, str);
            return;
        }
        C11465a c11465a = new C11465a(C11466b.c.LOAD_START);
        c11465a.m68576g(str);
        c11465a.m68575f(System.currentTimeMillis());
        InterfaceC11467c interfaceC11467c = this.f52218f;
        if (interfaceC11467c != null) {
            interfaceC11467c.mo68581b(c11465a);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        C13981a.m83988e("WapWebViewClient", "onReceivedError,errorCode is:" + i10);
        m66616i(webView, i10, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            int statusCode = webResourceResponse.getStatusCode();
            C13981a.m83989i("WapWebViewClient", "onReceivedHttpError url is:" + C11703j.m69806b(webResourceRequest.getUrl()) + ",errorCode is:" + statusCode);
            if (statusCode == 404 || statusCode == 500 || statusCode == 502) {
                m66616i(webView, statusCode, C11703j.m69806b(webResourceRequest.getUrl()));
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C13981a.m83988e("WapWebViewClient", "onReceivedSslError,url is:" + C11703j.m69807c(sslError.getUrl()));
        try {
            C10620h.m65082a(sslErrorHandler, sslError, C12347f.m74285n().m74301m());
        } catch (Exception unused) {
            C13981a.m83988e("WapWebViewClient", "WapWebViewClient onReceivedSslError exception");
            sslErrorHandler.cancel();
        }
    }

    @Override // sm.C12817a, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (this.f52213a == null) {
            return true;
        }
        C13981a.m83989i("WapWebViewClient", "onRenderProcessGone");
        this.f52213a.finish();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!C0209d.m1333z1(this.f52213a)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("WapWebViewClient", "url in shouldOverrideUrlLoading is empty");
            return false;
        }
        C13981a.m83989i("WapWebViewClient", "url in shouldOverrideUrlLoading is:" + C11703j.m69807c(str));
        if (str.startsWith("http") || str.startsWith("https")) {
            return false;
        }
        if (str.startsWith("phonefinder:")) {
            return m66611d(str);
        }
        C11703j.m69820p(this.f52213a, str);
        C13981a.m83989i("WapWebViewClient", "shouldOverrideUrlLoading over");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        C13981a.m83988e("WapWebViewClient", "onReceivedError errCode:" + webResourceError.getErrorCode() + ", errDescription:" + ((Object) webResourceError.getDescription()));
        String string = webResourceRequest.getUrl().toString();
        String strM69789e = C11702i.m69789e();
        if (string.startsWith(strM69789e)) {
            int errorCode = webResourceError.getErrorCode();
            if (errorCode == -2 || errorCode == -6 || errorCode == -7) {
                C13981a.m83988e("WapWebViewClient", "onReceivedError connect error");
                try {
                    C13981a.m83989i("WapWebViewClient", "onReceivedError RefreshGrsUrl");
                    C13040c.m78609F().m78651i();
                    C13452e.m80781L().m80988x1("from_findWapRefresh");
                    if (!StringUtil.equals(strM69789e, C13040c.m78609F().m78625Q())) {
                        C13981a.m83989i("WapWebViewClient", "onReceivedError reloadPortal");
                        Activity activity = this.f52213a;
                        if (activity instanceof WapFindPhoneActivity) {
                            ((WapFindPhoneActivity) activity).m27822V4();
                        }
                    } else {
                        C13981a.m83989i("WapWebViewClient", "onReceivedError loadPageError");
                        m66616i(webView, webResourceError.getErrorCode(), string);
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("WapWebViewClient", "getPortalHost error " + e10.getMessage());
                }
            }
        }
    }
}
