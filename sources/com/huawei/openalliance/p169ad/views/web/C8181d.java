package com.huawei.openalliance.p169ad.views.web;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.web.C8184g;

/* renamed from: com.huawei.openalliance.ad.views.web.d */
/* loaded from: classes2.dex */
public class C8181d extends WebViewClient {

    /* renamed from: a */
    private static final String f38356a = "d";

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        String str = f38356a;
        AbstractC7185ho.m43824c(str, "onReceivedSslError %s", sslError);
        if (webView == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b(str, "WebView ssl check");
            C8183f.m50695a(sslErrorHandler, sslError, sslError.getUrl(), webView.getContext().getApplicationContext(), new C8184g.a() { // from class: com.huawei.openalliance.ad.views.web.d.1
                @Override // com.huawei.openalliance.p169ad.views.web.C8184g.a
                /* renamed from: a */
                public void mo50687a(Context context, String str2) {
                    AbstractC7185ho.m43818a(C8181d.f38356a, "onProceed:%s", str2);
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SslErrorHandler sslErrorHandler2 = sslErrorHandler;
                            if (sslErrorHandler2 != null) {
                                sslErrorHandler2.proceed();
                            }
                        }
                    });
                }

                @Override // com.huawei.openalliance.p169ad.views.web.C8184g.a
                /* renamed from: b */
                public void mo50688b(Context context, String str2) {
                    AbstractC7185ho.m43818a(C8181d.f38356a, "onCancel:%s", str2);
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.d.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            C8181d.this.mo50686a(webView, sslErrorHandler, sslError);
                        }
                    });
                }
            });
        } catch (Exception | NoClassDefFoundError e10) {
            AbstractC7185ho.m43823c(f38356a, e10.getClass().getSimpleName());
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return true;
    }

    /* renamed from: a */
    public void mo50682a(WebView webView) {
    }

    /* renamed from: a */
    public void mo50686a(final WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        AbstractC7185ho.m43817a(f38356a, "handleSslError");
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.d.2
            @Override // java.lang.Runnable
            public void run() {
                C8181d.this.mo50682a(webView);
            }
        });
    }
}
