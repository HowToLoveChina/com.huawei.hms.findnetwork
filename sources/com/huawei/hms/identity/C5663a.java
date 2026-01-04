package com.huawei.hms.identity;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.identity.entity.GetUserAddressResult;
import com.huawei.hms.identity.entity.UserAddressRequest;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.JsonUtil;

/* renamed from: com.huawei.hms.identity.a */
/* loaded from: classes8.dex */
public class C5663a extends HuaweiApi<C5667e> implements AddressClient {

    /* renamed from: a */
    private static final String f25453a = "addressClient";

    /* renamed from: b */
    private static final int f25454b = 1;

    /* renamed from: c */
    private static C5667e f25455c = new C5667e();

    /* renamed from: d */
    private static final Api<C5667e> f25456d = new Api<>("HuaweiIdentity.API");

    public C5663a(Activity activity) {
        super(activity, f25456d, f25455c, (AbstractClientBuilder) new C5665c(), C5668f.f25479e);
        setApiLevel(1);
    }

    @Override // com.huawei.hms.identity.AddressClient
    public Task<GetUserAddressResult> getUserAddress(UserAddressRequest userAddressRequest) {
        Checker.checkNonNull(userAddressRequest);
        return doWrite(new C5669g(InterfaceC5666d.f25457a, JsonUtil.createJsonString(userAddressRequest), HiAnalyticsClient.reportEntry(getContext(), InterfaceC5666d.f25457a, C5668f.f25479e)));
    }

    public C5663a(Context context) {
        super(context, f25456d, f25455c, new C5665c(), C5668f.f25479e);
        setApiLevel(1);
    }
}
