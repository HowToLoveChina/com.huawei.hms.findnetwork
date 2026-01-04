package ru;

import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.connect.ServiceConnectCallback;
import java.util.concurrent.Callable;
import p208cq.C8943k;
import p558pu.C12227b;

/* renamed from: ru.b */
/* loaded from: classes9.dex */
public class C12628b {

    /* renamed from: d */
    public static volatile C12628b f58063d;

    /* renamed from: b */
    public volatile InterfaceC12627a f58065b;

    /* renamed from: c */
    public volatile ServiceConnectCallback f58066c = new a();

    /* renamed from: a */
    public C12629c f58064a = new C12629c();

    /* renamed from: ru.b$a */
    public class a extends ServiceConnectCallback.AbstractBinderC8886a {
        public a() {
        }

        @Override // com.huawei.wearengine.connect.ServiceConnectCallback.AbstractBinderC8886a
        /* renamed from: g */
        public void mo56500g() {
            if (C12628b.this.f58065b != null) {
                C12628b.this.f58065b.mo76148b();
            }
        }
    }

    /* renamed from: ru.b$b */
    public class b implements Callable<Void> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            int iReleaseConnection = C12628b.this.f58064a.releaseConnection();
            if (iReleaseConnection == 0) {
                return null;
            }
            throw new C12227b(iReleaseConnection);
        }
    }

    public C12628b(InterfaceC12627a interfaceC12627a) {
        this.f58065b = interfaceC12627a;
    }

    /* renamed from: c */
    public static C12628b m76151c(InterfaceC12627a interfaceC12627a) {
        if (f58063d == null) {
            synchronized (C12628b.class) {
                try {
                    if (f58063d == null) {
                        f58063d = new C12628b(interfaceC12627a);
                    }
                } finally {
                }
            }
        }
        return f58063d;
    }

    /* renamed from: d */
    public Task<Void> m76152d() {
        return C8943k.m56662b(new b());
    }
}
