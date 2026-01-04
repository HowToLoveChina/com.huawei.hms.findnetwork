package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;

/* renamed from: com.huawei.hms.network.ai.k */
/* loaded from: classes8.dex */
public class RunnableC5806k implements Runnable {

    /* renamed from: a */
    public Runnable f25940a;

    public RunnableC5806k(Runnable runnable) {
        this.f25940a = runnable;
    }

    /* renamed from: a */
    public void m33410a(Throwable th2) {
        HianalyticsHelper.getInstance().reportException(th2, CrashHianalyticsData.EVENT_ID_CRASH);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f25940a.run();
        } catch (Throwable th2) {
            Logger.m32139e("ai", "train task exception!", th2);
            m33410a(th2);
        }
    }
}
