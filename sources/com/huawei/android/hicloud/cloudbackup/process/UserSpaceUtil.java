package com.huawei.android.hicloud.cloudbackup.process;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import ca.C1398a;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgInfo;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgSpInfo;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientPopUpWindowNotify;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.GuideWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceMemberShareActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.hicloud.task.simple.C3009a;
import com.huawei.android.hicloud.task.simple.C3021d;
import com.huawei.android.hicloud.task.simple.C3025e;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.GetRecommendActivityResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.PayActivityInfo;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.bean.FreqControlBean;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.checker.LevelFrequencyController;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV4Bean;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.ExtraNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeContentRoot;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetailTextGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.SpaceInsufficientNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import dk.C9160a;
import fj.C9718g;
import fk.C9721b;
import gp.C10028c;
import id.C10467a;
import id.C10469c;
import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import je.C10811y;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p037bp.C1270a;
import p052cb.C1412i;
import p232dp.InterfaceC9282a;
import p292fn.C9733f;
import p315gj.C9948a;
import p315gj.C9950c;
import p336he.C10155f;
import p341hj.C10249n;
import p341hj.C10252o;
import p429kk.C11058a;
import p429kk.C11060c;
import p450le.C11273b;
import p454lj.C11289l;
import p454lj.C11290m;
import p454lj.C11296s;
import p459lp.C11327e;
import p514o9.C11829c;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12540b1;
import p620rp.InterfaceC12614b;
import p652t9.EnumC12999a;
import p684un.C13223b;
import p684un.C13227f;
import p703v8.C13366c;
import p703v8.C13368e;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p846zj.C14306d;
import p850zo.InterfaceC14351b;
import to.C13049a;

/* loaded from: classes2.dex */
public class UserSpaceUtil implements InterfaceC14351b {
    private static final int BACKUP_NOT_ENOUGH_DLG_TWO_BUTTON = 2;
    private static final int CHECK_BACKUP_MSG_FAILED = 2;
    private static final int CHECK_BACKUP_MSG_SUCCESE = 1;
    private static final String TAG = "UserSpaceUtil";
    private static final String USER_TYPE_FREE = "free";
    private static final String USER_TYPE_PAY = "pay";
    private static StorageInfo storageInfo = new StorageInfo();
    private long backupNeedSpace;
    private long galleryNum;
    private Context mContext;
    private long notUsedSpace;
    private long totalNeedSpace;
    private long userUsedSize = -1;
    private long backupUsedSize = -1;
    private boolean isSuccess = true;
    private List<CBSpaceDetail> backupDetails = new ArrayList();

    public class ActivitySpaceScreenStateListener implements ScreenListener.ScreenStateListener {
        private C12295b backupNoticeNeedInfo;
        private boolean isAutoBackup;
        private BackupSpaceNotEnoughNeedData mBackupSpaceNotEnoughNeedData;
        private NotificationWithActivity notification;

        public ActivitySpaceScreenStateListener(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, boolean z10, NotificationWithActivity notificationWithActivity) {
            this.mBackupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
            this.backupNoticeNeedInfo = c12295b;
            this.isAutoBackup = z10;
            this.notification = notificationWithActivity;
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOff() {
            C11839m.m70688i(UserSpaceUtil.TAG, "ActivitySpaceScreenStateListener onScreenOff, isAutoBackup: " + this.isAutoBackup);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOn() {
            C11839m.m70688i(UserSpaceUtil.TAG, "ActivitySpaceScreenStateListener  screenOn, isAutoBackup: " + this.isAutoBackup);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onUserPresent() {
            C11839m.m70688i(UserSpaceUtil.TAG, "ActivitySpaceScreenStateListener onUserPresent, isAutoBackup: " + this.isAutoBackup);
            if (C0209d.m1265i1(UserSpaceUtil.this.mContext) || UserSpaceUtil.this.isBackupForeground() || C0209d.m1245d1(UserSpaceUtil.this.mContext, MainActivity.class.getName())) {
                NotificationReportUtil.reportCloudBackupNoSpace("0001", "0018");
                C12515a.m75110o().m75175e(new C3021d(UserSpaceUtil.this.mContext, this.mBackupSpaceNotEnoughNeedData, this.backupNoticeNeedInfo, this.isAutoBackup, this.notification), true);
                return;
            }
            C11839m.m70688i(UserSpaceUtil.TAG, "start BackupActivityFailCheckTimer");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0019");
            C10467a.m64335p(UserSpaceUtil.this.mContext).cancel();
            C10467a.m64335p(UserSpaceUtil.this.mContext).m64349m(false);
            C10467a.m64335p(UserSpaceUtil.this.mContext).m64348l(this.mBackupSpaceNotEnoughNeedData);
            C10467a.m64335p(UserSpaceUtil.this.mContext).m64347k(this.backupNoticeNeedInfo);
            C10467a.m64335p(UserSpaceUtil.this.mContext).m64346j(this.isAutoBackup);
            C10467a.m64335p(UserSpaceUtil.this.mContext).m64340q(this.notification);
            C12515a.m75110o().m75175e(C10467a.m64335p(UserSpaceUtil.this.mContext), true);
            ScreenListener.m18023c(UserSpaceUtil.this.mContext).m18028g();
        }
    }

    public class GetBackupUsedRunnable extends AbstractC12367d {
        private GetBackupUsedRunnable() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Message message = new Message();
            message.what = 32316;
            try {
                BackupStorageInfo backupStorageInfoM80173d = new C13366c().m80173d();
                if (backupStorageInfoM80173d == null) {
                    C11839m.m70689w(UserSpaceUtil.TAG, "get user cloudbackup space failed: backupInfo == null");
                    UserSpaceUtil.this.isSuccess = false;
                    message.arg1 = 1;
                    UserSpaceUtil.sendMessage(message);
                    return;
                }
                List<CBSpaceDetail> backupDetails = backupStorageInfoM80173d.getBackupDetails();
                if (backupDetails == null) {
                    C11839m.m70689w(UserSpaceUtil.TAG, "getBackupUsedRunnable details is null");
                    UserSpaceUtil.this.isSuccess = false;
                    message.arg1 = 1;
                    UserSpaceUtil.sendMessage(message);
                    return;
                }
                message.arg1 = 0;
                message.obj = backupDetails;
                UserSpaceUtil.sendMessage(message);
                UserSpaceUtil userSpaceUtil = UserSpaceUtil.this;
                long backupUsedSize = 0;
                if (backupStorageInfoM80173d.getBackupUsedSize() >= 0) {
                    backupUsedSize = backupStorageInfoM80173d.getBackupUsedSize();
                }
                userSpaceUtil.backupUsedSize = backupUsedSize;
                C11839m.m70688i(UserSpaceUtil.TAG, "backupUsedSize = " + UserSpaceUtil.this.backupUsedSize);
                Message message2 = new Message();
                message2.what = 32317;
                message2.obj = Long.valueOf(UserSpaceUtil.this.backupUsedSize);
                UserSpaceUtil.sendMessage(message2);
                C13368e.m80184F().m80268z0(backupStorageInfoM80173d, 0);
            } catch (Exception unused) {
                C11839m.m70689w(UserSpaceUtil.TAG, "get user cloudbackup space failed.");
                UserSpaceUtil.this.isSuccess = false;
                message.arg1 = 1;
                UserSpaceUtil.sendMessage(message);
            }
        }

        public /* synthetic */ GetBackupUsedRunnable(UserSpaceUtil userSpaceUtil, C25081 c25081) {
            this();
        }
    }

    public class GetUsedSpaceRunnable extends AbstractC12367d {
        private GetUsedSpaceRunnable() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                UserSpaceUtil.this.userUsedSize = Long.parseLong(new C13049a(EnumC12999a.CLOUD_MORE, null).m78707F());
                UserSpaceUtil userSpaceUtil = UserSpaceUtil.this;
                long j10 = 0;
                if (userSpaceUtil.userUsedSize >= 0) {
                    j10 = UserSpaceUtil.this.userUsedSize;
                }
                userSpaceUtil.userUsedSize = j10;
                C13368e.m80184F().m80219H0(UserSpaceUtil.this.userUsedSize);
                C11839m.m70688i(UserSpaceUtil.TAG, "userUsedSize = " + UserSpaceUtil.this.userUsedSize);
            } catch (JsonSyntaxException unused) {
                C11839m.m70689w(UserSpaceUtil.TAG, "get user used space failed JsonSyntaxException.");
                UserSpaceUtil.this.isSuccess = false;
            } catch (C9721b unused2) {
                C11839m.m70689w(UserSpaceUtil.TAG, "get user used space failed.");
                UserSpaceUtil.this.isSuccess = false;
            } catch (NumberFormatException unused3) {
                C11839m.m70689w(UserSpaceUtil.TAG, "checkUserSpace format error.");
                UserSpaceUtil.this.isSuccess = false;
            }
        }

        public /* synthetic */ GetUsedSpaceRunnable(UserSpaceUtil userSpaceUtil, C25081 c25081) {
            this();
        }
    }

    public class SpaceScreenStateListener implements ScreenListener.ScreenStateListener {
        private C12295b backupNoticeNeedInfo;
        private boolean isAutoBackup;
        private BackupSpaceNotEnoughNeedData mBackupSpaceNotEnoughNeedData;
        private SpaceNotification notification;

        public SpaceScreenStateListener(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, boolean z10, SpaceNotification spaceNotification) {
            this.mBackupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
            this.backupNoticeNeedInfo = c12295b;
            this.isAutoBackup = z10;
            this.notification = spaceNotification;
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOff() {
            C11839m.m70688i(UserSpaceUtil.TAG, "SpaceScreenStateListener onScreenOff, isAutoBackup: " + this.isAutoBackup);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOn() {
            C11839m.m70688i(UserSpaceUtil.TAG, "SpaceScreenStateListener  screenOn, isAutoBackup: " + this.isAutoBackup);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onUserPresent() {
            C11839m.m70688i(UserSpaceUtil.TAG, "SpaceScreenStateListener onUserPresent, isAutoBackup: " + this.isAutoBackup);
            if (C0209d.m1265i1(UserSpaceUtil.this.mContext) || UserSpaceUtil.this.isBackupForeground() || C0209d.m1245d1(UserSpaceUtil.this.mContext, MainActivity.class.getName())) {
                NotificationReportUtil.reportCloudBackupNoSpace("0001", "0018");
                C12515a.m75110o().m75175e(new C3025e(UserSpaceUtil.this.mContext, this.mBackupSpaceNotEnoughNeedData, this.backupNoticeNeedInfo, this.isAutoBackup, this.notification), true);
                return;
            }
            C11839m.m70688i(UserSpaceUtil.TAG, "start BackupFailCheckTimer");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0019");
            C10469c.m64350p(UserSpaceUtil.this.mContext).cancel();
            C10469c.m64350p(UserSpaceUtil.this.mContext).m64349m(false);
            C10469c.m64350p(UserSpaceUtil.this.mContext).m64348l(this.mBackupSpaceNotEnoughNeedData);
            C10469c.m64350p(UserSpaceUtil.this.mContext).m64347k(this.backupNoticeNeedInfo);
            C10469c.m64350p(UserSpaceUtil.this.mContext).m64346j(this.isAutoBackup);
            C10469c.m64350p(UserSpaceUtil.this.mContext).m64352q(this.notification);
            C12515a.m75110o().m75175e(C10469c.m64350p(UserSpaceUtil.this.mContext), true);
            ScreenListener.m18023c(UserSpaceUtil.this.mContext).m18028g();
        }
    }

    public UserSpaceUtil(Context context) {
        this.mContext = context;
    }

    private void activityNotifyCollectEvent(NotificationWithActivity notificationWithActivity) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(this.mContext, "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put("notify_id", notificationWithActivity.getId());
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, notificationWithActivity.getActivityType());
            jSONObjectM79482j.put("notify_type", "1");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29952M("CKC", "DYNAMIC_NOTIFY_SHOW", jSONObjectM79482j);
    }

    private void autoBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, CloudNoticeOffCheckResult cloudNoticeOffCheckResult, List<PortraitAndGrade.UserTag> list) throws JSONException, Resources.NotFoundException, NumberFormatException {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "autoBackupFailNotify mContext is null");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0015");
            return;
        }
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "autoBackupFailNotify backupSpaceNotEnoughNeedData is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0016");
            return;
        }
        SpaceNoticeCommonSpUtil.getInstance().clear(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        BackupNotificationManager backupNotificationManager = new BackupNotificationManager(this.mContext);
        List<SpaceNotification> notification = getNotification();
        if (notification == null) {
            C11839m.m70688i(TAG, "AutoBackupFailNotify notifications is null");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0001");
        } else {
            Collections.sort(notification, new CloudSpaceNotifyUtil.NotificationComparator());
            doAutoBackupFailNotify(backupSpaceNotEnoughNeedData, cloudNoticeOffCheckResult, backupNotificationManager, notification, list);
        }
    }

    private boolean autoBackupFailNotifyTaskCenter(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, List<PortraitAndGrade.UserTag> list) throws Resources.NotFoundException, NumberFormatException {
        C11839m.m70688i(TAG, "autoBackup taskCenter start");
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "autoBackup taskCenter mContext is null");
            return false;
        }
        if (checkNotifyData(backupSpaceNotEnoughNeedData)) {
            return false;
        }
        String userGradeCode = getUserGradeCode("auBackupFailTaskCenter");
        List<NotificationWithActivity> notificationTaskCenter = getNotificationTaskCenter(userGradeCode, list, c12295b);
        if (notificationTaskCenter == null || notificationTaskCenter.isEmpty()) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0020", "0006");
            C11839m.m70687e(TAG, "autoBackup taskCenter notification is null");
            return false;
        }
        List<NotificationWithActivity> filterNotificationWithActivities = getFilterNotificationWithActivities(notificationTaskCenter);
        NotificationReportUtil.reportCloudBackupActivityNoSpace("0016", "valid_size=" + filterNotificationWithActivities.size());
        Iterator<NotificationWithActivity> it = filterNotificationWithActivities.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NotificationWithActivity next = it.next();
            if (checkFrequencySatify(next)) {
                C11839m.m70688i(TAG, "autoBackup taskCenter valid id = " + next.getId());
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0017", "valid_id=" + next.getId());
                c12295b.m73870G(getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
                List<String> remindModes = next.getRemindModes();
                PopupLimitedResult popupLimitedResult = new PopupLimitedResult();
                if (remindModes != null && remindModes.contains("popup")) {
                    if (!isNewCardMatchIncentiveNotifyConfig(next)) {
                        return false;
                    }
                    checkDialogShowActivity(next, c12295b, userGradeCode, backupSpaceNotEnoughNeedData, popupLimitedResult);
                    if (popupLimitedResult.isLimit()) {
                        sendBackupFailIMMessage(backupSpaceNotEnoughNeedData, next);
                    }
                }
                recordSpaceNotifyRuleFrequency(this.mContext);
            } else {
                C11839m.m70689w(TAG, "autoBackup taskCenter not satisfy frequency.");
                JsonArray jsonArray = new JsonArray();
                NotificationBIReportUtil.addDayOnceCheckFailNotice(jsonArray, next.getNoticeType(), String.valueOf(next.getId()));
                NotificationBIReportUtil.reportAutoBackupTaskCenterCheckFail(jsonArray);
            }
        }
        C11839m.m70688i(TAG, "autoBackupFailNotifyTaskCenter end");
        return true;
    }

    private boolean autoBackupFailNotifyWithActivity(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, CloudNoticeOffCheckResult cloudNoticeOffCheckResult, List<PortraitAndGrade.UserTag> list) throws JSONException, Resources.NotFoundException, NumberFormatException {
        C11839m.m70688i(TAG, "autoBackupFailNotifyWithActivity start");
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "autoBackupFailNotifyWithActivity mContext is null");
            return false;
        }
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "autoBackupFailNotifyWithActivity backupSpaceNotEnoughNeedData is null");
            return false;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70687e(TAG, "autoBackupFailNotifyWithActivity is child account, can not show.");
            return false;
        }
        String userGradeCode = getUserGradeCode("autoBackupFailWithActivity");
        C12295b c12295b = new C12295b();
        List<NotificationWithActivity> notificationWithActivity = getNotificationWithActivity(userGradeCode, list, backupSpaceNotEnoughNeedData, c12295b);
        c12295b.m73866C(1);
        if (notificationWithActivity == null || notificationWithActivity.isEmpty()) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0005", "0006");
            C11839m.m70687e(TAG, "autoBackupFailNotifyWithActivity notification is null");
            return false;
        }
        List<NotificationWithActivity> filterNotificationWithActivities = getFilterNotificationWithActivities(notificationWithActivity);
        NotificationReportUtil.reportCloudBackupActivityNoSpace("0016", "valid_size=" + filterNotificationWithActivities.size());
        Iterator<NotificationWithActivity> it = filterNotificationWithActivities.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NotificationWithActivity next = it.next();
            if (checkFrequencySatify(next)) {
                C11839m.m70688i(TAG, "autoBackupFailNotifyWithActivity valid id = " + next.getId());
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0017", "valid_id=" + next.getId());
                BackupNotificationManager backupNotificationManager = new BackupNotificationManager(this.mContext);
                c12295b.m73870G(getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
                c12295b.m73894w(checkBackupCouponShowTime(this.mContext, next.getCouponFrequency()));
                List<String> remindModes = next.getRemindModes();
                PopupLimitedResult popupLimitedResult = new PopupLimitedResult();
                if (remindModes != null && remindModes.contains("popup")) {
                    if (!isNewCardMatchIncentiveNotifyConfig(next)) {
                        return false;
                    }
                    checkDialogShowActivity(next, c12295b, userGradeCode, backupSpaceNotEnoughNeedData, popupLimitedResult);
                }
                if (remindModes != null && remindModes.contains("notification") && checkBackupCycleNotifyTime(this.mContext)) {
                    if (CloudSpaceNotifyUtil.getInstance().checkCloudNoticeOffCondition(NotifyConstants.NotificationReport.NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT_ACTIVITY)) {
                        C11839m.m70688i(TAG, "autoBackupFailNotifyWithActivity notice not fit Condition.");
                        NotificationReportUtil.reportCloudBackupNoSpace("0001", "0015");
                        return true;
                    }
                    cloudNoticeOffCheckResult.noticeCheckResult = true;
                    if (LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", next.getRemindPurposes(), next.getNoticeType()})) {
                        C11839m.m70688i(TAG, "show auto backup fail activity notify");
                        if (!isNewCardMatchIncentiveNotifyConfig(next)) {
                            return false;
                        }
                        backupNotificationManager.sendSpaceNotEnoughNotifyWithActivity(next, backupSpaceNotEnoughNeedData, true, c12295b);
                        activityNotifyCollectEvent(next);
                        NotificationReportUtil.reportCloudBackupActivityNoSpace("0007", "0003");
                        NoticeFreqControlManager.getInstance().recordLevelNoticeShow(next.getRemindPurposes(), "notification_bar");
                    } else {
                        C11839m.m70689w(TAG, "freq control check fail, notice type: " + next.getNoticeType());
                        if (popupLimitedResult.isLimit()) {
                            sendBackupFailIMMessage(backupSpaceNotEnoughNeedData, next);
                            recordSpaceNotifyRuleFrequency(this.mContext);
                        }
                    }
                }
                recordSpaceNotifyRuleFrequency(this.mContext);
            } else {
                C11839m.m70689w(TAG, "autoBackupFailNotifyWithActivity not satisfy frequency.");
                JsonArray jsonArray = new JsonArray();
                NotificationBIReportUtil.addDayOnceCheckFailNotice(jsonArray, next.getNoticeType(), String.valueOf(next.getId()));
                NotificationBIReportUtil.reportAutoBackupActivityDayonceCheckFail(jsonArray);
            }
        }
        C11839m.m70688i(TAG, "autoBackupFailNotifyWithActivity end");
        return true;
    }

    private void backupFailDialogActivityNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, NotificationWithActivity notificationWithActivity) {
        C11839m.m70688i(TAG, "backupFailDialogActivityNotify");
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "backupFailDialogActivityNotify backupSpaceNotEnoughNeedData is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.mContext, BackupNotificationActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, backupSpaceNotEnoughNeedData);
        C11839m.m70688i(TAG, "backupFailDialogActivityNotify =" + C0209d.m1295q(this.mContext));
        c12295b.m73864A(C0209d.m1295q(this.mContext));
        intent.putExtra("backup_space_not_enough_need_info_key", c12295b);
        intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(notificationWithActivity));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        this.mContext.startActivity(intent);
        clearDlgDelayInfo();
    }

    private void backupFailDialogNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, SpaceNotification spaceNotification) {
        C11839m.m70688i(TAG, "backupFailDialogNotify");
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "backupFailDialogNotify backupSpaceNotEnoughNeedData is null.");
            return;
        }
        try {
            backupSpaceNotEnoughNeedData.setFamilyShareMember(C11829c.m70629x0(true));
            Intent intent = new Intent();
            intent.setClass(this.mContext, BackupNotificationActivity.class);
            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, backupSpaceNotEnoughNeedData);
            c12295b.m73864A(C0209d.m1295q(this.mContext));
            intent.putExtra("backup_space_not_enough_need_info_key", c12295b);
            intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(spaceNotification));
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            this.mContext.startActivity(intent);
            clearDlgDelayInfo();
        } catch (C1412i e10) {
            C11839m.m70687e(TAG, e10.toString());
        }
    }

    private static BackupNotEnoughDlgInfo buildDlgInfo(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, int i10, boolean z10) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfo = new BackupNotEnoughDlgInfo();
        backupNotEnoughDlgInfo.setmBackupSpaceNotEnoughNeedData(backupSpaceNotEnoughNeedData);
        backupNotEnoughDlgInfo.setNeedInfo(c12295b);
        backupNotEnoughDlgInfo.setTimeStamp(System.currentTimeMillis());
        backupNotEnoughDlgInfo.setNotifyType(i10);
        backupNotEnoughDlgInfo.setAutoBackup(z10);
        return backupNotEnoughDlgInfo;
    }

    private MsgUserData buildUserData(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setNotifyType("cloudbackup_failed_suppression");
        msgUserData.setBackupSpaceNotEnoughNeedData(backupSpaceNotEnoughNeedData);
        return msgUserData;
    }

    public static void checkAndClearDlgDelayInfo(C12295b c12295b) {
        int iM73887p;
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfo;
        C12295b needInfo;
        if (c12295b == null || (iM73887p = c12295b.m73887p()) == 0) {
            return;
        }
        String strM62398u = C10028c.m62183d0(C0213f.m1377a()).m62398u();
        if (TextUtils.isEmpty(strM62398u) || (backupNotEnoughDlgInfo = (BackupNotEnoughDlgInfo) C12540b1.m75483a(strM62398u, BackupNotEnoughDlgInfo.class)) == null || (needInfo = backupNotEnoughDlgInfo.getNeedInfo()) == null || needInfo.m73887p() != iM73887p) {
            return;
        }
        C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
        InterfaceC12614b.get().clearConfigurable(BackupNotEnoughDlgSpInfo.class);
        C10028c.m62183d0(C0213f.m1377a()).m62353l(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE);
    }

    private boolean checkBackupCouponShowTime(Context context, float f10) {
        return new FrequencyManager().checkCouponFrequence(context, f10);
    }

    public static boolean checkBackupCycleNotifyTime(Context context) {
        return new FrequencyManager().checkBackupCycleNotifyTime(context);
    }

    public static int checkDialogPopButtonCount(NotificationWithActivity notificationWithActivity) {
        List<PopUpWithActivityGoto> popupeGoto = notificationWithActivity.getPopupeGoto();
        if (popupeGoto == null || popupeGoto.size() <= 0) {
            return -1;
        }
        int size = popupeGoto.size();
        NotifyLogger.m29915i(TAG, "checkDialogPopButtonCount popSize = " + size);
        if (size == 3) {
            NoticeContentRoot noticeContent = notificationWithActivity.getNoticeContent();
            if (noticeContent == null) {
                NotifyLogger.m29914e(TAG, "contentRoot null");
                return -1;
            }
            if (noticeContent.getNoticePopup() == null) {
                return -1;
            }
            Iterator<PopUpWithActivityGoto> it = popupeGoto.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().getPopupType())) {
                    size--;
                }
                if (size < 2) {
                    return -1;
                }
            }
        }
        NotifyLogger.m29915i(TAG, "checkDialogPopButtonCount button count = " + size);
        return size;
    }

    private void checkDialogShow(SpaceNotification spaceNotification, C12295b c12295b, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, PopupLimitedResult popupLimitedResult) {
        if (!checkSpaceDialogRuleFrequency(this.mContext, spaceNotification)) {
            C11839m.m70689w(TAG, "checkDialogShow, dialog freq check fail");
            UserNegFeedbackManager.getInstance(this.mContext).reportNegChecked(spaceNotification);
            return;
        }
        if (!LevelFrequencyController.getInstance().check(new Object[]{"desk_popup", spaceNotification.getRemindPurposes(), spaceNotification.getNoticeType()})) {
            C11839m.m70689w(TAG, "freq control check fail, notice type: " + spaceNotification.getNoticeType());
            recordSpaceNotifyRuleFrequency(this.mContext);
            popupLimitedResult.setLimit(true);
            return;
        }
        if (checkUserCloseOperator(backupSpaceNotEnoughNeedData, spaceNotification)) {
            return;
        }
        if (!NotifyUtil.isDialogSilent(this.mContext, spaceNotification)) {
            execAutoBackupFailNotify(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
            recordDialogShowFrequency(this.mContext);
            NoticeFreqControlManager.getInstance().recordLevelNoticeShow(spaceNotification.getRemindPurposes(), "desk_popup");
            return;
        }
        boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
        C11839m.m70689w(TAG, "in silent time, dialog not show silentDelay = " + zIsSilentDelay);
        if (!zIsSilentDelay) {
            NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK);
            NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK);
        } else {
            setSpaceScreenStateLis(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
            NotificationBIReportUtil.reportDialogMutedDelay(NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK);
            NotificationReportUtil.reportDialogMutedDelay(NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK);
        }
    }

    private void checkDialogShowActivity(NotificationWithActivity notificationWithActivity, C12295b c12295b, String str, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, PopupLimitedResult popupLimitedResult) {
        if (!checkSpaceDialogRuleFrequency(this.mContext, notificationWithActivity)) {
            C11839m.m70689w(TAG, "checkDialogShowActivity, dialog freq check fail");
            UserNegFeedbackManager.getInstance(this.mContext).reportNegChecked(notificationWithActivity);
            return;
        }
        if (!LevelFrequencyController.getInstance().check(new Object[]{"desk_popup", notificationWithActivity.getRemindPurposes(), notificationWithActivity.getNoticeType()})) {
            C11839m.m70689w(TAG, "freq control check fail, notice type: " + notificationWithActivity.getNoticeType());
            recordSpaceNotifyRuleFrequency(this.mContext);
            popupLimitedResult.setLimit(true);
            return;
        }
        if (checkUserCloseOperator(backupSpaceNotEnoughNeedData, notificationWithActivity)) {
            return;
        }
        int iCheckDialogPopButtonCount = checkDialogPopButtonCount(notificationWithActivity);
        c12295b.m73873J(iCheckDialogPopButtonCount);
        c12295b.m73896y(notificationWithActivity.getEnableNewCard());
        c12295b.m73865B(str);
        c12295b.m73892u(true);
        if (!NotifyUtil.isDialogSilent(this.mContext, notificationWithActivity)) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0022", "0011_" + iCheckDialogPopButtonCount);
            execAutoBackupFailNotifyActivity(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
            recordDialogShowFrequency(this.mContext);
            NoticeFreqControlManager.getInstance().recordLevelNoticeShow(notificationWithActivity.getRemindPurposes(), "desk_popup");
            return;
        }
        boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
        C11839m.m70689w(TAG, "in silent time, dialog not show silentDelay = " + zIsSilentDelay);
        if (!zIsSilentDelay) {
            NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK);
            NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK);
        } else {
            dealShowRenewAgreement(c12295b, null, notificationWithActivity);
            setActivitySpaceScreenLis(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
            NotificationBIReportUtil.reportDialogMutedDelay(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK);
            NotificationReportUtil.reportDialogMutedDelay(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK);
        }
    }

    private boolean checkFrequencySatify(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity != null) {
            return checkSpaceNotifyRuleFrequency(this.mContext, notificationWithActivity);
        }
        C11839m.m70687e(TAG, "checkFrequencySatify notificationFrequency is null");
        return false;
    }

    private static boolean checkIsSupportHicloudActives() {
        if (C11829c.m70530L0()) {
            return true;
        }
        NotifyLogger.m29916w(TAG, "checkIsSupportHicloudActives not support pps ads");
        return false;
    }

    private boolean checkNotifyData(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, " taskCenter backupSpaceNotEnoughNeedData is null");
            return true;
        }
        if (!C13452e.m80781L().m80795D0()) {
            return false;
        }
        C11839m.m70687e(TAG, " taskCenter is child account, can not show.");
        return true;
    }

    public static boolean checkSpaceDialogRuleFrequency(Context context, BaseNotifyBean baseNotifyBean) {
        return new FrequencyManager().checkBackupFailDialogFrequency(context, baseNotifyBean);
    }

    public static boolean checkSpaceNotifyRuleFrequency(Context context, BaseNotifyBean baseNotifyBean) {
        return new FrequencyManager().checkBackupFailNotifyFrequency(context, baseNotifyBean);
    }

    private boolean checkUserCloseOperator(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, BaseSpaceNotifyBean baseSpaceNotifyBean) throws Resources.NotFoundException, NumberFormatException {
        if (!C10028c.m62182c0().m62248N0()) {
            return false;
        }
        C11839m.m70688i(TAG, "user close dialog notify");
        C10811y.m65822f("SpaceNotEnoughV5Error", "3", "user close dialog notify");
        if (NoticeFreqControlManager.getInstance().getMatchedFreqControlBean() == null) {
            sendBackupFailIMMessageNew(backupSpaceNotEnoughNeedData, baseSpaceNotifyBean, "HiCloudBackupSpaceInsuffNotice");
            return true;
        }
        C11839m.m70688i(TAG, "sendBackupFailIMMessage");
        sendBackupFailIMMessage(backupSpaceNotEnoughNeedData, baseSpaceNotifyBean);
        return true;
    }

    public static void clearDlgDelayInfo() {
        try {
            InterfaceC12614b.get().clearConfigurable(BackupNotEnoughDlgSpInfo.class);
            String strM62398u = C10028c.m62183d0(C0213f.m1377a()).m62398u();
            if (TextUtils.isEmpty(strM62398u) || ((BackupNotEnoughDlgInfo) C12540b1.m75483a(strM62398u, BackupNotEnoughDlgInfo.class)) == null) {
                return;
            }
            C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "clearDlgDelayInfo error, " + e10.toString());
        }
    }

    private void dealShowRenewAgreement(C12295b c12295b, SpaceNotification spaceNotification, NotificationWithActivity notificationWithActivity) {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                C11839m.m70688i(TAG, "dealShowRenewAgreement, switch is close.");
                return;
            }
            List<CloudPackage> spacePackages = c12295b.m73885n().getSpacePackages();
            if (spacePackages == null || spacePackages.isEmpty()) {
                C11839m.m70687e(TAG, "dealShowRenewAgreement, cloudPackageList is null or emptry.");
                return;
            }
            int iM67655j = 0;
            int productType = spacePackages.get(0).getProductType();
            if (productType == 6 || productType == 8 || productType == 12) {
                int iM73888q = c12295b.m73888q();
                int iM73881j = c12295b.m73881j();
                if (iM73881j == 0 || iM73888q == 2) {
                    if (iM73881j == 0) {
                        iM67655j = C11273b.m67656k(spaceNotification);
                    } else if (iM73881j == 1 || iM73881j == 2) {
                        iM67655j = C11273b.m67655j(notificationWithActivity);
                    }
                    if (iM67655j != 4 && iM67655j != 6) {
                        C11839m.m70688i(TAG, "dealShowRenewAgreement, marketStyle is not recommend package.");
                        return;
                    }
                    C11060c c11060c = new C11060c();
                    c11060c.m66636B("06008");
                    c11060c.m66643I(C11058a.m66627b("06008"));
                    c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
                    c11060c.m66670z("2.0");
                    try {
                        GetClientUIConfigResp getClientUIConfigRespM61703z = C9948a.m61631C().m61703z(c11060c);
                        c12295b.m73869F(getClientUIConfigRespM61703z.getPackageCardAgreement());
                        c12295b.m73893v(getClientUIConfigRespM61703z.getCheckDialogRenewAgreement());
                    } catch (Exception e10) {
                        C11839m.m70687e(TAG, "getClientUIConfigResp, getClientUIConfigResp err : " + e10.toString());
                    }
                }
            }
        }
    }

    public static int diffDaysForNotice(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return (int) ((j10 - j11) / 8.64E7d);
    }

    private void doAutoBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, CloudNoticeOffCheckResult cloudNoticeOffCheckResult, BackupNotificationManager backupNotificationManager, List<SpaceNotification> list, List<PortraitAndGrade.UserTag> list2) throws JSONException, Resources.NotFoundException, NumberFormatException {
        C11839m.m70688i(TAG, "doAutoBackupFailNotify start.");
        String userGradeCode = getUserGradeCode("doAutoBackupFailNotify");
        if (!cloudNoticeOffCheckResult.noticeCheckResult && CloudSpaceNotifyUtil.getInstance().checkCloudNoticeOffCondition(NotifyConstants.NotificationReport.NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT)) {
            C11839m.m70688i(TAG, "autoBackupFailNotify notice not fit Condition.");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0016");
            return;
        }
        JsonArray jsonArray = new JsonArray();
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                break;
            }
            SpaceNotification spaceNotification = list.get(i10);
            String noticeType = spaceNotification.getNoticeType();
            List<String> remindModes = spaceNotification.getRemindModes();
            int id2 = spaceNotification.getId();
            if (NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(noticeType) && C10155f.m63260M(spaceNotification.getSupportGradeCodes(), userGradeCode) && CloudSpaceNotifyUtil.checkUserTag(list2, spaceNotification)) {
                if (!checkSpaceNotifyRuleFrequency(this.mContext, spaceNotification)) {
                    NotificationBIReportUtil.addDayOnceCheckFailNotice(jsonArray, noticeType, String.valueOf(id2));
                    NotificationReportUtil.reportCloudBackupNoSpace("0001", "0002");
                    C11839m.m70688i(TAG, "space rule frequency not satisfied");
                    if (!C0209d.m1217V0(spaceNotification.getUserGroupExtIDs())) {
                        break;
                    }
                } else {
                    C11839m.m70688i(TAG, "doAutoBackupFailNotify valid id = " + spaceNotification.getId());
                    GetPackagesBySpaceRuleResp recommendInfo = getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
                    boolean zCheckBackupCouponShowTime = checkBackupCouponShowTime(this.mContext, spaceNotification.getCouponFrequency());
                    C12295b c12295b = new C12295b();
                    c12295b.m73870G(recommendInfo);
                    c12295b.m73894w(zCheckBackupCouponShowTime);
                    c12295b.m73896y(spaceNotification.getEnableNewCard());
                    c12295b.m73865B(userGradeCode);
                    c12295b.m73892u(true);
                    c12295b.m73895x(filterDetailTextGoto(spaceNotification, "auto"));
                    c12295b.m73866C(0);
                    PopupLimitedResult popupLimitedResult = new PopupLimitedResult();
                    if (remindModes != null && remindModes.contains("popup")) {
                        checkDialogShow(spaceNotification, c12295b, backupSpaceNotEnoughNeedData, popupLimitedResult);
                    }
                    if (remindModes != null && remindModes.contains("notification") && checkBackupCycleNotifyTime(this.mContext)) {
                        C11839m.m70688i(TAG, "show auto backup fail notify");
                        if (!LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", spaceNotification.getRemindPurposes(), spaceNotification.getNoticeType()})) {
                            C11839m.m70689w(TAG, "freq control check fail, notice type: " + spaceNotification.getNoticeType());
                            if (popupLimitedResult.isLimit()) {
                                sendBackupFailIMMessage(backupSpaceNotEnoughNeedData, spaceNotification);
                            }
                            recordSpaceNotifyRuleFrequency(this.mContext);
                            return;
                        }
                        NotificationReportUtil.reportCloudBackupNoSpace("0003", "0003");
                        backupNotificationManager.sendSpaceNotEnoughNotify(spaceNotification, backupSpaceNotEnoughNeedData, true, c12295b);
                        notifyCollectEvent(id2, spaceNotification.getPercentage());
                    }
                    recordSpaceNotifyRuleFrequency(this.mContext);
                    NoticeFreqControlManager.getInstance().recordLevelNoticeShow(spaceNotification.getRemindPurposes(), "notification_bar");
                }
            }
            i10++;
        }
        C11839m.m70688i(TAG, "doAutoBackupFailNotify rule not satisfied");
        NotificationBIReportUtil.reportAutoBackupDayonceCheckFail(jsonArray);
    }

    private void execAutoBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, SpaceNotification spaceNotification) {
        C11839m.m70688i(TAG, "execAutoBackupFailNotify");
        if (popUpSpaceInsufficientNewWindow(backupSpaceNotEnoughNeedData, c12295b, spaceNotification)) {
            return;
        }
        dealShowRenewAgreement(c12295b, spaceNotification, null);
        if (C0209d.m1265i1(this.mContext) || isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
            backupFailDialogNotify(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
        } else {
            setSpaceScreenStateLis(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
        }
    }

    private void execAutoBackupFailNotifyActivity(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, NotificationWithActivity notificationWithActivity) {
        C11839m.m70688i(TAG, "execAutoBackupFailNotifyActivity");
        if (popUpSpaceInsufficientNewWindow(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity)) {
            return;
        }
        dealShowRenewAgreement(c12295b, null, notificationWithActivity);
        if (C0209d.m1265i1(this.mContext) || isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
            backupFailDialogActivityNotify(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
        } else {
            setActivitySpaceScreenLis(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
        }
    }

    private String filterDetailTextGoto(SpaceNotification spaceNotification, String str) {
        if (C0209d.m1205R0(spaceNotification.getDetailTextGoto())) {
            return NotifyConstants.MODIFY_BACKUP_DATA;
        }
        for (NoticeDetailTextGoto noticeDetailTextGoto : spaceNotification.getDetailTextGoto()) {
            if ((C13452e.m80781L().m80897c1() ? USER_TYPE_FREE : USER_TYPE_PAY).equalsIgnoreCase(noticeDetailTextGoto.getUser()) && str.equalsIgnoreCase(noticeDetailTextGoto.getType())) {
                return noticeDetailTextGoto.getUri();
            }
        }
        return NotifyConstants.MODIFY_BACKUP_DATA;
    }

    public static List<NotificationWithActivity> filterGiftNode(List<NotificationWithActivity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            C11839m.m70689w(TAG, "filterGiftList notificationWithActivityList is null");
            return arrayList;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            if (notificationWithActivity.getActivityType() != 1) {
                arrayList.add(notificationWithActivity);
            }
        }
        C11839m.m70688i(TAG, "filterGiftNode filterList size = " + arrayList.size());
        return arrayList;
    }

    public static List<NotificationWithActivity> filterIncentiveNode(List<NotificationWithActivity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            C11839m.m70689w(TAG, "filterIncentiveNode notificationWithActivityList is null");
            return arrayList;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            if (notificationWithActivity.getActivityType() == 1 && checkIsSupportHicloudActives()) {
                arrayList.add(notificationWithActivity);
            }
        }
        C11839m.m70688i(TAG, "filterIncentiveNode filterList size = " + arrayList.size());
        return arrayList;
    }

    private String getAutoBackupDlgInfo(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, int i10, boolean z10, SpaceNotification spaceNotification) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfoBuildDlgInfo = buildDlgInfo(backupSpaceNotEnoughNeedData, c12295b, i10, z10);
        backupNotEnoughDlgInfoBuildDlgInfo.setNotification(spaceNotification);
        return new Gson().toJson(backupNotEnoughDlgInfoBuildDlgInfo);
    }

    public static int getAutoBackupDlgTaskId() {
        return new Random().nextInt(10000) + 1;
    }

    public static long getAvailableSpace() throws C9721b {
        CloudSpace cloudSpaceM78754r = new C13049a(EnumC12999a.CLOUD_MORE, null).m78754r();
        return cloudSpaceM78754r.getTotal() - cloudSpaceM78754r.getUsed();
    }

    private Intent getCloudSpaceIntent(ExtraNotificationBean extraNotificationBean, boolean z10) {
        return z10 ? getMemberIntent(extraNotificationBean) : getGotoIntent(extraNotificationBean);
    }

    private List<NotificationWithActivity> getDlAppNotifications(List<NotificationWithActivity> list, long j10, C12295b c12295b) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i(TAG, "getDlAppNotification dlAppNotifications is null or empty");
            return null;
        }
        GetActivityEntryResp getActivityEntryRespM67735i = C11289l.m67735i(j10, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        if (getActivityEntryRespM67735i == null) {
            C11839m.m70687e(TAG, "getDlAppNotification getActivityEntryResp is null.");
            return null;
        }
        ActivityEntry entry = getActivityEntryRespM67735i.getEntry();
        long clientVersion = getActivityEntryRespM67735i.getClientVersion();
        if (list.size() > 1) {
            NoticeWithActivityUtil.sortNotifyConfigWithActivity(list);
        }
        HicloudH5ConfigManager.getInstance().checkH5ClientVersion(clientVersion);
        List<NotificationWithActivity> specificNotificationList = getSpecificNotificationList(list, entry, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        if (specificNotificationList == null || specificNotificationList.isEmpty()) {
            C11839m.m70687e(TAG, "getDlAppNotification specificNotificationList is null.");
            return null;
        }
        if (!C11289l.m67731e(entry, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, 1003, true)) {
            C11839m.m70689w(TAG, "getDlAppNotification checkPpsAdsIsOk result = false");
            return null;
        }
        if (c12295b != null) {
            c12295b.m73891t(entry);
            c12295b.m73866C(1);
        }
        return specificNotificationList;
    }

    public static ExtraNoticeConfiguration getExtraNoticeConfiguration() {
        NotificationConfig config = new HNCloudConfig().getConfig();
        if (config == null) {
            C11839m.m70688i(TAG, "notificationConfig is null");
            return null;
        }
        ExtraNotifyConfig hiCloudSpaceNoticeV2 = config.getHiCloudSpaceNoticeV2();
        if (hiCloudSpaceNoticeV2 == null) {
            return null;
        }
        return hiCloudSpaceNoticeV2.getConfiguration();
    }

    public static List<ExtraNotificationBean> getExtraNotificationBeanList() {
        ExtraNoticeConfiguration extraNoticeConfiguration = getExtraNoticeConfiguration();
        if (extraNoticeConfiguration == null) {
            return null;
        }
        return extraNoticeConfiguration.getNotification();
    }

    private List<NotificationWithActivity> getFilterNotificationWithActivities(List<NotificationWithActivity> list) {
        ArrayList arrayList = new ArrayList();
        NotificationWithActivity notificationWithActivity = list.get(0);
        List<String> userGroupExtIDs = notificationWithActivity.getUserGroupExtIDs();
        if (userGroupExtIDs == null || userGroupExtIDs.isEmpty()) {
            arrayList.addAll(list);
        } else {
            arrayList.add(notificationWithActivity);
        }
        return arrayList;
    }

    public static List<NotificationWithActivity> getGiftActivityNotificationList(String str, List<Integer> list, List<NotificationWithActivity> list2) {
        PayActivityInfo recommendActivityInfo = TextUtils.equals(str, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT) ? getRecommendActivityInfo(list, NotifyConstants.MarketingConstant.CSOURCE_VALUE_BACKUP_FAIL_NOTIFICATION_POPUP) : getRecommendActivityInfo(list, 401);
        if (recommendActivityInfo == null) {
            NotifyLogger.m29916w(TAG, "getGiftActivityNotificationList payActivityInfo is null.");
            return null;
        }
        int i10 = recommendActivityInfo.getcType();
        String str2 = recommendActivityInfo.getcId();
        List<NotificationWithActivity> listIsContainCtypeNotiConfigList = NoticeWithActivityUtil.isContainCtypeNotiConfigList(list2, i10);
        if (listIsContainCtypeNotiConfigList == null || listIsContainCtypeNotiConfigList.size() <= 0) {
            NotifyLogger.m29916w(TAG, "getGiftActivityNotificationList specificNotificationList is null");
            return null;
        }
        SpaceNoticeCommonSpUtil.getInstance().clear(str);
        SpaceNoticeCommonSpUtil.getInstance().setCType(str, i10);
        SpaceNoticeCommonSpUtil.getInstance().setCId(str, str2);
        return listIsContainCtypeNotiConfigList;
    }

    public static List<NotificationWithActivity> getGiftNode(List<NotificationWithActivity> list, String str) {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "getGiftNode giftNodeList is null");
            return null;
        }
        if (list.size() > 1) {
            NoticeWithActivityUtil.sortNotifyConfigWithActivity(list);
        }
        List<NotificationWithActivity> giftActivityNotificationList = getGiftActivityNotificationList(str, C10155f.m63284h(list), list);
        if (giftActivityNotificationList == null || giftActivityNotificationList.isEmpty()) {
            NotifyLogger.m29916w(TAG, "getGiftNode specificNotification is null");
            return null;
        }
        NotifyLogger.m29915i(TAG, "end getGiftNode SpaceNoticeWithActivityList");
        return giftActivityNotificationList;
    }

    private List<NotificationWithActivity> getGiftNotifications(List<NotificationWithActivity> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i(TAG, "getNewPhoneNotification newPhoneNotification is null or empty");
            return null;
        }
        if (list.size() > 1) {
            NoticeWithActivityUtil.sortNotifyConfigWithActivity(list);
        }
        List<NotificationWithActivity> giftActivityNotificationList = getGiftActivityNotificationList(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, C10155f.m63284h(list), list);
        if (giftActivityNotificationList != null && !giftActivityNotificationList.isEmpty()) {
            return giftActivityNotificationList;
        }
        C11839m.m70687e(TAG, "getNewPhoneNotification specificNotificationList is null.");
        return null;
    }

    private Intent getGotoIntent(ExtraNotificationBean extraNotificationBean) {
        if (extraNotificationBean == null) {
            C11839m.m70688i(TAG, "getGotoIntent spaceNotification is null");
            return null;
        }
        Intent intent = new Intent();
        int id2 = extraNotificationBean.getId();
        intent.setClass(this.mContext, CloudSpaceGuideActivity.class);
        NoticeDetail noticeDetail = extraNotificationBean.getNoticeDetail();
        if (noticeDetail == null) {
            C11839m.m70688i(TAG, "detailContent is null");
            return null;
        }
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        intent.putExtra("packageName", extraNotificationBean.getChannelContent().getAppId());
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, extraNotificationBean.getPercentage());
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        recommendNeedData.setId(id2);
        String noticeContent = getNoticeContent(noticeDetail.getTitle());
        if (TextUtils.isEmpty(noticeContent)) {
            C11839m.m70688i(TAG, "titleText is null");
            return null;
        }
        recommendNeedData.setTitle(noticeContent);
        recommendNeedData.setMainText((this.galleryNum <= 0 || this.backupNeedSpace <= 0 || C2783d.m16105R()) ? getNoticeContent(noticeDetail.getMainTextSecond()) : getNoticeContent(noticeDetail.getMainText()));
        recommendNeedData.setChooseOtherCaseText(getNoticeContent(noticeDetail.getButtonFirst()));
        recommendNeedData.setRecommendType(extraNotificationBean.getNoticeType());
        recommendNeedData.setTotalNeedSpace(this.totalNeedSpace);
        recommendNeedData.setBackupNeedSpace(this.backupNeedSpace);
        recommendNeedData.setNotUsedSpace(this.notUsedSpace);
        recommendNeedData.setGalleryNum(this.galleryNum);
        recommendNeedData.setChannelId(extraNotificationBean.getChannelContent().getChannelId());
        recommendNeedData.setAppId(extraNotificationBean.getChannelContent().getAppId());
        intent.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        return intent;
    }

    public static String getGradeCodeUseCache(String str) {
        NotifyLogger.m29915i(TAG, "getGradeCodeUseCache");
        long jM80794D = C13452e.m80781L().m80794D();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jM80794D > 0 && jCurrentTimeMillis - jM80794D < 86400000) {
            String strM80790C = C13452e.m80781L().m80790C();
            if (strM80790C == null) {
                return "";
            }
            NotifyLogger.m29915i(TAG, "getGradeCodeUseCache, gradeCode is " + strM80790C);
            return strM80790C;
        }
        NotifyLogger.m29915i(TAG, "getGradeCodeUseCache request");
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b(str + "_grade"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        try {
            PortraitAndGrade portraitAndGradeM61727d = C9950c.m61724c().m61727d(c11060c);
            NotifyLogger.m29915i(TAG, "getPortraitAll end.");
            PortraitAndGrade.GradeRights gradeRights = portraitAndGradeM61727d.getGradeRights();
            if (gradeRights == null) {
                return "";
            }
            String gradeCode = gradeRights.getGradeCode();
            if (!TextUtils.isEmpty(gradeCode)) {
                C10155f.m63265R(portraitAndGradeM61727d);
            }
            NotifyLogger.m29915i(TAG, "getGradeCode from server, grade code is " + gradeCode);
            return gradeCode;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getGradeCode exception: " + e10.toString());
            return "";
        }
    }

    public static HiCloudSpaceNoticeConfiguration getHiCloudSpaceNoticeConfiguration() {
        NotificationConfig configFromFile = new NotificationConfigManager().getConfigFromFile();
        if (configFromFile == null) {
            C11839m.m70688i(TAG, "notificationConfig is null");
            return null;
        }
        SpaceNotifyConfig hiCloudSpaceNotice = configFromFile.getHiCloudSpaceNotice();
        if (hiCloudSpaceNotice == null) {
            return null;
        }
        return hiCloudSpaceNotice.getConfiguration();
    }

    public static List<NotificationWithActivity> getIncentiveNode(List<NotificationWithActivity> list, GetActivityEntryResp getActivityEntryResp, String str) {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "getIncentiveNode incentiveNodeList is null");
            return null;
        }
        if (getActivityEntryResp == null) {
            NotifyLogger.m29916w(TAG, "getIncentiveNode getActivityEntryResp is null");
            return null;
        }
        ActivityEntry entry = getActivityEntryResp.getEntry();
        long clientVersion = getActivityEntryResp.getClientVersion();
        if (entry == null) {
            NotifyLogger.m29916w(TAG, "getIncentiveNode activityEntry is null");
            return null;
        }
        if (list.size() > 1) {
            NoticeWithActivityUtil.sortNotifyConfigWithActivity(list);
        }
        HicloudH5ConfigManager.getInstance().checkH5ClientVersion(clientVersion);
        List<NotificationWithActivity> specificNotificationList = getSpecificNotificationList(list, entry, str);
        if (specificNotificationList == null || specificNotificationList.isEmpty()) {
            NotifyLogger.m29916w(TAG, "getIncentiveNode specificNotificationList is null");
            return null;
        }
        if (C11289l.m67731e(entry, str, 1004, true)) {
            NotifyLogger.m29915i(TAG, "end getIncentiveNode SpaceNoticeWithActivityList");
            return specificNotificationList;
        }
        NotifyLogger.m29916w(TAG, "getSpecificNotificationList checkPpsAdsIsOk result = false");
        return null;
    }

    private Intent getMemberIntent(ExtraNotificationBean extraNotificationBean) {
        if (extraNotificationBean == null) {
            C11839m.m70687e(TAG, "getMemberIntent spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeDetailMember = extraNotificationBean.getNoticeDetailMember();
        if (noticeDetailMember == null) {
            C11839m.m70688i(TAG, "detailContent is null");
            return null;
        }
        String noticeContent = getNoticeContent(noticeDetailMember.getTitle());
        if (TextUtils.isEmpty(noticeContent)) {
            C11839m.m70688i(TAG, "titleText is null");
            return null;
        }
        String noticeContent2 = getNoticeContent(noticeDetailMember.getMainText());
        if (TextUtils.isEmpty(noticeContent2)) {
            C11839m.m70688i(TAG, "localMainText is null");
            return null;
        }
        String noticeContent3 = getNoticeContent(noticeDetailMember.getButtonFirst());
        if (TextUtils.isEmpty(noticeContent3)) {
            C11839m.m70688i(TAG, "buttonText is null");
            return null;
        }
        MemberShareDetail memberShareDetail = new MemberShareDetail();
        memberShareDetail.setTitle(noticeContent);
        memberShareDetail.setMainText(noticeContent2);
        memberShareDetail.setButtonText(noticeContent3);
        memberShareDetail.setNotifyType(extraNotificationBean.getNoticeType());
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudSpaceMemberShareActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail);
        intent.putExtra("packageName", extraNotificationBean.getChannelContent().getAppId());
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, extraNotificationBean.getPercentage());
        return intent;
    }

    private String getNoticeContent(String str) {
        if (str != null) {
            return ExtraNoticeConfigManager.getInstance().getExtraNoticeLanguage(str);
        }
        C11839m.m70686d(TAG, "noticeKey is null");
        return null;
    }

    public static List<SpaceNotification> getNotification() {
        SpaceNoticeV4Bean spaceNoticeConfigV4 = SpaceInsuffNoticeV4Manager.getInstance().getSpaceNoticeConfigV4();
        if (spaceNoticeConfigV4 == null) {
            C11839m.m70688i(TAG, "notificationConfig is null");
            return null;
        }
        SpaceInsufficientNoticeConfiguration configuration = spaceNoticeConfigV4.getConfiguration();
        if (configuration == null) {
            return null;
        }
        return configuration.getNotification();
    }

    private List<NotificationWithActivity> getNotificationTaskCenter(String str, List<PortraitAndGrade.UserTag> list, C12295b c12295b) {
        List<NotificationWithActivity> listMatchNotificationTaskCenter = matchNotificationTaskCenter(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, str, list);
        if (listMatchNotificationTaskCenter == null || listMatchNotificationTaskCenter.size() <= 0) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0020", "0004");
            C11839m.m70687e(TAG, "getNotificationWithActivity not support NotificationWithActivity");
            return null;
        }
        if (isFamilyShareMember()) {
            return null;
        }
        return getTaskCenterNotifications(listMatchNotificationTaskCenter, c12295b);
    }

    private List<NotificationWithActivity> getNotificationWithActivity(String str, List<PortraitAndGrade.UserTag> list, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b) {
        List<NotificationWithActivity> listIsSupportNotificationActivity = isSupportNotificationActivity(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, str, list);
        if (listIsSupportNotificationActivity == null || listIsSupportNotificationActivity.size() <= 0) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0005", "0004");
            C11839m.m70687e(TAG, "getNotificationWithActivity not support NotificationWithActivity");
            return null;
        }
        if (isFamilyShareMember()) {
            return null;
        }
        List<NotificationWithActivity> dlAppNotifications = getDlAppNotifications(C10155f.m63280d(listIsSupportNotificationActivity), backupSpaceNotEnoughNeedData.getTotalNeedSpace(), c12295b);
        return (dlAppNotifications == null || dlAppNotifications.isEmpty()) ? getGiftNotifications(C10155f.m63281e(listIsSupportNotificationActivity)) : dlAppNotifications;
    }

    public static List<NotificationWithActivity> getNotificationWithActivityList() {
        HiCloudSpaceNoticeConfiguration hiCloudSpaceNoticeConfiguration = getHiCloudSpaceNoticeConfiguration();
        if (hiCloudSpaceNoticeConfiguration == null) {
            return null;
        }
        return hiCloudSpaceNoticeConfiguration.getNotificationWithActivity();
    }

    public static List<NotificationWithActivity> getNotificationWithTaskCenter() {
        SpaceNoticeV4Bean spaceNoticeConfigV4 = SpaceInsuffNoticeV4Manager.getInstance().getSpaceNoticeConfigV4();
        if (spaceNoticeConfigV4 == null) {
            C11839m.m70688i(TAG, "notificationConfig is null");
            return null;
        }
        SpaceInsufficientNoticeConfiguration configuration = spaceNoticeConfigV4.getConfiguration();
        if (configuration == null) {
            return null;
        }
        return configuration.getNotificationWithTaskCenter();
    }

    public static PayActivityInfo getRecommendActivityInfo(List<Integer> list, int i10) {
        GetRecommendActivityResp getRecommendActivityRespM61640I;
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29915i(TAG, "getRecommendActivityInfo typeList is null");
            return null;
        }
        C11289l.m67732f();
        PayActivityInfo payActivityInfo = new PayActivityInfo();
        try {
            C11060c c11060c = new C11060c();
            c11060c.m66636B("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            getRecommendActivityRespM61640I = C9948a.m61631C().m61640I(list, i10, c11060c);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getRecommendActivityResp error " + e10.getMessage());
        }
        if (getRecommendActivityRespM61640I == null) {
            return null;
        }
        payActivityInfo = getRecommendActivityRespM61640I.getPayActivityInfo();
        if (payActivityInfo != null) {
            NotifyLogger.m29915i(TAG, "getRecommendActivityInfo payActivityInfo != null");
        }
        return payActivityInfo;
    }

    private List<NotifyWay> getRemindWays(BaseNotifyBean baseNotifyBean, FreqControlBean freqControlBean) {
        if (freqControlBean == null) {
            C11839m.m70689w(TAG, "controlBean or notifyBean is null!");
            return new ArrayList(0);
        }
        if (baseNotifyBean == null || baseNotifyBean.getRemindWays() == null || baseNotifyBean.getRemindWays().isEmpty()) {
            return freqControlBean.getRemindWays();
        }
        NotifyWay notifyWayOrElse = baseNotifyBean.getRemindWays().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.f1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return UserSpaceUtil.lambda$getRemindWays$1((NotifyWay) obj);
            }
        }).findFirst().orElse(null);
        if (notifyWayOrElse == null) {
            C11839m.m70689w(TAG, "not have sms notify way!");
            return freqControlBean.getRemindWays();
        }
        ArrayList arrayList = freqControlBean.getRemindWays() == null ? new ArrayList(1) : new ArrayList(freqControlBean.getRemindWays());
        arrayList.add(notifyWayOrElse);
        return arrayList;
    }

    public static List<SpaceNotification> getSpaceNotificationList() {
        HiCloudSpaceNoticeConfiguration hiCloudSpaceNoticeConfiguration = getHiCloudSpaceNoticeConfiguration();
        if (hiCloudSpaceNoticeConfiguration == null) {
            return null;
        }
        return hiCloudSpaceNoticeConfiguration.getNotification();
    }

    public static List<NotificationWithActivity> getSpecificNotificationList(List<NotificationWithActivity> list, ActivityEntry activityEntry, String str) {
        if (activityEntry == null) {
            NotifyLogger.m29916w(TAG, "getSpecificNotificationList activityEntry is null.");
            return null;
        }
        String resource = activityEntry.getResource();
        String url = activityEntry.getUrl();
        if (TextUtils.isEmpty(resource) || TextUtils.isEmpty(url)) {
            NotifyLogger.m29916w(TAG, "getSpecificNotificationList resource or url is null.");
            return null;
        }
        if (!HicloudH5ConfigManager.getInstance().isHasResourceId(resource)) {
            NotifyLogger.m29916w(TAG, "getSpecificNotificationList not has resourceId.");
            return null;
        }
        String str2 = activityEntry.getcType();
        if (!str2.equals("dlApp")) {
            NotifyLogger.m29916w(TAG, "getSpecificNotificationList cType is not right. cType = " + str2);
            return null;
        }
        AdParametersExt adParametersExt = activityEntry.getCampaignInfo().getAdParametersExt();
        if (adParametersExt == null) {
            C11839m.m70687e(TAG, " parametersExt is null");
            return null;
        }
        String ppsAdid = adParametersExt.getPpsAdid();
        List<NotificationWithActivity> listIsContainCtypeNotiConfigList = NoticeWithActivityUtil.isContainCtypeNotiConfigList(list, 1);
        if (listIsContainCtypeNotiConfigList == null || listIsContainCtypeNotiConfigList.size() <= 0) {
            NotifyLogger.m29916w(TAG, "getSpecificNotificationList specificNotification is null");
            return null;
        }
        SpaceNoticeCommonSpUtil.getInstance().clear(str);
        SpaceNoticeCommonSpUtil.getInstance().setCType(str, 1);
        SpaceNoticeCommonSpUtil.getInstance().setAdId(str, ppsAdid);
        return listIsContainCtypeNotiConfigList;
    }

    public static StorageInfo getStorageInfo() {
        return storageInfo;
    }

    private List<NotificationWithActivity> getTaskCenterNotifications(List<NotificationWithActivity> list, C12295b c12295b) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i(TAG, "getTaskCenterNotifications dlAppNotifications is null or empty");
            return null;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i(TAG, "getTaskCenterNotifications isChildAccount");
            return null;
        }
        if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "getTaskCenterNotifications getCloudSpaceFunctionItemSwitch is closed");
            return null;
        }
        GetCampaignActivityEntryResp getCampaignActivityEntryRespM63414a = new C10252o(3).m63414a();
        if (c12295b != null && getCampaignActivityEntryRespM63414a != null) {
            c12295b.m73897z(getCampaignActivityEntryRespM63414a.isExceedRedemptionLimit());
            c12295b.m73866C(2);
            if (getCampaignActivityEntryRespM63414a.isExceedRedemptionLimit() || getCampaignActivityEntryRespM63414a.isNoActivitiesAvailable()) {
                return null;
            }
        }
        if (!C9718g.m60602t().m60612J(C0213f.m1377a())) {
            C11839m.m70688i(TAG, "getTaskCenterNotifications not show");
            return null;
        }
        if (C9718g.m60602t().m60606D(C0213f.m1377a())) {
            C11839m.m70688i(TAG, "getTaskCenterNotifications activity finished");
            return null;
        }
        if (!CampaignCheckUtil.checkCampaignEntryCondition(C0213f.m1377a())) {
            C11839m.m70688i(TAG, "getTaskCenterNotifications checkCampaignEntryCondition");
            return null;
        }
        if (list.size() > 1) {
            NoticeWithActivityUtil.sortNotifyConfigWithActivity(list);
        }
        return list;
    }

    private String getUserGradeCode(String str) {
        return getGradeCodeUseCache(str);
    }

    private List<PortraitAndGrade.UserTag> getUserTags(String str) {
        return getUserTagsUseCache(str);
    }

    public static List<PortraitAndGrade.UserTag> getUserTagsUseCache(String str) {
        NotifyLogger.m29915i(TAG, "getUserTagUseCache");
        long jM80983w0 = C13452e.m80781L().m80983w0();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jM80983w0 > 0 && jCurrentTimeMillis - jM80983w0 < 86400000) {
            return C14306d.m85204e();
        }
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b(str + "_tags"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        try {
            PortraitAndGrade portraitAndGradeM61727d = C9950c.m61724c().m61727d(c11060c);
            PortraitAndGrade.UserTagList userTagList = portraitAndGradeM61727d.getUserTagList();
            if (userTagList == null) {
                return new ArrayList();
            }
            List<PortraitAndGrade.UserTag> userTags = userTagList.getUserTags();
            if (userTags == null) {
                userTags = new ArrayList<>();
            }
            C10155f.m63265R(portraitAndGradeM61727d);
            return userTags;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getUserTagsUseCache exception: " + e10.toString());
            return C14306d.m85204e();
        }
    }

    private static int getVoucherAvailableDays(long j10, long j11) {
        int iDiffDaysForNotice;
        NotifyLogger.m29914e(TAG, "getVoucherAvailableDays, voucherExpireTime is: " + j10 + ", server current time: " + j11);
        if (j10 < j11 || j11 <= 0) {
            iDiffDaysForNotice = -1;
        } else {
            iDiffDaysForNotice = diffDaysForNotice(j10, j11);
            NotifyLogger.m29913d(TAG, "calculate days use server time, calculateDays: " + iDiffDaysForNotice);
        }
        if (iDiffDaysForNotice >= 0) {
            return iDiffDaysForNotice;
        }
        int iDiffDaysForNotice2 = diffDaysForNotice(j10, System.currentTimeMillis());
        NotifyLogger.m29913d(TAG, "calculate days use client time, calculateDays: " + iDiffDaysForNotice2);
        return iDiffDaysForNotice2;
    }

    public static VoucherNotiDisplayInfo getVoucherNotiDisplayInfo(GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp) throws Resources.NotFoundException {
        Context contextM1377a;
        String string;
        String string2;
        RecommendVouchers recommendVouchersM67840x = C11296s.m67840x(getPackagesBySpaceRuleResp);
        if (recommendVouchersM67840x == null) {
            NotifyLogger.m29914e(TAG, "getVoucherInfo, recommend vouchers is null");
            return null;
        }
        List<Voucher> voucherList = recommendVouchersM67840x.getVoucherList();
        if (voucherList == null || voucherList.isEmpty()) {
            NotifyLogger.m29914e(TAG, "getVoucherInfo, recommend vouchers list is null");
            return null;
        }
        int size = voucherList.size();
        String voucherType = recommendVouchersM67840x.getVoucherType();
        contextM1377a = C0213f.m1377a();
        voucherType.hashCode();
        switch (voucherType) {
            case "0":
                string = contextM1377a.getString(R$string.voucher_type_common);
                break;
            case "1":
                string = contextM1377a.getString(R$string.voucher_type_full_reduce);
                break;
            case "2":
                string = contextM1377a.getString(R$string.voucher_type_discount);
                break;
            default:
                string = "";
                break;
        }
        BigDecimal discountAmount = recommendVouchersM67840x.getDiscountAmount();
        Voucher voucher = voucherList.get(0);
        String strM67747h = C11290m.m67747h(contextM1377a, discountAmount, voucher.getCurrency(), null);
        int voucherAvailableDays = getVoucherAvailableDays(voucher.getExpireTime(), getPackagesBySpaceRuleResp.getCurrentTime());
        if (voucherAvailableDays > 0) {
            string2 = contextM1377a.getResources().getQuantityString(R$plurals.voucher_available_days, voucherAvailableDays, NumberFormat.getInstance().format(voucherAvailableDays));
        } else {
            if (voucherAvailableDays != 0) {
                NotifyLogger.m29914e(TAG, "calculate available days is less than 0, calculate value is: " + voucherAvailableDays);
                return null;
            }
            string2 = contextM1377a.getString(R$string.voucher_available_today);
        }
        String voucherTitle = voucher.getVoucherTitle();
        if (size > 1) {
            voucherTitle = contextM1377a.getString(R$string.cloudpay_voucher_text);
        }
        NotifyLogger.m29915i(TAG, "getVoucherInfo voucherTitle: " + voucherTitle + ", voucherTypeStr: " + string + ", discountStr: " + strM67747h + ", availableDaysStr: " + string2);
        VoucherNotiDisplayInfo voucherNotiDisplayInfo = new VoucherNotiDisplayInfo();
        voucherNotiDisplayInfo.setDiscountAmount(strM67747h);
        voucherNotiDisplayInfo.setValidityDays(string2);
        voucherNotiDisplayInfo.setTitle(voucherTitle);
        voucherNotiDisplayInfo.setType(string);
        PackageGrades packageGrades = getPackagesBySpaceRuleResp.getPackageGrades().get(0);
        voucherNotiDisplayInfo.setGradeCode(packageGrades.getGradeCode());
        voucherNotiDisplayInfo.setPackageId(getPackagesBySpaceRuleResp.getSpacePackages().get(0).getId());
        voucherNotiDisplayInfo.setCapacity(packageGrades.getCapacity());
        return voucherNotiDisplayInfo;
    }

    public boolean isBackupForeground() {
        return C0209d.m1245d1(this.mContext, BackupMainActivity.class.getName()) || C0209d.m1245d1(this.mContext, CloudBackupDetailStateActivity.class.getName());
    }

    public static boolean isCanShowCoupon(GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp, int i10, boolean z10, Context context) {
        if (getPackagesBySpaceRuleResp == null) {
            return false;
        }
        List<Voucher> voucherList = getPackagesBySpaceRuleResp.getVoucherList();
        return z10 && C11296s.m67787K() && C11296s.m67789M(context) && voucherList != null && !voucherList.isEmpty() && i10 == 1;
    }

    private boolean isFamilyShareMember() {
        try {
            if (!C11829c.m70629x0(true)) {
                return false;
            }
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0005", "0012");
            C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity family share member not support NotificationWithActivity");
            return true;
        } catch (C1412i e10) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0005", "0012");
            C11839m.m70687e(TAG, e10.toString());
            return true;
        }
    }

    private boolean isNewCardMatchIncentiveNotifyConfig(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        int enableNewCard;
        if (baseSpaceNotifyBean == null || 2 != (enableNewCard = baseSpaceNotifyBean.getEnableNewCard())) {
            return true;
        }
        String strM80790C = C13452e.m80781L().m80790C();
        if (C13452e.m80781L().m80897c1()) {
            return true;
        }
        C11839m.m70688i(TAG, "enableNewCard: " + enableNewCard + ", gradeCode: " + strM80790C + ", not support incentive config");
        return false;
    }

    public static List<NotificationWithActivity> isSupportNotificationActivity(String str, String str2, List<PortraitAndGrade.UserTag> list) {
        ArrayList arrayList = new ArrayList();
        List<NotificationWithActivity> notificationWithActivity = getNotificationWithActivity();
        if (notificationWithActivity == null) {
            return null;
        }
        Collections.sort(notificationWithActivity, new CloudSpaceNotifyUtil.NotificationWithActivityComparator());
        if (notificationWithActivity.size() <= 0) {
            return null;
        }
        for (NotificationWithActivity notificationWithActivity2 : notificationWithActivity) {
            if (notificationWithActivity2 != null && TextUtils.equals(notificationWithActivity2.getNoticeType(), str) && C10155f.m63260M(notificationWithActivity2.getSupportGradeCodes(), str2) && CloudSpaceNotifyUtil.checkUserTag(list, notificationWithActivity2)) {
                arrayList.add(notificationWithActivity2);
            }
        }
        NotifyLogger.m29915i(TAG, "isSupportNotificationActivity noticeType = " + str + ", size = " + arrayList.size());
        return arrayList;
    }

    public static /* synthetic */ boolean lambda$getRemindWays$1(NotifyWay notifyWay) {
        return (notifyWay == null || TextUtils.isEmpty(notifyWay.getSmsTemplateId())) ? false : true;
    }

    private void manualBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, SpaceNotification spaceNotification) {
        C11839m.m70688i(TAG, "manualBackupFailNotify");
        if (checkUserCloseOperator(backupSpaceNotEnoughNeedData, spaceNotification) || popUpSpaceInsufficientNewWindow(backupSpaceNotEnoughNeedData, c12295b, spaceNotification)) {
            return;
        }
        dealShowRenewAgreement(c12295b, spaceNotification, null);
        if (C0209d.m1265i1(this.mContext) || isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
            backupFailDialogNotify(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
        } else {
            ScreenListener.m18023c(this.mContext).m18025b(new SpaceScreenStateListener(backupSpaceNotEnoughNeedData, c12295b, false, spaceNotification));
        }
    }

    private void manualBackupFailNotifyActivity(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, NotificationWithActivity notificationWithActivity) {
        C11839m.m70688i(TAG, "manualBackupFailNotifyActivity");
        if (checkUserCloseOperator(backupSpaceNotEnoughNeedData, notificationWithActivity) || popUpSpaceInsufficientNewWindow(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity)) {
            return;
        }
        dealShowRenewAgreement(c12295b, null, notificationWithActivity);
        if (C0209d.m1265i1(this.mContext) || isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
            backupFailDialogActivityNotify(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
        } else {
            ScreenListener.m18023c(this.mContext).m18025b(new ActivitySpaceScreenStateListener(backupSpaceNotEnoughNeedData, c12295b, false, notificationWithActivity));
        }
    }

    private boolean manualBackupFailNotifyTaskCenter(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, List<PortraitAndGrade.UserTag> list) {
        C11839m.m70688i(TAG, "taskCenter start");
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "taskCenter mContext is null");
            return false;
        }
        if (checkNotifyData(backupSpaceNotEnoughNeedData)) {
            return false;
        }
        String userGradeCode = getUserGradeCode("maBackupFailTaskCenter");
        List<NotificationWithActivity> listMatchNotificationTaskCenter = matchNotificationTaskCenter(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, userGradeCode, list);
        if (reportCloudBackupActivityNoSpace(listMatchNotificationTaskCenter)) {
            return false;
        }
        try {
            if (C11829c.m70629x0(true)) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0021", "0012");
                C11839m.m70687e(TAG, "family share member not support");
                return false;
            }
            List<NotificationWithActivity> taskCenterNotifications = getTaskCenterNotifications(listMatchNotificationTaskCenter, c12295b);
            if (taskCenterNotifications == null || taskCenterNotifications.isEmpty()) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0021", "0005");
                C11839m.m70687e(TAG, "taskCenter notifications is null");
                return false;
            }
            NotificationWithActivity notificationWithActivity = taskCenterNotifications.get(0);
            if (notificationWithActivity == null) {
                C11839m.m70687e(TAG, "taskCenter notification is null");
                return false;
            }
            if (!isNewCardMatchIncentiveNotifyConfig(notificationWithActivity)) {
                return false;
            }
            GetPackagesBySpaceRuleResp recommendInfo = getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
            int iCheckDialogPopButtonCount = checkDialogPopButtonCount(notificationWithActivity);
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0022", "0011_" + iCheckDialogPopButtonCount);
            boolean zCheckBackupCouponShowTime = checkBackupCouponShowTime(this.mContext, notificationWithActivity.getCouponFrequency());
            c12295b.m73870G(recommendInfo);
            c12295b.m73865B(userGradeCode);
            c12295b.m73892u(false);
            c12295b.m73894w(zCheckBackupCouponShowTime);
            c12295b.m73896y(notificationWithActivity.getEnableNewCard());
            c12295b.m73873J(iCheckDialogPopButtonCount);
            manualBackupFailNotifyActivity(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
            C11839m.m70688i(TAG, "taskCenter end. id = " + notificationWithActivity.getId());
            return true;
        } catch (C1412i e10) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0021", "0012");
            C11839m.m70687e(TAG, e10.toString());
            return false;
        }
    }

    public static List<NotificationWithActivity> matchNotificationTaskCenter(String str, String str2, List<PortraitAndGrade.UserTag> list) {
        ArrayList arrayList = new ArrayList();
        List<NotificationWithActivity> notificationWithTaskCenter = getNotificationWithTaskCenter();
        if (notificationWithTaskCenter == null) {
            return null;
        }
        Collections.sort(notificationWithTaskCenter, new CloudSpaceNotifyUtil.NotificationWithActivityComparator());
        if (notificationWithTaskCenter.size() <= 0) {
            return null;
        }
        for (NotificationWithActivity notificationWithActivity : notificationWithTaskCenter) {
            if (notificationWithActivity != null && TextUtils.equals(notificationWithActivity.getNoticeType(), str) && C10155f.m63260M(notificationWithActivity.getSupportGradeCodes(), str2) && CloudSpaceNotifyUtil.checkUserTag(list, notificationWithActivity)) {
                arrayList.add(notificationWithActivity);
            }
        }
        NotifyLogger.m29915i(TAG, "matchNotificationTaskCenter noticeType = " + str + ", size = " + arrayList.size());
        return arrayList;
    }

    private void newManualBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, List<PortraitAndGrade.UserTag> list) throws JSONException {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "newManualBackupFailNotify mContext is null");
            return;
        }
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "newManualBackupFailNotify backupSpaceNotEnoughNeedData is null");
            return;
        }
        SpaceNoticeCommonSpUtil.getInstance().clear(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        BackupNotificationManager backupNotificationManager = new BackupNotificationManager(this.mContext);
        List<SpaceNotification> notification = getNotification();
        if (notification == null) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            C11839m.m70688i(TAG, "NewManualBackupFailNotify notifications is null");
            return;
        }
        Collections.sort(notification, new CloudSpaceNotifyUtil.NotificationComparator());
        String userGradeCode = getUserGradeCode("newMaBackupFailNotify");
        for (int i10 = 0; i10 < notification.size(); i10++) {
            SpaceNotification spaceNotification = notification.get(i10);
            String noticeType = spaceNotification.getNoticeType();
            int id2 = spaceNotification.getId();
            if (noticeType != null && NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(noticeType) && C10155f.m63260M(spaceNotification.getSupportGradeCodes(), userGradeCode) && CloudSpaceNotifyUtil.checkUserTag(list, spaceNotification)) {
                C11839m.m70688i(TAG, "newManualBackupFailNotify id = " + id2);
                GetPackagesBySpaceRuleResp recommendInfo = getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
                boolean zCheckBackupCouponShowTime = checkBackupCouponShowTime(this.mContext, spaceNotification.getCouponFrequency());
                C12295b c12295b = new C12295b();
                c12295b.m73865B(userGradeCode);
                c12295b.m73870G(recommendInfo);
                c12295b.m73896y(spaceNotification.getEnableNewCard());
                c12295b.m73894w(zCheckBackupCouponShowTime);
                c12295b.m73892u(false);
                c12295b.m73895x(filterDetailTextGoto(spaceNotification, CBSbkFlowHead.BKMODE_MANUAL));
                c12295b.m73866C(0);
                manualBackupFailNotify(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
                backupNotificationManager.sendSpaceNotEnoughNotify(spaceNotification, backupSpaceNotEnoughNeedData, false, c12295b);
                notifyCollectEvent(id2, spaceNotification.getPercentage());
                NotificationReportUtil.reportCloudBackupNoSpace("0003", "0003");
                return;
            }
        }
    }

    private boolean newManualBackupFailNotifyWithActivity(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, List<PortraitAndGrade.UserTag> list) throws JSONException {
        C11839m.m70688i(TAG, "newManualBackupFailNotifyWithActivity start");
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity mContext is null");
            return false;
        }
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity backupSpaceNotEnoughNeedData is null");
            return false;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity is child account, can not show.");
            return false;
        }
        String userGradeCode = getUserGradeCode("newMaBackupFailWithActivity");
        List<NotificationWithActivity> listIsSupportNotificationActivity = isSupportNotificationActivity(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, userGradeCode, list);
        if (reportCloudBackupActivityNoSpace(listIsSupportNotificationActivity)) {
            return false;
        }
        try {
            if (C11829c.m70629x0(true)) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0006", "0012");
                C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity family share member not support NotificationWithActivity");
                return false;
            }
            C12295b c12295b = new C12295b();
            List<NotificationWithActivity> dlAppNotifications = getDlAppNotifications(C10155f.m63280d(listIsSupportNotificationActivity), backupSpaceNotEnoughNeedData.getTotalNeedSpace(), c12295b);
            if (dlAppNotifications == null || dlAppNotifications.isEmpty()) {
                dlAppNotifications = getGiftNotifications(C10155f.m63281e(listIsSupportNotificationActivity));
            }
            if (dlAppNotifications == null || dlAppNotifications.isEmpty()) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0006", "0005");
                C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity notifications is null");
                return false;
            }
            NotificationWithActivity notificationWithActivity = dlAppNotifications.get(0);
            if (notificationWithActivity == null) {
                C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity notification is null");
                return false;
            }
            if (!isNewCardMatchIncentiveNotifyConfig(notificationWithActivity)) {
                return false;
            }
            BackupNotificationManager backupNotificationManager = new BackupNotificationManager(this.mContext);
            GetPackagesBySpaceRuleResp recommendInfo = getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
            boolean zCheckBackupCouponShowTime = checkBackupCouponShowTime(this.mContext, notificationWithActivity.getCouponFrequency());
            int iCheckDialogPopButtonCount = checkDialogPopButtonCount(notificationWithActivity);
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0008", "0011_" + iCheckDialogPopButtonCount);
            c12295b.m73870G(recommendInfo);
            c12295b.m73894w(zCheckBackupCouponShowTime);
            c12295b.m73865B(userGradeCode);
            c12295b.m73892u(false);
            c12295b.m73896y(notificationWithActivity.getEnableNewCard());
            c12295b.m73873J(iCheckDialogPopButtonCount);
            c12295b.m73866C(1);
            backupNotificationManager.sendSpaceNotEnoughNotifyWithActivity(notificationWithActivity, backupSpaceNotEnoughNeedData, false, c12295b);
            activityNotifyCollectEvent(notificationWithActivity);
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0007", "0003");
            manualBackupFailNotifyActivity(backupSpaceNotEnoughNeedData, c12295b, notificationWithActivity);
            C11839m.m70688i(TAG, "newManualBackupFailNotifyWithActivity end. id = " + notificationWithActivity.getId());
            return true;
        } catch (C1412i e10) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0006", "0012");
            C11839m.m70687e(TAG, e10.toString());
            return false;
        }
    }

    private void notifyCollectEvent(int i10, float f10) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(this.mContext, "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put("notify_id", i10);
            jSONObjectM79482j.put("notify_type", "1");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(f10));
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29952M("CKC", "DYNAMIC_NOTIFY_SHOW", jSONObjectM79482j);
    }

    private boolean popUpSpaceInsufficientNewWindow(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        BackupSpaceInsufficientPopUpWindowNotify backupSpaceInsufficientPopUpWindowNotify = new BackupSpaceInsufficientPopUpWindowNotify(backupSpaceNotEnoughNeedData, baseSpaceNotifyBean, c12295b);
        if (!backupSpaceInsufficientPopUpWindowNotify.isSupportBackupSpaceInsufficientNewPopup()) {
            return false;
        }
        C11839m.m70688i(TAG, "backupSpaceInsufficientPopUpWindowNotify sendNotify");
        backupSpaceInsufficientPopUpWindowNotify.sendNotify();
        return true;
    }

    private void recordDialogShowFrequency(Context context) {
        C0212e0.m1370t(context, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.CHECKBACKUPFAILDIALOGTIME, System.currentTimeMillis());
    }

    public static void recordSpaceNotifyRuleFrequency(Context context) {
        C0212e0.m1370t(context, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.CHECKBACKUPFAILNOTIFYTIME, System.currentTimeMillis());
    }

    private boolean reportCloudBackupActivityNoSpace(List<NotificationWithActivity> list) {
        if (list != null && list.size() > 0) {
            return false;
        }
        NotificationReportUtil.reportCloudBackupActivityNoSpace("0006", "0004");
        C11839m.m70687e(TAG, "newManualBackupFailNotifyWithActivity not support NotificationWithActivity");
        return true;
    }

    public static void saveBackupFailPopupDelayInfo(String str) {
        if (!TextUtils.isEmpty(C10028c.m62183d0(C0213f.m1377a()).m62398u())) {
            C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
        }
        try {
            C10028c.m62183d0(C0213f.m1377a()).m62239L1(str);
            BackupNotEnoughDlgSpInfo backupNotEnoughDlgSpInfo = new BackupNotEnoughDlgSpInfo();
            backupNotEnoughDlgSpInfo.setJsonInfo(str);
            InterfaceC12614b.get().saveConfigurable(BackupNotEnoughDlgSpInfo.class, backupNotEnoughDlgSpInfo);
        } catch (Throwable th2) {
            C11839m.m70687e(TAG, "saveBackupFailPopupDelayInfo error, " + th2.toString());
            NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0001", "0021", th2.toString());
        }
    }

    public static void sendBackupFailIMMessageNew(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, BaseNotifyBean baseNotifyBean, String str) {
        C11839m.m70688i(TAG, "sendBackupFailIMMessageNew");
        String strM68061d = C11327e.m68061d(str);
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setNotifyType("cloudbackup_failed_suppression");
        msgUserData.setBackupSpaceNotEnoughNeedData(backupSpaceNotEnoughNeedData);
        baseNotifyBean.setNoticeType("cloudbackup_failed_suppression");
        MessageCenterManager.getInstance().invokeEvent(baseNotifyBean, strM68061d, str, msgUserData);
    }

    public static void sendMessage(Message message) {
        CBCallBack.getInstance().sendMessage(message);
    }

    public static void sendSpaceNotEnough(final boolean z10, final BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnough backupSpaceNotEnoughNeedData is null.");
        } else {
            IBackupNotEnoughNotify.get().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.e1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((IBackupNotEnoughNotify) obj).sendSpaceNotEnough(z10, backupSpaceNotEnoughNeedData);
                }
            });
        }
    }

    private void serviceAppGoto(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, Handler handler) {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "serviceAppGoto mContext is null");
            return;
        }
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "serviceAppGoto backupSpaceNotEnoughNeedData is null");
            Message message = new Message();
            message.what = 2;
            handler.sendMessage(message);
            return;
        }
        List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.THRID_APP_SPACE_INSUFFICIENT, getUserTagsUseCache("serviceAppGoto"));
        if (extraNotificationBean != null && extraNotificationBean.size() != 0) {
            serviceAppNeedData(backupSpaceNotEnoughNeedData, handler, extraNotificationBean.get(0));
            return;
        }
        C11839m.m70688i(TAG, "serviceAppGoto notificationBean is null");
        Message message2 = new Message();
        message2.what = 2;
        handler.sendMessage(message2);
    }

    private void serviceAppNeedData(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, Handler handler, ExtraNotificationBean extraNotificationBean) {
        C11839m.m70688i(TAG, "star serviceAppNeedData");
        if (C0209d.m1265i1(this.mContext) || C0209d.m1245d1(this.mContext, BackupMainActivity.class.getName()) || C0209d.m1245d1(this.mContext, GuideWebViewActivity.class.getName())) {
            startServiceApp(backupSpaceNotEnoughNeedData, handler, extraNotificationBean);
        }
    }

    private void setActivitySpaceScreenLis(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, NotificationWithActivity notificationWithActivity) {
        c12295b.m73872I(getAutoBackupDlgTaskId());
        String autoBackupDlgInfo = getAutoBackupDlgInfo(backupSpaceNotEnoughNeedData, c12295b, 2, true, notificationWithActivity);
        ScreenListener.m18023c(this.mContext).m18025b(new ActivitySpaceScreenStateListener(backupSpaceNotEnoughNeedData, c12295b, true, notificationWithActivity));
        saveBackupFailPopupDelayInfo(autoBackupDlgInfo);
    }

    private void setSpaceScreenStateLis(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, SpaceNotification spaceNotification) {
        c12295b.m73872I(getAutoBackupDlgTaskId());
        saveBackupFailPopupDelayInfo(getAutoBackupDlgInfo(backupSpaceNotEnoughNeedData, c12295b, 1, true, spaceNotification));
        ScreenListener.m18023c(this.mContext).m18025b(new SpaceScreenStateListener(backupSpaceNotEnoughNeedData, c12295b, true, spaceNotification));
    }

    private void startServiceApp(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, Handler handler, ExtraNotificationBean extraNotificationBean) {
        C11839m.m70688i(TAG, "start goto cloud space guide");
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "startServiceApp backupSpaceNotEnoughNeedData is null.");
            return;
        }
        try {
            boolean zM70629x0 = C11829c.m70629x0(false);
            if (C0209d.m1245d1(this.mContext, GuideWebViewActivity.class.getName()) && C1398a.m8025r() != null) {
                C11839m.m70688i(TAG, "startServiceApp GuideWebViewActivity isForeground");
                C1398a.m8025r().finish();
            }
            backupSpaceNotEnoughNeedData.setFamilyShareMember(zM70629x0);
            this.totalNeedSpace = backupSpaceNotEnoughNeedData.getTotalNeedSpace();
            this.backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
            this.notUsedSpace = backupSpaceNotEnoughNeedData.getNotUsedSpace();
            this.galleryNum = backupSpaceNotEnoughNeedData.getGalleryNum();
            Intent cloudSpaceIntent = getCloudSpaceIntent(extraNotificationBean, zM70629x0);
            Message message = new Message();
            if (cloudSpaceIntent == null) {
                message.what = 2;
            } else {
                message.obj = cloudSpaceIntent;
                message.what = 1;
            }
            handler.sendMessage(message);
        } catch (C1412i e10) {
            C11839m.m70687e(TAG, e10.toString());
        }
    }

    public boolean checkUserSpace(long j10) throws C9721b {
        long availableSpace = getAvailableSpace();
        if (availableSpace >= j10) {
            return true;
        }
        C11839m.m70689w(TAG, "cloud space not enough. available = " + availableSpace + " upload data size = " + j10);
        CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 32305));
        return false;
    }

    public String getIMMessageStr(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) throws Resources.NotFoundException {
        String iMMessage = NoticeFreqControlManager.getInstance().getIMMessage();
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "sendBackupFailIMMessage error, context is null");
            return null;
        }
        String string = context.getString(R$string.cloud_space_insufficient);
        long backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
        if (backupNeedSpace <= 0) {
            backupNeedSpace = 0;
        }
        String strM1524g = C0223k.m1524g(this.mContext, backupNeedSpace);
        int iM16190y = (int) C2783d.m16190y();
        return NoticeFreqControlManager.getInstance().replaceDeviceNameString(NoticeFreqControlManager.getInstance().replaceDataString(iMMessage, string, strM1524g, this.mContext.getResources().getQuantityString(R$plurals.cloud_backup_fail_days, iM16190y, Integer.valueOf(iM16190y))));
    }

    public GetPackagesBySpaceRuleResp getRecommendInfo(long j10) {
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        try {
            return C9948a.m61631C().m61638G(c11060c, 0, j10, 2, new ChannelInfo(), false);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getRecommendInfo err : " + e10.toString());
            return null;
        }
    }

    public void getUserSpaceDetail() {
        C11839m.m70688i(TAG, "get user used space details start.");
        C13368e.m80184F().m80262w0();
        C12515a.m75110o().m75172d(new GetUsedSpaceRunnable());
        C12515a.m75110o().m75172d(new GetBackupUsedRunnable());
        if (!C10028c.m62182c0().m62420y1()) {
            C12515a.m75110o().m75172d(new GetModuleUsedRunnableEu());
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58438k0(this.mContext, this);
        } else {
            C11839m.m70688i(TAG, "cloudAlbumRouterImpl is null");
        }
        C12515a.m75110o().m75172d(new GetModuleUsedRunnable());
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    @Override // p850zo.InterfaceC14351b
    public void onResult(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Message message = new Message();
        message.what = 32324;
        int i10 = bundle.getInt(C5963j.f27041j);
        if (i10 == 0) {
            long j10 = bundle.getLong("photoTotalSize");
            long j11 = bundle.getLong("recycleTotalSize");
            if (j10 < 0) {
                j10 = 0;
            }
            if (j11 < 0) {
                j11 = 0;
            }
            C11839m.m70688i(TAG, "gallery space=" + j10 + "galleryDeleteSize = " + j11);
            message.arg1 = 0;
            message.obj = Long.valueOf(j10);
            storageInfo.setGalleryUsedSize(j10);
            storageInfo.setGalleryDeleteSize(j11);
        } else if (i10 == 3) {
            C11839m.m70688i(TAG, "get gallery space INTFACE_FAIL_LOGOFF");
            C13612b.m81830Y(this.mContext);
            message.arg1 = 1;
            setSuccess(false);
        } else {
            C11839m.m70688i(TAG, "get gallery space failed");
            message.arg1 = 1;
            setSuccess(false);
        }
        sendMessage(message);
    }

    public void sendBackupFailIMMessage(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, BaseNotifyBean baseNotifyBean) throws Resources.NotFoundException, NumberFormatException {
        if (MessageCenterManager.getInstance().featureSwitch()) {
            String strM68061d = C11327e.m68061d("HiCloudSpaceFrequencyControl");
            MsgUserData msgUserDataBuildUserData = buildUserData(backupSpaceNotEnoughNeedData);
            FreqControlBean matchedFreqControlBean = NoticeFreqControlManager.getInstance().getMatchedFreqControlBean();
            MessageCenterManager.getInstance().invokeEvent(matchedFreqControlBean, strM68061d, "HiCloudSpaceFrequencyControl", msgUserDataBuildUserData, getRemindWays(baseNotifyBean, matchedFreqControlBean));
            return;
        }
        String iMMessageStr = getIMMessageStr(backupSpaceNotEnoughNeedData);
        C11839m.m70686d(TAG, "message: " + iMMessageStr);
        C12515a.m75110o().m75172d(new C10249n(null, iMMessageStr));
    }

    public void sendSpaceNotEnoughBeforeV5(boolean z10, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        try {
            C11839m.m70688i(TAG, "sendSpaceNotEnough , " + backupSpaceNotEnoughNeedData.toString());
            CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 32305));
            CloudNoticeOffCheckResult cloudNoticeOffCheckResult = new CloudNoticeOffCheckResult();
            C12295b c12295b = new C12295b();
            if (!z10) {
                List<PortraitAndGrade.UserTag> userTags = getUserTags("sendNotEnoughBeforeV5");
                if (manualBackupFailNotifyTaskCenter(backupSpaceNotEnoughNeedData, c12295b, userTags)) {
                    C11839m.m70688i(TAG, "manualBackupFailNotifyTaskCenter start show");
                    return;
                } else if (c12295b.m73890s()) {
                    newManualBackupFailNotify(backupSpaceNotEnoughNeedData, userTags);
                    return;
                } else {
                    if (newManualBackupFailNotifyWithActivity(backupSpaceNotEnoughNeedData, userTags)) {
                        return;
                    }
                    newManualBackupFailNotify(backupSpaceNotEnoughNeedData, userTags);
                    return;
                }
            }
            if (!HiCloudNotification.getInstance().checkNotifyModuleEnable()) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0023", "spaceNotEnoughLimitByRedList");
                return;
            }
            if (CloudSpaceNotifyUtil.getInstance().needDelay()) {
                C11839m.m70688i(TAG, "need delay, start timer");
                new C3009a(backupSpaceNotEnoughNeedData).m18128a();
                return;
            }
            List<PortraitAndGrade.UserTag> userTags2 = getUserTags("sendNotEnoughBeforeV5");
            NotificationReportUtil.reportAutoBackupExecute();
            if (autoBackupFailNotifyTaskCenter(backupSpaceNotEnoughNeedData, c12295b, userTags2)) {
                C11839m.m70688i(TAG, "autoBackupFailNotifyTaskCenter start show");
            } else if (c12295b.m73890s()) {
                autoBackupFailNotify(backupSpaceNotEnoughNeedData, cloudNoticeOffCheckResult, userTags2);
            } else {
                if (autoBackupFailNotifyWithActivity(backupSpaceNotEnoughNeedData, cloudNoticeOffCheckResult, userTags2)) {
                    return;
                }
                autoBackupFailNotify(backupSpaceNotEnoughNeedData, cloudNoticeOffCheckResult, userTags2);
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "space not enough notification error. err info : " + e10.getMessage());
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0018", e10.getMessage());
        }
    }

    public void serviceApp(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, Handler handler) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "serviceApp backupSpaceNotEnoughNeedData is null.");
            return;
        }
        C11839m.m70688i(TAG, "serviceApp sendSpaceNotEnough , " + backupSpaceNotEnoughNeedData.toString());
        CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 32305));
        serviceAppGoto(backupSpaceNotEnoughNeedData, handler);
    }

    public void setSuccess(boolean z10) {
        this.isSuccess = z10;
    }

    public static class CloudNoticeOffCheckResult {
        private boolean noticeCheckResult;

        private CloudNoticeOffCheckResult() {
            this.noticeCheckResult = false;
        }

        public /* synthetic */ CloudNoticeOffCheckResult(C25081 c25081) {
            this();
        }
    }

    public static class PopupLimitedResult {
        private boolean limit;

        private PopupLimitedResult() {
            this.limit = false;
        }

        public boolean isLimit() {
            return this.limit;
        }

        public void setLimit(boolean z10) {
            this.limit = z10;
        }

        public /* synthetic */ PopupLimitedResult(C25081 c25081) {
            this();
        }
    }

    public class GetModuleUsedRunnable extends AbstractC12367d {
        private List<HDSpaceDetail> details;
        private Map<String, HDSpaceDetail> detailsMap;
        private List<String> dirPaths;
        private List<Map<String, Object>> success;

        private GetModuleUsedRunnable() {
            this.dirPaths = new ArrayList();
            this.success = new ArrayList();
            this.detailsMap = new HashMap();
            this.details = new ArrayList();
        }

        private void queryFiles() throws C9721b {
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
            LsRequest lsRequest = new LsRequest();
            lsRequest.setServerPath("/Hicloud");
            lsRequest.setFields(new String[]{"name"});
            lsRequest.setType(2);
            lsRequest.setRecursive(1);
            List<String> listM70568d = C11829c.m70568d(c13049a.m78718T(lsRequest), this.dirPaths);
            this.dirPaths = listM70568d;
            Result resultM78709H = c13049a.m78709H((String[]) listM70568d.toArray(new String[listM70568d.size()]), new String[]{"name", "space", "size", "fileCount", "dirCount"});
            if (resultM78709H.getSuccessList() == null) {
                return;
            }
            List<Map<String, Object>> successList = resultM78709H.getSuccessList();
            this.success = successList;
            for (Map<String, Object> map : successList) {
                String str = (String) map.get("name");
                String str2 = C9160a.m57578b().get(str.substring(str.lastIndexOf(File.separator)));
                this.detailsMap.put(str2, HDSpaceDetail.buildHDSpaceDetail(map, str2, this.detailsMap.get(str2)));
            }
        }

        private void sort() throws C9721b {
            long j10 = 0;
            long fsize = 0;
            for (Map.Entry<String, HDSpaceDetail> entry : this.detailsMap.entrySet()) {
                HDSpaceDetail value = entry.getValue();
                if (value.getFsize() > 0) {
                    fsize += value.getFsize();
                    this.details.add(entry.getValue());
                }
            }
            while (UserSpaceUtil.this.isSuccess && (UserSpaceUtil.this.userUsedSize < 0 || UserSpaceUtil.this.backupUsedSize < 0)) {
                SystemClock.sleep(1000L);
            }
            if (!UserSpaceUtil.this.isSuccess) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "get user space not all success.");
            }
            long j11 = (UserSpaceUtil.this.userUsedSize - UserSpaceUtil.this.backupUsedSize) - fsize;
            C11839m.m70688i(UserSpaceUtil.TAG, "other " + j11);
            if (j11 > 0) {
                HDSpaceDetail hDSpaceDetail = new HDSpaceDetail();
                hDSpaceDetail.setModuleName("clouddrive");
                hDSpaceDetail.setFsize(j11);
                this.details.add(hDSpaceDetail);
                j10 = j11;
            }
            Message message = new Message();
            message.what = 32337;
            message.obj = Long.valueOf(j10);
            UserSpaceUtil.sendMessage(message);
            if (this.details.isEmpty()) {
                return;
            }
            Collections.sort(this.details);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Message message = new Message();
            message.what = 32319;
            try {
                queryFiles();
                sort();
                message.arg1 = 0;
                message.obj = this.details;
                C11839m.m70688i(UserSpaceUtil.TAG, "module detail size = " + this.details.size());
                long j10 = UserSpaceUtil.this.userUsedSize - UserSpaceUtil.this.backupUsedSize;
                if (j10 < 0) {
                    j10 = 0;
                }
                C11839m.m70688i(UserSpaceUtil.TAG, "moduleUsedSize = " + j10);
                UserSpaceUtil.storageInfo.setBackupDetails(UserSpaceUtil.this.backupDetails);
                UserSpaceUtil.storageInfo.setDiskDetails(this.details);
                UserSpaceUtil.storageInfo.setBackupUsedSize(UserSpaceUtil.this.backupUsedSize);
                UserSpaceUtil.storageInfo.setDiskUsedSize(j10);
                UserSpaceUtil.sendMessage(message);
            } catch (C9721b e10) {
                C11839m.m70689w(UserSpaceUtil.TAG, "get user modules space failed. errorCode = " + e10.m60659c());
                message.arg1 = 1;
                UserSpaceUtil.sendMessage(message);
            }
        }

        public /* synthetic */ GetModuleUsedRunnable(UserSpaceUtil userSpaceUtil, C25081 c25081) {
            this();
        }
    }

    private String getAutoBackupDlgInfo(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, int i10, boolean z10, NotificationWithActivity notificationWithActivity) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfoBuildDlgInfo = buildDlgInfo(backupSpaceNotEnoughNeedData, c12295b, i10, z10);
        backupNotEnoughDlgInfoBuildDlgInfo.setNotificationWithActivity(notificationWithActivity);
        return new Gson().toJson(backupNotEnoughDlgInfoBuildDlgInfo);
    }

    public class GetModuleUsedRunnableEu extends AbstractC12367d {
        private List<HDSpaceDetail> details;
        private List<HDSpaceDetail> diskDetails;
        private long galleryDeleteSize;
        private long galleryUsedSize;
        private long moduleUsedSize;
        private long totalCount;

        private GetModuleUsedRunnableEu() {
            this.totalCount = 0L;
            this.galleryUsedSize = -1L;
            this.galleryDeleteSize = -1L;
            this.moduleUsedSize = -1L;
            this.diskDetails = new ArrayList();
            this.details = new ArrayList();
        }

        private void queryFiles() throws C9721b {
            String str;
            String str2;
            String str3 = "name";
            String str4 = "/GallerySyncRecycle";
            try {
                Result resultM78709H = new C13049a(EnumC12999a.CLOUD_MORE, null).m78709H(new String[]{"/GallerySync", "/GallerySyncRecycle", "/BlockedBackup", "/RecordBackup", "/NoteSync"}, new String[]{"name", "space", "fileCount", "dirCount"});
                if (!resultM78709H.getFailList().isEmpty()) {
                    C11839m.m70687e(UserSpaceUtil.TAG, "query module space error " + resultM78709H.toString());
                    throw new C9721b(resultM78709H.getFailList().get(0).getErrCode(), "query module space error " + resultM78709H.toString());
                }
                for (Map<String, Object> map : resultM78709H.getSuccessList()) {
                    String str5 = (String) map.get(str3);
                    long j10 = 0;
                    if (str5.equals("/GallerySync")) {
                        long jM1688f = C0241z.m1688f(map.get("space").toString());
                        this.galleryUsedSize = jM1688f;
                        if (jM1688f >= 0) {
                            j10 = jM1688f;
                        }
                        this.galleryUsedSize = j10;
                    } else if (str5.equals(str4)) {
                        long jM1688f2 = C0241z.m1688f(map.get("space").toString());
                        this.galleryDeleteSize = jM1688f2;
                        if (jM1688f2 >= 0) {
                            j10 = jM1688f2;
                        }
                        this.galleryDeleteSize = j10;
                    } else {
                        str = str3;
                        str2 = str4;
                        long jM1688f3 = C0241z.m1688f(map.get("space").toString());
                        if (jM1688f3 > 0) {
                            String str6 = ICBUtil.getSpaceDefaultModules().get(str5);
                            HDSpaceDetail hDSpaceDetail = new HDSpaceDetail();
                            hDSpaceDetail.setModuleName(str6);
                            if (ICBUtil.getSupportDeleteModules().contains(str6)) {
                                hDSpaceDetail.setDelete(true);
                            }
                            hDSpaceDetail.setFsize(jM1688f3);
                            hDSpaceDetail.setFcount(C0241z.m1685c(map.get("fileCount").toString()));
                            hDSpaceDetail.setDcount(C0241z.m1685c(map.get("dirCount").toString()));
                            this.totalCount += hDSpaceDetail.getFsize();
                            this.details.add(hDSpaceDetail);
                        }
                        str3 = str;
                        str4 = str2;
                    }
                    str = str3;
                    str2 = str4;
                    str3 = str;
                    str4 = str2;
                }
            } catch (C9721b e10) {
                C11839m.m70689w(UserSpaceUtil.TAG, "get user modules space failed. errorCode = " + e10.getMessage());
            }
        }

        private void sort() throws InterruptedException, C9721b {
            long j10;
            while (true) {
                j10 = 0;
                if (!UserSpaceUtil.this.isSuccess || (UserSpaceUtil.this.userUsedSize >= 0 && UserSpaceUtil.this.backupUsedSize >= 0)) {
                    break;
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    C11839m.m70689w(UserSpaceUtil.TAG, "InterruptedException");
                }
            }
            if (!UserSpaceUtil.this.isSuccess) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "get user space not all success.");
            }
            long j11 = (((UserSpaceUtil.this.userUsedSize - this.galleryUsedSize) - this.galleryDeleteSize) - UserSpaceUtil.this.backupUsedSize) - this.totalCount;
            if (j11 > 0) {
                HDSpaceDetail hDSpaceDetail = new HDSpaceDetail();
                hDSpaceDetail.setModuleName("clouddrive");
                hDSpaceDetail.setFsize(j11);
                this.details.add(hDSpaceDetail);
                j10 = j11;
            }
            Message message = new Message();
            message.what = 32337;
            message.obj = Long.valueOf(j10);
            UserSpaceUtil.sendMessage(message);
            UserSpaceUtil.storageInfo.setCloudDriveSize(j10);
            if (this.details.isEmpty()) {
                return;
            }
            Collections.sort(this.details);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            Message message = new Message();
            message.what = 32319;
            try {
                queryFiles();
                sort();
                this.diskDetails = this.details;
                this.moduleUsedSize = ((UserSpaceUtil.this.userUsedSize - this.galleryUsedSize) - UserSpaceUtil.this.backupUsedSize) - this.galleryDeleteSize;
                C11839m.m70688i(UserSpaceUtil.TAG, "moduleUsedSize = " + this.moduleUsedSize + "totalCount = " + this.totalCount + "galleryUsedSize = " + this.galleryUsedSize + "galleryDeleteSize = " + this.galleryDeleteSize);
                long j10 = this.moduleUsedSize;
                if (j10 < 0) {
                    j10 = this.totalCount;
                }
                this.moduleUsedSize = j10;
                UserSpaceUtil.storageInfo.setGalleryUsedSize(this.galleryUsedSize);
                UserSpaceUtil.storageInfo.setGalleryDeleteSize(this.galleryDeleteSize);
                UserSpaceUtil.storageInfo.setBackupUsedSize(UserSpaceUtil.this.backupUsedSize);
                UserSpaceUtil.storageInfo.setBackupDetails(UserSpaceUtil.this.backupDetails);
                UserSpaceUtil.storageInfo.setDiskUsedSize(this.moduleUsedSize);
                UserSpaceUtil.storageInfo.setDiskDetails(this.diskDetails);
                message.arg1 = 0;
                UserSpaceUtil.sendMessage(message);
                C13368e.m80184F().m80206A0(UserSpaceUtil.storageInfo);
            } catch (C9721b e10) {
                C11839m.m70689w(UserSpaceUtil.TAG, "get user modules space failed. errorCode = " + e10.m60659c());
                message.arg1 = 1;
                UserSpaceUtil.sendMessage(message);
            }
        }

        public /* synthetic */ GetModuleUsedRunnableEu(UserSpaceUtil userSpaceUtil, C25081 c25081) {
            this();
        }
    }

    public static void checkAndClearDlgDelayInfo(int i10) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfo;
        NotEnoughDialogDataV5 notEnoughDialogDataV5;
        if (i10 != 0) {
            String strM62398u = C10028c.m62183d0(C0213f.m1377a()).m62398u();
            if (TextUtils.isEmpty(strM62398u) || (backupNotEnoughDlgInfo = (BackupNotEnoughDlgInfo) C12540b1.m75483a(strM62398u, BackupNotEnoughDlgInfo.class)) == null || (notEnoughDialogDataV5 = backupNotEnoughDlgInfo.getNotEnoughDialogDataV5()) == null || notEnoughDialogDataV5.getTaskId() != i10) {
                return;
            }
            C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
            InterfaceC12614b.get().clearConfigurable(BackupNotEnoughDlgSpInfo.class);
            C10028c.m62183d0(C0213f.m1377a()).m62353l(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE);
        }
    }

    public static List<NotificationWithActivity> getNotificationWithActivity() {
        SpaceNoticeV4Bean spaceNoticeConfigV4 = SpaceInsuffNoticeV4Manager.getInstance().getSpaceNoticeConfigV4();
        if (spaceNoticeConfigV4 == null) {
            C11839m.m70688i(TAG, "notificationConfig is null");
            return null;
        }
        SpaceInsufficientNoticeConfiguration configuration = spaceNoticeConfigV4.getConfiguration();
        if (configuration == null) {
            return null;
        }
        return configuration.getNotificationWithActivity();
    }
}
