package dm;

import am.InterfaceC0275i1;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import gm.C9992e0;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12565k;
import p618rm.C12568l;
import p618rm.C12574n;
import p618rm.C12583q;
import p618rm.C12590s0;
import p709vj.C13452e;
import p746wn.C13622a;
import p815ym.AbstractC14026a;
import pl.C12161c;
import pl.C12164f;
import sl.C12816g;

/* renamed from: dm.t1 */
/* loaded from: classes6.dex */
public class C9260t1 {

    /* renamed from: a */
    public C4880b f46514a;

    /* renamed from: c */
    public String f46516c;

    /* renamed from: d */
    public C9992e0 f46517d;

    /* renamed from: e */
    public C12816g f46518e;

    /* renamed from: f */
    public long f46519f = 0;

    /* renamed from: b */
    public Context f46515b = C0213f.m1377a();

    public C9260t1(C4880b c4880b, C9992e0 c9992e0, C12816g c12816g) {
        this.f46514a = c4880b;
        this.f46517d = c9992e0;
        this.f46518e = c12816g;
        this.f46516c = c4880b.m29783R();
    }

    /* renamed from: b */
    public final int m58244b(String str, final CloudRestoreStatusV3 cloudRestoreStatusV3, String str2, int i10) throws Throwable {
        int iPmsRestore;
        if (!PmsCheckUtil.m12611e()) {
            return 0;
        }
        this.f46514a.isRelease();
        String strM29470M = cloudRestoreStatusV3.m29470M();
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(this.f46515b, null, str, new InterfaceC0275i1() { // from class: dm.s1
            @Override // am.InterfaceC0275i1
            /* renamed from: a */
            public final void mo1767a(long j10) {
                this.f46482a.m58250h(cloudRestoreStatusV3, j10);
            }
        });
        if (C12565k.m75529o()) {
            m58246d(str2, i10, cloudRestoreStatusV3);
            iPmsRestore = backupRestoreUtil.pmsMove(str2, strM29470M, cloudRestoreStatusV3.getUid(), i10, true);
            if (iPmsRestore != 0) {
                this.f46514a.isRelease();
                m58245c();
                m58252j();
                iPmsRestore = backupRestoreUtil.pmsMove(str2, strM29470M, cloudRestoreStatusV3.getUid(), i10, false);
                C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "pms move data retry: " + str2 + " uid: " + cloudRestoreStatusV3.getUid() + " result: " + iPmsRestore);
            }
            m58253k(str, str2, strM29470M, cloudRestoreStatusV3.getUid());
        } else {
            m58247e(str2, strM29470M, i10);
            iPmsRestore = backupRestoreUtil.pmsRestore(str2, strM29470M, cloudRestoreStatusV3.getUid(), i10);
            if (iPmsRestore != 0) {
                this.f46514a.isRelease();
                m58252j();
                iPmsRestore = backupRestoreUtil.pmsRestore(str2, strM29470M, cloudRestoreStatusV3.getUid(), i10);
                C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "pms restore data retry: " + str2 + " uid: " + cloudRestoreStatusV3.getUid() + " result: " + iPmsRestore);
            }
        }
        if (iPmsRestore == 0) {
            int iM58256n = m58256n(backupRestoreUtil, cloudRestoreStatusV3.getUid(), i10, str2, strM29470M);
            if (!cloudRestoreStatusV3.isTwinApp() || iM58256n != 0) {
                return iM58256n;
            }
            int iM58251i = m58251i(str2, cloudRestoreStatusV3.getUid(), i10);
            C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "restore twin app data: " + str2 + " lastuid: " + cloudRestoreStatusV3.getUid() + " curUid: " + i10 + " result: " + iM58251i);
            return iM58251i;
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.f46516c, "pmsRestoreOneModuleError", C13452e.m80781L().m80971t0());
        String str3 = "appId=" + str2 + "&type=" + cloudRestoreStatusV3.getType() + "status=" + cloudRestoreStatusV3.getStatus() + "retCode=" + iPmsRestore;
        c11060cM66626a.m66665u("010_2102");
        c11060cM66626a.m66635A(str3);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        this.f46518e.m76955s(str2, String.valueOf(iPmsRestore), "pms return fail");
        return iPmsRestore;
    }

    /* renamed from: c */
    public final void m58245c() throws C9721b {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace == null) {
            return;
        }
        long jM29778M = this.f46514a.m29778M();
        if (jM29778M <= localLeftSpace.longValue()) {
            return;
        }
        throw new C9721b(1007, "checkLocalSpaceAfterPmsMoveFail local space not enough localLeftSpace: " + localLeftSpace + " ,restoreSize: " + jM29778M);
    }

    /* renamed from: d */
    public final void m58246d(String str, int i10, CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace == null) {
            return;
        }
        C12164f c12164f = new C12164f(this.f46514a.getBackupId(), str, 1, i10);
        long jM73061T = c12164f.m73061T();
        long jM58249g = m58249g(c12164f, cloudRestoreStatusV3);
        long jMax = Math.max(jM58249g, jM73061T);
        long jM29777L = this.f46514a.m29777L();
        C11839m.m70686d("CloudRestoreV3ModulePMSRestore", "checkLocalSpaceBeforePmsMove maxFileSize: " + jM73061T + " ,maxDbSize: " + jM58249g + " ,localspace: " + localLeftSpace + " ,reservedSize: " + jM29777L);
        if (jMax + jM29777L <= localLeftSpace.longValue()) {
            return;
        }
        throw new C9721b(1007, "checkLocalSpaceBeforePmsMove error maxSize: " + jMax + " ,localspace: " + localLeftSpace + " ,reservedSize: " + jM29777L);
    }

    /* renamed from: e */
    public final void m58247e(String str, String str2, int i10) throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkLocalSpaceBeforePmsRestore params error");
        }
        C12164f c12164f = new C12164f(this.f46514a.getBackupId(), str, 1, i10);
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace != null) {
            long jM73084i0 = c12164f.m73084i0();
            long jM75856h0 = C12590s0.m75856h0();
            long packageSize = AppDataSizeUtil.getPackageSize(this.f46515b, str2, i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("pms restore size check appId: " + str2);
            sb2.append(" ,packageSize: " + packageSize);
            sb2.append(" ,datasize: " + jM73084i0);
            sb2.append(" ,localRsize: " + jM75856h0);
            sb2.append(" ,leftSpace: " + localLeftSpace);
            C11839m.m70688i("CloudRestoreV3ModulePMSRestore", sb2.toString());
            if (jM73084i0 + jM75856h0 <= localLeftSpace.longValue() + packageSize) {
                return;
            }
            throw new C9721b(1007, "pms restore size not enough  " + ((Object) sb2));
        }
    }

    /* renamed from: f */
    public String m58248f(String str) {
        return C12583q.m75680p(1) + File.separator + str;
    }

    /* renamed from: g */
    public final long m58249g(C12164f c12164f, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        List<C12161c> listM73068a0;
        long jMax = 0;
        try {
            listM73068a0 = c12164f.m73068a0(8);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreV3ModulePMSRestore", "queryMetasByType error: " + e10.getMessage());
        }
        if (AbstractC14026a.m84159a(listM73068a0)) {
            C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "getMaxDiffDbSize bigDbMetas is empty");
            return 0L;
        }
        for (C12161c c12161c : listM73068a0) {
            String strM72950F = c12161c.m72950F();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ICBUtil.RELATIVE_SDATA_PATH);
            String str = File.separator;
            sb2.append(str);
            if (TextUtils.equals(strM72950F, sb2.toString())) {
                try {
                    File fileM63442h = C10278a.m63442h(C12590s0.m75758J(c12161c, cloudRestoreStatusV3, "V4".equals(this.f46514a.f22517K), this.f46514a.getLocation() + str + cloudRestoreStatusV3.getAppId()));
                    if (fileM63442h.exists()) {
                        jMax = Math.max(jMax, fileM63442h.length());
                    }
                } catch (C9721b e11) {
                    C11839m.m70689w("CloudRestoreV3ModulePMSRestore", "destination error: " + e11.getMessage());
                }
            }
        }
        return jMax;
    }

    /* renamed from: h */
    public final /* synthetic */ void m58250h(CloudRestoreStatusV3 cloudRestoreStatusV3, long j10) {
        long jMin = Math.min(j10, cloudRestoreStatusV3.getSize());
        long j11 = jMin - this.f46519f;
        this.f46519f = jMin;
        cloudRestoreStatusV3.addPmsAlreadyBytes(j11 > 0 ? j11 : 0L);
        RestoreProgress.updateStatus(cloudRestoreStatusV3);
        C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "pms move completed size is: " + jMin + " ,increase: " + j11);
    }

    /* renamed from: i */
    public final int m58251i(String str, int i10, int i11) {
        String strM75679o = C12583q.m75679o(str, i10);
        String strM75533b = C12568l.m75533b(i11);
        if (TextUtils.isEmpty(strM75679o) || TextUtils.isEmpty(strM75533b)) {
            return -1;
        }
        try {
            C12574n.m75561n(C10278a.m63442h(strM75679o), C10278a.m63442h(strM75533b), this.f46514a);
            return 0;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3ModulePMSRestore", "moveTwinAppExternalData error: " + str + " uid: " + i10 + " message: " + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: j */
    public final void m58252j() throws C9721b {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i10 >= 20) {
                return;
            }
            this.f46514a.isRelease();
            SystemClock.sleep(500L);
            i10 = i11;
        }
    }

    /* renamed from: k */
    public final void m58253k(String str, String str2, String str3, int i10) {
        File fileM63443i = C10278a.m63443i(str, str3 + ".txt");
        long jM73110w = new C12164f(this.f46514a.getBackupId(), str2, 1, i10).m73110w(str2);
        long jCount = -1;
        try {
            Stream<String> streamLines = Files.lines(Paths.get(C10279b.m63452a(fileM63443i), new String[0]));
            try {
                jCount = streamLines.count();
                streamLines.close();
            } finally {
            }
        } catch (Throwable th2) {
            C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "reportPmsMoveTxtlineMetacount error: " + th2.getMessage());
        }
        long j10 = jCount;
        if (jM73110w - j10 > 2) {
            CloudBackupReport.reportPmsMoveTxtlineMetacount(this.f46516c, str2, i10, j10, jM73110w);
        }
    }

    /* renamed from: l */
    public final int m58254l(String str, String str2, String str3, String str4, BackupRestoreUtil backupRestoreUtil, int i10) throws C9721b, IOException {
        File[] fileArrListFiles;
        if (!C0209d.m1179I1()) {
            C11835i.m70653q(str + str4, str2);
            return 0;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists() || (fileArrListFiles = fileM63442h.listFiles()) == null || fileArrListFiles.length <= 0) {
            return 0;
        }
        File fileM63443i = C10278a.m63443i(str, str4 + ".txt");
        if (!fileM63443i.exists()) {
            try {
                C11839m.m70686d("CloudRestoreV3ModulePMSRestore", "create pms txt file result = " + fileM63443i.createNewFile());
            } catch (IOException e10) {
                C11839m.m70687e("CloudRestoreV3ModulePMSRestore", "create pms txt file error: " + e10.toString());
            }
        }
        return backupRestoreUtil.pmsRestore(str, str2, i10);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: m */
    public void m58255m(CloudRestoreStatusV3 cloudRestoreStatusV3, int i10) throws Throwable {
        if (cloudRestoreStatusV3.is3rdAppType()) {
            String appId = cloudRestoreStatusV3.getAppId();
            if (cloudRestoreStatusV3.getType() != 1) {
                C11839m.m70689w("CloudRestoreV3ModulePMSRestore", "restoreOneModule3rdData apk restore error appId = " + appId + " ,uid: " + cloudRestoreStatusV3.getUid());
                return;
            }
            this.f46514a.isRelease();
            String strM58248f = m58248f(appId);
            File fileM63442h = C10278a.m63442h(strM58248f);
            if (!fileM63442h.exists()) {
                C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "restoreOneModule3rdData " + appId + " ,uid: " + cloudRestoreStatusV3.getUid() + " no data restore dataTempPath: " + strM58248f);
                return;
            }
            this.f46514a.isRelease();
            String[] list = fileM63442h.list();
            if (list == null || list.length <= 0) {
                C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "restoreOneModule3rdData " + appId + " no data restore ,uid: " + cloudRestoreStatusV3.getUid());
                return;
            }
            if (cloudRestoreStatusV3.getAction() != 0) {
                C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "not support to restore app data");
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(0);
            String strM29470M = cloudRestoreStatusV3.m29470M();
            if (ICBUtil.isForGroundProcess(strM29470M, this.f46515b, atomicInteger)) {
                C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "killBackgroundProcesses, foreground appId = " + appId + " ,uid: " + cloudRestoreStatusV3.getUid() + " ,curUid: " + i10);
                this.f46518e.m76958v(cloudRestoreStatusV3, -2, 2);
                CloudBackupReport.reportIsSkip(appId, "foreGround", this.f46516c, atomicInteger.get());
                return;
            }
            C11839m.m70688i("CloudRestoreV3ModulePMSRestore", "killBackgroundProcesses, background appId = " + appId + " ,uid: " + cloudRestoreStatusV3.getUid() + " ,curUid: " + i10);
            CloudBackupReport.reportIsSkip(appId, "backGround", this.f46516c, 0);
            ((ActivityManager) this.f46515b.getSystemService("activity")).killBackgroundProcesses(strM29470M);
            this.f46514a.isRelease();
            this.f46518e.m76958v(cloudRestoreStatusV3, 7, 0);
            this.f46517d.m61975I(cloudRestoreStatusV3);
            int iM58244b = m58244b(strM58248f, cloudRestoreStatusV3, appId, i10);
            this.f46514a.isRelease();
            cloudRestoreStatusV3.setStatus(7).setType(iM58244b != 0 ? 2 : 1);
            this.f46518e.m76957u(cloudRestoreStatusV3);
        }
    }

    /* renamed from: n */
    public final int m58256n(BackupRestoreUtil backupRestoreUtil, int i10, int i11, String str, String str2) throws C9721b, IOException {
        this.f46514a.isRelease();
        String strM75678n = C12583q.m75678n(str, i10);
        int iM58254l = m58254l(strM75678n + ICBUtil.ANDROID_DATA, C12583q.m75670f(i11, ICBUtil.ANDROID_DATA, str2), str, str2, backupRestoreUtil, i11);
        if (iM58254l != 0) {
            return iM58254l;
        }
        this.f46514a.isRelease();
        int iM58254l2 = m58254l(strM75678n + ICBUtil.ANDROID_MEDIA, C12583q.m75670f(i11, ICBUtil.ANDROID_MEDIA, str2), str, str2, backupRestoreUtil, i11);
        if (iM58254l2 != 0) {
            return iM58254l2;
        }
        this.f46514a.isRelease();
        int iM58254l3 = m58254l(strM75678n + ICBUtil.ANDROID_OBB, C12583q.m75670f(i11, ICBUtil.ANDROID_OBB, str2), str, str2, backupRestoreUtil, i11);
        if (iM58254l3 != 0) {
            return iM58254l3;
        }
        this.f46514a.isRelease();
        int iM58254l4 = m58254l(strM75678n + ICBUtil.ANDROID_OBJ, C12583q.m75670f(i11, ICBUtil.ANDROID_OBJ, str2), str, str2, backupRestoreUtil, i11);
        if (iM58254l4 != 0) {
            return iM58254l4;
        }
        this.f46514a.isRelease();
        return m58254l(strM75678n + ICBUtil.ANDROID_SANDBOX, C12583q.m75670f(i11, ICBUtil.ANDROID_SANDBOX, str2), str, str2, backupRestoreUtil, i11);
    }
}
