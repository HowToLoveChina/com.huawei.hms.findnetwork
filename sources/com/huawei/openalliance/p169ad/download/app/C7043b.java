package com.huawei.openalliance.p169ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7386lf;
import com.huawei.openalliance.p169ad.C7402ll;
import com.huawei.openalliance.p169ad.C7485mt;
import com.huawei.openalliance.p169ad.C7562ow;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.activity.PPSFullScreenNotifyActivity;
import com.huawei.openalliance.p169ad.activity.PPSInstallAuthorActivity;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6924e;
import com.huawei.openalliance.p169ad.beans.inner.DownloadBlockInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.InterfaceC7032a;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.C7050i;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7755bb;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8114g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.download.app.b */
/* loaded from: classes2.dex */
public class C7043b implements InterfaceC7032a<AppDownloadTask>, C7050i.c {

    /* renamed from: k */
    private static Map<DownloadTask.EnumC7030b, Integer> f32354k;

    /* renamed from: a */
    private Context f32355a;

    /* renamed from: b */
    private C7562ow f32356b;

    /* renamed from: d */
    private AppDownloadListener f32358d;

    /* renamed from: f */
    private AppDownloadListenerV1 f32360f;

    /* renamed from: g */
    private long f32361g;

    /* renamed from: h */
    private AutoOpenListener f32362h;

    /* renamed from: i */
    private a f32363i;

    /* renamed from: c */
    private Map<String, WeakHashMap<InterfaceC7069l, Object>> f32357c = new ConcurrentHashMap();

    /* renamed from: e */
    private String f32359e = Constants.TIMEOUT_TASK_ID + hashCode();

    /* renamed from: j */
    private BroadcastReceiver f32364j = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                AbstractC7185ho.m43821b("AppDownloadDelegate", "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    AbstractC7185ho.m43823c("AppDownloadDelegate", "itRe dataString is empty, " + action);
                    return;
                }
                final String strSubstring = dataString.substring(8);
                C7043b.this.m42298a(action, strSubstring);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C7043b.this.m42312p(C7046e.m42377h().mo42385a(strSubstring));
                        }
                    });
                }
            } catch (IllegalStateException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AppDownloadDelegate", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AppDownloadDelegate", sb2.toString());
            }
        }
    };

    /* renamed from: com.huawei.openalliance.ad.download.app.b$8, reason: invalid class name */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AppInfo f32380a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC7615qq f32381b;

        public AnonymousClass8(AppInfo appInfo, InterfaceC7615qq interfaceC7615qq) {
            this.f32380a = appInfo;
            this.f32381b = interfaceC7615qq;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.8.1
                @Override // java.lang.Runnable
                public void run() {
                    C7485mt.m45865a(C7043b.this.f32355a).m45866a(AnonymousClass8.this.f32380a.getPackageName(), new C7485mt.a() { // from class: com.huawei.openalliance.ad.download.app.b.8.1.1
                        @Override // com.huawei.openalliance.p169ad.C7485mt.a
                        /* renamed from: a */
                        public void mo42339a(String str, String str2) {
                            new C6922c(C7043b.this.f32355a).m39081a(AnonymousClass8.this.f32381b.mo46574a(), AnonymousClass8.this.f32380a.m44397g(), str2, AnonymousClass8.this.f32380a.getPackageName());
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.b$a */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "onReceive.");
            if (intent == null) {
                return;
            }
            try {
                if ("com.huawei.hms.pps.action.PPS_APP_OPEN".equals(intent.getAction())) {
                    AppInfo appInfo = (AppInfo) AbstractC7758be.m47739b(intent.getStringExtra("appInfo"), AppInfo.class, new Class[0]);
                    if (appInfo == null) {
                        AbstractC7185ho.m43820b("AppDownloadDelegate", "appInfo is null");
                        return;
                    }
                    C7045d c7045dM42344a = C7045d.m42344a();
                    if (c7045dM42344a != null) {
                        c7045dM42344a.onAppOpen(appInfo);
                    }
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AppDownloadDelegate", "exception: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.b$b */
    public static class b implements Runnable {

        /* renamed from: a */
        private WeakReference<C7043b> f32388a;

        public b(C7043b c7043b) {
            this.f32388a = new WeakReference<>(c7043b);
        }

        @Override // java.lang.Runnable
        public void run() {
            C7043b c7043b = this.f32388a.get();
            if (c7043b == null) {
                return;
            }
            c7043b.m42308d();
        }
    }

    static {
        HashMap map = new HashMap();
        f32354k = map;
        map.put(DownloadTask.EnumC7030b.NO_SPACE, Integer.valueOf(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN));
        f32354k.put(DownloadTask.EnumC7030b.CONN_FAILED, Integer.valueOf(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED));
        f32354k.put(DownloadTask.EnumC7030b.FILE_SIZE_ERROR, Integer.valueOf(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN));
        f32354k.put(DownloadTask.EnumC7030b.FILE_SHA256_ERROR, Integer.valueOf(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH));
        f32354k.put(DownloadTask.EnumC7030b.MOBILE_NETWORK, Integer.valueOf(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH));
    }

    public C7043b(Context context) {
        String str;
        Context applicationContext = context.getApplicationContext();
        this.f32355a = applicationContext;
        try {
            this.f32356b = C7562ow.m46641a(applicationContext);
            C7402ll.m45597a(context).m45599a();
            m42302b();
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            AbstractC7185ho.m43823c("AppDownloadDelegate", str);
        } catch (Exception unused2) {
            str = "registerReceiver Exception";
            AbstractC7185ho.m43823c("AppDownloadDelegate", str);
        }
    }

    /* renamed from: a */
    private int m42283a(DownloadTask.EnumC7030b enumC7030b) {
        Integer num = f32354k.get(enumC7030b);
        if (num == null) {
            return -1000;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m42308d() {
        AbstractC7185ho.m43820b("AppDownloadDelegate", "unRegisterAppInstReceiver");
        this.f32355a.unregisterReceiver(this.f32364j);
    }

    /* renamed from: m */
    private void m42309m(AppDownloadTask appDownloadTask) {
        WeakHashMap<InterfaceC7069l, Object> weakHashMapM42284a = m42284a(appDownloadTask.m42222B());
        if (weakHashMapM42284a == null || weakHashMapM42284a.size() <= 0) {
            return;
        }
        for (InterfaceC7069l interfaceC7069l : weakHashMapM42284a.keySet()) {
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42626a(appDownloadTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m42310n(AppDownloadTask appDownloadTask) {
        WeakHashMap<InterfaceC7069l, Object> weakHashMapM42284a = m42284a(appDownloadTask.m42222B());
        if (weakHashMapM42284a == null || weakHashMapM42284a.size() <= 0) {
            return;
        }
        for (InterfaceC7069l interfaceC7069l : weakHashMapM42284a.keySet()) {
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42628b(appDownloadTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m42311o(final AppDownloadTask appDownloadTask) {
        AbstractC7185ho.m43817a("AppDownloadDelegate", "installApp start");
        m42290a(AppStatusV1.START_INSTALL, 1000, appDownloadTask.m42222B());
        this.f32356b.m46652a(appDownloadTask.m42222B(), appDownloadTask, new C7562ow.a() { // from class: com.huawei.openalliance.ad.download.app.b.3
            @Override // com.huawei.openalliance.p169ad.C7562ow.a
            /* renamed from: a */
            public void mo42336a() {
                AbstractC7185ho.m43823c("AppDownloadDelegate", "onSilentInstallStart");
                appDownloadTask.m42054a(EnumC7062e.INSTALLING);
                C7043b.this.m42310n(appDownloadTask);
                C7043b.this.m42289a(AppStatus.INSTALLING, appDownloadTask.m42222B());
            }

            @Override // com.huawei.openalliance.p169ad.C7562ow.a
            /* renamed from: b */
            public void mo42338b() {
                AbstractC7185ho.m43823c("AppDownloadDelegate", "onSystemInstallStart");
                appDownloadTask.m42054a(EnumC7062e.DOWNLOADED);
                C7043b.this.m42310n(appDownloadTask);
                C7043b.this.m42289a(AppStatus.INSTALL, appDownloadTask.m42222B());
            }

            @Override // com.huawei.openalliance.p169ad.C7562ow.a
            /* renamed from: a */
            public void mo42337a(int i10) {
                C7043b c7043b;
                AppStatus appStatus;
                AbstractC7185ho.m43824c("AppDownloadDelegate", "install apk failed, reason: %s", Integer.valueOf(i10));
                C7043b.this.m42290a(AppStatusV1.INSTALL_FAILED, -1000, appDownloadTask.m42222B());
                if (i10 != 1 && C7043b.this.m42331i(appDownloadTask)) {
                    return;
                }
                appDownloadTask.m42054a(EnumC7062e.DOWNLOADED);
                if (C7043b.this.f32358d != null) {
                    if (AbstractC7731ae.m47458b(appDownloadTask.m42068d())) {
                        c7043b = C7043b.this;
                        appStatus = AppStatus.INSTALL;
                    } else {
                        appDownloadTask.m42059b(0);
                        appDownloadTask.m42060b(0L);
                        appDownloadTask.m42065c(0L);
                        appDownloadTask.m42054a(EnumC7062e.FAILED);
                        c7043b = C7043b.this;
                        appStatus = AppStatus.DOWNLOAD;
                    }
                    c7043b.m42289a(appStatus, appDownloadTask.m42222B());
                }
                C7043b.this.m42310n(appDownloadTask);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m42312p(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null || appDownloadTask.m42232L() != AppDownloadTask.EnumC7041b.DOWN_LOAD_MODE_FROM_SELF) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "task is empty");
            return;
        }
        appDownloadTask.m42054a(EnumC7062e.INSTALLED);
        final InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
        if (interfaceC7615qqM42223C != null) {
            interfaceC7615qqM42223C.mo46596a(Integer.valueOf(appDownloadTask.m42224D()), appDownloadTask.m42226F(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
            new C6922c(this.f32355a).m39079a(interfaceC7615qqM42223C.mo46574a(), (String) null, appDownloadTask);
        }
        final AppInfo appInfoM42222B = appDownloadTask.m42222B();
        if (appInfoM42222B == null) {
            return;
        }
        String packageName = appInfoM42222B.getPackageName();
        C7046e.m42377h().m42404c(appDownloadTask);
        final String strM42225E = appDownloadTask.m42225E();
        m42299a(packageName, strM42225E, appInfoM42222B);
        m42296a(interfaceC7615qqM42223C, appInfoM42222B);
        if (C7831j.m48457a(this.f32355a, packageName, appDownloadTask)) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "auto open app");
            m42297a(packageName, appDownloadTask, appInfoM42222B);
        } else {
            AbstractC7185ho.m43821b("AppDownloadDelegate", "onAppInstalled, popNotify: %s", Integer.valueOf(appInfoM42222B.m44418o()));
            AbstractC7185ho.m43821b("AppDownloadDelegate", "onAppInstalled, fullScrnNotify: %s", Integer.valueOf(appInfoM42222B.m44420p()));
            if (appInfoM42222B.m44418o() == 1 && appDownloadTask.m42241U()) {
                m42288a(appDownloadTask, appInfoM42222B);
            }
            if (interfaceC7615qqM42223C != null && appInfoM42222B.m44420p() != 0 && C6982bz.m41152b(this.f32355a)) {
                m42314a(this.f32355a, interfaceC7615qqM42223C.mo46574a(), appDownloadTask);
            }
        }
        if (interfaceC7615qqM42223C != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.7
                @Override // java.lang.Runnable
                public void run() {
                    new C6922c(C7043b.this.f32355a).m39080a(interfaceC7615qqM42223C.mo46574a(), appInfoM42222B.m44397g(), strM42225E);
                }
            });
        }
        m42289a(AppStatus.INSTALLED, appDownloadTask.m42222B());
        m42290a(AppStatusV1.INSTALL_SUCCESS, 1000, appDownloadTask.m42222B());
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onDownloadSuccess(AppDownloadTask appDownloadTask) {
        InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
        this.f32361g = C7124fh.m43316b(this.f32355a).mo43072f();
        if (interfaceC7615qqM42223C != null) {
            interfaceC7615qqM42223C.mo46613b(appDownloadTask.m42226F(), appDownloadTask.m42225E(), appDownloadTask.m42092x(), appDownloadTask.m42076h().m42095a(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        }
        m42313a();
        m42289a(AppStatus.DOWNLOADED, appDownloadTask.m42222B());
        m42290a(AppStatusV1.DOWNLOAD_SUCCESS, 1000, appDownloadTask.m42222B());
        m42328f(appDownloadTask);
    }

    /* renamed from: f */
    public void m42328f(AppDownloadTask appDownloadTask) {
        AbstractC7185ho.m43817a("AppDownloadDelegate", "onAppStartInstall start");
        try {
            InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
            if (interfaceC7615qqM42223C == null) {
                AbstractC7185ho.m43820b("AppDownloadDelegate", "eventProcessor is null! continue install.");
                m42311o(appDownloadTask);
                return;
            }
            ContentRecord contentRecordMo46574a = interfaceC7615qqM42223C.mo46574a();
            if (contentRecordMo46574a == null) {
                AbstractC7185ho.m43820b("AppDownloadDelegate", "contentRecord is null! continue install.");
                m42311o(appDownloadTask);
                return;
            }
            if (C7755bb.m47705a(appDownloadTask, this.f32355a)) {
                if (AbstractC7811dd.m48339o(this.f32355a)) {
                    AbstractC7185ho.m43820b("AppDownloadDelegate", "start InstallAuthorActivity!");
                    m42287a(contentRecordMo46574a);
                    if (contentRecordMo46574a.m41484af().m44348E() == 1) {
                        appDownloadTask.m42054a(EnumC7062e.DOWNLOADED);
                        m42310n(appDownloadTask);
                        return;
                    }
                } else if (AbstractC7558os.m46456D(contentRecordMo46574a.m41427W())) {
                    AbstractC7185ho.m43820b("AppDownloadDelegate", "app is background, stop install!");
                    appDownloadTask.m42054a(EnumC7062e.DOWNLOADED);
                    m42310n(appDownloadTask);
                    return;
                }
            }
            m42311o(appDownloadTask);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AppDownloadDelegate", "onAppStartInstall err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo42101b(final AppDownloadTask appDownloadTask) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.4
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(C7043b.this.f32355a, C7043b.this.f32355a.getString(C6849R.string.hiad_download_retry_toast_content, appDownloadTask.m42222B().getAppName()), 0).show();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onDownloadFail(final AppDownloadTask appDownloadTask) {
        Runnable runnable;
        InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
        if (interfaceC7615qqM42223C != null) {
            DownloadTask.EnumC7030b enumC7030bM42078j = appDownloadTask.m42078j();
            if (enumC7030bM42078j == null) {
                enumC7030bM42078j = DownloadTask.EnumC7030b.NONE;
            }
            interfaceC7615qqM42223C.mo46597a(appDownloadTask.m42226F(), appDownloadTask.m42225E(), enumC7030bM42078j.m42096a(), appDownloadTask.m42092x(), appDownloadTask.m42076h().m42095a(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        }
        if (m42331i(appDownloadTask)) {
            return;
        }
        m42310n(appDownloadTask);
        if (appDownloadTask.m42078j() != DownloadTask.EnumC7030b.NO_SPACE) {
            if (appDownloadTask.m42078j() == DownloadTask.EnumC7030b.FILE_SIZE_ERROR || appDownloadTask.m42078j() == DownloadTask.EnumC7030b.FILE_SHA256_ERROR) {
                runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(C7043b.this.f32355a, C7043b.this.f32355a.getString(C6849R.string.hiad_download_failed_toast_content, appDownloadTask.m42222B().getAppName()), 0).show();
                    }
                };
            }
            m42289a(AppStatus.DOWNLOADFAILED, appDownloadTask.m42222B());
            m42290a(AppStatusV1.DOWNLOAD_FAILED, m42283a(appDownloadTask.m42078j()), appDownloadTask.m42222B());
        }
        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.5
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(C7043b.this.f32355a, C6849R.string.hiad_download_no_space, 0).show();
            }
        };
        AbstractC7817dj.m48363a(runnable);
        m42289a(AppStatus.DOWNLOADFAILED, appDownloadTask.m42222B());
        m42290a(AppStatusV1.DOWNLOAD_FAILED, m42283a(appDownloadTask.m42078j()), appDownloadTask.m42222B());
    }

    /* renamed from: i */
    public boolean m42331i(AppDownloadTask appDownloadTask) {
        return C7046e.m42377h().m42406d(appDownloadTask);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.C7050i.c
    /* renamed from: j */
    public void mo42332j(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            EnumC7062e enumC7062eM42077i = appDownloadTask.m42077i();
            EnumC7062e enumC7062e = EnumC7062e.INSTALLING;
            if (enumC7062eM42077i == enumC7062e || appDownloadTask.m42077i() == EnumC7062e.DOWNLOADING) {
                AppStatus appStatus = appDownloadTask.m42077i() == enumC7062e ? AppStatus.INSTALLING : AppStatus.DOWNLOADING;
                AppStatusV1 appStatusV1 = appDownloadTask.m42077i() == enumC7062e ? AppStatusV1.START_INSTALL : AppStatusV1.START_DOWNLOAD;
                m42310n(appDownloadTask);
                if (appStatus == AppStatus.DOWNLOADING) {
                    onDownloadProgress(appDownloadTask);
                }
                m42289a(appStatus, appDownloadTask.m42222B());
                m42290a(appStatusV1, 1000, appDownloadTask.m42222B());
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.app.C7050i.c
    /* renamed from: k */
    public void mo42333k(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null || appDownloadTask.m42077i() != EnumC7062e.INSTALLED) {
            return;
        }
        m42310n(appDownloadTask);
        m42312p(appDownloadTask);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.C7050i.c
    /* renamed from: l */
    public void mo42334l(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        m42310n(appDownloadTask);
        onDownloadProgress(appDownloadTask);
    }

    /* renamed from: a */
    private synchronized WeakHashMap<InterfaceC7069l, Object> m42284a(AppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(appInfo.getPackageName())) {
                return m42285a(appInfo.getPackageName());
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m42302b() {
        this.f32363i = new a();
        AbstractC7741ao.m47537a(this.f32355a, this.f32363i, new IntentFilter("com.huawei.hms.pps.action.PPS_APP_OPEN"), Constants.PERMISSION_PPS_DOWNLOAD, null);
    }

    /* renamed from: c */
    private void m42306c() {
        AbstractC7768bo.m47810a(this.f32359e);
        AbstractC7768bo.m47809a(new b(this), this.f32359e, this.f32361g);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onDownloadProgress(AppDownloadTask appDownloadTask) {
        m42309m(appDownloadTask);
        AppDownloadListener appDownloadListener = this.f32358d;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadProgress(appDownloadTask.m42222B(), appDownloadTask.m42080l());
        } else {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "progress listener empty");
        }
    }

    /* renamed from: a */
    private synchronized WeakHashMap<InterfaceC7069l, Object> m42285a(String str) {
        return this.f32357c.get(str);
    }

    /* renamed from: b */
    private void m42303b(Context context, ContentRecord contentRecord, AppDownloadTask appDownloadTask) {
        Intent intent = new Intent(context, (Class<?>) PPSFullScreenNotifyActivity.class);
        intent.setFlags(805306368);
        intent.putExtra(Constants.CONTENT_KEY, AbstractC7758be.m47742b(contentRecord));
        intent.putExtra("unique_id", (appDownloadTask == null || appDownloadTask.m42222B() == null || appDownloadTask.m42222B().getUniqueId() == null) ? "" : appDownloadTask.m42222B().getUniqueId());
        if (appDownloadTask != null) {
            intent.putExtra("download_source", appDownloadTask.m42226F());
        }
        intent.setClipData(Constants.CLIP_DATA);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public void m42313a() {
        AbstractC7185ho.m43820b("AppDownloadDelegate", "registerAppInstReceiver");
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        AbstractC7741ao.m47536a(this.f32355a, this.f32364j, intentFilter);
        m42306c();
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onDownloadStart(AppDownloadTask appDownloadTask) {
        InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
        if (interfaceC7615qqM42223C != null && appDownloadTask.m42075g() <= 0) {
            interfaceC7615qqM42223C.mo46598a(appDownloadTask.m42226F(), appDownloadTask.m42225E(), appDownloadTask.m42076h().m42095a(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        }
        m42310n(appDownloadTask);
        m42289a(AppStatus.DOWNLOADING, appDownloadTask.m42222B());
        if (appDownloadTask.m42080l() > 0 || appDownloadTask.m42075g() > 0) {
            return;
        }
        m42290a(AppStatusV1.PRE_CHECK_SUCCESS, 1000, appDownloadTask.m42222B());
        m42290a(AppStatusV1.START_DOWNLOAD, 1000, appDownloadTask.m42222B());
    }

    /* renamed from: a */
    public void m42314a(Context context, ContentRecord contentRecord, AppDownloadTask appDownloadTask) {
        try {
            if (m42300a(contentRecord, appDownloadTask)) {
                m42303b(context, contentRecord, appDownloadTask);
            } else {
                AbstractC7185ho.m43820b("AppDownloadDelegate", "not show InstalledNotifyActivity");
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AppDownloadDelegate", "start installed notify activity error: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo42103c(AppDownloadTask appDownloadTask, boolean z10) {
        AppStatusV1 appStatusV1;
        InterfaceC7615qq interfaceC7615qqM42223C;
        if (z10 && (interfaceC7615qqM42223C = appDownloadTask.m42223C()) != null) {
            interfaceC7615qqM42223C.mo46612b(appDownloadTask.m42226F(), appDownloadTask.m42225E(), appDownloadTask.m42076h().m42095a(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        }
        if (z10) {
            appStatusV1 = AppStatusV1.USER_RESUME;
        } else {
            i = (appDownloadTask.m42084p() == DownloadTask.EnumC7031c.WAITING_WIFI_DOWNLOAD || appDownloadTask.m42084p() == DownloadTask.EnumC7031c.NETWORK_CHANGED) ? 1017 : 1000;
            appStatusV1 = AppStatusV1.RESUME;
        }
        m42290a(appStatusV1, i, appDownloadTask.m42222B());
        appDownloadTask.m42053a(DownloadTask.EnumC7031c.NONE);
        m42310n(appDownloadTask);
        m42289a(AppStatus.RESUME, appDownloadTask.m42222B());
    }

    /* renamed from: a */
    private void m42286a(Context context, String str, AppDownloadTask appDownloadTask) {
        C7047f c7047f = new C7047f();
        AbstractC7185ho.m43821b("AppDownloadDelegate", "sdk auto open app package sdk target %s.", str);
        boolean zM42417a = c7047f.m42417a(context, appDownloadTask.m42222B(), appDownloadTask.m42223C(), appDownloadTask.m42226F(), false);
        AppInfo appInfoM42222B = appDownloadTask.m42222B();
        if (appInfoM42222B == null || appInfoM42222B.m44383c() != 1) {
            return;
        }
        C6924e c6924e = new C6924e(2);
        c6924e.m39143a(appInfoM42222B);
        c6924e.m39142a(appDownloadTask);
        c6924e.m39141a(appDownloadTask.m42239S());
        c6924e.m39144a(zM42417a);
        new C6922c(context).mo39066a(c6924e);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo42099a(AppDownloadTask appDownloadTask) {
        m42310n(appDownloadTask);
        m42289a(AppStatus.WAITING_FOR_WIFI, appDownloadTask.m42222B());
        m42290a(AppStatusV1.WAITING_FOR_WIFI, 1000, appDownloadTask.m42222B());
    }

    /* renamed from: a */
    private void m42287a(ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("AppDownloadDelegate", "startInstallAuthorActivity");
        try {
            Intent intent = new Intent(this.f32355a, (Class<?>) PPSInstallAuthorActivity.class);
            intent.setFlags(805306368);
            intent.putExtra(Constants.CONTENT_KEY, AbstractC7758be.m47742b(contentRecord));
            PPSInstallAuthorActivity.m38726a(new InterfaceC8114g() { // from class: com.huawei.openalliance.ad.download.app.b.2
                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8114g
                /* renamed from: a */
                public void mo42335a(AppDownloadTask appDownloadTask) {
                    if (appDownloadTask != null) {
                        C7043b.this.m42311o(appDownloadTask);
                    }
                }
            });
            intent.setClipData(Constants.CLIP_DATA);
            this.f32355a.startActivity(intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("AppDownloadDelegate", "startInstallAuthorActivity failed %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo42102b(AppDownloadTask appDownloadTask, boolean z10) {
        AppStatusV1 appStatusV1;
        int i10;
        InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
        DownloadTask.EnumC7031c enumC7031cM42084p = appDownloadTask.m42084p();
        if (interfaceC7615qqM42223C != null) {
            DownloadBlockInfo downloadBlockInfoM42092x = appDownloadTask.m42092x();
            if (downloadBlockInfoM42092x != null) {
                downloadBlockInfoM42092x.m39397b(AbstractC7741ao.m47566c());
                appDownloadTask.m42093y();
            }
            interfaceC7615qqM42223C.mo46592a(appDownloadTask);
        }
        m42310n(appDownloadTask);
        m42289a(AppStatus.PAUSE, appDownloadTask.m42222B());
        if (z10) {
            appStatusV1 = AppStatusV1.USER_PAUSE;
            i10 = 1000;
        } else if (enumC7031cM42084p == null || DownloadTask.EnumC7031c.NETWORK_CHANGED != enumC7031cM42084p) {
            appStatusV1 = AppStatusV1.PAUSE;
            i10 = FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED;
        } else {
            appStatusV1 = AppStatusV1.PAUSE;
            i10 = FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE;
        }
        m42290a(appStatusV1, i10, appDownloadTask.m42222B());
    }

    /* renamed from: b */
    public synchronized void m42323b(String str, InterfaceC7069l interfaceC7069l) {
        WeakHashMap<InterfaceC7069l, Object> weakHashMap = this.f32357c.get(str);
        if (weakHashMap != null && weakHashMap.size() > 0) {
            weakHashMap.remove(interfaceC7069l);
            if (weakHashMap.size() <= 0) {
                this.f32357c.remove(str);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onDownloadWaiting(AppDownloadTask appDownloadTask) {
        m42310n(appDownloadTask);
        m42289a(AppStatus.WAITING, appDownloadTask.m42222B());
        m42290a(AppStatusV1.WAITING, 1000, appDownloadTask.m42222B());
    }

    /* renamed from: a */
    private void m42288a(AppDownloadTask appDownloadTask, AppInfo appInfo) {
        if (TextUtils.isEmpty(appInfo.m44394f())) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "popUpAfterInstallText is blank");
        } else {
            new C7386lf(this.f32355a, appDownloadTask).mo45479b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo42100a(AppDownloadTask appDownloadTask, boolean z10) {
        InterfaceC7615qq interfaceC7615qqM42223C;
        boolean z11 = z10 && appDownloadTask.m42077i() != EnumC7062e.DOWNLOADED;
        if (z11 && (interfaceC7615qqM42223C = appDownloadTask.m42223C()) != null) {
            DownloadBlockInfo downloadBlockInfoM42092x = appDownloadTask.m42092x();
            if (downloadBlockInfoM42092x != null) {
                downloadBlockInfoM42092x.m39397b(AbstractC7741ao.m47566c());
                appDownloadTask.m42093y();
            }
            interfaceC7615qqM42223C.mo46599a(appDownloadTask.m42226F(), appDownloadTask.m42225E(), downloadBlockInfoM42092x, appDownloadTask.m42076h().m42095a(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        }
        appDownloadTask.m42059b(0);
        appDownloadTask.m42060b(0L);
        appDownloadTask.m42065c(0L);
        appDownloadTask.m42054a(EnumC7062e.FAILED);
        if (z11) {
            m42289a(AppStatus.DOWNLOADFAILED, appDownloadTask.m42222B());
            m42290a(AppStatusV1.CANCEL_DOWNLOAD, 1000, appDownloadTask.m42222B());
        }
        m42310n(appDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42289a(AppStatus appStatus, AppInfo appInfo) {
        if (this.f32358d == null) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "app status empty");
            return;
        }
        AbstractC7185ho.m43820b("AppDownloadDelegate", "task status:" + appStatus);
        this.f32358d.onStatusChanged(appStatus, appInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42290a(AppStatusV1 appStatusV1, int i10, AppInfo appInfo) {
        if (this.f32360f == null) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "listener v1 empty");
            return;
        }
        AbstractC7185ho.m43820b("AppDownloadDelegate", "task status:" + appStatusV1 + ", code:" + i10);
        this.f32360f.onNewStatusChanged(appStatusV1, i10, appInfo);
    }

    /* renamed from: a */
    public void m42317a(AutoOpenListener autoOpenListener) {
        this.f32362h = autoOpenListener;
    }

    /* renamed from: a */
    public void m42318a(AppDownloadListener appDownloadListener) {
        this.f32358d = appDownloadListener;
    }

    /* renamed from: a */
    public void m42319a(AppDownloadListenerV1 appDownloadListenerV1) {
        this.f32360f = appDownloadListenerV1;
    }

    /* renamed from: a */
    private void m42296a(InterfaceC7615qq interfaceC7615qq, AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.getPackageName()) || interfaceC7615qq == null || C7124fh.m43316b(this.f32355a).mo43425bz() != 1) {
            return;
        }
        AbstractC7817dj.m48364a(new AnonymousClass8(appInfo, interfaceC7615qq), RippleView.SINGLE_RIPPLE_TIME);
    }

    /* renamed from: a */
    private void m42297a(String str, AppDownloadTask appDownloadTask, AppInfo appInfo) {
        Context context = this.f32355a;
        if (context == null || TextUtils.isEmpty(context.getPackageName()) || !Constants.HW_BROWSER_PACKAGE.equals(this.f32355a.getPackageName())) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "auto open app from other");
        } else {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "auto open app from browser");
            AutoOpenListener autoOpenListener = this.f32362h;
            if (autoOpenListener != null && !autoOpenListener.isNeedAutoOpen(appInfo)) {
                return;
            }
        }
        m42286a(this.f32355a, str, appDownloadTask);
    }

    /* renamed from: a */
    public synchronized void m42320a(String str, InterfaceC7069l interfaceC7069l) {
        try {
            WeakHashMap<InterfaceC7069l, Object> weakHashMap = this.f32357c.get(str);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                this.f32357c.put(str, weakHashMap);
            }
            weakHashMap.put(interfaceC7069l, null);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42298a(String str, String str2) {
        WeakHashMap<InterfaceC7069l, Object> weakHashMapM42285a = m42285a(str2);
        if (weakHashMapM42285a != null && weakHashMapM42285a.size() > 0) {
            if ("android.intent.action.PACKAGE_ADDED".equals(str)) {
                for (InterfaceC7069l interfaceC7069l : weakHashMapM42285a.keySet()) {
                    if (interfaceC7069l != null) {
                        interfaceC7069l.mo42627a(str2);
                    }
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(str)) {
                for (InterfaceC7069l interfaceC7069l2 : weakHashMapM42285a.keySet()) {
                    if (interfaceC7069l2 != null) {
                        interfaceC7069l2.mo42629b(str2);
                    }
                }
            }
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(str)) {
            if (this.f32358d == null) {
                AbstractC7185ho.m43820b("AppDownloadDelegate", "listener empty");
                return;
            }
            AppInfo appInfo = new AppInfo();
            appInfo.m44371a(str2);
            this.f32358d.onStatusChanged(AppStatus.DOWNLOAD, appInfo);
        }
    }

    /* renamed from: a */
    private void m42299a(final String str, String str2, final AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.m44397g()) || !"3".equalsIgnoreCase(str2)) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.b.9
            @Override // java.lang.Runnable
            public void run() {
                C7485mt.m45865a(C7043b.this.f32355a).m45867a(str, appInfo.m44397g(), appInfo.m44400h());
            }
        });
    }

    /* renamed from: a */
    private boolean m42300a(ContentRecord contentRecord, AppDownloadTask appDownloadTask) {
        String str;
        if (appDownloadTask != null && appDownloadTask.m42224D() == 2) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "not show fullScreen dialog: install source is 2");
            return false;
        }
        C6922c c6922c = new C6922c(this.f32355a);
        if (!HiAd.getInstance(this.f32355a).isAppInstalledNotify()) {
            AbstractC7185ho.m43820b("AppDownloadDelegate", "not show fullScreen dialog: media not allow show dialog");
            c6922c.mo39078a(contentRecord, "6", (C6920a) null);
            return false;
        }
        if (AbstractC7811dd.m48339o(this.f32355a)) {
            str = "show fullScreen dialog: app status is Foreground and media allow show dialog";
        } else {
            if (HiAd.m44014a(this.f32355a).mo44059l() == null || !HiAd.m44014a(this.f32355a).mo44059l().isForeground()) {
                AbstractC7185ho.m43820b("AppDownloadDelegate", "not show fullScreen dialog: app status is not Foreground and Callback is false");
                c6922c.mo39078a(contentRecord, "7", (C6920a) null);
                return false;
            }
            str = "show fullScreen dialog: get the app status is Foreground Through Callback";
        }
        AbstractC7185ho.m43820b("AppDownloadDelegate", str);
        return true;
    }
}
