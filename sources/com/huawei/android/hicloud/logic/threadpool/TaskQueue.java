package com.huawei.android.hicloud.logic.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TaskQueue {

    /* renamed from: a */
    public ThreadPoolExecutor f12245a;

    /* renamed from: b */
    public int f12246b;

    /* renamed from: c */
    public int f12247c;

    /* renamed from: d */
    public C2806b<Runnable> f12248d;

    public interface ITaskObserver {
        /* renamed from: a */
        void mo16411a();

        /* renamed from: b */
        void mo16412b();
    }

    /* renamed from: com.huawei.android.hicloud.logic.threadpool.TaskQueue$b */
    public static class C2806b<E> extends LinkedBlockingQueue<E> {
        private static final long serialVersionUID = -7927047142685926618L;

        /* renamed from: a */
        public boolean f12249a;

        public C2806b() {
            this.f12249a = true;
        }

        /* renamed from: b */
        public void m16413b(boolean z10) {
            this.f12249a = z10;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E e10) {
            return this.f12249a && super.offer(e10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.logic.threadpool.TaskQueue$c */
    public static class CallableC2807c implements Callable<Integer> {

        /* renamed from: a */
        public final TaskObject f12250a;

        /* renamed from: b */
        public final ITaskObserver f12251b;

        public CallableC2807c(TaskObject taskObject, ITaskObserver iTaskObserver) {
            this.f12250a = taskObject;
            this.f12251b = iTaskObserver;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() throws Exception {
            try {
                ITaskObserver iTaskObserver = this.f12251b;
                if (iTaskObserver != null) {
                    iTaskObserver.mo16412b();
                }
                TaskObject taskObject = this.f12250a;
                if (taskObject != null) {
                    taskObject.mo16407a();
                }
                ITaskObserver iTaskObserver2 = this.f12251b;
                if (iTaskObserver2 != null) {
                    iTaskObserver2.mo16411a();
                }
                return 0;
            } catch (Throwable th2) {
                ITaskObserver iTaskObserver3 = this.f12251b;
                if (iTaskObserver3 != null) {
                    iTaskObserver3.mo16411a();
                }
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.logic.threadpool.TaskQueue$d */
    public static class C2808d implements TaskHandle, ITaskObserver {

        /* renamed from: a */
        public TaskObject f12252a;

        /* renamed from: b */
        public boolean f12253b;

        /* renamed from: c */
        public volatile Future<?> f12254c;

        /* renamed from: d */
        public final Object f12255d = new Object();

        public C2808d(TaskObject taskObject) {
            this.f12252a = taskObject;
        }

        @Override // com.huawei.android.hicloud.logic.threadpool.TaskQueue.ITaskObserver
        /* renamed from: a */
        public void mo16411a() {
            m16417e();
        }

        @Override // com.huawei.android.hicloud.logic.threadpool.TaskQueue.ITaskObserver
        /* renamed from: b */
        public void mo16412b() {
        }

        /* renamed from: c */
        public synchronized TaskObject m16415c() {
            return this.f12252a;
        }

        @Override // com.huawei.android.hicloud.logic.threadpool.TaskHandle
        public boolean cancel() {
            Future<?> future = this.f12254c;
            if (future == null) {
                return false;
            }
            future.cancel(true);
            if (!future.isCancelled()) {
                return false;
            }
            TaskObject taskObjectM16415c = m16415c();
            if (taskObjectM16415c != null) {
                taskObjectM16415c.mo16408c();
            }
            m16416d();
            return true;
        }

        /* renamed from: d */
        public final synchronized void m16416d() {
            synchronized (this.f12255d) {
                this.f12252a = null;
                this.f12254c = null;
            }
        }

        /* renamed from: e */
        public final synchronized void m16417e() {
            synchronized (this.f12255d) {
                this.f12253b = true;
                this.f12252a = null;
                this.f12254c = null;
            }
        }

        /* renamed from: f */
        public synchronized void m16418f(Future<?> future) {
            if (!this.f12253b) {
                this.f12254c = future;
            }
        }
    }

    public TaskQueue(int i10, int i11) {
        i10 = i10 < 0 ? 0 : i10;
        i11 = i11 < 0 ? 0 : i11;
        i10 = i10 > i11 ? i11 : i10;
        this.f12246b = i10;
        this.f12247c = i11;
        m16410b(i10, i11);
    }

    /* renamed from: a */
    public TaskHandle m16409a(TaskObject taskObject) {
        Future<?> futureSubmit;
        C2808d c2808d = new C2808d(taskObject);
        CallableC2807c callableC2807c = new CallableC2807c(taskObject, c2808d);
        if (this.f12247c > 1) {
            if (this.f12245a.getActiveCount() < this.f12247c) {
                this.f12248d.m16413b(false);
            } else {
                this.f12248d.m16413b(true);
            }
        }
        try {
            try {
                futureSubmit = this.f12245a.submit(callableC2807c);
            } catch (RejectedExecutionException unused) {
                this.f12248d.m16413b(true);
                futureSubmit = this.f12245a.submit(callableC2807c);
            }
            c2808d.m16418f(futureSubmit);
            return c2808d;
        } catch (Throwable th2) {
            c2808d.m16418f(null);
            throw th2;
        }
    }

    /* renamed from: b */
    public final void m16410b(int i10, int i11) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 <= 0) {
            i11 = 1;
        }
        int i12 = i11;
        int i13 = i10 > i12 ? i12 : i10;
        this.f12248d = new C2806b<>();
        this.f12245a = new ThreadPoolExecutor(i13, i12, 10L, TimeUnit.SECONDS, this.f12248d);
    }
}
