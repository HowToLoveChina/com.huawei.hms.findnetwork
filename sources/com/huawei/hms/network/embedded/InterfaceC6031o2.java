package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.network.inner.api.DnsNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.o2 */
/* loaded from: classes8.dex */
public interface InterfaceC6031o2 {
    public static final InterfaceC6031o2 DEFAULT = new a();

    /* renamed from: com.huawei.hms.network.embedded.o2$a */
    public class a implements InterfaceC6031o2 {

        /* renamed from: a */
        public DnsNetworkService f27605a;

        @Override // com.huawei.hms.network.embedded.InterfaceC6031o2
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            if (TextUtils.isEmpty(str)) {
                throw new UnknownHostException("hostname == null");
            }
            if (this.f27605a == null) {
                NetworkService service = NetworkKitInnerImpl.getInstance().getService("dns");
                if (!(service instanceof DnsNetworkService)) {
                    throw new IllegalStateException("DNS service not available");
                }
                this.f27605a = (DnsNetworkService) service;
            }
            return this.f27605a.lookup(str);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6031o2
        public void setDnstime(int i10) {
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;

    void setDnstime(int i10);
}
