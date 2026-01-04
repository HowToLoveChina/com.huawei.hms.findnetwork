package com.huawei.hms.support.api.tss;

import android.content.Context;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

/* renamed from: com.huawei.hms.support.api.tss.c */
/* loaded from: classes8.dex */
public class C6403c extends HmsClient {
    public C6403c(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
