package com.huawei.hms.network.httpclient;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.network.AdvanceNetworkKitProvider;
import com.huawei.hms.network.api.advance.AdvanceNetworkKit;
import com.huawei.hms.network.embedded.C5911f;
import com.huawei.hms.network.embedded.C5965j1;

/* loaded from: classes8.dex */
public class DefaultAdvanceNetworkKitProvider extends AdvanceNetworkKitProvider {
    @Override // com.huawei.hms.network.AdvanceNetworkKitProvider
    public AdvanceNetworkKit createAdvanceNetworkKit() {
        return C5911f.getInstance();
    }

    @Override // com.huawei.hms.network.BaseProvider
    public int getApiLevel() {
        return C5965j1.getApiLevel();
    }

    @Override // com.huawei.hms.network.BaseProvider
    public String getName() {
        return "com.huawei.hms.network.httpclient.DefaultAdvanceNetworkKitProvider";
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
