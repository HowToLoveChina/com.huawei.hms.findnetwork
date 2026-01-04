package com.huawei.hms.network;

import android.content.Context;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.api.advance.AdvanceNetworkKit;

/* loaded from: classes8.dex */
public abstract class AdvanceNetworkKitProvider extends BaseProvider {
    private static final String DEFAULT_ADVANCE_PROVIDER = "com.huawei.hms.network.httpclient.DefaultAdvanceNetworkKitProvider";
    private static final Object LOCK = new Object();
    private static final String TAG = "AdvanceNetworkKitProvider";
    private static volatile AdvanceNetworkKitProvider enableProvider;

    private static AdvanceNetworkKitProvider addAdvanceProviderByClass(Context context) {
        try {
            return (AdvanceNetworkKitProvider) context.getClassLoader().loadClass(DEFAULT_ADVANCE_PROVIDER).asSubclass(AdvanceNetworkKitProvider.class).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e10) {
            Logger.m32139e(TAG, "com.huawei.hms.network.httpclient.DefaultAdvanceNetworkKitProvider not found", e10);
            return null;
        }
    }

    private static AdvanceNetworkKitProvider addHmsAdvanceProvider() {
        Context remoteContext = NetworkKit.getRemoteInitializer().getRemoteContext();
        if (remoteContext != null) {
            return addAdvanceProviderByClass(remoteContext);
        }
        throw new IllegalStateException("Unable to find AdvanceNetworkKit provider");
    }

    private static AdvanceNetworkKitProvider getAdvanceProvider(Context context) {
        return DynamicLoaderHelper.getInstance().getDynamicStatus() ? addHmsAdvanceProvider() : addAdvanceProviderByClass(context);
    }

    public static AdvanceNetworkKitProvider getEnableProvider() {
        NetworkKit.getInstance();
        synchronized (LOCK) {
            try {
                if (enableProvider != null) {
                    return enableProvider;
                }
                enableProvider = getAdvanceProvider(ContextHolder.getAppContext());
                if (enableProvider == null) {
                    throw new IllegalStateException("Unable to find AdvanceNetworkKit provider");
                }
                Logger.m32142i(TAG, "AdvanceNetworkKitProvider is dynamic provider result : %s", Boolean.valueOf(enableProvider.isDynamicProvider()));
                return enableProvider;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract AdvanceNetworkKit createAdvanceNetworkKit();
}
