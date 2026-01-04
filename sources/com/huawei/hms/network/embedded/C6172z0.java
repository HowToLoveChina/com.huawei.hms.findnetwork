package com.huawei.hms.network.embedded;

import com.huawei.hms.network.httpclient.okhttp.OkHttpClientGlobal;
import com.huawei.hms.network.inner.api.ProtocolStackManager;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.z0 */
/* loaded from: classes8.dex */
public class C6172z0 extends ProtocolStackManager {

    /* renamed from: a */
    public OkHttpClientGlobal f29222a;

    @Override // com.huawei.hms.network.inner.api.ProtocolStackManager
    public List<String> getHostsInConnectionPool() {
        if (this.f29222a == null) {
            this.f29222a = OkHttpClientGlobal.getInstance();
        }
        return this.f29222a.getHostsInConnectionPool();
    }
}
