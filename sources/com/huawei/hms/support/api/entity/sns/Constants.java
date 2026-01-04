package com.huawei.hms.support.api.entity.sns;

/* loaded from: classes8.dex */
public final class Constants {
    public static final int HMS_JSON_VERSION_MIN = 30002300;
    public static final int SNS_SDK_VERSION_CODE = 30003300;

    public static final class AddFriendResult {
        public static final int ADD_FRIEND_ALREAD_FRIEND = 5;
        public static final int ADD_FRIEND_LIMITED = 3;
        public static final int ADD_FRIEND_LIMITED_OTHER = 4;
        public static final int ADD_FRIEND_MUCH_REQ = 2;
        public static final int ADD_FRIEND_SUCCESS = 0;
        public static final int ADD_FRIEND_VERIFY = 1;
    }

    public interface ApiLevelCode {
        public static final int API_LEVEL_FIVE = 5;
        public static final int API_LEVEL_FOUR = 4;
        public static final int API_LEVEL_ONE = 1;
        public static final int API_LEVEL_THREE = 3;
        public static final int API_LEVEL_TWO = 2;
    }

    public interface FamilyIntentType {
        public static final int CREATE_CHILD_ACCOUNT = 3;
        public static final int CREATE_FAMILY_SHARE = 4;
        public static final int INVITE_MEMBER = 1;
        public static final int INVITE_MEMBER_BY_ACCOUNT = 2;
    }

    public static class GroupType {
        public static final int GROUP_ALL = 2;
        public static final int GROUP_COMMON = 1;
        public static final int GROUP_FAMILY = 0;
    }

    public static class Key {
        public static final String KEY_CALL_FRIEND = "hms_sns_call_friend";
        public static final String KEY_CALL_MSG = "hms_sns_call_msg";
        public static final String KEY_GROUP_ID = "hms_sns_group_id";
        public static final String KEY_IDS_LIST = "hms_sns_ids_list";
        public static final String KEY_USER_ID = "hms_sns_user_id";
    }

    public static final class MessageType {
        public static final int LINK = 1;
    }

    public static final class OnlineStatus {
        public static final int OFF_LINE = 0;
        public static final int ON_LINE = 1;
    }

    public static class UiIntentType {
        public static final int UI_ADD_CONTACTS = 10;
        public static final int UI_CHAT_ASSIST = 7;
        public static final int UI_CHAT_FRIEND = 5;
        public static final int UI_CHAT_GROUP = 6;
        public static final int UI_COMMON_GROUP = 9;
        public static final int UI_COMMON_GROUP_DETAIL = 3;
        public static final int UI_FAMILY_GROUP = 8;
        public static final int UI_FAMILY_GROUP_DETAIL = 2;
        public static final int UI_FRIEND = 1;
        public static final int UI_MSG = 0;
        public static final int UI_USER_DETAIL = 4;
    }
}
