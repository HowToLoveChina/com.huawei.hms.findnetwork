package com.huawei.hms.p109a.p110a.p112b;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;

/* renamed from: com.huawei.hms.a.a.b.a */
/* loaded from: classes8.dex */
public class C5038a extends HmsClient {
    public C5038a(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public int getMinApkVersion() {
        return AuthInternalPickerConstant.HMS_APK_VERSION_MIN;
    }
}
