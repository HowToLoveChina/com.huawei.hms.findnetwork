package p233dq;

import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8935c;
import p208cq.InterfaceC8938f;

/* renamed from: dq.d */
/* loaded from: classes8.dex */
public class C9291d<TResult> implements InterfaceC8935c<TResult> {

    /* renamed from: a */
    public InterfaceC8938f f46625a;

    /* renamed from: b */
    public Executor f46626b;

    /* renamed from: c */
    public final Object f46627c = new Object();

    /* renamed from: dq.d$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Task f46628a;

        public a(Task task) {
            this.f46628a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C9291d.this.f46627c) {
                try {
                    InterfaceC8938f interfaceC8938f = C9291d.this.f46625a;
                    if (interfaceC8938f != null) {
                        interfaceC8938f.onFailure(this.f46628a.getException());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public C9291d(Executor executor, InterfaceC8938f interfaceC8938f) {
        this.f46625a = interfaceC8938f;
        this.f46626b = executor;
    }

    @Override // p208cq.InterfaceC8935c
    public void cancel() {
        synchronized (this.f46627c) {
            this.f46625a = null;
        }
    }

    @Override // p208cq.InterfaceC8935c
    public final void onComplete(Task<TResult> task) {
        if (task.isSuccessful() || ((C9293f) task).f46637h) {
            return;
        }
        this.f46626b.execute(new a(task));
    }
}
