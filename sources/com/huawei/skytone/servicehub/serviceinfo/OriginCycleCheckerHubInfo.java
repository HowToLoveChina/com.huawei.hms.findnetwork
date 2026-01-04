package com.huawei.skytone.servicehub.serviceinfo;

import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker;
import com.huawei.skytone.servicehub.model.schema.C8689a;
import com.huawei.skytone.servicehub.model.schema.C8690b;

/* loaded from: classes5.dex */
public class OriginCycleCheckerHubInfo extends C8690b {
    public OriginCycleCheckerHubInfo() {
        this.group = ICycleChecker.class;
        this.impl = OriginCycleChecker.class;
        this.isSingleton = false;
        this.creator = C8689a.class;
    }
}
