package com.huawei.android.hicloud.p088ui.extend;

import com.huawei.hicloud.base.bean.SyncItemInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import p399jk.AbstractC10896a;

/* renamed from: com.huawei.android.hicloud.ui.extend.f */
/* loaded from: classes3.dex */
public class C3948f {

    /* renamed from: a */
    public Map<String, ServiceStateController> f18032a;

    /* renamed from: b */
    public LinkedHashMap<String, Integer> f18033b;

    /* renamed from: c */
    public Map<String, Integer> f18034c;

    /* renamed from: d */
    public String[] f18035d;

    /* renamed from: e */
    public int f18036e;

    /* renamed from: f */
    public Map<String, SyncItemInfo> f18037f;

    /* renamed from: g */
    public int f18038g;

    /* renamed from: com.huawei.android.hicloud.ui.extend.f$b */
    public static class b {

        /* renamed from: a */
        public static C3948f f18039a = new C3948f();
    }

    /* renamed from: g */
    public static C3948f m24064g() {
        return b.f18039a;
    }

    /* renamed from: d */
    public void m24066d() {
        LinkedHashMap<String, Integer> linkedHashMap = this.f18033b;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        this.f18038g = 0;
        this.f18036e = 0;
    }

    /* renamed from: e */
    public int m24067e() {
        return this.f18038g + this.f18036e;
    }

    /* renamed from: f */
    public String m24068f() {
        return this.f18035d[0];
    }

    /* renamed from: h */
    public String m24069h() {
        return this.f18035d[1];
    }

    /* renamed from: i */
    public Map<String, SyncItemInfo> m24070i() {
        return this.f18037f;
    }

    /* renamed from: k */
    public final /* synthetic */ void m24071k(String str, Integer num) {
        if (this.f18033b.containsKey(str)) {
            this.f18033b.put(str, num);
        }
        AbstractC10896a.m65885d("ServicesDataHelper", "tempMap has data: " + str + " : " + num);
    }

    /* renamed from: l */
    public final /* synthetic */ void m24072l(Integer num) {
        this.f18038g += num.intValue();
    }

    /* renamed from: m */
    public void m24073m(String str, ServiceStateController serviceStateController) {
        this.f18032a.put(str, serviceStateController);
    }

    /* renamed from: n */
    public final void m24074n() {
        Map<String, ServiceStateController> map = this.f18032a;
        if (map != null) {
            map.values().forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.extend.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ServiceStateController) obj).mo24013a();
                }
            });
        } else {
            AbstractC10896a.m65888w("ServicesDataHelper", "update callback is null");
        }
    }

    /* renamed from: o */
    public void m24075o(Map<String, SyncItemInfo> map) {
        this.f18037f = map;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setServiceNameMap: ");
        sb2.append(map);
        AbstractC10896a.m65885d("ServicesDataHelper", sb2.toString() == null ? "is null" : (String) map.keySet().stream().collect(Collectors.joining(",")));
        m24074n();
    }

    /* renamed from: p */
    public void m24076p(List<String> list) {
        if (list == null || list.size() == 0) {
            AbstractC10896a.m65888w("ServicesDataHelper", "services is null");
            return;
        }
        AbstractC10896a.m65885d("ServicesDataHelper", "setServicesName:" + ((String) list.stream().collect(Collectors.joining(","))));
        for (String str : list) {
            if (!this.f18033b.containsKey(str)) {
                this.f18033b.put(str, 0);
            }
        }
        Map<String, Integer> map = this.f18034c;
        if (map == null || map.size() == 0) {
            return;
        }
        AbstractC10896a.m65885d("ServicesDataHelper", "tempMap has data");
        this.f18034c.forEach(new BiConsumer() { // from class: com.huawei.android.hicloud.ui.extend.c
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f18030a.m24071k((String) obj, (Integer) obj2);
            }
        });
        this.f18034c.clear();
        this.f18038g = 0;
        this.f18033b.values().forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.extend.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f18031a.m24072l((Integer) obj);
            }
        });
        m24077q();
        m24074n();
    }

    /* renamed from: q */
    public final void m24077q() {
        int i10 = 0;
        for (Map.Entry<String, Integer> entry : this.f18033b.entrySet()) {
            if (entry.getValue().intValue() > 0) {
                String[] strArr = this.f18035d;
                if (i10 < strArr.length) {
                    strArr[i10] = entry.getKey();
                    i10++;
                }
                if (i10 >= this.f18035d.length) {
                    return;
                }
            }
        }
        String[] strArr2 = this.f18035d;
        if (i10 < strArr2.length) {
            if (i10 != 0) {
                strArr2[i10] = "cloudBack1";
            } else {
                strArr2[0] = "cloudBack1";
                strArr2[1] = "cloudBack2";
            }
        }
    }

    /* renamed from: r */
    public void m24078r(String str, int i10) {
        AbstractC10896a.m65885d("ServicesDataHelper", "updateServiceState: " + str + " : " + i10);
        if ("cloudbackup".equals(str)) {
            this.f18036e = i10;
        } else {
            LinkedHashMap<String, Integer> linkedHashMap = this.f18033b;
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                AbstractC10896a.m65887i("ServicesDataHelper", "serviceMap is null put data to tempMap: " + str + " : " + i10);
                this.f18034c.put(str, Integer.valueOf(i10));
                return;
            }
            if (!this.f18033b.containsKey(str)) {
                AbstractC10896a.m65888w("ServicesDataHelper", str + " is not in config, do nothing");
                return;
            }
            this.f18038g += i10 - this.f18033b.getOrDefault(str, 0).intValue();
            this.f18033b.put(str, Integer.valueOf(i10));
        }
        m24077q();
        m24074n();
    }

    public C3948f() {
        this.f18032a = new HashMap();
        this.f18033b = new LinkedHashMap<>();
        this.f18034c = new HashMap();
        this.f18035d = new String[2];
        this.f18036e = 0;
        this.f18038g = 0;
    }
}
