package com.huawei.android.hicloud.cloudbackup.process;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgInfo;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.p088ui.uiextend.bean.SecondaryRetentionContent;
import com.huawei.android.hicloud.p088ui.uiextend.bean.V5DailogActivityAreaNeedData;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.hicloud.task.simple.C3009a;
import com.huawei.android.hicloud.task.simple.C3029f;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffWindowNoticeBean;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.ActivePopup;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.ModelGoto;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.NoticeContent;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.router.R$drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fj.C9718g;
import id.C10470d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import je.C10811y;
import p015ak.C0209d;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p341hj.C10252o;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11289l;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p618rm.C12590s0;
import p709vj.C13452e;
import p778xk.C13823d;
import p815ym.AbstractC14026a;
import p836z8.C14157f;

/* loaded from: classes2.dex */
public class SpaceNotEnoughNotifyV5 implements IBackupNotEnoughNotify {
    private static final String TAG = "SpaceNotEnoughNotifyV5";
    private List<BackupSpaceInsuffNoticeV5Configuration> collectNotification;
    private Context context;

    public class V5ScreenStateListener implements ScreenListener.ScreenStateListener {
        private final boolean isAutoBackup;
        private final NotEnoughDialogDataV5 notEnoughDialogDataV5;
        private final BackupSpaceInsuffNoticeV5Configuration notification;

        public /* synthetic */ V5ScreenStateListener(SpaceNotEnoughNotifyV5 spaceNotEnoughNotifyV5, NotEnoughDialogDataV5 notEnoughDialogDataV5, boolean z10, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, C25071 c25071) {
            this(notEnoughDialogDataV5, z10, backupSpaceInsuffNoticeV5Configuration);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOff() {
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOn() {
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onUserPresent() {
            C11839m.m70688i(SpaceNotEnoughNotifyV5.TAG, "V5ScreenStateListener onUserPresent, isAutoBackup: " + this.isAutoBackup);
            if (SpaceNotEnoughNotifyV5.this.getContext() == null) {
                C11839m.m70688i(SpaceNotEnoughNotifyV5.TAG, "V5ScreenStateListener onUserPresent, context is null");
                return;
            }
            C10470d.m64355p(SpaceNotEnoughNotifyV5.this.getContext()).cancel();
            if (BackupNotificationV5Util.isShowDialog(SpaceNotEnoughNotifyV5.this.getContext())) {
                C10811y.m65822f("SpaceNotEnoughV5Error", "16", "");
                C12515a.m75110o().m75175e(new C3029f(SpaceNotEnoughNotifyV5.this.getContext(), this.notEnoughDialogDataV5, this.isAutoBackup, this.notification), true);
                return;
            }
            C11839m.m70688i(SpaceNotEnoughNotifyV5.TAG, "start BackupFailCheckV5Timer");
            C10811y.m65822f("SpaceNotEnoughV5Error", "17", "start BackupFailCheckV5Timer");
            C10470d.m64355p(SpaceNotEnoughNotifyV5.this.getContext()).m64349m(false);
            C10470d.m64355p(SpaceNotEnoughNotifyV5.this.getContext()).m64356q(this.notEnoughDialogDataV5);
            C10470d.m64355p(SpaceNotEnoughNotifyV5.this.getContext()).m64346j(this.isAutoBackup);
            C10470d.m64355p(SpaceNotEnoughNotifyV5.this.getContext()).m64357r(this.notification);
            C12515a.m75110o().m75175e(C10470d.m64355p(SpaceNotEnoughNotifyV5.this.getContext()), true);
        }

        private V5ScreenStateListener(NotEnoughDialogDataV5 notEnoughDialogDataV5, boolean z10, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
            this.notEnoughDialogDataV5 = notEnoughDialogDataV5;
            this.isAutoBackup = z10;
            this.notification = backupSpaceInsuffNoticeV5Configuration;
        }
    }

    private void autoBackupFailNotifyV5(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        if (getContext() == null) {
            C11839m.m70687e(TAG, "autoBackupFailNotifyV5 getContext() is null");
            C10811y.m65822f("SpaceNotEnoughV5Error", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "autoBackupFailNotifyV5 getContext() is null");
        } else if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "autoBackupFailNotifyV5 backupSpaceNotEnoughNeedData is null.");
            C10811y.m65822f("SpaceNotEnoughV5Error", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "autoBackupFailNotifyV5 backupSpaceNotEnoughNeedData is null.");
        } else {
            SpaceNoticeCommonSpUtil.getInstance().clear(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
            doAutoBackupFailNotifyV5(backupSpaceNotEnoughNeedData);
        }
    }

    private void backupFailDialogNotifyV5(NotEnoughDialogDataV5 notEnoughDialogDataV5, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        C11839m.m70688i(TAG, "backupFailDialogNotifyV5");
        BackupNotificationV5Util.startNotificationActivity(false, getContext(), notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration);
    }

    private void buildConfigData(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData) {
        v5DailogActivityAreaNeedData.setEnableFrontApp(backupSpaceInsuffNoticeV5Configuration.getEnableFrontApp());
        v5DailogActivityAreaNeedData.setEnableRecomPackages(backupSpaceInsuffNoticeV5Configuration.getEnableRecomPackages());
        v5DailogActivityAreaNeedData.setFrontAppStyle(backupSpaceInsuffNoticeV5Configuration.getFrontAppStyle());
        NoticeContent noticeContent = backupSpaceInsuffNoticeV5Configuration.getNoticeContent();
        if (noticeContent != null) {
            v5DailogActivityAreaNeedData.setFrontAppText(noticeContent.getFrontAppText());
            v5DailogActivityAreaNeedData.setDetailPage(noticeContent.getDetailPage());
        }
        v5DailogActivityAreaNeedData.setClientUIConfigResp(getUiParamsFromBusiness());
        v5DailogActivityAreaNeedData.setAutoPay(isAutoPay());
    }

    private BackupNotEnoughDlgInfo buildDlgInfo(NotEnoughDialogDataV5 notEnoughDialogDataV5) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfo = new BackupNotEnoughDlgInfo();
        backupNotEnoughDlgInfo.setNotEnoughDialogDataV5(notEnoughDialogDataV5);
        backupNotEnoughDlgInfo.setTimeStamp(System.currentTimeMillis());
        backupNotEnoughDlgInfo.setNotifyType(4);
        backupNotEnoughDlgInfo.setAutoBackup(true);
        return backupNotEnoughDlgInfo;
    }

    private NotifyNeedData buildNotifyNeedData(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, boolean z10, RecommendNeedData recommendNeedData) {
        if (backupSpaceInsuffNoticeV5Configuration == null || backupSpaceInsuffNoticeV5Configuration.getNotifyGoto() == null) {
            C11839m.m70688i(TAG, "buildNotifyNeedData notification is null or goto is null.");
            C10811y.m65822f("SpaceNotEnoughV5Error", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "buildNotifyNeedData notification is null or goto is null.");
            return null;
        }
        if (backupSpaceInsuffNoticeV5Configuration.getNoticeContent() == null || backupSpaceInsuffNoticeV5Configuration.getNoticeContent().getNoticeNotification() == null || TextUtils.isEmpty(backupSpaceInsuffNoticeV5Configuration.getNoticeContent().getNoticeNotification().getTitle()) || TextUtils.isEmpty(backupSpaceInsuffNoticeV5Configuration.getNoticeContent().getNoticeNotification().getMainText())) {
            C11839m.m70688i(TAG, "buildNotifyNeedData text is null");
            C10811y.m65822f("SpaceNotEnoughV5Error", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "buildNotifyNeedData text is null");
            return null;
        }
        ModelGoto notifyGoto = backupSpaceInsuffNoticeV5Configuration.getNotifyGoto();
        String stringFromDB = BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(backupSpaceInsuffNoticeV5Configuration.getNoticeContent().getNoticeNotification().getTitle());
        String stringFromDB2 = BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(backupSpaceInsuffNoticeV5Configuration.getNoticeContent().getNoticeNotification().getMainText());
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        notifyNeedData.setTitleText(stringFromDB);
        notifyNeedData.setMainText(stringFromDB2);
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setNeedGroup(true);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setId(775);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", C0213f.m1377a().getResources().getString(R$string.HiCloud_app_name));
        notifyNeedData.setExtraBundle(bundle);
        Intent intentM75832b0 = C12590s0.m75807V0(notifyGoto.getNotiDeeplink()) ? C12590s0.m75832b0(notifyGoto.getNotiDeeplink(), null, true) : NotifyUtil.getGotoIntent(C0213f.m1377a(), notifyGoto.getNotiType(), notifyGoto.getUri());
        intentM75832b0.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        intentM75832b0.putExtra(RemoteMessageConst.FROM, "backup_space_insuff_notify_bar_click_event");
        String notiType = notifyGoto.getNotiType();
        String uri = notifyGoto.getUri();
        notifyNeedData.setContentIntent((TextUtils.isEmpty(notiType) || TextUtils.isEmpty(uri) || !"application".equals(notiType) || !NotifyConstants.HICLOUD_GALLERY.equals(uri)) ? C0209d.m1248e0(C0213f.m1377a(), 0, intentM75832b0, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : PendingIntent.getBroadcast(this.context, 10002, intentM75832b0, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK));
        notifyNeedData.setSilent(z10);
        return notifyNeedData;
    }

    private RecommendNeedData buildRecommendData(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, int i10) {
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        recommendNeedData.setId(backupSpaceInsuffNoticeV5Configuration.getId());
        recommendNeedData.setRecommendType(backupSpaceInsuffNoticeV5Configuration.getNoticeType());
        recommendNeedData.setEnterType(1);
        recommendNeedData.setTotalNeedSpace(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
        recommendNeedData.setBackupNeedSpace(backupSpaceNotEnoughNeedData.getBackupNeedSpace());
        recommendNeedData.setNotUsedSpace(backupSpaceNotEnoughNeedData.getNotUsedSpace());
        recommendNeedData.setGalleryNum(backupSpaceNotEnoughNeedData.getGalleryNum());
        recommendNeedData.setActivityWithTaskCenter(i10 == 2);
        recommendNeedData.setV5BackupNotEnoughDialog(true);
        recommendNeedData.setDetailGotoBeanList(backupSpaceInsuffNoticeV5Configuration.getDetailGoto());
        if (i10 == 2) {
            recommendNeedData.setActivityType(4);
        } else if (i10 == 1) {
            recommendNeedData.setActivityType(1);
        }
        return recommendNeedData;
    }

    private RecommendNeedData checkDialogShowV5(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        GetPackagesBySpaceRuleResp recommendInfo = getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
        NotEnoughDialogDataV5 notEnoughDialogDataV5 = new NotEnoughDialogDataV5();
        V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData = new V5DailogActivityAreaNeedData();
        v5DailogActivityAreaNeedData.setRecommendPackageInfo(recommendInfo);
        buildConfigData(backupSpaceInsuffNoticeV5Configuration, v5DailogActivityAreaNeedData);
        notEnoughDialogDataV5.setV5DailogActivityAreaNeedData(v5DailogActivityAreaNeedData);
        notEnoughDialogDataV5.setSecondaryRetentionContent(getUserActivityContent(backupSpaceInsuffNoticeV5Configuration, notEnoughDialogDataV5));
        notEnoughDialogDataV5.setBackupSpaceNotEnoughNeedData(backupSpaceNotEnoughNeedData);
        RecommendNeedData recommendNeedDataBuildRecommendData = buildRecommendData(backupSpaceInsuffNoticeV5Configuration, backupSpaceNotEnoughNeedData, notEnoughDialogDataV5.getActivityType());
        notEnoughDialogDataV5.getV5DailogActivityAreaNeedData().setRecommendNeedData(recommendNeedDataBuildRecommendData);
        if (!NotifyUtil.isDialogSilent(getContext(), backupSpaceInsuffNoticeV5Configuration)) {
            execAutoBackupFailNotifyV5(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration);
            return recommendNeedDataBuildRecommendData;
        }
        boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
        C11839m.m70689w(TAG, "in silent time, dialog not show silentDelay = " + zIsSilentDelay);
        if (zIsSilentDelay) {
            setSpaceScreenStateLisV5(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration);
        }
        C10811y.m65821e(zIsSilentDelay);
        return recommendNeedDataBuildRecommendData;
    }

    private void doAutoBackupFailNotifyV5(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        C11839m.m70688i(TAG, "doAutoBackupFailNotifyV5 start.");
        if (CloudSpaceNotifyUtil.getInstance().checkCloudNoticeOffCondition(NotifyConstants.NotificationReport.NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT)) {
            C11839m.m70688i(TAG, "doAutoBackupFailNotifyV5 notice not fit Condition.");
            C10811y.m65822f("SpaceNotEnoughV5Error", "14", "doAutoBackupFailNotifyV5 notice not fit Condition.");
            return;
        }
        JsonArray jsonArray = new JsonArray();
        Iterator<BackupSpaceInsuffNoticeV5Configuration> it = this.collectNotification.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BackupSpaceInsuffNoticeV5Configuration next = it.next();
            String noticeType = next.getNoticeType();
            int id2 = next.getId();
            if (!UserSpaceUtil.checkSpaceNotifyRuleFrequency(getContext(), next)) {
                NotificationBIReportUtil.addDayOnceCheckFailNotice(jsonArray, noticeType, String.valueOf(id2));
                C11839m.m70688i(TAG, "space rule frequency not satisfied");
                C10811y.m65822f("SpaceNotEnoughV5Error", "15", "space rule frequency not satisfied");
                if (!C0209d.m1217V0(next.getUserGroupExtIDs())) {
                    C11839m.m70688i(TAG, "userGroupExtIDs not empty");
                    break;
                }
                C11839m.m70688i(TAG, "userGroupExtIDs is empty continue");
            } else {
                C11839m.m70688i(TAG, "doAutoBackupFailNotifyV5 valid id = " + next.getId());
                RecommendNeedData recommendNeedDataCheckDialogShowV5 = checkDialogShowV5(next, backupSpaceNotEnoughNeedData);
                if (UserSpaceUtil.checkBackupCycleNotifyTime(getContext())) {
                    C11839m.m70688i(TAG, "show auto backup fail notify");
                    sendNotificationBar(next, true, recommendNeedDataCheckDialogShowV5);
                } else {
                    C11839m.m70688i(TAG, "checkBackupCycleNotifyTime not notify");
                }
                UserSpaceUtil.recordSpaceNotifyRuleFrequency(getContext());
            }
        }
        C11839m.m70688i(TAG, "doAutoBackupFailNotifyV5 end");
        NotificationBIReportUtil.reportAutoBackupDayonceCheckFail(jsonArray);
    }

    private void execAutoBackupFailNotifyV5(NotEnoughDialogDataV5 notEnoughDialogDataV5, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        C11839m.m70688i(TAG, "execAutoBackupFailNotify");
        if (BackupNotificationV5Util.isShowDialog(getContext())) {
            backupFailDialogNotifyV5(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration);
        } else {
            setSpaceScreenStateLisV5(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration);
            C10811y.m65822f("SpaceNotEnoughV5Error", "4", "");
        }
    }

    private String getAutoBackupDlgInfo(NotEnoughDialogDataV5 notEnoughDialogDataV5, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfoBuildDlgInfo = buildDlgInfo(notEnoughDialogDataV5);
        backupNotEnoughDlgInfoBuildDlgInfo.setSpaceInsufficientV5(backupSpaceInsuffNoticeV5Configuration);
        return new Gson().toJson(backupNotEnoughDlgInfoBuildDlgInfo);
    }

    private int getAutoBackupDlgTaskId() {
        return UserSpaceUtil.getAutoBackupDlgTaskId();
    }

    public Context getContext() {
        return this.context;
    }

    private GetPackagesBySpaceRuleResp getRecommendInfo(long j10) {
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = null;
        try {
            Filter filter = new Filter();
            filter.setShowPlace(2);
            C11060c c11060c = new C11060c();
            c11060c.m66636B("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespBuildSpaceRuleResp = BackupNotificationV5Util.buildSpaceRuleResp(C9948a.m61631C().m61699v(c11060c, filter, null, null, j10));
            try {
                if (getPackagesBySpaceRuleRespBuildSpaceRuleResp == null) {
                    C11839m.m70687e(TAG, "getPackagesBySpaceRuleResp is null");
                    return null;
                }
                List<CloudPackage> spacePackages = getPackagesBySpaceRuleRespBuildSpaceRuleResp.getSpacePackages();
                if (spacePackages == null || spacePackages.isEmpty() || !C11296s.m67787K() || !C11296s.m67789M(C0213f.m1377a())) {
                    return getPackagesBySpaceRuleRespBuildSpaceRuleResp;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<CloudPackage> it = spacePackages.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getId());
                }
                getPackagesBySpaceRuleRespBuildSpaceRuleResp.setVoucherList(C9948a.m61631C().m61695t(c11060c, arrayList, new ArrayList()).getVouchers());
                return getPackagesBySpaceRuleRespBuildSpaceRuleResp;
            } catch (Exception e10) {
                e = e10;
                getPackagesBySpaceRuleResp = getPackagesBySpaceRuleRespBuildSpaceRuleResp;
                C11839m.m70687e(TAG, "getRecommendInfo err :" + e.getMessage());
                return getPackagesBySpaceRuleResp;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    private GetClientUIConfigResp getUiParamsFromBusiness() {
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        try {
            return C9948a.m61631C().m61703z(c11060c);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getClientUIConfigResp, getClientUIConfigResp err : " + e10.toString());
            return null;
        }
    }

    private boolean isAutoPay() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.sign.state");
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(arrayList, null, "V5_Dialog");
        if (listM84949i == null || listM84949i.isEmpty()) {
            C1442a.m8290i(TAG, "params is null or empty.");
            return false;
        }
        C4987f c4987f = listM84949i.get(0);
        if (c4987f != null) {
            return c4987f.m30027c().equals("1");
        }
        C1442a.m8290i(TAG, "paramsValue is null.");
        return false;
    }

    public static /* synthetic */ boolean lambda$checkValid$0(List list, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        return NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(backupSpaceInsuffNoticeV5Configuration.getNoticeType()) && CloudSpaceNotifyUtil.checkUserTag((List<PortraitAndGrade.UserTag>) list, backupSpaceInsuffNoticeV5Configuration);
    }

    public static /* synthetic */ boolean lambda$getDownloadAppContent$6(PopUpWithActivityGoto popUpWithActivityGoto) {
        return NotifyConstants.POP_GOTO_BUTTON_FIRST.equals(popUpWithActivityGoto.getCode());
    }

    public static /* synthetic */ void lambda$getDownloadAppContent$7(NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr, PopUpWithActivityGoto popUpWithActivityGoto) {
        NotEnoughDialogDataV5.DialogGoto dialogGoto = new NotEnoughDialogDataV5.DialogGoto();
        dialogGotoArr[0] = dialogGoto;
        dialogGoto.setPopupType(popUpWithActivityGoto.getPopupType());
        dialogGotoArr[0].setPopupUri(popUpWithActivityGoto.getPopupUri());
    }

    public static /* synthetic */ boolean lambda$getDownloadAppContent$8(PopUpWithActivityGoto popUpWithActivityGoto) {
        return NotifyConstants.POP_GOTO_BUTTON_SECOND.equals(popUpWithActivityGoto.getCode());
    }

    public static /* synthetic */ void lambda$getDownloadAppContent$9(NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr, PopUpWithActivityGoto popUpWithActivityGoto) {
        NotEnoughDialogDataV5.DialogGoto dialogGoto = new NotEnoughDialogDataV5.DialogGoto();
        dialogGotoArr[0] = dialogGoto;
        dialogGoto.setPopupType(popUpWithActivityGoto.getPopupType());
        dialogGotoArr[0].setPopupUri(popUpWithActivityGoto.getPopupUri());
    }

    public static /* synthetic */ boolean lambda$getTaskCenterContent$2(PopUpWithActivityGoto popUpWithActivityGoto) {
        return NotifyConstants.POP_GOTO_BUTTON_FIRST.equals(popUpWithActivityGoto.getCode());
    }

    public static /* synthetic */ void lambda$getTaskCenterContent$3(NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr, PopUpWithActivityGoto popUpWithActivityGoto) {
        NotEnoughDialogDataV5.DialogGoto dialogGoto = new NotEnoughDialogDataV5.DialogGoto();
        dialogGotoArr[0] = dialogGoto;
        dialogGoto.setPopupType(popUpWithActivityGoto.getPopupType());
        dialogGotoArr[0].setPopupUri(popUpWithActivityGoto.getPopupUri());
    }

    public static /* synthetic */ boolean lambda$getTaskCenterContent$4(PopUpWithActivityGoto popUpWithActivityGoto) {
        return NotifyConstants.POP_GOTO_BUTTON_SECOND.equals(popUpWithActivityGoto.getCode());
    }

    public static /* synthetic */ void lambda$getTaskCenterContent$5(NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr, PopUpWithActivityGoto popUpWithActivityGoto) {
        NotEnoughDialogDataV5.DialogGoto dialogGoto = new NotEnoughDialogDataV5.DialogGoto();
        dialogGotoArr[0] = dialogGoto;
        dialogGoto.setPopupType(popUpWithActivityGoto.getPopupType());
        dialogGotoArr[0].setPopupUri(popUpWithActivityGoto.getPopupUri());
    }

    public static /* synthetic */ boolean lambda$sendNotificationBar$1(NotifyWay notifyWay) {
        return TextUtils.equals(notifyWay.getName(), "notification_bar");
    }

    private void manualBackupFailNotifyV5(NotEnoughDialogDataV5 notEnoughDialogDataV5, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        C11839m.m70688i(TAG, "manualBackupFailNotifyV5");
        if (BackupNotificationV5Util.isShowDialog(getContext())) {
            backupFailDialogNotifyV5(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration);
            return;
        }
        C11839m.m70688i(TAG, "manualBackupFailNotifyV5 begin ScreenStateListen");
        ScreenListener.m18023c(getContext()).m18025b(new V5ScreenStateListener(notEnoughDialogDataV5, false, backupSpaceInsuffNoticeV5Configuration));
        C10811y.m65822f("SpaceNotEnoughV5Error", "4", "");
    }

    private void newManualBackupFailNotifyV5(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "newManualBackupFailNotify backupSpaceNotEnoughNeedData is null");
            return;
        }
        SpaceNoticeCommonSpUtil.getInstance().clear(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5ConfigurationOrElse = this.collectNotification.stream().findFirst().orElse(null);
        if (backupSpaceInsuffNoticeV5ConfigurationOrElse == null) {
            C11839m.m70689w(TAG, "newManualBackupFailNotifyV5 notication is null");
            return;
        }
        C11839m.m70688i(TAG, "newManualBackupFailNotify id = " + backupSpaceInsuffNoticeV5ConfigurationOrElse.getId());
        GetPackagesBySpaceRuleResp recommendInfo = getRecommendInfo(backupSpaceNotEnoughNeedData.getTotalNeedSpace());
        NotEnoughDialogDataV5 notEnoughDialogDataV5 = new NotEnoughDialogDataV5();
        V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData = new V5DailogActivityAreaNeedData();
        v5DailogActivityAreaNeedData.setRecommendPackageInfo(recommendInfo);
        buildConfigData(backupSpaceInsuffNoticeV5ConfigurationOrElse, v5DailogActivityAreaNeedData);
        notEnoughDialogDataV5.setV5DailogActivityAreaNeedData(v5DailogActivityAreaNeedData);
        notEnoughDialogDataV5.setSecondaryRetentionContent(getUserActivityContent(backupSpaceInsuffNoticeV5ConfigurationOrElse, notEnoughDialogDataV5));
        notEnoughDialogDataV5.setBackupSpaceNotEnoughNeedData(backupSpaceNotEnoughNeedData);
        RecommendNeedData recommendNeedDataBuildRecommendData = buildRecommendData(backupSpaceInsuffNoticeV5ConfigurationOrElse, backupSpaceNotEnoughNeedData, notEnoughDialogDataV5.getActivityType());
        notEnoughDialogDataV5.getV5DailogActivityAreaNeedData().setRecommendNeedData(recommendNeedDataBuildRecommendData);
        manualBackupFailNotifyV5(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5ConfigurationOrElse);
        sendNotificationBar(backupSpaceInsuffNoticeV5ConfigurationOrElse, false, recommendNeedDataBuildRecommendData);
    }

    private void reportEvent(List<PortraitAndGrade.UserTag> list) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!AbstractC14026a.m84159a(list)) {
                linkedHashMap.put("userTags", Arrays.toString(list.toArray()));
            }
            if (!AbstractC14026a.m84159a(this.collectNotification)) {
                BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration = this.collectNotification.get(0);
                linkedHashMap.put("matchConfigId", String.valueOf(backupSpaceInsuffNoticeV5Configuration.getId()));
                List<String> userGroupExtIDs = backupSpaceInsuffNoticeV5Configuration.getUserGroupExtIDs();
                if (!AbstractC14026a.m84159a(userGroupExtIDs)) {
                    linkedHashMap.put("matchConfigTag", Arrays.toString(userGroupExtIDs.toArray()));
                }
            }
            C10811y.m65820d("send_space_not_enough_V5", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "reportBi error: " + e10.getMessage());
        }
    }

    private void sendBackupFailIMMessageNew(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        UserSpaceUtil.sendBackupFailIMMessageNew(backupSpaceNotEnoughNeedData, backupSpaceInsuffNoticeV5Configuration, "HiCloudBackupSpaceInsuffNoticeV5");
    }

    private void sendNotificationBar(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, boolean z10, RecommendNeedData recommendNeedData) {
        List<NotifyWay> remindWays = backupSpaceInsuffNoticeV5Configuration.getRemindWays();
        if (remindWays == null || !remindWays.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.a1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpaceNotEnoughNotifyV5.lambda$sendNotificationBar$1((NotifyWay) obj);
            }
        })) {
            C11839m.m70688i(TAG, "sendNotificationBar not match, return: remindWayMatch: false");
            C10811y.m65822f("SpaceNotEnoughV5Error", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "sendNotificationBar not match, return: remindWayMatch: false");
            return;
        }
        NoticeContent noticeContent = backupSpaceInsuffNoticeV5Configuration.getNoticeContent();
        if (noticeContent != null) {
            BackupNotificationV5Util.buildDetailText(recommendNeedData, backupSpaceInsuffNoticeV5Configuration.getNotifyGoto().getNotiType(), noticeContent.getDetailPage());
        }
        new BackupNotificationManager(C0213f.m1377a()).sendNotification(buildNotifyNeedData(backupSpaceInsuffNoticeV5Configuration, z10, recommendNeedData));
        C10811y.m65828l();
    }

    private void sendSpaceNotEnoughV5(boolean z10, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        try {
            C11839m.m70688i(TAG, "sendSpaceNotEnoughV5 , " + backupSpaceNotEnoughNeedData.toString() + " ,autoBackup: " + z10);
            C10811y.m65831o(z10, backupSpaceNotEnoughNeedData.toString());
            if (!z10) {
                newManualBackupFailNotifyV5(backupSpaceNotEnoughNeedData);
                return;
            }
            if (!HiCloudNotification.getInstance().checkNotifyModuleEnable()) {
                C11839m.m70688i(TAG, "checkNotifyModuleEnable false.");
                C10811y.m65822f("SpaceNotEnoughV5Error", "10", "checkNotifyModuleEnable false.");
            } else if (!CloudSpaceNotifyUtil.getInstance().needDelay()) {
                C10811y.m65822f("SpaceNotEnoughV5Error", "11", "");
                autoBackupFailNotifyV5(backupSpaceNotEnoughNeedData);
            } else {
                C11839m.m70688i(TAG, "need delay, start timer");
                C10811y.m65822f("SpaceNotEnoughV5Error", "1", "need delay, start timer");
                new C3009a(backupSpaceNotEnoughNeedData).m18128a();
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "space not enough notification error. err info : " + e10.getMessage());
            C10811y.m65822f("SpaceNotEnoughV5Error", "12", e10.getMessage());
        }
    }

    private void setSpaceScreenStateLisV5(NotEnoughDialogDataV5 notEnoughDialogDataV5, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        notEnoughDialogDataV5.setTaskId(getAutoBackupDlgTaskId());
        UserSpaceUtil.saveBackupFailPopupDelayInfo(getAutoBackupDlgInfo(notEnoughDialogDataV5, backupSpaceInsuffNoticeV5Configuration));
        ScreenListener.m18023c(getContext()).m18025b(new V5ScreenStateListener(notEnoughDialogDataV5, true, backupSpaceInsuffNoticeV5Configuration));
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify
    public boolean checkValid() throws IOException {
        BackupSpaceInsuffWindowNoticeBean backupSpaceInsufficient = BackupSpaceInsuffNoticeV5Manager.getInstance().getBackupSpaceInsufficient();
        if (backupSpaceInsufficient == null) {
            C11839m.m70688i(TAG, "checkValid bean is null");
            C10811y.m65822f("SecondaryRetentionError", "9", "checkValid bean is null");
            return false;
        }
        final List<PortraitAndGrade.UserTag> userTagsUseCache = UserSpaceUtil.getUserTagsUseCache(TAG);
        List<BackupSpaceInsuffNoticeV5Configuration> configuration = backupSpaceInsufficient.getConfiguration();
        if (configuration == null || configuration.isEmpty()) {
            C11839m.m70688i(TAG, "checkValid notification is null");
            C10811y.m65822f("SecondaryRetentionError", "9", "checkValid notification is null");
            return false;
        }
        this.collectNotification = (List) configuration.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.t0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpaceNotEnoughNotifyV5.lambda$checkValid$0(userTagsUseCache, (BackupSpaceInsuffNoticeV5Configuration) obj);
            }
        }).sorted(Comparator.comparingInt(new ToIntFunction() { // from class: com.huawei.android.hicloud.cloudbackup.process.v0
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((BackupSpaceInsuffNoticeV5Configuration) obj).getPriority();
            }
        })).collect(Collectors.toList());
        String str = "checkValid collectNotification size: " + this.collectNotification.size();
        C11839m.m70688i(TAG, str);
        C10811y.m65822f("SecondaryRetentionError", "9", str);
        reportEvent(userTagsUseCache);
        return !this.collectNotification.isEmpty();
    }

    public SecondaryRetentionContent getDownloadAppContent(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, NotEnoughDialogDataV5 notEnoughDialogDataV5) {
        if (backupSpaceInsuffNoticeV5Configuration == null || backupSpaceInsuffNoticeV5Configuration.getActiveWindow() == null || backupSpaceInsuffNoticeV5Configuration.getActiveWindow().isEmpty()) {
            C11839m.m70689w(TAG, "getDownloadAppContent activeWindow is null.");
            C10811y.m65822f("SecondaryRetentionError", "8", "getDownloadAppContent activeWindow is null.");
            return null;
        }
        GetActivityEntryResp getActivityEntryRespM67735i = C11289l.m67735i(NotifyTimerSpManager.getInstance().getBackupTotalNeedSize(), NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        if (getActivityEntryRespM67735i == null) {
            C11839m.m70689w(TAG, "getDownloadAppContent getActivityEntryResp is null.");
            C10811y.m65822f("SecondaryRetentionError", "8", "getDownloadAppContent getActivityEntryResp is null.");
            return null;
        }
        ActivityEntry entry = getActivityEntryRespM67735i.getEntry();
        if (entry == null || TextUtils.isEmpty(entry.getUrl())) {
            C11839m.m70689w(TAG, "getDownloadAppContent activityEntry is null.");
            C10811y.m65822f("SecondaryRetentionError", "8", "getDownloadAppContent activityEntry is null.");
            return null;
        }
        if (TextUtils.isEmpty(entry.getResource())) {
            C11839m.m70689w(TAG, "getDownloadAppContent resource is null.");
            C10811y.m65822f("SecondaryRetentionError", "8", "getDownloadAppContent resource is null.");
            return null;
        }
        HicloudH5ConfigManager.getInstance().checkH5ClientVersion(getActivityEntryRespM67735i.getClientVersion());
        if (!C11289l.m67731e(entry, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, 1003, true)) {
            C11839m.m70689w(TAG, "getDlAppNotification checkPpsAdsIsOk result = false");
            C10811y.m65822f("SecondaryRetentionError", "8", "getDlAppNotification checkPpsAdsIsOk result = false");
            return null;
        }
        List<PopUpWithActivityGoto> activeWindow = backupSpaceInsuffNoticeV5Configuration.getActiveWindow();
        SecondaryRetentionContent secondaryRetentionContent = new SecondaryRetentionContent();
        final NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr = {null};
        activeWindow.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.w0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpaceNotEnoughNotifyV5.lambda$getDownloadAppContent$6((PopUpWithActivityGoto) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.x0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SpaceNotEnoughNotifyV5.lambda$getDownloadAppContent$7(dialogGotoArr, (PopUpWithActivityGoto) obj);
            }
        });
        NotEnoughDialogDataV5.DialogGoto dialogGoto = dialogGotoArr[0];
        if (dialogGoto != null && NotifyConstants.HICLOUD_DLAPP.equals(dialogGoto.getPopupUri()) && "application".equals(dialogGotoArr[0].getPopupType())) {
            dialogGotoArr[0].setPopupType(NotifyConstants.HICLOUD_DLAPP);
            dialogGotoArr[0].setPopupUri(entry.getUrl());
        }
        secondaryRetentionContent.setNegativeGoto(dialogGotoArr[0]);
        final NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr2 = {null};
        activeWindow.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.y0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpaceNotEnoughNotifyV5.lambda$getDownloadAppContent$8((PopUpWithActivityGoto) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.z0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SpaceNotEnoughNotifyV5.lambda$getDownloadAppContent$9(dialogGotoArr2, (PopUpWithActivityGoto) obj);
            }
        });
        NotEnoughDialogDataV5.DialogGoto dialogGoto2 = dialogGotoArr2[0];
        if (dialogGoto2 != null && NotifyConstants.HICLOUD_DLAPP.equals(dialogGoto2.getPopupUri()) && "application".equals(dialogGotoArr2[0].getPopupType())) {
            dialogGotoArr2[0].setPopupType(NotifyConstants.HICLOUD_DLAPP);
            dialogGotoArr2[0].setPopupUri(entry.getUrl());
        }
        secondaryRetentionContent.setPositiveGoto(dialogGotoArr2[0]);
        String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(entry.getResource(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_TITLE);
        String strFromDBByResource2 = NoticeWithActivityUtil.getStrFromDBByResource(entry.getResource(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_MAIN_TEXT);
        String strFromDBByResource3 = NoticeWithActivityUtil.getStrFromDBByResource(entry.getResource(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_BUTTON_FIRST);
        String strFromDBByResource4 = NoticeWithActivityUtil.getStrFromDBByResource(entry.getResource(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_BUTTON_SECOND);
        if (TextUtils.isEmpty(strFromDBByResource) || TextUtils.isEmpty(strFromDBByResource2) || TextUtils.isEmpty(strFromDBByResource3) || TextUtils.isEmpty(strFromDBByResource4)) {
            C11839m.m70689w(TAG, "getDownloadAppContent text is null.");
            C10811y.m65822f("SecondaryRetentionError", "8", "getDownloadAppContent text is null.");
            return null;
        }
        secondaryRetentionContent.setTitle(strFromDBByResource);
        secondaryRetentionContent.setMessage(strFromDBByResource2);
        secondaryRetentionContent.setNegativeText(strFromDBByResource3);
        secondaryRetentionContent.setPositiveText(strFromDBByResource4);
        secondaryRetentionContent.setDialogType(1);
        secondaryRetentionContent.setResourceId(entry.getResource());
        notEnoughDialogDataV5.getV5DailogActivityAreaNeedData().setActivityEntry(entry);
        return secondaryRetentionContent;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify
    public NotEnoughNotifyPriority getPriority() {
        return NotEnoughNotifyPriority.V5;
    }

    public SecondaryRetentionContent getTaskCenterContent(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        if (backupSpaceInsuffNoticeV5Configuration == null || backupSpaceInsuffNoticeV5Configuration.getTaskCenterWindow() == null) {
            C11839m.m70689w(TAG, "gteTaskCenterContent taskCenterWindow null");
            C10811y.m65822f("SecondaryRetentionError", "8", "gteTaskCenterContent taskCenterWindow null");
            return null;
        }
        new C10252o(3).m63414a();
        if (C9718g.m60602t().m60608F(C0213f.m1377a())) {
            C11839m.m70688i(TAG, "checkTaskCenter exceed redemption limit");
            C10811y.m65822f("SecondaryRetentionError", "8", "checkTaskCenter exceed redemption limit");
            return null;
        }
        if (!CampaignCheckUtil.checkCampaignEntryCondition(C0213f.m1377a())) {
            C11839m.m70689w(TAG, "gteTaskCenterContent checkCampaignEntryCondition false");
            C10811y.m65822f("SecondaryRetentionError", "8", "gteTaskCenterContent checkCampaignEntryCondition false");
            return null;
        }
        String strM82923g = C13823d.m82904y().m82923g(12);
        if (TextUtils.isEmpty(strM82923g)) {
            C11839m.m70689w(TAG, "gteTaskCenterContent deepLink null");
            C10811y.m65822f("SecondaryRetentionError", "8", "gteTaskCenterContent deepLink null");
            return null;
        }
        SecondaryRetentionContent secondaryRetentionContent = new SecondaryRetentionContent();
        List<PopUpWithActivityGoto> buttons = backupSpaceInsuffNoticeV5Configuration.getTaskCenterWindow().getButtons();
        ActivePopup activityPopup = backupSpaceInsuffNoticeV5Configuration.getTaskCenterWindow().getActivityPopup();
        if (buttons == null || buttons.isEmpty()) {
            C11839m.m70689w(TAG, "gteTaskCenterContent buttons null");
            C10811y.m65822f("SecondaryRetentionError", "8", "gteTaskCenterContent buttons null");
            return null;
        }
        if (activityPopup == null) {
            C11839m.m70689w(TAG, "gteTaskCenterContent activityPopup null");
            C10811y.m65822f("SecondaryRetentionError", "8", "gteTaskCenterContent activityPopup null");
            return null;
        }
        if (TextUtils.isEmpty(activityPopup.getButtonFirst()) || TextUtils.isEmpty(activityPopup.getButtonSecond()) || TextUtils.isEmpty(activityPopup.getTitle()) || TextUtils.isEmpty(activityPopup.getMainText())) {
            C11839m.m70689w(TAG, "gteTaskCenterContent text null");
            C10811y.m65822f("SecondaryRetentionError", "8", "gteTaskCenterContent text null");
            return null;
        }
        final NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr = {null};
        buttons.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.b1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpaceNotEnoughNotifyV5.lambda$getTaskCenterContent$2((PopUpWithActivityGoto) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.c1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SpaceNotEnoughNotifyV5.lambda$getTaskCenterContent$3(dialogGotoArr, (PopUpWithActivityGoto) obj);
            }
        });
        NotEnoughDialogDataV5.DialogGoto dialogGoto = dialogGotoArr[0];
        if (dialogGoto != null && NotifyConstants.HICLOUD_CENTER.equals(dialogGoto.getPopupUri()) && "application".equals(dialogGotoArr[0].getPopupType())) {
            dialogGotoArr[0].setPopupType(NotifyConstants.TYPE_DEEPLINK);
            dialogGotoArr[0].setPopupUri(strM82923g);
        }
        secondaryRetentionContent.setNegativeGoto(dialogGotoArr[0]);
        final NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr2 = {null};
        buttons.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.d1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpaceNotEnoughNotifyV5.lambda$getTaskCenterContent$4((PopUpWithActivityGoto) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.u0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SpaceNotEnoughNotifyV5.lambda$getTaskCenterContent$5(dialogGotoArr2, (PopUpWithActivityGoto) obj);
            }
        });
        NotEnoughDialogDataV5.DialogGoto dialogGoto2 = dialogGotoArr2[0];
        if (dialogGoto2 != null && NotifyConstants.HICLOUD_CENTER.equals(dialogGoto2.getPopupUri()) && "application".equals(dialogGotoArr2[0].getPopupType())) {
            dialogGotoArr2[0].setPopupType(NotifyConstants.TYPE_DEEPLINK);
            dialogGotoArr2[0].setPopupUri(strM82923g);
        }
        secondaryRetentionContent.setPositiveGoto(dialogGotoArr2[0]);
        secondaryRetentionContent.setNegativeText(activityPopup.getButtonFirst());
        secondaryRetentionContent.setPositiveText(activityPopup.getButtonSecond());
        secondaryRetentionContent.setTitle(activityPopup.getTitle());
        secondaryRetentionContent.setMessage(activityPopup.getMainText());
        secondaryRetentionContent.setDialogType(2);
        return secondaryRetentionContent;
    }

    public SecondaryRetentionContent getUserActivityContent(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, NotEnoughDialogDataV5 notEnoughDialogDataV5) {
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70686d(TAG, "getUserActivityContent is child account");
            C10811y.m65822f("SecondaryRetentionError", "8", "getUserActivityContent is child account");
            notEnoughDialogDataV5.setActivityType(0);
            return null;
        }
        if (C0209d.m1293p1()) {
            C11839m.m70686d(TAG, "getUserActivityContent isInkScreen");
            C10811y.m65822f("SecondaryRetentionError", "8", "getUserActivityContent isInkScreen");
            notEnoughDialogDataV5.setActivityType(0);
            return null;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70686d(TAG, "getUserActivityContent not owner user");
            C10811y.m65822f("SecondaryRetentionError", "8", "getUserActivityContent not owner user");
            notEnoughDialogDataV5.setActivityType(0);
            return null;
        }
        try {
            if (C11829c.m70629x0(true)) {
                C11839m.m70686d(TAG, "isFamilyShareMember");
                C10811y.m65822f("SecondaryRetentionError", "8", "isFamilyShareMember");
                notEnoughDialogDataV5.setActivityType(0);
                return null;
            }
            SecondaryRetentionContent taskCenterContent = getTaskCenterContent(backupSpaceInsuffNoticeV5Configuration);
            if (taskCenterContent != null) {
                C11839m.m70688i(TAG, "getUserActivityContent: task center");
                notEnoughDialogDataV5.setActivityType(2);
                return taskCenterContent;
            }
            SecondaryRetentionContent downloadAppContent = getDownloadAppContent(backupSpaceInsuffNoticeV5Configuration, notEnoughDialogDataV5);
            if (downloadAppContent != null) {
                C11839m.m70688i(TAG, "getUserActivityContent: download app");
                notEnoughDialogDataV5.setActivityType(1);
                return downloadAppContent;
            }
            C11839m.m70688i(TAG, "getUserActivityContent: null");
            notEnoughDialogDataV5.setActivityType(0);
            return null;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, e10.getMessage());
            return null;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify
    public void sendSpaceNotEnough(boolean z10, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        this.context = C0213f.m1377a();
        if (getContext() == null) {
            C11839m.m70687e(TAG, "sendSpaceNotEnoughv5 getContext() is null");
        } else {
            sendSpaceNotEnoughV5(z10, backupSpaceNotEnoughNeedData);
        }
    }
}
