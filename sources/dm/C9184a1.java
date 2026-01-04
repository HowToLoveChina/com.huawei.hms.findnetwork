package dm;

import am.InterfaceC0275i1;
import android.os.SystemClock;
import android.text.TextUtils;
import bm.InterfaceC1260a;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.FileExchangeDb;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.PmsDataV3Processor;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFastTarOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFastTarSuccessOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoForUploadOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CompressionPolicyUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mk.C11476b;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p495nm.C11728i;
import p514o9.C11835i;
import p514o9.C11839m;
import p606r9.C12478a;
import p617rl.C12526j;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12610z0;
import p652t9.EnumC12999a;
import p744wl.C13617a;
import pl.C12164f;

/* renamed from: dm.a1 */
/* loaded from: classes6.dex */
public class C9184a1 extends CloudBackupModuleTask {

    /* renamed from: p */
    public static final Object f46037p = new Object();

    /* renamed from: q */
    public static final Object f46038q = new Object();

    /* renamed from: a */
    public C9721b f46039a;

    /* renamed from: b */
    public C4879a f46040b;

    /* renamed from: c */
    public C9215i0 f46041c;

    /* renamed from: d */
    public final PmsDataV3Processor f46042d;

    /* renamed from: e */
    public CloudBackupStatus f46043e;

    /* renamed from: f */
    public long f46044f;

    /* renamed from: g */
    public long f46045g;

    /* renamed from: h */
    public long f46046h;

    /* renamed from: i */
    public volatile long f46047i;

    /* renamed from: j */
    public int f46048j;

    /* renamed from: k */
    public boolean f46049k;

    /* renamed from: l */
    public boolean f46050l;

    /* renamed from: m */
    public long f46051m;

    /* renamed from: n */
    public C12526j f46052n;

    /* renamed from: o */
    public long f46053o;

    /* renamed from: dm.a1$a */
    public class a implements InterfaceC1260a {

        /* renamed from: a */
        public final /* synthetic */ PmsMetaV3 f46054a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC9213h2 f46055b;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f46056c;

        public a(PmsMetaV3 pmsMetaV3, InterfaceC9213h2 interfaceC9213h2, CountDownLatch countDownLatch) {
            this.f46054a = pmsMetaV3;
            this.f46055b = interfaceC9213h2;
            this.f46056c = countDownLatch;
        }

        @Override // bm.InterfaceC1260a
        /* renamed from: a */
        public void mo7511a(long j10) {
            synchronized (C9184a1.f46037p) {
                try {
                    C9184a1.m57677q(C9184a1.this, j10);
                    C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "onReturnIncreaseSizeFile appId = " + ((CloudBackupModuleTask) C9184a1.this).appId + " alreadyBytes = " + C9184a1.this.f46047i);
                    C9184a1.this.f46043e.mo29308V(C9184a1.this.f46047i);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - C9184a1.this.f46051m >= RippleView.SINGLE_RIPPLE_TIME) {
                        C9184a1.this.f46051m = jCurrentTimeMillis;
                        C11963c.m71970y(C9184a1.this.f46043e, C9184a1.this.f46040b.m29713i0());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // bm.InterfaceC1260a
        /* renamed from: b */
        public void mo7512b(C9721b c9721b) {
            if (c9721b.m60659c() != 1013 && this.f46055b.mo57843d0()) {
                C9184a1.this.m57669R(c9721b);
                return;
            }
            try {
                C9184a1.this.m57691L(this.f46054a);
            } catch (C9721b e10) {
                C9184a1.this.m57669R(e10);
            }
        }

        @Override // bm.InterfaceC1260a
        /* renamed from: c */
        public void mo7513c() {
            synchronized (C9184a1.f46037p) {
                try {
                    C9184a1.m57674i(C9184a1.this);
                    C9184a1.this.f46043e.mo29310W(C9184a1.this.f46048j).mo29308V(C9184a1.this.f46047i);
                    C11963c.m71970y(C9184a1.this.f46043e, C9184a1.this.f46040b.m29713i0());
                    if (C9184a1.this.f46041c != null) {
                        C9184a1.this.f46041c.m57893o0(C9184a1.this.f46041c.m57867Q() + this.f46054a.getSize());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // bm.InterfaceC1260a
        public void release() {
            synchronized (C9184a1.f46037p) {
                this.f46056c.countDown();
                C9184a1.m57684z(C9184a1.this);
                C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "upload file release uploadFileCount: " + C9184a1.this.f46046h);
            }
        }
    }

    /* renamed from: dm.a1$b */
    public class b implements InterfaceC1260a {

        /* renamed from: a */
        public final /* synthetic */ int f46058a;

        /* renamed from: b */
        public final /* synthetic */ long f46059b;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f46060c;

        public b(int i10, long j10, CountDownLatch countDownLatch) {
            this.f46058a = i10;
            this.f46059b = j10;
            this.f46060c = countDownLatch;
        }

        @Override // bm.InterfaceC1260a
        /* renamed from: a */
        public void mo7511a(long j10) {
            synchronized (C9184a1.f46037p) {
                try {
                    C9184a1.m57678r(C9184a1.this, j10 * 0.5d);
                    C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "onReturnIncreaseSizeFile appId = " + ((CloudBackupModuleTask) C9184a1.this).appId + " alreadyBytes = " + C9184a1.this.f46047i);
                    C9184a1.this.f46043e.mo29308V(C9184a1.this.f46047i);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - C9184a1.this.f46051m >= RippleView.SINGLE_RIPPLE_TIME) {
                        C9184a1.this.f46051m = jCurrentTimeMillis;
                        C11963c.m71970y(C9184a1.this.f46043e, C9184a1.this.f46040b.m29713i0());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // bm.InterfaceC1260a
        /* renamed from: b */
        public void mo7512b(C9721b c9721b) {
            C9184a1.this.m57669R(c9721b);
        }

        @Override // bm.InterfaceC1260a
        /* renamed from: c */
        public void mo7513c() {
            C9184a1.m57675k(C9184a1.this, this.f46058a);
            C9184a1.this.f46043e.mo29310W(C9184a1.this.f46048j).mo29308V(C9184a1.this.f46047i);
            C11963c.m71970y(C9184a1.this.f46043e, C9184a1.this.f46040b.m29713i0());
            if (C9184a1.this.f46041c != null) {
                C9184a1.this.f46041c.m57893o0(C9184a1.this.f46041c.m57867Q() + this.f46059b);
            }
        }

        @Override // bm.InterfaceC1260a
        public void release() {
            synchronized (C9184a1.f46037p) {
                int i10 = 0;
                while (true) {
                    try {
                        int i11 = this.f46058a;
                        if (i10 < i11) {
                            this.f46060c.countDown();
                            i10++;
                        } else {
                            C9184a1.m57664A(C9184a1.this, i11);
                            C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "uploadTarFile release tarFileCount : " + this.f46058a + " ,uploadfilecount: " + C9184a1.this.f46046h);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public C9184a1(PmsDataV3Processor pmsDataV3Processor, C4879a c4879a, C9215i0 c9215i0, CloudBackupStatus cloudBackupStatus, long j10, long j11, C11728i c11728i) {
        super(cloudBackupStatus.m29870d());
        this.f46050l = false;
        this.f46051m = 0L;
        this.f46052n = new C12526j();
        this.f46053o = 0L;
        this.f46042d = pmsDataV3Processor;
        this.f46040b = c4879a;
        this.f46041c = c9215i0;
        this.f46043e = cloudBackupStatus;
        this.f46047i = cloudBackupStatus.m29868a();
        this.f46048j = cloudBackupStatus.m29869c();
        this.f46044f = j10;
        this.f46045g = j11;
        this.mCompressParams = c11728i;
    }

    /* renamed from: A */
    public static /* synthetic */ long m57664A(C9184a1 c9184a1, long j10) {
        long j11 = c9184a1.f46046h + j10;
        c9184a1.f46046h = j11;
        return j11;
    }

    /* renamed from: E */
    private void m57668E() {
        this.mCompressParams.m69981h(this.f46043e.m29863P());
        this.mCompressParams.m69982i(this.f46040b.m29747t1("sparse"));
        this.mCompressParams.m69980g(CompressionPolicyUtil.getCompressionPolicy(this.appId, this.f46043e.m29863P()));
    }

    /* renamed from: R */
    public void m57669R(Throwable th2) {
        synchronized (f46038q) {
            try {
                if (this.f46039a == null) {
                    if (th2 instanceof C9721b) {
                        this.f46039a = (C9721b) th2;
                    } else {
                        this.f46039a = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error." + th2.toString() + ",stackTrace: " + C12590s0.m75731C0(th2));
                    }
                    if (this.f46039a.m60659c() == 3900 && !C0209d.m1254f2(C0213f.m1377a())) {
                        this.f46039a = new C9721b(1002, this.f46039a.getMessage());
                    }
                    this.f46042d.error(this.f46039a);
                    this.f46041c.mo57894p(this.f46039a);
                    C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "task error. " + th2.toString() + ", exception" + this.f46039a.toString());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* renamed from: i */
    public static /* synthetic */ int m57674i(C9184a1 c9184a1) {
        int i10 = c9184a1.f46048j;
        c9184a1.f46048j = i10 + 1;
        return i10;
    }

    private long increaseSize(long j10) {
        long j11 = j10 - this.f46053o;
        this.f46053o = j10;
        if (j11 < 0) {
            j11 = 0;
        }
        C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "uploadPMSTarFile increaseSize: " + j11);
        return j11;
    }

    private void isCancel() throws InterruptedException, C9721b {
        this.f46041c.m59511j();
        if (this.abort) {
            throw new C9721b(1999, "task is interrupted.");
        }
        C9721b c9721b = this.f46039a;
        if (c9721b != null) {
            throw c9721b;
        }
    }

    /* renamed from: k */
    public static /* synthetic */ int m57675k(C9184a1 c9184a1, int i10) {
        int i11 = c9184a1.f46048j + i10;
        c9184a1.f46048j = i11;
        return i11;
    }

    /* renamed from: q */
    public static /* synthetic */ long m57677q(C9184a1 c9184a1, long j10) {
        long j11 = c9184a1.f46047i + j10;
        c9184a1.f46047i = j11;
        return j11;
    }

    /* renamed from: r */
    public static /* synthetic */ long m57678r(C9184a1 c9184a1, double d10) {
        long j10 = (long) (c9184a1.f46047i + d10);
        c9184a1.f46047i = j10;
        return j10;
    }

    /* renamed from: z */
    public static /* synthetic */ long m57684z(C9184a1 c9184a1) {
        long j10 = c9184a1.f46046h;
        c9184a1.f46046h = 1 + j10;
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* renamed from: F */
    public final void m57685F(File file, String str, String str2, List<PmsMetaV3> list, PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3, FileExchangeDb fileExchangeDb, PmsBatchFastTarOperatorV3 pmsBatchFastTarOperatorV3) throws Throwable {
        FileOutputStream fileOutputStream;
        Object obj;
        ?? r02;
        Exception e10;
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream;
        ?? r12 = 1;
        C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "createPmsTarSrcTxtFile delete pmsTarSrcTxt result: " + (file.exists() && !file.delete()));
        File fileM63437c = C10278a.m63437c(file);
        if (fileM63437c != null && !fileM63437c.exists() && !fileM63437c.mkdirs()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createPmsTarSrcTxtFile mkdirs error " + C10279b.m63452a(file));
        }
        try {
            boolean zExists = file.exists();
            boolean z10 = zExists;
            if (!zExists) {
                boolean zCreateNewFile = file.createNewFile();
                if (!zCreateNewFile) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createPmsTarSrcTxtFile createNewFile error " + C10279b.m63452a(file));
                }
                z10 = zCreateNewFile;
            }
            try {
                try {
                    fileOutputStream2 = new FileOutputStream(file, true);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    } catch (Exception e11) {
                        e = e11;
                        e10 = e;
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createPmsTarSrcTxtFile create pmsTarSrcTxt error:" + e10.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        r02 = fileOutputStream;
                        r12 = obj;
                        C0209d.m1263i(r12);
                        C0209d.m1263i(r02);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    obj = null;
                }
                try {
                    for (PmsMetaV3 pmsMetaV3 : list) {
                        if (pmsMetaV3 == null) {
                            C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "createPmsTarSrcTxtFile meta is empty");
                        } else {
                            String string = pmsMetaV3.toString();
                            if (TextUtils.isEmpty(string)) {
                                C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "createPmsTarSrcTxtFile originStr is empty");
                            } else {
                                if (TextUtils.isEmpty(pmsMetaV3.getFilePath()) || !pmsMetaV3.getFilePath().startsWith(str)) {
                                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createPmsTarSrcTxtFile tarRootPath error:" + pmsMetaV3.getFilePath() + " tarRootPath:" + str);
                                }
                                bufferedOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
                                pmsFullBriefFilesInfoForUploadOperatorV3.updateFileInfoByFilePath(str2, pmsMetaV3);
                            }
                        }
                    }
                    bufferedOutputStream.flush();
                    C0209d.m1263i(bufferedOutputStream);
                    C0209d.m1263i(fileOutputStream2);
                    fileExchangeDb.safeReadDestTarTxtFileToDb(pmsBatchFastTarOperatorV3, file);
                } catch (Exception e13) {
                    e10 = e13;
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createPmsTarSrcTxtFile create pmsTarSrcTxt error:" + e10.getMessage());
                }
            } catch (Throwable th4) {
                th = th4;
                r02 = z10;
                C0209d.m1263i(r12);
                C0209d.m1263i(r02);
                throw th;
            }
        } catch (IOException unused) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createPmsTarSrcTxtFile createNewFile error " + C10279b.m63452a(file));
        }
    }

    /* renamed from: G */
    public final void m57686G(PmsMetaV3 pmsMetaV3) {
        synchronized (f46037p) {
            try {
                this.f46048j++;
                this.f46047i += pmsMetaV3.getSize();
                this.f46043e.mo29310W(this.f46048j).mo29308V(this.f46047i);
                C11963c.m71970y(this.f46043e, this.f46040b.m29713i0());
                C9215i0 c9215i0 = this.f46041c;
                if (c9215i0 != null) {
                    this.f46041c.m57893o0(c9215i0.m57867Q() + pmsMetaV3.getSize());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: H */
    public final void m57687H(Bak bak) throws C9721b {
        Map<String, String> properties;
        String id2 = bak.getId();
        if (SnapshotTreeManagementService.getInstance().checkSuccessfulBackupRecordStatus(id2) || (properties = bak.getProperties()) == null || !properties.containsKey(SnapshotDBManager.PREFIX_DATABASE_NAME)) {
            return;
        }
        String str = bak.getProperties().get(SnapshotDBManager.PREFIX_DATABASE_NAME);
        C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "downloadV2Snapshot backupId: " + id2);
        String strM81913B = C13617a.m81913B(id2);
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.f46040b.m29654O0());
        String parent = C10278a.m63442h(C13617a.m81912A(id2)).getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f46040b.getLocation());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(strM81913B);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV2Snapshot tempFile delete file error");
        }
        c12478a.m74913i(str, string, new ProgressCallback());
        File fileM63442h2 = C10278a.m63442h(parent + str2 + strM81913B);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV2Snapshot delete file error");
        }
        if (!C11835i.m70654r(fileM63442h, fileM63442h2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV2Snapshot snapFile rename error");
        }
    }

    /* renamed from: I */
    public final void m57688I(List<PmsMetaV3> list) {
        PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(C13617a.m81914C(this.appId, this.f46043e.m29861N()));
        try {
            pmsFullBriefFilesInfoForUploadOperatorV3.updateUploadMidStatus();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "end updateUploadMidStatus error: " + e10.getMessage());
        }
        try {
            pmsFullBriefFilesInfoForUploadOperatorV3.updateLastExistMidStatus();
        } catch (C9721b e11) {
            C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "end updateLastExistMidStatus error: " + e11.getMessage());
        }
        if (list.isEmpty()) {
            return;
        }
        try {
            pmsFullBriefFilesInfoForUploadOperatorV3.updateAttrByPaths(list);
        } catch (C9721b e12) {
            C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "end updateAttrByPaths error: " + e12.getMessage());
        }
    }

    /* renamed from: J */
    public File m57689J(PmsMetaV3 pmsMetaV3) throws C9721b {
        String data = pmsMetaV3.getData();
        if (pmsMetaV3.getEncoded() == 1) {
            data = ICBUtil.getDecodedPath(pmsMetaV3.getData());
        }
        return C10278a.m63443i(C12583q.m75674j(0), data);
    }

    /* renamed from: K */
    public final boolean m57690K(File file, long j10) {
        if (!this.f46043e.m29422n1() || file.length() > j10) {
            return true;
        }
        String name = file.getName();
        return name.endsWith(".dbsplite") || name.endsWith(".differencepacket") || name.endsWith(".dbhashfile");
    }

    /* renamed from: L */
    public void m57691L(PmsMetaV3 pmsMetaV3) throws C9721b {
        synchronized (f46037p) {
            try {
                if (!this.f46050l) {
                    new C9195d0(this.f46040b, this.f46043e).m57757s("module_reset_from_module_upload_brief_file_not_exist");
                    this.f46050l = true;
                }
                throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist pmsv3 file not found " + this.appId + ": " + pmsMetaV3.getFilePath(), "upload");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: M */
    public int m57692M(PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3) throws C9721b {
        return pmsFullBriefFilesInfoForUploadOperatorV3.queryCountForUploadMetas(this.f46044f, this.f46045g);
    }

    /* renamed from: O */
    public void m57694O() {
        if (this.f46040b.m29699d1() || this.f46040b.isRefurbishment()) {
            this.f46049k = false;
            return;
        }
        List<Bak> listM29646K0 = this.f46040b.m29646K0();
        if (listM29646K0 == null || listM29646K0.isEmpty()) {
            this.f46049k = false;
            return;
        }
        for (Bak bak : listM29646K0) {
            String backupVersion = bak.getBackupVersion();
            try {
                if (C12590s0.m75925y1(backupVersion)) {
                    m57687H(bak);
                    List<SnapshotBackupMeta> listQueryLeafNodesByType = SnapshotTreeManagementService.getInstance().queryLeafNodesByType(this.appId, bak.getId(), 4);
                    if (listQueryLeafNodesByType != null && !listQueryLeafNodesByType.isEmpty()) {
                        this.f46049k = true;
                        return;
                    }
                } else if (C12590s0.m75921x1(backupVersion)) {
                    continue;
                } else {
                    String id2 = bak.getId();
                    String strM29713i0 = this.f46040b.m29713i0();
                    C4879a c4879a = this.f46040b;
                    C12610z0 c12610z0 = new C12610z0(c4879a, strM29713i0, c4879a.m29654O0(), id2, backupVersion, bak.getProperties());
                    c12610z0.m76091h(this.appId, this.f46043e.m29861N());
                    if (C13617a.m81938t(bak.getId(), this.appId, 0, this.f46043e.m29861N()) && c12610z0.m76096m(bak.getId(), this.appId, this.f46043e.m29861N()) && new C12164f(bak.getId(), this.appId, 0, this.f46043e.m29861N()).m73026B() > 0) {
                        this.f46049k = true;
                        return;
                    }
                }
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3ModuleUploaderBrief", "download snapshot error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: P */
    public List<PmsMetaV3> m57695P(PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3, int i10, int i11) throws C9721b {
        return pmsFullBriefFilesInfoForUploadOperatorV3.queryByLimitOffsetForUploadMetas(i11, i10, this.f46044f, this.f46045g);
    }

    /* renamed from: Q */
    public final File m57696Q(File file) throws C9721b {
        File fileM63442h = C10278a.m63442h(C10279b.m63452a(file.getParentFile()) + File.separator + C11476b.m68622d(file).getMD5() + ".tar");
        if (file.renameTo(fileM63442h)) {
            return fileM63442h;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "tarFile rename failed " + C10279b.m63452a(file) + " dest = " + fileM63442h);
    }

    /* renamed from: S */
    public final void m57697S(PmsMetaV3 pmsMetaV3, File file) throws C9721b {
        try {
            C12590s0.m75781O2(pmsMetaV3, file);
        } catch (C9721b e10) {
            if (file.exists()) {
                throw e10;
            }
            m57691L(pmsMetaV3);
        }
    }

    /* renamed from: T */
    public final void m57693N(long j10, long j11) {
        synchronized (f46037p) {
            if (j11 <= j10) {
                j10 = j11;
            }
            try {
                long jIncreaseSize = increaseSize(j10);
                if (jIncreaseSize <= 0) {
                    return;
                }
                this.f46047i += (long) (jIncreaseSize * 0.5d);
                this.f46043e.mo29308V(this.f46047i);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f46051m >= RippleView.SINGLE_RIPPLE_TIME) {
                    this.f46051m = jCurrentTimeMillis;
                    C11963c.m71970y(this.f46043e, this.f46040b.m29713i0());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: U */
    public final void m57699U(InterfaceC9213h2 interfaceC9213h2, PmsMetaV3 pmsMetaV3, CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        C4879a c4879a = this.f46040b;
        a aVar = new a(pmsMetaV3, interfaceC9213h2, countDownLatch);
        String str = this.appId;
        String filePath = pmsMetaV3.getFilePath();
        boolean z10 = this.f46049k;
        int iM29861N = this.f46043e.m29861N();
        boolean zM57873W = this.f46041c.m57873W(interfaceC9213h2, ICBUtil.RELATIVE_SDATA_PATH);
        CloudBackupStatus cloudBackupStatus = this.f46043e;
        C9258t c9258t = new C9258t(c4879a, aVar, str, interfaceC9213h2, filePath, pmsMetaV3, 6, z10, iM29861N, zM57873W, cloudBackupStatus, this.f46041c, cloudBackupStatus.mo29357K(), this.mCompressParams);
        CloudBackupTaskManager.getInstance().await(new C9274y0(this));
        isCancel();
        CloudBackupTaskManager.getInstance().addFileTask(this.appId, c9258t);
    }

    /* renamed from: V */
    public final void m57700V(List<PmsMetaV3> list, int i10, final long j10, String str, CountDownLatch countDownLatch, PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3, TarFileUtil tarFileUtil) throws Throwable {
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("CloudBackupV3ModuleUploaderBrief", "uploadPMSTarFile metas is empty");
            return;
        }
        isCancel();
        String strM75647A = C12583q.m75647A(this.appId, this.f46043e.m29861N());
        PmsBatchFastTarOperatorV3 pmsBatchFastTarOperatorV3 = new PmsBatchFastTarOperatorV3(this.f46042d.getPmsBriefMetaDb());
        String strM75690z = C12583q.m75690z(list.get(0), tarFileUtil);
        if (TextUtils.isEmpty(strM75690z)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "uploadPMSTarFile tarRootPath is null");
        }
        FileExchangeDb fileExchangeDb = new FileExchangeDb((ProgressCallback) null, this.f46043e);
        File fileM63442h = C10278a.m63442h(strM75647A);
        m57685F(fileM63442h, strM75690z, str, list, pmsFullBriefFilesInfoForUploadOperatorV3, fileExchangeDb, pmsBatchFastTarOperatorV3);
        isCancel();
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), this.f46040b, C12583q.m75658L(this.appId, this.f46043e.m29861N()), new InterfaceC0275i1() { // from class: dm.z0
            @Override // am.InterfaceC0275i1
            /* renamed from: a */
            public final void mo1767a(long j11) {
                this.f46600a.m57693N(j10, j11);
            }
        });
        String strM75687w = C12583q.m75687w(this.appId, this.f46043e.m29861N());
        String strM75689y = C12583q.m75689y(this.appId, this.f46043e.m29861N());
        int tar = backupRestoreUtil.toTar(strM75647A, strM75687w, strM75690z, strM75689y);
        C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "uploadPMSTarFile tarCode =" + tar);
        int i11 = 0;
        while (tar != 0 && i11 < 3) {
            tar = backupRestoreUtil.toTar(strM75647A, strM75687w, strM75690z, strM75689y);
            i11++;
            C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "uploadPMSTarFile retry tarCode =" + tar + ", retryTime = " + i11);
        }
        if (tar != 0) {
            throw new C9721b(1031, "uploadPMSTarFile error tarCode = " + tar);
        }
        m57693N(j10, j10);
        File fileM63442h2 = C10278a.m63442h(strM75689y);
        File fileM63442h3 = C10278a.m63442h(strM75687w);
        if (!fileM63442h3.exists() || !fileM63442h2.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "uploadPMSTarFile PMS tarFile or txtFile is not exists");
        }
        PmsBatchFastTarSuccessOperatorV3 pmsBatchFastTarSuccessOperatorV3 = new PmsBatchFastTarSuccessOperatorV3(this.f46042d.getPmsBriefMetaDb());
        fileExchangeDb.safeReadDestTarTxtFileToDb(pmsBatchFastTarSuccessOperatorV3, fileM63442h2);
        isCancel();
        pmsBatchFastTarSuccessOperatorV3.updateTarSuccessChangedFileStatus(PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_V3);
        pmsBatchFastTarSuccessOperatorV3.updateTarSuccessNotExistFileStatus(PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_V3);
        pmsBatchFastTarOperatorV3.updateStatusByFastTarResult(PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3);
        pmsFullBriefFilesInfoForUploadOperatorV3.updateNotExistFileUUIDByIsValid();
        isCancel();
        File fileM57696Q = m57696Q(fileM63442h3);
        m57701W(i10, j10, str, fileM57696Q, countDownLatch);
        m57703Y(fileM57696Q);
        pmsBatchFastTarOperatorV3.clear();
        pmsBatchFastTarSuccessOperatorV3.clear();
        C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "delete pmsTarSrcTxt result: " + C11835i.m70642f(fileM63442h));
        C11839m.m70686d("CloudBackupV3ModuleUploaderBrief", "delete destTarTxtFile result: " + C11835i.m70642f(fileM63442h2));
    }

    /* renamed from: W */
    public final void m57701W(int i10, long j10, String str, File file, CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        if (file != null) {
            C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "uuid = " + str + " ,tarfilecount = " + i10);
            C4879a c4879a = this.f46040b;
            b bVar = new b(i10, j10, countDownLatch);
            String str2 = this.appId;
            C9217i2 c9217i2 = new C9217i2(file);
            boolean z10 = this.f46049k;
            int iM29861N = this.f46043e.m29861N();
            CloudBackupStatus cloudBackupStatus = this.f46043e;
            C9258t c9258t = new C9258t(c4879a, bVar, str2, c9217i2, str, null, 7, z10, iM29861N, false, cloudBackupStatus, this.f46041c, cloudBackupStatus.mo29357K(), this.mCompressParams);
            CloudBackupTaskManager.getInstance().await(new C9274y0(this));
            isCancel();
            CloudBackupTaskManager.getInstance().addFileTask(this.appId, c9258t);
        }
    }

    /* renamed from: X */
    public void m57702X(CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        isCancel();
        if (countDownLatch == null) {
            return;
        }
        boolean z10 = this.f46039a != null;
        boolean zIsAbort = isAbort();
        while (countDownLatch.getCount() > 0 && !zIsAbort && !z10) {
            SystemClock.sleep(500L);
            zIsAbort = isAbort();
            z10 = this.f46039a != null;
        }
        isCancel();
    }

    /* renamed from: Y */
    public final void m57703Y(File file) {
        C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "wait tar file start.");
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        long jM75856h0 = C12590s0.m75856h0() * 2;
        if (localLeftSpace != null && localLeftSpace.longValue() <= jM75856h0) {
            C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "local left space is less than double reserved size. left space: " + localLeftSpace);
            while (file != null && file.exists()) {
                SystemClock.sleep(500L);
            }
        }
        C11839m.m70688i("CloudBackupV3ModuleUploaderBrief", "wait tar file end.");
    }

    /* JADX WARN: Removed duplicated region for block: B:323:0x042e A[Catch: all -> 0x0343, TryCatch #3 {all -> 0x0343, blocks: (B:321:0x0428, B:323:0x042e, B:327:0x0439, B:333:0x0445, B:338:0x0458, B:340:0x048b, B:344:0x0494, B:282:0x0339, B:286:0x0346, B:288:0x0350, B:289:0x035b, B:291:0x0388, B:295:0x03be, B:296:0x03ce, B:309:0x040b, B:314:0x0411, B:316:0x0419, B:319:0x0420, B:320:0x0421, B:346:0x04bd, B:347:0x04e4), top: B:362:0x0428 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0458 A[Catch: all -> 0x0343, TryCatch #3 {all -> 0x0343, blocks: (B:321:0x0428, B:323:0x042e, B:327:0x0439, B:333:0x0445, B:338:0x0458, B:340:0x048b, B:344:0x0494, B:282:0x0339, B:286:0x0346, B:288:0x0350, B:289:0x035b, B:291:0x0388, B:295:0x03be, B:296:0x03ce, B:309:0x040b, B:314:0x0411, B:316:0x0419, B:319:0x0420, B:320:0x0421, B:346:0x04bd, B:347:0x04e4), top: B:362:0x0428 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0493  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:361:? -> B:302:0x0403). Please report as a decompilation issue!!! */
    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call() {
        /*
            Method dump skipped, instructions count: 1504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9184a1.call():void");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        return this.abort || this.f46041c.m57872V();
    }
}
