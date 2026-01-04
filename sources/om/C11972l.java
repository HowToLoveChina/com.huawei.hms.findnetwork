package om;

import android.os.SystemClock;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import fk.C9721b;
import gp.C10028c;
import java.util.List;
import p015ak.C0213f;
import p514o9.C11839m;
import p571q9.C12294a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p709vj.C13452e;
import p711vl.C13466f;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;

/* renamed from: om.l */
/* loaded from: classes6.dex */
public class C11972l extends AbstractC11971k {

    /* renamed from: m */
    public long f55737m;

    /* renamed from: n */
    public boolean f55738n;

    /* renamed from: om.l$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public final C11972l f55739a;

        public a(C11972l c11972l) {
            this.f55739a = c11972l;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13029h c13029hM78495f;
            C11839m.m70688i("CommonBackupState", "CloudStateInitTask init start");
            C13030i c13030i = new C13030i();
            C13029h c13029hM72072Z = C11972l.m72072Z(c13030i);
            try {
                c13029hM78495f = c13030i.m78495f(3);
            } catch (C9721b e10) {
                C11839m.m70686d("CommonBackupState", "initFirst restoreTags query error: " + e10.getMessage());
                c13029hM78495f = null;
            }
            if (c13029hM78495f != null) {
                this.f55739a.mo72056h(c13029hM78495f, Integer.valueOf(c13029hM78495f.m78441G() == 4 ? 3 : 2), true);
            }
            if (c13029hM72072Z != null) {
                this.f55739a.mo72056h(c13029hM72072Z, Integer.valueOf(c13029hM72072Z.m78441G() != 4 ? 2 : 3), true);
            }
            if (c13029hM72072Z == null && c13029hM78495f == null) {
                C11839m.m70688i("CommonBackupState", "backupTags and restoretags all empty");
                new C13033l().clear();
            }
            C13466f.m81073d().m81081i("isTransferTagsToCloudstate", true);
            C11839m.m70688i("CommonBackupState", "CloudStateInitTask init end");
        }
    }

    /* renamed from: om.l$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public final C11972l f55740a;

        public b(C11972l c11972l) {
            this.f55740a = c11972l;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            long jM72078l0 = this.f55740a.m72078l0();
            if (jM72078l0 <= 0) {
                C11839m.m70688i("CommonBackupState", "GetLastSuccessTimeTask still is 0");
                return;
            }
            this.f55740a.mo72064p(true, 0);
            C11839m.m70688i("CommonBackupState", "GetLastSuccessTimeTask lastSuccessTime: " + jM72078l0);
        }
    }

    /* renamed from: om.l$c */
    public static class c extends AbstractC12367d {

        /* renamed from: a */
        public final C11972l f55741a;

        public c(C11972l c11972l) {
            this.f55741a = c11972l;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("CommonBackupState", "GetWaitBackupSizeTask start");
            for (boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName()); zM75158X0; zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName())) {
                SystemClock.sleep(400L);
            }
            GetOptionsInfoFromCloneTask.checkCacheInvalid();
            long jM69963a = C12590s0.m75923y(true).m69963a();
            if (jM69963a <= 0) {
                C11839m.m70688i("CommonBackupState", "GetWaitBackupSizeTask still is 0");
                return;
            }
            this.f55741a.mo72064p(true, 0);
            C11839m.m70688i("CommonBackupState", "GetWaitBackupSizeTask increase: " + jM69963a);
        }
    }

    /* renamed from: Z */
    public static C13029h m72072Z(C13030i c13030i) {
        C13029h c13029hM78495f = null;
        if (C12591s1.m75931a().m75941k()) {
            try {
                return c13030i.m78495f(4);
            } catch (C9721b e10) {
                C11839m.m70686d("CommonBackupState", "initFirst MANUAL_BACKUP backupTags query error: " + e10.getMessage());
                return null;
            }
        }
        try {
            c13029hM78495f = c13030i.m78495f(1);
        } catch (C9721b e11) {
            C11839m.m70686d("CommonBackupState", "initFirst MANUAL_BACKUP backupTags query error: " + e11.getMessage());
        }
        if (c13029hM78495f != null) {
            return c13029hM78495f;
        }
        try {
            return c13030i.m78495f(2);
        } catch (C9721b e12) {
            C11839m.m70686d("CommonBackupState", "initFirst AUTO_BACKUP backupTags query error: " + e12.getMessage());
            return c13029hM78495f;
        }
    }

    @Override // om.AbstractC11971k
    /* renamed from: E */
    public C13032k mo72026E(boolean z10, boolean z11) {
        C13032k c13032kM78546d = mo72032L().m78546d(1);
        if (c13032kM78546d == null) {
            C11839m.m70689w(mo72029I(), "getBackupStateItem stateItem is null");
        } else if (z10 && c13032kM78546d.m78532p() == 0 && !z11) {
            a aVar = new a(this);
            try {
                C11839m.m70688i("CommonBackupState", "getBackupStateItem check backupstate by tags");
                aVar.call();
                mo72026E(true, true);
            } catch (C9721b e10) {
                C11839m.m70689w("CommonBackupState", "getBackupStateItem error: " + e10.getMessage());
            }
        }
        return c13032kM78546d;
    }

    @Override // om.AbstractC11971k
    /* renamed from: F */
    public int mo72027F() {
        return 3;
    }

    @Override // om.AbstractC11971k
    /* renamed from: G */
    public String mo72028G(BackupItem backupItem, String str) {
        return (C12294a.f56945a && backupItem.m29863P() && !backupItem.m29862O()) ? C0213f.m1377a().getString(R$string.cloud_restore_applist) : str;
    }

    @Override // om.AbstractC11971k
    /* renamed from: I */
    public String mo72029I() {
        return "CommonBackupState";
    }

    @Override // om.AbstractC11971k
    /* renamed from: J */
    public int mo72030J() {
        return 33428;
    }

    @Override // om.AbstractC11971k
    /* renamed from: L */
    public C13033l mo72032L() {
        return new C13033l();
    }

    @Override // om.AbstractC11971k
    /* renamed from: N */
    public void mo72034N() {
        String str = CBSbkFlowHead.BKMODE_MANUAL;
        try {
            if (new C13030i().m78495f(4) != null) {
                str = "Refurbishment";
            }
        } catch (C9721b e10) {
            C11839m.m70686d("CommonBackupState", "get backupAction error, " + e10.getMessage());
        }
        C11963c.m71961p(str);
    }

    @Override // om.AbstractC11971k
    /* renamed from: P */
    public boolean mo72036P() {
        return C10028c.m62182c0().m62388s("backup_key");
    }

    @Override // om.AbstractC11971k
    /* renamed from: Q */
    public boolean mo72037Q() {
        return CBAccess.inBackup();
    }

    @Override // om.AbstractC11971k
    /* renamed from: R */
    public boolean mo72038R() {
        if (CBAccess.inRestoreTask()) {
            return true;
        }
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (iM80916g0 == 0 || iM80916g0 == 8) {
            return false;
        }
        C11839m.m70688i("CommonBackupState", "isInRestore restoreStatus: " + iM80916g0);
        if (iM80916g0 != 3 && iM80916g0 != 5) {
            return true;
        }
        List<CloudRestoreItem> itemList = RestoreUtil.getItemList();
        int failCount = RestoreUtil.getFailCount(0, itemList);
        int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
        return (failCount > 0 && succeedCount > 0) || failCount > 0 || succeedCount <= 0;
    }

    @Override // om.InterfaceC11973m
    /* renamed from: b */
    public CloudBackupState mo72075b() {
        CloudBackupState cloudBackupState = new CloudBackupState();
        m72069x(cloudBackupState);
        m72042X(false, cloudBackupState, true);
        return cloudBackupState;
    }

    @Override // om.InterfaceC11973m
    /* renamed from: c */
    public synchronized boolean mo72076c() {
        return this.f55738n;
    }

    @Override // om.AbstractC11971k, om.InterfaceC11973m
    /* renamed from: e */
    public long mo72050e() {
        return this.f55737m;
    }

    @Override // om.AbstractC11971k
    /* renamed from: e0 */
    public void mo72051e0() {
        C12515a.m75110o().m75172d(new c(this));
    }

    @Override // om.AbstractC11971k
    /* renamed from: f0 */
    public void mo72053f0() {
        C12515a.m75110o().m75172d(new b(this));
    }

    @Override // om.InterfaceC11973m
    public void init() {
        if (C13466f.m81073d().m81075b("isTransferTagsToCloudstate", false)) {
            return;
        }
        C12515a.m75110o().m75172d(new a(this));
    }

    @Override // om.InterfaceC11973m
    /* renamed from: k */
    public synchronized void mo72077k(boolean z10) {
        this.f55738n = z10;
    }

    /* renamed from: l0 */
    public final long m72078l0() {
        long jQuerylastsuccesstime = new SettingOperator().querylastsuccesstime();
        if (jQuerylastsuccesstime != 0 || !C10028c.m62182c0().m62360m1()) {
            return jQuerylastsuccesstime;
        }
        long lastSuccessTime = RestoreUtil.setLastSuccessTime();
        C11839m.m70688i("CommonBackupState", "getLastSuccessTime first get lastsuccesstime = " + lastSuccessTime);
        return lastSuccessTime;
    }

    @Override // om.InterfaceC11973m
    /* renamed from: m */
    public void mo72079m() {
        this.f55722a = new C13033l().m78546d(2);
    }

    @Override // om.AbstractC11971k, om.InterfaceC11973m
    /* renamed from: r */
    public void mo72066r(long j10) {
        this.f55737m = j10;
    }
}
