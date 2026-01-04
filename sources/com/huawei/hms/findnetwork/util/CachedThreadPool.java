package com.huawei.hms.findnetwork.util;

import com.huawei.hms.findnetwork.threadpool.NameThreadFactory;
import com.huawei.hms.findnetwork.threadpool.TaskWrapper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class CachedThreadPool {
    private static final int DEFAULT_KEEPALIVE_MILLIS = 60;
    private static final String TAG = "CachedThreadPool";
    private static final int THREAD_MAX_DEFAULT = 4;
    private static final int THREAD_MAX_LIMIT = 40;
    private static final int THREAD_MIN_DEFAULT = 4;
    private static final String THREAD_POOL_NAME_CORE = "Nearby-nStackX-Core";
    private static final String THREAD_POOL_NAME_SEQ = "Nearby-nStackX-Seq";
    private static final int THREAD_SYSTEM_CORES_RATIO = 2;
    private static volatile CachedThreadPool sInstance;
    private ThreadPoolExecutor mCoreExecutor;
    private ThreadPoolExecutor mSeqTaskExecutor;

    private CachedThreadPool() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new NameThreadFactory(THREAD_POOL_NAME_SEQ), new ThreadPoolExecutor.CallerRunsPolicy());
        this.mSeqTaskExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(4, getMaxPoolSize(), 60L, timeUnit, new SynchronousQueue(), new NameThreadFactory(THREAD_POOL_NAME_CORE), new ThreadPoolExecutor.CallerRunsPolicy());
        this.mCoreExecutor = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
    }

    private String appendExtraInfo(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        for (String str : strArr) {
            if (str != null && str.contains(":")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length >= 2) {
                    sb2.append(StringUtil.wrapQuotes(strArrSplit[0]) + ":" + StringUtil.wrapQuotes(strArrSplit[1]));
                    sb2.append(", ");
                }
            }
        }
        if (sb2.length() > 2) {
            sb2.setLength(sb2.length() - 2);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public static CachedThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (CachedThreadPool.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new CachedThreadPool();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private int getMaxPoolSize() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        HmsFindSDKLog.m32125d(TAG, "cores num is " + iAvailableProcessors);
        int i10 = iAvailableProcessors * 2;
        if (i10 >= 40) {
            return 40;
        }
        return Math.max(i10, 4);
    }

    private String getPrintExtraInfo(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return ", extraInfo=" + str;
    }

    public void execNormalTask(String str, Runnable runnable, String... strArr) {
        String strAppendExtraInfo = appendExtraInfo(strArr);
        if (str == null || runnable == null) {
            HmsFindSDKLog.m32128w(TAG, "task is null" + getPrintExtraInfo(strAppendExtraInfo));
            return;
        }
        try {
            this.mCoreExecutor.execute(new TaskWrapper(str, runnable));
        } catch (Exception e10) {
            HmsFindSDKLog.m32128w(TAG, str + " exec normal task failed, " + e10.getMessage() + getPrintExtraInfo(strAppendExtraInfo));
        }
    }

    public void execSafeTask(String str, Runnable runnable, String... strArr) {
        if (runnable == null) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th2) {
            HmsFindSDKLog.m32126e(str, "Execute task exception: " + th2.getMessage() + getPrintExtraInfo(appendExtraInfo(strArr)));
        }
    }

    public void execSeqTask(String str, Runnable runnable, String... strArr) {
        String strAppendExtraInfo = appendExtraInfo(strArr);
        if (str == null || runnable == null) {
            HmsFindSDKLog.m32128w(TAG, "task is null" + getPrintExtraInfo(strAppendExtraInfo));
            return;
        }
        try {
            this.mSeqTaskExecutor.execute(new TaskWrapper(str, runnable));
        } catch (Exception e10) {
            HmsFindSDKLog.m32128w(TAG, str + " exec sequence task failed, " + e10.getMessage() + getPrintExtraInfo(strAppendExtraInfo));
        }
    }
}
