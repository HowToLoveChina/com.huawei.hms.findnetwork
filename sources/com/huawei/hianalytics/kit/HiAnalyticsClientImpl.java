package com.huawei.hianalytics.kit;

import android.content.Context;
import com.huawei.hianalytics.C4802r0;
import com.huawei.hianalytics.C4804s0;
import com.huawei.hianalytics.C4808u0;
import com.huawei.hianalytics.C4810v0;
import com.huawei.hianalytics.C4812w0;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;

/* loaded from: classes5.dex */
public class HiAnalyticsClientImpl extends HuaweiApi<C4810v0> implements HiAnalyticsClient {
    public static final Api<C4810v0> HI_ANALYTICS_OPTIONS_API = new Api<>("HuaweiHASDK.API");
    public static final C4802r0 CLIENT_BUILDER = new C4802r0();

    public HiAnalyticsClientImpl(Context context, C4810v0 c4810v0) {
        super(context, HI_ANALYTICS_OPTIONS_API, c4810v0, CLIENT_BUILDER);
    }

    @Override // com.huawei.hianalytics.kit.HiAnalyticsClient
    public Task<C4812w0> getAesKey(C4808u0 c4808u0) {
        c4808u0.getClass();
        return doWrite(new HiAnalyticsTaskApiCall("qoes.getKey", "{\"type\" : \"" + c4808u0.f21941a + "\", \"source\" : \"" + c4808u0.f21942b + "\", \"pub_key\" : \"" + c4808u0.f21943c + "\", \"version\" : \"" + c4808u0.f21944d + "\"}"));
    }

    @Override // com.huawei.hianalytics.kit.HiAnalyticsClient
    public Task<C4812w0> getHaConfig(C4804s0 c4804s0) {
        c4804s0.getClass();
        return doWrite(new HiAnalyticsTaskApiCall("qoes.getHaConfig", "{\"type\" : \"" + c4804s0.f21930a + "\", \"source\" : \"" + c4804s0.f21931b + "\"}"));
    }
}
