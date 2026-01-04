package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import eg.AbstractC9478g;
import java.lang.ref.WeakReference;
import p015ak.C0209d;
import p015ak.C0226l0;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public class LocateTrackEventManager {

    /* renamed from: b */
    public static LocateTrackEventManager f20341b = new LocateTrackEventManager();

    /* renamed from: a */
    public LocateTrackTask f20342a;

    public static class StartLocateTrackTask extends AbstractC9478g {

        /* renamed from: a */
        public WeakReference<Context> f20343a;

        public StartLocateTrackTask(Context context) {
            this.f20343a = new WeakReference<>(context);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Context context = this.f20343a.get();
            if (context == null) {
                C13981a.m83988e("LocateTrackEventManager", "StartLocateTrackTask--mContext.get() == null");
            } else {
                C13981a.m83989i("LocateTrackEventManager", "PhoneFinder onAppStart start task");
                C0226l0.m1584d(new RunnableC4436a(context, C4450l.m27010f(context)));
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.LocateTrackEventManager$a */
    public static class RunnableC4436a implements Runnable {

        /* renamed from: a */
        public Context f20344a;

        /* renamed from: b */
        public boolean f20345b;

        public RunnableC4436a(Context context, boolean z10) {
            this.f20344a = context;
            this.f20345b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20345b && C4450l.m27011g(this.f20344a) && C4452n.m27030j(this.f20344a)) {
                LocateTrackEventManager.m26909a().m26912d(this.f20344a, false);
                C4441c.m26949o(this.f20344a).m26970v();
            } else {
                C4450l.m27015k(this.f20344a, false);
                C4441c.m26949o(this.f20344a).m26968t();
            }
        }
    }

    /* renamed from: a */
    public static LocateTrackEventManager m26909a() {
        return f20341b;
    }

    /* renamed from: b */
    public void m26910b(Context context) {
        C12515a.m75110o().m75172d(new StartLocateTrackTask(context));
        C13981a.m83989i("LocateTrackEventManager", "PhoneFinder onAppStart task add");
    }

    /* renamed from: c */
    public boolean m26911c(Context context, String str) {
        C13981a.m83989i("LocateTrackEventManager", "preLocateTrackTask start, queryTrackPeriod doQuery");
        if (!C4450l.m27010f(context)) {
            C13981a.m83988e("LocateTrackEventManager", "preLocateTrackTask AntiTheftDataManager getPhoneFinderSwitch error");
            return false;
        }
        String deviceID = AbstractC12139d.m72766e(context).getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            C13981a.m83988e("LocateTrackEventManager", "preLocateTrackTask->deviceID is null");
            return false;
        }
        String deviceType = AbstractC12139d.m72766e(context).getDeviceType();
        if (TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e("LocateTrackEventManager", "preLocateTrackTask->deviceType is null");
            return false;
        }
        new C4449k(str, deviceID, deviceType, AbstractC12139d.m72766e(context).getServiceToken(), new C4448j(context, str), context).m27003d();
        return true;
    }

    /* renamed from: d */
    public synchronized void m26912d(Context context, boolean z10) {
        try {
            C13981a.m83989i("LocateTrackEventManager", "startLocateTrackTask begin,isDelayed task:" + z10);
            if (C4450l.m27010f(context) && C4452n.m27030j(context)) {
                if (this.f20342a == null) {
                    this.f20342a = new LocateTrackTask(context);
                }
                if (z10) {
                    this.f20342a.m26923c();
                } else {
                    this.f20342a.m26924d();
                }
                C4450l.m27015k(context, true);
                C13981a.m83989i("LocateTrackEventManager", "startLocateTrackTask...");
            } else {
                C13981a.m83989i("LocateTrackEventManager", "status error, need stopLocateTrackTask");
                context.sendBroadcast(new Intent("com.huawei.android.remotecontrol.intent.STOP_TRACK"), "com.huawei.remotocontrol.permission.REMOTECALL");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public void m26913e(Context context) {
        C13981a.m83989i("LocateTrackEventManager", "start low power mode");
        Intent intent = new Intent(C0209d.m1277l1() ? "com.hihonor.intent.action.FIND_PHONE_BACK" : "com.huawei.intent.action.FIND_PHONE_BACK");
        intent.putExtra(MapKeyNames.PACKAGE_NAME, context.getPackageName());
        context.sendBroadcast(intent, C0209d.m1277l1() ? "com.hihonor.systemmanager.permission.ACCESS_INTERFACE" : "com.huawei.systemmanager.permission.ACCESS_INTERFACE");
    }

    /* renamed from: f */
    public synchronized void m26914f(Context context, boolean z10) {
        if (this.f20342a == null) {
            return;
        }
        C13981a.m83989i("LocateTrackEventManager", "stopLocateTrackTask...");
        if (z10) {
            this.f20342a.m26927g();
            return;
        }
        this.f20342a.m26928h();
        this.f20342a = null;
        C4450l.m27020p(context);
        C4450l.m27015k(context, false);
        C4450l.m27005a(context);
    }
}
