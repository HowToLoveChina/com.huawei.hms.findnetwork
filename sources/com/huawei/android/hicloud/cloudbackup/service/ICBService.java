package com.huawei.android.hicloud.cloudbackup.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreRetry;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.service.ICBService;
import com.huawei.android.hicloud.cloudbackup.service.IRemoteService;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.C11074k;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1009d;
import p371ik.C10527a;
import p459lp.C11327e;
import p514o9.C11839m;
import p572qb.C12299b;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12600v1;
import p709vj.C13452e;
import p744wl.C13617a;
import p744wl.C13619c;
import p847zk.C14315h;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes2.dex */
public class ICBService extends Service {
    private static final long DAY_MILLIS = 86400000;
    private static final long MINIT_MILLIS = 60000;
    private static final String TAG = "ICBService";
    private Context mContext;
    private long millis = 0;
    private long lastsuccesstime = 0;
    private final IRemoteService.Stub mbinder = new BinderC26781();

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.ICBService$1 */
    public class BinderC26781 extends IRemoteService.Stub {

        /* renamed from: com.huawei.android.hicloud.cloudbackup.service.ICBService$1$1 */
        public class AnonymousClass1 extends AbstractC12368e {
            public AnonymousClass1() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                boolean zCheckNotifyCondition;
                List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.BACKUP_CYCLE, UserSpaceUtil.getUserTagsUseCache("doBackupNotify"));
                long jQuerynotifycycle = new SettingOperator().querynotifycycle();
                if (extraNotificationBean != null && extraNotificationBean.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    zCheckNotifyCondition = false;
                    ExtraNotificationBean extraNotificationBean2 = extraNotificationBean.get(0);
                    List<String> userGroupExtIDs = extraNotificationBean2.getUserGroupExtIDs();
                    if (userGroupExtIDs == null || userGroupExtIDs.isEmpty()) {
                        arrayList.addAll(extraNotificationBean);
                    } else {
                        arrayList.add(extraNotificationBean2);
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        long unBackupDays = ((ExtraNotificationBean) it.next()).getUnBackupDays();
                        if (unBackupDays == 0) {
                            unBackupDays = jQuerynotifycycle;
                        }
                        if (BinderC26781.this.checkNotifyCondition(unBackupDays)) {
                            zCheckNotifyCondition = true;
                            break;
                        }
                    }
                } else {
                    zCheckNotifyCondition = BinderC26781.this.checkNotifyCondition(jQuerynotifycycle);
                }
                C11839m.m70688i(ICBService.TAG, "notify flag = " + zCheckNotifyCondition);
                if (zCheckNotifyCondition) {
                    BinderC26781 binderC26781 = BinderC26781.this;
                    binderC26781.beginNotify(ICBService.this.millis, ICBService.this.lastsuccesstime);
                }
            }
        }

        /* renamed from: com.huawei.android.hicloud.cloudbackup.service.ICBService$1$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false));
            }
        }

        public BinderC26781() {
        }

        public void beginNotify(long j10, long j11) {
            C11839m.m70688i(ICBService.TAG, "beginNotify millis: " + j10);
            HiCloudNotification.getInstance().executeBackupCycleNotify((int) (j10 / 86400000), j11);
        }

        public boolean checkNotifyCondition(long j10) {
            C11839m.m70688i(ICBService.TAG, "check notify condition.");
            SettingOperator settingOperator = new SettingOperator();
            ICBService.this.lastsuccesstime = settingOperator.querylastsuccesstime();
            long jQueryinitopentime = settingOperator.queryinitopentime();
            settingOperator.querylastnotifytime();
            C11839m.m70688i(ICBService.TAG, "notifycycle is : " + j10);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (ICBService.this.lastsuccesstime == 0) {
                ICBService.this.lastsuccesstime = jQueryinitopentime;
                ICBService iCBService = ICBService.this;
                iCBService.millis = jCurrentTimeMillis - iCBService.lastsuccesstime;
                C11839m.m70688i(ICBService.TAG, "has no backup record, day = " + ((ICBService.this.millis - 1) / 86400000) + 1);
                if (ICBService.this.millis > j10 * 86400000) {
                    return true;
                }
            } else {
                ICBService iCBService2 = ICBService.this;
                iCBService2.millis = jCurrentTimeMillis - iCBService2.lastsuccesstime;
                C11839m.m70688i(ICBService.TAG, "has success backup record, day = " + ((ICBService.this.millis - 1) / 86400000) + 1);
                if (ICBService.this.millis > j10 * 86400000) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ void lambda$callNotifyServer$0(BaseNotifyBean baseNotifyBean, MsgUserData msgUserData) {
            C11839m.m70688i(ICBService.TAG, "callNotifyResult:" + MessageCenterManager.getInstance().invokeEvent(baseNotifyBean, C11327e.m68061d(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE), NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, msgUserData));
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void callNotifyServer(String str) throws RemoteException {
            C11839m.m70688i(ICBService.TAG, "callNotifyServer enter,userData is:" + str);
            BackupBeforeNotice backupBeforeNotice = (BackupBeforeNotice) C10527a.m64629g(str, BackupBeforeNotice.class);
            if (str == null) {
                C11839m.m70687e(ICBService.TAG, "callNotifyServer error,data is null");
                return;
            }
            final BaseNotifyBean baseNotifyBeanM66709l = C11074k.m66709l(backupBeforeNotice);
            final MsgUserData msgUserDataM66710m = C11074k.m66710m(backupBeforeNotice);
            new Thread(new Runnable() { // from class: com.huawei.android.hicloud.cloudbackup.service.k
                @Override // java.lang.Runnable
                public final void run() {
                    ICBService.BinderC26781.lambda$callNotifyServer$0(baseNotifyBeanM66709l, msgUserDataM66710m);
                }
            }).start();
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doAbort(int i10) throws RemoteException {
            C11839m.m70688i(ICBService.TAG, "do abort. type = " + i10);
            if (i10 == 0) {
                if (C0209d.m1254f2(ICBService.this.mContext)) {
                    return;
                }
                CBAccess.abort(1002);
                return;
            }
            if (i10 == 1) {
                if (CBAccess.inBackup()) {
                    CBAccess.abortAutoBackup(1006);
                }
            } else if (i10 == 2) {
                if (CBAccess.inBackup()) {
                    CBAccess.abortAutoBackup(1005);
                }
            } else {
                if (i10 != 3) {
                    return;
                }
                if (CBAccess.inRestoreFirst() || CBAccess.inRestoreLast()) {
                    CBAccess.abort(1004);
                }
                if (CBAccess.inBackup()) {
                    CBAccess.abortManulBackup(1003);
                }
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doBackup() throws RemoteException {
            C11839m.m70688i(ICBService.TAG, "check backup condition.");
            if (C1009d.m6109e().m6115g() != 0) {
                C11839m.m70688i(ICBService.TAG, "doBackup clear not finish.");
                return;
            }
            if (!C0209d.m1254f2(ICBService.this.mContext)) {
                C11839m.m70688i(ICBService.TAG, "wifi is not active.");
                return;
            }
            if (CBAccess.inBackup() || CBAccess.inRestore()) {
                C11839m.m70688i(ICBService.TAG, "now in backup or restore");
                return;
            }
            SettingOperator settingOperator = new SettingOperator();
            long jQuerylastsuccesstime = settingOperator.querylastsuccesstime();
            long jQueryFinalBackupCycle = settingOperator.queryFinalBackupCycle();
            long jQuerynextbackuptime = settingOperator.querynextbackuptime();
            long jQuerylastfailedtime = settingOperator.querylastfailedtime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = jCurrentTimeMillis - jQuerylastsuccesstime;
            long jM75331D0 = new C12526j().m75331D0();
            C11839m.m70688i(ICBService.TAG, "backup millis time = " + j10);
            if (j10 >= jQueryFinalBackupCycle * 86400000) {
                boolean z10 = jQuerynextbackuptime == 0 && jCurrentTimeMillis - jQuerylastfailedtime > jM75331D0 * 60000;
                boolean z11 = jQuerynextbackuptime > 0 && jCurrentTimeMillis - jQuerylastfailedtime > jQuerynextbackuptime;
                if (z10 || z11) {
                    C11839m.m70688i(ICBService.TAG, "start auto backup");
                    CloudBackupService.getInstance().backup(true, false);
                }
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doBackupNotify() throws RemoteException {
            C12515a.m75110o().m75172d(new AbstractC12368e() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBService.1.1
                public AnonymousClass1() {
                }

                @Override // p616rk.AbstractRunnableC12516b
                public void call() throws C9721b {
                    boolean zCheckNotifyCondition;
                    List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.BACKUP_CYCLE, UserSpaceUtil.getUserTagsUseCache("doBackupNotify"));
                    long jQuerynotifycycle = new SettingOperator().querynotifycycle();
                    if (extraNotificationBean != null && extraNotificationBean.size() != 0) {
                        ArrayList arrayList = new ArrayList();
                        zCheckNotifyCondition = false;
                        ExtraNotificationBean extraNotificationBean2 = extraNotificationBean.get(0);
                        List<String> userGroupExtIDs = extraNotificationBean2.getUserGroupExtIDs();
                        if (userGroupExtIDs == null || userGroupExtIDs.isEmpty()) {
                            arrayList.addAll(extraNotificationBean);
                        } else {
                            arrayList.add(extraNotificationBean2);
                        }
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            long unBackupDays = ((ExtraNotificationBean) it.next()).getUnBackupDays();
                            if (unBackupDays == 0) {
                                unBackupDays = jQuerynotifycycle;
                            }
                            if (BinderC26781.this.checkNotifyCondition(unBackupDays)) {
                                zCheckNotifyCondition = true;
                                break;
                            }
                        }
                    } else {
                        zCheckNotifyCondition = BinderC26781.this.checkNotifyCondition(jQuerynotifycycle);
                    }
                    C11839m.m70688i(ICBService.TAG, "notify flag = " + zCheckNotifyCondition);
                    if (zCheckNotifyCondition) {
                        BinderC26781 binderC26781 = BinderC26781.this;
                        binderC26781.beginNotify(ICBService.this.millis, ICBService.this.lastsuccesstime);
                    }
                }
            });
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doGetBackupOptions() throws RemoteException {
            C11839m.m70688i(ICBService.TAG, "doGetBackupOptions");
            if (CBAccess.inBackup() || CBAccess.inRestoreWithRetryClearCheck(false)) {
                C11839m.m70688i(ICBService.TAG, "in backup or restore now");
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBService.1.2
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false));
                    }
                }, 10000L);
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public boolean doNewBackup(String str) throws RemoteException {
            if (CBAccess.inBackup() || CBAccess.inRestoreWithRetryClearCheck(true)) {
                C11839m.m70688i(ICBService.TAG, "doNewBackup now in backup or restore");
                return false;
            }
            boolean zHasValidTempBackup = CBAccess.hasValidTempBackup();
            boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
            C11839m.m70688i(ICBService.TAG, "doNewBackup type:" + str + " ,hasValidTempBackup: " + zHasValidTempBackup + " ,backupSwitch: " + zM62388s);
            if (!"0".equals(str)) {
                return CloudBackupService.getInstance().backup(true, false);
            }
            if (!zHasValidTempBackup) {
                CloudBackupReport.reportTempInvalidClear(zM62388s);
                if (!zM62388s) {
                    C14315h.m85247M(false, PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED, true);
                }
                C13617a.m81921c(C0213f.m1377a(), true);
                C12299b.m73932n("backupAction", "");
                return false;
            }
            int iM24616e = C13452e.m80781L().m80907e1() ? C12600v1.m76047c().m76053d().m24616e() : 0;
            C11839m.m70688i(ICBService.TAG, "has valid tempBackup,occupySpace:" + iM24616e);
            C0212e0.m1365o(C0213f.m1377a(), "tempBackupSpFile", "key_backup_start_or_resume", true);
            return CloudBackupService.getInstance().doTempBackup(true, iM24616e);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doNewBackupNotify(long j10, long j11) throws RemoteException {
            C11839m.m70688i(ICBService.TAG, "begin backup notify");
            beginNotify(j10, j11);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doPause() throws RemoteException {
            C11839m.m70688i(ICBService.TAG, "do pause.");
            CBAccess.pause();
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doRestore(int i10) throws RemoteException {
            C13029h c13029hM78495f;
            C11839m.m70688i(ICBService.TAG, "check last restore condition.");
            if (!CBAccess.hasRestoreTask()) {
                CloudBackupJobManager.getInstance().unRegisterDsRestoreScheduler();
                C11839m.m70688i(ICBService.TAG, "CloudRestoreJobService !hasRestoreTask");
                return;
            }
            try {
                c13029hM78495f = new C13030i().m78495f(3);
            } catch (C9721b e10) {
                C11839m.m70687e(ICBService.TAG, "tags is null " + e10.getMessage());
                c13029hM78495f = null;
            }
            RestoreRetry restoreRetryM75325A0 = new C12526j().m75325A0();
            if (!RestoreUtil.checkIsRegisterAutoRestore(c13029hM78495f, restoreRetryM75325A0)) {
                C11839m.m70688i(ICBService.TAG, "query tags is null or !checkIsRegister.");
                CloudBackupJobManager.getInstance().unRegisterDsRestoreScheduler();
                return;
            }
            if (i10 == 1 && !c13029hM78495f.m78474q().contains(String.valueOf(1002))) {
                C11839m.m70688i(ICBService.TAG, "autoRestoreType wifi connect ,not last wifi disable");
                return;
            }
            if (RestoreUtil.checkAutoRestoreCondition(restoreRetryM75325A0, ICBService.this.getApplicationContext())) {
                if (C13619c.m81952h(c13029hM78495f.m78480t())) {
                    C11839m.m70688i(ICBService.TAG, "restore retry v3 process");
                    CloudBackupService.getInstance().restoreRetryV3(false, true, true);
                } else {
                    C11839m.m70688i(ICBService.TAG, "restore retry v2 process");
                    CloudBackupService.getInstance().restoreRetry(false, true, true);
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mbinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }
}
