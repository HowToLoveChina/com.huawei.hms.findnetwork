package com.huawei.hms.support.sms;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.hwid.C5591ah;
import com.huawei.hms.hwid.C5593aj;

/* loaded from: classes8.dex */
public class ReadSmsManager {

    /* renamed from: a */
    private static final Api<Api.ApiOptions.NoOptions> f30121a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID);

    /* renamed from: b */
    private static final C5591ah f30122b = new C5591ah();

    public static Task<Void> start(Activity activity) {
        return new C5593aj(activity, f30121a, (Api.ApiOptions.NoOptions) null, (AbstractClientBuilder) f30122b).m32874a();
    }

    public static Task<Void> startConsent(Activity activity, String str) {
        return new C5593aj(activity, f30121a, (Api.ApiOptions.NoOptions) null, (AbstractClientBuilder) f30122b).m32875a(str);
    }

    public static Task<Void> start(Context context) {
        return new C5593aj(context, f30121a, (Api.ApiOptions.NoOptions) null, f30122b).m32874a();
    }
}
