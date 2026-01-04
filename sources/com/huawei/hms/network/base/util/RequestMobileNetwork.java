package com.huawei.hms.network.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.huawei.hms.framework.common.ContextCompat;
import com.huawei.hms.framework.common.Logger;

/* loaded from: classes8.dex */
public class RequestMobileNetwork {

    /* renamed from: a */
    private static final String f26231a = "RequestMobileNetwork";

    /* renamed from: b */
    private static String f26232b;

    /* renamed from: c */
    private static final Object f26233c = new Object();

    /* renamed from: d */
    private static ConnectivityManager.NetworkCallback f26234d;

    public static synchronized String requestMobileNiName(Context context, int i10) {
        try {
            if (!ContextCompat.checkSelfPermission(context, "android.permission.CHANGE_NETWORK_STATE")) {
                return null;
            }
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            f26232b = "";
            if (f26234d == null) {
                f26234d = new ConnectivityManager.NetworkCallback() { // from class: com.huawei.hms.network.base.util.RequestMobileNetwork.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        String unused = RequestMobileNetwork.f26232b = connectivityManager.getLinkProperties(network).getInterfaceName();
                        synchronized (RequestMobileNetwork.f26233c) {
                            RequestMobileNetwork.f26233c.notify();
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onUnavailable() {
                        super.onUnavailable();
                        synchronized (RequestMobileNetwork.f26233c) {
                            RequestMobileNetwork.f26233c.notify();
                        }
                    }
                };
            }
            connectivityManager.requestNetwork(networkRequestBuild, f26234d);
            try {
                Object obj = f26233c;
                synchronized (obj) {
                    obj.wait(i10);
                }
            } catch (InterruptedException e10) {
                Logger.m32145w(f26231a, e10.getMessage());
            }
            return f26232b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void stopMobileNetwork(Context context) {
        if (f26234d != null) {
            ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback(f26234d);
            f26234d = null;
        }
    }
}
