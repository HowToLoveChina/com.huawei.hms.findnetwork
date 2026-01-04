package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.AbstractC5932g7;
import com.huawei.hms.network.embedded.InterfaceC6100t6;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.g7 */
/* loaded from: classes8.dex */
public abstract class AbstractC5932g7 {
    public static final AbstractC5932g7 NONE = new a();

    /* renamed from: com.huawei.hms.network.embedded.g7$a */
    public class a extends AbstractC5932g7 {
    }

    /* renamed from: com.huawei.hms.network.embedded.g7$b */
    public interface b {
        AbstractC5932g7 create(InterfaceC6100t6 interfaceC6100t6);
    }

    /* renamed from: a */
    public static b m34312a(final AbstractC5932g7 abstractC5932g7) {
        return new b() { // from class: gq.e
            @Override // com.huawei.hms.network.embedded.AbstractC5932g7.b
            public final AbstractC5932g7 create(InterfaceC6100t6 interfaceC6100t6) {
                return AbstractC5932g7.m34313a(this.f48998a, interfaceC6100t6);
            }
        };
    }

    public void callEnd(InterfaceC6100t6 interfaceC6100t6) {
    }

    public void callFailed(InterfaceC6100t6 interfaceC6100t6, IOException iOException) {
    }

    public void callStart(InterfaceC6100t6 interfaceC6100t6) {
    }

    public void connectEnd(InterfaceC6100t6 interfaceC6100t6, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC6075r7 enumC6075r7) {
    }

    public void connectFailed(InterfaceC6100t6 interfaceC6100t6, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC6075r7 enumC6075r7, IOException iOException) {
    }

    public void connectStart(InterfaceC6100t6 interfaceC6100t6, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(InterfaceC6100t6 interfaceC6100t6, InterfaceC6165y6 interfaceC6165y6) {
    }

    public void connectionReleased(InterfaceC6100t6 interfaceC6100t6, InterfaceC6165y6 interfaceC6165y6) {
    }

    public void dnsEnd(InterfaceC6100t6 interfaceC6100t6, String str, List<InetAddress> list) {
    }

    public void dnsStart(InterfaceC6100t6 interfaceC6100t6, String str) {
    }

    public void requestBodyEnd(InterfaceC6100t6 interfaceC6100t6, long j10) {
    }

    public void requestBodyStart(InterfaceC6100t6 interfaceC6100t6) {
    }

    public void requestFailed(InterfaceC6100t6 interfaceC6100t6, IOException iOException) {
    }

    public void requestHeadersEnd(InterfaceC6100t6 interfaceC6100t6, C6101t7 c6101t7) {
    }

    public void requestHeadersStart(InterfaceC6100t6 interfaceC6100t6) {
    }

    public void responseBodyEnd(InterfaceC6100t6 interfaceC6100t6, long j10) {
    }

    public void responseBodyStart(InterfaceC6100t6 interfaceC6100t6) {
    }

    public void responseFailed(InterfaceC6100t6 interfaceC6100t6, IOException iOException) {
    }

    public void responseHeadersEnd(InterfaceC6100t6 interfaceC6100t6, C6127v7 c6127v7) {
    }

    public void responseHeadersStart(InterfaceC6100t6 interfaceC6100t6) {
    }

    public void secureConnectEnd(InterfaceC6100t6 interfaceC6100t6, C5958i7 c5958i7) {
    }

    public void secureConnectStart(InterfaceC6100t6 interfaceC6100t6) {
    }

    /* renamed from: a */
    public static /* synthetic */ AbstractC5932g7 m34313a(AbstractC5932g7 abstractC5932g7, InterfaceC6100t6 interfaceC6100t6) {
        return abstractC5932g7;
    }
}
