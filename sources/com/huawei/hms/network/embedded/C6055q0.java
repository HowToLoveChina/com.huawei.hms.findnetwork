package com.huawei.hms.network.embedded;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.q0 */
/* loaded from: classes8.dex */
public class C6055q0 {

    /* renamed from: d */
    public static final String f27797d = "HttpDnsClient";

    /* renamed from: e */
    public static final String f27798e = ",";

    /* renamed from: f */
    public static final String f27799f = "Retry-After";

    /* renamed from: g */
    public static final String f27800g = "metrics_data";

    /* renamed from: h */
    public static final String f27801h = "type";

    /* renamed from: i */
    public static final String f27802i = "ttl";

    /* renamed from: j */
    public static final String f27803j = "values";

    /* renamed from: k */
    public static final String f27804k = "values_v6";

    /* renamed from: l */
    public static final String f27805l = "domain";

    /* renamed from: m */
    public static final String f27806m = "dns";

    /* renamed from: n */
    public static final String f27807n = "error_code";

    /* renamed from: o */
    public static final int f27808o = 1000;

    /* renamed from: p */
    public static final int f27809p = 5;

    /* renamed from: q */
    public static final int f27810q = 86400;

    /* renamed from: r */
    public static final int f27811r = 600;

    /* renamed from: s */
    public static final int f27812s = 60;

    /* renamed from: t */
    public static final int f27813t = 503;

    /* renamed from: a */
    public final String f27814a;

    /* renamed from: b */
    public final HttpClient f27815b = new HttpClient.Builder().retryTimeOnConnectionFailure(0).build();

    /* renamed from: c */
    public a f27816c;

    /* renamed from: com.huawei.hms.network.embedded.q0$a */
    public static class a {

        /* renamed from: a */
        public final long f27817a;

        /* renamed from: b */
        public final long f27818b;

        public a(long j10, long j11) {
            this.f27817a = j10;
            this.f27818b = j11;
        }

        /* renamed from: a */
        public boolean m35052a() {
            return SystemClock.elapsedRealtime() - this.f27818b <= this.f27817a;
        }
    }

    public C6055q0(String str) {
        this.f27814a = str;
    }

    /* renamed from: a */
    public C6003m0 m35048a(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C6042p0 c6042p0 = new C6042p0();
        ArrayList<C6003m0> arrayListM35047a = m35047a(arrayList, c6042p0);
        C6042p0.m34949a();
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            Logger.m32144v("HttpDnsClient", "httpdns report data to aiops is: %s", new JSONObject(c6042p0.get()));
            HianalyticsHelper.getInstance().executeReportHa(c6042p0, "dns_request");
        }
        Iterator<C6003m0> it = arrayListM35047a.iterator();
        return it.hasNext() ? it.next() : new C6003m0();
    }

    /* renamed from: a */
    private C6003m0 m35045a(JSONObject jSONObject) {
        boolean z10;
        C6003m0 c6003m0 = new C6003m0();
        c6003m0.m34743b(3);
        if (TextUtils.isEmpty(jSONObject.optString("error_code"))) {
            int iOptInt = jSONObject.optInt("ttl");
            if (iOptInt > 86400) {
                iOptInt = 86400;
            } else if (iOptInt < 0) {
                iOptInt = 600;
            }
            c6003m0.m34744b(iOptInt * 1000);
            c6003m0.m34745b(jSONObject.optString("domain"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(f27803j);
            int i10 = 0;
            boolean z11 = false;
            if (jSONArrayOptJSONArray == null) {
                Logger.m32138e("HttpDnsClient", "response return empty ipv4 values");
                z10 = false;
            } else {
                int i11 = 0;
                z10 = false;
                while (i11 < jSONArrayOptJSONArray.length()) {
                    c6003m0.m34739a((String) jSONArrayOptJSONArray.opt(i11));
                    i11++;
                    z10 = true;
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(f27804k);
            if (jSONArrayOptJSONArray2 == null) {
                Logger.m32145w("HttpDnsClient", "response return empty ipv6 values");
            } else {
                boolean z12 = false;
                while (i10 < jSONArrayOptJSONArray2.length()) {
                    c6003m0.m34739a((String) jSONArrayOptJSONArray2.opt(i10));
                    i10++;
                    z12 = true;
                }
                z11 = z12;
            }
            C6158y.m35823a(c6003m0, z10, z11);
        }
        return c6003m0;
    }

    /* renamed from: a */
    public a m35049a() {
        return this.f27816c;
    }

    /* renamed from: a */
    private ArrayList<C6003m0> m35046a(Response<ResponseBody> response) {
        String str;
        ArrayList<C6003m0> arrayList = new ArrayList<>();
        try {
            String strByte2Str = StringUtils.byte2Str(IoUtils.toByteArray(response.getBody().getInputStream()));
            Logger.m32143v("HttpDnsClient", "BODY:" + strByte2Str);
            JSONArray jSONArray = new JSONObject(strByte2Str).getJSONArray("dns");
            arrayList.ensureCapacity(jSONArray.length());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                C6003m0 c6003m0M35045a = m35045a(jSONArray.getJSONObject(i10));
                c6003m0M35045a.m34737a(0);
                arrayList.add(c6003m0M35045a);
            }
        } catch (IOException e10) {
            e = e10;
            str = "IOException";
            Logger.m32146w("HttpDnsClient", str, e);
        } catch (JSONException e11) {
            Logger.m32147w("HttpDnsClient", "JSONException", e11.getClass().getSimpleName());
        } catch (Throwable th2) {
            e = th2;
            str = "parseResponse error";
            Logger.m32146w("HttpDnsClient", str, e);
        }
        return arrayList;
    }

    /* renamed from: a */
    public ArrayList<C6003m0> m35050a(List<String> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (String str : list) {
            if (i10 >= 5) {
                break;
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
                i10++;
            }
        }
        C6042p0 c6042p0 = new C6042p0();
        c6042p0.put("trigger_type", "dns_init");
        ArrayList<C6003m0> arrayListM35047a = m35047a(arrayList, c6042p0);
        C6042p0.m34949a();
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            Logger.m32144v("HttpDnsClient", "httpdns report data to aiops is: %s", new JSONObject(c6042p0.get()));
            HianalyticsHelper.getInstance().executeReportHa(c6042p0, "dns_request");
        }
        return arrayListM35047a;
    }

    /* renamed from: a */
    private ArrayList<C6003m0> m35047a(List<String> list, C6042p0 c6042p0) throws JSONException {
        long code;
        if (TextUtils.isEmpty(this.f27814a)) {
            Logger.m32138e("HttpDnsClient", "HttpDns baseUrl is null,maybe accountId is null");
            return new ArrayList<>();
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                int i11 = i10 + 1;
                if (i10 > 0) {
                    sb2.append(",");
                }
                sb2.append(str);
                i10 = i11;
            }
        }
        String str2 = this.f27814a + sb2.toString();
        Logger.m32143v("HttpDnsClient", "send the request to server:" + str2);
        String string = UUID.randomUUID().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metrics_data", new JSONObject().put("trace_id", string));
        } catch (JSONException e10) {
            Logger.m32146w("HttpDnsClient", "recordMap fail to put:", e10);
        }
        c6042p0.put("trace_id", string);
        c6042p0.put("request_domain", list.toString());
        c6042p0.put("network_type", NetworkUtil.getCurrentNetworkType());
        Request requestBuild = this.f27815b.newRequest().options(jSONObject.toString()).url(str2).build();
        ArrayList<C6003m0> arrayList = new ArrayList<>();
        Submit<ResponseBody> submitNewSubmit = this.f27815b.newSubmit(requestBuild);
        try {
            Response<ResponseBody> responseExecute = submitNewSubmit.execute();
            if (responseExecute.isOK()) {
                arrayList = m35046a(responseExecute);
                if (arrayList.isEmpty()) {
                    code = 10020001;
                    c6042p0.put("error_code", code);
                } else {
                    c6042p0.put("error_code", 10020000L);
                    Logger.m32143v("HttpDnsClient", arrayList);
                }
            } else if (responseExecute.getCode() == 503) {
                c6042p0.put("error_code", responseExecute.getCode());
                long jStringToLong = StringUtils.stringToLong(Headers.m33636of(responseExecute.getHeaders()).get(f27799f), 60L) * 1000;
                m35051a(new a(jStringToLong, Utils.getCurrentTime(true)));
                Logger.m32141i("HttpDnsClient", "retry-after:" + jStringToLong);
            } else {
                Logger.m32141i("HttpDnsClient", "httpDns request error code:" + responseExecute.getCode());
                code = (long) responseExecute.getCode();
                c6042p0.put("error_code", code);
            }
            RequestFinishedInfo requestFinishedInfo = submitNewSubmit.getRequestFinishedInfo();
            if (requestFinishedInfo != null) {
                c6042p0.put("dns_server_ips", Arrays.toString(requestFinishedInfo.getMetrics().getConnectIps().toArray()));
                c6042p0.put(C6042p0.f27652n, requestFinishedInfo.getMetricsTime().getTotalTime());
            }
            StringBuilder sb3 = new StringBuilder();
            Iterator<C6003m0> it = arrayList.iterator();
            while (it.hasNext()) {
                sb3.append(Arrays.toString(it.next().m34749d().toArray()));
            }
            c6042p0.put(C6042p0.f27650l, sb3.toString());
            return arrayList;
        } catch (IOException e11) {
            Logger.m32146w("HttpDnsClient", "IOException: ", e11);
            c6042p0.put("error_code", C6171z.m35899a((Exception) e11));
            return arrayList;
        }
    }

    /* renamed from: a */
    public void m35051a(a aVar) {
        this.f27816c = aVar;
    }
}
