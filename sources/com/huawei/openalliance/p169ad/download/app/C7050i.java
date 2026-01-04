package com.huawei.openalliance.p169ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.app.RunnableC7057n;
import com.huawei.openalliance.p169ad.exception.C7110b;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7832k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.download.app.i */
/* loaded from: classes2.dex */
public class C7050i {

    /* renamed from: a */
    private static final Object f32434a = new Object();

    /* renamed from: e */
    private static C7050i f32435e;

    /* renamed from: b */
    private final Map<String, RunnableC7057n> f32436b = new ConcurrentHashMap();

    /* renamed from: c */
    private final a f32437c;

    /* renamed from: d */
    private final Context f32438d;

    /* renamed from: f */
    private c f32439f;

    /* renamed from: com.huawei.openalliance.ad.download.app.i$a */
    public static class a {

        /* renamed from: c */
        private final WeakReference<Context> f32450c;

        /* renamed from: a */
        private final String f32448a = "appInstallListener-task";

        /* renamed from: b */
        private final BroadcastReceiver f32449b = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.i.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                StringBuilder sb2;
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    SafeIntent safeIntent = new SafeIntent(intent);
                    String action = safeIntent.getAction();
                    AbstractC7185ho.m43821b("AppRestoreHandler", "itRe action: %s", action);
                    if ("android.intent.action.PACKAGE_ADDED".equals(action) && (data = safeIntent.getData()) != null) {
                        String schemeSpecificPart = data.getSchemeSpecificPart();
                        if (a.this.f32451d.containsKey(schemeSpecificPart)) {
                            a.this.m42458b(schemeSpecificPart);
                        }
                    }
                } catch (IllegalStateException e10) {
                    e = e10;
                    sb2 = new StringBuilder();
                    sb2.append("itRe:");
                    sb2.append(e.getClass().getSimpleName());
                    AbstractC7185ho.m43823c("AppRestoreHandler", sb2.toString());
                } catch (Exception e11) {
                    e = e11;
                    sb2 = new StringBuilder();
                    sb2.append("itRe:");
                    sb2.append(e.getClass().getSimpleName());
                    AbstractC7185ho.m43823c("AppRestoreHandler", sb2.toString());
                }
            }
        };

        /* renamed from: d */
        private final Map<String, List<d>> f32451d = new ConcurrentHashMap();

        public a(Context context) {
            this.f32450c = new WeakReference<>(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m42456b() {
            try {
                Context context = this.f32450c.get();
                if (context == null) {
                    return;
                }
                context.unregisterReceiver(this.f32449b);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("AppRestoreHandler", "unregister receiver failed");
            }
        }

        /* renamed from: c */
        private void m42459c() {
            AbstractC7768bo.m47810a("appInstallListener-task");
        }

        /* renamed from: d */
        private void m42460d() {
            m42459c();
            AbstractC7768bo.m47809a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.i.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.m42456b();
                }
            }, "appInstallListener-task", RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        }

        /* renamed from: a */
        private void m42454a() {
            Context context = this.f32450c.get();
            if (context == null) {
                return;
            }
            AbstractC7185ho.m43820b("AppRestoreHandler", "registerAppInstReceiver");
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            AbstractC7741ao.m47536a(context, this.f32449b, intentFilter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m42458b(final String str) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.i.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        List list = (List) a.this.f32451d.get(str);
                        if (AbstractC7760bg.m47767a(list)) {
                            return;
                        }
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((d) it.next()).mo42452a();
                        }
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c("AppRestoreHandler", "run callback task failed");
                    }
                }
            });
        }

        /* renamed from: a */
        public void m42461a(String str) {
            this.f32451d.remove(str);
            if (this.f32451d.isEmpty()) {
                m42459c();
                m42456b();
            }
        }

        /* renamed from: a */
        public void m42462a(String str, d dVar) {
            if (TextUtils.isEmpty(str) || dVar == null) {
                return;
            }
            List<d> arrayList = this.f32451d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(dVar);
            this.f32451d.put(str, arrayList);
            m42454a();
            m42460d();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.i$b */
    public interface b {
        /* renamed from: a */
        void mo42463a(AppDownloadTask appDownloadTask);
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.i$c */
    public interface c {
        /* renamed from: j */
        void mo42332j(AppDownloadTask appDownloadTask);

        /* renamed from: k */
        void mo42333k(AppDownloadTask appDownloadTask);

        /* renamed from: l */
        void mo42334l(AppDownloadTask appDownloadTask);
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.i$d */
    public interface d {
        /* renamed from: a */
        void mo42452a();
    }

    private C7050i(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new C7110b("AppRestoreHandler init failed");
        }
        Context applicationContext = context.getApplicationContext();
        this.f32438d = applicationContext;
        this.f32437c = new a(applicationContext);
    }

    /* renamed from: a */
    public static C7050i m42427a() {
        C7050i c7050i;
        synchronized (f32434a) {
            try {
                c7050i = f32435e;
                if (c7050i == null) {
                    throw new C7110b("AppRestoreHandler instance is not init!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7050i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m42442c(AppDownloadTask appDownloadTask) {
        appDownloadTask.m42054a(EnumC7062e.DOWNLOADING);
        appDownloadTask.m42059b(50);
        m42443d(appDownloadTask);
    }

    /* renamed from: d */
    private void m42443d(final AppDownloadTask appDownloadTask) {
        if (this.f32439f == null) {
            return;
        }
        if (appDownloadTask.m42077i() == EnumC7062e.INSTALLED) {
            appDownloadTask.m42248d(11);
            this.f32439f.mo42333k(appDownloadTask);
        } else if (appDownloadTask.m42077i() == EnumC7062e.DOWNLOADING || appDownloadTask.m42077i() == EnumC7062e.INSTALLING) {
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.i.3
                @Override // java.lang.Runnable
                public void run() {
                    if (C7050i.this.f32439f != null) {
                        C7050i.this.f32439f.mo42332j(appDownloadTask);
                    }
                }
            }, 50L);
        } else {
            this.f32439f.mo42334l(appDownloadTask);
        }
    }

    /* renamed from: b */
    private void m42438b(int i10, AppDownloadTask appDownloadTask, b bVar) {
        appDownloadTask.m42054a(i10 == 0 ? EnumC7062e.INSTALLED : EnumC7062e.WAITING);
        appDownloadTask.m42059b(0);
        if (bVar != null) {
            bVar.mo42463a(appDownloadTask);
        }
        m42443d(appDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42429a(int i10, AppDownloadTask appDownloadTask, b bVar) {
        try {
            try {
                AbstractC7185ho.m43821b("AppRestoreHandler", "restore finished, result:%s", Integer.valueOf(i10));
                this.f32437c.m42461a(appDownloadTask.m42222B().getPackageName());
                m42438b(i10, appDownloadTask, bVar);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("AppRestoreHandler", "handle restore result has exception");
            }
        } finally {
            this.f32436b.remove(appDownloadTask.mo42082n());
        }
    }

    /* renamed from: b */
    public void m42448b(AppDownloadTask appDownloadTask) {
        RunnableC7057n runnableC7057n;
        if (appDownloadTask == null || (runnableC7057n = this.f32436b.get(appDownloadTask.mo42082n())) == null) {
            return;
        }
        runnableC7057n.m42546c();
        AbstractC7768bo.m47810a(runnableC7057n.m42543a());
        AbstractC7768bo.m47807a(runnableC7057n);
    }

    /* renamed from: a */
    public static void m42430a(Context context) {
        synchronized (f32434a) {
            try {
                if (f32435e == null) {
                    f32435e = new C7050i(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    private void m42439b(final AppDownloadTask appDownloadTask, final b bVar) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.i.1
            @Override // java.lang.Runnable
            public void run() {
                C7050i.this.m42442c(appDownloadTask);
                RunnableC7057n runnableC7057n = new RunnableC7057n(appDownloadTask.mo42082n(), new RunnableC7057n.a() { // from class: com.huawei.openalliance.ad.download.app.i.1.1
                    @Override // com.huawei.openalliance.p169ad.download.app.RunnableC7057n.a
                    /* renamed from: a */
                    public void mo42449a(int i10) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        C7050i.this.m42429a(i10, appDownloadTask, bVar);
                    }

                    @Override // com.huawei.openalliance.p169ad.download.app.RunnableC7057n.a
                    /* renamed from: b */
                    public void mo42451b(RunnableC7057n runnableC7057n2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        C7050i.this.m42434a(runnableC7057n2, appDownloadTask);
                    }

                    @Override // com.huawei.openalliance.p169ad.download.app.RunnableC7057n.a
                    /* renamed from: a */
                    public void mo42450a(RunnableC7057n runnableC7057n2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        C7050i.this.m42441b(runnableC7057n2, appDownloadTask);
                    }
                });
                C7050i.this.f32436b.put(appDownloadTask.mo42082n(), runnableC7057n);
                AbstractC7768bo.m47809a(runnableC7057n, runnableC7057n.m42543a(), 2500L);
            }
        });
    }

    /* renamed from: a */
    public void m42444a(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        m42435a(appDownloadTask.mo42082n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m42441b(RunnableC7057n runnableC7057n, AppDownloadTask appDownloadTask) {
        m42436a(appDownloadTask.m42222B().getPackageName(), runnableC7057n);
        appDownloadTask.m42054a(EnumC7062e.INSTALLING);
        m42443d(appDownloadTask);
    }

    /* renamed from: a */
    public synchronized void m42445a(AppDownloadTask appDownloadTask, b bVar) {
        if (appDownloadTask != null) {
            if (appDownloadTask.m42222B() != null) {
                if (!C7832k.m48465a().m48469a(this.f32438d)) {
                    appDownloadTask.m42054a(EnumC7062e.FAILED);
                    if (bVar != null) {
                        bVar.mo42463a(appDownloadTask);
                    }
                    return;
                } else if (this.f32436b.containsKey(appDownloadTask.mo42082n())) {
                    AbstractC7185ho.m43823c("AppRestoreHandler", "task already in restore processing");
                    return;
                } else {
                    m42439b(appDownloadTask, bVar);
                    return;
                }
            }
        }
        AbstractC7185ho.m43823c("AppRestoreHandler", "task cant be null");
    }

    /* renamed from: a */
    public void m42446a(c cVar) {
        this.f32439f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42434a(RunnableC7057n runnableC7057n, AppDownloadTask appDownloadTask) {
        int iM48468a = C7832k.m48465a().m48468a(this.f32438d, appDownloadTask);
        AbstractC7185ho.m43821b("AppRestoreHandler", "remote ret:%s", Integer.valueOf(iM48468a));
        if (runnableC7057n != null) {
            runnableC7057n.m42544a(iM48468a);
        }
    }

    /* renamed from: a */
    public void m42447a(AppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        m42435a(appInfo.getPackageName());
        this.f32436b.remove(appInfo.getPackageName());
    }

    /* renamed from: a */
    private void m42435a(String str) {
        RunnableC7057n runnableC7057n = this.f32436b.get(str);
        if (runnableC7057n == null) {
            return;
        }
        runnableC7057n.m42545b();
        AbstractC7768bo.m47810a(runnableC7057n.m42543a());
    }

    /* renamed from: a */
    private void m42436a(String str, final RunnableC7057n runnableC7057n) {
        this.f32437c.m42462a(str, new d() { // from class: com.huawei.openalliance.ad.download.app.i.2
            @Override // com.huawei.openalliance.p169ad.download.app.C7050i.d
            /* renamed from: a */
            public void mo42452a() {
                RunnableC7057n runnableC7057n2 = runnableC7057n;
                if (runnableC7057n2 != null) {
                    runnableC7057n2.m42544a(0);
                }
            }
        });
    }
}
