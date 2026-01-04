package com.huawei.hms.network.embedded;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContextHolder;

/* renamed from: com.huawei.hms.network.embedded.q2 */
/* loaded from: classes8.dex */
public class C6057q2 {

    /* renamed from: b */
    public static final String f27827b = "activity";

    /* renamed from: a */
    public Application.ActivityLifecycleCallbacks f27828a;

    /* renamed from: com.huawei.hms.network.embedded.q2$a */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            C5846a3.reportSysEvent(Long.valueOf(System.currentTimeMillis()), "activity", activity.getComponentName().getClassName() + "_onCreate");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            C5846a3.reportSysEvent(Long.valueOf(System.currentTimeMillis()), "activity", activity.getComponentName().getClassName() + "_onDestroyed");
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
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.q2$b */
    public static class b {

        /* renamed from: a */
        public static C6057q2 f27830a = new C6057q2(null);
    }

    public C6057q2() {
    }

    public /* synthetic */ C6057q2(a aVar) {
        this();
    }

    public static C6057q2 getInstance() {
        return b.f27830a;
    }

    public void init() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            a aVar = new a();
            this.f27828a = aVar;
            ((Application) appContext).registerActivityLifecycleCallbacks(aVar);
        }
    }
}
