package com.huawei.dynamicanimation;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.huawei.dynamicanimation.a */
/* loaded from: classes5.dex */
public class C4671a {

    /* renamed from: g */
    public static final ThreadLocal<C4671a> f21495g = new ThreadLocal<>();

    /* renamed from: d */
    public c f21499d;

    /* renamed from: a */
    public final HashMap<b, Long> f21496a = new HashMap<>();

    /* renamed from: b */
    public final ArrayList<b> f21497b = new ArrayList<>();

    /* renamed from: c */
    public final a f21498c = new a();

    /* renamed from: e */
    public long f21500e = 0;

    /* renamed from: f */
    public boolean f21501f = false;

    /* renamed from: com.huawei.dynamicanimation.a$a */
    public class a {
        public a() {
        }

        /* renamed from: a */
        public void m28622a() {
            C4671a.this.f21500e = SystemClock.uptimeMillis();
            C4671a c4671a = C4671a.this;
            c4671a.m28618h(c4671a.f21500e);
            if (C4671a.this.f21497b.size() > 0) {
                C4671a.this.m28619j().mo28624a();
            }
        }
    }

    /* renamed from: com.huawei.dynamicanimation.a$b */
    public interface b {
        /* renamed from: a */
        boolean mo28623a(long j10);
    }

    /* renamed from: com.huawei.dynamicanimation.a$c */
    public static abstract class c {

        /* renamed from: a */
        public final a f21503a;

        public c(a aVar) {
            this.f21503a = aVar;
        }

        /* renamed from: a */
        public abstract void mo28624a();
    }

    /* renamed from: com.huawei.dynamicanimation.a$d */
    public static class d extends c {

        /* renamed from: b */
        public final Choreographer f21504b;

        /* renamed from: c */
        public final Choreographer.FrameCallback f21505c;

        /* renamed from: com.huawei.dynamicanimation.a$d$a */
        public class a implements Choreographer.FrameCallback {
            public a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                d.this.f21503a.m28622a();
            }
        }

        public d(a aVar) {
            super(aVar);
            this.f21504b = Choreographer.getInstance();
            this.f21505c = new a();
        }

        @Override // com.huawei.dynamicanimation.C4671a.c
        /* renamed from: a */
        public void mo28624a() {
            this.f21504b.postFrameCallback(this.f21505c);
        }
    }

    /* renamed from: i */
    public static C4671a m28615i() {
        ThreadLocal<C4671a> threadLocal = f21495g;
        if (threadLocal.get() == null) {
            threadLocal.set(new C4671a());
        }
        return threadLocal.get();
    }

    /* renamed from: f */
    public void m28616f(b bVar, long j10) {
        if (this.f21497b.size() == 0) {
            m28619j().mo28624a();
        }
        if (!this.f21497b.contains(bVar)) {
            this.f21497b.add(bVar);
        }
        if (j10 > 0) {
            this.f21496a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    /* renamed from: g */
    public final void m28617g() {
        if (this.f21501f) {
            for (int size = this.f21497b.size() - 1; size >= 0; size--) {
                if (this.f21497b.get(size) == null) {
                    this.f21497b.remove(size);
                }
            }
            this.f21501f = false;
        }
    }

    /* renamed from: h */
    public final void m28618h(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f21497b.size(); i10++) {
            b bVar = this.f21497b.get(i10);
            if (bVar != null && m28620k(bVar, jUptimeMillis)) {
                bVar.mo28623a(j10);
            }
        }
        m28617g();
    }

    /* renamed from: j */
    public final c m28619j() {
        if (this.f21499d == null) {
            this.f21499d = new d(this.f21498c);
        }
        return this.f21499d;
    }

    /* renamed from: k */
    public final boolean m28620k(b bVar, long j10) {
        if (this.f21496a.get(bVar) == null) {
            return true;
        }
        if (this.f21496a.get(bVar).longValue() >= j10) {
            return false;
        }
        this.f21496a.remove(bVar);
        return true;
    }

    /* renamed from: l */
    public void m28621l(b bVar) {
        this.f21496a.remove(bVar);
        int iIndexOf = this.f21497b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f21497b.set(iIndexOf, null);
            this.f21501f = true;
        }
    }
}
