package p208cq;

import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import p233dq.C9293f;
import p233dq.C9294g;

/* renamed from: cq.k */
/* loaded from: classes8.dex */
public class C8943k {

    /* renamed from: a */
    public static C9294g f45442a = new C9294g();

    /* renamed from: a */
    public static <TResult> TResult m56661a(Task<TResult> task) throws ExecutionException, InterruptedException {
        C9294g c9294g = f45442a;
        c9294g.getClass();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        if (task.isComplete()) {
            return (TResult) c9294g.m58592b(task);
        }
        C9294g.b bVar = new C9294g.b();
        ((C9293f) task).addOnSuccessListener(C8942j.m56660b(), bVar).addOnFailureListener(bVar);
        bVar.f46653a.await();
        return (TResult) c9294g.m58592b(task);
    }

    /* renamed from: b */
    public static <TResult> Task<TResult> m56662b(Callable<TResult> callable) {
        return f45442a.m58591a(C8942j.m56659a(), callable);
    }

    /* renamed from: c */
    public static <TResult> Task<TResult> m56663c(Exception exc) {
        C8941i c8941i = new C8941i();
        c8941i.m56657c(exc);
        return c8941i.m56656b();
    }
}
