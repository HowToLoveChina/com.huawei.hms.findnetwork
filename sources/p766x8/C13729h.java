package p766x8;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.bean.DsStartMainProcessPolicy;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol;
import com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.constant.CommonBase;
import com.huawei.android.hicloud.p088ui.activity.AccountOpenSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.SiteChangeTipActivity;
import com.huawei.android.hicloud.p088ui.activity.SiteOfflineTipActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceMemberShareActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.task.schedule.BackupNotifyCancelTimer;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.CloudSpaceInfo;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.bean.ActivityEntryEx;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.data.MediaDataCollector;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.HiCloudSpacePositionMgrManager;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notificationv2.bean.ActionTimeRecord;
import com.huawei.hicloud.request.appmashup.bean.C4984c;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.router.R$drawable;
import com.huawei.hicloud.router.R$string;
import com.huawei.hicloud.router.data.FamilyShareStaticPages;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import ge.C9908c;
import gl.C9964e;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import kn.C11074k;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0235t;
import p015ak.C0238w;
import p015ak.C0241z;
import p020ap.C1006a;
import p020ap.C1009d;
import p052cb.C1412i;
import p252e9.C9430g;
import p284fb.C9681b;
import p292fn.C9733f;
import p315gj.C9948a;
import p329h7.C10121i;
import p364ib.C10465b;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11289l;
import p454lj.C11296s;
import p454lj.C11303z;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import p703v8.C13367d;
import p703v8.C13368e;
import p709vj.C13452e;
import p711vl.C13464d;
import p711vl.C13466f;
import p732w8.C13549a0;
import p805yb.C13933c;
import p815ym.AbstractC14026a;
import p836z8.C14157f;
import p848zl.C14337f;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;
import to.C13049a;

/* renamed from: x8.h */
/* loaded from: classes2.dex */
public class C13729h implements ICloudSpaceProxy {

    /* renamed from: x8.h$a */
    public class a implements QuotaInfoCallback {
        public a() {
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback
        /* renamed from: a */
        public void mo15490a() {
            C11839m.m70688i("CloudSpaceProxyImp", "onQueryFailed");
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback
        /* renamed from: b */
        public void mo15491b() {
            C11839m.m70688i("CloudSpaceProxyImp", "onQuerySuccess");
        }
    }

    /* renamed from: p */
    public static /* synthetic */ boolean m82494p(ICycleChecker iCycleChecker) {
        return !"1".equals(iCycleChecker.getType());
    }

    /* renamed from: q */
    public static /* synthetic */ boolean m82495q(long j10, long j11, ActionTimeRecord actionTimeRecord) {
        return actionTimeRecord.getTimeStamp() >= j10 && actionTimeRecord.getTimeStamp() < j11;
    }

    /* renamed from: r */
    public static /* synthetic */ boolean m82496r(long j10, long j11, Double d10) {
        return d10.doubleValue() >= ((double) j10) && d10.doubleValue() < ((double) j11);
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m82497s(long j10, long j11, Double d10) {
        return d10.doubleValue() >= ((double) j10) && d10.doubleValue() <= ((double) j11);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public NotifyNeedData buildBackupBeforeNoticeNotifyNeedData(MsgUserData msgUserData, String str) {
        return new BackupNotificationManager(C0213f.m1377a()).buildBackupBeforeNoticeNotifyNeedData(msgUserData, str);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public NotifyNeedData buildBackupCycleNotifyNeedData(ExtraNotificationBean extraNotificationBean, boolean z10, int i10, String str) {
        return new BackupNotificationManager(C0213f.m1377a()).buildBackupCycleNotifyNeedData(extraNotificationBean, z10, i10, str);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String buildBackupSuspendContent(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        return new UserSpaceUtil(C0213f.m1377a()).getIMMessageStr(backupSpaceNotEnoughNeedData);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void callNotifyServerInDs(String str) {
        NotifyLogger.m29915i("CloudSpaceProxyImp", "in DS Process");
        ICBServiceProtocol.getInstance().callNotifyServer(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkNotifyCondition(android.content.Context r12, long r13) {
        /*
            r11 = this;
            vl.d r11 = p711vl.C13464d.m81030f(r12)
            java.lang.String r12 = "lastsuccesstime"
            long r0 = r11.m81037h(r12)
            java.lang.String r12 = "lastbackuptime"
            long r2 = r11.m81037h(r12)
            java.lang.String r12 = "lastnotifytime"
            r11.m81037h(r12)
            long r11 = java.lang.System.currentTimeMillis()
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r5 = 1
            r6 = 1
            java.lang.String r8 = "CloudSpaceProxyImp"
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            if (r4 != 0) goto L45
            long r11 = r11 - r2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "has no backup record, day = "
            r0.append(r1)
            long r1 = r11 - r6
            long r1 = r1 / r9
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            p514o9.C11839m.m70688i(r8, r0)
            long r13 = r13 * r9
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L63
            goto L64
        L45:
            long r11 = r11 - r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "has success backup record, day = "
            r0.append(r1)
            long r1 = r11 - r6
            long r1 = r1 / r9
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            p514o9.C11839m.m70688i(r8, r0)
            long r13 = r13 * r9
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L63
            goto L64
        L63:
            r5 = 0
        L64:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "notify flag = "
            r11.append(r12)
            r11.append(r5)
            java.lang.String r11 = r11.toString()
            p514o9.C11839m.m70688i(r8, r11)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p766x8.C13729h.checkNotifyCondition(android.content.Context, long):boolean");
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean checkUserTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        List<PortraitAndGrade.UserTag> userTagsUseCache = UserSpaceUtil.getUserTagsUseCache("checkUserTag");
        if (userTagsUseCache.isEmpty()) {
            return false;
        }
        for (String str : list) {
            Iterator<PortraitAndGrade.UserTag> it = userTagsUseCache.iterator();
            while (it.hasNext()) {
                if (it.next().getUserGroupExtID().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void clearRecommendCardsNotification(int i10) {
        C11839m.m70688i("CloudSpaceProxyImp", "clearRecommendCardsNotification, notifyId: " + i10);
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CloudSpaceProxyImp", "context is null");
        } else {
            new HiCloudNotificationManager(contextM1377a).cancelNotification(i10);
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean diamondCanNotify(long j10) {
        GetAvailableGradePackagesResp getAvailableGradePackagesRespM67861b = C11303z.m67859c().m67861b();
        if (getAvailableGradePackagesRespM67861b == null) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "diamondCanNotify availableGradePackagesResp is null");
            return false;
        }
        List<CloudPackage> spacePackages = getAvailableGradePackagesRespM67861b.getSpacePackages();
        if (spacePackages == null) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "diamondCanNotify spacePackages is null");
            return false;
        }
        for (int i10 = 0; i10 < spacePackages.size(); i10++) {
            if (spacePackages.get(i10).getProductType() == 12) {
                NotifyLogger.m29915i("CloudSpaceProxyImp", "diamondCanNotify Expire notify");
                return true;
            }
        }
        if (spacePackages.size() <= 0 || j10 - System.currentTimeMillis() <= 0) {
            return false;
        }
        NotifyLogger.m29915i("CloudSpaceProxyImp", "diamondCanNotify space notify");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x00c3  */
    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity doSpaceNoticeWithActivity(java.util.Map<java.lang.String, java.util.List<com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity>> r28, com.huawei.hicloud.notification.p106db.bean.SNTimes r29, com.huawei.hicloud.notification.p106db.operator.SNTimeOperator r30, long r31, java.util.List<com.huawei.hicloud.notification.bean.PortraitAndGrade.UserTag> r33, long r34, java.util.List<com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity> r36) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p766x8.C13729h.doSpaceNoticeWithActivity(java.util.Map, com.huawei.hicloud.notification.db.bean.SNTimes, com.huawei.hicloud.notification.db.operator.SNTimeOperator, long, java.util.List, long, java.util.List):com.huawei.hicloud.notification.db.bean.NotificationWithActivity");
    }

    /* renamed from: e */
    public final boolean m82498e(String str, RecommendCard recommendCard) {
        String activityId = recommendCard.getActivityId();
        String galleryReleaseActivityType = recommendCard.getGalleryReleaseActivityType();
        C11839m.m70686d("CloudSpaceProxyImp", "canNotifyByTime activityId: " + activityId + ", galleryReleaseActivityType: " + galleryReleaseActivityType);
        long lastNotifyTimeFromSp = RecommendCardManager.getInstance().getLastNotifyTimeFromSp(str, activityId, (recommendCard.getActivityType().equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) && (str.equals(RecommendCardConstants.Entrance.HOMEPAGE) || str.equals(RecommendCardConstants.Entrance.BUY))) ? recommendCard.getGalleryReleaseActivityType() : recommendCard.getActivityType());
        if (lastNotifyTimeFromSp == 0) {
            return true;
        }
        String activityType = recommendCard.getActivityType();
        if (!TextUtils.isEmpty(activityId) && !TextUtils.isEmpty(activityType) && (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN.equals(galleryReleaseActivityType) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE.equals(galleryReleaseActivityType) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY.equals(galleryReleaseActivityType) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY.equals(galleryReleaseActivityType) || activityType.equals(RecommendCardConstants.ActivityType.TWO_HUNDRED_GUID) || activityType.equals(RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE) || activityType.equals(RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL))) {
            if (System.currentTimeMillis() - lastNotifyTimeFromSp >= recommendCard.getCardRefresh() * 86400000) {
                return true;
            }
        }
        C11839m.m70689w("CloudSpaceProxyImp", "has notified, activityId: " + activityId + ", activityType: " + recommendCard.getActivityType());
        return false;
    }

    /* renamed from: f */
    public final boolean m82499f() throws Exception {
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        UserPackage userPackageM61644M = C9948a.m61631C().m61644M(c11060c, "recommendSpaceFull");
        if (userPackageM61644M == null) {
            C11839m.m70687e("CloudSpaceProxyImp", "userPackage is null");
            return false;
        }
        MemGradeRights gradeRights = userPackageM61644M.getGradeRights();
        if (gradeRights != null) {
            return m82500g(userPackageM61644M, gradeRights);
        }
        C11839m.m70687e("CloudSpaceProxyImp", "gradeRights is null");
        return false;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String formatSpaceForMain(Context context, long j10) {
        return C0223k.m1524g(context, j10);
    }

    /* renamed from: g */
    public final boolean m82500g(UserPackage userPackage, MemGradeRights memGradeRights) {
        int gradeType = memGradeRights.getGradeType();
        int isAutoPay = userPackage.getIsAutoPay();
        C11839m.m70688i("CloudSpaceProxyImp", "gradeType: " + gradeType + ", autoPay: " + isAutoPay);
        if (gradeType != 9 || isAutoPay != 1) {
            C11839m.m70688i("CloudSpaceProxyImp", "have package");
            return true;
        }
        if (C11303z.m67859c().m67860a(C11303z.m67859c().m67861b())) {
            C11839m.m70688i("CloudSpaceProxyImp", "have worry free");
            return true;
        }
        C11839m.m70689w("CloudSpaceProxyImp", "no package and no worry free");
        return false;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getAvailableSize() {
        if (!C0209d.m1309t1(C0213f.m1377a())) {
            if (!C0209d.m1214U0(C0213f.m1377a())) {
                return 0L;
            }
            C13464d c13464dM81030f = C13464d.m81030f(C0213f.m1377a());
            return c13464dM81030f.m81037h("totalSize") - c13464dM81030f.m81037h("usedSize");
        }
        try {
            QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
            if (quotaSpaceInfoM80224M != null) {
                return quotaSpaceInfoM80224M.getTotal() - quotaSpaceInfoM80224M.getUsed();
            }
            CloudSpace cloudSpace = getCloudSpace();
            return cloudSpace.getTotal() - cloudSpace.getUsed();
        } catch (C9721b e10) {
            NotifyLogger.m29914e("CloudSpaceProxyImp", "getCloudSpaceError," + e10.getMessage());
            return 0L;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public int getBackupCycle() {
        return new SettingOperator().queryFinalBackupCycle();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public CloudSpace getCloudSpace() throws C9721b {
        return new C13049a(EnumC12999a.CLOUD_MORE, null).m78753q();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String getCurrentGradeCode(String str) {
        return UserSpaceUtil.getGradeCodeUseCache(str);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public ActivityEntryEx getIncentiveCardActivityEntryEx(String str, LinkedHashMap<String, String> linkedHashMap, int i10) {
        return m82504k(str, true, linkedHashMap, i10);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getLastBackupSuccessTime() {
        long jQuerylastsuccesstime = new SettingOperator().querylastsuccesstime();
        if (jQuerylastsuccesstime != 0) {
            return jQuerylastsuccesstime;
        }
        long jM82501h = m82501h();
        C11839m.m70688i("CloudSpaceProxyImp", "lastSuccessTime is 0,get backupStartTime:" + jM82501h);
        return jM82501h;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getLatestBackupCycleDay() {
        int backupCycle = getBackupCycle();
        long lastBackupSuccessTime = getLastBackupSuccessTime();
        C11839m.m70688i("CloudSpaceProxyImp", "isNoticeBeforeBackupTimeSatisfied,backupFrequency:" + backupCycle + ",lastBackupSuccessTime:" + lastBackupSuccessTime);
        if (backupCycle > 0) {
            long jLongValue = 0;
            if (lastBackupSuccessTime > 0) {
                long j10 = backupCycle * 86400000;
                long j11 = (1 * j10) + lastBackupSuccessTime;
                long jM66717t = C11074k.m66717t();
                int i10 = 1;
                while (jM66717t > j11) {
                    i10++;
                    j11 = (i10 * j10) + lastBackupSuccessTime;
                }
                List listM81076c = C13466f.m81073d().m81076c(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE);
                long j12 = j11 - j10;
                if (!AbstractC14026a.m84159a(listM81076c)) {
                    C11839m.m70688i("CloudSpaceProxyImp", "saved notifyTime is not empty");
                    jLongValue = ((Double) listM81076c.get(listM81076c.size() - 1)).longValue();
                }
                long nextBackupTime = getNextBackupTime();
                if (!C11074k.m66723z(j12, jM66717t) || !C11074k.m66723z(nextBackupTime, jM66717t) || C11074k.m66723z(jLongValue, jM66717t)) {
                    return j11;
                }
                C11839m.m70688i("CloudSpaceProxyImp", "today is backupCycleDay and not pop up notification");
                return j12;
            }
        }
        return System.currentTimeMillis();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getLocalClearSpace(CountDownLatch countDownLatch) throws InterruptedException {
        try {
            C9430g.m59138a().m59141d(C0213f.m1377a());
            C0213f.m1377a().getContentResolver().call(Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI), NotifyConstants.CloudAlbumReleaseSpace.METHOD_SYNC_CLOUD_DATA, (String) null, (Bundle) null);
            C11839m.m70688i("CloudSpaceProxyImp", "isSatisfiedGalleryReleaseSpaceSync waitResult:" + countDownLatch.await(10000L, TimeUnit.MILLISECONDS));
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceProxyImp", "isSatisfiedGalleryReleaseSpaceSync failed:" + e10.toString());
        }
        return C9430g.m59138a().m59139b();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getLocalPhotoSpace(CountDownLatch countDownLatch) throws InterruptedException {
        try {
            MediaDataCollector mediaDataCollector = new MediaDataCollector(countDownLatch);
            mediaDataCollector.execute();
            C11839m.m70688i("CloudSpaceProxyImp", "isSatisfiedGalleryReleaseSpaceUnSync waitResult:" + countDownLatch.await(10000L, TimeUnit.MILLISECONDS));
            return mediaDataCollector.getSize();
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceProxyImp", "isSatisfiedGalleryReleaseSpaceUnSync failed:" + e10.toString());
            return 0L;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public Intent getMemberSpaceNotifyIntent() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e("CloudSpaceProxyImp", "getMemberSpaceNotifyIntent spaceNotification is null.");
            return null;
        }
        Intent intent = new Intent();
        intent.setClass(contextM1377a, CloudSpaceMemberShareActivity.class);
        return intent;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public CloudSpaceInfo getModuleSizePercent() {
        C11839m.m70688i("CloudSpaceProxyImp", "getModuleSizePercent ");
        CloudSpaceInfo cloudSpaceInfoM82503j = m82503j();
        CloudSpaceInfo.AddInfo addInfoM80225O = C13368e.m80184F().m80225O();
        if (addInfoM80225O != null) {
            cloudSpaceInfoM82503j.setAddInfo(addInfoM80225O);
        } else {
            C11839m.m70688i("CloudSpaceProxyImp", "getModuleSizePercent AddInfo is null");
        }
        return cloudSpaceInfoM82503j;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public CloudSpaceInfo getModuleSizePercentByServer() {
        new C13549a0(new a()).call();
        return getModuleSizePercent();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String getNPSStringFromDb(String str) {
        return C13933c.m83668n().m83685r(str);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getNeedBackupSize() {
        return C12590s0.m75794S();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getNextBackupTime() {
        return C12590s0.m75872l0();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String getParam(String str, String str2, String str3) {
        return C1009d.m6109e().m6114f(str, str2, str3);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String getParamRealTime(String str, String str2, String str3) {
        List<C4987f> listM84950j = C14157f.m84942g().m84950j(null, Collections.singletonList(str), str2, str3);
        if (AbstractC14026a.m84159a(listM84950j)) {
            C11839m.m70689w("CloudSpaceProxyImp", "getParam, values is empty");
            return "";
        }
        C4987f c4987f = listM84950j.get(0);
        if (c4987f == null) {
            C11839m.m70689w("CloudSpaceProxyImp", "getParam, paramsValue is empty");
            return "";
        }
        if (!TextUtils.equals(str, c4987f.m30026b())) {
            C11839m.m70689w("CloudSpaceProxyImp", "getParam, key not equals");
            return "";
        }
        String strM30027c = c4987f.m30027c();
        C11839m.m70686d("CloudSpaceProxyImp", "getParam, key: " + str + ", value: " + strM30027c);
        return strM30027c;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public Map<String, String> getParamsFromServer(List<String> list) {
        new C4984c().m30021h(list);
        return (Map) C14157f.m84942g().m84949i(new ArrayList(), list, "GetParam").stream().collect(Collectors.toMap(new Function() { // from class: x8.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((C4987f) obj).m30026b();
            }
        }, new Function() { // from class: x8.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((C4987f) obj).m30027c();
            }
        }));
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public Map<String, Integer> getSpaceLanguageMap() {
        return CommonBase.m16240b();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long getUsedSize() {
        if (!C0209d.m1309t1(C0213f.m1377a())) {
            if (C0209d.m1214U0(C0213f.m1377a())) {
                return C13464d.m81030f(C0213f.m1377a()).m81037h("usedSize");
            }
            return 0L;
        }
        try {
            QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
            return quotaSpaceInfoM80224M != null ? quotaSpaceInfoM80224M.getUsed() : getCloudSpace().getUsed();
        } catch (C9721b e10) {
            NotifyLogger.m29914e("CloudSpaceProxyImp", "getCloudSpaceError," + e10.getMessage());
            return 0L;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public List<PortraitAndGrade.UserTag> getUserTagList(String str) {
        return UserSpaceUtil.getUserTagsUseCache(str);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public VoucherNotiDisplayInfo getVoucherInfo(SpaceNotification spaceNotification, Long l10) {
        if (!C11296s.m67787K() || !C11296s.m67789M(C0213f.m1377a())) {
            NotifyLogger.m29914e("CloudSpaceProxyImp", "getVoucherInfo, not support voucher");
            return null;
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06008"), "getPackagesBySpaceRule", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        try {
            return UserSpaceUtil.getVoucherNotiDisplayInfo(C9948a.m61631C().m61638G(c11060cM66626a, NotifyConstants.SPACE_AVAILABLE_DAYS_V3.equals(spaceNotification.getNoticeType()) ? 1 : 0, l10.longValue(), 1, null, false));
        } catch (C9721b e10) {
            NotifyLogger.m29914e("CloudSpaceProxyImp", "getVoucherInfo exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: h */
    public final long m82501h() {
        C13029h c13029hM82505l = m82505l();
        if (c13029hM82505l == null) {
            return 0L;
        }
        return c13029hM82505l.m78466i();
    }

    /* renamed from: i */
    public final int m82502i(String str, ArrayList<RecommendCard> arrayList) {
        int notifyBarDay = HiCloudSpacePositionMgrManager.getInstance().getNotifyBarDay(str);
        int notifyBarTimes = HiCloudSpacePositionMgrManager.getInstance().getNotifyBarTimes(str);
        String str2 = "CloudSpaceProxyImp";
        C11839m.m70688i("CloudSpaceProxyImp", "entrance: " + str + ", notifyBarDay: " + notifyBarDay + ", notifyBarTimes: " + notifyBarTimes);
        if (notifyBarDay == -1 || notifyBarTimes == -1) {
            C11839m.m70687e("CloudSpaceProxyImp", "config not exits");
            return -1;
        }
        if (notifyBarDay == 0 || notifyBarTimes == 0) {
            return 100;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i10 = 0;
        int i11 = 0;
        while (i10 < arrayList.size()) {
            RecommendCard recommendCard = arrayList.get(i10);
            if (recommendCard == null) {
                C11839m.m70687e(str2, "card is null");
            } else {
                long lastNotifyTimeFromNotificationSp = RecommendCardManager.getInstance().getLastNotifyTimeFromNotificationSp(str, recommendCard.getActivityId(), (recommendCard.getActivityType().equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) && str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) ? recommendCard.getGalleryReleaseActivityType() : recommendCard.getActivityType());
                String str3 = str2;
                if (jCurrentTimeMillis - lastNotifyTimeFromNotificationSp <= notifyBarDay * 86400000) {
                    arrayList.remove(i10);
                    i10--;
                    i11++;
                    str2 = str3;
                    NotifyLogger.m29915i(str2, "hasNotified, lastNotifyTime: " + lastNotifyTimeFromNotificationSp + ", activityId: " + recommendCard.getActivityId() + ", activityType: " + recommendCard.getActivityType());
                } else {
                    str2 = str3;
                }
            }
            i10++;
        }
        NotifyLogger.m29915i(str2, "hasNotifiedCnt: " + i11);
        if (i11 < notifyBarTimes) {
            return notifyBarTimes - i11;
        }
        NotifyLogger.m29915i(str2, "can't notify");
        return -1;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isBackupEndCodeSatisfy(int i10) {
        return C14337f.m85499b().keySet().contains(Integer.valueOf(i10));
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isBackupFailNoticeFrequencySatisfy() {
        Double d10;
        List listM81076c = C13466f.m81073d().m81076c(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE);
        if (listM81076c == null || listM81076c.isEmpty() || (d10 = (Double) listM81076c.get(listM81076c.size() - 1)) == null) {
            return false;
        }
        long jLongValue = d10.longValue();
        C13029h c13029hM75886o2 = C12590s0.m75886o2();
        if (c13029hM75886o2 == null) {
            C11839m.m70688i("CloudSpaceProxyImp", "isBackupFailNoticeFrequencySatisfy backupTags is empty");
            return false;
        }
        ICycleChecker iCycleChecker = ICycleChecker.get(new Predicate() { // from class: x8.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C13729h.m82494p((ICycleChecker) obj);
            }
        });
        long jM78469k = c13029hM75886o2.m78469k();
        boolean zIsSameCycle = iCycleChecker.isSameCycle(jLongValue, jM78469k);
        C11839m.m70686d("CloudSpaceProxyImp", "isBackupFailNoticeFrequencySatisfy beforeTime: " + jLongValue + " ,afterTime: " + jM78469k + " ,isSameCycle: " + zIsSameCycle);
        return zIsSameCycle;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isBackupTaskExecuteToday() {
        C13029h c13029hM82505l = m82505l();
        if (c13029hM82505l == null) {
            return false;
        }
        return isSpecifiedTimeInBackupCycleDay(c13029hM82505l.m78464f());
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isBackupTaskFailedAndWillRetryToday() {
        long jM75872l0 = C12590s0.m75872l0();
        C11839m.m70688i("CloudSpaceProxyImp", "isBackupTaskFailedAndWillRetryToday enter,nextBackupTime is:" + jM75872l0);
        return isLatestBackupTaskFailedToday() && isSpecifiedTimeInBackupCycleDay(jM75872l0);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isDsStartMainFrequencySatisfied() {
        DsStartMainProcessPolicy dsStartMainProcessPolicy;
        C12526j c12526j = new C12526j();
        if (c12526j.m75385d1("dsStartMainProcessPolicy")) {
            dsStartMainProcessPolicy = (DsStartMainProcessPolicy) c12526j.m75346L(DsStartMainProcessPolicy.class, "dsStartMainProcessPolicy");
            if (dsStartMainProcessPolicy == null) {
                C11839m.m70689w("CloudSpaceProxyImp", "dsStartMainProcessPolicy is null");
                dsStartMainProcessPolicy = new DsStartMainProcessPolicy();
            }
        } else {
            C11839m.m70689w("CloudSpaceProxyImp", "dsStartMainProcessPolicy config not exist");
            dsStartMainProcessPolicy = new DsStartMainProcessPolicy();
        }
        List<ActionTimeRecord> listM66714q = C11074k.m66714q(1);
        final long jCurrentTimeMillis = System.currentTimeMillis() - (dsStartMainProcessPolicy.getPeriodInterval() * C5863b6.g.f26453g);
        final long jCurrentTimeMillis2 = System.currentTimeMillis();
        long jCount = listM66714q.stream().filter(new Predicate() { // from class: x8.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C13729h.m82495q(jCurrentTimeMillis, jCurrentTimeMillis2, (ActionTimeRecord) obj);
            }
        }).count();
        boolean z10 = jCount < ((long) dsStartMainProcessPolicy.getTimes());
        C11839m.m70688i("CloudSpaceProxyImp", "isDsStartMainFrequencySatisfied:" + z10 + ",actionTimeRecords:" + listM66714q + ",count:" + jCount + ",dsStartMainProcessPolicy:" + dsStartMainProcessPolicy);
        return z10;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isFamilyShareMember() {
        try {
            return C11829c.m70629x0(true);
        } catch (C1412i e10) {
            NotifyLogger.m29914e("CloudSpaceProxyImp", e10.toString());
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isGallerySupportSetting() {
        return C1006a.m5936k().m5974u();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isGeneralAlbumOnBySp() {
        return C1006a.m5936k().m5975v(C0213f.m1377a());
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isInBackupOrRestoreTask() {
        return CBAccess.inBackup() || CBAccess.inRestoreWithRetryClearCheck(false);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isLatestBackupTaskFailedToday() {
        C13029h c13029hM82505l = m82505l();
        if (c13029hM82505l != null) {
            return c13029hM82505l.m78474q() != "0" && isSpecifiedTimeInBackupCycleDay(c13029hM82505l.m78464f());
        }
        C11839m.m70688i("CloudSpaceProxyImp", "latest backupTags is null");
        return false;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isNewBmUserBackupNoData() {
        if (C13452e.m80781L().m80887a1()) {
            Context contextM1377a = C0213f.m1377a();
            boolean zM1309t1 = C0209d.m1309t1(contextM1377a);
            boolean zM62303a1 = C10028c.m62182c0().m62303a1();
            if (!zM1309t1) {
                zM62303a1 = C13464d.m81030f(contextM1377a).m81033c("base_backup_new_key");
            }
            C11839m.m70688i("CloudSpaceProxyImp", "isNewBmUserBackupNoData:baseBackupOn:" + zM62303a1);
            if (!zM62303a1) {
                C11839m.m70688i("CloudSpaceProxyImp", "baseBackup switch is close.");
                return C12590s0.m75893q1();
            }
        }
        return false;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isNoMoreRemindSwitchChecked() {
        return C13466f.m81073d().m81075b("noMoreRemindBeforeBackup", false);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isNoticeFrequencySatisfyDayOnceConfig(String str, float f10) {
        List listM81076c = C13466f.m81073d().m81076c(str);
        final long jM66717t = C11074k.m66717t() - ((long) (8.64E7f * f10));
        final long jM66717t2 = C11074k.m66717t();
        long jCount = ((List) listM81076c.stream().filter(new Predicate() { // from class: x8.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C13729h.m82496r(jM66717t, jM66717t2, (Double) obj);
            }
        }).collect(Collectors.toList())).stream().count();
        C11839m.m70688i("CloudSpaceProxyImp", "isNoticeFrequencySatisfyDayOnceConfig,already notify " + jCount + " times in " + f10 + " days");
        return jCount < 1;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isParamSatisfy(List<String> list, List<String> list2, String str) {
        return C1009d.m6109e().m6119k(list, list2, str, 1, new LinkedHashMap<>());
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0051  */
    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hicloud.base.bean.CloudSpace isSatisfiedCloudSpaceFull(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            java.lang.String r2 = "CloudSpaceProxyImp"
            if (r0 != 0) goto L67
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L10
            goto L67
        L10:
            java.lang.String r0 = "application"
            boolean r0 = r0.equals(r7)
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L37
            java.lang.String r7 = "buy_more"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L26
        L22:
            r5 = r4
            r4 = r3
            r3 = r5
            goto L52
        L26:
            java.lang.String r7 = "manage"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L52
            java.lang.String r7 = "cloud_storage"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L51
            goto L52
        L37:
            java.lang.String r0 = "deeplink"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L51
            java.lang.String r7 = "PackageInfoActivity"
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L48
            goto L22
        L48:
            java.lang.String r7 = "HisyncSpaceDetailActivity"
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L51
            goto L52
        L51:
            r4 = r3
        L52:
            boolean r7 = com.huawei.android.hicloud.complexutil.C2783d.m16139f0()
            if (r7 != 0) goto L62
            if (r3 != 0) goto L5c
            if (r4 == 0) goto L62
        L5c:
            java.lang.String r6 = "not support storage region"
            p514o9.C11839m.m70687e(r2, r6)
            return r1
        L62:
            com.huawei.hicloud.base.bean.CloudSpace r6 = r6.m82507n(r3)
            return r6
        L67:
            java.lang.String r6 = "notifyType or notifyUri is empty"
            p514o9.C11839m.m70687e(r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p766x8.C13729h.isSatisfiedCloudSpaceFull(java.lang.String, java.lang.String):com.huawei.hicloud.base.bean.CloudSpace");
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isSatisfiedTwoHundredGuid(boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p;
        int twoHundredGuidResultFromSp;
        if (!C11829c.m70626w0()) {
            C11839m.m70689w("CloudSpaceProxyImp", "FamilyShareFunc not enable");
            return false;
        }
        if (z10 && (hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p()) != null) {
            int homePageCardRefreshTime = hiCloudSysParamMapM60757p.getHomePageCardRefreshTime();
            C11839m.m70688i("CloudSpaceProxyImp", "TwoHundredGuid homePageCardRefreshTime: " + homePageCardRefreshTime);
            if (homePageCardRefreshTime > 0) {
                if (System.currentTimeMillis() - RecommendCardManager.getInstance().getLastTwoHundredGuidTimeFromSp() < homePageCardRefreshTime * 86400000 && (twoHundredGuidResultFromSp = RecommendCardManager.getInstance().getTwoHundredGuidResultFromSp()) != 0) {
                    return twoHundredGuidResultFromSp == 1;
                }
            }
        }
        try {
            return m82508o((FamilyShareInfoResult) C12540b1.m75483a(new C13049a(EnumC12999a.CLOUD_MORE, null).m78730c0(), FamilyShareInfoResult.class), z10, linkedHashMap);
        } catch (Exception e10) {
            String str = "checkFamilyShareRule exception: " + e10.toString();
            C11839m.m70687e("CloudSpaceProxyImp", str);
            linkedHashMap.put("recommend_card_info", str);
            RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isSpecifiedTimeInBackupCycleDay(long j10) {
        int backupCycle = getBackupCycle();
        long lastBackupSuccessTime = getLastBackupSuccessTime();
        NotifyLogger.m29915i("CloudSpaceProxyImp", "isSpecifiedTimeInBackupCycleDay,backupFrequency:" + backupCycle + ",lastBackupSuccessTime:" + lastBackupSuccessTime + ",specifiedTime:" + j10);
        if (lastBackupSuccessTime == 0) {
            C11839m.m70688i("CloudSpaceProxyImp", "isSpecifiedTimeInBackupCycleDay,lastBackupSuccessTime is 0L,return true");
            return true;
        }
        if (backupCycle <= 0 || j10 <= 0) {
            C11839m.m70687e("CloudSpaceProxyImp", "isSpecifiedTimeInBackupCycleDay,backupFrequency:" + backupCycle + ",lastBackupSuccessTime:,specifiedTime:" + j10);
            return false;
        }
        long j11 = backupCycle * 86400000;
        long j12 = j10 - lastBackupSuccessTime;
        long j13 = j12 % j11;
        long j14 = j12 / j11;
        boolean z10 = j14 >= 1 && j13 <= 86400000;
        C11839m.m70688i("CloudSpaceProxyImp", "isSpecifiedTimeInBackupCycleDay:" + z10 + ",N:" + j14 + ",remainTime:" + j13);
        return z10;
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean isThirdAndSystemAppSwitchOpen() {
        return new C13026e().m78394o();
    }

    /* renamed from: j */
    public final CloudSpaceInfo m82503j() {
        CloudSpaceInfo cloudSpaceInfo = new CloudSpaceInfo();
        if (C13452e.m80781L().m80791C0()) {
            cloudSpaceInfo.setStatus(1);
        } else if (C13452e.m80781L().m80858T0()) {
            cloudSpaceInfo.setStatus(2);
        } else if (C13452e.m80781L().m80887a1()) {
            cloudSpaceInfo.setStatus(-1);
        } else {
            cloudSpaceInfo.setStatus(3);
        }
        return cloudSpaceInfo;
    }

    /* renamed from: k */
    public final ActivityEntryEx m82504k(String str, boolean z10, LinkedHashMap<String, String> linkedHashMap, int i10) {
        int i11;
        int i12;
        String str2 = "";
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07017"), "getActivityEntry", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            i11 = 1;
            i12 = 1007;
        } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
            i11 = 2;
            i12 = 1002;
        } else if (str.equals(RecommendCardConstants.Entrance.DESKTOP_DIALOG)) {
            if (i10 <= 0) {
                i10 = 412;
            }
            int i13 = i10;
            i12 = 1008;
            i11 = i13;
        } else {
            i11 = 0;
            i12 = 0;
        }
        try {
            GetActivityEntryResp getActivityEntryRespM61689q = C9948a.m61631C().m61689q(new UserTags(), i11, c11060cM66626a);
            if (getActivityEntryRespM61689q.getResultCode() == 0) {
                ActivityEntry entry = getActivityEntryRespM61689q.getEntry();
                if (entry == null) {
                    C11839m.m70687e("CloudSpaceProxyImp", "get activity entry SUCCESS, but campaignInfoList is null");
                    linkedHashMap.put("recommend_card_info", "get activity entry SUCCESS, but campaignInfoList is null");
                    RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
                    return null;
                }
                if (!"dlApp".equals(entry.getcType())) {
                    C11839m.m70687e("CloudSpaceProxyImp", "get activity entry SUCCESS , but cType is not dlApp , so no campaignInfo ");
                    linkedHashMap.put("recommend_card_info", "get activity entry SUCCESS , but cType is not dlApp , so no campaignInfo ");
                    RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
                    return null;
                }
                String resource = entry.getResource();
                String url = entry.getUrl();
                String str3 = "get activity entry SUCCESS , resourceId " + resource + " url " + url;
                linkedHashMap.put("recommend_card_info", str3);
                RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
                C11839m.m70686d("CloudSpaceProxyImp", str3);
                DlAppCampInfo campaignInfo = entry.getCampaignInfo();
                if (campaignInfo == null) {
                    C11839m.m70687e("CloudSpaceProxyImp", "get activity entry SUCCESS, but campaignInfo is null");
                    linkedHashMap.put("recommend_card_info", "get activity entry SUCCESS, but campaignInfo is null");
                    RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
                    return null;
                }
                AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
                if (adParametersExt == null) {
                    C11839m.m70687e("CloudSpaceProxyImp", " parametersExt is null");
                    return null;
                }
                C10121i.m63036b(adParametersExt);
                String ppsAdid = adParametersExt.getPpsAdid();
                if (!TextUtils.isEmpty(resource) && !TextUtils.isEmpty(url) && !TextUtils.isEmpty(ppsAdid)) {
                    if (C11289l.m67731e(entry, "", i12, false)) {
                        ActivityEntryEx activityEntryEx = new ActivityEntryEx();
                        activityEntryEx.setResource(resource);
                        activityEntryEx.setUrl(url);
                        activityEntryEx.setcType(entry.getcType());
                        if (z10) {
                            RecommendCardManager.getInstance().setLastIncentiveTimeToSp();
                            RecommendCardManager.getInstance().setResourceIdToSp(resource);
                            RecommendCardManager.getInstance().setH5JumpUrlToSp(url);
                            RecommendCardManager.getInstance().setCTypeToSp(activityEntryEx.getcType());
                        }
                        linkedHashMap.put("recommend_card_info", "");
                        RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
                        return activityEntryEx;
                    }
                }
                C11839m.m70687e("CloudSpaceProxyImp", "get activity entry SUCCESS, resourceId or url is null");
                linkedHashMap.put("recommend_card_info", "get activity entry SUCCESS, resourceId or url is null");
                RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
                return null;
            }
            str2 = "getActivityEntry error: " + getActivityEntryRespM61689q.getResultCode() + ", " + getActivityEntryRespM61689q.getResultDesc();
        } catch (C9721b e10) {
            str2 = "getIncentiveCardActivityEntryEx exception: " + e10.toString();
            C11839m.m70687e("CloudSpaceProxyImp", str2);
        }
        linkedHashMap.put("recommend_card_info", str2);
        RecommendCardManager.getInstance().reportRecommendCardShowInfo(linkedHashMap);
        return null;
    }

    /* renamed from: l */
    public final C13029h m82505l() {
        C13030i c13030i = new C13030i();
        try {
            C13029h c13029hM78495f = c13030i.m78495f(2);
            long jM78464f = c13029hM78495f == null ? 0L : c13029hM78495f.m78464f();
            C13029h c13029hM78495f2 = c13030i.m78495f(1);
            long jM78464f2 = c13029hM78495f2 == null ? 0L : c13029hM78495f2.m78464f();
            if (jM78464f == 0 && jM78464f2 == 0) {
                return null;
            }
            return jM78464f > jM78464f2 ? c13029hM78495f : c13029hM78495f2;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudSpaceProxyImp", "query backupTag error, " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: m */
    public final boolean m82506m(String str, String str2, String str3, String str4) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? false : true;
    }

    /* renamed from: n */
    public final CloudSpace m82507n(boolean z10) {
        CloudSpace cloudSpaceM80181d;
        try {
            cloudSpaceM80181d = C13367d.m80180e().m80181d();
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceProxyImp", "isSatisfiedCloudSpaceFull exception: " + e10.toString());
        }
        if (cloudSpaceM80181d == null) {
            C11839m.m70687e("CloudSpaceProxyImp", "get space fail, space is null");
            return null;
        }
        long used = cloudSpaceM80181d.getUsed();
        long total = cloudSpaceM80181d.getTotal();
        C11839m.m70688i("CloudSpaceProxyImp", "isSatisfiedCloudSpaceFull, used: " + used + ", total: " + total);
        if (used >= total) {
            if (!z10) {
                C11839m.m70688i("CloudSpaceProxyImp", "not buy");
                return cloudSpaceM80181d;
            }
            if (m82499f()) {
                return cloudSpaceM80181d;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0078  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m82508o(com.huawei.hicloud.base.bean.FamilyShareInfoResult r12, boolean r13, java.util.LinkedHashMap<java.lang.String, java.lang.String> r14) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p766x8.C13729h.m82508o(com.huawei.hicloud.base.bean.FamilyShareInfoResult, boolean, java.util.LinkedHashMap):boolean");
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public long queryDeviceDeleteListSize() {
        List<CBSDevice> listM61822k = C9964e.m61814f().m61822k(true);
        if (C0209d.m1205R0(listM61822k)) {
            C11839m.m70689w("CloudSpaceProxyImp", "cbsDeviceList is empty");
            return 0L;
        }
        long j10 = 0;
        for (CBSDevice cBSDevice : listM61822k) {
            if (cBSDevice == null) {
                C11839m.m70687e("CloudSpaceProxyImp", "cbsDevice is null");
            } else {
                long jM1688f = C0241z.m1688f(cBSDevice.getDeviceSpace());
                if (jM1688f != 0) {
                    j10 += jM1688f;
                }
            }
        }
        C11839m.m70688i("CloudSpaceProxyImp", "totalDeviceSpace: " + j10);
        return Math.max(j10, 0L);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public boolean queryDeviceDeleteSwitch() {
        return C9964e.m61814f().m61827p();
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void reportRecommendCardShowEvent(ArrayList<RecommendCard> arrayList, boolean z10) {
        C2783d.m16100O0(arrayList, z10);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void reportRecommendCardUnsatisfied(String str, String str2, String str3) {
        C2783d.m16104Q0(str, str2, str3);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void saveForcedUpgradeConfig(Context context, boolean z10, ForcedUpgradeUtil.QueryUpdate queryUpdate) {
        C9908c.m61499D().m61523I(context, null);
        C9908c.m61499D().m61533S(context, z10, queryUpdate);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void saveNotificationTime(String str, long j10) {
        List listM81076c = C13466f.m81073d().m81076c(str);
        final long jM66717t = C11074k.m66717t() - 2592000000L;
        final long jM66717t2 = C11074k.m66717t();
        List list = (List) listM81076c.stream().filter(new Predicate() { // from class: x8.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C13729h.m82497s(jM66717t, jM66717t2, (Double) obj);
            }
        }).map(new Function() { // from class: x8.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Long.valueOf(((Double) obj).longValue());
            }
        }).collect(Collectors.toList());
        list.add(Long.valueOf(j10));
        C13466f.m81073d().m81085m(str, list);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendBackupFailNotify(int i10) {
        new BackupNotificationManager(C0213f.m1377a()).sendAutoBackupFailNotify(i10);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendFamilyShareEnableNotify(long j10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && C0209d.m1173G1(contextM1377a)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareEnableNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        FamilyShareStaticPages familyShareStaticPagesM60490j = C9681b.m60470l().m60490j();
        if (familyShareStaticPagesM60490j == null) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareEnableNotify, istaticPages null");
            return;
        }
        String strM1524g = C0223k.m1524g(contextM1377a, j10);
        String strM64299i = C10465b.m64299i(familyShareStaticPagesM60490j.getMemberAcceptNoticeTitle());
        String strM64299i2 = C10465b.m64299i(familyShareStaticPagesM60490j.getMemberAcceptNoticeMainText());
        if (TextUtils.isEmpty(strM64299i) || TextUtils.isEmpty(strM64299i2)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareEnableNotify, titleReplace or contentReplace null");
            return;
        }
        String strM64293c = C10465b.m64293c(strM64299i2, strM1524g);
        if (TextUtils.isEmpty(strM64299i) || TextUtils.isEmpty(strM64293c)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, title or content null");
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) AccountOpenSpaceShareActivity.class);
        intent.putExtra(FaqConstants.FAQ_MODULE, "spaceShare");
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 5);
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_FAMILY_SHARE_ENABLED_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1668i(contextM1377a, strM64299i).m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i10)).m3811l(strM64299i).m3810k(strM64293c).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(contextM1377a);
        hiCloudNotificationManager.notificationGroupDone(false);
        hiCloudNotificationManager.notify(279, notificationM3804d);
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.SPACE_SHARE_ENABLE_NOTICE_SHOW);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendFamilyShareStopNotify() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && C0209d.m1173G1(contextM1377a)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        FamilyShareStaticPages familyShareStaticPagesM60490j = C9681b.m60470l().m60490j();
        if (familyShareStaticPagesM60490j == null) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, istaticPages null");
            return;
        }
        String strM64299i = C10465b.m64299i(familyShareStaticPagesM60490j.getStopNoticeMemberTitle());
        String strM64299i2 = C10465b.m64299i(familyShareStaticPagesM60490j.getStopNoticeMemberMainText());
        if (TextUtils.isEmpty(strM64299i) || TextUtils.isEmpty(strM64299i2)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, title or content null");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(contextM1377a, CloudSpaceShareActivity.class);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 6);
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_FAMILY_SHARE_STOPPED_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i10 = com.huawei.android.p073ds.R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1668i(contextM1377a, strM64299i).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i10)).m3811l(strM64299i).m3810k(strM64299i2).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(contextM1377a);
        hiCloudNotificationManager.notificationGroupDone(false);
        hiCloudNotificationManager.notify(280, notificationM3804d);
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.SPACE_SHARE_STOP_NOTICE_SHOW);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendHomePageRecommendCardsNotification(String str, ArrayList<RecommendCard> arrayList) {
        int i10;
        C13729h c13729h = this;
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CloudSpaceProxyImp", "context is null");
            return;
        }
        int iM82502i = m82502i(str, arrayList);
        NotifyLogger.m29915i("CloudSpaceProxyImp", "canNotifyCnt: " + iM82502i);
        if (iM82502i == -1) {
            return;
        }
        int i11 = 0;
        while (i11 < arrayList.size() && iM82502i > 0) {
            RecommendCard recommendCard = arrayList.get(i11);
            if (recommendCard == null) {
                C11839m.m70687e("CloudSpaceProxyImp", "card is null");
            } else if (!recommendCard.isNotifyBar()) {
                C11839m.m70687e("CloudSpaceProxyImp", "isNotifyBar false, activityId: " + recommendCard.getActivityId() + ", activityType: " + recommendCard.getActivityType());
            } else {
                if (!NoticeFreqControlManager.getInstance().canShowNotice()) {
                    NotifyLogger.m29916w("CloudSpaceProxyImp", "freq control check fail, notice type: " + recommendCard.getActivityType() + ", notice id: " + recommendCard.getActivityId());
                    NoticeFreqControlManager.getInstance().reportFreqControlled(recommendCard.getActivityType());
                    return;
                }
                String notifyBarTitle = recommendCard.getNotifyBarTitle();
                String notifyBarDescription = recommendCard.getNotifyBarDescription();
                NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
                if (notifyTypeAndUriGoto == null) {
                    C11839m.m70687e("CloudSpaceProxyImp", "go is null, activityId: " + recommendCard.getActivityId() + ", activityType: " + recommendCard.getActivityType());
                } else {
                    String notifyType = notifyTypeAndUriGoto.getNotifyType();
                    String notifyUri = notifyTypeAndUriGoto.getNotifyUri();
                    if (c13729h.m82506m(notifyBarTitle, notifyBarDescription, notifyType, notifyUri)) {
                        if (c13729h.m82498e(str, recommendCard)) {
                            Intent intentM70543S = C11829c.m70543S(notifyType, notifyUri, true, recommendCard);
                            if (intentM70543S == null) {
                                C11839m.m70687e("CloudSpaceProxyImp", "intent is null");
                                return;
                            }
                            int i12 = iM82502i - 1;
                            boolean z10 = str.equals(RecommendCardConstants.Entrance.HOMEPAGE) || str.equals(RecommendCardConstants.Entrance.BUY);
                            i10 = i11;
                            RecommendCardManager.getInstance().setLastNotifyTimeToSp(str, recommendCard.getActivityId(), (recommendCard.getActivityType().equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) && z10) ? recommendCard.getGalleryReleaseActivityType() : recommendCard.getActivityType(), System.currentTimeMillis());
                            RecommendCardManager.getInstance().setLastNotifyTimeToNotificationSp(str, recommendCard.getActivityId(), (recommendCard.getActivityType().equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) && z10) ? recommendCard.getGalleryReleaseActivityType() : recommendCard.getActivityType(), System.currentTimeMillis());
                            int currentNotifyId = RecommendCardManager.getInstance().getCurrentNotifyId((recommendCard.getActivityType().equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) && z10) ? recommendCard.getGalleryReleaseActivityType() : recommendCard.getActivityType());
                            C11839m.m70686d("CloudSpaceProxyImp", "sendHomePageRecommendCardsNotification: " + currentNotifyId);
                            RecommendCardManager.getInstance().recordNotifyId(currentNotifyId, recommendCard.getActivityId(), (recommendCard.getActivityType().equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) && z10) ? recommendCard.getGalleryReleaseActivityType() : recommendCard.getActivityType());
                            C11839m.m70688i("CloudSpaceProxyImp", "sendHomePageRecommendCardsNotification, entrance: " + str + ", activityId: " + recommendCard.getActivityId() + ", notifyUri: " + notifyUri + ", activityType: " + recommendCard.getActivityType());
                            NoticeFreqControlManager.getInstance().recordNoticeShow();
                            RecommendCardReport recommendCardReport = new RecommendCardReport();
                            recommendCardReport.setActivityId(recommendCard.getActivityId());
                            recommendCardReport.setActivityType(recommendCard.getActivityType());
                            recommendCardReport.setEntrance(str);
                            m82510u(contextM1377a, notifyBarTitle, notifyBarDescription, notifyType, notifyUri, intentM70543S, currentNotifyId, recommendCardReport, recommendCard);
                            iM82502i = i12;
                        }
                        i11 = i10 + 1;
                        c13729h = this;
                    } else {
                        C11839m.m70687e("CloudSpaceProxyImp", "data not complete, activityId: " + recommendCard.getActivityId() + ", activityType: " + recommendCard.getActivityType() + ", title: " + notifyBarTitle + ", description: " + notifyBarDescription + ", notifyType: " + notifyType + ", notifyUri: " + notifyUri);
                    }
                }
            }
            i10 = i11;
            i11 = i10 + 1;
            c13729h = this;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendQuitOwnerFamilyShareNotify() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && C0209d.m1173G1(contextM1377a)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        FamilyShareStaticPages familyShareStaticPagesM60490j = C9681b.m60470l().m60490j();
        if (familyShareStaticPagesM60490j == null) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, istaticPages null");
            return;
        }
        String strM64299i = C10465b.m64299i(familyShareStaticPagesM60490j.getQuitOwnerFamilyShareTitle());
        String strM64299i2 = C10465b.m64299i(familyShareStaticPagesM60490j.getQuitOwnerFamilyShareDesc());
        if (TextUtils.isEmpty(strM64299i) || TextUtils.isEmpty(strM64299i2)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendFamilyShareStopNotify, title or content null");
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) CloudSpaceUpgradeActivity.class);
        intent.putExtra("from_where", 5);
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_QUIT_FAMLIY_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i10 = com.huawei.android.p073ds.R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1668i(contextM1377a, strM64299i).m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i10)).m3811l(strM64299i).m3810k(strM64299i2).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(contextM1377a);
        hiCloudNotificationManager.notificationGroupDone(false);
        hiCloudNotificationManager.notify(309, notificationM3804d);
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.QUIT_OWNER_FAMILY_SHARE_SHOW);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendSiteChangedNotification() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            if (C0209d.m1173G1(contextM1377a)) {
                NotifyLogger.m29915i("CloudSpaceProxyImp", "sendSiteChangedNotification, isPrivacyUser, now exit Cloud!");
                return;
            }
            Intent intent = new Intent(contextM1377a, (Class<?>) SiteChangeTipActivity.class);
            intent.putExtra(NotifyConstants.NOTIFY_ID_KEY, 289);
            C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_SITE_CHANGE_NOTIFY");
            PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
            intent2.setClass(contextM1377a, CommonNotifyReceiver.class);
            intent2.putExtra("requestId", 10003);
            PendingIntent broadcast = PendingIntent.getBroadcast(contextM1377a, 0, intent2, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            String string = contextM1377a.getString(com.huawei.android.p073ds.R$string.hicloud_service_location_change_2);
            Bundle bundle = new Bundle();
            Resources resources = contextM1377a.getResources();
            int i10 = R$string.HiCloud_app_name;
            bundle.putString("android.substName", resources.getString(i10));
            String string2 = contextM1377a.getString(com.huawei.android.p073ds.R$string.hicloud_service_location_change_1);
            Notification notificationM3804d = C0238w.m1663f().m1668i(contextM1377a, string2).m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i10)).m3811l(string2).m3810k(string).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3801a(0, contextM1377a.getString(com.huawei.android.p073ds.R$string.hicloud_service_location_change_3), broadcast).m3801a(0, contextM1377a.getString(com.huawei.android.p073ds.R$string.hicloud_service_location_change_4), pendingIntentM1248e0).m3804d();
            HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(contextM1377a);
            hiCloudNotificationManager.notificationGroupDone(false);
            hiCloudNotificationManager.notify(289, notificationM3804d);
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void sendSiteOfflineNotification() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && C0209d.m1173G1(contextM1377a)) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendSiteOfflineNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        if (contextM1377a == null) {
            NotifyLogger.m29915i("CloudSpaceProxyImp", "sendSiteOfflineNotification, mContext is null");
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) SiteOfflineTipActivity.class);
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_SITE_OFFLINE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        String string = contextM1377a.getString(com.huawei.android.p073ds.R$string.hicloud_service_location_change_10);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", contextM1377a.getResources().getString(com.huawei.android.p073ds.R$string.HiCloud_app_name));
        String string2 = contextM1377a.getString(com.huawei.android.p073ds.R$string.hicloud_service_location_change_9);
        Notification notificationM3804d = C0238w.m1663f().m1668i(contextM1377a, string2).m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(R$string.HiCloud_app_name)).m3811l(string2).m3810k(string).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(contextM1377a);
        hiCloudNotificationManager.notificationGroupDone(false);
        hiCloudNotificationManager.notify(290, notificationM3804d);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public void setLastBackupNotifyTime(Context context) {
        C12515a.m75110o().m75172d(new BackupNotifyCancelTimer(context));
        new SettingOperator().replace(new Settings[]{new Settings("lastnotifytime", String.valueOf(System.currentTimeMillis()), "2")});
    }

    /* renamed from: t */
    public final void m82509t(Context context, boolean z10, NotificationManager notificationManager) {
        if (notificationManager.getActiveNotifications().length < 1) {
            return;
        }
        NotificationCompat.Builder builderM1647f = z10 ? C0235t.m1645e().m1647f(context, "com.huawei.android.hicloud", "2", context.getString(com.huawei.android.p073ds.R$string.channel_backup_notification)) : C0238w.m1663f().m1668i(context, "com.huawei.android.hicloud");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 1, new Intent(context, (Class<?>) MainActivity.class), HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", context.getResources().getString(com.huawei.android.p073ds.R$string.HiCloud_app_name));
        builderM1647f.m3823x(true);
        notificationManager.notify(22, builderM1647f.m3824y(com.huawei.android.p073ds.R$drawable.logo_about_system).m3809j(pendingIntentM1248e0).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
    }

    /* renamed from: u */
    public final void m82510u(Context context, String str, String str2, String str3, String str4, Intent intent, int i10, RecommendCardReport recommendCardReport, RecommendCard recommendCard) {
        C11839m.m70688i("CloudSpaceProxyImp", "sendHomePageRecommendCardsNotificationSplit");
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "recommend_card_notification_click");
        intent.putExtra("recommend_card_activity_id", recommendCardReport.getActivityId());
        intent.putExtra("recommend_card_activity_type", recommendCardReport.getActivityType());
        intent.putExtra("recommend_card_entrance", recommendCardReport.getEntrance());
        if (RecommendCardConstants.Entrance.HOMEPAGE.equals(recommendCardReport.getEntrance())) {
            String activityType = recommendCard.getActivityType();
            if (NotifyConstants.HICLOUD_GALLERY.equals(str4) && !TextUtils.isEmpty(activityType) && activityType.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE)) {
                intent.putExtra("start_to_open_cloud_album_source", 4);
            }
            intent.putExtra("activityType", recommendCardReport.getActivityType());
            String[] devConditions = recommendCard.getDevConditions();
            if (devConditions != null && RecommendCardManager.isOpenGallerySwitchBannerShouldShow(devConditions)) {
                intent.putExtra("gallery_start_to_open_cloud_album", true);
                intent.putExtra("start_to_open_cloud_album_source", 6);
            }
        }
        C0216g0.m1402e(context).m1408F(intent, recommendCardReport.getActivityType() + "_" + recommendCardReport.getActivityId());
        PendingIntent broadcast = (str3.equals("application") && str4.equals(NotifyConstants.HICLOUD_GALLERY)) ? PendingIntent.getBroadcast(context, RecommendCardManager.getInstance().getCurrentRequestCode(), intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : C0209d.m1248e0(context, RecommendCardManager.getInstance().getCurrentRequestCode(), intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        C2783d.m16094L0(recommendCardReport, "recommend_card_notification_show");
        Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent2.setComponent(new ComponentName(context, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent2, "com.huawei.hidisk");
        intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 1, intent2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle = new Bundle();
        Resources resources = context.getResources();
        int i11 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i11));
        boolean zIsSilentNotifyTime = NotifyUtil.isSilentNotifyTime();
        C11839m.m70688i("CloudSpaceProxyImp", "isSilent: " + zIsSilentNotifyTime);
        Notification notificationM3804d = (zIsSilentNotifyTime ? C0235t.m1645e().m1647f(context, str, "2", context.getString(com.huawei.hicloud.account.R$string.app_name)) : C0238w.m1663f().m1668i(context, str)).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(context.getResources().getString(i11)).m3811l(str).m3810k(str2).m3809j(broadcast).m3814o(broadcast2).m3824y(R$drawable.logo_about_system).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        m82509t(context, zIsSilentNotifyTime, notificationManager);
        notificationManager.notify(i10, notificationM3804d);
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public String getParam(String str, String str2) {
        return getParam(str, str2, "");
    }

    @Override // com.huawei.hicloud.notification.ICloudSpaceProxy
    public ActivityEntryEx getIncentiveCardActivityEntryEx(String str, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p;
        if (z10 && (hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p()) != null) {
            int homePageCardRefreshTime = hiCloudSysParamMapM60757p.getHomePageCardRefreshTime();
            C11839m.m70688i("CloudSpaceProxyImp", "Incentive homePageCardRefreshTime: " + homePageCardRefreshTime);
            if (homePageCardRefreshTime > 0) {
                if (System.currentTimeMillis() - RecommendCardManager.getInstance().getLastIncentiveTimeFromSp() < homePageCardRefreshTime * 86400000) {
                    String resourceIdFromSp = RecommendCardManager.getInstance().getResourceIdFromSp();
                    String h5JumpUrlFromSp = RecommendCardManager.getInstance().getH5JumpUrlFromSp();
                    String cTypeFromSp = RecommendCardManager.getInstance().getCTypeFromSp();
                    if (!TextUtils.isEmpty(resourceIdFromSp) && !TextUtils.isEmpty(h5JumpUrlFromSp) && !TextUtils.isEmpty(cTypeFromSp)) {
                        ActivityEntryEx activityEntryEx = new ActivityEntryEx();
                        activityEntryEx.setResource(resourceIdFromSp);
                        activityEntryEx.setUrl(h5JumpUrlFromSp);
                        activityEntryEx.setcType(cTypeFromSp);
                        return activityEntryEx;
                    }
                }
            }
        }
        return m82504k(str, z10, linkedHashMap, -1);
    }
}
