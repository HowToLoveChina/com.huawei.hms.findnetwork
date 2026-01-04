package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.GroupMem;
import java.util.List;

/* loaded from: classes8.dex */
public class GroupMemListResult extends Result {
    private List<GroupMem> groupMems;

    public List<GroupMem> getGroupMems() {
        return this.groupMems;
    }

    public void setGroupMems(List<GroupMem> list) {
        this.groupMems = list;
    }
}
