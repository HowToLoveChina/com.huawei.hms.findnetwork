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
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.c */
/* loaded from: classes8.dex */
public class CallableC5482c extends AbstractC5486g implements Callable {

    /* renamed from: i */
    private static final String f25069i = "DNKeeperCallable";

    /* renamed from: d */
    private RequestHost f25070d;

    /* renamed from: e */
    private String f25071e;

    /* renamed from: f */
    private C5487h f25072f;

    /* renamed from: g */
    private PLSharedPreferences f25073g;

    /* renamed from: h */
    private C5484e f25074h;

    public CallableC5482c(RequestHost requestHost, String str, C5487h c5487h, PLSharedPreferences pLSharedPreferences) {
        this.f25070d = requestHost;
        this.f25071e = requestHost.getDomainName();
        this.f25119b = str;
        this.f25072f = c5487h;
        this.f25073g = pLSharedPreferences;
        C5484e c5484e = new C5484e();
        this.f25074h = c5484e;
        c5484e.put("trigger_type", "dns_sync_query");
    }

    /* renamed from: a */
    private void m32382a() {
        this.f25072f.m32402a(System.currentTimeMillis());
    }

    /* renamed from: b */
    private void m32386b() {
        C5484e.m32387a();
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            Logger.m32144v(f25069i, "dnkeeper report data to aiops is: %s", new JSONObject(this.f25074h.get()));
            HianalyticsHelper.getInstance().executeReportHa(this.f25074h, "dns_request");
        }
    }

    @Override // java.util.concurrent.Callable
    public DnsResult call() throws JSONException {
        HttpClient httpClient = DNKeeperManager.getInstance().getHttpClient();
        DnsResult dnsResult = new DnsResult();
        String str = "https://" + this.f25119b + InterfaceC5483d.f25081g;
        String string = UUID.randomUUID().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metrics_data", new JSONObject().put("trace_id", string));
        } catch (JSONException e10) {
            Logger.m32146w(f25069i, "recordMap fail to put:", e10);
        }
        Request requestBuild = httpClient.newRequest().options(jSONObject.toString()).requestBody(RequestBodyProviders.create(InterfaceC5483d.f25083i, StringUtils.str2Byte(C5485f.m32390a(this.f25070d)))).url(str).method("POST").build();
        Logger.m32143v(f25069i, "DNKeeperCallable call : " + this.f25070d.getDomainName());
        this.f25074h.put("request_domain", "[" + this.f25070d.getDomainName() + ']');
        this.f25074h.put("trace_id", string);
        Submit<ResponseBody> submitNewSubmit = httpClient.newSubmit(requestBuild);
        try {
            Response<ResponseBody> responseExecute = submitNewSubmit.execute();
            m32385a(submitNewSubmit);
            if (responseExecute.isOK() && this.f25119b.equals(this.f25071e)) {
                m32383a((DnsResult) null);
                try {
                    responseExecute.close();
                } catch (IOException e11) {
                    Logger.m32146w(f25069i, "response close error", e11);
                }
                PLSharedPreferences pLSharedPreferences = this.f25073g;
                return pLSharedPreferences != null ? C5485f.m32389a(pLSharedPreferences.getString(this.f25119b)) : dnsResult;
            }
            if (responseExecute.isOK()) {
                m32384a(responseExecute);
            } else {
                Logger.m32145w(f25069i, "response status code:" + responseExecute.getCode());
                this.f25074h.put("error_code", (long) responseExecute.getCode());
                m32382a();
            }
            m32386b();
            DnsResult dnsResultM32401a = this.f25072f.m32401a();
            if (!C5485f.m32398a(dnsResultM32401a)) {
                Logger.m32141i(f25069i, this.f25071e + " queryIps from dnkeeper service success");
                this.f25072f.m32405a(false);
            }
            return dnsResultM32401a;
        } catch (IOException e12) {
            Logger.m32146w(f25069i, "IOException: ", e12);
            this.f25074h.put("error_code", ExceptionCode.getErrorCodeFromException(e12));
            m32385a(submitNewSubmit);
            m32382a();
            m32386b();
            return dnsResult;
        }
    }

    /* renamed from: a */
    private void m32383a(DnsResult dnsResult) throws JSONException {
        PLSharedPreferences pLSharedPreferences = this.f25073g;
        if (pLSharedPreferences != null) {
            pLSharedPreferences.putString(InterfaceC5483d.f25079e, "https://" + this.f25119b);
        }
        if (dnsResult == null) {
            m32399a(this.f25073g);
        } else {
            m32400a(dnsResult, this.f25071e, this.f25073g);
        }
    }

    /* renamed from: a */
    private void m32384a(Response<ResponseBody> response) throws JSONException {
        try {
            String strByte2Str = StringUtils.byte2Str(IoUtils.toByteArray(response.getBody().getInputStream()));
            Logger.m32143v(f25069i, "response = " + strByte2Str);
            JSONObject jSONObject = new JSONObject(strByte2Str);
            int i10 = jSONObject.getInt(DnsResult.KEY_ATN_CODE);
            if (i10 == 0) {
                this.f25074h.put("error_code", 10020000L);
                jSONObject.put("createTime", System.currentTimeMillis());
                DnsResult dnsResultM32389a = C5485f.m32389a(jSONObject.toString());
                this.f25072f.m32403a(dnsResultM32389a);
                m32383a(dnsResultM32389a);
                m32383a((DnsResult) null);
            } else {
                this.f25074h.put("error_code", 10020001L);
                Logger.m32147w(f25069i, "DNKeeper response atnCode %d", Integer.valueOf(i10));
                m32382a();
            }
        } catch (IOException | JSONException e10) {
            m32382a();
            this.f25074h.put("error_code", 10020001L);
            Logger.m32145w(f25069i, e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m32385a(Submit submit) {
        this.f25072f.m32404a((Future) null);
        RequestFinishedInfo requestFinishedInfo = submit.getRequestFinishedInfo();
        if (requestFinishedInfo != null) {
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            this.f25118a = metrics.getConnectIps();
            this.f25074h.put("dns_server_ips", Arrays.toString(metrics.getConnectIps().toArray()));
            this.f25074h.put(C5484e.f25105h, requestFinishedInfo.getMetricsTime().getTotalTime());
            this.f25074h.put("protocol_impl", requestFinishedInfo.getNetworkSdkType());
        }
    }
}
