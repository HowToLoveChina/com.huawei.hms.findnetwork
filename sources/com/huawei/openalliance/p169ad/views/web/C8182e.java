package com.huawei.openalliance.p169ad.views.web;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7781ca;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w;
import java.net.URISyntaxException;

/* renamed from: com.huawei.openalliance.ad.views.web.e */
/* loaded from: classes2.dex */
public class C8182e extends C8181d {

    /* renamed from: a */
    private static final String f38365a = "e";

    /* renamed from: b */
    private ProgressBar f38366b;

    /* renamed from: c */
    private InterfaceC8130w f38367c;

    public C8182e(InterfaceC8130w interfaceC8130w) {
        this.f38367c = interfaceC8130w;
    }

    /* renamed from: b */
    private void m50690b() {
        AbstractC7185ho.m43820b(f38365a, "onPageFinished");
        this.f38367c.mo49764c();
    }

    /* renamed from: c */
    private String m50692c() {
        return C6982bz.m41148a(this.f38367c.getContext()).mo41175d() ? "com.android.browser" : "com.android.chrome";
    }

    @Override // com.huawei.openalliance.p169ad.views.web.C8181d
    /* renamed from: a */
    public void mo50682a(WebView webView) {
        AbstractC7185ho.m43820b(f38365a, "onReceivedError");
        webView.loadUrl("about:blank");
        ProgressBar progressBar = this.f38366b;
        if (progressBar != null && progressBar.getVisibility() == 0) {
            this.f38366b.setVisibility(4);
        }
        InterfaceC8130w interfaceC8130w = this.f38367c;
        if (interfaceC8130w != null) {
            interfaceC8130w.mo49759a();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ProgressBar progressBar = this.f38366b;
        if (progressBar != null) {
            progressBar.setVisibility(4);
            this.f38366b.setProgress(100);
        }
        m50690b();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AbstractC7185ho.m43818a(f38365a, "onPageStarted url=%s", str);
        ProgressBar progressBar = this.f38366b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        super.onReceivedError(webView, i10, str, str2);
        AbstractC7185ho.m43818a(f38365a, "onReceivedError description:%s", str);
        mo50682a(webView);
    }

    @Override // com.huawei.openalliance.p169ad.views.web.C8181d, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        AbstractC7185ho.m43818a(f38365a, "WebResourceRequest url=%s", webResourceRequest.getUrl().toString());
        String string = webResourceRequest.getUrl().toString();
        if (m50689a(string)) {
            return true;
        }
        m50691b(string);
        return true;
    }

    /* renamed from: b */
    private void m50691b(String str) {
        String str2;
        String str3;
        Context context = this.f38367c.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C7781ca c7781ca = new C7781ca(context);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        String strM47874a = c7781ca.m47874a(intent);
        AbstractC7185ho.m43818a(f38365a, "preferred browser:%s", strM47874a);
        if (!TextUtils.isEmpty(strM47874a)) {
            intent.setPackage(strM47874a);
        } else if (c7781ca.m47875a(m50692c())) {
            intent.setPackage(m50692c());
        }
        try {
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, C6849R.string.no_browser_tips, 1).show();
            str2 = f38365a;
            str3 = "openUrlByBrowser ActivityNotFoundException";
            AbstractC7185ho.m43826d(str2, str3);
        } catch (Exception unused2) {
            str2 = f38365a;
            str3 = "openUrlByBrowser Exception";
            AbstractC7185ho.m43826d(str2, str3);
        }
    }

    /* renamed from: a */
    public void m50693a(ProgressBar progressBar) {
        this.f38366b = progressBar;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        AbstractC7185ho.m43818a(f38365a, "onReceivedError error:%s", webResourceError.getDescription());
        mo50682a(webView);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        AbstractC7185ho.m43818a(f38365a, "shouldOverrideUrlLoading url=%s", str);
        if (m50689a(str)) {
            return true;
        }
        m50691b(str);
        return true;
    }

    /* renamed from: a */
    private boolean m50689a(String str) throws URISyntaxException {
        Context context = this.f38367c.getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.equals(str, "oobe://more")) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName("com.huawei.systemmanager", "com.huawei.dataprivacycenter.MainActivity");
                    intent.setClipData(Constants.CLIP_DATA);
                    context.startActivity(intent);
                } catch (Exception e10) {
                    AbstractC7185ho.m43823c(f38365a, e10.getClass().getSimpleName());
                }
                return true;
            }
            if (!str.startsWith("http")) {
                try {
                    Intent uri = Intent.parseUri(str, 1);
                    uri.addCategory("android.intent.category.BROWSABLE");
                    uri.setComponent(null);
                    uri.setSelector(null);
                    if (context.getPackageManager().queryIntentActivities(uri, 0).size() > 0) {
                        uri.setClipData(Constants.CLIP_DATA);
                        context.startActivity(uri);
                    }
                } catch (URISyntaxException e11) {
                    AbstractC7185ho.m43823c(f38365a, e11.getClass().getSimpleName());
                }
                return true;
            }
        }
        return false;
    }
}
