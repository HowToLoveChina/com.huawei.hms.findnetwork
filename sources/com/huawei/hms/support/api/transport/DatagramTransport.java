package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* loaded from: classes8.dex */
public interface DatagramTransport {

    /* renamed from: com.huawei.hms.support.api.transport.DatagramTransport$a */
    public interface InterfaceC6400a {
        /* renamed from: a */
        void mo36643a(int i10, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, InterfaceC6400a interfaceC6400a);

    void send(ApiClient apiClient, InterfaceC6400a interfaceC6400a);
}
