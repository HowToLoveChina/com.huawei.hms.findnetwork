package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class UnreadMsg implements IMessageEntity {

    @Packed
    private int familyInvitation;

    @Packed
    private int friendInvitation;

    @Packed
    private int friendMsg;

    @Packed
    private int groupMsg;

    public int getFamilyInvitation() {
        return this.familyInvitation;
    }

    public int getFriendInvitation() {
        return this.friendInvitation;
    }

    public int getFriendMsg() {
        return this.friendMsg;
    }

    public int getGroupMsg() {
        return this.groupMsg;
    }

    public void setFamilyInvitation(int i10) {
        this.familyInvitation = i10;
    }

    public void setFriendInvitation(int i10) {
        this.friendInvitation = i10;
    }

    public void setFriendMsg(int i10) {
        this.friendMsg = i10;
    }

    public void setGroupMsg(int i10) {
        this.groupMsg = i10;
    }
}
