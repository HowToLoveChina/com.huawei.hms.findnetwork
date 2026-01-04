package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class UpdateAdapterMgr {
    public static final UpdateAdapterMgr INST = new UpdateAdapterMgr();

    /* renamed from: a */
    private WeakReference<Activity> f23381a;

    /* renamed from: a */
    private Activity m30605a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f23381a;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    public boolean needStartUpdateActivity() {
        Activity activityM30605a = m30605a();
        if (activityM30605a == null) {
            return true;
        }
        if (activityM30605a.isTaskRoot()) {
            return false;
        }
        activityM30605a.finish();
        HMSLog.m36988i("UpdateAdapterMgr", " finish old activity.");
        return true;
    }

    public void onActivityCreate(Activity activity) {
        HMSLog.m36988i("UpdateAdapterMgr", "onActivityCreate");
        Activity activityM30605a = m30605a();
        if (activityM30605a != null) {
            activityM30605a.finish();
            HMSLog.m36988i("UpdateAdapterMgr", "finish old activity.");
        }
        this.f23381a = new WeakReference<>(activity);
    }

    public void onActivityDestroy(Activity activity) {
        HMSLog.m36988i("UpdateAdapterMgr", "onActivityDestroy");
        Activity activityM30605a = m30605a();
        if (activity == null || !activity.equals(activityM30605a)) {
            return;
        }
        HMSLog.m36988i("UpdateAdapterMgr", "reset");
        this.f23381a = null;
    }
}
