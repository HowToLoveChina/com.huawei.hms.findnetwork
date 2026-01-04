package com.huawei.hms.network.embedded;

import com.huawei.hms.network.exception.NetworkCanceledExceptionImpl;
import com.huawei.hms.network.exception.NetworkInternalExceptionImpl;
import com.huawei.hms.network.exception.NetworkTimeoutExceptionImpl;
import com.huawei.hms.network.exception.NetworkUnsupportedExceptionImpl;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.t0 */
/* loaded from: classes8.dex */
public class C6094t0 {
    /* renamed from: a */
    public static IOException m35373a(String str) {
        return C5939h1.apiAvailable(4) ? new NetworkCanceledExceptionImpl(str) : new IOException(str);
    }

    /* renamed from: b */
    public static IOException m35375b(String str) {
        return C5939h1.apiAvailable(4) ? new NetworkInternalExceptionImpl(str) : new IOException(str);
    }

    /* renamed from: c */
    public static IOException m35377c(String str) {
        return C5939h1.apiAvailable(4) ? new NetworkTimeoutExceptionImpl(str) : new IOException(str);
    }

    /* renamed from: d */
    public static IOException m35379d(String str) {
        return C5939h1.apiAvailable(4) ? new NetworkUnsupportedExceptionImpl(str) : new IOException(str);
    }

    /* renamed from: a */
    public static IOException m35374a(String str, Throwable th2) {
        return C5939h1.apiAvailable(4) ? new NetworkCanceledExceptionImpl(str, th2) : new IOException(str, th2);
    }

    /* renamed from: b */
    public static IOException m35376b(String str, Throwable th2) {
        return C5939h1.apiAvailable(4) ? new NetworkInternalExceptionImpl(str, th2) : new IOException(str, th2);
    }

    /* renamed from: c */
    public static IOException m35378c(String str, Throwable th2) {
        return C5939h1.apiAvailable(4) ? new NetworkTimeoutExceptionImpl(str, th2) : new IOException(str, th2);
    }

    /* renamed from: d */
    public static IOException m35380d(String str, Throwable th2) {
        return C5939h1.apiAvailable(4) ? new NetworkUnsupportedExceptionImpl(str, th2) : new IOException(str, th2);
    }
}
