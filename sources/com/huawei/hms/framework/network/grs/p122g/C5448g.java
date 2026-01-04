package com.huawei.hms.framework.network.grs.p122g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.InterfaceC5430b;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import com.huawei.hms.framework.network.grs.p122g.p123i.C5450a;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5452b;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5453c;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5454d;
import com.huawei.hms.framework.network.grs.p125h.C5458d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.framework.network.grs.g.g */
/* loaded from: classes8.dex */
public class C5448g {

    /* renamed from: b */
    private static final ExecutorService f24976b = ExecutorsUtils.newCachedThreadPool("GrsReqPool");

    /* renamed from: c */
    private static final Map<String, C5452b> f24977c = new ConcurrentHashMap(16);

    /* renamed from: d */
    private static final Object f24978d = new Object();

    /* renamed from: a */
    private C5434a f24979a;

    /* renamed from: com.huawei.hms.framework.network.grs.g.g$a */
    public class a implements Callable<C5445d> {

        /* renamed from: a */
        final /* synthetic */ C5453c f24980a;

        /* renamed from: b */
        final /* synthetic */ String f24981b;

        /* renamed from: c */
        final /* synthetic */ C5436c f24982c;

        public a(C5453c c5453c, String str, C5436c c5436c) {
            this.f24980a = c5453c;
            this.f24981b = str;
            this.f24982c = c5436c;
        }

        @Override // java.util.concurrent.Callable
        public C5445d call() {
            return new C5444c(this.f24980a, C5448g.this.f24979a).m32252a(C5448g.f24976b, this.f24981b, this.f24982c);
        }
    }

    /* renamed from: com.huawei.hms.framework.network.grs.g.g$b */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C5453c f24984a;

        /* renamed from: b */
        final /* synthetic */ String f24985b;

        /* renamed from: c */
        final /* synthetic */ C5436c f24986c;

        /* renamed from: d */
        final /* synthetic */ int f24987d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC5430b f24988e;

        public b(C5453c c5453c, String str, C5436c c5436c, int i10, InterfaceC5430b interfaceC5430b) {
            this.f24984a = c5453c;
            this.f24985b = str;
            this.f24986c = c5436c;
            this.f24987d = i10;
            this.f24988e = interfaceC5430b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5448g c5448g = C5448g.this;
            c5448g.m32295a(c5448g.m32297a(this.f24984a, this.f24985b, this.f24986c, this.f24987d), this.f24988e);
        }
    }

    /* renamed from: a */
    public C5445d m32297a(C5453c c5453c, String str, C5436c c5436c, int i10) {
        Future<C5445d> futureSubmit;
        String str2;
        String str3;
        Logger.m32136d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = c5453c.m32310b().getGrsParasKey(true, true, c5453c.m32308a());
        Logger.m32143v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (f24978d) {
            try {
                if (!NetworkUtil.isNetworkAvailable(c5453c.m32308a())) {
                    return null;
                }
                C5458d.a aVarM32328a = C5458d.m32328a(grsParasKey);
                Map<String, C5452b> map = f24977c;
                C5452b c5452b = map.get(grsParasKey);
                if (c5452b == null || !c5452b.m32305b()) {
                    if (aVarM32328a != null && aVarM32328a.m32330a()) {
                        return null;
                    }
                    Logger.m32136d("RequestController", "hitGrsRequestBean == null or request block is released.");
                    futureSubmit = f24976b.submit(new a(c5453c, str, c5436c));
                    map.put(grsParasKey, new C5452b(futureSubmit));
                } else {
                    futureSubmit = c5452b.m32304a();
                }
                if (i10 == -1) {
                    C5454d c5454dM32303a = C5450a.m32303a(c5453c.m32308a());
                    i10 = c5454dM32303a != null ? c5454dM32303a.m32318c() : 10;
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i10);
                objArr[1] = c5453c.m32308a() == null ? "" : c5453c.m32308a().getPackageName();
                Logger.m32142i("RequestController", "use grsQueryTimeout %d, pkg:%s", objArr);
                try {
                    return futureSubmit.get(i10, TimeUnit.SECONDS);
                } catch (InterruptedException e10) {
                    e = e10;
                    str2 = "RequestController";
                    str3 = "when check result, find InterruptedException, check others";
                    Logger.m32146w(str2, str3, e);
                    return null;
                } catch (CancellationException e11) {
                    e = e11;
                    str2 = "RequestController";
                    str3 = "when check result, find CancellationException, check others";
                    Logger.m32146w(str2, str3, e);
                    return null;
                } catch (ExecutionException e12) {
                    e = e12;
                    str2 = "RequestController";
                    str3 = "when check result, find ExecutionException, check others";
                    Logger.m32146w(str2, str3, e);
                    return null;
                } catch (TimeoutException e13) {
                    e = e13;
                    str2 = "RequestController";
                    str3 = "when check result, find TimeoutException, check others";
                    Logger.m32146w(str2, str3, e);
                    return null;
                } catch (Exception e14) {
                    e = e14;
                    str2 = "RequestController";
                    str3 = "when check result, find Other Exception, check others";
                    Logger.m32146w(str2, str3, e);
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m32298a(C5434a c5434a) {
        this.f24979a = c5434a;
    }

    /* renamed from: a */
    public void m32295a(C5445d c5445d, InterfaceC5430b interfaceC5430b) {
        if (interfaceC5430b != null) {
            if (c5445d == null) {
                Logger.m32143v("RequestController", "GrsResponse is null");
                interfaceC5430b.mo32159a();
            } else {
                Logger.m32143v("RequestController", "GrsResponse is not null");
                interfaceC5430b.mo32160a(c5445d);
            }
        }
    }

    /* renamed from: a */
    public void m32299a(C5453c c5453c, InterfaceC5430b interfaceC5430b, String str, C5436c c5436c, int i10) {
        f24976b.execute(new b(c5453c, str, c5436c, i10, interfaceC5430b));
    }

    /* renamed from: a */
    public void m32300a(String str) {
        synchronized (f24978d) {
            f24977c.remove(str);
        }
    }
}
