package com.huawei.hms.network.file.core.util;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.PackageManagerCompat;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.network.Version;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.embedded.C6018n2;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.core.C6224b;
import com.huawei.hms.network.file.core.C6226d;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.InterfaceC6233d;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.file.core.util.f */
/* loaded from: classes8.dex */
public class C6256f {

    /* renamed from: a */
    int f29517a = 0;

    /* renamed from: b */
    int f29518b = 0;

    /* renamed from: c */
    long f29519c = 0;

    /* renamed from: d */
    long f29520d = 0;

    /* renamed from: e */
    int f29521e;

    /* renamed from: f */
    String f29522f;

    public C6256f(C6226d c6226d) {
        this.f29521e = 0;
        if (c6226d == null || c6226d.m36205a() == null) {
            return;
        }
        if (c6226d.m36205a().getOldInterfaceFlag()) {
            this.f29521e = 1;
        }
        this.f29522f = Utils.getValueFromOptions("scene", c6226d.m36205a().getOptions());
    }

    /* renamed from: a */
    private long m36370a(double d10, double d11) {
        return (long) ((d10 * 0.2d) + (d11 * 0.8d));
    }

    /* renamed from: b */
    public void m36380b() {
        this.f29518b = NetworkUtil.getMobileRsrp(RequestManager.getAppContext());
        this.f29517a = NetworkUtil.getWifiRssi(RequestManager.getAppContext());
    }

    /* renamed from: a */
    private static String m36371a(List<AbstractC6240k> list) {
        if (Utils.isEmpty(list)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (AbstractC6240k abstractC6240k : list) {
            if (abstractC6240k != null && (abstractC6240k instanceof AbstractC6240k)) {
                String strM36344s = abstractC6240k.m36344s();
                if (!Utils.isBlank(strM36344s) && !arrayList.contains(strM36344s)) {
                    arrayList.add(strM36344s);
                }
            }
        }
        if (Utils.isEmpty(arrayList)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (i10 != 0) {
                sb2.append(";");
            }
            sb2.append((String) arrayList.get(i10));
        }
        return sb2.toString();
    }

    /* renamed from: b */
    private void m36377b(LinkedHashMap<String, String> linkedHashMap, List<AbstractC6240k> list) {
        long jM36045d = 0;
        long jLongValue = 0;
        long jLongValue2 = 0;
        long jM36044c = 0;
        for (AbstractC6240k abstractC6240k : list) {
            if (abstractC6240k.mo36029m() != null) {
                if (abstractC6240k.mo36029m().m36041b() != null) {
                    jLongValue += abstractC6240k.mo36029m().m36041b().longValue();
                }
                if (abstractC6240k.mo36029m().m36037a() != null) {
                    jLongValue2 += abstractC6240k.mo36029m().m36037a().longValue();
                }
                jM36045d += abstractC6240k.mo36029m().m36045d();
                jM36044c += abstractC6240k.mo36029m().m36044c();
                FLogger.m36354v("Reporter", "DownloadReportCollectInfo:" + abstractC6240k.mo36029m());
            }
        }
        linkedHashMap.put("available_ram", String.valueOf(m36370a(jLongValue, jLongValue2) / list.size()));
        linkedHashMap.put("current_cpu_freq", String.valueOf(m36370a(jM36045d, jM36044c) / list.size()));
    }

    /* renamed from: a */
    public void m36378a() {
        this.f29519c = System.currentTimeMillis();
        this.f29520d = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    private <T> void m36372a(int i10) {
        if (i10 == Constants.ErrorCode.SUCCESS.getErrorCode()) {
            i10 = 0;
        }
        long jElapsedRealtime = this.f29520d != 0 ? SystemClock.elapsedRealtime() - this.f29520d : 0L;
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        linkedHashMapPack.put("package", RequestManager.getAppContext().getPackageName()).put("version", "8.0.1.305").put("service", "networkkit").put("apiName", "file_request").put("result", i10).put(WiseOpenHianalyticsData.UNION_COSTTIME, jElapsedRealtime).put("callTime", this.f29519c).put(WiseOpenHianalyticsData.UNION_APP_VERSION, PackageManagerCompat.getAppVersion(RequestManager.getAppContext()));
        FLogger.m36354v("Reporter", "collectWiseOpenData:" + linkedHashMapPack.getAll());
        HianalyticsHelper.getInstance().onEvent(linkedHashMapPack.getAll(), "60000", 0);
    }

    /* renamed from: a */
    private void m36373a(Request request, LinkedHashMap<String, String> linkedHashMap) {
        RequestConfig config = request.getConfig();
        if (config == null || TextUtils.isEmpty(config.getOptions())) {
            return;
        }
        String valueFromOptions = Utils.getValueFromOptions("complete_file_size", config.getOptions());
        if (TextUtils.isEmpty(valueFromOptions)) {
            return;
        }
        linkedHashMap.put("complete_file_size", valueFromOptions);
    }

    /* renamed from: a */
    private void m36374a(LinkedHashMap<String, String> linkedHashMap, List<AbstractC6240k> list) {
        linkedHashMap.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        if (list == null || list.size() <= 1) {
            return;
        }
        linkedHashMap.put("hardware", Build.HARDWARE);
        m36377b(linkedHashMap, list);
    }

    /* renamed from: a */
    public void m36379a(List<AbstractC6240k> list, FileManagerException fileManagerException, InterfaceC6233d interfaceC6233d, LinkedHashMap<String, String> linkedHashMap) {
        String message;
        if (!HianalyticsHelper.getInstance().isEnableReport(RequestManager.getAppContext())) {
            FLogger.m36353i("Reporter", "hiAnalyticEnable is false, no need to report!", new Object[0]);
            return;
        }
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sdk_type", "UxPP");
        linkedHashMap2.put(HianalyticsBaseData.SDK_NAME, "networkkit");
        linkedHashMap2.put("sdk_version", "8.0.1.305");
        linkedHashMap2.put("total_time", String.valueOf(interfaceC6233d.mo36230a()));
        linkedHashMap2.put("net_total_time", String.valueOf(interfaceC6233d.mo36231b()));
        linkedHashMap2.put("restclient_version_code", Version.getVersion());
        linkedHashMap2.put("network_type", String.valueOf(NetworkUtil.netWork(RequestManager.getAppContext())));
        linkedHashMap2.put("wifi_signal_strength", String.valueOf(this.f29517a));
        linkedHashMap2.put("mobile_signal_strength", String.valueOf(this.f29518b));
        linkedHashMap2.put("old_interface_flag", String.valueOf(this.f29521e));
        int errorCode = Constants.ErrorCode.SUCCESS.getErrorCode();
        if (fileManagerException != null) {
            errorCode = fileManagerException.getErrorCode();
            message = fileManagerException.getMessage();
        } else {
            message = "success";
        }
        linkedHashMap2.put("error_code", String.valueOf(errorCode));
        linkedHashMap2.put("message", Utils.anonymizeMessage(message));
        m36375a(list, interfaceC6233d, linkedHashMap2);
        m36374a(linkedHashMap2, list);
        FLogger.m36354v("Reporter", "uploadCollection:" + linkedHashMap2);
        StringBuilder sb2 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("protocol_impl", list.get(i10).m36340o());
                linkedHashMap3.put("protocol", list.get(i10).m36339n());
                linkedHashMap3.put(C6018n2.CONGESTION_CONTROL_TYPE, list.get(i10).m36335i());
                linkedHashMap3.put("multipath_algorithm", String.valueOf(list.get(i10).m36338l()));
                sb2.append(linkedHashMap3);
                if (i10 != list.size() - 1) {
                    sb2.append(",");
                }
            }
        }
        FLogger.m36353i("Reporter", "protocol:" + ((Object) sb2), new Object[0]);
        HianalyticsHelper.getInstance().onEvent(linkedHashMap2, "file_request");
        m36372a(errorCode);
        linkedHashMap2.clear();
    }

    /* renamed from: a */
    private void m36375a(List<AbstractC6240k> list, InterfaceC6233d interfaceC6233d, LinkedHashMap<String, String> linkedHashMap) {
        AbstractC6240k abstractC6240kM36317a = AbstractC6240k.m36317a(list);
        String str = "unknown";
        if (abstractC6240kM36317a == null) {
            linkedHashMap.put("trans_type", "unknown");
            return;
        }
        Request requestM36341p = abstractC6240kM36317a.m36341p();
        String strValueOf = String.valueOf(requestM36341p.getId());
        linkedHashMap.put(MapKeyNames.REQUEST_ID, strValueOf);
        m36373a(requestM36341p, linkedHashMap);
        if (!TextUtils.isEmpty(this.f29522f)) {
            linkedHashMap.put("scene", this.f29522f);
        }
        linkedHashMap.put("retry_time", String.valueOf((requestM36341p.getConfig() == null || requestM36341p.getConfig().getRetryTimes() == -100) ? 0 : requestM36341p.getConfig().getRetryTimes()));
        if (abstractC6240kM36317a.mo36026d() == InterfaceC6234e.b.UPLOAD) {
            str = "upload";
        } else if (abstractC6240kM36317a.mo36026d() == InterfaceC6234e.b.DOWNLOAD) {
            str = "download";
        }
        linkedHashMap.put("trans_type", str);
        String strM36339n = abstractC6240kM36317a.m36339n();
        linkedHashMap.put("protocol", strM36339n);
        if (C5927g2.f26799H3.equals(strM36339n)) {
            linkedHashMap.put(C6018n2.CONGESTION_CONTROL_TYPE, abstractC6240kM36317a.m36335i());
            linkedHashMap.put("multipath_algorithm", String.valueOf(abstractC6240kM36317a.m36338l()));
        }
        linkedHashMap.put("protocol_impl", abstractC6240kM36317a.m36340o());
        linkedHashMap.put("request_file_size", String.valueOf(abstractC6240kM36317a.m36342q()));
        linkedHashMap.put(C6148x2.CONNECT_RETRY, String.valueOf(abstractC6240kM36317a.m36336j()));
        linkedHashMap.put("server_ip", m36371a(list));
        linkedHashMap.put("function_flag", String.valueOf(abstractC6240kM36317a.m36337k()));
        if (requestM36341p.getSpeedLimit() > 0) {
            m36376a(linkedHashMap, "speed_limit", Integer.valueOf(requestM36341p.getSpeedLimit()));
        }
        Utils.addNonEmptyMapItem(linkedHashMap, requestM36341p.getReportInfos());
        if (!linkedHashMap.containsKey("trace_id")) {
            linkedHashMap.put("trace_id", strValueOf);
        }
        m36376a(linkedHashMap, "file_size", Long.valueOf(interfaceC6233d.mo36232b(list)));
        m36376a(linkedHashMap, "rate", Long.valueOf(interfaceC6233d.mo36015a(list)));
        m36376a(linkedHashMap, "ABTest_dyFrag_groupid", C6224b.m36177a());
        m36376a(linkedHashMap, "config_slice_num", Integer.valueOf(C6224b.m36181b()));
        m36376a(linkedHashMap, "actual_slice_num", Integer.valueOf(abstractC6240kM36317a.m36345t()));
    }

    /* renamed from: a */
    private void m36376a(Map<String, String> map, String str, Object obj) {
        if (map == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
            return;
        }
        map.put(str, String.valueOf(obj));
    }
}
