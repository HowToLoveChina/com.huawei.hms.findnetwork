package com.huawei.skytone.servicehub.serviceinfo;

import com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify;
import com.huawei.android.hicloud.cloudbackup.process.SpaceNotEnoughNotifyV5;
import com.huawei.skytone.servicehub.model.schema.C8689a;
import com.huawei.skytone.servicehub.model.schema.C8690b;

/* loaded from: classes5.dex */
public class SpaceNotEnoughNotifyV5HubInfo extends C8690b {
    public SpaceNotEnoughNotifyV5HubInfo() {
        this.group = IBackupNotEnoughNotify.class;
        this.impl = SpaceNotEnoughNotifyV5.class;
        this.isSingleton = false;
        this.creator = C8689a.class;
    }
}
