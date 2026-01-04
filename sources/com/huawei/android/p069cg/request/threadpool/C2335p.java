package com.huawei.android.p069cg.request.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p031b7.C1120a;
import p546p6.C12105r;
import p546p6.C12111x;

/* renamed from: com.huawei.android.cg.request.threadpool.p */
/* loaded from: classes2.dex */
public class C2335p extends Thread {

    /* renamed from: a */
    public BlockingQueue<C2334o<Object>> f11153a;

    /* renamed from: b */
    public boolean f11154b = false;

    /* renamed from: c */
    public ExecutorService f11155c;

    /* renamed from: d */
    public String f11156d;

    /* renamed from: com.huawei.android.cg.request.threadpool.p$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public String f11157a;

        public a(String str) {
            this.f11157a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f11157a);
        }
    }

    public C2335p(BlockingQueue<C2334o<Object>> blockingQueue, String str) {
        this.f11153a = blockingQueue;
        this.f11156d = str;
        this.f11155c = Executors.newFixedThreadPool(1, new a(str));
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        C2334o<Object> c2334oTake;
        Exception e10;
        StringBuilder sb2;
        while (!this.f11154b) {
            C2334o<Object> c2334o = null;
            try {
                C1120a.m6675d("ThumbTaskExecutor", "thumbTaskBlockingQueue size: " + this.f11153a.size());
                c2334oTake = this.f11153a.take();
            } catch (Exception e11) {
                c2334oTake = null;
                e10 = e11;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    if (this.f11155c.submit(c2334oTake) == null) {
                        C1120a.m6675d("ThumbTaskExecutor", "submit is null");
                    }
                    Object obj = c2334oTake.get();
                    C1120a.m6675d("ThumbTaskExecutor", "ThumbTask onResult: " + obj.toString());
                    c2334oTake.m14679i(obj);
                    sb2 = new StringBuilder();
                } catch (Throwable th3) {
                    th = th3;
                    c2334o = c2334oTake;
                    if (c2334o != null) {
                        C1120a.m6675d("ThumbTaskExecutor", "remove: " + c2334o.m14678h());
                        C12111x.m72537e().m72544h(c2334o.m14678h());
                        C12105r.m72501e().m72507g(c2334o.m14678h());
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e10 = e12;
                C1120a.m6676e("ThumbTaskExecutor", "Exception: " + e10.toString());
                if (c2334oTake != null) {
                    sb2 = new StringBuilder();
                    sb2.append("remove: ");
                    sb2.append(c2334oTake.m14678h());
                    C1120a.m6675d("ThumbTaskExecutor", sb2.toString());
                    C12111x.m72537e().m72544h(c2334oTake.m14678h());
                    C12105r.m72501e().m72507g(c2334oTake.m14678h());
                }
            }
            sb2.append("remove: ");
            sb2.append(c2334oTake.m14678h());
            C1120a.m6675d("ThumbTaskExecutor", sb2.toString());
            C12111x.m72537e().m72544h(c2334oTake.m14678h());
            C12105r.m72501e().m72507g(c2334oTake.m14678h());
        }
    }
}
