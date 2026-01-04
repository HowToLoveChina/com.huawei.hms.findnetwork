package com.huawei.hms.drive;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.restclient.dnkeeper.C5484e;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
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

/* renamed from: com.huawei.hms.drive.n */
/* loaded from: classes8.dex */
public class CallableC5292n extends AbstractC5296r implements Callable {

    /* renamed from: c */
    private HashSet<C5291m> f24540c;

    /* renamed from: d */
    private HashMap<String, C5297s> f24541d;

    /* renamed from: e */
    private PLSharedPreferences f24542e;

    /* renamed from: f */
    private C5294p f24543f;

    public CallableC5292n(HashSet<C5291m> hashSet, String str, HashMap<String, C5297s> map, PLSharedPreferences pLSharedPreferences, C5294p c5294p) {
        HashSet<C5291m> hashSet2 = new HashSet<>();
        this.f24540c = hashSet2;
        hashSet2.addAll(hashSet);
        this.f24551b = str;
        this.f24541d = map;
        this.f24542e = pLSharedPreferences;
        this.f24543f = c5294p;
    }

    /* renamed from: b */
    private void m31768b() {
        Iterator<C5297s> it = this.f24541d.values().iterator();
        while (it.hasNext()) {
            it.next().m31790a(System.currentTimeMillis());
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public HashMap<String, C5298t> call() throws JSONException {
        RequestFinishedInfo.Metrics metrics;
        HttpClient httpClientM31753d = C5290l.m31730a().m31753d();
        HashMap<String, C5298t> map = new HashMap<>();
        String str = "https://" + this.f24551b + InterfaceC5483d.f25082h;
        String strM31780a = C5295q.m31780a(this.f24540c);
        String string = UUID.randomUUID().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metrics_data", new JSONObject().put("trace_id", string));
        } catch (JSONException e10) {
            Logger.m32146w("DNKeeperBatchCallable", "recordMap fail to put:", e10);
        }
        Request requestBuild = httpClientM31753d.newRequest().options(jSONObject.toString()).requestBody(RequestBodyProviders.create(InterfaceC5483d.f25084j, StringUtils.str2Byte(strM31780a))).url(str).method("POST").build();
        Logger.m32143v("DNKeeperBatchCallable", "DNKeeperCallable call : " + requestBuild);
        this.f24543f.put("request_domain", this.f24540c.toString());
        this.f24543f.put("trace_id", string);
        Submit<ResponseBody> submitNewSubmit = httpClientM31753d.newSubmit(requestBuild);
        try {
            Response<ResponseBody> responseExecute = submitNewSubmit.execute();
            m31767a(submitNewSubmit);
            RequestFinishedInfo requestFinishedInfo = submitNewSubmit.getRequestFinishedInfo();
            if (requestFinishedInfo != null && (metrics = requestFinishedInfo.getMetrics()) != null) {
                this.f24550a = metrics.getConnectIps();
            }
            if (responseExecute.isOK()) {
                Logger.m32141i("DNKeeperBatchCallable", "response from dnkeeper server success");
                this.f24543f.put("error_code", 10020000L);
                m31766a(responseExecute);
            } else {
                Logger.m32145w("DNKeeperBatchCallable", "response status code:" + responseExecute.getCode());
                this.f24543f.put("error_code", (long) responseExecute.getCode());
                m31768b();
            }
            C5294p.m31776a();
            if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
                Logger.m32144v("DNKeeperBatchCallable", "dnkeeper report data to aiops is: %s", new JSONObject(this.f24543f.get()));
                HianalyticsHelper.getInstance().executeReportHa(this.f24543f, "dns_request");
            }
            for (Map.Entry<String, C5297s> entry : this.f24541d.entrySet()) {
                C5297s value = entry.getValue();
                if (!C5295q.m31786a(value.m31797d())) {
                    Logger.m32136d("DNKeeperBatchCallable", "queryIps from dnkeeper service success");
                    value.m31793a(false);
                    map.put(entry.getKey(), value.m31797d());
                }
            }
            return map;
        } catch (IOException e11) {
            Logger.m32146w("DNKeeperBatchCallable", "IOException: ", e11);
            this.f24543f.put("error_code", ExceptionCode.getErrorCodeFromException(e11));
            m31767a(submitNewSubmit);
            m31768b();
            C5294p.m31776a();
            if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
                Logger.m32144v("DNKeeperBatchCallable", "dnkeeper report data to aiops is: %s", new JSONObject(this.f24543f.get()));
                HianalyticsHelper.getInstance().executeReportHa(this.f24543f, "dns_request");
            }
            return map;
        }
    }

    /* renamed from: a */
    private void m31764a(C5297s c5297s) {
        c5297s.m31790a(System.currentTimeMillis());
    }

    /* renamed from: a */
    private void m31765a(C5298t c5298t, String str) throws JSONException {
        if (c5298t == null) {
            m31789a(this.f24542e);
        } else {
            m31788a(c5298t, str, this.f24542e);
        }
    }

    /* renamed from: a */
    private void m31766a(Response<ResponseBody> response) throws JSONException {
        try {
            String strByte2Str = StringUtils.byte2Str(IoUtils.toByteArray(response.getBody().getInputStream()));
            Logger.m32143v("DNKeeperBatchCallable", "response = " + strByte2Str);
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
            PLSharedPreferences pLSharedPreferences = this.f24542e;
            if (pLSharedPreferences != null) {
                pLSharedPreferences.putString(InterfaceC5483d.f25079e, "https://" + this.f24551b);
                Logger.m32136d("DNKeeperBatchCallable", "whiteDomainRecords persist " + jSONArrayOptJSONArray);
                this.f24542e.putString(InterfaceC5483d.f25088n, sb2.toString());
            }
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                String string = jSONObject2.getString("domainName");
                C5297s c5297s = this.f24541d.get(string);
                if (c5297s == null) {
                    c5297s = new C5297s();
                    this.f24541d.put(string, c5297s);
                }
                if (jSONObject2.getInt(DnsResult.KEY_ATN_CODE) == 0) {
                    jSONObject2.put("createTime", System.currentTimeMillis());
                    C5298t c5298tM31778a = C5295q.m31778a(jSONObject2.toString());
                    c5297s.m31791a(c5298tM31778a);
                    m31765a(c5298tM31778a, string);
                } else {
                    this.f24543f.put("error_code", 10020001L);
                    m31764a(c5297s);
                }
            }
            m31765a(null, null);
        } catch (IOException | JSONException e10) {
            m31768b();
            this.f24543f.put("error_code", 10020001L);
            Logger.m32145w("DNKeeperBatchCallable", e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m31767a(Submit submit) {
        Iterator<C5297s> it = this.f24541d.values().iterator();
        while (it.hasNext()) {
            it.next().m31792a((Future) null);
        }
        RequestFinishedInfo requestFinishedInfo = submit.getRequestFinishedInfo();
        if (requestFinishedInfo != null) {
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            this.f24550a = metrics.getConnectIps();
            this.f24543f.put("dns_server_ips", Arrays.toString(metrics.getConnectIps().toArray()));
            this.f24543f.put(C5484e.f25105h, requestFinishedInfo.getMetricsTime().getTotalTime());
            this.f24543f.put("protocol_impl", requestFinishedInfo.getNetworkSdkType());
        }
    }
}
