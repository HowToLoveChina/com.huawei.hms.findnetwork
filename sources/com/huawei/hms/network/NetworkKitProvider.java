package com.huawei.hms.network;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.network.RemoteInitializer;
import com.huawei.hms.network.httpclient.internal.IHttpClientBuilder;
import com.huawei.hms.network.restclient.internal.IRestClientBuilder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class NetworkKitProvider extends BaseProvider {

    /* renamed from: a */
    private static final String f25633a = "NetworkKitProvider";

    /* renamed from: b */
    private static final String f25634b = "com.huawei.hms.network.httpclient.DefaultNetworkKitProvider";

    /* renamed from: c */
    private static final Object f25635c = new Object();

    /* renamed from: d */
    private static volatile NetworkKitProvider f25636d;

    /* renamed from: a */
    private static int m33224a(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    /* renamed from: b */
    private static void m33229b(Context context, List<NetworkKitProvider> list) {
        if (list.size() == 0) {
            Logger.m32136d(f25633a, "start load local");
            Logger.m32141i(f25633a, "load local result is: " + m33227a(context, list));
        }
        if (list.size() <= 0) {
            throw new IllegalStateException("Unable to find NetworkKitProvider provider, context: " + context.getPackageName());
        }
        f25636d = list.get(0);
        Logger.m32142i(f25633a, "provider client version code: %s, api level: %s", f25636d.getVersion(), Integer.valueOf(f25636d.getApiLevel()));
        DynamicLoaderHelper.getInstance().setDynamicStatus(f25636d.isDynamicProvider());
        Logger.m32142i(f25633a, "NetworkKitProvider is dynamic provider result : %s", Boolean.valueOf(f25636d.isDynamicProvider()));
    }

    public static NetworkKitProvider getEnableProvider() {
        return getEnableProvider(false);
    }

    public static NetworkKitProvider loadLocalProvider() {
        synchronized (f25635c) {
            try {
                if (f25636d != null) {
                    return f25636d;
                }
                m33229b(NetworkKit.getContext(), new ArrayList());
                return f25636d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract IHttpClientBuilder createHttpClientBuilder();

    public abstract NetworkKit createNetworkKit();

    public abstract IRestClientBuilder createRestClientBuilder();

    /* renamed from: a */
    private static int m33225a(String str) {
        if (str == null) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 4) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                String str2 = strArrSplit[i10];
                if (Integer.parseInt(str2) <= 9 && (i10 == 1 || i10 == 2)) {
                    sb2.append("0");
                }
                sb2.append(str2);
            } catch (NumberFormatException unused) {
                Logger.m32138e(f25633a, "getVersionNumber error " + str);
                return 0;
            }
        }
        return Integer.parseInt(sb2.toString());
    }

    public static NetworkKitProvider getEnableProvider(boolean z10) {
        if (!z10) {
            NetworkKit.getInstance();
        }
        synchronized (f25635c) {
            try {
                if (f25636d != null) {
                    return f25636d;
                }
                List<NetworkKitProvider> listM33226a = m33226a(NetworkKit.getContext());
                int iM33225a = m33225a(Version.getVersion());
                for (int size = listM33226a.size() - 1; size >= 0; size--) {
                    NetworkKitProvider networkKitProvider = listM33226a.get(size);
                    new PLSharedPreferences(NetworkKit.getContext(), RemoteInitializer.C5782b.f25653i).putString("kit_version", networkKitProvider.getVersion());
                    if (networkKitProvider.getApiLevel() < Version.getApi() || m33224a(m33225a(networkKitProvider.getVersion()), iM33225a) <= 0) {
                        listM33226a.remove(size);
                    }
                }
                m33229b(NetworkKit.getContext(), listM33226a);
                return f25636d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private static List<NetworkKitProvider> m33226a(Context context) {
        ArrayList arrayList = new ArrayList();
        Logger.m32142i(f25633a, "load hms result is: %s", Boolean.valueOf(m33228a(arrayList)));
        return new ArrayList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static boolean m33227a(Context context, List<NetworkKitProvider> list) {
        try {
            list.add(context.getClassLoader().loadClass(f25634b).asSubclass(NetworkKitProvider.class).getConstructor(new Class[0]).newInstance(new Object[0]));
            return true;
        } catch (Exception e10) {
            Logger.m32139e(f25633a, context.getPackageName() + " DefaultNetworkKitProvider not found", e10);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m33228a(List<NetworkKitProvider> list) {
        Context remoteContext = NetworkKit.getRemoteInitializer().getRemoteContext();
        if (remoteContext != null) {
            return m33227a(remoteContext, list);
        }
        return false;
    }
}
