package com.huawei.hms.support.api.sns.json;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.api.entity.sns.UnreadMsg;
import com.huawei.hms.support.api.entity.sns.UserUnreadMsg;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendReq;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendResp;
import com.huawei.hms.support.api.entity.sns.internal.FollowPublicUserReq;
import com.huawei.hms.support.api.entity.sns.internal.FollowPublicUserResp;
import com.huawei.hms.support.api.entity.sns.internal.FriendSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.GetFriendListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupMemListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetIMStatusResp;
import com.huawei.hms.support.api.entity.sns.internal.GroupListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupMemListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.SnsSendMsgIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UiIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataResp;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchReq;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchResp;
import com.huawei.hms.support.api.entity.sns.internal.UserUnreadMsgReq;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;

/* loaded from: classes8.dex */
public interface SnsClient {

    public interface Callback {
        void notify(String str);
    }

    Task<AddFriendResp> addFriend(AddFriendReq addFriendReq, Callback callback);

    Task<FollowPublicUserResp> followPublicUser(FollowPublicUserReq followPublicUserReq, Callback callback);

    Task<GetFriendListResp> getFriendList(Callback callback);

    Task<SnsOutIntent> getFriendSelectorIntent(FriendSelectorIntentReq friendSelectorIntentReq, Callback callback);

    Task<SnsOutIntent> getGroupCreatorIntent(Callback callback);

    Task<GetGroupListResp> getGroupList(GroupListReq groupListReq, Callback callback);

    Task<GetGroupMemListResp> getGroupMemList(GroupMemListReq groupMemListReq, Callback callback);

    Task<SnsOutIntent> getGroupSelectorIntent(GroupSelectorIntentReq groupSelectorIntentReq, Callback callback);

    Task<GetIMStatusResp> getIMStatus(Callback callback);

    Task<SnsOutIntent> getUiIntent(UiIntentReq uiIntentReq, Callback callback);

    Task<UnreadMsg> getUnreadMsgCount(Callback callback);

    Task<UserUnreadMsg> getUserCount(UserUnreadMsgReq userUnreadMsgReq, Callback callback);

    Task<UserDataResp> getUserData(UserDataReq userDataReq, Callback callback);

    Task<UserSearchResp> searchUser(UserSearchReq userSearchReq, Callback callback);

    Task<SnsOutIntent> sendMsgIntent(SnsSendMsgIntentReq snsSendMsgIntentReq, Callback callback);
}
