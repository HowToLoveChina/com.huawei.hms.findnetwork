package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.AbstractC5915f3;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.f3 */
/* loaded from: classes8.dex */
public abstract class AbstractC5915f3 implements InterfaceC6100t6 {

    /* renamed from: a */
    public static final String f26740a = "AbstractConnectCall";

    /* renamed from: b */
    public static Method f26741b;
    public C6062q7 client;
    public C6128v8 exchange;
    public List<InterfaceC6023n7> interceptors = new ArrayList();
    public C6101t7 request;
    public C5894d9 transmitter;

    static {
        try {
            Class cls = Boolean.TYPE;
            f26741b = C5894d9.class.getDeclaredMethod("exchangeMessageDone", C6128v8.class, cls, cls, IOException.class);
        } catch (NoSuchMethodException e10) {
            Logger.m32146w(f26740a, "Get Transmitter exchangeMessageDone error ", e10);
        }
    }

    public AbstractC5915f3(C6062q7 c6062q7, C6101t7 c6101t7) {
        this.client = c6062q7;
        this.request = c6101t7;
        this.transmitter = new C5894d9(c6062q7, this);
    }

    /* renamed from: a */
    public static /* synthetic */ Object m34212a(Method method) throws SecurityException {
        method.setAccessible(true);
        return null;
    }

    /* renamed from: b */
    public static /* synthetic */ Object m34214b(Method method) throws SecurityException {
        method.setAccessible(false);
        return null;
    }

    public abstract void addResponseInterceptor();

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public void cancel() {
        this.transmitter.cancel();
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract InterfaceC6100t6 mo85655clone();

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public void enqueue(InterfaceC6113u6 interfaceC6113u6) {
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public C6127v7 execute() throws IOException {
        try {
            this.transmitter.callStart();
            this.interceptors.add(new C6025n9(this.client));
            this.interceptors.add(new C6102t8(this.client));
            addResponseInterceptor();
            C6127v7 c6127v7Mo34620a = new C5986k9(this.interceptors, this.transmitter, null, 0, this.request, this, this.client.m35081e(), this.client.m35102z(), this.client.m35071D()).mo34620a(this.request);
            this.transmitter.noMoreExchanges(null);
            final Method methodM34213a = m34213a();
            AccessController.doPrivileged(new PrivilegedAction() { // from class: gq.a
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return AbstractC5915f3.m34212a(methodM34213a);
                }
            });
            C5894d9 c5894d9 = this.transmitter;
            Boolean bool = Boolean.TRUE;
            methodM34213a.invoke(c5894d9, this.exchange, bool, bool, null);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: gq.b
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return AbstractC5915f3.m34214b(methodM34213a);
                }
            });
            return c6127v7Mo34620a;
        } catch (IOException e10) {
            throw e10;
        } catch (Throwable th2) {
            throw new IOException("connect host error", th2);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public boolean isCanceled() {
        return this.transmitter.isCanceled();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public synchronized boolean isExecuted() {
        return false;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public C6101t7 request() {
        return this.request;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public C5855ac timeout() {
        return this.transmitter.timeout();
    }

    /* renamed from: a */
    public static synchronized Method m34213a() {
        try {
        } catch (NoSuchMethodException e10) {
            Logger.m32146w(f26740a, "Get Transmitter exchangeMessageDone error ", e10);
        }
        if (f26741b == null) {
            Class cls = Boolean.TYPE;
            f26741b = C5894d9.class.getDeclaredMethod("exchangeMessageDone", C6128v8.class, cls, cls, IOException.class);
        }
        return f26741b;
    }
}
