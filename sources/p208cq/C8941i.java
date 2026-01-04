package p208cq;

import com.huawei.hmf.tasks.Task;
import p233dq.C9293f;

/* renamed from: cq.i */
/* loaded from: classes8.dex */
public class C8941i<TResult> {

    /* renamed from: a */
    public final C9293f<TResult> f45436a = new C9293f<>();

    /* renamed from: cq.i$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C8941i.this.f45436a.m58589d();
        }
    }

    public C8941i() {
    }

    /* renamed from: b */
    public Task<TResult> m56656b() {
        return this.f45436a;
    }

    /* renamed from: c */
    public void m56657c(Exception exc) {
        this.f45436a.m58587b(exc);
    }

    /* renamed from: d */
    public void m56658d(TResult tresult) {
        this.f45436a.m58588c(tresult);
    }

    public C8941i(AbstractC8933a abstractC8933a) {
        abstractC8933a.register(new a());
    }
}
