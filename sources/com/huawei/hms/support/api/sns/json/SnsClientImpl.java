package com.huawei.hms.support.api.sns.json;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.entity.sns.Constants;
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
import com.huawei.hms.support.api.entity.sns.internal.SnsNaming;
import com.huawei.hms.support.api.entity.sns.internal.SnsSendMsgIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UiIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataResp;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchReq;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchResp;
import com.huawei.hms.support.api.entity.sns.internal.UserUnreadMsgReq;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import p000a.C0000a;

/* loaded from: classes8.dex */
public class SnsClientImpl extends HuaweiApi<SnsOptions> implements SnsClient {

    /* renamed from: a */
    private static final SnsClientBuilder f29921a = new SnsClientBuilder();

    /* renamed from: b */
    private static final SnsOptions f29922b = new SnsOptions();

    /* renamed from: c */
    private static final Api<SnsOptions> f29923c = new Api<>(HuaweiApiAvailability.HMS_API_NAME_SNS);

    public SnsClientImpl(Activity activity, SnsOptions snsOptions) {
        super(activity, f29923c, snsOptions, (AbstractClientBuilder) f29921a);
    }

    /* renamed from: a */
    private void m36801a(TaskApiCall taskApiCall, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        taskApiCall.setTransactionId(str);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<AddFriendResp> addFriend(AddFriendReq addFriendReq, SnsClient.Callback callback) {
        Checker.checkNonNull(addFriendReq);
        String strM36800a = m36800a(SnsNaming.ADD_FRIEND);
        SnsAddFriendApiCall snsAddFriendApiCall = new SnsAddFriendApiCall(SnsNaming.ADD_FRIEND, addFriendReq.toJsonString(), callback, this);
        m36801a(snsAddFriendApiCall, strM36800a);
        return doWrite(snsAddFriendApiCall);
    }

    public void biReportExit(String str, String str2, int i10, int i11) {
        if (C0000a.m0a(getContext())) {
            HMSLog.m36988i("SnsClientImpl", "HiAnalyticsClient_report_Exit");
            HiAnalyticsClient.reportExit(getContext(), str, str2, i10, i11);
        }
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<FollowPublicUserResp> followPublicUser(FollowPublicUserReq followPublicUserReq, SnsClient.Callback callback) {
        Checker.checkNonNull(followPublicUserReq);
        String strM36800a = m36800a(SnsNaming.FOLLOW_PUBLIC_USER);
        SnsFollowPublicUserApiCall snsFollowPublicUserApiCall = new SnsFollowPublicUserApiCall(SnsNaming.FOLLOW_PUBLIC_USER, followPublicUserReq.toJsonString(), callback, this);
        m36801a(snsFollowPublicUserApiCall, strM36800a);
        return doWrite(snsFollowPublicUserApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<GetFriendListResp> getFriendList(SnsClient.Callback callback) {
        String strM36800a = m36800a(SnsNaming.GET_FRIEND_LIST);
        SnsGetFriendListTaskApiCall snsGetFriendListTaskApiCall = new SnsGetFriendListTaskApiCall(SnsNaming.GET_FRIEND_LIST, "", callback, this);
        m36801a(snsGetFriendListTaskApiCall, strM36800a);
        return doWrite(snsGetFriendListTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<SnsOutIntent> getFriendSelectorIntent(FriendSelectorIntentReq friendSelectorIntentReq, SnsClient.Callback callback) {
        Checker.checkNonNull(friendSelectorIntentReq);
        String strM36800a = m36800a(SnsNaming.GET_FRIEND_SELECTOR_INTENT);
        SnsTaskApiCall snsTaskApiCall = new SnsTaskApiCall(SnsNaming.GET_FRIEND_SELECTOR_INTENT, friendSelectorIntentReq.toJsonString(), callback, this);
        m36801a(snsTaskApiCall, strM36800a);
        return doWrite(snsTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<SnsOutIntent> getGroupCreatorIntent(SnsClient.Callback callback) {
        String strM36800a = m36800a(SnsNaming.GET_GROUP_CREATOR_INTENT);
        SnsTaskApiCall snsTaskApiCall = new SnsTaskApiCall(SnsNaming.GET_GROUP_CREATOR_INTENT, "", callback, this);
        m36801a(snsTaskApiCall, strM36800a);
        return doWrite(snsTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<GetGroupListResp> getGroupList(GroupListReq groupListReq, SnsClient.Callback callback) {
        Checker.checkNonNull(groupListReq);
        String strM36800a = m36800a(SnsNaming.GET_GROUP_LIST);
        SnsGetGroupListTaskApiCall snsGetGroupListTaskApiCall = new SnsGetGroupListTaskApiCall(SnsNaming.GET_GROUP_LIST, groupListReq.toJsonString(), callback, this);
        m36801a(snsGetGroupListTaskApiCall, strM36800a);
        return doWrite(snsGetGroupListTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<GetGroupMemListResp> getGroupMemList(GroupMemListReq groupMemListReq, SnsClient.Callback callback) {
        Checker.checkNonNull(groupMemListReq);
        String strM36800a = m36800a(SnsNaming.GET_GROUP_MEM_LIST);
        SnsGetGroupMemListTaskApiCall snsGetGroupMemListTaskApiCall = new SnsGetGroupMemListTaskApiCall(SnsNaming.GET_GROUP_MEM_LIST, groupMemListReq.toJsonString(), callback, this);
        m36801a(snsGetGroupMemListTaskApiCall, strM36800a);
        return doWrite(snsGetGroupMemListTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<SnsOutIntent> getGroupSelectorIntent(GroupSelectorIntentReq groupSelectorIntentReq, SnsClient.Callback callback) {
        Checker.checkNonNull(groupSelectorIntentReq);
        String strM36800a = m36800a(SnsNaming.GET_GROUP_SELECTOR_INTENT);
        SnsTaskApiCall snsTaskApiCall = new SnsTaskApiCall(SnsNaming.GET_GROUP_SELECTOR_INTENT, groupSelectorIntentReq.toJsonString(), callback, this);
        m36801a(snsTaskApiCall, strM36800a);
        return doWrite(snsTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<GetIMStatusResp> getIMStatus(SnsClient.Callback callback) {
        String strM36800a = m36800a(SnsNaming.GET_IM_STATUS);
        SnsImStateApiCall snsImStateApiCall = new SnsImStateApiCall(SnsNaming.GET_IM_STATUS, "", callback, this);
        m36801a(snsImStateApiCall, strM36800a);
        return doWrite(snsImStateApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<SnsOutIntent> getUiIntent(UiIntentReq uiIntentReq, SnsClient.Callback callback) {
        Checker.checkNonNull(uiIntentReq);
        String strM36800a = m36800a(SnsNaming.GET_UI_INTENT);
        SnsTaskApiCall snsTaskApiCall = new SnsTaskApiCall(SnsNaming.GET_UI_INTENT, uiIntentReq.toJsonString(), callback, this);
        m36801a(snsTaskApiCall, strM36800a);
        return doWrite(snsTaskApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<UnreadMsg> getUnreadMsgCount(SnsClient.Callback callback) {
        String strM36800a = m36800a(SnsNaming.GET_UNREAD_MSG_COUNT);
        SnsGetUnReadCountApiCall snsGetUnReadCountApiCall = new SnsGetUnReadCountApiCall(SnsNaming.GET_UNREAD_MSG_COUNT, "", callback, this);
        m36801a(snsGetUnReadCountApiCall, strM36800a);
        return doWrite(snsGetUnReadCountApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<UserUnreadMsg> getUserCount(UserUnreadMsgReq userUnreadMsgReq, SnsClient.Callback callback) {
        Checker.checkNonNull(userUnreadMsgReq);
        String strM36800a = m36800a(SnsNaming.GET_USER_COUNT);
        SnsGetUserCountApiCall snsGetUserCountApiCall = new SnsGetUserCountApiCall(SnsNaming.GET_USER_COUNT, userUnreadMsgReq.toJsonString(), callback, this);
        m36801a(snsGetUserCountApiCall, strM36800a);
        return doWrite(snsGetUserCountApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<UserDataResp> getUserData(UserDataReq userDataReq, SnsClient.Callback callback) {
        Checker.checkNonNull(userDataReq);
        String strM36800a = m36800a(SnsNaming.GET_USER_DATA);
        SnsGetUserDataApiCall snsGetUserDataApiCall = new SnsGetUserDataApiCall(SnsNaming.GET_USER_DATA, userDataReq.toJsonString(), callback, this);
        m36801a(snsGetUserDataApiCall, strM36800a);
        return doWrite(snsGetUserDataApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<UserSearchResp> searchUser(UserSearchReq userSearchReq, SnsClient.Callback callback) {
        Checker.checkNonNull(userSearchReq);
        String strM36800a = m36800a(SnsNaming.ADD_FRIEND);
        SnsSearchReqApiCall snsSearchReqApiCall = new SnsSearchReqApiCall(SnsNaming.SEARCH_USER, userSearchReq.toJsonString(), callback, this);
        m36801a(snsSearchReqApiCall, strM36800a);
        return doWrite(snsSearchReqApiCall);
    }

    @Override // com.huawei.hms.support.api.sns.json.SnsClient
    public Task<SnsOutIntent> sendMsgIntent(SnsSendMsgIntentReq snsSendMsgIntentReq, SnsClient.Callback callback) {
        Checker.checkNonNull(snsSendMsgIntentReq);
        String strM36800a = m36800a(SnsNaming.GET_MSG_SEND_INTENT);
        SnsSendMsgTaskApiCall snsSendMsgTaskApiCall = new SnsSendMsgTaskApiCall(SnsNaming.GET_MSG_SEND_INTENT, snsSendMsgIntentReq.toJsonString(), callback, this);
        m36801a(snsSendMsgTaskApiCall, strM36800a);
        return doWrite(snsSendMsgTaskApiCall);
    }

    public SnsClientImpl(Context context, SnsOptions snsOptions) {
        super(context, f29923c, snsOptions, f29921a);
    }

    /* renamed from: a */
    private String m36800a(String str) {
        if (!C0000a.m0a(getContext())) {
            return "";
        }
        HMSLog.m36988i("SnsClientImpl", "HiAnalyticsClient_report_Entry");
        return HiAnalyticsClient.reportEntry(getContext(), str, Constants.SNS_SDK_VERSION_CODE);
    }
}
