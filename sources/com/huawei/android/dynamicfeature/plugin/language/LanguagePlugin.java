package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class LanguagePlugin extends AbstractC2401i {
    private AbstractC2393a installStrategy;

    private void registerActivityLifecycleCallbacks(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                LanguagePlugin.this.activityInit(activity);
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
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }
        });
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2401i
    public void activityInit(Activity activity) {
        if (this.installStrategy == null) {
            this.installStrategy = C2394b.m14988a(activity.getApplicationContext());
        }
        this.installStrategy.mo14980a(activity);
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2401i
    public void appInit(Context context, Application application) {
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2401i
    public void appOnCreate(Application application) {
        AbstractC2393a abstractC2393aM14988a = C2394b.m14988a(application.getApplicationContext());
        this.installStrategy = abstractC2393aM14988a;
        abstractC2393aM14988a.mo14986h(application);
        registerActivityLifecycleCallbacks(application);
    }
}
