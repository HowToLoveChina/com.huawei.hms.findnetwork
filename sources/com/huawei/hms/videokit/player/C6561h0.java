package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.network.base.common.MediaType;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.videokit.player.WisePlayer;
import com.huawei.hms.videokit.player.bean.recommend.C6547a;
import com.huawei.hms.videokit.player.bean.recommend.RecommendOptions;
import com.huawei.hms.videokit.player.bean.recommend.RecommendVideo;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.videokit.player.h0 */
/* loaded from: classes8.dex */
public class C6561h0 {

    /* renamed from: a */
    private Context f30464a;

    /* renamed from: b */
    private C6591o0 f30465b = new C6591o0();

    /* renamed from: com.huawei.hms.videokit.player.h0$a */
    public class a implements Runnable {

        /* renamed from: a */
        private String f30466a;

        /* renamed from: b */
        private RecommendOptions f30467b;

        /* renamed from: c */
        private String f30468c;

        /* renamed from: d */
        private WisePlayer.IRecommendVideoCallback f30469d;

        /* renamed from: e */
        private C6605w f30470e = new C6605w();

        public a(String str, RecommendOptions recommendOptions, String str2, WisePlayer.IRecommendVideoCallback iRecommendVideoCallback) {
            this.f30466a = str;
            this.f30467b = recommendOptions;
            this.f30468c = str2;
            this.f30469d = iRecommendVideoCallback;
        }

        /* renamed from: a */
        private Submit<ResponseBody> m37389a() {
            String strM37641a = "";
            try {
                this.f30470e.m37704b(C6600t0.m37688f());
                this.f30470e.m37709d(String.valueOf(C6600t0.m37688f()));
                strM37641a = C6597s.m37641a("videoopenapi");
                this.f30470e.m37707c(String.valueOf(C6600t0.m37688f()));
            } catch (JSONException e10) {
                C6550c1.m37258a("RecommendRequestLogic", "getGrsServiceUrl fail ", e10);
            }
            this.f30470e.m37702a(strM37641a);
            this.f30470e.m37713f("/contentopenapi/v1/getVodInfo");
            String strM37645b = C6598s0.m37645b(C6561h0.this.f30464a);
            this.f30470e.m37717h(strM37645b);
            if (C6600t0.m37683c(strM37641a)) {
                C6550c1.m37265d("RecommendRequestLogic", "GetRecommendInfoTask, domainName empty");
                this.f30470e.m37700a(101);
                return null;
            }
            return C6561h0.this.f30465b.m37581a(C6561h0.this.f30464a, strM37641a).m37696a(strM37641a + "/contentopenapi/v1/getVodInfo", C6561h0.this.m37387a(this.f30468c, strM37645b), RequestBodyProviders.create(MediaType.parse("application/json;charset=utf-8"), m37391b().toString()));
        }

        /* renamed from: b */
        private JSONObject m37391b() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String strM37690g = C6600t0.m37690g();
            try {
                if (C6600t0.m37683c(strM37690g)) {
                    strM37690g = "UNKNOW";
                }
                jSONObject.put("terminalType", strM37690g);
                jSONObject.put("packageName", "com.huawei.hms.videokit.player");
                jSONObject.put("ver", String.valueOf(10016300));
                jSONObject.put("deviceId", C6580j.m37442b());
                jSONObject.put(StartDownloadV2IPCRequest.KEY_DEVICE_ID_TYPE, "6");
                RecommendOptions recommendOptions = this.f30467b;
                jSONObject.put("i18n", (recommendOptions == null || C6600t0.m37683c(recommendOptions.getLanguage())) ? C6583k0.m37457a(C6561h0.this.f30464a) : this.f30467b.getLanguage());
                jSONObject.put("country", C6597s.m37640a());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mvId", this.f30466a);
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e10) {
                C6550c1.m37258a("RecommendRequestLogic", "getRequest", e10);
            }
            return jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Submit<ResponseBody> submitM37389a = m37389a();
            if (submitM37389a == null) {
                C6550c1.m37265d("RecommendRequestLogic", "GetRecommendInfoTask request null");
                this.f30469d.onFailed(PlayerConstants.ErrorCode.DEFAULT_ERROR, 0, null);
                C6561h0.this.m37382a(this.f30470e);
                return;
            }
            C6547a c6547aM37390a = m37390a(submitM37389a);
            if (c6547aM37390a.m37241d() != 0 || c6547aM37390a.m37240c() == null) {
                C6550c1.m37265d("RecommendRequestLogic", "GetRecommendInfoTask query failed");
                int[] iArrM37384a = C6561h0.this.m37384a(c6547aM37390a);
                this.f30469d.onFailed(iArrM37384a[0], iArrM37384a[1], null);
            } else {
                C6550c1.m37264c("RecommendRequestLogic", "GetRecommendInfoTask response success");
                ArrayList arrayList = new ArrayList();
                arrayList.add(c6547aM37390a.m37240c());
                this.f30469d.onSuccess(arrayList);
            }
            C6561h0.this.m37382a(this.f30470e);
            C6561h0.this.m37383a(this.f30466a, c6547aM37390a.m37240c());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r9v1, types: [com.huawei.hms.videokit.player.w] */
        /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.StringBuilder] */
        /* renamed from: a */
        private C6547a m37390a(Submit<ResponseBody> submit) throws Throwable {
            String str;
            int i10;
            StringBuilder sb2;
            Response<ResponseBody> responseExecute;
            Response<ResponseBody> response = null;
            strValueOf = null;
            strValueOf = null;
            String strValueOf = null;
            response = null;
            ?? r32 = 0;
            int i11 = 0;
            try {
            } catch (Throwable th2) {
                th = th2;
                r32 = responseExecute;
            }
            try {
                try {
                    responseExecute = submit.execute();
                    if (responseExecute != null) {
                        try {
                            strValueOf = String.valueOf(responseExecute.getCode());
                            String protocol = submit.getRequestFinishedInfo().getMetrics().getProtocol();
                            Locale locale = Locale.ENGLISH;
                            if (protocol.toLowerCase(locale).equals("http/1.1")) {
                                protocol = "HTTP/1.1";
                            } else if (protocol.toLowerCase(locale).equals("h2")) {
                                protocol = "HTTP/2.0";
                            } else {
                                C6550c1.m37256a("RecommendRequestLogic", "none http protocol");
                            }
                            this.f30470e.m37715g(protocol);
                            this.f30470e.m37711e(strValueOf);
                        } catch (IOException e10) {
                            e = e10;
                            str = strValueOf;
                            response = responseExecute;
                            i10 = 100;
                            C6550c1.m37258a("RecommendRequestLogic", "getUrl, request execute", e);
                            this.f30470e.m37701a(C6600t0.m37688f());
                            this.f30470e.m37700a(100);
                            sb2 = new StringBuilder();
                            sb2.append("clientCode:");
                            sb2.append(i10);
                            C6550c1.m37256a("RecommendRequestLogic", sb2.toString());
                            int i12 = i10;
                            responseExecute = response;
                            strValueOf = str;
                            i11 = i12;
                            C6547a c6547aM37369a = C6559g0.m37369a(responseExecute);
                            this.f30470e.m37705b(String.valueOf(c6547aM37369a.m37241d()));
                            c6547aM37369a.m37234a(i11);
                            c6547aM37369a.m37236a(strValueOf);
                            return c6547aM37369a;
                        } catch (Exception e11) {
                            e = e11;
                            str = strValueOf;
                            response = responseExecute;
                            i10 = 101;
                            C6550c1.m37258a("RecommendRequestLogic", "getUrl, request nullPointer", e);
                            this.f30470e.m37701a(C6600t0.m37688f());
                            this.f30470e.m37700a(101);
                            sb2 = new StringBuilder();
                            sb2.append("clientCode:");
                            sb2.append(i10);
                            C6550c1.m37256a("RecommendRequestLogic", sb2.toString());
                            int i122 = i10;
                            responseExecute = response;
                            strValueOf = str;
                            i11 = i122;
                            C6547a c6547aM37369a2 = C6559g0.m37369a(responseExecute);
                            this.f30470e.m37705b(String.valueOf(c6547aM37369a2.m37241d()));
                            c6547aM37369a2.m37234a(i11);
                            c6547aM37369a2.m37236a(strValueOf);
                            return c6547aM37369a2;
                        }
                    }
                    this.f30470e.m37701a(C6600t0.m37688f());
                    this.f30470e.m37700a(0);
                    C6550c1.m37256a("RecommendRequestLogic", "clientCode:0");
                } catch (IOException e12) {
                    e = e12;
                    str = null;
                } catch (Exception e13) {
                    e = e13;
                    str = null;
                }
                C6547a c6547aM37369a22 = C6559g0.m37369a(responseExecute);
                this.f30470e.m37705b(String.valueOf(c6547aM37369a22.m37241d()));
                c6547aM37369a22.m37234a(i11);
                c6547aM37369a22.m37236a(strValueOf);
                return c6547aM37369a22;
            } catch (Throwable th3) {
                th = th3;
                this.f30470e.m37701a(C6600t0.m37688f());
                this.f30470e.m37700a(r32);
                C6550c1.m37256a("RecommendRequestLogic", "clientCode:" + r32);
                throw th;
            }
        }
    }

    public C6561h0(Context context) {
        this.f30464a = context;
    }

    /* renamed from: a */
    public HashMap<String, String> m37387a(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", InterfaceC5483d.f25084j);
        map.put("Accept", InterfaceC5483d.f25084j);
        if (str2 == null) {
            str2 = "";
        }
        map.put("x-traceId", str2);
        map.put(FeedbackWebConstants.AUTHORIZATION, "Bearer " + C6591o0.m37575a(str));
        return map;
    }

    /* renamed from: a */
    public void m37382a(C6605w c6605w) {
        C6592p c6592pM37249a = C6549c0.m37249a(this.f30464a);
        c6592pM37249a.m37591a("IFTYPE", "/contentopenapi/v1/getVodInfo");
        c6592pM37249a.m37591a("GRS_STARTTS", c6605w.m37712f());
        c6592pM37249a.m37591a("GRS_ENDTS", c6605w.m37710e());
        c6592pM37249a.m37591a("NET", C6589n0.m37566b(this.f30464a));
        c6592pM37249a.m37591a("X-TRACEID", c6605w.m37719j());
        c6592pM37249a.m37590a("STARTTS", c6605w.m37718i());
        c6592pM37249a.m37590a("ENDTS", c6605w.m37706c());
        c6592pM37249a.m37591a("DOMAINNAME", c6605w.m37703b());
        int iM37699a = c6605w.m37699a();
        c6592pM37249a.m37591a("CLIENTCODE", iM37699a == 0 ? "" : String.valueOf(iM37699a));
        c6592pM37249a.m37591a("PROTOCOL", c6605w.m37716h());
        c6592pM37249a.m37591a("HTTPCODE", c6605w.m37714g());
        c6592pM37249a.m37591a("ERRORCODE", c6605w.m37708d());
        C6609y.m37724b().m37725a(1, "VideoKitOM100", c6592pM37249a);
    }

    /* renamed from: a */
    public void m37388a(String str, RecommendOptions recommendOptions, String str2, WisePlayer.IRecommendVideoCallback iRecommendVideoCallback) {
        if (iRecommendVideoCallback == null) {
            C6550c1.m37265d("RecommendRequestLogic", "getRecommendVideoList callback null");
        } else if (!C6600t0.m37683c(str) && !C6600t0.m37683c(str2)) {
            C6595q0.m37636a(new a(str, recommendOptions, str2, iRecommendVideoCallback));
        } else {
            C6550c1.m37265d("RecommendRequestLogic", "getRecommendVideoList param check error");
            iRecommendVideoCallback.onFailed(PlayerConstants.ErrorCode.INPUT_PARAM_ILLEGAL_ERROR, 0, null);
        }
    }

    /* renamed from: a */
    public void m37383a(String str, RecommendVideo recommendVideo) throws JSONException {
        if (C6600t0.m37683c(str) || recommendVideo == null) {
            C6550c1.m37265d("RecommendRequestLogic", "reportOp102ForRecommend param illegal, originalId:" + str);
            return;
        }
        C6592p c6592pM37249a = C6549c0.m37249a(this.f30464a);
        c6592pM37249a.m37591a("originVideoId", str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("videoId", recommendVideo.getVideoId());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            c6592pM37249a.m37591a("recVideo", String.valueOf(jSONArray));
        } catch (JSONException e10) {
            C6550c1.m37258a("RecommendRequestLogic", "get OP102 data fail ", e10);
        }
        C6609y.m37724b().m37725a(0, "VideoKitOP102", c6592pM37249a);
    }

    /* renamed from: a */
    public int[] m37384a(C6547a c6547a) {
        int iM37562a;
        int[] iArr = {PlayerConstants.ErrorCode.DEFAULT_ERROR, 0};
        if (c6547a.m37233a() == 100) {
            iArr[0] = 1201;
            return iArr;
        }
        if (c6547a.m37241d() != 0) {
            iArr[0] = 1131;
            iArr[1] = c6547a.m37241d();
            return iArr;
        }
        if (C6600t0.m37683c(c6547a.m37237b()) || (iM37562a = C6587m0.m37562a(c6547a.m37237b(), PlayerConstants.ErrorCode.DEFAULT_ERROR)) == 1199) {
            return iArr;
        }
        iArr[0] = 1203;
        iArr[1] = iM37562a;
        return iArr;
    }
}
