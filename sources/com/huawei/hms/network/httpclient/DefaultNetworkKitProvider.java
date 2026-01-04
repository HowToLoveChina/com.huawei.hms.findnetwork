package com.huawei.hms.network.httpclient;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.NetworkKitProvider;
import com.huawei.hms.network.embedded.C5844a1;
import com.huawei.hms.network.embedded.C5924g;
import com.huawei.hms.network.embedded.C5944h6;
import com.huawei.hms.network.embedded.C5965j1;
import com.huawei.hms.network.httpclient.internal.IHttpClientBuilder;
import com.huawei.hms.network.restclient.internal.IRestClientBuilder;

/* loaded from: classes8.dex */
public class DefaultNetworkKitProvider extends NetworkKitProvider {
    @Override // com.huawei.hms.network.NetworkKitProvider
    public IHttpClientBuilder createHttpClientBuilder() {
        return new C5844a1.b();
    }

    @Override // com.huawei.hms.network.NetworkKitProvider
    public NetworkKit createNetworkKit() {
        return C5924g.getInstance();
    }

    @Override // com.huawei.hms.network.NetworkKitProvider
    public IRestClientBuilder createRestClientBuilder() {
        return new C5944h6.b();
    }

    @Override // com.huawei.hms.network.BaseProvider
    public int getApiLevel() {
        return C5965j1.getApiLevel();
    }

    @Override // com.huawei.hms.network.BaseProvider
    public String getName() {
        return "DefaultHttpClientProvider";
    }

    @Override // com.huawei.hms.network.BaseProvider
    public String getVersion() {
        return C5965j1.getVersion();
    }

    @Override // com.huawei.hms.network.BaseProvider
    public boolean isDynamicProvider() {
        return ContextHolder.getKitContext() != null;
    }
}
