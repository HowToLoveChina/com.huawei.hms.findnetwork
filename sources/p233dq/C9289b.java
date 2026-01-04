package p233dq;

import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8935c;
import p208cq.InterfaceC8936d;

/* renamed from: dq.b */
/* loaded from: classes8.dex */
public class C9289b<TResult> implements InterfaceC8935c<TResult> {

    /* renamed from: a */
    public InterfaceC8936d f46616a;

    /* renamed from: b */
    public Executor f46617b;

    /* renamed from: c */
    public final Object f46618c = new Object();

    /* renamed from: dq.b$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C9289b.this.f46618c) {
                try {
                    InterfaceC8936d interfaceC8936d = C9289b.this.f46616a;
                    if (interfaceC8936d != null) {
                        interfaceC8936d.onCanceled();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public C9289b(Executor executor, InterfaceC8936d interfaceC8936d) {
        this.f46616a = interfaceC8936d;
        this.f46617b = executor;
    }

    @Override // p208cq.InterfaceC8935c
    public void cancel() {
        synchronized (this.f46618c) {
            this.f46616a = null;
        }
    }

    @Override // p208cq.InterfaceC8935c
    public final void onComplete(Task<TResult> task) {
        if (((C9293f) task).f46637h) {
            this.f46617b.execute(new a());
        }
    }
}
