package com.huawei.location.lite.common.report;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import es.C9536a;
import es.C9538c;
import es.C9546k;
import es.C9550o;
import es.C9552q;
import es.C9555t;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import mr.C11506a;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class ReportBuilder {
    protected static final String CLOUD_FENCE_TYPE = "3";
    protected static final String CP_SDK_TYPE = "1";
    protected static final String FULL_SDK_TYPE = "4";
    protected static final String OPEN_SDK_TYPE = "2";
    private static final String ROM_CN_HW = "1003";
    private static final String ROM_G_ABROAD = "1002";
    private static final String ROM_HW_PAD = "1100";
    private static final String ROM_HW_WATCH = "1200";
    private static final String ROM_NOG_ABROAD = "1001";
    private static final String ROM_NO_HW = "2001";
    private long callTime;
    private String eventId;
    protected LinkedHashMap<String, String> linkedHashMap = new C6790b();

    /* renamed from: com.huawei.location.lite.common.report.ReportBuilder$b */
    public static class C6790b<K, V> extends LinkedHashMap<K, V> {

        /* renamed from: a */
        public static final Object f31379a = new Object();

        public C6790b() {
        }

        public /* synthetic */ C6790b(C6789a c6789a) {
            this();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            synchronized (f31379a) {
                super.clear();
            }
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> setEntrySet;
            synchronized (f31379a) {
                setEntrySet = super.entrySet();
            }
            return setEntrySet;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V v10;
            synchronized (f31379a) {
                v10 = (V) super.get(obj);
            }
            return v10;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public V getOrDefault(Object obj, V v10) {
            V v11;
            synchronized (f31379a) {
                v11 = (V) super.getOrDefault(obj, v10);
            }
            return v11;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V put(K k10, V v10) {
            V v11;
            synchronized (f31379a) {
                v11 = (V) super.put(k10, v10);
            }
            return v11;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (f31379a) {
                super.putAll(map);
            }
        }

        @Override // java.util.HashMap, java.util.Map
        public V putIfAbsent(K k10, V v10) {
            V v11;
            synchronized (f31379a) {
                v11 = (V) super.putIfAbsent(k10, v10);
            }
            return v11;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            V v10;
            synchronized (f31379a) {
                v10 = (V) super.remove(obj);
            }
            return v10;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            String string;
            synchronized (f31379a) {
                string = super.toString();
            }
            return string;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collectionValues;
            synchronized (f31379a) {
                collectionValues = super.values();
            }
            return collectionValues;
        }

        @Override // java.util.HashMap, java.util.Map
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (f31379a) {
                zRemove = super.remove(obj, obj2);
            }
            return zRemove;
        }
    }

    public ReportBuilder() {
        setBrand();
        setManufacturer();
        setCallTime();
        setWifiEnable();
        setService("hwLocation");
        setNetworkType(C9546k.m59609c());
        setNetworkValid(C9546k.m59613g(C11991a.m72145a()));
        setMCC(C9555t.m59660e());
        setLocationSdkType("4");
        setLBSVersionCode(C9536a.m59544d());
        setRomType(getRomType());
        setPackage(C11991a.m72145a().getPackageName());
        setVersion(String.valueOf(21403300));
        if (C9552q.m59643a() == 100) {
            setAppID(C11506a.m68682e().m68686d());
        }
    }

    public LinkedHashMap<String, String> build() {
        return this.linkedHashMap;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getMcc() {
        LinkedHashMap<String, String> linkedHashMap = this.linkedHashMap;
        return linkedHashMap == null ? "" : linkedHashMap.get("MCC");
    }

    public final String getRomType() {
        return C9550o.m59635h() ? C9538c.m59567f(C11991a.m72145a()) == 1 ? ROM_HW_PAD : C9538c.m59571j() ? "1200" : C9550o.m59633f() ? ROM_CN_HW : C9550o.m59634g() ? ROM_G_ABROAD : ROM_NOG_ABROAD : ROM_NO_HW;
    }

    public final ReportBuilder setApiName(String str) {
        this.linkedHashMap.put("apiName", str);
        this.eventId = str;
        return this;
    }

    public final ReportBuilder setAppID(String str) {
        this.linkedHashMap.put("appid", str);
        return this;
    }

    public final ReportBuilder setBrand() {
        this.linkedHashMap.put(JsbMapKeyNames.H5_BRAND, C9538c.m59566e());
        return this;
    }

    public final ReportBuilder setCallTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.linkedHashMap.put("callTime", String.valueOf(jCurrentTimeMillis));
        this.callTime = jCurrentTimeMillis;
        return this;
    }

    public final ReportBuilder setCostTime() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.callTime;
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = 0;
        }
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(jCurrentTimeMillis));
        return this;
    }

    public final ReportBuilder setCpAppVersion(String str) {
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_APP_VERSION, str);
        return this;
    }

    public final ReportBuilder setErrorCode(String str) {
        this.linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, str);
        return this;
    }

    public final ReportBuilder setErrorMessage(String str) {
        this.linkedHashMap.put("errorMessage", str);
        return this;
    }

    public final ReportBuilder setExt(String str) {
        this.linkedHashMap.put("ext", str);
        return this;
    }

    public final ReportBuilder setExtParam(String str, String str2) {
        this.linkedHashMap.put(str, str2);
        return this;
    }

    public final ReportBuilder setLBSVersionCode(long j10) {
        this.linkedHashMap.put("lbs_version", j10 + "");
        return this;
    }

    public final ReportBuilder setLocationEnable(boolean z10) {
        if (!z10) {
            this.linkedHashMap.put("locEnable", "false");
        }
        return this;
    }

    public final ReportBuilder setLocationSdkType(String str) {
        this.linkedHashMap.put("lcSdkType", str);
        return this;
    }

    public final ReportBuilder setMCC(String str) {
        this.linkedHashMap.put("MCC", str);
        return this;
    }

    public final ReportBuilder setManufacturer() {
        this.linkedHashMap.put("pub_mfc", C9538c.m59569h());
        return this;
    }

    public final ReportBuilder setModuleName(String str) {
        this.linkedHashMap.put(FaqConstants.FAQ_MODULE, str);
        return this;
    }

    public final ReportBuilder setNetworkType(String str) {
        this.linkedHashMap.put("networkType", str);
        return this;
    }

    public ReportBuilder setNetworkValid(boolean z10) {
        this.linkedHashMap.put("netWorkValid", "" + z10);
        return this;
    }

    public final ReportBuilder setOperator(String str) {
        this.linkedHashMap.put("operator", str);
        return this;
    }

    public final ReportBuilder setPackage(String str) {
        this.linkedHashMap.put("package", str);
        return this;
    }

    public final ReportBuilder setRequestUrl(String str) {
        this.linkedHashMap.put("requestUrl", str);
        return this;
    }

    public final ReportBuilder setResult(String str) {
        this.linkedHashMap.put("result", str);
        return this;
    }

    public final ReportBuilder setRomType(String str) {
        this.linkedHashMap.put("rom_type", str);
        return this;
    }

    public final ReportBuilder setService(String str) {
        this.linkedHashMap.put("service", str);
        return this;
    }

    public final ReportBuilder setSrc(String str) {
        this.linkedHashMap.put("src", str);
        return this;
    }

    public final ReportBuilder setTag(String str) {
        this.linkedHashMap.put("tag", str);
        return this;
    }

    public final ReportBuilder setTransactionID(String str) {
        this.linkedHashMap.put("transId", str);
        return this;
    }

    public final ReportBuilder setVersion(String str) {
        this.linkedHashMap.put("version", str);
        return this;
    }

    public final ReportBuilder setWLANScan() {
        if (!C9555t.m59656a(C11991a.m72145a())) {
            this.linkedHashMap.put("WLANScan", "false");
        }
        return this;
    }

    public final ReportBuilder setWifiEnable() {
        if (!C9555t.m59657b(C11991a.m72145a())) {
            this.linkedHashMap.put("wifiEnable", "false");
        }
        return this;
    }
}
