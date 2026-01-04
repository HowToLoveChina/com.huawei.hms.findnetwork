package com.huawei.hms.support.api.sns;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.SnsMsg;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendReq;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendResp;
import com.huawei.hms.support.api.entity.sns.internal.FriendSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.GetFriendListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupMemListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetIMStatusResp;
import com.huawei.hms.support.api.entity.sns.internal.GetUnreadMsgResp;
import com.huawei.hms.support.api.entity.sns.internal.GetUserUnreadMsgResp;
import com.huawei.hms.support.api.entity.sns.internal.GroupListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupMemListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.SNSIntentResp;
import com.huawei.hms.support.api.entity.sns.internal.SNSVoidEntity;
import com.huawei.hms.support.api.entity.sns.internal.SnsNaming;
import com.huawei.hms.support.api.entity.sns.internal.SnsSendMsgIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UiIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataResp;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchReq;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchResp;
import com.huawei.hms.support.api.entity.sns.internal.UserUnreadMsgReq;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class HuaweiSnsApiImpl implements HuaweiSnsApi {

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$a */
    public class C6386a extends PendingResultImpl<IntentResult, SNSIntentResp> {
        public C6386a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentResult onComplete(SNSIntentResp sNSIntentResp) {
            IntentResult intentResult = new IntentResult();
            intentResult.setStatus(Status.SUCCESS);
            intentResult.setIntent(sNSIntentResp.getIntent());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getUiIntent onComplete");
            return intentResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$b */
    public class C6387b extends PendingResultImpl<IntentResult, SNSIntentResp> {
        public C6387b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentResult onComplete(SNSIntentResp sNSIntentResp) {
            IntentResult intentResult = new IntentResult();
            intentResult.setStatus(Status.SUCCESS);
            intentResult.setIntent(sNSIntentResp.getIntent());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getMsgSendIntent onComplete");
            return intentResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$c */
    public class C6388c extends PendingResultImpl<AddFriendResult, AddFriendResp> {
        public C6388c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AddFriendResult onComplete(AddFriendResp addFriendResp) {
            AddFriendResult addFriendResult = new AddFriendResult();
            addFriendResult.setStatus(Status.SUCCESS);
            addFriendResult.setResult(addFriendResp.getResult());
            HMSLog.m36988i("HuaweiSnsApiImpl", "addFriend onComplete");
            return addFriendResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$d */
    public class C6389d extends PendingResultImpl<UserSearchResult, UserSearchResp> {
        public C6389d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserSearchResult onComplete(UserSearchResp userSearchResp) {
            UserSearchResult userSearchResult = new UserSearchResult();
            userSearchResult.setStatus(Status.SUCCESS);
            userSearchResult.setUserId(userSearchResp.getUserId());
            HMSLog.m36988i("HuaweiSnsApiImpl", "searchUser onComplete");
            return userSearchResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$e */
    public class C6390e extends PendingResultImpl<IMStatusResult, GetIMStatusResp> {
        public C6390e(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IMStatusResult onComplete(GetIMStatusResp getIMStatusResp) {
            IMStatusResult iMStatusResult = new IMStatusResult();
            iMStatusResult.setStatus(Status.SUCCESS);
            iMStatusResult.setImStatus(getIMStatusResp.getOnlineStatus());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getIMStatus onComplete");
            return iMStatusResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$f */
    public class C6391f extends PendingResultImpl<FriendListResult, GetFriendListResp> {
        public C6391f(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FriendListResult onComplete(GetFriendListResp getFriendListResp) {
            FriendListResult friendListResult = new FriendListResult();
            friendListResult.setStatus(Status.SUCCESS);
            friendListResult.setFriends(getFriendListResp.getFriends());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getFriendList onComplete");
            return friendListResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$g */
    public class C6392g extends PendingResultImpl<GroupListResult, GetGroupListResp> {
        public C6392g(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupListResult onComplete(GetGroupListResp getGroupListResp) {
            GroupListResult groupListResult = new GroupListResult();
            groupListResult.setStatus(Status.SUCCESS);
            groupListResult.setGroups(getGroupListResp.getGroups());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getGroupList onComplete");
            return groupListResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$h */
    public class C6393h extends PendingResultImpl<GroupMemListResult, GetGroupMemListResp> {
        public C6393h(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupMemListResult onComplete(GetGroupMemListResp getGroupMemListResp) {
            GroupMemListResult groupMemListResult = new GroupMemListResult();
            groupMemListResult.setStatus(Status.SUCCESS);
            groupMemListResult.setGroupMems(getGroupMemListResp.getGroupMemList());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getGroupList onComplete");
            return groupMemListResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$i */
    public class C6394i extends PendingResultImpl<UserDataResult, UserDataResp> {
        public C6394i(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserDataResult onComplete(UserDataResp userDataResp) {
            UserDataResult userDataResult = new UserDataResult();
            userDataResult.setStatus(Status.SUCCESS);
            userDataResult.setUserData(userDataResp.getUserData());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getUserData onComplete");
            return userDataResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$j */
    public class C6395j extends PendingResultImpl<UnreadMsgCountResult, GetUnreadMsgResp> {
        public C6395j(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnreadMsgCountResult onComplete(GetUnreadMsgResp getUnreadMsgResp) {
            UnreadMsgCountResult unreadMsgCountResult = new UnreadMsgCountResult();
            unreadMsgCountResult.setStatus(Status.SUCCESS);
            unreadMsgCountResult.setUnreadMsg(getUnreadMsgResp.getUnreadMsg());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getUnreadMsgCount onCompete");
            return unreadMsgCountResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$k */
    public class C6396k extends PendingResultImpl<UserUnreadMsgCountResult, GetUserUnreadMsgResp> {
        public C6396k(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserUnreadMsgCountResult onComplete(GetUserUnreadMsgResp getUserUnreadMsgResp) {
            UserUnreadMsgCountResult userUnreadMsgCountResult = new UserUnreadMsgCountResult();
            userUnreadMsgCountResult.setStatus(Status.SUCCESS);
            userUnreadMsgCountResult.setCount(getUserUnreadMsgResp.getUserUnreadMsg().getFriendMsg());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getUserCount onComplete");
            return userUnreadMsgCountResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$l */
    public class C6397l extends PendingResultImpl<IntentResult, SNSIntentResp> {
        public C6397l(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentResult onComplete(SNSIntentResp sNSIntentResp) {
            IntentResult intentResult = new IntentResult();
            intentResult.setStatus(Status.SUCCESS);
            intentResult.setIntent(sNSIntentResp.getIntent());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getFriendSelectorIntent onComplete");
            return intentResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$m */
    public class C6398m extends PendingResultImpl<IntentResult, SNSIntentResp> {
        public C6398m(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentResult onComplete(SNSIntentResp sNSIntentResp) {
            IntentResult intentResult = new IntentResult();
            intentResult.setStatus(Status.SUCCESS);
            intentResult.setIntent(sNSIntentResp.getIntent());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getGroupSelectorIntent onComplete");
            return intentResult;
        }
    }

    /* renamed from: com.huawei.hms.support.api.sns.HuaweiSnsApiImpl$n */
    public class C6399n extends PendingResultImpl<IntentResult, SNSIntentResp> {
        public C6399n(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentResult onComplete(SNSIntentResp sNSIntentResp) {
            IntentResult intentResult = new IntentResult();
            intentResult.setStatus(Status.SUCCESS);
            intentResult.setIntent(sNSIntentResp.getIntent());
            HMSLog.m36988i("HuaweiSnsApiImpl", "getGroupCreatorIntent onComplete");
            return intentResult;
        }
    }

    /* renamed from: a */
    private static PendingResultImpl<FriendListResult, GetFriendListResp> m36771a(HuaweiApiClient huaweiApiClient) {
        return new C6391f(huaweiApiClient, SnsNaming.GET_FRIEND_LIST, new SNSVoidEntity());
    }

    /* renamed from: b */
    private static PendingResultImpl<UnreadMsgCountResult, GetUnreadMsgResp> m36784b(HuaweiApiClient huaweiApiClient, SNSVoidEntity sNSVoidEntity) {
        return new C6395j(huaweiApiClient, SnsNaming.GET_UNREAD_MSG_COUNT, sNSVoidEntity);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<AddFriendResult> addFriend(HuaweiApiClient huaweiApiClient, long j10, String str) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter addFriend");
        AddFriendReq addFriendReq = new AddFriendReq();
        addFriendReq.setUserId(j10);
        addFriendReq.setRemark(str);
        return m36772a(huaweiApiClient, addFriendReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<FriendListResult> getFriendList(HuaweiApiClient huaweiApiClient) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getFriendList");
        return m36771a(huaweiApiClient);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IntentResult> getFriendSelectorIntent(HuaweiApiClient huaweiApiClient, boolean z10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getFriendSelectorIntent");
        FriendSelectorIntentReq friendSelectorIntentReq = new FriendSelectorIntentReq();
        friendSelectorIntentReq.setSingleChoice(z10);
        return m36773a(huaweiApiClient, friendSelectorIntentReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IntentResult> getGroupCreatorIntent(HuaweiApiClient huaweiApiClient) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getGroupCreatorIntent");
        return m36777a(huaweiApiClient, new SNSVoidEntity());
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<GroupListResult> getGroupList(HuaweiApiClient huaweiApiClient, int i10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getGroupList");
        GroupListReq groupListReq = new GroupListReq();
        groupListReq.setGroupType(i10);
        return m36774a(huaweiApiClient, groupListReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<GroupMemListResult> getGroupMemList(HuaweiApiClient huaweiApiClient, long j10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getGroupList");
        GroupMemListReq groupMemListReq = new GroupMemListReq();
        groupMemListReq.setGroupId(j10);
        return m36775a(huaweiApiClient, groupMemListReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IntentResult> getGroupSelectorIntent(HuaweiApiClient huaweiApiClient, int i10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getGroupSelectorIntent");
        GroupSelectorIntentReq groupSelectorIntentReq = new GroupSelectorIntentReq();
        groupSelectorIntentReq.setGroupType(i10);
        return m36776a(huaweiApiClient, groupSelectorIntentReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IMStatusResult> getIMStatus(HuaweiApiClient huaweiApiClient) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getIMStatus");
        return m36783b(huaweiApiClient);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient huaweiApiClient, SnsMsg snsMsg, boolean z10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getMsgSendIntent1");
        SnsSendMsgIntentReq snsSendMsgIntentReq = new SnsSendMsgIntentReq();
        snsSendMsgIntentReq.setSnsMsg(snsMsg);
        snsSendMsgIntentReq.setCallerPackageName(huaweiApiClient.getPackageName());
        snsSendMsgIntentReq.setNeedResult(z10);
        return m36778a(huaweiApiClient, snsSendMsgIntentReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IntentResult> getUiIntent(HuaweiApiClient huaweiApiClient, int i10, long j10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getUiIntent type:" + i10);
        UiIntentReq uiIntentReq = new UiIntentReq();
        uiIntentReq.setType(i10);
        uiIntentReq.setParam(j10);
        return m36779a(huaweiApiClient, uiIntentReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<UnreadMsgCountResult> getUnreadMsgCount(HuaweiApiClient huaweiApiClient) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getUnreadMsgCount");
        return m36784b(huaweiApiClient, new SNSVoidEntity());
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<UserUnreadMsgCountResult> getUserCount(HuaweiApiClient huaweiApiClient, long j10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getUserCount");
        UserUnreadMsgReq userUnreadMsgReq = new UserUnreadMsgReq();
        userUnreadMsgReq.setUserId(j10);
        return m36782a(huaweiApiClient, userUnreadMsgReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<UserDataResult> getUserData(HuaweiApiClient huaweiApiClient, long j10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getUserData");
        UserDataReq userDataReq = new UserDataReq();
        userDataReq.setUserId(j10);
        return m36780a(huaweiApiClient, userDataReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<UserSearchResult> searchUser(HuaweiApiClient huaweiApiClient, String str) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter searchUser");
        UserSearchReq userSearchReq = new UserSearchReq();
        userSearchReq.setAccount(str);
        return m36781a(huaweiApiClient, userSearchReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<GroupListResult, GetGroupListResp> m36774a(HuaweiApiClient huaweiApiClient, GroupListReq groupListReq) {
        return new C6392g(huaweiApiClient, SnsNaming.GET_GROUP_LIST, groupListReq);
    }

    /* renamed from: b */
    private static PendingResultImpl<IMStatusResult, GetIMStatusResp> m36783b(HuaweiApiClient huaweiApiClient) {
        return new C6390e(huaweiApiClient, SnsNaming.GET_IM_STATUS, new SNSVoidEntity());
    }

    /* renamed from: a */
    private static PendingResultImpl<GroupMemListResult, GetGroupMemListResp> m36775a(HuaweiApiClient huaweiApiClient, GroupMemListReq groupMemListReq) {
        return new C6393h(huaweiApiClient, SnsNaming.GET_GROUP_MEM_LIST, groupMemListReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<UserDataResult, UserDataResp> m36780a(HuaweiApiClient huaweiApiClient, UserDataReq userDataReq) {
        return new C6394i(huaweiApiClient, SnsNaming.GET_USER_DATA, userDataReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<UserUnreadMsgCountResult, GetUserUnreadMsgResp> m36782a(HuaweiApiClient huaweiApiClient, UserUnreadMsgReq userUnreadMsgReq) {
        return new C6396k(huaweiApiClient, SnsNaming.GET_USER_COUNT, userUnreadMsgReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<IntentResult, SNSIntentResp> m36773a(HuaweiApiClient huaweiApiClient, FriendSelectorIntentReq friendSelectorIntentReq) {
        return new C6397l(huaweiApiClient, SnsNaming.GET_FRIEND_SELECTOR_INTENT, friendSelectorIntentReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<IntentResult, SNSIntentResp> m36776a(HuaweiApiClient huaweiApiClient, GroupSelectorIntentReq groupSelectorIntentReq) {
        return new C6398m(huaweiApiClient, SnsNaming.GET_GROUP_SELECTOR_INTENT, groupSelectorIntentReq);
    }

    @Override // com.huawei.hms.support.api.sns.HuaweiSnsApi
    public PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient huaweiApiClient, SnsMsg snsMsg, int i10, boolean z10) {
        HMSLog.m36988i("HuaweiSnsApiImpl", "Enter getMsgSendIntent2");
        return getMsgSendIntent(huaweiApiClient, snsMsg, z10);
    }

    /* renamed from: a */
    private static PendingResultImpl<IntentResult, SNSIntentResp> m36777a(HuaweiApiClient huaweiApiClient, SNSVoidEntity sNSVoidEntity) {
        return new C6399n(huaweiApiClient, SnsNaming.GET_GROUP_CREATOR_INTENT, sNSVoidEntity);
    }

    /* renamed from: a */
    private static PendingResultImpl<IntentResult, SNSIntentResp> m36779a(HuaweiApiClient huaweiApiClient, UiIntentReq uiIntentReq) {
        return new C6386a(huaweiApiClient, SnsNaming.GET_UI_INTENT, uiIntentReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<IntentResult, SNSIntentResp> m36778a(HuaweiApiClient huaweiApiClient, SnsSendMsgIntentReq snsSendMsgIntentReq) {
        return new C6387b(huaweiApiClient, SnsNaming.GET_MSG_SEND_INTENT, snsSendMsgIntentReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<AddFriendResult, AddFriendResp> m36772a(HuaweiApiClient huaweiApiClient, AddFriendReq addFriendReq) {
        return new C6388c(huaweiApiClient, SnsNaming.ADD_FRIEND, addFriendReq);
    }

    /* renamed from: a */
    private static PendingResultImpl<UserSearchResult, UserSearchResp> m36781a(HuaweiApiClient huaweiApiClient, UserSearchReq userSearchReq) {
        return new C6389d(huaweiApiClient, SnsNaming.SEARCH_USER, userSearchReq);
    }
}
