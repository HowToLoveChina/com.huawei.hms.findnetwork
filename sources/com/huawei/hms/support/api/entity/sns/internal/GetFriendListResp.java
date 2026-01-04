package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.Friend;
import java.util.List;

/* loaded from: classes8.dex */
public class GetFriendListResp implements IMessageEntity {

    @Packed
    private List<Friend> friends;

    public List<Friend> getFriends() {
        return this.friends;
    }

    public void setFriends(List<Friend> list) {
        this.friends = list;
    }
}
