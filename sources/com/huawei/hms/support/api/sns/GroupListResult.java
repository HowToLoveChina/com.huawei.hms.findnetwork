package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.Group;
import java.util.List;

/* loaded from: classes8.dex */
public class GroupListResult extends Result {
    private List<Group> groups;

    public List<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(List<Group> list) {
        this.groups = list;
    }
}
