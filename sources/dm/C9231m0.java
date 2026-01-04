package dm;

import am.InterfaceC0275i1;
import am.InterfaceC0278j1;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.PmsDataV3Management;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9720a;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p582ql.C12371b;
import p618rm.C12535a;
import p618rm.C12571m;
import p618rm.C12574n;
import p618rm.C12583q;
import p618rm.C12590s0;
import p682ul.C13216j;
import p744wl.C13617a;
import p848zl.C14333b;
import sl.C12815f;
import tl.C13029h;

/* renamed from: dm.m0 */
/* loaded from: classes6.dex */
public class C9231m0 {

    /* renamed from: a */
    public final C4879a f46337a;

    /* renamed from: b */
    public final C9215i0 f46338b;

    /* renamed from: c */
    public final String f46339c;

    /* renamed from: d */
    public final String f46340d;

    /* renamed from: e */
    public final String f46341e;

    /* renamed from: f */
    public final String f46342f;

    /* renamed from: g */
    public final boolean f46343g;

    /* renamed from: dm.m0$b */
    public class b extends ProgressCallback {
        public b() {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback, com.huawei.android.hicloud.connect.progress.ICallback
        public boolean onStop() throws InterruptedException {
            if (C9231m0.this.f46338b == null) {
                return super.onStop();
            }
            try {
                C9231m0.this.m57980A();
                return false;
            } catch (C9721b unused) {
                return true;
            }
        }

        public /* synthetic */ b(C9231m0 c9231m0, a aVar) {
            this();
        }
    }

    public C9231m0(C4879a c4879a, C9215i0 c9215i0, C13029h c13029h, String str, boolean z10) {
        this.f46337a = c4879a;
        this.f46338b = c9215i0;
        this.f46339c = c4879a.getLocation();
        this.f46340d = c4879a.m29743s0();
        this.f46341e = c13029h.m78465h();
        this.f46342f = str;
        this.f46343g = z10;
    }

    /* renamed from: G */
    public static /* synthetic */ boolean m57973G(String str, String str2) {
        return str2 != null && str2.startsWith(str);
    }

    /* renamed from: l */
    public static void m57979l(int i10, String str, String str2, BackupRestoreUtil backupRestoreUtil) {
        String strM75677m = C12583q.m75677m(str);
        String str3 = strM75677m + File.separator + str;
        File fileM63442h = C10278a.m63442h(str3);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70689w("CloudBackupV3ModulePrepare", "srcSplitCreateAndroidDir mkdir error: " + str3);
        }
        File fileM63443i = C10278a.m63443i(strM75677m, str + ".txt");
        try {
            if (!fileM63443i.exists() && !fileM63443i.createNewFile()) {
                C11839m.m70689w("CloudBackupV3ModulePrepare", "androidDirTxtFile create failed");
            }
        } catch (IOException e10) {
            C11839m.m70689w("CloudBackupV3ModulePrepare", "androidDirTxtFile create error: " + e10.getMessage());
        }
        C11839m.m70688i("CloudBackupV3ModulePrepare", "pmsCreateDirResult: " + backupRestoreUtil.pmsRestore(strM75677m, str2, i10));
    }

    /* renamed from: A */
    public final void m57980A() throws InterruptedException, C9721b {
        if (this.f46338b == null) {
            return;
        }
        if (!this.f46337a.isAutoBackup() || !this.f46337a.m29684Y0()) {
            this.f46338b.m59511j();
            return;
        }
        C11839m.m70688i("CloudBackupV3ModulePrepare", "app prepare exit, abnormal autobackup condition");
        int iM29710h0 = this.f46337a.m29710h0();
        throw new C9721b(iM29710h0, "app prepare exit, abnormal autobackup condition, err code = " + iM29710h0, "CloudBackupV3ModulePrepare");
    }

    /* renamed from: B */
    public final boolean m57981B(File file, String str, String str2, File file2, List<String> list, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        String strSubstring = SafeString.substring(C10279b.m63452a(file2), C10279b.m63452a(file).length() + 1);
        if (!TextUtils.equals(str, str2)) {
            strSubstring = strSubstring.replaceFirst(str, str2);
        }
        if (!m57983D(BackupRestoreConstans.DATA_PATH + strSubstring, cloudBackupAppDataUtil)) {
            return false;
        }
        list.add(strSubstring);
        return true;
    }

    /* renamed from: C */
    public final void m57982C(CloudBackupAppDataUtil cloudBackupAppDataUtil, String str, int i10) throws IllegalAccessException, NoSuchMethodException, C9721b, SecurityException, IllegalArgumentException, InvocationTargetException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (!ICBUtil.isForGroundProcess(str, m58005v(), i10, atomicInteger)) {
            if (cloudBackupAppDataUtil.isKillBackgroundApp()) {
                ICBUtil.closeBackGroundProcess(str, m58005v(), i10);
                return;
            }
            return;
        }
        C11839m.m70689w("CloudBackupV3ModulePrepare", "isForeGroundProcess = " + str);
        if (cloudBackupAppDataUtil.isBackupForegroundApp()) {
            if (cloudBackupAppDataUtil.isKillForegroundApp()) {
                ICBUtil.closeBackGroundProcess(str, m58005v(), i10);
            }
        } else {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, "ForeGroundProcess is running importance: " + atomicInteger.get());
        }
    }

    /* renamed from: D */
    public final boolean m57983D(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        boolean zIsMatchPathInfo = cloudBackupAppDataUtil.isMatchPathInfo(str, cloudBackupAppDataUtil.getmCloudBackupExclude(), true);
        C11839m.m70686d("CloudBackupV3ModulePrepare", "isMatchOMPath absolutePath = " + str + " ," + zIsMatchPathInfo);
        return zIsMatchPathInfo;
    }

    /* renamed from: E */
    public final /* synthetic */ void m57984E(long j10) {
        C9215i0 c9215i0 = this.f46338b;
        if (c9215i0 == null || c9215i0.m57864N() == null) {
            return;
        }
        this.f46338b.m57864N().mo29427p0(j10);
        C11963c.m71970y(this.f46338b.m57864N(), this.f46342f);
    }

    /* renamed from: F */
    public final /* synthetic */ void m57985F(long j10, long j11) {
        C9215i0 c9215i0 = this.f46338b;
        if (c9215i0 == null || c9215i0.m57864N() == null) {
            return;
        }
        this.f46338b.m57864N().mo29427p0(j10).mo29434s0(j11);
        C11963c.m71970y(this.f46338b.m57864N(), this.f46342f);
    }

    /* renamed from: H */
    public final void m57986H(File file, String str, StringBuffer stringBuffer) throws Throwable {
        String string = stringBuffer.toString();
        if (TextUtils.isEmpty(string)) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "originStr is empty");
            return;
        }
        String strReplaceAll = Pattern.compile(str).matcher(string).replaceAll("");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(strReplaceAll.getBytes(StandardCharsets.UTF_8));
                    C0209d.m1263i(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "matchAndWriteString FileNotFoundException");
                } catch (IOException unused2) {
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "matchAndWriteString IOException");
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: I */
    public final void m57987I(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws Throwable {
        if (cloudBackupStatus.m29863P()) {
            String strM29870d = cloudBackupStatus.m29870d();
            int iM29861N = cloudBackupStatus.m29861N();
            if (cloudBackupStatus.m29419m1() && cloudBackupStatus.m29425o1()) {
                m57982C(cloudBackupAppDataUtil, cloudBackupStatus.mo29421n(), iM29861N);
                ScanAppDataUtil scanAppDataUtil = new ScanAppDataUtil(strM29870d, cloudBackupStatus.m29861N(), cloudBackupStatus.mo29421n(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                if (this.f46343g) {
                    m57995k(cloudBackupStatus);
                    new PmsDataV3Management(this.f46337a, this.f46338b, new b(), cloudBackupStatus, m58008y(), this.f46341e, scanAppDataUtil, cloudBackupAppDataUtil).backup3rdAppDataIncrementV3(0, cloudBackupStatus, null);
                    PmsMetaStatusOperator pmsMetaStatusOperator = new PmsMetaStatusOperator(C13617a.m81914C(strM29870d, cloudBackupStatus.m29861N()));
                    if (pmsMetaStatusOperator.query() != null) {
                        pmsMetaStatusOperator.updateModifytime(System.currentTimeMillis());
                    }
                } else {
                    cloudBackupStatus.mo29449x0(1);
                    new C12815f(this.f46342f).m76934m(cloudBackupStatus);
                    m57988J(scanAppDataUtil, cloudBackupAppDataUtil, cloudBackupStatus);
                }
                if (cloudBackupStatus.mo29370Q()) {
                    m58007x(scanAppDataUtil, cloudBackupStatus);
                }
            }
        }
    }

    /* renamed from: J */
    public final void m57988J(ScanAppDataUtil scanAppDataUtil, CloudBackupAppDataUtil cloudBackupAppDataUtil, CloudBackupStatus cloudBackupStatus) throws Throwable {
        String strM29870d = cloudBackupStatus.m29870d();
        String strMo29421n = cloudBackupStatus.mo29421n();
        int iM29861N = cloudBackupStatus.m29861N();
        C11839m.m70688i("CloudBackupV3ModulePrepare", "backup 3rd data by pms start, appId = " + strM29870d);
        String strM58006w = m58006w(strM29870d);
        File fileM63442h = C10278a.m63442h(strM58006w);
        BackupCacheRecord.delete(m58005v(), strM29870d);
        C12571m.m75547i(strM58006w);
        try {
            m57990f(cloudBackupStatus, scanAppDataUtil, strM58006w);
        } catch (C9721b e10) {
            if (e10.m60659c() != 1020) {
                throw e10;
            }
            C11839m.m70688i("CloudBackupV3ModulePrepare", "pmsBackup retry, wait start");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException unused) {
                C11839m.m70688i("CloudBackupV3ModulePrepare", "pmsBackup wait excepiton");
            }
            C11839m.m70688i("CloudBackupV3ModulePrepare", "pmsBackup retry, wait end");
            BackupCacheRecord.delete(m58005v(), strM29870d);
            C12571m.m75547i(strM58006w);
            m57990f(cloudBackupStatus, scanAppDataUtil, strM58006w);
        }
        File fileM63441g = C10278a.m63441g(fileM63442h, strM29870d + ".txt");
        m58003t(cloudBackupStatus, fileM63442h, fileM63441g, cloudBackupAppDataUtil);
        m58001r(strM29870d, strMo29421n, iM29861N, fileM63442h, fileM63441g);
        m57993i(fileM63441g, C10278a.m63441g(fileM63442h, strM29870d));
        C11839m.m70688i("CloudBackupV3ModulePrepare", "backup 3rd data by pms end, appId = " + strM29870d);
    }

    /* renamed from: K */
    public final void m57989K(ScanAppDataUtil scanAppDataUtil, CloudBackupStatus cloudBackupStatus) throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        int iM29861N = cloudBackupStatus.m29861N();
        String strMo29421n = cloudBackupStatus.mo29421n();
        List<String> androidDataPaths = scanAppDataUtil.getAndroidDataPaths(cloudBackupStatus.m29861N());
        final String strM75670f = C12583q.m75670f(iM29861N, ICBUtil.ANDROID_DATA, strMo29421n);
        boolean zAnyMatch = androidDataPaths.stream().anyMatch(new Predicate() { // from class: dm.j0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9231m0.m57973G(strM75670f, (String) obj);
            }
        });
        cloudBackupStatus.m29432r1("0");
        if (zAnyMatch) {
            cloudBackupStatus.m29432r1("1");
            String strM29870d = cloudBackupStatus.m29870d();
            long packageSize = AppDataSizeUtil.getPackageSize(C0213f.m1377a(), strMo29421n, iM29861N);
            long dirSize = ScanAppDataUtil.getDirSize(C10278a.m63442h(m58006w(strM29870d)));
            m57992h(strM29870d, iM29861N, packageSize, dirSize);
            BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(m58005v(), this.f46337a, this.f46339c);
            if (backupRestoreUtil.backupAndroid(strM29870d, strMo29421n, iM29861N) == 0) {
                return;
            }
            m57979l(iM29861N, strMo29421n, strM75670f, backupRestoreUtil);
            if (backupRestoreUtil.backupAndroid(strM29870d, strMo29421n, iM29861N) == 0) {
                return;
            }
            m57992h(strM29870d, iM29861N, packageSize, dirSize);
            throw new C9721b(2101, "R version copy android data error");
        }
    }

    /* renamed from: f */
    public final void m57990f(CloudBackupStatus cloudBackupStatus, ScanAppDataUtil scanAppDataUtil, String str) throws C9721b {
        this.f46338b.m57864N().mo29427p0(0L).mo29434s0(ScanAppDataUtil.get3rdAppDataDirSize(cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N()));
        scanAppDataUtil.appDataPrepare(str, this.f46337a, cloudBackupStatus.m29870d(), cloudBackupStatus.mo29421n(), new InterfaceC0275i1() { // from class: dm.l0
            @Override // am.InterfaceC0275i1
            /* renamed from: a */
            public final void mo1767a(long j10) {
                this.f46331a.m57984E(j10);
            }
        });
    }

    /* renamed from: g */
    public final void m57991g(CloudBackupStatus cloudBackupStatus, Bundle bundle) throws InterruptedException, C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        C12535a c12535a = new C12535a(this.f46337a, cloudBackupStatus.m29870d(), cloudBackupStatus.mo29421n());
        if (m58009z(cloudBackupStatus) || !c12535a.m75463a(cloudBackupStatus)) {
            C11839m.m70686d("CloudBackupV3ModulePrepare", "backup3rdApk appId = " + strM29870d + " isAppLost = " + m58009z(cloudBackupStatus));
            File fileM59506c = this.f46338b.m59506c(cloudBackupStatus, bundle);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("normalApk is null appId: ");
            sb2.append(strM29870d);
            C9720a.m60657f(fileM59506c, sb2.toString());
            cloudBackupStatus.mo29321d0(fileM59506c.length());
            cloudBackupStatus.m29405g2("");
            cloudBackupStatus.m29350G1("");
            new C12815f(this.f46337a.m29713i0()).m76934m(cloudBackupStatus);
        }
    }

    /* renamed from: h */
    public final void m57992h(String str, int i10, long j10, long j11) throws C9721b {
        long j12 = j10 - j11;
        if (j12 <= 0) {
            j12 = 0;
        }
        long jM75856h0 = j12 + C12590s0.m75856h0();
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        C11839m.m70688i("CloudBackupV3ModulePrepare", "copy android data space check appId: " + str + " ,uid: " + i10 + " ,pgsize: " + j10 + " ,datasize: " + j11 + " needSize: " + jM75856h0);
        if (localLeftSpace == null || localLeftSpace.longValue() >= jM75856h0) {
            return;
        }
        C12590s0.m75777N2(jM75856h0 - localLeftSpace.longValue());
        throw new C9721b(1007, "copy android data local space not enough, appId: " + str + " ,uid: " + i10 + " ,pgsize: " + j10 + " ,datasize: " + j11 + " needSize: " + jM75856h0);
    }

    /* renamed from: i */
    public final boolean m57993i(File file, File file2) throws C9721b {
        if (file2.exists() && file2.listFiles() != null && file2.listFiles().length > 0) {
            return false;
        }
        C11839m.m70688i("CloudBackupV3ModulePrepare", "checkTxtVaild end, temppath isEmpty()");
        if (!file.exists() || file.delete()) {
            return true;
        }
        throw new C9721b(1017, "checkTxtVaild delete txt error");
    }

    /* renamed from: j */
    public final void m57994j(CloudBackupStatus cloudBackupStatus, boolean z10, Bundle bundle) throws InterruptedException, C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29355J0 = cloudBackupStatus.m29355J0();
        int iM29861N = cloudBackupStatus.m29861N();
        String str = this.f46339c + File.separator + strM29870d;
        if (!CloneService.getInstance().getModuleInfoList().isEmpty()) {
            new C12371b(this.f46341e, strM29870d, iM29355J0, iM29861N).clear();
            CloneService.getInstance().clearModuleInfoList();
        }
        BackupCacheRecord.delete(m58005v(), strM29870d);
        C12571m.m75547i(str);
        if (C10278a.m63442h(str).exists()) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "use pms move delete cache file, path = " + str);
            ScanAppDataUtil.executePmsMoveProcess(str);
        }
        if (z10) {
            m57991g(cloudBackupStatus, bundle);
        } else {
            m57999p(strM29870d, this.f46339c, bundle, 0, new InterfaceC0278j1() { // from class: dm.k0
                @Override // am.InterfaceC0278j1
                /* renamed from: a */
                public final void mo1768a(long j10, long j11) {
                    this.f46326a.m57985F(j10, j11);
                }
            });
        }
    }

    /* renamed from: k */
    public final void m57995k(CloudBackupStatus cloudBackupStatus) {
        if (this.f46338b.m57865O().m61921h0(cloudBackupStatus)) {
            C13216j.m79422g(C13617a.m81914C(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N()));
        }
    }

    /* renamed from: m */
    public final void m57996m(File file, String str, String str2, List<String> list, CloudBackupAppDataUtil cloudBackupAppDataUtil, File file2) throws C9721b {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            String strM63452a = C10279b.m63452a(file3);
            boolean zIsDirectory = file3.isDirectory();
            if (m57981B(file2, str, str2, file3, list, cloudBackupAppDataUtil)) {
                C11839m.m70686d("CloudBackupV3ModulePrepare", "deleteFromTempDir isFilterDataPath true " + strM63452a + "," + zIsDirectory);
                C12571m.m75547i(strM63452a);
                if (file3.exists()) {
                    throw new C9721b(1017, "deleteFromTempDir error = " + strM63452a + ", directory " + zIsDirectory);
                }
            } else if (zIsDirectory) {
                m57996m(file3, str, str2, list, cloudBackupAppDataUtil, file2);
            }
        }
    }

    /* renamed from: n */
    public final void m57997n(File file, int i10, List<String> list) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        File fileM63441g = C10278a.m63441g(C10278a.m63437c(file), "tempfile");
        if (fileM63441g.exists() && !fileM63441g.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "filterDataFile tempFile delete error");
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            sb2.append("(");
            sb2.append(BackupRestoreConstans.getUserPath(i10));
            sb2.append("/");
            sb2.append(next);
            sb2.append(")");
            if (it.hasNext()) {
                sb2.append("|");
            }
        }
        String str = "(" + ((CharSequence) sb2) + ")[\\s\\S]*?[;]+[0-9]+[\\n]";
        C11839m.m70686d("CloudBackupV3ModulePrepare", "deleteTXTLine regex = " + str);
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (FileNotFoundException e10) {
                        e = e10;
                    } catch (IOException e11) {
                        e = e11;
                    } catch (Throwable th2) {
                        th = th2;
                        C0209d.m1263i(bufferedReader2);
                        C0209d.m1263i(inputStreamReader);
                        C0209d.m1263i(fileInputStream);
                        throw th;
                    }
                    try {
                        String line = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(line) && line.startsWith(BackupRestoreConstans.getUserPath(i10))) {
                            stringBuffer.append(line);
                            stringBuffer.append(System.lineSeparator());
                            int i11 = 0;
                            while (true) {
                                String line2 = bufferedReader.readLine();
                                if (line2 == null) {
                                    C0209d.m1263i(bufferedReader);
                                    C0209d.m1263i(inputStreamReader);
                                    C0209d.m1263i(fileInputStream);
                                    m57998o(file, fileM63441g, str, stringBuffer);
                                    C11839m.m70688i("CloudBackupV3ModulePrepare", "deleteTXTLine regex end");
                                    return;
                                }
                                m57980A();
                                i11++;
                                if (i11 >= 1000 && line2.startsWith(BackupRestoreConstans.getUserPath(i10))) {
                                    m57986H(fileM63441g, str, stringBuffer);
                                    stringBuffer.delete(0, stringBuffer.length());
                                    i11 = 0;
                                }
                                stringBuffer.append(line2);
                                stringBuffer.append(System.lineSeparator());
                            }
                        }
                        C11839m.m70689w("CloudBackupV3ModulePrepare", "deleteTXTLine first line is invalid.");
                        C0209d.m1263i(bufferedReader);
                        C0209d.m1263i(inputStreamReader);
                        C0209d.m1263i(fileInputStream);
                    } catch (FileNotFoundException e12) {
                        e = e12;
                        C11839m.m70687e("CloudBackupV3ModulePrepare", "filterDataFile FileNotFoundException: " + e.toString());
                        throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterDataFile FileNotFoundException delete error " + e.toString());
                    } catch (IOException e13) {
                        e = e13;
                        C11839m.m70687e("CloudBackupV3ModulePrepare", "filterDataFile IOException: " + e.toString());
                        throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterDataFile IOException delete error " + e.toString());
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        C0209d.m1263i(bufferedReader2);
                        C0209d.m1263i(inputStreamReader);
                        C0209d.m1263i(fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                } catch (IOException e15) {
                    e = e15;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException e17) {
                e = e17;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }

    /* renamed from: o */
    public final void m57998o(File file, File file2, String str, StringBuffer stringBuffer) throws Throwable {
        if (stringBuffer.length() > 0) {
            m57986H(file2, str, stringBuffer);
        }
        boolean zDelete = file.delete();
        if (zDelete && file2.renameTo(file)) {
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterDataFile delete error or rename error = " + zDelete);
    }

    /* renamed from: p */
    public final void m57999p(String str, String str2, Bundle bundle, int i10, InterfaceC0278j1 interfaceC0278j1) throws InterruptedException, C9721b {
        this.f46338b.m59507d(str, str2, bundle, i10, interfaceC0278j1);
    }

    /* renamed from: q */
    public void m58000q(CloudBackupStatus cloudBackupStatus, Bundle bundle, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws IllegalAccessException, C9721b, IllegalArgumentException, InvocationTargetException {
        if (cloudBackupStatus.m29867U()) {
            return;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        try {
            try {
                C11839m.m70688i("CloudBackupV3ModulePrepare", "prepare data begin, appId = " + strM29870d + " uid: " + cloudBackupStatus.m29861N() + ", backupId: " + this.f46341e);
                m57980A();
                m57994j(cloudBackupStatus, cloudBackupStatus.m29863P(), bundle);
                m57980A();
                m57987I(cloudBackupStatus, cloudBackupAppDataUtil);
            } catch (C9721b e10) {
                if (e10.m60659c() != 2012 || (!("phoneManager".equalsIgnoreCase(strM29870d) || "Memo".equalsIgnoreCase(strM29870d) || "smartcare".equalsIgnoreCase(strM29870d)) || C12590s0.m75803U0(C14333b.f63651c.get(cloudBackupStatus.mo29421n()), m58005v()))) {
                    throw e10;
                }
                throw new C9721b(1998, "clone backup data error, file length is zero, package name not found, appId =" + strM29870d);
            }
        } finally {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "prepare data end, appId = " + strM29870d);
            if (!this.f46338b.m57877a0()) {
                C12590s0.m75753H2(cloudBackupStatus.mo29421n(), cloudBackupAppDataUtil, cloudBackupStatus.m29861N());
                this.f46338b.m57895p0(true);
            }
        }
    }

    /* renamed from: r */
    public final void m58001r(String str, String str2, int i10, File file, File file2) throws Throwable {
        InputStreamReader inputStreamReader;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        int i11;
        BufferedReader bufferedReader;
        Object obj;
        Object obj2;
        InputStreamReader inputStreamReader2;
        File fileM58004u = m58004u(str, file, file2);
        if (fileM58004u == null) {
            return;
        }
        int i12 = FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                try {
                    inputStreamReader2 = new InputStreamReader(fileInputStream2, StandardCharsets.UTF_8);
                } catch (FileNotFoundException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    i11 = 1016;
                    obj2 = null;
                } catch (IOException e11) {
                    e = e11;
                    fileInputStream = fileInputStream2;
                    i11 = 1016;
                    obj = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    inputStreamReader = null;
                    fileOutputStream = null;
                }
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(fileM58004u, true);
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("(");
                            sb2.append(BackupRestoreConstans.getUserPath(i10));
                            sb2.append("/[^;\\n]+)+(;\\d+){4}");
                            C11839m.m70688i("CloudBackupV3ModulePrepare", str + " filterAbnormalFile regexNormal=" + sb2.toString());
                            Pattern patternCompile = Pattern.compile(sb2.toString());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("(");
                            sb3.append(BackupRestoreConstans.getUserPath(i10));
                            sb3.append("/)+[\\s\\S]+(;\\d+){4}");
                            C11839m.m70688i("CloudBackupV3ModulePrepare", str + " filterAbnormalFile regexAbnormal=" + sb3.toString());
                            Pattern patternCompile2 = Pattern.compile(sb3.toString());
                            while (true) {
                                String line = bufferedReader3.readLine();
                                if (line == null) {
                                    break;
                                }
                                m57980A();
                                fileOutputStream = fileOutputStream2;
                                bufferedReader = bufferedReader3;
                                inputStreamReader = inputStreamReader2;
                                fileInputStream = fileInputStream2;
                                i11 = i12;
                                try {
                                    m58002s(str, str2, i10, file, fileOutputStream2, line, stringBuffer, patternCompile, patternCompile2);
                                    i12 = i11;
                                    inputStreamReader2 = inputStreamReader;
                                    fileOutputStream2 = fileOutputStream;
                                    bufferedReader3 = bufferedReader;
                                    fileInputStream2 = fileInputStream;
                                } catch (FileNotFoundException e12) {
                                    e = e12;
                                    C11839m.m70687e("CloudBackupV3ModulePrepare", "filterAbnormalFile FileNotFoundException: " + e.toString());
                                    throw new C9721b(i11, "filterAbnormalFile FileNotFoundException " + e.toString());
                                } catch (IOException e13) {
                                    e = e13;
                                    C11839m.m70687e("CloudBackupV3ModulePrepare", "filterAbnormalFile IOException: " + e.toString());
                                    throw new C9721b(i11, "filterAbnormalFile IOException " + e.toString());
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedReader2 = bufferedReader;
                                    C0209d.m1263i(bufferedReader2);
                                    C0209d.m1263i(inputStreamReader);
                                    C0209d.m1263i(fileInputStream);
                                    C0209d.m1263i(fileOutputStream);
                                    throw th;
                                }
                            }
                            int i13 = i12;
                            C0209d.m1263i(bufferedReader3);
                            C0209d.m1263i(inputStreamReader2);
                            C0209d.m1263i(fileInputStream2);
                            C0209d.m1263i(fileOutputStream2);
                            boolean zDelete = file2.delete();
                            if (!zDelete || !fileM58004u.renameTo(file2)) {
                                throw new C9721b(i13, "filterAbnormalFile delete or rename error = " + zDelete);
                            }
                            C11839m.m70688i("CloudBackupV3ModulePrepare", str + " filterAbnormalFile end");
                        } catch (FileNotFoundException e14) {
                            e = e14;
                            fileInputStream = fileInputStream2;
                            i11 = i12;
                        } catch (IOException e15) {
                            e = e15;
                            fileInputStream = fileInputStream2;
                            i11 = i12;
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                            bufferedReader = bufferedReader3;
                            inputStreamReader = inputStreamReader2;
                            fileInputStream = fileInputStream2;
                        }
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        i11 = 1016;
                    } catch (IOException e17) {
                        e = e17;
                        fileInputStream = fileInputStream2;
                        i11 = 1016;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader3;
                        inputStreamReader = inputStreamReader2;
                        fileInputStream = fileInputStream2;
                        fileOutputStream = null;
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    i11 = 1016;
                    obj2 = null;
                    C11839m.m70687e("CloudBackupV3ModulePrepare", "filterAbnormalFile FileNotFoundException: " + e.toString());
                    throw new C9721b(i11, "filterAbnormalFile FileNotFoundException " + e.toString());
                } catch (IOException e19) {
                    e = e19;
                    fileInputStream = fileInputStream2;
                    i11 = 1016;
                    obj = null;
                    C11839m.m70687e("CloudBackupV3ModulePrepare", "filterAbnormalFile IOException: " + e.toString());
                    throw new C9721b(i11, "filterAbnormalFile IOException " + e.toString());
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader = inputStreamReader2;
                    fileInputStream = fileInputStream2;
                    fileOutputStream = null;
                    C0209d.m1263i(bufferedReader2);
                    C0209d.m1263i(inputStreamReader);
                    C0209d.m1263i(fileInputStream);
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e20) {
                e = e20;
                i11 = 1016;
            } catch (IOException e21) {
                e = e21;
                i11 = 1016;
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
                fileOutputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            fileInputStream = null;
        }
    }

    /* renamed from: s */
    public final void m58002s(String str, String str2, int i10, File file, OutputStream outputStream, String str3, StringBuffer stringBuffer, Pattern pattern, Pattern pattern2) throws C9721b, IOException {
        if (stringBuffer.length() > 0) {
            stringBuffer.append("\n");
            stringBuffer.append(str3);
            C11839m.m70686d("CloudBackupV3ModulePrepare", " filterAbnormalFile deal new line=" + stringBuffer.toString());
            if (pattern2.matcher(stringBuffer).matches()) {
                C12574n.m75560m(str, str2, i10, stringBuffer.toString(), file);
                stringBuffer.delete(0, stringBuffer.length());
                return;
            }
            return;
        }
        if (pattern.matcher(str3).matches()) {
            C11839m.m70686d("CloudBackupV3ModulePrepare", "filterAbnormalFile normal line=" + str3);
            Charset charset = StandardCharsets.UTF_8;
            outputStream.write(str3.getBytes(charset));
            outputStream.write("\n".getBytes(charset));
            return;
        }
        C11839m.m70686d("CloudBackupV3ModulePrepare", "filterAbnormalFile abnormal line=" + str3);
        if (pattern2.matcher(str3).matches()) {
            C12574n.m75560m(str, str2, i10, str3, file);
            return;
        }
        C11839m.m70686d("CloudBackupV3ModulePrepare", "filterAbnormalFile new line=" + str3);
        stringBuffer.append(str3);
    }

    /* renamed from: t */
    public final void m58003t(CloudBackupStatus cloudBackupStatus, File file, File file2, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws Throwable {
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        if (!file2.exists()) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "filterDataFile txt file not exist " + strM29870d);
            return;
        }
        C11839m.m70688i("CloudBackupV3ModulePrepare", strM29870d + " filterDataFile start");
        File fileM63441g = C10278a.m63441g(file, strM29870d);
        if (m57993i(file2, fileM63441g)) {
            return;
        }
        if (!cloudBackupAppDataUtil.needFilterData()) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", strM29870d + " no data path filter");
            return;
        }
        ArrayList arrayList = new ArrayList();
        m57996m(fileM63441g, strM29870d, cloudBackupStatus.mo29421n(), arrayList, cloudBackupAppDataUtil, file);
        if (arrayList.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "filterDataFile end deletePaths.isEmpty");
        } else {
            m57997n(file2, iM29861N, arrayList);
            C11839m.m70688i("CloudBackupV3ModulePrepare", "filterDataFile end");
        }
    }

    /* renamed from: u */
    public final File m58004u(String str, File file, File file2) throws C9721b {
        if (!file2.exists()) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "filterAbnormalFile txt file not exist " + str);
            return null;
        }
        if (m57993i(file2, C10278a.m63441g(file, str))) {
            C11839m.m70688i("CloudBackupV3ModulePrepare", "filterAbnormalFile tempPackageDir not exist");
            return null;
        }
        C11839m.m70688i("CloudBackupV3ModulePrepare", str + " filterAbnormalFile start");
        File fileM63441g = C10278a.m63441g(C10278a.m63437c(file2), "temp_index_file");
        if (!fileM63441g.exists() || fileM63441g.delete()) {
            return fileM63441g;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "filterAbnormalFile tempFile delete error");
    }

    /* renamed from: v */
    public final Context m58005v() {
        return C0213f.m1377a();
    }

    /* renamed from: w */
    public final String m58006w(String str) {
        return this.f46340d + File.separator + str;
    }

    /* renamed from: x */
    public final void m58007x(ScanAppDataUtil scanAppDataUtil, CloudBackupStatus cloudBackupStatus) throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        if (!SplitAppUtil.notSupportSplitAndroidScanVersion()) {
            cloudBackupStatus.m29432r1("0");
            C11839m.m70688i("CloudBackupV3ModulePrepare", "version < R, scan file backup");
        } else if (this.f46343g) {
            cloudBackupStatus.m29432r1("2");
        } else {
            m57989K(scanAppDataUtil, cloudBackupStatus);
        }
        new C12815f().m76934m(cloudBackupStatus);
    }

    /* renamed from: y */
    public final List<Bak> m58008y() {
        ArrayList arrayList = new ArrayList();
        if (!this.f46337a.m29699d1() && !this.f46337a.isRefurbishment()) {
            return this.f46337a.m29646K0();
        }
        C11839m.m70688i("CloudBackupV3ModulePrepare", "isFullBK. get last success bak id null");
        return arrayList;
    }

    /* renamed from: z */
    public final boolean m58009z(CloudBackupStatus cloudBackupStatus) {
        C4879a c4879a = this.f46337a;
        if (c4879a == null || c4879a.m29731o0() == null || this.f46337a.m29731o0().m61892J() == null || cloudBackupStatus == null) {
            return false;
        }
        boolean zContainsKey = this.f46337a.m29731o0().m61892J().containsKey(cloudBackupStatus.m29870d());
        C9215i0 c9215i0 = this.f46338b;
        if (c9215i0 != null && c9215i0.m57870T() != null) {
            this.f46338b.m57870T().put("leftSpaceSize", zContainsKey ? "1" : "0");
        }
        return zContainsKey;
    }
}
