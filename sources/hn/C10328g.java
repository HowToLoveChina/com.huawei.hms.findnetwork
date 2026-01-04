package hn;

import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import gn.EnumC10018a;
import gn.InterfaceC10023f;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kn.C11074k;
import p015ak.C0209d;
import p015ak.C0213f;
import p401jn.C10901a;
import p457ln.C11320e;
import p748wp.C13624a;

/* renamed from: hn.g */
/* loaded from: classes6.dex */
public class C10328g implements InterfaceC10023f {

    /* renamed from: a */
    public C4972b f49999a;

    /* renamed from: b */
    public boolean f50000b;

    /* renamed from: c */
    public boolean f50001c;

    /* renamed from: d */
    public long f50002d;

    /* renamed from: b */
    private NotificationTask m63593b(C4972b c4972b) {
        int iM29933b = c4972b.m29933b();
        if (iM29933b != 0 && iM29933b != 1 && iM29933b != 3) {
            if (iM29933b == 4) {
                NotificationTask notificationTask = new NotificationTask(0L, c4972b.m29932a(), 4);
                notificationTask.setEventType(c4972b.m29933b());
                return notificationTask;
            }
            if (iM29933b != 5) {
                return null;
            }
        }
        long jM63594a = m63594a();
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "notifyTime is:" + jM63594a);
        NotificationTask notificationTask2 = new NotificationTask(jM63594a, c4972b.m29932a(), 1);
        notificationTask2.setEventType(c4972b.m29933b());
        C11074k.m66696R(notificationTask2);
        return notificationTask2;
    }

    /* renamed from: a */
    public final long m63594a() {
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy != null) {
            return spaceProxy.getLatestBackupCycleDay();
        }
        NotifyLogger.m29914e("NoticeBeforeBackupDecisionMaker", "spaceProxy is null");
        return 0L;
    }

    /* renamed from: e */
    public final void m63595e(NotificationTask notificationTask) {
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "handleBackupTaskBegin");
        C11320e c11320e = new C11320e();
        BackupBeforeNotice backupBeforeNoticeM66715r = C11074k.m66715r();
        List<String> arrayList = new ArrayList<>();
        if (backupBeforeNoticeM66715r == null) {
            arrayList.add("notification_bar");
        } else {
            arrayList = backupBeforeNoticeM66715r.getRemindWays();
        }
        notificationTask.setData(arrayList.toString());
        c11320e.m67989a(notificationTask).cancelNotify();
    }

    /* renamed from: f */
    public final boolean m63596f() {
        this.f50001c = CloudSpaceNotifyUtil.getInstance().getSpaceProxy().isSpecifiedTimeInBackupCycleDay(C11074k.m66717t());
        this.f50000b = m63598i();
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "isNoticeBeforeBackupTimeSatisfied,mInBackupCycleDay:" + this.f50001c + ",mNextBackupTimeIsToday:" + this.f50000b);
        return this.f50001c && this.f50000b;
    }

    /* renamed from: h */
    public boolean m63597h() {
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "backup switch is not open");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "backup switch is not open");
            return true;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e("NoticeBeforeBackupDecisionMaker", "spaceProxy is null");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "spaceProxy is null");
            return true;
        }
        if (spaceProxy.isNoMoreRemindSwitchChecked()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "no more remind switch checked.");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "no more remind switch checked.");
            return true;
        }
        if (spaceProxy.isNewBmUserBackupNoData()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "newBmUser but backup data is empty.");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "newBmUser but backup data is empty.");
            return true;
        }
        if (!spaceProxy.isThirdAndSystemAppSwitchOpen()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "all third app switch closed");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "all third app switch closed");
            return true;
        }
        if (spaceProxy.isInBackupOrRestoreTask()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "backup task is running now.");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "backup or restore task is running");
            return true;
        }
        if (m63596f()) {
            return false;
        }
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "notice before backup time not satisfied.");
        if (C0209d.m1309t1(C0213f.m1377a())) {
            m63600p(spaceProxy);
        }
        return true;
    }

    /* renamed from: i */
    public final boolean m63598i() {
        this.f50002d = CloudSpaceNotifyUtil.getInstance().getSpaceProxy().getNextBackupTime();
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "nextBackupTime:" + this.f50002d);
        return C11074k.m66723z(this.f50002d, C11074k.m66717t());
    }

    @Override // gn.InterfaceC10023f
    public EnumC10018a identity() {
        return EnumC10018a.PRE_BACKUP;
    }

    @Override // gn.InterfaceC10023f
    public boolean isValid() {
        return super.isValid();
    }

    /* renamed from: k */
    public final void m63599k(List<NotificationTask> list, NotificationTask notificationTask) {
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "preCheckNoticeBeforeBackup enter");
        if (m63597h()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "precondition not satisfied");
            return;
        }
        if (!CloudSpaceNotifyUtil.getInstance().getSpaceProxy().isBackupTaskExecuteToday()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "today not execute backup task.");
            list.add(notificationTask);
        } else if (!CloudSpaceNotifyUtil.getInstance().getSpaceProxy().isLatestBackupTaskFailedToday()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "backup success today.");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "backup success today.");
        } else if (CloudSpaceNotifyUtil.getInstance().getSpaceProxy().isBackupTaskFailedAndWillRetryToday()) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "isBackupTaskFailedAndWillRetryToday");
            list.add(notificationTask);
        }
    }

    @Override // gn.InterfaceC10023f
    /* renamed from: o */
    public void mo62168o(C4972b c4972b, List<NotificationTask> list) {
        if (c4972b == null) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "event is null.");
            return;
        }
        this.f49999a = c4972b;
        NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "enter into NoticeBeforeBackup DecisionMaker,event id:" + c4972b.m29933b());
        NotificationTask notificationTaskM63593b = m63593b(c4972b);
        if (notificationTaskM63593b == null) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "no need to add notificationTask,event id is:" + c4972b.m29933b());
            return;
        }
        NotifyLogger.m29913d("NoticeBeforeBackupDecisionMaker", "notificationTask type:" + notificationTaskM63593b.getType());
        if (notificationTaskM63593b.getType() == 1) {
            m63599k(list, notificationTaskM63593b);
        } else if (notificationTaskM63593b.getType() == 4) {
            m63595e(notificationTaskM63593b);
        }
    }

    /* renamed from: p */
    public final void m63600p(ICloudSpaceProxy iCloudSpaceProxy) {
        long latestBackupCycleDay = iCloudSpaceProxy.getLatestBackupCycleDay();
        long jM66717t = C11074k.m66717t();
        if (jM66717t >= latestBackupCycleDay - 86400000 && jM66717t < latestBackupCycleDay) {
            NotifyLogger.m29915i("NoticeBeforeBackupDecisionMaker", "not reach backup cycle day,but within 24h,will set timer");
            C11074k.m66693O(this.f49999a.m29933b(), 1, "not reach backup cycle day,but within 24h,will set timer");
            C13624a.m81979b().m81980c(new C10901a(), new Date(latestBackupCycleDay));
            return;
        }
        C11074k.m66693O(this.f49999a.m29933b(), 1, "time not satisfied,isInBackupCycleDay:" + this.f50001c + ",nextBackupTime:" + this.f50002d + ",nextBackupIsToday:" + this.f50000b);
    }
}
