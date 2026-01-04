package dm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import bm.InterfaceC1261b;
import cm.C1460f;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import im.AbstractC10571u;
import im.C10546a;
import im.C10547a0;
import im.InterfaceC10551c0;
import im.InterfaceC10562l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import mm.AbstractC11494p;
import mm.C11492n;
import mm.InterfaceC11495q;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0221j;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12593t0;
import p709vj.C13452e;
import p746wn.C13622a;
import p848zl.C14333b;
import pl.C12161c;
import pl.C12164f;

/* renamed from: dm.i1 */
/* loaded from: classes6.dex */
public class C9216i1 extends CloudBackupFileTask {

    /* renamed from: a */
    public String f46263a;

    /* renamed from: b */
    public String f46264b;

    /* renamed from: c */
    public String f46265c;

    /* renamed from: d */
    public C1460f f46266d;

    /* renamed from: e */
    public CloudRestoreStatusV3 f46267e;

    /* renamed from: f */
    public C12161c f46268f;

    /* renamed from: g */
    public InterfaceC1261b f46269g;

    /* renamed from: h */
    public CountDownLatch f46270h;

    /* renamed from: i */
    public C10547a0 f46271i;

    /* renamed from: j */
    public Set<String> f46272j;

    /* renamed from: k */
    public String f46273k;

    /* renamed from: l */
    public String f46274l;

    /* renamed from: m */
    public long f46275m;

    /* renamed from: n */
    public boolean f46276n;

    /* renamed from: o */
    public List<String> f46277o;

    /* renamed from: p */
    public C4880b f46278p;

    /* renamed from: q */
    public Map<String, String> f46279q;

    /* renamed from: r */
    public boolean f46280r;

    public C9216i1(C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3, C12161c c12161c, InterfaceC1261b interfaceC1261b, CountDownLatch countDownLatch, int i10, Set<String> set, String str, boolean z10, Map<String, String> map) {
        super(c12161c.m72974c() + cloudRestoreStatusV3.getUid(), i10);
        this.f46277o = new ArrayList();
        this.f46280r = false;
        this.f46278p = c4880b;
        this.f46263a = c4880b.getBackupId();
        this.f46264b = c4880b.m29783R();
        this.f46274l = c4880b.m29772G();
        this.f46265c = c4880b.getLocation();
        this.f46266d = c4880b.m29776K();
        this.f46267e = cloudRestoreStatusV3;
        this.f46268f = c12161c;
        this.f46269g = interfaceC1261b;
        this.f46270h = countDownLatch;
        this.f46272j = set;
        this.f46273k = str;
        this.f46276n = z10;
        this.f46279q = map;
    }

    /* renamed from: A */
    public final String m57910A(C12161c c12161c) throws C9721b {
        String strM73011z = c12161c.m73011z();
        if (c12161c.m72980f() == 1) {
            strM73011z = ICBUtil.getDecodedPath(strM73011z);
        }
        String strCheckTarPrePathMoveRoot = ICBUtil.checkTarPrePathMoveRoot(strM73011z);
        if (!TextUtils.isEmpty(strCheckTarPrePathMoveRoot) && !TextUtils.equals(strCheckTarPrePathMoveRoot, strM73011z)) {
            C11839m.m70686d("CloudRestoreV3FileDownload", "getTarFileEndPath destination: " + strM73011z + " ,checkResult: " + strCheckTarPrePathMoveRoot);
            return strCheckTarPrePathMoveRoot;
        }
        String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(strM73011z, this.f46265c, c12161c.m72974c());
        if (isStringNull(strConvertToAbsolutePath)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        for (String str : this.f46272j) {
            if (strConvertToAbsolutePath.startsWith(str)) {
                return strConvertToAbsolutePath.substring(str.length());
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getFileEndPath error destination " + strConvertToAbsolutePath);
    }

    /* renamed from: B */
    public final boolean m57911B(String str, int i10, String str2) {
        return !TextUtils.isEmpty(str) && str.startsWith(C12583q.m75670f(i10, ICBUtil.ANDROID_DATA, "com.android.providers.telephony")) && "chatSms".equals(str2);
    }

    /* renamed from: C */
    public final boolean m57912C(C12161c c12161c) {
        return !TextUtils.isEmpty(c12161c.m72984h()) && !TextUtils.isEmpty(c12161c.m73009x()) && c12161c.m73010y() == 1 && c12161c.m72953I() == 7;
    }

    /* renamed from: D */
    public final /* synthetic */ void m57913D(boolean z10, AbstractC10571u abstractC10571u) {
        long jM64862U = abstractC10571u.m64862U();
        long jM64864W = abstractC10571u.m64864W();
        if (z10) {
            long j10 = this.f46275m;
            if (j10 > 0) {
                jM64862U = (long) (j10 * (jM64862U / jM64864W));
                jM64864W = j10;
            }
        }
        this.f46269g.onProgress(jM64862U, jM64864W);
    }

    /* renamed from: E */
    public final /* synthetic */ InterfaceC10551c0 m57914E(C12161c c12161c, String str) throws C9721b {
        if (isAbort()) {
            C11839m.m70688i("CloudRestoreV3FileDownload", "task is abort return null");
            return null;
        }
        String strM72978e = c12161c.m72978e();
        C10547a0 c10547a0 = new C10547a0(this.f46278p.getBackupId(), this.f46264b, this.f46266d, str, c12161c.m73009x(), strM72978e, c12161c.m72954J(), this.priority);
        this.f46271i = c10547a0;
        c10547a0.m64876j0(this.f46274l);
        m57923r(c12161c);
        return this.f46271i;
    }

    /* renamed from: F */
    public final /* synthetic */ InterfaceC10551c0 m57915F(C12161c c12161c, String str) throws C9721b {
        if (isAbort()) {
            C11839m.m70688i("CloudRestoreV3FileDownload", "task is abort return null");
            return null;
        }
        C10547a0 c10547a0 = new C10547a0(this.f46278p.getBackupId(), this.f46264b, this.f46266d, str, m57929z(this.f46273k, c12161c.m72974c(), c12161c.m72984h()), this.priority);
        this.f46271i = c10547a0;
        c10547a0.m64876j0(this.f46274l);
        m57923r(c12161c);
        return this.f46271i;
    }

    /* renamed from: G */
    public final /* synthetic */ void m57916G(AtomicLong atomicLong, String str, AbstractC11494p abstractC11494p, int i10) throws C9721b {
        for (int i11 = 1; i11 <= i10; i11++) {
            C12161c c12161c = (C12161c) abstractC11494p.query(i11);
            atomicLong.addAndGet(c12161c.m72951G());
            String strM57910A = m57910A(c12161c);
            String str2 = "V4".equals(this.f46278p.f22517K) ? str + File.separator + strM57910A : str + strM57910A;
            File fileM63442h = C10278a.m63442h(str2);
            if (fileM63442h.exists()) {
                String strM57920k = m57920k(c12161c);
                this.f46277o.add(strM57920k);
                C11839m.m70686d("CloudRestoreV3FileDownload", "getFileEndPath path = " + strM57910A + " ,tempFilePath = " + str2 + " path: " + strM57920k);
                File fileM63442h2 = C10278a.m63442h(strM57920k);
                if (fileM63442h2.isDirectory()) {
                    if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadTARFile origin file " + strM57920k + " create dir error: " + c12161c.m72948D());
                    }
                } else if (!fileM63442h2.exists()) {
                    renameFile(fileM63442h2, fileM63442h);
                    this.f46269g.mo7515b(strM57920k, c12161c);
                } else if (RestoreUtil.isSameFile(fileM63442h2, c12161c.m72945A(), c12161c.m72946B())) {
                    C11839m.m70686d("CloudRestoreV3FileDownload", "downloadTARFile destination " + strM57920k + " exist");
                    C12593t0.m75970c(C10279b.m63452a(fileM63442h2), this.f46267e, this.f46278p, this.f46279q);
                } else {
                    C11839m.m70686d("CloudRestoreV3FileDownload", "downloadTARFile destination " + strM57920k + " exist");
                    if (!fileM63442h2.delete()) {
                        C11839m.m70689w("CloudRestoreV3FileDownload", "downloadTARFile destination " + strM57920k + " exist hash not equal, delete error");
                    }
                    renameFile(fileM63442h2, fileM63442h);
                    this.f46269g.mo7515b(strM57920k, c12161c);
                }
            } else {
                C11839m.m70687e("CloudRestoreV3FileDownload", "downloadTARFile origin file " + strM57910A + " not exist, tarfile: " + c12161c.m72948D());
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "moveOriginFiles", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66666v("isSuccess", "0", "1", "downloadTARFile origin file " + strM57910A + " not exist, tarfile: " + c12161c.m72948D());
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            }
        }
    }

    /* renamed from: H */
    public final long m57917H(final String str) throws C9721b {
        C11492n c11492n = new C11492n(new C12164f(this.f46263a, this.f46268f.m72974c(), 1, this.f46267e.getUid()), this.f46268f.m72974c(), this.f46268f.m73010y() == 1 ? this.f46268f.m73009x() : this.f46268f.m72984h(), this.f46268f.m72953I(), this.f46268f.m73010y());
        final AtomicLong atomicLong = new AtomicLong();
        c11492n.execute(new InterfaceC11495q() { // from class: dm.g1
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws C9721b {
                this.f46209a.m57916G(atomicLong, str, abstractC11494p, i10);
            }
        });
        C11839m.m70686d("CloudRestoreV3FileDownload", "downloadTARFile untar end, cloudPath = " + this.f46268f.m72984h() + ", fileId = " + this.f46268f.m73009x());
        return atomicLong.get();
    }

    /* renamed from: I */
    public final void m57918I(File file) {
        C11839m.m70688i("CloudRestoreV3FileDownload", "file is exists,the length is : " + file.length());
        this.f46267e.addBytesDownloaded(false, file.length());
        RestoreProgress.updateStatus(this.f46267e);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        C9721b c9721b;
        StringBuilder sb2;
        String strM57920k = "";
        long jM72951G = this.f46268f.m72951G();
        String strM72974c = this.f46268f.m72974c();
        int iM72953I = -1;
        try {
            try {
                iM72953I = (int) this.f46268f.m72953I();
                strM57920k = m57920k(this.f46268f);
                C11839m.m70686d("CloudRestoreV3FileDownload", "download file begin, uid: " + this.f46267e.getUid() + " ,name = " + this.f46268f.m72948D() + ", fileType = " + iM72953I + ", path = " + strM57920k);
                switch (iM72953I) {
                    case 6:
                    case 8:
                    case 9:
                        downloadNormalFile(strM57920k);
                        break;
                    case 7:
                        jM72951G = downloadTARFile();
                        break;
                }
                C11839m.m70686d("CloudRestoreV3FileDownload", "download file success. name = " + this.f46268f.m72948D());
                m57924s(iM72953I, strM57920k, jM72951G);
                sb2 = new StringBuilder();
            } catch (Exception e10) {
                String str = strM57920k;
                long j10 = jM72951G;
                int i10 = iM72953I;
                if (e10 instanceof C9721b) {
                    c9721b = (C9721b) e10;
                } else {
                    c9721b = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file error. name = " + this.f46268f.m72948D() + ",error msg: " + e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
                }
                C11839m.m70686d("CloudRestoreV3FileDownload", "download file error. " + c9721b);
                m57927v(strM72974c, i10, j10, str, c9721b);
                sb2 = new StringBuilder();
            }
            sb2.append("download file end. name = ");
            sb2.append(this.f46268f.m72948D());
            C11839m.m70686d("CloudRestoreV3FileDownload", sb2.toString());
            this.f46270h.countDown();
        } catch (Throwable th2) {
            C11839m.m70686d("CloudRestoreV3FileDownload", "download file end. name = " + this.f46268f.m72948D());
            this.f46270h.countDown();
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        C10547a0 c10547a0 = this.f46271i;
        if (c10547a0 != null) {
            c10547a0.mo64711f();
        }
        super.cancel(z10);
    }

    public final void downloadNormalFile(String str) throws C9721b {
        String strM1488P = C0221j.m1488P(str, "-");
        File fileM63442h = C10278a.m63442h(str);
        if (m57928y(fileM63442h.getName())) {
            C11839m.m70687e("CloudRestoreV3FileDownload", "download diff pack but type is 6: " + str);
            m57918I(fileM63442h);
            return;
        }
        if (!fileM63442h.exists()) {
            C12161c c12161c = this.f46268f;
            m57921p(c12161c, strM1488P, c12161c.m72951G());
        } else {
            if (C14333b.m85446B().contains(this.f46268f.m72974c())) {
                m57918I(fileM63442h);
                return;
            }
            if (RestoreUtil.isSameFile(fileM63442h, this.f46268f.m72945A(), this.f46268f.m72946B())) {
                m57918I(fileM63442h);
            } else {
                if (str.equals(strM1488P)) {
                    C11839m.m70686d("CloudRestoreV3FileDownload", " file already exists delete result: " + fileM63442h.delete() + ". start to download the file again. " + str);
                }
                C12161c c12161c2 = this.f46268f;
                m57921p(c12161c2, strM1488P, c12161c2.m72951G());
            }
        }
        String appId = this.f46267e.getAppId();
        if (HNConstants.DataType.MEDIA.equals(appId) || "music".equals(appId)) {
            long jM73006u = this.f46268f.m73006u();
            if (jM73006u > 0) {
                C11839m.m70686d("CloudRestoreV3FileDownload", "setLastModified result = " + fileM63442h.setLastModified(jM73006u) + ", path = " + strM1488P + ", emui = " + C0219i.m1463a());
            }
            if (HNConstants.DataType.MEDIA.equals(appId)) {
                m57919i(this.f46268f.m73007v(), fileM63442h);
            }
        }
        new C12164f(this.f46263a, this.f46268f.m72974c(), 1, this.f46267e.getUid()).m73031D0(this.f46268f.m72991l(), 2L);
        C12593t0.m75970c(strM1488P, this.f46267e, this.f46278p, this.f46279q);
    }

    public final long downloadTARFile() throws Throwable {
        String tarNameByCloudPath;
        C12164f c12164f = new C12164f(this.f46263a, this.f46268f.m72974c(), 1, this.f46267e.getUid());
        boolean z10 = 1 == this.f46268f.m73010y();
        if (z10) {
            this.f46275m = c12164f.m73092m0(7, this.f46268f.m73009x());
        } else {
            this.f46275m = c12164f.m73090l0(7, this.f46268f.m72984h());
        }
        if (1 == this.f46268f.m73010y()) {
            tarNameByCloudPath = this.f46268f.m73009x() + ".tar";
        } else {
            String strM72984h = this.f46268f.m72984h();
            if (isStringNull(strM72984h)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadTarFile error cloudPath is empty");
            }
            tarNameByCloudPath = ICBUtil.getTarNameByCloudPath(strM72984h);
            if (isStringNull(tarNameByCloudPath)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadFiles tar name is empty");
            }
        }
        String localTarPath = ICBUtil.getLocalTarPath(this.f46265c, this.f46268f.m72974c(), this.f46267e.getUid());
        File fileM63441g = C10278a.m63441g(C10278a.m63442h(localTarPath), tarNameByCloudPath);
        if (fileM63441g.exists()) {
            this.f46267e.addBytesDownloaded(false, fileM63441g.length());
            RestoreProgress.updateStatus(this.f46267e);
            C11839m.m70688i("CloudRestoreV3FileDownload", "tarFile exist,the size is: " + fileM63441g.length());
        } else {
            m57921p(this.f46268f, C10279b.m63452a(fileM63441g), this.f46268f.m72951G());
        }
        C11839m.m70686d("CloudRestoreV3FileDownload", "downloadTARFile untar start " + this.f46268f.m72948D());
        String str = localTarPath + File.separator + UUID.randomUUID();
        try {
            TarFileUtil.unTarAll(fileM63441g, str);
        } catch (C9721b e10) {
            String str2 = "unTar error srcFile: " + C10279b.m63452a(fileM63441g) + " , " + e10.toString();
            C11839m.m70689w("CloudRestoreV3FileDownload", str2);
            CloudBackupReport.reportUnTarError(this.f46264b, str2);
        }
        long jM57917H = m57917H(str);
        if (z10) {
            c12164f.m73035F0(this.f46268f.m73009x(), 2);
        } else {
            c12164f.m73033E0(this.f46268f.m72984h(), 2);
        }
        if (!fileM63441g.delete()) {
            C11839m.m70689w("CloudRestoreV3FileDownload", "downloadTARFile " + tarNameByCloudPath + " ,delete error");
        }
        C12571m.m75542d(str);
        return jM57917H;
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: i */
    public final void m57919i(long j10, File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.putExtra("datetaken", j10);
        intent.setData(Uri.fromFile(file));
        C0213f.m1377a().sendBroadcast(intent);
        C11839m.m70686d("CloudRestoreV3FileDownload", "dateTakenScan date_taken = " + j10 + " file is = " + C10279b.m63452a(file));
    }

    public final boolean isStringNull(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: k */
    public final String m57920k(C12161c c12161c) throws C9721b {
        return C12590s0.m75758J(c12161c, this.f46267e, "V4".equals(this.f46278p.f22517K), this.f46278p.getLocation() + File.separator + c12161c.m72974c());
    }

    /* renamed from: p */
    public final void m57921p(C12161c c12161c, String str, long j10) throws C9721b {
        File[] fileArrListFiles;
        C12590s0.m75845e1(str, j10, this.f46265c);
        this.f46280r = true;
        C9721b c9721bM57922q = m57922q(c12161c, str);
        if (c9721bM57922q == null) {
            return;
        }
        int uid = this.f46267e.getUid();
        String appId = this.f46267e.getAppId();
        if (m57911B(str, uid, appId)) {
            C11839m.m70688i("CloudRestoreV3FileDownload", "downloadFile chatsms android data file: " + str);
            String strM75670f = C12583q.m75670f(uid, ICBUtil.ANDROID_DATA, "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C12583q.m75680p(1));
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(appId);
            sb2.append(str2);
            String string = sb2.toString();
            String strReplaceFirst = str.replaceFirst(strM75670f, string);
            File fileM63442h = C10278a.m63442h(string);
            C12590s0.m75834b2(fileM63442h, true ^ "V4".equals(this.f46278p.f22517K));
            try {
                if (m57922q(c12161c, strReplaceFirst) == null && C0209d.m1179I1() && fileM63442h.exists() && (fileArrListFiles = fileM63442h.listFiles()) != null && fileArrListFiles.length > 0) {
                    File fileM63441g = C10278a.m63441g(fileM63442h, "com.android.providers.telephony.txt");
                    if (!fileM63441g.exists()) {
                        try {
                            C11839m.m70686d("CloudRestoreV3FileDownload", "create pms txt file result = " + fileM63441g.createNewFile());
                        } catch (IOException e10) {
                            C11839m.m70687e("CloudRestoreV3FileDownload", "create pms txt file error: " + e10.getMessage());
                        }
                    }
                    int iPmsRestore = new BackupRestoreUtil(C0213f.m1377a(), (CacheTask) null, this.f46265c).pmsRestore(string, C12583q.m75670f(uid, ICBUtil.ANDROID_DATA, "com.android.providers.telephony"), uid);
                    C11839m.m70688i("CloudRestoreV3FileDownload", "downloadFile chatsms android data file copy result: " + iPmsRestore);
                    if (iPmsRestore == 0) {
                        c9721bM57922q = null;
                    }
                }
            } finally {
                C11835i.m70642f(fileM63442h);
            }
        }
        if (c9721bM57922q == null) {
            return;
        }
        C12590s0.m75845e1(str, j10, this.f46265c);
        throw c9721bM57922q;
    }

    /* renamed from: q */
    public final C9721b m57922q(C12161c c12161c, String str) {
        C9721b c9721bM57925t = 1 == c12161c.m73010y() ? m57925t(c12161c, str) : m57926u(c12161c, str);
        if (c9721bM57925t == null) {
            return c9721bM57925t;
        }
        if (1 == c12161c.m73010y() && !TextUtils.isEmpty(c12161c.m72984h()) && c12161c.m72953I() != 7) {
            C11839m.m70688i("CloudRestoreV3FileDownload", "cloudPath and fileId both exist, download file with cloudPath again");
            return m57926u(c12161c, str);
        }
        if (c12161c.m73010y() != 0 || TextUtils.isEmpty(c12161c.m73009x())) {
            return c9721bM57925t;
        }
        C11839m.m70688i("CloudRestoreV3FileDownload", "flag is vfs, download file with fileId again");
        return m57925t(c12161c, str);
    }

    /* renamed from: r */
    public final void m57923r(C12161c c12161c) {
        final boolean z10 = c12161c.m72953I() == 7;
        this.f46271i.m64875i0(new InterfaceC10562l() { // from class: dm.h1
            @Override // im.InterfaceC10562l
            /* renamed from: a */
            public final void mo57819a(AbstractC10571u abstractC10571u) {
                this.f46233a.m57913D(z10, abstractC10571u);
            }
        });
    }

    public final void renameFile(File file, File file2) throws C9721b {
        C12590s0.m75816X1(C10278a.m63437c(file), !"V4".equals(this.f46278p.f22517K));
        if (file.exists() && !file.delete()) {
            C11839m.m70686d("CloudRestoreV3FileDownload", "rename file, delete old file error.");
            throw new C9721b(4001, "rename file, delete old file error,  file = " + C10279b.m63452a(file2));
        }
        boolean zM70640d = C11835i.m70640d(file2, file);
        if (!zM70640d) {
            C11839m.m70686d("CloudRestoreV3FileDownload", "use pms copy file, delete cache = " + file.delete());
            boolean z10 = new BackupRestoreUtil(C0213f.m1377a(), (CacheTask) null, this.f46265c).backup(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, C10279b.m63452a(file2), C10279b.m63452a(file)) == 0;
            C11839m.m70686d("CloudRestoreV3FileDownload", "use pms copy file result = " + z10);
            zM70640d = z10;
        }
        if (zM70640d) {
            C12593t0.m75970c(C10279b.m63452a(file), this.f46267e, this.f46278p, this.f46279q);
            C11839m.m70686d("CloudRestoreV3FileDownload", "copy file success, delete source file = " + file2.delete());
            if (file.exists()) {
                return;
            }
            throw new C9721b(4001, "copy file success, but file not exist, file = " + C10279b.m63452a(file2));
        }
        String str = "copy file failed, source file = " + C10279b.m63452a(file2) + " dest file = " + C10279b.m63452a(file) + " delete source file = " + file2.delete();
        C11839m.m70687e("CloudRestoreV3FileDownload", str);
        CloudBackupReport.reportUnTarError(this.f46264b, str);
    }

    /* renamed from: s */
    public final void m57924s(int i10, String str, long j10) {
        if (this.f46267e.isShowRestoreProgressTotal() && i10 == 7) {
            this.f46269g.mo7517d(this.f46277o);
        } else {
            this.f46269g.mo7516c(str, j10, this.f46268f, this.f46280r);
        }
    }

    /* renamed from: t */
    public final C9721b m57925t(final C12161c c12161c, final String str) {
        try {
            C10546a.m64704a(new C10546a.a() { // from class: dm.e1
                @Override // im.C10546a.a
                /* renamed from: a */
                public final InterfaceC10551c0 mo1696a() {
                    return this.f46165a.m57914E(c12161c, str);
                }
            }).m64705b();
            return null;
        } catch (C9721b e10) {
            return e10;
        }
    }

    /* renamed from: u */
    public final C9721b m57926u(final C12161c c12161c, final String str) {
        try {
            C10546a.m64704a(new C10546a.a() { // from class: dm.f1
                @Override // im.C10546a.a
                /* renamed from: a */
                public final InterfaceC10551c0 mo1696a() {
                    return this.f46171a.m57915F(c12161c, str);
                }
            }).m64705b();
            return null;
        } catch (C9721b e10) {
            return e10;
        }
    }

    /* renamed from: v */
    public final void m57927v(String str, int i10, long j10, String str2, C9721b c9721b) {
        boolean z10 = true;
        if (m57912C(this.f46268f)) {
            new C12164f(this.f46263a, this.f46268f.m72974c(), 1, this.f46267e.getUid()).m73027B0(this.f46268f.m73009x());
            C11839m.m70686d("CloudRestoreV3FileDownload", "isDMandCloudPath appId: " + str + " file: " + this.f46268f.m73009x());
            return;
        }
        if (this.f46276n && 6 == i10) {
            if (!"soundrecorder".equals(str) && !"callRecorder".equals(str)) {
                z10 = false;
            }
            if (!TextUtils.isEmpty(str2) && ((!str2.startsWith("/data") || z10) && c9721b.m60659c() == 3911 && c9721b.m60663g() == 404)) {
                C11839m.m70686d("CloudRestoreV3FileDownload", "download file error. ignore path = " + str2);
                m57924s(i10, str2, j10);
                return;
            }
        }
        try {
            C12590s0.m75845e1(str2, j10, this.f46265c);
        } catch (C9721b e10) {
            c9721b = e10;
            C11839m.m70689w("CloudRestoreV3FileDownload", "error local space not enough: " + str + " size: " + j10);
        }
        this.f46269g.mo7514a(c9721b);
    }

    /* renamed from: y */
    public final boolean m57928y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith(".dbhashfile")) {
            return true;
        }
        return str.endsWith(".differencepacket") && this.f46268f.m72953I() == 6;
    }

    /* renamed from: z */
    public final String m57929z(String str, String str2, String str3) {
        return str + str2 + "/" + str3;
    }
}
