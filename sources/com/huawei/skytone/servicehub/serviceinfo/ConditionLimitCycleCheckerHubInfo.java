package com.huawei.skytone.servicehub.serviceinfo;

import com.huawei.android.hicloud.cloudbackup.process.util.ConditionLimitCycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.skytone.servicehub.model.schema.C8689a;
import com.huawei.skytone.servicehub.model.schema.C8690b;

/* loaded from: classes5.dex */
public class ConditionLimitCycleCheckerHubInfo extends C8690b {
    public ConditionLimitCycleCheckerHubInfo() {
        this.group = ICycleChecker.class;
        this.impl = ConditionLimitCycleChecker.class;
        this.isSingleton = false;
        this.creator = C8689a.class;
    }
}
