package p233dq;

import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8935c;
import p208cq.InterfaceC8939g;

/* renamed from: dq.e */
/* loaded from: classes8.dex */
public class C9292e<TResult> implements InterfaceC8935c<TResult> {

    /* renamed from: a */
    public InterfaceC8939g<TResult> f46630a;

    /* renamed from: b */
    public Executor f46631b;

    /* renamed from: c */
    public final Object f46632c = new Object();

    /* renamed from: dq.e$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Task f46633a;

        public a(Task task) {
            this.f46633a = task;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (C9292e.this.f46632c) {
                try {
                    InterfaceC8939g<TResult> interfaceC8939g = C9292e.this.f46630a;
                    if (interfaceC8939g != 0) {
                        interfaceC8939g.onSuccess(this.f46633a.getResult());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public C9292e(Executor executor, InterfaceC8939g<TResult> interfaceC8939g) {
        this.f46630a = interfaceC8939g;
        this.f46631b = executor;
    }

    @Override // p208cq.InterfaceC8935c
    public void cancel() {
        synchronized (this.f46632c) {
            this.f46630a = null;
        }
    }

    @Override // p208cq.InterfaceC8935c
    public final void onComplete(Task<TResult> task) {
        if (!task.isSuccessful() || ((C9293f) task).f46637h) {
            return;
        }
        this.f46631b.execute(new a(task));
    }
}
