package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.views.linkscroll.C8142e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.openalliance.ad.utils.dq */
/* loaded from: classes2.dex */
public class C7824dq {

    /* renamed from: a */
    static final Pattern f36096a = Pattern.compile("\\S*[?]\\S*");

    /* renamed from: b */
    private static final ArrayList<String> f36097b;

    /* renamed from: c */
    private static final Map<String, String> f36098c;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f36097b = arrayList;
        HashMap map = new HashMap();
        f36098c = map;
        arrayList.add("html");
        arrayList.add("js");
        arrayList.add("png");
        arrayList.add("jpg");
        arrayList.add("svg");
        arrayList.add(MetaCreativeType.GIF);
        arrayList.add("css");
        map.put("html", "text/html");
        map.put("js", "application/x-javascript");
        map.put("png", MimeType.PNG);
        map.put("jpg", FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        map.put("svg", "image/svg+xml");
        map.put(MetaCreativeType.GIF, MimeType.GIF);
        map.put("css", "text/css");
    }

    /* renamed from: a */
    public static WebView m48386a(Context context) {
        String str;
        try {
            AbstractC7185ho.m43820b("WebViewUtil", "createWebview android sdk: " + Build.VERSION.SDK_INT);
            try {
                return context.isDeviceProtectedStorage() ? new C8142e((Context) AbstractC7791ck.m48057a(context, "createCredentialProtectedStorageContext", (Class<?>[]) null, (Object[]) null)) : new C8142e(context);
            } catch (IllegalArgumentException unused) {
                str = "createWebview IllegalArgumentException";
                AbstractC7185ho.m43826d("WebViewUtil", str);
                return null;
            } catch (Exception unused2) {
                str = "createWebview Exception";
                AbstractC7185ho.m43826d("WebViewUtil", str);
                return null;
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("WebViewUtil", "fail to create webview, " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: b */
    public static String m48389b(String str) {
        return f36098c.get(m48390c(str).toLowerCase(Locale.ENGLISH));
    }

    /* renamed from: c */
    private static String m48390c(String str) {
        Matcher matcher = f36096a.matcher(str);
        String[] strArrSplit = str.split("/");
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (matcher.find()) {
            String[] strArrSplit2 = str2.split("\\?")[0].split("\\.");
            return strArrSplit2.length == 1 ? "" : strArrSplit2[strArrSplit2.length - 1];
        }
        String[] strArrSplit3 = str2.split("\\.");
        return strArrSplit3.length == 1 ? "" : strArrSplit3[strArrSplit3.length - 1];
    }

    /* renamed from: a */
    public static void m48387a(WebView webView) {
        WebSettings settings;
        if (webView == null || (settings = webView.getSettings()) == null) {
            return;
        }
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setGeolocationEnabled(false);
        settings.setAllowContentAccess(false);
    }

    /* renamed from: a */
    public static boolean m48388a(String str) {
        return f36097b.contains(m48390c(str).toLowerCase(Locale.ENGLISH));
    }
}
