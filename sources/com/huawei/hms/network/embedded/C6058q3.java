package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.hms.network.embedded.q3 */
/* loaded from: classes8.dex */
public class C6058q3 {

    /* renamed from: g */
    public static final String f27831g = "WebSocketEventListener";

    /* renamed from: h */
    public static final String f27832h = "trigger_type";

    /* renamed from: i */
    public static final String f27833i = "websocket_open_time";

    /* renamed from: a */
    public C5993l3 f27834a;

    /* renamed from: b */
    public C5939h1.d f27835b;

    /* renamed from: c */
    public C6148x2 f27836c = new C6148x2();

    /* renamed from: d */
    public LinkedList<Long> f27837d = new LinkedList<>();

    /* renamed from: e */
    public long f27838e;

    /* renamed from: f */
    public C6071r3 f27839f;

    /* renamed from: com.huawei.hms.network.embedded.q3$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Object f27840a;

        /* renamed from: b */
        public final /* synthetic */ String f27841b;

        public a(Object obj, String str) {
            this.f27840a = obj;
            this.f27841b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27840a instanceof Integer) {
                if (!HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
                    return;
                } else {
                    C6058q3.this.f27836c.put("error_code", ((Integer) this.f27840a).intValue());
                }
            }
            C6058q3.this.m35060a(this.f27841b);
            Exception exception = C6058q3.this.f27834a.getException();
            if (exception != null) {
                if (!HianalyticsHelper.getInstance().isEnableReportNoSeed(ContextHolder.getAppContext())) {
                    return;
                }
                C6058q3.this.f27836c.put("error_code", C5955i4.getErrorCodeFromException(exception)).put("exception_name", exception.getClass().getSimpleName()).put("message", StringUtils.anonymizeMessage(exception.getMessage())).put(C6148x2.INRATE, "" + (HianalyticsHelper.getInstance().inRate() ? 1 : 0));
            }
            HianalyticsHelper.getInstance().onEvent(C6058q3.this.f27836c.get(), C6148x2.WEBSOCKET_ID);
        }
    }

    public C6058q3(C5993l3 c5993l3, C5939h1.d dVar) {
        this.f27834a = c5993l3;
        this.f27835b = dVar;
        m35057a();
    }

    /* renamed from: a */
    private long m35054a(long j10, long j11) {
        if (j11 <= 0 || j10 <= 0) {
            return 0L;
        }
        return j10 - j11;
    }

    public <T> void reportData(T t10, String str) {
        HianalyticsHelper.getInstance().getReportExecutor().execute(new a(t10, str));
    }

    public void setOnOpenTime(long j10) {
        this.f27838e = j10;
    }

    public void setPingIntervalManager(C6071r3 c6071r3) {
        this.f27839f = c6071r3;
    }

    public void setPingPongDelayList(LinkedList<Long> linkedList) {
        this.f27837d.addAll(linkedList);
    }

    public void setRequestFinishedInfo(C5993l3 c5993l3) {
        this.f27834a = c5993l3;
    }

    /* renamed from: a */
    private String m35056a(C6109u2 c6109u2, RequestFinishedInfo requestFinishedInfo) {
        if (requestFinishedInfo.getNetworkSdkType() != "type_okhttp") {
            return null;
        }
        List<String> connectIps = c6109u2.getConnectIps();
        if (connectIps.isEmpty()) {
            Logger.m32136d(f27831g, "connect ip is empty");
            return null;
        }
        String successIp = c6109u2.getSuccessIp();
        if (TextUtils.isEmpty(successIp)) {
            Logger.m32136d(f27831g, "success ip is empty, all connect ip expire");
            return StringUtils.collection2String(connectIps);
        }
        LinkedList linkedList = new LinkedList();
        for (String str : connectIps) {
            if (successIp.equals(str)) {
                break;
            }
            linkedList.add(str);
        }
        return StringUtils.collection2String(linkedList);
    }

    /* renamed from: a */
    private void m35057a() {
        try {
            URL url = new URL(this.f27835b.getUrl());
            this.f27836c.put("domain", url.getHost());
            this.f27836c.put(C6148x2.API_ID, StringUtils.anonymizeMessage(url.getPath()));
        } catch (MalformedURLException unused) {
            Logger.m32145w(f27831g, "Create Url error");
            this.f27836c.put(C6148x2.API_ID, "unknown");
        }
        this.f27836c.put("sdk_version", "8.0.1.309");
        this.f27836c.put("network_type", NetworkUtil.getCurrentNetworkType());
        String string = this.f27835b.getNetConfig().getMap("core_metrics_data").get("trace_id");
        boolean zIsEmpty = TextUtils.isEmpty(string);
        C6148x2 c6148x2 = this.f27836c;
        if (zIsEmpty) {
            string = UUID.randomUUID().toString();
        }
        c6148x2.put("trace_id", string);
    }

    /* renamed from: a */
    private void m35059a(C6109u2 c6109u2) {
        C6148x2 c6148x2;
        String str;
        List<String> connectIps = c6109u2.getConnectIps();
        String string = connectIps.isEmpty() ? null : Arrays.toString(connectIps.toArray());
        String successIp = this.f27834a.getMetrics().getSuccessIp();
        if (!TextUtils.isEmpty(successIp)) {
            string = string + "/" + successIp;
            if (CheckParamUtils.isIpV6(successIp)) {
                this.f27836c.put(C6148x2.IP_TYPE, "AAAA");
            }
            if (CheckParamUtils.isIpV4(successIp)) {
                c6148x2 = this.f27836c;
                str = "A";
            }
            this.f27836c.put("server_ip", string);
        }
        c6148x2 = this.f27836c;
        str = "unknown";
        c6148x2.put(C6148x2.IP_TYPE, str);
        this.f27836c.put("server_ip", string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m35060a(String str) {
        C6109u2 metrics = this.f27834a.getMetrics();
        AbstractC6122v2 metricsRealTime = this.f27834a.getMetricsRealTime();
        m35059a(metrics);
        this.f27836c.put("trigger_type", str).put(f27833i, this.f27838e).put("domain", this.f27834a.getHost()).put("req_start_time", this.f27834a.getMetricsTime().getCallStartTime()).put("protocol_impl", this.f27834a.getNetworkSdkType()).put(C6148x2.CONNECT_OUT_IP, m35056a(metrics, this.f27834a)).put("ttfb", this.f27834a.getMetricsRealTime().getTtfb()).put(C6148x2.WEBSOCKET_CLIENT_PING_INTERVAL, this.f27834a.getPingInterval()).put(C6148x2.WEBSOCKET_PING_DELAY, this.f27837d.toString()).put(C6148x2.CONNECT_RETRY, metrics.getConnectRetryTime() < 0 ? 0L : metrics.getConnectRetryTime()).put(C6148x2.TLS_VERSION, metrics.getTlsVersion()).put(C6148x2.DNS_TYPE, metrics.getDnsType()).put(C6148x2.DNS_CACHE, metrics.getDnsCache()).put(C6148x2.DNS_TTL, metrics.getDnsTtl()).put(C6148x2.DNS_STATUS, metrics.getDnsStatus()).put(C6148x2.TLS_CIPHERSUITE, metrics.getCipherSuite()).put("dns_server_ips", NetworkUtil.getDnsServerIps(ContextHolder.getAppContext())).put("req_total_time", metricsRealTime.getRequestBodyEndTime() - metricsRealTime.getCallStartTime()).put("total_time", metricsRealTime.getTotalTime()).put("tcpconn_time", m35054a(metricsRealTime.getSecureConnectStartTime(), metricsRealTime.getConnectStartTime())).put("ssl_time", m35054a(metricsRealTime.getSecureConnectEndTime(), metricsRealTime.getSecureConnectStartTime())).put("connect_time", m35054a(metricsRealTime.getConnectEndTime(), metricsRealTime.getConnectStartTime())).put(C6148x2.REQ_START_TRANSFER, m35054a(metricsRealTime.getRequestHeadersStartTime(), metricsRealTime.getCallStartTime())).put(C6148x2.DNS_TIME, m35054a(metricsRealTime.getDnsEndTime(), metricsRealTime.getDnsStartTime())).put(this.f27839f.getReporterData());
    }
}
