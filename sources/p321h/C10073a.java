package p321h;

import java.util.concurrent.Executor;

/* renamed from: h.a */
/* loaded from: classes.dex */
public class C10073a extends AbstractC10075c {

    /* renamed from: c */
    public static volatile C10073a f49137c;

    /* renamed from: d */
    public static final Executor f49138d = new a();

    /* renamed from: e */
    public static final Executor f49139e = new b();

    /* renamed from: a */
    public AbstractC10075c f49140a;

    /* renamed from: b */
    public AbstractC10075c f49141b;

    /* renamed from: h.a$a */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C10073a.m62696d().mo62699c(runnable);
        }
    }

    /* renamed from: h.a$b */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C10073a.m62696d().mo62697a(runnable);
        }
    }

    public C10073a() {
        C10074b c10074b = new C10074b();
        this.f49141b = c10074b;
        this.f49140a = c10074b;
    }

    /* renamed from: d */
    public static C10073a m62696d() {
        if (f49137c != null) {
            return f49137c;
        }
        synchronized (C10073a.class) {
            try {
                if (f49137c == null) {
                    f49137c = new C10073a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f49137c;
    }

    @Override // p321h.AbstractC10075c
    /* renamed from: a */
    public void mo62697a(Runnable runnable) {
        this.f49140a.mo62697a(runnable);
    }

    @Override // p321h.AbstractC10075c
    /* renamed from: b */
    public boolean mo62698b() {
        return this.f49140a.mo62698b();
    }

    @Override // p321h.AbstractC10075c
    /* renamed from: c */
    public void mo62699c(Runnable runnable) {
        this.f49140a.mo62699c(runnable);
    }
}
