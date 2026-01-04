package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.Friend;
import java.util.List;

/* loaded from: classes8.dex */
public class FriendListResult extends Result {
    private List<Friend> friends;

    public List<Friend> getFriends() {
        return this.friends;
    }

    public void setFriends(List<Friend> list) {
        this.friends = list;
    }
}
