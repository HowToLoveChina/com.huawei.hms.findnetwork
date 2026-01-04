package com.huawei.skytone.servicehub.serviceinfo;

import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.RefurbishmentCycleChecker;
import com.huawei.skytone.servicehub.model.schema.C8689a;
import com.huawei.skytone.servicehub.model.schema.C8690b;

/* loaded from: classes5.dex */
public class RefurbishmentCycleCheckerHubInfo extends C8690b {
    public RefurbishmentCycleCheckerHubInfo() {
        this.group = ICycleChecker.class;
        this.impl = RefurbishmentCycleChecker.class;
        this.isSingleton = false;
        this.creator = C8689a.class;
    }
}
