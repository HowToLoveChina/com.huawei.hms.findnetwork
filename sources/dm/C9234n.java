package dm;

import am.InterfaceC0272h1;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.PmsUtils;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10554e;
import im.C10564n;
import im.InterfaceC10570t;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0227m;
import p455ll.C11308a;
import p495nm.C11728i;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p848zl.C14337f;
import p851zp.InterfaceC14357d;
import pl.C12161c;
import pl.C12164f;
import sl.C12814e;
import tl.C13029h;

/* renamed from: dm.n */
/* loaded from: classes6.dex */
public class C9234n extends CloudBackupFileTask {

    /* renamed from: a */
    public final C4879a f46347a;

    /* renamed from: b */
    public final InterfaceC0272h1 f46348b;

    /* renamed from: c */
    public final C12161c f46349c;

    /* renamed from: d */
    public final String f46350d;

    /* renamed from: e */
    public final String f46351e;

    /* renamed from: f */
    public final String f46352f;

    /* renamed from: g */
    public final C12594t1 f46353g;

    /* renamed from: h */
    public final String f46354h;

    /* renamed from: i */
    public final String f46355i;

    /* renamed from: j */
    public final int f46356j;

    /* renamed from: k */
    public C10564n f46357k;

    /* renamed from: l */
    public boolean f46358l;

    /* renamed from: m */
    public final boolean f46359m;

    /* renamed from: n */
    public final CloudBackupStatus f46360n;

    /* renamed from: o */
    public C9190c f46361o;

    /* renamed from: p */
    public final C11728i f46362p;

    public C9234n(C4879a c4879a, InterfaceC0272h1 interfaceC0272h1, C12161c c12161c, C13029h c13029h, boolean z10, CloudBackupStatus cloudBackupStatus, C11728i c11728i) {
        super(c12161c.m72974c(), 0);
        this.f46358l = false;
        this.f46347a = c4879a;
        this.f46348b = interfaceC0272h1;
        this.f46349c = c12161c;
        this.f46351e = c13029h.m78444J();
        this.f46352f = c12161c.m72974c();
        this.f46350d = c4879a.getLocation();
        this.f46354h = c13029h.m78465h();
        this.f46355i = C12590s0.m75786Q(c13029h);
        this.f46356j = cloudBackupStatus.m29861N();
        this.f46353g = C12594t1.m75990o();
        this.f46359m = z10;
        this.f46360n = cloudBackupStatus;
        this.f46362p = c11728i;
    }

    /* renamed from: i */
    public static boolean m58013i(String str, File file) {
        return C11835i.m70641e(str, C10279b.m63452a(file), true);
    }

    /* renamed from: A */
    public final void m58014A(String str, String str2, Context context, File file) {
        PmsUtils.copyAndroidDataFileByBrief(new BackupRestoreUtil(context, this.f46347a, this.f46350d), str2, C10279b.m63452a(file), this.f46356j, str);
    }

    /* renamed from: B */
    public final boolean m58015B(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CloudBackupV3FileUpload", "filePath is empty, " + str);
            return false;
        }
        String str2 = this.f46352f;
        if (!str.startsWith(C12583q.m75670f(this.f46356j, ICBUtil.ANDROID_DATA, str2))) {
            if (!TextUtils.equals(str2, "chatSms") || !str.startsWith(C12583q.m75670f(this.f46356j, ICBUtil.ANDROID_DATA, "com.android.providers.telephony"))) {
                C11839m.m70688i("CloudBackupV3FileUpload", "not Android data file, " + str);
                return false;
            }
            str2 = "com.android.providers.telephony";
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && !C11835i.m70650n(fileM63442h)) {
            try {
                m58019k(fileM63442h, str2, str);
                return true;
            } catch (Exception e10) {
                C11839m.m70688i("CloudBackupV3FileUpload", "retry upload failed, " + str + ", exception: " + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final C11308a m58024t(String str, int i10, final boolean z10) throws InterruptedException, C9721b {
        try {
            final long jM72951G = this.f46349c.m72951G();
            File fileM63442h = C10278a.m63442h(str);
            C10321z c10321z = new C10321z(this.f46347a.m29713i0(), this.f46347a.m29636F0(), this.f46347a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46351e);
            c10321z.m63540D0(this.f46347a.m29761y0());
            C10564n c10564n = new C10564n(this.f46352f, this.f46356j, this.f46351e, c10321z, this.f46355i, this.f46354h, this.f46347a, fileM63442h, null, z10, this.f46362p, this.f46360n.mo29357K());
            this.f46357k = c10564n;
            c10564n.m64772V(i10 > 0);
            this.f46357k.m64770T(new InterfaceC10570t() { // from class: dm.l
                @Override // im.InterfaceC10570t
                /* renamed from: a */
                public final void mo57738a(AbstractC10554e abstractC10554e) {
                    this.f46329a.m58023s(jM72951G, abstractC10554e);
                }
            });
            return this.f46357k.m64763M(i10);
        } catch (C9721b e10) {
            if (this.abort) {
                throw e10;
            }
            this.f46347a.isCancel();
            final int i11 = i10 + 1;
            if (i11 > 2 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                throw e10;
            }
            SystemClock.sleep(500L);
            this.f46347a.isCancel();
            C11839m.m70688i("CloudBackupV3FileUpload", "upload file = " + str + ", retry = " + i11);
            C11728i c11728i = this.f46362p;
            if (c11728i != null && c11728i.m69978e()) {
                this.f46362p.m69974a(str);
            }
            return m58017D(e10, str, new InterfaceC14357d() { // from class: dm.m
                @Override // p851zp.InterfaceC14357d
                /* renamed from: a */
                public final Object mo57972a(Object obj) {
                    return this.f46334a.m58024t(i11, z10, (String) obj);
                }
            });
        }
    }

    /* renamed from: D */
    public final C11308a m58017D(C9721b c9721b, String str, InterfaceC14357d<String, C11308a, C9721b> interfaceC14357d) throws Throwable {
        String strM58020p;
        try {
            strM58020p = m58020p(c9721b, str);
        } catch (Throwable th2) {
            th = th2;
            strM58020p = str;
        }
        try {
            C11308a c11308aMo57972a = interfaceC14357d.mo57972a(strM58020p);
            if (!TextUtils.equals(strM58020p, str)) {
                C11835i.m70643g(strM58020p);
            }
            return c11308aMo57972a;
        } catch (Throwable th3) {
            th = th3;
            if (!TextUtils.equals(strM58020p, str)) {
                C11835i.m70643g(strM58020p);
            }
            throw th;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() throws Throwable {
        String str = "com.android.providers.telephony";
        String str2 = null;
        boolean z10 = false;
        try {
            try {
                this.f46347a.isCancel();
                String strM76013p = this.f46353g.m76013p(this.f46349c, this.f46360n.mo29421n(), this.f46356j, this.f46360n.m29345E0());
                try {
                    if (TextUtils.isEmpty(strM76013p)) {
                        this.f46348b.onTaskFail();
                        return;
                    }
                    File fileM63442h = C10278a.m63442h(strM76013p);
                    String strM75797S2 = C12590s0.m75797S2(this.f46352f, this.f46360n.mo29421n(), this.f46356j, strM76013p, this.f46360n.m29345E0());
                    if (TextUtils.isEmpty(strM75797S2)) {
                        this.f46348b.onTaskFail();
                        return;
                    }
                    String strM29870d = this.f46360n.m29870d();
                    String strMo29421n = this.f46360n.mo29421n();
                    if (!TextUtils.equals(strM29870d, "chatSms") || !strM76013p.contains("com.android.providers.telephony")) {
                        str = strM29870d;
                    }
                    boolean zM58026v = m58026v(strM76013p, str, strMo29421n);
                    try {
                        File fileM63442h2 = C10278a.m63442h(strM75797S2);
                        if (!zM58026v) {
                            this.f46353g.m75991A(fileM63442h2, fileM63442h, this.f46349c, this.f46350d, this.f46356j);
                        }
                        if (!this.f46349c.m72984h().startsWith(AlbumsTempScript.DATABASE_NAME)) {
                            C11839m.m70688i("CloudBackupV3FileUpload", "appid = " + this.f46352f + ",file = " + this.f46349c.m72984h() + " ,uid: " + this.f46356j);
                            this.f46348b.onTaskBegin(null);
                        }
                        if (m58021q(this.f46349c)) {
                            this.f46348b.onTaskSuccess();
                            return;
                        }
                        this.f46347a.isCancel();
                        if (this.f46359m) {
                            m58025u(strM76013p, this.f46349c);
                        } else {
                            C11839m.m70686d("CloudBackupV3FileUpload", "needCopyFile: " + zM58026v + " path: " + strM76013p);
                            if (zM58026v) {
                                m58019k(fileM63442h, str, strM76013p);
                            } else {
                                m58018h(strM76013p, this.f46349c);
                            }
                        }
                        this.f46348b.onReturnSize(false);
                        this.f46348b.onTaskSuccess();
                    } catch (C9721b e10) {
                        e = e10;
                        str2 = strM76013p;
                        z10 = zM58026v;
                        if (m58015B(str2)) {
                            this.f46348b.onReturnSize(true);
                            this.f46348b.onTaskSuccess();
                            return;
                        }
                        File fileM63442h3 = C10278a.m63442h(str2);
                        if (!z10 && (!fileM63442h3.exists() || fileM63442h3.length() <= 0)) {
                            this.f46348b.onTaskFail();
                            return;
                        }
                        if (e.m60659c() == 1013) {
                            this.f46348b.onTaskFail();
                            return;
                        }
                        String str3 = "upload error. file = " + this.f46349c.m72991l() + ", PMS Copy: " + this.f46358l + ", " + e.getMessage();
                        C11839m.m70687e("CloudBackupV3FileUpload", str3);
                        C9721b c9721b = new C9721b(e.m60659c(), e.m60663g(), str3, e.m60658b());
                        c9721b.m60664h(e.m60661e());
                        this.f46348b.onTaskAbort(c9721b);
                    }
                } catch (C9721b e11) {
                    e = e11;
                    str2 = strM76013p;
                }
            } catch (C9721b e12) {
                e = e12;
            }
        } catch (Exception e13) {
            C11839m.m70687e("CloudBackupV3FileUpload", "upload error catch Exception. file = " + this.f46349c.m72991l() + e13.getMessage());
            this.f46348b.onTaskAbort(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e13.getMessage(), "UploadTask"));
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        C11839m.m70688i("CloudBackupV3FileUpload", "cancel");
        abort();
        C10564n c10564n = this.f46357k;
        if (c10564n != null) {
            c10564n.mo64711f();
        }
        C9190c c9190c = this.f46361o;
        if (c9190c != null) {
            c9190c.m57712f();
        }
        super.cancel(z10);
    }

    /* renamed from: h */
    public final void m58018h(String str, C12161c c12161c) throws InterruptedException, C9721b {
        if (c12161c == null || str == null) {
            return;
        }
        boolean zM76918e = new C12814e().m76918e(c12161c.m72950F(), c12161c.m72991l(), c12161c.m72945A(), c12161c.m72946B());
        C11308a c11308aM58024t = m58024t(str, 0, this.f46347a.m29699d1() || zM76918e || (!this.f46347a.m29720k1() && this.f46347a.m29737q0().contains(this.f46352f)));
        if (zM76918e) {
            this.f46347a.f22481o = true;
            C11839m.m70686d("CloudBackupV3FileUpload", "cloudBackupLostFile antiMdr = true filePath: " + c12161c.m72991l());
        }
        c12161c.m72998o0(-4);
        c12161c.m72983g0(1);
        c12161c.m72981f0(c11308aM58024t.m67895m());
        c12161c.m72958N(c11308aM58024t.m67883a());
        c12161c.m73002q0(c11308aM58024t.m67898p());
        c12161c.m72961Q("");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c12161c);
        this.f46353g.m76002a(this.f46352f, this.f46354h, arrayList, this.f46356j);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        C4879a c4879a = this.f46347a;
        return c4879a != null ? c4879a.isAbort() : super.isAbort();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m58019k(java.io.File r25, java.lang.String r26, java.lang.String r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9234n.m58019k(java.io.File, java.lang.String, java.lang.String):void");
    }

    /* renamed from: p */
    public final String m58020p(C9721b c9721b, String str) {
        if (!TextUtils.equals(this.f46352f, HNConstants.DataType.MEDIA)) {
            return str;
        }
        String message = c9721b.getMessage();
        if (message == null || !message.contains("SignatureDoesNotMatch")) {
            C11839m.m70688i("CloudBackupV3FileUpload", "gallery error not SignatureDoesNotMatch error");
            return str;
        }
        File fileM63442h = C10278a.m63442h(C12583q.m75680p(0) + File.separator + this.f46352f);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70688i("CloudBackupV3FileUpload", "gallery error !tempDir.exists() && !tempDir.mkdirs()");
            CloudBackupReport.reportGalleryRetryCopyFileUpload(this.f46351e, "copy failed, gallery error !tempDir.exists() && !tempDir.mkdirs() ,filePath: " + str);
            return str;
        }
        File fileM63441g = C10278a.m63441g(fileM63442h, C0227m.m1593f(str));
        if (fileM63441g.exists() && !C11835i.m70642f(fileM63441g)) {
            C11839m.m70688i("CloudBackupV3FileUpload", "gallery error tempFile.exists() && !FileUtil.deleteFile(tempFile)");
            CloudBackupReport.reportGalleryRetryCopyFileUpload(this.f46351e, "copy failed, gallery error tempFile.exists() && !FileUtil.deleteFile(tempFile) ,filePath: " + str);
            return str;
        }
        if (!m58013i(str, fileM63441g)) {
            C11839m.m70688i("CloudBackupV3FileUpload", "gallery error copyFile failed");
            CloudBackupReport.reportGalleryRetryCopyFileUpload(this.f46351e, "copy failed, gallery error copyFile failed ,filePath: " + str);
            return str;
        }
        String strM63452a = C10279b.m63452a(fileM63441g);
        CloudBackupReport.reportGalleryRetryCopyFileUpload(this.f46351e, "copy success, retry upload: " + str);
        C11839m.m70688i("CloudBackupV3FileUpload", "gallery copyFile success retry: " + strM63452a);
        return strM63452a;
    }

    /* renamed from: q */
    public final boolean m58021q(C12161c c12161c) {
        int iM72952H = c12161c.m72952H();
        if (iM72952H != 4 && iM72952H != 5) {
            return iM72952H == 6;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - c12161c.m73004s();
        return jCurrentTimeMillis <= 21600000 && jCurrentTimeMillis > 0;
    }

    /* renamed from: r */
    public final /* synthetic */ void m58022r(C12161c c12161c, AbstractC10554e abstractC10554e) {
        synchronized (CloudBackupFileTask.SIZE_LOCK) {
            try {
                if (this.abort) {
                    C11839m.m70688i("CloudBackupV3FileUpload", "uploader abort return");
                } else {
                    this.f46348b.mo1765a(increaseSize((abstractC10554e.m64747z() * c12161c.m72951G()) / 100));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s */
    public final /* synthetic */ void m58023s(long j10, AbstractC10554e abstractC10554e) {
        synchronized (CloudBackupFileTask.SIZE_LOCK) {
            try {
                if (this.abort) {
                    C11839m.m70688i("CloudBackupV3FileUpload", "uploader abort return");
                } else {
                    this.f46348b.mo1765a(increaseSize((abstractC10554e.m64747z() * j10) / 100));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: u */
    public final void m58025u(String str, final C12161c c12161c) throws InterruptedException, C9721b {
        C4879a c4879a = this.f46347a;
        C9190c c9190c = new C9190c(c4879a, c4879a.m29734p0(), this.f46360n, this.f46347a.m29628C0(), new C9217i2(C10278a.m63442h(str)), c12161c.m72982g(), this.f46351e, "common", c12161c.m73006u(), new InterfaceC10570t() { // from class: dm.k
            @Override // im.InterfaceC10570t
            /* renamed from: a */
            public final void mo57738a(AbstractC10554e abstractC10554e) {
                this.f46324a.m58022r(c12161c, abstractC10554e);
            }
        }, c12161c.m72951G());
        this.f46361o = c9190c;
        boolean zM57718l = c9190c.m57718l();
        this.f46347a.isCancel();
        if (!zM57718l) {
            C11839m.m70689w("CloudBackupV3FileUpload", "diff fail");
            m58018h(str, c12161c);
            return;
        }
        C12164f c12164f = new C12164f(this.f46347a.m29734p0(), this.f46352f, 0, this.f46356j);
        c12161c.m73000p0(8L);
        c12161c.m72998o0(-4);
        c12164f.m73111w0(c12161c);
        C11839m.m70688i("CloudBackupV3FileUpload", "largeFileUpload diff succss");
        C12590s0.m75813W2(this.f46360n, "2");
    }

    /* renamed from: v */
    public final boolean m58026v(String str, String str2, String str3) {
        if (!C12583q.m75654H(this.f46356j, str, str3)) {
            return false;
        }
        if ("2".equals(this.f46360n.m29345E0())) {
            return true;
        }
        return this.f46347a.m29723l1() && !C12590s0.m75917w1(str2, this.f46356j, str, this.f46360n.m29345E0());
    }

    /* renamed from: y */
    public final void m58027y(String str, String str2, Context context, String str3, File file) {
        if ("2".equals(this.f46360n.m29345E0())) {
            m58014A(str, str2, context, file);
        } else {
            m58028z(str, str2, context, str3, file);
        }
    }

    /* renamed from: z */
    public final void m58028z(String str, String str2, Context context, String str3, File file) {
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(context, this.f46347a, this.f46350d);
        int iBackupAndroid = backupRestoreUtil.backupAndroid(str, this.f46356j, str2, str3);
        C11839m.m70688i("CloudBackupV3FileUpload", "appid = " + str + ", copy and upload file = " + str3 + " result: " + iBackupAndroid + " ,uid: " + this.f46356j);
        if (iBackupAndroid != 0) {
            C11839m.m70686d("CloudBackupV3FileUpload", "pms copy error path: " + str2);
            if (this.f46347a.m29723l1()) {
                C11839m.m70686d("CloudBackupV3FileUpload", "retry pms copy byfile path: " + str2);
                PmsUtils.copyAndroidDataFileByBrief(backupRestoreUtil, str2, C10279b.m63452a(file), this.f46356j, str);
                return;
            }
            if (str2.contains(" ") && this.f46347a.m29726m1()) {
                C11839m.m70686d("CloudBackupV3FileUpload", "filePath has PMS_INTERVAL");
                PmsUtils.copyAndroidDataFileByBrief(backupRestoreUtil, str2, C10279b.m63452a(file), this.f46356j, str);
                C11839m.m70686d("CloudBackupV3FileUpload", "filePath has PMS_INTERVAL end: " + str2);
            }
        }
    }
}
