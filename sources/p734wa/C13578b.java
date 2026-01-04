package p734wa;

import android.graphics.drawable.BitmapDrawable;
import java.util.concurrent.locks.ReentrantLock;
import p768xa.C13736a;

/* renamed from: wa.b */
/* loaded from: classes3.dex */
public final class C13578b {

    /* renamed from: b */
    public static volatile C13578b f61076b;

    /* renamed from: c */
    public static final ReentrantLock f61077c = new ReentrantLock();

    /* renamed from: a */
    public C13577a f61078a = new C13577a(62914560);

    public C13578b() {
        C13736a.m82556c().m82559d();
    }

    /* renamed from: f */
    public static C13578b m81574f() {
        if (f61076b == null) {
            ReentrantLock reentrantLock = f61077c;
            reentrantLock.lock();
            try {
                if (f61076b == null) {
                    f61076b = new C13578b();
                }
                reentrantLock.unlock();
            } catch (Throwable th2) {
                f61077c.unlock();
                throw th2;
            }
        }
        return f61076b;
    }

    /* renamed from: a */
    public void m81575a(BitmapDrawable bitmapDrawable, String str) {
        m81576b(bitmapDrawable, str, false, false);
    }

    /* renamed from: b */
    public void m81576b(BitmapDrawable bitmapDrawable, String str, boolean z10, boolean z11) {
        m81577c(bitmapDrawable, C13736a.m82555b(str), z10, z11);
    }

    /* renamed from: c */
    public void m81577c(BitmapDrawable bitmapDrawable, String str, boolean z10, boolean z11) {
        if (str == null) {
            return;
        }
        ReentrantLock reentrantLock = f61077c;
        reentrantLock.lock();
        try {
            if (z10) {
                String str2 = str + z10 + z11;
                if (this.f61078a.get(str2) == null) {
                    this.f61078a.put(str2, bitmapDrawable);
                }
            } else if (this.f61078a.get(str) == null) {
                this.f61078a.put(str, bitmapDrawable);
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            f61077c.unlock();
            throw th2;
        }
    }

    /* renamed from: d */
    public BitmapDrawable m81578d(String str) {
        return m81579e(str, false, false);
    }

    /* renamed from: e */
    public BitmapDrawable m81579e(String str, boolean z10, boolean z11) {
        String strM82555b = C13736a.m82555b(str);
        if (strM82555b == null) {
            return null;
        }
        if (!z10) {
            return this.f61078a.m81572b(strM82555b);
        }
        return this.f61078a.m81572b(strM82555b + z10 + z11);
    }
}
