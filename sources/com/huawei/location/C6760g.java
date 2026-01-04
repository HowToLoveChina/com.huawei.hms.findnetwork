package com.huawei.location;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/* renamed from: com.huawei.location.g */
/* loaded from: classes8.dex */
public final class C6760g {

    /* renamed from: d */
    public static volatile C6760g f31322d;

    /* renamed from: e */
    public static final Object f31323e = new Object();

    /* renamed from: a */
    public a f31324a;

    /* renamed from: b */
    public Handler f31325b;

    /* renamed from: c */
    public boolean f31326c = false;

    /* renamed from: com.huawei.location.g$a */
    public static class a extends HandlerThread {

        /* renamed from: a */
        public C6760g f31327a;

        public a(C6760g c6760g) {
            super("LogPersistenceManagerThread");
            this.f31327a = c6760g;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            if (this.f31327a == null) {
                Log.i("LogPersistenceManager", "log persistence manager null");
            }
        }
    }

    public C6760g() {
        int i10 = C6768h.f31330a;
        m38370a();
    }

    /* renamed from: b */
    public static C6760g m38369b() {
        if (f31322d == null) {
            synchronized (f31323e) {
                try {
                    if (f31322d == null) {
                        f31322d = new C6760g();
                    }
                } finally {
                }
            }
        }
        return f31322d;
    }

    /* renamed from: a */
    public final void m38370a() {
        if (this.f31326c) {
            return;
        }
        this.f31326c = true;
        a aVar = new a(this);
        this.f31324a = aVar;
        aVar.start();
        this.f31325b = new Handler(this.f31324a.getLooper());
    }
}
