package dm;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import fk.C9721b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p292fn.C9733f;
import p514o9.C11839m;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p618rm.C12610z0;
import pl.C12165g;
import sl.C12810a;
import sl.C12812c;
import sl.C12815f;
import tl.C13029h;

/* renamed from: dm.r0 */
/* loaded from: classes6.dex */
public class C9251r0 {

    /* renamed from: a */
    public C4879a f46405a;

    /* renamed from: b */
    public List<Bak> f46406b;

    /* renamed from: f */
    public String f46410f;

    /* renamed from: h */
    public String f46412h;

    /* renamed from: i */
    public String f46413i;

    /* renamed from: c */
    public Map<String, SnapshotBackupMeta> f46407c = new HashMap();

    /* renamed from: d */
    public Map<String, SnapshotBackupMeta> f46408d = new HashMap();

    /* renamed from: e */
    public Map<String, SnapshotBackupMeta> f46409e = new HashMap();

    /* renamed from: g */
    public C12594t1 f46411g = C12594t1.m75990o();

    /* renamed from: j */
    public int f46414j = 0;

    /* renamed from: k */
    public int f46415k = 0;

    public C9251r0(C4879a c4879a, C13029h c13029h, String str, String str2) {
        this.f46405a = c4879a;
        this.f46410f = c13029h.m78465h();
        this.f46406b = c4879a.m29646K0();
        this.f46412h = str;
        this.f46413i = str2;
    }

    /* renamed from: a */
    public final void m58089a(String str, String str2, String str3) throws Throwable {
        if (C12590s0.m75873l1(str3)) {
            C11839m.m70688i("CloudBackupV3ModuleStatistic", "v3 record");
            return;
        }
        try {
            C11839m.m70688i("CloudBackupV3ModuleStatistic", "getApkBackupMetaInfoForStatics begin, appId = " + str + ", successBakId = " + str2 + ", version = " + str3);
            SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(".apk");
            SnapshotBackupMeta snapshotBackupMetaQueryAppApkFile = snapshotBackupMetaOperator.queryAppApkFile(str, sb2.toString());
            String hash1 = snapshotBackupMetaQueryAppApkFile.getHash1();
            snapshotBackupMetaQueryAppApkFile.getAppType();
            if (TextUtils.isEmpty(hash1)) {
                return;
            }
            this.f46408d.put(hash1, snapshotBackupMetaQueryAppApkFile);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3ModuleStatistic", "getApkBackupMetaInfoForStatics exception: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public final long m58090b(String str, int i10) {
        C12810a c12810aM76886e = new C12812c().m76886e(str, "apk", i10);
        if (c12810aM76886e != null && !TextUtils.isEmpty(c12810aM76886e.m76859j())) {
            SnapshotBackupMeta snapshotBackupMeta = this.f46408d.get(c12810aM76886e.m76859j());
            if (snapshotBackupMeta != null) {
                return snapshotBackupMeta.getSize();
            }
        }
        return 0L;
    }

    /* renamed from: c */
    public final void m58091c(String str, CloudBackupStatus cloudBackupStatus) throws C9721b {
        C12165g c12165g = new C12165g(this.f46410f, str, 0, cloudBackupStatus.m29861N());
        if (this.f46405a.m29705f1()) {
            c12165g.m73119b();
        }
        if (m58093e()) {
            c12165g.m73120c();
        }
    }

    /* renamed from: d */
    public final void m58092d() throws InterruptedException, C9721b {
        C4879a c4879a = this.f46405a;
        if (c4879a != null) {
            c4879a.isCancel();
        }
    }

    /* renamed from: e */
    public final boolean m58093e() {
        return this.f46414j == 1 || this.f46415k == 1;
    }

    /* renamed from: f */
    public void m58094f(String str, CloudBackupStatus cloudBackupStatus) throws C9721b {
        new C12165g(this.f46410f, str, 0, cloudBackupStatus.m29861N()).m73121d();
    }

    /* renamed from: g */
    public final void m58095g(CloudBackupStatus cloudBackupStatus, String str, Map<String, String> map) throws C9721b {
        long jM58090b = cloudBackupStatus.m29863P() ? m58090b(str, cloudBackupStatus.m29861N()) : 0L;
        C12165g c12165g = new C12165g(this.f46410f, str, 0, cloudBackupStatus.m29861N());
        if (this.f46405a.m29705f1()) {
            long jM73126i = c12165g.m73126i() + jM58090b;
            long jM73125h = c12165g.m73125h();
            map.put("vfsReuploadSize", String.valueOf(jM73126i));
            map.put("vfsReuploadCount", String.valueOf(jM73125h));
        }
        if (m58093e()) {
            long jM73127j = c12165g.m73127j();
            long jM73124g = c12165g.m73124g();
            map.put("vfsRefSize", String.valueOf(jM58090b + jM73127j));
            map.put("vfsRefCount", String.valueOf(jM73124g));
            cloudBackupStatus.m29369P1(String.valueOf(jM73127j));
            new C12815f(this.f46412h).m76934m(cloudBackupStatus);
        }
    }

    /* renamed from: h */
    public void m58096h(CloudBackupStatus cloudBackupStatus, Map<String, String> map) throws C9721b {
        if (cloudBackupStatus == null) {
            C11839m.m70687e("CloudBackupV3ModuleStatistic", "backupStatus is null.");
            return;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        C11839m.m70688i("CloudBackupV3ModuleStatistic", "statisticVFS begin, appId = " + strM29870d + ", backupId = " + this.f46410f);
        this.f46414j = C9733f.m60705z().m60763v("vfsRefStatistics");
        this.f46415k = C9733f.m60705z().m60763v("backupVfsRefBypass");
        C11839m.m70688i("CloudBackupV3ModuleStatistic", "vfsRefStatisticSwitch:" + this.f46414j + ",backupVfsRefByPass:" + this.f46415k + ",ignoreVFS:" + this.f46405a.m29705f1());
        if (!this.f46405a.m29705f1() && this.f46414j == 0 && this.f46415k == 0) {
            C11839m.m70688i("CloudBackupV3ModuleStatistic", "no need to statistic vfs.");
            return;
        }
        m58092d();
        m58091c(strM29870d, cloudBackupStatus);
        m58092d();
        m58097i(cloudBackupStatus, strM29870d);
        m58095g(cloudBackupStatus, strM29870d, map);
        m58094f(strM29870d, cloudBackupStatus);
        C11839m.m70688i("CloudBackupV3ModuleStatistic", "statisticVFS end, appId = " + strM29870d + ", backupId = " + this.f46410f + ",vfsRefTotalSize = " + cloudBackupStatus.m29383W0());
    }

    /* renamed from: i */
    public final void m58097i(CloudBackupStatus cloudBackupStatus, String str) throws Throwable {
        for (Bak bak : this.f46406b) {
            String id2 = bak.getId();
            String backupVersion = bak.getBackupVersion();
            if (TextUtils.isEmpty(id2)) {
                C11839m.m70688i("CloudBackupV3ModuleStatistic", "update error, successBakId =" + id2 + ",version = " + backupVersion);
            } else {
                m58092d();
                try {
                    try {
                        new C12610z0(this.f46405a, this.f46412h, this.f46413i, bak.getId(), backupVersion, bak.getProperties()).m76086c(bak, str, backupVersion, cloudBackupStatus);
                        m58092d();
                        if (cloudBackupStatus.m29863P()) {
                            m58089a(str, id2, backupVersion);
                        }
                        if (C12590s0.m75767L0(cloudBackupStatus)) {
                            m58092d();
                            if (this.f46405a.m29705f1()) {
                                m58098j(str, id2, backupVersion, cloudBackupStatus.m29861N());
                            }
                            if (m58093e()) {
                                m58099k(str, id2, backupVersion, cloudBackupStatus.m29861N());
                            }
                        }
                    } catch (C9721b e10) {
                        e = e10;
                        C11839m.m70689w("CloudBackupV3ModuleStatistic", "download snapshot exception, " + e.getMessage() + ", skip bakId =" + id2 + ",version = " + backupVersion);
                    }
                } catch (C9721b e11) {
                    e = e11;
                }
            }
        }
    }

    /* renamed from: j */
    public final void m58098j(String str, String str2, String str3, int i10) throws SQLException {
        C11839m.m70688i("CloudBackupV3ModuleStatistic", "update t_temp,current backup id = " + this.f46410f + ",last success backupId = " + str2 + ", successBakVersion = " + str3 + ", appId = " + str);
        try {
            this.f46411g.m75997G(str2, str3, this.f46410f, str, i10);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleStatistic", "updateTableTemp error: " + e10.getMessage());
        }
        C11839m.m70688i("CloudBackupV3ModuleStatistic", "update end, appId = " + str + ", successBakId = " + str2 + ", version = " + str3);
    }

    /* renamed from: k */
    public final void m58099k(String str, String str2, String str3, int i10) throws SQLException {
        C11839m.m70688i("CloudBackupV3ModuleStatistic", "update t_temp2,current backup id = " + this.f46410f + ",last success backupId = " + str2 + ",successBakVersion = " + str3 + ", appId = " + str);
        try {
            this.f46411g.m75998H(str2, str3, this.f46410f, str, i10);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleStatistic", "updateTableTemp2 error: " + e10.getMessage());
        }
    }
}
