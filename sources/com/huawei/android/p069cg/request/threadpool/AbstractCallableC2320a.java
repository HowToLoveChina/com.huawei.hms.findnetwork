package com.huawei.android.p069cg.request.threadpool;

import com.huawei.hms.network.embedded.C5863b6;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p031b7.C1120a;

/* renamed from: com.huawei.android.cg.request.threadpool.a */
/* loaded from: classes2.dex */
public abstract class AbstractCallableC2320a<V> implements Callable<V> {
    private static final String EXCEPTION_MESSAGE = "BaseCallable shutdown";
    private static final ReentrantLock PAUSE_LOCK_CALLABLE;
    private static final ReentrantLock PAUSE_LOCK_POOL;
    private static final String TAG = "BaseCallable";
    private static boolean isPauseCallable = false;
    private static boolean isPausePool = false;
    private static Condition unpausedCallable;
    private static Condition unpausedPool;
    private Object callParam;
    protected int cancelCode;
    private C2321b conditionTool;
    private ExecutorService currentExecutorService;
    private int currentRetry;
    private boolean executed;
    private Vector<Map<String, Object>> fixedThreadPoolExecutedList;
    private Vector<Map<String, Object>> fixedThreadPoolList;
    protected boolean isCancel;
    protected boolean isTimeout;
    private boolean nextShutDown;
    private Object preCallResult;
    private boolean priority;
    private int retry;
    private boolean shutdownFlag;
    private AbstractC2329j singleCallablePool;
    private int threadType;
    private int thumbType;
    private long timeout;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        PAUSE_LOCK_POOL = reentrantLock;
        unpausedPool = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        PAUSE_LOCK_CALLABLE = reentrantLock2;
        unpausedCallable = reentrantLock2.newCondition();
        isPauseCallable = false;
    }

    public AbstractCallableC2320a(Object obj) {
        this.preCallResult = null;
        this.timeout = C5863b6.g.f26453g;
        this.retry = 1;
        this.currentRetry = 1;
        this.nextShutDown = false;
        this.priority = false;
        this.threadType = 0;
        this.shutdownFlag = false;
        this.fixedThreadPoolList = null;
        this.fixedThreadPoolExecutedList = null;
        this.executed = false;
        this.currentExecutorService = null;
        this.thumbType = 0;
        this.conditionTool = null;
        this.cancelCode = 115;
        this.isCancel = false;
        this.isTimeout = false;
        this.callParam = obj;
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] com.huawei.android.cg.request.threadpool.a.class) */
    public static synchronized void pause(int i10) {
        synchronized (AbstractCallableC2320a.class) {
            C1120a.m6675d(TAG, "pause...threadType:" + i10);
            if (i10 == 0 || i10 == 1) {
                ReentrantLock reentrantLock = PAUSE_LOCK_POOL;
                reentrantLock.lock();
                try {
                    isPausePool = true;
                    reentrantLock.unlock();
                    if (i10 != 0 || i10 == 2) {
                        ReentrantLock reentrantLock2 = PAUSE_LOCK_CALLABLE;
                        reentrantLock2.lock();
                        try {
                            isPauseCallable = true;
                            reentrantLock2.unlock();
                        } catch (Throwable th2) {
                            PAUSE_LOCK_CALLABLE.unlock();
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    PAUSE_LOCK_POOL.unlock();
                    throw th3;
                }
            } else {
                if (i10 != 0) {
                }
                ReentrantLock reentrantLock22 = PAUSE_LOCK_CALLABLE;
                reentrantLock22.lock();
                isPauseCallable = true;
                reentrantLock22.unlock();
            }
        }
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] com.huawei.android.cg.request.threadpool.a.class) */
    public static synchronized void resume(int i10) {
        synchronized (AbstractCallableC2320a.class) {
            C1120a.m6675d(TAG, "resume...threadType:" + i10);
            if (i10 == 0 || i10 == 1) {
                ReentrantLock reentrantLock = PAUSE_LOCK_POOL;
                reentrantLock.lock();
                try {
                    isPausePool = false;
                    unpausedPool.signalAll();
                    reentrantLock.unlock();
                    if (i10 != 0 || i10 == 2) {
                        ReentrantLock reentrantLock2 = PAUSE_LOCK_CALLABLE;
                        reentrantLock2.lock();
                        try {
                            isPauseCallable = false;
                            unpausedCallable.signalAll();
                            reentrantLock2.unlock();
                        } catch (Throwable th2) {
                            PAUSE_LOCK_CALLABLE.unlock();
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    PAUSE_LOCK_POOL.unlock();
                    throw th3;
                }
            } else {
                if (i10 != 0) {
                }
                ReentrantLock reentrantLock22 = PAUSE_LOCK_CALLABLE;
                reentrantLock22.lock();
                isPauseCallable = false;
                unpausedCallable.signalAll();
                reentrantLock22.unlock();
            }
        }
    }

    public boolean baseEquals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.concurrent.Callable
    public abstract V call() throws Exception;

    public boolean cancel() {
        this.isCancel = true;
        if (getConditionTool() != null) {
            return getConditionTool().m14592a().cancel(true);
        }
        return false;
    }

    public Object getCallParam() {
        return this.callParam;
    }

    public int getCancelCode() {
        return this.cancelCode;
    }

    public C2321b getConditionTool() {
        return this.conditionTool;
    }

    public ExecutorService getCurrentExecutorService() {
        return this.currentExecutorService;
    }

    public int getCurrentRetry() {
        return this.currentRetry;
    }

    public Vector<Map<String, Object>> getFixedThreadPoolExecutedList() {
        return this.fixedThreadPoolExecutedList;
    }

    public Vector<Map<String, Object>> getFixedThreadPoolList() {
        return this.fixedThreadPoolList;
    }

    public Object getPreCallResult() {
        return this.preCallResult;
    }

    public int getRetry() {
        return this.retry;
    }

    public AbstractC2329j getSingleCallablePool() {
        return null;
    }

    public synchronized int getThreadType() {
        return this.threadType;
    }

    public int getThumbType() {
        return this.thumbType;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void handleCallException(Exception exc) {
    }

    public boolean isCancel() {
        return this.isCancel;
    }

    public boolean isExecuted() {
        return this.executed;
    }

    public boolean isNextShutDown() {
        return this.nextShutDown;
    }

    public boolean isPriority() {
        return this.priority;
    }

    public boolean isShutdown() {
        return this.shutdownFlag;
    }

    public synchronized void onPause() throws Exception {
        int i10;
        int i11;
        try {
            if (isShutdown() || (getCurrentExecutorService() != null && getCurrentExecutorService().isShutdown())) {
                C1120a.m6675d(TAG, EXCEPTION_MESSAGE);
                throw new InterruptedException(EXCEPTION_MESSAGE);
            }
            PAUSE_LOCK_POOL.lock();
            try {
                if (isPausePool) {
                    C1120a.m6675d(TAG, "onPausePool check in...");
                    while (isPausePool && ((i11 = this.threadType) == 0 || i11 == 1)) {
                        C1120a.m6675d(TAG, "onPausePool await...");
                        unpausedPool.await();
                    }
                    C1120a.m6675d(TAG, "onPausePool check out...");
                }
                PAUSE_LOCK_POOL.unlock();
                PAUSE_LOCK_CALLABLE.lock();
                try {
                    if (isPauseCallable) {
                        C1120a.m6675d(TAG, "onPauseCallable check in...");
                        while (isPauseCallable && ((i10 = this.threadType) == 0 || i10 == 2)) {
                            C1120a.m6675d(TAG, "onPauseCallable await...");
                            unpausedCallable.await();
                        }
                        C1120a.m6675d(TAG, "onPauseCallable check out...");
                    }
                    PAUSE_LOCK_CALLABLE.unlock();
                } finally {
                    PAUSE_LOCK_CALLABLE.unlock();
                }
            } finally {
                PAUSE_LOCK_POOL.unlock();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void onTimeout() {
        this.isTimeout = true;
    }

    public void setCancel(boolean z10) {
    }

    public void setCancelCode(int i10) {
        this.cancelCode = i10;
    }

    public void setConditionTool(C2321b c2321b) {
        this.conditionTool = c2321b;
    }

    public void setCurrentExecutorService(ExecutorService executorService) {
        this.currentExecutorService = executorService;
    }

    public void setCurrentRetry(int i10) {
        this.currentRetry = i10;
    }

    public void setExecuted(boolean z10) {
        this.executed = z10;
    }

    public void setFixedThreadPoolExecutedList(Vector<Map<String, Object>> vector) {
        this.fixedThreadPoolExecutedList = vector;
    }

    public void setFixedThreadPoolList(Vector<Map<String, Object>> vector) {
        this.fixedThreadPoolList = vector;
    }

    public void setPreCallResult(Object obj) {
        this.preCallResult = obj;
    }

    public void setPriority(boolean z10) {
        this.priority = z10;
    }

    public void setSingleCallablePool(AbstractC2329j abstractC2329j) {
    }

    public synchronized void setThreadType(int i10) {
        this.threadType = i10;
    }

    public void setThumbType(int i10) {
        this.thumbType = i10;
    }

    public void shutDown() {
        this.shutdownFlag = true;
    }

    public boolean cancel(int i10) {
        setCancelCode(i10);
        this.isCancel = true;
        if (getConditionTool() != null) {
            return getConditionTool().m14592a().cancel(true);
        }
        return false;
    }

    public AbstractCallableC2320a(Object obj, int i10, long j10) {
        this.preCallResult = null;
        this.retry = 1;
        this.currentRetry = 1;
        this.nextShutDown = false;
        this.priority = false;
        this.threadType = 0;
        this.shutdownFlag = false;
        this.fixedThreadPoolList = null;
        this.fixedThreadPoolExecutedList = null;
        this.executed = false;
        this.currentExecutorService = null;
        this.conditionTool = null;
        this.cancelCode = 115;
        this.isCancel = false;
        this.isTimeout = false;
        this.callParam = obj;
        this.thumbType = i10;
        this.timeout = j10;
    }

    public AbstractCallableC2320a(Object obj, long j10) {
        this.preCallResult = null;
        this.retry = 1;
        this.currentRetry = 1;
        this.nextShutDown = false;
        this.priority = false;
        this.threadType = 0;
        this.shutdownFlag = false;
        this.fixedThreadPoolList = null;
        this.fixedThreadPoolExecutedList = null;
        this.executed = false;
        this.currentExecutorService = null;
        this.thumbType = 0;
        this.conditionTool = null;
        this.cancelCode = 115;
        this.isCancel = false;
        this.isTimeout = false;
        this.callParam = obj;
        this.timeout = j10;
    }

    public AbstractCallableC2320a(Object obj, long j10, int i10, boolean z10) {
        this.preCallResult = null;
        this.currentRetry = 1;
        this.priority = false;
        this.threadType = 0;
        this.shutdownFlag = false;
        this.fixedThreadPoolList = null;
        this.fixedThreadPoolExecutedList = null;
        this.executed = false;
        this.currentExecutorService = null;
        this.thumbType = 0;
        this.conditionTool = null;
        this.cancelCode = 115;
        this.isCancel = false;
        this.isTimeout = false;
        this.callParam = obj;
        this.timeout = j10;
        this.retry = i10;
        this.nextShutDown = z10;
    }
}
