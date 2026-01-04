package dm;

import android.os.SystemClock;
import bm.InterfaceC1260a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoForUploadOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10554e;
import im.C10555e0;
import im.C10564n;
import im.C10565o;
import im.InterfaceC10570t;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Consumer;
import mm.AbstractC11494p;
import mm.C11487i;
import mm.InterfaceC11495q;
import p455ll.C11308a;
import p495nm.C11728i;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p744wl.C13617a;
import p848zl.C14337f;
import sl.C12814e;

/* renamed from: dm.t */
/* loaded from: classes6.dex */
public class C9258t extends CloudBackupFileTask {

    /* renamed from: a */
    public C4879a f46488a;

    /* renamed from: b */
    public InterfaceC1260a f46489b;

    /* renamed from: c */
    public String f46490c;

    /* renamed from: d */
    public String f46491d;

    /* renamed from: e */
    public String f46492e;

    /* renamed from: f */
    public String f46493f;

    /* renamed from: g */
    public C10564n f46494g;

    /* renamed from: h */
    public C10565o f46495h;

    /* renamed from: i */
    public InterfaceC9213h2 f46496i;

    /* renamed from: j */
    public String f46497j;

    /* renamed from: k */
    public int f46498k;

    /* renamed from: l */
    public boolean f46499l;

    /* renamed from: m */
    public boolean f46500m;

    /* renamed from: n */
    public long f46501n;

    /* renamed from: o */
    public long f46502o;

    /* renamed from: p */
    public String f46503p;

    /* renamed from: q */
    public int f46504q;

    /* renamed from: r */
    public boolean f46505r;

    /* renamed from: s */
    public boolean f46506s;

    /* renamed from: t */
    public PmsMetaV3 f46507t;

    /* renamed from: u */
    public CloudBackupStatus f46508u;

    /* renamed from: v */
    public C9215i0 f46509v;

    /* renamed from: w */
    public C9190c f46510w;

    /* renamed from: x */
    public final String f46511x;

    /* renamed from: y */
    public final C11728i f46512y;

    public C9258t(C4879a c4879a, InterfaceC1260a interfaceC1260a, String str, InterfaceC9213h2 interfaceC9213h2, String str2, PmsMetaV3 pmsMetaV3, int i10, boolean z10, int i11, boolean z11, CloudBackupStatus cloudBackupStatus, C9215i0 c9215i0, String str3, C11728i c11728i) {
        super(str, 0);
        this.f46488a = c4879a;
        this.f46489b = interfaceC1260a;
        this.f46490c = c4879a.m29713i0();
        this.f46491d = c4879a.m29719k0();
        this.f46492e = c4879a.m29734p0();
        this.f46493f = c4879a.m29654O0();
        this.f46507t = pmsMetaV3;
        this.f46496i = interfaceC9213h2;
        this.f46497j = str2;
        this.f46498k = i10;
        this.f46499l = z10;
        this.f46503p = C13617a.m81914C(str, i11);
        this.f46504q = i11;
        this.f46506s = z11;
        this.f46508u = cloudBackupStatus;
        this.f46509v = c9215i0;
        this.f46511x = str3;
        this.f46512y = c11728i;
        m58239u();
    }

    /* renamed from: B */
    public static /* synthetic */ void m58215B(PmsMetaV3 pmsMetaV3, FileInputStream fileInputStream) throws Throwable {
        try {
            C12590s0.m75785P2(pmsMetaV3, fileInputStream);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3FileUploaderBrief", "hmacFile error: " + e10.toString());
        }
    }

    private void isCancel() throws InterruptedException, C9721b {
        this.f46488a.isCancel();
        if (this.abort) {
            throw new C9721b(1999, "task is interrupted.");
        }
    }

    /* renamed from: A */
    public final /* synthetic */ void m58221A(AbstractC10554e abstractC10554e) {
        synchronized (CloudBackupFileTask.SIZE_LOCK) {
            try {
                if (this.abort) {
                    C11839m.m70688i("CloudBackupV3FileUploaderBrief", "uploader abort return");
                } else {
                    this.f46489b.mo7511a(increaseSize((abstractC10554e.m64747z() * this.f46507t.getSize()) / 100));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: C */
    public final /* synthetic */ void m58222C(PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3, AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
        for (int i11 = 1; i11 <= i10; i11++) {
            PmsMetaV3 pmsMetaV3 = (PmsMetaV3) abstractC11494p.query(i11);
            isCancel();
            String data = pmsMetaV3.getData();
            if (pmsMetaV3.getEncoded() == 1) {
                data = ICBUtil.getDecodedPath(pmsMetaV3.getData());
            }
            C12571m.m75547i(C10279b.m63452a(C10278a.m63443i(C12583q.m75674j(0), data)));
            pmsFullBriefFilesInfoForUploadOperatorV3.updateDeleteFlagByFilePath(pmsMetaV3.getFilePath());
        }
    }

    /* renamed from: D */
    public final /* synthetic */ void m58223D(AbstractC10554e abstractC10554e) {
        synchronized (CloudBackupFileTask.SIZE_LOCK) {
            try {
                if (this.abort) {
                    C11839m.m70688i("CloudBackupV3FileUploaderBrief", "uploader abort return");
                } else {
                    this.f46489b.mo7511a(increaseSize((abstractC10554e.m64747z() * m58238t()) / 100));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: E */
    public final /* synthetic */ void m58224E(AbstractC10554e abstractC10554e) {
        synchronized (CloudBackupFileTask.SIZE_LOCK) {
            try {
                if (this.abort) {
                    C11839m.m70688i("CloudBackupV3FileUploaderBrief", "uploader abort return");
                } else {
                    this.f46489b.mo7511a(increaseSize((abstractC10554e.m64747z() * this.f46502o) / 100));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: F */
    public final boolean m58225F() {
        C4879a c4879a = this.f46488a;
        C9190c c9190c = new C9190c(c4879a, c4879a.m29734p0(), this.f46508u, this.f46488a.m29628C0(), this.f46496i, this.f46507t.getHash2(), this.f46493f, "pms", this.f46507t.getModifytime(), new InterfaceC10570t() { // from class: dm.p
            @Override // im.InterfaceC10570t
            /* renamed from: a */
            public final void mo57738a(AbstractC10554e abstractC10554e) {
                this.f46378a.m58221A(abstractC10554e);
            }
        }, this.f46507t.getSize());
        this.f46510w = c9190c;
        return c9190c.m57718l();
    }

    /* renamed from: G */
    public final void m58226G(String str) throws C9721b, IOException {
        boolean zM29699d1 = this.f46488a.m29699d1();
        this.f46505r = zM29699d1;
        PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(this.f46503p);
        if (m58242z()) {
            return;
        }
        PmsMetaV3 pmsMetaV3QueryMetaByFilePath = pmsFullBriefFilesInfoForUploadOperatorV3.queryMetaByFilePath(str);
        m58227H(pmsMetaV3QueryMetaByFilePath);
        this.f46507t.setHash1(pmsMetaV3QueryMetaByFilePath.getHash1());
        this.f46507t.setHash2(pmsMetaV3QueryMetaByFilePath.getHash2());
        this.f46507t.setCloudHash(pmsMetaV3QueryMetaByFilePath.getCloudHash());
        C12590s0.m75738E(pmsMetaV3QueryMetaByFilePath, this.f46499l, this.f46488a, this.appId, this.f46504q, this.f46509v, this.f46503p);
        if (pmsMetaV3QueryMetaByFilePath.getStatus() == -2) {
            pmsFullBriefFilesInfoForUploadOperatorV3.updateHashAndUploadInfoByFilePath(pmsMetaV3QueryMetaByFilePath);
            C11839m.m70686d("CloudBackupV3FileUploaderBrief", "updateHashAndUploadInfoByFilePath: " + pmsMetaV3QueryMetaByFilePath.getFilePath());
            this.f46500m = true;
            return;
        }
        pmsFullBriefFilesInfoForUploadOperatorV3.updateHashByFilePath(pmsMetaV3QueryMetaByFilePath.getFilePath(), pmsMetaV3QueryMetaByFilePath.getHash1(), pmsMetaV3QueryMetaByFilePath.getHash2(), pmsMetaV3QueryMetaByFilePath.getCloudHash());
        boolean zM76918e = new C12814e().m76918e(ICBUtil.RELATIVE_SDATA_PATH + File.separator, pmsMetaV3QueryMetaByFilePath.getData(), pmsMetaV3QueryMetaByFilePath.getHash1(), pmsMetaV3QueryMetaByFilePath.getHash2());
        boolean z10 = zM29699d1 || zM76918e || (!this.f46488a.m29720k1() && this.f46488a.m29737q0().contains(this.appId));
        this.f46505r = z10;
        if (z10) {
            this.f46488a.f22481o = true;
            C11839m.m70686d("CloudBackupV3FileUploaderBrief", "cloudBackupLostFile antiMdr = " + this.f46505r + ", isLost: " + zM76918e + " filePath: " + pmsMetaV3QueryMetaByFilePath.getData());
        }
    }

    /* renamed from: H */
    public final void m58227H(final PmsMetaV3 pmsMetaV3) throws C9721b, IOException {
        InterfaceC9213h2 interfaceC9213h2 = this.f46496i;
        if (interfaceC9213h2 instanceof C9217i2) {
            C12590s0.m75781O2(pmsMetaV3, ((C9217i2) interfaceC9213h2).mo57841Q());
        } else if (interfaceC9213h2 instanceof C9257s2) {
            long[] jArrM64760h = new C10555e0(((C9257s2) interfaceC9213h2).mo57842U()).m64760h(new Consumer() { // from class: dm.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) throws Throwable {
                    C9258t.m58215B(pmsMetaV3, (FileInputStream) obj);
                }
            });
            this.f46501n = jArrM64760h[0];
            this.f46502o = jArrM64760h[1];
        }
    }

    /* renamed from: I */
    public final void m58228I(C11308a c11308a) throws C9721b {
        C12571m.m75547i(this.f46496i.mo57844e0());
        if (m58242z()) {
            if (c11308a == null) {
                C11839m.m70689w("CloudBackupV3FileUploaderBrief", "asset is null");
                return;
            } else {
                final PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(this.f46503p);
                new C11487i(c11308a.m67895m(), this.appId, pmsFullBriefFilesInfoForUploadOperatorV3).execute(new InterfaceC11495q() { // from class: dm.r
                    @Override // mm.InterfaceC11495q
                    /* renamed from: a */
                    public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
                        this.f46403a.m58222C(pmsFullBriefFilesInfoForUploadOperatorV3, abstractC11494p, i10);
                    }
                });
            }
        }
        this.f46489b.mo7513c();
    }

    /* renamed from: J */
    public final void m58229J(C11308a c11308a) throws C9721b {
        if (this.f46500m) {
            return;
        }
        String strM67895m = c11308a.m67895m();
        String strM67883a = c11308a.m67883a();
        String strM67898p = c11308a.m67898p();
        PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(this.f46503p);
        if (!m58242z()) {
            pmsFullBriefFilesInfoForUploadOperatorV3.updateInfoByFilePath(this.f46497j, strM67895m, strM67883a, strM67898p, System.currentTimeMillis(), -3);
            return;
        }
        long jQueryMetaSumsizeByFileId = pmsFullBriefFilesInfoForUploadOperatorV3.queryMetaSumsizeByFileId(this.f46497j);
        long jQueryZeroMetaCountByFileId = pmsFullBriefFilesInfoForUploadOperatorV3.queryZeroMetaCountByFileId(this.f46497j);
        C11839m.m70688i("CloudBackupV3FileUploaderBrief", "update tar info id: " + this.f46497j + " size: " + jQueryMetaSumsizeByFileId + " , count: " + jQueryZeroMetaCountByFileId);
        pmsFullBriefFilesInfoForUploadOperatorV3.updateInfoByFileId(this.f46497j, strM67895m, strM67883a, strM67898p, System.currentTimeMillis(), -3, jQueryZeroMetaCountByFileId + jQueryMetaSumsizeByFileId);
    }

    /* renamed from: K */
    public final C11308a m58230K(int i10) throws InterruptedException, C9721b {
        if (this.f46500m) {
            return null;
        }
        isCancel();
        InterfaceC9213h2 interfaceC9213h2 = this.f46496i;
        if (interfaceC9213h2 instanceof C9217i2) {
            return m58231L(i10, ((C9217i2) interfaceC9213h2).mo57841Q());
        }
        if (interfaceC9213h2 instanceof C9257s2) {
            return m58232M(i10, (C9257s2) interfaceC9213h2);
        }
        return null;
    }

    /* renamed from: L */
    public final C11308a m58231L(int i10, File file) throws InterruptedException, C9721b {
        int i11;
        String strMo57844e0 = this.f46496i.mo57844e0();
        if (!this.f46496i.mo57843d0() || this.f46496i.length() <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file not exist, file = " + strMo57844e0);
        }
        try {
            C10321z c10321z = new C10321z(this.f46488a.m29713i0(), this.f46488a.m29636F0(), this.f46488a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46493f);
            c10321z.m63540D0(this.f46488a.m29761y0());
            C10564n c10564n = new C10564n(this.appId, this.f46504q, this.f46493f, c10321z, this.f46491d, this.f46492e, this.f46488a, file, null, this.f46505r, this.f46512y, this.f46508u.mo29357K());
            this.f46494g = c10564n;
            c10564n.m64772V(i10 > 0);
            this.f46494g.m64770T(new InterfaceC10570t() { // from class: dm.s
                @Override // im.InterfaceC10570t
                /* renamed from: a */
                public final void mo57738a(AbstractC10554e abstractC10554e) {
                    this.f46470a.m58223D(abstractC10554e);
                }
            });
            return this.f46494g.m64763M(i10);
        } catch (C9721b e10) {
            if (this.abort || (i11 = i10 + 1) > 2 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                throw e10;
            }
            SystemClock.sleep(500L);
            isCancel();
            if (this.abort) {
                throw e10;
            }
            C11839m.m70688i("CloudBackupV3FileUploaderBrief", "upload file = " + strMo57844e0 + ", retry = " + i11);
            C11728i c11728i = this.f46512y;
            if (c11728i != null && c11728i.m69978e()) {
                this.f46512y.m69974a(strMo57844e0);
            }
            return m58230K(i11);
        }
    }

    /* renamed from: M */
    public final C11308a m58232M(int i10, C9257s2 c9257s2) throws InterruptedException, C9721b {
        try {
            C10321z c10321z = new C10321z(this.f46490c, this.f46488a.m29636F0(), this.f46488a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46493f);
            c10321z.m63540D0(this.f46488a.m29761y0());
            C10565o c10565o = new C10565o(this.appId, this.f46504q, this.f46493f, c10321z, this.f46491d, this.f46492e, this.f46488a.m29728n0(), null, this.f46505r, c9257s2.mo57842U(), c9257s2.getName(), this.f46502o, this.f46501n, this.f46511x);
            this.f46495h = c10565o;
            c10565o.m64827i0(i10 > 0);
            this.f46495h.m64826h0(new InterfaceC10570t() { // from class: dm.q
                @Override // im.InterfaceC10570t
                /* renamed from: a */
                public final void mo57738a(AbstractC10554e abstractC10554e) {
                    this.f46383a.m58224E(abstractC10554e);
                }
            });
            return this.f46495h.m64818R(i10);
        } catch (C9721b e10) {
            if (this.abort) {
                throw e10;
            }
            int i11 = i10 + 1;
            if (m58240v(e10) || m58241y(e10) || i11 > 2 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                throw e10;
            }
            SystemClock.sleep(500L);
            isCancel();
            if (this.abort) {
                throw e10;
            }
            C11839m.m70688i("CloudBackupV3FileUploaderBrief", "upload file = " + c9257s2.mo57842U() + ", retry = " + i11);
            return m58230K(i11);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        try {
            C11839m.m70686d("CloudBackupV3FileUploaderBrief", "upload file " + this.f46497j + " start");
            m58235q(0);
            C11839m.m70686d("CloudBackupV3FileUploaderBrief", "upload file " + this.f46497j + " success");
        } finally {
            m58236r();
            this.f46489b.release();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        C11839m.m70688i("CloudBackupV3FileUploaderBrief", "cancel");
        C10564n c10564n = this.f46494g;
        if (c10564n != null) {
            c10564n.mo64711f();
        }
        C10565o c10565o = this.f46495h;
        if (c10565o != null) {
            c10565o.mo64711f();
        }
        C9190c c9190c = this.f46510w;
        if (c9190c != null) {
            c9190c.m57712f();
        }
        super.cancel(z10);
    }

    /* renamed from: k */
    public final void m58233k(C9721b c9721b, int i10) throws InterruptedException, IOException {
        try {
            if (m58240v(c9721b)) {
                if (i10 < m58237s()) {
                    m58235q(i10);
                    return;
                } else {
                    this.f46489b.mo7512b(c9721b);
                    return;
                }
            }
            if (m58241y(c9721b)) {
                m58234p();
            } else {
                this.f46489b.mo7512b(c9721b);
            }
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackupV3FileUploaderBrief", "dealExecuteTaskException: " + c9721b.toString());
            this.f46489b.mo7512b(e10);
        }
    }

    /* renamed from: p */
    public final void m58234p() throws C9721b {
        C11839m.m70688i("CloudBackupV3FileUploaderBrief", "dealFileNotExist: " + this.f46496i.getName());
        if (this.f46496i instanceof C9257s2) {
            new PmsFullBriefFilesInfoOperatorV3(this.f46503p).updateNotExistFileInfoStatus(this.f46496i.mo57842U());
            m58228I(null);
        }
    }

    /* renamed from: q */
    public final void m58235q(int i10) throws InterruptedException, IOException {
        try {
            m58226G(this.f46497j);
            if (this.f46500m || !this.f46506s) {
                C11308a c11308aM58230K = m58230K(0);
                m58229J(c11308aM58230K);
                m58228I(c11308aM58230K);
            } else {
                boolean zM58225F = m58225F();
                isCancel();
                if (zM58225F) {
                    C12571m.m75547i(this.f46496i.mo57844e0());
                    PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(this.f46503p);
                    this.f46507t.setType(8);
                    this.f46507t.setStatus(-3);
                    pmsFullBriefFilesInfoForUploadOperatorV3.updateHashAndUploadInfoByFilePath(this.f46507t);
                    C12590s0.m75813W2(this.f46508u, "1");
                    this.f46489b.mo7513c();
                    C11839m.m70688i("CloudBackupV3FileUploaderBrief", "diff succss");
                } else {
                    C11308a c11308aM58230K2 = m58230K(0);
                    m58229J(c11308aM58230K2);
                    m58228I(c11308aM58230K2);
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3FileUploaderBrief", "upload file " + this.f46497j + " error: " + e10.getMessage());
            m58233k(e10, i10 + 1);
        }
    }

    /* renamed from: r */
    public final void m58236r() {
        if (m58242z() && this.f46496i.mo57843d0()) {
            long jMo57847p0 = this.f46496i.mo57847p0();
            if (this.f46501n == jMo57847p0) {
                C12571m.m75547i(this.f46496i.mo57844e0());
                return;
            }
            C11839m.m70686d("CloudBackupV3FileUploaderBrief", "delete return v3data tarfileModifytime: " + this.f46501n + " ,current: " + jMo57847p0);
        }
    }

    /* renamed from: s */
    public final int m58237s() {
        return this.f46496i instanceof C9257s2 ? 3 : 1;
    }

    /* renamed from: t */
    public final long m58238t() {
        InterfaceC9213h2 interfaceC9213h2 = this.f46496i;
        return interfaceC9213h2 instanceof C9217i2 ? interfaceC9213h2.length() : this.f46502o;
    }

    /* renamed from: u */
    public final void m58239u() {
        InterfaceC9213h2 interfaceC9213h2 = this.f46496i;
        if (interfaceC9213h2 instanceof C9217i2) {
            this.f46501n = interfaceC9213h2.mo57847p0();
            this.f46502o = this.f46496i.length();
        }
    }

    /* renamed from: v */
    public final boolean m58240v(C9721b c9721b) {
        return 1031 == c9721b.m60659c();
    }

    /* renamed from: y */
    public final boolean m58241y(C9721b c9721b) {
        return 1032 == c9721b.m60659c();
    }

    /* renamed from: z */
    public final boolean m58242z() {
        return 7 == this.f46498k;
    }
}
