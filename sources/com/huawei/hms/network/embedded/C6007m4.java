package com.huawei.hms.network.embedded;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PackageManagerCompat;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.embedded.m4 */
/* loaded from: classes8.dex */
public final class C6007m4 {

    /* renamed from: e */
    public static final String f27478e = "NetSerManager";

    /* renamed from: f */
    public static final String f27479f = "networkservice_";

    /* renamed from: h */
    public static final String f27481h = "networkservice_config";

    /* renamed from: a */
    public PolicyNetworkService f27483a;

    /* renamed from: b */
    public Context f27484b;

    /* renamed from: c */
    public volatile ConcurrentHashMap<String, NetworkService> f27485c = new ConcurrentHashMap<>(8);

    /* renamed from: d */
    public C6020n4 f27486d;

    /* renamed from: g */
    public static final C6007m4 f27480g = new C6007m4();

    /* renamed from: i */
    public static final List<String> f27482i = Collections.unmodifiableList(Arrays.asList("core_switch_dns", "core_switch_config"));

    /* renamed from: b */
    private NetworkService m34757b(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f27478e, "networkService classPath is null");
            return null;
        }
        try {
            ClassLoader classLoader = C6007m4.class.getClassLoader();
            if (classLoader != null) {
                NetworkService networkService = (NetworkService) classLoader.loadClass(str).asSubclass(NetworkService.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                networkService.onCreate(context, bundle);
                return networkService;
            }
        } catch (Throwable unused) {
            Logger.m32145w(f27478e, "network service load failed");
        }
        return null;
    }

    /* renamed from: c */
    public static C6007m4 m34758c() {
        return f27480g;
    }

    /* renamed from: a */
    public Boolean m34759a(String str) {
        return this.f27486d.m34885a(str);
    }

    /* renamed from: d */
    public void m34766d(String str) {
        if (str == null || !this.f27485c.containsKey(str)) {
            return;
        }
        this.f27485c.remove(str);
    }

    /* renamed from: a */
    public List<NetworkService> m34760a() {
        return new ArrayList(this.f27485c.values());
    }

    /* renamed from: b */
    public NetworkService m34763b(String str) {
        return this.f27485c.get(str);
    }

    /* renamed from: c */
    public Boolean m34765c(String str) {
        return Boolean.valueOf(this.f27486d.m34887b(str));
    }

    /* renamed from: a */
    private Map<String, String> m34756a(Context context, Bundle bundle) {
        NetworkService networkServiceM34757b = m34757b(context, PackageManagerCompat.getMetaDataFromKitOrApp(context, f27481h, ""), bundle);
        if (!(networkServiceM34757b instanceof PolicyNetworkService)) {
            throw new IllegalStateException("configPolicyService is error");
        }
        this.f27483a = (PolicyNetworkService) networkServiceM34757b;
        this.f27485c.put(NetworkService.Constants.CONFIG_SERVICE, this.f27483a);
        Map<String, String> metaDataMapFromKitOrApp = PackageManagerCompat.getMetaDataMapFromKitOrApp(context, f27479f);
        if (!metaDataMapFromKitOrApp.isEmpty() && metaDataMapFromKitOrApp.containsKey(NetworkService.Constants.CONFIG_SERVICE)) {
            metaDataMapFromKitOrApp.remove(NetworkService.Constants.CONFIG_SERVICE);
        }
        return metaDataMapFromKitOrApp;
    }

    /* renamed from: b */
    public void m34764b() {
        this.f27485c.clear();
    }

    /* renamed from: a */
    public synchronized void m34761a(Context context, String str, Bundle bundle) {
        try {
            this.f27484b = context;
            this.f27486d = new C6020n4(str);
            Map<String, String> mapM34756a = m34756a(context, bundle);
            this.f27486d.m34886a();
            if (!mapM34756a.isEmpty()) {
                for (Map.Entry<String, String> entry : mapM34756a.entrySet()) {
                    String key = entry.getKey();
                    String str2 = PolicyNetworkService.NETWORK_SWITCH_CONFIG_PRE + key;
                    if (f27482i.contains(str2) || this.f27486d.m34887b(str2)) {
                        NetworkService networkServiceM34757b = m34757b(context, entry.getValue(), bundle);
                        if (networkServiceM34757b != null) {
                            this.f27485c.put(key, networkServiceM34757b);
                        }
                    }
                }
            }
            Logger.m32141i(f27478e, "networkServices map is: " + this.f27485c);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m34762a(PolicyNetworkService policyNetworkService) {
        if (this.f27484b == null) {
            return;
        }
        for (String str : NetworkService.Constants.NETWORK_SERVICES) {
            NetworkService networkServiceM34763b = m34763b(str);
            if (networkServiceM34763b != null) {
                Logger.m32141i(f27478e, str + "Service,setOptions:");
                networkServiceM34763b.serviceOptions(policyNetworkService.getValues("", (String[]) PolicyNetworkService.GlobalConstants.GLOBAL_CONSTANTS.toArray(new String[0])));
            }
        }
    }
}
