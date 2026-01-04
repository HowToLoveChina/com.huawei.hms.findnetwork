package com.huawei.hianalytics;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.huawei.hianalytics.y0 */
/* loaded from: classes5.dex */
public class C4816y0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public static C4816y0 f21996a;

    /* renamed from: a */
    public static ConcurrentHashMap<String, C4747d1> f21997a;

    /* renamed from: a */
    public Handler f21998a;

    /* renamed from: a */
    public final Set<Integer> f21999a;

    /* renamed from: a */
    public final AtomicLong f22000a;

    /* renamed from: com.huawei.hianalytics.y0$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                C4816y0.this.getClass();
                for (C4747d1 c4747d1 : C4816y0.f21997a.values()) {
                    if (c4747d1 != null) {
                        c4747d1.onReport(0);
                        c4747d1.onReport(1);
                    }
                }
            }
        }
    }

    public C4816y0() {
        m29059a();
        this.f21999a = new HashSet();
        this.f22000a = new AtomicLong(0L);
        f21997a = new ConcurrentHashMap<>();
    }

    /* renamed from: a */
    public static C4816y0 m29058a() {
        if (f21996a == null) {
            f21996a = new C4816y0();
        }
        return f21996a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ConcurrentHashMap<String, C4747d1> concurrentHashMap = f21997a;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || activity == null || this.f21999a.contains(Integer.valueOf(activity.hashCode()))) {
            return;
        }
        this.f21999a.add(Integer.valueOf(activity.hashCode()));
        this.f22000a.incrementAndGet();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ConcurrentHashMap<String, C4747d1> concurrentHashMap = f21997a;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || activity == null || !this.f21999a.contains(Integer.valueOf(activity.hashCode())) || this.f22000a.decrementAndGet() > 0) {
            return;
        }
        this.f21998a.sendEmptyMessage(1);
    }

    /* renamed from: a */
    public final void m29059a() {
        HandlerThread handlerThread = new HandlerThread("HA_BACKGROUND_REPORT");
        handlerThread.start();
        this.f21998a = new a(handlerThread.getLooper());
    }
}
