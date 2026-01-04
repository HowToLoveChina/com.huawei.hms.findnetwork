package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.AppStatusV1;
import com.huawei.openalliance.p169ad.download.app.C7045d;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.C7831j;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.an */
/* loaded from: classes8.dex */
public abstract class AbstractC6919an extends AbstractC6912ag {

    /* renamed from: com.huawei.openalliance.ad.an$a */
    public static class a {

        /* renamed from: a */
        private static d f31819a = new d();

        static {
            AbstractC7185ho.m43817a("JsbOnDownloadChange", "register global Jsb browser app download Listener.");
            C7045d.m42344a().m42351b(f31819a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.an$b */
    public static class b implements AppDownloadListener {

        /* renamed from: a */
        private String f31820a;

        /* renamed from: b */
        private String f31821b;

        /* renamed from: c */
        private String f31822c;

        /* renamed from: d */
        private String f31823d;

        /* renamed from: e */
        private int f31824e = 20;

        /* renamed from: f */
        private Map<String, RemoteCallResultCallback<String>> f31825f = Collections.synchronizedMap(new e(this.f31824e));

        /* renamed from: g */
        private Map<String, RemoteCallResultCallback<String>> f31826g = Collections.synchronizedMap(new e(this.f31824e));

        /* renamed from: h */
        private Map<String, RemoteCallResultCallback<String>> f31827h = Collections.synchronizedMap(new e(this.f31824e));

        /* renamed from: i */
        private Map<String, RemoteCallResultCallback<String>> f31828i = Collections.synchronizedMap(new e(this.f31824e));

        public b() {
            AbstractC7185ho.m43817a("JsbOnDownloadChange", "DownloadListener init");
        }

        /* renamed from: a */
        public void m38804a(int i10) {
            this.f31824e = i10;
        }

        /* renamed from: b */
        public void m38807b(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            AbstractC7185ho.m43821b("JsbOnDownloadChange", "add app progress cb %s", str2);
            this.f31826g.put(str2, remoteCallResultCallback);
            this.f31821b = str;
        }

        /* renamed from: c */
        public void m38808c(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31827h.put(str2, remoteCallResultCallback);
            this.f31822c = str;
        }

        /* renamed from: d */
        public void m38809d(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31828i.put(str2, remoteCallResultCallback);
            this.f31823d = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
            Map<String, RemoteCallResultCallback<String>> map = this.f31827h;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.f31827h.values()) {
                if (remoteCallResultCallback != null) {
                    AbstractC7326j.m45216a(remoteCallResultCallback, this.f31822c, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, AppStatus.INSTALLED)), false);
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onDownloadProgress(AppInfo appInfo, int i10) {
            AppDownloadTask appDownloadTaskM42405d = C7046e.m42377h().m42405d(appInfo);
            if (appDownloadTaskM42405d != null) {
                onStatusChanged(C7831j.m48451a(appDownloadTaskM42405d), appInfo);
            }
            Map<String, RemoteCallResultCallback<String>> map = this.f31826g;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> it = this.f31826g.values().iterator();
            while (it.hasNext()) {
                AbstractC7326j.m45216a(it.next(), this.f31821b, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, i10)), false);
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
            RemoteCallResultCallback<String> value;
            Map<String, RemoteCallResultCallback<String>> map = this.f31825f;
            if (map == null || map.size() <= 0) {
                AbstractC7185ho.m43823c("JsbOnDownloadChange", "status map is null");
                return;
            }
            for (Map.Entry<String, RemoteCallResultCallback<String>> entry : this.f31825f.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    AbstractC7326j.m45216a(value, this.f31820a, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, appStatus)), false);
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onUserCancel(AppInfo appInfo) {
            Map<String, RemoteCallResultCallback<String>> map;
            if (appInfo == null || (map = this.f31828i) == null || map.size() == 0) {
                return;
            }
            AbstractC7185ho.m43821b("JsbOnDownloadChange", "onUserCancel, app: %s", appInfo.getPackageName());
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.f31828i.values()) {
                if (remoteCallResultCallback != null) {
                    AbstractC7326j.m45216a(remoteCallResultCallback, this.f31823d, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, AppStatus.DOWNLOAD)), false);
                }
            }
        }

        /* renamed from: a */
        public void m38805a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            AbstractC7185ho.m43821b("JsbOnDownloadChange", "add app status cb %s", str2);
            this.f31825f.put(str2, remoteCallResultCallback);
            this.f31820a = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(String str) {
        }

        /* renamed from: a */
        public void m38806a(String str) {
            if (str == null) {
                return;
            }
            AbstractC7185ho.m43821b("JsbOnDownloadChange", "remove app status cb %s", str);
            this.f31825f.remove(str);
            this.f31826g.remove(str);
            this.f31827h.remove(str);
            this.f31828i.remove(str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.an$c */
    public static class c {

        /* renamed from: a */
        private static b f31829a = new b();

        static {
            AbstractC7185ho.m43817a("JsbOnDownloadChange", "register global Jsb app download Listener.");
            C7045d.m42344a().m42353d(f31829a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.an$d */
    public static class d implements AppDownloadListenerV1 {

        /* renamed from: a */
        private String f31830a;

        /* renamed from: b */
        private String f31831b;

        /* renamed from: c */
        private String f31832c;

        /* renamed from: d */
        private Map<String, RemoteCallResultCallback<String>> f31833d = Collections.synchronizedMap(new e(5));

        /* renamed from: e */
        private Map<String, RemoteCallResultCallback<String>> f31834e = Collections.synchronizedMap(new e(5));

        /* renamed from: f */
        private Map<String, RemoteCallResultCallback<String>> f31835f = Collections.synchronizedMap(new e(5));

        public d() {
            AbstractC7185ho.m43817a("JsbOnDownloadChange", "BrowserDownloadListener init");
        }

        /* renamed from: a */
        public void m38811a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31833d.put(str2, remoteCallResultCallback);
            this.f31830a = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
        public void onNewAppOpen(AppInfo appInfo) {
            Map<String, RemoteCallResultCallback<String>> map = this.f31835f;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.f31835f.values()) {
                if (remoteCallResultCallback != null) {
                    AbstractC7326j.m45216a(remoteCallResultCallback, this.f31832c, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, AppStatus.INSTALLED)), false);
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
        public void onNewDownloadProgress(AppInfo appInfo, int i10) {
            Map<String, RemoteCallResultCallback<String>> map = this.f31834e;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> it = this.f31834e.values().iterator();
            while (it.hasNext()) {
                AbstractC7326j.m45216a(it.next(), this.f31831b, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, i10)), false);
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
        public void onNewStatusChanged(AppStatusV1 appStatusV1, int i10, AppInfo appInfo) {
            RemoteCallResultCallback<String> value;
            Map<String, RemoteCallResultCallback<String>> map = this.f31833d;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, RemoteCallResultCallback<String>> entry : this.f31833d.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    AbstractC7326j.m45216a(value, this.f31830a, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(appInfo, appStatusV1, i10)), false);
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
        public void onNewAppOpen(String str) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.an$e */
    public static class e<K, V> extends LinkedHashMap<K, V> {

        /* renamed from: a */
        private final int f31836a;

        public e(int i10) {
            this.f31836a = i10;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.f31836a;
        }
    }

    public AbstractC6919an(String str) {
        super(str);
    }

    /* renamed from: b */
    public b m38800b() {
        return c.f31829a;
    }

    /* renamed from: c */
    public d m38802c() {
        return a.f31819a;
    }

    /* renamed from: b */
    public b m38801b(Context context) {
        c.f31829a.m38804a(C7124fh.m43316b(context).mo43084r());
        return c.f31829a;
    }
}
