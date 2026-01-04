package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.identity.C5668f;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.bean.AckQrLoginReq;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.bean.GetRealNameInfoReq;
import com.huawei.hms.support.hwid.bean.LoginInfoReq;
import com.huawei.hms.support.hwid.bean.SignInByQrReq;
import com.huawei.hms.support.hwid.bean.StartQrAuthReq;
import com.huawei.hms.support.hwid.bean.StartQrLoginReq;
import com.huawei.hms.support.hwid.common.C6462a;
import com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler;
import com.huawei.hms.support.hwid.common.constants.CommonConstant;
import com.huawei.hms.support.hwid.common.p142b.C6465b;
import com.huawei.hms.support.hwid.common.p145d.C6469a;
import com.huawei.hms.support.hwid.common.p146e.C6474d;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.p138a.C6446b;
import com.huawei.hms.support.hwid.p139b.C6447a;
import com.huawei.hms.support.hwid.p140c.C6448a;
import com.huawei.hms.support.hwid.p140c.C6450c;
import com.huawei.hms.support.hwid.p140c.C6451d;
import com.huawei.hms.support.hwid.p140c.C6452e;
import com.huawei.hms.support.hwid.p140c.C6453f;
import com.huawei.hms.support.hwid.p140c.C6454g;
import com.huawei.hms.support.hwid.p140c.C6455h;
import com.huawei.hms.support.hwid.p140c.C6456i;
import com.huawei.hms.support.hwid.p140c.C6457j;
import com.huawei.hms.support.hwid.p140c.C6458k;
import com.huawei.hms.support.hwid.p140c.C6459l;
import com.huawei.hms.support.hwid.p140c.C6460m;
import com.huawei.hms.support.hwid.p140c.C6461n;
import com.huawei.hms.support.hwid.result.C6484a;
import com.huawei.hms.support.hwid.result.InterfaceC6486c;
import com.huawei.hms.support.hwid.result.SignInQrInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.support.hwid.service.b */
/* loaded from: classes8.dex */
public class C6496b implements HuaweiIdAdvancedService {

    /* renamed from: a */
    private static final Map<String, Integer> f30094a;

    /* renamed from: b */
    private Context f30095b;

    static {
        HashMap map = new HashMap();
        f30094a = map;
        map.put(CommonNaming.queryRealNameInfo, 40004300);
        map.put(CommonNaming.queryAccountInfo, 50200300);
        map.put(CommonNaming.signInByQrCode, 60100300);
        map.put(CommonNaming.startQrLogin, 60100300);
        map.put("hwid.queryAccountChanged", 50001300);
        map.put("hwid.getDeviceInfo", 50001300);
        map.put("hwid.queryRealNameInfoNppa", 50200300);
        map.put("hwid.checkPasswordByUserId", Integer.valueOf(C5668f.f25479e));
        map.put("hwid.registerFilterForLogin", 60100300);
        map.put("hwid.startQrAuth", 60100300);
        map.put("hwid.getVerifyTokenByQrcode", 60600300);
        map.put("hwid.login", 60700300);
    }

    public C6496b(Context context) {
        this.f30095b = context;
    }

    /* renamed from: a */
    private Task<String> m36951a(List<String> list) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "accountInfoRequest entry.");
        if (this.f30095b == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        List<String> listM36954b = m36954b(list);
        if (listM36954b == null || listM36954b.isEmpty()) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "requestScopes is empty or null.");
            return m36949a((C6496b) "{}");
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(this.f30095b, CommonNaming.queryAccountInfo, AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accountInfoTransId", strReportEntry);
            jSONObject.put("scopes", m36955c(listM36954b));
            return m36947a((TaskApiCall) new C6450c(CommonNaming.queryAccountInfo, jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "JSONException.");
            return m36950a("build json error", 2005);
        }
    }

    /* renamed from: b */
    private List<String> m36954b(List<String> list) {
        if (list == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "scopes is null.");
            return null;
        }
        HashSet hashSet = new HashSet();
        for (String str : list) {
            if (str != null) {
                String strTrim = str.trim();
                if ("https://www.huawei.com/auth/account/mobile.number".equals(strTrim) || "https://www.huawei.com/auth/account/mobile.flag".equals(strTrim) || CommonConstant.SCOPE.SCOPE_LOGIN_ACCOUNT.equals(strTrim) || "https://www.huawei.com/auth/account/base.profile".equals(strTrim)) {
                    hashSet.add(strTrim);
                } else {
                    C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "invalid scope.");
                }
            } else {
                C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "null scope.");
            }
        }
        return new ArrayList(hashSet);
    }

    /* renamed from: c */
    private String m36955c(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < list.size(); i10++) {
            jSONArray.put(list.get(i10));
        }
        return jSONArray.toString();
    }

    /* renamed from: d */
    private JSONArray m36956d(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < list.size(); i10++) {
            jSONArray.put(list.get(i10));
        }
        return jSONArray;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> ackQrLogin(AckQrLoginReq ackQrLoginReq) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "enter ackQrLogin");
        Context context = this.f30095b;
        if (context == null || ackQrLoginReq == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "context or ackQrLoginReq is null.");
            return m36950a("context or sessionId is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.ackQrLogin", AuthInternalPickerConstant.HMS_SDK_VERSION);
        try {
            JSONObject json = ackQrLoginReq.toJson();
            json.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6448a("hwid.ackQrLogin", json.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "2015JSONException");
            new C8941i().m56657c(new ApiException(new Status(2015)));
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public void checkPasswordByUserId(Context context, CheckPasswordByUserIdReq checkPasswordByUserIdReq, CloudRequestHandler cloudRequestHandler) {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "begin checkPasswordByUserId");
        C6462a.m36833a().m36834a(context);
        C6495a.m36941a(context, checkPasswordByUserIdReq, cloudRequestHandler);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> getAccountInfo(List<String> list) {
        return m36951a(list);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> getDeviceInfo() throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "getDeviceInfo");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "getDeviceInfo activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.getDeviceInfo", AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6451d("hwid.getDeviceInfo", jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "getDeviceInfo JSONException");
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> getRealNameInfo() {
        return m36946a();
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> getVerifyTokenByQrcode(String str) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "getVerifyTokenByQrcode, sessionId is null ? " + TextUtils.isEmpty(str));
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.getVerifyTokenByQrcode", AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sessionId", str);
            return m36947a((TaskApiCall) new C6461n("hwid.getVerifyTokenByQrcode", jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "2015JSONException");
            new C8941i().m56657c(new ApiException(new Status(2015)));
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> hasAccountChanged(String str, String str2) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "queryAccountChanged");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "queryAccountChanged activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.queryAccountChanged", AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openId", str);
            jSONObject.put("uid", str2);
            jSONObject.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6454g("hwid.queryAccountChanged", jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "queryAccountChanged JSONException");
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<Void> login(LoginInfoReq loginInfoReq) throws JSONException, InterruptedException {
        boolean zAwait;
        C6477g.m36904a("HuaweiIdAdvanceServiceImpl", "login entry.", true);
        Context context = this.f30095b;
        if (context == null || loginInfoReq == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.login", AuthInternalPickerConstant.HMS_SDK_VERSION);
        String strM36863a = C6469a.m36860a(this.f30095b).m36863a("public-key", "");
        if (TextUtils.isEmpty(strM36863a)) {
            C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "sp is unuseable" + System.currentTimeMillis());
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            C6474d.m36879a().m36891a(this.f30095b, strReportEntry, loginInfoReq.getPackageName(), new InterfaceC6486c<C6484a>() { // from class: com.huawei.hms.support.hwid.service.b.1
                @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void mo36893a(C6484a c6484a) {
                    if (c6484a.m36920a().m36921a() == 0) {
                        C6477g.m36904a("HuaweiIdAdvanceServiceImpl", "get publicKey success " + System.currentTimeMillis(), true);
                    } else {
                        C6477g.m36904a("HuaweiIdAdvanceServiceImpl", "get publicKey fail " + System.currentTimeMillis(), true);
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                zAwait = countDownLatch.await(10L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                C6477g.m36907c("HuaweiIdAdvanceServiceImpl", "checkPermission InterruptedException.", true);
                zAwait = false;
            }
            C6477g.m36906b("HuaweiIdAdvanceServiceImpl", "getDomainNameAndPublicKey awaitValue:" + zAwait, true);
            if (!zAwait) {
                return m36950a("get publicKey fail", 2015);
            }
            strM36863a = C6469a.m36860a(this.f30095b).m36863a("public-key", "");
        } else {
            C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "sp is useable");
            C6474d.m36879a().m36890a(this.f30095b, strReportEntry, loginInfoReq.getPackageName());
        }
        loginInfoReq.setPassword(C6465b.m36844a(loginInfoReq.getPassword(), strM36863a));
        new JSONObject();
        try {
            JSONObject json = loginInfoReq.toJson();
            json.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6453f("hwid.login", json.toString(), strReportEntry));
        } catch (JSONException unused2) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "2015 JSONException");
            return m36950a("build json error", 2015);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<Void> logout() throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "logout");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "logout activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, AccountNaming.logout, AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6452e(AccountNaming.logout, jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "logout JSONException");
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> registerFilterForLogin(String str, HashMap<String, String> map, List<String> list, int i10, String str2) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "registerFilterFourLogin entry.");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.registerFilterForLogin", AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(map);
            jSONObject.put("appID", str);
            jSONObject.put("options", jSONObject2);
            jSONObject.put("callbackParams", m36956d(list));
            jSONObject.put("callbackType", i10);
            jSONObject.put("callback", str2);
            jSONObject.put("transId", strReportEntry);
            jSONObject.put("packageName", this.f30095b.getPackageName());
            return m36947a((TaskApiCall) new C6457j("hwid.registerFilterForLogin", jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "JSONException.");
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<Void> signInByQrCode(SignInByQrReq signInByQrReq) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "signInByQrCode");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, CommonNaming.signInByQrCode, AuthInternalPickerConstant.HMS_SDK_VERSION);
        try {
            JSONObject json = signInByQrReq.toJson();
            json.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6458k(CommonNaming.signInByQrCode, json.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "2015JSONException");
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> startQrAuth(StartQrAuthReq startQrAuthReq) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "enter startQrAuth");
        Context context = this.f30095b;
        if (context == null || startQrAuthReq == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "startQrAuth context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, "hwid.startQrAuth", AuthInternalPickerConstant.HMS_SDK_VERSION);
        try {
            JSONObject json = startQrAuthReq.toJson();
            json.put("transId", strReportEntry);
            return m36947a((TaskApiCall) new C6459l("hwid.startQrAuth", json.toString(), strReportEntry));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "startQrAuth JSONException");
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<SignInQrInfo> startQrLogin(StartQrLoginReq startQrLoginReq) throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "startQrLogin");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, CommonNaming.startQrLogin, AuthInternalPickerConstant.HMS_SDK_VERSION);
        try {
            JSONObject json = startQrLoginReq.toJson();
            json.put("transId", strReportEntry);
            C6460m c6460m = new C6460m(CommonNaming.startQrLogin, json.toString(), strReportEntry);
            c6460m.m36831a(CommonConstant.StartQrLoginQrValue.QRSCENE_RECHECK_USER.equals(startQrLoginReq.getQrScene()));
            return m36947a((TaskApiCall) c6460m);
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "startQrLogin JSONException");
            return m36950a("build json error", 2005);
        }
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAdvancedService
    public Task<String> getRealNameInfo(GetRealNameInfoReq getRealNameInfoReq) {
        if (getRealNameInfoReq == null || getRealNameInfoReq.getRequestChannelInfo() == null || getRealNameInfoReq.getRequestChannelExtraInfo() == null) {
            C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "Parameter getRealNameInfoReq, requestChannelInfo or requestChannelExtraInfo is null.");
            return m36950a("Parameter getRealNameInfoReq, requestChannelInfo or requestChannelExtraInfo is null.", 2005);
        }
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "getRealNameInfoForNppa with realNameReqInfo.");
        return m36948a(getRealNameInfoReq);
    }

    /* renamed from: a */
    private Task m36948a(GetRealNameInfoReq getRealNameInfoReq) {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "realNameInfoRequestForNppa entry.");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        if (getRealNameInfoReq == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "getRealNameInfoReq is null.");
            return m36950a("getRealNameInfoReq getRealNameInfoReq is null.", 2005);
        }
        try {
            getRealNameInfoReq.setTransId(HiAnalyticsClient.reportEntry(context, "hwid.queryRealNameInfoNppa", AuthInternalPickerConstant.HMS_SDK_VERSION));
            return m36947a((TaskApiCall) new C6455h("hwid.queryRealNameInfoNppa", getRealNameInfoReq.getGetRealNameInfoReqJsonString() != null ? getRealNameInfoReq.getGetRealNameInfoReqJsonString() : "", 50200300));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "JSONException.");
            return m36950a("build json error", 2005);
        }
    }

    /* renamed from: a */
    private Task m36946a() throws JSONException {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "realNameInfoRequest entry.");
        Context context = this.f30095b;
        if (context == null) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "activity or context is null.");
            return m36950a("activity or context is null.", 2005);
        }
        String strReportEntry = HiAnalyticsClient.reportEntry(context, CommonNaming.queryRealNameInfo, AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonConstant.REALNAMEREQUEST.REQUEST_TRANS_ID, strReportEntry);
            return m36947a((TaskApiCall) new C6456i(CommonNaming.queryRealNameInfo, jSONObject.toString(), 40004300));
        } catch (JSONException unused) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "JSONException.");
            return m36950a("build json error", 2005);
        }
    }

    /* renamed from: a */
    private <TResult, TClient extends AnyClient> Task<TResult> m36947a(TaskApiCall<TClient, TResult> taskApiCall) {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "innerRequest by taskApiCall entry.");
        try {
            return m36952a(this.f30095b, new Api.ApiOptions.NoOptions(), new Api(HuaweiApiAvailability.HMS_API_NAME_ID), new C6446b(), "").doWrite(taskApiCall);
        } catch (C6447a e10) {
            C6477g.m36905b("HuaweiIdAdvanceServiceImpl", "InvalidVersionException.");
            return this.m36950a(e10.m36823a().getErrorString(), e10.m36823a().getStatusCode());
        }
    }

    /* renamed from: a */
    private <TResult> Task<TResult> m36950a(String str, int i10) {
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", str);
        C8941i c8941i = new C8941i();
        c8941i.m56657c(new ApiException(new Status(i10, str)));
        return c8941i.m56656b();
    }

    /* renamed from: a */
    private <TResult> Task<TResult> m36949a(TResult tresult) {
        C8941i c8941i = new C8941i();
        c8941i.m56658d(tresult);
        return c8941i.m56656b();
    }

    /* renamed from: a */
    private boolean m36953a(Context context) {
        boolean z10 = context instanceof Activity;
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "check context result:" + z10);
        return z10;
    }

    /* renamed from: a */
    private <TOption extends Api.ApiOptions> HuaweiApi m36952a(Context context, TOption toption, Api<TOption> api, AbstractClientBuilder abstractClientBuilder, String str) throws C6447a {
        if (m36953a(context)) {
            C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "entry initService activity.");
            return new HuaweiApi((Activity) context, (Api) api, (Api.ApiOptions) toption, abstractClientBuilder, AuthInternalPickerConstant.HMS_SDK_VERSION);
        }
        C6477g.m36903a("HuaweiIdAdvanceServiceImpl", "entry initService context.");
        return new HuaweiApi(context, api, toption, abstractClientBuilder, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }
}
