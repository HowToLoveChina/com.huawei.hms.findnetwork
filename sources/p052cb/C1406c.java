package p052cb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import p514o9.C11839m;

/* renamed from: cb.c */
/* loaded from: classes3.dex */
public class C1406c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public int f6030a = 0;

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
        int i10 = this.f6030a + 1;
        this.f6030a = i10;
        if (i10 == 1) {
            C11839m.m70686d("AnrDetectorLifecycleCallbacks", "process Foreground");
            C1405b.m8109e().m8115h();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i10 = this.f6030a - 1;
        this.f6030a = i10;
        if (i10 == 0) {
            C11839m.m70686d("AnrDetectorLifecycleCallbacks", "process Background");
            C1405b.m8109e().m8116i();
        }
    }
}
