package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.inner.api.NetworkReceiver;

/* renamed from: com.huawei.hms.network.embedded.u */
/* loaded from: classes8.dex */
public class C6106u implements NetworkReceiver {

    /* renamed from: b */
    public static final String f28441b = "DNSNetworkReceiver";

    /* renamed from: a */
    public NetworkInfo f28442a;

    public C6106u() {
        NetworkInfo networkInfo = NetworkUtil.getNetworkInfo(ContextHolder.getAppContext());
        this.f28442a = networkInfo;
        Object[] objArr = new Object[1];
        objArr[0] = networkInfo == null ? "null" : networkInfo.toString();
        Logger.m32144v(f28441b, "lastActivityNetInfo: %s", objArr);
    }

    /* renamed from: a */
    private boolean m35474a(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        return NetworkUtil.isChangeToConnected(networkInfo, networkInfo2) || NetworkUtil.isConnectTypeChange(networkInfo, networkInfo2);
    }

    @Override // com.huawei.hms.network.inner.api.NetworkReceiver
    public void onReceiveMsg(Context context, Intent intent) {
        NetworkInfo networkInfo = NetworkUtil.getNetworkInfo(context);
        if (networkInfo == null) {
            Logger.m32143v(f28441b, "Get NetworkInfo failed");
            return;
        }
        Logger.m32144v(f28441b, "networkInfo: %s", networkInfo);
        if (m35474a(this.f28442a, networkInfo)) {
            C5843a0.m33735a(networkInfo);
            this.f28442a = networkInfo;
        }
    }
}
