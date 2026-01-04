package com.huawei.openalliance.p169ad.download.p172ag;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7386lf;
import com.huawei.openalliance.p169ad.C7402ll;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.activity.AgProtocolActivity;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.InterfaceC7032a;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.AppStatusV1;
import com.huawei.openalliance.p169ad.download.app.C7045d;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.download.ag.c */
/* loaded from: classes2.dex */
public class C7035c implements InterfaceC7032a<AppDownloadTask> {

    /* renamed from: h */
    private static Map<String, Method> f32272h = new HashMap();

    /* renamed from: a */
    private Context f32273a;

    /* renamed from: b */
    private String f32274b;

    /* renamed from: c */
    private long f32275c;

    /* renamed from: e */
    private AppDownloadListener f32277e;

    /* renamed from: f */
    private AppDownloadListenerV1 f32278f;

    /* renamed from: g */
    private AutoOpenListener f32279g;

    /* renamed from: j */
    private AppDownloadButton.OnResolutionRequiredListener f32281j;

    /* renamed from: k */
    private long f32282k;

    /* renamed from: d */
    private Map<String, Set<InterfaceC7069l>> f32276d = new ConcurrentHashMap();

    /* renamed from: i */
    private Map<String, Set<AppDownloadButton.OnResolutionRequiredListener>> f32280i = new ConcurrentHashMap();

    /* renamed from: l */
    private String f32283l = Constants.TIMEOUT_TASK_ID + hashCode();

    /* renamed from: m */
    private BroadcastReceiver f32284m = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.ag.c.1
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                AbstractC7185ho.m43818a("AgDe", "appRe action: %s", action);
                C7035c.this.m42125a(intent, action);
            } catch (IllegalStateException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("appRe ");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("appRe ");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            }
        }
    };

    /* renamed from: n */
    private BroadcastReceiver f32285n = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.ag.c.2

        /* renamed from: com.huawei.openalliance.ad.download.ag.c$2$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f32291a;

            /* renamed from: b */
            final /* synthetic */ String f32292b;

            public AnonymousClass1(Context context, String str) {
                context = context;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7035c.this.onAppInstalled(C7036d.m42166a(context).mo42105a(str));
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                AbstractC7185ho.m43821b("AgDe", "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    AbstractC7185ho.m43823c("AgDe", "itRe dataString is empty, " + action);
                    return;
                }
                String strSubstring = dataString.substring(8);
                C7035c.this.m42133a(action, strSubstring);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.ag.c.2.1

                        /* renamed from: a */
                        final /* synthetic */ Context f32291a;

                        /* renamed from: b */
                        final /* synthetic */ String f32292b;

                        public AnonymousClass1(Context context2, String strSubstring2) {
                            context = context2;
                            str = strSubstring2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C7035c.this.onAppInstalled(C7036d.m42166a(context).mo42105a(str));
                        }
                    });
                }
            } catch (IllegalStateException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            }
        }
    };

    /* renamed from: o */
    private BroadcastReceiver f32286o = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.ag.c.3

        /* renamed from: com.huawei.openalliance.ad.download.ag.c$3$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f32295a;

            public AnonymousClass1(Context context) {
                context = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7036d.m42166a(context).m42110b();
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(new SafeIntent(intent).getAction())) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        AbstractC7185ho.m43820b("AgDe", "a bad intent");
                    } else if (schemeSpecificPart.equals(C7830i.m48434e(context))) {
                        AbstractC7185ho.m43820b("AgDe", "on hms data cleared.");
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.download.ag.c.3.1

                            /* renamed from: a */
                            final /* synthetic */ Context f32295a;

                            public AnonymousClass1(Context context2) {
                                context = context2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C7036d.m42166a(context).m42110b();
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AgDe", "on data clear received ex: %s", th2.getClass().getSimpleName());
            }
        }
    };

    /* renamed from: p */
    private BroadcastReceiver f32287p = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.ag.c.4
        public AnonymousClass4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7185ho.m43820b("AgDe", "app remove from hms");
            try {
                String stringExtra = intent.getStringExtra(MapKeyNames.PACKAGE_NAME);
                if (TextUtils.isEmpty(stringExtra)) {
                    AbstractC7185ho.m43820b("AgDe", "a bad removed intent");
                } else {
                    C7035c.this.m42123a(context, stringExtra);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AgDe", "appRemovedReceiver err, %s", th2.getClass().getSimpleName());
            }
        }
    };

    /* renamed from: q */
    private BroadcastReceiver f32288q = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.ag.c.6
        public AnonymousClass6() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppInfo appInfoM42222B;
            try {
                AbstractC7185ho.m43820b("AgDe", "get check is need auto open app");
                if (intent == null) {
                    return;
                }
                String stringExtra = intent.getStringExtra("packageName");
                boolean z10 = true;
                if (!TextUtils.isEmpty(stringExtra)) {
                    AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(context).mo42105a(stringExtra);
                    if (appDownloadTaskMo42105a == null || appDownloadTaskMo42105a.m42222B() == null) {
                        AbstractC7185ho.m43820b("AgDe", "task is remove");
                        AppInfo appInfo = new AppInfo();
                        appInfo.m44371a(stringExtra);
                        appInfoM42222B = appInfo;
                    } else {
                        appInfoM42222B = appDownloadTaskMo42105a.m42222B();
                    }
                    if (C7035c.this.f32279g == null || C7035c.this.f32279g.isNeedAutoOpen(appInfoM42222B)) {
                        AbstractC7185ho.m43820b("AgDe", " need auto open");
                    } else {
                        AbstractC7185ho.m43820b("AgDe", "no need auto open");
                        z10 = false;
                    }
                }
                Intent intent2 = new Intent();
                intent2.setAction("huawei.intent.action.AUTO_OPEN_APP");
                intent2.putExtra("autoOpen", z10);
                intent2.setPackage(C7830i.m48434e(context));
                context.sendBroadcast(intent2);
                AbstractC7185ho.m43820b("AgDe", "send auto open");
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("AgDe", "autoOpenRec err: " + th2.getClass().getSimpleName());
            }
        }
    };

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$1 */
    public class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                AbstractC7185ho.m43818a("AgDe", "appRe action: %s", action);
                C7035c.this.m42125a(intent, action);
            } catch (IllegalStateException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("appRe ");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("appRe ");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$2 */
    public class AnonymousClass2 extends BroadcastReceiver {

        /* renamed from: com.huawei.openalliance.ad.download.ag.c$2$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f32291a;

            /* renamed from: b */
            final /* synthetic */ String f32292b;

            public AnonymousClass1(Context context2, String strSubstring2) {
                context = context2;
                str = strSubstring2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7035c.this.onAppInstalled(C7036d.m42166a(context).mo42105a(str));
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context2, Intent intent) {
            StringBuilder sb2;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                AbstractC7185ho.m43821b("AgDe", "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    AbstractC7185ho.m43823c("AgDe", "itRe dataString is empty, " + action);
                    return;
                }
                String strSubstring2 = dataString.substring(8);
                C7035c.this.m42133a(action, strSubstring2);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.ag.c.2.1

                        /* renamed from: a */
                        final /* synthetic */ Context f32291a;

                        /* renamed from: b */
                        final /* synthetic */ String f32292b;

                        public AnonymousClass1(Context context22, String strSubstring22) {
                            context = context22;
                            str = strSubstring22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C7035c.this.onAppInstalled(C7036d.m42166a(context).mo42105a(str));
                        }
                    });
                }
            } catch (IllegalStateException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AgDe", sb2.toString());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$3 */
    public class AnonymousClass3 extends BroadcastReceiver {

        /* renamed from: com.huawei.openalliance.ad.download.ag.c$3$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f32295a;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7036d.m42166a(context).m42110b();
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context2, Intent intent) {
            try {
                if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(new SafeIntent(intent).getAction())) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        AbstractC7185ho.m43820b("AgDe", "a bad intent");
                    } else if (schemeSpecificPart.equals(C7830i.m48434e(context2))) {
                        AbstractC7185ho.m43820b("AgDe", "on hms data cleared.");
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.download.ag.c.3.1

                            /* renamed from: a */
                            final /* synthetic */ Context f32295a;

                            public AnonymousClass1(Context context22) {
                                context = context22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C7036d.m42166a(context).m42110b();
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AgDe", "on data clear received ex: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$4 */
    public class AnonymousClass4 extends BroadcastReceiver {
        public AnonymousClass4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7185ho.m43820b("AgDe", "app remove from hms");
            try {
                String stringExtra = intent.getStringExtra(MapKeyNames.PACKAGE_NAME);
                if (TextUtils.isEmpty(stringExtra)) {
                    AbstractC7185ho.m43820b("AgDe", "a bad removed intent");
                } else {
                    C7035c.this.m42123a(context, stringExtra);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AgDe", "appRemovedReceiver err, %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f32298a;

        /* renamed from: b */
        final /* synthetic */ String f32299b;

        public AnonymousClass5(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(context).mo42105a(str);
            if (appDownloadTaskMo42105a == null || appDownloadTaskMo42105a.m42232L() == AppDownloadTask.EnumC7041b.DOWN_LOAD_MODE_FROM_SELF) {
                return;
            }
            C7036d.m42166a(C7035c.this.f32273a).m42111b((C7036d) appDownloadTaskMo42105a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$6 */
    public class AnonymousClass6 extends BroadcastReceiver {
        public AnonymousClass6() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppInfo appInfoM42222B;
            try {
                AbstractC7185ho.m43820b("AgDe", "get check is need auto open app");
                if (intent == null) {
                    return;
                }
                String stringExtra = intent.getStringExtra("packageName");
                boolean z10 = true;
                if (!TextUtils.isEmpty(stringExtra)) {
                    AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(context).mo42105a(stringExtra);
                    if (appDownloadTaskMo42105a == null || appDownloadTaskMo42105a.m42222B() == null) {
                        AbstractC7185ho.m43820b("AgDe", "task is remove");
                        AppInfo appInfo = new AppInfo();
                        appInfo.m44371a(stringExtra);
                        appInfoM42222B = appInfo;
                    } else {
                        appInfoM42222B = appDownloadTaskMo42105a.m42222B();
                    }
                    if (C7035c.this.f32279g == null || C7035c.this.f32279g.isNeedAutoOpen(appInfoM42222B)) {
                        AbstractC7185ho.m43820b("AgDe", " need auto open");
                    } else {
                        AbstractC7185ho.m43820b("AgDe", "no need auto open");
                        z10 = false;
                    }
                }
                Intent intent2 = new Intent();
                intent2.setAction("huawei.intent.action.AUTO_OPEN_APP");
                intent2.putExtra("autoOpen", z10);
                intent2.setPackage(C7830i.m48434e(context));
                context.sendBroadcast(intent2);
                AbstractC7185ho.m43820b("AgDe", "send auto open");
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("AgDe", "autoOpenRec err: " + th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$7 */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f32302a;

        /* renamed from: b */
        final /* synthetic */ String f32303b;

        /* renamed from: c */
        final /* synthetic */ int f32304c;

        /* renamed from: d */
        final /* synthetic */ String f32305d;

        public AnonymousClass7(Context context, String str, int i10, String str2) {
            context = context;
            str = str;
            i = i10;
            str = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC7615qq interfaceC7615qqM42223C;
            AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(context).mo42105a(str);
            new C6922c(context).m39100a(str, (appDownloadTaskMo42105a == null || (interfaceC7615qqM42223C = appDownloadTaskMo42105a.m42223C()) == null) ? null : interfaceC7615qqM42223C.mo46574a(), i, str, "reqAgPendingIntent");
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.c$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private WeakReference<C7035c> f32307a;

        public a(C7035c c7035c) {
            this.f32307a = new WeakReference<>(c7035c);
        }

        @Override // java.lang.Runnable
        public void run() {
            C7035c c7035c = this.f32307a.get();
            if (c7035c == null) {
                return;
            }
            c7035c.m42143e();
        }
    }

    public C7035c(Context context) {
        String str;
        this.f32273a = context.getApplicationContext();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("huawei.intent.action.DOWNLOAD");
            intentFilter.addAction("huawei.intent.action.OPEN");
            intentFilter.addAction("huawei.intent.action.PENDINGINTENT");
            AbstractC7741ao.m47537a(this.f32273a, this.f32284m, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.PACKAGE_DATA_CLEARED");
            intentFilter2.addDataScheme("package");
            AbstractC7741ao.m47536a(this.f32273a, this.f32286o, intentFilter2);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("huawei.intent.action.CHECK_AUTO_OPEN_APP");
            AbstractC7741ao.m47537a(this.f32273a, this.f32288q, intentFilter3, Constants.PERMISSION_PPS_DOWNLOAD, null);
            AbstractC7741ao.m47537a(this.f32273a, this.f32287p, new IntentFilter("huawei.intent.action.APP.REMOVE"), Constants.PERMISSION_PPS_DOWNLOAD, null);
            C7402ll.m45597a(context).m45599a();
            m42147g();
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            AbstractC7185ho.m43823c("AgDe", str);
        } catch (Exception unused2) {
            str = "registerReceiver Exception";
            AbstractC7185ho.m43823c("AgDe", str);
        }
    }

    /* renamed from: c */
    private void m42137c() {
        AbstractC7768bo.m47810a(this.f32283l);
        AbstractC7768bo.m47809a(new a(this), this.f32283l, this.f32282k);
    }

    /* renamed from: d */
    private synchronized Set<AppDownloadButton.OnResolutionRequiredListener> m42140d(String str) {
        return this.f32280i.get(str);
    }

    /* renamed from: e */
    public void m42143e() {
        AbstractC7185ho.m43820b("AgDe", "unRegisterAppInstReceiver");
        this.f32273a.unregisterReceiver(this.f32285n);
    }

    /* renamed from: f */
    private boolean m42145f() {
        String packageName;
        Context context = this.f32273a;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return false;
        }
        return WhiteListPkgList.isHwBrowserPkgName(packageName);
    }

    /* renamed from: g */
    private static void m42147g() throws SecurityException {
        try {
            for (Method method : C7035c.class.getDeclaredMethods()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(AppDownloadTask.class)) {
                    f32272h.put(method.getName(), method);
                }
            }
        } catch (IllegalArgumentException e10) {
            AbstractC7185ho.m43818a("AgDe", "transport=%s", e10.getMessage());
            AbstractC7185ho.m43826d("AgDe", "transport=" + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: h */
    private void m42149h(AppDownloadTask appDownloadTask) {
        Context context;
        boolean z10;
        if (appDownloadTask == null || appDownloadTask.m42222B() == null) {
            return;
        }
        if (this.f32279g == null || C7045d.m42344a().m42349b() == null || C7045d.m42344a().m42349b().size() == 0) {
            AbstractC7185ho.m43820b("AgDe", " no setting auto open Listener");
            context = this.f32273a;
            z10 = false;
        } else {
            AbstractC7185ho.m43820b("AgDe", " setting auto open Listener");
            context = this.f32273a;
            z10 = true;
        }
        C7038f.m42207a(context, z10, String.class);
    }

    @OuterVisible
    public void onDownloadDeleted(AppDownloadTask appDownloadTask) {
        appDownloadTask.m42059b(0);
        appDownloadTask.m42060b(0L);
        appDownloadTask.m42054a(EnumC7062e.FAILED);
        m42148g(appDownloadTask);
        m42144e(appDownloadTask);
        m42131a(m42145f() ? AppStatus.DOWNLOADCANCELLED : AppStatus.DOWNLOADFAILED, appDownloadTask);
        if (m42134a(appDownloadTask, System.currentTimeMillis())) {
            m42132a(AppStatusV1.CANCEL_DOWNLOAD, appDownloadTask.m42240T(), appDownloadTask);
        }
    }

    @OuterVisible
    public void onDownloadPaused(AppDownloadTask appDownloadTask) {
        m42144e(appDownloadTask);
        m42131a(AppStatus.PAUSE, appDownloadTask);
        m42132a(AppStatusV1.PAUSE, appDownloadTask.m42240T(), appDownloadTask);
    }

    @OuterVisible
    public void onDownloadResumed(AppDownloadTask appDownloadTask) {
        m42144e(appDownloadTask);
        m42131a(AppStatus.RESUME, appDownloadTask);
        m42132a(AppStatusV1.RESUME, 1000, appDownloadTask);
    }

    /* renamed from: a */
    private synchronized Set<InterfaceC7069l> m42120a(AppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(appInfo.getPackageName())) {
                return m42121a(appInfo.getPackageName());
            }
        }
        return null;
    }

    /* renamed from: d */
    private void m42141d() {
        AbstractC7185ho.m43820b("AgDe", "registerAppInstReceiver");
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        AbstractC7741ao.m47536a(this.f32273a, this.f32285n, intentFilter);
    }

    /* renamed from: e */
    private void m42144e(AppDownloadTask appDownloadTask) {
        Set<InterfaceC7069l> setM42120a = m42120a(appDownloadTask.m42222B());
        if (setM42120a == null || setM42120a.size() <= 0) {
            return;
        }
        Iterator<InterfaceC7069l> it = setM42120a.iterator();
        while (it.hasNext()) {
            it.next().mo42628b(appDownloadTask);
        }
    }

    /* renamed from: f */
    private boolean m42146f(AppDownloadTask appDownloadTask) {
        AppInfo appInfoM42222B = appDownloadTask.m42222B();
        if (appInfoM42222B == null) {
            AbstractC7185ho.m43817a("AgDe", "appInfo is null");
            return false;
        }
        if (appInfoM42222B.m44418o() != 1) {
            AbstractC7185ho.m43818a("AgDe", "appInfo's popNotify is not popup immediate, popNotify is %s", Integer.valueOf(appInfoM42222B.m44418o()));
            return false;
        }
        if (TextUtils.isEmpty(appInfoM42222B.m44394f())) {
            AbstractC7185ho.m43817a("AgDe", "appInfo's popUpAfterInstall is null.");
            return false;
        }
        if (!appDownloadTask.m42241U()) {
            AbstractC7185ho.m43817a("AgDe", "this is not task starter");
            return false;
        }
        if (!C7831j.m48457a(this.f32273a, appInfoM42222B.getPackageName(), appDownloadTask)) {
            return true;
        }
        AbstractC7185ho.m43817a("AgDe", "can auto open,no send notification");
        return false;
    }

    /* renamed from: g */
    private void m42148g(AppDownloadTask appDownloadTask) {
        C7036d.m42166a(this.f32273a).m42111b((C7036d) appDownloadTask);
    }

    /* renamed from: b */
    public void m42159b() {
        AbstractC7185ho.m43820b("AgDe", "remove all OnResolutionRequiredListener");
        this.f32281j = null;
        this.f32280i.clear();
    }

    @OuterVisible
    public void onAppInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            AbstractC7185ho.m43817a("AgDe", "task is null onAppInstalled");
            return;
        }
        if (appDownloadTask.m42232L() == AppDownloadTask.EnumC7041b.DOWN_LOAD_MODE_FROM_SELF) {
            AbstractC7185ho.m43817a("AgDe", "task download from self");
            return;
        }
        AbstractC7185ho.m43818a("AgDe", "task is installed and patter is %s", appDownloadTask.m42232L());
        appDownloadTask.m42054a(EnumC7062e.INSTALLED);
        m42131a(AppStatus.INSTALLED, appDownloadTask);
        m42132a(AppStatusV1.INSTALL_SUCCESS, 1000, appDownloadTask);
        m42144e(appDownloadTask);
        if (m42146f(appDownloadTask)) {
            new C7386lf(this.f32273a, appDownloadTask).mo45479b();
        }
        new C7039g(this.f32273a, appDownloadTask).m42213a();
    }

    @OuterVisible
    public void onAppUnInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            String packageName = appDownloadTask.m42222B().getPackageName();
            Set<InterfaceC7069l> setM42121a = m42121a(packageName);
            if (setM42121a != null && setM42121a.size() > 0) {
                Iterator<InterfaceC7069l> it = setM42121a.iterator();
                while (it.hasNext()) {
                    it.next().mo42629b(packageName);
                }
            }
            m42131a(AppStatus.DOWNLOAD, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    @OuterVisible
    public void onDownloadFail(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            AbstractC7185ho.m43821b("AgDe", "onDownloadFail, current way: %s", appDownloadTask.m42228H());
        }
        if (m42165c(appDownloadTask)) {
            return;
        }
        appDownloadTask.m42059b(0);
        appDownloadTask.m42060b(0L);
        m42148g(appDownloadTask);
        m42144e(appDownloadTask);
        m42131a(AppStatus.DOWNLOADFAILED, appDownloadTask);
        m42132a(AppStatusV1.DOWNLOAD_FAILED, appDownloadTask.m42240T(), appDownloadTask);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    @OuterVisible
    public void onDownloadProgress(AppDownloadTask appDownloadTask) {
        m42142d(appDownloadTask);
        AppDownloadListener appDownloadListener = this.f32277e;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadProgress(appDownloadTask.m42222B(), appDownloadTask.m42080l());
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    @OuterVisible
    public void onDownloadStart(AppDownloadTask appDownloadTask) {
        AppStatusV1 appStatusV1;
        m42144e(appDownloadTask);
        m42131a(AppStatus.DOWNLOADING, appDownloadTask);
        if (appDownloadTask.m42080l() > 0 || appDownloadTask.m42075g() > 0) {
            appStatusV1 = AppStatusV1.RESUME;
        } else {
            m42132a(AppStatusV1.PRE_CHECK_SUCCESS, 1000, appDownloadTask);
            appStatusV1 = AppStatusV1.START_DOWNLOAD;
        }
        m42132a(appStatusV1, 1000, appDownloadTask);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    @OuterVisible
    public void onDownloadSuccess(AppDownloadTask appDownloadTask) {
        Object[] objArr = new Object[1];
        objArr[0] = appDownloadTask == null ? null : appDownloadTask.mo42082n();
        AbstractC7185ho.m43821b("AgDe", "down success: %s", objArr);
        this.f32282k = C7124fh.m43316b(this.f32273a).mo43072f();
        m42131a(AppStatus.DOWNLOADED, appDownloadTask);
        m42132a(AppStatusV1.DOWNLOAD_SUCCESS, 1000, appDownloadTask);
        m42141d();
        m42137c();
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    @OuterVisible
    public void onDownloadWaiting(AppDownloadTask appDownloadTask) {
        m42144e(appDownloadTask);
        m42131a(AppStatus.WAITING, appDownloadTask);
        m42132a(AppStatusV1.WAITING, 1000, appDownloadTask);
    }

    @OuterVisible
    public void onSilentInstallFailed(AppDownloadTask appDownloadTask) {
        AppStatus appStatus;
        if (m42165c(appDownloadTask)) {
            return;
        }
        m42144e(appDownloadTask);
        if (appDownloadTask.m42077i() == EnumC7062e.FAILED) {
            m42148g(appDownloadTask);
            appStatus = AppStatus.DOWNLOAD;
        } else {
            appStatus = AppStatus.INSTALL;
        }
        m42131a(appStatus, appDownloadTask);
        m42132a(AppStatusV1.INSTALL_FAILED, -1000, appDownloadTask);
    }

    @OuterVisible
    public void onSilentInstallStart(AppDownloadTask appDownloadTask) {
        m42149h(appDownloadTask);
        m42144e(appDownloadTask);
        m42131a(AppStatus.INSTALLING, appDownloadTask);
        m42132a(AppStatusV1.START_INSTALL, 1000, appDownloadTask);
    }

    @OuterVisible
    public void onSilentInstallSuccess(AppDownloadTask appDownloadTask) {
        m42144e(appDownloadTask);
        m42131a(AppStatus.INSTALLED, appDownloadTask);
        m42132a(AppStatusV1.INSTALL_SUCCESS, 1000, appDownloadTask);
    }

    @OuterVisible
    public void onSystemInstallStart(AppDownloadTask appDownloadTask) {
        m42149h(appDownloadTask);
        m42144e(appDownloadTask);
        m42131a(AppStatus.INSTALL, appDownloadTask);
        m42132a(AppStatusV1.START_INSTALL, 1000, appDownloadTask);
    }

    /* renamed from: a */
    private synchronized Set<InterfaceC7069l> m42121a(String str) {
        return this.f32276d.get(str);
    }

    /* renamed from: d */
    private void m42142d(AppDownloadTask appDownloadTask) {
        Set<InterfaceC7069l> setM42120a = m42120a(appDownloadTask.m42222B());
        if (setM42120a == null || setM42120a.size() <= 0) {
            return;
        }
        Iterator<InterfaceC7069l> it = setM42120a.iterator();
        while (it.hasNext()) {
            it.next().mo42626a(appDownloadTask);
        }
    }

    /* renamed from: a */
    public void m42150a() {
        this.f32281j = null;
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: c */
    public void mo42103c(AppDownloadTask appDownloadTask, boolean z10) {
        onDownloadResumed(appDownloadTask);
        m42132a(z10 ? AppStatusV1.USER_RESUME : AppStatusV1.RESUME, 1000, appDownloadTask);
    }

    /* renamed from: a */
    private void m42122a(Context context, int i10, String str, String str2) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.ag.c.7

            /* renamed from: a */
            final /* synthetic */ Context f32302a;

            /* renamed from: b */
            final /* synthetic */ String f32303b;

            /* renamed from: c */
            final /* synthetic */ int f32304c;

            /* renamed from: d */
            final /* synthetic */ String f32305d;

            public AnonymousClass7(Context context2, String str3, int i102, String str22) {
                context = context2;
                str = str3;
                i = i102;
                str = str22;
            }

            @Override // java.lang.Runnable
            public void run() {
                InterfaceC7615qq interfaceC7615qqM42223C;
                AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(context).mo42105a(str);
                new C6922c(context).m39100a(str, (appDownloadTaskMo42105a == null || (interfaceC7615qqM42223C = appDownloadTaskMo42105a.m42223C()) == null) ? null : interfaceC7615qqM42223C.mo46574a(), i, str, "reqAgPendingIntent");
            }
        });
    }

    /* renamed from: c */
    private void m42139c(String str) {
        Set<AppDownloadButton.OnResolutionRequiredListener> setM42140d = m42140d(str);
        if (!AbstractC7760bg.m47767a(setM42140d)) {
            for (AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener : setM42140d) {
                AppInfo appInfo = new AppInfo();
                appInfo.m44371a(str);
                onResolutionRequiredListener.onResolutionRequired(appInfo, new Bundle());
            }
        }
        if (this.f32281j != null) {
            AppInfo appInfo2 = new AppInfo();
            appInfo2.m44371a(str);
            this.f32281j.onResolutionRequired(appInfo2, new Bundle());
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: b */
    public void mo42101b(AppDownloadTask appDownloadTask) {
    }

    /* renamed from: a */
    public void m42123a(Context context, String str) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.ag.c.5

            /* renamed from: a */
            final /* synthetic */ Context f32298a;

            /* renamed from: b */
            final /* synthetic */ String f32299b;

            public AnonymousClass5(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(context).mo42105a(str);
                if (appDownloadTaskMo42105a == null || appDownloadTaskMo42105a.m42232L() == AppDownloadTask.EnumC7041b.DOWN_LOAD_MODE_FROM_SELF) {
                    return;
                }
                C7036d.m42166a(C7035c.this.f32273a).m42111b((C7036d) appDownloadTaskMo42105a);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: b */
    public void mo42102b(AppDownloadTask appDownloadTask, boolean z10) {
        onDownloadPaused(appDownloadTask);
    }

    /* renamed from: c */
    public boolean m42165c(AppDownloadTask appDownloadTask) {
        return C7046e.m42377h().m42406d(appDownloadTask);
    }

    /* renamed from: a */
    private void m42124a(Intent intent) {
        String stringExtra;
        int intExtra;
        String stringExtra2;
        try {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pendingIntent");
            if (pendingIntent != null) {
                Intent intent2 = new Intent();
                intent2.setClass(this.f32273a, AgProtocolActivity.class);
                intent2.putExtra("pendingIntent", pendingIntent);
                intExtra = intent.getIntExtra("pendingIntent.type", 6);
                intent2.putExtra("pendingIntent.type", intExtra);
                stringExtra = intent.getStringExtra("task.pkg");
                intent2.putExtra("task.pkg", stringExtra);
                stringExtra2 = intent.getStringExtra(MapKeyNames.AG_ACTION_NAME);
                intent2.putExtra(MapKeyNames.AG_ACTION_NAME, stringExtra2);
                intent2.setClipData(Constants.CLIP_DATA);
                Activity curActivity = HiAd.getInstance(this.f32273a).getCurActivity();
                if (curActivity == null || curActivity.isFinishing()) {
                    intent2.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    this.f32273a.startActivity(intent2);
                } else {
                    curActivity.startActivity(intent2);
                }
                m42139c(stringExtra);
            } else {
                stringExtra = null;
                intExtra = -1;
                stringExtra2 = null;
            }
            m42122a(this.f32273a, intExtra, stringExtra, stringExtra2);
        } catch (Throwable unused) {
            AbstractC7185ho.m43820b("AgDe", " requestAgProtocol error");
        }
    }

    /* renamed from: b */
    private void m42136b(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("AgDe", " packageName is empty.");
            return;
        }
        Set<InterfaceC7069l> setM42121a = m42121a(str);
        if (setM42121a == null || setM42121a.size() <= 0) {
            return;
        }
        AbstractC7185ho.m43818a("AgDe", " findAndRefreshTask list:%s", setM42121a.toString());
        Iterator<InterfaceC7069l> it = setM42121a.iterator();
        while (it.hasNext()) {
            it.next().mo42630c(str);
        }
    }

    /* renamed from: a */
    public void m42125a(Intent intent, String str) {
        try {
            Intent intent2 = new Intent(intent);
            if (!"huawei.intent.action.DOWNLOAD".equals(str)) {
                if (!"huawei.intent.action.OPEN".equals(str)) {
                    if ("huawei.intent.action.PENDINGINTENT".equals(str)) {
                        AbstractC7185ho.m43820b("AgDe", " request intent");
                        m42124a(intent2);
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("appPackageName");
                AppDownloadListener appDownloadListener = this.f32277e;
                if (appDownloadListener != null) {
                    appDownloadListener.onAppOpen(stringExtra);
                    return;
                }
                return;
            }
            String stringExtra2 = intent2.getStringExtra("appPackageName");
            AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(this.f32273a).mo42105a(stringExtra2);
            if (appDownloadTaskMo42105a == null) {
                AbstractC7185ho.m43820b("AgDe", " task is null, pkg=" + stringExtra2);
                m42136b(stringExtra2);
                return;
            }
            String stringExtra3 = intent2.getStringExtra("appInfo");
            if (!TextUtils.isEmpty(stringExtra3)) {
                AppInfo appInfo = (AppInfo) AbstractC7758be.m47739b(stringExtra3, AppInfo.class, new Class[0]);
                AppInfo appInfoM42222B = appDownloadTaskMo42105a.m42222B();
                if (appInfo != null && appInfoM42222B != null) {
                    AbstractC7185ho.m43820b("AgDe", "update appInfo from remote task.");
                    appInfoM42222B.m44433v(appInfo.getUniqueId());
                }
            }
            appDownloadTaskMo42105a.m42252f(intent2.getIntExtra("agFailedReason", -1000));
            m42130a(appDownloadTaskMo42105a, intent2);
            String stringExtra4 = intent2.getStringExtra("appDownloadMethod");
            if (TextUtils.isEmpty(stringExtra4)) {
                return;
            }
            if (stringExtra4.equals("onDownloadDeleted")) {
                C7036d.m42166a(this.f32273a).m42112c((C7036d) appDownloadTaskMo42105a);
                return;
            }
            if (stringExtra4.equals("onDownloadStart")) {
                String stringExtra5 = intent2.getStringExtra("agd_event_reason");
                String stringExtra6 = intent2.getStringExtra("agd_install_type");
                if (!AbstractC7806cz.m48165b(stringExtra5)) {
                    appDownloadTaskMo42105a.m42262o(stringExtra5);
                }
                if (!AbstractC7806cz.m48165b(stringExtra6)) {
                    appDownloadTaskMo42105a.m42263p(stringExtra6);
                }
            }
            Method method = f32272h.get(stringExtra4);
            if (method != null) {
                try {
                    try {
                        AbstractC7185ho.m43821b("AgDe", "methodName:%s", stringExtra4);
                        method.invoke(this, appDownloadTaskMo42105a);
                    } catch (IllegalAccessException unused) {
                        AbstractC7185ho.m43824c("AgDe", "ilex=%s", stringExtra4);
                    } catch (Exception e10) {
                        AbstractC7185ho.m43824c("AgDe", "Exception=%s", e10.getClass().getSimpleName());
                    }
                } catch (InvocationTargetException unused2) {
                    AbstractC7185ho.m43824c("AgDe", "itex=%s", stringExtra4);
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("AgDe", "notifyListener Err: " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public synchronized void m42162b(String str, InterfaceC7069l interfaceC7069l) {
        Set<InterfaceC7069l> set = this.f32276d.get(str);
        if (set != null && set.size() > 0) {
            set.remove(interfaceC7069l);
            if (set.size() <= 0) {
                this.f32276d.remove(str);
            }
        }
    }

    /* renamed from: b */
    public synchronized void m42163b(String str, AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        Set<AppDownloadButton.OnResolutionRequiredListener> set = this.f32280i.get(str);
        if (!AbstractC7760bg.m47767a(set)) {
            set.remove(onResolutionRequiredListener);
            if (set.size() <= 0) {
                this.f32280i.remove(str);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: a */
    public void mo42099a(AppDownloadTask appDownloadTask) {
        m42132a(AppStatusV1.WAITING_FOR_WIFI, 1000, appDownloadTask);
    }

    /* renamed from: a */
    private void m42129a(AppDownloadTask appDownloadTask, int i10) {
        appDownloadTask.m42060b((appDownloadTask.m42073f() * i10) / 100);
    }

    /* renamed from: a */
    private void m42130a(AppDownloadTask appDownloadTask, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        appDownloadTask.m42054a(EnumC7062e.m42595a(safeIntent.getIntExtra(UpdateKey.MARKET_DLD_STATUS, EnumC7062e.IDLE.m42596a())));
        AbstractC7185ho.m43818a("AgDe", "download status=%s", appDownloadTask.m42077i());
        appDownloadTask.m42059b(safeIntent.getIntExtra("downloadProgress", 0));
        int intExtra = safeIntent.getIntExtra("pauseReason", DownloadTask.EnumC7031c.NONE.m42098a());
        AbstractC7185ho.m43818a("AgDe", " pauseReason=%d", Integer.valueOf(intExtra));
        appDownloadTask.m42053a(DownloadTask.EnumC7031c.m42097a(intExtra));
        m42129a(appDownloadTask, appDownloadTask.m42080l());
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7032a
    /* renamed from: a */
    public void mo42100a(AppDownloadTask appDownloadTask, boolean z10) {
        onDownloadDeleted(appDownloadTask);
    }

    /* renamed from: a */
    private void m42131a(AppStatus appStatus, AppDownloadTask appDownloadTask) {
        AppDownloadListener appDownloadListener = this.f32277e;
        if (appDownloadListener != null) {
            appDownloadListener.onStatusChanged(appStatus, appDownloadTask.m42222B());
        }
    }

    /* renamed from: a */
    private void m42132a(AppStatusV1 appStatusV1, int i10, AppDownloadTask appDownloadTask) {
        AppDownloadListenerV1 appDownloadListenerV1 = this.f32278f;
        if (appDownloadListenerV1 != null) {
            appDownloadListenerV1.onNewStatusChanged(appStatusV1, i10, appDownloadTask.m42222B());
        }
    }

    /* renamed from: a */
    public void m42153a(AutoOpenListener autoOpenListener) {
        this.f32279g = autoOpenListener;
    }

    /* renamed from: a */
    public void m42154a(AppDownloadListener appDownloadListener) {
        this.f32277e = appDownloadListener;
    }

    /* renamed from: a */
    public void m42155a(AppDownloadListenerV1 appDownloadListenerV1) {
        this.f32278f = appDownloadListenerV1;
    }

    /* renamed from: a */
    public void m42156a(AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        this.f32281j = onResolutionRequiredListener;
    }

    /* renamed from: a */
    public synchronized void m42157a(String str, InterfaceC7069l interfaceC7069l) {
        try {
            Set<InterfaceC7069l> hashSet = this.f32276d.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.f32276d.put(str, hashSet);
            }
            hashSet.add(interfaceC7069l);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m42158a(String str, AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        try {
            Set<AppDownloadButton.OnResolutionRequiredListener> hashSet = this.f32280i.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.f32280i.put(str, hashSet);
            }
            hashSet.add(onResolutionRequiredListener);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public void m42133a(String str, String str2) {
        Set<InterfaceC7069l> setM42121a = m42121a(str2);
        if (setM42121a == null || setM42121a.size() <= 0 || !"android.intent.action.PACKAGE_ADDED".equals(str)) {
            return;
        }
        for (InterfaceC7069l interfaceC7069l : setM42121a) {
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42627a(str2);
            }
        }
    }

    /* renamed from: a */
    private boolean m42134a(AppDownloadTask appDownloadTask, long j10) {
        if (appDownloadTask != null && appDownloadTask.m42222B() != null && !TextUtils.isEmpty(appDownloadTask.m42222B().getPackageName())) {
            if (!TextUtils.isEmpty(this.f32274b)) {
                long j11 = this.f32275c;
                if (j11 != 0) {
                    long j12 = j10 - j11;
                    if (this.f32274b.equals(appDownloadTask.m42222B().getPackageName()) && j12 < 500) {
                        this.f32274b = null;
                        this.f32275c = 0L;
                        AbstractC7185ho.m43820b("AgDe", " repeat cancel");
                        return false;
                    }
                }
            }
            this.f32274b = appDownloadTask.m42222B().getPackageName();
            this.f32275c = j10;
        }
        return true;
    }
}
