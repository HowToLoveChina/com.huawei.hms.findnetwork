package com.huawei.hwcloudjs.core;

import android.webkit.WebView;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.support.enables.INoProguard;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class JsCallback implements INoProguard {

    /* renamed from: a */
    private static final int f30792a = 0;

    /* renamed from: b */
    private static final int f30793b = 9999;

    /* renamed from: c */
    private static final String f30794c = "JsCallback";

    /* renamed from: d */
    private static final String f30795d = "javascript:%s.callback(%s,%s,%d);";

    /* renamed from: e */
    private final String f30796e;

    /* renamed from: f */
    private WeakReference<WebView> f30797f;

    /* renamed from: g */
    private String f30798g;

    /* renamed from: h */
    private String f30799h;

    /* renamed from: com.huawei.hwcloudjs.core.JsCallback$a */
    public static class RunnableC6620a implements Runnable {

        /* renamed from: a */
        private WebView f30800a;

        /* renamed from: b */
        private String f30801b;

        public RunnableC6620a(WebView webView, String str) {
            this.f30800a = webView;
            this.f30801b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f30800a.getSettings().setSavePassword(false);
            this.f30800a.loadUrl(this.f30801b);
        }
    }

    public JsCallback(WebView webView, String str, String str2) {
        this.f30798g = str2;
        this.f30797f = new WeakReference<>(webView);
        this.f30796e = "\"" + str + "\"";
        this.f30799h = str;
    }

    /* renamed from: a */
    private String m37759a(String str) {
        return str;
    }

    public final void failure() {
        failure(9999);
    }

    public WebView getWebView() {
        return this.f30797f.get();
    }

    public String getwebviewId() {
        return this.f30798g;
    }

    public final void success() {
        success("{}");
    }

    /* renamed from: a */
    private void m37760a(WebView webView, String str) {
        webView.post(new RunnableC6620a(webView, str));
    }

    public final void failure(int i10) throws JSONException {
        failure(i10, "");
    }

    public final void success(Object obj) {
        m37761a(new C6624b().m37770a(obj), 0);
    }

    /* renamed from: a */
    private void m37761a(String str, int i10) {
        WebView webView = getWebView();
        if (webView == null) {
            return;
        }
        m37760a(webView, String.format(Locale.ENGLISH, f30795d, "hbs", this.f30796e, str, Integer.valueOf(i10)));
    }

    public final void failure(int i10, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i10);
            jSONObject.put("message", str);
        } catch (JSONException unused) {
            C6659d.m37881b(f30794c, "failure put json error", true);
        }
        m37761a(m37759a(jSONObject.toString()), i10);
    }

    public final void success(String str) {
        m37761a(m37759a(str), 0);
    }

    public final void failure(String str) throws JSONException {
        failure(9999, str);
    }
}
