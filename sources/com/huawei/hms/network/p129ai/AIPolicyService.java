package com.huawei.hms.network.p129ai;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.inner.DomainManager;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.api.RequestContext;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class AIPolicyService extends PolicyNetworkService {
    public static final String PRE_DNKEEPER_DOMAIN = "dnkeeper";
    public static final String TAG = "AIInterceptorService";
    public static boolean enableFlag = false;
    public boolean hasCreated = false;

    /* renamed from: com.huawei.hms.network.ai.AIPolicyService$a */
    public class RunnableC5783a implements Runnable {
        public RunnableC5783a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AIPolicyService.this.initModels();
        }
    }

    /* renamed from: com.huawei.hms.network.ai.AIPolicyService$b */
    public class RunnableC5784b implements Runnable {
        public RunnableC5784b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5792d.m33287c().m33294b();
            C5800h.m33340d().m33341a();
        }
    }

    private void destroyModel() {
        Logger.m32136d(TAG, "model destory");
        C5800h.m33340d().m33345b();
    }

    public static boolean isAiEnable() {
        return enableFlag;
    }

    public static boolean isExcludedDomain(String str) {
        if (!DomainManager.getInstance().isHaDomain(str)) {
            return TextUtils.isEmpty(str) || str.startsWith("dnkeeper");
        }
        Logger.m32143v(TAG, "ha request do not need ai train");
        return true;
    }

    public static boolean isOkHttpTask(RequestContext requestContext) {
        String channel = requestContext.getChannel();
        return channel != null && channel.equals("type_okhttp");
    }

    private void registModels() {
        if (DomainManager.getInstance().isHwPhoneAndInChina()) {
            C5792d.m33287c().m33292a(C5788b.f25731a, new C5795e0());
            C5792d.m33287c().m33292a(C5788b.f25732b, new C5814o());
            C5800h.m33340d().m33344a(C5788b.f25731a, new C5793d0());
            C5800h.m33340d().m33344a(C5788b.f25732b, new C5812n());
            C5800h.m33340d().m33344a(C5788b.f25733c, new C5791c0());
        }
        C5801h0.m33347b().m33350a();
        C5821u.m33525c().m33527b();
        C5789b0.m33249c().m33252b();
        C5790c.m33256f().m33267a();
    }

    public static void setEnableFlag(boolean z10) {
        enableFlag = z10;
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public void beginRequest(RequestContext requestContext) {
        if (isOkHttpTask(requestContext) && !isExcludedDomain(NetworkUtil.getHost(requestContext.request().getUrl()))) {
            C5800h.m33340d().m33342a(requestContext.request());
        }
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void clear() {
        C5794e.m33310a().m33312b(new RunnableC5784b());
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public int compareIp(InetAddress inetAddress, InetAddress inetAddress2) {
        return C5801h0.m33347b().m33348a(inetAddress, inetAddress2);
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public void endRequest(RequestContext requestContext) {
        if (isOkHttpTask(requestContext) && !isExcludedDomain(NetworkUtil.getHost(requestContext.request().getUrl()))) {
            C5800h.m33340d().m33343a(requestContext);
        }
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public int getAiConnectTimeout() {
        return C5821u.m33525c().m33526a();
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceName() {
        return "ai";
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService, com.huawei.hms.network.inner.api.NetworkService
    public String getServiceType() {
        return AIPolicyService.class.getName();
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public String getValue(String str, String str2) {
        return null;
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public Map<String, String> getValues(String str, String... strArr) {
        return null;
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getVersion() {
        return "8.0.1.309";
    }

    public void initModels() {
        Logger.m32136d(TAG, "check init");
        registModels();
        C5800h.m33340d().m33346c();
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public boolean initWebSocketPingModelPredictor() {
        return C5789b0.m33249c().m33251a();
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public List<List<InetAddress>> ipListsSort(List<List<InetAddress>> list) {
        return C5801h0.m33347b().m33349a(list);
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onCreate(Context context, Bundle bundle) {
        Logger.m32141i(TAG, "aiServcie onCreate");
        if (this.hasCreated) {
            return;
        }
        this.hasCreated = true;
        setEnableFlag(true);
        C5790c.m33253a(bundle);
        C5794e.m33310a().m33312b(new RunnableC5783a());
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onDestroy(Context context) {
        destroyModel();
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public Map<String, String> pingResult(int i10, Map<String, String> map) {
        Map<String, Integer> mapM33250a;
        String str;
        Logger.m32143v(TAG, "pingResult, type:" + i10 + ", networkData:" + map);
        HashMap map2 = null;
        try {
            mapM33250a = C5789b0.m33249c().m33250a(i10, map);
        } catch (Throwable th2) {
            Logger.m32143v(TAG, "pingResult error, please search thread_id in report data:" + Process.myTid());
            HianalyticsHelper.getInstance().reportException(th2, CrashHianalyticsData.EVENT_ID_CRASH);
            mapM33250a = null;
        }
        if (mapM33250a == null) {
            str = "pingResultMap is null";
        } else {
            map2 = new HashMap();
            for (Map.Entry<String, Integer> entry : mapM33250a.entrySet()) {
                map2.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
            str = "pingResult, back:" + map2;
        }
        Logger.m32143v(TAG, str);
        return map2;
    }
}
