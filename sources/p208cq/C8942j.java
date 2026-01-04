package p208cq;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p233dq.C9288a;

/* renamed from: cq.j */
/* loaded from: classes8.dex */
public final class C8942j {

    /* renamed from: d */
    public static final C8942j f45438d = new C8942j();

    /* renamed from: b */
    public final ExecutorService f45440b = C9288a.m58584a();

    /* renamed from: a */
    public final Executor f45439a = new a();

    /* renamed from: c */
    public final Executor f45441c = C9288a.m58585b();

    /* renamed from: cq.j$a */
    public static final class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public static ExecutorService m56659a() {
        return f45438d.f45440b;
    }

    /* renamed from: b */
    public static Executor m56660b() {
        return f45438d.f45441c;
    }
}
