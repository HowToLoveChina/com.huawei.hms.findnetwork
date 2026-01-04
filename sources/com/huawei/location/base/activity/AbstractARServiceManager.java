package com.huawei.location.base.activity;

import android.content.Context;
import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p531or.C11991a;

/* loaded from: classes8.dex */
public abstract class AbstractARServiceManager {
    private static final String TAG = "AbstractARServiceManager";
    protected long lastTimeByTimer = -1;
    protected Context mContext = C11991a.m72145a();
    protected ActivityRecognitionMappingManager recognitionMappingManager;
    protected ScheduledExecutorService scheduledExecutorService;
    protected ScheduledFuture scheduledFuture;
    protected ActivityTransitionMappingManager transitionMappingManager;

    public AbstractARServiceManager(ActivityTransitionMappingManager activityTransitionMappingManager, ActivityRecognitionMappingManager activityRecognitionMappingManager) {
        this.transitionMappingManager = activityTransitionMappingManager;
        this.recognitionMappingManager = activityRecognitionMappingManager;
    }

    public boolean checkActivityRecognitionPermission(ClientInfo clientInfo) {
        if (clientInfo == null) {
            return false;
        }
        return ARLocationPermissionManager.checkCPActivityRecognitionPermission(TAG, clientInfo.getClientPid(), clientInfo.getClientUid());
    }

    public abstract boolean connectService();

    public abstract boolean disConnectService();

    public abstract ActivityRecognitionResult getDetectedActivity(int i10, int i11);

    public ActivityRecognitionMappingManager getRecognitionRequestMapping() {
        return this.recognitionMappingManager;
    }

    public Runnable getTask() {
        return null;
    }

    public ActivityTransitionMappingManager getTransitionMappingManager() {
        return this.transitionMappingManager;
    }

    public abstract boolean isConnected();

    public abstract void removeActivityTransitionUpdates(ATCallback aTCallback, ClientInfo clientInfo);

    public abstract void removeActivityUpdates(ARCallback aRCallback, ClientInfo clientInfo);

    public abstract void requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo);

    public abstract void requestActivityUpdates(long j10, ARCallback aRCallback, ClientInfo clientInfo);

    public void restartScheduled(long j10) {
        stopScheduled();
        startScheduled(j10);
    }

    public synchronized void scheduleTimer() {
        long minTime;
        try {
            minTime = this.recognitionMappingManager.getMinTime();
        } catch (Exception unused) {
            C1016d.m6185e(TAG, "scheduleTimer exception", true);
        }
        if (-1 == minTime) {
            C1016d.m6186f(TAG, "scheduleTimer return time is " + minTime);
            this.lastTimeByTimer = -1L;
            stopScheduled();
            return;
        }
        long j10 = this.lastTimeByTimer;
        if (j10 == -1) {
            C1016d.m6186f(TAG, "scheduleTimer begin time is " + minTime);
            this.lastTimeByTimer = minTime;
            startScheduled(minTime);
        } else if (minTime != j10) {
            C1016d.m6186f(TAG, "scheduleTimer begin again time is " + minTime);
            this.lastTimeByTimer = minTime;
            restartScheduled(minTime);
        }
    }

    public void startScheduled(long j10) {
        C1016d.m6186f(TAG, "startScheduled enter");
        if (this.scheduledExecutorService == null) {
            this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        }
        this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(getTask(), 0L, j10, TimeUnit.MILLISECONDS);
        C1016d.m6186f(TAG, "startScheduled exit");
    }

    public void stopScheduled() {
        C1016d.m6186f(TAG, "stopScheduled enter");
        try {
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                C1016d.m6186f(TAG, "stopScheduled exit:" + this.scheduledFuture.cancel(true));
                return;
            }
            C1016d.m6186f(TAG, "scheduled not init or cancelled");
        } catch (Exception unused) {
            C1016d.m6185e(TAG, "stopScheduled exit exception", true);
        }
    }
}
