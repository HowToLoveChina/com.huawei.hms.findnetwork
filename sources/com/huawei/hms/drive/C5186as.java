package com.huawei.hms.drive;

import com.huawei.hms.drive.C5200be;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.drive.as */
/* loaded from: classes8.dex */
public class C5186as extends AbstractC5172ae {

    /* renamed from: g */
    static final /* synthetic */ boolean f23766g = true;

    /* renamed from: b */
    protected Runnable f23768b;

    /* renamed from: c */
    protected ExecutorService f23769c;

    /* renamed from: a */
    protected int f23767a = 64;

    /* renamed from: h */
    private int f23773h = 5;

    /* renamed from: d */
    protected final Deque<C5200be.a> f23770d = new ArrayDeque();

    /* renamed from: e */
    protected final Deque<C5200be.a> f23771e = new ArrayDeque();

    /* renamed from: f */
    protected final Deque<C5200be> f23772f = new ArrayDeque();

    /* renamed from: c */
    private boolean m30882c() {
        int i10;
        boolean z10;
        if (!f23766g && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C5200be.a> it = this.f23770d.iterator();
                while (it.hasNext()) {
                    C5200be.a next = it.next();
                    if (this.f23771e.size() >= this.f23767a) {
                        break;
                    }
                    if (next.m31100a().get() < this.f23773h) {
                        it.remove();
                        next.m31100a().incrementAndGet();
                        arrayList.add(next);
                        this.f23771e.add(next);
                    }
                }
                z10 = m30885b() > 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((C5200be.a) arrayList.get(i10)).m31101a(m30883a());
        }
        return z10;
    }

    @Override // com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: a */
    public void mo30802a(String str, int i10, String str2) {
    }

    @Override // com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: b */
    public void mo30804b(String str, int i10, String str2) {
    }

    /* renamed from: a */
    public synchronized ExecutorService m30883a() {
        try {
            if (this.f23769c == null) {
                this.f23769c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), C5210bo.m31188a("OkHttp Dispatcher", false));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f23769c;
    }

    @Override // com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: b */
    public void mo30803b(C5200be c5200be) {
        m30881a(this.f23772f, c5200be);
    }

    /* renamed from: b */
    public synchronized int m30885b() {
        return this.f23771e.size() + this.f23772f.size();
    }

    /* renamed from: a */
    public void m30884a(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f23767a = i10;
            }
            m30882c();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    @Override // com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: a */
    public synchronized void mo30801a(C5200be c5200be) {
        this.f23772f.add(c5200be);
    }

    @Override // com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: a */
    public void mo30800a(C5200be.a aVar) {
        aVar.m31100a().decrementAndGet();
        m30881a(this.f23771e, aVar);
    }

    /* renamed from: a */
    private <T> void m30881a(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t10)) {
                runnable = this.f23768b;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (m30882c() || runnable == null) {
            return;
        }
        runnable.run();
    }
}
