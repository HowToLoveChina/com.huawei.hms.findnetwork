package com.huawei.openalliance.p169ad;

import com.huawei.hms.ads.jsb.inner.data.WebInfo;
import com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.aq */
/* loaded from: classes8.dex */
public abstract class AbstractC6939aq extends AbstractC7326j {

    /* renamed from: com.huawei.openalliance.ad.aq$a */
    public static class a<K, V> extends LinkedHashMap<K, V> {

        /* renamed from: a */
        private final int f31980a;

        public a(int i10) {
            this.f31980a = i10;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.f31980a;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.aq$b */
    public static class b implements IPPSWebEventCallback {

        /* renamed from: a */
        private String f31981a;

        /* renamed from: b */
        private Map<String, RemoteCallResultCallback<String>> f31982b = Collections.synchronizedMap(new a(5));

        /* renamed from: c */
        private Map<String, RemoteCallResultCallback<String>> f31983c = Collections.synchronizedMap(new a(5));

        /* renamed from: d */
        private Map<String, RemoteCallResultCallback<String>> f31984d = Collections.synchronizedMap(new a(5));

        public b() {
            AbstractC7185ho.m43817a("JsbOnWebChange", "WebListener init");
        }

        /* renamed from: a */
        public void m39234a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31982b.put(str2, remoteCallResultCallback);
            this.f31981a = str;
        }

        /* renamed from: b */
        public void m39235b(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31983c.put(str2, remoteCallResultCallback);
            this.f31981a = str;
        }

        /* renamed from: c */
        public void m39236c(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31984d.put(str2, remoteCallResultCallback);
            this.f31981a = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback
        public void onWebClose(int i10) {
            m39233a(this.f31983c, new WebInfo(i10));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback
        public void onWebOpen() {
            m39233a(this.f31982b, new WebInfo());
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback
        public void onWebloadFinish() {
            m39233a(this.f31984d, new WebInfo());
        }

        /* renamed from: a */
        private void m39233a(Map<String, RemoteCallResultCallback<String>> map, WebInfo webInfo) {
            RemoteCallResultCallback<String> value;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, RemoteCallResultCallback<String>> entry : map.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    AbstractC7326j.m45216a(value, this.f31981a, 1000, AbstractC7758be.m47742b(webInfo), false);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.aq$c */
    public static class c {

        /* renamed from: a */
        private static b f31985a = new b();

        static {
            AbstractC7185ho.m43817a("JsbOnWebChange", "register global Jsb Web Listener.");
            C7517nl.m46150a().m46152b(f31985a);
        }
    }

    public AbstractC6939aq(String str) {
        super(str);
    }

    /* renamed from: b */
    public b m39232b() {
        return c.f31985a;
    }
}
