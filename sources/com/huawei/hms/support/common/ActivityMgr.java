package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = new ActivityMgr();

    /* renamed from: a */
    private WeakReference<Activity> f29962a;

    private ActivityMgr() {
    }

    /* renamed from: a */
    private static String m36805a(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    public Activity getCurrentActivity() {
        if (this.f29962a == null) {
            HMSLog.m36988i("ActivityMgr", "mCurrentActivity is " + this.f29962a);
            return null;
        }
        HMSLog.m36988i("ActivityMgr", "mCurrentActivity.get() is " + this.f29962a.get());
        return this.f29962a.get();
    }

    public void init(Application application) {
        HMSLog.m36983d("ActivityMgr", "init");
        if (application == null) {
            HMSLog.m36989w("ActivityMgr", "init failed for app is null");
            return;
        }
        ActivityMgr activityMgr = INST;
        application.unregisterActivityLifecycleCallbacks(activityMgr);
        application.registerActivityLifecycleCallbacks(activityMgr);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        HMSLog.m36983d("ActivityMgr", "onCreated:" + m36805a(activity));
        this.f29962a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        HMSLog.m36983d("ActivityMgr", "onResumed:" + m36805a(activity));
        this.f29962a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        HMSLog.m36983d("ActivityMgr", "onStarted:" + m36805a(activity));
        this.f29962a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
