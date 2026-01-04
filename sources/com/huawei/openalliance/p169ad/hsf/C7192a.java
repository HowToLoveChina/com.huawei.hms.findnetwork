package com.huawei.openalliance.p169ad.hsf;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.hsf.AbstractC7196e;
import com.huawei.openalliance.p169ad.hsf.InterfaceC7194c;
import com.huawei.openalliance.p169ad.hsf.InterfaceC7195d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.openalliance.ad.hsf.a */
/* loaded from: classes2.dex */
public class C7192a implements AbstractC7196e.a {

    /* renamed from: d */
    private static C7192a f33106d;

    /* renamed from: e */
    private static final byte[] f33107e = new byte[0];

    /* renamed from: a */
    private AbstractC7196e f33108a;

    /* renamed from: b */
    private InterfaceC7195d f33109b;

    /* renamed from: c */
    private List<a> f33110c = new CopyOnWriteArrayList();

    /* renamed from: com.huawei.openalliance.ad.hsf.a$a */
    public static class a {

        /* renamed from: a */
        String f33117a;

        /* renamed from: b */
        String f33118b;

        /* renamed from: c */
        b f33119c;

        public a(String str, String str2, b bVar) {
            this.f33117a = str;
            this.f33118b = str2;
            this.f33119c = bVar;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hsf.a$b */
    public interface b {
        /* renamed from: a */
        void mo43859a();

        /* renamed from: b */
        void mo43860b();

        /* renamed from: c */
        void mo43861c();
    }

    private C7192a(Context context) {
        AbstractC7196e abstractC7196eM43868a = AbstractC7196e.m43868a(context, this);
        this.f33108a = abstractC7196eM43868a;
        abstractC7196eM43868a.mo43869a();
    }

    /* renamed from: a */
    public static C7192a m43846a(Context context) {
        C7192a c7192a;
        synchronized (f33107e) {
            try {
                if (f33106d == null) {
                    f33106d = new C7192a(context);
                }
                c7192a = f33106d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7192a;
    }

    /* renamed from: b */
    private InterfaceC7195d m43849b() {
        PPSHsfService pPSHsfServiceMo43874a = this.f33108a.mo43874a("com.huawei.hsf.pm.service.IPackageManager");
        if (pPSHsfServiceMo43874a != null) {
            return InterfaceC7195d.a.m43867a(pPSHsfServiceMo43874a.m43843b());
        }
        AbstractC7185ho.m43824c("HsfPackageInstaller", "cannot find package manager, hsf isConnected: %s", Boolean.valueOf(this.f33108a.mo43870b()));
        return null;
    }

    /* renamed from: c */
    private void m43853c() {
        Iterator<a> it = this.f33110c.iterator();
        while (it.hasNext()) {
            m43847a(it.next().f33119c);
        }
        this.f33110c.clear();
    }

    @Override // com.huawei.openalliance.p169ad.hsf.AbstractC7196e.a
    /* renamed from: a */
    public void mo43854a() {
        this.f33109b = m43849b();
        for (a aVar : this.f33110c) {
            if (this.f33109b == null) {
                m43847a(aVar.f33119c);
            } else {
                m43852b(aVar.f33117a, aVar.f33118b, aVar.f33119c);
            }
        }
        this.f33110c.clear();
    }

    @Override // com.huawei.openalliance.p169ad.hsf.AbstractC7196e.a
    /* renamed from: b */
    public void mo43857b(int i10) {
        AbstractC7185ho.m43821b("HsfPackageInstaller", "onConnectionFailed result: %d", Integer.valueOf(i10));
        this.f33109b = null;
        if (i10 != 5 && i10 != 1) {
            m43853c();
            return;
        }
        Iterator<a> it = this.f33110c.iterator();
        while (it.hasNext()) {
            b bVar = it.next().f33119c;
            if (bVar != null) {
                bVar.mo43859a();
            }
        }
        this.f33110c.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m43850b(b bVar) {
        if (bVar != null) {
            bVar.mo43860b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.hsf.AbstractC7196e.a
    /* renamed from: a */
    public void mo43855a(int i10) {
        AbstractC7185ho.m43821b("HsfPackageInstaller", "onConnectionSuspended cause: %d", Integer.valueOf(i10));
        this.f33109b = null;
        m43853c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m43847a(b bVar) {
        if (bVar != null) {
            bVar.mo43861c();
        }
    }

    /* renamed from: b */
    private void m43852b(final String str, final String str2, final b bVar) {
        final InterfaceC7195d interfaceC7195d = this.f33109b;
        if (interfaceC7195d != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.hsf.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC7195d.mo43866a(str, str2, new InterfaceC7194c.a() { // from class: com.huawei.openalliance.ad.hsf.a.1.1
                            @Override // com.huawei.openalliance.p169ad.hsf.InterfaceC7194c
                            /* renamed from: a */
                            public void mo43858a(String str3, int i10) {
                                AbstractC7185ho.m43818a("HsfPackageInstaller", "packageInstalled %s code: %d", str3, Integer.valueOf(i10));
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (i10 == 1) {
                                    C7192a.this.m43850b(bVar);
                                } else {
                                    C7192a.this.m43847a(bVar);
                                }
                            }
                        }, 2);
                    } catch (Exception e10) {
                        AbstractC7185ho.m43823c("HsfPackageInstaller", "installPackage " + e10.getClass().getSimpleName());
                        C7192a.this.m43847a(bVar);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m43856a(String str, String str2, b bVar) {
        if (this.f33109b == null) {
            if (this.f33108a.mo43870b()) {
                InterfaceC7195d interfaceC7195dM43849b = m43849b();
                this.f33109b = interfaceC7195dM43849b;
                if (interfaceC7195dM43849b == null) {
                    m43847a(bVar);
                }
            } else {
                this.f33110c.add(new a(str, str2, bVar));
                this.f33108a.mo43869a();
            }
        }
        m43852b(str, str2, bVar);
    }
}
