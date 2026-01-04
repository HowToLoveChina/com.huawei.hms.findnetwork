package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* loaded from: classes8.dex */
public class GetFamilyGroupMemberResp implements IMessageEntity {

    @Packed
    private List<GroupMember> groupMemList;

    public static class GroupMember implements IMessageEntity {

        @Packed
        Integer age;

        @Packed
        String imageURL;

        @Packed
        String joinTime;

        @Packed
        String nickName;

        @Packed
        Integer role;

        @Packed
        String userID;

        public Integer getAge() {
            return this.age;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public String getJoinTime() {
            return this.joinTime;
        }

        public String getNickName() {
            return this.nickName;
        }

        public Integer getRole() {
            return this.role;
        }

        public String getUserID() {
            return this.userID;
        }

        public void setAge(Integer num) {
            this.age = num;
        }

        public void setImageURL(String str) {
            this.imageURL = str;
        }

        public void setJoinTime(String str) {
            this.joinTime = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setRole(Integer num) {
            this.role = num;
        }

        public void setUserID(String str) {
            this.userID = str;
        }
    }

    public List<GroupMember> getGroupMemList() {
        return this.groupMemList;
    }

    public void setGroupMemList(List<GroupMember> list) {
        this.groupMemList = list;
    }
}
