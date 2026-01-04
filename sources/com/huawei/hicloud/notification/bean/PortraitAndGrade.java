package com.huawei.hicloud.notification.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class PortraitAndGrade implements Serializable {
    private static final long serialVersionUID = 23;
    private GradeRights gradeRights;
    private UserTagList userTagList;

    public static class GradeRights implements Serializable {
        private static final long serialVersionUID = 24;
        private Integer defaultFlag;
        private String gradeCode;

        public Integer getDefaultFlag() {
            return this.defaultFlag;
        }

        public String getGradeCode() {
            return this.gradeCode;
        }

        public void setDefaultFlag(Integer num) {
            this.defaultFlag = num;
        }

        public void setGradeCode(String str) {
            this.gradeCode = str;
        }

        public String toString() {
            return "GradeRights{gradeCode='" + this.gradeCode + "', defaultFlag=" + this.defaultFlag + '}';
        }
    }

    public static class UserTag implements Serializable {
        private static final long serialVersionUID = 26;
        private String userGroupExtID;
        private String userGroupName;

        public String getUserGroupExtID() {
            return this.userGroupExtID;
        }

        public String getUserGroupName() {
            return this.userGroupName;
        }

        public void setUserGroupExtID(String str) {
            this.userGroupExtID = str;
        }

        public void setUserGroupName(String str) {
            this.userGroupName = str;
        }

        public String toString() {
            return "UserTag{userGroupExtID='" + this.userGroupExtID + "', userGroupName='" + this.userGroupName + "'}";
        }
    }

    public static class UserTagList implements Serializable {
        private static final long serialVersionUID = 25;
        private String nextCursor;
        private List<UserTag> userTags;

        public String getNextCursor() {
            return this.nextCursor;
        }

        public List<UserTag> getUserTags() {
            return this.userTags;
        }

        public void setNextCursor(String str) {
            this.nextCursor = str;
        }

        public void setUserTags(List<UserTag> list) {
            this.userTags = list;
        }
    }

    public static class UserTagWithoutName implements Serializable {
        private static final long serialVersionUID = 27;
        private String userGroupExtID;

        public String getUserGroupExtID() {
            return this.userGroupExtID;
        }

        public void setUserGroupExtID(String str) {
            this.userGroupExtID = str;
        }

        public String toString() {
            return "UserTag{userGroupExtID='" + this.userGroupExtID + "'}";
        }
    }

    public GradeRights getGradeRights() {
        return this.gradeRights;
    }

    public UserTagList getUserTagList() {
        return this.userTagList;
    }

    public void setGradeRights(GradeRights gradeRights) {
        this.gradeRights = gradeRights;
    }

    public void setUserTagList(UserTagList userTagList) {
        this.userTagList = userTagList;
    }
}
