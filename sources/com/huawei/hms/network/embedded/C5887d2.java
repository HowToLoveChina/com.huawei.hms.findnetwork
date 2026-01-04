package com.huawei.hms.network.embedded;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.httpclient.excutor.PolicyExecutor;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.impl.ImplVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.d2 */
/* loaded from: classes8.dex */
public class C5887d2 {
    public static final String CONGESTION_CONTROL_PCC_MULTIPATH = "pcc_multipath";

    /* renamed from: c */
    public static final String f26607c = "CronetEngineManager";

    /* renamed from: d */
    public static final String f26608d = "CronetListener";

    /* renamed from: e */
    public static final String f26609e = "core_textTransmission";

    /* renamed from: f */
    public static final String f26610f = "core_smallPkt-fec";

    /* renamed from: g */
    public static final String f26611g = "SCC";

    /* renamed from: h */
    public static final String f26612h = "HW01,AKDU";

    /* renamed from: i */
    public static final String f26613i = "RACK,ARC3";

    /* renamed from: j */
    public static final String f26614j = "HW02,PCCH,IFWd";

    /* renamed from: k */
    public static final String f26615k = "PRIO";

    /* renamed from: l */
    public static final int f26616l = 0;

    /* renamed from: m */
    public static final int f26617m = 5;

    /* renamed from: n */
    public static final int f26618n = 1;

    /* renamed from: o */
    public static final int f26619o = 2;

    /* renamed from: p */
    public static final int f26620p = 3;

    /* renamed from: q */
    public static final int f26621q = 4;

    /* renamed from: r */
    public static final String f26622r = "MPTH,MMAB";

    /* renamed from: s */
    public static final String f26623s = "MPTH,MRTT";

    /* renamed from: t */
    public static final String f26624t = "MPTH,MMIM";

    /* renamed from: u */
    public static final String f26625u = "MPTH";

    /* renamed from: v */
    public static final String f26626v = "STMP";

    /* renamed from: w */
    public static final int f26627w = 16;

    /* renamed from: x */
    public static final int f26628x = 300;

    /* renamed from: y */
    public static final int f26629y = 1000;

    /* renamed from: z */
    public static final String f26630z = ",";

    /* renamed from: a */
    public C5901e2 f26631a;

    /* renamed from: b */
    public ConcurrentHashMap<String, C5873c2> f26632b;

    /* renamed from: com.huawei.hms.network.embedded.d2$b */
    public static class b {

        /* renamed from: a */
        public static final C5887d2 f26633a = new C5887d2();
    }

    public C5887d2() {
        this.f26632b = new ConcurrentHashMap<>(3);
    }

    /* renamed from: a */
    private C5873c2 m34097a(Context context, PolicyExecutor policyExecutor) {
        String string;
        int i10;
        int iStringToInteger;
        StringBuilder sb2;
        String str;
        C5873c2 c5873c2 = new C5873c2();
        try {
            ExperimentalCronetEngine.Builder builderEnableNetworkQualityEstimator = new ExperimentalCronetEngine.Builder(context).enableQuic(true).enableHttp2(true).enableNetworkQualityEstimator(true);
            if (ImplVersion.getApiLevel() >= 16) {
                builderEnableNetworkQualityEstimator.enableTextTransmission(Boolean.parseBoolean(policyExecutor.getValue("", f26609e)));
            }
            for (Map.Entry<String, C6005m2> entry : C5927g2.getInstance().getQuicHints().entrySet()) {
                Logger.m32142i(f26607c, "the host of using quic is %s", entry.getKey());
                builderEnableNetworkQualityEstimator.addQuicHint(entry.getKey(), entry.getValue().getPort(), entry.getValue().getAlternatePort());
            }
            if (policyExecutor.getUserConfigValue(f26610f).isEmpty() ? policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.SMALLPKT_FEC) : StringUtils.stringToBoolean(policyExecutor.getUserConfigValue(f26610f), false)) {
                long j10 = policyExecutor.getLong("", PolicyNetworkService.ClientConstants.SMALLPKT_FEC_INITIALLEVEL, 0L);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(",HW01,AKDU");
                sb3.append(",SCC");
                if (j10 < 0 || j10 > 5) {
                    j10 = 0;
                }
                sb3.append(j10);
                string = sb3.toString();
            } else {
                string = "";
            }
            if (policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.ENABLE_MULTIPATH)) {
                int i11 = policyExecutor.getInt("", PolicyNetworkService.ClientConstants.MULTIPATH_TYPE);
                if (i11 == 4) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    str = ",MPTH";
                } else if (i11 == 3) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    str = ",MPTH,MMIM";
                } else if (i11 == 2) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    str = ",MPTH,MRTT";
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    str = ",MPTH,MMAB";
                }
                sb2.append(str);
                string = sb2.toString();
            }
            if (C5976k.a.f27162b.equals(policyExecutor.getString("", PolicyNetworkService.ClientConstants.CONGESTION_CONTROL_TYPE))) {
                string = string + ",HW02,PCCH,IFWd";
            }
            if (policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.REDUNDANT_ACK)) {
                string = string + ",RACK,ARC3";
            }
            if (C5976k.f.f27214a.equals(policyExecutor.getString("", PolicyNetworkService.ClientConstants.PRIORITY_CONTROL_TYPE))) {
                string = string + ",PRIO";
            }
            if (HianalyticsHelper.getInstance().isQuicEnableReport(ContextHolder.getAppContext()) && C5929g4.getInstance().addQuicTrace()) {
                string = string + ",RPTD";
            }
            String string2 = policyExecutor.getString("", PolicyNetworkService.ClientConstants.QUIC_CONNECTION_OPTIONS);
            String strM34098a = TextUtils.isEmpty(string2) ? f26626v + string : m34098a(string, string2);
            String str2 = ("huawei_module_quic_pro".equals(policyExecutor.getString("", PolicyNetworkService.QuicConstants.MODULE_NAME)) && C5927g2.getInstance().isHquicProviderSupportSelectQuic()) ? C5927g2.f26799H3 : "QUIC_VERSION_43";
            try {
                JSONObject jSONObjectPut = new JSONObject().put(C5950i.f26985f, strM34098a).put("idle_connection_timeout_seconds", 300).put("quic_disable_tls_0rtt", !policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.TLS_ZERO_RTT));
                jSONObjectPut.put("quic_version", str2);
                if (policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.HWHTTP_ENABLE_CONNECTION_MIGRATION)) {
                    jSONObjectPut.put("migrate_sessions_on_network_change_v2", true).put("migrate_sessions_early_v2", true);
                    c5873c2.setEnableConnectionMigrated(true);
                    long j11 = policyExecutor.getLong("", PolicyNetworkService.ClientConstants.WAIT_FOR_NEW_NETWORK_TIME_MS, -1L);
                    if (j11 >= 0 && j11 <= 20000) {
                        jSONObjectPut.put("wait_for_new_network_time_ms", j11);
                    }
                }
                JSONObject jSONObjectPut2 = new JSONObject().put("QUIC", jSONObjectPut);
                if (policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.QUIC_ENABLE_GSO)) {
                    jSONObjectPut2.put("quic_enable_gso", true);
                }
                if (policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.QUIC_ENABLE_BANDWIDTH)) {
                    jSONObjectPut2.put("quic_enable_bandwidth", true);
                }
                String value = policyExecutor.getValue("", PolicyNetworkService.ClientConstants.TRAFFIC_CLASS);
                if (!TextUtils.isEmpty(value) && (iStringToInteger = StringUtils.stringToInteger(value, -1)) >= 0 && iStringToInteger <= 255) {
                    jSONObjectPut2.put(C6148x2.TRAFFIC_CLASS, iStringToInteger);
                }
                String string3 = policyExecutor.getString("", PolicyNetworkService.ClientConstants.STORAGE_PATH);
                if (m34099a(string3)) {
                    File file = new File(CreateFileUtil.getCanonicalPath(string3) + "/cronet_cache");
                    if (file.exists() || file.mkdirs()) {
                        builderEnableNetworkQualityEstimator.setStoragePath(file.getCanonicalPath());
                        long j12 = policyExecutor.getLong("", PolicyNetworkService.ClientConstants.MAX_SERVER_CONFIGS_STORED_PROPERTIES, 0L);
                        if (j12 > 0 && j12 <= 1000) {
                            jSONObjectPut.put("max_server_configs_stored_in_properties", policyExecutor.getLong("", PolicyNetworkService.ClientConstants.MAX_SERVER_CONFIGS_STORED_PROPERTIES, 0L));
                        }
                    }
                } else {
                    Logger.m32141i(f26607c, "Storage file path is invalid.");
                }
                jSONObjectPut2.put("server_config_persist_delay", policyExecutor.getInt("", PolicyNetworkService.ClientConstants.SERVER_CONFIG_PERSIST_DELAY)).put("tls13_session_timeout", policyExecutor.getInt("", PolicyNetworkService.ClientConstants.TLS13_SESSION_TIMEOUT)).put("commit_file_delay", policyExecutor.getInt("", PolicyNetworkService.ClientConstants.COMMIT_FILE_DELAY)).put("quic_broken_mode", policyExecutor.getInt("", PolicyNetworkService.ClientConstants.QUIC_BROKEN_MDOE));
                Logger.m32141i(f26607c, "QUIC options:" + jSONObjectPut2.toString());
                builderEnableNetworkQualityEstimator.setExperimentalOptions(jSONObjectPut2.toString());
                C5963j.m34447e().m34456b(strM34098a);
                i10 = 0;
            } catch (JSONException e10) {
                i10 = 0;
                Logger.m32140e(f26607c, "set QUIC options failed, exception:", e10.getClass().getSimpleName());
            }
            builderEnableNetworkQualityEstimator.setThreadPriority(i10);
            ExperimentalCronetEngine experimentalCronetEngineBuild = builderEnableNetworkQualityEstimator.build();
            c5873c2.setCronetEngine(experimentalCronetEngineBuild);
            C5901e2 c5901e2 = new C5901e2(ExecutorsUtils.newSingleThreadExecutor(f26608d));
            this.f26631a = c5901e2;
            if (experimentalCronetEngineBuild instanceof ExperimentalCronetEngine) {
                experimentalCronetEngineBuild.addRequestFinishedListener(c5901e2);
            }
        } catch (Throwable th2) {
            Logger.m32141i(f26607c, "build CronetEngine failed, the reason:" + StringUtils.anonymizeMessage(th2.getMessage()));
        }
        return c5873c2;
    }

    public static C5887d2 getInstance() {
        return b.f26633a;
    }

    public void addCronetEngineFeature(String str, C5873c2 c5873c2) {
        this.f26632b.put(str, c5873c2);
    }

    public C5873c2 getCronetEngineFeature(Context context, PolicyExecutor policyExecutor) {
        String str = policyExecutor.getString("", PolicyNetworkService.ClientConstants.CONGESTION_CONTROL_TYPE).equals(C5976k.a.f27162b) ? policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.ENABLE_MULTIPATH) ? CONGESTION_CONTROL_PCC_MULTIPATH : C5976k.a.f27162b : "bbrv1";
        Logger.m32143v(f26607c, "congestionType is " + str);
        synchronized (C5887d2.class) {
            try {
                C5873c2 c5873c2 = this.f26632b.get(str);
                if (c5873c2 == null || c5873c2.getCronetEngine() == null) {
                    C5873c2 c5873c2M34097a = m34097a(context, policyExecutor);
                    getInstance().addCronetEngineFeature(str, c5873c2M34097a);
                    C5927g2.getInstance().maybeRecordCongestionTypeInfo(str, policyExecutor.getBoolean("", PolicyNetworkService.ClientConstants.QUIC_ENABLE_BANDWIDTH));
                    return c5873c2M34097a;
                }
                Logger.m32143v(f26607c, "use already cronet engine, congestion type is " + str);
                return c5873c2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private String m34098a(String str, String str2) {
        String[] strArrSplit = str.split(",");
        String[] strArrSplit2 = str2.split(",");
        HashSet<String> hashSet = new HashSet();
        hashSet.add(f26626v);
        hashSet.addAll(Arrays.asList(strArrSplit));
        hashSet.addAll(Arrays.asList(strArrSplit2));
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : hashSet) {
            if (!TextUtils.isEmpty(str3)) {
                sb2.append("," + str3);
            }
        }
        return sb2.toString().replaceFirst(",", "");
    }

    /* renamed from: a */
    private boolean m34099a(String str) {
        File fileNewFile = CreateFileUtil.newFile(str);
        return fileNewFile != null && fileNewFile.exists() && fileNewFile.canWrite();
    }
}
