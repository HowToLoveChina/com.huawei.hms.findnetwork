package com.huawei.hms.network.embedded;

import android.content.Context;
import com.huawei.hms.network.ComposedNetworkKit;
import com.huawei.hms.network.NetworkKit;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.network.embedded.g */
/* loaded from: classes8.dex */
public class C5924g extends NetworkKit {

    /* renamed from: a */
    public static final String f26785a = "NetworkKitImpl";

    /* renamed from: b */
    public static final NetworkKit f26786b = new C5924g();

    public static NetworkKit getInstance() {
        return f26786b;
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void addQuicHint(boolean z10, String... strArr) {
        ComposedNetworkKit.getInstance().addQuicHint(z10, strArr);
    }

    public boolean checkConnectivity() {
        return ComposedNetworkKit.getInstance().checkConnectivity();
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void evictAllConnections() {
        ComposedNetworkKit.getInstance().evictAllConnections();
    }

    @Override // com.huawei.hms.network.NetworkKit
    public String getOption(String str) {
        return ComposedNetworkKit.getInstance().getOption("", str);
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void initConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        ComposedNetworkKit.getInstance().initConnectionPool(i10, j10, timeUnit);
    }

    public void initKit(Context context) throws InterruptedException, TimeoutException, BrokenBarrierException {
        ComposedNetworkKit.getInstance().initKit(context, "");
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void setOptions(String str) {
        ComposedNetworkKit.getInstance().setOptions(str);
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void initKit(Context context, String str) throws InterruptedException, TimeoutException, BrokenBarrierException {
        ComposedNetworkKit.getInstance().initKit(context, str);
    }
}
