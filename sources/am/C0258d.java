package am;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import bm.InterfaceC1262c;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0226l0;
import p292fn.C9733f;
import p336he.C10155f;
import p429kk.C11058a;
import p514o9.C11839m;
import p572qb.C12299b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12600v1;
import p709vj.C13452e;
import p711vl.C13466f;
import p814yl.C13998b0;
import p840zd.C14229k2;
import p847zk.C14317j;
import pm.C12176c;

/* renamed from: am.d */
/* loaded from: classes6.dex */
public class C0258d extends CacheTask {

    /* renamed from: a */
    public final boolean f918a;

    /* renamed from: b */
    public final boolean f919b;

    /* renamed from: c */
    public boolean f920c;

    /* renamed from: d */
    public C9721b f921d;

    /* renamed from: e */
    public final String f922e;

    /* renamed from: f */
    public final boolean f923f;

    /* renamed from: g */
    public final boolean f924g;

    /* renamed from: h */
    public final boolean f925h;

    /* renamed from: i */
    public final int f926i;

    /* renamed from: am.d$a */
    public class a implements InterfaceC1262c {

        /* renamed from: a */
        public final /* synthetic */ AtomicBoolean f927a;

        public a(AtomicBoolean atomicBoolean) {
            this.f927a = atomicBoolean;
        }

        @Override // bm.InterfaceC1262c
        /* renamed from: a */
        public void mo1753a() {
            C0258d.this.abort();
        }

        @Override // bm.InterfaceC1262c
        /* renamed from: b */
        public void mo1754b() {
            this.f927a.set(true);
        }
    }

    public C0258d(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10) {
        this.f920c = false;
        this.f921d = null;
        this.f918a = z10;
        this.f919b = z11;
        this.f922e = C11058a.m66627b(z10 ? "02001" : "02002");
        this.f923f = z12;
        this.f924g = z13;
        this.f926i = i10;
        this.f925h = z14;
    }

    /* renamed from: q */
    public static boolean m1733q(int i10) {
        return i10 == 3 || i10 == 1 || i10 == 5 || i10 == 6;
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m1734s(String str, BackupOptionItem backupOptionItem) {
        return str.equals(backupOptionItem.getAppId());
    }

    /* renamed from: t */
    public static /* synthetic */ void m1735t(int i10) {
        Toast.makeText(CacheTask.getContext(), i10, 1).show();
    }

    /* renamed from: A */
    public final void m1736A(final int i10) {
        if (!this.f923f || this.f924g) {
            C0226l0.m1584d(new Runnable() { // from class: am.b
                @Override // java.lang.Runnable
                public final void run() {
                    C0258d.m1735t(i10);
                }
            });
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        CacheTask c4879a;
        try {
            try {
                C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
                C10782d.m65634a().m65640g(CacheTask.getContext());
                C11839m.m70688i("CloudBackupPreCheckTask", "CloudBackupPreCheckTask start.");
                m1752z();
                if (this.f925h) {
                    m1742k();
                }
                if (m1749u()) {
                    isCancel();
                    String str = this.f918a ? "auto" : CBSbkFlowHead.BKMODE_MANUAL;
                    if (this.f925h) {
                        str = "interim";
                        m1738f();
                        c4879a = new C4879a(this.f918a, "interim", this.f922e, this.f926i);
                    } else if (this.f919b) {
                        String strM1746o = m1746o();
                        C11839m.m70688i("CloudBackupPreCheckTask", "getUploadTargetStrategy, strategy = " + strM1746o);
                        if ("1".equalsIgnoreCase(strM1746o)) {
                            throw new C9721b(3912, "upload target strategy is error, stop refurbish backup task.");
                        }
                        m1737e();
                        c4879a = new C4879a(this.f918a, "Refurbishment", this.f922e, this.f926i);
                        str = "Refurbishment";
                    } else {
                        String strM1746o2 = m1746o();
                        C11839m.m70688i("CloudBackupPreCheckTask", "getUploadTargetStrategy, strategy = " + strM1746o2);
                        c4879a = "2".equalsIgnoreCase(strM1746o2) ? new C4879a(this.f918a, this.f922e, this.f923f) : new CloudBackupTask(this.f918a, this.f922e);
                    }
                    CBAccess.removeTask(this);
                    if (CBAccess.addTask(c4879a)) {
                        this.f920c = true;
                        if (!this.f918a) {
                            ScreenListener.m18023c(CacheTask.getContext()).m18028g();
                        }
                        C14317j.m85301e(str).m85310k(1, this.f919b);
                        NotificationReportUtil.reportTriggerSrc("0004");
                        CloudSpaceNotifyUtil.getInstance().notifyCloudSpace();
                    }
                }
            } catch (C9721b e10) {
                C11839m.m70686d("CloudBackupPreCheckTask", "LoadAboutTask failed " + e10);
                this.f921d = e10;
            }
            CBAccess.removeTask(this);
            m1750v();
            m1751y();
        } catch (Throwable th2) {
            CBAccess.removeTask(this);
            m1750v();
            m1751y();
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean condition() {
        return this.f918a ? C0209d.m1254f2(CacheTask.getContext()) : C10782d.m65634a().m65642i(CacheTask.getContext());
    }

    /* renamed from: e */
    public final void m1737e() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudBackupPreCheckTask", "abortBackupTaskExcludeRefurbishTask start");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CBAccess.abortAllBackupExRefurbish(1001, m1739g(atomicBoolean));
        while (!atomicBoolean.get()) {
            SystemClock.sleep(1000L);
            isCancel();
        }
        C11839m.m70688i("CloudBackupPreCheckTask", "abortBackupTaskExcludeRefurbishTask end");
    }

    /* renamed from: f */
    public final void m1738f() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudBackupPreCheckTask", "abortBackupTaskExcludeTempTask start");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CBAccess.abortAllBackupExTemp(1001, m1739g(atomicBoolean));
        while (!atomicBoolean.get()) {
            SystemClock.sleep(1000L);
            isCancel();
        }
        C11839m.m70688i("CloudBackupPreCheckTask", "abortBackupTaskExcludeTempTask end");
    }

    /* renamed from: g */
    public final InterfaceC1262c m1739g(AtomicBoolean atomicBoolean) {
        return new a(atomicBoolean);
    }

    /* renamed from: h */
    public final void m1740h(About about) throws C9721b {
        if (about != null) {
            if (m1733q(about.getCloudOperationType() == null ? 0 : about.getCloudOperationType().intValue())) {
                throw new C9721b(3920, "clearing backup restore abort");
            }
        }
    }

    /* renamed from: j */
    public final void m1741j(About about) throws C9721b {
        if (about != null) {
            Integer refurQuotaExhausted = about.getRefurQuotaExhausted();
            C11839m.m70688i("CloudBackupPreCheckTask", "about refurQuotaExhausted: " + refurQuotaExhausted);
            if (this.f919b && refurQuotaExhausted != null && refurQuotaExhausted.intValue() == 0) {
                throw new C9721b(3921, "refurbish quota exhausted");
            }
        }
    }

    /* renamed from: k */
    public final void m1742k() {
        C14229k2 c14229k2 = new C14229k2();
        List<BackupOptionItem> listM78397u = c14229k2.m78397u();
        List<String> listM75384d0 = new C12526j().m75384d0();
        List<String> listM75387e0 = new C12526j().m75387e0();
        for (BackupOptionItem backupOptionItem : listM78397u) {
            if (backupOptionItem.getOperateType() != 1 && !backupOptionItem.getBackupSwitch() && (listM75384d0.contains(backupOptionItem.getAppId()) || listM75387e0.contains(backupOptionItem.getAppId()))) {
                C11839m.m70688i("CloudBackupPreCheckTask", "correct status: " + backupOptionItem.getAppId());
                c14229k2.m78377L(true, backupOptionItem.getAppId(), backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
            }
        }
        m1743l(c14229k2);
    }

    /* renamed from: l */
    public final void m1743l(C14229k2 c14229k2) {
        if (c14229k2 == null) {
            c14229k2 = new C14229k2();
        }
        List<BackupOptionItem> listM78397u = c14229k2.m78397u();
        if (listM78397u == null) {
            C11839m.m70688i("CloudBackupPreCheckTask", "tempModulesList is null");
            return;
        }
        ArrayList arrayList = new ArrayList(listM78397u);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackupOptionItem backupOptionItem = (BackupOptionItem) it.next();
            if (backupOptionItem != null && SplitAppUtil.hasSplitAppSuffix(backupOptionItem.getAppId())) {
                String splitAppType = SplitAppUtil.getSplitAppType(backupOptionItem.getAppId());
                backupOptionItem.setOriBackupAppName(SplitAppUtil.getSplitOriAppId(backupOptionItem.getAppId()));
                backupOptionItem.setSplitApkType(splitAppType);
                List arrayList2 = map.get(backupOptionItem.getOriBackupAppName()) != null ? (List) map.get(backupOptionItem.getOriBackupAppName()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(backupOptionItem);
                    map.put(backupOptionItem.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (map.isEmpty()) {
            return;
        }
        for (final String str : map.keySet()) {
            Optional<BackupOptionItem> optionalFindFirst = listM78397u.stream().filter(new Predicate() { // from class: am.c
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C0258d.m1734s(str, (BackupOptionItem) obj);
                }
            }).findFirst();
            if (!optionalFindFirst.isPresent()) {
                C11839m.m70688i("CloudBackupPreCheckTask", "firstItem is null");
            } else if (optionalFindFirst.get().getBackupSwitch()) {
                C11839m.m70688i("CloudBackupPreCheckTask", "backupSwitch is true,not need deal");
            } else {
                List<BackupOptionItem> list = (List) map.get(str);
                if (list == null) {
                    C11839m.m70688i("CloudBackupPreCheckTask", "splitItems is null");
                } else {
                    for (BackupOptionItem backupOptionItem2 : list) {
                        c14229k2.m78377L(false, backupOptionItem2.getAppId(), backupOptionItem2.getOperateType(), Long.valueOf(backupOptionItem2.getOperateTime()));
                    }
                }
            }
        }
    }

    /* renamed from: m */
    public final String m1744m() throws C9721b {
        C11839m.m70688i("CloudBackupPreCheckTask", "getAutoUploadTargetStrategyFromServer");
        return C12176c.m73270m(new C13998b0().m84137z("uploadTargetStrategy", this.f922e));
    }

    /* renamed from: n */
    public final String m1745n() throws C9721b {
        C11839m.m70688i("CloudBackupPreCheckTask", "getManualUploadTargetStrategyFromServer");
        String strQueryUploadTargetStrategy = new SettingOperator().queryUploadTargetStrategy();
        C13998b0 c13998b0 = new C13998b0();
        About aboutM84095B = "1".equalsIgnoreCase(strQueryUploadTargetStrategy) ? this.f919b ? c13998b0.m84095B("uploadTargetStrategy,cloudOperationType,refurQuotaExhausted", true, this.f922e, "Refurbishment", null) : c13998b0.m84137z("uploadTargetStrategy,cloudOperationType", this.f922e) : this.f919b ? c13998b0.m84094A("cloudOperationType,refurQuotaExhausted", this.f922e, "Refurbishment") : c13998b0.m84137z("cloudOperationType", this.f922e);
        String strM73270m = C12176c.m73270m(aboutM84095B);
        m1740h(aboutM84095B);
        m1741j(aboutM84095B);
        return strM73270m;
    }

    /* renamed from: o */
    public final String m1746o() throws InterruptedException, C9721b {
        isCancel();
        SettingOperator settingOperator = new SettingOperator();
        return (this.f918a || !C10028c.m62182c0().m62335h1()) ? (this.f918a && TextUtils.isEmpty(settingOperator.queryUploadTargetStrategyConfig())) ? m1744m() : settingOperator.queryUploadTargetStrategy() : m1745n();
    }

    /* renamed from: p */
    public boolean m1747p() {
        return this.f919b;
    }

    /* renamed from: r */
    public boolean m1748r() {
        return this.f925h;
    }

    /* renamed from: u */
    public final boolean m1749u() throws C9721b {
        if (!C10028c.m62182c0().m62403v("backup_key", false) && !this.f925h) {
            C13466f.m81073d().m81081i("backup_key", false);
            C12299b.m73934p(false);
            return false;
        }
        if (!this.f925h && !m1747p() && CBAccess.hasValidTempBackup()) {
            throw new C9721b(33035, "exist temp backup task");
        }
        String strM80950o = C13452e.m80781L().m80950o();
        if (strM80950o == null || strM80950o.isEmpty()) {
            C11839m.m70689w("CloudBackupPreCheckTask", "backup device is empty.");
            return false;
        }
        if (!C10155f.m63259L(CacheTask.getContext())) {
            C11839m.m70689w("CloudBackupPreCheckTask", "phone locked.");
            return false;
        }
        if (this.f918a && !this.f925h) {
            CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33020));
        }
        C12515a.m75110o().m75166b(GetOptionsInfoFromCloneTask.class.getName());
        C12515a.m75110o().m75166b(CloudBackupService.DeleteLocalRecordCacheTask.class.getName());
        return true;
    }

    /* renamed from: v */
    public final void m1750v() {
        int i10;
        Message messageObtain = Message.obtain();
        messageObtain.what = 33023;
        if (this.f920c) {
            i10 = 1;
        } else {
            C9721b c9721b = this.f921d;
            if (c9721b == null || c9721b.m60659c() != 3920) {
                C9721b c9721b2 = this.f921d;
                if (c9721b2 == null || c9721b2.m60659c() != 3900) {
                    C9721b c9721b3 = this.f921d;
                    if (c9721b3 == null || c9721b3.m60659c() != 33035) {
                        C9721b c9721b4 = this.f921d;
                        if (c9721b4 == null || c9721b4.m60659c() != 3921) {
                            m1736A(R$string.recovery_no_data_server_error);
                        }
                        i10 = 2;
                    } else {
                        i10 = 33035;
                    }
                } else {
                    m1736A(R$string.alert_net_disconnect);
                    i10 = 0;
                }
            } else {
                m1736A(R$string.toast_tip_in_delete_backup);
                i10 = 3;
            }
        }
        C11839m.m70688i("CloudBackupPreCheckTask", "sendEndMessage: " + i10);
        messageObtain.arg1 = i10;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: y */
    public final void m1751y() {
        if (this.f919b) {
            Message messageObtain = Message.obtain();
            if (this.f921d != null) {
                C11839m.m70688i("CloudBackupPreCheckTask", "refurbish pre check task error: " + this.f921d);
                messageObtain.what = 33027;
                messageObtain.arg1 = this.f921d.m60659c();
            } else if (this.f920c) {
                C11839m.m70688i("CloudBackupPreCheckTask", "refurbish pre check task success.");
                messageObtain.what = 33026;
            } else {
                C11839m.m70688i("CloudBackupPreCheckTask", "refurbish pre check task load error.");
                messageObtain.what = 33027;
            }
            CBCallBack.getInstance().sendMessage(messageObtain);
        }
    }

    /* renamed from: z */
    public final void m1752z() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 33025;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    public C0258d(boolean z10, boolean z11, boolean z12) {
        this(z10, z11, z12, false, false, C12600v1.m76047c().m76053d().m24616e());
    }
}
