package com.huawei.hwcloudjs;

import android.webkit.WebView;
import com.huawei.hwcloudjs.api.JsParam;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p152c.C6619a;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.jsmsg.NativeMsg;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.e */
/* loaded from: classes8.dex */
public class C6644e {

    /* renamed from: a */
    private static final String f30854a = "JSUtils";

    /* renamed from: a */
    public static JsParam m37836a(JsParam jsParam, String str, String str2, String str3) {
        if (jsParam != null) {
            jsParam.setAppId(str);
            jsParam.setWebUrl(str2);
            jsParam.setBridgeId(str3);
        }
        return jsParam;
    }

    /* renamed from: a */
    public static JSONObject m37837a(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            C6659d.m37881b(f30854a, "json2Object error", true);
            return null;
        }
    }

    /* renamed from: a */
    public static void m37838a(WebView webView) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
        } catch (JSONException unused) {
            C6659d.m37881b(f30854a, "jsReady  put data error", true);
        }
        m37842a(webView, C6619a.m37758a(C6619a.f30789i, jSONObject));
    }

    /* renamed from: a */
    public static void m37839a(WebView webView, int i10) throws JSONException {
        m37840a(webView, i10, "");
    }

    /* renamed from: a */
    public static void m37840a(WebView webView, int i10, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i10);
            jSONObject.put("message", str);
            m37842a(webView, C6619a.m37758a(C6619a.f30788h, jSONObject));
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public static void m37841a(WebView webView, NativeMsg nativeMsg) {
        m37842a(webView, C6619a.m37757a(nativeMsg));
    }

    /* renamed from: a */
    public static void m37842a(WebView webView, String str) {
        webView.post(new RunnableC6629d(webView, str));
    }

    /* renamed from: a */
    public static void m37843a(WebView webView, String str, int i10, String str2) throws JSONException {
        new JsCallback(webView, str, str2).failure(i10);
    }
}
