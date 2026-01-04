package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.material.snackbar.a */
/* loaded from: classes.dex */
public class C1837a {

    /* renamed from: e */
    public static C1837a f8680e;

    /* renamed from: a */
    public final Object f8681a = new Object();

    /* renamed from: b */
    public final Handler f8682b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c */
    public c f8683c;

    /* renamed from: d */
    public c f8684d;

    /* renamed from: com.google.android.material.snackbar.a$a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            C1837a.this.m11033d((c) message.obj);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.a$b */
    public interface b {
        /* renamed from: a */
        void m11043a(int i10);

        void show();
    }

    /* renamed from: com.google.android.material.snackbar.a$c */
    public static class c {

        /* renamed from: a */
        public final WeakReference<b> f8686a;

        /* renamed from: b */
        public int f8687b;

        /* renamed from: c */
        public boolean f8688c;

        /* renamed from: a */
        public boolean m11044a(b bVar) {
            return bVar != null && this.f8686a.get() == bVar;
        }
    }

    /* renamed from: c */
    public static C1837a m11030c() {
        if (f8680e == null) {
            f8680e = new C1837a();
        }
        return f8680e;
    }

    /* renamed from: a */
    public final boolean m11031a(c cVar, int i10) {
        b bVar = cVar.f8686a.get();
        if (bVar == null) {
            return false;
        }
        this.f8682b.removeCallbacksAndMessages(cVar);
        bVar.m11043a(i10);
        return true;
    }

    /* renamed from: b */
    public void m11032b(b bVar, int i10) {
        synchronized (this.f8681a) {
            try {
                if (m11035f(bVar)) {
                    m11031a(this.f8683c, i10);
                } else if (m11036g(bVar)) {
                    m11031a(this.f8684d, i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m11033d(c cVar) {
        synchronized (this.f8681a) {
            try {
                if (this.f8683c == cVar || this.f8684d == cVar) {
                    m11031a(cVar, 2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public boolean m11034e(b bVar) {
        boolean z10;
        synchronized (this.f8681a) {
            try {
                z10 = m11035f(bVar) || m11036g(bVar);
            } finally {
            }
        }
        return z10;
    }

    /* renamed from: f */
    public final boolean m11035f(b bVar) {
        c cVar = this.f8683c;
        return cVar != null && cVar.m11044a(bVar);
    }

    /* renamed from: g */
    public final boolean m11036g(b bVar) {
        c cVar = this.f8684d;
        return cVar != null && cVar.m11044a(bVar);
    }

    /* renamed from: h */
    public void m11037h(b bVar) {
        synchronized (this.f8681a) {
            try {
                if (m11035f(bVar)) {
                    this.f8683c = null;
                    if (this.f8684d != null) {
                        m11042m();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i */
    public void m11038i(b bVar) {
        synchronized (this.f8681a) {
            try {
                if (m11035f(bVar)) {
                    m11041l(this.f8683c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    public void m11039j(b bVar) {
        synchronized (this.f8681a) {
            try {
                if (m11035f(bVar)) {
                    c cVar = this.f8683c;
                    if (!cVar.f8688c) {
                        cVar.f8688c = true;
                        this.f8682b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public void m11040k(b bVar) {
        synchronized (this.f8681a) {
            try {
                if (m11035f(bVar)) {
                    c cVar = this.f8683c;
                    if (cVar.f8688c) {
                        cVar.f8688c = false;
                        m11041l(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public final void m11041l(c cVar) {
        int i10 = cVar.f8687b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            i10 = i10 == -1 ? 1500 : 2750;
        }
        this.f8682b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f8682b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    /* renamed from: m */
    public final void m11042m() {
        c cVar = this.f8684d;
        if (cVar != null) {
            this.f8683c = cVar;
            this.f8684d = null;
            b bVar = cVar.f8686a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f8683c = null;
            }
        }
    }
}
