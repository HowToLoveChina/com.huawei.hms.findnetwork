package p630s2;

import java.util.concurrent.Executor;

/* renamed from: s2.e */
/* loaded from: classes.dex */
public final class C12670e {

    /* renamed from: a */
    public static final Executor f58173a = new a();

    /* renamed from: b */
    public static final Executor f58174b = new b();

    /* renamed from: s2.e$a */
    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C12677l.m76297t(runnable);
        }
    }

    /* renamed from: s2.e$b */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public static Executor m76259a() {
        return f58174b;
    }

    /* renamed from: b */
    public static Executor m76260b() {
        return f58173a;
    }
}
