package com.huawei.hiar.listener;

import com.huawei.hiar.common.CloudServiceState;
import java.util.EventObject;

/* loaded from: classes5.dex */
public class CloudServiceEvent extends EventObject {
    private static final long serialVersionUID = 3097405229771875942L;
    private CloudServiceState cloudServiceState;

    public CloudServiceEvent(Object obj, CloudServiceState cloudServiceState) {
        super(obj);
        this.cloudServiceState = cloudServiceState;
    }

    public CloudServiceState getCloudServiceState() {
        return this.cloudServiceState;
    }
}
