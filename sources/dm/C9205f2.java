package dm;

import android.content.Context;
import android.content.p017pm.IPackageDataObserver;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cm.C1460f;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.provider.QueryAppRestoreFromProvider;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gm.C9992e0;
import gp.C10028c;
import hk.C10278a;
import im.AbstractC10571u;
import im.C10546a;
import im.C10547a0;
import im.C10574x;
import im.InterfaceC10551c0;
import im.InterfaceC10562l;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import je.C10782d;
import mk.C11476b;
import mm.C11490l;
import mm.InterfaceC11493o;
import p015ak.C0213f;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p709vj.C13452e;
import p744wl.C13617a;
import p746wn.C13622a;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import pl.C12161c;
import pl.C12164f;
import pm.C12187n;
import pm.C12188o;
import sl.C12810a;
import sl.C12811b;
import sl.C12815f;
import sl.C12816g;

/* renamed from: dm.f2 */
/* loaded from: classes6.dex */
public class C9205f2 extends CloudBackupModuleTask {

    /* renamed from: B */
    public static final Object f46174B = new Object();

    /* renamed from: A */
    public RestoreModuleReportInfo f46175A;

    /* renamed from: a */
    public Context f46176a;

    /* renamed from: b */
    public C4880b f46177b;

    /* renamed from: c */
    public C1460f f46178c;

    /* renamed from: d */
    public boolean f46179d;

    /* renamed from: e */
    public boolean f46180e;

    /* renamed from: f */
    public boolean f46181f;

    /* renamed from: g */
    public CloudRestoreStatusV3 f46182g;

    /* renamed from: h */
    public C9992e0 f46183h;

    /* renamed from: i */
    public C12816g f46184i;

    /* renamed from: j */
    public C12811b f46185j;

    /* renamed from: k */
    public C12164f f46186k;

    /* renamed from: l */
    public C10574x f46187l;

    /* renamed from: m */
    public C10547a0 f46188m;

    /* renamed from: n */
    public String f46189n;

    /* renamed from: o */
    public String f46190o;

    /* renamed from: p */
    public String f46191p;

    /* renamed from: q */
    public String f46192q;

    /* renamed from: r */
    public Set<String> f46193r;

    /* renamed from: s */
    public boolean f46194s;

    /* renamed from: t */
    public C9721b f46195t;

    /* renamed from: u */
    public long f46196u;

    /* renamed from: v */
    public int f46197v;

    /* renamed from: w */
    public int f46198w;

    /* renamed from: x */
    public C9252r1 f46199x;

    /* renamed from: y */
    public C9721b f46200y;

    /* renamed from: z */
    public boolean f46201z;

    /* renamed from: dm.f2$a */
    public class a implements InterfaceC10562l {

        /* renamed from: a */
        public long f46202a = 0;

        /* renamed from: b */
        public final /* synthetic */ boolean f46203b;

        public a(boolean z10) {
            this.f46203b = z10;
        }

        /* renamed from: c */
        private void m57818c(AbstractC10571u abstractC10571u) {
            long jM64862U = abstractC10571u.m64862U();
            long jM64864W = abstractC10571u.m64864W();
            if (jM64864W == 0 || jM64862U > jM64864W || ((CloudBackupBaseTask) C9205f2.this).abort) {
                return;
            }
            long size = C9205f2.this.f46182g.getSize();
            long asize = C9205f2.this.f46182g.getAsize();
            long j10 = size + asize;
            long j11 = jM64862U - this.f46202a;
            if (j11 < 0) {
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "send Progress, the increase is invalid. increase is:" + j11);
                return;
            }
            C9205f2.m57772D(C9205f2.this, j11);
            C11839m.m70686d("CloudRestoreV3ModulePrepare", "send Progress, value: " + jM64862U + " | size: " + size + "| asize: " + asize + " | alreadyDownloadSize: " + C9205f2.this.f46196u + " download3rdApp:" + this.f46203b + " totalLength:" + jM64864W);
            if (C9205f2.this.f46196u <= j10) {
                RestoreProgressManager.getInstance().addBytesDownloaded(j11);
                C9205f2.this.f46182g.addBytesDownloaded(this.f46203b, j11);
            } else {
                C9205f2.this.f46196u = j10;
            }
            boolean zIs3rdAppType = C9205f2.this.f46182g.is3rdAppType();
            if (zIs3rdAppType || C9205f2.this.f46182g.m29486U()) {
                synchronized (C9205f2.f46174B) {
                    try {
                        this.f46202a = jM64862U;
                        boolean z10 = jM64862U == jM64864W;
                        if (this.f46203b) {
                            m57820b(Math.min((int) Math.floor((C9205f2.this.f46196u / jM64864W) * 100.0d), 100), z10, zIs3rdAppType);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        @Override // im.InterfaceC10562l
        /* renamed from: a */
        public void mo57819a(AbstractC10571u abstractC10571u) {
            m57818c(abstractC10571u);
        }

        /* renamed from: b */
        public final void m57820b(int i10, boolean z10, boolean z11) {
            if (((CloudBackupBaseTask) C9205f2.this).abort || C9205f2.this.f46195t != null) {
                C11839m.m70686d("CloudRestoreV3ModulePrepare", "update3rdProgress appId" + ((CloudBackupModuleTask) C9205f2.this).appId + "pause " + C9205f2.this.f46180e + " ,uid: " + C9205f2.this.f46182g.getUid());
                return;
            }
            C11839m.m70686d("CloudRestoreV3ModulePrepare", "update3rdProgress percent =" + i10 + ", appId:" + ((CloudBackupModuleTask) C9205f2.this).appId + " lastProgressForTimer =" + C9205f2.this.f46197v + " isDone" + z10);
            if (i10 - C9205f2.this.f46197v > 0 || z10) {
                C9205f2.this.f46197v = i10;
                C9205f2.this.f46182g.setCurrent(i10).setCount(100);
                RestoreProgress.updateStatus(C9205f2.this.f46182g);
                if (z11 && !C9205f2.this.f46182g.isTwinApp() && C9205f2.this.f46182g.m29478Q() && C9205f2.this.f46194s) {
                    if (i10 - C9205f2.this.f46198w >= 10 || z10) {
                        C11839m.m70686d("CloudRestoreV3ModulePrepare", "update3rd progress, appId = " + ((CloudBackupModuleTask) C9205f2.this).appId + " percent = " + i10 + " ,uid: " + C9205f2.this.f46182g.getUid());
                        C9205f2.this.f46198w = i10;
                        Bundle bundle = new Bundle();
                        bundle.putString("packageName_", C9205f2.this.f46182g.m29470M());
                        bundle.putString("name_", C9205f2.this.f46182g.getAppName());
                        bundle.putInt("status_", 2);
                        bundle.putInt("progress_", i10);
                        ICBBroadcastManager.sendDownloadEventBroadcast(C9205f2.this.f46176a, bundle);
                    }
                }
            }
        }
    }

    public C9205f2(C4880b c4880b, C9992e0 c9992e0, CloudRestoreStatusV3 cloudRestoreStatusV3, Set<String> set, String str) {
        super(cloudRestoreStatusV3.getAppId());
        this.f46179d = false;
        this.f46180e = false;
        this.f46184i = new C12816g();
        this.f46185j = new C12811b();
        this.f46195t = null;
        this.f46196u = 0L;
        this.f46201z = false;
        this.f46177b = c4880b;
        this.f46178c = c4880b.m29776K();
        this.f46194s = c4880b.m29790Y();
        this.f46183h = c9992e0;
        this.f46182g = cloudRestoreStatusV3;
        this.f46192q = str;
        this.f46176a = C0213f.m1377a();
        this.f46189n = c9992e0.m61983n();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f46189n);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(this.appId);
        sb2.append(str2);
        sb2.append("info.xml");
        this.f46190o = sb2.toString();
        this.f46193r = set;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(isEncrypt() ? "" : "/Backup");
        sb3.append("/CloudBackup/");
        sb3.append(C11476b.m68626h(c4880b.m29773H()));
        sb3.append("/");
        this.f46191p = sb3.toString();
    }

    /* renamed from: D */
    public static /* synthetic */ long m57772D(C9205f2 c9205f2, long j10) {
        long j11 = c9205f2.f46196u + j10;
        c9205f2.f46196u = j11;
        return j11;
    }

    /* renamed from: O */
    private String m57781O(C12161c c12161c) throws C9721b {
        return C12590s0.m75758J(c12161c, this.f46182g, "V4".equals(this.f46177b.f22517K), this.f46177b.getLocation() + File.separator + this.appId);
    }

    private void dealError(int i10, C9721b c9721b) {
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "dealError code = " + i10);
        if (i10 == 1001 || i10 == 1007) {
            C12816g c12816g = this.f46184i;
            CloudRestoreStatusV3 cloudRestoreStatusV3 = this.f46182g;
            c12816g.m76958v(cloudRestoreStatusV3, cloudRestoreStatusV3.getStatus(), 2);
            this.f46177b.setException(c9721b);
            return;
        }
        if (i10 != 3900) {
            switch (i10) {
                case 1104:
                case 1105:
                case 1106:
                case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                    break;
                default:
                    C12816g c12816g2 = this.f46184i;
                    CloudRestoreStatusV3 cloudRestoreStatusV32 = this.f46182g;
                    c12816g2.m76958v(cloudRestoreStatusV32, cloudRestoreStatusV32.getStatus(), 2);
                    break;
            }
            return;
        }
        this.f46184i.m76958v(this.f46182g, 0, 0);
        sendDownloadStatus(0);
        this.f46177b.setException(c9721b);
    }

    private boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private boolean isNetDisconnect(C9721b c9721b) {
        C11839m.m70688i("CloudRestoreV3ModulePrepare", c9721b.toString());
        int iM60659c = c9721b.m60659c();
        return 1104 == iM60659c || 1105 == iM60659c || 1106 == iM60659c || 1107 == iM60659c || 3900 == iM60659c;
    }

    private boolean isSuccess() {
        int type = this.f46182g.getType();
        C11839m.m70686d("CloudRestoreV3ModulePrepare", "isSuccess type: " + type + " ,status: " + this.f46182g.getStatus());
        if (!this.f46182g.is3rdAppType() || !this.f46182g.m29484T()) {
            return 1 == type;
        }
        int status = this.f46182g.getStatus();
        if (status != 5) {
            if (status != 6 || type == 2) {
                return false;
            }
        } else if (type != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: r */
    private void m57790r() {
        new C13998b0().m84119P0(this.f46177b.m29783R(), this.f46177b.m29772G(), "resourceScan");
    }

    /* renamed from: r0 */
    private void m57791r0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (isSuccess()) {
            Boolean bool = Boolean.TRUE;
            boolean zEquals = bool.equals(this.f46175A.isAgdDownloadSuccess());
            boolean zEquals2 = bool.equals(this.f46175A.isPpsDownloadSuccess());
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "restoreEnd success, isAgd = " + zEquals + ", isPps = " + zEquals2);
            if (!zEquals && !zEquals2) {
                sendDownloadStatus(4);
                if (!this.f46182g.isTwinApp() && this.f46183h.f48901s.contains(this.f46182g.m29470M())) {
                    ICBBroadcastManager.sendInstallEventBroadcast(this.f46176a, this.f46182g.m29470M(), 0);
                }
                if (this.f46182g.is3rdAppType()) {
                    this.f46182g.setCurrent(100);
                }
                RestoreProgress.updateStatus(this.f46182g);
            }
            C12187n.m73319p(this.f46177b, this.f46182g);
        } else {
            if (!C10782d.m65634a().m65642i(this.f46176a)) {
                this.f46195t = new C9721b(1104, "net disabled, appId = " + this.appId);
            }
            if (this.f46195t == null) {
                this.f46195t = new C9721b(1999, "download module interrupted, appId =" + this.appId + " uid: " + this.f46182g.getUid());
            }
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "restoreEnd fail, abort = " + this.abort + ", condition = " + this.f46181f + ", cancel = " + this.f46179d + ", pause = " + this.f46180e);
            if (!this.abort) {
                dealError(this.f46195t.m60659c(), this.f46195t);
            } else if (this.f46181f || isNetDisconnect(this.f46195t)) {
                this.f46184i.m76958v(this.f46182g, 0, 0);
                sendDownloadStatus(0);
            } else if (this.f46179d) {
                this.f46184i.m76958v(this.f46182g, 1, 0);
                sendDownloadStatus(3);
            } else if (this.f46180e) {
                this.f46184i.m76958v(this.f46182g, 2, 0);
                sendDownloadStatus(6);
            } else {
                C12816g c12816g = this.f46184i;
                CloudRestoreStatusV3 cloudRestoreStatusV3 = this.f46182g;
                c12816g.m76958v(cloudRestoreStatusV3, cloudRestoreStatusV3.getStatus(), 2);
                this.f46177b.setException(this.f46195t);
            }
            this.f46177b.checkException(this.f46195t);
            C12187n.m73309f(this.f46177b, this.f46182g);
        }
        m57800N();
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "restore one module end, appId = " + this.appId + " uid: " + this.f46182g.getUid() + " status: " + this.f46182g.getStatus() + " type: " + this.f46182g.getType());
    }

    /* renamed from: s0 */
    private InterfaceC10562l m57793s0(boolean z10) {
        return new a(z10);
    }

    private void sendDownloadStatus(int i10) {
        if (!this.f46182g.isTwinApp() && this.f46182g.is3rdAppType() && this.f46194s) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "sendDownloadStatus: appId = " + this.f46182g.getAppId() + ", status = " + i10 + " ,uid: " + this.f46182g.getUid());
            Bundle bundle = new Bundle();
            bundle.putString("packageName_", this.f46182g.m29470M());
            bundle.putString("name_", this.f46182g.getAppName());
            bundle.putInt("status_", i10);
            ICBBroadcastManager.sendDownloadEventBroadcast(this.f46176a, bundle);
        }
    }

    /* renamed from: M */
    public final void m57799M(List<C12161c> list, int i10) throws InterruptedException, C9721b {
        m57805T();
        ArrayList arrayList = new ArrayList();
        if (AbstractC14026a.m84159a(list)) {
            return;
        }
        for (C12161c c12161c : list) {
            if (((int) c12161c.m72953I()) == 5) {
                C12590s0.m75824Z1(m57781O(c12161c), !"V4".equals(this.f46177b.f22517K));
                arrayList.add(c12161c.m72991l());
            }
        }
        this.f46186k.m73077f(arrayList, 2L);
    }

    /* renamed from: N */
    public final void m57800N() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f46176a == null) {
            C11839m.m70689w("CloudRestoreV3ModulePrepare", "deleteApplicationCacheFiles the mContext is null.");
            return;
        }
        if (C9733f.m60705z().m60751k()) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "deleteApplicationCacheFiles: the switch is closed, no need delete cache files, appId = " + this.appId);
            return;
        }
        if (!this.f46182g.is3rdAppType() || 1 == this.f46182g.getAction()) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "deleteApplicationCacheFiles: ths app no need delete cache files, appId = " + this.appId);
            return;
        }
        try {
            PackageManager packageManager = this.f46176a.getPackageManager();
            Method declaredMethod = packageManager.getClass().getDeclaredMethod("deleteApplicationCacheFilesAsUser", String.class, Integer.TYPE, IPackageDataObserver.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(packageManager, this.appId, Integer.valueOf(this.f46182g.getUid()), null);
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "deleteApplicationCacheFiles success, appId = " + this.appId + " uid: " + this.f46182g.getUid() + " status: " + this.f46182g.getStatus() + " type: " + this.f46182g.getType());
        } catch (Exception e10) {
            C11839m.m70689w("CloudRestoreV3ModulePrepare", "deleteApplicationCacheFiles error, appId = " + this.appId + " uid: " + this.f46182g.getUid() + " status: " + this.f46182g.getStatus() + " type: " + this.f46182g.getType() + "err: " + e10);
        }
    }

    /* renamed from: P */
    public final void m57801P() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "download one module start, appId = " + this.appId + " uid: " + this.f46182g.getUid());
        this.f46182g.setSubStatus("prepareDownloadBegin");
        RestoreProgress.updateStatus(this.f46182g);
        CloudRestoreStatusV3 cloudRestoreStatusV3M76948l = this.f46184i.m76948l(this.appId, this.f46182g.getUid());
        if (cloudRestoreStatusV3M76948l != null) {
            this.f46182g.setStatus(cloudRestoreStatusV3M76948l.getStatus()).setType(cloudRestoreStatusV3M76948l.getType());
        }
        if (this.f46182g.getStatus() == 1 || this.f46182g.getStatus() == 2) {
            throw new C9721b(1999, "task cancel or pause: " + this.f46182g.getStatus());
        }
        File fileM63442h = C10278a.m63442h(this.f46189n + "/" + this.appId);
        File fileM63442h2 = C10278a.m63442h(this.f46189n + ICBUtil.TAR_LOCAL_DIR + this.appId);
        File fileM63442h3 = C10278a.m63442h(C12583q.m75678n(this.appId, this.f46182g.getUid()));
        File fileM63442h4 = C10278a.m63442h(C12583q.m75679o(this.appId, this.f46182g.getUid()));
        C12590s0.m75812W1(fileM63442h);
        C12590s0.m75812W1(fileM63442h2);
        C12590s0.m75812W1(fileM63442h3);
        C12590s0.m75812W1(fileM63442h4);
        m57805T();
        this.f46184i.m76958v(this.f46182g, 4, 0);
        RestoreProgress.updateStatus(this.f46182g);
        restore3rdIconsBeforeLauncher();
        m57807V(this.f46182g);
    }

    /* renamed from: Q */
    public final void m57802Q() throws C9721b {
        this.f46182g.setSubStatus("prepareDownloadInfo");
        RestoreProgress.updateStatus(this.f46182g);
        C12810a c12810aM76880e = this.f46185j.m76880e(this.appId, "xml", this.f46182g.getUid());
        if (c12810aM76880e == null) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "info.xml attachment not exist");
            return;
        }
        if (2 == c12810aM76880e.m76862m() && C10278a.m63442h(this.f46190o).exists()) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "info.xml already exist");
            return;
        }
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "download info.xml begin");
        final String strM76851b = c12810aM76880e.m76851b();
        final String strM29503v = this.f46182g.m29503v();
        final String strM76865p = c12810aM76880e.m76865p();
        C12590s0.m75845e1(this.f46190o, c12810aM76880e.m76861l(), this.f46189n);
        C10546a.m64704a(new C10546a.a() { // from class: dm.v1
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f46527a.m57811Z(strM29503v, strM76851b, strM76865p);
            }
        }).m64705b();
        this.f46185j.m76881f(this.appId, "xml", 2, this.f46182g.getUid());
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "download info.xml end.");
    }

    /* renamed from: R */
    public final void m57803R() throws Throwable {
        C12164f c12164f;
        C12164f c12164f2;
        C12164f c12164f3;
        C12164f c12164f4;
        this.f46182g.setSubStatus("prepareDownloadSnapshot");
        RestoreProgress.updateStatus(this.f46182g);
        if (this.f46182g.is3rdAppType() && 1 == this.f46182g.getAction()) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "no need restore appdata, no need to download snapshot");
            m57805T();
            return;
        }
        C12810a c12810aM76880e = this.f46185j.m76880e(this.appId, SnapshotDBManager.PREFIX_DATABASE_NAME, this.f46182g.getUid());
        if (c12810aM76880e == null) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "snapshot attachment not exist");
            return;
        }
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "download snapshot begin.");
        String backupId = this.f46177b.getBackupId();
        String strM81942x = C13617a.m81942x(backupId, this.appId, 1, this.f46182g.getUid());
        File fileM63442h = C10278a.m63442h(strM81942x);
        boolean zExists = fileM63442h.exists();
        boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupSnapshotRecoverRestore");
        if (!zExists) {
            C12590s0.m75845e1(strM81942x, c12810aM76880e.m76861l(), this.f46189n);
            File fileM63442h2 = C10278a.m63442h(C13617a.m81942x(backupId, this.appId, 0, this.f46182g.getUid()));
            if (fileM63442h2.exists()) {
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "snapshot exist, copy snapshot to restore directory, appId = " + this.appId + " ,uid: " + this.f46182g.getUid());
                if (zM60720O) {
                    DatabaseRepairUtil.m15923m(fileM63442h2, C11058a.m66626a(this.f46177b.m29783R(), "DatabaseRepairUtil", C13452e.m80781L().m80971t0()));
                }
                try {
                    c12164f4 = new C12164f(backupId, this.appId, 0, this.f46182g.getUid());
                } catch (Throwable th2) {
                    th = th2;
                    c12164f3 = null;
                }
                try {
                    if (c12164f4.queryCount() > 0) {
                        zExists = C11835i.m70640d(fileM63442h2, fileM63442h);
                    } else {
                        C11839m.m70689w("CloudRestoreV3ModulePrepare", "db invalid, delete = " + fileM63442h2.delete() + ", appId = " + this.appId + " ,uid: " + this.f46182g.getUid());
                    }
                    c12164f4.close();
                } catch (Throwable th3) {
                    th = th3;
                    c12164f3 = c12164f4;
                    if (c12164f3 != null) {
                        c12164f3.close();
                    }
                    throw th;
                }
            }
        }
        if (!zExists || !fileM63442h.exists()) {
            m57804S(c12810aM76880e);
            if (zM60720O) {
                DatabaseRepairUtil.m15923m(fileM63442h, C11058a.m66626a(this.f46177b.m29783R(), "DatabaseRepairUtil", C13452e.m80781L().m80971t0()));
            }
        }
        try {
            c12164f2 = new C12164f(backupId, this.appId, 1, this.f46182g.getUid());
        } catch (Throwable th4) {
            th = th4;
            c12164f = null;
        }
        try {
            if (c12164f2.queryCount() <= 0) {
                m57804S(c12810aM76880e);
                if (zM60720O) {
                    DatabaseRepairUtil.m15923m(fileM63442h, C11058a.m66626a(this.f46177b.m29783R(), "DatabaseRepairUtil", C13452e.m80781L().m80971t0()));
                }
            }
            c12164f2.close();
            m57816p0();
            this.f46186k = new C12164f(this.f46177b.getBackupId(), this.appId, 1, this.f46182g.getUid());
            if (2 == c12810aM76880e.m76862m()) {
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "snapshot already exist");
                return;
            }
            this.f46186k.m73108v(this.f46177b.f22517K);
            CloudBackupReport.reportRestoreFileStatusAbnormalNum(this.f46177b.m29783R(), this.appId, this.f46177b.isFromOOBE(), this.f46186k.m73050N());
            this.f46186k.m73037G0(0L);
            this.f46185j.m76881f(this.appId, SnapshotDBManager.PREFIX_DATABASE_NAME, 2, this.f46182g.getUid());
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "download snapshot end.");
        } catch (Throwable th5) {
            th = th5;
            c12164f = c12164f2;
            if (c12164f != null) {
                c12164f.close();
            }
            throw th;
        }
    }

    /* renamed from: S */
    public final void m57804S(C12810a c12810a) throws C9721b {
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "snapshot is not exist, begin download snapshot");
        if (2 == c12810a.m76862m()) {
            c12810a.m76846C(0);
        }
        String str = this.f46177b.m29779N() + ICBUtil.TAR_LOCAL_DIR + this.appId + FeedbackWebConstants.SUFFIX;
        if (c12810a.m76863n() != 0) {
            str = this.f46177b.m29779N() + ICBUtil.TAR_LOCAL_DIR + this.appId + "_" + c12810a.m76863n() + FeedbackWebConstants.SUFFIX;
        }
        File fileM63442h = C10278a.m63442h(str);
        final String strM76851b = c12810a.m76851b();
        final String strM29503v = this.f46182g.m29503v();
        final String strM76865p = c12810a.m76865p();
        final String str2 = str;
        C10546a.m64704a(new C10546a.a() { // from class: dm.d2
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f46158a.m57812i0(str2, strM29503v, strM76851b, strM76865p);
            }
        }).m64705b();
        if (!C12590s0.m75805U2(str, this.f46177b.m29779N())) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unzip file: " + fileM63442h.getName());
        }
        if (fileM63442h.delete()) {
            return;
        }
        C11839m.m70689w("CloudRestoreV3ModulePrepare", "download snapshot tar file: " + fileM63442h.getName() + ", delete error.");
    }

    /* renamed from: T */
    public void m57805T() throws InterruptedException, C9721b {
        this.f46177b.isCancel();
        if (!C10782d.m65634a().m65642i(this.f46176a)) {
            condition();
            throw new C9721b(1002, "net disable.", "isCancel");
        }
        C9721b c9721b = this.f46195t;
        if (c9721b != null) {
            throw c9721b;
        }
        if (this.abort) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "process abort.");
            throw new C9721b(1999, "process abort", "isCancel");
        }
    }

    /* renamed from: U */
    public final boolean m57806U() {
        return this.f46194s && "HWlanucher".equals(this.appId);
    }

    /* renamed from: V */
    public final void m57807V(CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        if (cloudRestoreStatusV3.is3rdAppType() && cloudRestoreStatusV3.getAction() == 0) {
            String appId = cloudRestoreStatusV3.getAppId();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            if (!ICBUtil.isForGroundProcess(cloudRestoreStatusV3.m29470M(), this.f46176a, atomicInteger)) {
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "killBackgroundProcesses, background localAppId = " + appId);
                return;
            }
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "killBackgroundProcesses, foreground localAppId = " + appId);
            this.f46184i.m76958v(cloudRestoreStatusV3, -2, 2);
            throw new C9721b(FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, "app running foreground importance: " + atomicInteger.get(), "isCancel");
        }
    }

    /* renamed from: W */
    public final /* synthetic */ void m57808W(C9721b c9721b) {
        this.f46200y = c9721b;
    }

    /* renamed from: X */
    public final /* synthetic */ void m57809X(Boolean bool) {
        this.f46201z = bool.booleanValue();
    }

    /* renamed from: Y */
    public final /* synthetic */ void m57810Y(RestoreModuleReportInfo restoreModuleReportInfo) {
        this.f46175A.setAgdDownloadSuccess(restoreModuleReportInfo.isAgdDownloadSuccess());
        this.f46175A.setAgdDownloadVersion(restoreModuleReportInfo.getAgdDownloadVersion());
        this.f46175A.setPpsDownloadSuccess(restoreModuleReportInfo.isPpsDownloadSuccess());
        this.f46175A.setPpsDownloadVersion(restoreModuleReportInfo.getPpsDownloadVersion());
    }

    /* renamed from: Z */
    public final /* synthetic */ InterfaceC10551c0 m57811Z(String str, String str2, String str3) throws InterruptedException, C9721b {
        m57805T();
        C10574x c10574x = new C10574x(this.f46177b.getBackupId(), this.f46177b.m29783R(), this.f46178c, this.f46190o, "xml", str, str2, str3);
        this.f46187l = c10574x;
        c10574x.m64876j0(this.f46177b.m29772G());
        this.f46187l.m64875i0(m57793s0(false));
        return this.f46187l;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f46182g == null) {
            return;
        }
        RestoreModuleReportInfo restoreModuleReportInfo = new RestoreModuleReportInfo();
        this.f46175A = restoreModuleReportInfo;
        restoreModuleReportInfo.setAppId(this.appId);
        try {
            try {
                this.f46183h.m61987w(this.f46182g);
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "restore prepare start: " + this.appId);
                m57805T();
                m57801P();
                m57805T();
                m57803R();
                RestoreUtil.pmsMoveCheckBeforeDownload(this.appId, this.f46182g.getUid());
                m57805T();
                m57802Q();
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "restore prepare download finish");
                m57805T();
                createDirs();
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "restore prepare createDirs finish");
                m57805T();
                download();
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "restore prepare end");
            } catch (Exception e10) {
                try {
                    String str = this.f46189n;
                    C12590s0.m75845e1(str, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE, str);
                    if (e10 instanceof C9721b) {
                        this.f46195t = (C9721b) e10;
                    } else {
                        this.f46195t = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore error. appId = " + this.appId + e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
                    }
                } catch (C9721b e11) {
                    C11839m.m70687e("CloudRestoreV3ModulePrepare", "restore one module isLocalSpaceEnough error: " + e11);
                    this.f46195t = e11;
                }
                C11839m.m70687e("CloudRestoreV3ModulePrepare", "restore one module + " + this.f46182g.getAppId() + "restoreStatus = " + this.f46182g.getStatus() + " error: " + this.f46195t.toString());
                this.f46175A.setErrorReason(this.f46195t.getMessage());
            }
        } finally {
            m57791r0();
            this.f46184i.m76956t(this.f46182g, this.f46195t);
            this.f46175A.update(this.f46182g);
            CloudBackupReport.reportSingleModuleRestore(this.f46175A, this.f46177b.m29783R(), true, this.f46177b.getEntryType(), RestoreCache.getInstance().getEntranceOfRestore(), this.f46201z, this.f46177b.m29587j());
        }
    }

    public void cancel() {
        this.f46179d = true;
        this.abort = true;
        Optional.ofNullable(this.f46199x).ifPresent(new Consumer() { // from class: dm.u1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((C9252r1) obj).cancel();
            }
        });
    }

    public void condition() {
        this.f46181f = true;
        this.abort = true;
        Optional.ofNullable(this.f46199x).ifPresent(new Consumer() { // from class: dm.x1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((C9252r1) obj).condition();
            }
        });
    }

    public final void createDirs() throws InterruptedException, C9721b {
        this.f46182g.setSubStatus("prepareCreateDirs");
        RestoreProgress.updateStatus(this.f46182g);
        if (this.f46182g.is3rdAppType() && 1 == this.f46182g.getAction()) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "no need restore appdata");
            m57805T();
            this.f46184i.m76958v(this.f46182g, 4, 1);
            return;
        }
        if (this.f46185j.m76880e(this.appId, SnapshotDBManager.PREFIX_DATABASE_NAME, this.f46182g.getUid()) == null) {
            this.f46184i.m76958v(this.f46182g, 4, 2);
            m57790r();
            throw new C9721b(1009, this.appId + " snapshot attachment is empty");
        }
        this.f46186k.m73043J0(1, 2);
        if (this.f46186k.m73026B() != 0) {
            new C11490l(this.appId, this.f46186k).batchExecute(new InterfaceC11493o() { // from class: dm.w1
                @Override // mm.InterfaceC11493o
                /* renamed from: a */
                public final void mo15310a(List list, int i10) throws InterruptedException, C9721b {
                    this.f46536a.m57799M(list, i10);
                }
            });
            return;
        }
        C11839m.m70688i("CloudRestoreV3ModulePrepare", "no file info in cloud. appId = " + this.appId + " ,uid: " + this.f46182g.getUid());
        this.f46184i.m76959w(this.appId, 4, this.f46182g.getUid(), 1, this.f46182g.getSubStatus());
    }

    public final void download() throws C9721b {
        C9252r1 c9252r1 = new C9252r1(this.f46177b, this.f46183h, this.f46182g, this.f46193r, this.f46194s, this.f46192q);
        this.f46199x = c9252r1;
        c9252r1.setExceptionConsumer(new Consumer() { // from class: dm.a2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f46062a.m57808W((C9721b) obj);
            }
        });
        this.f46199x.setDownloadApkConsumer(new Consumer() { // from class: dm.b2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f46076a.m57809X((Boolean) obj);
            }
        });
        this.f46199x.setReportInfoConsumer(new Consumer() { // from class: dm.c2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f46126a.m57810Y((RestoreModuleReportInfo) obj);
            }
        });
        try {
            try {
                C12188o.m73320c().m73321a(this.f46199x, this.f46182g).get();
                if (this.f46200y == null) {
                    return;
                }
                C11839m.m70687e("CloudRestoreV3ModulePrepare", "downloadException exist");
                throw this.f46200y;
            } catch (InterruptedException unused) {
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "download task InterruptedException");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download task InterruptedException, appId = " + this.appId);
            } catch (ExecutionException unused2) {
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "download task ExecutionException");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download task ExecutionException, appId = " + this.appId);
            }
        } finally {
            C12188o.m73320c().m73323d(this.f46182g);
        }
    }

    /* renamed from: i0 */
    public final /* synthetic */ InterfaceC10551c0 m57812i0(String str, String str2, String str3, String str4) throws InterruptedException, C9721b {
        m57805T();
        C10574x c10574x = new C10574x(this.f46177b.getBackupId(), this.f46177b.m29783R(), this.f46178c, str, SnapshotDBManager.PREFIX_DATABASE_NAME, str2, str3, str4);
        this.f46187l = c10574x;
        c10574x.m64876j0(this.f46177b.m29772G());
        this.f46187l.m64875i0(m57793s0(false));
        return this.f46187l;
    }

    public final boolean isAPPExist() throws PackageManager.NameNotFoundException {
        try {
            C11839m.m70686d("CloudRestoreV3ModulePrepare", "package version = " + this.f46176a.getPackageManager().getPackageInfo(this.f46182g.m29470M(), 16384).versionName + " appId = " + this.appId + " ,uid: " + this.f46182g.getUid());
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    /* renamed from: j0 */
    public final /* synthetic */ InterfaceC10551c0 m57813j0(String str, String str2) throws InterruptedException, C9721b {
        m57805T();
        C10547a0 c10547a0 = new C10547a0(this.f46177b.getBackupId(), this.f46177b.m29783R(), this.f46178c, str, str2, 2);
        this.f46188m = c10547a0;
        c10547a0.m64876j0(this.f46177b.m29772G());
        this.f46188m.m64875i0(m57793s0(true));
        return this.f46188m;
    }

    /* renamed from: m0 */
    public final /* synthetic */ InterfaceC10551c0 m57814m0(String str, String str2, String str3, String str4) throws InterruptedException, C9721b {
        m57805T();
        C10574x c10574x = new C10574x(this.f46177b.getBackupId(), this.f46177b.m29783R(), this.f46178c, str, "icon", str2, str3, str4);
        this.f46187l = c10574x;
        c10574x.m64876j0(this.f46177b.m29772G());
        this.f46187l.m64875i0(m57793s0(false));
        return this.f46187l;
    }

    /* renamed from: n0 */
    public final void m57815n0() throws C9721b {
        Iterator<CloudRestoreStatusV3> it = this.f46184i.m76944h().iterator();
        boolean z10 = false;
        while (it.hasNext() && !(!it.next().m29500t().isEmpty())) {
        }
        if (z10) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", " notify restore launcher start.");
            QueryAppRestoreFromProvider.notifyRestoreLauncherStart(this.f46176a);
        }
    }

    /* renamed from: p0 */
    public final void m57816p0() {
        try {
            CloudBackupStatus cloudBackupStatusM76929h = new C12815f().m76929h(this.appId, this.f46182g.getUid());
            if (cloudBackupStatusM76929h != null) {
                String strM29373R0 = cloudBackupStatusM76929h.m29373R0();
                if (strM29373R0.isEmpty()) {
                    return;
                }
                C11060c c11060cM66626a = C11058a.m66626a(this.f46177b.m29783R(), "moduleSkipFile", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("010_1013");
                String str = "appId = " + this.appId + ", appName = " + this.f46182g.getAppName() + ", module skip file num = " + strM29373R0;
                C11839m.m70688i("CloudRestoreV3ModulePrepare", "report skip info: " + str);
                c11060cM66626a.m66635A(str);
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3ModulePrepare", "query backup status error: " + e10.toString());
        }
    }

    public void pause() {
        this.f46180e = true;
        this.abort = true;
        Optional.ofNullable(this.f46199x).ifPresent(new Consumer() { // from class: dm.e2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((C9252r1) obj).pause();
            }
        });
    }

    /* renamed from: q0 */
    public final void m57817q0(CloudRestoreStatusV3 cloudRestoreStatusV3) throws InterruptedException, C9721b {
        if (cloudRestoreStatusV3.getUid() != 0) {
            return;
        }
        String str = this.f46189n + "/restoreicon";
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e("CloudRestoreV3ModulePrepare", "3rd icon mkdirs failed.");
            return;
        }
        C12810a c12810aM76879d = this.f46185j.m76879d(cloudRestoreStatusV3.getAppId(), "icon");
        if (c12810aM76879d == null) {
            C11839m.m70689w("CloudRestoreV3ModulePrepare", "restore3rdIcon no icon " + this.appId);
            return;
        }
        final String str2 = str + "/" + cloudRestoreStatusV3.getAppId() + ".icon";
        C11839m.m70686d("CloudRestoreV3ModulePrepare", "download 3rd app icons start, appId = " + cloudRestoreStatusV3.getAppId() + " uid = " + cloudRestoreStatusV3.getUid() + ", flag = " + c12810aM76879d.m76858i());
        try {
            if (c12810aM76879d.m76858i() == 0) {
                String strM76851b = c12810aM76879d.m76851b();
                final String str3 = this.f46191p + this.appId + "/" + strM76851b.substring(strM76851b.lastIndexOf("/") + 1);
                C10546a.m64704a(new C10546a.a() { // from class: dm.y1
                    @Override // im.C10546a.a
                    /* renamed from: a */
                    public final InterfaceC10551c0 mo1696a() {
                        return this.f46576a.m57813j0(str2, str3);
                    }
                }).m64705b();
            } else {
                final String strM76851b2 = c12810aM76879d.m76851b();
                final String strM29503v = cloudRestoreStatusV3.m29503v();
                final String strM76865p = c12810aM76879d.m76865p();
                C10546a.m64704a(new C10546a.a() { // from class: dm.z1
                    @Override // im.C10546a.a
                    /* renamed from: a */
                    public final InterfaceC10551c0 mo1696a() {
                        return this.f46602a.m57814m0(str2, strM29503v, strM76851b2, strM76865p);
                    }
                }).m64705b();
            }
            this.f46184i.m76953q(cloudRestoreStatusV3.getAppId(), str2);
            C11839m.m70686d("CloudRestoreV3ModulePrepare", "download 3rd app icons end, appId = " + cloudRestoreStatusV3.getAppId() + " ,uid: " + cloudRestoreStatusV3.getUid());
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreV3ModulePrepare", "download 3rd app icons err, appId = " + cloudRestoreStatusV3.getAppId() + " " + e10.getMessage() + " ,uid: " + cloudRestoreStatusV3.getUid());
            int iM60659c = e10.m60659c();
            if (iM60659c != 1002) {
                switch (iM60659c) {
                    case 1104:
                    case 1105:
                    case 1106:
                    case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                        break;
                    default:
                        m57805T();
                        return;
                }
            }
            throw e10;
        }
    }

    public final void restore3rdIconsBeforeLauncher() throws InterruptedException, C9721b {
        if (m57806U()) {
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "download 3rd app icons start.");
            List<CloudRestoreStatusV3> listM76944h = this.f46184i.m76944h();
            for (CloudRestoreStatusV3 cloudRestoreStatusV3 : listM76944h) {
                m57805T();
                if (cloudRestoreStatusV3 == null) {
                    C11839m.m70689w("CloudRestoreV3ModulePrepare", "restore3rdIconsBeforeLauncher cloudRestoreStatus is null.");
                } else {
                    String appId = cloudRestoreStatusV3.getAppId();
                    int status = cloudRestoreStatusV3.getStatus();
                    if (status != -8 && status != -1) {
                        if (status == 8) {
                            C11839m.m70688i("CloudRestoreV3ModulePrepare", "download 3rd app icon done, localAppId = " + appId + " ,uid: " + this.f46182g.getUid());
                        } else if (status != -6 && status != -5 && status != -4 && status != -3) {
                            if (cloudRestoreStatusV3.m29484T()) {
                                m57817q0(cloudRestoreStatusV3);
                            } else {
                                C11839m.m70688i("CloudRestoreV3ModulePrepare", "download 3rd app icon version lower, localAppId = " + appId + " ,uid: " + this.f46182g.getUid());
                                if (!isAPPExist()) {
                                    m57817q0(cloudRestoreStatusV3);
                                }
                            }
                        }
                    }
                    C11839m.m70688i("CloudRestoreV3ModulePrepare", "download 3rd app icon, skip localAppId = " + appId + " ,uid: " + this.f46182g.getUid());
                }
            }
            listM76944h.clear();
            m57805T();
            m57815n0();
            C11839m.m70688i("CloudRestoreV3ModulePrepare", "download 3rd app icons end.");
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        C10574x c10574x = this.f46187l;
        if (c10574x != null) {
            c10574x.mo64711f();
        }
        C10547a0 c10547a0 = this.f46188m;
        if (c10547a0 != null) {
            c10547a0.mo64711f();
        }
        if (!this.isRunning) {
            C12187n.m73309f(this.f46177b, this.f46182g);
        }
        C9252r1 c9252r1 = this.f46199x;
        if (c9252r1 != null) {
            c9252r1.cancel(z10);
        } else {
            super.cancel(z10);
        }
    }
}
