package com.huawei.hianalytics;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hianalytics.C4805t;
import com.huawei.hianalytics.C4817z;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DaoManager;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.p100dc.StateKeeper;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.common.PackageConstants;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hianalytics.t */
/* loaded from: classes5.dex */
public class C4805t {

    /* renamed from: a */
    public static HandlerC4807u f21932a = null;

    /* renamed from: a */
    public static String f21933a = "";

    /* renamed from: b */
    public static HandlerC4807u f21934b;

    /* renamed from: a */
    public static void m29026a() {
        if (StateKeeper.isInit()) {
            HiLog.m28810si("CC", "unregister");
            try {
                InterfaceC4783i0 interfaceC4783i0M28957a = C4789k0.m28957a();
                InterfaceC4780h0 interfaceC4780h0Mo28830b = interfaceC4783i0M28957a.mo28830b();
                interfaceC4780h0Mo28830b.mo28817c();
                interfaceC4780h0Mo28830b.mo28814a();
                InterfaceC4780h0 interfaceC4780h0Mo28828a = interfaceC4783i0M28957a.mo28828a();
                interfaceC4780h0Mo28828a.mo28817c();
                interfaceC4780h0Mo28828a.mo28814a();
                StateKeeper.setInit(false);
            } catch (Throwable th2) {
                HiLog.m28809i("CC", "unregister " + th2.getMessage());
            }
        }
    }

    /* renamed from: b */
    public static /* synthetic */ void m29030b(String str) {
        synchronized (StateKeeper.class) {
            m29034e(str);
        }
    }

    /* renamed from: c */
    public static void m29032c(String str) {
        if (StateKeeper.isInit()) {
            HiLog.m28807d("CC", "register has init");
            return;
        }
        try {
            if (f21932a == null) {
                f21932a = new HandlerC4807u(TaskThread.getWorkLooper(), 1, str);
            }
            if (m29029a()) {
                HiLog.m28810si("CC", "register");
                InterfaceC4783i0 interfaceC4783i0M28957a = C4789k0.m28957a();
                InterfaceC4780h0 interfaceC4780h0Mo28830b = interfaceC4783i0M28957a.mo28830b();
                interfaceC4780h0Mo28830b.mo28816b();
                C4798p c4798p = new C4798p(f21932a, str);
                interfaceC4780h0Mo28830b.mo28815a(c4798p);
                HandlerC4807u handlerC4807u = f21932a;
                handlerC4807u.getClass();
                handlerC4807u.f21938b = new WeakReference<>(c4798p);
                InterfaceC4780h0 interfaceC4780h0Mo28828a = interfaceC4783i0M28957a.mo28828a();
                interfaceC4780h0Mo28828a.mo28816b();
                C4809v c4809v = new C4809v(f21932a, str);
                interfaceC4780h0Mo28828a.mo28815a(c4809v);
                HandlerC4807u handlerC4807u2 = f21932a;
                handlerC4807u2.getClass();
                handlerC4807u2.f21936a = new WeakReference<>(c4809v);
                C4730b0 c4730b0 = new C4730b0(f21932a, str);
                interfaceC4780h0Mo28828a.mo28815a(c4730b0);
                HandlerC4807u handlerC4807u3 = f21932a;
                handlerC4807u3.getClass();
                handlerC4807u3.f21939c = new WeakReference<>(c4730b0);
                StateKeeper.setInit(true);
            }
        } catch (Throwable th2) {
            HiLog.m28809i("CC", "register " + th2.getMessage());
        }
    }

    /* renamed from: d */
    public static void m29033d(final String str) {
        for (String str2 : InterfaceC4776g.f21821a) {
            if (TextUtils.equals(str2, str)) {
                TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        C4805t.m29027a(str);
                    }
                });
                return;
            }
        }
    }

    /* renamed from: e */
    public static void m29034e(String str) {
        HiLog.m28810si("CC", "registerMetric");
        if (StateKeeper.isMetricInit()) {
            HiLog.m28807d("CC", "registerMetric has init");
            return;
        }
        try {
            if (m29031b()) {
                if (f21934b == null) {
                    f21934b = new HandlerC4807u(TaskThread.getWorkLooper(), 2, str);
                }
                C4785j.m28912a();
                SQLiteDatabase writableDatabase = C4796o.m28972a(EnvUtils.getAppContext(), "haformal_event.db", null, 6).getWritableDatabase();
                DaoManager.getInstance().createMcInfoTable(writableDatabase);
                DaoManager.getInstance().createMcTagTable(writableDatabase);
                C4727a0 c4727a0 = new C4727a0(f21934b);
                HandlerC4807u handlerC4807u = f21934b;
                handlerC4807u.getClass();
                handlerC4807u.f21940d = new WeakReference<>(c4727a0);
                C4817z c4817z = C4817z.c.f22010a;
                c4817z.f22002a = c4727a0;
                c4817z.m29062b();
                InterfaceC4780h0 interfaceC4780h0Mo28830b = C4789k0.m28957a().mo28830b();
                interfaceC4780h0Mo28830b.mo28816b();
                C4798p c4798p = new C4798p(f21934b, str);
                interfaceC4780h0Mo28830b.mo28815a(c4798p);
                HandlerC4807u handlerC4807u2 = f21934b;
                handlerC4807u2.getClass();
                handlerC4807u2.f21938b = new WeakReference<>(c4798p);
                StateKeeper.setMetricInit(true);
            }
        } catch (Throwable th2) {
            HiLog.m28809i("CC", "registerMetric: " + th2.getMessage());
        }
    }

    /* renamed from: f */
    public static void m29035f(final String str) {
        if (C4811w.m29047a().f21966c.contains(str)) {
            f21933a = str;
            TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.h
                @Override // java.lang.Runnable
                public final void run() {
                    C4805t.m29030b(str);
                }
            });
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m29027a(String str) {
        synchronized (StateKeeper.class) {
            m29032c(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (r0.contains("metrics1.data") == false) goto L25;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m29031b() {
        /*
            com.huawei.hianalytics.w r0 = com.huawei.hianalytics.C4811w.m29047a()
            r0.getClass()
            android.content.Context r1 = com.huawei.hianalytics.core.common.EnvUtils.getAppContext()
            java.lang.String r1 = com.huawei.hianalytics.C4785j.m28930b(r1)
            java.util.List<java.lang.String> r0 = r0.f21963b
            boolean r0 = r0.contains(r1)
            r1 = 0
            if (r0 != 0) goto L19
            return r1
        L19:
            boolean r0 = com.huawei.hianalytics.C4785j.m28935b()
            java.lang.String r2 = "CC"
            if (r0 != 0) goto L27
            java.lang.String r0 = "not China rom"
            com.huawei.hianalytics.core.log.HiLog.m28807d(r2, r0)
            return r1
        L27:
            java.lang.String r0 = "Analytics_Kit_Tag"
            com.huawei.hianalytics.process.HiAnalyticsInstance r0 = com.huawei.hianalytics.process.HiAnalyticsManager.getInstanceByTag(r0)
            if (r0 != 0) goto L30
            goto L5d
        L30:
            com.huawei.hianalytics.w r3 = com.huawei.hianalytics.C4811w.m29047a()
            boolean r3 = r3.f21964b
            if (r3 != 0) goto L39
            goto L63
        L39:
            java.lang.String r0 = r0.getCollectUrl()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L44
            goto L5d
        L44:
            java.lang.String r3 = "metrics1-drcn"
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L63
            java.lang.String r3 = "metrics-drcn"
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L63
            java.lang.String r3 = "metrics1.data"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L5d
            goto L63
        L5d:
            java.lang.String r0 = "not China url"
            com.huawei.hianalytics.core.log.HiLog.m28807d(r2, r0)
            return r1
        L63:
            boolean r0 = com.huawei.hianalytics.C4785j.m28951h()
            if (r0 != 0) goto L6f
            java.lang.String r0 = "not phone or pad"
            com.huawei.hianalytics.core.log.HiLog.m28807d(r2, r0)
            return r1
        L6f:
            boolean r0 = com.huawei.hianalytics.C4785j.m28945d()
            if (r0 != 0) goto L7b
            java.lang.String r0 = "emui level below 29"
            com.huawei.hianalytics.core.log.HiLog.m28807d(r2, r0)
            return r1
        L7b:
            android.content.Context r0 = com.huawei.hianalytics.core.common.EnvUtils.getAppContext()
            java.lang.String r3 = "android.permission.STATUS_BAR_SERVICE"
            int r0 = r0.checkSelfPermission(r3)
            if (r0 == 0) goto L99
            android.content.Context r0 = com.huawei.hianalytics.core.common.EnvUtils.getAppContext()
            java.lang.String r3 = "android.permission.MEDIA_CONTENT_CONTROL"
            int r0 = r0.checkSelfPermission(r3)
            if (r0 == 0) goto L99
            java.lang.String r0 = "permission is denied"
            com.huawei.hianalytics.core.log.HiLog.m28807d(r2, r0)
            return r1
        L99:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4805t.m29031b():boolean");
    }

    /* renamed from: a */
    public static boolean m29029a() {
        String str;
        if (C4803s.m29018a().f21918a) {
            String strM28930b = C4785j.m28930b(EnvUtils.getAppContext());
            if (HiLog.isDebugEnable()) {
                HiLog.m28807d("CC", "current process " + strM28930b);
            }
            if (!TextUtils.equals(strM28930b, "com.huawei.hwid.core") && !TextUtils.equals(strM28930b, PackageConstants.GENERAL_SERVICES_ACTION)) {
                return false;
            }
            if (!C4785j.m28935b()) {
                str = "not China rom";
            } else {
                if (C4785j.m28951h()) {
                    boolean zM28947e = C4785j.m28947e();
                    if (zM28947e) {
                        try {
                            Class.forName("com.hihonor.android.app.IHwActivityNotifierEx");
                        } catch (Throwable unused) {
                        }
                    } else {
                        if (zM28947e) {
                            return false;
                        }
                        try {
                            Class.forName("com.huawei.android.app.IHwActivityNotifierEx");
                        } catch (Throwable unused2) {
                            return false;
                        }
                    }
                    return true;
                }
                str = "not phone or pad";
            }
        } else {
            str = "isCollectEnable false";
        }
        HiLog.m28807d("CC", str);
        return false;
    }

    /* renamed from: a */
    public static void m29028a(boolean z10) {
        if (z10) {
            if (TextUtils.isEmpty(f21933a) || HiAnalyticsManager.getInstanceByTag(f21933a) == null) {
                return;
            }
            m29035f(f21933a);
            return;
        }
        synchronized (StateKeeper.class) {
            try {
                if (StateKeeper.isInit()) {
                    HiLog.m28810si("CC", "unregisterMetric");
                    C4817z c4817z = C4817z.c.f22010a;
                    synchronized (c4817z) {
                        HiLog.m28807d("MediaHelper", "unregister");
                        if (c4817z.f22007a) {
                            c4817z.f22003a.unregisterEventObserver(c4817z.f22004a);
                        }
                    }
                    StateKeeper.setInit(false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
