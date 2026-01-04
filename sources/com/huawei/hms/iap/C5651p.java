package com.huawei.hms.iap;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hms.iap.p */
/* loaded from: classes8.dex */
public class C5651p extends AbstractClientBuilder<C5642g, C5644i> {

    /* renamed from: com.huawei.hms.iap.p$a */
    public static class a extends C5642g {
        public a(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
            super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient
        public int getMinApkVersion() {
            return 40004200;
        }
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C5642g buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new a(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
