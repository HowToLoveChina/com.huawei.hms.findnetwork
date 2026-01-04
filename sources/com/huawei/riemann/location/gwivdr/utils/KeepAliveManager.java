package com.huawei.riemann.location.gwivdr.utils;

import as.C1016d;
import com.huawei.riemann.location.gwivdr.GwiVdrClient;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p784xq.C13850f;

/* loaded from: classes5.dex */
public class KeepAliveManager {
    private static final int RESTART_DELAY_10_MIN = 600;
    private static final int RESTART_DELAY_10_SEC = 10;
    private static final int RESTART_DELAY_1_MIN = 60;
    private static final String TAG = "KeepAliveManager";
    private final GwiVdrClient gwiVdrClient;
    private volatile boolean isVdrStopped = false;
    private int restartDelay = 0;
    private final ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);

    public KeepAliveManager(GwiVdrClient gwiVdrClient) {
        this.gwiVdrClient = gwiVdrClient;
    }

    private boolean isNeedRestartVdr(int i10) {
        return i10 == 77;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setErrorCode$0() {
        this.gwiVdrClient.startVdr();
        this.isVdrStopped = false;
        C1016d.m6186f(TAG, "vdr started");
    }

    public boolean isVdrStopped() {
        return this.isVdrStopped;
    }

    public void setErrorCode(int i10) {
        if (!isNeedRestartVdr(i10) || this.isVdrStopped) {
            return;
        }
        this.gwiVdrClient.stopVdr();
        this.isVdrStopped = true;
        int i11 = this.restartDelay;
        if (i11 >= 60) {
            this.restartDelay = 600;
        } else {
            this.restartDelay = i11 < 10 ? 10 : 60;
        }
        C13850f.m83120a(new StringBuilder("vdr stopped, restart delay: "), this.restartDelay, TAG);
        this.timer.schedule(new Runnable() { // from class: vt.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f60721a.lambda$setErrorCode$0();
            }
        }, this.restartDelay, TimeUnit.SECONDS);
    }

    public String toString() {
        return "KeepAliveManager{isVdrStopped=" + this.isVdrStopped + '}';
    }
}
