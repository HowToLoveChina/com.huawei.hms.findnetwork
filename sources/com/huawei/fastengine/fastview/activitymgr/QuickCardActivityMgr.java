package com.huawei.fastengine.fastview.activitymgr;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class QuickCardActivityMgr implements Application.ActivityLifecycleCallbacks, ComponentCallbacks {
    public static final QuickCardActivityMgr INST = new QuickCardActivityMgr();
    private static final String TAG = "QuickCardActivityMgr";
    private Application application;
    private List<IConfigurationCallback> configurationCallbacks = new ArrayList();
    private Map<Activity, List<IActivityLifecycleForCard>> activityLifeCycleCallbacks = new HashMap();

    private QuickCardActivityMgr() {
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    public void clearActivitLifeCycleCallbacks() {
        FastViewLogUtils.m28722d(TAG, "clearActivitLifeCycleCallbacks");
        this.activityLifeCycleCallbacks.clear();
    }

    public void clearConfigurationCallbacks() {
        FastViewLogUtils.m28722d(TAG, "clearConfigurationCallback");
        this.configurationCallbacks.clear();
    }

    public void init(Application application) {
        FastViewLogUtils.m28722d(TAG, "init");
        Application application2 = this.application;
        if (application2 != null) {
            application2.unregisterActivityLifecycleCallbacks(this);
            this.application.unregisterComponentCallbacks(this);
        }
        this.application = application;
        application.registerActivityLifecycleCallbacks(this);
        application.registerComponentCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        List<IActivityLifecycleForCard> list = this.activityLifeCycleCallbacks.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        FastViewLogUtils.m28722d(TAG, "onDestroyed:" + objDesc(activity));
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            ((IActivityLifecycleForCard) it.next()).onActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        List<IActivityLifecycleForCard> list = this.activityLifeCycleCallbacks.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        FastViewLogUtils.m28722d(TAG, "onPaused:" + objDesc(activity));
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            ((IActivityLifecycleForCard) it.next()).onActivityPause(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        List<IActivityLifecycleForCard> list = this.activityLifeCycleCallbacks.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        FastViewLogUtils.m28722d(TAG, "onResumed:" + objDesc(activity));
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            ((IActivityLifecycleForCard) it.next()).onActivityResume(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        List<IActivityLifecycleForCard> list = this.activityLifeCycleCallbacks.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        FastViewLogUtils.m28722d(TAG, "onStarted:" + objDesc(activity));
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            ((IActivityLifecycleForCard) it.next()).onActivityStart(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        List<IActivityLifecycleForCard> list = this.activityLifeCycleCallbacks.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        FastViewLogUtils.m28722d(TAG, "onStopped:" + objDesc(activity));
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            ((IActivityLifecycleForCard) it.next()).onActivityStop(activity);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        FastViewLogUtils.m28722d(TAG, "onConfigurationChanged");
        for (IConfigurationCallback iConfigurationCallback : new ArrayList(this.configurationCallbacks)) {
            if (iConfigurationCallback != null) {
                iConfigurationCallback.onActivityConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public void registerActivitLifeCycleEvent(Activity activity, IActivityLifecycleForCard iActivityLifecycleForCard) {
        List<IActivityLifecycleForCard> arrayList = this.activityLifeCycleCallbacks.get(activity);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.activityLifeCycleCallbacks.put(activity, arrayList);
        }
        if (arrayList.contains(iActivityLifecycleForCard)) {
            return;
        }
        arrayList.add(iActivityLifecycleForCard);
    }

    public void registerConfigurationEvent(IConfigurationCallback iConfigurationCallback) {
        if (this.configurationCallbacks.contains(iConfigurationCallback)) {
            return;
        }
        this.configurationCallbacks.add(iConfigurationCallback);
    }

    public void release() {
        FastViewLogUtils.m28722d(TAG, "release");
        Application application = this.application;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
            this.application.unregisterComponentCallbacks(this);
        }
        clearActivitLifeCycleCallbacks();
        clearConfigurationCallbacks();
        this.application = null;
    }

    public void unRegisterActivitLifeCycleEvent(Activity activity, IActivityLifecycleForCard iActivityLifecycleForCard) {
        try {
            List<IActivityLifecycleForCard> list = this.activityLifeCycleCallbacks.get(activity);
            if (list != null) {
                list.remove(iActivityLifecycleForCard);
                if (list.isEmpty()) {
                    this.activityLifeCycleCallbacks.remove(activity);
                }
            }
        } catch (Exception unused) {
            FastViewLogUtils.m28724e(TAG, "unRegisterActivityLifeCycle Exception");
        }
    }

    public void unRegisterConfigurationEvent(IConfigurationCallback iConfigurationCallback) {
        try {
            this.configurationCallbacks.remove(iConfigurationCallback);
        } catch (Exception unused) {
            FastViewLogUtils.m28724e(TAG, "unRegisterOnConfiguration Exception");
        }
    }
}
