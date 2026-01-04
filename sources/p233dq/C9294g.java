package p233dq;

import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p208cq.C8941i;
import p208cq.InterfaceC8936d;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* renamed from: dq.g */
/* loaded from: classes8.dex */
public class C9294g {

    /* renamed from: dq.g$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C8941i f46651a;

        /* renamed from: b */
        public final /* synthetic */ Callable f46652b;

        public a(C9294g c9294g, C8941i c8941i, Callable callable) {
            this.f46651a = c8941i;
            this.f46652b = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f46651a.m56658d(this.f46652b.call());
            } catch (Exception e10) {
                this.f46651a.m56657c(e10);
            }
        }
    }

    /* renamed from: dq.g$b */
    public static class b<TResult> implements InterfaceC8939g<TResult>, InterfaceC8938f, InterfaceC8936d {

        /* renamed from: a */
        public final CountDownLatch f46653a = new CountDownLatch(1);

        @Override // p208cq.InterfaceC8936d
        public void onCanceled() {
            this.f46653a.countDown();
        }

        @Override // p208cq.InterfaceC8938f
        public final void onFailure(Exception exc) {
            this.f46653a.countDown();
        }

        @Override // p208cq.InterfaceC8939g
        public final void onSuccess(TResult tresult) {
            this.f46653a.countDown();
        }
    }

    /* renamed from: a */
    public <TResult> Task<TResult> m58591a(Executor executor, Callable<TResult> callable) {
        C8941i c8941i = new C8941i();
        try {
            executor.execute(new a(this, c8941i, callable));
        } catch (Exception e10) {
            c8941i.m56657c(e10);
        }
        return c8941i.m56656b();
    }

    /* renamed from: b */
    public final <TResult> TResult m58592b(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }
}
