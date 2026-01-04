package com.huawei.openalliance.p169ad.views.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7332jf;
import com.huawei.openalliance.p169ad.C7527nv;
import com.huawei.openalliance.p169ad.C7650rz;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7824dq;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.views.web.b */
/* loaded from: classes2.dex */
public class C8179b implements C7332jf.a {

    /* renamed from: a */
    private static final byte[] f38341a = new byte[0];

    /* renamed from: g */
    @SuppressLint({"StaticFieldLeak"})
    private static C8179b f38342g;

    /* renamed from: b */
    private WebView f38343b;

    /* renamed from: c */
    private C7332jf f38344c;

    /* renamed from: d */
    private Map<String, Integer> f38345d = new HashMap(5);

    /* renamed from: e */
    private String f38346e;

    /* renamed from: f */
    private final int f38347f;

    /* renamed from: com.huawei.openalliance.ad.views.web.b$a */
    public static class a {
        private a() {
        }

        @JavascriptInterface
        public boolean isPreload() {
            AbstractC7185ho.m43817a("PreloadWebView", "isPreload:true");
            return true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.web.b$b */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            AbstractC7185ho.m43817a("PreloadWebView", " onLoadResource url is :" + str);
            int iIntValue = C8179b.this.f38345d.get(C8179b.this.f38346e) != null ? ((Integer) C8179b.this.f38345d.get(C8179b.this.f38346e)).intValue() : 0;
            if (!C7824dq.m48388a(str) || iIntValue >= C8179b.this.f38347f) {
                AbstractC7185ho.m43817a("PreloadWebView", "don't download url :" + str);
            } else {
                C8179b.this.f38345d.put(C8179b.this.f38346e, Integer.valueOf(iIntValue + 1));
                C8179b.m50678b(webView.getContext(), str);
            }
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }
    }

    private C8179b(Context context) {
        AbstractC7811dd.m48331h(context);
        this.f38344c = new C7332jf(this);
        WebView webView = new WebView(context);
        this.f38343b = webView;
        webView.setWebViewClient(new b());
        this.f38343b.addJavascriptInterface(new a(), Constants.PPS_JS_NAME);
        C7527nv.m46233b(this.f38343b);
        this.f38343b.getSettings().setJavaScriptEnabled(false);
        this.f38347f = C7124fh.m43316b(context).mo43084r();
    }

    /* renamed from: a */
    public static C8179b m50673a(Context context) {
        C8179b c8179b;
        synchronized (f38341a) {
            try {
                if (f38342g == null) {
                    f38342g = new C8179b(context);
                }
                c8179b = f38342g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c8179b;
    }

    /* renamed from: b */
    private static void m50677b() {
        synchronized (f38341a) {
            f38342g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m50678b(final Context context, final String str) {
        final C7022dk c7022dkM41937a = C7019dh.m41937a(context, Constants.WEBVIEW_CACHE);
        c7022dkM41937a.m41958a(100);
        c7022dkM41937a.m41959a(Math.max(c7022dkM41937a.m41967c(), Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE));
        AbstractC7834m.m48485e(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.b.1
            @Override // java.lang.Runnable
            public void run() {
                C7653sb c7653sb = new C7653sb();
                c7653sb.m47181b(false);
                c7653sb.m47185c(true);
                c7653sb.m47190e(Constants.WEBVIEW_CACHE);
                c7653sb.m47166a(2000);
                c7653sb.m47176b(2000);
                c7653sb.m47187d(str);
                C7654sc c7654scM47158a = new C7650rz(context, c7653sb).m47158a();
                if (c7654scM47158a != null) {
                    String strM47207a = c7654scM47158a.m47207a();
                    if (TextUtils.isEmpty(strM47207a)) {
                        return;
                    }
                    AbstractC7185ho.m43818a("PreloadWebView", "download url is : %s , filePath is : %s", str, c7022dkM41937a.m41968c(strM47207a));
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.C7332jf.a
    /* renamed from: a */
    public void mo45287a() {
        WebView webView = this.f38343b;
        if (webView != null) {
            webView.destroy();
        }
        this.f38343b = null;
        this.f38344c = null;
        m50677b();
    }

    /* renamed from: a */
    public void m50680a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return;
        }
        AbstractC7185ho.m43820b("PreloadWebView", "preLoad begin");
        this.f38346e = str;
        this.f38343b.loadUrl(str);
        this.f38344c.m45285a();
        this.f38344c.m45286b();
    }
}
