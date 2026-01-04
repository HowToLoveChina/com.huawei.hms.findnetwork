package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;

/* renamed from: com.huawei.hms.videokit.player.a0 */
/* loaded from: classes8.dex */
public final class C6541a0 extends C6544b0 {

    /* renamed from: b */
    private Context f30300b;

    /* renamed from: c */
    private C6609y f30301c;

    public C6541a0(Context context) {
        super(context);
        this.f30300b = context;
        this.f30301c = C6609y.m37724b();
    }

    /* renamed from: a */
    private void m37194a(OperationData operationData) {
        if (operationData == null) {
            C6550c1.m37265d("ApiDataReporter", "opData is null");
            return;
        }
        if (this.f30301c == null) {
            this.f30301c = C6609y.m37724b();
        }
        C6592p c6592p = new C6592p();
        c6592p.m37590a(WiseOpenHianalyticsData.UNION_COSTTIME, operationData.getCostTime());
        c6592p.m37590a("callTime", operationData.getCallTime());
        c6592p.m37591a("apiName", operationData.getApiName());
        c6592p.m37591a("appid", AGCUtils.getAppId(this.f30300b));
        c6592p.m37590a("result", operationData.getResult());
        String uuid = operationData.getUuid();
        if (C6600t0.m37683c(uuid)) {
            uuid = C6598s0.m37646c(this.f30300b);
        }
        c6592p.m37591a("transId", uuid);
        m37219b(c6592p);
        this.f30301c.m37725a(0, "60000", c6592p);
    }

    /* renamed from: b */
    public void m37195b(OperationData operationData) {
        if (C6609y.m37724b().m37727c()) {
            m37194a(operationData);
        } else {
            C6550c1.m37256a("ApiDataReporter", "VideoPlayer reporting channel is off ");
        }
    }
}
