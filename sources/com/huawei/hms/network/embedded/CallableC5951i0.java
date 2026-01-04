package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.i0 */
/* loaded from: classes8.dex */
public class CallableC5951i0 implements Callable<C6003m0> {

    /* renamed from: c */
    public static final String f26989c = "DnsCallable";

    /* renamed from: a */
    public final String f26990a;

    /* renamed from: b */
    public final ExecutorService f26991b;

    /* renamed from: com.huawei.hms.network.embedded.i0$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public final String f26992a;

        /* renamed from: b */
        public final InterfaceC5938h0 f26993b;

        /* renamed from: c */
        public final BlockingQueue f26994c;

        public a(String str, InterfaceC5938h0 interfaceC5938h0, BlockingQueue blockingQueue) {
            this.f26992a = str;
            this.f26993b = interfaceC5938h0;
            this.f26994c = blockingQueue;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb2 = new StringBuilder();
            InterfaceC5938h0 interfaceC5938h0 = this.f26993b;
            InterfaceC5938h0 interfaceC5938h02 = InterfaceC5938h0.f26897b;
            sb2.append(interfaceC5938h0 == interfaceC5938h02 ? "LocalDNS" : "HttpDNS");
            sb2.append(" do look up");
            Logger.m32143v(CallableC5951i0.f26989c, sb2.toString());
            C6003m0 c6003m0Lookup = this.f26993b.lookup(this.f26992a);
            if (c6003m0Lookup.m34755j()) {
                if (this.f26993b != interfaceC5938h02) {
                    Logger.m32145w(CallableC5951i0.f26989c, "HttpDNS do look up result is empty");
                    return;
                }
                Logger.m32145w(CallableC5951i0.f26989c, "LocalDNS do look up result is empty");
            }
            this.f26994c.add(c6003m0Lookup);
        }
    }

    public CallableC5951i0(String str, ExecutorService executorService) {
        this.f26990a = str;
        this.f26991b = executorService;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public C6003m0 call() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        C6003m0 c6003m0 = new C6003m0();
        try {
            if (C6093t.m35329m().m35367k()) {
                this.f26991b.execute(new a(this.f26990a, InterfaceC5938h0.f26899d, linkedBlockingQueue));
            }
            this.f26991b.execute(new a(this.f26990a, InterfaceC5938h0.f26897b, linkedBlockingQueue));
            C6003m0 c6003m02 = (C6003m0) linkedBlockingQueue.poll(C6158y.m35816a(), TimeUnit.MILLISECONDS);
            if (c6003m02 == null) {
                return c6003m0;
            }
            C6093t.m35329m().m35339a(this.f26990a, c6003m02.m34751f());
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c6003m02.m34751f() == 3 ? "HttpDNS" : "LocalDNS");
                sb2.append(" finish loop up");
                Logger.m32141i(f26989c, sb2.toString());
                return c6003m02;
            } catch (InterruptedException | RuntimeException e10) {
                e = e10;
                c6003m0 = c6003m02;
                Logger.m32146w(f26989c, "Dns loop Exception ", e);
                return c6003m0;
            }
        } catch (InterruptedException | RuntimeException e11) {
            e = e11;
        }
    }
}
