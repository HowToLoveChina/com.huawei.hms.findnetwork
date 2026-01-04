package com.huawei.hms.support.api.sns;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.sns.SnsMsg;

/* loaded from: classes8.dex */
public interface HuaweiSnsApi {
    PendingResult<AddFriendResult> addFriend(HuaweiApiClient huaweiApiClient, long j10, String str);

    PendingResult<FriendListResult> getFriendList(HuaweiApiClient huaweiApiClient);

    PendingResult<IntentResult> getFriendSelectorIntent(HuaweiApiClient huaweiApiClient, boolean z10);

    PendingResult<IntentResult> getGroupCreatorIntent(HuaweiApiClient huaweiApiClient);

    PendingResult<GroupListResult> getGroupList(HuaweiApiClient huaweiApiClient, int i10);

    PendingResult<GroupMemListResult> getGroupMemList(HuaweiApiClient huaweiApiClient, long j10);

    PendingResult<IntentResult> getGroupSelectorIntent(HuaweiApiClient huaweiApiClient, int i10);

    PendingResult<IMStatusResult> getIMStatus(HuaweiApiClient huaweiApiClient);

    PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient huaweiApiClient, SnsMsg snsMsg, int i10, boolean z10);

    PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient huaweiApiClient, SnsMsg snsMsg, boolean z10);

    PendingResult<IntentResult> getUiIntent(HuaweiApiClient huaweiApiClient, int i10, long j10);

    PendingResult<UnreadMsgCountResult> getUnreadMsgCount(HuaweiApiClient huaweiApiClient);

    PendingResult<UserUnreadMsgCountResult> getUserCount(HuaweiApiClient huaweiApiClient, long j10);

    PendingResult<UserDataResult> getUserData(HuaweiApiClient huaweiApiClient, long j10);

    PendingResult<UserSearchResult> searchUser(HuaweiApiClient huaweiApiClient, String str);
}
