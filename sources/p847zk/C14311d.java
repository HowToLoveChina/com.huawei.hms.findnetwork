package p847zk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.bean.ReportAppMarketInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.ReadOmConfigFileTask;
import com.huawei.android.hicloud.cloudbackup.restore.ReportAppMarketFailedSp;
import com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.common.account.AccountBroadcastManager;
import com.huawei.android.hicloud.common.manager.ConfigBroadcastManager;
import com.huawei.android.hicloud.common.mission.Mission;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainforSettingActivity;
import com.huawei.android.hicloud.task.simple.C3052k2;
import com.huawei.hicloud.notification.CloudSpaceNotifyHelper;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hms.network.embedded.C5843a0;
import gn.InterfaceC10020c;
import gp.C10028c;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import kn.C11074k;
import mn.C11500d;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0241z;
import p221d9.C9053a;
import p221d9.C9054b;
import p221d9.C9055c;
import p221d9.C9056d;
import p292fn.C9733f;
import p362i9.C10454a;
import p362i9.C10456c;
import p399jk.AbstractC10896a;
import p454lj.C11291n;
import p495nm.C11720a;
import p514o9.C11829c;
import p514o9.C11839m;
import p550pb.C12126b;
import p572qb.C12299b;
import p616rk.C12515a;
import p618rm.C12574n;
import p618rm.C12585q1;
import p618rm.C12590s0;
import p674ub.C13146c;
import p709vj.C13452e;
import p711vl.C13462b;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p766x8.C13729h;
import p766x8.C13730i;
import p780xm.C13834f;

/* renamed from: zk.d */
/* loaded from: classes6.dex */
public class C14311d {

    /* renamed from: zk.d$a */
    public class a extends TimerTask {

        /* renamed from: a */
        public final /* synthetic */ List f63567a;

        public a(List list) {
            this.f63567a = list;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C11839m.m70688i("CloudBackupManager", "retryAppReport: task start.");
            ReportAppMarketManager.getInstance().installEvent(this.f63567a);
        }
    }

    /* renamed from: zk.d$b */
    public static final class b {

        /* renamed from: a */
        public static C14311d f63569a = new C14311d(null);
    }

    public /* synthetic */ C14311d(a aVar) {
        this();
    }

    /* renamed from: g */
    public static C14311d m85230g() {
        return b.f63569a;
    }

    /* renamed from: i */
    public static /* synthetic */ Void m85231i(Context context) throws Exception {
        if (!C10028c.m62182c0().m62221H1()) {
            C11839m.m70686d("CloudBackupManager", "checkDozeWhiteList not agree!");
            return null;
        }
        if (context == null || C9733f.m60705z().m60720O("disableDozeOptimization")) {
            C11839m.m70686d("CloudBackupManager", "checkDozeWhiteList close switch closed!");
            return null;
        }
        String[] strArrM1556k = C0224k0.m1556k();
        if (strArrM1556k == null || !Arrays.asList(strArrM1556k).contains(context.getPackageName())) {
            C0224k0.m1547b(context.getPackageName());
        }
        return null;
    }

    /* renamed from: j */
    public static /* synthetic */ Void m85232j() throws Exception {
        Mission.get().forEach(new Consumer() { // from class: zk.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Mission) obj).m15614k0();
            }
        });
        return null;
    }

    /* renamed from: c */
    public final void m85233c() {
        if (TextUtils.isEmpty(C10028c.m62183d0(C0213f.m1377a()).m62398u())) {
            return;
        }
        C12515a.m75110o().m75175e(new C10454a(), true);
    }

    /* renamed from: d */
    public final void m85234d() {
        AbstractC10896a.m65887i("CloudBackupManager", "checkDozeWhiteList");
        if (C0209d.m1269j1()) {
            AbstractC10896a.m65885d("CloudBackupManager", "checkDozeWhiteList isHonorProduct");
        } else {
            final Context contextM1377a = C0213f.m1377a();
            C13834f.m82974k(new Callable() { // from class: zk.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C14311d.m85231i(contextM1377a);
                }
            }, null);
        }
    }

    /* renamed from: e */
    public final void m85235e() {
        boolean zIsSpaceNotifyTimerStart = NotifyTimerSpManager.getInstance().isSpaceNotifyTimerStart();
        boolean zIsAutoBackupNotifyTimerStart = NotifyTimerSpManager.getInstance().isAutoBackupNotifyTimerStart();
        if (zIsSpaceNotifyTimerStart || zIsAutoBackupNotifyTimerStart) {
            C11839m.m70687e("CloudBackupManager", "need check notify timer");
            C12515a.m75110o().m75172d(new C10456c());
        }
    }

    /* renamed from: f */
    public void m85236f(Context context, boolean z10) {
        C11839m.m70688i("CloudBackupManager", "cleanCache");
        C14315h.m85262p().m85277i(context, z10, true);
        C14315h.m85262p();
        C14315h.m85260l(context);
        C12574n.m75552e(context);
    }

    /* renamed from: h */
    public void m85237h(Context context) {
        if (!C0209d.m1309t1(context)) {
            if (C0209d.m1214U0(context)) {
                m85234d();
                C13466f.m81073d().m81080h(context);
                CloudSpaceNotifyUtil.getInstance().init(context);
                CloudSpaceNotifyUtil.getInstance().setSpaceProxy(new C13729h());
                C13834f.m82974k(new Callable() { // from class: zk.a
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return C14311d.m85232j();
                    }
                }, null);
                C12590s0.m75771M0("DsProcessInit");
                return;
            }
            return;
        }
        m85234d();
        C13466f.m81073d().m81080h(context);
        C13467g.m81086c().m81092g(context);
        C13465e.m81052f().m81063l(context);
        ReportAppMarketFailedSp.getInstance().init(context);
        C13462b.m81015c().m81019e(context);
        if (C13466f.m81073d().m81078f("first_record_into_backup_time", -1L) <= 0) {
            C13466f.m81073d().m81083k("first_record_into_backup_time", System.currentTimeMillis());
        }
        C14315h.m85262p().m85281r(C13452e.m80781L().m80887a1(), C13452e.m80781L().m80790C());
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62403v = c10028cM62182c0.m62403v("funcfg_cloud_backup", true);
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        if (!zM62403v && zM62388s) {
            C11839m.m70689w("CloudBackupManager", "not support cloud backup, but switch is open, close it");
            C14315h.m85262p().m85278n();
            zM62388s = false;
        }
        CloudBackupJobManager.getInstance().syncDataToDS(false);
        if (zM62388s) {
            C14315h.m85262p().m85272K(true);
            C13466f.m81073d().m81081i("backup_key", true);
            int iM1685c = C0241z.m1685c(C1443a.f6213a);
            int iM62190B0 = c10028cM62182c0.m62190B0("no_sticky_version_code");
            boolean z10 = C13466f.m81073d().m81075b("lastsuccesstime", false) || C12299b.m73921c("lastsuccesstime");
            if (z10) {
                C13466f.m81073d().m81081i("lastsuccesstime", true);
            }
            C11839m.m70688i("CloudBackupManager", "currentVersionCode = " + iM1685c + " lastVersionCode = " + iM62190B0 + ", dsSpContainsValue: " + z10);
            if (iM1685c != iM62190B0 || !z10) {
                CloudBackupJobManager.getInstance().syncDataToDS(true);
                c10028cM62182c0.m62387r3("no_sticky_version_code", iM1685c);
                C12515a.m75110o().m75172d(new ReadOmConfigFileTask());
            }
            if (C11829c.m70611r0()) {
                CloudBackupJobManager.getInstance().startService();
                if (C0219i.m1463a() >= 23) {
                    CloudBackupJobManager.getInstance().unRegisterAllScheduler();
                }
            } else {
                CloudBackupJobManager.getInstance().stopService();
                CloudBackupJobManager.getInstance().registerAllBackupScheduler();
            }
            CloudBackupJobManager.getInstance().registerTimeWindowScheduler();
        }
        m85244q(context);
        C11720a.m69921a().m69923c();
        C12585q1.m75696f();
        AccountBroadcastManager.m15536m().m15548n();
        ConfigBroadcastManager.m15597a().m15598b();
        m85235e();
        m85238k();
        CloudSpaceNotifyUtil.getInstance().init(context);
        CloudSpaceNotifyUtil.getInstance().setBackupNotifyProxy(new C13146c());
        CloudSpaceNotifyHelper.setNotifyProxy(new C11291n());
        CloudSpaceNotifyUtil.getInstance().setSpaceProxy(new C13729h());
        NoticeFreqControlManager.getInstance().setSpaceProxy(new C13729h());
        HiCloudAllOMConfigManager.getInstance().initConfigProxy(new C13730i());
        ICBBroadcastManager.registerBroadcastReceiver(context);
        m85242o(context);
        C12126b.m72705a(context);
        m85233c();
        m85239l(context);
        if (C13452e.m80781L().m80842P0() && C10028c.m62183d0(context).m62221H1()) {
            InterfaceC10020c.get().mo62163b(new C4972b(0, ""));
        } else {
            C11839m.m70689w("CloudBackupManager", "user not login or agree terms");
            C11074k.m66694P(0, 1, "user not login or agree terms");
        }
        C12590s0.m75771M0("MainProcessInit");
    }

    /* renamed from: k */
    public final void m85238k() {
        C11500d.m68648g().m68659l(new C9054b());
        C11500d.m68648g().m68659l(new C9056d());
        C11500d.m68648g().m68659l(new C9053a());
        C11500d.m68648g().m68659l(new C9055c());
    }

    /* renamed from: l */
    public final void m85239l(Context context) {
        boolean zCheckNotifyInterval = RestoreNotifyUtil.getInstance().checkNotifyInterval(context);
        C11839m.m70686d("CloudBackupManager", "isValidInterval: " + zCheckNotifyInterval);
        if (zCheckNotifyInterval) {
            C12515a.m75110o().m75175e(new C3052k2(context, 3), false);
        }
    }

    /* renamed from: m */
    public void m85240m(Context context) {
        C14315h.m85262p().m85277i(context, true, true);
        C14315h.m85262p();
        C14315h.m85260l(context);
        C12574n.m75556i(context);
    }

    /* renamed from: n */
    public final void m85241n(Context context) {
        if (!RestoreUtil.isAppMarketSupportedReport(context)) {
            C11839m.m70686d("CloudBackupManager", "retryAppReport: app market not supported!");
            return;
        }
        List<ReportAppMarketInfo> reportInfoAll = ReportAppMarketFailedSp.getInstance().getReportInfoAll();
        if (reportInfoAll == null || reportInfoAll.isEmpty()) {
            C11839m.m70686d("CloudBackupManager", "retryAppReport: reportInfoList is null or empty!");
            return;
        }
        int iM1260h0 = C0209d.m1260h0(0, C5843a0.f26297c);
        C11839m.m70686d("CloudBackupManager", "retryAppReport: randomTime(ms)=" + iM1260h0);
        new Timer().schedule(new a(reportInfoAll), (long) iM1260h0);
    }

    /* renamed from: o */
    public final void m85242o(Context context) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if ((!C0209d.m1166E1() && !ModuleConfigUtil.getInstance().isLocalVersion()) || !C2783d.m16107S()) {
            C11839m.m70688i("CloudBackupManager", "isPrivacyUser or Rom is not China region, disable BackupMainforSettingActivity");
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) BackupMainforSettingActivity.class), 2, 1);
        } else if (C0209d.m1166E1() && !ModuleConfigUtil.getInstance().isLocalVersion() && c10028cM62182c0.m62388s("backup_key")) {
            C11839m.m70688i("CloudBackupManager", "cloud backup is open. disable BackupMainforSettingActivity");
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) BackupMainforSettingActivity.class), 2, 1);
        }
    }

    /* renamed from: p */
    public final void m85243p() {
        if (C13467g.m81086c().m81087a("backup_setting_data_transfer", false)) {
            C11839m.m70688i("CloudBackupManager", "transferBackupSettingsRecord , isTransfer = true , return ");
            return;
        }
        C13467g.m81086c().m81094i("user_number_of_backup_record", C13466f.m81073d().m81077e("user_number_of_backup_record", -1));
        C13467g.m81086c().m81093h("backup_setting_data_transfer", true);
    }

    /* renamed from: q */
    public final void m85244q(Context context) {
        C14317j.m85300d().m85307h();
        C14315h.m85262p().m85264B(context);
        m85243p();
        TransferedUtil.transferData();
        m85241n(context);
    }

    public C14311d() {
    }
}
