package com.huawei.hms.network.embedded;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.inner.api.InterceptorNetworkService;
import com.huawei.hms.network.inner.api.NetDiagnosisNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.r3 */
/* loaded from: classes8.dex */
public class C6071r3 {

    /* renamed from: A */
    public static final String f28010A = "isSuccess";

    /* renamed from: B */
    public static final String f28011B = "isActive";

    /* renamed from: C */
    public static final String f28012C = "continuePing";
    public static final int COUNTRECEIVE_TYPE = 2;
    public static final int COUNTSEND_TYPE = 1;

    /* renamed from: D */
    public static final String f28013D = "delayPing";

    /* renamed from: E */
    public static final String f28014E = "delayTimes";

    /* renamed from: F */
    public static final String f28015F = "ai_ping_enable";

    /* renamed from: G */
    public static final String f28016G = "ai_ping_minthreshold";

    /* renamed from: H */
    public static final String f28017H = "ai_ping_nat";

    /* renamed from: I */
    public static final String f28018I = "enable_dynamic_ping";

    /* renamed from: J */
    public static final String f28019J = "pingInterval";
    public static final int PING_TYPE_HIGH_EFFIC = 1;
    public static final int PING_TYPE_LOWER_CONSUMPTION = 2;
    public static final int PING_TYPE_LOWER_CONSUMPTION_TIME = 120000;
    public static final String TAG = "WebSocketResetPingIntervalManager";

    /* renamed from: o */
    public static final String f28020o = "mnc";

    /* renamed from: p */
    public static final String f28021p = "domain";

    /* renamed from: q */
    public static final String f28022q = "businessPing";

    /* renamed from: r */
    public static final String f28023r = "ping";

    /* renamed from: s */
    public static final String f28024s = "pingStatus";

    /* renamed from: t */
    public static final String f28025t = "wifi_signal_strength";

    /* renamed from: u */
    public static final String f28026u = "mobile_signal_strength";

    /* renamed from: v */
    public static final String f28027v = "networkChange";

    /* renamed from: w */
    public static final String f28028w = "network_changed";

    /* renamed from: x */
    public static final String f28029x = "pingIntervalList";

    /* renamed from: y */
    public static final String f28030y = "networkType";

    /* renamed from: z */
    public static final String f28031z = "firstNetworkType";

    /* renamed from: a */
    public int f28032a;

    /* renamed from: b */
    public int f28033b;

    /* renamed from: c */
    public long f28034c;

    /* renamed from: d */
    public int f28035d;

    /* renamed from: e */
    public int f28036e;

    /* renamed from: f */
    public int f28037f;

    /* renamed from: g */
    public NetDiagnosisNetworkService f28038g;

    /* renamed from: h */
    public C5993l3 f28039h;

    /* renamed from: i */
    public long f28040i;

    /* renamed from: j */
    public Map<String, String> f28041j;

    /* renamed from: k */
    public NetworkService f28042k;

    /* renamed from: m */
    public boolean f28044m;

    /* renamed from: l */
    public int f28043l = -2;

    /* renamed from: n */
    public boolean f28045n = false;

    public C6071r3(int i10, int i11, String str) {
        this.f28037f = i10;
        this.f28036e = i11;
        this.f28035d = i11;
        NetworkService service = NetworkKitInnerImpl.getInstance().getService("ai");
        if (service != null) {
            this.f28042k = service;
            this.f28044m = StringUtils.stringToBoolean(String.valueOf(ConfigAPI.getValue("ai_ping_enable")), false);
        }
        InterceptorNetworkService interceptorNetworkService = NetworkKitInnerImpl.getInstance().getInterceptorNetworkService("netdiag");
        if (interceptorNetworkService != null) {
            NetDiagnosisNetworkService netDiagnosisNetworkService = (NetDiagnosisNetworkService) interceptorNetworkService;
            this.f28038g = netDiagnosisNetworkService;
            netDiagnosisNetworkService.requestThirdMetrics(str);
        }
        this.f28041j = m35193a();
        Logger.m32145w(TAG, "actionType：" + i10);
    }

    /* renamed from: a */
    private Map<String, String> m35193a() {
        HashMap map = new HashMap();
        map.put("ping", this.f28036e + "");
        map.put("pingStatus", "0");
        if (this.f28037f == 2) {
            map.put("delayTimes", "1");
            map.put("delayPing", "120000");
        }
        return map;
    }

    public boolean aiPingEnable() {
        return this.f28044m;
    }

    public void counting(int i10) {
        if (i10 == 1) {
            this.f28032a++;
        } else {
            this.f28033b++;
        }
        this.f28034c = System.currentTimeMillis();
    }

    public int getCount() {
        return this.f28032a + this.f28033b;
    }

    public boolean getNetworkDate(boolean z10, long j10, LinkedList<Long> linkedList) {
        NetDiagnosisNetworkService netDiagnosisNetworkService = this.f28038g;
        if (netDiagnosisNetworkService == null) {
            Logger.m32145w(TAG, "getNetworkDate not find NetDiagnosisNetworkService");
            return false;
        }
        Map<String, String> websocketNetworkData = netDiagnosisNetworkService.getWebsocketNetworkData(this.f28040i, SystemClock.elapsedRealtime());
        this.f28040i = SystemClock.elapsedRealtime();
        this.f28041j.put("businessPing", j10 + "");
        this.f28041j.put("pingIntervalList", linkedList.toString());
        this.f28041j.put("mnc", NetworkUtil.getMNC(ContextHolder.getAppContext()));
        int currentNetworkType = NetworkUtil.getCurrentNetworkType();
        this.f28041j.put("networkType", currentNetworkType + "");
        if (this.f28043l == -2) {
            this.f28043l = currentNetworkType;
        }
        this.f28041j.put("firstNetworkType", this.f28043l + "");
        this.f28041j.put("isActive", isWebSocketActive() + "");
        this.f28041j.put("isSuccess", z10 + "");
        this.f28041j.put("domain", this.f28039h.getHost());
        this.f28041j.put("wifi_signal_strength", websocketNetworkData.get("wifi_signal_strength"));
        this.f28041j.put("mobile_signal_strength", websocketNetworkData.get("mobile_signal_strength"));
        this.f28041j.put("networkChange", websocketNetworkData.get("network_changed"));
        Logger.m32136d(TAG, "NetworkDate " + websocketNetworkData.get("wifi_signal_strength") + " " + websocketNetworkData.get("mobile_signal_strength") + " " + websocketNetworkData.get("network_changed"));
        return true;
    }

    public LinkedHashMap<String, String> getReporterData() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        int iStringToInteger = StringUtils.stringToInteger(String.valueOf(ConfigAPI.getValue("ai_ping_minthreshold")), 0);
        int iStringToInteger2 = StringUtils.stringToInteger(String.valueOf(ConfigAPI.getValue("ai_ping_nat")), 0);
        linkedHashMap.put("ai_ping_enable", this.f28044m + "");
        linkedHashMap.put("ai_ping_minthreshold", iStringToInteger + "");
        linkedHashMap.put("ai_ping_nat", iStringToInteger2 + "");
        linkedHashMap.put(f28018I, this.f28037f + "");
        linkedHashMap.put(f28019J, this.f28035d + "");
        Map<String, String> map = this.f28041j;
        if (map != null) {
            if (map.containsKey("pingStatus")) {
                linkedHashMap.put("pingStatus", this.f28041j.get("pingStatus"));
            } else {
                linkedHashMap.put("pingStatus", "");
            }
        }
        return linkedHashMap;
    }

    public boolean isWebSocketActive() {
        return System.currentTimeMillis() - this.f28034c <= ((long) this.f28035d);
    }

    public Map<String, String> pingResult(int i10, Map<String, String> map) {
        if (this.f28042k == null) {
            Logger.m32145w(TAG, "pingResult not find AiService");
            return m35193a();
        }
        if (this.f28045n) {
            this.f28045n = false;
            this.f28041j.putAll(m35193a());
        }
        return this.f28042k.pingResult(i10, map);
    }

    public boolean predictorModel() {
        NetworkService networkService = this.f28042k;
        if (networkService != null) {
            return networkService.initWebSocketPingModelPredictor();
        }
        Logger.m32143v(TAG, "predictorModel not found AIPolicyService ai_ping_enable:" + this.f28044m);
        return false;
    }

    public boolean setActionType(int i10) {
        this.f28037f = i10;
        boolean zInitWebSocketPingModelPredictor = false;
        if (i10 != 1 && i10 != 2) {
            Logger.m32141i(TAG, "canot predictor model ,type is:" + i10);
            return false;
        }
        NetworkService networkService = this.f28042k;
        if (networkService != null) {
            zInitWebSocketPingModelPredictor = networkService.initWebSocketPingModelPredictor();
            if (zInitWebSocketPingModelPredictor) {
                this.f28045n = true;
            }
        } else {
            Logger.m32143v(TAG, "not found AIPolicyService ai_ping_enable:" + this.f28044m);
        }
        return zInitWebSocketPingModelPredictor;
    }

    public void setOnOpenTime(long j10) {
        this.f28040i = j10;
    }

    public int setPingResult(boolean z10, long j10, LinkedList<Long> linkedList) {
        int iStringToInteger;
        if (getNetworkDate(z10, j10, linkedList)) {
            Map<String, String> mapPingResult = pingResult(this.f28037f, this.f28041j);
            if (mapPingResult != null) {
                this.f28041j.clear();
                this.f28041j.putAll(mapPingResult);
                String str = this.f28041j.get("continuePing");
                String str2 = this.f28041j.get("delayPing");
                String str3 = this.f28041j.get("ping");
                if (str != null) {
                    iStringToInteger = StringUtils.stringToInteger(str, this.f28036e);
                } else {
                    iStringToInteger = this.f28036e;
                    if (str2 != null) {
                        iStringToInteger = StringUtils.stringToInteger(str2, iStringToInteger);
                    } else if (str3 != null) {
                        iStringToInteger = StringUtils.stringToInteger(str3, iStringToInteger);
                    }
                }
                this.f28035d = iStringToInteger;
                return iStringToInteger;
            }
            Logger.m32145w(TAG, "PingResult no data map, ping " + this.f28036e);
        }
        return this.f28036e;
    }

    public void setRequestFinishedInfo(C5993l3 c5993l3) {
        this.f28039h = c5993l3;
    }
}
