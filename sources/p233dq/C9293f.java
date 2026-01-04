package p233dq;

import android.app.Activity;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.p108a.FragmentC5036g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p208cq.C8942j;
import p208cq.InterfaceC8934b;
import p208cq.InterfaceC8935c;
import p208cq.InterfaceC8936d;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p208cq.InterfaceC8940h;

/* renamed from: dq.f */
/* loaded from: classes8.dex */
public class C9293f<TResult> extends Task<TResult> {

    /* renamed from: g */
    public boolean f46636g;

    /* renamed from: h */
    public volatile boolean f46637h;

    /* renamed from: i */
    public TResult f46638i;

    /* renamed from: j */
    public Exception f46639j;

    /* renamed from: f */
    public final Object f46635f = new Object();

    /* renamed from: k */
    public List<InterfaceC8935c<TResult>> f46640k = new ArrayList();

    /* renamed from: dq.f$a */
    public class a implements InterfaceC8939g<TResult> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC8940h f46641a;

        /* renamed from: b */
        public final /* synthetic */ C9293f f46642b;

        /* renamed from: dq.f$a$a */
        public class C14503a<TContinuationResult> implements InterfaceC8937e<TContinuationResult> {
            public C14503a() {
            }

            @Override // p208cq.InterfaceC8937e
            public void onComplete(Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    a.this.f46642b.m58588c(task.getResult());
                } else if (((C9293f) task).f46637h) {
                    a.this.f46642b.m58589d();
                } else {
                    a.this.f46642b.m58587b(task.getException());
                }
            }
        }

        public a(C9293f c9293f, InterfaceC8940h interfaceC8940h, C9293f c9293f2) {
            this.f46641a = interfaceC8940h;
            this.f46642b = c9293f2;
        }

        @Override // p208cq.InterfaceC8939g
        public void onSuccess(TResult tresult) {
            try {
                Task taskMo56654a = this.f46641a.mo56654a(tresult);
                if (taskMo56654a == null) {
                    this.f46642b.m58587b(new NullPointerException("SuccessContinuation returned null"));
                } else {
                    ((C9293f) taskMo56654a).addOnCompleteListener(C8942j.m56660b(), new C14503a());
                }
            } catch (Exception e10) {
                this.f46642b.m58587b(e10);
            }
        }
    }

    /* renamed from: dq.f$b */
    public class b implements InterfaceC8938f {

        /* renamed from: a */
        public final /* synthetic */ C9293f f46644a;

        public b(C9293f c9293f, C9293f c9293f2) {
            this.f46644a = c9293f2;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            this.f46644a.m58587b(exc);
        }
    }

    /* renamed from: dq.f$c */
    public class c implements InterfaceC8936d {

        /* renamed from: a */
        public final /* synthetic */ C9293f f46645a;

        public c(C9293f c9293f, C9293f c9293f2) {
            this.f46645a = c9293f2;
        }

        @Override // p208cq.InterfaceC8936d
        public void onCanceled() {
            this.f46645a.m58589d();
        }
    }

    /* renamed from: dq.f$d */
    public class d implements InterfaceC8937e<TResult> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC8934b f46646a;

        /* renamed from: b */
        public final /* synthetic */ C9293f f46647b;

        /* renamed from: dq.f$d$a */
        public class a<TContinuationResult> implements InterfaceC8937e<TContinuationResult> {
            public a() {
            }

            @Override // p208cq.InterfaceC8937e
            public void onComplete(Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    d.this.f46647b.m58588c(task.getResult());
                } else if (((C9293f) task).f46637h) {
                    d.this.f46647b.m58589d();
                } else {
                    d.this.f46647b.m58587b(task.getException());
                }
            }
        }

        public d(C9293f c9293f, InterfaceC8934b interfaceC8934b, C9293f c9293f2) {
            this.f46646a = interfaceC8934b;
            this.f46647b = c9293f2;
        }

        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<TResult> task) {
            try {
                Task task2 = (Task) this.f46646a.mo33041a(task);
                if (task2 == null) {
                    this.f46647b.m58587b(new NullPointerException("Continuation returned null"));
                } else {
                    ((C9293f) task2).addOnCompleteListener(C8942j.m56660b(), new a());
                }
            } catch (Exception e10) {
                this.f46647b.m58587b(e10);
            }
        }
    }

    /* renamed from: dq.f$e */
    public class e implements InterfaceC8937e<TResult> {

        /* renamed from: a */
        public final /* synthetic */ C9293f f46649a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC8934b f46650b;

        public e(C9293f c9293f, C9293f c9293f2, InterfaceC8934b interfaceC8934b) {
            this.f46649a = c9293f2;
            this.f46650b = interfaceC8934b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<TResult> task) {
            if (((C9293f) task).f46637h) {
                this.f46649a.m58589d();
                return;
            }
            try {
                this.f46649a.m58588c(this.f46650b.mo33041a(task));
            } catch (Exception e10) {
                this.f46649a.m58587b(e10);
            }
        }
    }

    /* renamed from: a */
    public Task<TResult> m58586a(InterfaceC8935c<TResult> interfaceC8935c) {
        boolean zIsComplete;
        synchronized (this.f46635f) {
            try {
                zIsComplete = isComplete();
                if (!zIsComplete) {
                    this.f46640k.add(interfaceC8935c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zIsComplete) {
            interfaceC8935c.onComplete(this);
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Activity activity, InterfaceC8936d interfaceC8936d) {
        C9289b c9289b = new C9289b(C8942j.m56660b(), interfaceC8936d);
        FragmentC5036g.m30076a(activity, c9289b);
        return m58586a(c9289b);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Activity activity, InterfaceC8937e<TResult> interfaceC8937e) {
        C9290c c9290c = new C9290c(C8942j.m56660b(), interfaceC8937e);
        FragmentC5036g.m30076a(activity, c9290c);
        return m58586a(c9290c);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        C9291d c9291d = new C9291d(C8942j.m56660b(), interfaceC8938f);
        FragmentC5036g.m30076a(activity, c9291d);
        return m58586a(c9291d);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Activity activity, InterfaceC8939g<TResult> interfaceC8939g) {
        C9292e c9292e = new C9292e(C8942j.m56660b(), interfaceC8939g);
        FragmentC5036g.m30076a(activity, c9292e);
        return m58586a(c9292e);
    }

    /* renamed from: b */
    public final void m58587b(Exception exc) {
        synchronized (this.f46635f) {
            try {
                if (this.f46636g) {
                    return;
                }
                this.f46636g = true;
                this.f46639j = exc;
                this.f46635f.notifyAll();
                m58590e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public final void m58588c(TResult tresult) {
        synchronized (this.f46635f) {
            try {
                if (this.f46636g) {
                    return;
                }
                this.f46636g = true;
                this.f46638i = tresult;
                this.f46635f.notifyAll();
                m58590e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(InterfaceC8934b<TResult, TContinuationResult> interfaceC8934b) {
        Executor executorM56660b = C8942j.m56660b();
        C9293f c9293f = new C9293f();
        addOnCompleteListener(executorM56660b, new e(this, c9293f, interfaceC8934b));
        return c9293f;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(InterfaceC8934b<TResult, Task<TContinuationResult>> interfaceC8934b) {
        Executor executorM56660b = C8942j.m56660b();
        C9293f c9293f = new C9293f();
        addOnCompleteListener(executorM56660b, new d(this, interfaceC8934b, c9293f));
        return c9293f;
    }

    /* renamed from: d */
    public final boolean m58589d() {
        synchronized (this.f46635f) {
            try {
                if (this.f46636g) {
                    return false;
                }
                this.f46636g = true;
                this.f46637h = true;
                this.f46635f.notifyAll();
                m58590e();
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public final void m58590e() {
        synchronized (this.f46635f) {
            Iterator<InterfaceC8935c<TResult>> it = this.f46640k.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (RuntimeException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new RuntimeException(e11);
                }
            }
            this.f46640k = null;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        Exception exc;
        synchronized (this.f46635f) {
            exc = this.f46639j;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.f46635f) {
            try {
                if (this.f46639j != null) {
                    throw new RuntimeException(this.f46639j);
                }
                tresult = this.f46638i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <E extends Throwable> TResult getResultThrowException(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f46635f) {
            if (cls != null) {
                try {
                    if (cls.isInstance(this.f46639j)) {
                        throw cls.cast(this.f46639j);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.f46639j != null) {
                throw new RuntimeException(this.f46639j);
            }
            tresult = this.f46638i;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return this.f46637h;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        boolean z10;
        synchronized (this.f46635f) {
            z10 = this.f46636g;
        }
        return z10;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        boolean z10;
        synchronized (this.f46635f) {
            try {
                z10 = this.f46636g && !this.f46637h && this.f46639j == null;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(InterfaceC8940h<TResult, TContinuationResult> interfaceC8940h) {
        Executor executorM56660b = C8942j.m56660b();
        C9293f c9293f = new C9293f();
        addOnSuccessListener(executorM56660b, new a(this, interfaceC8940h, c9293f));
        addOnFailureListener(new b(this, c9293f));
        m58586a(new C9289b(C8942j.m56660b(), new c(this, c9293f)));
        return c9293f;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(InterfaceC8936d interfaceC8936d) {
        return m58586a(new C9289b(C8942j.m56660b(), interfaceC8936d));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(InterfaceC8937e<TResult> interfaceC8937e) {
        return addOnCompleteListener(C8942j.m56660b(), interfaceC8937e);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        return m58586a(new C9291d(C8942j.m56660b(), interfaceC8938f));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(InterfaceC8939g<TResult> interfaceC8939g) {
        return addOnSuccessListener(C8942j.m56660b(), interfaceC8939g);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Executor executor, InterfaceC8937e<TResult> interfaceC8937e) {
        return m58586a(new C9290c(executor, interfaceC8937e));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Executor executor, InterfaceC8939g<TResult> interfaceC8939g) {
        return m58586a(new C9292e(executor, interfaceC8939g));
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, InterfaceC8934b<TResult, TContinuationResult> interfaceC8934b) {
        C9293f c9293f = new C9293f();
        addOnCompleteListener(executor, new e(this, c9293f, interfaceC8934b));
        return c9293f;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, InterfaceC8934b<TResult, Task<TContinuationResult>> interfaceC8934b) {
        C9293f c9293f = new C9293f();
        addOnCompleteListener(executor, new d(this, interfaceC8934b, c9293f));
        return c9293f;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Executor executor, InterfaceC8936d interfaceC8936d) {
        return m58586a(new C9289b(executor, interfaceC8936d));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        return m58586a(new C9291d(executor, interfaceC8938f));
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, InterfaceC8940h<TResult, TContinuationResult> interfaceC8940h) {
        C9293f c9293f = new C9293f();
        addOnSuccessListener(executor, new a(this, interfaceC8940h, c9293f));
        addOnFailureListener(new b(this, c9293f));
        m58586a(new C9289b(C8942j.m56660b(), new c(this, c9293f)));
        return c9293f;
    }
}
