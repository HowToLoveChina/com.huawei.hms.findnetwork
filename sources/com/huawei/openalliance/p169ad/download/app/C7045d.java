package com.huawei.openalliance.p169ad.download.app;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.huawei.openalliance.ad.download.app.d */
/* loaded from: classes2.dex */
public class C7045d implements AutoOpenListener, AppDownloadListener, AppDownloadListenerV1 {

    /* renamed from: a */
    private Map<String, AppDownloadListener> f32389a;

    /* renamed from: b */
    private Map<String, AppDownloadListenerV1> f32390b;

    /* renamed from: c */
    private Map<String, AutoOpenListener> f32391c;

    /* renamed from: d */
    private final CopyOnWriteArraySet<AppDownloadListener> f32392d;

    /* renamed from: com.huawei.openalliance.ad.download.app.d$1 */
    public class AnonymousClass1 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ AppInfo f32393a;

        public AnonymousClass1(AppInfo appInfo) {
            appInfo = appInfo;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            for (AutoOpenListener autoOpenListener : C7045d.this.f32391c.values()) {
                if (autoOpenListener != null && !autoOpenListener.isNeedAutoOpen(appInfo)) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.d$a */
    public static class a {

        /* renamed from: a */
        private static final C7045d f32395a = new C7045d();
    }

    private C7045d() {
        this.f32389a = new ConcurrentHashMap();
        this.f32390b = new ConcurrentHashMap();
        this.f32391c = new ConcurrentHashMap();
        this.f32392d = new CopyOnWriteArraySet<>();
        C7046e.m42377h().m42390a((AppDownloadListener) this);
        C7046e.m42377h().m42391a((AppDownloadListenerV1) this);
        C7046e.m42377h().m42387a((AutoOpenListener) this);
    }

    /* renamed from: a */
    public static C7045d m42344a() {
        return a.f32395a;
    }

    /* renamed from: b */
    public Map<String, AutoOpenListener> m42349b() {
        return this.f32391c;
    }

    /* renamed from: c */
    public void m42352c(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.f32392d.remove(appDownloadListener);
    }

    /* renamed from: d */
    public void m42353d(AppDownloadListener appDownloadListener) {
        Map<String, AppDownloadListener> map = this.f32389a;
        if (appDownloadListener == null) {
            map.remove("jsb_listener_key");
        } else {
            map.put("jsb_listener_key", appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener
    public boolean isNeedAutoOpen(AppInfo appInfo) {
        try {
            return ((Boolean) AbstractC7810dc.m48268a(new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.download.app.d.1

                /* renamed from: a */
                final /* synthetic */ AppInfo f32393a;

                public AnonymousClass1(AppInfo appInfo2) {
                    appInfo = appInfo2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() {
                    for (AutoOpenListener autoOpenListener : C7045d.this.f32391c.values()) {
                        if (autoOpenListener != null && !autoOpenListener.isNeedAutoOpen(appInfo)) {
                            return Boolean.FALSE;
                        }
                    }
                    return Boolean.TRUE;
                }
            }, 100L, Boolean.TRUE)).booleanValue();
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("AppDownloadListenerRegister", "AutoOpen err: " + th2.getClass().getSimpleName());
            return true;
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onAppOpen(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.f32389a.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.onAppOpen(appInfo);
            }
        }
        Iterator<AppDownloadListener> it = this.f32392d.iterator();
        while (it.hasNext()) {
            AppDownloadListener next = it.next();
            if (next != null) {
                next.onAppOpen(appInfo);
            }
        }
        onNewAppOpen(appInfo);
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onDownloadProgress(AppInfo appInfo, int i10) {
        for (AppDownloadListener appDownloadListener : this.f32389a.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.onDownloadProgress(appInfo, i10);
            }
        }
        onNewDownloadProgress(appInfo, i10);
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
    public void onNewAppOpen(AppInfo appInfo) {
        for (AppDownloadListenerV1 appDownloadListenerV1 : this.f32390b.values()) {
            if (appDownloadListenerV1 != null) {
                appDownloadListenerV1.onNewAppOpen(appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
    public void onNewDownloadProgress(AppInfo appInfo, int i10) {
        for (AppDownloadListenerV1 appDownloadListenerV1 : this.f32390b.values()) {
            if (appDownloadListenerV1 != null) {
                appDownloadListenerV1.onNewDownloadProgress(appInfo, i10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
    public void onNewStatusChanged(AppStatusV1 appStatusV1, int i10, AppInfo appInfo) {
        for (AppDownloadListenerV1 appDownloadListenerV1 : this.f32390b.values()) {
            if (appDownloadListenerV1 != null) {
                appDownloadListenerV1.onNewStatusChanged(appStatusV1, i10, appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.f32389a.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.onStatusChanged(appStatus, appInfo);
            }
        }
        Iterator<AppDownloadListener> it = this.f32392d.iterator();
        while (it.hasNext()) {
            AppDownloadListener next = it.next();
            if (next != null) {
                next.onStatusChanged(appStatus, appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onUserCancel(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.f32389a.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.onUserCancel(appInfo);
            }
        }
    }

    public /* synthetic */ C7045d(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* renamed from: b */
    public void m42350b(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.f32392d.add(appDownloadListener);
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onAppOpen(String str) {
        for (AppDownloadListener appDownloadListener : this.f32389a.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.onAppOpen(str);
            }
        }
        Iterator<AppDownloadListener> it = this.f32392d.iterator();
        while (it.hasNext()) {
            AppDownloadListener next = it.next();
            if (next != null) {
                next.onAppOpen(str);
            }
        }
        onNewAppOpen(str);
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1
    public void onNewAppOpen(String str) {
        for (AppDownloadListenerV1 appDownloadListenerV1 : this.f32390b.values()) {
            if (appDownloadListenerV1 != null) {
                appDownloadListenerV1.onNewAppOpen(str);
            }
        }
    }

    /* renamed from: a */
    public void m42346a(AutoOpenListener autoOpenListener) {
        Map<String, AutoOpenListener> map = this.f32391c;
        if (autoOpenListener == null) {
            map.remove("outer_listener_key");
        } else {
            map.put("outer_listener_key", autoOpenListener);
        }
    }

    /* renamed from: b */
    public void m42351b(AppDownloadListenerV1 appDownloadListenerV1) {
        Map<String, AppDownloadListenerV1> map = this.f32390b;
        if (appDownloadListenerV1 == null) {
            map.remove("jsb_listener_key");
        } else {
            map.put("jsb_listener_key", appDownloadListenerV1);
        }
    }

    /* renamed from: a */
    public void m42347a(AppDownloadListener appDownloadListener) {
        Map<String, AppDownloadListener> map = this.f32389a;
        if (appDownloadListener == null) {
            map.remove("outer_listener_key");
        } else {
            map.put("outer_listener_key", appDownloadListener);
        }
    }

    /* renamed from: a */
    public void m42348a(AppDownloadListenerV1 appDownloadListenerV1) {
        Map<String, AppDownloadListenerV1> map = this.f32390b;
        if (appDownloadListenerV1 == null) {
            map.remove("outer_listener_key");
        } else {
            map.put("outer_listener_key", appDownloadListenerV1);
        }
    }
}
