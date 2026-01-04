package com.huawei.hms.network.inner.api;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.network.embedded.C5994l4;
import com.huawei.hms.network.embedded.C6007m4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class NetworkKitInnerImpl {
    public static final NetworkKitInnerImpl INSTANCE = new NetworkKitInnerImpl();
    public ProtocolStackManager protocolStackManager;

    public static NetworkKitInnerImpl getInstance() {
        return INSTANCE;
    }

    private C6007m4 getNetworkServiceManager() {
        return C6007m4.m34758c();
    }

    public List<NetworkService> getAll() {
        return getNetworkServiceManager().m34760a();
    }

    public List<String> getHostsInConnectionPool() {
        ProtocolStackManager protocolStackManager = this.protocolStackManager;
        return protocolStackManager != null ? protocolStackManager.getHostsInConnectionPool() : new ArrayList();
    }

    public InterceptorNetworkService getInterceptorNetworkService(String str) {
        NetworkService networkServiceM34763b = getNetworkServiceManager().m34763b(str);
        if (networkServiceM34763b instanceof InterceptorNetworkService) {
            return (InterceptorNetworkService) networkServiceM34763b;
        }
        return null;
    }

    public C5994l4 getNetworkBroadcastManager() {
        return C5994l4.m34650b();
    }

    public PolicyNetworkService getPolicyNetworkService(String str) {
        NetworkService networkServiceM34763b = getNetworkServiceManager().m34763b(str);
        if (networkServiceM34763b instanceof PolicyNetworkService) {
            return (PolicyNetworkService) networkServiceM34763b;
        }
        return null;
    }

    public NetworkService getService(String str) {
        return getNetworkServiceManager().m34763b(str);
    }

    public NetworkKitInnerImpl init(Context context, String str, Bundle bundle) {
        getNetworkServiceManager().m34761a(context, str, bundle);
        return this;
    }

    public void setPolicyExecutor(PolicyNetworkService policyNetworkService) {
        getNetworkServiceManager().m34762a(policyNetworkService);
    }

    public void setProtocolStackManager(ProtocolStackManager protocolStackManager) {
        this.protocolStackManager = protocolStackManager;
    }
}
