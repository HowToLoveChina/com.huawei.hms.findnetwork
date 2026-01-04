package p776xi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: xi.b */
/* loaded from: classes.dex */
public class C13816b {

    /* renamed from: d */
    public static final C13816b f62016d = new C13816b();

    /* renamed from: a */
    public ExecutorService f62017a = Executors.newCachedThreadPool();

    /* renamed from: b */
    public ExecutorService f62018b = Executors.newFixedThreadPool(4);

    /* renamed from: c */
    public ExecutorService f62019c = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public static C13816b m82856c() {
        return f62016d;
    }

    /* renamed from: a */
    public void m82857a(AbstractRunnableC13815a abstractRunnableC13815a) {
        abstractRunnableC13815a.m82855e(this.f62018b.submit(abstractRunnableC13815a));
    }

    /* renamed from: b */
    public void m82858b(AbstractRunnableC13815a abstractRunnableC13815a) {
        abstractRunnableC13815a.m82855e(this.f62017a.submit(abstractRunnableC13815a));
    }
}
