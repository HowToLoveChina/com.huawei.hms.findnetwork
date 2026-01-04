package com.huawei.skytone.servicehub.serviceinfo;

import com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify;
import com.huawei.android.hicloud.cloudbackup.process.SpaceNotEnoughNotifyOlder;
import com.huawei.skytone.servicehub.model.schema.C8689a;
import com.huawei.skytone.servicehub.model.schema.C8690b;

/* loaded from: classes5.dex */
public class SpaceNotEnoughNotifyOlderHubInfo extends C8690b {
    public SpaceNotEnoughNotifyOlderHubInfo() {
        this.group = IBackupNotEnoughNotify.class;
        this.impl = SpaceNotEnoughNotifyOlder.class;
        this.isSingleton = false;
        this.creator = C8689a.class;
    }
}
