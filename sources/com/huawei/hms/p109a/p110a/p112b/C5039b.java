package com.huawei.hms.p109a.p110a.p112b;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.picker.request.AccountPickerParams;

/* renamed from: com.huawei.hms.a.a.b.b */
/* loaded from: classes8.dex */
public class C5039b extends AbstractClientBuilder<C5038a, AccountPickerParams> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C5038a buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C5038a(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
