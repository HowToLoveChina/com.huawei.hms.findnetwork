package com.huawei.hicloud.notification.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.NotifyJumpInfo;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.BackupNotEnoughDisplayInfo;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NoticeDisplayInfo;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.bean.SpaceNoticeStrInfo;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.config.CBPushConfigObject;
import com.huawei.hicloud.notification.config.CBPushContent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NoticeWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.SNTimes;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.operator.SNTimeOperator;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.notification.util.AbstractCheckAppStatus;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.notification.util.HiCloudLink;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.notify.R$drawable;
import com.huawei.hicloud.notify.R$plurals;
import com.huawei.hicloud.notify.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0229n;
import p015ak.C0235t;
import p015ak.C0238w;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class HiCloudNotificationManager {
    private static final int CLOUD_ALBUM_RELEASE_SPACE_REQUEST_CODE = 2;
    private static final int DATA_RETENTION_REQUEST_CODE = 3;
    private static final long DEFAULT_BACKUP_SPACE = -1;
    private static final long DEFAULT_CURRENT_PACKAGE_SPACE = -1;
    private static final long DEFAULT_PACKAGE_END_TIME = 0;
    private static final int FLAG_REMOVBLE = 65536;
    private static final int SPACE_NOTIFICATION_REQUEST_CODE = 1;
    private static final String TAG = "HiCloudNotificationManager";
    private Context mContext;
    private NotificationManager mManager;

    public HiCloudNotificationManager(Context context) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "BackupNotificationManager ctx is null");
        } else {
            this.mContext = context;
            this.mManager = (NotificationManager) context.getSystemService("notification");
        }
    }

    private void addActivityRecommendExtra(Bundle bundle, NotificationWithActivity notificationWithActivity, RecommendNeedData recommendNeedData) {
        NotifyLogger.m29915i(TAG, "addActivityRecommendExtra");
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "setActivityRecommendExtra, spaceNotification is null");
            return;
        }
        NoticeWithActivityGoto notiGoto = notificationWithActivity.getNotiGoto();
        if (notiGoto == null) {
            NotifyLogger.m29914e(TAG, "setActivityRecommendExtra, noticeGoto is null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!"detail".equals(notiGoto.getNotiType()) || recommendNeedData == null) {
            return;
        }
        bundle.putSerializable(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
    }

    private void addRecommendExtra(Bundle bundle, SpaceNotification spaceNotification, RecommendNeedData recommendNeedData) {
        NotifyLogger.m29915i(TAG, "addRecommendExtra");
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "addRecommendExtra, spaceNotification is null");
            return;
        }
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        if (noticeGoto == null) {
            NotifyLogger.m29914e(TAG, "addRecommendExtra, noticeGoto is null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!"detail".equals(noticeGoto.getNotiType()) || recommendNeedData == null) {
            return;
        }
        bundle.putSerializable(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
    }

    private void addUniqueId(Bundle bundle, String str) {
        NotifyLogger.m29915i(TAG, "addUniqueId");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bundle.putString("unique_id", str);
    }

    private void addVoucherExtra(Bundle bundle, NoticeDisplayInfo noticeDisplayInfo) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (noticeDisplayInfo.isVoucherNotice()) {
            bundle.putBoolean(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, true);
            bundle.putString(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, noticeDisplayInfo.getGradeCode());
            bundle.putLong(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, noticeDisplayInfo.getPackageCapacity());
            bundle.putString(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, noticeDisplayInfo.getPackageId());
        }
        bundle.putBoolean(HNConstants.C4906BI.DATA_IS_VOUCHER_NOTICE, noticeDisplayInfo.isVoucherNotice());
    }

    private NoticeDisplayInfo buildSpaceNoticeInfo(SpaceNotification spaceNotification, Long l10, Long l11, long j10) {
        String noticeTitle;
        String strReplaceVoucherPlaceholder;
        boolean z10;
        NoticeContent noticeCouponContent;
        NoticeDisplayInfo noticeDisplayInfo = new NoticeDisplayInfo();
        boolean zCheckSpaceNotifyRuleFrequency = CloudSpaceNotifyUtil.getInstance().checkSpaceNotifyRuleFrequency(spaceNotification.getNoticeType() + NotifyConstants.SPACE_NOTICE_FREQ_COUPON_SUFFIX, String.valueOf(spaceNotification.getId()), spaceNotification.getCouponFrequency(), spaceNotification.getFrequencyTimes());
        NotifyLogger.m29915i(TAG, "sendSpaceNotify couponfreqFit: " + zCheckSpaceNotifyRuleFrequency);
        VoucherNotiDisplayInfo voucherInfo = zCheckSpaceNotifyRuleFrequency ? CloudSpaceNotifyUtil.getInstance().getVoucherInfo(spaceNotification, l10) : null;
        if (voucherInfo == null || (noticeCouponContent = CloudSpaceNotifyUtil.getInstance().getNoticeCouponContent(spaceNotification)) == null || !SpaceNoticeV3Manager.getInstance().checkMultiLanguage(noticeCouponContent.getTitle(), noticeCouponContent.getMainText())) {
            noticeTitle = "";
            strReplaceVoucherPlaceholder = "";
        } else {
            NotifyLogger.m29915i(TAG, "sendSpaceNotify couponNoticeContent not null");
            String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeCouponContent.getTitle());
            String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeCouponContent.getMainText());
            noticeTitle = replaceVoucherPlaceholder(stringUseLock, voucherInfo);
            strReplaceVoucherPlaceholder = replaceVoucherPlaceholder(stringUseLock2, voucherInfo);
        }
        if (TextUtils.isEmpty(strReplaceVoucherPlaceholder) || TextUtils.isEmpty(noticeTitle)) {
            NoticeContent noticeContentNotification = CloudSpaceNotifyUtil.getInstance().getNoticeContentNotification(spaceNotification);
            if (noticeContentNotification == null) {
                NotifyLogger.m29914e(TAG, "sendSpaceNotify noticeContent null");
                return noticeDisplayInfo;
            }
            if (!SpaceNoticeV3Manager.getInstance().checkMultiLanguage(noticeContentNotification.getMainText(), noticeContentNotification.getTitle())) {
                NotifyLogger.m29914e(TAG, "sendSpaceNotify multi language check fail");
                return noticeDisplayInfo;
            }
            String stringUseLock3 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentNotification.getMainText());
            z10 = false;
            noticeTitle = getNoticeTitle(spaceNotification, noticeContentNotification);
            strReplaceVoucherPlaceholder = stringUseLock3;
        } else {
            z10 = true;
        }
        if (NotifyConstants.SPACE_AVAILABLE_DAYS_V3.equals(spaceNotification.getNoticeType())) {
            if (l11.longValue() >= 0) {
                noticeTitle = C0209d.m1303s(noticeTitle, C0223k.m1520c(this.mContext, l11.longValue()));
            }
            noticeTitle = replaceAvailDaysPlaceHolder(noticeTitle, j10);
        }
        noticeDisplayInfo.setNoticeMainText(strReplaceVoucherPlaceholder);
        noticeDisplayInfo.setNoticeTitle(noticeTitle);
        noticeDisplayInfo.setIsVoucherNotice(z10);
        if (voucherInfo != null) {
            noticeDisplayInfo.setPackageCapacity(voucherInfo.getCapacity());
            noticeDisplayInfo.setGradeCode(voucherInfo.getGradeCode());
            noticeDisplayInfo.setPackageId(voucherInfo.getPackageId());
        }
        return noticeDisplayInfo;
    }

    private NoticeShowNeedData buildSpaceUsedNoticeData(ExtraNotificationBean extraNotificationBean, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
        NoticeShowNeedData noticeShowNeedData = new NoticeShowNeedData();
        if (pendingIntent2 == null || !ExtraNoticeConfigManager.getInstance().isNoticeResourceComplete(extraNotificationBean)) {
            noticeShowNeedData.setTitleText(this.mContext.getResources().getString(R$string.space_notify_title));
            noticeShowNeedData.setMainText(this.mContext.getResources().getString(R$string.space_notify_content));
            noticeShowNeedData.setContentPendingIntent(pendingIntent);
            noticeShowNeedData.setCancelPendingIntent(pendingIntent3);
        } else {
            noticeShowNeedData.setTitleText(ExtraNoticeConfigManager.getInstance().getExtraNoticeLanguage(extraNotificationBean.getNoticeContent().getTitle()));
            noticeShowNeedData.setMainText(ExtraNoticeConfigManager.getInstance().getExtraNoticeLanguage(extraNotificationBean.getNoticeContent().getMainText()));
            noticeShowNeedData.setContentPendingIntent(pendingIntent2);
            noticeShowNeedData.setCancelPendingIntent(pendingIntent3);
        }
        return noticeShowNeedData;
    }

    private String getDisplayDaysStr(long j10) {
        int iAbs = (int) (Math.abs(j10 - System.currentTimeMillis()) / 8.64E7d);
        if (iAbs == 0) {
            iAbs = 1;
        }
        return C0213f.m1377a().getResources().getQuantityString(R$plurals.common_days, iAbs, Integer.valueOf(iAbs));
    }

    private PendingIntent getGalleryMainPendingIntent() {
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.GALLERY_MAIN_ACTION);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_ALBUM_RELEASE_SPACE_NOTIFY");
        return C0209d.m1248e0(this.mContext, 2, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private Intent getMemberIntent(SpaceNotification spaceNotification) {
        MemberShareDetail memberShareDetail = getMemberShareDetail(spaceNotification);
        if (memberShareDetail == null) {
            NotifyLogger.m29914e(TAG, "getMemberIntent, memberShareDetail is null");
            return null;
        }
        Intent familyMemberNotifyIntent = CloudSpaceNotifyUtil.getInstance().getFamilyMemberNotifyIntent();
        if (familyMemberNotifyIntent == null) {
            NotifyLogger.m29914e(TAG, "getMemberIntent, intent is null");
            return null;
        }
        familyMemberNotifyIntent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail);
        return familyMemberNotifyIntent;
    }

    private String getNoticeTitle(SpaceNotification spaceNotification, NoticeContent noticeContent) {
        if (!NotifyConstants.SPACE_AVAILABLE_DAYS_V3.equals(spaceNotification.getNoticeType())) {
            return SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getTitle());
        }
        String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getTitle2());
        return TextUtils.isEmpty(stringUseLock) ? SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getTitle()) : stringUseLock;
    }

    private PendingIntent getSpaceDetailCancelPendingIntent(float f10) {
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, f10);
        return PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
    }

    private PendingIntent getSpaceDetailLocalPendingIntent(String str, float f10) {
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.SPACE_DETAIL_ACTION);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, str);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "1");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, f10);
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra("scene_id", NotifyUtil.getReportSceneId(NotifyConstants.SPACE_QUERY_DETAIL));
        C13222a.m79470l(intent, "3");
        C13230i.m79525e1(intent, "4", "6");
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_SPACE_DETAIL_LOCAL_NOTIFY");
        return C0209d.m1248e0(this.mContext, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hicloud.notification.bean.SpaceNoticeStrInfo getSpaceNoticeStrInfo(boolean r1, int r2, java.lang.String r3, com.huawei.hicloud.notification.p106db.bean.NoticeContent r4) {
        /*
            r0 = this;
            com.huawei.hicloud.notification.bean.SpaceNoticeStrInfo r0 = new com.huawei.hicloud.notification.bean.SpaceNoticeStrInfo
            r0.<init>()
            if (r1 == 0) goto L36
            if (r2 != 0) goto L16
            java.lang.String r1 = "insufficient_main_text"
            java.lang.String r1 = com.huawei.hicloud.notification.util.NoticeWithActivityUtil.getStrFromDBByResource(r3, r1)
            java.lang.String r2 = "insufficient_title"
            java.lang.String r2 = com.huawei.hicloud.notification.util.NoticeWithActivityUtil.getStrFromDBByResource(r3, r2)
            goto L68
        L16:
            r1 = 1
            if (r2 != r1) goto L26
            java.lang.String r1 = "full_main_text"
            java.lang.String r1 = com.huawei.hicloud.notification.util.NoticeWithActivityUtil.getStrFromDBByResource(r3, r1)
            java.lang.String r2 = "full_title"
            java.lang.String r2 = com.huawei.hicloud.notification.util.NoticeWithActivityUtil.getStrFromDBByResource(r3, r2)
            goto L68
        L26:
            r1 = 2
            if (r2 != r1) goto L65
            java.lang.String r1 = "almost_main_text"
            java.lang.String r1 = com.huawei.hicloud.notification.util.NoticeWithActivityUtil.getStrFromDBByResource(r3, r1)
            java.lang.String r2 = "almost_title"
            java.lang.String r2 = com.huawei.hicloud.notification.util.NoticeWithActivityUtil.getStrFromDBByResource(r3, r2)
            goto L68
        L36:
            com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager r1 = com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager.getInstance()
            java.lang.String r2 = r4.getMainText()
            java.lang.String r3 = r4.getTitle()
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            boolean r1 = r1.checkMultiLanguage(r2)
            if (r1 == 0) goto L65
            com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager r1 = com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager.getInstance()
            java.lang.String r2 = r4.getMainText()
            java.lang.String r1 = r1.getStringUseLock(r2)
            com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager r2 = com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager.getInstance()
            java.lang.String r3 = r4.getTitle()
            java.lang.String r2 = r2.getStringUseLock(r3)
            goto L68
        L65:
            java.lang.String r1 = ""
            r2 = r1
        L68:
            r0.setContentTitle(r2)
            r0.setContentText(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HiCloudNotificationManager.getSpaceNoticeStrInfo(boolean, int, java.lang.String, com.huawei.hicloud.notification.db.bean.NoticeContent):com.huawei.hicloud.notification.bean.SpaceNoticeStrInfo");
    }

    private PendingIntent getSpaceNotifyActivityPendingIntent(NotificationWithActivity notificationWithActivity, String str, Bundle bundle) {
        Intent activitySpacePendingNeedIntent = getActivitySpacePendingNeedIntent(notificationWithActivity, str);
        if (activitySpacePendingNeedIntent == null) {
            NotifyLogger.m29914e(TAG, "getPendingNeedIntent is null.");
            return null;
        }
        if (bundle != null) {
            activitySpacePendingNeedIntent.putExtras(bundle);
        }
        C13222a.m79470l(activitySpacePendingNeedIntent, "4");
        C13230i.m79525e1(activitySpacePendingNeedIntent, "4", "6");
        NotifyUtil.notifyBuildReportCollect(activitySpacePendingNeedIntent, notificationWithActivity, notificationWithActivity.getNotiGoto(), "2");
        activitySpacePendingNeedIntent.putExtra("enterFrom", "0007");
        C13222a.m79471m(activitySpacePendingNeedIntent, 3);
        C0216g0.m1402e(C0213f.m1377a()).m1408F(activitySpacePendingNeedIntent, notificationWithActivity.getNoticeType() + "_" + notificationWithActivity.getId());
        return getPendingActivityIntent(notificationWithActivity, false, activitySpacePendingNeedIntent, 1);
    }

    private PendingIntent getSpaceNotifyPendingIntent(SpaceNotification spaceNotification, Bundle bundle, long j10) {
        Intent pendingNeedIntent;
        boolean zIsFamilyShareMember = CloudSpaceNotifyUtil.getInstance().isFamilyShareMember();
        if (zIsFamilyShareMember) {
            pendingNeedIntent = getMemberIntent(spaceNotification);
        } else {
            String gotoDeeplinkUri = spaceNotification.getGotoDeeplinkUri();
            pendingNeedIntent = !TextUtils.isEmpty(gotoDeeplinkUri) ? NotifyUtil.geteFinalDeepLinkIntent(gotoDeeplinkUri, j10) : getPendingNeedIntent(spaceNotification);
        }
        if (pendingNeedIntent == null) {
            NotifyLogger.m29914e(TAG, "getPendingNeedIntent is null.");
            return null;
        }
        if (bundle != null) {
            pendingNeedIntent.putExtras(bundle);
        }
        if (NotifyConstants.SPACE_AVAILABLE_DAYS_V3.equals(spaceNotification.getNoticeType())) {
            pendingNeedIntent.putExtra("action_bar_color_hm_os_bg", true);
            pendingNeedIntent.putExtra("is_support_dark_mode", true);
        }
        pendingNeedIntent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        pendingNeedIntent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "2");
        pendingNeedIntent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
        C13222a.m79470l(pendingNeedIntent, "4");
        C13230i.m79525e1(pendingNeedIntent, "4", "6");
        pendingNeedIntent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        pendingNeedIntent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        pendingNeedIntent.putExtra(HNConstants.C4906BI.DATA_TYPE_ID, "" + spaceNotification.getId());
        pendingNeedIntent.putExtra("scene_id", NotifyUtil.getReportSceneId(spaceNotification.getNoticeType()));
        pendingNeedIntent.putExtra("enterFrom", "0007");
        C13222a.m79471m(pendingNeedIntent, 3);
        C0216g0.m1402e(C0213f.m1377a()).m1408F(pendingNeedIntent, spaceNotification.getNoticeType() + "_" + spaceNotification.getId());
        return getPendingIntent(spaceNotification, zIsFamilyShareMember, pendingNeedIntent);
    }

    private boolean isGallery(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals("application") && str2.equals(NotifyConstants.HICLOUD_GALLERY);
    }

    private void reportCPBNotifyShow(Context context, CBPushConfigObject cBPushConfigObject, boolean z10) throws JSONException {
        NotifyLogger.m29915i(TAG, "send CBPushNotification collectEvent");
        String strValueOf = cBPushConfigObject != null ? String.valueOf(cBPushConfigObject.getId()) : "";
        JSONObject jSONObjectM79482j = C13223b.m79482j(context, "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put("notify_id", strValueOf);
            jSONObjectM79482j.put("notify_type", "1");
            jSONObjectM79482j.put("is_silent_noti", z10);
        } catch (JSONException e10) {
            NotifyLogger.m29914e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_SHOW", "4", "34", jSONObjectM79482j);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("type", strValueOf);
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        C13227f.m79492i1().m79591l0("mecloud_notify_pullnew_show", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_pullnew_show", "4", "3", linkedHashMapM79497A);
    }

    private void reportCloudSpaceShow(SpaceNotification spaceNotification, boolean z10, boolean z11) throws JSONException {
        int id2;
        float percentage;
        String noticeType;
        JSONObject jSONObjectM79482j = C13223b.m79482j(this.mContext, "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        if (spaceNotification != null) {
            id2 = spaceNotification.getId();
            percentage = spaceNotification.getPercentage();
            noticeType = spaceNotification.getNoticeType();
        } else {
            id2 = 0;
            percentage = 0.0f;
            noticeType = "";
        }
        try {
            jSONObjectM79482j.put("notify_id", id2);
            jSONObjectM79482j.put("notify_type", "1");
            jSONObjectM79482j.put("is_silent_noti", z10);
            jSONObjectM79482j.put("voucher_notice", z11);
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, percentage);
            jSONObjectM79482j.put("scene_id", NotifyUtil.getReportSceneId(noticeType));
        } catch (JSONException e10) {
            NotifyLogger.m29914e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_SHOW", "4", "6", jSONObjectM79482j);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("type", String.valueOf(id2));
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        linkedHashMapM79497A.put("voucher_notice", String.valueOf(z11));
        linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(percentage));
        linkedHashMapM79497A.put("scene_id", NotifyUtil.getReportSceneId(noticeType));
        C13227f.m79492i1().m79591l0("mecloud_notify_cloudspace_show", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_show", "4", "6", linkedHashMapM79497A);
        NotificationReportUtil.reportSpaceNotifyShow(linkedHashMapM79497A);
    }

    private void reportSpaceUsedShow(ExtraNotificationBean extraNotificationBean, boolean z10) {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        if (extraNotificationBean != null) {
            strValueOf = String.valueOf(extraNotificationBean.getId());
            strValueOf3 = String.valueOf(extraNotificationBean.getNoticeType());
            strValueOf2 = String.valueOf(extraNotificationBean.getPercentage());
        } else {
            strValueOf = "";
            strValueOf2 = "";
            strValueOf3 = strValueOf2;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("notify_id", strValueOf);
        linkedHashMapM79497A.put("notify_type", strValueOf3);
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, strValueOf2);
        C13227f.m79492i1().m79591l0("mecloud_notify_space_use_show", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_space_use_show", "4", "6", linkedHashMapM79497A);
    }

    private void showNotice(NoticeShowNeedData noticeShowNeedData, String str, String str2, int i10, boolean z10) {
        if (noticeShowNeedData == null || !noticeShowNeedData.isAllMustDataExist()) {
            NotifyLogger.m29914e(TAG, "data is not complete");
            return;
        }
        NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(z10, noticeShowNeedData.getTitleText());
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", str2);
        notificationBuilder.m3823x(true);
        this.mManager.notify(i10, notificationBuilder.m3811l(noticeShowNeedData.getTitleText()).m3810k(noticeShowNeedData.getMainText()).m3799B(noticeShowNeedData.getTitleText()).m3809j(noticeShowNeedData.getContentPendingIntent()).m3814o(noticeShowNeedData.getCancelPendingIntent()).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3803c(bundle).m3817r(str).m3807h(true).m3804d());
        notificationGroupDone(z10);
    }

    public void addAgdParamExtra(Bundle bundle, NotifyAgdParameters notifyAgdParameters) {
        if (notifyAgdParameters == null) {
            NotifyLogger.m29915i(TAG, "notify adParameters is null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("agd_resource_enable", notifyAgdParameters.getEnabled());
        bundle.putString("agd_resource_slot_id", notifyAgdParameters.getSlotId());
        bundle.putInt("pps_threshold", notifyAgdParameters.getThreshold());
    }

    public NotifyNeedData buildSpaceActivityNotifyNeedData(NotificationWithActivity notificationWithActivity, Long l10, Long l11, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters, String str3) {
        if (notificationWithActivity == null) {
            NotifyLogger.m29915i(TAG, "buildSpaceActivityNotifyNeedData spaceNotification is null.");
            return null;
        }
        if (C0209d.m1173G1(this.mContext)) {
            NotifyLogger.m29915i(TAG, "buildSpaceActivityNotifyNeedData, isPrivacyUser, now exit Cloud!");
            return null;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "buildSpaceActivityNotifyNeedData, AppStatusAbnormal");
            return null;
        }
        boolean z11 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(notificationWithActivity);
        NoticeContent noticeContentQueryNoticeContentForSpaceNotify = NoticeWithActivityUtil.queryNoticeContentForSpaceNotify(notificationWithActivity);
        if (noticeContentQueryNoticeContentForSpaceNotify == null) {
            NotifyLogger.m29914e(TAG, "buildSpaceActivityNotifyNeedData noticeContent null");
            return null;
        }
        SpaceNoticeStrInfo spaceNoticeStrInfo = getSpaceNoticeStrInfo(z10, notificationWithActivity.getSpaceType(), str, noticeContentQueryNoticeContentForSpaceNotify);
        String contentTitle = spaceNoticeStrInfo.getContentTitle();
        String contentText = spaceNoticeStrInfo.getContentText();
        if (TextUtils.isEmpty(contentText) && TextUtils.isEmpty(contentTitle)) {
            NotifyLogger.m29914e(TAG, "buildSpaceActivityNotifyNeedData contentTitle and contentText is null");
            return null;
        }
        Bundle bundle = new Bundle();
        RecommendNeedData activityRecommendNeedData = getActivityRecommendNeedData(notificationWithActivity, l10, l11);
        addActivityRecommendExtra(bundle, notificationWithActivity, activityRecommendNeedData);
        addUniqueId(bundle, str3);
        addAgdParamExtra(bundle, notifyAgdParameters);
        PendingIntent spaceNotifyActivityPendingIntent = getSpaceNotifyActivityPendingIntent(notificationWithActivity, str2, bundle);
        if (spaceNotifyActivityPendingIntent == null) {
            NotifyLogger.m29914e(TAG, "buildSpaceActivityNotifyNeedData contentIntent is null.");
            return null;
        }
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("notify_id", notificationWithActivity.getId());
        bundle2.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle2);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle3 = new Bundle();
        bundle3.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        notifyNeedData.setSilent(z11);
        notifyNeedData.setTitleText(contentTitle);
        notifyNeedData.setMainText(contentText);
        notifyNeedData.setContentIntent(spaceNotifyActivityPendingIntent);
        notifyNeedData.setCancelIntent(broadcast);
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle3);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setId(265);
        notifyNeedData.setResourceInfo(String.valueOf(notificationWithActivity.getId()));
        notifyNeedData.setRecommendNeedData(activityRecommendNeedData);
        notifyNeedData.setNoticeType(notificationWithActivity.getNoticeType());
        notifyNeedData.setActivityType(notificationWithActivity.getActivityType());
        return notifyNeedData;
    }

    public NotifyNeedData buildSpaceNotifyNeedData(SpaceNotification spaceNotification, long j10, long j11, long j12, String str) throws SQLException {
        if (spaceNotification == null) {
            NotifyLogger.m29915i(TAG, "buildSpaceNotifyNeedData baseNotifyBean is null.");
            return null;
        }
        if (C0209d.m1173G1(C0213f.m1377a())) {
            NotifyLogger.m29915i(TAG, "buildSpaceNotifyNeedData, isPrivacyUser, now exit Cloud!");
            return null;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "buildSpaceNotifyNeedData, AppStatusAbnormal");
            return null;
        }
        boolean z10 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(spaceNotification);
        NoticeDisplayInfo noticeDisplayInfoBuildSpaceNoticeInfo = buildSpaceNoticeInfo(spaceNotification, Long.valueOf(j10), Long.valueOf(j11), j12);
        String noticeMainText = noticeDisplayInfoBuildSpaceNoticeInfo.getNoticeMainText();
        String noticeTitle = noticeDisplayInfoBuildSpaceNoticeInfo.getNoticeTitle();
        if (TextUtils.isEmpty(noticeMainText) || TextUtils.isEmpty(noticeTitle)) {
            NotifyLogger.m29914e(TAG, "buildSpaceNotifyNeedData notice string null");
            return null;
        }
        if (spaceNotification.getTopupPackage() == 1) {
            noticeTitle = C0229n.m1604c(noticeTitle, "Storage+", "fa");
        }
        Bundle bundle = new Bundle();
        addUniqueId(bundle, str);
        RecommendNeedData notifyRecommendNeedData = getNotifyRecommendNeedData(spaceNotification, Long.valueOf(j10), Long.valueOf(j11));
        addRecommendExtra(bundle, spaceNotification, notifyRecommendNeedData);
        addVoucherExtra(bundle, noticeDisplayInfoBuildSpaceNoticeInfo);
        MemberShareDetail memberShareDetail = getMemberShareDetail(spaceNotification);
        PendingIntent spaceNotifyPendingIntent = getSpaceNotifyPendingIntent(spaceNotification, bundle, j10);
        if (spaceNotifyPendingIntent == null) {
            NotifyLogger.m29914e(TAG, "buildSpaceNotifyNeedData contentIntent is null.");
            return null;
        }
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.DATA_IS_VOUCHER_NOTICE, noticeDisplayInfoBuildSpaceNoticeInfo.isVoucherNotice());
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        if (noticeDisplayInfoBuildSpaceNoticeInfo.isVoucherNotice()) {
            NotifyLogger.m29915i(TAG, "buildSpaceNotifyNeedData record coupon notice frequency, noticeType = " + spaceNotification.getNoticeType() + ", noticeId = " + spaceNotification.getId());
            CloudSpaceNotifyUtil.getInstance().recordSpaceNotifyCouponFrequency(spaceNotification);
        }
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        notifyNeedData.setSilent(z10);
        notifyNeedData.setTitleText(noticeTitle);
        notifyNeedData.setMainText(noticeMainText);
        notifyNeedData.setContentIntent(spaceNotifyPendingIntent);
        notifyNeedData.setCancelIntent(broadcast);
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle2);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setId(265);
        notifyNeedData.setResourceInfo(String.valueOf(spaceNotification.getId()));
        notifyNeedData.setRecommendNeedData(notifyRecommendNeedData);
        notifyNeedData.setMemberShareDetail(memberShareDetail);
        notifyNeedData.setNoticeType(spaceNotification.getNoticeType());
        return notifyNeedData;
    }

    public MsgUserData buildUserData(SpaceNotification spaceNotification, Long l10) {
        return buildUserData(spaceNotification, l10, -1L, 0L);
    }

    public MsgUserData buildUserDataActivity(NotificationWithActivity notificationWithActivity, Long l10, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) {
        if (notificationWithActivity == null) {
            NotifyLogger.m29915i(TAG, "buildUserDataActivity spaceNotification is null.");
            return null;
        }
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setNotifyType(notificationWithActivity.getNoticeType());
        msgUserData.setActivityNotify(true);
        msgUserData.setNotifyConfigId(notificationWithActivity.getId());
        msgUserData.setTotalNeedSpace(l10.longValue());
        msgUserData.setCurrentPackageSpace(-1L);
        msgUserData.setContainActivity(z10);
        msgUserData.setResourceId(str);
        msgUserData.setH5ActivityUrl(str2);
        msgUserData.setAgdParameters(notifyAgdParameters);
        return msgUserData;
    }

    public void cancelNotification(int i10) {
        boolean z10;
        NotifyLogger.m29915i(TAG, "cancelNotification, id = " + i10);
        NotificationManager notificationManager = this.mManager;
        if (notificationManager != null) {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications == null) {
                NotifyLogger.m29914e(TAG, "cancelNotification sta is null.");
                return;
            }
            int i11 = 0;
            boolean z11 = false;
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (i10 == statusBarNotification.getId()) {
                    z11 = true;
                }
            }
            if (!z11) {
                NotifyLogger.m29914e(TAG, "cancelNotification id doesn't exist");
                return;
            }
            if (activeNotifications.length == 2) {
                NotifyLogger.m29915i(TAG, "cancel all notification");
                if (activeNotifications[0].getId() != i10 && activeNotifications[1].getId() != i10) {
                    AbstractC10896a.m65886e(TAG, "cancel invalid notify id = " + i10);
                    return;
                }
                this.mManager.cancel(i10);
                this.mManager.cancel(22);
                AbstractC10896a.m65887i(TAG, "cancel notification finish");
            }
            if (activeNotifications.length > 0) {
                z10 = false;
                int i12 = 0;
                while (i11 < activeNotifications.length) {
                    if (activeNotifications[i11].getNotification() == null) {
                        NotifyLogger.m29915i(TAG, "notification is null");
                    } else if (activeNotifications[i11].getNotification().getGroup() == null) {
                        NotifyLogger.m29915i(TAG, "Notification group is null");
                    } else if ("com.huawei.android.hicloud".equals(activeNotifications[i11].getNotification().getGroup())) {
                        i12++;
                        if (activeNotifications[i11].getId() == 22) {
                            z10 = true;
                        }
                    }
                    i11++;
                }
                i11 = i12;
            } else {
                z10 = false;
            }
            this.mManager.cancel(i10);
            if (i11 == 2 && z10) {
                this.mManager.cancel(22);
            }
        }
    }

    public void clearSummaryNotification() {
        StatusBarNotification statusBarNotification;
        StatusBarNotification[] activeNotifications = this.mManager.getActiveNotifications();
        if (activeNotifications.length == 1 && (statusBarNotification = activeNotifications[0]) != null && statusBarNotification.getId() == 22) {
            this.mManager.cancel(22);
        }
    }

    public NotificationWithActivity doSpaceNoticeWithActivity(Map<String, List<NotificationWithActivity>> map, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, List<PortraitAndGrade.UserTag> list, long j11, List<NotificationWithActivity> list2) {
        return CloudSpaceNotifyUtil.getInstance().doSpaceNoticeWithActivity(map, sNTimes, sNTimeOperator, j10, list, j11, list2);
    }

    public RecommendNeedData getActivityRecommendNeedData(NotificationWithActivity notificationWithActivity, Long l10, Long l11) {
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "getActivityRecommendNeedData spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeDetailQueryNoticeDetailForSpaceNotify = NoticeWithActivityUtil.queryNoticeDetailForSpaceNotify(notificationWithActivity);
        if (noticeDetailQueryNoticeDetailForSpaceNotify == null) {
            NotifyLogger.m29916w(TAG, "getActivityRecommendNeedData noticeDetail is null.");
            return null;
        }
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeDetailQueryNoticeDetailForSpaceNotify.getTitle());
        String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeDetailQueryNoticeDetailForSpaceNotify.getMainText());
        String stringUseLock3 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeDetailQueryNoticeDetailForSpaceNotify.getButtonFirst());
        if (TextUtils.isEmpty(stringUseLock) && TextUtils.isEmpty(stringUseLock2) && TextUtils.isEmpty(stringUseLock3)) {
            NotifyLogger.m29914e(TAG, "getActivityRecommendNeedData contentTitle and contentText and buttonFirst is null");
            return null;
        }
        recommendNeedData.setIsFormWithActivity(true);
        recommendNeedData.setActivityType(SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
        recommendNeedData.setRecommendType(notificationWithActivity.getNoticeType());
        recommendNeedData.setEnterType(0);
        recommendNeedData.setId(notificationWithActivity.getId());
        recommendNeedData.setTitle(stringUseLock);
        recommendNeedData.setMainText(stringUseLock2);
        recommendNeedData.setChooseOtherCaseText(stringUseLock3);
        recommendNeedData.setTotalNeedSpace(l10.longValue());
        recommendNeedData.setCurrentPackageSpace(l11.longValue());
        recommendNeedData.setWorryFreeExpire(notificationWithActivity.getTopupPackage() == 1);
        return recommendNeedData;
    }

    public Intent getActivitySpacePendingNeedIntent(NotificationWithActivity notificationWithActivity, String str) {
        if (notificationWithActivity == null) {
            NotifyLogger.m29916w(TAG, "getActivitySpacePendingNeedIntent spaceNotification is null.");
            return null;
        }
        NotifyLogger.m29915i(TAG, "getActivitySpacePendingNeedIntent start, noticeType = " + notificationWithActivity.getNoticeType());
        NoticeWithActivityGoto notiGoto = notificationWithActivity.getNotiGoto();
        String notiType = notiGoto.getNotiType();
        String notiUri = notiGoto.getNotiUri();
        if (TextUtils.isEmpty(notiType)) {
            return null;
        }
        Intent gotoIntent = NotifyUtil.getGotoIntent(this.mContext, notiType, notiUri, str);
        if (gotoIntent == null) {
            NotifyLogger.m29916w(TAG, "getActivitySpacePendingNeedIntent gotoIntent is null.");
            return null;
        }
        NotifyLogger.m29915i(TAG, "getActivitySpacePendingNeedIntent end");
        return gotoIntent;
    }

    public MemberShareDetail getMemberShareDetail(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getMemberShareDetail spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeContentDetailMember = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailMember(spaceNotification);
        if (noticeContentDetailMember == null) {
            NotifyLogger.m29914e(TAG, "getMemberShareDetail noticeDetail is null.");
            return null;
        }
        MemberShareDetail memberShareDetail = new MemberShareDetail();
        memberShareDetail.setTitle(SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailMember.getTitle()));
        memberShareDetail.setMainText(SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailMember.getMainText()));
        memberShareDetail.setButtonText(SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailMember.getButtonFirst()));
        memberShareDetail.setNotifyType(spaceNotification.getNoticeType());
        return memberShareDetail;
    }

    public RecommendNeedData getNotifyRecommendNeedData(SpaceNotification spaceNotification, Long l10, Long l11) {
        String stringUseLock;
        String stringUseLock2;
        String stringUseLock3;
        if (spaceNotification == null) {
            NotifyLogger.m29915i(TAG, "getNotifyRecommendNeedData spaceNotification is null");
            return null;
        }
        String notiType = spaceNotification.getNoticeGoto().getNotiType();
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        NoticeDetail noticeDetailWithPlaceHolder = CloudSpaceNotifyUtil.getInstance().getNoticeDetailWithPlaceHolder(spaceNotification);
        if (noticeDetailWithPlaceHolder != null) {
            stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeDetailWithPlaceHolder.getTitle());
            stringUseLock3 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeDetailWithPlaceHolder.getButtonFirst());
            stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeDetailWithPlaceHolder.getMainText());
        } else {
            stringUseLock = "";
            stringUseLock2 = "";
            stringUseLock3 = stringUseLock2;
        }
        recommendNeedData.setGalleryNum(0L);
        NoticeDetail noticeContentDetailDefault = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailDefault(spaceNotification, notiType);
        if (noticeContentDetailDefault != null) {
            stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentDetailDefault.getMainText());
        }
        recommendNeedData.setRecommendType(spaceNotification.getNoticeType());
        recommendNeedData.setId(spaceNotification.getId());
        recommendNeedData.setTitle(stringUseLock);
        recommendNeedData.setMainText(stringUseLock2);
        recommendNeedData.setChooseOtherCaseText(stringUseLock3);
        recommendNeedData.setTotalNeedSpace(l10.longValue());
        recommendNeedData.setCurrentPackageSpace(l11.longValue());
        recommendNeedData.setNotUsedSpace(-1L);
        recommendNeedData.setWorryFreeExpire(spaceNotification.getTopupPackage() == 1);
        return recommendNeedData;
    }

    public PendingIntent getPendingActivityIntent(NotificationWithActivity notificationWithActivity, boolean z10, Intent intent, int i10) {
        NoticeWithActivityGoto notiGoto = notificationWithActivity.getNotiGoto();
        return (z10 || !isGallery(notiGoto.getNotiType(), notiGoto.getNotiUri())) ? C0209d.m1248e0(this.mContext, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : PendingIntent.getBroadcast(this.mContext, 10002, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    public PendingIntent getPendingIntent(SpaceNotification spaceNotification, boolean z10, Intent intent) {
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        return (z10 || !isGallery(noticeGoto.getNotiType(), noticeGoto.getNotiUri())) ? C0209d.m1248e0(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : PendingIntent.getBroadcast(this.mContext, 10002, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    public Intent getPendingNeedIntent(SpaceNotification spaceNotification) {
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        String notiType = noticeGoto.getNotiType();
        String notiUri = noticeGoto.getNotiUri();
        if (!NotifyUtil.checkIsUriModuleEnable(this.mContext, notiType, notiUri, noticeGoto)) {
            NotifyLogger.m29916w(TAG, "getPendingNeedIntent uri is empty or moudlue not enable");
            return null;
        }
        Intent gotoIntent = NotifyUtil.getGotoIntent(this.mContext, notiType, notiUri);
        NotifyLogger.m29915i(TAG, "notification = " + spaceNotification.getNoticeType());
        return gotoIntent;
    }

    public boolean isFamilyShareMember() {
        return CloudSpaceNotifyUtil.getInstance().isFamilyShareMember();
    }

    public void notificationGroupDone(boolean z10) {
        notificationGroupDone(z10, 3, "reminder");
    }

    public void notificationProgressGroupDone(boolean z10) {
        notificationGroupDone(z10, 3, VastAttribute.PROGRESS);
    }

    public void notify(int i10, Notification notification) {
        this.mManager.notify(i10, notification);
    }

    public String replaceAvailDaysPlaceHolder(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "replaceAvailDaysPlaceHolder error. oriStr is null");
            return str;
        }
        if (j10 == 0) {
            NotifyLogger.m29914e(TAG, "replaceAvailDaysPlaceHolder error. packageEndTime is 0L");
            return str;
        }
        if (str.contains("%{PackageAbsoluteEndTime}")) {
            str = str.replace("%{PackageAbsoluteEndTime}", C0223k.m1519b(C0213f.m1377a(), j10, C13452e.m80781L().m80901d0()));
        }
        return str.contains("%{PackageRelativeEndTime}") ? str.replace("%{PackageRelativeEndTime}", getDisplayDaysStr(j10)) : str;
    }

    public String replacePlaceForBackup(String str, BackupNotEnoughDisplayInfo backupNotEnoughDisplayInfo) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "replacePlaceholder error. oriStr is null");
            return str;
        }
        if (!TextUtils.isEmpty(backupNotEnoughDisplayInfo.getUnBackupDays())) {
            str = str.replace("%{UNBackupDay}s", backupNotEnoughDisplayInfo.getUnBackupDays());
        }
        if (!TextUtils.isEmpty(backupNotEnoughDisplayInfo.getBackupDataSize())) {
            str = str.replace("%{BackupSize}s", backupNotEnoughDisplayInfo.getBackupDataSize());
        }
        return !TextUtils.isEmpty(backupNotEnoughDisplayInfo.getRemainSpace()) ? str.replace("%{RemainSpace}s", backupNotEnoughDisplayInfo.getRemainSpace()) : str;
    }

    public String replaceVoucherPlaceholder(String str, VoucherNotiDisplayInfo voucherNotiDisplayInfo) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "replaceVoucherPlaceholder error. oriStr is null");
            return str;
        }
        if (voucherNotiDisplayInfo == null) {
            NotifyLogger.m29914e(TAG, "replaceVoucherPlaceholder error. displayInfo is null");
            return str;
        }
        String discountAmount = voucherNotiDisplayInfo.getDiscountAmount();
        if (!TextUtils.isEmpty(discountAmount)) {
            str = str.replace("%{CDAmount}s", discountAmount);
        }
        String validityDays = voucherNotiDisplayInfo.getValidityDays();
        if (!TextUtils.isEmpty(validityDays)) {
            str = str.replace("%{CVDays}s", validityDays);
        }
        String title = voucherNotiDisplayInfo.getTitle();
        if (!TextUtils.isEmpty(title)) {
            str = str.replace("%{CTitle}s", title);
        }
        String type = voucherNotiDisplayInfo.getType();
        if (!TextUtils.isEmpty(type)) {
            str = str.replace("%{CType}s", type);
        }
        String packagePrice = voucherNotiDisplayInfo.getPackagePrice();
        if (!TextUtils.isEmpty(packagePrice)) {
            str = str.replace("%{PackagePrice}s", packagePrice);
        }
        String packageCapacityStr = voucherNotiDisplayInfo.getPackageCapacityStr();
        if (!TextUtils.isEmpty(packageCapacityStr)) {
            str = str.replace("%{PackageCapacity}s", packageCapacityStr);
        }
        String pacageDuration = voucherNotiDisplayInfo.getPacageDuration();
        if (!TextUtils.isEmpty(pacageDuration)) {
            str = str.replace("%{PackageDuration}s", pacageDuration);
        }
        String firstMonthPackagePrice = voucherNotiDisplayInfo.getFirstMonthPackagePrice();
        if (!TextUtils.isEmpty(firstMonthPackagePrice)) {
            str = str.replace("%{FirstMonthPackagePrice}s", firstMonthPackagePrice);
        }
        String firstMonthPackageDuration = voucherNotiDisplayInfo.getFirstMonthPackageDuration();
        if (!TextUtils.isEmpty(firstMonthPackageDuration)) {
            str = str.replace("%{FirstMonthPackageDuration}s", firstMonthPackageDuration);
        }
        String everyMonthPackagePrice = voucherNotiDisplayInfo.getEveryMonthPackagePrice();
        return !TextUtils.isEmpty(everyMonthPackagePrice) ? str.replace("%{EveryMonthPackagePrice}s", everyMonthPackagePrice) : str;
    }

    public void sendAcceptFrontAppPrizeNotify(String str, String str2, Intent intent) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || intent == null) {
            NotifyLogger.m29914e(TAG, "sendAcceptFrontAppPrizeNotify param error");
            return;
        }
        if (this.mContext == null) {
            NotifyLogger.m29914e(TAG, "sendAcceptFrontAppPrizeNotify mContext is null");
            return;
        }
        try {
            NotifyLogger.m29915i(TAG, "sendAcceptFrontAppPrizeNotify");
            NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(false, "com.huawei.android.hicloud");
            notificationBuilder.m3823x(true);
            PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
            intent2.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
            C0209d.m1302r2(intent2, this.mContext.getPackageName());
            intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
            intent2.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "9");
            intent2.putExtra(HNConstants.C4906BI.NOTIFY_TITLE, str);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3839h(str2);
            notificationBuilder.m3825z(c0605b);
            Notification notificationM3804d = notificationBuilder.m3811l(str).m3810k(str2).m3809j(pendingIntentM1248e0).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
            notificationM3804d.flags = 65536 | 16;
            this.mManager.notify(377, notificationM3804d);
            notificationGroupDone(false);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "sendAcceptFrontAppPrizeNotify error. " + e10.toString());
        }
    }

    public void sendCBPNotification(Context context, CBPushContent cBPushContent, CBPushConfigObject cBPushConfigObject) throws JSONException {
        if (!C10028c.m62182c0().m62420y1()) {
            NotifyLogger.m29915i(TAG, "sendCBPNotification isEurope.");
            return;
        }
        Context context2 = this.mContext;
        if (context2 != null && C0209d.m1173G1(context2)) {
            NotifyLogger.m29915i(TAG, "sendCBPNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "sendCBPNotification, AppStatusAbnormal");
            return;
        }
        NotifyLogger.m29915i(TAG, "send CBPushNotification title=" + cBPushContent.getTitle() + ", content=" + cBPushContent.getSubTitle());
        if (context == null || this.mContext == null) {
            NotifyLogger.m29915i(TAG, "send CBPushNotification context null");
            return;
        }
        boolean zIsSilentNotifyTime = NotifyUtil.isSilentNotifyTime();
        reportCPBNotifyShow(context, cBPushConfigObject, zIsSilentNotifyTime);
        NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(zIsSilentNotifyTime, cBPushContent.getTitle());
        notificationBuilder.m3823x(true);
        String type = cBPushConfigObject.getmGoto().getType();
        String uri = cBPushConfigObject.getmGoto().getUri();
        if (!new HiCloudLink(this.mContext).checkModuleEnable(type, uri)) {
            NotifyLogger.m29915i(TAG, "link disable type=" + type + ", uri=" + uri);
            return;
        }
        Intent gotoIntent = NotifyUtil.getGotoIntent(this.mContext, type, uri);
        if (gotoIntent == null) {
            NotifyLogger.m29915i(TAG, "sendCBPNotification intent is null.");
            return;
        }
        gotoIntent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        gotoIntent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        gotoIntent.putExtra(HNConstants.C4906BI.DATA_TYPE_ID, "" + cBPushConfigObject.getId());
        gotoIntent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "1");
        gotoIntent.putExtra("channel_of_open_switch", "7");
        gotoIntent.putExtra("enterFrom", "0007");
        C13222a.m79470l(gotoIntent, "4");
        C13230i.m79525e1(gotoIntent, "4", "3");
        C0216g0.m1402e(context).m1408F(gotoIntent, "SOURCE_ID_CPB_NOTIFY");
        PendingIntent broadcast = (type.equals("application") && uri.equals(NotifyConstants.HICLOUD_GALLERY)) ? PendingIntent.getBroadcast(context, 10002, gotoIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : C0209d.m1248e0(context, 0, gotoIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(context, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "1");
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", context.getResources().getString(R$string.HiCloud_app_name));
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(cBPushContent.getSubTitle());
        notificationBuilder.m3825z(c0605b);
        this.mManager.notify(272, notificationBuilder.m3811l(cBPushContent.getTitle()).m3810k(cBPushContent.getSubTitle()).m3809j(broadcast).m3814o(broadcast2).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d());
        notificationGroupDone(zIsSilentNotifyTime);
    }

    public void sendCloudAlbumReleaseSpace(String str) {
        Context context = this.mContext;
        if (context == null) {
            NotifyLogger.m29914e(TAG, "sendCloudAlbumRelease context is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            NotifyLogger.m29915i(TAG, "sendCloudAlbumRelease, isPrivacyUser, exit Cloud!");
            return;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "sendCloudAlbumRelease, isAppStatusAbnormal");
            return;
        }
        try {
            NotifyLogger.m29915i(TAG, "sendCloudAlbumRelease");
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                NotifyLogger.m29914e(TAG, "sendCloudAlbumRelease hiCloudSysParamMap is null");
                return;
            }
            boolean zCheckSilentNotifyTimeWithDefault = NotifyUtil.checkSilentNotifyTimeWithDefault(hiCloudSysParamMapM60757p.getReleaseSpaceMuteBeginTime(), hiCloudSysParamMapM60757p.getReleaseSpaceMuteEndTime());
            NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(zCheckSilentNotifyTimeWithDefault, "com.huawei.android.hicloud");
            PendingIntent galleryMainPendingIntent = getGalleryMainPendingIntent();
            notificationBuilder.m3823x(true);
            Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
            intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
            C0209d.m1302r2(intent, this.mContext.getPackageName());
            intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
            intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
            PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
            Notification notificationM3804d = notificationBuilder.m3811l(this.mContext.getResources().getString(R$string.release_space_title)).m3825z(new NotificationCompat.C0605b()).m3810k(String.format(Locale.ENGLISH, this.mContext.getResources().getString(R$string.release_space_content), str)).m3809j(galleryMainPendingIntent).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
            notificationM3804d.flags = 65536 | 16;
            this.mManager.notify(297, notificationM3804d);
            notificationGroupDone(zCheckSilentNotifyTimeWithDefault);
            C10028c c10028cM62183d0 = C10028c.m62183d0(this.mContext);
            c10028cM62183d0.m62197C2(NotifyConstants.CloudAlbumReleaseSpace.POP_TIME, System.currentTimeMillis());
            c10028cM62183d0.m62362m3(NotifyConstants.CloudAlbumReleaseSpace.NOTICE_TIMES, c10028cM62183d0.m62414x0(NotifyConstants.CloudAlbumReleaseSpace.NOTICE_TIMES) + 1);
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put(NotifyConstants.CloudAlbumReleaseSpace.NOTICE_TIMES, 1);
            C13227f.m79492i1().m79567R(NotifyConstants.CloudAlbumReleaseSpace.POP_TYPE, linkedHashMapM79499C);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(NotifyConstants.CloudAlbumReleaseSpace.NOTICE_TIMES, String.valueOf(1));
            UBAAnalyze.m29958S("PVC", NotifyConstants.CloudAlbumReleaseSpace.POP_TYPE, "4", "14", linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "sendCloudAlbumRelease error. " + e10.getMessage());
        }
    }

    public void sendDataRecoveryNotify(int i10) throws Resources.NotFoundException {
        PendingIntent activity;
        if (this.mContext == null) {
            NotifyLogger.m29914e(TAG, "sendDataRecoveryNotify mContext is null");
            return;
        }
        try {
            NotifyLogger.m29915i(TAG, "sendDataRecoveryNotify");
            String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("data_has_restore_title");
            String spaceMultLanguage2 = SpaceMultLanguageUtil.getSpaceMultLanguage("data_has_restore_content");
            Resources resources = this.mContext.getResources();
            if (TextUtils.isEmpty(spaceMultLanguage)) {
                if (resources == null) {
                    NotifyLogger.m29914e(TAG, "sendDataRecoveryNotify fail resources is null");
                    return;
                }
                spaceMultLanguage = resources.getString(R$string.data_has_restore_title);
            }
            if (TextUtils.isEmpty(spaceMultLanguage2)) {
                if (resources == null) {
                    NotifyLogger.m29914e(TAG, "sendDataRecoveryNotify fail resources is null");
                    return;
                }
                spaceMultLanguage2 = resources.getString(R$string.data_has_restore_content, resources.getQuantityString(R$plurals.common_days, i10, Integer.valueOf(i10)));
            }
            NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(false, "com.huawei.android.hicloud");
            notificationBuilder.m3823x(true);
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null || TextUtils.isEmpty(hiCloudSysParamMapM60757p.getExtendDataUri())) {
                NotifyLogger.m29914e(TAG, "sendOpenFrontAppNotify ExtendDataUri is null");
                activity = null;
            } else {
                SafeIntent safeIntent = new SafeIntent(new Intent("android.intent.action.VIEW"));
                C0209d.m1302r2(safeIntent, this.mContext.getPackageName());
                safeIntent.setData(Uri.parse(hiCloudSysParamMapM60757p.getExtendDataUri()));
                safeIntent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                activity = PendingIntent.getActivity(this.mContext, 3, safeIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            }
            Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
            intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
            C0209d.m1302r2(intent, this.mContext.getPackageName());
            intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
            intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "11");
            intent.putExtra(HNConstants.C4906BI.NOTIFY_TITLE, spaceMultLanguage);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", resources.getString(R$string.HiCloud_app_name));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3839h(spaceMultLanguage);
            notificationBuilder.m3825z(c0605b);
            Notification notificationM3804d = notificationBuilder.m3811l(spaceMultLanguage).m3810k(spaceMultLanguage2).m3809j(activity).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
            notificationM3804d.flags = 65536 | 16;
            this.mManager.notify(384, notificationM3804d);
            notificationGroupDone(false);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "sendOpenFrontAppNotify error. " + e10.toString());
        }
    }

    public void sendFamilyShareEnableNotify(long j10) {
        CloudSpaceNotifyUtil.getInstance().sendFamilyShareEnableNotify(j10);
    }

    public void sendFamilyShareStopNotify(Context context) {
        CloudSpaceNotifyUtil.getInstance().sendFamilyShareStopNotify();
    }

    public void sendForcedUpgradeNotification(Context context, String str, String str2, NotifyJumpInfo notifyJumpInfo) {
        NotifyLogger.m29915i(TAG, "sendForcedUpgradeNotification");
        Context context2 = this.mContext;
        if (context2 == null) {
            NotifyLogger.m29914e(TAG, "sendForcedUpgradeNotification mContext is null");
            return;
        }
        if (C0209d.m1173G1(context2)) {
            NotifyLogger.m29915i(TAG, "sendForcedUpgradeNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        Intent intent = new Intent();
        if (TextUtils.equals(notifyJumpInfo.getNotifyType(), "web") && !TextUtils.isEmpty(notifyJumpInfo.getNotifyUri()) && (intent = GeneralRedirectUtil.getCommonGotoIntent("web", notifyJumpInfo.getNotifyUri(), true)) != null) {
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
        }
        if (TextUtils.isEmpty(notifyJumpInfo.getNotifyType()) || TextUtils.equals(notifyJumpInfo.getNotifyType(), RecommendCardConstants.Entrance.HOMEPAGE)) {
            intent.setAction(NotifyConstants.Action.ACTION_MAIN_ACTIVITY);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "6");
        }
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_FORCE_UPGRADE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent2.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent2, this.mContext.getPackageName());
        intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent2.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "6");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle = new Bundle();
        Resources resources = context.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1668i(context, str).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(context.getResources().getString(i10)).m3811l(str).m3810k(str2).m3809j(pendingIntentM1248e0).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        notificationGroupDone(false);
        this.mManager.notify(278, notificationM3804d);
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        c10028cM62183d0.m62197C2("upgrade_last_notice_time", System.currentTimeMillis());
        c10028cM62183d0.m62362m3("notice_times", c10028cM62183d0.m62414x0("notice_times") + 1);
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("notice_times", 1);
        linkedHashMapM79499C.put("forced_upgrade_type", Integer.valueOf(c10028cM62183d0.m62278U()));
        C13227f.m79492i1().m79567R("upgrade_notice_show", linkedHashMapM79499C);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("notice_times", String.valueOf(1));
        linkedHashMap.put("forced_upgrade_type", String.valueOf(c10028cM62183d0.m62278U()));
        UBAAnalyze.m29958S("PVC", "upgrade_notice_show", "4", "12", linkedHashMap);
    }

    public void sendOpenFrontAppNotify(String str, String str2, Intent intent) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || intent == null) {
            NotifyLogger.m29914e(TAG, "sendOpenFrontAppNotify param error");
            return;
        }
        if (this.mContext == null) {
            NotifyLogger.m29914e(TAG, "sendOpenFrontAppNotify mContext is null");
            return;
        }
        try {
            NotifyLogger.m29915i(TAG, "sendOpenFrontAppNotify");
            NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(false, "com.huawei.android.hicloud");
            notificationBuilder.m3823x(true);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
            intent2.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
            C0209d.m1302r2(intent2, this.mContext.getPackageName());
            intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
            intent2.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "10");
            intent2.putExtra(HNConstants.C4906BI.NOTIFY_TITLE, str);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(this.mContext, 1, intent2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3839h(str2);
            notificationBuilder.m3825z(c0605b);
            Notification notificationM3804d = notificationBuilder.m3811l(str).m3810k(str2).m3809j(broadcast).m3814o(broadcast2).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
            notificationM3804d.flags = 65536 | 16;
            this.mManager.notify(384, notificationM3804d);
            notificationGroupDone(false);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "sendOpenFrontAppNotify error. " + e10.toString());
        }
    }

    public void sendQuitOwnerFamilyShareNotify() {
        CloudSpaceNotifyUtil.getInstance().sendQuitOwnerFamilyShareNotify();
    }

    public void sendSiteChangedNotification() {
        CloudSpaceNotifyUtil.getInstance().sendSiteChangedNotification();
    }

    public void sendSiteOfflineNotification() {
        CloudSpaceNotifyUtil.getInstance().sendSiteOfflineNotification();
    }

    public void sendSpaceNotify(SpaceNotification spaceNotification, Long l10) {
        sendSpaceNotify(spaceNotification, l10.longValue(), -1L, 0L);
    }

    public void sendSpaceNotifyWithActivity(NotificationWithActivity notificationWithActivity, Long l10, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) {
        sendSpaceNotifyWithActivity(notificationWithActivity, l10, -1L, str, str2, z10, notifyAgdParameters);
    }

    public void sendSpaceUsedNotify(ExtraNotificationBean extraNotificationBean) {
        NotifyLogger.m29915i(TAG, "sendSpaceUsedNotify");
        PendingIntent spaceDetailLocalPendingIntent = getSpaceDetailLocalPendingIntent("MONTHLY_SPACE_CHECK_NOTIFY_CLICK", extraNotificationBean.getPercentage());
        PendingIntent spaceDetailCancelPendingIntent = getSpaceDetailCancelPendingIntent(extraNotificationBean.getPercentage());
        boolean z10 = true;
        PendingIntent extraNoticePendingIntent = NotifyUtil.getExtraNoticePendingIntent(this.mContext, extraNotificationBean, 1, 3, "MONTHLY_SPACE_CHECK_NOTIFY_CLICK");
        if (!NotifyUtil.isSilentNotifyTime() && !NotifyUtil.isSilentNotifyTime(extraNotificationBean)) {
            z10 = false;
        }
        boolean z11 = z10;
        reportSpaceUsedShow(extraNotificationBean, z11);
        showNotice(buildSpaceUsedNoticeData(extraNotificationBean, spaceDetailLocalPendingIntent, extraNoticePendingIntent, spaceDetailCancelPendingIntent), "com.huawei.android.hicloud", this.mContext.getResources().getString(R$string.HiCloud_app_name), 21, z11);
        CloudSpaceNotifyUtil.getInstance().recordSpaceUsedNoticeShow();
        NoticeFreqControlManager.getInstance().recordLevelNoticeShow(extraNotificationBean.getRemindPurposes(), "notification_bar");
    }

    public MsgUserData buildUserData(SpaceNotification spaceNotification, Long l10, Long l11, long j10) {
        if (spaceNotification == null) {
            return null;
        }
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setActivityNotify(false);
        msgUserData.setNotifyType(spaceNotification.getNoticeType());
        msgUserData.setTotalNeedSpace(l10.longValue());
        msgUserData.setCurrentPackageSpace(l11.longValue());
        msgUserData.setNotifyConfigId(spaceNotification.getId());
        msgUserData.setPackageEndTime(j10);
        return msgUserData;
    }

    public void notificationGroupDone(boolean z10, int i10, String str) {
        NotificationCompat.Builder builderM1670k;
        if (this.mManager.getActiveNotifications().length < 1) {
            return;
        }
        if (z10) {
            C0235t c0235tM1645e = C0235t.m1645e();
            Context context = this.mContext;
            builderM1670k = c0235tM1645e.m1649h(context, "com.huawei.android.hicloud", "2", context.getString(R$string.channel_backup_notification), i10, str);
        } else {
            builderM1670k = C0238w.m1663f().m1670k(this.mContext, "com.huawei.android.hicloud", i10, str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        builderM1670k.m3823x(true);
        this.mManager.notify(22, builderM1670k.m3824y(R$drawable.logo_about_system).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
        NotifyLogger.m29915i(TAG, "notificationGroupDone");
    }

    public void sendSpaceNotify(SpaceNotification spaceNotification, long j10, long j11, long j12) {
        if (spaceNotification == null) {
            NotifyLogger.m29915i(TAG, "sendSpaceNotify spaceNotification is null.");
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotify mContext is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            NotifyLogger.m29915i(TAG, "sendSpaceNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "sendSpaceNotify, AppStatusAbnormal");
            return;
        }
        try {
            NotifyLogger.m29915i(TAG, "sendSpaceNotify");
            boolean z10 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(spaceNotification);
            NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(z10, "com.huawei.android.hicloud");
            NoticeDisplayInfo noticeDisplayInfoBuildSpaceNoticeInfo = buildSpaceNoticeInfo(spaceNotification, Long.valueOf(j10), Long.valueOf(j11), j12);
            String noticeMainText = noticeDisplayInfoBuildSpaceNoticeInfo.getNoticeMainText();
            String noticeTitle = noticeDisplayInfoBuildSpaceNoticeInfo.getNoticeTitle();
            if (!TextUtils.isEmpty(noticeMainText) && !TextUtils.isEmpty(noticeTitle)) {
                if (spaceNotification.getTopupPackage() == 1) {
                    noticeTitle = C0229n.m1604c(noticeTitle, "Storage+", "fa");
                }
                reportCloudSpaceShow(spaceNotification, z10, noticeDisplayInfoBuildSpaceNoticeInfo.isVoucherNotice());
                Bundle bundle = new Bundle();
                addRecommendExtra(bundle, spaceNotification, getNotifyRecommendNeedData(spaceNotification, Long.valueOf(j10), Long.valueOf(j11)));
                addVoucherExtra(bundle, noticeDisplayInfoBuildSpaceNoticeInfo);
                PendingIntent spaceNotifyPendingIntent = getSpaceNotifyPendingIntent(spaceNotification, bundle, j10);
                if (spaceNotifyPendingIntent == null) {
                    NotifyLogger.m29914e(TAG, "sendSpaceNotify contentIntent is null.");
                    return;
                }
                notificationBuilder.m3823x(true);
                Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
                intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
                C0209d.m1302r2(intent, this.mContext.getPackageName());
                intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
                intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
                intent.putExtra(HNConstants.C4906BI.DATA_IS_VOUCHER_NOTICE, noticeDisplayInfoBuildSpaceNoticeInfo.isVoucherNotice());
                intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
                PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                Bundle bundle2 = new Bundle();
                bundle2.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
                NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
                c0605b.m3839h(noticeMainText);
                notificationBuilder.m3825z(c0605b);
                Notification notificationM3804d = notificationBuilder.m3811l(noticeTitle).m3810k(noticeMainText).m3809j(spaceNotifyPendingIntent).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle2).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
                notificationM3804d.flags = 65536 | 16;
                this.mManager.notify(265, notificationM3804d);
                notificationGroupDone(z10);
                if (noticeDisplayInfoBuildSpaceNoticeInfo.isVoucherNotice()) {
                    NotifyLogger.m29915i(TAG, "sendSpaceNotify record coupon notice frequency, noticeType = " + spaceNotification.getNoticeType() + ", noticeId = " + spaceNotification.getId());
                    CloudSpaceNotifyUtil.getInstance().recordSpaceNotifyCouponFrequency(spaceNotification);
                    return;
                }
                return;
            }
            NotifyLogger.m29914e(TAG, "sendSpaceNotify notice string null");
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotify error. " + e10.toString());
        }
    }

    public void sendSpaceNotifyWithActivity(NotificationWithActivity notificationWithActivity, Long l10, Long l11, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) {
        boolean z11;
        NotificationCompat.Builder notificationBuilder;
        NoticeContent noticeContentQueryNoticeContentForSpaceNotify;
        if (notificationWithActivity == null) {
            NotifyLogger.m29915i(TAG, "sendSpaceNotifyWithActivity spaceNotification is null.");
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotifyWithActivity mContext is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            NotifyLogger.m29915i(TAG, "sendSpaceNotifyWithActivity, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "sendSpaceNotifyWithActivity, AppStatusAbnormal");
            return;
        }
        try {
            NotifyLogger.m29915i(TAG, "sendSpaceNotifyWithActivity start , id = " + notificationWithActivity.getId());
            z11 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(notificationWithActivity);
            notificationBuilder = NotifyUtil.getNotificationBuilder(z11, "com.huawei.android.hicloud");
            NotifyUtil.reportCloudSpaceActivityShow(this.mContext, notificationWithActivity, z11);
            noticeContentQueryNoticeContentForSpaceNotify = NoticeWithActivityUtil.queryNoticeContentForSpaceNotify(notificationWithActivity);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotifyWithActivity error. " + e10.toString());
        }
        if (noticeContentQueryNoticeContentForSpaceNotify == null) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotifyWithActivity noticeContent null");
            return;
        }
        SpaceNoticeStrInfo spaceNoticeStrInfo = getSpaceNoticeStrInfo(z10, notificationWithActivity.getSpaceType(), str, noticeContentQueryNoticeContentForSpaceNotify);
        String contentTitle = spaceNoticeStrInfo.getContentTitle();
        String contentText = spaceNoticeStrInfo.getContentText();
        if (TextUtils.isEmpty(contentText) && TextUtils.isEmpty(contentTitle)) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotifyWithActivity contentTitle and contentText is null");
            return;
        }
        Bundle bundle = new Bundle();
        addActivityRecommendExtra(bundle, notificationWithActivity, getActivityRecommendNeedData(notificationWithActivity, l10, l11));
        addAgdParamExtra(bundle, notifyAgdParameters);
        PendingIntent spaceNotifyActivityPendingIntent = getSpaceNotifyActivityPendingIntent(notificationWithActivity, str2, bundle);
        if (spaceNotifyActivityPendingIntent == null) {
            NotifyLogger.m29914e(TAG, "sendSpaceNotifyWithActivity contentIntent is null.");
            return;
        }
        notificationBuilder.m3823x(true);
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("notify_id", notificationWithActivity.getId());
        bundle2.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle2);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle3 = new Bundle();
        bundle3.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(contentText);
        notificationBuilder.m3825z(c0605b);
        Notification notificationM3804d = notificationBuilder.m3811l(contentTitle).m3810k(contentText).m3809j(spaceNotifyActivityPendingIntent).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle3).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
        notificationM3804d.flags = 65536 | 16;
        this.mManager.notify(265, notificationM3804d);
        notificationGroupDone(z11);
        NotifyLogger.m29915i(TAG, "sendSpaceNotifyWithActivity end");
    }
}
