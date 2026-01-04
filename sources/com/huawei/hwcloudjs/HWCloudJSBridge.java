package com.huawei.hwcloudjs;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.huawei.hwcloudjs.api.JsParam;
import com.huawei.hwcloudjs.core.C6624b;
import com.huawei.hwcloudjs.core.C6626d;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.core.p153a.C6622a;
import com.huawei.hwcloudjs.core.p153a.C6623b;
import com.huawei.hwcloudjs.p152c.C6619a;
import com.huawei.hwcloudjs.p154d.p155a.C6632c;
import com.huawei.hwcloudjs.p160e.p163b.InterfaceC6653b;
import com.huawei.hwcloudjs.p164f.C6657b;
import com.huawei.hwcloudjs.p164f.C6658c;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.p164f.C6660e;
import com.huawei.hwcloudjs.p164f.C6663h;
import com.huawei.hwcloudjs.service.jsapi.JsCoreApi;
import com.huawei.hwcloudjs.service.jsmsg.C6692a;
import com.huawei.hwcloudjs.service.jsmsg.NativeMsg;
import com.huawei.hwcloudjs.support.enables.INoProguard;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HWCloudJSBridge implements InterfaceC6653b<NativeMsg>, INoProguard {

    /* renamed from: a */
    private static final String f30722a = "HWCloudJSBridge";

    /* renamed from: c */
    private String f30724c;

    /* renamed from: b */
    private WebView f30723b = null;

    /* renamed from: d */
    private final List<String> f30725d = new ArrayList();

    /* renamed from: e */
    private HashMap<String, String> f30726e = new HashMap<>();

    public HWCloudJSBridge() {
        this.f30724c = "";
        this.f30724c = (C6663h.m37899a() + System.currentTimeMillis()) + "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m37743b(String str, String str2, List<String> list, JSONObject jSONObject) {
        C6626d.m37771a().m37772a(this.f30723b.getContext(), str, str2, this.f30724c, list, jSONObject);
    }

    public void attach(WebView webView) {
        this.f30723b = webView;
        webView.addJavascriptInterface(this, "hbssdk");
        C6692a.m37996a().mo37870b(this);
        C6659d.m37882c(f30722a, "attach begin", true);
    }

    @JavascriptInterface
    public void config(String str) throws JSONException {
        C6659d.m37882c(f30722a, "config begin", true);
        JSONObject jSONObjectM37837a = C6644e.m37837a(str);
        if (jSONObjectM37837a == null) {
            C6659d.m37881b(f30722a, "callJson == null", true);
            C6644e.m37839a(this.f30723b, 13);
            return;
        }
        String strOptString = jSONObjectM37837a.optString("appId");
        if (TextUtils.isEmpty(strOptString)) {
            C6659d.m37881b(f30722a, "appId isEmpty", true);
            C6644e.m37839a(this.f30723b, 13);
            return;
        }
        String strM37872a = C6657b.m37872a(this.f30723b);
        if (TextUtils.isEmpty(strM37872a)) {
            C6659d.m37881b(f30722a, "webViewUrl isEmpty", true);
            C6644e.m37839a(this.f30723b, 9999);
        } else {
            m37740a(strOptString, strM37872a, C6658c.m37879a(jSONObjectM37837a.optJSONArray("needConfig")), jSONObjectM37837a);
            synchronized (this.f30725d) {
                this.f30725d.add(strOptString);
            }
        }
    }

    public void detach() {
        this.f30723b.removeJavascriptInterface("hbssdk");
        C6692a.m37996a().mo37868a(this);
        C6659d.m37882c(f30722a, "detach begin", true);
    }

    public String getBridgeId() {
        return this.f30724c;
    }

    @JavascriptInterface
    public void invoke(String str) throws JSONException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        C6659d.m37882c(f30722a, "invoke begin", true);
        JSONObject jSONObjectM37837a = C6644e.m37837a(str);
        if (jSONObjectM37837a == null) {
            C6659d.m37881b(f30722a, "invoke callJson null", true);
            C6644e.m37839a(this.f30723b, 13);
            return;
        }
        String strOptString = jSONObjectM37837a.optString("_appId");
        String strOptString2 = jSONObjectM37837a.optString("_method");
        String strOptString3 = jSONObjectM37837a.optString("_args");
        String strOptString4 = jSONObjectM37837a.optString("_index");
        String strM37872a = C6657b.m37872a(this.f30723b);
        if (TextUtils.isEmpty(strM37872a)) {
            C6659d.m37881b(f30722a, "invoke webViewUrl null", true);
            C6644e.m37843a(this.f30723b, strOptString4, 9999, this.f30724c);
            return;
        }
        if (TextUtils.isEmpty(strOptString) && !m37741a(strM37872a)) {
            C6659d.m37881b(f30722a, "invoke JS_RET_CODE_METHOD_NOT_AUTH", true);
            C6644e.m37843a(this.f30723b, strOptString4, 10, this.f30724c);
            return;
        }
        if (TextUtils.isEmpty(strOptString2)) {
            C6659d.m37881b(f30722a, "invoke method isEmpty", true);
            C6644e.m37843a(this.f30723b, strOptString4, 13, this.f30724c);
            return;
        }
        if (strOptString2.equals("listenEvent")) {
            C6659d.m37882c(f30722a, "invoke method listenEvent", true);
            if (m37744b(strOptString3)) {
                return;
            }
            C6659d.m37881b(f30722a, "invoke method listenEvent error", true);
            C6644e.m37843a(this.f30723b, strOptString4, 13, this.f30724c);
            return;
        }
        C6659d.m37882c(f30722a, "invoke method:" + strOptString2, false);
        C6622a c6622aM37766a = C6623b.m37765a().m37766a(strOptString2);
        if (c6622aM37766a != null) {
            m37739a(strOptString, strOptString3, strOptString4, strM37872a, c6622aM37766a);
        } else {
            C6659d.m37881b(f30722a, "invoke method cannot get!", true);
            C6644e.m37843a(this.f30723b, strOptString4, 12, this.f30724c);
        }
    }

    public void setBridgeId(String str) {
        this.f30724c = str;
    }

    /* renamed from: b */
    private boolean m37744b(String str) {
        JSONObject jSONObjectM37837a = C6644e.m37837a(str);
        if (jSONObjectM37837a == null) {
            return false;
        }
        String strOptString = jSONObjectM37837a.optString("eventName");
        if (this.f30726e.containsKey(strOptString)) {
            return true;
        }
        if (strOptString.length() >= 64 || this.f30726e.size() >= 50) {
            return false;
        }
        this.f30726e.put(strOptString, "");
        return true;
    }

    @Override // com.huawei.hwcloudjs.p160e.p163b.InterfaceC6653b
    public boolean onReceive(NativeMsg nativeMsg) {
        NativeMsg nativeMsg2;
        if (nativeMsg != null && !TextUtils.isEmpty(nativeMsg.getType())) {
            String strM37872a = C6657b.m37872a(this.f30723b);
            if (TextUtils.isEmpty(strM37872a)) {
                return true;
            }
            String type = nativeMsg.getType();
            if ("channelMessage".equals(type) && (nativeMsg instanceof JsCoreApi.ChannelMessageReq)) {
                JsCoreApi.ChannelMessageReq channelMessageReq = (JsCoreApi.ChannelMessageReq) nativeMsg;
                nativeMsg2 = channelMessageReq;
                if (!this.f30726e.containsKey(C6619a.f30790j + channelMessageReq.getChannelName())) {
                    return true;
                }
            } else {
                nativeMsg2 = nativeMsg;
                if (!this.f30726e.containsKey(type)) {
                    return true;
                }
            }
            m37738a(nativeMsg2, strM37872a);
        }
        return true;
    }

    /* renamed from: a */
    private void m37737a(C6622a c6622a, String str, String str2, String str3, String str4) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objM37769a;
        C6659d.m37882c(f30722a, "callNative begin", true);
        if (c6622a.m37764b() == null) {
            objM37769a = null;
        } else if (c6622a.m37764b() == JsParam.class) {
            C6659d.m37882c(f30722a, "callNative paramType is JsParam", true);
            objM37769a = new JsParam(str3, str4, this.f30724c);
        } else {
            C6659d.m37882c(f30722a, "callNative paramType is not JsParam", true);
            objM37769a = new C6624b().m37769a(str, c6622a.m37764b());
            if (objM37769a != null && (objM37769a instanceof JsParam)) {
                objM37769a = C6644e.m37836a((JsParam) objM37769a, str3, str4, this.f30724c);
            }
        }
        c6622a.m37763a(objM37769a, new JsCallback(this.f30723b, str2, this.f30724c));
    }

    /* renamed from: a */
    private void m37738a(NativeMsg nativeMsg, String str) {
        if (m37741a(str)) {
            C6659d.m37882c(f30722a, "url Allow contains!!", true);
            C6644e.m37841a(this.f30723b, nativeMsg);
        } else if (nativeMsg.isOpen()) {
            synchronized (this.f30725d) {
                try {
                    Iterator<String> it = this.f30725d.iterator();
                    while (it.hasNext()) {
                        if (m37742a(it.next(), str, nativeMsg.getPermission())) {
                            C6644e.m37841a(this.f30723b, nativeMsg);
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    private void m37739a(String str, String str2, String str3, String str4, C6622a c6622a) throws IllegalAccessException, JSONException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        C6659d.m37882c(f30722a, "callNativeMethod begin", true);
        if (m37741a(str4)) {
            C6659d.m37882c(f30722a, "url Allow contains!", true);
            m37737a(c6622a, str2, str3, str, str4);
        } else if (!C6660e.m37885b(c6622a)) {
            C6659d.m37881b(f30722a, "method Is not Open!", true);
            C6644e.m37843a(this.f30723b, str3, 12, this.f30724c);
        } else if (m37742a(str, str4, C6660e.m37884a(c6622a))) {
            C6659d.m37882c(f30722a, "checkAuth OK", true);
            m37737a(c6622a, str2, str3, str, str4);
        } else {
            C6659d.m37881b(f30722a, "checkAuth fail!", true);
            C6644e.m37843a(this.f30723b, str3, 10, this.f30724c);
        }
    }

    /* renamed from: a */
    private void m37740a(String str, String str2, List<String> list, JSONObject jSONObject) {
        C6659d.m37882c(f30722a, "configAuth begin", true);
        C6616b c6616b = new C6616b(this, str, str2, list, jSONObject);
        C6632c.m37786a().m37795a(str, str2, new ArrayList(), c6616b, this.f30723b.getContext());
    }

    /* renamed from: a */
    private boolean m37741a(String str) {
        return C6632c.m37786a().m37796a(str);
    }

    /* renamed from: a */
    private boolean m37742a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        return C6632c.m37786a().m37798a(str, str2, arrayList);
    }
}
