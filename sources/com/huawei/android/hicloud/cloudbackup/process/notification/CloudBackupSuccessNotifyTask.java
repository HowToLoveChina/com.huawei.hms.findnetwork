package com.huawei.android.hicloud.cloudbackup.process.notification;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.notification.CloudBackupSuccessNotifyTask;
import com.huawei.android.hicloud.cloudbackup.util.BackupNotificationUtil;
import com.huawei.android.hicloud.cloudbackup.util.TipPeriodCheckUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeContentRoot;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0223k;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;
import tl.C13026e;

/* loaded from: classes2.dex */
public class CloudBackupSuccessNotifyTask extends AbstractC12367d {
    private static final int CHECKFAIL = 0;
    private static final int ILLEGAL = -1;
    private static final int SUCCESS = 1;
    private static final String TAG = "CloudBackupSuccessNotifyTask";
    private static final String TYPE = "cloud_back_success_notify";
    public long backupSize;
    private boolean isAutoBackup;
    public String noticeMainText;
    public String noticeTitle;
    private Context mContext = C0213f.m1377a();
    private FrequencyManager frequencyChecker = new FrequencyManager();
    private TipPeriodCheckUtil tipPeriodChecker = new TipPeriodCheckUtil();
    private HiCloudNotificationManager notifyManager = new HiCloudNotificationManager(this.mContext);

    public CloudBackupSuccessNotifyTask(boolean z10, long j10) {
        this.isAutoBackup = z10;
        this.backupSize = j10;
    }

    private int doNotifyBackUpSuccess(String str, List<SpaceNotification> list) {
        C0212e0.m1369s(this.mContext, SharedPreferencesStorage.BACKUPOPTION_SPFILE, TipPeriodCheckUtil.CHECKBACKUPSUCCESSCOUNT, C0212e0.m1358h(this.mContext, SharedPreferencesStorage.BACKUPOPTION_SPFILE, TipPeriodCheckUtil.CHECKBACKUPSUCCESSCOUNT, 0) + 1);
        if (list == null || list.size() == 0) {
            NotifyLogger.m29915i(TAG, "doNotifyBackUpSuccess spaceNotifications empty");
            return -1;
        }
        SpaceNotification weightNotificationBy = getWeightNotificationBy(list, str, UserSpaceUtil.getUserTagsUseCache("doNotifyBackUpSuccess"), UserSpaceUtil.getGradeCodeUseCache("doNotifyBackUpSuccess"));
        if (weightNotificationBy == null) {
            NotifyLogger.m29915i(TAG, "sendBackupSuccessNotice backupNotify null and block!");
            return 0;
        }
        if (!this.tipPeriodChecker.checkBackupSuccessNotifyCount(this.mContext, weightNotificationBy.getTipPeriod())) {
            NotifyLogger.m29915i(TAG, "sendBackupSuccessNotice tipPeriodChecker blocked!");
            return 0;
        }
        Optional.ofNullable(weightNotificationBy.getNoticeContent()).map(new Function() { // from class: j8.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((NoticeContentRoot) obj).getNoticeContent();
            }
        }).ifPresent(new Consumer() { // from class: j8.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f51388a.getNoticeTextFromOM((NoticeContent) obj);
            }
        });
        if (C4633d0.m28404a(this.noticeTitle) || C4633d0.m28404a(this.noticeMainText)) {
            NotifyLogger.m29914e(TAG, "doNotifyBackUpSuccess noticeTitle or noticeMainText is null");
            return -1;
        }
        if (C13452e.m80781L().m80887a1()) {
            NotifyLogger.m29915i(TAG, "new bm type, hide notify content");
            this.noticeMainText = null;
        }
        long jSendBackupSuccessNotice = BackupNotificationUtil.sendBackupSuccessNotice(this.mContext, this.isAutoBackup, this.notifyManager, weightNotificationBy, this.noticeTitle, this.noticeMainText);
        C0212e0.m1369s(this.mContext, SharedPreferencesStorage.BACKUPOPTION_SPFILE, TipPeriodCheckUtil.CHECKBACKUPSUCCESSCOUNT, 0);
        if (jSendBackupSuccessNotice == -1) {
            return -1;
        }
        C0212e0.m1371u(this.mContext, SharedPreferencesStorage.BACKUPOPTION_SPFILE, FrequencyManager.CHECKBACKUPSUCCESSTIME, jSendBackupSuccessNotice);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNoticeTextFromOM(NoticeContent noticeContent) {
        this.noticeTitle = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getTitle());
        if (!C13452e.m80781L().m80897c1()) {
            String stringUseLock = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getPayMainText());
            this.noticeMainText = stringUseLock;
            if (C4633d0.m28404a(stringUseLock)) {
                return;
            }
            this.noticeMainText = this.noticeMainText.replace("%{BackupSize}s", C0223k.m1524g(this.mContext, this.backupSize));
            return;
        }
        if (!new C13026e().m78395p()) {
            this.noticeMainText = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getCloseDataMainText());
            return;
        }
        String stringUseLock2 = SpaceNoticeV3Manager.getInstance().getStringUseLock(noticeContent.getOpenDataMainText());
        this.noticeMainText = stringUseLock2;
        if (C4633d0.m28404a(stringUseLock2)) {
            return;
        }
        this.noticeMainText = this.noticeMainText.replace("%{BackupSize}s", C0223k.m1524g(this.mContext, this.backupSize));
    }

    private SpaceNotification getWeightNotificationBy(List<SpaceNotification> list, String str, List<PortraitAndGrade.UserTag> list2, String str2) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            SpaceNotification spaceNotification = list.get(i10);
            if (spaceNotification != null) {
                String noticeType = spaceNotification.getNoticeType();
                float frequency = spaceNotification.getFrequency();
                if (!TextUtils.isEmpty(str) && str.equals(noticeType) && CloudSpaceNotifyUtil.checkUserTag(list2, spaceNotification) && CloudSpaceNotifyUtil.getInstance().checkGradeCode(spaceNotification, str2) && this.frequencyChecker.checkBackupSuccessNotifyFrequency(this.mContext, SharedPreferencesStorage.BACKUPOPTION_SPFILE, frequency)) {
                    arrayList.add(spaceNotification);
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 1) {
            Collections.sort(arrayList, new Comparator() { // from class: j8.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return CloudBackupSuccessNotifyTask.lambda$getWeightNotificationBy$0((SpaceNotification) obj, (SpaceNotification) obj2);
                }
            });
        }
        if (size2 > 0) {
            return (SpaceNotification) arrayList.get(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getWeightNotificationBy$0(SpaceNotification spaceNotification, SpaceNotification spaceNotification2) {
        return spaceNotification.getPriority() - spaceNotification2.getPriority();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b, IOException {
        List<SpaceNotification> configNotificationByNoticeType = SpaceNoticeV3Manager.getInstance().getConfigNotificationByNoticeType("cloud_back_success_notify");
        if (this.isAutoBackup) {
            doNotifyBackUpSuccess("cloud_back_success_notify", configNotificationByNoticeType);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.BACKUP_LIFE_CYCLE;
    }
}
