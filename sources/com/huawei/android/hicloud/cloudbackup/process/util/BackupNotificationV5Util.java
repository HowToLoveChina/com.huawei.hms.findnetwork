package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.p088ui.uiextend.bean.SecondaryRetentionContent;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.BackupErrorPopDefaultInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.DataItems;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.ModelGoto;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.NoticeContentNoticePopup;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.TriggerDefine;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.V5DetailPageText;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fj.C9718g;
import hk.C10278a;
import hu.C10342a;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import je.C10811y;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p020ap.C1009d;
import p292fn.C9733f;
import p341hj.C10252o;
import p364ib.C10465b;
import p454lj.C11289l;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;
import p778xk.C13823d;
import p848zl.C14333b;

/* loaded from: classes2.dex */
public class BackupNotificationV5Util {
    private static final int FREE_SPACE = 50;
    private static final int SUPPORT_TRIGGER = 1;
    private static final String TAG = "BackupNotificationV5Util";

    private static void addDialogButton(List<NotEnoughDialogDataV5.DialogButtonV5> list, String str, String str2, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        String strQueryStrById = queryStrById(str);
        NotEnoughDialogDataV5.DialogGoto buttonGoto = getButtonGoto(str2, backupSpaceInsuffNoticeV5Configuration);
        if (TextUtils.isEmpty(strQueryStrById) || buttonGoto == null) {
            C11839m.m70689w(TAG, "addDialogButton param is null" + str2);
            return;
        }
        if (!NotifyConstants.TYPE_DLAPP_AND_ACYIVE.equals(buttonGoto.getPopupUri())) {
            list.add(new NotEnoughDialogDataV5.DialogButtonV5(strQueryStrById, buttonGoto));
            return;
        }
        NotEnoughDialogDataV5.DialogButtonV5 dlAppOrActiveButton = getDlAppOrActiveButton(buttonGoto, strQueryStrById);
        if (dlAppOrActiveButton != null) {
            list.add(dlAppOrActiveButton);
        }
    }

    public static RecommendNeedData buildDetailText(RecommendNeedData recommendNeedData, String str, V5DetailPageText v5DetailPageText) {
        if (v5DetailPageText == null) {
            C11839m.m70687e(TAG, "buildDetailText, v5DetailPageText is null.");
            if (TextUtils.isEmpty(str) || NotifyConstants.DETAIL2.equals(str) || "detail".equals(str) || NotifyConstants.DETAIL3.equals(str)) {
                return null;
            }
            return recommendNeedData;
        }
        if (NotifyConstants.DETAIL2.equals(str)) {
            recommendNeedData.setTitle(getTextFromDB(v5DetailPageText.getDetail2Title()));
            recommendNeedData.setMainText(getTextFromDB(v5DetailPageText.getDetail2MainText()));
        } else if ("detail".equals(str)) {
            recommendNeedData.setTitle(getTextFromDB(v5DetailPageText.getDetailTitle()));
            Context contextM1377a = C0213f.m1377a();
            if (recommendNeedData.getGalleryNum() <= 0 || recommendNeedData.getBackupNeedSpace() <= 0 || C2783d.m16105R()) {
                recommendNeedData.setMainText(C10465b.m64293c(getTextFromDB(v5DetailPageText.getDetailPhotoDescOpen()), C0223k.m1524g(contextM1377a, recommendNeedData.getBackupNeedSpace()), C0223k.m1524g(contextM1377a, recommendNeedData.getNotUsedSpace())));
            } else {
                Resources resources = contextM1377a.getResources();
                if (resources != null) {
                    recommendNeedData.setMainText(C10465b.m64293c(getTextFromDB(v5DetailPageText.getDetailPhotoDescClose()), resources.getQuantityString(R$plurals.cloud_backup_fail_remain_data, (int) recommendNeedData.getGalleryNum(), Integer.valueOf((int) recommendNeedData.getGalleryNum())), C0223k.m1524g(contextM1377a, recommendNeedData.getBackupNeedSpace())));
                }
            }
        } else {
            recommendNeedData.setTitle(getTextFromDB(v5DetailPageText.getDetailTitle()));
            recommendNeedData.setMainText(getTextFromDB(v5DetailPageText.getDetailMainText()));
            recommendNeedData.setSubTitle(getTextFromDB(v5DetailPageText.getDetailSubTitle()));
            recommendNeedData.setSecondMainText(getTextFromDB(v5DetailPageText.getDetailMainTextSec()));
        }
        return recommendNeedData;
    }

    public static GetPackagesBySpaceRuleResp buildSpaceRuleResp(GetAvailableGradePackagesResp getAvailableGradePackagesResp) {
        String gradeCode;
        PackageGrades next;
        int matchPriority;
        if (getAvailableGradePackagesResp == null) {
            C11839m.m70687e(TAG, "getRecommendInfo getAvailableGradePackagesResp is null.");
            return null;
        }
        List<PackageGrades> packageGrades = getAvailableGradePackagesResp.getPackageGrades();
        if (packageGrades == null) {
            C11839m.m70687e(TAG, "getRecommendInfo packageGrades is null.");
            return null;
        }
        Iterator<PackageGrades> it = packageGrades.iterator();
        while (true) {
            if (!it.hasNext()) {
                gradeCode = "";
                next = null;
                break;
            }
            next = it.next();
            if (next.getRecommended() == 1) {
                gradeCode = next.getGradeCode();
                break;
            }
        }
        List<CloudPackage> spacePackages = getAvailableGradePackagesResp.getSpacePackages();
        if (TextUtils.isEmpty(gradeCode)) {
            C11839m.m70687e(TAG, "getRecommendInfo has not valid gradeCode.");
            return null;
        }
        int i10 = Integer.MIN_VALUE;
        int durationMonth = Integer.MAX_VALUE;
        CloudPackage cloudPackage = null;
        for (CloudPackage cloudPackage2 : spacePackages) {
            if (cloudPackage2.getGradeCode().equals(gradeCode) && next != null && next.getCapacity() == cloudPackage2.getCapacity() && ((matchPriority = cloudPackage2.getMatchPriority()) > i10 || (matchPriority == i10 && durationMonth > cloudPackage2.getDurationMonth()))) {
                durationMonth = cloudPackage2.getDurationMonth();
                cloudPackage = cloudPackage2;
                i10 = matchPriority;
            }
        }
        if (cloudPackage == null) {
            C11839m.m70687e(TAG, "getRecommendInfo targetCloudPackage or targetPackageGrade is null.");
            return null;
        }
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = new GetPackagesBySpaceRuleResp();
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        getPackagesBySpaceRuleResp.setPackageGrades(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(cloudPackage);
        getPackagesBySpaceRuleResp.setSpacePackages(arrayList2);
        getPackagesBySpaceRuleResp.setCurrentTime(getAvailableGradePackagesResp.getServerTime());
        getPackagesBySpaceRuleResp.setVoucherList(getAvailableGradePackagesResp.getAvailableVouchers());
        return getPackagesBySpaceRuleResp;
    }

    private static boolean checkButtonIsNeedSort(List<NotEnoughDialogDataV5.DialogButtonV5> list) {
        if (list == null || list.size() < 2) {
            return false;
        }
        for (NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5 : list) {
            if (dialogButtonV5.getButtonGoto() == null || dialogButtonV5.getButtonGoto().getPosition() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0178 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5 dataAdapt(com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration r14, com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5 r15) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util.dataAdapt(com.huawei.hicloud.notification.db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration, com.huawei.android.hicloud.ui.uiextend.bean.NotEnoughDialogDataV5):com.huawei.android.hicloud.ui.uiextend.bean.NotEnoughDialogDataV5");
    }

    private static NotEnoughDialogDataV5.DialogButtonV5 getActiveButton(NotEnoughDialogDataV5.DialogGoto dialogGoto, String str) {
        new C10252o(3).m63414a();
        if (C9718g.m60602t().m60608F(C0213f.m1377a())) {
            C11839m.m70686d(TAG, "getActiveButton exceed redemption limit");
            return null;
        }
        if (!CampaignCheckUtil.checkCampaignEntryCondition(C0213f.m1377a())) {
            C11839m.m70686d(TAG, "getActiveButton checkCampaignEntryCondition false");
            return null;
        }
        String strM82923g = C13823d.m82904y().m82923g(12);
        if (TextUtils.isEmpty(strM82923g)) {
            C11839m.m70686d(TAG, "getActiveButton uri is null");
            return null;
        }
        NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5 = new NotEnoughDialogDataV5.DialogButtonV5(str, dialogGoto);
        if (dialogButtonV5.getButtonGoto() == null) {
            C11839m.m70686d(TAG, "getActiveButton buttonGoto is null");
            return null;
        }
        dialogButtonV5.getButtonGoto().setPopupUri(strM82923g);
        dialogButtonV5.getButtonGoto().setPopupType(NotifyConstants.TYPE_DEEPLINK);
        return dialogButtonV5;
    }

    private static NotEnoughDialogDataV5.DialogGoto getButtonGoto(final String str, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        ModelGoto notifyGoto = backupSpaceInsuffNoticeV5Configuration.getNotifyGoto();
        if (notifyGoto == null) {
            C11839m.m70689w(TAG, "getButtonGoto notifyGoto is null");
            return null;
        }
        List<PopUpWithActivityGoto> buttonLink = notifyGoto.getButtonLink();
        if (buttonLink == null) {
            C11839m.m70689w(TAG, "getButtonGoto buttonLink is null");
            return null;
        }
        final NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr = {null};
        buttonLink.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupNotificationV5Util.lambda$getButtonGoto$1(str, (PopUpWithActivityGoto) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BackupNotificationV5Util.lambda$getButtonGoto$2(dialogGotoArr, (PopUpWithActivityGoto) obj);
            }
        });
        return dialogGotoArr[0];
    }

    private static NotEnoughDialogDataV5.DialogButtonV5 getDlAppButton(NotEnoughDialogDataV5.DialogGoto dialogGoto, String str) {
        GetActivityEntryResp getActivityEntryRespM67735i = C11289l.m67735i(NotifyTimerSpManager.getInstance().getBackupTotalNeedSize(), NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        if (getActivityEntryRespM67735i == null) {
            C11839m.m70686d(TAG, "getDlAppButton getActivityEntryResp is null.");
            return null;
        }
        ActivityEntry entry = getActivityEntryRespM67735i.getEntry();
        if (entry == null || TextUtils.isEmpty(entry.getUrl())) {
            C11839m.m70686d(TAG, "getDlAppButton activityEntry is null.");
            return null;
        }
        if (TextUtils.isEmpty(entry.getResource())) {
            C11839m.m70686d(TAG, "getDlAppButton resource is null.");
            return null;
        }
        HicloudH5ConfigManager.getInstance().checkH5ClientVersion(getActivityEntryRespM67735i.getClientVersion());
        if (!C11289l.m67731e(entry, NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT, 1003, true)) {
            C11839m.m70686d(TAG, "getDlAppButton checkPpsAdsIsOk result = false");
            return null;
        }
        NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5 = new NotEnoughDialogDataV5.DialogButtonV5(str, dialogGoto);
        String url = entry.getUrl();
        if (dialogButtonV5.getButtonGoto() == null) {
            C11839m.m70686d(TAG, "getDlAppButton button goto is null.");
            return null;
        }
        dialogButtonV5.getButtonGoto().setPopupUri(url);
        dialogButtonV5.getButtonGoto().setPopupType(NotifyConstants.HICLOUD_DLAPP);
        return dialogButtonV5;
    }

    private static NotEnoughDialogDataV5.DialogButtonV5 getDlAppOrActiveButton(NotEnoughDialogDataV5.DialogGoto dialogGoto, String str) {
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70686d(TAG, "getDlAppOrActiveButton is child account");
            return null;
        }
        if (C0209d.m1293p1()) {
            C11839m.m70686d(TAG, "getDlAppOrActiveButton isInkScreen");
            return null;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70686d(TAG, "getDlAppOrActiveButton not owner user");
            return null;
        }
        try {
            if (C11829c.m70629x0(true)) {
                C11839m.m70686d(TAG, "getDlAppOrActiveButton isFamilyShareMember");
                return null;
            }
            NotEnoughDialogDataV5.DialogButtonV5 activeButton = getActiveButton(dialogGoto, str);
            return activeButton == null ? getDlAppButton(dialogGoto, str) : activeButton;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getDlAppOrActiveButton： " + e10.getMessage());
            return null;
        }
    }

    private static String getResourceByRemindType(String str, String str2, String str3) {
        return str.equals(NotifyConstants.HICLOUD_BACKUP_REMIND_DELETE) ? str2 : str3;
    }

    private static int getSelectIdx(int i10) {
        int select;
        String strM60762u = C9733f.m60705z().m60762u("backupErrorPopupDefaultOptionIndex");
        int i11 = 0;
        if (TextUtils.isEmpty(strM60762u)) {
            select = 0;
        } else {
            try {
                BackupErrorPopDefaultInfo backupErrorPopDefaultInfo = (BackupErrorPopDefaultInfo) new Gson().fromJson(strM60762u, BackupErrorPopDefaultInfo.class);
                select = C9733f.m60705z().m60720O("backupErrorPopupDefaultOptionIndex") ? backupErrorPopDefaultInfo.getSelect() : backupErrorPopDefaultInfo.getDefaultSelect();
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "getSelectIdx error: " + e10);
            }
        }
        if (select < 0 || select >= i10) {
            C11839m.m70689w(TAG, "selectIdx not correct: " + select);
        } else {
            i11 = select;
        }
        C11839m.m70688i(TAG, "selectIdx: " + i11);
        return i11;
    }

    private static String getTextFromDB(String str) {
        if (!TextUtils.isEmpty(str)) {
            return BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(str);
        }
        C11839m.m70687e(TAG, "getTextFromDB id is null.");
        return "";
    }

    private static SecondaryRetentionContent getUserActivityContent(NotEnoughDialogDataV5 notEnoughDialogDataV5) {
        String strQueryStrById;
        String strQueryStrById2;
        String strQueryStrById3;
        String strQueryStrById4;
        if (notEnoughDialogDataV5 == null) {
            C11839m.m70689w(TAG, "notEnoughDialogDataV5 is null");
            return null;
        }
        SecondaryRetentionContent secondaryRetentionContent = notEnoughDialogDataV5.getSecondaryRetentionContent();
        if (secondaryRetentionContent == null) {
            C11839m.m70689w(TAG, "secondaryRetentionContent is null");
            return null;
        }
        if (secondaryRetentionContent.getDialogType() == 1) {
            strQueryStrById = NoticeWithActivityUtil.getStrFromDBByResource(secondaryRetentionContent.getResourceId(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_TITLE);
            strQueryStrById2 = NoticeWithActivityUtil.getStrFromDBByResource(secondaryRetentionContent.getResourceId(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_MAIN_TEXT);
            strQueryStrById3 = NoticeWithActivityUtil.getStrFromDBByResource(secondaryRetentionContent.getResourceId(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_BUTTON_FIRST);
            strQueryStrById4 = NoticeWithActivityUtil.getStrFromDBByResource(secondaryRetentionContent.getResourceId(), NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_BUTTON_SECOND);
        } else {
            strQueryStrById = queryStrById(secondaryRetentionContent.getTitle());
            strQueryStrById2 = queryStrById(secondaryRetentionContent.getMessage());
            strQueryStrById3 = queryStrById(secondaryRetentionContent.getNegativeText());
            strQueryStrById4 = queryStrById(secondaryRetentionContent.getPositiveText());
        }
        if (TextUtils.isEmpty(strQueryStrById) || TextUtils.isEmpty(strQueryStrById2) || TextUtils.isEmpty(strQueryStrById3) || TextUtils.isEmpty(strQueryStrById4)) {
            C11839m.m70689w(TAG, "getDownloadAppContent text is null.");
            return null;
        }
        String strM1303s = C0209d.m1303s(strQueryStrById2, 50);
        secondaryRetentionContent.setTitle(strQueryStrById);
        secondaryRetentionContent.setMessage(strM1303s);
        secondaryRetentionContent.setNegativeText(strQueryStrById3);
        secondaryRetentionContent.setPositiveText(strQueryStrById4);
        return secondaryRetentionContent;
    }

    public static void initAppIcon(Context context, DataItems dataItems) throws PackageManager.NameNotFoundException {
        C11839m.m70688i(TAG, "initAppIcon");
        if (dataItems == null) {
            C11839m.m70689w(TAG, "dataItem is null");
            return;
        }
        String bundleName = dataItems.getBundleName();
        if (C14333b.m85483r().containsKey(bundleName)) {
            return;
        }
        CommonPicture icon = dataItems.getIcon();
        if (icon == null || context == null) {
            C11839m.m70689w(TAG, "commonPicture or context is null");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            C11839m.m70689w(TAG, "packageManager is null");
            return;
        }
        try {
            String url = icon.getUrl();
            String picturePath = BackupSpaceInsuffNoticeV5Manager.getInstance().getPicturePath(url);
            File fileM63442h = C10278a.m63442h(picturePath);
            if (!TextUtils.isEmpty(url) && !fileM63442h.exists()) {
                File parentFile = fileM63442h.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    C11839m.m70688i(TAG, "desParent.mkdirs false " + picturePath);
                }
                C11839m.m70688i(TAG, "start BaseDownLoadFileTask " + bundleName);
                C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, picturePath, icon.getHash(), null), false);
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(bundleName, 0);
            if (packageInfo == null) {
                dataItems.setDesc("");
                dataItems.setErrorDesc("packageInfo is null");
                return;
            }
            if (TextUtils.isEmpty(url)) {
                url = bundleName;
            }
            String iconPath = BackupSpaceInsuffNoticeV5Manager.getInstance().getIconPath(url);
            File fileM63442h2 = C10278a.m63442h(iconPath);
            if (!fileM63442h2.exists()) {
                File parentFile2 = fileM63442h2.getParentFile();
                if (parentFile2 != null && !parentFile2.exists() && !parentFile2.mkdirs()) {
                    C11839m.m70688i(TAG, "desParent.mkdirs false " + picturePath);
                }
                C11839m.m70688i(TAG, "start loadIcon");
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    ICBUtil.drawable2File(applicationInfo.loadIcon(packageManager), iconPath);
                }
            }
            C11839m.m70688i(TAG, "start BaseDownLoadFileTask " + bundleName);
            C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, picturePath, icon.getHash(), null), false);
        } catch (PackageManager.NameNotFoundException e10) {
            dataItems.setDesc("");
            dataItems.setErrorDesc("packageInfo is null");
            C11839m.m70688i(TAG, "bundleName getPackageInfo error" + e10);
        } catch (Exception e11) {
            C11839m.m70688i(TAG, "bundleName exception error" + e11);
            dataItems.setErrorDesc("getPackageInfo exception: " + e11);
        }
    }

    private static void initDialogButton(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration, NotEnoughDialogDataV5.DialogMainShowContentV5 dialogMainShowContentV5, NoticeContentNoticePopup noticeContentNoticePopup) {
        if (dialogMainShowContentV5 == null) {
            C11839m.m70689w(TAG, "initDialogButton dialogMainShowContentV5 is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        addDialogButton(arrayList, noticeContentNoticePopup.getButtonFirst(), NotifyConstants.POP_GOTO_BUTTON_FIRST, backupSpaceInsuffNoticeV5Configuration);
        addDialogButton(arrayList, noticeContentNoticePopup.getButtonSecond(), NotifyConstants.POP_GOTO_BUTTON_SECOND, backupSpaceInsuffNoticeV5Configuration);
        addDialogButton(arrayList, noticeContentNoticePopup.getButtonThird(), NotifyConstants.POP_GOTO_BUTTON_THIRD, backupSpaceInsuffNoticeV5Configuration);
        C11839m.m70688i(TAG, "initDialogButton botton num: " + arrayList.size());
        if (checkButtonIsNeedSort(arrayList)) {
            arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return BackupNotificationV5Util.lambda$initDialogButton$0((NotEnoughDialogDataV5.DialogButtonV5) obj, (NotEnoughDialogDataV5.DialogButtonV5) obj2);
                }
            });
        }
        dialogMainShowContentV5.setButtonList(arrayList);
    }

    private static boolean isSatisfy(TriggerDefine triggerDefine) {
        if (triggerDefine == null) {
            return true;
        }
        return C1009d.m6109e().m6119k(triggerDefine.getParams(), triggerDefine.getRealtimeParams(), triggerDefine.getTrigger(), 1, new LinkedHashMap<>());
    }

    public static boolean isShowDialog(Context context) {
        if (context == null) {
            return false;
        }
        return C0209d.m1265i1(context) || C0209d.m1245d1(context, BackupMainActivity.class.getName()) || C0209d.m1245d1(context, CloudBackupDetailStateActivity.class.getName()) || C0209d.m1245d1(context, MainActivity.class.getName());
    }

    public static /* synthetic */ boolean lambda$getButtonGoto$1(String str, PopUpWithActivityGoto popUpWithActivityGoto) {
        return TextUtils.equals(popUpWithActivityGoto.getCode(), str);
    }

    public static /* synthetic */ void lambda$getButtonGoto$2(NotEnoughDialogDataV5.DialogGoto[] dialogGotoArr, PopUpWithActivityGoto popUpWithActivityGoto) {
        NotEnoughDialogDataV5.DialogGoto dialogGoto = new NotEnoughDialogDataV5.DialogGoto();
        dialogGotoArr[0] = dialogGoto;
        dialogGoto.setPopupType(popUpWithActivityGoto.getPopupType());
        dialogGotoArr[0].setPopupUri(popUpWithActivityGoto.getPopupUri());
        dialogGotoArr[0].setPosition(popUpWithActivityGoto.getPosition());
    }

    public static /* synthetic */ int lambda$initDialogButton$0(NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5, NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV52) {
        if (dialogButtonV52.getButtonGoto() == null || dialogButtonV52.getButtonGoto().getPosition() == null || dialogButtonV5.getButtonGoto() == null || dialogButtonV5.getButtonGoto().getPosition() == null) {
            return -1;
        }
        return Integer.compare(dialogButtonV5.getButtonGoto().getPosition().intValue(), dialogButtonV52.getButtonGoto().getPosition().intValue());
    }

    private static String queryStrById(String str) {
        return BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(str);
    }

    public static void startNotificationActivity(boolean z10, Context context, NotEnoughDialogDataV5 notEnoughDialogDataV5, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        if (notEnoughDialogDataV5 == null) {
            C11839m.m70687e(TAG, "startNotificationActivity notEnoughDialogDataV5 is null.");
            return;
        }
        if (backupSpaceInsuffNoticeV5Configuration == null) {
            C11839m.m70687e(TAG, "notification is null.");
            return;
        }
        if (!isSatisfy(backupSpaceInsuffNoticeV5Configuration.getTriggerDefine())) {
            C10811y.m65822f("SpaceNotEnoughV5Error", "19", "backup activity no Reach reach strategy");
            C11839m.m70688i(TAG, "backup activity no Reach reach strategy");
            return;
        }
        dataAdapt(backupSpaceInsuffNoticeV5Configuration, notEnoughDialogDataV5);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        if (z10) {
            hiCloudSafeIntent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
            C0209d.m1302r2(hiCloudSafeIntent, context.getPackageName());
        } else {
            hiCloudSafeIntent.setClass(context, BackupNotificationActivity.class);
        }
        hiCloudSafeIntent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 17);
        hiCloudSafeIntent.putExtra("backup_space_not_enough_notification_key_V5", new Gson().toJson(notEnoughDialogDataV5));
        hiCloudSafeIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (!isShowDialog(context)) {
            C10811y.m65822f("SpaceNotEnoughV5Error", "18", "backup activity no foreground");
            C11839m.m70688i(TAG, "backup activity no foreground");
        } else {
            C10342a.m63676b(context, hiCloudSafeIntent);
            ScreenListener.m18023c(context).m18028g();
            UserSpaceUtil.checkAndClearDlgDelayInfo(notEnoughDialogDataV5.getTaskId());
        }
    }
}
