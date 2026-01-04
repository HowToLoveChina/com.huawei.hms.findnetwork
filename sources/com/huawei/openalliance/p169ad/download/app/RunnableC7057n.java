package com.huawei.openalliance.p169ad.download.app;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.download.app.n */
/* loaded from: classes2.dex */
public class RunnableC7057n implements Runnable {

    /* renamed from: a */
    private final a f32499a;

    /* renamed from: b */
    private final CountDownLatch f32500b = new CountDownLatch(1);

    /* renamed from: c */
    private final String f32501c;

    /* renamed from: d */
    private boolean f32502d;

    /* renamed from: e */
    private int f32503e;

    /* renamed from: com.huawei.openalliance.ad.download.app.n$a */
    public interface a {
        /* renamed from: a */
        void mo42449a(int i10);

        /* renamed from: a */
        void mo42450a(RunnableC7057n runnableC7057n);

        /* renamed from: b */
        void mo42451b(RunnableC7057n runnableC7057n);
    }

    public RunnableC7057n(String str, a aVar) {
        this.f32501c = "restore_" + str;
        this.f32499a = aVar;
    }

    /* renamed from: d */
    private void m42542d() {
        try {
            boolean zAwait = this.f32500b.await(5L, TimeUnit.SECONDS);
            AbstractC7185ho.m43821b("RestoreTask", "wait restore success:%s", Boolean.valueOf(zAwait));
            if (zAwait) {
                return;
            }
            this.f32503e = -1;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("RestoreTask", "wait result failed");
        }
    }

    /* renamed from: a */
    public String m42543a() {
        return this.f32501c;
    }

    /* renamed from: b */
    public void m42545b() {
        this.f32502d = true;
    }

    /* renamed from: c */
    public void m42546c() {
        this.f32502d = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f32499a == null) {
            return;
        }
        AbstractC7185ho.m43818a("RestoreTask", "task:%s startup", this.f32501c);
        if (this.f32502d) {
            AbstractC7185ho.m43818a("RestoreTask", "task:%s is canceled", this.f32501c);
            return;
        }
        try {
            try {
                this.f32499a.mo42450a(this);
                this.f32499a.mo42451b(this);
                m42542d();
            } finally {
                this.f32499a.mo42449a(this.f32503e);
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("RestoreTask", "try restore has exception");
        }
    }

    /* renamed from: a */
    public void m42544a(int i10) {
        AbstractC7185ho.m43818a("RestoreTask", "stub result code:%s", Integer.valueOf(i10));
        if (i10 == -1 || i10 == 0) {
            this.f32503e = i10;
            this.f32500b.countDown();
        }
    }
}
