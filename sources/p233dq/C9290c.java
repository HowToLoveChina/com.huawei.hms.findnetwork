package p233dq;

import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8935c;
import p208cq.InterfaceC8937e;

/* renamed from: dq.c */
/* loaded from: classes8.dex */
public class C9290c<TResult> implements InterfaceC8935c<TResult> {

    /* renamed from: a */
    public InterfaceC8937e<TResult> f46620a;

    /* renamed from: b */
    public Executor f46621b;

    /* renamed from: c */
    public final Object f46622c = new Object();

    /* renamed from: dq.c$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Task f46623a;

        public a(Task task) {
            this.f46623a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C9290c.this.f46622c) {
                try {
                    InterfaceC8937e<TResult> interfaceC8937e = C9290c.this.f46620a;
                    if (interfaceC8937e != null) {
                        interfaceC8937e.onComplete(this.f46623a);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public C9290c(Executor executor, InterfaceC8937e<TResult> interfaceC8937e) {
        this.f46620a = interfaceC8937e;
        this.f46621b = executor;
    }

    @Override // p208cq.InterfaceC8935c
    public void cancel() {
        synchronized (this.f46622c) {
            this.f46620a = null;
        }
    }

    @Override // p208cq.InterfaceC8935c
    public final void onComplete(Task<TResult> task) {
        this.f46621b.execute(new a(task));
    }
}
