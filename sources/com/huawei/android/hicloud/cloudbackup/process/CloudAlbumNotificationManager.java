package com.huawei.android.hicloud.cloudbackup.process;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceMemberShareActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.checker.LevelFrequencyController;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyFrequencyOperator;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0235t;
import p015ak.C0238w;
import p459lp.C11327e;
import p514o9.C11839m;
import p684un.C13222a;
import p684un.C13224c;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class CloudAlbumNotificationManager {
    private static final int FLAG_REMOVBLE = 65536;
    private static final String TAG = "CloudAlbumNotificationManager";
    private Context mContext;
    private NotificationManager mManager;

    public CloudAlbumNotificationManager(Context context) {
        if (context == null) {
            C11839m.m70687e(TAG, "BackupNotificationManager ctx is null");
        } else {
            this.mContext = context;
            this.mManager = (NotificationManager) context.getSystemService("notification");
        }
    }

    private void addRecommendExtra(Bundle bundle, RecommendNeedData recommendNeedData) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (recommendNeedData != null) {
            bundle.putSerializable(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        }
    }

    private void addUniqueIdExtra(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bundle.putString("unique_id", str);
    }

    private void autoCloudAlbumFailNotify(long j10) throws JSONException, SQLException {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "newManualCloudAlbumFailNotify mContext is null");
            return;
        }
        List<SpaceNotification> spaceNotificationList = UserSpaceUtil.getSpaceNotificationList();
        if (spaceNotificationList == null) {
            C11839m.m70688i(TAG, "newManualCloudAlbumFailNotify notifications is null");
            return;
        }
        Collections.sort(spaceNotificationList, new CloudSpaceNotifyUtil.SpaceNotificationComparator());
        for (int i10 = 0; i10 < spaceNotificationList.size(); i10++) {
            SpaceNotification spaceNotification = spaceNotificationList.get(i10);
            if (spaceNotification != null) {
                String noticeType = spaceNotification.getNoticeType();
                C11839m.m70688i(TAG, "noticeType is:" + noticeType);
                if (isNeedContinue(spaceNotification)) {
                    C11839m.m70688i(TAG, "space rule not satisfied");
                } else {
                    float frequency = spaceNotification.getFrequency();
                    float f10 = 24.0f * frequency * 3600000.0f;
                    if (!checkSpaceNotifyRuleFrequency(this.mContext, noticeType, frequency, spaceNotification.getFrequencyTimes())) {
                        C11839m.m70688i(TAG, "autoCloudAlbumFailNotify frequency not satisfied");
                        List<String> userGroupExtIDs = spaceNotification.getUserGroupExtIDs();
                        if (userGroupExtIDs != null && !userGroupExtIDs.isEmpty()) {
                            return;
                        }
                    } else if (MessageCenterManager.getInstance().featureSwitch()) {
                        if (MessageCenterManager.getInstance().invokeEvent(spaceNotification, C11327e.m68061d("HiCloudSpaceNoticeConfigV3"), "HiCloudSpaceNoticeConfigV3", buildUserData(spaceNotification, j10))) {
                            int id2 = spaceNotification.getId();
                            C11839m.m70688i(TAG, "autoCloudAlbumFailNotify id is:" + id2);
                            HiCloudNotification.getInstance().setLastNotifyTime(System.currentTimeMillis());
                            notifyCollectEvent(id2, spaceNotification.getPercentage());
                            CloudSpaceNotifyUtil.saveNotifyTime(this.mContext, f10);
                            recordSpaceNotifyRuleFrequency(spaceNotification);
                            return;
                        }
                        NotifyLogger.m29916w(TAG, "autoCloudAlbumFailNotify invokeEvent fail, notice type: " + noticeType);
                    } else {
                        if (LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", spaceNotification.getRemindPurposes(), noticeType})) {
                            sendSpaceNotEnoughNotify(spaceNotification, true, j10);
                            int id22 = spaceNotification.getId();
                            C11839m.m70688i(TAG, "autoCloudAlbumFailNotify id is:" + id22);
                            HiCloudNotification.getInstance().setLastNotifyTime(System.currentTimeMillis());
                            notifyCollectEvent(id22, spaceNotification.getPercentage());
                            CloudSpaceNotifyUtil.saveNotifyTime(this.mContext, f10);
                            recordSpaceNotifyRuleFrequency(spaceNotification);
                            return;
                        }
                        NotifyLogger.m29916w(TAG, "autoCloudAlbumFailNotify level freq control check fail, notice type: " + noticeType);
                    }
                }
            }
        }
    }

    private boolean checkSpaceNotifyRuleFrequency(Context context, String str, float f10, int i10) {
        return checkCloudAlbumFailNotifyFrequency(context, str, f10, i10);
    }

    private boolean checkUserTags(SpaceNotification spaceNotification) {
        return CloudSpaceNotifyUtil.checkUserTag(UserSpaceUtil.getUserTagsUseCache("AlbumNotificationManager"), spaceNotification);
    }

    private Intent getAlbumPendingIntent(SpaceNotification spaceNotification, String str, String str2, Bundle bundle, long j10) {
        Intent gotoIntent;
        if (CloudSpaceNotifyUtil.getInstance().isFamilyShareMember()) {
            gotoIntent = getMemberIntent(spaceNotification);
        } else {
            String gotoDeeplinkUri = spaceNotification.getGotoDeeplinkUri();
            gotoIntent = !TextUtils.isEmpty(gotoDeeplinkUri) ? NotifyUtil.geteFinalDeepLinkIntent(gotoDeeplinkUri, j10) : getGotoIntent(str, str2);
        }
        if (gotoIntent == null) {
            C11839m.m70687e(TAG, "getAlbumPendingIntent intent is null.");
            return null;
        }
        if (bundle != null) {
            gotoIntent.putExtras(bundle);
        }
        gotoIntent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        gotoIntent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        gotoIntent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        gotoIntent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "3");
        gotoIntent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
        gotoIntent.putExtra("scene_id", NotifyUtil.getReportSceneId(spaceNotification.getNoticeType()));
        C0216g0.m1402e(this.mContext).m1408F(gotoIntent, spaceNotification.getNoticeType() + "_" + spaceNotification.getId());
        return gotoIntent;
    }

    private Intent getFamilyMemberNotifyIntent() {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "getFamilyMemberNotifyIntent, mContext is null");
            return null;
        }
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudSpaceMemberShareActivity.class);
        return intent;
    }

    private Intent getGotoIntent(String str, String str2) {
        Intent intent = new Intent();
        if ("application".equals(str)) {
            Class<?> cls = NotifyConstants.getGotoAppMapping().get(str2);
            if (cls == null) {
                C11839m.m70687e(TAG, "no uri match, return null, uri is: " + str2);
                return null;
            }
            intent.setClass(this.mContext, cls);
            if (NotifyConstants.BUY_MORE.equals(str2)) {
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
            }
        } else if ("web".equals(str)) {
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
        } else if ("detail".equals(str)) {
            intent.setClass(this.mContext, CloudSpaceGuideActivity.class);
        }
        return intent;
    }

    private Intent getMemberIntent(SpaceNotification spaceNotification) {
        MemberShareDetail memberShareDetail = getMemberShareDetail(spaceNotification);
        if (memberShareDetail == null) {
            C11839m.m70687e(TAG, "getMemberIntent, memberShareDetail is null");
            return null;
        }
        Intent familyMemberNotifyIntent = getFamilyMemberNotifyIntent();
        if (familyMemberNotifyIntent == null) {
            C11839m.m70687e(TAG, "getMemberIntent, intent is null");
            return null;
        }
        familyMemberNotifyIntent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail);
        return familyMemberNotifyIntent;
    }

    private RecommendNeedData getRecommendData(SpaceNotification spaceNotification, int i10, long j10) {
        if (spaceNotification == null) {
            C11839m.m70687e(TAG, "getRecommendData spaceNotification is null");
            return null;
        }
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        NoticeDetail noticeContentDetail = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetail(spaceNotification);
        String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetail.getTitle());
        String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetail.getMainText());
        String stringUseLock3 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetail.getButtonFirst());
        C11839m.m70686d(TAG, "getRecommendData detailTitle:" + stringUseLock + " buttonFirst:" + stringUseLock3);
        recommendNeedData.setTitle(stringUseLock);
        recommendNeedData.setMainText(stringUseLock2);
        recommendNeedData.setChooseOtherCaseText(stringUseLock3);
        recommendNeedData.setId(i10);
        recommendNeedData.setTotalNeedSpace(j10);
        recommendNeedData.setRecommendType(NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT);
        recommendNeedData.setEnterType(0);
        return recommendNeedData;
    }

    private boolean isNeedContinue(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            return true;
        }
        String noticeType = spaceNotification.getNoticeType();
        List<String> remindModes = spaceNotification.getRemindModes();
        return (!TextUtils.isEmpty(noticeType) && remindModes != null && NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(noticeType) && remindModes.contains("notification") && checkUserTags(spaceNotification) && checkGradeCode(spaceNotification, UserSpaceUtil.getGradeCodeUseCache("AlbumNotificationManager"))) ? false : true;
    }

    private void newManualCloudAlbumFailNotify(long j10) throws JSONException {
        String noticeType;
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "newManualCloudAlbumFailNotify mContext is null");
            return;
        }
        new UserSpaceUtil(this.mContext);
        List<SpaceNotification> spaceNotificationList = UserSpaceUtil.getSpaceNotificationList();
        if (spaceNotificationList == null) {
            C11839m.m70688i(TAG, "newManualCloudAlbumFailNotify notifications is null");
            return;
        }
        Collections.sort(spaceNotificationList, new CloudSpaceNotifyUtil.SpaceNotificationComparator());
        String gradeCodeUseCache = UserSpaceUtil.getGradeCodeUseCache("AlbumNotificationManager");
        for (int i10 = 0; i10 < spaceNotificationList.size(); i10++) {
            SpaceNotification spaceNotification = spaceNotificationList.get(i10);
            if (spaceNotification != null && (noticeType = spaceNotification.getNoticeType()) != null && NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(noticeType) && checkUserTags(spaceNotification) && checkGradeCode(spaceNotification, gradeCodeUseCache)) {
                int id2 = spaceNotification.getId();
                C11839m.m70686d(TAG, "sendSpaceNotEnoughNotify id:" + id2);
                HiCloudNotification.getInstance().setLastNotifyTime(System.currentTimeMillis());
                sendSpaceNotEnoughNotify(spaceNotification, false, j10);
                notifyCollectEvent(id2, spaceNotification.getPercentage());
                return;
            }
        }
    }

    private void notificationGroupDone(int i10, String str) {
        if (this.mManager.getActiveNotifications().length < 1) {
            return;
        }
        NotificationCompat.Builder builderM1670k = C0238w.m1663f().m1670k(this.mContext, "com.huawei.android.hicloud", i10, str);
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 3, new Intent(this.mContext, (Class<?>) MainActivity.class), HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        builderM1670k.m3823x(true);
        this.mManager.notify(22, builderM1670k.m3824y(R$drawable.logo_about_system).m3809j(pendingIntentM1248e0).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
        C11839m.m70688i(TAG, "notificationGroupDone");
    }

    private void notifyCollectEvent(int i10, float f10) throws JSONException {
        JSONObject jSONObjectM79464f = C13222a.m79464f(this.mContext, "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79464f.put("notify_id", i10);
            jSONObjectM79464f.put("notify_type", "1");
            jSONObjectM79464f.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(f10));
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13224c.m79487f1().m79602z(jSONObjectM79464f);
        UBAAnalyze.m29952M("CKC", "DYNAMIC_NOTIFY_SHOW", jSONObjectM79464f);
    }

    private void recordSpaceNotifyRuleFrequency(SpaceNotification spaceNotification) throws SQLException {
        if (spaceNotification == null) {
            C11839m.m70687e(TAG, "notification is null");
            return;
        }
        new SpaceNotifyFrequencyOperator().updateCount(spaceNotification.getNoticeType(), String.valueOf(spaceNotification.getId()));
    }

    private void reportAlbumNoticeShow(SpaceNotification spaceNotification, boolean z10, boolean z11) {
        String strValueOf;
        float percentage;
        String strValueOf2;
        if (spaceNotification != null) {
            strValueOf = String.valueOf(spaceNotification.getId());
            strValueOf2 = String.valueOf(spaceNotification.getNoticeType());
            percentage = spaceNotification.getPercentage();
        } else {
            strValueOf = "";
            percentage = 0.0f;
            strValueOf2 = "";
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("notify_id", strValueOf);
        linkedHashMapM79497A.put("notify_type", strValueOf2);
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        linkedHashMapM79497A.put("is_auto_sync", String.valueOf(z11));
        linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(percentage));
        C13225d.m79490f1().m79591l0("mecloud_notify_cloudphotospace_not_enough_show", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudphotospace_not_enough_show", "4", "6", linkedHashMapM79497A);
    }

    public NotifyNeedData buildNotifyNeedData(SpaceNotification spaceNotification, String str, long j10) {
        if (C0209d.m1173G1(this.mContext)) {
            C11839m.m70688i(TAG, "buildNotifyNeedData, isPrivacyUser, now exit Cloud!");
            return null;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70688i(TAG, "buildNotifyNeedData, SyncRiskEffective");
            return null;
        }
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        String notiType = noticeGoto.getNotiType();
        String notiUri = noticeGoto.getNotiUri();
        int id2 = spaceNotification.getId();
        NoticeContent noticeNotification = CloudSpaceNotifyUtil.getInstance().getNoticeNotification(spaceNotification);
        if (noticeNotification == null) {
            C11839m.m70687e(TAG, "buildNotifyNeedData noticeContent null");
            return null;
        }
        if (!SpaceNoticeV3Manager.getInstance().checkMultiLanguage(noticeNotification.getTitle(), noticeNotification.getMainText())) {
            C11839m.m70687e(TAG, "buildNotifyNeedData multi language check fail");
            return null;
        }
        if (TextUtils.isEmpty(notiType) || (!"detail".equals(notiType) && TextUtils.isEmpty(notiUri))) {
            C11839m.m70687e(TAG, "type is null or uri is null and type is:" + notiType);
            return null;
        }
        boolean z10 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(spaceNotification);
        Bundle bundle = new Bundle();
        RecommendNeedData recommendData = getRecommendData(spaceNotification, id2, j10);
        addRecommendExtra(bundle, recommendData);
        addUniqueIdExtra(bundle, str);
        MemberShareDetail memberShareDetail = getMemberShareDetail(spaceNotification);
        Intent albumPendingIntent = getAlbumPendingIntent(spaceNotification, notiType, notiUri, bundle, j10);
        if (albumPendingIntent == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify intent is null.");
            return null;
        }
        C13222a.m79471m(albumPendingIntent, 5);
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 3, albumPendingIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 3, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeNotification.getMainText());
        String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeNotification.getTitle());
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        notifyNeedData.setSilent(z10);
        notifyNeedData.setTitleText(stringUseLock2);
        notifyNeedData.setMainText(stringUseLock);
        notifyNeedData.setContentIntent(pendingIntentM1248e0);
        notifyNeedData.setCancelIntent(broadcast);
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle2);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setId(288);
        notifyNeedData.setResourceInfo(String.valueOf(spaceNotification.getId()));
        notifyNeedData.setRecommendNeedData(recommendData);
        notifyNeedData.setMemberShareDetail(memberShareDetail);
        notifyNeedData.setNoticeType(spaceNotification.getNoticeType());
        return notifyNeedData;
    }

    public MsgUserData buildUserData(SpaceNotification spaceNotification, long j10) {
        if (spaceNotification == null) {
            return null;
        }
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setNotifyType(spaceNotification.getNoticeType());
        msgUserData.setNotifyConfigId(spaceNotification.getId());
        msgUserData.setTotalNeedSpace(j10);
        return msgUserData;
    }

    public boolean checkCloudAlbumFailNotifyFrequency(Context context, String str, float f10, int i10) {
        if (context == null || !NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(str)) {
            return false;
        }
        return CloudSpaceNotifyUtil.checkAlbumNotifyFrequency(context, f10 * 24.0f * 3600000.0f, i10);
    }

    public boolean checkGradeCode(SpaceNotification spaceNotification, String str) {
        List<String> supportGradeCodes = spaceNotification.getSupportGradeCodes();
        if (supportGradeCodes == null) {
            C11839m.m70688i(TAG, "checkGradeCode, supportGradeCodes is null, support all grade");
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i(TAG, "checkGradeCode， gradeCode is null or empty");
            return false;
        }
        if (supportGradeCodes.size() > 0) {
            Iterator<String> it = supportGradeCodes.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public MemberShareDetail getMemberShareDetail(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getMemberShareDetail spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeContentDetailMember = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailMember(spaceNotification);
        if (noticeContentDetailMember == null) {
            C11839m.m70687e(TAG, "getFamilyMemberNotifyIntent albumNoticeContent is null.");
            return null;
        }
        MemberShareDetail memberShareDetail = new MemberShareDetail();
        memberShareDetail.setTitle(SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailMember.getTitle()));
        memberShareDetail.setMainText(SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailMember.getMainText()));
        memberShareDetail.setButtonText(SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailMember.getButtonFirst()));
        memberShareDetail.setNotifyType(spaceNotification.getNoticeType());
        return memberShareDetail;
    }

    public void sendSpaceNotEnoughNotify(SpaceNotification spaceNotification, boolean z10, long j10) {
        NotificationCompat.Builder builderM1669j;
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify mContext is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotify, SyncRiskEffective");
            return;
        }
        try {
            NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
            String notiType = noticeGoto.getNotiType();
            String notiUri = noticeGoto.getNotiUri();
            int id2 = spaceNotification.getId();
            NoticeContent noticeNotification = CloudSpaceNotifyUtil.getInstance().getNoticeNotification(spaceNotification);
            if (noticeNotification == null) {
                C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify noticeContent null");
                return;
            }
            if (!SpaceNoticeV3Manager.getInstance().checkMultiLanguage(noticeNotification.getTitle(), noticeNotification.getMainText())) {
                C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify multi language check fail");
                return;
            }
            if (!TextUtils.isEmpty(notiType) && ("detail".equals(notiType) || !TextUtils.isEmpty(notiUri))) {
                String title = noticeNotification.getTitle();
                boolean z11 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(spaceNotification);
                reportAlbumNoticeShow(spaceNotification, z11, z10);
                if (z11 && z10) {
                    C0235t c0235tM1645e = C0235t.m1645e();
                    Context context2 = this.mContext;
                    builderM1669j = c0235tM1645e.m1648g(context2, title, "2", context2.getString(R$string.channel_backup_notification));
                } else {
                    builderM1669j = C0238w.m1663f().m1669j(this.mContext, title);
                }
                NotificationCompat.Builder builder = builderM1669j;
                Bundle bundle = new Bundle();
                addRecommendExtra(bundle, getRecommendData(spaceNotification, id2, j10));
                Intent albumPendingIntent = getAlbumPendingIntent(spaceNotification, notiType, notiUri, bundle, j10);
                if (albumPendingIntent == null) {
                    C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify intent is null.");
                    return;
                }
                C13222a.m79471m(albumPendingIntent, 5);
                PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 3, albumPendingIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
                builder.m3823x(true);
                Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
                intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
                C0209d.m1302r2(intent, this.mContext.getPackageName());
                intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
                intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
                intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
                PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 3, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                Bundle bundle2 = new Bundle();
                bundle2.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
                NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
                String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeNotification.getMainText());
                String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeNotification.getTitle());
                c0605b.m3839h(stringUseLock);
                builder.m3825z(c0605b);
                Notification notificationM3804d = builder.m3811l(stringUseLock2).m3810k(stringUseLock).m3809j(pendingIntentM1248e0).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle2).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
                notificationM3804d.flags = 65536 | 16;
                this.mManager.notify(288, notificationM3804d);
                notificationGroupDone(3, VastAttribute.PROGRESS);
                return;
            }
            C11839m.m70687e(TAG, "type is null or uri is null and type is:" + notiType);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify error. " + e10.toString());
        }
    }

    public void showNotify(boolean z10, long j10) throws JSONException, SQLException {
        C11839m.m70688i(TAG, "showNotify isAutoSync:" + z10 + " needSpace:" + j10);
        if (j10 <= 0) {
            C11839m.m70687e(TAG, "needSpace is less than 0 return");
        } else if (z10) {
            autoCloudAlbumFailNotify(j10);
        } else {
            newManualCloudAlbumFailNotify(j10);
        }
    }
}
