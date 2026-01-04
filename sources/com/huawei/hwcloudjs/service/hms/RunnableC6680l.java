package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hwcloudjs.service.hms.C6679k;

/* renamed from: com.huawei.hwcloudjs.service.hms.l */
/* loaded from: classes8.dex */
public class RunnableC6680l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HuaweiApiAvailability f30988a;

    /* renamed from: b */
    final /* synthetic */ int f30989b;

    /* renamed from: c */
    final /* synthetic */ C6679k.b f30990c;

    public RunnableC6680l(C6679k.b bVar, HuaweiApiAvailability huaweiApiAvailability, int i10) {
        this.f30990c = bVar;
        this.f30988a = huaweiApiAvailability;
        this.f30989b = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity = (Activity) this.f30990c.f30977c.get();
        if (activity != null) {
            this.f30988a.resolveError(activity, this.f30989b, ConnectionResult.SERVICE_UPDATING);
        }
    }
}
