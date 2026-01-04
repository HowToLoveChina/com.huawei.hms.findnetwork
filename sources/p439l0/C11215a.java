package p439l0;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import p438l.C11213g;

/* renamed from: l0.a */
/* loaded from: classes.dex */
public class C11215a {

    /* renamed from: g */
    public static final ThreadLocal<C11215a> f52651g = new ThreadLocal<>();

    /* renamed from: d */
    public c f52655d;

    /* renamed from: a */
    public final C11213g<b, Long> f52652a = new C11213g<>();

    /* renamed from: b */
    public final ArrayList<b> f52653b = new ArrayList<>();

    /* renamed from: c */
    public final a f52654c = new a();

    /* renamed from: e */
    public long f52656e = 0;

    /* renamed from: f */
    public boolean f52657f = false;

    /* renamed from: l0.a$a */
    public class a {
        public a() {
        }

        /* renamed from: a */
        public void m67355a() {
            C11215a.this.f52656e = SystemClock.uptimeMillis();
            C11215a c11215a = C11215a.this;
            c11215a.m67351c(c11215a.f52656e);
            if (C11215a.this.f52653b.size() > 0) {
                C11215a.this.m67352e().mo67357a();
            }
        }
    }

    /* renamed from: l0.a$b */
    public interface b {
        /* renamed from: a */
        boolean mo67356a(long j10);
    }

    /* renamed from: l0.a$c */
    public static abstract class c {

        /* renamed from: a */
        public final a f52659a;

        public c(a aVar) {
            this.f52659a = aVar;
        }

        /* renamed from: a */
        public abstract void mo67357a();
    }

    /* renamed from: l0.a$d */
    public static class d extends c {

        /* renamed from: b */
        public final Choreographer f52660b;

        /* renamed from: c */
        public final Choreographer.FrameCallback f52661c;

        /* renamed from: l0.a$d$a */
        public class a implements Choreographer.FrameCallback {
            public a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                d.this.f52659a.m67355a();
            }
        }

        public d(a aVar) {
            super(aVar);
            this.f52660b = Choreographer.getInstance();
            this.f52661c = new a();
        }

        @Override // p439l0.C11215a.c
        /* renamed from: a */
        public void mo67357a() {
            this.f52660b.postFrameCallback(this.f52661c);
        }
    }

    /* renamed from: d */
    public static C11215a m67348d() {
        ThreadLocal<C11215a> threadLocal = f52651g;
        if (threadLocal.get() == null) {
            threadLocal.set(new C11215a());
        }
        return threadLocal.get();
    }

    /* renamed from: a */
    public void m67349a(b bVar, long j10) {
        if (this.f52653b.size() == 0) {
            m67352e().mo67357a();
        }
        if (!this.f52653b.contains(bVar)) {
            this.f52653b.add(bVar);
        }
        if (j10 > 0) {
            this.f52652a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    /* renamed from: b */
    public final void m67350b() {
        if (this.f52657f) {
            for (int size = this.f52653b.size() - 1; size >= 0; size--) {
                if (this.f52653b.get(size) == null) {
                    this.f52653b.remove(size);
                }
            }
            this.f52657f = false;
        }
    }

    /* renamed from: c */
    public void m67351c(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f52653b.size(); i10++) {
            b bVar = this.f52653b.get(i10);
            if (bVar != null && m67353f(bVar, jUptimeMillis)) {
                bVar.mo67356a(j10);
            }
        }
        m67350b();
    }

    /* renamed from: e */
    public c m67352e() {
        if (this.f52655d == null) {
            this.f52655d = new d(this.f52654c);
        }
        return this.f52655d;
    }

    /* renamed from: f */
    public final boolean m67353f(b bVar, long j10) {
        Long l10 = this.f52652a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f52652a.remove(bVar);
        return true;
    }

    /* renamed from: g */
    public void m67354g(b bVar) {
        this.f52652a.remove(bVar);
        int iIndexOf = this.f52653b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f52653b.set(iIndexOf, null);
            this.f52657f = true;
        }
    }
}
