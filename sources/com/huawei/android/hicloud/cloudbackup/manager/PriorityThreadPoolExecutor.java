package com.huawei.android.hicloud.cloudbackup.manager;

import java.util.Objects;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    public static class ComparableFutureTask<T> extends FutureTask<T> implements Comparable<ComparableFutureTask> {
        private Runnable runnable;

        public ComparableFutureTask(Runnable runnable, T t10) {
            super(runnable, t10);
            this.runnable = runnable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.runnable, ((ComparableFutureTask) obj).runnable);
        }

        public int hashCode() {
            return Objects.hash(this.runnable);
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask comparableFutureTask) {
            if (comparableFutureTask == null) {
                return -1;
            }
            if (this == comparableFutureTask) {
                return 0;
            }
            Runnable runnable = this.runnable;
            if (runnable instanceof Comparable) {
                return ((Comparable) runnable).compareTo(comparableFutureTask.runnable);
            }
            return 0;
        }
    }

    public PriorityThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit) {
        super(i10, i11, j10, timeUnit, new PriorityBlockingQueue(11));
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        if (runnable == null) {
            return null;
        }
        return runnable instanceof Comparable ? new ComparableFutureTask(runnable, t10) : super.newTaskFor(runnable, t10);
    }
}
