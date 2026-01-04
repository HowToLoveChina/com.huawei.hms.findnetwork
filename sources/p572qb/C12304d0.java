package p572qb;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.bean.SnsAssistantMsg;
import com.huawei.hicloud.messagecenter.bean.SnsAssistantMsgListItem;
import com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.messagecenter.manager.MessageNotificationManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NoticeWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import dk.C9162c;
import java.util.List;
import kn.C11074k;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: qb.d0 */
/* loaded from: classes3.dex */
public class C12304d0 extends BaseMsgProcessor {

    /* renamed from: a */
    public NotifyNeedData f57008a = null;

    /* renamed from: a */
    public final MessageCenterMsgObj m73964a(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay, MsgUserData msgUserData) {
        C11839m.m70688i("ProductMsgProcessor", "buildAlbumSpaceMsg start");
        SpaceNotification spaceNotifyById = new NotificationConfigManager().getSpaceNotifyById(msgUserData.getNotifyConfigId());
        if (spaceNotifyById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildAlbumSpaceMsg config bean is null");
            return null;
        }
        NotifyNeedData notifyNeedDataM73971h = m73971h(clientMessageBody, str);
        if (notifyNeedDataM73971h == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildAlbumSpaceMsg, buildAlbumNotifyNeedData return null");
            return null;
        }
        NoticeGoto noticeGoto = spaceNotifyById.getNoticeGoto();
        if (noticeGoto == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildAlbumSpaceMsg, noticeGoto return null");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObjM73970g = m73970g(clientMessageBody, str, notifyWay, notifyNeedDataM73971h);
        if (messageCenterMsgObjM73970g == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildAlbumSpaceMsg, buildBaseMsg return null");
            return null;
        }
        String notiType = noticeGoto.getNotiType();
        if (TextUtils.isEmpty(notiType)) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, jumpType is null");
            return null;
        }
        RecommendNeedData recommendNeedData = notifyNeedDataM73971h.getRecommendNeedData();
        if (notiType.equals("detail") && recommendNeedData == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, jumpType is detail but no recommend data");
            return null;
        }
        messageCenterMsgObjM73970g.setRecommendNeedData(new Gson().toJson(recommendNeedData));
        messageCenterMsgObjM73970g.setMemberShareDetail(new Gson().toJson(notifyNeedDataM73971h.getMemberShareDetail()));
        messageCenterMsgObjM73970g.setCheckFamilyMember(1);
        messageCenterMsgObjM73970g.setMsgGotoType(notiType);
        messageCenterMsgObjM73970g.setMsgGotoUri(noticeGoto.getNotiUri());
        messageCenterMsgObjM73970g.setResourceInfo(String.valueOf(spaceNotifyById.getId()));
        messageCenterMsgObjM73970g.setGotoDeeplinkUri(spaceNotifyById.getGotoDeeplinkUri());
        long totalNeedSpace = recommendNeedData.getTotalNeedSpace();
        if (totalNeedSpace == -1) {
            totalNeedSpace = 5368709120L;
        }
        messageCenterMsgObjM73970g.setTotalNeedSpace(totalNeedSpace);
        return messageCenterMsgObjM73970g;
    }

    /* renamed from: b */
    public final NotifyNeedData m73965b(MsgUserData msgUserData, String str) {
        C11839m.m70688i("ProductMsgProcessor", "buildAlbumSpaceNotifyNeedData start");
        SpaceNotification spaceNotifyById = new NotificationConfigManager().getSpaceNotifyById(msgUserData.getNotifyConfigId());
        if (spaceNotifyById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildAlbumSpaceNotifyNeedData config bean is null");
            return null;
        }
        return CloudSpaceNotifyUtil.getInstance().buildAlbumNotifyNeedData(spaceNotifyById, str, msgUserData.getTotalNeedSpace());
    }

    /* renamed from: c */
    public final NotifyNeedData m73966c(MsgUserData msgUserData, String str) {
        return CloudSpaceNotifyUtil.getInstance().buildBackupBeforeNoticeData(msgUserData, str);
    }

    /* renamed from: d */
    public final MessageCenterMsgObj m73967d(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay, MsgUserData msgUserData) {
        C11839m.m70688i("ProductMsgProcessor", "buildBackupCycleMsg start");
        int notifyConfigId = msgUserData.getNotifyConfigId();
        ExtraNotificationBean extraNotificationById = new NotificationConfigManager().getExtraNotificationById(notifyConfigId);
        if (extraNotificationById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildBackupCycleMsg config bean is null");
            return null;
        }
        NotifyNeedData notifyNeedDataM73971h = m73971h(clientMessageBody, str);
        if (notifyNeedDataM73971h == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildBackupCycleMsg, buildBackupCycleNotifyNeedData return null");
            return null;
        }
        NoticeGoto noticeGoto = extraNotificationById.getNoticeGoto();
        if (noticeGoto == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildBackupCycleMsg, NoticeWithActivityGoto return null");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObjM73970g = m73970g(clientMessageBody, str, notifyWay, notifyNeedDataM73971h);
        if (messageCenterMsgObjM73970g == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildBackupCycleMsg, buildBaseMsg return null");
            return null;
        }
        messageCenterMsgObjM73970g.setMsgGotoType(noticeGoto.getNotiType());
        messageCenterMsgObjM73970g.setMsgGotoUri(noticeGoto.getNotiUri());
        messageCenterMsgObjM73970g.setResourceInfo(String.valueOf(notifyConfigId));
        return messageCenterMsgObjM73970g;
    }

    /* renamed from: e */
    public final NotifyNeedData m73968e(MsgUserData msgUserData, String str) {
        C11839m.m70688i("ProductMsgProcessor", "buildBackupCycleNotifyNeedData start");
        ExtraNotificationBean extraNotificationById = new NotificationConfigManager().getExtraNotificationById(msgUserData.getNotifyConfigId());
        if (extraNotificationById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildBackupCycleNotifyNeedData config bean is null");
            return null;
        }
        return CloudSpaceNotifyUtil.getInstance().buildBackupCycleNotifyNeedData(extraNotificationById, msgUserData.isShowLocal(), msgUserData.getDays(), str);
    }

    /* renamed from: f */
    public final MessageCenterMsgObj m73969f(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay, MsgUserData msgUserData) {
        C11839m.m70688i("ProductMsgProcessor", "buildBackupSuspendMsg start");
        String strBuildBackupSuspendContent = CloudSpaceNotifyUtil.getInstance().buildBackupSuspendContent(msgUserData.getBackupSpaceNotEnoughNeedData());
        if (!m73978o(strBuildBackupSuspendContent)) {
            C11839m.m70687e("ProductMsgProcessor", "buildBackupSuspendMsg, richContent not fit rule");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObj = new MessageCenterMsgObj();
        messageCenterMsgObj.setCategory(clientMessageBody.getCategory());
        messageCenterMsgObj.setMsgType(notifyWay.getMsgType());
        if (notifyWay.isHasIcon()) {
            messageCenterMsgObj.setNeedShowBadge(1);
        }
        messageCenterMsgObj.setUniqueId(str);
        messageCenterMsgObj.setNotifyTime(clientMessageBody.getNotifyTime());
        messageCenterMsgObj.setRichMsgContent(strBuildBackupSuspendContent);
        messageCenterMsgObj.setResourceInfo(msgUserData.getNotifyType());
        return messageCenterMsgObj;
    }

    /* renamed from: g */
    public final MessageCenterMsgObj m73970g(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay, NotifyNeedData notifyNeedData) {
        if (notifyNeedData == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildBaseMsgObj, notifyNeedData return null");
            return null;
        }
        String titleText = notifyNeedData.getTitleText();
        String mainText = notifyNeedData.getMainText();
        if (TextUtils.isEmpty(titleText) || TextUtils.isEmpty(mainText)) {
            C11839m.m70687e("ProductMsgProcessor", "buildBaseMsgObj, text is null");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObj = new MessageCenterMsgObj();
        messageCenterMsgObj.setCategory(clientMessageBody.getCategory());
        messageCenterMsgObj.setMsgType(notifyWay.getMsgType());
        if (notifyWay.isHasIcon()) {
            messageCenterMsgObj.setNeedShowBadge(1);
        }
        messageCenterMsgObj.setUniqueId(str);
        messageCenterMsgObj.setNotifyTime(clientMessageBody.getNotifyTime());
        messageCenterMsgObj.setTitleText(titleText);
        messageCenterMsgObj.setMainText(mainText);
        messageCenterMsgObj.setNotifyType(clientMessageBody.getNotifyType());
        if (messageContainsNotify(clientMessageBody)) {
            messageCenterMsgObj.setNotifyId(notifyNeedData.getId());
        }
        return messageCenterMsgObj;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.hicloud.notification.bean.NotifyNeedData m73971h(com.huawei.hicloud.messagecenter.bean.ClientMessageBody r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ProductMsgProcessor"
            com.huawei.hicloud.notification.bean.NotifyNeedData r1 = r5.f57008a
            if (r1 == 0) goto L7
            return r1
        L7:
            r1 = 0
            java.lang.String r6 = r6.getUserData()     // Catch: java.lang.Exception -> L18
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L18
            if (r2 == 0) goto L1b
            java.lang.String r5 = "buildNotifyNeedData, userDataStr is empty"
            p514o9.C11839m.m70687e(r0, r5)     // Catch: java.lang.Exception -> L18
            return r1
        L18:
            r5 = move-exception
            goto Lc1
        L1b:
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L18
            r2.<init>()     // Catch: java.lang.Exception -> L18
            java.lang.Class<com.huawei.hicloud.notification.bean.MsgUserData> r3 = com.huawei.hicloud.notification.bean.MsgUserData.class
            java.lang.Object r6 = r2.fromJson(r6, r3)     // Catch: java.lang.Exception -> L18
            com.huawei.hicloud.notification.bean.MsgUserData r6 = (com.huawei.hicloud.notification.bean.MsgUserData) r6     // Catch: java.lang.Exception -> L18
            if (r6 != 0) goto L30
            java.lang.String r5 = "buildNotifyNeedData, userData is empty"
            p514o9.C11839m.m70687e(r0, r5)     // Catch: java.lang.Exception -> L18
            return r1
        L30:
            java.lang.String r2 = r6.getNotifyType()     // Catch: java.lang.Exception -> L18
            boolean r3 = r6.isActivityNotify()     // Catch: java.lang.Exception -> L18
            int r4 = r2.hashCode()     // Catch: java.lang.Exception -> L18
            switch(r4) {
                case -2116214370: goto L7c;
                case -1849560048: goto L72;
                case -1502954020: goto L68;
                case -765047562: goto L5e;
                case -372943030: goto L54;
                case -8273879: goto L4a;
                case 12357325: goto L40;
                default: goto L3f;
            }     // Catch: java.lang.Exception -> L18
        L3f:
            goto L86
        L40:
            java.lang.String r4 = "HiCloudBackupBeforeNotice"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 6
            goto L87
        L4a:
            java.lang.String r4 = "cloudbackup_days_notify"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 5
            goto L87
        L54:
            java.lang.String r4 = "space_used_size"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 3
            goto L87
        L5e:
            java.lang.String r4 = "space_available_days_v3"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 0
            goto L87
        L68:
            java.lang.String r4 = "space_available_ratio"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 1
            goto L87
        L72:
            java.lang.String r4 = "space_available_size"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 2
            goto L87
        L7c:
            java.lang.String r4 = "cloudphoto_sync_space_insufficient"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L18
            if (r4 == 0) goto L86
            r4 = 4
            goto L87
        L86:
            r4 = -1
        L87:
            switch(r4) {
                case 0: goto Lba;
                case 1: goto Lae;
                case 2: goto Lae;
                case 3: goto Lae;
                case 4: goto La9;
                case 5: goto La4;
                case 6: goto L9f;
                default: goto L8a;
            }     // Catch: java.lang.Exception -> L18
        L8a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L18
            r5.<init>()     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = "buildNotifyNeedData, unsupport notify type: "
            r5.append(r6)     // Catch: java.lang.Exception -> L18
            r5.append(r2)     // Catch: java.lang.Exception -> L18
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L18
            p514o9.C11839m.m70687e(r0, r5)     // Catch: java.lang.Exception -> L18
            return r1
        L9f:
            com.huawei.hicloud.notification.bean.NotifyNeedData r6 = r5.m73966c(r6, r7)     // Catch: java.lang.Exception -> L18
            goto Lbe
        La4:
            com.huawei.hicloud.notification.bean.NotifyNeedData r6 = r5.m73968e(r6, r7)     // Catch: java.lang.Exception -> L18
            goto Lbe
        La9:
            com.huawei.hicloud.notification.bean.NotifyNeedData r6 = r5.m73965b(r6, r7)     // Catch: java.lang.Exception -> L18
            goto Lbe
        Lae:
            if (r3 == 0) goto Lb5
            com.huawei.hicloud.notification.bean.NotifyNeedData r6 = r5.m73974k(r6, r7)     // Catch: java.lang.Exception -> L18
            goto Lbe
        Lb5:
            com.huawei.hicloud.notification.bean.NotifyNeedData r6 = r5.m73976m(r6, r7)     // Catch: java.lang.Exception -> L18
            goto Lbe
        Lba:
            com.huawei.hicloud.notification.bean.NotifyNeedData r6 = r5.m73976m(r6, r7)     // Catch: java.lang.Exception -> L18
        Lbe:
            r5.f57008a = r6     // Catch: java.lang.Exception -> L18
            return r6
        Lc1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "buildNotifyNeedData exception: "
            r6.append(r7)
            java.lang.String r5 = r5.toString()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            p514o9.C11839m.m70687e(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p572qb.C12304d0.m73971h(com.huawei.hicloud.messagecenter.bean.ClientMessageBody, java.lang.String):com.huawei.hicloud.notification.bean.NotifyNeedData");
    }

    /* renamed from: i */
    public final MessageCenterMsgObj m73972i(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        try {
            String userData = clientMessageBody.getUserData();
            if (TextUtils.isEmpty(userData)) {
                C11839m.m70687e("ProductMsgProcessor", "buildRichMessageCenterObj, userDataStr is empty");
                return null;
            }
            MsgUserData msgUserData = (MsgUserData) new Gson().fromJson(userData, MsgUserData.class);
            if (msgUserData == null) {
                C11839m.m70687e("ProductMsgProcessor", "buildRichMessageCenterObj, userData is empty");
                return null;
            }
            String notifyType = msgUserData.getNotifyType();
            if ("cloudbackup_failed_suppression".equals(notifyType)) {
                return m73969f(clientMessageBody, str, notifyWay, msgUserData);
            }
            C11839m.m70687e("ProductMsgProcessor", "buildRichMessageCenterObj, unsupport notify type: " + notifyType);
            return null;
        } catch (Exception e10) {
            C11839m.m70687e("ProductMsgProcessor", "buildRichMessageCenterObj exception: " + e10.toString());
            return null;
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean isMsgValid(ClientMessageBody clientMessageBody) {
        if (clientMessageBody == null) {
            C11839m.m70687e("ProductMsgProcessor", "isMsgValid, message is null");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long validityTime = clientMessageBody.getValidityTime();
        C11839m.m70688i("ProductMsgProcessor", "isMsgValid, msg id: " + clientMessageBody.getCfgResourceId() + ", current time: " + jCurrentTimeMillis + ", valid time: " + validityTime);
        return validityTime == 0 || validityTime >= jCurrentTimeMillis;
    }

    /* renamed from: j */
    public final MessageCenterMsgObj m73973j(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay, MsgUserData msgUserData) {
        C11839m.m70688i("ProductMsgProcessor", "buildSpaceActivityNotifyMsg start");
        NotificationWithActivity spaceNotifyActivityById = new NotificationConfigManager().getSpaceNotifyActivityById(msgUserData.getNotifyConfigId());
        if (spaceNotifyActivityById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildSpaceActivityNotifyMsg config bean is null");
            return null;
        }
        String h5ActivityUrl = msgUserData.getH5ActivityUrl();
        NotifyAgdParameters agdParameters = msgUserData.getAgdParameters();
        NotifyNeedData notifyNeedDataM73971h = m73971h(clientMessageBody, str);
        if (notifyNeedDataM73971h == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceActivityNotifyMsg, buildSpaceActivityNotifyNeedData return null");
            return null;
        }
        NoticeWithActivityGoto notiGoto = spaceNotifyActivityById.getNotiGoto();
        if (notiGoto == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceActivityNotifyMsg, NoticeWithActivityGoto return null");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObjM73970g = m73970g(clientMessageBody, str, notifyWay, notifyNeedDataM73971h);
        if (messageCenterMsgObjM73970g == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceActivityNotifyMsg, buildBaseMsg return null");
            return null;
        }
        String notiType = notiGoto.getNotiType();
        if (TextUtils.isEmpty(notiType)) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, jumpType is null");
            return null;
        }
        RecommendNeedData recommendNeedData = notifyNeedDataM73971h.getRecommendNeedData();
        if (notiType.equals("detail") && recommendNeedData == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, jumpType is detail but no recommend data");
            return null;
        }
        messageCenterMsgObjM73970g.setRecommendNeedData(new Gson().toJson(recommendNeedData));
        if (NotifyConstants.HICLOUD_DLAPP.equals(notiGoto.getNotiUri())) {
            messageCenterMsgObjM73970g.setMsgGotoType(notiGoto.getNotiUri());
            messageCenterMsgObjM73970g.setMsgGotoUri(h5ActivityUrl);
            messageCenterMsgObjM73970g.setAgdParameters(new Gson().toJson(agdParameters));
        } else {
            messageCenterMsgObjM73970g.setMsgGotoType(notiType);
            messageCenterMsgObjM73970g.setMsgGotoUri(notiGoto.getNotiUri());
        }
        messageCenterMsgObjM73970g.setResourceInfo(String.valueOf(spaceNotifyActivityById.getId()));
        return messageCenterMsgObjM73970g;
    }

    /* renamed from: k */
    public final NotifyNeedData m73974k(MsgUserData msgUserData, String str) {
        C11839m.m70688i("ProductMsgProcessor", "buildSpaceActivityNotifyNeedData start");
        HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(C0213f.m1377a());
        NotificationWithActivity spaceNotifyActivityById = new NotificationConfigManager().getSpaceNotifyActivityById(msgUserData.getNotifyConfigId());
        if (spaceNotifyActivityById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildSpaceActivityNotifyNeedData config bean is null");
            return null;
        }
        long totalNeedSpace = msgUserData.getTotalNeedSpace();
        long currentPackageSpace = msgUserData.getCurrentPackageSpace();
        String resourceId = msgUserData.getResourceId();
        String strAddLanguageType = NoticeWithActivityUtil.addLanguageType(msgUserData.getH5ActivityUrl());
        NotifyAgdParameters agdParameters = msgUserData.getAgdParameters();
        return hiCloudNotificationManager.buildSpaceActivityNotifyNeedData(spaceNotifyActivityById, Long.valueOf(totalNeedSpace), Long.valueOf(currentPackageSpace), resourceId, strAddLanguageType, msgUserData.isContainActivity(), agdParameters, str);
    }

    /* renamed from: l */
    public final MessageCenterMsgObj m73975l(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay, MsgUserData msgUserData) {
        C11839m.m70688i("ProductMsgProcessor", "buildSpaceNotifyMsg start");
        SpaceNotification spaceNotifyById = new NotificationConfigManager().getSpaceNotifyById(msgUserData.getNotifyConfigId());
        if (spaceNotifyById == null) {
            C11839m.m70688i("ProductMsgProcessor", "buildSpaceNotifyMsg config bean is null");
            return null;
        }
        NotifyNeedData notifyNeedDataM73971h = m73971h(clientMessageBody, str);
        if (notifyNeedDataM73971h == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, buildSpaceNotifyNeedData return null");
            return null;
        }
        NoticeGoto noticeGoto = spaceNotifyById.getNoticeGoto();
        if (noticeGoto == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, noticeGoto return null");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObjM73970g = m73970g(clientMessageBody, str, notifyWay, notifyNeedDataM73971h);
        if (messageCenterMsgObjM73970g == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, buildBaseMsg return null");
            return null;
        }
        String notiType = noticeGoto.getNotiType();
        if (TextUtils.isEmpty(notiType)) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, jumpType is null");
            return null;
        }
        RecommendNeedData recommendNeedData = notifyNeedDataM73971h.getRecommendNeedData();
        if (notiType.equals("detail") && recommendNeedData == null) {
            C11839m.m70687e("ProductMsgProcessor", "buildSpaceNotifyMsg, jumpType is detail but no recommend data");
            return null;
        }
        messageCenterMsgObjM73970g.setRecommendNeedData(new Gson().toJson(recommendNeedData));
        messageCenterMsgObjM73970g.setMemberShareDetail(new Gson().toJson(notifyNeedDataM73971h.getMemberShareDetail()));
        messageCenterMsgObjM73970g.setCheckFamilyMember(1);
        messageCenterMsgObjM73970g.setMsgGotoType(notiType);
        messageCenterMsgObjM73970g.setMsgGotoUri(noticeGoto.getNotiUri());
        messageCenterMsgObjM73970g.setResourceInfo(String.valueOf(spaceNotifyById.getId()));
        messageCenterMsgObjM73970g.setGotoDeeplinkUri(spaceNotifyById.getGotoDeeplinkUri());
        long totalNeedSpace = recommendNeedData.getTotalNeedSpace();
        if (totalNeedSpace == -1) {
            totalNeedSpace = 5368709120L;
        }
        messageCenterMsgObjM73970g.setTotalNeedSpace(totalNeedSpace);
        return messageCenterMsgObjM73970g;
    }

    /* renamed from: m */
    public final NotifyNeedData m73976m(MsgUserData msgUserData, String str) {
        C11839m.m70688i("ProductMsgProcessor", "buildSpaceNotifyNeedData start");
        HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(C0213f.m1377a());
        SpaceNotification spaceNotifyById = new NotificationConfigManager().getSpaceNotifyById(msgUserData.getNotifyConfigId());
        if (spaceNotifyById != null) {
            return hiCloudNotificationManager.buildSpaceNotifyNeedData(spaceNotifyById, msgUserData.getTotalNeedSpace(), msgUserData.getCurrentPackageSpace(), msgUserData.getPackageEndTime(), str);
        }
        C11839m.m70688i("ProductMsgProcessor", "buildSpaceNotifyNeedData config bean is null");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj m73977n(com.huawei.hicloud.messagecenter.bean.ClientMessageBody r12, java.lang.String r13, com.huawei.hicloud.bean.NotifyWay r14) {
        /*
            r11 = this;
            java.lang.String r0 = "ProductMsgProcessor"
            r1 = 0
            java.lang.String r2 = r12.getUserData()     // Catch: java.lang.Exception -> L13
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L13
            if (r3 == 0) goto L16
            java.lang.String r11 = "buildTxtMessageCenterObj, userDataStr is empty"
            p514o9.C11839m.m70687e(r0, r11)     // Catch: java.lang.Exception -> L13
            return r1
        L13:
            r11 = move-exception
            goto Lb9
        L16:
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L13
            r3.<init>()     // Catch: java.lang.Exception -> L13
            java.lang.Class<com.huawei.hicloud.notification.bean.MsgUserData> r4 = com.huawei.hicloud.notification.bean.MsgUserData.class
            java.lang.Object r2 = r3.fromJson(r2, r4)     // Catch: java.lang.Exception -> L13
            com.huawei.hicloud.notification.bean.MsgUserData r2 = (com.huawei.hicloud.notification.bean.MsgUserData) r2     // Catch: java.lang.Exception -> L13
            if (r2 != 0) goto L2b
            java.lang.String r11 = "buildTxtMessageCenterObj, userData is empty"
            p514o9.C11839m.m70687e(r0, r11)     // Catch: java.lang.Exception -> L13
            return r1
        L2b:
            java.lang.String r3 = r2.getNotifyType()     // Catch: java.lang.Exception -> L13
            boolean r4 = r2.isActivityNotify()     // Catch: java.lang.Exception -> L13
            int r5 = r3.hashCode()     // Catch: java.lang.Exception -> L13
            r6 = 4
            r7 = 2
            r8 = 1
            r9 = 3
            r10 = 5
            switch(r5) {
                case -2116214370: goto L72;
                case -1849560048: goto L68;
                case -1502954020: goto L5e;
                case -765047562: goto L54;
                case -372943030: goto L4a;
                case -8273879: goto L40;
                default: goto L3f;
            }     // Catch: java.lang.Exception -> L13
        L3f:
            goto L7c
        L40:
            java.lang.String r5 = "cloudbackup_days_notify"
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            r5 = r10
            goto L7d
        L4a:
            java.lang.String r5 = "space_used_size"
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            r5 = r9
            goto L7d
        L54:
            java.lang.String r5 = "space_available_days_v3"
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            r5 = 0
            goto L7d
        L5e:
            java.lang.String r5 = "space_available_ratio"
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            r5 = r8
            goto L7d
        L68:
            java.lang.String r5 = "space_available_size"
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            r5 = r7
            goto L7d
        L72:
            java.lang.String r5 = "cloudphoto_sync_space_insufficient"
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            r5 = r6
            goto L7d
        L7c:
            r5 = -1
        L7d:
            if (r5 == 0) goto Lb4
            if (r5 == r8) goto La8
            if (r5 == r7) goto La8
            if (r5 == r9) goto La8
            if (r5 == r6) goto La3
            if (r5 == r10) goto L9e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L13
            r11.<init>()     // Catch: java.lang.Exception -> L13
            java.lang.String r12 = "buildTxtMessageCenterObj, unsupport notify type: "
            r11.append(r12)     // Catch: java.lang.Exception -> L13
            r11.append(r3)     // Catch: java.lang.Exception -> L13
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> L13
            p514o9.C11839m.m70687e(r0, r11)     // Catch: java.lang.Exception -> L13
            return r1
        L9e:
            com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj r11 = r11.m73967d(r12, r13, r14, r2)     // Catch: java.lang.Exception -> L13
            goto Lb8
        La3:
            com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj r11 = r11.m73964a(r12, r13, r14, r2)     // Catch: java.lang.Exception -> L13
            goto Lb8
        La8:
            if (r4 == 0) goto Laf
            com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj r11 = r11.m73973j(r12, r13, r14, r2)     // Catch: java.lang.Exception -> L13
            goto Lb8
        Laf:
            com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj r11 = r11.m73975l(r12, r13, r14, r2)     // Catch: java.lang.Exception -> L13
            goto Lb8
        Lb4:
            com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj r11 = r11.m73975l(r12, r13, r14, r2)     // Catch: java.lang.Exception -> L13
        Lb8:
            return r11
        Lb9:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "buildTxtMessageCenterObj exception: "
            r12.append(r13)
            java.lang.String r11 = r11.toString()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            p514o9.C11839m.m70687e(r0, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p572qb.C12304d0.m73977n(com.huawei.hicloud.messagecenter.bean.ClientMessageBody, java.lang.String, com.huawei.hicloud.bean.NotifyWay):com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj");
    }

    /* renamed from: o */
    public final boolean m73978o(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("ProductMsgProcessor", "checkRichContentValid, richContent is null");
            return false;
        }
        try {
            SnsAssistantMsg snsAssistantMsg = (SnsAssistantMsg) new Gson().fromJson(str, SnsAssistantMsg.class);
            if (snsAssistantMsg == null) {
                C11839m.m70687e("ProductMsgProcessor", "checkRichContentValid, snsAssistantMsg is null");
                return false;
            }
            List<SnsAssistantMsgListItem> message = snsAssistantMsg.getMessage();
            if (message == null || message.isEmpty()) {
                C11839m.m70687e("ProductMsgProcessor", "checkRichContentValid, msgItems is null");
                return false;
            }
            SnsAssistantMsgListItem snsAssistantMsgListItem = message.get(0);
            if (snsAssistantMsgListItem == null) {
                C11839m.m70687e("ProductMsgProcessor", "checkRichContentValid, item is null");
                return false;
            }
            if (!TextUtils.isEmpty(snsAssistantMsgListItem.getContent())) {
                return true;
            }
            C11839m.m70687e("ProductMsgProcessor", "checkRichContentValid, content is null");
            return false;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("ProductMsgProcessor", "checkRichContentValid, json exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: p */
    public final void m73979p(NotifyNeedData notifyNeedData) {
        if (notifyNeedData.getId() == 308) {
            CloudSpaceNotifyUtil.getInstance().getSpaceProxy().saveNotificationTime(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, System.currentTimeMillis());
            C11074k.m66711n(new NotificationTask(0L, "", 1));
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void process(ClientMessageBody clientMessageBody) {
        super.process(clientMessageBody);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processBannerNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "operation type can't process banner message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processDeskPopup(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "operation type can't process desk popup message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processH5Dialog(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "product type can't process h5 dialog");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processImgMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "product type can't process img message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMenuNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "operation type can't process menu message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "processMessage start");
        super.processMessage(clientMessageBody, str, notifyWay);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processNotification(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "processNotification start");
        NotifyNeedData notifyNeedDataM73971h = m73971h(clientMessageBody, str);
        if (notifyNeedDataM73971h == null) {
            C11839m.m70687e("ProductMsgProcessor", "processNotification, data process error, notifyNeedData is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_notify_failed");
        } else {
            if (m73980q(notifyNeedDataM73971h)) {
                C11839m.m70688i("ProductMsgProcessor", "no need to notify,will return.");
                return;
            }
            MessageCenterReportUtil.reportMsgProcSuccess(clientMessageBody, notifyNeedDataM73971h, str, notifyWay);
            sendNotification(notifyNeedDataM73971h, clientMessageBody);
            m73979p(notifyNeedDataM73971h);
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processRichMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "processRichMessage start");
        MessageCenterMsgObj messageCenterMsgObjM73972i = m73972i(clientMessageBody, str, notifyWay);
        if (messageCenterMsgObjM73972i == null) {
            C11839m.m70687e("ProductMsgProcessor", "processRichMessage, data process error, msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_rich_msg_failed");
        } else {
            MessageCenterReportUtil.reportMsgProcSuccess(clientMessageBody, messageCenterMsgObjM73972i.getResourceInfo(), str, notifyWay);
            MessageCenterManager.getInstance().insertMessageCenterData(messageCenterMsgObjM73972i);
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processTextMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("ProductMsgProcessor", "processTextMessage start");
        MessageCenterMsgObj messageCenterMsgObjM73977n = m73977n(clientMessageBody, str, notifyWay);
        if (messageCenterMsgObjM73977n == null) {
            C11839m.m70687e("ProductMsgProcessor", "data process error, msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_text_msg_failed");
        } else {
            MessageCenterReportUtil.reportMsgProcSuccess(clientMessageBody, messageCenterMsgObjM73977n.getResourceInfo(), str, notifyWay);
            MessageCenterManager.getInstance().insertMessageCenterData(messageCenterMsgObjM73977n);
        }
    }

    /* renamed from: q */
    public final boolean m73980q(NotifyNeedData notifyNeedData) {
        if (notifyNeedData.getId() != 308 || !C11074k.m66680B()) {
            return false;
        }
        C11839m.m70688i("ProductMsgProcessor", "check Before Notify,now is in silentTime,no need to notify.");
        C11074k.m66693O(0, 1, "check Before Notify,now is in silentTime,no need to notify.");
        return true;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void sendNotification(NotifyNeedData notifyNeedData, ClientMessageBody clientMessageBody) {
        MessageNotificationManager messageNotificationManager = new MessageNotificationManager(C0213f.m1377a());
        if (notifyNeedData == null || clientMessageBody == null) {
            NotifyLogger.m29916w("ProductMsgProcessor", "processNotifyCompatBuilder, notifyNeedData or message is null");
            messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(false, "com.huawei.android.hicloud"), notifyNeedData);
        } else if (C9162c.m57582c().contains(clientMessageBody.getNotifyType())) {
            messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(notifyNeedData.isSilent(), "com.huawei.android.hicloud", 3, VastAttribute.PROGRESS), notifyNeedData, 3, VastAttribute.PROGRESS);
        } else {
            messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(notifyNeedData.isSilent(), "com.huawei.android.hicloud"), notifyNeedData);
        }
    }
}
