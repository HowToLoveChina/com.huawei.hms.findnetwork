package com.huawei.openalliance.p169ad.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.al */
/* loaded from: classes2.dex */
public class C7738al {

    /* renamed from: a */
    private final byte[] f35816a = new byte[0];

    /* renamed from: b */
    private final byte[] f35817b = new byte[0];

    /* renamed from: c */
    private final String f35818c;

    /* renamed from: d */
    private C7737ak f35819d;

    /* renamed from: e */
    private HandlerThread f35820e;

    /* renamed from: f */
    private int f35821f;

    /* renamed from: com.huawei.openalliance.ad.utils.al$a */
    public static class a {

        /* renamed from: a */
        int f35825a;

        /* renamed from: b */
        Runnable f35826b;

        /* renamed from: c */
        String f35827c;

        /* renamed from: d */
        long f35828d;

        public a(int i10, Runnable runnable, String str, long j10) {
            this.f35825a = i10;
            this.f35826b = runnable;
            this.f35827c = str;
            this.f35828d = j10;
        }

        public String toString() {
            return "CacheTask{taskType=" + this.f35825a + ", id='" + this.f35827c + "'}";
        }
    }

    public C7738al(String str) {
        this.f35818c = TextUtils.isEmpty(str) ? "handler_exec_thread" : str;
    }

    /* renamed from: c */
    private void m47511c() {
        C7737ak c7737akM47516f = m47516f();
        if (c7737akM47516f != null) {
            AbstractC7185ho.m43820b("HandlerExecAgent", "delay quit thread");
            c7737akM47516f.m47503a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.al.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (C7738al.this.f35817b) {
                        try {
                            if (C7738al.this.f35820e != null) {
                                C7738al.this.f35820e.quitSafely();
                                C7738al.this.f35820e = null;
                            }
                            C7738al.this.m47506a((C7737ak) null);
                            AbstractC7185ho.m43820b("HandlerExecAgent", "quit thread and release");
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }, "handler_exec_release_task", 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m47515e() {
        if (m47514d()) {
            synchronized (this.f35817b) {
                try {
                    if (this.f35820e == null) {
                        AbstractC7185ho.m43820b("HandlerExecAgent", "init handler thread");
                        HandlerThread handlerThread = new HandlerThread(this.f35818c);
                        handlerThread.start();
                        Looper looper = handlerThread.getLooper();
                        if (looper != null) {
                            this.f35820e = handlerThread;
                            m47506a(new C7737ak(new Handler(looper)));
                        } else {
                            handlerThread.quit();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public C7737ak m47516f() {
        C7737ak c7737ak;
        synchronized (this.f35816a) {
            c7737ak = this.f35819d;
        }
        return c7737ak;
    }

    /* renamed from: d */
    private boolean m47514d() {
        boolean z10;
        synchronized (this.f35816a) {
            z10 = this.f35821f > 0;
        }
        return z10;
    }

    /* renamed from: a */
    public void m47517a() {
        synchronized (this.f35816a) {
            try {
                this.f35821f++;
                C7737ak c7737akM47516f = m47516f();
                if (c7737akM47516f != null) {
                    c7737akM47516f.m47504a("handler_exec_release_task");
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("HandlerExecAgent", "acquire exec agent. ref count: %d", Integer.valueOf(this.f35821f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m47521b() {
        synchronized (this.f35816a) {
            try {
                if (!m47514d()) {
                    AbstractC7185ho.m43820b("HandlerExecAgent", "release exec agent - not working");
                    return;
                }
                int i10 = this.f35821f - 1;
                this.f35821f = i10;
                if (i10 <= 0) {
                    this.f35821f = 0;
                    m47511c();
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("HandlerExecAgent", "release exec agent - ref count: %d", Integer.valueOf(this.f35821f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m47506a(C7737ak c7737ak) {
        synchronized (this.f35816a) {
            this.f35819d = c7737ak;
        }
    }

    /* renamed from: a */
    private void m47507a(final a aVar) {
        AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.utils.al.2
            @Override // java.lang.Runnable
            public void run() {
                C7738al.this.m47515e();
                C7737ak c7737akM47516f = C7738al.this.m47516f();
                if (c7737akM47516f != null) {
                    a aVar2 = aVar;
                    int i10 = aVar2.f35825a;
                    if (i10 == 1) {
                        c7737akM47516f.m47503a(aVar2.f35826b, aVar2.f35827c, aVar2.f35828d);
                    } else if (i10 == 2) {
                        c7737akM47516f.m47504a(aVar2.f35827c);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void m47518a(Runnable runnable) {
        if (m47514d()) {
            C7737ak c7737akM47516f = m47516f();
            if (c7737akM47516f != null) {
                c7737akM47516f.m47501a(runnable);
            } else {
                m47507a(new a(1, runnable, null, 0L));
            }
        }
    }

    /* renamed from: a */
    public void m47519a(Runnable runnable, String str, long j10) {
        if (m47514d()) {
            C7737ak c7737akM47516f = m47516f();
            if (c7737akM47516f != null) {
                c7737akM47516f.m47503a(runnable, str, j10);
            } else {
                m47507a(new a(1, runnable, str, j10));
            }
        }
    }

    /* renamed from: a */
    public void m47520a(String str) {
        if (m47514d()) {
            C7737ak c7737akM47516f = m47516f();
            if (c7737akM47516f != null) {
                c7737akM47516f.m47504a(str);
            } else {
                m47507a(new a(2, null, str, 0L));
            }
        }
    }
}
