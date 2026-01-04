package com.huawei.hms.ads.consent.inner.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.consent.bean.ConsentSyncRsp;
import com.huawei.hms.ads.consent.bean.network.ApiStatisticsReq;
import com.huawei.hms.ads.consent.bean.network.ApiStatisticsRsp;
import com.huawei.hms.ads.consent.bean.network.ConfirmResultReq;
import com.huawei.hms.ads.consent.bean.network.ConfirmResultRsp;
import com.huawei.hms.ads.consent.bean.network.ConsentConfigReq;
import com.huawei.hms.ads.consent.bean.network.ConsentConfigRsp;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7118fb;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.InterfaceC7623qy;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7830i;
import org.json.JSONException;
import org.json.JSONObject;

@OuterVisible
/* loaded from: classes8.dex */
public class ConsentImpl {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <T> void m30245b(RemoteCallResultCallback<T> remoteCallResultCallback, String str, int i10, T t10) {
        if (remoteCallResultCallback != null) {
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(i10);
            try {
                if (i10 == 200) {
                    callResult.setData(t10);
                } else {
                    callResult.setMsg("");
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("ConsentImpl", "onCallResult fail " + th2.getClass().getSimpleName());
                callResult.setCode(-1);
                callResult.setMsg(th2.getMessage());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    @OuterVisible
    public static void lookUpConsent(Context context, String str, String str2, RemoteCallResultCallback<ConsentConfigRsp> remoteCallResultCallback, Class<ConsentConfigRsp> cls) {
        String str3;
        AbstractC7185ho.m43817a("ConsentImpl", "begin to lookup consent config");
        if (AbstractC7806cz.m48165b(str2)) {
            str3 = "consent req is empty, please check it!";
        } else {
            ConsentConfigReq consentConfigReq = (ConsentConfigReq) AbstractC7758be.m47739b(str2, ConsentConfigReq.class, new Class[0]);
            if (consentConfigReq != null) {
                String strMo43382bI = C7124fh.m43316b(context).mo43382bI();
                if (!TextUtils.isEmpty(strMo43382bI)) {
                    consentConfigReq.setCountryCode(strMo43382bI);
                } else if (AbstractC7806cz.m48165b(consentConfigReq.getCountryCode())) {
                    strMo43382bI = new CountryCodeBean(context).m39390a();
                    C7787cg.m47900a(context).m48031z(strMo43382bI);
                    AbstractC7185ho.m43818a("ConsentImpl", "look up consent, countryCode is: %s", strMo43382bI);
                    consentConfigReq.setCountryCode(strMo43382bI);
                }
                consentConfigReq.setLangCode(AbstractC7807d.m48204a());
                String packageName = context.getPackageName();
                String strM48435e = C7830i.m48435e(context, packageName);
                if (TextUtils.isEmpty(consentConfigReq.getPkgName()) || !WhiteListPkgList.inWhiteList(packageName, strM48435e)) {
                    consentConfigReq.setPkgName(packageName);
                    AbstractC7185ho.m43818a("ConsentImpl", "app set app package name: %s", packageName);
                } else {
                    packageName = consentConfigReq.getPkgName();
                    AbstractC7185ho.m43818a("ConsentImpl", "fast app set app package name:  %s", packageName);
                }
                com.huawei.openalliance.p169ad.beans.server.ConsentConfigRsp consentConfigRspMo43269a = C7118fb.m43196a(context).mo43269a(packageName, new com.huawei.openalliance.p169ad.beans.server.ConsentConfigReq(consentConfigReq));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("responseCode:");
                sb2.append(consentConfigRspMo43269a == null ? "null" : Integer.valueOf(consentConfigRspMo43269a.responseCode));
                AbstractC7185ho.m43820b("ConsentImpl", sb2.toString());
                if (consentConfigRspMo43269a == null || consentConfigRspMo43269a.responseCode != 0) {
                    m30245b(remoteCallResultCallback, str, -1, null);
                    return;
                } else {
                    m30245b(remoteCallResultCallback, str, 200, new ConsentConfigRsp(consentConfigRspMo43269a));
                    return;
                }
            }
            str3 = "req is null: " + str2;
        }
        AbstractC7185ho.m43826d("ConsentImpl", str3);
        m30245b(remoteCallResultCallback, str, -1, null);
    }

    @OuterVisible
    public static void reportApiStistics(Context context, String str, String str2, RemoteCallResultCallback<ApiStatisticsRsp> remoteCallResultCallback, Class<ApiStatisticsRsp> cls) {
        if (context == null || TextUtils.isEmpty(str2)) {
            AbstractC7185ho.m43826d("ConsentImpl", "reportApiStistics req is empty, please check it!");
            m30245b(remoteCallResultCallback, str, -1, null);
            return;
        }
        ApiStatisticsReq apiStatisticsReq = (ApiStatisticsReq) AbstractC7758be.m47739b(str2, ApiStatisticsReq.class, new Class[0]);
        String packageName = context.getPackageName();
        String strM48435e = C7830i.m48435e(context, packageName);
        if (TextUtils.isEmpty(packageName) || !WhiteListPkgList.inWhiteList(packageName, strM48435e)) {
            AbstractC7185ho.m43818a("ConsentImpl", "app set app package name: %s", packageName);
        } else {
            try {
                String strOptString = new JSONObject(apiStatisticsReq.getParams()).optString(MapKeyNames.FAST_APP_PACAKAE);
                if (!TextUtils.isEmpty(strOptString)) {
                    packageName = strOptString;
                }
            } catch (JSONException unused) {
                AbstractC7185ho.m43823c("ConsentImpl", "get pkgName failed, params is not valid json");
            }
            AbstractC7185ho.m43818a("ConsentImpl", "fast app set app package name: %s", packageName);
        }
        new C6922c(context).m39098a(packageName, new com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq(apiStatisticsReq));
        ApiStatisticsRsp apiStatisticsRsp = new ApiStatisticsRsp();
        apiStatisticsRsp.setRetcode(200);
        m30245b(remoteCallResultCallback, str, 200, apiStatisticsRsp);
    }

    @OuterVisible
    public static void reportConfirmResult(Context context, final String str, String str2, final RemoteCallResultCallback<ConfirmResultRsp> remoteCallResultCallback, Class<ConfirmResultRsp> cls) {
        if (AbstractC7806cz.m48165b(str2)) {
            AbstractC7185ho.m43826d("ConsentImpl", "confirmResult req is empty, please check it!");
            m30245b(remoteCallResultCallback, str, -1, null);
            return;
        }
        ConfirmResultReq confirmResultReq = (ConfirmResultReq) AbstractC7758be.m47739b(str2, ConfirmResultReq.class, new Class[0]);
        if (confirmResultReq == null || confirmResultReq.getCaches() == null) {
            m30245b(remoteCallResultCallback, str, -1, null);
            return;
        }
        C6928i c6928i = new C6928i(context);
        String packageName = context.getPackageName();
        String strM48435e = C7830i.m48435e(context, packageName);
        if (TextUtils.isEmpty(packageName) || !WhiteListPkgList.inWhiteList(packageName, strM48435e)) {
            AbstractC7185ho.m43818a("ConsentImpl", "app set app package name: %s", packageName);
        } else {
            if (confirmResultReq.getCaches().get(0) != null) {
                try {
                    String strOptString = new JSONObject(confirmResultReq.getCaches().get(0).getParams()).optString(MapKeyNames.FAST_APP_PACAKAE);
                    if (!TextUtils.isEmpty(strOptString)) {
                        packageName = strOptString;
                    }
                } catch (JSONException unused) {
                    AbstractC7185ho.m43823c("ConsentImpl", "get pkgName failed, params is not valid json");
                }
            }
            AbstractC7185ho.m43818a("ConsentImpl", "fast app set app package name: %s", packageName);
        }
        c6928i.mo39204a(packageName, confirmResultReq, new InterfaceC7623qy() { // from class: com.huawei.hms.ads.consent.inner.impl.ConsentImpl.1
            @Override // com.huawei.openalliance.p169ad.InterfaceC7623qy
            /* renamed from: a */
            public void mo30246a() {
                ConfirmResultRsp confirmResultRsp = new ConfirmResultRsp();
                confirmResultRsp.setRetcode(200);
                ConsentImpl.m30245b(remoteCallResultCallback, str, 200, confirmResultRsp);
            }
        });
    }

    @OuterVisible
    public static void reportConsentStatus(Context context, String str, String str2, RemoteCallResultCallback<ConsentSyncRsp> remoteCallResultCallback, Class<ConsentSyncRsp> cls) {
        Log.i("ConsentImpl", "reportConsentStatus");
        if (context != null && !TextUtils.isEmpty(str2)) {
            C7484ms.m45854a(context.getApplicationContext()).m45855a(str, str2, remoteCallResultCallback, cls);
        } else {
            AbstractC7185ho.m43826d("ConsentImpl", "reportConsentStatus req is empty, please check it!");
            m30245b(remoteCallResultCallback, str, -1, null);
        }
    }

    @OuterVisible
    public static void reportConsentToKit(Context context, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback, Class<String> cls) {
        if (context != null && !TextUtils.isEmpty(str2)) {
            C7484ms.m45854a(context.getApplicationContext()).m45855a(str, str2, remoteCallResultCallback, cls);
        } else {
            AbstractC7185ho.m43826d("ConsentImpl", "reportConsentToKit req is empty, please check it!");
            m30245b(remoteCallResultCallback, str, -1, null);
        }
    }
}
