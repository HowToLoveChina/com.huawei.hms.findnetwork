package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ApkResolutionFailedManager {

    /* renamed from: c */
    private static final ApkResolutionFailedManager f23124c = new ApkResolutionFailedManager();

    /* renamed from: a */
    private final Handler f23125a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private final Map<String, Runnable> f23126b = new HashMap(2);

    private ApkResolutionFailedManager() {
    }

    public static ApkResolutionFailedManager getInstance() {
        return f23124c;
    }

    public void postTask(String str, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.m36986e("ApkResolutionFailedManager", "postTask is not in main thread");
        } else {
            this.f23126b.put(str, runnable);
            this.f23125a.postDelayed(runnable, RippleView.SINGLE_RIPPLE_TIME);
        }
    }

    public void removeTask(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.m36986e("ApkResolutionFailedManager", "removeTask is not in main thread");
            return;
        }
        Runnable runnableRemove = this.f23126b.remove(str);
        if (runnableRemove == null) {
            HMSLog.m36986e("ApkResolutionFailedManager", "cancel runnable is null");
        } else {
            this.f23125a.removeCallbacks(runnableRemove);
        }
    }

    public void removeValueOnly(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.m36986e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        } else {
            this.f23126b.remove(str);
        }
    }
}
