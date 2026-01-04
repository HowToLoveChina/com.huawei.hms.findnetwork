package com.huawei.hianalytics.kit;

import com.huawei.hianalytics.C4804s0;
import com.huawei.hianalytics.C4808u0;
import com.huawei.hianalytics.C4812w0;
import com.huawei.hmf.tasks.Task;

/* loaded from: classes5.dex */
public interface HiAnalyticsClient {
    Task<C4812w0> getAesKey(C4808u0 c4808u0);

    Task<C4812w0> getHaConfig(C4804s0 c4804s0);
}
