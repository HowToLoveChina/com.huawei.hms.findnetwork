package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.GroupMem;
import java.util.List;

/* loaded from: classes8.dex */
public class GetGroupMemListResp implements IMessageEntity {

    @Packed
    private List<GroupMem> groupMemList;

    public List<GroupMem> getGroupMemList() {
        return this.groupMemList;
    }

    public void setGroupMemList(List<GroupMem> list) {
        this.groupMemList = list;
    }
}
