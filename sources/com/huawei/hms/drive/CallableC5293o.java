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
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.drive.o */
/* loaded from: classes8.dex */
public class CallableC5293o extends AbstractC5296r implements Callable {

    /* renamed from: c */
    private C5291m f24544c;

    /* renamed from: d */
    private String f24545d;

    /* renamed from: e */
    private C5297s f24546e;

    /* renamed from: f */
    private PLSharedPreferences f24547f;

    /* renamed from: g */
    private C5294p f24548g;

    public CallableC5293o(C5291m c5291m, String str, C5297s c5297s, PLSharedPreferences pLSharedPreferences) {
        this.f24544c = c5291m;
        this.f24545d = c5291m.m31754a();
        this.f24551b = str;
        this.f24546e = c5297s;
        this.f24547f = pLSharedPreferences;
        C5294p c5294p = new C5294p();
        this.f24548g = c5294p;
        c5294p.put("trigger_type", "dns_sync_query");
    }

    /* renamed from: b */
    private void m31773b() {
        C5294p.m31776a();
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            Logger.m32144v("DNKeeperCallable", "dnkeeper report data to aiops is: %s", new JSONObject(this.f24548g.get()));
            HianalyticsHelper.getInstance().executeReportHa(this.f24548g, "dns_request");
        }
    }

    /* renamed from: c */
    private void m31774c() {
        this.f24546e.m31790a(System.currentTimeMillis());
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public C5298t call() throws JSONException {
        HttpClient httpClientM31753d = C5290l.m31730a().m31753d();
        C5298t c5298t = new C5298t();
        String str = "https://" + this.f24551b + InterfaceC5483d.f25081g;
        String string = UUID.randomUUID().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metrics_data", new JSONObject().put("trace_id", string));
        } catch (JSONException e10) {
            Logger.m32146w("DNKeeperCallable", "recordMap fail to put:", e10);
        }
        Request requestBuild = httpClientM31753d.newRequest().options(jSONObject.toString()).requestBody(RequestBodyProviders.create(InterfaceC5483d.f25083i, StringUtils.str2Byte(C5295q.m31779a(this.f24544c)))).url(str).method("POST").build();
        Logger.m32143v("DNKeeperCallable", "DNKeeperCallable call : " + this.f24544c.m31754a());
        this.f24548g.put("request_domain", "[" + this.f24544c.m31754a() + ']');
        this.f24548g.put("trace_id", string);
        Submit<ResponseBody> submitNewSubmit = httpClientM31753d.newSubmit(requestBuild);
        try {
            Response<ResponseBody> responseExecute = submitNewSubmit.execute();
            m31772a(submitNewSubmit);
            if (responseExecute.isOK() && this.f24551b.equals(this.f24545d)) {
                m31770a((C5298t) null);
                try {
                    responseExecute.close();
                } catch (IOException e11) {
                    Logger.m32146w("DNKeeperCallable", "response close error", e11);
                }
                PLSharedPreferences pLSharedPreferences = this.f24547f;
                return pLSharedPreferences != null ? C5295q.m31778a(pLSharedPreferences.getString(this.f24551b)) : c5298t;
            }
            if (responseExecute.isOK()) {
                m31771a(responseExecute);
            } else {
                Logger.m32145w("DNKeeperCallable", "response status code:" + responseExecute.getCode());
                this.f24548g.put("error_code", (long) responseExecute.getCode());
                m31774c();
            }
            m31773b();
            C5298t c5298tM31797d = this.f24546e.m31797d();
            if (!C5295q.m31786a(c5298tM31797d)) {
                Logger.m32141i("DNKeeperCallable", this.f24545d + " queryIps from dnkeeper service success");
                this.f24546e.m31793a(false);
            }
            return c5298tM31797d;
        } catch (IOException e12) {
            Logger.m32146w("DNKeeperCallable", "IOException: ", e12);
            this.f24548g.put("error_code", ExceptionCode.getErrorCodeFromException(e12));
            m31772a(submitNewSubmit);
            m31774c();
            m31773b();
            return c5298t;
        }
    }

    /* renamed from: a */
    private void m31770a(C5298t c5298t) throws JSONException {
        PLSharedPreferences pLSharedPreferences = this.f24547f;
        if (pLSharedPreferences != null) {
            pLSharedPreferences.putString(InterfaceC5483d.f25079e, "https://" + this.f24551b);
        }
        if (c5298t == null) {
            m31789a(this.f24547f);
        } else {
            m31788a(c5298t, this.f24545d, this.f24547f);
        }
    }

    /* renamed from: a */
    private void m31771a(Response<ResponseBody> response) throws JSONException {
        try {
            String strByte2Str = StringUtils.byte2Str(IoUtils.toByteArray(response.getBody().getInputStream()));
            Logger.m32143v("DNKeeperCallable", "response = " + strByte2Str);
            JSONObject jSONObject = new JSONObject(strByte2Str);
            int i10 = jSONObject.getInt(DnsResult.KEY_ATN_CODE);
            if (i10 == 0) {
                this.f24548g.put("error_code", 10020000L);
                jSONObject.put("createTime", System.currentTimeMillis());
                C5298t c5298tM31778a = C5295q.m31778a(jSONObject.toString());
                this.f24546e.m31791a(c5298tM31778a);
                m31770a(c5298tM31778a);
                m31770a((C5298t) null);
            } else {
                this.f24548g.put("error_code", 10020001L);
                Logger.m32147w("DNKeeperCallable", "DNKeeper response atnCode %d", Integer.valueOf(i10));
                m31774c();
            }
        } catch (IOException | JSONException e10) {
            m31774c();
            this.f24548g.put("error_code", 10020001L);
            Logger.m32145w("DNKeeperCallable", e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m31772a(Submit submit) {
        this.f24546e.m31792a((Future) null);
        RequestFinishedInfo requestFinishedInfo = submit.getRequestFinishedInfo();
        if (requestFinishedInfo != null) {
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            this.f24550a = metrics.getConnectIps();
            this.f24548g.put("dns_server_ips", Arrays.toString(metrics.getConnectIps().toArray()));
            this.f24548g.put(C5484e.f25105h, requestFinishedInfo.getMetricsTime().getTotalTime());
            this.f24548g.put("protocol_impl", requestFinishedInfo.getNetworkSdkType());
        }
    }
}
