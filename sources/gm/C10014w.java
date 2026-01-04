package gm;

import android.content.ContentValues;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import dm.C9195d0;
import fk.C9721b;
import hm.C10321z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p015ak.C0241z;
import p292fn.C9733f;
import p384j4.AbstractC10705d;
import p495nm.C11723d;
import p514o9.C11839m;
import p572qb.C12299b;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p709vj.C13452e;
import p711vl.C13466f;
import p815ym.AbstractC14026a;
import p847zk.C14317j;
import pm.C12176c;
import sl.C12815f;
import tl.C13029h;
import tl.C13030i;

/* renamed from: gm.w */
/* loaded from: classes6.dex */
public class C10014w {

    /* renamed from: a */
    public C4879a f48973a;

    /* renamed from: b */
    public String f48974b;

    /* renamed from: c */
    public boolean f48975c;

    /* renamed from: d */
    public C13029h f48976d;

    /* renamed from: e */
    public List<C11723d> f48977e;

    public C10014w(C4879a c4879a, boolean z10, boolean z11, C13029h c13029h, List<C11723d> list) {
        this.f48977e = new ArrayList();
        this.f48973a = c4879a;
        this.f48974b = c4879a.m29713i0();
        this.f48975c = z11;
        this.f48976d = c13029h;
        this.f48977e = list;
    }

    /* renamed from: a */
    public final String m62159a() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f48973a.m29705f1()) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(2);
        }
        if (this.f48973a.m29699d1()) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(3);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public final long m62160b(Integer num, String str, String str2, String str3, String str4, String str5, long j10) throws C9721b {
        BakFinish bakFinish = new BakFinish();
        bakFinish.setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setIncType(Integer.valueOf(!this.f48975c ? 1 : 0)).setEndTime(new C4644l(System.currentTimeMillis()));
        if (num.intValue() != 0) {
            bakFinish.setBmDataType(num);
        }
        C4644l endTime = new C10321z(str3, this.f48973a.m29636F0(), this.f48973a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, str).m63552O(this.f48973a.m29728n0(), str4, str2, str5, bakFinish, 0).getEndTime();
        if (endTime != null && endTime.m28458c() > 0) {
            return endTime.m28458c();
        }
        C11839m.m70689w("CloudBackupV3Release", "get backup record end time error, return local time");
        return System.currentTimeMillis();
    }

    /* renamed from: c */
    public void m62161c() throws C9721b {
        Iterator<CloudBackupStatus> it;
        boolean z10;
        C12594t1 c12594t1;
        boolean z11;
        C10014w c10014w = this;
        C11839m.m70688i("CloudBackupV3Release", "v3 task release start");
        C12594t1 c12594t1M75990o = C12594t1.m75990o();
        List<CloudBackupStatus> listM76016s = c12594t1M75990o.m76016s(c10014w.f48974b);
        if (AbstractC14026a.m84159a(listM76016s)) {
            throw new C9721b(1036, "backup no module data");
        }
        C12815f c12815f = new C12815f(c10014w.f48974b);
        List arrayList = new ArrayList();
        if (C13452e.m80781L().m80887a1()) {
            arrayList = C12176c.m73271n(null);
        }
        Iterator<CloudBackupStatus> it2 = listM76016s.iterator();
        long jM1685c = 0;
        long jM1688f = 0;
        boolean z12 = false;
        int i10 = 0;
        boolean z13 = true;
        while (it2.hasNext()) {
            CloudBackupStatus next = it2.next();
            String strM29870d = next.m29870d();
            int iM29861N = next.m29861N();
            if ((next.m29863P() || next.m29867U()) && next.m29351H0() == 0) {
                it = it2;
                StringBuilder sb2 = new StringBuilder();
                z10 = z12;
                sb2.append("delete backup meta db, appId = ");
                sb2.append(strM29870d);
                sb2.append(", uid = ");
                sb2.append(iM29861N);
                C11839m.m70688i("CloudBackupV3Release", sb2.toString());
                c12594t1M75990o.m76006f(c10014w.f48976d.m78465h(), strM29870d, iM29861N);
            } else {
                it = it2;
                z10 = z12;
            }
            if (6 != next.m29859L()) {
                C11839m.m70688i("CloudBackupV3Release", "make file not all success. appId = " + strM29870d + ", uid = " + iM29861N);
                new C9195d0(c10014w.f48973a, next).m57757s("module_reset_from_release_not_success_check");
                i10++;
                c12594t1 = c12594t1M75990o;
                z11 = true;
            } else {
                if (next.mo29370Q() && c12815f.m76929h(next.mo29421n(), 0) == null) {
                    C11839m.m70688i("CloudBackupV3Release", "make file mainapp not success. appId = " + strM29870d + ", uid = " + iM29861N + " ,originAppId: " + next.mo29421n());
                }
                c12594t1 = c12594t1M75990o;
                z11 = z10;
            }
            long jM29875i = next.m29875i();
            String strM29368P0 = next.m29368P0();
            jM1688f = jM1688f + jM29875i + C0241z.m1688f(strM29368P0);
            C12815f c12815f2 = c12815f;
            boolean zM29756w1 = c10014w.f48973a.m29756w1();
            C12594t1 c12594t12 = c12594t1;
            String strM29371Q0 = next.m29371Q0();
            boolean z14 = z11;
            String strM29383W0 = next.m29383W0();
            int i11 = i10;
            if (C0241z.m1685c(strM29371Q0) == 1 && !zM29756w1) {
                jM1688f += next.m29874h();
            }
            jM1685c += C0241z.m1685c(strM29383W0);
            if (z13 && jM29875i > 0 && !arrayList.contains(next.m29870d())) {
                z13 = false;
            }
            C11839m.m70686d("CloudBackupV3Release", "module appId: " + strM29870d + " uid = " + next.m29861N() + " dataBytes = " + jM29875i + " data2 = " + strM29368P0 + " data3 = " + strM29371Q0 + " codeByte = " + next.m29874h() + " unStaticSpace = " + zM29756w1 + " vfsModuleSize = " + strM29383W0);
            c10014w = this;
            it2 = it;
            z12 = z14;
            c12815f = c12815f2;
            c12594t1M75990o = c12594t12;
            i10 = i11;
        }
        boolean z15 = z12;
        C11839m.m70688i("CloudBackupV3Release", "release totalSize = " + jM1688f + ",refVfsTotalSize:" + jM1685c);
        C14317j.m85301e(this.f48974b).m85317r(jM1688f);
        if (z15 || jM1688f == 0) {
            throw new C9721b(1018, "make file not all success, count: " + i10 + ", totalSize: " + jM1688f);
        }
        m62162d(jM1685c);
        this.f48973a.isCancel();
        String strM78465h = this.f48976d.m78465h();
        String strM75786Q = C12590s0.m75786Q(this.f48976d);
        String strM78444J = this.f48976d.m78444J();
        int iM75782P = C12590s0.m75782P(this.f48973a.isRefurbishment() || this.f48973a.mo29591n());
        C11839m.m70688i("CloudBackupV3Release", "finish BackupRecord: " + strM78465h + " begin, bmDataType: " + iM75782P);
        long jM62160b = m62160b(Integer.valueOf(iM75782P), strM78444J, strM78465h, this.f48974b, strM75786Q, m62159a(), jM1685c);
        String strValueOf = String.valueOf(jM62160b);
        SettingOperator settingOperator = new SettingOperator();
        Settings settings = new Settings("lastsuccesstime", strValueOf, "2");
        Settings settings2 = new Settings("lastnotifytime", strValueOf, "2");
        Settings settings3 = new Settings("nextbackuptime", "0", "2");
        Settings settings4 = new Settings("lastsuccessbackupid", strM78465h, "2");
        if (this.f48973a.isRefurbishment() || this.f48973a.mo29591n()) {
            settingOperator.replace(new Settings[]{settings3});
            C12299b.m73932n("backupAction", "");
        } else {
            settingOperator.replace(new Settings[]{settings, settings2, settings3, settings4});
        }
        C11839m.m70688i("CloudBackupV3Release", "finish BackupRecord: " + strM78465h + " end, time = " + jM62160b);
        if (C0241z.m1685c(this.f48976d.m78480t()) != 0) {
            C11839m.m70688i("CloudBackupV3Release", "getBackupV3Lock success clear tag flowcontrol count");
            this.f48976d.m78455U(String.valueOf(0));
        }
        this.f48976d.m78447M(jM62160b);
        this.f48976d.m78477r0(4);
        this.f48976d.m78473p0(jM1688f);
        new C13030i().m78496g(this.f48976d);
        this.f48973a.m29722l0().mo1764j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("autobackupblowouttime", (Integer) 0);
        contentValues.put("autobackupstarttime", (Integer) 0);
        C12299b.m73937s(contentValues);
        C11839m.m70688i("CloudBackupV3Release", "save backup cache isSuccess.");
        if (this.f48975c) {
            List<String> cloudControlAction = this.f48973a.m29728n0().mo8329d().getCloudControlAction();
            if (cloudControlAction == null || cloudControlAction.isEmpty() || !cloudControlAction.contains("1")) {
                C11839m.m70688i("CloudBackupV3Release", "not contain full backup action, no need report full backup client action");
            } else {
                C11839m.m70688i("CloudBackupV3Release", "report full backup client action");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("1");
                BakRefresh bakRefresh = new BakRefresh();
                bakRefresh.setAppsUnbacked(AbstractC10705d.m65337C(C12590s0.m75907u(this.f48977e)));
                bakRefresh.setCloudControlAction(arrayList2).setUpdateTime(new C4644l(System.currentTimeMillis()));
                try {
                    new C10321z(this.f48974b, this.f48973a.m29636F0(), this.f48973a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, strM78444J).m63535A0(this.f48973a.m29728n0(), strM75786Q, strM78465h, bakRefresh, 0, null);
                } catch (C9721b e10) {
                    C11839m.m70689w("CloudBackupV3Release", "report full backup client action error." + e10.toString());
                }
            }
        } else {
            BakRefresh bakRefresh2 = new BakRefresh();
            List<HashMap<String, Integer>> listM75907u = C12590s0.m75907u(this.f48977e);
            bakRefresh2.setUpdateTime(new C4644l(System.currentTimeMillis()));
            bakRefresh2.setAppsUnbacked(AbstractC10705d.m65337C(listM75907u));
            try {
                new C10321z(this.f48974b, this.f48973a.m29636F0(), this.f48973a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, strM78444J).m63535A0(this.f48973a.m29728n0(), strM75786Q, strM78465h, bakRefresh2, 0, null);
            } catch (C9721b e11) {
                C11839m.m70689w("CloudBackupV3Release", "report not full backup client action error." + e11.toString());
            }
        }
        C11839m.m70688i("CloudBackupV3Release", "v3 task release end");
    }

    /* renamed from: d */
    public final void m62162d(long j10) {
        int iM60763v = C9733f.m60705z().m60763v("vfsRefStatistics");
        int iM60763v2 = C9733f.m60705z().m60763v("backupVfsRefBypass");
        C11839m.m70688i("CloudBackupV3Release", "vfsRefStatisticSwitch:" + iM60763v + ",backupVfsRefByPass:" + iM60763v2 + ",ignoreVFS：" + this.f48973a.m29705f1());
        if (!this.f48973a.m29705f1() && iM60763v == 0 && iM60763v2 == 0) {
            C11839m.m70688i("CloudBackupV3Release", "no need to saveVfsRefTotalSize.");
        } else {
            C13466f.m81073d().m81083k("vfsRefTotalSize", j10);
        }
    }
}
