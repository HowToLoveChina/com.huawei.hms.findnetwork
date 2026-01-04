package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
class BindingFailedResolveMgr {

    /* renamed from: b */
    static final BindingFailedResolveMgr f23328b = new BindingFailedResolveMgr();

    /* renamed from: c */
    private static final Object f23329c = new Object();

    /* renamed from: a */
    List<Activity> f23330a = new ArrayList(1);

    /* renamed from: a */
    public void m30561a(Activity activity) {
        synchronized (f23329c) {
            try {
                for (Activity activity2 : this.f23330a) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.f23330a.add(activity);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m30562b(Activity activity) {
        synchronized (f23329c) {
            this.f23330a.remove(activity);
        }
    }
}
