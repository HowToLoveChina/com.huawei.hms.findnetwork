package com.huawei.hicloud.notification;

import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.CloudSpaceInfo;
import com.huawei.hicloud.notification.bean.ActivityEntryEx;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.p106db.bean.SNTimes;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.operator.SNTimeOperator;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import fk.C9721b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public interface ICloudSpaceProxy {
    NotifyNeedData buildBackupBeforeNoticeNotifyNeedData(MsgUserData msgUserData, String str);

    NotifyNeedData buildBackupCycleNotifyNeedData(ExtraNotificationBean extraNotificationBean, boolean z10, int i10, String str);

    String buildBackupSuspendContent(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData);

    void callNotifyServerInDs(String str);

    boolean checkNotifyCondition(Context context, long j10);

    boolean checkUserTag(List<String> list);

    void clearRecommendCardsNotification(int i10);

    boolean diamondCanNotify(long j10);

    NotificationWithActivity doSpaceNoticeWithActivity(Map<String, List<NotificationWithActivity>> map, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, List<PortraitAndGrade.UserTag> list, long j11, List<NotificationWithActivity> list2);

    String formatSpaceForMain(Context context, long j10);

    long getAvailableSize();

    int getBackupCycle();

    CloudSpace getCloudSpace() throws C9721b;

    String getCurrentGradeCode(String str);

    ActivityEntryEx getIncentiveCardActivityEntryEx(String str, LinkedHashMap<String, String> linkedHashMap, int i10);

    ActivityEntryEx getIncentiveCardActivityEntryEx(String str, boolean z10, LinkedHashMap<String, String> linkedHashMap);

    long getLastBackupSuccessTime();

    long getLatestBackupCycleDay();

    long getLocalClearSpace(CountDownLatch countDownLatch);

    long getLocalPhotoSpace(CountDownLatch countDownLatch);

    Intent getMemberSpaceNotifyIntent();

    CloudSpaceInfo getModuleSizePercent();

    CloudSpaceInfo getModuleSizePercentByServer();

    String getNPSStringFromDb(String str);

    long getNeedBackupSize();

    long getNextBackupTime();

    String getParam(String str, String str2);

    String getParam(String str, String str2, String str3);

    String getParamRealTime(String str, String str2, String str3);

    Map<String, String> getParamsFromServer(List<String> list);

    Map<String, Integer> getSpaceLanguageMap();

    long getUsedSize();

    List<PortraitAndGrade.UserTag> getUserTagList(String str);

    VoucherNotiDisplayInfo getVoucherInfo(SpaceNotification spaceNotification, Long l10);

    boolean isBackupEndCodeSatisfy(int i10);

    boolean isBackupFailNoticeFrequencySatisfy();

    boolean isBackupTaskExecuteToday();

    boolean isBackupTaskFailedAndWillRetryToday();

    boolean isDsStartMainFrequencySatisfied();

    boolean isFamilyShareMember();

    boolean isGallerySupportSetting();

    boolean isGeneralAlbumOnBySp();

    boolean isInBackupOrRestoreTask();

    boolean isLatestBackupTaskFailedToday();

    boolean isNewBmUserBackupNoData();

    boolean isNoMoreRemindSwitchChecked();

    boolean isNoticeFrequencySatisfyDayOnceConfig(String str, float f10);

    boolean isParamSatisfy(List<String> list, List<String> list2, String str);

    CloudSpace isSatisfiedCloudSpaceFull(String str, String str2);

    boolean isSatisfiedTwoHundredGuid(boolean z10, LinkedHashMap<String, String> linkedHashMap);

    boolean isSpecifiedTimeInBackupCycleDay(long j10);

    boolean isThirdAndSystemAppSwitchOpen();

    long queryDeviceDeleteListSize();

    boolean queryDeviceDeleteSwitch();

    void reportRecommendCardShowEvent(ArrayList<RecommendCard> arrayList, boolean z10);

    void reportRecommendCardUnsatisfied(String str, String str2, String str3);

    void saveForcedUpgradeConfig(Context context, boolean z10, ForcedUpgradeUtil.QueryUpdate queryUpdate);

    void saveNotificationTime(String str, long j10);

    void sendBackupFailNotify(int i10);

    void sendFamilyShareEnableNotify(long j10);

    void sendFamilyShareStopNotify();

    void sendHomePageRecommendCardsNotification(String str, ArrayList<RecommendCard> arrayList);

    void sendQuitOwnerFamilyShareNotify();

    void sendSiteChangedNotification();

    void sendSiteOfflineNotification();

    void setLastBackupNotifyTime(Context context);
}
