package com.huawei.riemann.location.gwivdr.utils;

import android.os.Build;
import android.os.Process;
import as.C1016d;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class InputFreqCheckThread extends Thread {
    private static final int ACC_TAG = 1;
    private static final int GYRO_TAG = 2;
    private static final Object LOCK = new Object();
    private static final int MAX_DEQUE_SIZE = 5000;
    private static final int MAX_IMU_INTERVAL_MS = 200;
    private static final int MAX_WSS_INTERVAL_MS = 500;
    private static final int MIN_IMU_FREQUENCY = 10;
    private static final int MIN_WSS_FREQUENCY = 1;
    private static final String TAG = "InputFreqCheckThread";
    private static final int WSS_TAG = 3;
    private static volatile InputFreqCheckThread freqCheckThread;
    private final LinkedBlockingDeque<Long> accTimeDeque;
    private final LinkedBlockingDeque<Long> gyroTimeDeque;
    private ScheduledExecutorService timer;
    private final LinkedBlockingDeque<Long> wssTimeDeque;

    private InputFreqCheckThread() {
        super("InputFreqChecker");
        this.accTimeDeque = new LinkedBlockingDeque<>(5000);
        this.gyroTimeDeque = new LinkedBlockingDeque<>(5000);
        this.wssTimeDeque = new LinkedBlockingDeque<>(5000);
    }

    private void checkDataPeriodically() {
        String str;
        if (this.accTimeDeque == null || this.gyroTimeDeque == null) {
            C1016d.m6183c(TAG, "invalid sdk_ver: " + Build.VERSION.SDK_INT);
            return;
        }
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.timer = scheduledExecutorServiceNewScheduledThreadPool;
        try {
            scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: vt.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60720a.lambda$checkDataPeriodically$0();
                }
            }, 1000L, 1000L, TimeUnit.MILLISECONDS);
        } catch (IllegalArgumentException unused) {
            str = "invalid argument!";
            C1016d.m6183c(TAG, str);
        } catch (RejectedExecutionException unused2) {
            str = "reject execute!";
            C1016d.m6183c(TAG, str);
        }
    }

    private static void clearThread() {
        freqCheckThread = null;
    }

    private LinkedBlockingDeque<Long> getDeque(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? new LinkedBlockingDeque<>(1) : this.wssTimeDeque : this.gyroTimeDeque : this.accTimeDeque;
    }

    public static InputFreqCheckThread getInstance() {
        if (freqCheckThread == null) {
            synchronized (InputFreqCheckThread.class) {
                try {
                    if (freqCheckThread == null) {
                        freqCheckThread = new InputFreqCheckThread();
                    }
                } finally {
                }
            }
        }
        return freqCheckThread;
    }

    private String getKeyWord(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "unknown" : "wss" : "imu_gyro" : "imu_acc";
    }

    private int getLowFreqErrorCode(int i10) {
        if (i10 == 1) {
            return 202;
        }
        if (i10 == 2) {
            return 212;
        }
        if (i10 != 3) {
            return 500;
        }
        return Constant.ERROR_WSS_LOW_FREQ;
    }

    private int getMinFreq(int i10) {
        return (i10 == 1 || i10 == 2) ? 10 : 1;
    }

    private int getNoDataErrorCode(int i10) {
        if (i10 == 1) {
            return 201;
        }
        if (i10 == 2) {
            return 211;
        }
        if (i10 != 3) {
            return 500;
        }
        return Constant.ERROR_WSS_NO_DATA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDataPeriodically$0() {
        refreshDeque(1);
        refreshDeque(2);
        refreshDeque(3);
        C1016d.m6186f(TAG, "Input freq [acc|gyro|wss]: [" + this.accTimeDeque.size() + "|" + this.gyroTimeDeque.size() + "|" + this.wssTimeDeque.size() + "]");
    }

    private void refreshDeque(int i10) {
        String keyWord = getKeyWord(i10);
        LinkedBlockingDeque<Long> deque = getDeque(i10);
        if (deque.size() == 0) {
            C1016d.m6183c(TAG, keyWord + " null deque!");
            return;
        }
        synchronized (LOCK) {
            try {
                if (deque.isEmpty()) {
                    ErrorCodeManager.setErrorCode(getNoDataErrorCode(i10));
                    C1016d.m6183c(TAG, keyWord + " no data!");
                    return;
                }
                while (!deque.isEmpty()) {
                    Long lPoll = deque.poll();
                    if (lPoll == null) {
                        C1016d.m6183c(TAG, keyWord + " null item!");
                    } else if (System.currentTimeMillis() - lPoll.longValue() <= 1000) {
                        break;
                    }
                }
                int size = deque.size();
                if (size >= getMinFreq(i10)) {
                    ErrorCodeManager.setErrorCode(0);
                    return;
                }
                C1016d.m6183c(TAG, keyWord + " invalid freq: " + size);
                ErrorCodeManager.setErrorCode(getLowFreqErrorCode(i10));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void accEnqueue(long j10) {
        if (this.accTimeDeque == null) {
            C1016d.m6183c(TAG, "null accTimeDeque!");
            return;
        }
        synchronized (LOCK) {
            try {
                if (this.accTimeDeque.isEmpty()) {
                    if (!this.accTimeDeque.offer(Long.valueOf(j10))) {
                        C1016d.m6183c(TAG, "accDeque error!");
                    }
                    return;
                }
                try {
                    Long last = this.accTimeDeque.getLast();
                    if (last == null) {
                        C1016d.m6183c(TAG, "null acc item!");
                        return;
                    }
                    if (j10 >= 0 && last.longValue() >= 0) {
                        long jAbs = Math.abs(j10 - last.longValue());
                        if (jAbs > 200) {
                            C1016d.m6181a(TAG, "acc interval: " + jAbs);
                            ErrorCodeManager.setErrorCode(203);
                        }
                        if (!this.accTimeDeque.offer(Long.valueOf(j10))) {
                            C1016d.m6181a(TAG, "offer acc failed!");
                        }
                        return;
                    }
                    C1016d.m6183c(TAG, "invalid acc time: " + j10 + "/" + last);
                } catch (NoSuchElementException unused) {
                    C1016d.m6183c(TAG, "no acc item in deque!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof InputFreqCheckThread)) {
            return false;
        }
        InputFreqCheckThread inputFreqCheckThread = (InputFreqCheckThread) obj;
        if (Objects.equals(this.accTimeDeque, inputFreqCheckThread.accTimeDeque) && Objects.equals(this.gyroTimeDeque, inputFreqCheckThread.gyroTimeDeque)) {
            return Objects.equals(this.wssTimeDeque, inputFreqCheckThread.wssTimeDeque);
        }
        return false;
    }

    public void gyroEnqueue(long j10) {
        if (this.gyroTimeDeque == null) {
            C1016d.m6183c(TAG, "null gyroDeque!");
            return;
        }
        synchronized (LOCK) {
            try {
                if (this.gyroTimeDeque.isEmpty()) {
                    if (!this.gyroTimeDeque.offer(Long.valueOf(j10))) {
                        C1016d.m6183c(TAG, "gyroDeque error!");
                    }
                    return;
                }
                try {
                    Long last = this.gyroTimeDeque.getLast();
                    if (last == null) {
                        C1016d.m6183c(TAG, "null gyro item!");
                        return;
                    }
                    if (j10 >= 0 && last.longValue() >= 0) {
                        long jAbs = Math.abs(j10 - last.longValue());
                        if (jAbs > 200) {
                            C1016d.m6181a(TAG, "gyro interval: " + jAbs);
                            ErrorCodeManager.setErrorCode(213);
                        }
                        if (!this.gyroTimeDeque.offer(Long.valueOf(j10))) {
                            C1016d.m6181a(TAG, "offer gyro error!");
                        }
                        return;
                    }
                    C1016d.m6183c(TAG, "invalid gyro time: " + j10 + "/" + last);
                } catch (NoSuchElementException unused) {
                    C1016d.m6183c(TAG, "no gyro item in deque!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int hashCode() {
        LinkedBlockingDeque<Long> linkedBlockingDeque = this.accTimeDeque;
        int iHashCode = (linkedBlockingDeque != null ? linkedBlockingDeque.hashCode() : 0) * 31;
        LinkedBlockingDeque<Long> linkedBlockingDeque2 = this.gyroTimeDeque;
        int iHashCode2 = (iHashCode + (linkedBlockingDeque2 != null ? linkedBlockingDeque2.hashCode() : 0)) * 31;
        LinkedBlockingDeque<Long> linkedBlockingDeque3 = this.wssTimeDeque;
        return iHashCode2 + (linkedBlockingDeque3 != null ? linkedBlockingDeque3.hashCode() : 0);
    }

    @Override // java.lang.Thread
    public void interrupt() {
        super.interrupt();
        stopChecker();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws SecurityException, IllegalArgumentException {
        C1016d.m6186f(TAG, "thread name: " + getName());
        Process.setThreadPriority(-4);
        checkDataPeriodically();
    }

    public void stopChecker() {
        ScheduledExecutorService scheduledExecutorService;
        C1016d.m6183c(TAG, "ready to stop FreqChecker.");
        synchronized (LOCK) {
            try {
                clearThread();
                LinkedBlockingDeque<Long> linkedBlockingDeque = this.accTimeDeque;
                if (linkedBlockingDeque != null) {
                    linkedBlockingDeque.clear();
                }
                LinkedBlockingDeque<Long> linkedBlockingDeque2 = this.gyroTimeDeque;
                if (linkedBlockingDeque2 != null) {
                    linkedBlockingDeque2.clear();
                }
                LinkedBlockingDeque<Long> linkedBlockingDeque3 = this.wssTimeDeque;
                if (linkedBlockingDeque3 != null) {
                    linkedBlockingDeque3.clear();
                }
                try {
                    scheduledExecutorService = this.timer;
                } catch (InterruptedException e10) {
                    C1016d.m6183c(TAG, "watchDogThread timer exception: " + e10.getMessage());
                    this.timer.shutdownNow();
                }
                if (scheduledExecutorService == null) {
                    C1016d.m6190j(TAG, "timer is null!");
                    return;
                }
                scheduledExecutorService.shutdown();
                if (!this.timer.awaitTermination(10L, TimeUnit.MILLISECONDS)) {
                    this.timer.shutdownNow();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void wssEnqueue(long j10) {
        if (this.wssTimeDeque == null) {
            C1016d.m6183c(TAG, "null wssDeque!");
            return;
        }
        synchronized (LOCK) {
            try {
                if (this.wssTimeDeque.isEmpty()) {
                    if (!this.wssTimeDeque.offer(Long.valueOf(j10))) {
                        C1016d.m6183c(TAG, "wssDeque error!");
                    }
                    return;
                }
                try {
                    Long last = this.wssTimeDeque.getLast();
                    if (last == null) {
                        C1016d.m6183c(TAG, "null wss item!");
                        return;
                    }
                    if (j10 >= 0 && last.longValue() >= 0) {
                        long jAbs = Math.abs(j10 - last.longValue());
                        if (jAbs > 500) {
                            C1016d.m6183c(TAG, "wss interval: " + jAbs);
                            ErrorCodeManager.setErrorCode(Constant.ERROR_WSS_TIME_DIFF_LARGE);
                        }
                        if (!this.wssTimeDeque.offer(Long.valueOf(j10))) {
                            C1016d.m6183c(TAG, "offer wss error!");
                        }
                        return;
                    }
                    C1016d.m6183c(TAG, "invalid wss time: " + j10 + "/" + last);
                } catch (NoSuchElementException unused) {
                    C1016d.m6183c(TAG, "no wss item in deque!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
