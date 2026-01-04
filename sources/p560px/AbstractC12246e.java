package p560px;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import p376ix.C10631a;
import p537ox.C12056a;

/* renamed from: px.e */
/* loaded from: classes9.dex */
public abstract class AbstractC12246e<T> {

    /* renamed from: a */
    public final C12056a f56637a;

    /* renamed from: b */
    public final boolean f56638b;

    /* renamed from: c */
    public final ExecutorService f56639c;

    /* renamed from: px.e$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Object f56640a;

        public a(Object obj) {
            this.f56640a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractC12246e abstractC12246e = AbstractC12246e.this;
                abstractC12246e.m73483i(this.f56640a, abstractC12246e.f56637a);
            } catch (C10631a unused) {
            } catch (Throwable th2) {
                AbstractC12246e.this.f56639c.shutdown();
                throw th2;
            }
            AbstractC12246e.this.f56639c.shutdown();
        }
    }

    /* renamed from: px.e$b */
    public static class b {

        /* renamed from: a */
        public final C12056a f56642a;

        /* renamed from: b */
        public final boolean f56643b;

        /* renamed from: c */
        public final ExecutorService f56644c;

        public b(ExecutorService executorService, boolean z10, C12056a c12056a) {
            this.f56644c = executorService;
            this.f56643b = z10;
            this.f56642a = c12056a;
        }
    }

    public AbstractC12246e(b bVar) {
        this.f56637a = bVar.f56642a;
        this.f56638b = bVar.f56643b;
        this.f56639c = bVar.f56644c;
    }

    /* renamed from: d */
    public abstract long mo73471d(T t10) throws C10631a;

    /* renamed from: e */
    public void m73481e(T t10) throws C10631a {
        if (this.f56638b && C12056a.b.BUSY.equals(this.f56637a.m72196d())) {
            throw new C10631a("invalid operation - Zip4j is in busy state");
        }
        m73482h();
        if (!this.f56638b) {
            m73483i(t10, this.f56637a);
            return;
        }
        this.f56637a.m72203k(mo73471d(t10));
        this.f56639c.execute(new a(t10));
    }

    /* renamed from: f */
    public abstract void mo73472f(T t10, C12056a c12056a) throws IOException;

    /* renamed from: g */
    public abstract C12056a.c mo73447g();

    /* renamed from: h */
    public final void m73482h() {
        this.f56637a.m72195c();
        this.f56637a.m72202j(C12056a.b.BUSY);
        this.f56637a.m72199g(mo73447g());
    }

    /* renamed from: i */
    public final void m73483i(T t10, C12056a c12056a) throws C10631a {
        try {
            mo73472f(t10, c12056a);
            c12056a.m72193a();
        } catch (C10631a e10) {
            c12056a.m72194b(e10);
            throw e10;
        } catch (Exception e11) {
            c12056a.m72194b(e11);
            throw new C10631a(e11);
        }
    }

    /* renamed from: j */
    public void m73484j() throws C10631a {
        if (this.f56637a.m72197e()) {
            this.f56637a.m72201i(C12056a.a.CANCELLED);
            this.f56637a.m72202j(C12056a.b.READY);
            throw new C10631a("Task cancelled", C10631a.a.TASK_CANCELLED_EXCEPTION);
        }
    }
}
