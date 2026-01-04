package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.Group;
import java.util.List;

/* loaded from: classes8.dex */
public class GetGroupListResp implements IMessageEntity {

    @Packed
    private List<Group> groups;

    public List<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(List<Group> list) {
        this.groups = list;
    }
}
