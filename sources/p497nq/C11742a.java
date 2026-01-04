package p497nq;

import android.content.Intent;
import p640sq.C12836o;

/* renamed from: nq.a */
/* loaded from: classes8.dex */
public class C11742a {

    /* renamed from: b */
    public static C11742a f54301b;

    /* renamed from: a */
    public InterfaceC11743b f54302a;

    /* renamed from: a */
    public static synchronized C11742a m70048a() {
        try {
            if (f54301b == null) {
                m70049c(new C11742a());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54301b;
    }

    /* renamed from: c */
    public static synchronized void m70049c(C11742a c11742a) {
        f54301b = c11742a;
    }

    /* renamed from: b */
    public synchronized void m70050b(Intent intent) {
        try {
            C12836o.m77097b("WeixinAuthLogin", "WeixinAuthLogin send:", true);
            InterfaceC11743b interfaceC11743b = this.f54302a;
            if (interfaceC11743b != null) {
                interfaceC11743b.mo38114d(intent);
            } else {
                C12836o.m77099d("WeixinAuthLogin", "mWeixinObserver is null.", true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: d */
    public synchronized void m70051d(InterfaceC11743b interfaceC11743b) {
        C12836o.m77097b("WeixinAuthLogin", "WeixinAuthLogin register:", true);
        this.f54302a = interfaceC11743b;
    }

    /* renamed from: e */
    public synchronized void m70052e() {
        C12836o.m77097b("WeixinAuthLogin", "WeixinAuthLogin unregister:", true);
        if (this.f54302a != null) {
            this.f54302a = null;
        }
    }
}
