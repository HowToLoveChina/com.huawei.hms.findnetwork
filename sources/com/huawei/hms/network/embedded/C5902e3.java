package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.lang.ref.WeakReference;
import java.net.SocketException;

/* renamed from: com.huawei.hms.network.embedded.e3 */
/* loaded from: classes8.dex */
public class C5902e3 {

    /* renamed from: c */
    public static final String f26676c = "ConnectionInfo";

    /* renamed from: a */
    public String f26677a;

    /* renamed from: b */
    public WeakReference<C6167y8> f26678b;

    public C5902e3(String str, C6167y8 c6167y8) {
        this.f26677a = str;
        this.f26678b = new WeakReference<>(c6167y8);
    }

    public String getHost() {
        return this.f26677a;
    }

    public boolean isHealthy(boolean z10) throws SocketException {
        C6167y8 c6167y8;
        WeakReference<C6167y8> weakReference = this.f26678b;
        if (weakReference == null || (c6167y8 = weakReference.get()) == null) {
            return false;
        }
        boolean zM35860a = c6167y8.m35860a(z10);
        Object[] objArr = {this.f26677a};
        if (zM35860a) {
            Logger.m32144v(f26676c, "the host is : %s,and the connection is healthy!", objArr);
            return true;
        }
        Logger.m32144v(f26676c, "the host is : %s,but the connection is unhealthy!", objArr);
        return false;
    }
}
