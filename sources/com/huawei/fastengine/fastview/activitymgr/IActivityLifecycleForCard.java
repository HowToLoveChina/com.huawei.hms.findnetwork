package com.huawei.fastengine.fastview.activitymgr;

import android.app.Activity;

/* loaded from: classes5.dex */
public interface IActivityLifecycleForCard {
    void onActivityDestroyed(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityResume(Activity activity);

    void onActivityStart(Activity activity);

    void onActivityStop(Activity activity);
}
