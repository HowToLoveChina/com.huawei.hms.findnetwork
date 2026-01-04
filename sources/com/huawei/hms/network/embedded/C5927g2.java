package com.huawei.hms.network.embedded;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hms.hquic.HQUICException;
import com.huawei.hms.hquic.HQUICManager;
import com.huawei.hms.hquic.HQUICProvider;
import com.huawei.hms.network.base.util.HttpUtils;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.chromium.net.CronetEngine;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.NetworkException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.g2 */
/* loaded from: classes8.dex */
public class C5927g2 {

    /* renamed from: H3 */
    public static final String f26799H3 = "h3";
    public static final String QUIC = "quic";

    /* renamed from: f */
    public static final String f26800f = "CronetNegotiateManager";

    /* renamed from: g */
    public static final String f26801g = "org.chromium.net.CronetEngine";

    /* renamed from: h */
    public static final String f26802h = "com.huawei.hms.hquic.HQUICManager";

    /* renamed from: i */
    public static final String f26803i = "hquic_load";

    /* renamed from: j */
    public static final int f26804j = 0;

    /* renamed from: k */
    public static final int f26805k = 1;

    /* renamed from: l */
    public static final int f26806l = 2;

    /* renamed from: m */
    public static final int f26807m = 3;

    /* renamed from: n */
    public static final int f26808n = 443;

    /* renamed from: o */
    public static final int f26809o = 10000910;

    /* renamed from: p */
    public static final int f26810p = 10000911;

    /* renamed from: q */
    public static volatile C5927g2 f26811q = null;

    /* renamed from: r */
    public static final int f26812r = 1;

    /* renamed from: s */
    public static final int f26813s = 0;

    /* renamed from: c */
    public volatile d f26816c;

    /* renamed from: a */
    public ConcurrentHashMap<String, C6005m2> f26814a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public int f26815b = 0;

    /* renamed from: d */
    public String f26817d = null;

    /* renamed from: e */
    public boolean f26818e = false;

    /* renamed from: com.huawei.hms.network.embedded.g2$a */
    public class a implements HQUICManager.HQUICInitCallback {

        /* renamed from: a */
        public HQUICProvider f26819a = new HQUICProvider(ContextHolder.getResourceContext());

        public a() {
        }

        /* renamed from: a */
        private void m34293a() {
            new ExperimentalCronetEngine.Builder(new C6173z1(ContextHolder.getResourceContext())).enableQuic(true).enableHttp2(true).enableNetworkQualityEstimator(true).build().shutdown();
        }

        @Override // com.huawei.hms.hquic.HQUICManager.HQUICInitCallback
        public void onFail(Exception exc) {
            StringBuilder sb2;
            String str;
            Logger.m32141i(C5927g2.f26800f, "Init Quic Fail");
            C5927g2.this.f26815b = 3;
            if (!(exc instanceof HQUICException)) {
                if (exc instanceof IllegalArgumentException) {
                    sb2 = new StringBuilder();
                    str = "invalid argument, reason:";
                }
                C5927g2.this.f26816c.setLoadError(exc);
                m34294a(C5927g2.f26810p);
                C5927g2 c5927g2 = C5927g2.this;
                c5927g2.m34289a(c5927g2.f26816c);
            }
            sb2 = new StringBuilder();
            str = "Init Hms Quic Loader failed, reason:";
            sb2.append(str);
            sb2.append(exc.getMessage());
            Logger.m32141i(C5927g2.f26800f, sb2.toString());
            C5927g2.this.f26816c.setLoadError(exc);
            m34294a(C5927g2.f26810p);
            C5927g2 c5927g22 = C5927g2.this;
            c5927g22.m34289a(c5927g22.f26816c);
        }

        @Override // com.huawei.hms.hquic.HQUICManager.HQUICInitCallback
        public void onSuccess() {
            Logger.m32141i(C5927g2.f26800f, "Init Quic Success");
            try {
                m34293a();
                C5927g2.this.f26815b = 2;
                m34294a(C5927g2.f26809o);
                C5927g2 c5927g2 = C5927g2.this;
                c5927g2.m34289a(c5927g2.f26816c);
            } catch (Throwable th2) {
                Logger.m32145w(C5927g2.f26800f, "load quic pro success but init engine fail: " + th2.getMessage());
                onFail(new Exception(th2));
            }
        }

        /* renamed from: a */
        private void m34294a(int i10) {
            C5927g2.this.f26816c.setLoadEndTime(Utils.getCurrentTime(false));
            if (a.class.getClassLoader() != null) {
                C5927g2.this.f26816c.setLoadSdkName(a.class.getClassLoader().getClass().getCanonicalName());
            } else {
                C5927g2.this.f26816c.setLoadSdkName(this.f26819a.getName());
            }
            C5927g2.this.f26816c.setErrorCode(i10);
            C5927g2.this.f26816c.setLoadSdkVersion(this.f26819a.getVersion());
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g2$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5927g2 c5927g2 = C5927g2.this;
            c5927g2.m34289a(c5927g2.f26816c);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g2$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ d f26822a;

        public c(d dVar) {
            this.f26822a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HianalyticsHelper.getInstance().onEvent(this.f26822a.finiInfo2HaMap(), C5927g2.f26803i);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.g2$d */
    public static final class d {

        /* renamed from: a */
        public LinkedHashMap<String, String> f26824a;

        /* renamed from: b */
        public long f26825b;

        /* renamed from: c */
        public long f26826c;

        /* renamed from: d */
        public Exception f26827d;

        /* renamed from: e */
        public int f26828e;

        /* renamed from: f */
        public String f26829f;

        /* renamed from: g */
        public String f26830g;

        public d() {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            this.f26824a = linkedHashMap;
            linkedHashMap.put(HianalyticsBaseData.SDK_NAME, "networkkit");
            this.f26824a.put("sdk_type", "UxPP");
            this.f26824a.put("sdk_version", "8.0.1.309");
        }

        public LinkedHashMap<String, String> finiInfo2HaMap() {
            this.f26824a.put("error_code", String.valueOf(this.f26828e));
            this.f26824a.put("total_time", String.valueOf(getLoadTime()));
            this.f26824a.put("req_start_time", String.valueOf(this.f26825b));
            this.f26824a.put("kit_provider", this.f26830g);
            this.f26824a.put("kit_version", this.f26829f);
            Exception exc = this.f26827d;
            if (exc != null) {
                this.f26824a.put("exception_name", exc.getClass().getSimpleName());
                this.f26824a.put("message", StringUtils.anonymizeMessage(this.f26827d.getMessage()));
            }
            return this.f26824a;
        }

        public long getLoadTime() {
            long j10 = this.f26826c - this.f26825b;
            if (j10 > 0) {
                return j10;
            }
            return 0L;
        }

        public void setErrorCode(int i10) {
            this.f26828e = i10;
        }

        public void setLoadEndTime(long j10) {
            this.f26826c = j10;
        }

        public void setLoadError(Exception exc) {
            this.f26827d = exc;
        }

        public void setLoadSdkName(String str) {
            this.f26830g = str;
        }

        public void setLoadSdkVersion(String str) {
            this.f26829f = str;
        }

        public void setLoadStartTime(long j10) {
            this.f26825b = j10;
        }
    }

    public static C5927g2 getInstance() {
        if (f26811q == null) {
            synchronized (C5927g2.class) {
                try {
                    if (f26811q == null) {
                        f26811q = new C5927g2();
                    }
                } finally {
                }
            }
        }
        return f26811q;
    }

    public void addQuicHint(String str, boolean z10) {
        m34292a(str, z10, false);
    }

    public String getAltSvcType() {
        return "huawei_module_quic_pro".equals(this.f26817d) ? f26799H3 : QUIC;
    }

    public ConcurrentHashMap<String, C6005m2> getQuicHints() {
        return this.f26814a;
    }

    public boolean isAvailable() {
        Logger.m32143v(f26800f, "initHmsQuicProviderState code is: " + this.f26815b);
        return this.f26815b == 2;
    }

    public Boolean isEnableQuic(String str, int i10) {
        Logger.m32144v(f26800f, "isEnableQuic is execute,and the map is: %s", this.f26814a.keySet().toString());
        C6005m2 c6005m2 = this.f26814a.get(str);
        if (c6005m2 == null || !c6005m2.getEnableQuic() || (i10 != -1 && i10 != c6005m2.getPort())) {
            return Boolean.FALSE;
        }
        Logger.m32143v(f26800f, "use cronet and request");
        return Boolean.TRUE;
    }

    public boolean isHquicProviderSupportSelectQuic() {
        return ReflectionUtils.checkCompatible(f26802h, "asyncInit", Context.class, String.class, HQUICManager.HQUICInitCallback.class);
    }

    public boolean isSupportCronet() {
        try {
            int i10 = CronetEngine.f55785a;
            return true;
        } catch (ClassNotFoundException e10) {
            Logger.m32147w(f26800f, "load network-quic CronetEngine class failed, exception:%s", e10.getClass().getSimpleName());
            return false;
        }
    }

    public boolean isSupportExtraBandwidthEvaluation() {
        return this.f26818e;
    }

    public void lazyInitHmsQuicLoader(boolean z10) {
        synchronized (this) {
            if (!z10) {
                try {
                    if (this.f26815b != 0) {
                        Logger.m32141i(f26800f, "run lazyInitHmsQuicLoader before");
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f26816c = new d();
            this.f26816c.setLoadStartTime(Utils.getCurrentTime(false));
            try {
                String str = HQUICManager.HQUIC_MODULE_NAME;
                this.f26815b = 1;
                m34288a();
            } catch (ClassNotFoundException e10) {
                Logger.m32147w(f26800f, "load com.huawei.hms.hquic.HQUICManagerclass failed, exception:%s", e10.getClass().getSimpleName());
                this.f26815b = 3;
                this.f26816c.setLoadEndTime(Utils.getCurrentTime(false));
                this.f26816c.setLoadError(e10);
                this.f26816c.setErrorCode(f26810p);
                HianalyticsHelper.getInstance().getReportExecutor().execute(new b());
            }
        }
    }

    public void loadQuicConf() throws JSONException {
        String strValueOf = String.valueOf(ConfigAPI.getValue(PolicyNetworkService.QuicConstants.QUICHINT));
        Logger.m32144v(f26800f, "quichint is %s", strValueOf);
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        m34291a(strValueOf);
    }

    public int mappingCronetErrorCode(Exception exc) {
        if (exc == null || !isAvailable() || !(exc instanceof NetworkException)) {
            return ExceptionCode.NETWORK_IO_EXCEPTION;
        }
        switch (((NetworkException) exc).getErrorCode()) {
        }
        return ExceptionCode.NETWORK_IO_EXCEPTION;
    }

    public void maybeExtraBandwidthEvaluation() {
        this.f26818e = true;
    }

    public void maybeRecordCongestionTypeInfo(String str, boolean z10) {
        if (this.f26818e && z10) {
            C5991l1.getInstance().recordCongestionTypeInfo(str);
            return;
        }
        Logger.m32143v(f26800f, "the CronetEngine can‘t use for bandwidth, and congestionType = " + str);
    }

    public void updateQuicHints(String str, int i10, boolean z10) {
        if (str != null && !z10) {
            this.f26814a.remove(str);
        }
        if (str == null) {
            Logger.m32143v(f26800f, "host == null");
            return;
        }
        C6005m2 c6005m2 = this.f26814a.get(str);
        if (c6005m2 == null || !(i10 == -1 || i10 == c6005m2.getPort())) {
            Logger.m32144v(f26800f, "server negotiate port is %d, but there is not compatible config or historical success record", Integer.valueOf(i10));
        } else {
            Logger.m32144v(f26800f, "the host:%s will use cronet next time", str);
            c6005m2.setEnableQuic(z10);
        }
        Logger.m32144v(f26800f, "updateQuicHints is execute,and the map is: %s", this.f26814a.keySet().toString());
    }

    public void addQuicHint(List<String> list, boolean z10) {
        if (list == null) {
            Logger.m32138e(f26800f, "invalid argument");
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            addQuicHint(it.next(), z10);
        }
    }

    /* renamed from: a */
    private void m34288a() {
        String strValueOf = String.valueOf(ConfigAPI.getValue(PolicyNetworkService.QuicConstants.MODULE_NAME));
        this.f26817d = strValueOf;
        Logger.m32142i(f26800f, "module name is %s", strValueOf);
        a aVar = new a();
        if (isHquicProviderSupportSelectQuic()) {
            HQUICManager.asyncInit(ContextHolder.getResourceContext(), this.f26817d, aVar);
        } else {
            Logger.m32141i(f26800f, "not support select quic");
            HQUICManager.asyncInit(ContextHolder.getResourceContext(), aVar);
        }
    }

    /* renamed from: a */
    public void m34289a(d dVar) {
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            InitReport.reportWhenInit(new c(dVar));
        } else {
            Logger.m32141i(f26800f, "HianalyticsHelper report disable");
        }
    }

    /* renamed from: a */
    private void m34291a(String str) throws JSONException {
        Logger.m32144v(f26800f, "the configInfo is %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("services");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                if (TextUtils.isEmpty(next) || TextUtils.isEmpty(string)) {
                    Logger.m32138e(f26800f, "config file has been broken.");
                } else {
                    int iStringToInteger = StringUtils.stringToInteger(string, -1);
                    if (iStringToInteger == 0) {
                        m34292a(next, false, true);
                    } else if (iStringToInteger == 1) {
                        m34292a(next, true, true);
                    }
                }
            }
            Logger.m32144v(f26800f, "loadConfigToCache is execute,and the map size is:%s---%s", Integer.valueOf(this.f26814a.size()), this.f26814a.keySet().toString());
        } catch (JSONException e10) {
            Logger.m32146w(f26800f, "parse JSON occur error.", e10);
        }
    }

    /* renamed from: a */
    private void m34292a(String str, boolean z10, boolean z11) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "invalid argument";
        } else {
            if (HttpUtils.isHttpUrl(str)) {
                str2 = str;
            } else {
                str2 = "https://" + str;
            }
            try {
                URL url = new URL(str2);
                C6005m2 c6005m2 = this.f26814a.get(url.getHost());
                int port = url.getPort() == -1 ? f26808n : url.getPort();
                if (c6005m2 == null || z11 || port != c6005m2.getPort()) {
                    c6005m2 = new C6005m2();
                    c6005m2.setHost(url.getHost());
                    c6005m2.setPort(port);
                    c6005m2.setAlternatePort(port);
                    c6005m2.setEnableQuic(z10);
                    Logger.m32145w(f26800f, "QuicHit:" + c6005m2);
                }
                this.f26814a.put(c6005m2.getHost(), c6005m2);
                return;
            } catch (MalformedURLException unused) {
                str3 = "add QuicHit failed，please check domian format:" + str;
            }
        }
        Logger.m32138e(f26800f, str3);
    }
}
