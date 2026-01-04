package com.huawei.hms.framework.network.restclient.dnkeeper;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.b */
/* loaded from: classes8.dex */
public class CallableC5481b extends AbstractC5486g implements Callable {

    /* renamed from: h */
    private static final String f25064h = "DNKeeperBatchCallable";

    /* renamed from: d */
    private HashSet<RequestHost> f25065d;

    /* renamed from: e */
    private HashMap<String, C5487h> f25066e;

    /* renamed from: f */
    private PLSharedPreferences f25067f;

    /* renamed from: g */
    private C5484e f25068g;

    public CallableC5481b(HashSet<RequestHost> hashSet, String str, HashMap<String, C5487h> map, PLSharedPreferences pLSharedPreferences, C5484e c5484e) {
        HashSet<RequestHost> hashSet2 = new HashSet<>();
        this.f25065d = hashSet2;
        hashSet2.addAll(hashSet);
        this.f25119b = str;
        this.f25066e = map;
        this.f25067f = pLSharedPreferences;
        this.f25068g = c5484e;
    }

    /* renamed from: a */
    private void m32377a() {
        Iterator<C5487h> it = this.f25066e.values().iterator();
        while (it.hasNext()) {
            it.next().m32402a(System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    private void m32378a(C5487h c5487h) {
        c5487h.m32402a(System.currentTimeMillis());
    }

    @Override // java.util.concurrent.Callable
    public HashMap<String, DnsResult> call() throws JSONException {
        RequestFinishedInfo.Metrics metrics;
        HttpClient httpClient = DNKeeperManager.getInstance().getHttpClient();
        HashMap<String, DnsResult> map = new HashMap<>();
        String str = "https://" + this.f25119b + InterfaceC5483d.f25082h;
        String strM32391a = C5485f.m32391a(this.f25065d);
        String string = UUID.randomUUID().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metrics_data", new JSONObject().put("trace_id", string));
        } catch (JSONException e10) {
            Logger.m32146w(f25064h, "recordMap fail to put:", e10);
        }
        Request requestBuild = httpClient.newRequest().options(jSONObject.toString()).requestBody(RequestBodyProviders.create(InterfaceC5483d.f25084j, StringUtils.str2Byte(strM32391a))).url(str).method("POST").build();
        Logger.m32143v(f25064h, "DNKeeperCallable call : " + requestBuild);
        this.f25068g.put("request_domain", this.f25065d.toString());
        this.f25068g.put("trace_id", string);
        Submit<ResponseBody> submitNewSubmit = httpClient.newSubmit(requestBuild);
        try {
            Response<ResponseBody> responseExecute = submitNewSubmit.execute();
            m32381a(submitNewSubmit);
            RequestFinishedInfo requestFinishedInfo = submitNewSubmit.getRequestFinishedInfo();
            if (requestFinishedInfo != null && (metrics = requestFinishedInfo.getMetrics()) != null) {
                this.f25118a = metrics.getConnectIps();
            }
            if (responseExecute.isOK()) {
                Logger.m32141i(f25064h, "response from dnkeeper server success");
                this.f25068g.put("error_code", 10020000L);
                m32380a(responseExecute);
            } else {
                Logger.m32145w(f25064h, "response status code:" + responseExecute.getCode());
                this.f25068g.put("error_code", (long) responseExecute.getCode());
                m32377a();
            }
            C5484e.m32387a();
            if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
                Logger.m32144v(f25064h, "dnkeeper report data to aiops is: %s", new JSONObject(this.f25068g.get()));
                HianalyticsHelper.getInstance().executeReportHa(this.f25068g, "dns_request");
            }
            for (Map.Entry<String, C5487h> entry : this.f25066e.entrySet()) {
                C5487h value = entry.getValue();
                if (!C5485f.m32398a(value.m32401a())) {
                    Logger.m32136d(f25064h, "queryIps from dnkeeper service success");
                    value.m32405a(false);
                    map.put(entry.getKey(), value.m32401a());
                }
            }
            return map;
        } catch (IOException e11) {
            Logger.m32146w(f25064h, "IOException: ", e11);
            this.f25068g.put("error_code", ExceptionCode.getErrorCodeFromException(e11));
            m32381a(submitNewSubmit);
            m32377a();
            C5484e.m32387a();
            if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
                Logger.m32144v(f25064h, "dnkeeper report data to aiops is: %s", new JSONObject(this.f25068g.get()));
                HianalyticsHelper.getInstance().executeReportHa(this.f25068g, "dns_request");
            }
            return map;
        }
    }

    /* renamed from: a */
    private void m32379a(DnsResult dnsResult, String str) throws JSONException {
        if (dnsResult == null) {
            m32399a(this.f25067f);
        } else {
            m32400a(dnsResult, str, this.f25067f);
        }
    }

    /* renamed from: a */
    private void m32380a(Response<ResponseBody> response) throws JSONException {
        try {
            String strByte2Str = StringUtils.byte2Str(IoUtils.toByteArray(response.getBody().getInputStream()));
            Logger.m32143v(f25064h, "response = " + strByte2Str);
            JSONObject jSONObject = new JSONObject(strByte2Str);
            JSONArray jSONArray = jSONObject.getJSONArray(InterfaceC5483d.f25089o);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(InterfaceC5483d.f25088n);
            StringBuilder sb2 = new StringBuilder();
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    if (i10 > 0) {
                        sb2.append("&");
                    }
                    sb2.append(jSONArrayOptJSONArray.opt(i10));
                }
            }
            PLSharedPreferences pLSharedPreferences = this.f25067f;
            if (pLSharedPreferences != null) {
                pLSharedPreferences.putString(InterfaceC5483d.f25079e, "https://" + this.f25119b);
                Logger.m32136d(f25064h, "whiteDomainRecords persist " + jSONArrayOptJSONArray);
                this.f25067f.putString(InterfaceC5483d.f25088n, sb2.toString());
            }
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                String string = jSONObject2.getString("domainName");
                C5487h c5487h = this.f25066e.get(string);
                if (c5487h == null) {
                    c5487h = new C5487h();
                    this.f25066e.put(string, c5487h);
                }
                if (jSONObject2.getInt(DnsResult.KEY_ATN_CODE) == 0) {
                    jSONObject2.put("createTime", System.currentTimeMillis());
                    DnsResult dnsResultM32389a = C5485f.m32389a(jSONObject2.toString());
                    c5487h.m32403a(dnsResultM32389a);
                    m32379a(dnsResultM32389a, string);
                } else {
                    this.f25068g.put("error_code", 10020001L);
                    m32378a(c5487h);
                }
            }
            m32379a(null, null);
        } catch (IOException | JSONException e10) {
            m32377a();
            this.f25068g.put("error_code", 10020001L);
            Logger.m32145w(f25064h, e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m32381a(Submit submit) {
        Iterator<C5487h> it = this.f25066e.values().iterator();
        while (it.hasNext()) {
            it.next().m32404a((Future) null);
        }
        RequestFinishedInfo requestFinishedInfo = submit.getRequestFinishedInfo();
        if (requestFinishedInfo != null) {
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            this.f25118a = metrics.getConnectIps();
            this.f25068g.put("dns_server_ips", Arrays.toString(metrics.getConnectIps().toArray()));
            this.f25068g.put(C5484e.f25105h, requestFinishedInfo.getMetricsTime().getTotalTime());
            this.f25068g.put("protocol_impl", requestFinishedInfo.getNetworkSdkType());
        }
    }
}
