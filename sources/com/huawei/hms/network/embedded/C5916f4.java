package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.InterfaceC5886d1;
import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.huawei.hms.network.embedded.f4 */
/* loaded from: classes8.dex */
public class C5916f4 implements InterfaceC5886d1.a {

    /* renamed from: a */
    public C5844a1 f26742a;

    public C5916f4(C5844a1 c5844a1) {
        this.f26742a = c5844a1;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public String getChannel() {
        return "type_urlconnection";
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f26742a.getHostnameVerifier();
    }

    public Proxy getProxy() {
        return this.f26742a.getProxy();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f26742a.getSslSocketFactory();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public boolean isAvailable() {
        return true;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public InterfaceC5886d1 newTask() {
        return new C5903e4(this);
    }
}
