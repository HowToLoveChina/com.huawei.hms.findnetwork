package com.huawei.hms.findnetwork.util;

import com.huawei.hms.findnetwork.threadpool.NameThreadFactory;
import com.huawei.hms.findnetwork.threadpool.TaskWrapper;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class ScheduleThreadPool extends ScheduledThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int DEFAULT_KEEPALIVE_MILLIS = 60;
    private static final int SCHEDULED_MAX_POOL_SIZE = 20;
    private static final String TAG = "ScheduleThreadPool";
    private static volatile ScheduleThreadPool sInstance;

    private ScheduleThreadPool() {
        super(0);
        setMaximumPoolSize(20);
        setKeepAliveTime(60L, TimeUnit.SECONDS);
        setThreadFactory(new NameThreadFactory("Nearby-nStackX-Timer"));
    }

    public static ScheduleThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (ScheduleThreadPool.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ScheduleThreadPool();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public ScheduledFuture<?> scheduleTask(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            HmsFindSDKLog.m32128w(TAG, "task is null.");
            return null;
        }
        if (timeUnit == null) {
            HmsFindSDKLog.m32128w(TAG, "unit is null.");
            return null;
        }
        try {
            return sInstance.schedule(new TaskWrapper(TAG, runnable), j10, timeUnit);
        } catch (Exception e10) {
            HmsFindSDKLog.m32125d(TAG, "schedule task failed, " + e10.getMessage());
            return null;
        }
    }

    public ScheduledFuture<?> scheduleTaskAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        if (runnable == null) {
            HmsFindSDKLog.m32128w(TAG, "task is null.");
            return null;
        }
        if (timeUnit == null) {
            HmsFindSDKLog.m32128w(TAG, "unit is null.");
            return null;
        }
        if (j11 <= 0) {
            HmsFindSDKLog.m32128w(TAG, "delay is illegal");
            return null;
        }
        try {
            return sInstance.scheduleAtFixedRate(new TaskWrapper(TAG, runnable), j10, j11, timeUnit);
        } catch (Exception e10) {
            HmsFindSDKLog.m32125d(TAG, "schedule task failed, " + e10.getMessage());
            return null;
        }
    }

    public ScheduledFuture<?> scheduleTaskWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        if (runnable == null) {
            HmsFindSDKLog.m32128w(TAG, "task is null.");
            return null;
        }
        if (timeUnit == null) {
            HmsFindSDKLog.m32128w(TAG, "unit is null.");
            return null;
        }
        if (j11 <= 0) {
            HmsFindSDKLog.m32128w(TAG, "delay is illegal");
            return null;
        }
        try {
            return sInstance.scheduleWithFixedDelay(new TaskWrapper(TAG, runnable), j10, j11, timeUnit);
        } catch (Exception e10) {
            HmsFindSDKLog.m32125d(TAG, "schedule task failed, " + e10.getMessage());
            return null;
        }
    }
}
