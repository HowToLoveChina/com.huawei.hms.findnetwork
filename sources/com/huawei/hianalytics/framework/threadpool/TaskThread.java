package com.huawei.hianalytics.framework.threadpool;

import android.os.HandlerThread;
import android.os.Looper;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class TaskThread {
    public static final int KEEP_ALIVE_TIME = 10000;
    public static final int KEEP_UPDATE_ALIVE_TIME = 60000;
    public static final int MAX_TASK_SIZE = 5000;
    public static final String TAG = "TaskThread";
    public static HandlerThread worker;

    /* renamed from: a */
    public final ThreadPoolExecutor f21812a;
    public static final TaskThread RECORD_THREAD = new TaskThread(5, "OnEvent", 10000);
    public static final TaskThread REPORT_THREAD = new TaskThread(1, "OnReport", 10000);
    public static final TaskThread UPDATE_THREAD = new TaskThread(1, "Update", 60000);

    /* renamed from: com.huawei.hianalytics.framework.threadpool.TaskThread$a */
    public static class RunnableC4766a implements Runnable {

        /* renamed from: a */
        public final Runnable f21813a;

        public RunnableC4766a(Runnable runnable) {
            this.f21813a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f21813a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th2) {
                    HiLog.m28812w(TaskThread.TAG, "error occurred: " + th2.getMessage() + ";" + th2.getCause());
                }
            }
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.threadpool.TaskThread$b */
    public static class ThreadFactoryC4767b implements ThreadFactory {

        /* renamed from: d */
        public static final AtomicInteger f21814d = new AtomicInteger(1);

        /* renamed from: a */
        public final ThreadGroup f21815a;

        /* renamed from: b */
        public final AtomicInteger f21816b = new AtomicInteger(1);

        /* renamed from: c */
        public final String f21817c;

        public ThreadFactoryC4767b(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f21815a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f21817c = "HASDK-" + str + "-" + f21814d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f21815a, runnable, this.f21817c + this.f21816b.getAndIncrement(), 0L);
        }
    }

    public TaskThread(int i10, String str, int i11) {
        this.f21812a = new ThreadPoolExecutor(0, i10, i11, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new ThreadFactoryC4767b(str));
    }

    public static TaskThread getRecordThread() {
        return RECORD_THREAD;
    }

    public static TaskThread getReportThread() {
        return REPORT_THREAD;
    }

    public static TaskThread getUpdateThread() {
        return UPDATE_THREAD;
    }

    public static Looper getWorkLooper() {
        if (worker == null) {
            synchronized (TaskThread.class) {
                try {
                    if (worker == null) {
                        HandlerThread handlerThread = new HandlerThread("HASDK-OnEvent-31");
                        worker = handlerThread;
                        handlerThread.start();
                    }
                } finally {
                }
            }
        }
        HandlerThread handlerThread2 = worker;
        return handlerThread2 != null ? handlerThread2.getLooper() : Looper.getMainLooper();
    }

    public void addToQueue(Runnable runnable) {
        try {
            this.f21812a.execute(new RunnableC4766a(runnable));
        } catch (RejectedExecutionException unused) {
            HiLog.m28812w(TAG, "exception has happened from rejected execution");
        }
    }
}
