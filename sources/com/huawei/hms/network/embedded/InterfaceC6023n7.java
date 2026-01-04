package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.n7 */
/* loaded from: classes8.dex */
public interface InterfaceC6023n7 {

    /* renamed from: com.huawei.hms.network.embedded.n7$a */
    public interface a {
        /* renamed from: a */
        a mo34619a(int i10, TimeUnit timeUnit);

        /* renamed from: a */
        C6127v7 mo34620a(C6101t7 c6101t7) throws IOException;

        /* renamed from: a */
        InterfaceC6165y6 mo34622a();

        /* renamed from: b */
        int mo34623b();

        /* renamed from: b */
        a mo34624b(int i10, TimeUnit timeUnit);

        /* renamed from: c */
        int mo34625c();

        /* renamed from: c */
        a mo34626c(int i10, TimeUnit timeUnit);

        InterfaceC6100t6 call();

        /* renamed from: d */
        int mo34627d();

        C6101t7 request();
    }

    C6127v7 intercept(a aVar) throws IOException;
}
