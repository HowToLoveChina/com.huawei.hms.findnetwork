package dm;

import am.InterfaceC0272h1;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.process.util.CompressionPolicyUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppCreate;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import mm.AbstractC11494p;
import mm.C11483e;
import mm.C11485g;
import mm.C11488j;
import mm.InterfaceC11493o;
import mm.InterfaceC11495q;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p495nm.C11728i;
import p514o9.C11835i;
import p514o9.C11839m;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p709vj.C13452e;
import p746wn.C13622a;
import pl.C12159a;
import pl.C12160b;
import pl.C12161c;
import pl.C12164f;
import sl.C12815f;
import tl.C13029h;

/* renamed from: dm.x0 */
/* loaded from: classes6.dex */
public class C9271x0 extends CloudBackupModuleTask {

    /* renamed from: v */
    public static final Object f46539v = new Object();

    /* renamed from: w */
    public static final Object f46540w = new Object();

    /* renamed from: a */
    public C4879a f46541a;

    /* renamed from: b */
    public C9215i0 f46542b;

    /* renamed from: c */
    public C13029h f46543c;

    /* renamed from: d */
    public String f46544d;

    /* renamed from: e */
    public String f46545e;

    /* renamed from: f */
    public String f46546f;

    /* renamed from: g */
    public String f46547g;

    /* renamed from: h */
    public int f46548h;

    /* renamed from: i */
    public int f46549i;

    /* renamed from: j */
    public CloudBackupStatus f46550j;

    /* renamed from: k */
    public int f46551k;

    /* renamed from: l */
    public volatile long f46552l;

    /* renamed from: m */
    public int f46553m;

    /* renamed from: n */
    public int f46554n;

    /* renamed from: o */
    public long f46555o;

    /* renamed from: p */
    public C12594t1 f46556p;

    /* renamed from: q */
    public C12526j f46557q;

    /* renamed from: r */
    public C9721b f46558r;

    /* renamed from: s */
    public long f46559s;

    /* renamed from: t */
    public Map<String, String> f46560t;

    /* renamed from: u */
    public boolean f46561u;

    /* renamed from: dm.x0$a */
    public class a implements InterfaceC0272h1 {

        /* renamed from: a */
        public int f46562a;

        /* renamed from: b */
        public final /* synthetic */ int f46563b;

        /* renamed from: c */
        public final /* synthetic */ String f46564c;

        /* renamed from: d */
        public final /* synthetic */ CountDownLatch f46565d;

        /* renamed from: e */
        public final /* synthetic */ CloudBackupStatus f46566e;

        /* renamed from: f */
        public final /* synthetic */ File f46567f;

        public a(int i10, String str, CountDownLatch countDownLatch, CloudBackupStatus cloudBackupStatus, File file) {
            this.f46563b = i10;
            this.f46564c = str;
            this.f46565d = countDownLatch;
            this.f46566e = cloudBackupStatus;
            this.f46567f = file;
            this.f46562a = i10;
        }

        @Override // am.InterfaceC0272h1
        /* renamed from: a */
        public void mo1765a(long j10) {
            synchronized (C9271x0.f46539v) {
                C9271x0.m58258B(C9271x0.this, j10 * 0.5d);
                C11839m.m70688i("CloudBackupV3ModuleUpload", "onReturnIncreaseSizeTar appId = " + this.f46564c + " alreadyUploadSize = " + C9271x0.this.f46552l);
                this.f46566e.mo29308V(C9271x0.this.f46552l);
                C11963c.m71970y(this.f46566e, C9271x0.this.f46547g);
            }
        }

        @Override // am.InterfaceC0272h1
        /* renamed from: b */
        public void mo1766b(Object obj) {
            synchronized (C9271x0.f46539v) {
                try {
                    C9271x0.this.m58290Q(this.f46564c, this.f46565d, (C12161c) obj, null);
                    this.f46562a--;
                } catch (C9721b e10) {
                    C9271x0.this.m58261X(e10);
                }
            }
        }

        /* renamed from: c */
        public final void m58304c(C9721b c9721b) {
            C9271x0.this.m58261X(c9721b);
            int i10 = this.f46562a;
            if (i10 <= 0) {
                return;
            }
            C9271x0.this.m58284J(i10, this.f46565d);
            C11839m.m70686d("CloudBackupV3ModuleUpload", "upload tar file abort, to upload = " + (C9271x0.this.f46554n - C9271x0.this.f46551k) + ", downLatch count = " + this.f46565d.getCount());
        }

        @Override // am.InterfaceC0272h1
        public void onReturnSize(boolean z10) {
            C9271x0.m58275v(C9271x0.this, this.f46567f.length());
        }

        @Override // am.InterfaceC0272h1
        public void onTaskAbort(Object obj) {
            synchronized (C9271x0.f46539v) {
                C11839m.m70688i("CloudBackupV3ModuleUpload", "onTaskAbort successNum = " + C9271x0.this.f46551k + ",size = " + C9271x0.this.f46554n + ". module = " + this.f46564c);
                m58304c((C9721b) obj);
            }
        }

        @Override // am.InterfaceC0272h1
        public void onTaskBegin(Object obj) {
        }

        @Override // am.InterfaceC0272h1
        public void onTaskFail() {
            synchronized (C9271x0.f46539v) {
                try {
                    int i10 = this.f46562a;
                    if (i10 <= 0) {
                        return;
                    }
                    C9271x0.this.m58284J(i10, this.f46565d);
                    C11839m.m70686d("CloudBackupV3ModuleUpload", "upload tar file failed, to upload = " + (C9271x0.this.f46554n - C9271x0.this.f46551k) + ", downLatch count = " + this.f46565d.getCount());
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // am.InterfaceC0272h1
        public void onTaskSuccess() {
            synchronized (C9271x0.f46539v) {
                try {
                    int i10 = this.f46562a;
                    if (i10 <= 0) {
                        BaseLogger.m28730d("CloudBackupV3ModuleUpload", "onTaskSuccess, mTarFileCount <= 0", "appId: " + this.f46564c);
                        C9271x0.m58268p(C9271x0.this);
                    } else {
                        C9271x0.m58269q(C9271x0.this, i10);
                        C9271x0.this.m58284J(i10, this.f46565d);
                        C11839m.m70686d("CloudBackupV3ModuleUpload", "upload tar file success, to upload = " + (C9271x0.this.f46554n - C9271x0.this.f46551k) + ", downLatch count = " + this.f46565d.getCount());
                    }
                    C11839m.m70686d("CloudBackupV3ModuleUpload", "onTaskSuccess successNum = " + C9271x0.this.f46551k + ",size = " + C9271x0.this.f46554n + ". module = " + this.f46564c);
                    this.f46566e.mo29310W(Math.max(1, Math.min(C9271x0.this.f46551k, C9271x0.this.f46554n))).mo29325f0(C9271x0.this.f46554n);
                    C11963c.m71970y(this.f46566e, C9271x0.this.f46547g);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: dm.x0$b */
    public class b implements InterfaceC0272h1 {

        /* renamed from: a */
        public final /* synthetic */ CloudBackupStatus f46569a;

        /* renamed from: b */
        public final /* synthetic */ C12161c f46570b;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f46571c;

        /* renamed from: d */
        public final /* synthetic */ String f46572d;

        public b(CloudBackupStatus cloudBackupStatus, C12161c c12161c, CountDownLatch countDownLatch, String str) {
            this.f46569a = cloudBackupStatus;
            this.f46570b = c12161c;
            this.f46571c = countDownLatch;
            this.f46572d = str;
        }

        @Override // am.InterfaceC0272h1
        /* renamed from: a */
        public void mo1765a(long j10) {
            synchronized (C9271x0.f46539v) {
                C9271x0.m58257A(C9271x0.this, j10);
                C11839m.m70688i("CloudBackupV3ModuleUpload", "onReturnIncreaseSizeFile appId = " + this.f46572d + " alreadyUploadSize = " + C9271x0.this.f46552l);
                this.f46569a.mo29308V(C9271x0.this.f46552l);
                C11963c.m71970y(this.f46569a, C9271x0.this.f46547g);
            }
        }

        @Override // am.InterfaceC0272h1
        /* renamed from: b */
        public void mo1766b(Object obj) {
        }

        @Override // am.InterfaceC0272h1
        public void onReturnSize(boolean z10) {
            C9271x0.m58275v(C9271x0.this, this.f46570b.m72951G());
            C9271x0.this.m58292S(z10);
        }

        @Override // am.InterfaceC0272h1
        public void onTaskAbort(Object obj) {
            synchronized (C9271x0.f46539v) {
                C11839m.m70688i("CloudBackupV3ModuleUpload", "onTaskAbort successNum = " + C9271x0.this.f46551k + ",size = " + C9271x0.this.f46554n + ". module = " + this.f46572d);
                C9271x0.this.m58261X((C9721b) obj);
                this.f46571c.countDown();
                C11839m.m70687e("CloudBackupV3ModuleUpload", "upload one file abort, to upload = " + (C9271x0.this.f46554n - C9271x0.this.f46551k) + ", downLatch count = " + this.f46571c.getCount());
            }
        }

        @Override // am.InterfaceC0272h1
        public void onTaskBegin(Object obj) {
        }

        @Override // am.InterfaceC0272h1
        public void onTaskFail() {
            synchronized (C9271x0.f46539v) {
                try {
                    C11839m.m70688i("CloudBackupV3ModuleUpload", "onTaskFail successNum = " + C9271x0.this.f46551k + ",size = " + C9271x0.this.f46554n + ". module = " + this.f46572d);
                    C9271x0.this.m58290Q(this.f46572d, this.f46571c, this.f46570b, null);
                } catch (C9721b e10) {
                    C9271x0.this.m58261X(e10);
                    this.f46571c.countDown();
                    C11839m.m70687e("CloudBackupV3ModuleUpload", "upload one file error, to upload = " + (C9271x0.this.f46554n - C9271x0.this.f46551k) + ", downLatch count = " + this.f46571c.getCount());
                }
            }
        }

        @Override // am.InterfaceC0272h1
        public void onTaskSuccess() {
            synchronized (C9271x0.f46539v) {
                C9271x0.this.m58301m0(this.f46569a, this.f46570b, this.f46571c);
            }
        }
    }

    public C9271x0(C4879a c4879a, C9215i0 c9215i0, C13029h c13029h, CloudBackupStatus cloudBackupStatus, String str, Map<String, String> map, C11728i c11728i) {
        super(cloudBackupStatus.m29870d());
        this.f46551k = 0;
        this.f46552l = 0L;
        this.f46553m = 0;
        this.f46554n = 0;
        this.f46555o = 0L;
        this.f46556p = C12594t1.m75990o();
        this.f46557q = new C12526j();
        this.f46561u = false;
        this.f46541a = c4879a;
        this.f46542b = c9215i0;
        this.f46543c = c13029h;
        this.f46550j = cloudBackupStatus;
        this.f46544d = C12590s0.m75786Q(c13029h);
        this.f46545e = c13029h.m78465h();
        this.f46546f = c13029h.m78444J();
        this.f46547g = str;
        this.f46560t = map;
        this.mCompressParams = c11728i;
    }

    /* renamed from: A */
    public static /* synthetic */ long m58257A(C9271x0 c9271x0, long j10) {
        long j11 = c9271x0.f46552l + j10;
        c9271x0.f46552l = j11;
        return j11;
    }

    /* renamed from: B */
    public static /* synthetic */ long m58258B(C9271x0 c9271x0, double d10) {
        long j10 = (long) (c9271x0.f46552l + d10);
        c9271x0.f46552l = j10;
        return j10;
    }

    /* renamed from: M */
    private C9721b m58260M() {
        C9721b c9721b;
        synchronized (f46540w) {
            c9721b = this.f46558r;
        }
        return c9721b;
    }

    /* renamed from: X */
    public void m58261X(Throwable th2) {
        synchronized (f46540w) {
            try {
                if (this.f46558r == null) {
                    if (th2 instanceof C9721b) {
                        this.f46558r = (C9721b) th2;
                    } else {
                        this.f46558r = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error." + th2.toString() + ",stackTrace: " + C12590s0.m75731C0(th2));
                    }
                    if (this.f46558r.m60659c() == 3900 && !C0209d.m1254f2(C0213f.m1377a())) {
                        this.f46558r = new C9721b(1002, this.f46558r.getMessage());
                    }
                    C11839m.m70687e("CloudBackupV3ModuleUpload", this.appId + " task error: " + th2.toString() + ", exception: " + this.f46558r.toString() + ", uid = " + this.f46550j.m29861N());
                    this.f46542b.mo57894p(this.f46558r);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private String getLocation() {
        return C12583q.m75680p(0);
    }

    private void isCancel() throws InterruptedException, C9721b {
        if (this.abort) {
            throw new C9721b(1999, "module backup task interrupted.");
        }
        if (this.f46541a.isAutoBackup() && this.f46541a.m29684Y0()) {
            C11839m.m70688i("CloudBackupV3ModuleUpload", "upload files exit, abnormal autobackup condition");
            int iM29710h0 = this.f46541a.m29710h0();
            m58261X(new C9721b(iM29710h0, "upload files exit, abnormal autobackup condition, appId = " + this.appId + ", err code = " + iM29710h0, "upload"));
        }
        if (m58260M() != null) {
            throw this.f46558r;
        }
        this.f46542b.m59511j();
    }

    /* renamed from: p */
    public static /* synthetic */ int m58268p(C9271x0 c9271x0) {
        int i10 = c9271x0.f46551k;
        c9271x0.f46551k = i10 + 1;
        return i10;
    }

    /* renamed from: q */
    public static /* synthetic */ int m58269q(C9271x0 c9271x0, int i10) {
        int i11 = c9271x0.f46551k + i10;
        c9271x0.f46551k = i11;
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0007, code lost:
    
        if (r7.f46558r != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0009, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x000b, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0014, code lost:
    
        if (r8.getCount() <= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0016, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0018, code lost:
    
        android.os.SystemClock.sleep(500);
        isCancel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0022, code lost:
    
        if (r7.f46558r == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0029, code lost:
    
        if (m58260M() != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x002b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x002c, code lost:
    
        p514o9.C11839m.m70688i("CloudBackupV3ModuleUpload", "upload files exception, " + r7.f46558r.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004a, code lost:
    
        throw r7.f46558r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x000c, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0022 -> B:30:0x0009). Please report as a decompilation issue!!! */
    /* renamed from: q0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m58270q0(java.util.concurrent.CountDownLatch r8) throws java.lang.InterruptedException, fk.C9721b {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            fk.b r0 = r7.f46558r
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lb
        L9:
            r0 = r2
            goto Lc
        Lb:
            r0 = r1
        Lc:
            long r3 = r8.getCount()
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L25
            if (r0 != 0) goto L25
            r3 = 500(0x1f4, double:2.47E-321)
            android.os.SystemClock.sleep(r3)
            r7.isCancel()
            fk.b r0 = r7.f46558r
            if (r0 == 0) goto Lb
            goto L9
        L25:
            fk.b r8 = r7.m58260M()
            if (r8 != 0) goto L2c
            return
        L2c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "upload files exception, "
            r8.append(r0)
            fk.b r0 = r7.f46558r
            java.lang.String r0 = r0.getMessage()
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "CloudBackupV3ModuleUpload"
            p514o9.C11839m.m70688i(r0, r8)
            fk.b r7 = r7.f46558r
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9271x0.m58270q0(java.util.concurrent.CountDownLatch):void");
    }

    /* renamed from: v */
    public static /* synthetic */ long m58275v(C9271x0 c9271x0, long j10) {
        long j11 = c9271x0.f46559s + j10;
        c9271x0.f46559s = j11;
        return j11;
    }

    /* renamed from: D */
    public final void m58278D() {
        this.mCompressParams.m69981h(this.f46550j.m29863P());
        this.mCompressParams.m69982i(this.f46541a.m29747t1("sparse"));
        this.mCompressParams.m69980g(CompressionPolicyUtil.getCompressionPolicy(this.appId, this.f46550j.m29863P()));
    }

    /* renamed from: E */
    public final App m58279E(CloudBackupStatus cloudBackupStatus, String str) throws C9721b, PackageManager.NameNotFoundException {
        String strM29870d = cloudBackupStatus.m29870d();
        Map<String, String> mapM59504a = this.f46542b.m59504a(cloudBackupStatus, false);
        if (!TextUtils.isEmpty(str)) {
            mapM59504a.put("signatures", str);
        }
        AppCreate appCreate = new AppCreate();
        appCreate.setApkType(Integer.valueOf(cloudBackupStatus.m29872f())).setBackupAppName(strM29870d).setBackupDeviceId(this.f46544d).setBackupRecordId(this.f46545e).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setCreateTime(new C4644l(System.currentTimeMillis())).setFileCount(Integer.valueOf(cloudBackupStatus.m29877l())).setAppTotalSize(Long.valueOf(cloudBackupStatus.m29875i())).setPackageVersion(cloudBackupStatus.m29407h1()).setRuntimeType(Integer.valueOf(cloudBackupStatus.m29400e1())).setProperties(mapM59504a);
        if (cloudBackupStatus.mo29370Q()) {
            appCreate.setSplitApkType(cloudBackupStatus.mo29357K());
        }
        if (cloudBackupStatus.m29863P()) {
            appCreate.setPackageFileName(strM29870d + ".apk").setIconFileName(strM29870d + ".icon");
        }
        return new C10321z(this.f46547g, this.f46541a.m29636F0(), this.f46541a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46546f).m63542F(this.f46541a.m29728n0(), this.f46544d, this.f46545e, appCreate, 0);
    }

    /* renamed from: F */
    public final void m58280F(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        C11839m.m70686d("CloudBackupV3ModuleUpload", "delete deleteTmpFile failed: " + C10279b.m63452a(file));
    }

    /* renamed from: G */
    public final void m58281G(String str) throws C9721b {
        C12164f c12164f = new C12164f(this.f46545e, str, 0, this.f46550j.m29861N());
        C12160b c12160b = new C12160b(this.f46545e, str, 0, this.f46550j.m29861N());
        if (!this.f46550j.m29393b1().contains("isDiff")) {
            c12160b.m72932c(1);
            C11839m.m70688i("CloudBackupV3ModuleUpload", "IS_DIFF false, curDiffPacketMetaOperator clear");
            return;
        }
        List<C12159a> listM72938i = c12160b.m72938i();
        Map<String, String> mapM75858h2 = C12590s0.m75858h2(this.f46550j.m29393b1());
        if (listM72938i == null || listM72938i.isEmpty()) {
            if (Objects.equals(mapM75858h2.get("isDiff"), "2")) {
                new C9195d0(this.f46541a, this.f46550j).m57757s("module_reset_from_no_diff_info");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "module upload checkdiffdb is empty");
            }
            return;
        }
        for (C12159a c12159a : listM72938i) {
            C11839m.m70688i("CloudBackupV3ModuleUpload", "create diff packet meta, appId = " + str + ", file: " + c12159a.m72907j());
            C12161c c12161cM72892b = c12159a.m72892b();
            c12161cM72892b.m72957M(this.f46550j.m29871e());
            c12161cM72892b.m72983g0(1);
            c12164f.m73111w0(c12161cM72892b);
        }
    }

    /* renamed from: H */
    public final void m58282H(CloudBackupStatus cloudBackupStatus, Map<String, String> map) throws C9721b {
        if (this.f46541a.m29699d1() || this.f46541a.isRefurbishment()) {
            C11839m.m70688i("CloudBackupV3ModuleUpload", "update snapshot cache is full backup, return.");
            return;
        }
        C11839m.m70688i("CloudBackupV3ModuleUpload", "do one module update start, appId = " + this.appId + ", uid = " + cloudBackupStatus.m29861N());
        long jCurrentTimeMillis = System.currentTimeMillis();
        C9255s0 c9255s0 = new C9255s0(this.f46541a, this.f46543c, this.f46547g, this.f46546f);
        c9255s0.m58187i(cloudBackupStatus);
        if (cloudBackupStatus.m29863P() && cloudBackupStatus.m29351H0() == 1) {
            new C11483e(cloudBackupStatus.m29870d(), new C12164f(this.f46541a.m29734p0(), cloudBackupStatus.m29870d(), 0, cloudBackupStatus.m29861N())).batchExecute(new InterfaceC11493o() { // from class: dm.t0
                @Override // mm.InterfaceC11493o
                /* renamed from: a */
                public final void mo15310a(List list, int i10) throws InterruptedException, C9721b {
                    this.f46513a.m58293T(list, i10);
                }
            });
            c9255s0.m58187i(cloudBackupStatus);
        }
        c9255s0.m58185g(cloudBackupStatus);
        map.put(SyncProtocol.Constant.UPDATE, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        C11839m.m70688i("CloudBackupV3ModuleUpload", "do one module update end, appId = " + this.appId + ", uid = " + cloudBackupStatus.m29861N());
    }

    /* renamed from: I */
    public final void m58283I(CloudBackupStatus cloudBackupStatus, Map<String, String> map) {
        C11839m.m70688i("CloudBackupV3ModuleUpload", "doVfsStatistics start, appId = " + this.appId + ", uid = " + cloudBackupStatus.m29861N());
        try {
            new C9251r0(this.f46541a, this.f46543c, this.f46547g, this.f46546f).m58096h(cloudBackupStatus, map);
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackupV3ModuleUpload", "doVfsStatistics error, appId = " + this.appId + ",error:" + e10.getMessage());
        }
        C11839m.m70688i("CloudBackupV3ModuleUpload", "doVfsStatistics end, appId = " + this.appId + ", uid = " + cloudBackupStatus.m29861N());
    }

    /* renamed from: J */
    public final void m58284J(int i10, CountDownLatch countDownLatch) {
        for (int i11 = 0; i11 < i10; i11++) {
            countDownLatch.countDown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0352 A[Catch: all -> 0x035e, TryCatch #8 {all -> 0x035e, blocks: (B:106:0x000b, B:115:0x005a, B:120:0x00c1, B:124:0x00dd, B:133:0x012a, B:145:0x01ad, B:167:0x022d, B:169:0x0352, B:172:0x0362, B:166:0x0213, B:131:0x0122, B:175:0x03d3, B:176:0x041d), top: B:202:0x000b }] */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m58285K() throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 1232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9271x0.m58285K():void");
    }

    /* renamed from: L */
    public final boolean m58286L(CloudBackupStatus cloudBackupStatus, File file, long j10, long j11) {
        if (!cloudBackupStatus.m29422n1()) {
            return true;
        }
        long length = file.length();
        if (length != 0) {
            j10 = length;
        }
        if (j10 > j11) {
            return true;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        String strM63452a = C10279b.m63452a(file);
        return (file.getName().endsWith(".dbsplite") || file.getName().endsWith(".differencepacket") || file.getName().endsWith(".dbhashfile")) || (ICBUtil.isApkFile(strM63452a, this.f46541a.getLocation(), strM29870d) || ICBUtil.isIconFile(strM63452a, this.f46541a.getLocation(), strM29870d)) || ICBUtil.isInfoFile(strM63452a, this.f46541a.getLocation(), strM29870d) || ICBUtil.isTxtFile(strM63452a, this.f46541a.getLocation(), strM29870d);
    }

    /* renamed from: N */
    public final void m58287N(String str) {
        CloudBackup cloudBackup;
        this.f46548h = this.f46557q.m75333E0();
        this.f46549i = this.f46557q.m75335F0();
        List<AppInfoList> listM75300k = new C12519c().m75300k(str);
        if (listM75300k.isEmpty() || (cloudBackup = listM75300k.get(0).getCloudBackup()) == null) {
            return;
        }
        int sdcardAcptErrNum = cloudBackup.getSdcardAcptErrNum();
        int sdcardAcptErrRate = cloudBackup.getSdcardAcptErrRate();
        if (sdcardAcptErrNum < 0 || sdcardAcptErrRate < 0) {
            return;
        }
        this.f46548h = sdcardAcptErrNum;
        this.f46549i = sdcardAcptErrRate;
    }

    /* renamed from: O */
    public final String m58288O(String str, int i10) {
        return C12583q.m75662P(str, i10);
    }

    /* renamed from: P */
    public long m58289P() {
        return this.f46559s;
    }

    /* renamed from: Q */
    public final void m58290Q(String str, CountDownLatch countDownLatch, C12161c c12161c, C9721b c9721b) throws InterruptedException, C9721b {
        if (c12161c == null) {
            C11839m.m70687e("CloudBackupV3ModuleUpload", "handleFileNotExist backupMeta is null");
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist sdcard file not found backupMeta is null", "upload");
        }
        isCancel();
        String strM76013p = this.f46556p.m76013p(c12161c, this.f46550j.mo29421n(), this.f46550j.m29861N(), this.f46550j.m29345E0());
        m58294U(c12161c, c9721b, strM76013p);
        if (HNConstants.DataType.MEDIA.equals(str) || "music".equals(str)) {
            this.f46556p.m75992B(this.f46545e, c12161c, this.f46550j.m29861N());
            this.f46551k--;
            countDownLatch.countDown();
            return;
        }
        if (strM76013p == null || strM76013p.startsWith(getLocation()) || this.f46550j.m29866T()) {
            new C9195d0(this.f46541a, this.f46550j).m57757s("module_reset_from_module_upload_file_not_exist");
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist file not found " + str + ": " + strM76013p, "upload");
        }
        this.f46556p.m75992B(this.f46545e, c12161c, this.f46550j.m29861N());
        int iM76022y = this.f46556p.m76022y(str, this.f46545e, this.f46550j.m29861N());
        C12815f c12815f = new C12815f(this.f46547g);
        this.f46550j.m29359K1(String.valueOf(iM76022y));
        c12815f.m76934m(this.f46550j);
        m58287N(this.f46550j.mo29421n());
        C11839m.m70686d("CloudBackupV3ModuleUpload", "handleFileNotExist moduleNotExistCount:" + iM76022y + " ,sdcardFilesNum: " + this.f46553m + ", sdcardAcptErrNum: " + this.f46548h + ", sdcardAcptErrRate: " + this.f46549i);
        if (iM76022y > this.f46548h) {
            this.f46550j.mo29338z0(2).mo29289A0(0).m29423n2(0L);
            c12815f.m76934m(this.f46550j);
            C11963c.m71970y(this.f46550j, this.f46547g);
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist sdcard file not found " + str + " moduleNotExistCount: " + iM76022y, "upload");
        }
        int i10 = this.f46553m;
        float f10 = i10 != 0 ? (iM76022y / i10) * 100.0f : 0.0f;
        if (f10 <= this.f46549i) {
            countDownLatch.countDown();
            return;
        }
        this.f46550j.mo29338z0(2).mo29289A0(0).m29423n2(0L);
        c12815f.m76934m(this.f46550j);
        C11963c.m71970y(this.f46550j, this.f46547g);
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist sdcard file not found " + str + " moduleNotExistCount: " + iM76022y + " ,prorate: " + f10, "upload");
    }

    /* renamed from: R */
    public final boolean m58291R(boolean z10, File file, long j10, int i10, long j11) {
        return z10 || (file.exists() && file.length() > j10) || ((long) i10) >= j11;
    }

    /* renamed from: S */
    public final void m58292S(boolean z10) {
        if (z10) {
            this.f46561u = z10;
        }
    }

    /* renamed from: T */
    public final void m58293T(List<C12161c> list, int i10) throws InterruptedException, C9721b {
        C12164f c12164f = new C12164f(this.f46545e, this.appId, 0, this.f46550j.m29861N());
        String location = this.f46541a.getLocation();
        int i11 = 1;
        for (C12161c c12161c : list) {
            if (c12161c != null) {
                if (i11 % 100 == 0) {
                    this.f46541a.isCancel();
                }
                String strM76013p = C12594t1.m75990o().m76013p(c12161c, this.f46550j.mo29421n(), this.f46550j.m29861N(), this.f46550j.m29345E0());
                File fileM63442h = C10278a.m63442h(strM76013p);
                File fileM63442h2 = C10278a.m63442h(C12590s0.m75797S2(this.f46550j.m29870d(), this.f46550j.mo29421n(), this.f46550j.m29861N(), strM76013p, this.f46550j.m29345E0()));
                if (fileM63442h.exists()) {
                    C12594t1.m75990o().m75991A(fileM63442h2, fileM63442h, c12161c, location, this.f46550j.m29861N());
                    c12164f.m73111w0(c12161c);
                }
                i11++;
            }
        }
    }

    /* renamed from: U */
    public final void m58294U(C12161c c12161c, C9721b c9721b, String str) {
        C11060c c11060cM66626a = C11058a.m66626a(this.f46546f, "fileNotExist", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_1013");
        String str2 = "appId = " + c12161c.m72974c() + ", appName = " + c12161c.m72976d() + ", file name = " + c12161c.m72948D();
        if (!C4633d0.m28404a(str)) {
            str2 = str2 + ", file path = " + str + ", file exist = " + C10278a.m63442h(str).exists();
        }
        if (c9721b != null) {
            str2 = str2 + ", errorMsg = " + c9721b.getMessage();
        }
        C11839m.m70686d("CloudBackupV3ModuleUpload", "report file not exist info: " + str2);
        c11060cM66626a.m66635A(str2);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }

    /* renamed from: V */
    public final void m58295V(CloudBackupStatus cloudBackupStatus) throws InterruptedException, C9721b {
        if (cloudBackupStatus.m29866T()) {
            return;
        }
        isCancel();
        new C11485g(cloudBackupStatus.m29870d(), new C12164f(this.f46545e, this.appId, 0, cloudBackupStatus.m29861N())).execute(new InterfaceC11495q() { // from class: dm.w0
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
                this.f46535a.m58296W(abstractC11494p, i10);
            }
        });
    }

    /* renamed from: W */
    public final void m58296W(AbstractC11494p<?> abstractC11494p, int i10) throws InterruptedException, C9721b {
        CountDownLatch countDownLatch = new CountDownLatch(i10);
        for (int i11 = 1; i11 <= i10; i11++) {
            C12161c c12161c = (C12161c) abstractC11494p.query(i11);
            int iM72952H = c12161c.m72952H();
            if (iM72952H == -4 || iM72952H == 4 || iM72952H == 5 || iM72952H == 6) {
                C11839m.m70686d("CloudBackupV3ModuleUpload", "retryUploadWaitDeleteFile success: " + iM72952H + " ,snapshotBackupMetas: " + c12161c.m72991l());
                countDownLatch.countDown();
            } else {
                String strM76013p = this.f46556p.m76013p(c12161c, this.f46550j.mo29421n(), this.f46550j.m29861N(), this.f46550j.m29345E0());
                File fileM63442h = C10278a.m63442h(strM76013p);
                C11839m.m70686d("CloudBackupV3ModuleUpload", "retryUploadWaitDeleteFile localPath: " + strM76013p + " ,file.exists(): " + fileM63442h.exists());
                if (C11835i.m70650n(fileM63442h)) {
                    m58300j0(this.f46550j, c12161c, countDownLatch);
                } else {
                    m58301m0(this.f46550j, c12161c, countDownLatch);
                }
            }
        }
        m58270q0(countDownLatch);
    }

    /* renamed from: Y */
    public final void m58297Y(String str, CountDownLatch countDownLatch, C12161c c12161c, String str2, C9721b c9721b) throws C9721b {
        synchronized (f46539v) {
            C11839m.m70686d("CloudBackupV3ModuleUpload", "file not exist: " + str2);
            m58290Q(str, countDownLatch, c12161c, c9721b);
        }
    }

    /* renamed from: Z */
    public final int m58298Z(CloudBackupStatus cloudBackupStatus, boolean z10) throws C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        if (z10) {
            this.f46556p.m76010j(strM29870d, this.f46545e, cloudBackupStatus.m29861N());
        } else {
            this.f46556p.m76003c(strM29870d, this.f46545e, cloudBackupStatus.m29861N());
        }
        C12164f c12164f = new C12164f(this.f46545e, strM29870d, 0, cloudBackupStatus.m29861N());
        long jM73070b0 = c12164f.m73070b0();
        int iM73026B = c12164f.m73026B();
        if (!cloudBackupStatus.m29866T() || HNConstants.DataType.MEDIA.equalsIgnoreCase(strM29870d) || "music".equalsIgnoreCase(strM29870d)) {
            cloudBackupStatus.mo29327g0(HNConstants.DataType.MEDIA.equals(strM29870d) ? iM73026B - 1 : iM73026B);
        }
        cloudBackupStatus.mo29323e0(jM73070b0);
        return iM73026B;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() throws C9721b {
        m58285K();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        abort();
        super.cancel(z10);
    }

    /* renamed from: i0 */
    public final void m58299i0(long j10, int i10, int i11) throws C9721b {
        String strM29870d = this.f46550j.m29870d();
        C11839m.m70688i("CloudBackupV3ModuleUpload", "upload begin, appId = " + strM29870d + " ,alreadyUploadCount: " + i10 + " , alreadyUploadSize = " + j10 + " ,: " + i11);
        this.f46552l = j10;
        this.f46551k = i10;
        this.f46554n = i11;
        this.f46550j.mo29310W(i10).mo29325f0(i11).mo29308V(j10);
        C11963c.m71970y(this.f46550j, this.f46547g);
        this.f46553m = this.f46556p.m76020w(strM29870d, this.f46545e, this.f46550j.m29861N());
        new C11488j(strM29870d, new C12164f(this.f46545e, strM29870d, 0, this.f46550j.m29861N())).execute(new InterfaceC11495q() { // from class: dm.u0
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i12) throws Throwable {
                this.f46524a.m58302n0(abstractC11494p, i12);
            }
        });
        m58281G(strM29870d);
        C11839m.m70688i("CloudBackupV3ModuleUpload", "upload end, appId = " + strM29870d);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        return this.abort || this.f46541a.isAbort();
    }

    /* renamed from: j0 */
    public final void m58300j0(CloudBackupStatus cloudBackupStatus, C12161c c12161c, CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        C9234n c9234n = new C9234n(this.f46541a, new b(cloudBackupStatus, c12161c, countDownLatch, strM29870d), c12161c, this.f46543c, this.f46542b.m57873W(new C9217i2(C10278a.m63442h(this.f46556p.m76013p(c12161c, cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N(), cloudBackupStatus.m29345E0()))), c12161c.m72950F()), cloudBackupStatus, this.mCompressParams);
        CloudBackupTaskManager.getInstance().await(new C9265v0(this));
        isCancel();
        CloudBackupTaskManager.getInstance().addFileTask(strM29870d, c9234n);
    }

    /* renamed from: m0 */
    public final void m58301m0(CloudBackupStatus cloudBackupStatus, C12161c c12161c, CountDownLatch countDownLatch) {
        int i10 = this.f46551k + 1;
        this.f46551k = i10;
        int iMax = Math.max(0, Math.min(i10, this.f46554n));
        cloudBackupStatus.mo29310W(iMax).mo29325f0(this.f46554n);
        C11963c.m71970y(cloudBackupStatus, this.f46547g);
        countDownLatch.countDown();
        C11839m.m70686d("CloudBackupV3ModuleUpload", "upload one file success, to upload = " + (this.f46554n - this.f46551k) + ", downLatch count = " + countDownLatch.getCount() + " ,curSuccessNum: " + iMax + " ,appId: " + this.appId);
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x0261 A[Catch: all -> 0x014e, TRY_LEAVE, TryCatch #5 {all -> 0x014e, blocks: (B:116:0x00dd, B:118:0x0103, B:121:0x011c, B:124:0x013b, B:131:0x0157, B:133:0x015d, B:135:0x0163, B:137:0x0170, B:139:0x0176, B:140:0x0196, B:142:0x01af, B:144:0x01bf, B:146:0x01e3, B:148:0x01fa, B:149:0x0212, B:159:0x024e, B:166:0x0259, B:168:0x0261), top: B:200:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0288 A[Catch: all -> 0x0299, TryCatch #4 {all -> 0x0299, blocks: (B:183:0x02e0, B:174:0x0282, B:176:0x0288, B:178:0x028e, B:181:0x029c, B:185:0x02eb), top: B:198:0x0282 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02ea A[SYNTHETIC] */
    /* renamed from: n0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m58302n0(mm.AbstractC11494p r47, int r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 809
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9271x0.m58302n0(mm.p, int):void");
    }

    /* renamed from: p0 */
    public final void m58303p0(CloudBackupStatus cloudBackupStatus, int i10, String str, File file, CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        C9196d1 c9196d1 = new C9196d1(this.f46541a, new a(i10, strM29870d, countDownLatch, cloudBackupStatus, file), cloudBackupStatus, file, str, this.f46543c, this.mCompressParams);
        CloudBackupTaskManager.getInstance().await(new C9265v0(this));
        isCancel();
        CloudBackupTaskManager.getInstance().addFileTask(strM29870d, c9196d1);
    }
}
