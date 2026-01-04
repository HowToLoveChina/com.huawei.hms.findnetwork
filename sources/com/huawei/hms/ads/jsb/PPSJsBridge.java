package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.huawei.hms.ads.jsb.annotations.OuterVisible;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.ads.jsb.inner.impl.JsBridgeImpl;
import com.huawei.hms.ads.jsbridge.C5094a;
import com.huawei.hms.ads.jsbridge.C5095b;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

@OuterVisible
/* loaded from: classes8.dex */
public class PPSJsBridge extends C5094a {

    /* renamed from: a */
    private static JsbConfig f23239a;

    /* renamed from: b */
    private String f23240b = null;

    /* renamed from: c */
    private WeakReference<WebView> f23241c;

    /* renamed from: d */
    private IWebView f23242d;

    /* renamed from: e */
    private boolean f23243e;

    @OuterVisible
    public PPSJsBridge(WebView webView) {
        if (webView == null) {
            C5095b.m30398b("webView object is null, cannot register it.");
            return;
        }
        m30351b(webView);
        m30345a();
        webView.addJavascriptInterface(this, "_HwJSBridge");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Context m30349b() {
        WebView webView;
        if (this.f23243e) {
            IWebView iWebView = this.f23242d;
            if (iWebView != null) {
                Context context = iWebView.getContext();
                if (context == null) {
                    C5095b.m30398b("custom webView context is null.");
                }
                return context;
            }
        } else {
            WeakReference<WebView> weakReference = this.f23241c;
            if (weakReference != null && (webView = weakReference.get()) != null) {
                return webView.getContext();
            }
        }
        C5095b.m30398b("the webview context is null.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m30353c() {
        if (this.f23243e) {
            IWebView iWebView = this.f23242d;
            if (iWebView != null) {
                return m30395a(iWebView);
            }
            return null;
        }
        WeakReference<WebView> weakReference = this.f23241c;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return m30394a(this.f23241c.get());
    }

    @OuterVisible
    public static void init(JsbConfig jsbConfig) {
        f23239a = jsbConfig;
    }

    @OuterVisible
    public void destroy() {
        if (this.f23240b != null) {
            JsBridgeImpl.invoke(m30349b(), "pps.listener.offDownloadChange", "{webid:" + this.f23240b + "}", null, String.class);
        }
        WeakReference<WebView> weakReference = this.f23241c;
        if (weakReference != null) {
            weakReference.clear();
        }
        IWebView iWebView = this.f23242d;
        if (iWebView != null) {
            iWebView.removeJavascriptInterface("_HwJSBridge");
            this.f23242d = null;
        }
    }

    @JavascriptInterface
    public String invoke(String str, String str2) {
        WeakReference<WebView> weakReference = this.f23241c;
        if (weakReference != null && weakReference.get() != null) {
            return JsBridgeImpl.invoke(this.f23241c.get().getContext(), str, str2);
        }
        C5095b.m30398b("this webView is destroyed");
        return null;
    }

    @JavascriptInterface
    public void invokeAsync(final String str, final String str2, final String str3) {
        final JSONObject jSONObject = new JSONObject();
        C5094a.m30391a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                String string = str2;
                final boolean zOptBoolean = true;
                final String strOptString = null;
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    zOptBoolean = jSONObject2.optBoolean(Constant.MAP_KEY_TOP, true);
                    strOptString = jSONObject2.optString("uuid");
                    if (!TextUtils.isEmpty(jSONObject2.optString("webid"))) {
                        PPSJsBridge.this.f23240b = jSONObject2.optString("webid");
                    }
                    jSONObject2.put("url", PPSJsBridge.this.m30353c());
                    string = jSONObject2.toString();
                } catch (Throwable unused) {
                    C5095b.m30398b("jsb response data error.");
                }
                Context contextM30349b = PPSJsBridge.this.m30349b();
                if (contextM30349b == null) {
                    C5095b.m30398b("invoke method param context is null.");
                }
                JsBridgeImpl.invoke(contextM30349b, str, string, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1.1
                    @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str4, CallResult<String> callResult) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(callResult.getData());
                            boolean zOptBoolean2 = jSONObject3.optBoolean("complete", true);
                            jSONObject.put("code", callResult.getCode());
                            jSONObject.put("data", jSONObject3);
                            jSONObject.put("msg", callResult.getMsg());
                            RunnableC50881 runnableC50881 = RunnableC50881.this;
                            PPSJsBridge.this.m30348a(str3, jSONObject.toString(), zOptBoolean2, zOptBoolean, strOptString);
                        } catch (Throwable unused2) {
                            C5095b.m30398b("jsb response data error.");
                        }
                    }
                }, String.class);
            }
        });
    }

    @OuterVisible
    public PPSJsBridge(IWebView iWebView) {
        if (iWebView == null) {
            C5095b.m30398b("webView object is null, cannot register it.");
            return;
        }
        m30352b(iWebView);
        m30345a();
        iWebView.addJavascriptInterface(this, "_HwJSBridge");
    }

    /* renamed from: a */
    private void m30345a() {
        JsBridgeImpl.initConfig(m30349b(), f23239a);
    }

    /* renamed from: b */
    private void m30351b(WebView webView) {
        this.f23241c = new WeakReference<>(webView);
    }

    /* renamed from: b */
    private void m30352b(IWebView iWebView) {
        this.f23243e = true;
        this.f23242d = iWebView;
    }

    /* renamed from: a */
    private void m30347a(final String str) {
        C5094a.m30391a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (PPSJsBridge.this.f23243e) {
                    if (PPSJsBridge.this.f23242d != null) {
                        PPSJsBridge.this.f23242d.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.1
                            @Override // android.webkit.ValueCallback
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceiveValue(String str3) {
                            }
                        });
                        return;
                    }
                    str2 = "please register a custom webView object to jsb.";
                } else {
                    if (PPSJsBridge.this.f23241c != null && PPSJsBridge.this.f23241c.get() != null) {
                        ((WebView) PPSJsBridge.this.f23241c.get()).evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.2
                            @Override // android.webkit.ValueCallback
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceiveValue(String str3) {
                            }
                        });
                        return;
                    }
                    str2 = "please register a webView object to jsb.";
                }
                C5095b.m30398b(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m30348a(String str, String str2, boolean z10, boolean z11, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z11) {
            str4 = String.format(Locale.ENGLISH, "if(window['%s']){%s(%s)};", str, str, str2);
            if (z10) {
                str4 = str4 + "delete window." + str;
            }
        } else {
            if (str3 == null) {
                str3 = "";
            }
            str4 = "var iframeEles=document.querySelectorAll('iframe');if(iframeEles && iframeEles.length>0){for (let index = 0; index < iframeEles.length; index++) {var iframe = iframeEles[index];if (iframe &&iframe.contentWindow) {iframe.contentWindow.postMessage({ppsMsgType:1,data:" + str2 + ",cb:'" + str + "',complete:" + z10 + ",uuid:'" + str3 + "'},'*');}}};var myEvent = new CustomEvent(\"tmp\", {detail:{ppsMsgType:1,data:" + str2 + ",cb:'" + str + "',complete:" + z10 + ",uuid:'" + str3 + "'}});window.dispatchEvent(myEvent);";
        }
        m30347a(str4);
    }
}
