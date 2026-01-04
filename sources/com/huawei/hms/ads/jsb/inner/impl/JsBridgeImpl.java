package com.huawei.hms.ads.jsb.inner.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.ads.jsb.C5091a;
import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7326j;
import com.huawei.openalliance.p169ad.C7417m;
import com.huawei.openalliance.p169ad.InterfaceC7143g;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import org.json.JSONObject;

@OuterVisible
/* loaded from: classes8.dex */
public class JsBridgeImpl {

    /* renamed from: com.huawei.hms.ads.jsb.inner.impl.JsBridgeImpl$a */
    public static class RunnableC5093a implements Runnable {

        /* renamed from: a */
        private final Context f23272a;

        /* renamed from: b */
        private final String f23273b;

        /* renamed from: c */
        private final String f23274c;

        /* renamed from: d */
        private final RemoteCallResultCallback<String> f23275d;

        /* renamed from: e */
        private InterfaceC7143g f23276e;

        public RunnableC5093a(Context context, InterfaceC7143g interfaceC7143g, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.f23272a = context;
            this.f23273b = str;
            this.f23274c = str2;
            this.f23275d = remoteCallResultCallback;
            this.f23276e = interfaceC7143g;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsBridgeImpl.m30389b(this.f23272a, this.f23276e, this.f23273b, this.f23274c, this.f23275d);
        }
    }

    /* renamed from: b */
    public static void m30389b(Context context, InterfaceC7143g interfaceC7143g, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (interfaceC7143g == null) {
            String str3 = "api for " + str + " is not found";
            AbstractC7185ho.m43820b("JsBridgeImpl", "call " + str3);
            AbstractC7326j.m45216a(remoteCallResultCallback, str, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, str3, true);
            return;
        }
        AbstractC7185ho.m43820b("JsBridgeImpl", "call method: " + str);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("JsBridgeImpl", "param: %s", AbstractC7819dl.m48375a(str2));
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String strOptString = jSONObject.optString("content");
            interfaceC7143g.mo43564a(jSONObject.optString("url"));
            String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_CLIENT_ID);
            String strOptString3 = jSONObject.optString("webid");
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("JsBridgeImpl", "call method %s, webID: %s", str, strOptString3);
            }
            if (TextUtils.isEmpty(strOptString3)) {
                interfaceC7143g.mo43565b(strOptString2);
            } else {
                interfaceC7143g.mo43565b(strOptString3);
            }
            interfaceC7143g.mo38573a(context, strOptString, remoteCallResultCallback);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("JsBridgeImpl", "call method %s, ex: %s", str, th2.getClass().getSimpleName());
            AbstractC7326j.m45216a(remoteCallResultCallback, str, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, th2.getClass().getSimpleName() + ":" + th2.getMessage(), true);
            AbstractC7185ho.m43815a(3, th2);
        }
    }

    @OuterVisible
    public static void initConfig(Context context, JsbConfig jsbConfig) {
        C5091a.m30359a(context).m30362a(jsbConfig);
    }

    @OuterVisible
    public static String invoke(Context context, String str, String str2) {
        Object objMo43562a;
        JSONObject jSONObject = new JSONObject();
        int i10 = FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED;
        if (context != null) {
            try {
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("JsBridgeImpl", "call method : " + th2.getClass().getSimpleName());
                objMo43562a = "call " + str + " " + th2.getClass().getSimpleName() + ":" + th2.getMessage();
            }
            if (!TextUtils.isEmpty(str2)) {
                InterfaceC7143g interfaceC7143gM45654a = C7417m.m45653a().m45654a(str);
                if (interfaceC7143gM45654a != null) {
                    AbstractC7185ho.m43820b("JsBridgeImpl", "call api: " + str);
                    objMo43562a = interfaceC7143gM45654a.mo43562a(context.getApplicationContext(), new JSONObject(str2).optString("content"));
                    i10 = 1000;
                } else {
                    objMo43562a = null;
                }
                try {
                    jSONObject.put("code", i10);
                    jSONObject.put("data", objMo43562a);
                } catch (Throwable th3) {
                    AbstractC7185ho.m43823c("JsBridgeImpl", "call method : " + th3.getClass().getSimpleName());
                }
                return jSONObject.toString();
            }
        }
        AbstractC7185ho.m43823c("JsBridgeImpl", "param is invalid, please check it!");
        jSONObject.put("msg", "invalid params");
        jSONObject.put("code", FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED);
        return jSONObject.toString();
    }

    @OuterVisible
    public static void invoke(Context context, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback, Class<String> cls) {
        if (context == null || TextUtils.isEmpty(str2)) {
            AbstractC7185ho.m43826d("JsBridgeImpl", "param is invalid, please check it!");
            AbstractC7326j.m45216a(remoteCallResultCallback, str, 1001, null, true);
            return;
        }
        InterfaceC7143g interfaceC7143gM45654a = C7417m.m45653a().m45654a(str);
        AbstractC7834m.a aVarMo43561a = AbstractC7834m.a.IO;
        if (interfaceC7143gM45654a != null) {
            aVarMo43561a = interfaceC7143gM45654a.mo43561a();
            if (context instanceof Activity) {
                interfaceC7143gM45654a.mo43563a((Activity) context);
            }
        }
        AbstractC7834m.m48480a(new RunnableC5093a(context.getApplicationContext(), interfaceC7143gM45654a, str, str2, remoteCallResultCallback), aVarMo43561a, false);
    }
}
