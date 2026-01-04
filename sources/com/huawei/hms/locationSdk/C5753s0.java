package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

/* renamed from: com.huawei.hms.locationSdk.s0 */
/* loaded from: classes8.dex */
public class C5753s0 extends HmsClient {
    public C5753s0(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public int getMinApkVersion() {
        return 50000000;
    }

    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public String getServiceAction() {
        return "com.huawei.hms.core.locationaidlservice";
    }
}
