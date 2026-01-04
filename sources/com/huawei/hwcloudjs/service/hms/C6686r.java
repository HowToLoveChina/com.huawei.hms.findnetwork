package com.huawei.hwcloudjs.service.hms;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.huawei.hwcloudjs.service.hms.r */
/* loaded from: classes8.dex */
public final class C6686r {

    /* renamed from: a */
    private static C6686r f31006a = new C6686r();

    /* renamed from: b */
    private final Map<String, Map<String, HuaweiApiClient>> f31007b = new HashMap();

    /* renamed from: c */
    private final Map<String, Map<String, HuaweiIdAuthService>> f31008c = new HashMap();

    private C6686r() {
    }

    /* renamed from: a */
    public HuaweiIdAuthService m37973a(String str, String str2) {
        synchronized (this.f31008c) {
            try {
                Map<String, HuaweiIdAuthService> map = this.f31008c.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public HuaweiApiClient m37977b(String str, String str2) {
        synchronized (this.f31007b) {
            try {
                Map<String, HuaweiApiClient> map = this.f31007b.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C6686r m37972a() {
        return f31006a;
    }

    /* renamed from: b */
    public void m37978b(String str) {
        synchronized (this.f31007b) {
            try {
                Map<String, HuaweiApiClient> mapRemove = this.f31007b.remove(str);
                if (mapRemove != null) {
                    Iterator<Map.Entry<String, HuaweiApiClient>> it = mapRemove.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next().getValue().disconnect();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m37974a(String str) {
        synchronized (this.f31008c) {
            this.f31008c.remove(str);
        }
    }

    /* renamed from: a */
    public void m37975a(String str, String str2, HuaweiApiClient huaweiApiClient) {
        synchronized (this.f31007b) {
            try {
                Map<String, HuaweiApiClient> map = this.f31007b.get(str);
                if (map == null) {
                    map = new HashMap<>();
                    this.f31007b.put(str, map);
                }
                map.put(str2, huaweiApiClient);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m37976a(String str, String str2, HuaweiIdAuthService huaweiIdAuthService) {
        synchronized (this.f31008c) {
            try {
                Map<String, HuaweiIdAuthService> map = this.f31008c.get(str);
                if (map == null) {
                    map = new HashMap<>();
                    this.f31008c.put(str, map);
                }
                map.put(str2, huaweiIdAuthService);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
