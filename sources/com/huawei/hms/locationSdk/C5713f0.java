package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.api.location.common.LocationClientStateManager;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.locationSdk.f0 */
/* loaded from: classes8.dex */
public class C5713f0 extends AbstractClientBuilder<C5750r0, C5765w0> {

    /* renamed from: com.huawei.hms.locationSdk.f0$a */
    public static class a implements BaseHmsClient.ConnectionCallbacks {

        /* renamed from: a */
        private BaseHmsClient.ConnectionCallbacks f25510a;

        public a(BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
            this.f25510a = connectionCallbacks;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.m36988i("LocationClientBuilder", "onConnected, send suspended requests,reStartState:" + LocationClientStateManager.getInstance().getResendState());
            BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.f25510a;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnected();
            }
            if (LocationClientStateManager.getInstance().getResendState() == 2) {
                LocationClientStateManager.getInstance().reStartHmsLocation();
            }
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
            HMSLog.m36988i("LocationClientBuilder", "onConnectionSuspended reason:" + i10);
            BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.f25510a;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(i10);
            }
            LocationClientStateManager.getInstance().checkCanResend();
        }
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public C5750r0 buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C5750r0(context, clientSettings, onConnectionFailedListener, new a(connectionCallbacks));
    }
}
