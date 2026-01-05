package com.huawei.hicloud.request.okhttp.request;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4993b;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0228m0;
import p514o9.C11839m;
import p674ub.C13152i;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: com.huawei.hicloud.request.okhttp.request.a */
/* loaded from: classes6.dex */
public abstract class AbstractC4994a extends AbstractC4993b<String> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "SCallback";
    protected String svc;
    protected String traceID;

    public AbstractC4994a(String str, String str2, String str3) {
        this.svc = str;
        this.traceID = str2;
        this.method = str3;
    }

    public void parseErrorByRsp(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "parseErrorByRsp body is null");
            return;
        }
        if (str.contains("errorNo")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("errorNo") && jSONObject.optInt("errorNo") == 9999) {
                    String strOptString = jSONObject.optString("scenarioId");
                    if (TextUtils.isEmpty(strOptString)) {
                        return;
                    }
                    C11839m.m70688i(TAG, "parseErrorByRsp scenarioId: " + strOptString);
                    C13152i.m79070o().m79091a(strOptString, TAG);
                }
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "parseErrorByRsp error: " + e10.toString());
            }
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, IOException {
        String str = C1443a.f6213a;
        aVar.addHeader("version", str);
        aVar.addHeader("x-hw-app-version", str);
        aVar.addHeader("x-hw-terminal", Build.MODEL);
        aVar.addHeader("x-hw-os", C0209d.m1315v());
        aVar.addHeader("x-hw-trace-id", this.traceID);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80942m = C13452e.m80781L().m80942m();
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        C9720a.m60653b(strM80971t0, "userId is null");
        C9720a.m60653b(strM80942m, "countryCode is null");
        C9720a.m60653b(strM80970t, "deviceType is null");
        C9720a.m60653b(strM80954p, "deviceId is null");
        aVar.addHeader(JsbMapKeyNames.H5_USER_ID, strM80971t0);
        aVar.addHeader("x-hw-country-code", strM80942m);
        aVar.addHeader("x-hw-device-type", strM80970t);
        aVar.addHeader("x-hw-device-id", strM80954p);
        aVar.addHeader("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.addHeader("x-hw-os-brand", C0209d.m1276l0());
        C14306d.m85213n(aVar);
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(HttpResponseBuilder HttpResponseBuilder) throws C9721b, IOException, NumberFormatException {
        String strM71637z = HttpResponseBuilder.m71595s().m71637z();
        String strM71599w = HttpResponseBuilder.m71599w("NSP_STATUS");
        if (strM71599w == null || strM71599w.isEmpty()) {
            parseErrorByRsp(strM71637z);
            return strM71637z;
        }
        StringBuilder sb2 = new StringBuilder(this.svc);
        sb2.append(" nsp status = ");
        sb2.append(strM71599w);
        sb2.append("=>");
        try {
            int i10 = Integer.parseInt(strM71599w);
            sb2.append(strM71637z);
            throw new C9721b(4000, i10, sb2.toString(), this.svc);
        } catch (NumberFormatException unused) {
            sb2.append(strM71637z);
            throw new C9721b(4000, -1, sb2.toString(), this.svc);
        }
    }
}
