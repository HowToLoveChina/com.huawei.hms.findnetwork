package com.huawei.android.hicloud.p088ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.DataMigrationAuthActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncExternalActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.UpgradeIntroductionActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceMemberShareActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.PresentLog;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.bean.BackupNotEnoughNotifyStrInfo;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.checker.LevelFrequencyController;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.BackupBeforeNoticeManager;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.manager.NoticeShowNeedData;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NoticeWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.AbstractCheckAppStatus;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.R$drawable;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import il.C10542o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0235t;
import p015ak.C0238w;
import p020ap.C1006a;
import p054cj.C1442a;
import p336he.C10152c;
import p336he.C10155f;
import p336he.C10158i;
import p364ib.C10465b;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11296s;
import p459lp.C11327e;
import p514o9.C11829c;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p711vl.C13466f;
import p746wn.C13622a;
import p766x8.C13729h;
import p807yd.C13946b;
import p848zl.C14337f;
import tl.C13029h;
import to.C13049a;

/* loaded from: classes3.dex */
public class BackupNotificationManager {
    private static final int BACKUP_NOTIFICATION_REQUEST_CODE = 3;
    private static final long DEFAULT_BACKUP_SPACE = -1;
    private static final int FLAG_REMOVBLE = 65536;
    private static final int SPACE_COMPLIMENTARY = 2;
    private static final String TAG = "BackupNotificationManager";
    private Context mContext;
    private NotificationManager mManager;

    public static class SendCycleNotificationTask extends AbstractC12367d {
        private int days;
        private Context mContext;
        private NotificationManager mManager;
        private boolean showLocal;
        private List<PortraitAndGrade.UserTag> userTags;

        public SendCycleNotificationTask(Context context, boolean z10, int i10, List<PortraitAndGrade.UserTag> list, NotificationManager notificationManager) {
            this.mContext = context;
            this.showLocal = z10;
            this.days = i10;
            this.userTags = list;
            this.mManager = notificationManager;
        }

        private MsgUserData buildUserData(ExtraNotificationBean extraNotificationBean, boolean z10, int i10) {
            if (extraNotificationBean == null) {
                return null;
            }
            MsgUserData msgUserData = new MsgUserData();
            msgUserData.setNotifyType(extraNotificationBean.getNoticeType());
            msgUserData.setNotifyConfigId(extraNotificationBean.getId());
            msgUserData.setShowLocal(z10);
            msgUserData.setDays(i10);
            return msgUserData;
        }

        private void sendBackupCycleNotify(ExtraNotificationBean extraNotificationBean) throws Resources.NotFoundException {
            NoticeShowNeedData noticeShowNeedDataBuildBackupCycleNoticeData = BackupNotificationManager.buildBackupCycleNoticeData(extraNotificationBean, BackupNotificationManager.getBackupCycleLocalPendingIntent(this.mContext, ""), NotifyUtil.getExtraNoticePendingIntent(this.mContext, extraNotificationBean, 0, 10, null), this.days, this.showLocal, this.mContext);
            Resources resources = this.mContext.getResources();
            int i10 = R$plurals.backup_guide_tip_days;
            int i11 = this.days;
            String quantityString = resources.getQuantityString(i10, i11, Integer.valueOf(i11));
            Bundle bundle = new Bundle();
            String string = this.mContext.getResources().getString(R$string.HiCloud_app_name);
            bundle.putString("android.substName", string);
            boolean z10 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(extraNotificationBean);
            BackupNotificationManager.reportBackupCycleShow(extraNotificationBean, z10);
            NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(z10, string);
            notificationBuilder.m3807h(true);
            notificationBuilder.m3824y(R$drawable.logo_about_system);
            notificationBuilder.m3811l(noticeShowNeedDataBuildBackupCycleNoticeData.getTitleText()).m3810k(C0209d.m1303s(noticeShowNeedDataBuildBackupCycleNoticeData.getMainText(), quantityString)).m3809j(noticeShowNeedDataBuildBackupCycleNoticeData.getContentPendingIntent()).m3803c(bundle).m3825z(new NotificationCompat.C0605b()).m3818s(false).m3817r("com.huawei.android.hicloud.cloudbackup").m3800C(System.currentTimeMillis());
            Notification notificationM3804d = notificationBuilder.m3804d();
            NotificationManager notificationManager = this.mManager;
            if (notificationManager == null) {
                NotifyLogger.m29914e(BackupNotificationManager.TAG, " mManager is null ");
            } else {
                notificationManager.notify(24, notificationM3804d);
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Resources.NotFoundException, C9721b {
            ExtraNotificationBean next;
            C13729h c13729h = new C13729h();
            NotifyLogger.m29915i(BackupNotificationManager.TAG, " cycleNotification start ");
            if (this.mContext == null) {
                NotifyLogger.m29914e(BackupNotificationManager.TAG, "sendCycleNotification mContext is null");
                return;
            }
            List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.BACKUP_CYCLE, this.userTags);
            if (C0209d.m1205R0(extraNotificationBean)) {
                NotifyLogger.m29914e(BackupNotificationManager.TAG, " extraNotificationBeans is empty");
            } else {
                Iterator<ExtraNotificationBean> it = extraNotificationBean.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (c13729h.checkNotifyCondition(this.mContext.getApplicationContext(), next.getUnBackupDays())) {
                        break;
                    }
                }
            }
            next = null;
            if (next == null) {
                NotifyLogger.m29914e(BackupNotificationManager.TAG, " extraNotificationBean is null");
            }
            if (MessageCenterManager.getInstance().featureSwitch()) {
                if (!MessageCenterManager.getInstance().invokeEvent(next, C11327e.m68061d("HiCloudNoticeConfigAllInOne"), "HiCloudNoticeConfigAllInOne", buildUserData(next, this.showLocal, this.days))) {
                    NotifyLogger.m29916w(BackupNotificationManager.TAG, "invokeEvent fail, notice type: cloudbackup_days_notify");
                    return;
                }
            } else {
                List<String> remindPurposes = next != null ? next.getRemindPurposes() : null;
                if (!LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", remindPurposes, NotifyConstants.BACKUP_CYCLE})) {
                    NotifyLogger.m29916w(BackupNotificationManager.TAG, "level freq control check fail, notice type: cloudbackup_days_notify");
                    return;
                } else {
                    NoticeFreqControlManager.getInstance().recordLevelNoticeShow(remindPurposes, "notification_bar");
                    sendBackupCycleNotify(next);
                }
            }
            NotifyLogger.m29915i(BackupNotificationManager.TAG, " cycleNotification end ");
        }
    }

    public BackupNotificationManager(Context context) {
        if (context == null) {
            C11839m.m70687e(TAG, "BackupNotificationManager ctx is null");
        } else {
            this.mContext = context;
            this.mManager = (NotificationManager) context.getSystemService("notification");
        }
    }

    public static NoticeShowNeedData buildBackupCycleNoticeData(ExtraNotificationBean extraNotificationBean, PendingIntent pendingIntent, PendingIntent pendingIntent2, int i10, boolean z10, Context context) throws Resources.NotFoundException {
        NoticeShowNeedData noticeShowNeedData = new NoticeShowNeedData();
        String noticeExtraTitleText = ExtraNoticeConfigManager.getInstance().getNoticeExtraTitleText(extraNotificationBean);
        String noticeExtraMainText = ExtraNoticeConfigManager.getInstance().getNoticeExtraMainText(extraNotificationBean);
        if (z10 || pendingIntent2 == null || TextUtils.isEmpty(noticeExtraTitleText) || TextUtils.isEmpty(noticeExtraMainText)) {
            String string = context.getResources().getString(R$string.backup_not_complete_guide_notify_tip_content, context.getResources().getQuantityString(R$plurals.backup_guide_tip_days, i10, Integer.valueOf(i10)));
            noticeShowNeedData.setTitleText(context.getResources().getString(R$string.backup_not_complete_guide_notify_tip_title));
            noticeShowNeedData.setMainText(string);
            noticeShowNeedData.setContentPendingIntent(pendingIntent);
        } else {
            noticeShowNeedData.setTitleText(noticeExtraTitleText);
            noticeShowNeedData.setMainText(noticeExtraMainText);
            noticeShowNeedData.setContentPendingIntent(pendingIntent2);
        }
        return noticeShowNeedData;
    }

    private boolean checkConditionForNotEnough(C12295b c12295b) {
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify mContext is null");
            return false;
        }
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotify, isPrivacyUser, now exit Cloud!");
            return false;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotify, AppStatusAbnormal");
            return false;
        }
        if (c12295b != null) {
            return true;
        }
        C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify backupNoticeNeedInfo is null");
        return false;
    }

    private boolean checkConditionForNoticeActivity(C12295b c12295b) {
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotifyWithActivity mContext is null");
            return false;
        }
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotifyWithActivity, isPrivacyUser, now exit Cloud!");
            return false;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotifyWithActivity, AppStatusAbnormal");
            return false;
        }
        if (c12295b != null) {
            return true;
        }
        C11839m.m70687e(TAG, "sendSpaceNotEnoughNotifyWithActivity backupNoticeNeedInfo is null");
        return false;
    }

    private boolean checkData(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return false;
        }
        NotifyLogger.m29914e(TAG, "getActivityBackupPendingNeedIntent contentTitle and contentText and buttonFirst is null");
        return true;
    }

    private Intent getActivityBackupPendingNeedIntent(NotificationWithActivity notificationWithActivity, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, ActivityEntry activityEntry) {
        String str;
        boolean z10;
        if (backupSpaceNotEnoughNeedData == null || notificationWithActivity == null) {
            C11839m.m70689w(TAG, "getActivityBackupPendingNeedIntent backupSpaceNotEnoughNeedData is null.");
            return null;
        }
        C11839m.m70688i(TAG, "getActivityBackupPendingNeedIntent start, noticeType = " + notificationWithActivity.getNoticeType());
        long totalNeedSpace = backupSpaceNotEnoughNeedData.getTotalNeedSpace();
        long backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
        long notUsedSpace = backupSpaceNotEnoughNeedData.getNotUsedSpace();
        long galleryNum = backupSpaceNotEnoughNeedData.getGalleryNum();
        NoticeWithActivityGoto notiGoto = notificationWithActivity.getNotiGoto();
        if (notiGoto == null) {
            C11839m.m70689w(TAG, "getActivityBackupPendingNeedIntent noticegoto is null.");
            return null;
        }
        String notiType = notiGoto.getNotiType();
        String notiUri = notiGoto.getNotiUri();
        String deeplinkUri = notiGoto.getDeeplinkUri();
        if (TextUtils.isEmpty(notiType)) {
            C11839m.m70689w(TAG, "getActivityBackupPendingNeedIntent uriType is null.");
            return null;
        }
        Intent intentM75832b0 = C12590s0.m75807V0(deeplinkUri) ? C12590s0.m75832b0(deeplinkUri, null, true) : NotifyUtil.getGotoIntent(this.mContext, notiType, notiUri, activityEntry != null ? activityEntry.getUrl() : "");
        C13946b.m83729e().m83753a(intentM75832b0);
        if (intentM75832b0 == null) {
            C11839m.m70689w(TAG, "getActivityBackupPendingNeedIntent intent is null.");
            return null;
        }
        if ("detail".equals(notiType) || NotifyConstants.DETAIL2.equals(notiType) || NotifyConstants.DETAIL3.equals(notiType)) {
            NoticeDetail noticeDetailQueryBackupDetailNoticeContent = NoticeWithActivityUtil.queryBackupDetailNoticeContent(notificationWithActivity, false, notiType);
            if (noticeDetailQueryBackupDetailNoticeContent == null) {
                C11839m.m70688i(TAG, "getActivityBackupPendingNeedIntent noticeDetail is null.");
                return null;
            }
            RecommendNeedData recommendNeedData = new RecommendNeedData();
            int id2 = notificationWithActivity.getId();
            str = TAG;
            String stringUseLock = getStringUseLock(noticeDetailQueryBackupDetailNoticeContent.getTitle(), id2);
            Intent intent = intentM75832b0;
            String stringUseLock2 = getStringUseLock(noticeDetailQueryBackupDetailNoticeContent.getMainText(), id2);
            String stringUseLock3 = getStringUseLock(noticeDetailQueryBackupDetailNoticeContent.getButtonFirst(), id2);
            if (checkData(stringUseLock, stringUseLock2, stringUseLock3)) {
                return null;
            }
            recommendNeedData.setGalleryNum(galleryNum);
            if (galleryNum <= 0 || backupNeedSpace <= 0 || C2783d.m16105R()) {
                z10 = true;
                NoticeDetail noticeDetailQueryBackupDetailNoticeContent2 = NoticeWithActivityUtil.queryBackupDetailNoticeContent(notificationWithActivity, true, notiType);
                if (noticeDetailQueryBackupDetailNoticeContent2 != null) {
                    stringUseLock2 = getStringUseLock(noticeDetailQueryBackupDetailNoticeContent2.getMainText(), id2);
                }
            } else {
                z10 = true;
            }
            recommendNeedData.setIsFormWithActivity(z10);
            recommendNeedData.setActivityType(SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
            recommendNeedData.setBackupNeedSpace(backupNeedSpace);
            recommendNeedData.setNotUsedSpace(notUsedSpace);
            recommendNeedData.setRecommendType(notificationWithActivity.getNoticeType());
            recommendNeedData.setSubTitle(getStringUseLock(noticeDetailQueryBackupDetailNoticeContent.getSbuTitle(), id2));
            recommendNeedData.setSecondMainText(getStringUseLock(noticeDetailQueryBackupDetailNoticeContent.getMainTextSecond(), id2));
            recommendNeedData.setId(notificationWithActivity.getId());
            recommendNeedData.setTitle(stringUseLock);
            recommendNeedData.setMainText(stringUseLock2);
            recommendNeedData.setChooseOtherCaseText(stringUseLock3);
            recommendNeedData.setTotalNeedSpace(totalNeedSpace);
            recommendNeedData.setNotUsedSpace(notUsedSpace);
            intentM75832b0 = C10152c.m63231o(intent, notiType, notificationWithActivity, C10152c.m63219c(this.mContext) + 1);
            intentM75832b0.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        } else {
            str = TAG;
        }
        C13222a.m79470l(intentM75832b0, "4");
        C13230i.m79525e1(intentM75832b0, "4", "6");
        notifyBuildReportCollect(intentM75832b0, notificationWithActivity, notiGoto, "3");
        C11839m.m70688i(str, "getActivityBackupPendingNeedIntent end");
        return intentM75832b0;
    }

    private BackupNotEnoughNotifyStrInfo getBackupActivityNotifyStr(List<NotificationWithActivity> list, C12295b c12295b, boolean z10, NotificationWithActivity notificationWithActivity, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp) throws Resources.NotFoundException {
        String strReplaceVoucherPlaceholder;
        String strReplaceVoucherPlaceholder2;
        BackupNotEnoughNotifyStrInfo backupNotEnoughNotifyStrInfo = new BackupNotEnoughNotifyStrInfo();
        if (C10155f.m63287k(list)) {
            ActivityEntry activityEntryM73874b = c12295b.m73874b();
            if (activityEntryM73874b == null) {
                C11839m.m70687e(TAG, "getBackupActivityNotifyStr activityEntry is null");
                return backupNotEnoughNotifyStrInfo;
            }
            String resource = activityEntryM73874b.getResource();
            if (z10) {
                VoucherNotiDisplayInfo voucherNotiDisplayInfo = UserSpaceUtil.getVoucherNotiDisplayInfo(getPackagesBySpaceRuleResp);
                String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_NOTI_TITLE);
                String strFromDBByResource2 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_NOTI_MAIN_TEXT);
                HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(this.mContext);
                strReplaceVoucherPlaceholder = hiCloudNotificationManager.replaceVoucherPlaceholder(strFromDBByResource, voucherNotiDisplayInfo);
                strReplaceVoucherPlaceholder2 = hiCloudNotificationManager.replaceVoucherPlaceholder(strFromDBByResource2, voucherNotiDisplayInfo);
            } else {
                strReplaceVoucherPlaceholder = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_NOTI_TITLE);
                strReplaceVoucherPlaceholder2 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_NOTI_MAIN_TEXT);
            }
        } else if (z10) {
            NoticeContent noticeContentQueryBackupNotifiCouponContent = NoticeWithActivityUtil.queryBackupNotifiCouponContent(notificationWithActivity, false);
            if (noticeContentQueryBackupNotifiCouponContent == null) {
                C11839m.m70687e(TAG, "getBackupActivityNotifyStr noticeContent null");
                return backupNotEnoughNotifyStrInfo;
            }
            if (!SpaceNoticeV3Manager.getInstance().checkMultiLanguage(noticeContentQueryBackupNotifiCouponContent.getNotiTitle(), noticeContentQueryBackupNotifiCouponContent.getNotiMainText())) {
                C11839m.m70687e(TAG, "getBackupActivityNotifyStr checkMultiLanguage fail");
                return backupNotEnoughNotifyStrInfo;
            }
            VoucherNotiDisplayInfo voucherNotiDisplayInfo2 = UserSpaceUtil.getVoucherNotiDisplayInfo(getPackagesBySpaceRuleResp);
            String stringUseLock = getStringUseLock(noticeContentQueryBackupNotifiCouponContent.getNotiTitle(), notificationWithActivity.getId());
            String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContentQueryBackupNotifiCouponContent.getNotiMainText());
            HiCloudNotificationManager hiCloudNotificationManager2 = new HiCloudNotificationManager(this.mContext);
            strReplaceVoucherPlaceholder = hiCloudNotificationManager2.replaceVoucherPlaceholder(stringUseLock, voucherNotiDisplayInfo2);
            strReplaceVoucherPlaceholder2 = hiCloudNotificationManager2.replaceVoucherPlaceholder(stringUseLock2, voucherNotiDisplayInfo2);
        } else {
            NoticeContent noticeContentQueryBackupNotificationContent = NoticeWithActivityUtil.queryBackupNotificationContent(notificationWithActivity, false);
            if (noticeContentQueryBackupNotificationContent == null) {
                C11839m.m70687e(TAG, "getBackupActivityNotifyStr noticeContent null");
                return backupNotEnoughNotifyStrInfo;
            }
            if (!SpaceNoticeV3Manager.getInstance().checkMultiLanguage(noticeContentQueryBackupNotificationContent.getTitle(), noticeContentQueryBackupNotificationContent.getMainText())) {
                C11839m.m70687e(TAG, "getBackupActivityNotifyStr checkMultiLanguage fail");
                return backupNotEnoughNotifyStrInfo;
            }
            String stringUseLock3 = getStringUseLock(noticeContentQueryBackupNotificationContent.getTitle(), notificationWithActivity.getId());
            strReplaceVoucherPlaceholder2 = getStringUseLock(noticeContentQueryBackupNotificationContent.getMainText(), notificationWithActivity.getId());
            strReplaceVoucherPlaceholder = stringUseLock3;
        }
        backupNotEnoughNotifyStrInfo.setTitile(strReplaceVoucherPlaceholder);
        backupNotEnoughNotifyStrInfo.setMainText(strReplaceVoucherPlaceholder2);
        return backupNotEnoughNotifyStrInfo;
    }

    private static PendingIntent getBackupBeforeNoticePendingIntent(Context context, BackupBeforeNotice backupBeforeNotice, String str) {
        Intent noticeBeforeBackupIntent = getNoticeBeforeBackupIntent(context, backupBeforeNotice.getNoticeGoto().getNotifyType(), backupBeforeNotice.getNoticeGoto().getNotifyUri());
        if (noticeBeforeBackupIntent == null) {
            NotifyLogger.m29914e(TAG, "buildNotifyNeedData, intent is null");
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            noticeBeforeBackupIntent.putExtra("unique_id", str);
        }
        reportBackupBeforeShow(backupBeforeNotice);
        return C0209d.m1248e0(context, 0, noticeBeforeBackupIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    public static PendingIntent getBackupCycleLocalPendingIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BackupMainActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("unique_id", str);
        }
        C13230i.m79525e1(intent, "4", "11");
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "1");
        intent.putExtra("scene_id", NotifyUtil.getReportSceneId(NotifyConstants.BACKUP_CYCLE));
        C13222a.m79471m(intent, 10);
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_BACKUP_CYCLE_LOCAL_NOTIFY");
        return C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private PendingIntent getBackupNotEnoughPendingActivityIntent(NotificationWithActivity notificationWithActivity, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, boolean z10, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp, ActivityEntry activityEntry) {
        Intent activityBackupPendingNeedIntent = getActivityBackupPendingNeedIntent(notificationWithActivity, backupSpaceNotEnoughNeedData, activityEntry);
        if (z10) {
            if (getPackagesBySpaceRuleResp == null) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingActivityIntent recommendInfo is null.");
                return null;
            }
            List<PackageGrades> packageGrades = getPackagesBySpaceRuleResp.getPackageGrades();
            if (C0209d.m1205R0(packageGrades)) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingActivityIntent packageGradesList is null or empty.");
                return null;
            }
            List<CloudPackage> spacePackages = getPackagesBySpaceRuleResp.getSpacePackages();
            if (C0209d.m1205R0(spacePackages)) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingActivityIntent cloudPackageList is null or empty.");
                return null;
            }
            PackageGrades packageGrades2 = packageGrades.get(0);
            CloudPackage cloudPackage = spacePackages.get(0);
            activityBackupPendingNeedIntent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, true);
            activityBackupPendingNeedIntent.putExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, packageGrades2.getGradeCode());
            activityBackupPendingNeedIntent.putExtra(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, packageGrades2.getCapacity());
            activityBackupPendingNeedIntent.putExtra(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, cloudPackage.getId());
        }
        C13222a.m79471m(activityBackupPendingNeedIntent, 4);
        if (activityBackupPendingNeedIntent == null) {
            C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent getPendingNeedIntent is null.");
            return null;
        }
        C0216g0.m1402e(this.mContext).m1408F(activityBackupPendingNeedIntent, notificationWithActivity.getNoticeType() + "_" + notificationWithActivity.getId());
        return getPendingActivityIntent(notificationWithActivity, false, activityBackupPendingNeedIntent, 3);
    }

    private PendingIntent getBackupNotEnoughPendingIntent(SpaceNotification spaceNotification, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, boolean z10, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp, boolean z11) {
        FamilyShareInfoResult familyShareInfoResult;
        boolean zM64302l;
        Intent pendingNeedIntent;
        if (C11829c.m70626w0()) {
            try {
                familyShareInfoResult = (FamilyShareInfoResult) C12540b1.m75483a(new C13049a(EnumC12999a.CLOUD_MORE, null).m78730c0(), FamilyShareInfoResult.class);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent error : " + e10.toString());
                familyShareInfoResult = null;
            }
            if (familyShareInfoResult == null) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent familyShareInfoResult is null.");
                return null;
            }
            zM64302l = C10465b.m64302l(familyShareInfoResult);
        } else {
            zM64302l = false;
        }
        if (zM64302l) {
            pendingNeedIntent = getMemberBackupNotifyIntent(spaceNotification);
            if (pendingNeedIntent == null) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent getPendingNeedIntent is null.");
                return null;
            }
        } else {
            pendingNeedIntent = getPendingNeedIntent(spaceNotification, backupSpaceNotEnoughNeedData);
            if (pendingNeedIntent == null) {
                C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent getPendingNeedIntent is null.");
                return null;
            }
            if (z10) {
                if (getPackagesBySpaceRuleResp == null) {
                    C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent recommendInfo is null.");
                    return null;
                }
                List<PackageGrades> packageGrades = getPackagesBySpaceRuleResp.getPackageGrades();
                if (C0209d.m1205R0(packageGrades)) {
                    C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent packageGradesList is null or empty.");
                    return null;
                }
                List<CloudPackage> spacePackages = getPackagesBySpaceRuleResp.getSpacePackages();
                if (C0209d.m1205R0(spacePackages)) {
                    C11839m.m70687e(TAG, "getBackupNotEnoughPendingIntent cloudPackageList is null or empty.");
                    return null;
                }
                PackageGrades packageGrades2 = packageGrades.get(0);
                CloudPackage cloudPackage = spacePackages.get(0);
                pendingNeedIntent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, true);
                pendingNeedIntent.putExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, packageGrades2.getGradeCode());
                pendingNeedIntent.putExtra(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, packageGrades2.getCapacity());
                pendingNeedIntent.putExtra(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, cloudPackage.getId());
            }
        }
        pendingNeedIntent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        pendingNeedIntent.putExtra("scene_id", "auto_backup_failed_notify_click_record");
        pendingNeedIntent.putExtra("is_auto_backup", String.valueOf(z11));
        C13222a.m79471m(pendingNeedIntent, 4);
        C0216g0.m1402e(this.mContext).m1408F(pendingNeedIntent, spaceNotification.getNoticeType() + "_" + spaceNotification.getId());
        return getPendingIntent(spaceNotification, zM64302l, pendingNeedIntent, 3);
    }

    private String getMainTextLanguageId(BackupBeforeNotice backupBeforeNotice) {
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        return BackupAppEstimateUtil.isSpaceEnoughForBackup(quotaSpaceInfoM80224M.getAvailable(), quotaSpaceInfoM80224M.getTotal(), C12590s0.m75794S(), 0L) ? backupBeforeNotice.getText() : backupBeforeNotice.getSpaceLess();
    }

    private Intent getMemberBackupNotifyIntent(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            C11839m.m70687e(TAG, "getBackupNotifyIntent spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeContentDetailMember = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailMember(spaceNotification);
        if (noticeContentDetailMember == null) {
            C11839m.m70687e(TAG, "getBackupNotifyIntent noticeContent is null.");
            return null;
        }
        int id2 = spaceNotification.getId();
        MemberShareDetail memberShareDetail = new MemberShareDetail();
        memberShareDetail.setTitle(getStringUseLock(noticeContentDetailMember.getTitle(), id2));
        memberShareDetail.setMainText(getStringUseLock(noticeContentDetailMember.getMainText(), id2));
        memberShareDetail.setButtonText(getStringUseLock(noticeContentDetailMember.getButtonFirst(), id2));
        memberShareDetail.setNotifyType(spaceNotification.getNoticeType());
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudSpaceMemberShareActivity.class);
        intent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail);
        return intent;
    }

    private static Intent getNoticeBeforeBackupIntent(Context context, String str, String str2) {
        if (str.hashCode() == 117588) {
            str.equals("web");
        }
        return getNoticeBeforeBackupWebViewIntent(context, str2);
    }

    public static Intent getNoticeBeforeBackupWebViewIntent(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.NOTICE_BEFORE_BACKUP_WEBVIEW_ACTION);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra("is_support_orientation", true);
        intent.putExtra("srcChannel", "0");
        intent.putExtra("salChannel", "0");
        intent.putExtra("url", str);
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra("title", context.getString(R$string.HiCloud_app_name));
        intent.putExtra("isEnableJs", true);
        intent.putExtra("scene_id", "backup_before_notify_record");
        intent.putExtra("is_support_orientation", true);
        intent.putExtra("is_support_dark_mode", true);
        return intent.resolveActivity(context.getPackageManager()) == null ? NotifyUtil.getBrowserIntent(str) : new HiCloudSafeIntent(intent);
    }

    private PendingIntent getPendingActivityIntent(NotificationWithActivity notificationWithActivity, boolean z10, Intent intent, int i10) {
        NoticeWithActivityGoto notiGoto = notificationWithActivity.getNotiGoto();
        String notiType = notiGoto.getNotiType();
        String notiUri = notiGoto.getNotiUri();
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        return (z10 || TextUtils.isEmpty(notiType) || TextUtils.isEmpty(notiUri) || !notiType.equals("application") || !notiUri.equals(NotifyConstants.HICLOUD_GALLERY) || C12590s0.m75807V0(notiGoto.getDeeplinkUri())) ? C0209d.m1248e0(this.mContext, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : PendingIntent.getBroadcast(this.mContext, 10002, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private PendingIntent getPendingIntent(SpaceNotification spaceNotification, boolean z10, Intent intent, int i10) {
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        String notiType = noticeGoto.getNotiType();
        String notiUri = noticeGoto.getNotiUri();
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
        return (z10 || TextUtils.isEmpty(notiType) || TextUtils.isEmpty(notiUri) || !notiType.equals("application") || !notiUri.equals(NotifyConstants.HICLOUD_GALLERY) || C12590s0.m75807V0(noticeGoto.getNotiDeeplink())) ? C0209d.m1248e0(this.mContext, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : PendingIntent.getBroadcast(this.mContext, 10002, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private Intent getPendingNeedIntent(SpaceNotification spaceNotification, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        return getPendingNeedIntent(spaceNotification, Long.valueOf(backupSpaceNotEnoughNeedData.getTotalNeedSpace()), -1L, Long.valueOf(backupSpaceNotEnoughNeedData.getBackupNeedSpace()), Long.valueOf(backupSpaceNotEnoughNeedData.getNotUsedSpace()), Long.valueOf(backupSpaceNotEnoughNeedData.getGalleryNum()));
    }

    private String getStringUseLock(String str, int i10) {
        if (SpaceInsuffNoticeV4Manager.getInstance().checkMultiLanguage(i10, str)) {
            return SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(str, i10);
        }
        if (SpaceNoticeV3Manager.getInstance().checkMultiLanguage(str)) {
            return SpaceNoticeV3Manager.getInstance().getStringUseLock(str);
        }
        NotifyLogger.m29914e(TAG, "prepareSpaceNotEnoughDialog checkMultiLanguage failed");
        return null;
    }

    private boolean isCanShowCouponInfo(Context context, boolean z10, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp, int i10) {
        if (getPackagesBySpaceRuleResp == null) {
            C11839m.m70687e(TAG, "isCanShowCouponInfo recommendInfo is null.");
            return false;
        }
        List<Voucher> voucherList = getPackagesBySpaceRuleResp.getVoucherList();
        return z10 && C11296s.m67787K() && C11296s.m67789M(context) && voucherList != null && !voucherList.isEmpty() && i10 == 1;
    }

    private void notificationGroupDone(boolean z10) {
        notificationGroupDone(z10, 3, "reminder");
    }

    private void notificationProgressGroupDone(boolean z10) {
        notificationGroupDone(z10, 3, VastAttribute.PROGRESS);
    }

    private void notifyBuildReportCollect(Intent intent, NotificationWithActivity notificationWithActivity, NoticeWithActivityGoto noticeWithActivityGoto, String str) {
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, str);
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        intent.putExtra(HNConstants.C4906BI.DATA_TYPE_ID, "" + notificationWithActivity.getId());
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra("scene_id", NotifyUtil.getReportSceneId(notificationWithActivity.getNoticeType()));
        Bundle bundle = new Bundle();
        String notiType = (TextUtils.equals("detail", noticeWithActivityGoto.getNotiType()) || TextUtils.equals("close", noticeWithActivityGoto.getNotiType())) ? noticeWithActivityGoto.getNotiType() : noticeWithActivityGoto.getNotiUri();
        bundle.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
        bundle.putString(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, notiType);
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle);
    }

    private PendingIntent prepareActivityCancelPendingIntent(NotificationWithActivity notificationWithActivity) {
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        Bundle bundle = new Bundle();
        bundle.putInt("notify_id", notificationWithActivity.getId());
        bundle.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        intent.putExtra("user_tags_key", C13622a.m81963i());
        return PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
    }

    private PendingIntent prepareCancelPendingIntent(SpaceNotification spaceNotification) {
        Intent intent = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent, this.mContext.getPackageName());
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, spaceNotification.getPercentage());
        return PendingIntent.getBroadcast(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
    }

    private String prepareContentText(String str) throws Resources.NotFoundException {
        String quantityString;
        long jM16190y = C2783d.m16190y();
        Resources resources = this.mContext.getResources();
        if (resources != null) {
            int i10 = (int) jM16190y;
            quantityString = resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10));
        } else {
            quantityString = "0";
        }
        return C10465b.m64293c(str, quantityString);
    }

    private void prepareReportInfoForActivity(LinkedHashMap linkedHashMap, NotificationWithActivity notificationWithActivity, boolean z10, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp) {
        RecommendVouchers recommendVouchersM67840x;
        linkedHashMap.put("type", Integer.valueOf(notificationWithActivity.getId()));
        linkedHashMap.put("enableNewCard", Integer.valueOf(notificationWithActivity.getEnableNewCard()));
        linkedHashMap.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(notificationWithActivity.getActivityType()));
        linkedHashMap.put("voucher_notice", Boolean.valueOf(z10));
        if (!z10 || (recommendVouchersM67840x = C11296s.m67840x(getPackagesBySpaceRuleResp)) == null) {
            return;
        }
        linkedHashMap.put("voucher_id_list", C11296s.m67801Y(recommendVouchersM67840x.getVoucherList()));
    }

    private void prepareReportInfoForBackup(LinkedHashMap linkedHashMap, boolean z10, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp) {
        RecommendVouchers recommendVouchersM67840x;
        linkedHashMap.put("voucher_notice", Boolean.valueOf(z10));
        if (!z10 || (recommendVouchersM67840x = C11296s.m67840x(getPackagesBySpaceRuleResp)) == null) {
            return;
        }
        linkedHashMap.put("voucher_id_list", C11296s.m67801Y(recommendVouchersM67840x.getVoucherList()));
    }

    private static void queryBakSizeData() throws InterruptedException {
        CloudBackupUserInfo cloudBackupUserInfoM64691s1;
        C11839m.m70688i(TAG, "queryBakSizeData start.");
        try {
            cloudBackupUserInfoM64691s1 = new C10542o().m64691s1();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "queryBakSizeData,  queryLastRecordDetails e : " + e10.getMessage());
            cloudBackupUserInfoM64691s1 = null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false, cloudBackupUserInfoM64691s1, countDownLatch));
        try {
            C11839m.m70688i(TAG, "queryBakSizeData wait:" + countDownLatch.await(20000L, TimeUnit.MILLISECONDS));
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "queryBakSizeData Exception:" + e11.getMessage());
        }
    }

    private void recordCouponShowTime() {
        C0212e0.m1370t(this.mContext, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.BACKUP_COUPON_SHOW_TIME, System.currentTimeMillis());
    }

    private void reportActivitySpaceNotEnoughDialogShow(NotificationWithActivity notificationWithActivity, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp, boolean z10) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(notificationWithActivity.getPercentage()));
        prepareReportInfoForActivity(linkedHashMapM79499C, notificationWithActivity, z10, getPackagesBySpaceRuleResp);
        linkedHashMapM79499C.put("recommend_space_needed", Long.valueOf(backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
        NoticeWithActivityGoto notiGoto = notificationWithActivity.getNotiGoto();
        if (C12590s0.m75807V0(notiGoto != null ? notiGoto.getDeeplinkUri() : "")) {
            linkedHashMapM79499C.put("gotoDeeplink", notiGoto.getDeeplinkUri());
        }
        C13225d.m79490f1().m79591l0("mecloud_notify_cloudspace_not_enough_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_not_enough_show", "4", "9", linkedHashMapM79499C);
    }

    private static void reportAutoBackupFailNotifyEvent(boolean z10, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("notify_type", "1");
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        linkedHashMapM79497A.put("err_code", String.valueOf(i10));
        C13225d.m79490f1().m79591l0("auto_backup_failed_notify_record", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "auto_backup_failed_notify_record", "4", "88", linkedHashMapM79497A);
    }

    private static void reportBackupBeforeShow(BackupBeforeNotice backupBeforeNotice) {
        String strValueOf;
        float percentage;
        String strValueOf2;
        if (backupBeforeNotice != null) {
            strValueOf = String.valueOf(backupBeforeNotice.getId());
            strValueOf2 = String.valueOf(backupBeforeNotice.getNoticeGoto().getNotifyType());
            percentage = backupBeforeNotice.getPercentage();
        } else {
            strValueOf = "";
            percentage = 0.0f;
            strValueOf2 = "";
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            C11839m.m70687e(TAG, "spaceProxy is null");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("needBackupSize", String.valueOf(spaceProxy.getNeedBackupSize()));
        linkedHashMapM79497A.put("availableSize", String.valueOf(spaceProxy.getAvailableSize()));
        linkedHashMapM79497A.put("usedSize", String.valueOf(spaceProxy.getUsedSize()));
        linkedHashMapM79497A.put("userTags", spaceProxy.getUserTagList("reportBackupBeforeShow").toString());
        linkedHashMapM79497A.put("gradeCode", spaceProxy.getCurrentGradeCode("reportBackupBeforeShow"));
        linkedHashMapM79497A.put("notify_id", strValueOf);
        linkedHashMapM79497A.put("notify_type", strValueOf2);
        linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(percentage));
        reportOMEvent(linkedHashMapM79497A);
        C13225d.m79490f1().m79591l0("action_code_backup_before_nofity", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_backup_before_nofity", "4", "80", linkedHashMapM79497A);
    }

    public static void reportBackupCycleShow(ExtraNotificationBean extraNotificationBean, boolean z10) {
        String strValueOf;
        float percentage;
        String strValueOf2;
        if (extraNotificationBean != null) {
            strValueOf = String.valueOf(extraNotificationBean.getId());
            strValueOf2 = String.valueOf(extraNotificationBean.getNoticeType());
            percentage = extraNotificationBean.getPercentage();
        } else {
            strValueOf = "";
            percentage = 0.0f;
            strValueOf2 = "";
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("notify_id", strValueOf);
        linkedHashMapM79497A.put("notify_type", strValueOf2);
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(percentage));
        C13225d.m79490f1().m79591l0("mecloud_notify_backup_cycle_show", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_backup_cycle_show", "4", "6", linkedHashMapM79497A);
    }

    private static void reportOMEvent(LinkedHashMap linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02311"), "noticeBeforeBackupShow", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    private void reportSpaceNotEnoughDialogShow(SpaceNotification spaceNotification, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, boolean z10, GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp, boolean z11) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(spaceNotification.getPercentage()));
        linkedHashMapM79499C.put("enableNewCard", Integer.valueOf(spaceNotification.getEnableNewCard()));
        linkedHashMapM79499C.put("type", Integer.valueOf(spaceNotification.getId()));
        prepareReportInfoForBackup(linkedHashMapM79499C, z11, getPackagesBySpaceRuleResp);
        linkedHashMapM79499C.put("recommend_space_needed", Long.valueOf(backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(z10));
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        if (noticeGoto != null && C12590s0.m75807V0(noticeGoto.getNotiDeeplink())) {
            linkedHashMapM79499C.put("gotoDeeplink", noticeGoto.getNotiDeeplink());
        }
        C13225d.m79490f1().m79591l0("mecloud_notify_cloudspace_not_enough_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_not_enough_show", "4", "9", linkedHashMapM79499C);
    }

    public NotifyNeedData buildBackupBeforeNoticeNotifyNeedData(MsgUserData msgUserData, String str) throws InterruptedException {
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        BackupBeforeNotice backupBeforeNotice = BackupBeforeNoticeManager.getInstance().getBackupBeforeNotice(msgUserData.getNotifyConfigId());
        if (backupBeforeNotice == null) {
            return notifyNeedData;
        }
        queryBakSizeData();
        PendingIntent backupBeforeNoticePendingIntent = getBackupBeforeNoticePendingIntent(this.mContext, backupBeforeNotice, str);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        notifyNeedData.setTitleText(BackupBeforeNoticeManager.getInstance().getExtraNoticeLanguage(backupBeforeNotice.getTitle()));
        notifyNeedData.setMainText(BackupBeforeNoticeManager.getInstance().getExtraNoticeLanguage(getMainTextLanguageId(backupBeforeNotice)));
        notifyNeedData.setContentIntent(backupBeforeNoticePendingIntent);
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle);
        notifyNeedData.setNeedGroup(false);
        notifyNeedData.setResourceInfo(backupBeforeNotice.getId());
        notifyNeedData.setNoticeType(backupBeforeNotice.getNoticeGoto().getNotifyType());
        notifyNeedData.setId(308);
        return notifyNeedData;
    }

    public NotifyNeedData buildBackupCycleNotifyNeedData(ExtraNotificationBean extraNotificationBean, boolean z10, int i10, String str) throws Resources.NotFoundException {
        NoticeShowNeedData noticeShowNeedDataBuildBackupCycleNoticeData = buildBackupCycleNoticeData(extraNotificationBean, getBackupCycleLocalPendingIntent(this.mContext, str), NotifyUtil.getExtraNoticePendingIntent(this.mContext, extraNotificationBean, 0, 10, null, str), i10, z10, this.mContext);
        String quantityString = this.mContext.getResources().getQuantityString(R$plurals.backup_guide_tip_days, i10, Integer.valueOf(i10));
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        boolean z11 = NotifyUtil.isSilentNotifyTime() || NotifyUtil.isSilentNotifyTime(extraNotificationBean);
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        notifyNeedData.setSilent(z11);
        notifyNeedData.setTitleText(noticeShowNeedDataBuildBackupCycleNoticeData.getTitleText());
        notifyNeedData.setMainText(C0209d.m1303s(noticeShowNeedDataBuildBackupCycleNoticeData.getMainText(), quantityString));
        notifyNeedData.setContentIntent(noticeShowNeedDataBuildBackupCycleNoticeData.getContentPendingIntent());
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud.cloudbackup");
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setId(24);
        notifyNeedData.setNeedGroup(false);
        notifyNeedData.setResourceInfo(String.valueOf(extraNotificationBean.getId()));
        notifyNeedData.setNoticeType(extraNotificationBean.getNoticeType());
        return notifyNeedData;
    }

    public void cancelHonorUpGuideNotification() {
        cancelNotification(777);
        C10158i.m63323g();
    }

    public void cancelNotification(int i10) {
        boolean z10;
        boolean z11;
        C11839m.m70688i(TAG, "cancelNotification, id = " + i10);
        NotificationManager notificationManager = this.mManager;
        if (notificationManager != null) {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            int i11 = 0;
            if (activeNotifications == null || activeNotifications.length <= 0) {
                z10 = false;
                z11 = false;
            } else {
                z10 = false;
                z11 = false;
                int i12 = 0;
                while (i11 < activeNotifications.length) {
                    if (activeNotifications[i11].getNotification() == null) {
                        C11839m.m70688i(TAG, "notification is null");
                    } else if (activeNotifications[i11].getNotification().getGroup() == null) {
                        C11839m.m70688i(TAG, "Notification group is null");
                    } else if ("com.huawei.android.hicloud".equals(activeNotifications[i11].getNotification().getGroup())) {
                        i12++;
                        if (activeNotifications[i11].getId() == 22) {
                            z10 = true;
                        }
                        if (activeNotifications[i11].getId() == i10) {
                            z11 = true;
                        }
                    }
                    i11++;
                }
                i11 = i12;
            }
            this.mManager.cancel(i10);
            if (activeNotifications != null && i11 == 2 && z10 && z11) {
                C11839m.m70688i(TAG, "cancel all notification");
                this.mManager.cancel(22);
            }
        }
    }

    public void cancelNotify(int i10) {
        int i11;
        boolean z10;
        StatusBarNotification[] activeNotifications = this.mManager.getActiveNotifications();
        boolean z11 = false;
        if (activeNotifications.length <= 0) {
            NotifyLogger.m29915i(TAG, "notifications is null");
            i11 = 0;
            z10 = false;
        } else {
            boolean z12 = false;
            i11 = 0;
            z10 = false;
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification.getNotification() == null) {
                    NotifyLogger.m29915i(TAG, "notification is null");
                } else {
                    String group = statusBarNotification.getNotification().getGroup();
                    if (group == null) {
                        NotifyLogger.m29915i(TAG, "Notification group is null");
                    } else if ("com.huawei.android.hicloud".equals(group)) {
                        i11++;
                        if (statusBarNotification.getId() == 22) {
                            z10 = true;
                        }
                        if (statusBarNotification.getId() == i10) {
                            z12 = true;
                        }
                    }
                }
            }
            z11 = z12;
        }
        NotifyLogger.m29915i(TAG, "cancelNotify needCancel is " + z11 + ", notifyId" + i10);
        if (z11) {
            this.mManager.cancel(i10);
            NotifyLogger.m29915i(TAG, "cancelNotify hiCloudNotiCount is " + i11 + ", containGroupID is " + z10);
            if (i11 == 2 && z10) {
                this.mManager.cancel(22);
            }
        }
    }

    public void cancelSpaceNotEnoughNotify() {
        Context context = this.mContext;
        if (context != null && C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "cancelSpaceNotEnoughNotify, isPrivacyUser, now exit Cloud!");
        } else {
            cancelNotification(273);
            cancelNotify(775);
        }
    }

    public void clearSummaryNotification() {
        StatusBarNotification statusBarNotification;
        StatusBarNotification[] activeNotifications = this.mManager.getActiveNotifications();
        if (activeNotifications.length == 1 && (statusBarNotification = activeNotifications[0]) != null && statusBarNotification.getId() == 22) {
            this.mManager.cancel(22);
        }
    }

    public void saveBackupFailBeNotifyTime() {
        Double d10;
        List listM81076c = C13466f.m81073d().m81076c(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE);
        if (listM81076c == null || listM81076c.isEmpty() || (d10 = (Double) listM81076c.get(listM81076c.size() - 1)) == null) {
            return;
        }
        C13466f.m81073d().m81083k("key_backup_failed_record_time", d10.longValue());
    }

    public void sendAutoBackupFailNotify(int i10) {
        Integer num;
        NotificationCompat.Builder builderM1669j;
        C13029h c13029hM75886o2;
        Context contextM1377a = C0213f.m1377a();
        if (this.mManager == null || contextM1377a == null || (num = C14337f.m85499b().get(Integer.valueOf(i10))) == null) {
            return;
        }
        long jM78438D = (1007 != i10 || (c13029hM75886o2 = C12590s0.m75886o2()) == null) ? 100000000L : c13029hM75886o2.m78438D();
        String string = contextM1377a.getString(R$string.cloud_backup_failed_notification_title);
        String str = String.format(contextM1377a.getString(num.intValue()), C0223k.m1525h(contextM1377a, jM78438D, 1000));
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i11 = com.huawei.hicloud.router.R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i11));
        boolean zIsSilentNotifyTime = NotifyUtil.isSilentNotifyTime();
        if (zIsSilentNotifyTime) {
            C0235t c0235tM1645e = C0235t.m1645e();
            Context context = this.mContext;
            builderM1669j = c0235tM1645e.m1648g(context, string, "2", context.getString(R$string.channel_backup_notification));
        } else {
            builderM1669j = C0238w.m1663f().m1669j(this.mContext, string);
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        hiCloudSafeIntent.setClass(contextM1377a, BackupMainActivity.class);
        hiCloudSafeIntent.putExtra("scene_id", "auto_backup_failed_env_not_satisfied_notify_click_record");
        hiCloudSafeIntent.putExtra("is_silent_noti", String.valueOf(zIsSilentNotifyTime));
        hiCloudSafeIntent.putExtra("err_code", String.valueOf(i10));
        hiCloudSafeIntent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        this.mManager.notify(27, builderM1669j.m3824y(R$drawable.logo_about_system).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i11)).m3811l(string).m3810k(str).m3809j(C0209d.m1248e0(contextM1377a, 0, hiCloudSafeIntent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK)).m3815p(bundle).m3817r("com.huawei.android.hicloud.cloudbackup").m3823x(true).m3800C(System.currentTimeMillis()).m3807h(true).m3804d());
        reportAutoBackupFailNotifyEvent(zIsSilentNotifyTime, i10);
        saveBackupFailBeNotifyTime();
    }

    public void sendComplimentaryPackageNotify(PresentLog presentLog) {
        C11839m.m70688i(TAG, "sendComplimentaryPackageNotify");
        if (presentLog == null) {
            C11839m.m70687e(TAG, "sendComplimentaryPackageNotify presentLog is null.");
            return;
        }
        if (presentLog.getGrade() == null) {
            C11839m.m70687e(TAG, "sendComplimentaryPackageNotify memGradeRights is null.");
            return;
        }
        String presentNickName = presentLog.getPresentNickName();
        if (TextUtils.isEmpty(presentNickName)) {
            C1442a.m8289e(TAG, "sendComplimentaryPackageNotify nickname is invalid.");
            return;
        }
        String productName = presentLog.getProductName();
        if (TextUtils.isEmpty(productName)) {
            C1442a.m8289e(TAG, "sendComplimentaryPackageNotify productName is invalid.");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        String strM64293c = C10465b.m64293c(contextM1377a.getString(R$string.cloudpay_complimentary_title), productName);
        String strM64293c2 = C10465b.m64293c(contextM1377a.getString(R$string.cloudpay_complimentary_text, presentNickName), new Object[0]);
        if (TextUtils.isEmpty(strM64293c) || TextUtils.isEmpty(strM64293c2)) {
            C11839m.m70687e(TAG, "sendFamilyShareStopNotify, title or content null");
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) CloudSpaceUpgradeActivity.class);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 5);
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_RECEIVE_GIFT_PACKAGE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 2, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1668i(contextM1377a, strM64293c).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i10)).m3811l(strM64293c).m3810k(strM64293c2).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        notificationGroupDone(false);
        this.mManager.notify(new Random().nextInt(100) + 1000, notificationM3804d);
    }

    public void sendCycleNotification(int i10, boolean z10, List<PortraitAndGrade.UserTag> list) {
        NotifyLogger.m29915i(TAG, " sendCycleNotification ");
        C12515a.m75110o().m75172d(new SendCycleNotificationTask(this.mContext, z10, i10, list, this.mManager));
    }

    public void sendDataMigrationNotification(Context context) {
        Context context2 = this.mContext;
        if (context2 != null && C0209d.m1173G1(context2)) {
            C11839m.m70688i(TAG, "sendSTInvalidNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DataMigrationAuthActivity.class);
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_DATA_MIGRATION_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        String string = context.getString(R$string.migrate_terms_2);
        Bundle bundle = new Bundle();
        Resources resources = context.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        String string2 = context.getString(R$string.migrate_terms_title2);
        Notification notificationM3804d = C0238w.m1663f().m1668i(context, string2).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(context.getResources().getString(i10)).m3811l(string2).m3810k(string).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(false).m3804d();
        notificationGroupDone(false);
        this.mManager.notify(276, notificationM3804d);
    }

    public void sendHonorUpGuideNotification(String str, String str2) {
        if (C0209d.m1185K1(this.mContext)) {
            return;
        }
        if (C0209d.m1173G1(this.mContext)) {
            C11839m.m70688i(TAG, "sendUpGuideNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (this.mContext == null) {
            C11839m.m70688i(TAG, "sendUpGuideNotification, mContext is null");
            return;
        }
        cancelHonorUpGuideNotification();
        Intent intent = new Intent(this.mContext, (Class<?>) MainActivity.class);
        intent.putExtra(NotifyConstants.NOTIFY_ID_KEY, 777);
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_HONOR_UPGRADE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1668i(this.mContext, str).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(this.mContext.getResources().getString(i10)).m3811l(str).m3810k(str2).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        notificationGroupDone(false);
        this.mManager.notify(777, notificationM3804d);
        C10158i.m63324h("1", null);
    }

    public void sendNotification(NotifyNeedData notifyNeedData) {
        if (notifyNeedData == null) {
            NotifyLogger.m29914e(TAG, "sendNotification notifyNeedData is null");
            return;
        }
        if (TextUtils.isEmpty(notifyNeedData.getTitleText()) || TextUtils.isEmpty(notifyNeedData.getMainText())) {
            NotifyLogger.m29914e(TAG, "sendNotification notifyNeedData text is empty");
            return;
        }
        NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(notifyNeedData.isSilent(), "com.huawei.android.hicloud", 3, VastAttribute.PROGRESS);
        notificationBuilder.m3823x(true);
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(notifyNeedData.getMainText());
        notificationBuilder.m3825z(c0605b);
        Notification notificationM3804d = notificationBuilder.m3811l(notifyNeedData.getTitleText()).m3810k(notifyNeedData.getMainText()).m3809j(notifyNeedData.getContentIntent()).m3814o(notifyNeedData.getCancelIntent()).m3824y(notifyNeedData.getIconId()).m3800C(System.currentTimeMillis()).m3815p(notifyNeedData.getExtraBundle()).m3817r(notifyNeedData.getGroupKey()).m3807h(notifyNeedData.isAutoCancel()).m3804d();
        notificationM3804d.flags = 65536 | 16;
        this.mManager.notify(notifyNeedData.getId(), notificationM3804d);
        C11839m.m70688i(TAG, "sendNotification v5 end");
        if (notifyNeedData.isNeedGroup()) {
            setNotifyGroup(notifyNeedData.isSilent(), 3, VastAttribute.PROGRESS);
        }
    }

    public void sendOpenCloudNotification() {
        if (this.mContext == null) {
            C11839m.m70688i(TAG, "sendOpenCloudNotification, mContext is null");
            return;
        }
        Intent intent = new Intent(this.mContext.getApplicationContext(), (Class<?>) HisyncExternalActivity.class);
        intent.putExtra("channel_from_otherApp_login", true);
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_OPEN_CLOUD_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext.getApplicationContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        String string = this.mContext.getString(R$string.account_notify_title);
        Notification notificationM3804d = C0238w.m1663f().m1668i(this.mContext, string).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(this.mContext.getResources().getString(i10)).m3811l(string).m3810k(this.mContext.getString(R$string.account_notify_sub_title)).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        notificationGroupDone(false);
        this.mManager.notify(292, notificationM3804d);
    }

    public void sendPowerNotify() {
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "sendPowerNotify mContext is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendPowerNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        C11839m.m70688i(TAG, "sendPowerNotify");
        NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(this.mContext, "com.huawei.android.hicloud");
        Intent intent = new Intent();
        Class clsM5963i = C1006a.m5936k().m5963i();
        if (clsM5963i != null) {
            intent.setClass(this.mContext, clsM5963i);
        }
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_ALBUM_POWER_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        builderM1668i.m3823x(true);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Resources resources2 = this.mContext.getResources();
        int i11 = R$string.cloudphoto_connect_power_for_more_photo;
        Notification notificationM3804d = builderM1668i.m3799B(resources2.getString(i11)).m3811l(this.mContext.getResources().getString(i10)).m3810k(this.mContext.getResources().getString(i11)).m3809j(pendingIntentM1248e0).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
        notificationM3804d.flags = 65536 | 16;
        this.mManager.notify(17, notificationM3804d);
        notificationGroupDone(false);
    }

    public void sendSpaceNotEnoughNotify(SpaceNotification spaceNotification, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, boolean z10, C12295b c12295b) {
        String strReplaceVoucherPlaceholder;
        String strReplaceVoucherPlaceholder2;
        String strReplaceVoucherPlaceholder3;
        NotificationCompat.Builder builderM1669j;
        if (!checkConditionForNotEnough(c12295b)) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify do not meet the condition.");
            return;
        }
        try {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotify id = " + spaceNotification.getId());
            GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespM73885n = c12295b.m73885n();
            boolean zIsCanShowCouponInfo = isCanShowCouponInfo(this.mContext, c12295b.m73889r(), getPackagesBySpaceRuleRespM73885n, spaceNotification.getEnableShowCoupon());
            reportSpaceNotEnoughDialogShow(spaceNotification, backupSpaceNotEnoughNeedData, z10, getPackagesBySpaceRuleRespM73885n, zIsCanShowCouponInfo);
            NoticeContent noticeCouponContent = zIsCanShowCouponInfo ? CloudSpaceNotifyUtil.getInstance().getNoticeCouponContent(spaceNotification) : CloudSpaceNotifyUtil.getInstance().getNoticeNotification(spaceNotification);
            if (noticeCouponContent == null) {
                C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify noticeContent null");
                return;
            }
            boolean zM80897c1 = C13452e.m80781L().m80897c1();
            if (zIsCanShowCouponInfo) {
                String strFilterNoticeTitle = NotifyUtil.filterNoticeTitle(noticeCouponContent, zM80897c1, z10, NotifyUtil.TITLE_TYPE_NOTI, spaceNotification.getId());
                String strFilterNoticeMainText = NotifyUtil.filterNoticeMainText(noticeCouponContent, zM80897c1, z10, NotifyUtil.MAIN_TEXT_TYPE_NOTI, spaceNotification.getId());
                String stringUseLock = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeCouponContent.getNotiDescription(), spaceNotification.getId());
                HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(this.mContext);
                VoucherNotiDisplayInfo voucherNotiDisplayInfo = UserSpaceUtil.getVoucherNotiDisplayInfo(getPackagesBySpaceRuleRespM73885n);
                strReplaceVoucherPlaceholder = hiCloudNotificationManager.replaceVoucherPlaceholder(strFilterNoticeTitle, voucherNotiDisplayInfo);
                strReplaceVoucherPlaceholder2 = hiCloudNotificationManager.replaceVoucherPlaceholder(stringUseLock, voucherNotiDisplayInfo);
                strReplaceVoucherPlaceholder3 = hiCloudNotificationManager.replaceVoucherPlaceholder(strFilterNoticeMainText, voucherNotiDisplayInfo);
            } else {
                strReplaceVoucherPlaceholder = NotifyUtil.filterNoticeTitle(noticeCouponContent, zM80897c1, z10, "title", spaceNotification.getId());
                strReplaceVoucherPlaceholder3 = NotifyUtil.filterNoticeMainText(noticeCouponContent, zM80897c1, z10, NotifyUtil.MAIN_TEXT_TYPE_DEFAULT, spaceNotification.getId());
                strReplaceVoucherPlaceholder2 = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeCouponContent.getDescription(), spaceNotification.getId());
            }
            String str = strReplaceVoucherPlaceholder2;
            String str2 = strReplaceVoucherPlaceholder3;
            String str3 = strReplaceVoucherPlaceholder;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                PendingIntent backupNotEnoughPendingIntent = getBackupNotEnoughPendingIntent(spaceNotification, backupSpaceNotEnoughNeedData, zIsCanShowCouponInfo, getPackagesBySpaceRuleRespM73885n, z10);
                if (backupNotEnoughPendingIntent == null) {
                    C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify contentIntent is null.");
                    return;
                }
                if (z10) {
                    C0235t c0235tM1645e = C0235t.m1645e();
                    Context context = this.mContext;
                    builderM1669j = c0235tM1645e.m1648g(context, str3, "2", context.getString(R$string.channel_backup_notification));
                } else {
                    builderM1669j = C0238w.m1663f().m1669j(this.mContext, str3);
                }
                builderM1669j.m3823x(true);
                Bundle bundle = new Bundle();
                bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
                NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
                c0605b.m3839h(str);
                builderM1669j.m3825z(c0605b);
                Notification notificationM3804d = builderM1669j.m3811l(str3).m3810k(prepareContentText(str2)).m3809j(backupNotEnoughPendingIntent).m3814o(prepareCancelPendingIntent(spaceNotification)).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
                notificationM3804d.flags = 65536 | 16;
                this.mManager.notify(273, notificationM3804d);
                notificationProgressGroupDone(z10);
                if (zIsCanShowCouponInfo) {
                    recordCouponShowTime();
                    return;
                }
                return;
            }
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify mainText = " + str2 + " or title = " + str3 + " is null.");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotify error. " + e10.toString());
        }
    }

    public boolean sendSpaceNotEnoughNotifyWithActivity(NotificationWithActivity notificationWithActivity, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, boolean z10, C12295b c12295b) {
        NotificationCompat.Builder builderM1669j;
        if (!checkConditionForNoticeActivity(c12295b)) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotifyWithActivity not meet condition.");
            return false;
        }
        C11839m.m70688i(TAG, "sendSpaceNotEnoughNotifyWithActivity id = " + notificationWithActivity.getId());
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespM73885n = c12295b.m73885n();
        boolean zIsCanShowCouponInfo = isCanShowCouponInfo(this.mContext, c12295b.m73889r(), getPackagesBySpaceRuleRespM73885n, notificationWithActivity.getEnableShowCoupon());
        reportActivitySpaceNotEnoughDialogShow(notificationWithActivity, backupSpaceNotEnoughNeedData, getPackagesBySpaceRuleRespM73885n, zIsCanShowCouponInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(notificationWithActivity);
        BackupNotEnoughNotifyStrInfo backupActivityNotifyStr = getBackupActivityNotifyStr(arrayList, c12295b, zIsCanShowCouponInfo, notificationWithActivity, getPackagesBySpaceRuleRespM73885n);
        String titile = backupActivityNotifyStr.getTitile();
        String mainText = backupActivityNotifyStr.getMainText();
        if (TextUtils.isEmpty(mainText) || TextUtils.isEmpty(titile)) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotifyWithActivity mainText = " + mainText + " or title = " + titile + " is null.");
            return false;
        }
        PendingIntent backupNotEnoughPendingActivityIntent = getBackupNotEnoughPendingActivityIntent(notificationWithActivity, backupSpaceNotEnoughNeedData, zIsCanShowCouponInfo, getPackagesBySpaceRuleRespM73885n, c12295b.m73874b());
        if (backupNotEnoughPendingActivityIntent == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotifyWithActivity contentIntent is null.");
            return false;
        }
        try {
            if (z10) {
                C0235t c0235tM1645e = C0235t.m1645e();
                Context context = this.mContext;
                builderM1669j = c0235tM1645e.m1648g(context, titile, "2", context.getString(R$string.channel_backup_notification));
            } else {
                builderM1669j = C0238w.m1663f().m1669j(this.mContext, titile);
            }
            builderM1669j.m3823x(true);
            long jM16190y = C2783d.m16190y();
            Resources resources = this.mContext.getResources();
            String quantityString = "0";
            if (resources != null) {
                int i10 = (int) jM16190y;
                quantityString = resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10));
            }
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3839h(C10465b.m64293c(mainText, quantityString));
            builderM1669j.m3825z(c0605b);
            Notification notificationM3804d = builderM1669j.m3811l(titile).m3810k(C10465b.m64293c(mainText, quantityString)).m3809j(backupNotEnoughPendingActivityIntent).m3814o(prepareActivityCancelPendingIntent(notificationWithActivity)).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
            notificationM3804d.flags = 65536 | 16;
            this.mManager.notify(273, notificationM3804d);
            notificationProgressGroupDone(z10);
            if (zIsCanShowCouponInfo) {
                recordCouponShowTime();
            }
            C11839m.m70688i(TAG, "sendSpaceNotEnoughNotifyWithActivity end");
            return true;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughNotifyWithActivity error. " + e10.toString());
            return false;
        }
    }

    public void sendSyncRiskNotification(Context context, String str, String str2) throws Resources.NotFoundException {
        C11839m.m70688i(TAG, "sendSyncRiskNotification");
        Context context2 = this.mContext;
        if (context2 != null && C0209d.m1173G1(context2)) {
            C11839m.m70688i(TAG, "sendSyncRiskNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("risk_entry_key", "risk_click_notification");
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_SYNC_RISK_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent2.setComponent(new ComponentName(this.mContext, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent2, context.getPackageName());
        intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent2.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "5");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, intent2, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", str);
        NotificationCompat.Builder builderM3801a = C0238w.m1663f().m1668i(context, str).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3801a(0, context.getResources().getString(R$string.risk_sync_handle), pendingIntentM1248e0);
        Resources resources = context.getResources();
        int i10 = R$string.HiCloud_app_name;
        NotificationCompat.Builder builderM3809j = builderM3801a.m3799B(resources.getString(i10)).m3810k(str2).m3809j(pendingIntentM1248e0);
        if (TextUtils.isEmpty(str)) {
            str = this.mContext.getResources().getString(i10);
        }
        this.mManager.notify(277, builderM3809j.m3811l(str).m3814o(broadcast).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d());
        C10028c.m62183d0(context).m62197C2("sync_risk_notify_time", System.currentTimeMillis());
        notificationGroupDone(false);
        C13223b.m79473a(context, "risk_notification", "1");
        UBAAnalyze.m29954O("PVC", "risk_notification", "4", "38");
    }

    public void sendUpGuideNotification() {
        Context context = this.mContext;
        if (context != null && C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendUpGuideNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (this.mContext == null) {
            C11839m.m70688i(TAG, "sendUpGuideNotification, mContext is null");
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) UpgradeIntroductionActivity.class);
        intent.putExtra(NotifyConstants.NOTIFY_ID_KEY, 291);
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_UP_GUIDE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        String string = this.mContext.getString(R$string.intro_noti_sub_title);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        String string2 = this.mContext.getString(R$string.intro_noti_title);
        Notification notificationM3804d = C0238w.m1663f().m1668i(this.mContext, string2).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(this.mContext.getResources().getString(i10)).m3811l(string2).m3810k(string).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        notificationGroupDone(false);
        this.mManager.notify(291, notificationM3804d);
    }

    public void setNotifyGroup(boolean z10, int i10, String str) {
        Context contextM1377a = C0213f.m1377a();
        if (this.mManager.getActiveNotifications().length < 1) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", contextM1377a.getResources().getString(com.huawei.hicloud.router.R$string.HiCloud_app_name));
        this.mManager.notify(22, NotifyUtil.getNotificationBuilder(z10, "com.huawei.android.hicloud", i10, str).m3824y(R$drawable.logo_about_system).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3823x(true).m3804d());
        NotifyLogger.m29915i(TAG, "setNotifyGroup end");
    }

    private void notificationGroupDone(boolean z10, int i10, String str) {
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
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 1, new Intent(this.mContext, (Class<?>) MainActivity.class), HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        builderM1670k.m3823x(true);
        this.mManager.notify(22, builderM1670k.m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3809j(pendingIntentM1248e0).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
        C11839m.m70688i(TAG, "notificationGroupDone");
    }

    private Intent getPendingNeedIntent(SpaceNotification spaceNotification, Long l10, Long l11, Long l12, Long l13, Long l14) {
        Intent gotoIntent;
        Intent intent;
        String str;
        String str2;
        String str3;
        String stringUseLock;
        String stringUseLock2;
        String stringUseLock3;
        NoticeDetail noticeContentDetailDefault;
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        String notiType = noticeGoto.getNotiType();
        String notiUri = noticeGoto.getNotiUri();
        String notiDeeplink = noticeGoto.getNotiDeeplink();
        if (!NotifyUtil.checkIsUriModuleEnable(this.mContext, notiType, notiUri, noticeGoto)) {
            C11839m.m70689w(TAG, "getPendingNeedIntent uri is empty or moudlue not enable");
            return null;
        }
        if (C12590s0.m75807V0(notiDeeplink)) {
            gotoIntent = C12590s0.m75832b0(notiDeeplink, null, true);
        } else {
            gotoIntent = NotifyUtil.getGotoIntent(this.mContext, notiType, notiUri);
        }
        if (gotoIntent == null) {
            C11839m.m70688i(TAG, "sendSpaceNotify intent is null.");
            return null;
        }
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        int id2 = spaceNotification.getId();
        if (l12.longValue() != -1) {
            NoticeDetail noticeContentDetail = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetail(spaceNotification);
            if (NotifyConstants.DETAIL2.equals(notiType)) {
                noticeContentDetail = C10152c.m63224h(spaceNotification);
            }
            if (noticeContentDetail != null) {
                stringUseLock = getStringUseLock(noticeContentDetail.getTitle(), id2);
                stringUseLock2 = getStringUseLock(noticeContentDetail.getSbuTitle(), id2);
                stringUseLock3 = getStringUseLock(noticeContentDetail.getMainText(), id2);
                String stringUseLock4 = getStringUseLock(noticeContentDetail.getMainTextSecond(), id2);
                String stringUseLock5 = getStringUseLock(noticeContentDetail.getButtonFirst(), id2);
                recommendNeedData.setBackupNeedSpace(l12.longValue());
                recommendNeedData.setNotUsedSpace(l13.longValue());
                gotoIntent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
                str2 = stringUseLock4;
                str3 = stringUseLock5;
            } else {
                str2 = "";
                str3 = str2;
                stringUseLock = str3;
                stringUseLock2 = stringUseLock;
                stringUseLock3 = stringUseLock2;
            }
            intent = gotoIntent;
            str = notiDeeplink;
        } else {
            NoticeDetail noticeDetailWithPlaceHolder = CloudSpaceNotifyUtil.getInstance().getNoticeDetailWithPlaceHolder(spaceNotification);
            if (NotifyConstants.DETAIL2.equals(notiType)) {
                noticeDetailWithPlaceHolder = C10152c.m63224h(spaceNotification);
            }
            if (noticeDetailWithPlaceHolder != null) {
                stringUseLock = getStringUseLock(noticeDetailWithPlaceHolder.getTitle(), id2);
                stringUseLock2 = getStringUseLock(noticeDetailWithPlaceHolder.getSbuTitle(), id2);
                stringUseLock3 = getStringUseLock(noticeDetailWithPlaceHolder.getMainText(), id2);
                String stringUseLock6 = getStringUseLock(noticeDetailWithPlaceHolder.getMainTextSecond(), id2);
                String stringUseLock7 = getStringUseLock(noticeDetailWithPlaceHolder.getButtonFirst(), id2);
                gotoIntent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
                str = notiDeeplink;
                str2 = stringUseLock6;
                str3 = stringUseLock7;
                intent = gotoIntent;
            } else {
                intent = gotoIntent;
                str = notiDeeplink;
                str2 = "";
                str3 = str2;
                stringUseLock = str3;
                stringUseLock2 = stringUseLock;
                stringUseLock3 = stringUseLock2;
            }
        }
        recommendNeedData.setGalleryNum(l14.longValue());
        if ((l14.longValue() <= 0 || l12.longValue() <= 0 || C2783d.m16105R()) && (noticeContentDetailDefault = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailDefault(spaceNotification, notiType)) != null) {
            stringUseLock3 = getStringUseLock(noticeContentDetailDefault.getMainText(), id2);
        }
        recommendNeedData.setIsFormWithActivity(false);
        recommendNeedData.setRecommendType(spaceNotification.getNoticeType());
        recommendNeedData.setEnterType(0);
        recommendNeedData.setId(spaceNotification.getId());
        recommendNeedData.setTitle(stringUseLock);
        recommendNeedData.setSubTitle(stringUseLock2);
        recommendNeedData.setMainText(stringUseLock3);
        recommendNeedData.setSecondMainText(str2);
        recommendNeedData.setChooseOtherCaseText(str3);
        recommendNeedData.setTotalNeedSpace(l10.longValue());
        recommendNeedData.setCurrentPackageSpace(l11.longValue());
        recommendNeedData.setNotUsedSpace(l13.longValue());
        Intent intent2 = intent;
        intent2.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        Intent intentM63229m = C10152c.m63229m(intent2, spaceNotification, noticeGoto, C10152c.m63219c(this.mContext) + 1, false);
        C13222a.m79470l(intentM63229m, "4");
        C13230i.m79525e1(intentM63229m, "4", "6");
        intentM63229m.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intentM63229m.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        intentM63229m.putExtra(HNConstants.C4906BI.DATA_TYPE_ID, "" + spaceNotification.getId());
        intentM63229m.putExtra("user_tags_key", C13622a.m81963i());
        intentM63229m.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(spaceNotification.getPercentage()));
        intentM63229m.putExtra("scene_id", NotifyUtil.getReportSceneId(spaceNotification.getNoticeType()));
        if (C12590s0.m75807V0(str)) {
            intentM63229m.putExtra("gotoDeeplink", str);
        }
        C11839m.m70688i(TAG, "notification = " + spaceNotification.getNoticeType());
        return intentM63229m;
    }
}
