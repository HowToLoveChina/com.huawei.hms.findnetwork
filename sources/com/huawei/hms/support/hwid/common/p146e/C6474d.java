package com.huawei.hms.support.hwid.common.p146e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.framework.network.grs.GrsApi;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.RestClientGlobalInstance;
import com.huawei.hms.framework.network.restclient.ResultCallback;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.hms.support.hwid.common.p143c.p144a.C6467a;
import com.huawei.hms.support.hwid.common.p145d.C6469a;
import com.huawei.hms.support.hwid.result.C6484a;
import com.huawei.hms.support.hwid.result.C6487d;
import com.huawei.hms.support.hwid.result.InterfaceC6486c;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.hms.support.hwid.common.e.d */
/* loaded from: classes8.dex */
public class C6474d {

    /* renamed from: a */
    private static final C6474d f30048a = new C6474d();

    /* renamed from: d */
    private InterfaceC6486c<C6484a> f30051d;

    /* renamed from: g */
    private Context f30054g;

    /* renamed from: h */
    private JSONObject f30055h;

    /* renamed from: i */
    private JSONObject f30056i;

    /* renamed from: b */
    private String f30049b = "";

    /* renamed from: c */
    private String f30050c = "";

    /* renamed from: e */
    private boolean f30052e = false;

    /* renamed from: f */
    private boolean f30053f = false;

    /* renamed from: j */
    private boolean f30057j = false;

    /* renamed from: com.huawei.hms.support.hwid.common.e.d$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Map<String, String> mapSynGetGrsUrls = GrsApi.synGetGrsUrls("com.huawei.cloud.hwid");
                if (mapSynGetGrsUrls == null) {
                    C6477g.m36905b("GetDomainNameUtil", "urlMap null");
                    C6474d.this.m36881a(2003, "urlMap null");
                    C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 2003, C6474d.this.f30050c);
                    return;
                }
                String str = mapSynGetGrsUrls.get("Root");
                if (TextUtils.isEmpty(str)) {
                    C6477g.m36905b("GetDomainNameUtil", "url is empty exit");
                    C6474d.this.m36881a(2003, "url is empty exit");
                    C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 2003, C6474d.this.f30050c);
                } else {
                    C6477g.m36903a("GetDomainNameUtil", "get domain url from grs success");
                    C6474d.this.m36886a(str, "siteDomain");
                    C6474d.this.m36886a(str, "upLogin503");
                }
            } catch (NoClassDefFoundError unused) {
                C6477g.m36905b("GetDomainNameUtil", "NoClassDefFoundError");
                C6474d.this.m36881a(2003, "NoClassDefFoundError");
                C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 2003, C6474d.this.f30050c);
            }
        }
    }

    /* renamed from: com.huawei.hms.support.hwid.common.e.d$2 */
    public class AnonymousClass2 implements ResultCallback<ResponseBody> {

        /* renamed from: a */
        final /* synthetic */ C6467a f30059a;

        /* renamed from: b */
        final /* synthetic */ String f30060b;

        public AnonymousClass2(C6467a c6467a, String str) {
            c6467a = c6467a;
            str = str;
        }

        @Override // com.huawei.hms.framework.network.restclient.ResultCallback
        public void onFailure(Throwable th2) {
            C6477g.m36903a("GetDomainNameUtil", "request getResource for siteDomain onFailure");
            C6474d.this.m36881a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "request getResource for siteDomain onFailure");
            C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, C6474d.this.f30050c);
        }

        @Override // com.huawei.hms.framework.network.restclient.ResultCallback
        public void onResponse(Response<ResponseBody> response) {
            C6477g.m36903a("GetDomainNameUtil", "request getResource for siteDomain success");
            C6474d.this.m36882a(c6467a, response, str);
        }
    }

    /* renamed from: com.huawei.hms.support.hwid.common.e.d$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f30062a;

        /* renamed from: b */
        final /* synthetic */ String f30063b;

        /* renamed from: c */
        final /* synthetic */ String f30064c;

        /* renamed from: com.huawei.hms.support.hwid.common.e.d$3$1 */
        public class AnonymousClass1 implements InterfaceC6486c<C6484a> {
            public AnonymousClass1() {
            }

            @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
            /* renamed from: a */
            public void mo36893a(C6484a c6484a) {
                C6487d c6487dM36920a = c6484a.m36920a();
                if (c6487dM36920a.m36921a() == 0) {
                    C6477g.m36904a("GetDomainNameUtil", "updateSiteDomain success: ", true);
                    C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 0, C6474d.this.f30050c);
                } else {
                    C6477g.m36906b("GetDomainNameUtil", "updateSiteDomain fail: ", true);
                    C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", c6487dM36920a.m36921a(), C6474d.this.f30050c);
                }
            }
        }

        public AnonymousClass3(Context context, String str, String str2) {
            context = context;
            str = str;
            str = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6474d.this.m36891a(context, str, str, new InterfaceC6486c<C6484a>() { // from class: com.huawei.hms.support.hwid.common.e.d.3.1
                public AnonymousClass1() {
                }

                @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
                /* renamed from: a */
                public void mo36893a(C6484a c6484a) {
                    C6487d c6487dM36920a = c6484a.m36920a();
                    if (c6487dM36920a.m36921a() == 0) {
                        C6477g.m36904a("GetDomainNameUtil", "updateSiteDomain success: ", true);
                        C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 0, C6474d.this.f30050c);
                    } else {
                        C6477g.m36906b("GetDomainNameUtil", "updateSiteDomain fail: ", true);
                        C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", c6487dM36920a.m36921a(), C6474d.this.f30050c);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private void m36889b() {
        C6477g.m36903a("GetDomainNameUtil", "enter callback");
        if (!this.f30052e || !this.f30053f) {
            C6477g.m36903a("GetDomainNameUtil", "request siteDomain and publickey no finish");
            return;
        }
        C6477g.m36903a("GetDomainNameUtil", "request siteDomain and publickey all finish");
        HashMap<String, Object> map = new HashMap<>();
        map.put("public-key", this.f30056i.optString("public-key"));
        map.put("1", this.f30055h.optString("as_1"));
        map.put("5", this.f30055h.optString("as_5"));
        map.put("7", this.f30055h.optString("as_7"));
        map.put("8", this.f30055h.optString("as_8"));
        map.put("lastupdate", String.valueOf(System.currentTimeMillis()));
        C6469a.m36860a(this.f30054g).m36865a(map);
        C6477g.m36903a("GetDomainNameUtil", "save publickey and siteDomain success");
        m36881a(0, "save publickey and siteDomain success");
        C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", 0, this.f30050c);
    }

    /* renamed from: a */
    public static C6474d m36879a() {
        return f30048a;
    }

    /* renamed from: a */
    public void m36891a(Context context, String str, String str2, InterfaceC6486c<C6484a> interfaceC6486c) {
        this.f30049b = str;
        this.f30050c = str2;
        this.f30051d = interfaceC6486c;
        this.f30054g = context;
        new Thread(new Runnable() { // from class: com.huawei.hms.support.hwid.common.e.d.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map<String, String> mapSynGetGrsUrls = GrsApi.synGetGrsUrls("com.huawei.cloud.hwid");
                    if (mapSynGetGrsUrls == null) {
                        C6477g.m36905b("GetDomainNameUtil", "urlMap null");
                        C6474d.this.m36881a(2003, "urlMap null");
                        C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 2003, C6474d.this.f30050c);
                        return;
                    }
                    String str3 = mapSynGetGrsUrls.get("Root");
                    if (TextUtils.isEmpty(str3)) {
                        C6477g.m36905b("GetDomainNameUtil", "url is empty exit");
                        C6474d.this.m36881a(2003, "url is empty exit");
                        C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 2003, C6474d.this.f30050c);
                    } else {
                        C6477g.m36903a("GetDomainNameUtil", "get domain url from grs success");
                        C6474d.this.m36886a(str3, "siteDomain");
                        C6474d.this.m36886a(str3, "upLogin503");
                    }
                } catch (NoClassDefFoundError unused) {
                    C6477g.m36905b("GetDomainNameUtil", "NoClassDefFoundError");
                    C6474d.this.m36881a(2003, "NoClassDefFoundError");
                    C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 2003, C6474d.this.f30050c);
                }
            }
        }).start();
    }

    /* renamed from: a */
    public void m36886a(String str, String str2) {
        C6477g.m36903a("GetDomainNameUtil", "getSiteDomianFromServer");
        RestClientGlobalInstance.getInstance().init(this.f30054g);
        RestClient restClientBuild = new RestClient.Builder(this.f30054g).baseUrl(str).build();
        if (restClientBuild == null) {
            m36881a(2003, "restClient is null");
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", 2003, this.f30050c);
            return;
        }
        InterfaceC6471a interfaceC6471a = (InterfaceC6471a) restClientBuild.create(InterfaceC6471a.class);
        C6467a c6467a = new C6467a(this.f30054g, str2);
        try {
            interfaceC6471a.m36868a(c6467a.m36851d(), RequestBody.create(" text/html; charset=utf-8", c6467a.m36853e().getBytes(Constants.UTF_8))).enqueue(new ResultCallback<ResponseBody>() { // from class: com.huawei.hms.support.hwid.common.e.d.2

                /* renamed from: a */
                final /* synthetic */ C6467a f30059a;

                /* renamed from: b */
                final /* synthetic */ String f30060b;

                public AnonymousClass2(C6467a c6467a2, String str22) {
                    c6467a = c6467a2;
                    str = str22;
                }

                @Override // com.huawei.hms.framework.network.restclient.ResultCallback
                public void onFailure(Throwable th2) {
                    C6477g.m36903a("GetDomainNameUtil", "request getResource for siteDomain onFailure");
                    C6474d.this.m36881a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "request getResource for siteDomain onFailure");
                    C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, C6474d.this.f30050c);
                }

                @Override // com.huawei.hms.framework.network.restclient.ResultCallback
                public void onResponse(Response<ResponseBody> response) {
                    C6477g.m36903a("GetDomainNameUtil", "request getResource for siteDomain success");
                    C6474d.this.m36882a(c6467a, response, str);
                }
            });
        } catch (IOException unused) {
            C6477g.m36903a("GetDomainNameUtil", "request getResource for siteDomain IOException");
            m36881a(2015, "request getResource for siteDomain IOException");
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", 2015, this.f30050c);
        }
    }

    /* renamed from: a */
    public void m36882a(C6467a c6467a, Response<ResponseBody> response, String str) {
        C6477g.m36903a("GetDomainNameUtil", "handleRequestNet");
        int code = response.getCode();
        C6477g.m36903a("GetDomainNameUtil", "code:" + code);
        if (code != 200) {
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", code, this.f30050c);
            m36881a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "request error");
            return;
        }
        C6477g.m36903a("GetDomainNameUtil", "GetResourceRequest success");
        try {
            c6467a.m36852a(new String(response.getBody().bytes(), Constants.UTF_8));
            String strM36854f = c6467a.m36854f();
            if (!TextUtils.isEmpty(strM36854f) && strM36854f != null) {
                C6477g.m36903a("GetDomainNameUtil", "get getResourceResponseJson success");
                JSONObject jSONObject = new JSONObject(strM36854f);
                if (str.equals("siteDomain")) {
                    this.f30055h = jSONObject;
                    this.f30052e = true;
                } else {
                    this.f30056i = jSONObject;
                    this.f30053f = true;
                }
                m36889b();
                return;
            }
            C6477g.m36903a("GetDomainNameUtil", "getResourceResponseJson is null, errorcode is " + c6467a.m36855g());
            C6477g.m36904a("GetDomainNameUtil", "getResourceResponseJson is null, errorcode is " + c6467a.m36855g() + " errorMsg: " + c6467a.m36856h(), false);
            m36881a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "getResourceResponseJson is null");
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, this.f30050c);
        } catch (IOException unused) {
            C6477g.m36903a("GetDomainNameUtil", "IOException");
            m36881a(2015, "IOException");
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", 2015, this.f30050c);
        } catch (JSONException unused2) {
            C6477g.m36903a("GetDomainNameUtil", "JSONException");
            m36881a(2015, "JSONException");
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", 2015, this.f30050c);
        } catch (XmlPullParserException unused3) {
            C6477g.m36903a("GetDomainNameUtil", "XmlPullParserException");
            m36881a(2015, "XmlPullParserException");
            C6476f.m36901a(this.f30049b, "hwid.checkPasswordByUserId", 2015, this.f30050c);
        }
    }

    /* renamed from: a */
    public void m36890a(Context context, String str, String str2) {
        if (m36887a(context)) {
            new Thread(new Runnable() { // from class: com.huawei.hms.support.hwid.common.e.d.3

                /* renamed from: a */
                final /* synthetic */ Context f30062a;

                /* renamed from: b */
                final /* synthetic */ String f30063b;

                /* renamed from: c */
                final /* synthetic */ String f30064c;

                /* renamed from: com.huawei.hms.support.hwid.common.e.d$3$1 */
                public class AnonymousClass1 implements InterfaceC6486c<C6484a> {
                    public AnonymousClass1() {
                    }

                    @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
                    /* renamed from: a */
                    public void mo36893a(C6484a c6484a) {
                        C6487d c6487dM36920a = c6484a.m36920a();
                        if (c6487dM36920a.m36921a() == 0) {
                            C6477g.m36904a("GetDomainNameUtil", "updateSiteDomain success: ", true);
                            C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 0, C6474d.this.f30050c);
                        } else {
                            C6477g.m36906b("GetDomainNameUtil", "updateSiteDomain fail: ", true);
                            C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", c6487dM36920a.m36921a(), C6474d.this.f30050c);
                        }
                    }
                }

                public AnonymousClass3(Context context2, String str3, String str22) {
                    context = context2;
                    str = str3;
                    str = str22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C6474d.this.m36891a(context, str, str, new InterfaceC6486c<C6484a>() { // from class: com.huawei.hms.support.hwid.common.e.d.3.1
                        public AnonymousClass1() {
                        }

                        @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
                        /* renamed from: a */
                        public void mo36893a(C6484a c6484a) {
                            C6487d c6487dM36920a = c6484a.m36920a();
                            if (c6487dM36920a.m36921a() == 0) {
                                C6477g.m36904a("GetDomainNameUtil", "updateSiteDomain success: ", true);
                                C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", 0, C6474d.this.f30050c);
                            } else {
                                C6477g.m36906b("GetDomainNameUtil", "updateSiteDomain fail: ", true);
                                C6476f.m36901a(C6474d.this.f30049b, "hwid.checkPasswordByUserId", c6487dM36920a.m36921a(), C6474d.this.f30050c);
                            }
                        }
                    });
                }
            }).start();
        }
    }

    /* renamed from: a */
    private boolean m36887a(Context context) throws NumberFormatException {
        long j10;
        C6477g.m36903a("GetDomainNameUtil", "check needUpdateProp");
        try {
            j10 = Long.parseLong(C6469a.m36860a(context).m36863a("lastupdate", ""));
        } catch (NumberFormatException unused) {
            j10 = 0;
        }
        long time = new Date().getTime();
        if (j10 > time) {
            j10 = 0;
        }
        if (j10 != 0 && time - j10 <= 86400000) {
            C6477g.m36903a("GetDomainNameUtil", "no need update siteDomainName file");
            return false;
        }
        C6477g.m36903a("GetDomainNameUtil", "need update siteDomainName file");
        return true;
    }

    /* renamed from: a */
    public void m36881a(int i10, String str) {
        C6484a c6484a = new C6484a(new C6487d(i10, str));
        InterfaceC6486c<C6484a> interfaceC6486c = this.f30051d;
        if (interfaceC6486c == null) {
            return;
        }
        if (!this.f30057j) {
            this.f30057j = true;
            interfaceC6486c.mo36893a(c6484a);
        }
        C6477g.m36903a("GetDomainNameUtil", "hasOnCallback is:" + this.f30057j);
    }
}
