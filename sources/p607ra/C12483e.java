package p607ra;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p514o9.C11839m;
import qa.C12296a;

/* renamed from: ra.e */
/* loaded from: classes3.dex */
public class C12483e extends Thread {

    /* renamed from: a */
    public BlockingQueue<C12482d> f57480a;

    /* renamed from: b */
    public boolean f57481b = false;

    /* renamed from: c */
    public ExecutorService f57482c;

    /* renamed from: d */
    public String f57483d;

    /* renamed from: ra.e$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public String f57484a;

        public a(String str) {
            this.f57484a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f57484a);
        }
    }

    public C12483e(BlockingQueue<C12482d> blockingQueue, String str) {
        this.f57480a = blockingQueue;
        this.f57483d = str;
        this.f57482c = Executors.newFixedThreadPool(1, new a(str));
    }

    /* renamed from: a */
    public void m74961a() {
        C11839m.m70688i("ThumbTaskExecutor", "quit: " + this.f57483d);
        this.f57481b = true;
        interrupt();
        ExecutorService executorService = this.f57482c;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        C12482d c12482dTake;
        Exception e10;
        StringBuilder sb2;
        while (!this.f57481b) {
            C12482d c12482d = null;
            try {
                C11839m.m70686d("ThumbTaskExecutor", "thumbTaskBlockingQueue size: " + this.f57480a.size());
                c12482dTake = this.f57480a.take();
                if (c12482dTake != null) {
                    try {
                        try {
                            C12296a.m73898e().m73899a(c12482dTake.m74959f());
                        } catch (Throwable th2) {
                            th = th2;
                            c12482d = c12482dTake;
                            if (c12482d != null) {
                                C11839m.m70686d("ThumbTaskExecutor", "remove: " + c12482d.m74959f());
                                C12296a.m73898e().m73904g(c12482d.m74959f());
                                C12296a.m73898e().m73905h(c12482d.m74959f());
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e10 = e11;
                        C11839m.m70687e("ThumbTaskExecutor", "Exception: " + e10.toString());
                        if (c12482dTake != null) {
                            sb2 = new StringBuilder();
                            sb2.append("remove: ");
                            sb2.append(c12482dTake.m74959f());
                            C11839m.m70686d("ThumbTaskExecutor", sb2.toString());
                            C12296a.m73898e().m73904g(c12482dTake.m74959f());
                            C12296a.m73898e().m73905h(c12482dTake.m74959f());
                        }
                    }
                }
                this.f57482c.submit(c12482dTake).get();
            } catch (Exception e12) {
                c12482dTake = null;
                e10 = e12;
            } catch (Throwable th3) {
                th = th3;
            }
            if (c12482dTake != null) {
                sb2 = new StringBuilder();
                sb2.append("remove: ");
                sb2.append(c12482dTake.m74959f());
                C11839m.m70686d("ThumbTaskExecutor", sb2.toString());
                C12296a.m73898e().m73904g(c12482dTake.m74959f());
                C12296a.m73898e().m73905h(c12482dTake.m74959f());
            }
        }
    }
}
