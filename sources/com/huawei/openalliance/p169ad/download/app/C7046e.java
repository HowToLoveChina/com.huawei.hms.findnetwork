package com.huawei.openalliance.p169ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7673sv;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.C7059b;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.C7050i;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.download.p172ag.C7036d;
import com.huawei.openalliance.p169ad.download.p172ag.C7037e;
import com.huawei.openalliance.p169ad.exception.C7110b;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.download.app.e */
/* loaded from: classes2.dex */
public class C7046e extends C7059b<AppDownloadTask> {

    /* renamed from: f */
    private static final byte[] f32396f = new byte[0];

    /* renamed from: g */
    private static C7046e f32397g;

    /* renamed from: h */
    private a f32398h;

    /* renamed from: i */
    private AppDownloadListenerV1 f32399i;

    /* renamed from: j */
    private AutoOpenListener f32400j;

    /* renamed from: k */
    private C7043b f32401k;

    /* renamed from: l */
    private BroadcastReceiver f32402l;

    /* renamed from: com.huawei.openalliance.ad.download.app.e$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f32403a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((C7059b) C7046e.this).f32506b = C7046e.m42369c(context);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.e$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7046e.this.m42384m();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.e$3 */
    public class AnonymousClass3 implements Callable<AppDownloadTask> {

        /* renamed from: a */
        final /* synthetic */ AppInfo f32406a;

        public AnonymousClass3(AppInfo appInfo) {
            appInfo = appInfo;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AppDownloadTask call() {
            return C7046e.this.m42381j(appInfo);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.e$4 */
    public class AnonymousClass4 implements Callable<String> {
        public AnonymousClass4() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            return C7046e.m42369c(((C7059b) C7046e.this).f32505a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.e$5 */
    public class AnonymousClass5 implements Callable<String> {
        public AnonymousClass5() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            return C7046e.m42369c(((C7059b) C7046e.this).f32505a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.e$6 */
    public class AnonymousClass6 extends BroadcastReceiver {

        /* renamed from: com.huawei.openalliance.ad.download.app.e$6$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f32411a;

            public AnonymousClass1(Context context) {
                context = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                    C7046e.this.m42383l();
                } else {
                    if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                        return;
                    }
                    C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                }
            }
        }

        public AnonymousClass6() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AppDownloadManager", "netReceiver.onReceive, action:%s", intent.getAction());
            }
            Context applicationContext = context.getApplicationContext();
            if (C7124fh.m43316b(applicationContext).mo43345aL()) {
                AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.6.1

                    /* renamed from: a */
                    final /* synthetic */ Context f32411a;

                    public AnonymousClass1(Context applicationContext2) {
                        context = applicationContext2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                            C7046e.this.m42383l();
                        } else {
                            if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                return;
                            }
                            C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                        }
                    }
                });
            } else {
                AbstractC7185ho.m43820b("AppDownloadManager", "user info is not enabled");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.e$a */
    public class a {

        /* renamed from: b */
        private final Context f32414b;

        /* renamed from: c */
        private ConnectivityManager.NetworkCallback f32415c = new ConnectivityManager.NetworkCallback() { // from class: com.huawei.openalliance.ad.download.app.e.a.1

            /* renamed from: com.huawei.openalliance.ad.download.app.e$a$1$1 */
            public class RunnableC144541 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Context f32417a;

                public RunnableC144541(Context context) {
                    context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                        C7046e.this.m42383l();
                    } else {
                        if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                            return;
                        }
                        C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                    }
                }
            }

            /* renamed from: com.huawei.openalliance.ad.download.app.e$a$1$2 */
            public class AnonymousClass2 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Context f32419a;

                public AnonymousClass2(Context context) {
                    context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                        C7046e.this.m42383l();
                    } else {
                        if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                            return;
                        }
                        C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                Context applicationContext = a.this.f32414b.getApplicationContext();
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AppDownloadManager", "net onAvailable, active netType: %s, [0:UNKNOWN, 1:ETHERNET, 2:WIFI, 4/5/6/7:2G/3G/4G/5G]", Integer.valueOf(C7775bv.m47830d(applicationContext)));
                }
                if (C7124fh.m43316b(applicationContext).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.a.1.1

                        /* renamed from: a */
                        final /* synthetic */ Context f32417a;

                        public RunnableC144541(Context applicationContext2) {
                            context = applicationContext2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                C7046e.this.m42383l();
                            } else {
                                if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                    return;
                                }
                                C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("AppDownloadManager", "user info is not enabled");
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                Context applicationContext = a.this.f32414b.getApplicationContext();
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AppDownloadManager", "net onLost, active netType: %s, [0:UNKNOWN, 1:ETHERNET, 2:WIFI, 4/5/6/7:2G/3G/4G/5G]", Integer.valueOf(C7775bv.m47830d(applicationContext)));
                }
                if (C7124fh.m43316b(applicationContext).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.a.1.2

                        /* renamed from: a */
                        final /* synthetic */ Context f32419a;

                        public AnonymousClass2(Context applicationContext2) {
                            context = applicationContext2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                C7046e.this.m42383l();
                            } else {
                                if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                    return;
                                }
                                C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("AppDownloadManager", "user info is not enabled");
                }
            }
        };

        /* renamed from: com.huawei.openalliance.ad.download.app.e$a$1 */
        public class AnonymousClass1 extends ConnectivityManager.NetworkCallback {

            /* renamed from: com.huawei.openalliance.ad.download.app.e$a$1$1 */
            public class RunnableC144541 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Context f32417a;

                public RunnableC144541(Context applicationContext2) {
                    context = applicationContext2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                        C7046e.this.m42383l();
                    } else {
                        if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                            return;
                        }
                        C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                    }
                }
            }

            /* renamed from: com.huawei.openalliance.ad.download.app.e$a$1$2 */
            public class AnonymousClass2 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Context f32419a;

                public AnonymousClass2(Context applicationContext2) {
                    context = applicationContext2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                        C7046e.this.m42383l();
                    } else {
                        if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                            return;
                        }
                        C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                Context applicationContext2 = a.this.f32414b.getApplicationContext();
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AppDownloadManager", "net onAvailable, active netType: %s, [0:UNKNOWN, 1:ETHERNET, 2:WIFI, 4/5/6/7:2G/3G/4G/5G]", Integer.valueOf(C7775bv.m47830d(applicationContext2)));
                }
                if (C7124fh.m43316b(applicationContext2).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.a.1.1

                        /* renamed from: a */
                        final /* synthetic */ Context f32417a;

                        public RunnableC144541(Context applicationContext22) {
                            context = applicationContext22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                C7046e.this.m42383l();
                            } else {
                                if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                    return;
                                }
                                C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("AppDownloadManager", "user info is not enabled");
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                Context applicationContext2 = a.this.f32414b.getApplicationContext();
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AppDownloadManager", "net onLost, active netType: %s, [0:UNKNOWN, 1:ETHERNET, 2:WIFI, 4/5/6/7:2G/3G/4G/5G]", Integer.valueOf(C7775bv.m47830d(applicationContext2)));
                }
                if (C7124fh.m43316b(applicationContext2).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.a.1.2

                        /* renamed from: a */
                        final /* synthetic */ Context f32419a;

                        public AnonymousClass2(Context applicationContext22) {
                            context = applicationContext22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                C7046e.this.m42383l();
                            } else {
                                if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                    return;
                                }
                                C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("AppDownloadManager", "user info is not enabled");
                }
            }
        }

        public a(Context context) {
            this.f32414b = context;
        }

        /* renamed from: a */
        public void m42416a() {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f32414b.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0).addTransportType(3).addTransportType(1);
                connectivityManager.registerNetworkCallback(builder.build(), this.f32415c);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("AppDownloadManager", "register all network callback exception.");
            }
        }
    }

    private C7046e(Context context) {
        String str;
        super(context);
        this.f32402l = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.6

            /* renamed from: com.huawei.openalliance.ad.download.app.e$6$1 */
            public class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Context f32411a;

                public AnonymousClass1(Context applicationContext2) {
                    context = applicationContext2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                        C7046e.this.m42383l();
                    } else {
                        if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                            return;
                        }
                        C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                    }
                }
            }

            public AnonymousClass6() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AppDownloadManager", "netReceiver.onReceive, action:%s", intent.getAction());
                }
                Context applicationContext2 = context2.getApplicationContext();
                if (C7124fh.m43316b(applicationContext2).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.6.1

                        /* renamed from: a */
                        final /* synthetic */ Context f32411a;

                        public AnonymousClass1(Context applicationContext22) {
                            context = applicationContext22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                C7046e.this.m42383l();
                            } else {
                                if (C7775bv.m47831e(context) && C7775bv.m47829c(context)) {
                                    return;
                                }
                                C7046e.this.m42386a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("AppDownloadManager", "user info is not enabled");
                }
            }
        };
        try {
            super.m42551a();
            C7043b c7043b = new C7043b(context);
            this.f32401k = c7043b;
            super.m42555a(c7043b);
            C7050i.m42430a(context);
            C7050i.m42427a().m42446a(this.f32401k);
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.1

                /* renamed from: a */
                final /* synthetic */ Context f32403a;

                public AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((C7059b) C7046e.this).f32506b = C7046e.m42369c(context);
                }
            });
            a aVar = new a(this.f32505a);
            this.f32398h = aVar;
            aVar.m42416a();
        } catch (IllegalStateException unused) {
            str = "init IllegalStateException";
            AbstractC7185ho.m43823c("AppDownloadManager", str);
        } catch (Exception unused2) {
            str = "init exception";
            AbstractC7185ho.m43823c("AppDownloadManager", str);
        }
    }

    /* renamed from: g */
    private boolean m42375g(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return false;
        }
        while (appDownloadTask.m42230J()) {
            AbstractC7185ho.m43821b("AppDownloadManager", "switch next install way succ, curInstallWay:%s", appDownloadTask.m42228H());
            if (!appDownloadTask.m42231K() || AbstractC7741ao.m47568c(this.f32505a)) {
                return true;
            }
        }
        AbstractC7185ho.m43821b("AppDownloadManager", "switch next install way fail, curInstallWay:%s", appDownloadTask.m42228H());
        return false;
    }

    /* renamed from: h */
    public static C7046e m42377h() {
        C7046e c7046e;
        synchronized (f32396f) {
            try {
                c7046e = f32397g;
                if (c7046e == null) {
                    throw new C7110b("AppDownloadManager instance is not init!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7046e;
    }

    /* renamed from: j */
    public AppDownloadTask m42381j(AppInfo appInfo) {
        AppDownloadTask appDownloadTaskM42382k;
        boolean z10;
        if (appInfo == null || (appDownloadTaskM42382k = m42382k(appInfo)) == null) {
            return null;
        }
        File file = new File(appDownloadTaskM42382k.m42068d());
        if (file.exists()) {
            z10 = false;
        } else {
            file = new File(appDownloadTaskM42382k.m42071e());
            if (!file.exists()) {
                return null;
            }
            z10 = true;
        }
        return m42357a(appInfo, appDownloadTaskM42382k, file, z10);
    }

    /* renamed from: k */
    private AppDownloadTask m42382k(AppInfo appInfo) {
        return new AppDownloadTask.C7040a().m42268a(false).m42265a(appInfo).m42267a(m42407e(appInfo)).m42270b(m42408f(appInfo)).m42269a();
    }

    /* renamed from: l */
    public void m42383l() {
        List<AppDownloadTask> listM42588c = this.f32509e.m42588c();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AppDownloadManager", "resumeAllTask, task.size:%d", Integer.valueOf(listM42588c.size()));
        }
        if (listM42588c.size() <= 0) {
            return;
        }
        m42364a(listM42588c);
    }

    /* renamed from: m */
    public void m42384m() {
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f32506b);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("tmp");
            sb2.append(str2);
            String string = sb2.toString();
            String[] list = new File(string).list();
            if (list != null && list.length > 0) {
                m42363a(string, list);
            }
        } catch (RuntimeException unused) {
            str = "deleteTimeoutFile RuntimeException";
            AbstractC7185ho.m43823c("AppDownloadManager", str);
        } catch (Exception unused2) {
            str = "deleteTimeoutFile exception";
            AbstractC7185ho.m43823c("AppDownloadManager", str);
        }
    }

    /* renamed from: d */
    public AppDownloadTask m42405d(AppInfo appInfo) {
        if (!m42380i(appInfo)) {
            if (m42376g(appInfo)) {
                return null;
            }
            AppDownloadTask appDownloadTaskMo42385a = mo42385a(appInfo.getPackageName());
            return appDownloadTaskMo42385a == null ? (AppDownloadTask) AbstractC7810dc.m48272b(new Callable<AppDownloadTask>() { // from class: com.huawei.openalliance.ad.download.app.e.3

                /* renamed from: a */
                final /* synthetic */ AppInfo f32406a;

                public AnonymousClass3(AppInfo appInfo2) {
                    appInfo = appInfo2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public AppDownloadTask call() {
                    return C7046e.this.m42381j(appInfo);
                }
            }) : appDownloadTaskMo42385a;
        }
        AppDownloadTask appDownloadTaskM42179b = C7036d.m42166a(this.f32505a).m42179b(appInfo2);
        if (appDownloadTaskM42179b == null && "11".equals(appInfo2.getPriorInstallWay())) {
            appDownloadTaskM42179b = mo42385a(appInfo2.getPackageName());
        }
        if (appDownloadTaskM42179b != null) {
            m42361a(appInfo2, appDownloadTaskM42179b);
            appDownloadTaskM42179b.m42243a(appInfo2);
        }
        return appDownloadTaskM42179b;
    }

    /* renamed from: e */
    public String m42407e(AppInfo appInfo) {
        if (TextUtils.isEmpty(this.f32506b)) {
            this.f32506b = (String) AbstractC7810dc.m48272b(new Callable<String>() { // from class: com.huawei.openalliance.ad.download.app.e.4
                public AnonymousClass4() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public String call() {
                    return C7046e.m42369c(((C7059b) C7046e.this).f32505a);
                }
            });
        }
        return this.f32506b + File.separator + appInfo.getPackageName() + ".apk";
    }

    /* renamed from: f */
    public String m42408f(AppInfo appInfo) {
        if (TextUtils.isEmpty(this.f32506b)) {
            this.f32506b = (String) AbstractC7810dc.m48272b(new Callable<String>() { // from class: com.huawei.openalliance.ad.download.app.e.5
                public AnonymousClass5() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public String call() {
                    return C7046e.m42369c(((C7059b) C7046e.this).f32505a);
                }
            });
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f32506b);
        String str = File.separator;
        sb2.append(str);
        sb2.append("tmp");
        sb2.append(str);
        sb2.append(appInfo.getPackageName());
        sb2.append(".apk");
        return sb2.toString();
    }

    /* renamed from: i */
    public AppDownloadListenerV1 m42409i() {
        return this.f32399i;
    }

    /* renamed from: c */
    public static String m42369c(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractC7803cw.m48133c(context));
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        sb2.append("apk");
        return sb2.toString();
    }

    /* renamed from: d */
    private String m42371d(String str) {
        int iIndexOf = str.indexOf(".apk");
        if (iIndexOf > 0) {
            return str.substring(0, iIndexOf);
        }
        return null;
    }

    /* renamed from: e */
    private boolean m42373e(AppDownloadTask appDownloadTask) {
        return "11".equals(appDownloadTask.m42228H());
    }

    /* renamed from: f */
    private void m42374f(AppDownloadTask appDownloadTask) {
        C7043b c7043b = this.f32401k;
        if (c7043b != null) {
            c7043b.m42328f(appDownloadTask);
        }
    }

    /* renamed from: g */
    private static boolean m42376g(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        if ("11".equals(appInfo.getPriorInstallWay())) {
            return false;
        }
        return TextUtils.isEmpty(appInfo.getPackageName()) || TextUtils.isEmpty(appInfo.getDownloadUrl()) || m42379h(appInfo) || appInfo.getFileSize() <= 0;
    }

    /* renamed from: h */
    private boolean m42378h(AppDownloadTask appDownloadTask) {
        ContentRecord contentRecordM42239S = appDownloadTask.m42239S();
        if (contentRecordM42239S != null) {
            return new C7673sv(this.f32505a, contentRecordM42239S).mo47233a();
        }
        return false;
    }

    /* renamed from: i */
    private boolean m42380i(AppInfo appInfo) {
        AppDownloadTask appDownloadTaskMo42385a;
        return (appInfo == null || (appDownloadTaskMo42385a = mo42385a(appInfo.getPackageName())) == null || !appDownloadTaskMo42385a.m42231K()) ? false : true;
    }

    @Override // com.huawei.openalliance.p169ad.download.C7059b
    /* renamed from: b */
    public AppDownloadTask mo42385a(String str) {
        DownloadTask downloadTaskMo42385a = super.mo42385a(str);
        return downloadTaskMo42385a instanceof AppDownloadTask ? (AppDownloadTask) downloadTaskMo42385a : C7036d.m42166a(this.f32505a).mo42105a(str);
    }

    /* renamed from: j */
    public void m42410j() {
        C7036d.m42166a(this.f32505a).m42184c();
    }

    /* renamed from: k */
    public void m42411k() {
        C7036d.m42166a(this.f32505a).m42186d();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.p169ad.download.app.AppDownloadTask m42357a(com.huawei.openalliance.p169ad.inter.data.AppInfo r7, com.huawei.openalliance.p169ad.download.app.AppDownloadTask r8, java.io.File r9, boolean r10) {
        /*
            r6 = this;
            long r0 = r9.length()
            long r2 = r7.getFileSize()
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L4f
            boolean r0 = r7.isCheckSha256()
            if (r0 == 0) goto L23
            java.lang.String r0 = r7.getSha256()
            boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7731ae.m47452a(r0, r9)
            if (r0 == 0) goto L1e
            goto L23
        L1e:
            com.huawei.openalliance.p169ad.utils.AbstractC7731ae.m47449a(r9)
        L21:
            r8 = r3
            goto L6f
        L23:
            if (r10 == 0) goto L37
            android.content.Context r10 = r6.f32505a
            java.lang.String r0 = r8.m42068d()
            java.lang.String r1 = "normal"
            boolean r10 = com.huawei.openalliance.p169ad.utils.AbstractC7731ae.m47448a(r10, r9, r0, r1)
            if (r10 != 0) goto L37
            com.huawei.openalliance.p169ad.utils.AbstractC7731ae.m47449a(r9)
            return r3
        L37:
            r9 = 100
            r8.m42059b(r9)
            long r9 = r7.getFileSize()
            r8.m42060b(r9)
            boolean r6 = r6.m42560b(r8)
            if (r6 == 0) goto L21
            com.huawei.openalliance.ad.download.e r6 = com.huawei.openalliance.p169ad.download.EnumC7062e.DOWNLOADED
        L4b:
            r8.m42054a(r6)
            goto L6f
        L4f:
            long r4 = r7.getFileSize()
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 <= 0) goto L1e
            r9 = 100
            long r9 = r9 * r0
            long r4 = r7.getFileSize()
            long r9 = r9 / r4
            int r7 = (int) r9
            r8.m42059b(r7)
            r8.m42060b(r0)
            boolean r6 = r6.m42560b(r8)
            if (r6 == 0) goto L21
            com.huawei.openalliance.ad.download.e r6 = com.huawei.openalliance.p169ad.download.EnumC7062e.IDLE
            goto L4b
        L6f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.download.app.C7046e.m42357a(com.huawei.openalliance.ad.inter.data.AppInfo, com.huawei.openalliance.ad.download.app.AppDownloadTask, java.io.File, boolean):com.huawei.openalliance.ad.download.app.AppDownloadTask");
    }

    /* renamed from: h */
    private static boolean m42379h(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.isCheckSha256() && TextUtils.isEmpty(appInfo.getSha256());
    }

    /* renamed from: c */
    public String m42402c(AppInfo appInfo) {
        AppDownloadTask appDownloadTaskM42405d = m42405d(appInfo);
        if (appInfo == null || appDownloadTaskM42405d == null || appDownloadTaskM42405d.m42222B() == null) {
            return null;
        }
        return appDownloadTaskM42405d.m42222B().getUniqueId();
    }

    /* renamed from: b */
    public void m42398b(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        if (appDownloadTask.m42231K()) {
            C7036d.m42166a(this.f32505a).m42181b(appDownloadTask);
            return;
        }
        if (appDownloadTask.m42077i() != EnumC7062e.INSTALLING && appDownloadTask.m42077i() != EnumC7062e.DOWNLOADED) {
            if (m42373e(appDownloadTask)) {
                C7050i.m42427a().m42444a(appDownloadTask);
            }
            m42554a((C7046e) appDownloadTask, DownloadTask.EnumC7031c.USER_CLICK);
        } else {
            AbstractC7185ho.m43820b("AppDownloadManager", " can not pause, status=" + appDownloadTask.m42077i());
        }
    }

    /* renamed from: d */
    public boolean m42406d(AppDownloadTask appDownloadTask) {
        String strM42228H = appDownloadTask.m42228H();
        if (!m42375g(appDownloadTask)) {
            return false;
        }
        m42362a(strM42228H, appDownloadTask);
        return mo42403c(appDownloadTask);
    }

    /* renamed from: a */
    public static void m42359a(Context context) {
        synchronized (f32396f) {
            try {
                if (f32397g == null) {
                    f32397g = new C7046e(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m42399b(AppInfo appInfo, InterfaceC7069l interfaceC7069l) {
        if (appInfo != null) {
            C7036d.m42166a(this.f32505a).m42182b(appInfo.getPackageName(), interfaceC7069l);
            this.f32401k.m42323b(appInfo.getPackageName(), interfaceC7069l);
        }
        if (C7831j.m48458a(appInfo)) {
            C7037e.m42187a(this.f32505a).m42199b(appInfo.m44358J(), interfaceC7069l);
        }
    }

    /* renamed from: c */
    public boolean m42404c(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return false;
        }
        if (appDownloadTask.m42231K()) {
            C7036d.m42166a(this.f32505a).m42111b((C7036d) appDownloadTask);
            m42557a((C7046e) appDownloadTask, false, true, false);
            return true;
        }
        return m42557a((C7046e) appDownloadTask, false, true, true);
    }

    /* renamed from: c */
    private boolean m42370c(String str) {
        return !TextUtils.isEmpty(str) && (str.equals("8") || str.equals("6") || str.equals("5"));
    }

    /* renamed from: a */
    public void m42386a(DownloadTask.EnumC7031c enumC7031c) {
        List<AppDownloadTask> listM42590d = this.f32509e.m42590d();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AppDownloadManager", "pauseAllTask.begin, task.size:%d", Integer.valueOf(listM42590d.size()));
        }
        for (AppDownloadTask appDownloadTask : listM42590d) {
            if (appDownloadTask.m42077i() == EnumC7062e.INSTALLING || appDownloadTask.m42077i() == EnumC7062e.DOWNLOADED) {
                AbstractC7185ho.m43820b("AppDownloadManager", " can not pause task, status=" + appDownloadTask.m42077i());
            } else {
                m42554a((C7046e) appDownloadTask, enumC7031c);
            }
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AppDownloadManager", "pauseAllTask.end, task.size:%d", Integer.valueOf(listM42590d.size()));
        }
    }

    /* renamed from: b */
    public void m42400b(AppInfo appInfo, AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.getPackageName()) || onResolutionRequiredListener == null) {
            return;
        }
        C7036d.m42166a(this.f32505a).m42183b(appInfo.getPackageName(), onResolutionRequiredListener);
    }

    /* renamed from: b */
    public boolean m42401b(AppInfo appInfo) {
        return m42365a(appInfo, true);
    }

    /* renamed from: a */
    public void m42387a(AutoOpenListener autoOpenListener) {
        this.f32400j = autoOpenListener;
        this.f32401k.m42317a(autoOpenListener);
        C7036d.m42166a(this.f32505a).m42172a(this.f32400j);
    }

    /* renamed from: a */
    private void m42361a(AppInfo appInfo, AppDownloadTask appDownloadTask) {
        AppInfo appInfoM42222B = appDownloadTask.m42222B();
        if (appInfoM42222B != null) {
            AbstractC7185ho.m43820b("AppDownloadManager", "update appInfo from remote task.");
            appInfo.m44433v(appInfoM42222B.getUniqueId());
        }
    }

    /* renamed from: a */
    public void m42388a(AppInfo appInfo, InterfaceC7069l interfaceC7069l) {
        if (appInfo != null) {
            C7036d.m42166a(this.f32505a).m42177a(appInfo.getPackageName(), interfaceC7069l);
        }
        if (!m42376g(appInfo)) {
            this.f32401k.m42320a(appInfo.getPackageName(), interfaceC7069l);
        }
        if (C7831j.m48458a(appInfo)) {
            C7037e.m42187a(this.f32505a).m42198a(appInfo.m44358J(), interfaceC7069l);
        }
    }

    /* renamed from: a */
    public void m42389a(AppInfo appInfo, AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.getPackageName()) || onResolutionRequiredListener == null) {
            return;
        }
        C7036d.m42166a(this.f32505a).m42178a(appInfo.getPackageName(), onResolutionRequiredListener);
    }

    /* renamed from: a */
    public void m42390a(AppDownloadListener appDownloadListener) {
        this.f32401k.m42318a(appDownloadListener);
        C7036d.m42166a(this.f32505a).m42174a(appDownloadListener);
    }

    /* renamed from: a */
    public void m42391a(AppDownloadListenerV1 appDownloadListenerV1) {
        this.f32399i = appDownloadListenerV1;
        this.f32401k.m42319a(appDownloadListenerV1);
        C7036d.m42166a(this.f32505a).m42175a(appDownloadListenerV1);
    }

    /* renamed from: a */
    public void m42392a(AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        C7036d.m42166a(this.f32505a).m42176a(onResolutionRequiredListener);
    }

    /* renamed from: a */
    private void m42362a(String str, AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        if (m42370c(str)) {
            C7036d.m42166a(this.f32505a).m42111b((C7036d) appDownloadTask);
        } else {
            if (m42376g(appDownloadTask.m42222B())) {
                return;
            }
            m42565d((C7046e) appDownloadTask);
        }
    }

    /* renamed from: a */
    private void m42363a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str2.endsWith(".apk")) {
                File file = new File(str + str2);
                if (!file.isDirectory() && System.currentTimeMillis() - file.lastModified() > 172800000) {
                    AbstractC7185ho.m43820b("AppDownloadManager", "remove timeout file");
                    AppDownloadTask appDownloadTaskMo42385a = mo42385a(m42371d(str2));
                    if (appDownloadTaskMo42385a != null) {
                        m42404c(appDownloadTaskMo42385a);
                    } else {
                        AbstractC7731ae.m47466e(file);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m42364a(List<AppDownloadTask> list) {
        Collections.sort(list);
        for (AppDownloadTask appDownloadTask : list) {
            AbstractC7185ho.m43820b("AppDownloadManager", " task pause reason:" + appDownloadTask.m42084p());
            if (appDownloadTask.m42084p() == DownloadTask.EnumC7031c.NETWORK_CHANGED || appDownloadTask.m42084p() == DownloadTask.EnumC7031c.WAITING_WIFI_DOWNLOAD) {
                mo42393a(appDownloadTask, false);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.C7059b
    /* renamed from: a */
    public boolean mo42403c(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            AbstractC7185ho.m43823c("AppDownloadManager", "cannot add task, task is null");
            return false;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AppDownloadManager", "addTask, package:%s", appDownloadTask.mo42082n());
        }
        appDownloadTask.m42251e(true);
        if (m42373e(appDownloadTask)) {
            m42560b((C7046e) appDownloadTask);
            C7050i.m42427a().m42445a(appDownloadTask, (C7050i.b) null);
            return true;
        }
        if (appDownloadTask.m42231K()) {
            C7036d.m42166a(this.f32505a).mo42107a(appDownloadTask);
            m42557a((C7046e) appDownloadTask, false, true, false);
            return true;
        }
        if (appDownloadTask.m42229I()) {
            AppInfo appInfoM42222B = appDownloadTask.m42222B();
            if (appInfoM42222B != null && !TextUtils.isEmpty(appInfoM42222B.m44428t()) && m42378h(appDownloadTask)) {
                return true;
            }
            AbstractC7185ho.m43820b("AppDownloadManager", "can not open Ag detail");
            return m42406d(appDownloadTask);
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7046e.this.m42384m();
            }
        });
        if (m42376g(appDownloadTask.m42222B())) {
            return m42406d(appDownloadTask);
        }
        if (appDownloadTask.m42077i() == EnumC7062e.INSTALLING) {
            AbstractC7185ho.m43820b("AppDownloadManager", appDownloadTask.m42222B().getPackageName() + " is installing.");
            return true;
        }
        if (appDownloadTask.m42077i() != EnumC7062e.DOWNLOADED || !AbstractC7731ae.m47458b(appDownloadTask.m42068d())) {
            return super.mo42403c((C7046e) appDownloadTask);
        }
        AbstractC7185ho.m43820b("AppDownloadManager", appDownloadTask.m42222B().getPackageName() + " is downloaded.");
        m42374f(appDownloadTask);
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.download.C7059b
    /* renamed from: a */
    public boolean mo42393a(AppDownloadTask appDownloadTask, boolean z10) {
        if (appDownloadTask == null) {
            return false;
        }
        if (m42373e(appDownloadTask)) {
            C7050i.m42427a().m42448b(appDownloadTask);
            return true;
        }
        if (appDownloadTask.m42231K()) {
            C7036d.m42166a(this.f32505a).m42185c(appDownloadTask);
            m42557a((C7046e) appDownloadTask, z10, true, false);
            return true;
        }
        if (appDownloadTask.m42077i() == EnumC7062e.INSTALLING) {
            AbstractC7185ho.m43820b("AppDownloadManager", appDownloadTask.m42222B().getPackageName() + " is installing!");
            return false;
        }
        if (appDownloadTask.m42077i() != EnumC7062e.DOWNLOADED || !AbstractC7731ae.m47458b(appDownloadTask.m42068d())) {
            return super.mo42393a((C7046e) appDownloadTask, z10);
        }
        AbstractC7185ho.m43820b("AppDownloadManager", appDownloadTask.m42222B().getPackageName() + " is downloaded!");
        m42374f(appDownloadTask);
        return true;
    }

    /* renamed from: a */
    public boolean m42396a(AppInfo appInfo) {
        return m42365a(appInfo, false);
    }

    /* renamed from: a */
    private boolean m42365a(AppInfo appInfo, boolean z10) throws JSONException {
        C7050i.m42427a().m42447a(appInfo);
        if (m42380i(appInfo)) {
            C7036d.m42166a(this.f32505a).m42173a(appInfo);
            m42557a((C7046e) mo42385a(appInfo.getPackageName()), z10, true, false);
            return true;
        }
        if (m42376g(appInfo)) {
            return false;
        }
        return m42557a((C7046e) mo42385a(appInfo.getPackageName()), z10, true, true);
    }
}
