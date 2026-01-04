package com.huawei.hms.network.embedded;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.PackageManagerCompat;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.network.ComposedNetworkKit;
import com.huawei.hms.network.RemoteInitializer;
import com.huawei.hms.network.abtest.ABHelper;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.embedded.AbstractC6174z2;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.exception.NetworkTimeoutException;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.inner.api.InterceptorNetworkService;
import com.huawei.hms.network.inner.api.NetDiagnosisNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.t2 */
/* loaded from: classes8.dex */
public class C6096t2 extends AbstractC6174z2 {

    /* renamed from: V */
    public static final String f28324V = "DefaultRCEventListener";

    /* renamed from: W */
    public static boolean f28325W = false;

    /* renamed from: X */
    public static final int f28326X = 0;

    /* renamed from: Y */
    public static final int f28327Y = 1;

    /* renamed from: Z */
    public static final int f28328Z = 2;

    /* renamed from: a0 */
    public static final int f28329a0 = 1;

    /* renamed from: b0 */
    public static final int f28330b0 = 2;

    /* renamed from: c0 */
    public static final String f28331c0 = "X-HwPs-Redirects";

    /* renamed from: d0 */
    public static final char f28332d0 = ';';

    /* renamed from: A */
    public int f28333A;

    /* renamed from: B */
    public int f28334B;

    /* renamed from: C */
    public PolicyNetworkService f28335C;

    /* renamed from: D */
    public boolean f28336D;

    /* renamed from: E */
    public boolean f28337E;

    /* renamed from: F */
    public NetDiagnosisNetworkService f28338F;

    /* renamed from: G */
    public int f28339G;

    /* renamed from: H */
    public int f28340H;

    /* renamed from: I */
    public long f28341I;

    /* renamed from: J */
    public long f28342J;

    /* renamed from: K */
    public long f28343K;

    /* renamed from: L */
    public long f28344L;

    /* renamed from: M */
    public long f28345M;

    /* renamed from: N */
    public long f28346N;

    /* renamed from: O */
    public long f28347O;

    /* renamed from: P */
    public long f28348P;

    /* renamed from: Q */
    public long f28349Q;

    /* renamed from: R */
    public String f28350R;

    /* renamed from: S */
    public String f28351S;

    /* renamed from: T */
    public String f28352T;

    /* renamed from: U */
    public boolean f28353U;

    /* renamed from: a */
    public boolean f28354a;

    /* renamed from: b */
    public long f28355b;

    /* renamed from: c */
    public long f28356c;

    /* renamed from: d */
    public int f28357d;

    /* renamed from: e */
    public int f28358e;

    /* renamed from: f */
    public long f28359f;

    /* renamed from: g */
    public volatile int f28360g;

    /* renamed from: h */
    public long f28361h;

    /* renamed from: i */
    public long f28362i;

    /* renamed from: j */
    public long f28363j;

    /* renamed from: k */
    public long f28364k;

    /* renamed from: l */
    public long f28365l;

    /* renamed from: m */
    public int f28366m;

    /* renamed from: n */
    public String f28367n;

    /* renamed from: o */
    public String f28368o;

    /* renamed from: p */
    public int f28369p;

    /* renamed from: q */
    public int f28370q;

    /* renamed from: r */
    public int f28371r;

    /* renamed from: s */
    public String f28372s;

    /* renamed from: t */
    public Map<String, String> f28373t;

    /* renamed from: u */
    public List<InterfaceC5886d1> f28374u;

    /* renamed from: v */
    public List<IOException> f28375v;

    /* renamed from: w */
    public boolean f28376w;

    /* renamed from: x */
    public Exception f28377x;

    /* renamed from: y */
    public int f28378y;

    /* renamed from: z */
    public int f28379z;

    /* renamed from: com.huawei.hms.network.embedded.t2$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Object f28380a;

        public a(Object obj) {
            this.f28380a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6096t2.this.reportData(this.f28380a);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t2$b */
    public static class b implements AbstractC6174z2.c {

        /* renamed from: b */
        public static final AtomicLong f28382b = new AtomicLong(1);

        /* renamed from: a */
        public boolean f28383a;

        public b(boolean z10) {
            this.f28383a = z10;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6174z2.c
        public AbstractC6174z2 create(Submit submit) {
            return new C6096t2(f28382b.getAndIncrement(), this.f28383a, null);
        }
    }

    public C6096t2(long j10, boolean z10) {
        this.f28358e = 0;
        this.f28365l = 0L;
        this.f28368o = "default";
        this.f28374u = new ArrayList();
        this.f28375v = new ArrayList();
        this.f28376w = false;
        this.f28378y = 0;
        this.f28379z = 0;
        this.f28333A = 0;
        this.f28353U = false;
        this.f28335C = NetworkKitInnerImpl.getInstance().getPolicyNetworkService(NetworkService.Constants.CONFIG_SERVICE);
        this.f28355b = j10;
        this.f28354a = z10;
        this.f28337E = StringUtils.stringToBoolean(String.valueOf(ConfigAPI.getValue(C5976k.i.f27227a)), false);
    }

    /* renamed from: a */
    private long m35384a(long j10, long j11) {
        if (j11 == 0 || j10 == 0) {
            return 0L;
        }
        return j10 - j11;
    }

    /* renamed from: b */
    private String m35399b() {
        JSONObject jSONObject;
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        boolean z10 = C6007m4.m34758c().m34763b("ai") != null;
        linkedHashMapPack.put("ai", z10);
        if (z10) {
            boolean zStringToBoolean = StringUtils.stringToBoolean(String.valueOf(ConfigAPI.getValue(NetworkService.Constants.AI_IPSORT_SWITCH)), false);
            if (zStringToBoolean) {
                linkedHashMapPack.put(NetworkService.Constants.AI_IPSORT_SWITCH, zStringToBoolean);
            }
            boolean zStringToBoolean2 = StringUtils.stringToBoolean(String.valueOf(ConfigAPI.getValue(NetworkService.Constants.AI_CONNECTTIMEOUT_SWITCH)), false);
            if (zStringToBoolean2) {
                linkedHashMapPack.put(NetworkService.Constants.AI_CONNECTTIMEOUT_SWITCH, zStringToBoolean2);
            }
            boolean zStringToBoolean3 = StringUtils.stringToBoolean(String.valueOf(ConfigAPI.getValue("ai_ping_enable")), false);
            if (zStringToBoolean3) {
                linkedHashMapPack.put("ai_ping_enable", zStringToBoolean3);
            }
            jSONObject = new JSONObject(linkedHashMapPack.getAll());
        } else {
            jSONObject = new JSONObject(linkedHashMapPack.getAll());
        }
        return jSONObject.toString();
    }

    /* renamed from: c */
    private long m35403c() {
        long j10;
        if (this.f28374u.size() == 0) {
            return 0L;
        }
        InterfaceC5886d1 interfaceC5886d1 = this.f28374u.get(r0.size() - 1);
        if (interfaceC5886d1 != null && interfaceC5886d1.getRequestFinishedInfo() != null) {
            AbstractC6122v2 abstractC6122v2 = (AbstractC6122v2) interfaceC5886d1.getRequestFinishedInfo().getMetricsRealTime();
            if (abstractC6122v2.getCallStartTime() == 0) {
                return 0L;
            }
            if (interfaceC5886d1 instanceof C5967j3) {
                j10 = this.f28364k;
            } else if (interfaceC5886d1 instanceof C5966j2) {
                j10 = this.f28363j;
            }
            return j10 - abstractC6122v2.getCallStartTime();
        }
        return 0L;
    }

    /* renamed from: d */
    private void m35405d() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(ContextHolder.getResourceContext(), RemoteInitializer.C5782b.f25653i);
        try {
            if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
                try {
                    try {
                        all = pLSharedPreferences.getAll();
                    } catch (Exception e10) {
                        e = e10;
                        Logger.m32145w(f28324V, "the dynamic data has error! exception = " + e.getClass().getSimpleName());
                        HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
                    }
                } catch (ClassCastException e11) {
                    e = e11;
                    Logger.m32145w(f28324V, "the map cast has error!");
                    HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
                }
                if (all.isEmpty()) {
                    Logger.m32143v(f28324V, "the dynamic init data is empty!");
                    return;
                }
                C6161y2 c6161y2 = new C6161y2();
                c6161y2.put("kit_version", (String) all.get("kit_version"));
                c6161y2.put("error_code", (String) all.get("error_code"));
                c6161y2.put("total_time", (String) all.get("total_time"));
                c6161y2.put("message", (String) all.get("message"));
                c6161y2.put("exception_name", (String) all.get("exception_name"));
                c6161y2.put("req_start_time", (String) all.get("req_start_time"));
                c6161y2.put(C6161y2.SPILT_MODULES_MSG, (String) all.get(C6161y2.SPILT_MODULES_MSG));
                ClassLoader classLoader = getClass().getClassLoader();
                c6161y2.put("kit_provider", classLoader == null ? null : classLoader.getClass().getCanonicalName());
                HianalyticsHelper.getInstance().onEvent(c6161y2.get(), "network_load");
            }
        } finally {
            pLSharedPreferences.clear();
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void acquireClient(C5844a1 c5844a1) {
        String value = c5844a1.getPolicyExecutor().getValue("", PolicyNetworkService.ClientConstants.TRAFFIC_CLASS);
        if (TextUtils.isEmpty(value)) {
            return;
        }
        this.f28334B = StringUtils.stringToInteger(value, -1);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void acquireRequestEnd(C5939h1.d dVar) {
        this.f28367n = dVar.getUrl();
        m35396a("acquireRequestEnd");
        this.f28373t = dVar.getNetConfig().getMap("core_metrics_data");
        this.f28379z = dVar.getNetConfig().enableConnectEmptyBody() ? 1 : 0;
        this.f28333A = dVar.getNetConfig().getMetricPolicy();
        this.f28336D = dVar.getNetConfig().enableInnerConnectEmptyBody();
        this.f28369p = dVar.getNetConfig().getInt("core_connect_timeout");
        this.f28370q = dVar.getNetConfig().getInt("core_read_timeout");
        this.f28371r = dVar.getNetConfig().getInt("core_write_timeout");
        String string = dVar.getNetConfig().getString(PolicyNetworkService.ProfileConstants.SCENE_TYPE);
        if (!TextUtils.isEmpty(string)) {
            Logger.m32143v(f28324V, "type: " + string);
            this.f28368o = string;
        }
        Logger.m32143v(f28324V, "sceneType: " + this.f28368o);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void acquireRequestStart() {
        m35396a("acquireRequestStart");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void callEnd(Response response) {
        this.f28353U = true;
        this.f28364k = SystemClock.elapsedRealtime();
        this.f28363j = System.currentTimeMillis();
        m35392a(2);
        this.f28361h = SystemClock.elapsedRealtime() - this.f28362i;
        this.f28366m = response.getCode();
        m35400b(response);
        m35404c(Integer.valueOf(response.getCode()));
        m35396a("callEnd");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void callFailed(Exception exc) {
        this.f28364k = SystemClock.elapsedRealtime();
        this.f28363j = System.currentTimeMillis();
        m35392a(3);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f28362i;
        this.f28361h = jElapsedRealtime;
        this.f28359f = jElapsedRealtime;
        if (this.f28376w) {
            this.f28366m = (C5939h1.apiAvailable(4) && (exc instanceof NetworkTimeoutException)) ? ExceptionCode.NETWORK_TIMEOUT : ExceptionCode.CANCEL;
            m35404c(Integer.valueOf(this.f28366m));
        } else {
            m35404c(exc);
            this.f28377x = exc;
        }
        m35396a("callFailed");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void callFinishAtNetLib(int i10) {
        Logger.m32143v(f28324V, "call finish at net lib, try to report data to AIOps");
        setReadStatus(i10);
        m35391a();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void callStart() {
        this.f28356c = System.currentTimeMillis();
        this.f28362i = SystemClock.elapsedRealtime();
        this.f28357d = NetworkUtil.getCurrentNetworkType();
        m35396a("callStart");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cancel() {
        this.f28376w = true;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void convertGrsEnd(String str) {
        this.f28367n = str;
        m35396a("convertGrsEnd");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void convertGrsStart(String str) {
        m35396a("convertGrsStart");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpApplicationInterceptorReqEnd() {
        this.f28341I = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpApplicationInterceptorResEnd() {
        this.f28345M = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpApplicationInterceptorResStart() {
        this.f28344L = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpNetworkInterceptorReqEnd() {
        this.f28343K = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpNetworkInterceptorReqStart() {
        this.f28342J = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpNetworkInterceptorResEnd() {
        this.f28347O = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void cpNetworkInterceptorResStart() {
        this.f28346N = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void rcNetworkInterceptorReqEnd(C5939h1.d dVar) {
        if (TextUtils.isEmpty(this.f28367n) || this.f28367n.startsWith("grs://")) {
            this.f28367n = dVar.getUrl();
            Logger.m32143v(f28324V, "cpApplicationInterceptorReqEnd requestUrl:" + this.f28367n);
        }
        this.f28348P = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void rcNetworkInterceptorResStart() {
        this.f28349Q = SystemClock.elapsedRealtime();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void recordCpApplicationInterceptorNums(int i10) {
        this.f28339G = i10;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void recordCpNetworkInterceptorNums(int i10) {
        this.f28340H = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void reportData(T t10) {
        String string;
        if (f28325W) {
            Logger.m32143v(f28324V, "the networkKit dynamic data no need for reporting this time!");
        } else {
            Logger.m32143v(f28324V, "the networkKit dynamic data is reporting this time!");
            f28325W = true;
            m35405d();
        }
        if (this.f28336D) {
            return;
        }
        Logger.m32136d(f28324V, "metric policy:" + this.f28333A);
        int i10 = this.f28333A;
        if (i10 == 1) {
            return;
        }
        if (i10 != 2 || (t10 instanceof Exception) || ((t10 instanceof Integer) && m35397a((Integer) t10))) {
            Context appContext = ContextHolder.getAppContext();
            C6148x2 c6148x2 = new C6148x2();
            if (m35398a((C6096t2) t10, c6148x2, appContext)) {
                this.f28358e--;
                c6148x2.put("sdk_version", "8.0.1.309").put(C6148x2.REQ_START, this.f28356c).put(C6148x2.CALL_START_NETWORK_TYPE, this.f28357d).put("network_type", NetworkUtil.getCurrentNetworkType()).put("total_time", this.f28361h).put(C6148x2.REQUEST_RETRY, Math.max(this.f28358e, 0)).putIfNotDefault(C6148x2.REQUEST_TYPE, this.f28379z, 0L).put(C6148x2.WAITINGTIME, this.f28365l);
                c6148x2.put(C6148x2.ALL_TIME, this.f28359f).put(C6148x2.READ_STATUS, this.f28360g);
                if (this.f28335C != null) {
                    String strValueOf = String.valueOf(ConfigAPI.getValue("core_configversion"));
                    c6148x2.put("config_version", strValueOf);
                    c6148x2.put(C6148x2.PROFILE_TYPE, Character.toUpperCase(this.f28368o.charAt(0)) + "_" + strValueOf);
                }
                int i11 = this.f28334B;
                if (i11 > 0) {
                    c6148x2.put(C6148x2.TRAFFIC_CLASS, i11);
                }
                if (this.f28373t != null) {
                    for (String str : C6148x2.RECORD_LIST) {
                        if (this.f28373t.containsKey(str)) {
                            c6148x2.put(str, this.f28373t.get(str));
                        }
                    }
                    string = this.f28373t.get("trace_id");
                } else {
                    string = "";
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    c6148x2.put("trace_id", string);
                }
                InterceptorNetworkService interceptorNetworkService = NetworkKitInnerImpl.getInstance().getInterceptorNetworkService("netdiag");
                if (interceptorNetworkService != null) {
                    NetDiagnosisNetworkService netDiagnosisNetworkService = (NetDiagnosisNetworkService) interceptorNetworkService;
                    this.f28338F = netDiagnosisNetworkService;
                    netDiagnosisNetworkService.requestThirdMetrics(string);
                }
                String option = ComposedNetworkKit.getInstance().getOption("", "core_wlacid");
                if (!TextUtils.isEmpty(option)) {
                    c6148x2.put(C6148x2.WLACID, option);
                }
                if (t10 instanceof Integer) {
                    c6148x2.put("error_code", ((Integer) t10).intValue());
                }
                if (!TextUtils.isEmpty(this.f28372s)) {
                    c6148x2.put(C6148x2.REDIRECT_INFO, this.f28372s);
                }
                c6148x2.put(C6148x2.CONNECT_TIMEOUT, this.f28369p);
                c6148x2.put("read_timeout", this.f28370q);
                c6148x2.put(C6148x2.WRITE_TIMEMEOUT, this.f28371r);
                c6148x2.put(C6148x2.AI_TYPE, m35399b());
                String strValueOf2 = String.valueOf(ConfigAPI.getValue(PolicyNetworkService.GlobalConstants.DNS_RESULT_TTL));
                if (!TextUtils.isEmpty(strValueOf2)) {
                    c6148x2.put(C6148x2.DNS_RESULT_TTL, strValueOf2);
                }
                String scene = C6110u3.getInstance().getScene();
                if (!TextUtils.isEmpty(scene)) {
                    c6148x2.put(C6148x2.SCENE_SITE, scene);
                }
                try {
                    URL url = new URL(this.f28367n);
                    c6148x2.put(C6148x2.ORIGIN_DOMAIN, url.getHost());
                    c6148x2.put(C6148x2.API_ID, this.f28354a ? url.getPath() : StringUtils.anonymizeMessage(url.getPath()));
                } catch (MalformedURLException unused) {
                    Logger.m32145w(f28324V, "the url is error,and can't known the host and path!");
                    c6148x2.put(C6148x2.ORIGIN_DOMAIN, "unknown");
                    c6148x2.put(C6148x2.API_ID, "unknown");
                }
                m35395a(c6148x2);
                if (this.f28338F != null) {
                    c6148x2.put(C6148x2.NETDIAG_INFO, m35388a((C6096t2) t10));
                } else {
                    Logger.m32145w(f28324V, "netdaigService is null, and skip it");
                }
                if (this.f28374u.size() > 0 && (this.f28374u.get(0) instanceof C5966j2)) {
                    Logger.m32143v(f28324V, "collect quic stats");
                    C6018n2.collectQuicStats(c6148x2, (C5966j2) this.f28374u.get(0));
                }
                Logger.m32143v(f28324V, c6148x2);
                HianalyticsHelper.getInstance().onEvent(c6148x2.get());
                m35401b((C6096t2) t10);
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void responseBodyEnd() {
        m35396a("responseBodyEnd");
        setReadStatus(1);
        m35391a();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void responseFailed() {
        m35396a("responseFailed");
        if (this.f28353U) {
            setReadStatus(2);
        }
        m35391a();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void retryInterceptorEnd(Response response, C5844a1 c5844a1) {
        m35396a("retryInterceptorEnd");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void retryInterceptorFailed(IOException iOException) {
        this.f28375v.add(iOException);
        m35396a("retryInterceptorFailed");
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void retryInterceptorStart(Request request, InterfaceC5886d1 interfaceC5886d1, long j10) {
        this.f28358e++;
        this.f28365l += j10;
        this.f28374u.add(interfaceC5886d1);
        m35396a("retryInterceptorStart");
        interfaceC5886d1.setRcEventListener(this);
    }

    public void setReadStatus(int i10) {
        this.f28360g = i10;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void traceResponseNetworkKitInEvent(String str, String str2) {
        this.f28350R = str;
        this.f28352T = str2;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6174z2
    public void traceResponseNetworkKitOutEvent(String str) {
        this.f28351S = str;
    }

    public /* synthetic */ C6096t2(long j10, boolean z10, a aVar) {
        this(j10, z10);
    }

    /* renamed from: a */
    private String m35385a(C5939h1.d dVar) {
        String str = Headers.m33636of(dVar.getHeaders()).get(C5929g4.f26846h);
        if (TextUtils.isEmpty(str)) {
            Logger.m32143v(f28324V, "there is no net-msg-id in request");
            return "";
        }
        Logger.m32143v(f28324V, "net msg id in request: " + str);
        return str;
    }

    /* renamed from: b */
    private void m35400b(Response response) {
        List<String> list;
        if (response == null || response.getHeaders() == null || (list = response.getHeaders().get(f28331c0)) == null || list.isEmpty()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        this.f28372s = stringBuffer.toString();
    }

    /* renamed from: c */
    private synchronized <T> void m35404c(T t10) {
        boolean zM35402b;
        if (!InitReport.isHasConnectNet()) {
            Logger.m32141i(f28324V, "unable to report before first connect");
            return;
        }
        if (this.f28374u.size() > 0) {
            List<InterfaceC5886d1> list = this.f28374u;
            zM35402b = m35402b(list.get(list.size() - 1));
        } else {
            zM35402b = true;
        }
        Logger.m32144v(f28324V, "reportImmediate:%s", Boolean.valueOf(zM35402b));
        if (zM35402b) {
            try {
                HianalyticsHelper.getInstance().getReportExecutor().submit(new a(t10));
            } catch (RejectedExecutionException unused) {
                Logger.m32145w(f28324V, "executor rejected at report");
            }
        }
    }

    /* renamed from: a */
    private String m35386a(C6109u2 c6109u2, RequestFinishedInfo requestFinishedInfo) {
        if (requestFinishedInfo.getNetworkSdkType() != "type_okhttp") {
            return null;
        }
        List<String> connectIps = c6109u2.getConnectIps();
        if (connectIps.isEmpty()) {
            Logger.m32136d(f28324V, "connect ip is empty");
            return null;
        }
        String successIp = c6109u2.getSuccessIp();
        if (TextUtils.isEmpty(successIp)) {
            Logger.m32136d(f28324V, "success ip is empty, all connect ip expire");
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

    /* renamed from: b */
    private <T> void m35401b(T t10) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        linkedHashMapPack.put("package", ContextHolder.getAppContext().getPackageName()).put("version", "8.0.1.309").put("service", "networkkit").put("apiName", HianalyticsBaseData.EVENT_ID).put("result", t10 instanceof Integer ? 0L : -1L).put(WiseOpenHianalyticsData.UNION_COSTTIME, this.f28361h).put(WiseOpenHianalyticsData.UNION_APP_VERSION, PackageManagerCompat.getAppVersion(ContextHolder.getAppContext())).put("callTime", this.f28356c);
        HianalyticsHelper.getInstance().onEvent(linkedHashMapPack.getAll(), "60000", 0);
    }

    /* renamed from: a */
    private String m35387a(Response response) {
        String str = Headers.m33636of(response.getHeaders()).get("dl-from");
        for (String str2 : C6148x2.DL_WHITESPACE) {
            if (str2.equalsIgnoreCase(str)) {
                return str2;
            }
        }
        return "";
    }

    /* renamed from: b */
    private <T> boolean m35402b(InterfaceC5886d1 interfaceC5886d1) {
        if (!(interfaceC5886d1 instanceof C5966j2) && !(interfaceC5886d1 instanceof C5967j3)) {
            return true;
        }
        Logger.m32144v(f28324V, "listenerFinishState:%d", Integer.valueOf(this.f28378y));
        return (this.f28378y & 3) == 3;
    }

    /* renamed from: a */
    private <T> String m35388a(T t10) {
        String str;
        HashMap map = new HashMap();
        try {
            map.putAll(this.f28338F.getSyncNetDiagnosisInfo(this.f28362i, this.f28364k, t10 instanceof Exception, this.f28337E));
            return new JSONObject(map).toString();
        } catch (NullPointerException e10) {
            e = e10;
            str = "key == null";
            Logger.m32145w(f28324V, str);
            HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
            return "";
        } catch (Throwable th2) {
            e = th2;
            str = "netdiag has error!";
            Logger.m32145w(f28324V, str);
            HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
            return "";
        }
    }

    /* renamed from: a */
    private String m35389a(String str, int i10) {
        String str2;
        if (i10 != 0) {
            str2 = i10 != 1 ? i10 != 2 ? "" : this.f28352T : this.f28351S;
        } else {
            str2 = this.f28350R;
        }
        Logger.m32143v(f28324V, "networkHeaderData:" + str);
        Logger.m32143v(f28324V, "extralInfo:" + str2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.indexOf(59) == str.length() - 1) {
            return str + str2;
        }
        return str + ';' + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00bf  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.LinkedHashMap<java.lang.String, java.lang.String> m35390a(com.huawei.hms.network.embedded.InterfaceC5886d1 r10) throws java.net.UnknownHostException {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6096t2.m35390a(com.huawei.hms.network.embedded.d1):java.util.LinkedHashMap");
    }

    /* renamed from: a */
    private void m35391a() {
        this.f28359f = SystemClock.elapsedRealtime() - this.f28362i;
        m35392a(1);
        Object objValueOf = this.f28377x;
        if (objValueOf == null) {
            objValueOf = Integer.valueOf(this.f28366m);
        }
        m35404c(objValueOf);
    }

    /* renamed from: a */
    private synchronized void m35392a(int i10) {
        this.f28378y = i10 | this.f28378y;
    }

    /* renamed from: a */
    private void m35393a(LinkedHashMapPack linkedHashMapPack) {
        linkedHashMapPack.put(C6148x2.CP_INTERCEPTOR_NUM, this.f28339G + this.f28340H);
        long jM35384a = this.f28339G == 0 ? 0L : m35384a(this.f28341I, this.f28362i);
        long jM35384a2 = this.f28339G == 0 ? 0L : m35384a(this.f28345M, this.f28344L);
        long jM35384a3 = this.f28340H == 0 ? 0L : m35384a(this.f28343K, this.f28342J);
        long jM35384a4 = this.f28340H != 0 ? m35384a(this.f28347O, this.f28346N) : 0L;
        linkedHashMapPack.put(C6148x2.CP_INTERCEPTOR_COST, jM35384a + jM35384a2 + jM35384a3 + jM35384a4);
        Logger.m32143v(f28324V, "cpApplicationInterceptorNum:" + this.f28339G + " cpAppInterceptorReqCost:" + jM35384a + "  cpAppInterceptorResCost:" + jM35384a2);
        Logger.m32143v(f28324V, "cpNetworkInterceptorNum:" + this.f28340H + " cpNetInterceptorReqCost:" + jM35384a3 + "  cpNetInterceptorResCost:" + jM35384a4);
        long jM35384a5 = m35384a(this.f28348P, this.f28343K);
        long jM35384a6 = m35384a(this.f28346N, this.f28349Q);
        long jM35384a7 = m35384a(this.f28342J, this.f28341I);
        long jM35384a8 = m35384a(this.f28344L, this.f28347O);
        linkedHashMapPack.put(C6148x2.RC_INTERCEPTOR_COST, jM35384a5 + jM35384a6 + jM35384a7 + jM35384a8);
        Logger.m32143v(f28324V, "rcApplicationInterceptorReqCost:" + jM35384a7 + "  rcApplicationInterceptorResCost:" + jM35384a8 + " rcNetworkInterceptorReqCost:" + jM35384a5 + "  rcNetworkInterceptorResCost:" + jM35384a6);
        linkedHashMapPack.put(C6148x2.PROTOCOL_COST, m35384a(this.f28349Q, this.f28348P));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("protocolCost:");
        sb2.append(m35384a(this.f28349Q, this.f28348P));
        Logger.m32143v(f28324V, sb2.toString());
    }

    /* renamed from: a */
    private void m35394a(LinkedHashMapPack linkedHashMapPack, RequestFinishedInfo requestFinishedInfo, C5939h1.d dVar) {
        if (requestFinishedInfo.getResponse() == null) {
            Logger.m32143v(f28324V, "reponse is null, try to get net msg id from request");
            String strM35385a = m35385a(dVar);
            if (TextUtils.isEmpty(strM35385a)) {
                return;
            }
            linkedHashMapPack.put(C6148x2.NETWORK_MSG_ID, strM35385a);
            return;
        }
        Headers headersM33636of = Headers.m33636of(requestFinishedInfo.getResponse().getHeaders());
        String strM35389a = m35389a(headersM33636of.get(C5929g4.f26845g), 2);
        if (!TextUtils.isEmpty(strM35389a)) {
            linkedHashMapPack.put(C6148x2.NETWORK_VENDOR, strM35389a);
        }
        String strM35389a2 = m35389a(headersM33636of.get(C5929g4.f26843e), 0);
        if (!TextUtils.isEmpty(strM35389a2)) {
            linkedHashMapPack.put(C6148x2.NETWORK_IN, strM35389a2);
        }
        String strM35389a3 = m35389a(headersM33636of.get(C5929g4.f26844f), 1);
        if (!TextUtils.isEmpty(strM35389a3)) {
            linkedHashMapPack.put(C6148x2.NETWORK_OUT, strM35389a3);
        }
        String str = headersM33636of.get(C5929g4.f26846h);
        if (TextUtils.isEmpty(str)) {
            String strM35385a2 = m35385a(dVar);
            if (TextUtils.isEmpty(strM35385a2)) {
                Logger.m32143v(f28324V, "there is no net-msg-id in request and reponse");
            } else {
                Logger.m32143v(f28324V, "report net msg id from request");
                linkedHashMapPack.put(C6148x2.NETWORK_MSG_ID, strM35385a2);
            }
        } else {
            Logger.m32143v(f28324V, "report net msg id from reponse");
            linkedHashMapPack.put(C6148x2.NETWORK_MSG_ID, str);
        }
        String str2 = headersM33636of.get("x-nuwa-sample-state");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        linkedHashMapPack.put(C6148x2.X_NUWA_SAMPLE_STATE, str2);
    }

    /* renamed from: a */
    private void m35395a(C6148x2 c6148x2) {
        c6148x2.put(C6148x2.NETWORK_TIME, m35403c());
        int size = this.f28374u.size();
        if (size > 0) {
            int i10 = size - 1;
            c6148x2.put(m35390a(this.f28374u.get(i10)));
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < i10; i11++) {
                jSONArray.put(new JSONObject(m35390a(this.f28374u.get(i11))));
            }
            if (jSONArray.length() > 0) {
                c6148x2.put(C6148x2.FAILED_INFO, jSONArray.toString());
            }
        }
    }

    /* renamed from: a */
    private void m35396a(String str) {
        Logger.m32144v(f28324V, "callId = %d / %s : ElapsedTime = %d", Long.valueOf(this.f28355b), str, Long.valueOf(System.currentTimeMillis() - this.f28356c));
    }

    /* renamed from: a */
    private boolean m35397a(Integer num) {
        return num.intValue() == 10000101;
    }

    /* renamed from: a */
    private <T> boolean m35398a(T t10, C6148x2 c6148x2, Context context) {
        if (ReflectionUtils.isAbTestEnable() && ABHelper.getInstance().isInAllowList(String.valueOf(ConfigAPI.getValue(PolicyNetworkService.GlobalConstants.AB_ALLOWED_LIST)))) {
            String reportAbInfo = ABHelper.getInstance().getReportAbInfo();
            if (!TextUtils.isEmpty(reportAbInfo)) {
                c6148x2.put(C6148x2.INRATE, "" + (HianalyticsHelper.getInstance().inRate() ? 1 : 0));
                c6148x2.put(C6148x2.AB_INFO, reportAbInfo);
                return true;
            }
        }
        if ((t10 instanceof Exception) && HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            c6148x2.put(C6148x2.INRATE, "" + (HianalyticsHelper.getInstance().inRate() ? 1 : 0));
            return true;
        }
        if (this.f28374u.size() > 0) {
            List<InterfaceC5886d1> list = this.f28374u;
            RequestFinishedInfo requestFinishedInfo = list.get(list.size() - 1).getRequestFinishedInfo();
            if (requestFinishedInfo != null && requestFinishedInfo.getNetworkSdkType().equals("type_cronet")) {
                if (!HianalyticsHelper.getInstance().isQuicEnableReport(context)) {
                    return false;
                }
                c6148x2.put(C6148x2.INRATE, "" + (HianalyticsHelper.getInstance().inRate() ? 1 : 0));
                return true;
            }
        }
        return HianalyticsHelper.getInstance().isEnableReport(context);
    }
}
