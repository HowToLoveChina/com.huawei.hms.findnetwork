package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import com.huawei.cloud.pay.model.reward.GetRewardsResp;
import java.util.function.Consumer;

/* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.i0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3679i0 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ PackageExperienceFragment f17550a;

    public /* synthetic */ C3679i0(PackageExperienceFragment packageExperienceFragment) {
        this.f17550a = packageExperienceFragment;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f17550a.m23636P((GetRewardsResp) obj);
    }
}
