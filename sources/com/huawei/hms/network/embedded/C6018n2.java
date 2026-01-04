package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.hquic.HQUICProvider;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.chromium.net.UrlResponseInfo;

/* renamed from: com.huawei.hms.network.embedded.n2 */
/* loaded from: classes8.dex */
public class C6018n2 {
    public static final String SERVER_IP = "server_ip";

    /* renamed from: a */
    public static final String f27564a = "QuicStats";

    /* renamed from: d */
    public static final String f27567d = ",";

    /* renamed from: e */
    public static final String f27568e = ":";
    public static final String CONGESTION_CONTROL_TYPE = "congestion_control_type";
    public static final String MULTIPATH_ALGORITHM = "multipath_scheduler";

    /* renamed from: b */
    public static final Set<String> f27565b = new HashSet(Arrays.asList(JsbMapKeyNames.H5_CLIENT_ID, "bytes_sent", "packets_sent", "packets_discarded", "bytes_received", "packets_received", "packets_processed", "bytes_retransmitted", "packets_retransmitted", "bytes_spuriously_retransmitted", "packets_spuriously_retransmitted", "packets_lost", "srtt_us", "estimated_bandwidth_bps", "is_fec_enabled", "current_fec_policy", "packet_loss_rate", "is_text_transmission_used", "tlp_count", "rto_count", "pto_count", "zero_rtt_mode", "zero_rtt_early_data_reason", "is_rack_enabled", "rack_count", "is_pcch_enabled", "sending_rate", "migration_result", "migration_status", "alternativejob_start_status", "alternativejob_race_res", "inner_quic_error", "inner_net_error", "mark_broken", "is_ript_enabled", "ript_count", CONGESTION_CONTROL_TYPE, MULTIPATH_ALGORITHM, "gso_status"));

    /* renamed from: c */
    public static final Set<String> f27566c = new HashSet(Arrays.asList("fec_restored", "fec_actual_bytes_sent", "fec_actual_packets_sent", "fec_actual_bytes_received", "fec_actual_packets_received", "fec_bytes_sent", "fec_packets_send", "fec_packet_lost", "fec_frames_received", "fec_protected_packets_sent"));

    public static void collectQuicStats(C6148x2 c6148x2, C5966j2 c5966j2) {
        LinkedHashMap<String, String> quicStatsMap = getQuicStatsMap(c5966j2.getResponseInfo());
        if (quicStatsMap.isEmpty()) {
            return;
        }
        c6148x2.put("hquic_version", new HQUICProvider(ContextHolder.getResourceContext()).getVersion());
        boolean z10 = false;
        for (Map.Entry<String, String> entry : quicStatsMap.entrySet()) {
            if (f27565b.contains(entry.getKey())) {
                if ("is_fec_enabled".equals(entry.getKey()) && "1".equals(entry.getValue())) {
                    z10 = true;
                }
            } else if (!z10 || !f27566c.contains(entry.getKey())) {
            }
            c6148x2.put(entry.getKey(), entry.getValue());
        }
    }

    public static LinkedHashMap<String, String> getQuicStatsMap(UrlResponseInfo urlResponseInfo) {
        String quicStats;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (urlResponseInfo == null) {
            return linkedHashMap;
        }
        try {
            quicStats = urlResponseInfo.getQuicStats();
        } catch (Throwable unused) {
            Logger.m32138e(f27564a, "getQuicStats meet error");
            quicStats = null;
        }
        if (TextUtils.isEmpty(quicStats)) {
            return linkedHashMap;
        }
        Logger.m32143v(f27564a, "Cronet urlResponseInfo.getQuicStats(): " + quicStats);
        String[] strArrSplit = quicStats.split(",");
        int length = strArrSplit.length;
        for (int i10 = 0; i10 < length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].split(":");
            if (strArrSplit2.length == 2) {
                linkedHashMap.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
        return linkedHashMap;
    }
}
