package p847zk;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupUserPackageHelper;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.cloud.pay.model.TrxReq;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import gl.C9964e;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mk.C11476b;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p315gj.C9948a;
import p336he.C10152c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p572qb.C12299b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12574n;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12598v;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13461a;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p744wl.C13617a;
import p746wn.C13622a;
import p814yl.C13998b0;
import pm.C12176c;
import sl.C12811b;
import sl.C12812c;
import sl.C12815f;
import sl.C12816g;
import tl.C13026e;
import tl.C13030i;
import vn.C13471c;

/* renamed from: zk.h */
/* loaded from: classes6.dex */
public class C14315h {

    /* renamed from: a */
    public static ExecutorService f63577a = Executors.newFixedThreadPool(1);

    /* renamed from: zk.h$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String strM66627b = C11058a.m66627b("02004");
            if (C10028c.m62182c0().m62335h1()) {
                C11839m.m70688i("CloudBackupOperator", "open backup switch, get bak Strategy");
                About aboutM84137z = new C13998b0().m84137z("gradeCode,uploadTargetStrategy", strM66627b);
                C12176c.m73270m(aboutM84137z);
                C12176c.m73264f(aboutM84137z, strM66627b);
            }
            C14315h.m85248N(strM66627b);
        }
    }

    /* renamed from: zk.h$b */
    public static final class b {

        /* renamed from: a */
        public static C14315h f63579a = new C14315h(null);
    }

    public /* synthetic */ C14315h(a aVar) {
        this();
    }

    /* renamed from: I */
    public static void m85246I() {
        try {
            C13030i c13030i = new C13030i();
            boolean zM75941k = C12591s1.m75931a().m75941k();
            C11839m.m70686d("CloudBackupOperator", "sendCloudBackupStateBroadCast isRefurbishing: " + zM75941k);
            if (zM75941k) {
                ICBBroadcastManager.sendCancelCloudBackupStateBroadcast(1, CloudBackupStateUtil.getBroadcastId(1));
            }
            if (c13030i.m78495f(3) == null || !CBAccess.inRestore()) {
                return;
            }
            ICBBroadcastManager.sendCancelCloudBackupStateBroadcast(2, CloudBackupStateUtil.getBroadcastId(2));
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupOperator", "queryTag error: " + e10.getMessage());
        }
    }

    /* renamed from: M */
    public static void m85247M(boolean z10, int i10, boolean z11) {
        if (z10) {
            CloudBackupJobManager.getInstance().unRegisterNotifyScheduler();
        } else {
            if (i10 > 0) {
                if (z11) {
                    CBAccess.manualAbort(i10);
                } else {
                    CBAccess.abortBackupOnly(i10);
                }
            }
            CloudBackupJobManager.getInstance().stopService();
            CloudBackupJobManager.getInstance().unRegisterAllScheduler();
        }
        CloudBackupJobManager.getInstance().unRegisterBackupCacheScheduler();
        CloudBackupJobManager.getInstance().unRegisterTimeWindowScheduler();
    }

    /* renamed from: N */
    public static void m85248N(String str) {
        String strM81079g = C13466f.m81073d().m81079g("gradeCode", "");
        if (strM81079g.isEmpty()) {
            C11839m.m70688i("CloudBackupOperator", "get gradeCode last is empty.");
            return;
        }
        int iM81089d = C13467g.m81086c().m81089d("isFirstQueryTrans", -1);
        if (iM81089d != -1) {
            C11839m.m70688i("CloudBackupOperator", "has already queried transaction items and queryTags is: " + iM81089d);
            return;
        }
        if (!C12590s0.m75828a1(strM81079g)) {
            C11839m.m70688i("CloudBackupOperator", "query transaction items of member is vip: " + strM81079g);
            return;
        }
        C11839m.m70686d("CloudBackupOperator", "query transaction items result: " + iM81089d + ", grade code: " + strM81079g);
        C11060c c11060c = new C11060c();
        c11060c.m66643I(str);
        try {
            if (!C9948a.m61631C().m61675i0(new TrxReq("4.0"), c11060c).isEmpty()) {
                C11839m.m70688i("CloudBackupOperator", "query transaction items not empty.");
                m85251R(1);
            } else {
                C11839m.m70688i("CloudBackupOperator", "query transaction items is empty.");
                new C13026e().m78385f();
                m85251R(0);
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupOperator", "query transaction items error: " + e10.toString());
        }
    }

    /* renamed from: O */
    public static void m85249O(boolean z10) {
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            z10 = false;
        } else if (C13452e.m80781L().m80791C0()) {
            z10 = true;
        }
        C10028c.m62182c0().m62407v3(z10);
    }

    /* renamed from: P */
    public static void m85250P() {
        C10028c.m62182c0().m62240L2(C10028c.m62182c0().m62388s("backup_key"));
    }

    /* renamed from: R */
    public static void m85251R(int i10) {
        C13467g.m81086c().m81094i("isFirstQueryTrans", i10);
    }

    /* renamed from: f */
    public static void m85256f(Context context) {
        C13466f.m81073d().m81074a();
        C10152c.m63218b(context);
        C9964e.m61814f().m61820g();
        C13465e.m81052f().m81053a();
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "backup_clone_app_sp", 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().clear().apply();
        }
    }

    /* renamed from: g */
    public static void m85257g() {
        C13467g.m81086c().m81094i("user_number_of_backup_record", -1);
        C13467g.m81086c().m81094i("about_number_of_backup_record", CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS.intValue());
    }

    /* renamed from: j */
    public static void m85258j(Context context) {
        C11963c.m71950e();
        BackupCacheRecord.clear(context);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().remove(NotifyConstants.BackupNotificationType.SP_BACKUP_NOT_COMPLETE_NOTIFY_FLAG).apply();
        }
    }

    /* renamed from: k */
    public static void m85259k(Context context) {
        m85256f(context);
        C12299b.m73919a(context);
        C13461a.m81002d(context).m81003a();
    }

    /* renamed from: l */
    public static void m85260l(Context context) {
        m85261m();
        C13617a.m81933o();
        C13617a.m81932n(true);
        C12574n.m75558k(context);
        C12574n.m75558k(C0213f.m1378b());
    }

    /* renamed from: m */
    public static void m85261m() {
        RestoreProgress.clearCache();
        C13452e.m80781L().m80890b();
    }

    /* renamed from: p */
    public static C14315h m85262p() {
        return b.f63579a;
    }

    /* renamed from: A */
    public final void m85263A(Context context) throws IOException, SQLException {
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean zM81087a = C13467g.m81086c().m81087a("cloud_backup_upgrade_v3", false);
        if (!zM62221H1 || zM81087a) {
            return;
        }
        C13026e c13026e = new C13026e();
        if (c13026e.m78393n()) {
            File fileM63441g = C10278a.m63441g(context.getFilesDir(), "HiCloudAppFiles.json");
            if (fileM63441g.exists()) {
                C11839m.m70688i("CloudBackupOperator", "onDatabaseSettingUpgrade data migration start.");
                try {
                    new QueryOmAppBackupScopeTask().parseBackupConfig(C10279b.m63452a(fileM63441g));
                } catch (C9721b e10) {
                    C11839m.m70687e("CloudBackupOperator", "onDatabaseSettingUpgrade data migration error: " + e10.getMessage());
                }
                C11839m.m70688i("CloudBackupOperator", "onDatabaseSettingUpgrade data migration end.");
            }
            C11839m.m70688i("CloudBackupOperator", "update item data3 = 1");
            c13026e.m78375J();
            ArrayList arrayList = new ArrayList();
            BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(HNConstants.DataType.CONTACT, false);
            if (backupOptionItemQueryItem != null) {
                backupOptionItemQueryItem.setParent(HNConstants.DataType.CONTACT);
                arrayList.add(backupOptionItemQueryItem);
            }
            BackupOptionItem backupOptionItemQueryItem2 = TransferedUtil.queryItem("calendar", false);
            if (backupOptionItemQueryItem2 != null) {
                backupOptionItemQueryItem2.setParent("calendar");
                arrayList.add(backupOptionItemQueryItem2);
            }
            BackupOptionItem backupOptionItemQueryItem3 = TransferedUtil.queryItem("Memo", false);
            if (backupOptionItemQueryItem3 != null) {
                backupOptionItemQueryItem3.setParent("Memo");
                arrayList.add(backupOptionItemQueryItem3);
            }
            BackupOptionItem backupOptionItemQueryItem4 = TransferedUtil.queryItem("harassment", false);
            if (backupOptionItemQueryItem4 != null) {
                backupOptionItemQueryItem4.setParent("baseData");
                backupOptionItemQueryItem4.setBackupSwitch(true);
                arrayList.add(backupOptionItemQueryItem4);
            }
            try {
                c13026e.m78383d(arrayList);
            } catch (C9721b e11) {
                C11839m.m70687e("CloudBackupOperator", "batch replace items error: " + e11.getMessage());
            }
            C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false));
        }
        C13467g.m81086c().m81093h("cloud_backup_upgrade_v3", true);
    }

    /* renamed from: B */
    public void m85264B(final Context context) {
        m85280q();
        f63577a.execute(new Runnable() { // from class: zk.g
            @Override // java.lang.Runnable
            public final void run() throws IOException, SQLException {
                this.f63575a.m85284u(context);
            }
        });
    }

    /* renamed from: C */
    public void m85265C() {
        if (C13467g.m81086c().m81087a("cloud_backup_upgrade_app_twin_db", false)) {
            return;
        }
        C11839m.m70688i("CloudBackupOperator", "onUpgradeAppTwin start");
        new C13026e(false, false).m78396t();
        new C12815f(false, null).m76927f();
        new C12816g(false).m76939c();
        new C12812c(false).m76885d();
        new C12811b(false).m76878c();
        C13467g.m81086c().m81093h("cloud_backup_upgrade_app_twin_db", true);
        C11839m.m70688i("CloudBackupOperator", "onUpgradeAppTwin end");
    }

    /* renamed from: D */
    public final void m85266D() {
        if (!C13466f.m81073d().m81075b("isAboutRequestCalled", false)) {
            try {
                new C12176c().m73272a(C11058a.m66627b("02101"));
                return;
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupOperator", "first upgrade query about error. " + e10.toString());
                return;
            }
        }
        if (C13466f.m81073d().m81075b("isAboutRefurbishRequestCalled", false)) {
            return;
        }
        C11839m.m70688i("CloudBackupOperator", "onUpgradeQueryAbout about request");
        try {
            C12176c.m73269l(new C13998b0().m84137z("refEffeDays,refEffeDelayDays", C11058a.m66627b("02101")));
            C13466f.m81073d().m81081i("isAboutRefurbishRequestCalled", true);
        } catch (C9721b e11) {
            C11839m.m70687e("CloudBackupOperator", "onUpgradeQueryAbout upgrade query about error. " + e11.toString());
        }
    }

    /* renamed from: E */
    public final void m85267E() {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0) || !C11476b.m68626h(strM80971t0).equals(C13467g.m81086c().m81090e("backup_sha_id", ""))) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backup_frequency", Integer.valueOf(C13467g.m81086c().m81091f()));
        C12299b.m73929k(contentValues, "backupUserFrequency");
        C11839m.m70688i("CloudBackupOperator", "userId is same, update to ds");
    }

    /* renamed from: F */
    public final void m85268F() {
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: G */
    public final void m85269G(boolean z10) {
        String strM66627b = C11058a.m66627b(z10 ? "02004" : "02005");
        String str = z10 ? "open cloudbackup" : "close cloudbackup";
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "CloudBackup_Switch", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66635A(str);
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66664t("success");
        C13622a.m81970p(c11060cM66626a, null, false);
    }

    /* renamed from: H */
    public final void m85270H(boolean z10, boolean z11) {
        String strM66627b = C11058a.m66627b(z10 ? "02107" : "02108");
        String str = z10 ? "open cloudbackup" : "close cloudbackup";
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, z11 ? "CloudBackup_Base_Switch" : "CloudBackup_Full_Switch", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66635A(str);
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66668x("1");
        C13622a.m81970p(c11060cM66626a, null, false);
    }

    /* renamed from: J */
    public void m85271J(boolean z10) {
        if (ICBUtil.checkPrivacyUser(C0213f.m1377a())) {
            m85278n();
            return;
        }
        if (C0209d.m1293p1()) {
            m85278n();
            return;
        }
        String strM80790C = C13452e.m80781L().m80790C();
        boolean zM62186A1 = C10028c.m62182c0().m62186A1();
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        C11839m.m70688i("CloudBackupOperator", "cloud base backup checked change, result = " + z10 + " ,fullOpen: " + zM62186A1 + " ,baseOpen: " + zM62303a1 + " ,gradeCode: " + strM80790C);
        if (z10 == zM62303a1) {
            C11839m.m70688i("CloudBackupOperator", "cloud base backup switch status not change");
            return;
        }
        C10028c.m62182c0().m62351k2(z10);
        m85249O(z10);
        m85250P();
        C12299b.m73928j("base_backup_new_key", Boolean.valueOf(z10));
        C13225d c13225dM79490f1 = C13225d.m79490f1();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CloudBackupOperator");
        sb2.append(z10 ? ": open base" : ": close base");
        c13225dM79490f1.m79597u0(sb2.toString(), C13471c.f.BASE_SWITCH, z10);
        C12299b.m73932n("CACHED_GRADE_CODE", strM80790C);
        C14317j.m85300d().m85319t();
        m85270H(z10, true);
    }

    /* renamed from: K */
    public boolean m85272K(boolean z10) {
        return m85273L(z10, true);
    }

    /* renamed from: L */
    public boolean m85273L(boolean z10, boolean z11) {
        if (ICBUtil.checkPrivacyUser(C0213f.m1377a())) {
            m85274Q(false);
            return false;
        }
        if (C0209d.m1293p1()) {
            m85274Q(false);
            return false;
        }
        C11839m.m70688i("CloudBackupOperator", "cloud backup checked change, result = " + z10);
        if (z10 == C10028c.m62182c0().m62388s("backup_key")) {
            return true;
        }
        m85274Q(z10);
        if (z10) {
            C11839m.m70688i("CloudBackupOperator", "cloud backup checked change, open full and base switch.");
            SettingOperator settingOperator = new SettingOperator();
            String strValueOf = String.valueOf(System.currentTimeMillis());
            settingOperator.replace(new Settings[]{new Settings("lastnotifytime", strValueOf, "2"), new Settings("lastbackuptime", strValueOf, "2"), new Settings("backupswitchtime", strValueOf, "2")});
            m85267E();
            if (C11829c.m70611r0()) {
                CloudBackupJobManager.getInstance().startService();
            } else {
                CloudBackupJobManager.getInstance().registerAllBackupScheduler();
            }
            CloudBackupJobManager.getInstance().registerTimeWindowScheduler();
            m85268F();
        } else {
            C12598v.m76039g(CloudBackupConstant.REPORT_TYPE_OLD_BACKUP_SWITCH_CLOSE);
            m85276h(C0213f.m1377a(), z11);
        }
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        m85249O(zM62303a1);
        m85250P();
        if (C13452e.m80781L().m80887a1()) {
            m85270H(zM62303a1, true);
            m85270H(z10, false);
        }
        C14317j.m85300d().m85319t();
        m85269G(z10);
        return true;
    }

    /* renamed from: Q */
    public final void m85274Q(boolean z10) {
        C13466f.m81073d().m81081i("backup_key", z10);
        C10028c.m62182c0().m62336h2("backup_key", z10);
        C12299b.m73934p(z10);
        if (z10) {
            C12590s0.m75809V2("OpenBackupSwitch");
        } else {
            C11839m.m70688i("CloudBackupOperator", "updateSwitch isChecked false, close full and base switch.");
        }
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        m85249O(zM62303a1);
        m85250P();
        if (C13452e.m80781L().m80887a1()) {
            m85270H(zM62303a1, true);
            m85270H(z10, false);
        }
    }

    /* renamed from: e */
    public final void m85275e(final boolean z10, final boolean z11) {
        m85280q();
        f63577a.execute(new Runnable() { // from class: zk.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f63572a.m85282s(z10, z11);
            }
        });
    }

    /* renamed from: h */
    public void m85276h(Context context, boolean z10) {
        boolean zHasValidTempBackup = CBAccess.hasValidTempBackup();
        m85247M(zHasValidTempBackup, PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED, z10);
        if (!zHasValidTempBackup) {
            m85256f(context);
            BackupNotification.getInstance().cancelBackupNotification();
        }
        m85275e(zHasValidTempBackup, z10);
    }

    /* renamed from: i */
    public void m85277i(Context context, boolean z10, boolean z11) {
        C11839m.m70688i("CloudBackupOperator", "deleteBackup: " + z10 + " ,isCloseRestoreSnapshot: " + z11);
        if (z10) {
            m85258j(context);
        }
        C13617a.m81927i(z10);
        C13617a.m81920b(z10, z11);
        C12574n.m75553f(context, z10);
        C12574n.m75553f(C0213f.m1378b(), z10);
    }

    /* renamed from: n */
    public void m85278n() {
        CloudBackupService.getInstance().cancelTempBackup("delete_single_from_backup_disable");
        m85272K(false);
    }

    /* renamed from: o */
    public void m85279o(final Context context) {
        C11839m.m70688i("CloudBackupOperator", "CloudBackupOperator exit start");
        BackupNotification.getInstance().cancelBackupNotification();
        m85246I();
        C12590s0.m75749G2();
        m85280q();
        f63577a.execute(new Runnable() { // from class: zk.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f63570a.m85283t(context);
            }
        });
        m85247M(false, 1001, true);
        m85259k(context);
        m85257g();
        C12574n.m75556i(context);
        ICBBroadcastManager.sendCancelRestoreBroadcast(context);
        DeviceIconManager.getInstance().clearCache();
        CloudBackupUserPackageHelper.clearCache();
        C11839m.m70688i("CloudBackupOperator", "CloudBackupOperator exit end");
    }

    /* renamed from: q */
    public final synchronized void m85280q() {
        try {
            if (f63577a.isShutdown() || f63577a.isTerminated()) {
                f63577a = Executors.newFixedThreadPool(1);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: r */
    public void m85281r(boolean z10, String str) {
        C11839m.m70686d("CloudBackupOperator", "initNewBmTypeBackupSwitch isNewBmType:" + z10 + " gradeCode:" + str);
        C10028c.m62182c0().m62333h();
    }

    /* renamed from: s */
    public final /* synthetic */ void m85282s(boolean z10, boolean z11) {
        SystemClock.sleep(500L);
        m85277i(C0213f.m1377a(), !z10, z11);
    }

    /* renamed from: t */
    public final /* synthetic */ void m85283t(Context context) {
        C11839m.m70688i("CloudBackupOperator", "Executor service exit start");
        m85277i(context, true, true);
        m85260l(context);
        C13617a.m81928j();
        C11839m.m70688i("CloudBackupOperator", "Executor service exit end");
    }

    /* renamed from: u */
    public final /* synthetic */ void m85284u(Context context) throws IOException, SQLException {
        m85266D();
        m85288y(context);
        m85289z(context);
        m85265C();
        m85263A(context);
        m85287x(context);
    }

    /* renamed from: v */
    public final void m85285v(Context context, String str) throws IOException, SQLException {
        StringBuilder sb2;
        File fileM63441g = C10278a.m63441g(context.getFilesDir(), "HiCloudAppFiles.json");
        if (fileM63441g.exists()) {
            C11839m.m70688i("CloudBackupOperator", "onDatabaseSettingUpgrade data migration start.");
            try {
                new QueryOmAppBackupScopeTask().parseBackupConfig(C10279b.m63452a(fileM63441g));
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupOperator", "onDatabaseSettingUpgrade data migration error: " + e10.getMessage());
            }
            C11839m.m70688i("CloudBackupOperator", "onDatabaseSettingUpgrade data migration end.");
        }
        SettingOperator settingOperator = new SettingOperator();
        try {
            try {
                settingOperator.attach(str);
                settingOperator.transfer();
                try {
                    settingOperator.detach();
                } catch (C9721b e11) {
                    e = e11;
                    sb2 = new StringBuilder();
                    sb2.append("onDatabaseSettingUpgrade detach error.");
                    sb2.append(e.toString());
                    C11839m.m70689w("CloudBackupOperator", sb2.toString());
                }
            } catch (C9721b e12) {
                C11839m.m70689w("CloudBackupOperator", "onDatabaseSettingUpgrade error." + e12.toString());
                try {
                    settingOperator.detach();
                } catch (C9721b e13) {
                    e = e13;
                    sb2 = new StringBuilder();
                    sb2.append("onDatabaseSettingUpgrade detach error.");
                    sb2.append(e.toString());
                    C11839m.m70689w("CloudBackupOperator", sb2.toString());
                }
            }
        } catch (Throwable th2) {
            try {
                settingOperator.detach();
            } catch (C9721b e14) {
                C11839m.m70689w("CloudBackupOperator", "onDatabaseSettingUpgrade detach error." + e14.toString());
            }
            throw th2;
        }
    }

    /* renamed from: w */
    public final void m85286w(String str) throws SQLException {
        StringBuilder sb2;
        C13030i c13030i = new C13030i();
        try {
            try {
                c13030i.attach(str);
                c13030i.transfer();
                try {
                    c13030i.detach();
                } catch (C9721b e10) {
                    e = e10;
                    sb2 = new StringBuilder();
                    sb2.append("onDatabaseTagUpgrade detach error.");
                    sb2.append(e.toString());
                    C11839m.m70689w("CloudBackupOperator", sb2.toString());
                }
            } catch (C9721b e11) {
                C11839m.m70689w("CloudBackupOperator", "onDatabaseTagUpgrade error." + e11.toString());
                try {
                    c13030i.detach();
                } catch (C9721b e12) {
                    e = e12;
                    sb2 = new StringBuilder();
                    sb2.append("onDatabaseTagUpgrade detach error.");
                    sb2.append(e.toString());
                    C11839m.m70689w("CloudBackupOperator", sb2.toString());
                }
            }
        } catch (Throwable th2) {
            try {
                c13030i.detach();
            } catch (C9721b e13) {
                C11839m.m70689w("CloudBackupOperator", "onDatabaseTagUpgrade detach error." + e13.toString());
            }
            throw th2;
        }
    }

    /* renamed from: x */
    public final void m85287x(Context context) throws IOException, SQLException {
        boolean zM81087a = C13467g.m81086c().m81087a("backup_config_parse", false);
        C11839m.m70688i("CloudBackupOperator", "onDatabaseUpgradeForParse  upgrade: " + zM81087a);
        if (zM81087a) {
            return;
        }
        File fileM63441g = C10278a.m63441g(context.getFilesDir(), "HiCloudAppFiles.json");
        if (fileM63441g.exists()) {
            C11839m.m70688i("CloudBackupOperator", "onDatabaseUpgradeForParse data migration start.");
            try {
                new QueryOmAppBackupScopeTask().parseBackupConfig(C10279b.m63452a(fileM63441g));
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupOperator", "onDatabaseUpgradeForParse data migration error: " + e10.getMessage());
            }
            C11839m.m70688i("CloudBackupOperator", "onDatabaseUpgradeForParse data migration end.");
            C13467g.m81086c().m81093h("backup_config_parse", true);
        }
    }

    /* renamed from: y */
    public final void m85288y(Context context) throws IOException, SQLException {
        File[] fileArrListFiles;
        if (C13467g.m81086c().m81087a("cloud_backup_upgrade", false)) {
            return;
        }
        File databasePath = context.createDeviceProtectedStorageContext().getDatabasePath("hicloudbackup.db");
        if (databasePath != null && databasePath.exists()) {
            m85285v(context, databasePath.getPath());
            m85286w(databasePath.getPath());
            if (databasePath.delete() && (fileArrListFiles = databasePath.getParentFile().listFiles()) != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    if (file.exists() && file.isFile() && file.getName().startsWith("hicloudbackup.db")) {
                        C11839m.m70686d("CloudBackupOperator", "journal delete success = " + file.delete());
                    }
                }
            }
        }
        C13467g.m81086c().m81093h("cloud_backup_upgrade", true);
    }

    /* renamed from: z */
    public final void m85289z(Context context) throws IOException, SQLException {
        File[] fileArrListFiles;
        if (C13467g.m81086c().m81087a("cloud_backup_upgrade_v2", false)) {
            return;
        }
        File databasePath = context.createDeviceProtectedStorageContext().getDatabasePath("cloudbackup_setting.db");
        if (databasePath != null && databasePath.exists()) {
            m85285v(context, databasePath.getPath());
            CloudBackupJobManager.getInstance().syncDataToDS(true);
            if (databasePath.delete() && (fileArrListFiles = databasePath.getParentFile().listFiles()) != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    if (file.exists() && file.isFile() && file.getName().startsWith("cloudbackup_setting.db")) {
                        C11839m.m70686d("CloudBackupOperator", "journal delete success = " + file.delete());
                    }
                }
            }
        }
        C13467g.m81086c().m81093h("cloud_backup_upgrade_v2", true);
    }

    public C14315h() {
    }
}
