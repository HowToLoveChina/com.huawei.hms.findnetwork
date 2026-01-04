package com.huawei.hwcloudjs;

import android.webkit.WebView;
import com.huawei.hwcloudjs.p154d.p155a.C6632c;
import com.huawei.hwcloudjs.p164f.C6659d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.b */
/* loaded from: classes8.dex */
public class C6616b implements C6632c.a {

    /* renamed from: a */
    final /* synthetic */ String f30749a;

    /* renamed from: b */
    final /* synthetic */ String f30750b;

    /* renamed from: c */
    final /* synthetic */ List f30751c;

    /* renamed from: d */
    final /* synthetic */ JSONObject f30752d;

    /* renamed from: e */
    final /* synthetic */ HWCloudJSBridge f30753e;

    public C6616b(HWCloudJSBridge hWCloudJSBridge, String str, String str2, List list, JSONObject jSONObject) {
        this.f30753e = hWCloudJSBridge;
        this.f30749a = str;
        this.f30750b = str2;
        this.f30751c = list;
        this.f30752d = jSONObject;
    }

    @Override // com.huawei.hwcloudjs.p154d.p155a.C6632c.a
    /* renamed from: a */
    public void mo37752a(int i10) throws JSONException {
        WebView webView;
        int i11;
        if (i10 == 0) {
            C6659d.m37882c("HWCloudJSBridge", "configAuthSUC", true);
            this.f30753e.m37743b(this.f30749a, this.f30750b, this.f30751c, this.f30752d);
            C6644e.m37838a(this.f30753e.f30723b);
            return;
        }
        if (i10 == -2) {
            C6659d.m37881b("HWCloudJSBridge", "AUTH_FAIL_NO_NET", true);
            webView = this.f30753e.f30723b;
            i11 = 12;
        } else if (i10 == -1) {
            C6659d.m37881b("HWCloudJSBridge", "AUTH_FAIL", true);
            webView = this.f30753e.f30723b;
            i11 = 10;
        } else if (i10 == -3) {
            C6659d.m37881b("HWCloudJSBridge", "AUTH_FAIL_NET_ERROR", true);
            webView = this.f30753e.f30723b;
            i11 = 11;
        } else {
            if (i10 != -4) {
                C6659d.m37881b("HWCloudJSBridge", "JS_CONFIG_RET_CODE_GW_ERROR" + i10, true);
                C6644e.m37840a(this.f30753e.f30723b, 14, i10 + "");
                return;
            }
            C6659d.m37881b("HWCloudJSBridge", "AUTH_FAIL_OTHER", true);
            webView = this.f30753e.f30723b;
            i11 = 9999;
        }
        C6644e.m37839a(webView, i11);
    }
}
