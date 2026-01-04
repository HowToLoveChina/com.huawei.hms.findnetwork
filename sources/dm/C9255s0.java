package dm;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p618rm.C12610z0;
import p709vj.C13452e;
import p744wl.C13617a;
import pl.C12164f;
import sl.C12810a;
import sl.C12812c;
import sl.C12815f;
import tl.C13029h;

/* renamed from: dm.s0 */
/* loaded from: classes6.dex */
public class C9255s0 {

    /* renamed from: a */
    public C4879a f46471a;

    /* renamed from: b */
    public List<Bak> f46472b;

    /* renamed from: e */
    public String f46475e;

    /* renamed from: h */
    public String f46478h;

    /* renamed from: i */
    public String f46479i;

    /* renamed from: k */
    public boolean f46481k;

    /* renamed from: c */
    public Map<String, SnapshotBackupMeta> f46473c = new HashMap();

    /* renamed from: d */
    public Map<String, SnapshotBackupMeta> f46474d = new HashMap();

    /* renamed from: f */
    public C12594t1 f46476f = C12594t1.m75990o();

    /* renamed from: j */
    public boolean f46480j = false;

    /* renamed from: g */
    public String f46477g = C10279b.m63452a(C10278a.m63442h(m58180b().getFilesDir() + "/cloudbackup"));

    public C9255s0(C4879a c4879a, C13029h c13029h, String str, String str2) {
        this.f46471a = c4879a;
        this.f46475e = c13029h.m78465h();
        this.f46472b = c4879a.m29646K0();
        this.f46478h = str;
        this.f46479i = str2;
    }

    /* renamed from: a */
    public final void m58179a(String str, String str2, String str3) throws Throwable {
        if (C12590s0.m75873l1(str3) || this.f46471a.m29705f1() || C13452e.m80781L().m80887a1()) {
            return;
        }
        try {
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "get apk meta begin, appId = " + str + ", successBakId = " + str2 + ", version = " + str3);
            SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(".apk");
            SnapshotBackupMeta snapshotBackupMetaQueryAppApkFile = snapshotBackupMetaOperator.queryAppApkFile(str, sb2.toString());
            String hash1 = snapshotBackupMetaQueryAppApkFile.getHash1();
            long appType = snapshotBackupMetaQueryAppApkFile.getAppType();
            if (!TextUtils.isEmpty(hash1) && appType != C0241z.m1685c("3")) {
                C11839m.m70688i("CloudBackupV3ModuleUpdate", "get apk snapshotBackupMeta");
                this.f46473c.put(hash1, snapshotBackupMetaQueryAppApkFile);
            }
            SnapshotBackupMeta snapshotBackupMetaQueryAppApkFile2 = snapshotBackupMetaOperator.queryAppApkFile(str, str + ".icon");
            String hash12 = snapshotBackupMetaQueryAppApkFile2.getHash1();
            long appType2 = snapshotBackupMetaQueryAppApkFile2.getAppType();
            if (!TextUtils.isEmpty(hash12) && appType2 != C0241z.m1685c("3")) {
                C11839m.m70688i("CloudBackupV3ModuleUpdate", "get icon snapshotBackupMeta");
                this.f46474d.put(hash12, snapshotBackupMetaQueryAppApkFile);
            }
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "get apk meta end, appId = " + str + ", successBakId = " + str2 + ", version = " + str3);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3ModuleUpdate", "getApkBackupMetaInfo exception: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public final Context m58180b() {
        return C0213f.m1377a();
    }

    /* renamed from: c */
    public final boolean m58181c(CloudBackupStatus cloudBackupStatus) {
        C4879a c4879a = this.f46471a;
        if (c4879a == null || c4879a.m29731o0() == null || this.f46471a.m29731o0().m61892J() == null || cloudBackupStatus == null) {
            return false;
        }
        return this.f46471a.m29731o0().m61892J().containsKey(cloudBackupStatus.m29870d());
    }

    /* renamed from: d */
    public final void m58182d() throws InterruptedException, C9721b {
        C4879a c4879a = this.f46471a;
        if (c4879a != null) {
            if (!c4879a.isAutoBackup() || !this.f46471a.m29684Y0()) {
                this.f46471a.isCancel();
                return;
            }
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "module update exit, abnormal autobackup condition");
            int iM29710h0 = this.f46471a.m29710h0();
            throw new C9721b(iM29710h0, "module update exit, abnormal autobackup condition, err code = " + iM29710h0, "CloudBackupV3ModuleUpdate");
        }
    }

    /* renamed from: e */
    public final boolean m58183e(CloudBackupStatus cloudBackupStatus) {
        if (!this.f46480j || !this.f46471a.m29648L0()) {
            return false;
        }
        if (!cloudBackupStatus.m29863P() || cloudBackupStatus.m29351H0() == 1) {
            return cloudBackupStatus.m29422n1();
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m58184f(CloudBackupStatus cloudBackupStatus) {
        PmsMetaStatus pmsMetaStatusQuery;
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        if (cloudBackupStatus.m29863P()) {
            String strM81914C = C13617a.m81914C(strM29870d, iM29861N);
            if (C10278a.m63442h(strM81914C).exists()) {
                PmsMetaStatusOperatorV3 pmsMetaStatusOperatorV3 = new PmsMetaStatusOperatorV3(strM81914C);
                if (pmsMetaStatusOperatorV3.isExistTable()) {
                    try {
                        pmsMetaStatusQuery = pmsMetaStatusOperatorV3.query();
                    } catch (C9721b e10) {
                        C11839m.m70687e("CloudBackupV3ModuleUpdate", "isPmsCopyDone query error: " + e10.getMessage());
                        pmsMetaStatusQuery = null;
                    }
                    if (pmsMetaStatusQuery != null && 5 == pmsMetaStatusQuery.getStatus() && cloudBackupStatus.m29858I() == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: g */
    public void m58185g(CloudBackupStatus cloudBackupStatus) {
        if (m58183e(cloudBackupStatus)) {
            String strM29870d = cloudBackupStatus.m29870d();
            int iM29861N = cloudBackupStatus.m29861N();
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "iterationTar start");
            C12164f c12164f = new C12164f(this.f46475e, strM29870d, 0, iM29861N);
            try {
                c12164f.m73081h(this.f46481k, this.f46471a.m29638G0(), this.f46471a.m29652N0());
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3ModuleUpdate", "iterationTar error: " + e10.getMessage());
                try {
                    c12164f.dropCaclTarRefRatioTable();
                } catch (C9721b e11) {
                    C11839m.m70687e("CloudBackupV3ModuleUpdate", "dropTarTable error: " + e11.getMessage());
                }
            }
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "iterationTar end");
        }
    }

    /* renamed from: h */
    public final boolean m58186h(Bak bak, String str, String str2, CloudBackupStatus cloudBackupStatus) {
        String id2 = bak.getId();
        if (C12590s0.m75921x1(str2) || C12590s0.m75925y1(str2)) {
            if (SnapshotTreeManagementService.getInstance().checkSuccessfulBackupRecordStatus(id2)) {
                return true;
            }
        } else if (C12590s0.m75873l1(str2)) {
            File fileM63442h = C10278a.m63442h(C13617a.m81942x(id2, str, 0, cloudBackupStatus.m29861N()));
            if (new C12610z0(this.f46471a, this.f46478h, this.f46479i, id2, str2, bak.getProperties()).m76096m(id2, str, cloudBackupStatus.m29861N()) && fileM63442h.exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public void m58187i(CloudBackupStatus cloudBackupStatus) throws C9721b {
        if (this.f46471a.m29699d1() || this.f46471a.isRefurbishment()) {
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "update snapshot cache is full backup, return.");
            return;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        m58182d();
        this.f46481k = m58184f(cloudBackupStatus);
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update data begin, appId = " + strM29870d + ", bakcupId = " + this.f46475e + " pmsCopyUploadDone: " + this.f46481k);
        for (Bak bak : this.f46472b) {
            String id2 = bak.getId();
            String backupVersion = bak.getBackupVersion();
            if (TextUtils.isEmpty(id2)) {
                C11839m.m70688i("CloudBackupV3ModuleUpdate", "update error, successBakId =" + id2 + ",version = " + backupVersion);
            } else if (!C12590s0.m75869k1(this.f46471a.m29657P0()) || this.f46471a.isRefurbishment() || !this.f46471a.m29737q0().contains(strM29870d) || C12590s0.m75857h1(bak.getBmDataType())) {
                m58182d();
                try {
                    new C12610z0(this.f46471a, this.f46478h, this.f46479i, bak.getId(), backupVersion, bak.getProperties()).m76086c(bak, strM29870d, backupVersion, cloudBackupStatus);
                    m58182d();
                    if (cloudBackupStatus.m29863P()) {
                        m58179a(strM29870d, id2, backupVersion);
                    }
                    if (!m58186h(bak, strM29870d, backupVersion, cloudBackupStatus)) {
                        C11839m.m70688i("CloudBackupV3ModuleUpdate", "no need update, successBakId =" + id2 + ",version = " + backupVersion);
                    } else if (C12590s0.m75767L0(cloudBackupStatus)) {
                        m58182d();
                        m58192n(strM29870d, id2, backupVersion, cloudBackupStatus.m29861N(), this.f46481k);
                    }
                } catch (C9721b e10) {
                    C11839m.m70689w("CloudBackupV3ModuleUpdate", "download snapshot exception, " + e10.getMessage() + ", skip bakId =" + id2 + ",version = " + backupVersion);
                }
            } else {
                C11839m.m70688i("CloudBackupV3ModuleUpdate", "skip update, successBakId =" + id2 + ", bmType = " + bak.getBmDataType());
            }
        }
        if (cloudBackupStatus.m29863P()) {
            C11839m.m70688i("CloudBackupV3ModuleUpdate", "update 3rd vfs apk and icon info");
            m58188j(strM29870d, cloudBackupStatus);
            m58189k(strM29870d, cloudBackupStatus);
        }
        this.f46480j = true;
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update data end, appId = " + strM29870d + ", bakcupId = " + this.f46475e);
    }

    /* renamed from: j */
    public final void m58188j(String str, CloudBackupStatus cloudBackupStatus) throws C9721b {
        if (this.f46473c.isEmpty()) {
            return;
        }
        int iM29861N = cloudBackupStatus.m29861N();
        C12812c c12812c = new C12812c();
        C12810a c12810aM76886e = c12812c.m76886e(str, "apk", iM29861N);
        if (c12810aM76886e == null || TextUtils.isEmpty(c12810aM76886e.m76859j())) {
            return;
        }
        SnapshotBackupMeta snapshotBackupMeta = this.f46473c.get(c12810aM76886e.m76859j());
        if (snapshotBackupMeta == null || 2 == c12810aM76886e.m76862m() || m58181c(cloudBackupStatus)) {
            return;
        }
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update update3rdApkAttachmentCache, appId = " + str + ", V2 bakcupId = " + this.f46475e);
        cloudBackupStatus.m29441u1(snapshotBackupMeta.getAppSlice());
        cloudBackupStatus.mo29318b0(3);
        new C12815f(this.f46478h).m76934m(cloudBackupStatus);
        c12810aM76886e.m76846C(2);
        c12810aM76886e.m76874y(0);
        c12812c.m76888g(c12810aM76886e);
    }

    /* renamed from: k */
    public final void m58189k(String str, CloudBackupStatus cloudBackupStatus) throws C9721b {
        C12812c c12812c;
        C12810a c12810aM76886e;
        if (this.f46474d.isEmpty() || (c12810aM76886e = (c12812c = new C12812c()).m76886e(str, "icon", cloudBackupStatus.m29861N())) == null || TextUtils.isEmpty(c12810aM76886e.m76859j())) {
            return;
        }
        SnapshotBackupMeta snapshotBackupMeta = this.f46474d.get(c12810aM76886e.m76859j());
        if (snapshotBackupMeta == null || 2 == c12810aM76886e.m76862m() || m58181c(cloudBackupStatus)) {
            return;
        }
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update3rdIconAttachmentCache, appId = " + str + ", V2 bakcupId = " + this.f46475e);
        cloudBackupStatus.m29376S1(snapshotBackupMeta.getAppSlice());
        cloudBackupStatus.mo29318b0(3);
        new C12815f(this.f46478h).m76934m(cloudBackupStatus);
        c12810aM76886e.m76846C(2);
        c12810aM76886e.m76874y(0);
        c12812c.m76888g(c12810aM76886e);
    }

    /* renamed from: l */
    public final void m58190l(String str, String str2, int i10, boolean z10) throws SQLException {
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update V2 cache,cur backup id = " + this.f46475e + ",last backupid =  " + str2 + ", appid = " + str);
        try {
            this.f46476f.m76000J(str2, this.f46475e, str, i10);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleUpdate", "update V2 cache error: " + e10.toString());
        }
        this.f46476f.m75996F(this.f46475e, str, i10, z10);
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update V2 cache end.");
    }

    /* renamed from: m */
    public final void m58191m(String str, String str2, int i10, boolean z10) throws SQLException {
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update V3 cache,cur backup id = " + this.f46475e + ",last backupid =  " + str2 + ", appid = " + str);
        try {
            this.f46476f.m76001K(str2, this.f46475e, str, i10, this.f46471a.m29705f1(), z10);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleUpdate", "update V3 cache error: " + e10.toString());
        }
        this.f46476f.m75996F(this.f46475e, str, i10, z10);
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update V3 cache end.");
    }

    /* renamed from: n */
    public final void m58192n(String str, String str2, String str3, int i10, boolean z10) throws SQLException {
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update begin, appId = " + str + ", successBakId = " + str2 + ", version = " + str3);
        if (C12590s0.m75873l1(str3)) {
            m58191m(str, str2, i10, z10);
        } else if (!this.f46471a.m29705f1()) {
            m58190l(str, str2, i10, z10);
        }
        C11839m.m70688i("CloudBackupV3ModuleUpdate", "update end, appId = " + str + ", successBakId = " + str2 + ", version = " + str3);
    }
}
