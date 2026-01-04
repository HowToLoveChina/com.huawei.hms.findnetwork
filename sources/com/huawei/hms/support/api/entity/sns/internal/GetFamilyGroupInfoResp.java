package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class GetFamilyGroupInfoResp implements IMessageEntity {

    @Packed
    private String createTime;

    @Packed
    private String groupID;

    @Packed
    private String managerID;

    @Packed
    private Integer memberNum;

    public String getCreateTime() {
        return this.createTime;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getManagerID() {
        return this.managerID;
    }

    public Integer getMemberNum() {
        return this.memberNum;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setManagerID(String str) {
        this.managerID = str;
    }

    public void setMemberNum(Integer num) {
        this.memberNum = num;
    }
}
