package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.t6 */
/* loaded from: classes8.dex */
public interface InterfaceC6100t6 extends Cloneable {

    /* renamed from: com.huawei.hms.network.embedded.t6$a */
    public interface a {
        /* renamed from: a */
        InterfaceC6100t6 mo35073a(C6101t7 c6101t7);
    }

    void cancel();

    InterfaceC6100t6 clone();

    void enqueue(InterfaceC6113u6 interfaceC6113u6);

    C6127v7 execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C6101t7 request();

    C5855ac timeout();
}
