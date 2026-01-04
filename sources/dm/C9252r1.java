package dm;

import al.AbstractC0242a;
import al.AbstractC0243b;
import al.C0248g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import bm.InterfaceC1261b;
import cl.InterfaceC1446a;
import cl.InterfaceC1447b;
import cl.InterfaceC1454i;
import cm.C1460f;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.FileCategoryUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import fk.C9721b;
import gm.C9992e0;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import im.AbstractC10571u;
import im.C10546a;
import im.C10547a0;
import im.C10574x;
import im.InterfaceC10551c0;
import im.InterfaceC10562l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import je.C10782d;
import mk.C11476b;
import mm.AbstractC11494p;
import mm.C11491m;
import mm.InterfaceC11495q;
import p015ak.C0213f;
import p015ak.C0221j;
import p292fn.C9733f;
import p336he.C10153d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12538b;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12593t0;
import p709vj.C13452e;
import p746wn.C13622a;
import p814yl.C13998b0;
import pl.C12161c;
import pl.C12164f;
import pm.C12188o;
import sl.C12810a;
import sl.C12811b;
import sl.C12816g;

/* renamed from: dm.r1 */
/* loaded from: classes6.dex */
public class C9252r1 extends CloudBackupModuleTask {

    /* renamed from: R */
    public static final Pattern f46416R = Pattern.compile("[a-zA-Z0-9_\\-]{1,200}");

    /* renamed from: S */
    public static final Object f46417S = new Object();

    /* renamed from: A */
    public C10547a0 f46418A;

    /* renamed from: B */
    public String f46419B;

    /* renamed from: C */
    public boolean f46420C;

    /* renamed from: D */
    public boolean f46421D;

    /* renamed from: E */
    public C9721b f46422E;

    /* renamed from: F */
    public C9721b f46423F;

    /* renamed from: G */
    public boolean f46424G;

    /* renamed from: H */
    public boolean f46425H;

    /* renamed from: I */
    public Consumer<C9721b> f46426I;

    /* renamed from: J */
    public Consumer<Boolean> f46427J;

    /* renamed from: K */
    public Consumer<RestoreModuleReportInfo> f46428K;

    /* renamed from: L */
    public RestoreModuleReportInfo f46429L;

    /* renamed from: M */
    public Map<String, String> f46430M;

    /* renamed from: N */
    public final int f46431N;

    /* renamed from: O */
    public boolean f46432O;

    /* renamed from: P */
    public final InterfaceC1454i f46433P;

    /* renamed from: Q */
    public final InterfaceC1447b f46434Q;

    /* renamed from: a */
    public C12816g f46435a;

    /* renamed from: b */
    public C12811b f46436b;

    /* renamed from: c */
    public C12164f f46437c;

    /* renamed from: d */
    public CloudRestoreStatusV3 f46438d;

    /* renamed from: e */
    public C9992e0 f46439e;

    /* renamed from: f */
    public C4880b f46440f;

    /* renamed from: g */
    public boolean f46441g;

    /* renamed from: h */
    public boolean f46442h;

    /* renamed from: i */
    public boolean f46443i;

    /* renamed from: j */
    public boolean f46444j;

    /* renamed from: k */
    public boolean f46445k;

    /* renamed from: l */
    public String f46446l;

    /* renamed from: m */
    public int f46447m;

    /* renamed from: n */
    public int f46448n;

    /* renamed from: o */
    public int f46449o;

    /* renamed from: p */
    public long f46450p;

    /* renamed from: q */
    public int f46451q;

    /* renamed from: r */
    public String f46452r;

    /* renamed from: s */
    public Context f46453s;

    /* renamed from: t */
    public Set<String> f46454t;

    /* renamed from: u */
    public List<String> f46455u;

    /* renamed from: v */
    public Map<String, Integer> f46456v;

    /* renamed from: w */
    public C1460f f46457w;

    /* renamed from: x */
    public int f46458x;

    /* renamed from: y */
    public int f46459y;

    /* renamed from: z */
    public C10574x f46460z;

    /* renamed from: dm.r1$a */
    public class a extends AbstractC0243b {
        public a() {
        }

        @Override // al.AbstractC0243b
        public String getAppId() {
            return C9252r1.this.f46438d.m29470M();
        }

        @Override // al.AbstractC0243b
        public RestoreModuleReportInfo getReportInfo() {
            return C9252r1.this.f46429L;
        }

        @Override // al.AbstractC0243b
        public long getVersionCode() {
            return C9252r1.this.f46438d.getVersionCode();
        }

        @Override // al.AbstractC0243b, cl.InterfaceC1454i
        public void isAbort() throws InterruptedException, C9721b {
            C9252r1.this.m58147A0();
        }

        @Override // al.AbstractC0243b, cl.InterfaceC1454i
        public boolean isPause() {
            return C9252r1.this.f46443i;
        }
    }

    /* renamed from: dm.r1$b */
    public class b extends AbstractC0242a {

        /* renamed from: a */
        public int f46462a = 0;

        public b() {
        }

        @Override // al.AbstractC0242a
        public RestoreModuleReportInfo getReportInfo() {
            return C9252r1.this.f46429L;
        }

        @Override // al.AbstractC0242a
        public String getTAG() {
            return "CloudRestoreV3ModuleDownload";
        }

        @Override // al.AbstractC0242a
        public void notifyLauncher(int i10) {
            if (C9252r1.this.f46438d.isTwinApp() || !C9252r1.this.f46439e.f48901s.contains(C9252r1.this.f46438d.m29470M())) {
                return;
            }
            ICBBroadcastManager.sendInstallEventBroadcast(C9252r1.this.getContext(), C9252r1.this.f46438d.m29470M(), i10);
        }

        @Override // al.AbstractC0242a
        public void onDownloadFinish() {
            C9252r1.this.f46436b.m76881f(((CloudBackupModuleTask) C9252r1.this).appId, "apk", 2, C9252r1.this.f46438d.getUid());
            C9252r1.this.f46435a.m76958v(C9252r1.this.f46438d, 5, 1);
            C9252r1.this.f46420C = true;
            C9252r1.this.sendDownloadStatus(4);
            if (C9252r1.this.f46438d.is3rdAppType()) {
                C9252r1.this.f46438d.setCurrent(100);
            }
            RestoreProgress.updateStatus(C9252r1.this.f46438d);
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore3rd app success, appId = " + ((CloudBackupModuleTask) C9252r1.this).appId + " ,uid: " + C9252r1.this.f46438d.getUid());
        }

        @Override // al.AbstractC0242a
        public void onInstallFail() {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore3rd INSTALL_FAILED  app success, appId = " + ((CloudBackupModuleTask) C9252r1.this).appId);
            C9252r1.this.f46435a.m76958v(C9252r1.this.f46438d, 6, 2);
            RestoreProgress.updateStatus(C9252r1.this.f46438d);
        }

        @Override // al.AbstractC0242a
        public void onInstallSuccess() {
            C9252r1.this.f46438d.setDoneStatusAndType(1, C9252r1.this.f46438d.getType());
            C9252r1.this.f46435a.m76958v(C9252r1.this.f46438d, 6, 1);
            RestoreProgress.updateStatus(C9252r1.this.f46438d);
            C9252r1.this.f46425H = true;
            C9252r1.this.f46420C = true;
        }

        @Override // al.AbstractC0242a
        public void onInstalling() {
            if (C9252r1.this.f46438d.isTwinApp() || !C9252r1.this.f46439e.f48901s.contains(((CloudBackupModuleTask) C9252r1.this).appId)) {
                return;
            }
            C9252r1.this.f46438d.setStatus(6).setType(0);
            RestoreProgress.updateStatus(C9252r1.this.f46438d);
        }

        @Override // al.AbstractC0242a
        public void update3rdProgress(int i10, boolean z10, boolean z11) {
            long asize = C9252r1.this.f46438d.getAsize();
            int i11 = this.f46462a;
            long j10 = i10 - i11 > 0 ? asize * (i10 - i11) : 0L;
            this.f46462a = Math.max(i11, i10);
            C9252r1.this.f46438d.addBytesDownloaded(true, j10 / 100);
            RestoreProgress.updateStatus(C9252r1.this.f46438d);
            C9252r1.this.update3rdProgress(i10, z10, z11);
        }
    }

    /* renamed from: dm.r1$c */
    public class c implements InterfaceC10562l {

        /* renamed from: a */
        public long f46464a = 0;

        /* renamed from: b */
        public final /* synthetic */ boolean f46465b;

        public c(boolean z10) {
            this.f46465b = z10;
        }

        @Override // im.InterfaceC10562l
        /* renamed from: a */
        public void mo57819a(AbstractC10571u abstractC10571u) {
            m58170b(abstractC10571u);
        }

        /* renamed from: b */
        public final void m58170b(AbstractC10571u abstractC10571u) {
            long jM64862U = abstractC10571u.m64862U();
            long jM64864W = abstractC10571u.m64864W();
            if (jM64864W == 0 || jM64862U > jM64864W || ((CloudBackupBaseTask) C9252r1.this).abort) {
                return;
            }
            long size = C9252r1.this.f46438d.getSize();
            long asize = C9252r1.this.f46438d.getAsize();
            long j10 = size + asize;
            long j11 = jM64862U - this.f46464a;
            if (j11 < 0) {
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "send Progress, the increase is invalid. increase is:" + j11);
                return;
            }
            C9252r1.m58124Y(C9252r1.this, j11);
            C11839m.m70686d("CloudRestoreV3ModuleDownload", "send Progress, value: " + jM64862U + " | size: " + size + "asize: " + asize + " | alreadyDownloadSize: " + C9252r1.this.f46450p + " has3rdFiles:" + C9252r1.this.f46445k + " download3rdApp:" + this.f46465b + " totalLength:" + jM64864W);
            if (C9252r1.this.f46450p <= j10) {
                RestoreProgressManager.getInstance().addBytesDownloaded(j11);
            } else {
                j11 -= C9252r1.this.f46450p - j10;
                C9252r1.this.f46450p = j10;
            }
            C9252r1.this.f46438d.addBytesDownloaded(this.f46465b, j11);
            boolean zIs3rdAppType = C9252r1.this.f46438d.is3rdAppType();
            if (zIs3rdAppType || C9252r1.this.f46438d.m29486U()) {
                synchronized (C9252r1.f46417S) {
                    try {
                        this.f46464a = jM64862U;
                        if (C9252r1.this.f46445k) {
                            int iFloor = (int) Math.floor((C9252r1.this.f46450p / j10) * 100.0d);
                            C9252r1 c9252r1 = C9252r1.this;
                            c9252r1.update3rdProgress(iFloor, c9252r1.f46450p >= j10, zIs3rdAppType);
                        } else {
                            boolean z10 = jM64862U == jM64864W;
                            if (this.f46465b) {
                                C9252r1.this.update3rdProgress(Math.min((int) Math.floor((C9252r1.this.f46450p / jM64864W) * 100.0d), 100), z10, zIs3rdAppType);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    /* renamed from: dm.r1$d */
    public class d implements InterfaceC1261b {

        /* renamed from: a */
        public long f46467a = 0;

        public d() {
        }

        @Override // bm.InterfaceC1261b
        /* renamed from: a */
        public void mo7514a(C9721b c9721b) {
            synchronized (C9252r1.f46417S) {
                try {
                    C9252r1.m58135n0(C9252r1.this);
                    if (m58172f(c9721b)) {
                        C9252r1.this.m58159M0(c9721b);
                    } else {
                        C9252r1.this.m58158L0(c9721b);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // bm.InterfaceC1261b
        /* renamed from: b */
        public void mo7515b(String str, C12161c c12161c) {
            synchronized (C9252r1.f46417S) {
                m58175i(str, c12161c, true);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
        @Override // bm.InterfaceC1261b
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo7516c(java.lang.String r4, long r5, pl.C12161c r7, boolean r8) {
            /*
                r3 = this;
                java.lang.Object r5 = dm.C9252r1.m58106G()
                monitor-enter(r5)
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3 r6 = dm.C9252r1.m58138r(r6)     // Catch: java.lang.Throwable -> L1e
                boolean r6 = r6.m29486U()     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L21
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L1e
                r6.<init>()     // Catch: java.lang.Throwable -> L1e
                r6.add(r4)     // Catch: java.lang.Throwable -> L1e
                r3.m58177k(r6)     // Catch: java.lang.Throwable -> L1e
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                return
            L1e:
                r3 = move-exception
                goto Lc9
            L21:
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                dm.C9252r1.m58135n0(r6)     // Catch: java.lang.Throwable -> L1e
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                java.lang.String r6 = dm.C9252r1.m58136p0(r6)     // Catch: java.lang.Throwable -> L1e
                int r0 = r6.hashCode()     // Catch: java.lang.Throwable -> L1e
                r1 = -196315310(0xfffffffff44c7752, float:-6.479789E31)
                r2 = 1
                if (r0 == r1) goto L46
                r1 = 104263205(0x636ee25, float:3.4405356E-35)
                if (r0 == r1) goto L3c
                goto L50
            L3c:
                java.lang.String r0 = "music"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L50
                r6 = 0
                goto L51
            L46:
                java.lang.String r0 = "gallery"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L50
                r6 = r2
                goto L51
            L50:
                r6 = -1
            L51:
                if (r6 == 0) goto L81
                if (r6 == r2) goto L62
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                int r0 = dm.C9252r1.m58141t(r6)     // Catch: java.lang.Throwable -> L1e
                dm.C9252r1.m58144v(r6, r0)     // Catch: java.lang.Throwable -> L1e
                r3.m58175i(r4, r7, r8)     // Catch: java.lang.Throwable -> L1e
                goto Lc7
            L62:
                java.lang.String r6 = "gallery.db"
                boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L74
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                int r7 = dm.C9252r1.m58139s(r6)     // Catch: java.lang.Throwable -> L1e
                dm.C9252r1.m58144v(r6, r7)     // Catch: java.lang.Throwable -> L1e
                goto L7d
            L74:
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                int r7 = dm.C9252r1.m58141t(r6)     // Catch: java.lang.Throwable -> L1e
                dm.C9252r1.m58144v(r6, r7)     // Catch: java.lang.Throwable -> L1e
            L7d:
                r3.m58171e(r4)     // Catch: java.lang.Throwable -> L1e
                goto Lc7
            L81:
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                int r7 = dm.C9252r1.m58141t(r6)     // Catch: java.lang.Throwable -> L1e
                dm.C9252r1.m58144v(r6, r7)     // Catch: java.lang.Throwable -> L1e
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r6 = dm.C9252r1.m58145y(r6)     // Catch: java.lang.Throwable -> L1e
                r6.add(r4)     // Catch: java.lang.Throwable -> L1e
                dm.r1 r4 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                int r4 = dm.C9252r1.m58132j0(r4)     // Catch: java.lang.Throwable -> L1e
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                int r6 = dm.C9252r1.m58146z(r6)     // Catch: java.lang.Throwable -> L1e
                if (r4 == r6) goto Laf
                dm.r1 r4 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r4 = dm.C9252r1.m58145y(r4)     // Catch: java.lang.Throwable -> L1e
                int r4 = r4.size()     // Catch: java.lang.Throwable -> L1e
                r6 = 10
                if (r4 < r6) goto Lc7
            Laf:
                dm.r1 r4 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r4 = dm.C9252r1.m58145y(r4)     // Catch: java.lang.Throwable -> L1e
                dm.r1 r6 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                android.content.Context r6 = dm.C9252r1.m58100A(r6)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.scanFileList(r4, r6)     // Catch: java.lang.Throwable -> L1e
                dm.r1 r3 = dm.C9252r1.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r3 = dm.C9252r1.m58145y(r3)     // Catch: java.lang.Throwable -> L1e
                r3.clear()     // Catch: java.lang.Throwable -> L1e
            Lc7:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                return
            Lc9:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: dm.C9252r1.d.mo7516c(java.lang.String, long, pl.c, boolean):void");
        }

        @Override // bm.InterfaceC1261b
        /* renamed from: d */
        public void mo7517d(List<String> list) {
            synchronized (C9252r1.f46417S) {
                m58177k(list);
            }
        }

        /* renamed from: e */
        public final void m58171e(String str) throws IOException {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "start checkOutsideAlbums");
            if (C9252r1.this.f46456v.isEmpty()) {
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "checkOutsideAlbums exit, no need to check.");
                return;
            }
            String strM1512v = C0221j.m1512v();
            String parent = C10278a.m63442h(str).getParent();
            for (Map.Entry entry : C9252r1.this.f46456v.entrySet()) {
                int iIntValue = ((Integer) entry.getValue()).intValue();
                if (str.contains((CharSequence) entry.getKey())) {
                    if (iIntValue == 1) {
                        m58174h(parent);
                        return;
                    }
                    boolean zContains = str.contains(strM1512v);
                    if (zContains && iIntValue == 3) {
                        m58174h(parent);
                        return;
                    } else if (!zContains && iIntValue == 2) {
                        m58174h(parent);
                        return;
                    }
                }
            }
        }

        /* renamed from: f */
        public final boolean m58172f(C9721b c9721b) {
            int iM60659c = c9721b.m60659c();
            C11839m.m70686d("CloudRestoreV3ModuleDownload", "onRestoreFailed code " + iM60659c + ", appId  " + ((CloudBackupModuleTask) C9252r1.this).appId + C9252r1.this.f46438d.getStatus() + " ,uid: " + C9252r1.this.f46438d.getUid());
            if (iM60659c == 1002 || iM60659c == 1007 || iM60659c == 1102 || iM60659c == 4008) {
                return true;
            }
            switch (iM60659c) {
                case 1104:
                case 1105:
                case 1106:
                case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                    return true;
                default:
                    return m58173g(true);
            }
        }

        /* renamed from: g */
        public final boolean m58173g(boolean z10) {
            String str = ((CloudBackupModuleTask) C9252r1.this).appId;
            str.hashCode();
            if (str.equals(HNConstants.DataType.MEDIA) || str.equals("music")) {
                return false;
            }
            return z10;
        }

        /* renamed from: h */
        public final void m58174h(String str) throws IOException {
            C11839m.m70686d("CloudRestoreV3ModuleDownload", "outsideFileCreate path = " + str);
            File fileM63442h = C10278a.m63442h(str);
            File fileM63442h2 = C10278a.m63442h(str + File.separator + Albums.OUTSIDE_FILE_NAME);
            if (!fileM63442h.exists() && fileM63442h.mkdirs()) {
                C11839m.m70689w("CloudRestoreV3ModuleDownload", "create .outside dir file success");
            }
            if (fileM63442h2.exists()) {
                return;
            }
            try {
                boolean zCreateNewFile = fileM63442h2.createNewFile();
                C11839m.m70689w("CloudRestoreV3ModuleDownload", "create .outside file result  = " + zCreateNewFile);
                if (zCreateNewFile) {
                    RestoreUtil.scanFolder(C10279b.m63452a(fileM63442h2), C9252r1.this.getContext());
                }
            } catch (IOException unused) {
                C11839m.m70687e("CloudRestoreV3ModuleDownload", "create .outside file failed");
            }
        }

        /* renamed from: i */
        public final void m58175i(String str, C12161c c12161c, boolean z10) {
            if (C9252r1.this.f46438d == null || c12161c == null) {
                C11839m.m70689w("CloudRestoreV3ModuleDownload", "scan3rdFileMedia restoreStatus == null || restoreMeta == null");
                return;
            }
            if (!C9252r1.this.f46432O && C9252r1.this.f46438d.is3rdAppType() && C9252r1.this.f46445k) {
                if (!z10) {
                    C11839m.m70686d("CloudRestoreV3ModuleDownload", "scan3rdFileMedia file not real download: " + str);
                    return;
                }
                if (TextUtils.equals(c12161c.m72950F(), ICBUtil.RELATIVE_SDATA_PATH + File.separator)) {
                    return;
                }
                if (c12161c.m72991l() == null || str == null) {
                    C11839m.m70689w("CloudRestoreV3ModuleDownload", "scan3rdFileMedia restoreMeta.getData() == null || path == null");
                    return;
                }
                File fileM63442h = C10278a.m63442h(str);
                if (!fileM63442h.exists()) {
                    C11839m.m70689w("CloudRestoreV3ModuleDownload", "scan3rdFileMedia file not exist : " + str);
                    return;
                }
                if (c12161c.m73006u() > 0) {
                    fileM63442h.setLastModified(c12161c.m73006u());
                }
                if (c12161c.m72991l().startsWith("Android/data/")) {
                    return;
                }
                int fileCategory = FileCategoryUtil.getFileCategory(C12538b.m75479b(fileM63442h).m73355a());
                if (fileCategory == 4 || fileCategory == 1) {
                    C9252r1.this.f46455u.add(str);
                    m58176j(C9252r1.this.f46455u);
                }
            }
        }

        /* renamed from: j */
        public final void m58176j(List<String> list) {
            C9252r1.this.f46449o += list.size();
            C9252r1.this.f46455u.addAll(list);
            if (C9252r1.this.f46449o >= C9252r1.this.f46448n || C9252r1.this.f46455u.size() >= 10) {
                RestoreUtil.scanFileList(C9252r1.this.f46455u, C9252r1.this.getContext());
                C9252r1.this.f46455u.clear();
            }
        }

        /* renamed from: k */
        public final void m58177k(List<String> list) {
            if (C9252r1.this.f46438d.isShowRestoreProgressTotal()) {
                m58176j(list);
                int iMin = Math.min(C9252r1.m58143u(C9252r1.this, list.size()), C9252r1.this.f46447m);
                C9252r1.this.f46438d.setCount(C9252r1.this.f46447m);
                C9252r1.this.f46438d.setCurrent(iMin);
                RestoreProgress.updateStatus(C9252r1.this.f46438d);
                C9252r1.this.f46435a.m76954r(C9252r1.this.f46438d);
            }
        }

        /* renamed from: l */
        public final void m58178l(boolean z10, long j10, boolean z11) {
            if (!C9252r1.this.f46445k || z11) {
                return;
            }
            int iFloor = (int) Math.floor((C9252r1.this.f46450p / j10) * 100.0d);
            C9252r1 c9252r1 = C9252r1.this;
            c9252r1.update3rdProgress(iFloor, c9252r1.f46450p >= j10, z10);
        }

        @Override // bm.InterfaceC1261b
        public void onProgress(long j10, long j11) {
            if (j11 == 0 || j10 > j11 || ((CloudBackupBaseTask) C9252r1.this).abort) {
                return;
            }
            boolean zIs3rdAppType = C9252r1.this.f46438d.is3rdAppType();
            synchronized (C9252r1.f46417S) {
                try {
                    if (C9252r1.this.isAbort()) {
                        C11839m.m70688i("CloudRestoreV3ModuleDownload", "onProgress abort appId" + ((CloudBackupModuleTask) C9252r1.this).appId + "abort " + ((CloudBackupBaseTask) C9252r1.this).abort + " ,uid: " + C9252r1.this.f46438d.getUid());
                        return;
                    }
                    long j12 = j10 - this.f46467a;
                    if (j12 < 0) {
                        C11839m.m70688i("CloudRestoreV3ModuleDownload", "onProgress, the increase is invalid. increase is:" + j12);
                        return;
                    }
                    C9252r1.m58124Y(C9252r1.this, j12);
                    long size = C9252r1.this.f46438d.getSize();
                    long asize = C9252r1.this.f46438d.getAsize();
                    long j13 = size + asize;
                    if (C9252r1.this.f46450p <= j13) {
                        RestoreProgressManager.getInstance().addBytesDownloaded(j12);
                    } else {
                        j12 -= C9252r1.this.f46450p - j13;
                        C9252r1.this.f46450p = j13;
                    }
                    C9252r1.this.f46438d.addBytesDownloaded(false, j12);
                    RestoreProgress.updateStatus(C9252r1.this.f46438d);
                    this.f46467a = j10;
                    boolean zIsShowRestoreProgressTotal = C9252r1.this.f46438d.isShowRestoreProgressTotal();
                    C11839m.m70686d("CloudRestoreV3ModuleDownload", "onProgress, value: " + j10 + " | size: " + size + "apkSize: " + asize + " | alreadyDownloadSize: " + C9252r1.this.f46450p + " has3rdFiles:" + C9252r1.this.f46445k + " showRestoreProgressTotal:" + zIsShowRestoreProgressTotal + " increase:" + j12 + " total:" + j11);
                    m58178l(zIs3rdAppType, j13, zIsShowRestoreProgressTotal);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public C9252r1(C4880b c4880b, C9992e0 c9992e0, CloudRestoreStatusV3 cloudRestoreStatusV3, Set<String> set, boolean z10, String str) {
        super(cloudRestoreStatusV3.getAppId());
        this.f46435a = new C12816g();
        this.f46436b = new C12811b();
        this.f46441g = false;
        this.f46442h = false;
        this.f46443i = false;
        this.f46447m = 0;
        this.f46448n = 0;
        this.f46449o = 0;
        this.f46450p = 0L;
        this.f46451q = 0;
        this.f46455u = new ArrayList();
        this.f46456v = new HashMap();
        this.f46420C = false;
        this.f46422E = null;
        this.f46423F = null;
        this.f46424G = false;
        this.f46425H = false;
        this.f46432O = false;
        this.f46433P = new a();
        this.f46434Q = new b();
        this.f46440f = c4880b;
        this.f46457w = c4880b.m29776K();
        this.f46439e = c9992e0;
        this.f46438d = cloudRestoreStatusV3;
        this.f46444j = z10;
        this.f46446l = str;
        this.f46453s = C0213f.m1377a();
        this.f46452r = c9992e0.m61983n();
        this.f46454t = set;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isEncrypt() ? "" : "/Backup");
        sb2.append("/CloudBackup/");
        sb2.append(C11476b.m68626h(c4880b.m29773H()));
        sb2.append("/");
        this.f46419B = sb2.toString();
        this.f46430M = C12593t0.m75974g(cloudRestoreStatusV3);
        this.f46431N = C9733f.m60705z().m60763v("businessJumpGarbleFileId");
    }

    /* renamed from: Y */
    public static /* synthetic */ long m58124Y(C9252r1 c9252r1, long j10) {
        long j11 = c9252r1.f46450p + j10;
        c9252r1.f46450p = j11;
        return j11;
    }

    private boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private boolean isStringNull(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: n0 */
    public static /* synthetic */ int m58135n0(C9252r1 c9252r1) {
        int i10 = c9252r1.f46449o;
        c9252r1.f46449o = i10 + 1;
        return i10;
    }

    /* renamed from: s0 */
    public static boolean m58140s0(CountDownLatch countDownLatch, C12161c c12161c) {
        long jM72953I = c12161c.m72953I();
        boolean z10 = jM72953I == 7;
        boolean z11 = jM72953I == 6;
        boolean z12 = c12161c.m73010y() == 1;
        if (!z10 || z12) {
            if ((z10 || z11) && z12 && !C10153d.m63245i(c12161c.m73009x())) {
                countDownLatch.countDown();
                C11839m.m70689w("CloudRestoreV3ModuleDownload", "restoreMetas FileId invalid: " + c12161c.m73009x());
                return true;
            }
        } else if (!C10153d.m63246j(c12161c.m72984h())) {
            countDownLatch.countDown();
            C11839m.m70689w("CloudRestoreV3ModuleDownload", "restoreMetas tar cloudpath invalid: " + c12161c.m72984h());
            return true;
        }
        return false;
    }

    /* renamed from: t */
    public static /* synthetic */ int m58141t(C9252r1 c9252r1) {
        int i10 = c9252r1.f46451q + 1;
        c9252r1.f46451q = i10;
        return i10;
    }

    /* renamed from: t0 */
    private String m58142t0(C12161c c12161c) throws C9721b {
        return C12590s0.m75758J(c12161c, this.f46438d, "V4".equals(this.f46440f.f22517K), this.f46440f.getLocation() + File.separator + this.appId);
    }

    /* renamed from: u */
    public static /* synthetic */ int m58143u(C9252r1 c9252r1, int i10) {
        int i11 = c9252r1.f46451q + i10;
        c9252r1.f46451q = i11;
        return i11;
    }

    /* renamed from: A0 */
    public void m58147A0() throws InterruptedException, C9721b {
        this.f46440f.isCancel();
        if (!C10782d.m65634a().m65642i(getContext())) {
            condition();
            throw new C9721b(1002, "net disable.", "isCancel");
        }
        C9721b c9721b = this.f46422E;
        if (c9721b != null) {
            throw c9721b;
        }
        if (this.abort) {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "process abort.");
            throw new C9721b(1999, "process abort", "isCancel");
        }
    }

    /* renamed from: B0 */
    public final boolean m58148B0() {
        return this.f46438d.getStatus() == 4 && this.f46438d.getType() == 1;
    }

    /* renamed from: C0 */
    public final /* synthetic */ InterfaceC10551c0 m58149C0(String str, String str2, String str3, String str4) throws InterruptedException, C9721b {
        m58147A0();
        C10574x c10574x = new C10574x(this.f46440f.getBackupId(), this.f46440f.m29783R(), this.f46457w, str, "apk", str2, str3, str4);
        this.f46460z = c10574x;
        c10574x.m64876j0(this.f46440f.m29772G());
        this.f46460z.m64875i0(m58153G0(true));
        return this.f46460z;
    }

    /* renamed from: D0 */
    public final /* synthetic */ InterfaceC10551c0 m58150D0(String str, String str2) throws InterruptedException, C9721b {
        m58147A0();
        C10547a0 c10547a0 = new C10547a0(this.f46440f.getBackupId(), this.f46440f.m29783R(), this.f46457w, str, str2, 2);
        this.f46418A = c10547a0;
        c10547a0.m64876j0(this.f46440f.m29772G());
        this.f46418A.m64875i0(m58153G0(true));
        return this.f46418A;
    }

    /* renamed from: E0 */
    public final void m58151E0(String str, String str2, String str3, int i10, String str4) {
        try {
            String strM29783R = this.f46440f.m29783R();
            File fileM63442h = C10278a.m63442h(str);
            if (fileM63442h.exists()) {
                String hash = C11476b.m68622d(fileM63442h).getHash();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("appId", this.appId);
                linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(i10));
                linkedHashMap.put(ContentResource.FILE_NAME, str3);
                linkedHashMap.put("dBDiffErrorReason", str4);
                C12590s0.m75729B2(strM29783R, hash, str2, str, linkedHashMap);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudRestoreV3ModuleDownload", "getMd5AndHash mergeDBFile exception" + e10.getMessage());
        }
    }

    /* renamed from: F0 */
    public final void m58152F0() {
        if (!this.f46455u.isEmpty()) {
            RestoreUtil.scanFileList(this.f46455u, getContext());
            this.f46455u.clear();
        }
        if (!isSuccess()) {
            if (!C10782d.m65634a().m65642i(getContext())) {
                this.f46422E = new C9721b(1104, "net disabled, appId = " + this.appId);
            }
            if (this.f46422E == null) {
                C9721b c9721b = this.f46423F;
                if (c9721b == null) {
                    c9721b = new C9721b(1999, "download module interrupted, appId =" + this.appId + " uid: " + this.f46438d.getUid());
                }
                this.f46422E = c9721b;
            }
            if (!this.abort) {
                dealError(this.f46422E.m60659c(), this.f46422E);
            } else if (this.f46441g || isNetDisconnect(this.f46422E)) {
                this.f46435a.m76958v(this.f46438d, 0, 0);
                sendDownloadStatus(0);
            } else if (this.f46442h) {
                this.f46435a.m76958v(this.f46438d, 1, 0);
                sendDownloadStatus(3);
            } else if (this.f46443i) {
                this.f46435a.m76958v(this.f46438d, 2, 0);
                sendDownloadStatus(6);
            } else {
                C12816g c12816g = this.f46435a;
                CloudRestoreStatusV3 cloudRestoreStatusV3 = this.f46438d;
                c12816g.m76958v(cloudRestoreStatusV3, cloudRestoreStatusV3.getStatus(), 2);
                this.f46440f.setException(this.f46422E);
            }
            this.f46440f.checkException(this.f46422E);
        }
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore one module end, appId = " + this.appId + " uid: " + this.f46438d.getUid());
    }

    /* renamed from: G0 */
    public final InterfaceC10562l m58153G0(boolean z10) {
        return new c(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023b  */
    /* renamed from: H0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m58154H0(mm.AbstractC11494p<?> r28, int r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9252r1.m58154H0(mm.p, int):void");
    }

    /* renamed from: I0 */
    public final void m58155I0(boolean z10) throws C9721b {
        int[] iArr = {6, 7, 8, 9};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            if (z10) {
                long[] jArrM73046L = this.f46437c.m73046L(i11);
                int i12 = (int) jArrM73046L[0];
                long j10 = jArrM73046L[1];
                if (i12 > 0) {
                    this.f46450p += j10;
                    RestoreProgressManager.getInstance().addBytesDownloaded(j10);
                    this.f46438d.addBytesDownloaded(false, j10);
                    int i13 = this.f46451q + i12;
                    this.f46451q = i13;
                    updateCurrent(i13);
                }
                RestoreProgress.updateStatus(this.f46438d);
            }
        }
        new C11491m(this.appId, this.f46437c).execute(new InterfaceC11495q() { // from class: dm.p1
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i14) throws Throwable {
                this.f46381a.m58154H0(abstractC11494p, i14);
            }
        });
    }

    /* renamed from: J0 */
    public void m58156J0(File file, List<String[]> list, String str) throws InterruptedException, C9721b {
        if (!file.exists()) {
            C11839m.m70689w("CloudRestoreV3ModuleDownload", "file is not exists, scanFiles fail path = " + C10279b.m63452a(file));
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2 != null) {
                        m58156J0(file2, list, str);
                    }
                }
            }
        } else {
            String[] strArr = new String[3];
            String strM58169z0 = m58169z0(file);
            if (!TextUtils.isEmpty(strM58169z0)) {
                strArr[0] = String.valueOf(2);
                strArr[1] = strM58169z0;
                strArr[2] = str;
                list.add(strArr);
            }
        }
        m58160N0(list, false);
    }

    /* renamed from: K0 */
    public void m58157K0(String str, String str2) throws InterruptedException, C9721b {
        File fileM63442h = C10278a.m63442h(str);
        ArrayList arrayList = new ArrayList();
        m58156J0(fileM63442h, arrayList, str2);
        m58160N0(arrayList, true);
    }

    /* renamed from: L0 */
    public void m58158L0(C9721b c9721b) {
        synchronized (f46417S) {
            try {
                if (this.f46423F == null) {
                    this.f46423F = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: M0 */
    public void m58159M0(C9721b c9721b) {
        synchronized (f46417S) {
            try {
                if (this.f46422E == null) {
                    this.f46422E = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: N0 */
    public final void m58160N0(List<String[]> list, boolean z10) throws InterruptedException, C9721b {
        if (list.size() > 1000 || z10) {
            m58147A0();
            this.f46437c.m73075e(list);
            list.clear();
        }
    }

    public final boolean businessRestoreStandardApk(List<InterfaceC1446a> list) throws InterruptedException, C9721b {
        boolean z10 = true;
        this.f46438d.m29457B0(String.valueOf(1));
        String oriBackupAppName = !this.f46438d.isTwinApp() ? this.appId : this.f46438d.getOriBackupAppName();
        Iterator<InterfaceC1446a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (it.next().mo7489a(oriBackupAppName, this.f46434Q, this.f46433P)) {
                break;
            }
            m58147A0();
        }
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "businessRestoreStandardApk result = " + z10);
        return z10;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        Optional optionalOfNullable;
        Consumer consumer;
        if (this.f46438d == null) {
            return;
        }
        this.f46432O = C9733f.m60705z().m60720O("disableRefresh3rdMediaTimestamp");
        this.f46429L = new RestoreModuleReportInfo();
        try {
            try {
                this.f46421D = new C12526j().m75339H0();
                this.f46437c = new C12164f(this.f46440f.getBackupId(), this.appId, 1, this.f46438d.getUid());
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "v3 module download start appId = " + this.appId + " uid: " + this.f46438d.getUid());
                m58147A0();
                m58166w0();
                m58165v0();
                m58147A0();
                reportActualSize();
                m58152F0();
                Optional.ofNullable(this.f46426I).ifPresent(new Consumer() { // from class: dm.k1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f46327a.lambda$call$0((Consumer) obj);
                    }
                });
                Optional.ofNullable(this.f46427J).ifPresent(new Consumer() { // from class: dm.l1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f46332a.lambda$call$1((Consumer) obj);
                    }
                });
                optionalOfNullable = Optional.ofNullable(this.f46428K);
                consumer = new Consumer() { // from class: dm.m1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f46345a.lambda$call$2((Consumer) obj);
                    }
                };
            } catch (Exception e10) {
                if (e10 instanceof C9721b) {
                    this.f46422E = (C9721b) e10;
                } else {
                    this.f46422E = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore error. appId = " + this.appId + e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
                }
                m58152F0();
                Optional.ofNullable(this.f46426I).ifPresent(new Consumer() { // from class: dm.k1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f46327a.lambda$call$0((Consumer) obj);
                    }
                });
                Optional.ofNullable(this.f46427J).ifPresent(new Consumer() { // from class: dm.l1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f46332a.lambda$call$1((Consumer) obj);
                    }
                });
                optionalOfNullable = Optional.ofNullable(this.f46428K);
                consumer = new Consumer() { // from class: dm.m1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f46345a.lambda$call$2((Consumer) obj);
                    }
                };
            }
            optionalOfNullable.ifPresent(consumer);
        } catch (Throwable th2) {
            m58152F0();
            Optional.ofNullable(this.f46426I).ifPresent(new Consumer() { // from class: dm.k1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f46327a.lambda$call$0((Consumer) obj);
                }
            });
            Optional.ofNullable(this.f46427J).ifPresent(new Consumer() { // from class: dm.l1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f46332a.lambda$call$1((Consumer) obj);
                }
            });
            Optional.ofNullable(this.f46428K).ifPresent(new Consumer() { // from class: dm.m1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f46345a.lambda$call$2((Consumer) obj);
                }
            });
            throw th2;
        }
    }

    public void cancel() {
        this.f46442h = true;
        this.abort = true;
    }

    public void condition() {
        this.f46441g = true;
        this.abort = true;
    }

    public final void dealError(int i10, C9721b c9721b) {
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "dealError code = " + i10);
        if (i10 == 1001 || i10 == 1007) {
            C12816g c12816g = this.f46435a;
            CloudRestoreStatusV3 cloudRestoreStatusV3 = this.f46438d;
            c12816g.m76958v(cloudRestoreStatusV3, cloudRestoreStatusV3.getStatus(), 2);
            this.f46440f.setException(c9721b);
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
                    C12816g c12816g2 = this.f46435a;
                    CloudRestoreStatusV3 cloudRestoreStatusV32 = this.f46438d;
                    c12816g2.m76958v(cloudRestoreStatusV32, cloudRestoreStatusV32.getStatus(), 2);
                    break;
            }
            return;
        }
        this.f46435a.m76958v(this.f46438d, 0, 0);
        sendDownloadStatus(0);
        this.f46440f.setException(c9721b);
    }

    public final void downloadFilesMultiPrepare() throws InterruptedException, C9721b {
        initDownloadTotalSize();
        if (this.f46438d.is3rdAppType()) {
            File fileM63442h = C10278a.m63442h(ICBUtil.getLocalTarPath(this.f46452r, this.appId));
            if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create tar temp dir error");
            }
            boolean z10 = 1 == this.f46438d.m29498s() || this.f46447m > 1;
            this.f46445k = z10;
            if (z10) {
                sendDownloadStatus(2);
            }
            this.f46438d.setCurrent(0).setCount(100);
            RestoreProgress.updateStatus(this.f46438d);
        }
        if (this.f46438d.isVirtual()) {
            if (this.f46438d.isShowRestoreProgressTotal()) {
                this.f46438d.setCurrent(Math.min(this.f46451q, this.f46447m)).setCount(this.f46447m);
            } else {
                this.f46445k = true;
                this.f46438d.setCurrent(0).setCount(100);
            }
            RestoreProgress.updateStatus(this.f46438d);
        }
        updateCurrent(0);
        long jM75389f0 = new C12526j().m75389f0();
        long jM73060S = this.f46437c.m73060S();
        long jM73062U = this.f46437c.m73062U();
        C11839m.m70686d("CloudRestoreV3ModuleDownload", "downloadFilesMultiPrepare appId: " + this.appId + " ,uid: " + this.f46438d.getUid() + " ,mctCount: " + jM73060S + " ,mdtCount: " + jM73062U + " ,maxTarCount: " + jM75389f0);
        this.f46424G = jM73062U > jM75389f0 || jM73060S > jM75389f0;
    }

    public final void downloadGalleryDB() throws InterruptedException, C9721b {
        C12161c c12161cM73052O = this.f46437c.m73052O();
        if (c12161cM73052O == null) {
            C11839m.m70689w("CloudRestoreV3ModuleDownload", "downloadGalleryDB failed, dbMeta is null.");
            this.f46447m = this.f46448n;
            return;
        }
        this.f46447m = this.f46448n - 1;
        File fileM63442h = C10278a.m63442h(m58142t0(c12161cM73052O));
        if (fileM63442h.exists()) {
            Md5AndHash md5AndHashM68622d = C11476b.m68622d(fileM63442h);
            String hash = isEncrypt() ? md5AndHashM68622d.getHash() : md5AndHashM68622d.getMD5();
            String strM72946B = isEncrypt() ? c12161cM73052O.m72946B() : c12161cM73052O.m72945A();
            if (isStringNull(hash) || !hash.equals(strM72946B)) {
                C11839m.m70686d("CloudRestoreV3ModuleDownload", "downloadGalleryDB file.delete" + fileM63442h.delete());
                m58147A0();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                CloudBackupTaskManager.getInstance().addFileTask(this.appId, new C9216i1(this.f46440f, this.f46438d, c12161cM73052O, new d(), countDownLatch, 0, this.f46454t, this.f46419B, this.f46421D, new HashMap()));
                syncLock(countDownLatch);
                c12161cM73052O.m72998o0(2);
                this.f46437c.m73111w0(c12161cM73052O);
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "downloadGalleryDB successful. appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
            }
        } else {
            m58147A0();
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            CloudBackupTaskManager.getInstance().addFileTask(this.appId, new C9216i1(this.f46440f, this.f46438d, c12161cM73052O, new d(), countDownLatch2, 0, this.f46454t, this.f46419B, this.f46421D, new HashMap()));
            syncLock(countDownLatch2);
            c12161cM73052O.m72998o0(2);
            this.f46437c.m73111w0(c12161cM73052O);
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "downloadGalleryDB successful. appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
        }
        m58147A0();
        AlbumsTempOperator albumsTempOperator = new AlbumsTempOperator();
        this.f46456v = albumsTempOperator.getPathAndOutSide();
        albumsTempOperator.close();
    }

    public final Context getContext() {
        return C0213f.m1377a();
    }

    public final void initDownloadTotalSize() throws InterruptedException, C9721b {
        String str = this.appId;
        str.hashCode();
        switch (str) {
            case "callRecorder":
            case "soundrecorder":
                int count = this.f46438d.getCount();
                if (count <= 0) {
                    count = this.f46448n;
                }
                this.f46447m = count;
                break;
            case "gallery":
                downloadGalleryDB();
                break;
            case "music":
                this.f46447m = this.f46448n;
                break;
            default:
                if (this.f46438d.is3rdAppType()) {
                    this.f46447m = this.f46448n;
                }
                if (this.f46438d.isShowRestoreProgressTotal()) {
                    this.f46447m = this.f46448n;
                    break;
                }
                break;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        if (this.f46422E != null) {
            return true;
        }
        return super.isAbort();
    }

    public final boolean isGalleryDbFile(String str) {
        return HNConstants.DataType.MEDIA.equals(this.appId) && !isStringNull(str) && str.contains(AlbumsTempScript.DATABASE_NAME);
    }

    public final boolean isNetDisconnect(C9721b c9721b) {
        C11839m.m70688i("CloudRestoreV3ModuleDownload", c9721b.toString());
        int iM60659c = c9721b.m60659c();
        return 1104 == iM60659c || 1105 == iM60659c || 1106 == iM60659c || 1107 == iM60659c || 3900 == iM60659c;
    }

    public final boolean isSuccess() {
        int type = this.f46438d.getType();
        C11839m.m70686d("CloudRestoreV3ModuleDownload", "isSuccess type: " + type + " ,status: " + this.f46438d.getStatus());
        if (!this.f46438d.is3rdAppType() || !this.f46438d.m29484T()) {
            return 1 == type;
        }
        int status = this.f46438d.getStatus();
        if (status != 5) {
            if (status != 6 || type == 2) {
                return false;
            }
        } else if (type != 1) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void lambda$call$0(Consumer consumer) {
        consumer.accept(this.f46422E);
    }

    public final /* synthetic */ void lambda$call$1(Consumer consumer) {
        consumer.accept(Boolean.valueOf(this.f46420C));
    }

    public final /* synthetic */ void lambda$call$2(Consumer consumer) {
        consumer.accept(this.f46429L);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mergeDbfile() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9252r1.mergeDbfile():void");
    }

    /* renamed from: p */
    public final void m58161p() {
        new C13998b0().m84119P0(this.f46440f.m29783R(), this.f46440f.m29772G(), "resourceScan");
    }

    public void pause() {
        this.f46443i = true;
        this.abort = true;
    }

    /* renamed from: q0 */
    public final void m58162q0() throws InterruptedException, C9721b {
        if (!this.f46438d.is3rdAppType() || this.f46438d.m29498s() == 0) {
            return;
        }
        try {
            if (this.f46437c.m73078f0() > 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C12583q.m75680p(1));
            String str = File.separator;
            sb2.append(str);
            sb2.append(this.appId);
            m58157K0(sb2.toString(), ICBUtil.RELATIVE_SDATA_PATH + str);
            m58157K0(C12583q.m75678n(this.appId, this.f46438d.getUid()), "/external" + str);
            m58157K0(C12583q.m75679o(this.appId, this.f46438d.getUid()), "/external" + str);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3ModuleDownload", "checkAndUpdateExistFile error: " + e10.getMessage());
        }
    }

    /* renamed from: r0 */
    public final boolean m58163r0(File file) {
        return (file.exists() || file.mkdirs()) ? false : true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask, com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        C12188o.m73320c().m73323d(this.f46438d);
    }

    public final void reportActualSize() {
        long asize = this.f46438d.getAsize() + this.f46438d.getSize();
        C4880b c4880b = this.f46440f;
        c4880b.m29812u0(c4880b.m29778M() + asize);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strM66627b = C11058a.m66627b("02015");
        linkedHashMap.put("backupTransID", this.f46440f.m29783R());
        linkedHashMap.put("traceId", strM66627b);
        linkedHashMap.put("appId", this.appId);
        linkedHashMap.put("actualSize", String.valueOf(asize));
        C11060c c11060cM66626a = C11058a.m66626a(this.f46440f.m29783R(), "actualSize", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        String strM80987x0 = C13452e.m80781L().m80987x0();
        if (!TextUtils.isEmpty(strM80987x0)) {
            linkedHashMap.put("userType", strM80987x0);
        }
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    public final void restoreSafeboxFile() throws C9721b {
        if ("safebox".equals(this.appId)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                ICBUtil.moveSpecialFile(this.appId, linkedHashMap);
                CloudBackupReport.reportSafeBoxRestoreErrorMsg(linkedHashMap, this.f46440f.m29783R());
            } catch (IOException e10) {
                C11839m.m70687e("CloudRestoreV3ModuleDownload", "restoreSafeboxFile error: " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restoreSafeboxFile exception" + e10.getMessage());
            }
        }
    }

    public final void sendDownloadStatus(int i10) {
        if (!this.f46438d.isTwinApp() && this.f46438d.is3rdAppType() && this.f46444j) {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "sendDownloadStatus: appId = " + this.f46438d.getAppId() + ", status = " + i10 + " ,uid: " + this.f46438d.getUid());
            Bundle bundle = new Bundle();
            bundle.putString("packageName_", this.f46438d.m29470M());
            bundle.putString("name_", this.f46438d.getAppName());
            bundle.putInt("status_", i10);
            ICBBroadcastManager.sendDownloadEventBroadcast(this.f46453s, bundle);
        }
    }

    public void setDownloadApkConsumer(Consumer<Boolean> consumer) {
        this.f46427J = consumer;
    }

    public void setExceptionConsumer(Consumer<C9721b> consumer) {
        this.f46426I = consumer;
    }

    public void setReportInfoConsumer(Consumer<RestoreModuleReportInfo> consumer) {
        this.f46428K = consumer;
    }

    public final void syncLock(CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "syncLock start lock");
        while (countDownLatch.getCount() > 0) {
            m58147A0();
            try {
                if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    break;
                }
            } catch (InterruptedException e10) {
                C11839m.m70689w("CloudRestoreV3ModuleDownload", "downloadFilesMulti lock wait error." + e10);
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadFilesMulti lock wait error.");
            }
        }
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "syncLock end lock");
    }

    /* renamed from: u0 */
    public final void m58164u0(C12810a c12810a, String str, List<InterfaceC1446a> list) throws InterruptedException, C9721b {
        try {
            m58147A0();
            int iM76858i = c12810a.m76858i();
            C12590s0.m75845e1(str, c12810a.m76861l(), this.f46452r);
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore3rd app start, appId = " + this.appId + ", flag = " + iM76858i + " ,uid: " + this.f46438d.getUid());
            if (iM76858i != 0) {
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore3rd app start, appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
                boolean z10 = false;
                boolean z11 = c12810a.m76854e().equals(String.valueOf(3)) ? !list.isEmpty() : false;
                if (z11) {
                    boolean zBusinessRestoreStandardApk = businessRestoreStandardApk(list);
                    if (!zBusinessRestoreStandardApk) {
                        this.f46420C = false;
                        this.f46435a.m76958v(this.f46438d, 5, 0);
                    }
                    z10 = zBusinessRestoreStandardApk;
                }
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "startTask cloudRestoreAgdApiClient , appId = " + this.appId + ", allowBusinessRestoreDownload = " + z11 + ", quotaType = " + c12810a.m76854e() + " businessRestoreResult: " + z10);
                if (!z11 || !z10) {
                    C11839m.m70688i("CloudRestoreV3ModuleDownload", "downloadStandardApk by obs");
                    m58167x0(c12810a, str);
                }
                if (!z10) {
                }
                this.f46420C = true;
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore3rd app success, appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
            }
            m58168y0(c12810a, str);
            this.f46436b.m76881f(this.appId, "apk", 2, this.f46438d.getUid());
            this.f46435a.m76958v(this.f46438d, 5, 1);
            this.f46420C = true;
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore3rd app success, appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreV3ModuleDownload", "restore3rd app failed, appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
            this.f46435a.m76958v(this.f46438d, 5, 2);
            throw e10;
        }
    }

    public final void update3rdProgress(int i10, boolean z10, boolean z11) {
        if (this.abort || this.f46422E != null) {
            C11839m.m70686d("CloudRestoreV3ModuleDownload", "update3rdProgress appId" + this.appId + "pause " + this.f46443i + " ,uid: " + this.f46438d.getUid());
            return;
        }
        C11839m.m70686d("CloudRestoreV3ModuleDownload", "update3rdProgress percent =" + i10 + ", appId:" + this.appId + " lastProgressForTimer =" + this.f46458x + " isDone" + z10);
        if (i10 - this.f46458x > 0 || z10) {
            this.f46458x = i10;
            this.f46438d.setCurrent(i10).setCount(100);
            RestoreProgress.updateStatus(this.f46438d);
            if (z11 && !this.f46438d.isTwinApp() && this.f46438d.m29478Q() && this.f46444j) {
                if (i10 - this.f46459y >= 10 || z10) {
                    C11839m.m70686d("CloudRestoreV3ModuleDownload", "update3rd progress, appId = " + this.appId + " percent = " + i10 + " ,uid: " + this.f46438d.getUid());
                    this.f46459y = i10;
                    Bundle bundle = new Bundle();
                    bundle.putString("packageName_", this.f46438d.m29470M());
                    bundle.putString("name_", this.f46438d.getAppName());
                    bundle.putInt("status_", 2);
                    bundle.putInt("progress_", i10);
                    ICBBroadcastManager.sendDownloadEventBroadcast(getContext(), bundle);
                }
            }
        }
    }

    public final void updateCurrent(int i10) {
        String str = this.appId;
        str.hashCode();
        switch (str) {
            case "callRecorder":
            case "gallery":
            case "music":
            case "soundrecorder":
                this.f46438d.setCurrent(Math.min(i10, this.f46447m));
                RestoreProgress.updateStatus(this.f46438d);
                this.f46435a.m76954r(this.f46438d);
                break;
        }
    }

    /* renamed from: v0 */
    public final void m58165v0() throws InterruptedException, C9721b {
        if (!this.f46438d.is3rdAppType() || "V4".equals(this.f46440f.f22517K)) {
            return;
        }
        this.f46438d.setSubStatus("downloadApp");
        PackageManager packageManager = getContext().getPackageManager();
        String strM29470M = this.f46438d.m29470M();
        long versionCode = ICBUtil.getVersionCode(packageManager, strM29470M);
        boolean z10 = versionCode > 0;
        List<InterfaceC1446a> listM1694e = C0248g.m1694e(strM29470M, versionCode, this.f46440f.m29775J(), this.f46440f.mo29591n());
        boolean z11 = listM1694e.size() == 0;
        if (!this.f46438d.m29484T()) {
            if (z10 && z11) {
                C11839m.m70688i("CloudRestoreV3ModuleDownload", "downloadApk apk version lower, appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
                RestoreProgressManager.getInstance().addBytesDownloaded(this.f46438d.getAsize());
                CloudRestoreStatusV3 cloudRestoreStatusV3 = this.f46438d;
                cloudRestoreStatusV3.addBytesDownloaded(true, cloudRestoreStatusV3.getAsize());
                return;
            }
            if (!z10) {
                this.f46438d.m29465J0(0);
            }
        }
        C12810a c12810aM76880e = this.f46436b.m76880e(this.appId, "apk", this.f46438d.getUid());
        if (c12810aM76880e == null) {
            this.f46435a.m76958v(this.f46438d, 5, 2);
            m58161p();
            throw new C9721b(1009, this.appId + " downloadApk exit for apkAttachmentStatus is empty");
        }
        String str = this.f46446l + "/" + this.appId + ".apk";
        if (2 == c12810aM76880e.m76862m() && C10278a.m63442h(str).exists()) {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "apk already exist");
            this.f46435a.m76958v(this.f46438d, 5, 1);
        } else if (m58148B0()) {
            if (m58163r0(C10278a.m63442h(this.f46446l))) {
                C11839m.m70689w("CloudRestoreV3ModuleDownload", "downloadApk mkdirs failed.");
                this.f46435a.m76958v(this.f46438d, 5, 2);
            } else {
                this.f46435a.m76958v(this.f46438d, 5, 0);
                if (!this.f46445k) {
                    sendDownloadStatus(2);
                }
                m58164u0(c12810aM76880e, str, listM1694e);
            }
        }
    }

    /* renamed from: w0 */
    public final void m58166w0() throws Throwable {
        this.f46438d.setSubStatus("downloadFiles");
        if (this.f46438d.is3rdAppType() && 1 == this.f46438d.getAction()) {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "no need restore appdata");
            m58147A0();
            this.f46435a.m76958v(this.f46438d, 4, 1);
            return;
        }
        if (this.f46436b.m76880e(this.appId, SnapshotDBManager.PREFIX_DATABASE_NAME, this.f46438d.getUid()) == null) {
            this.f46435a.m76958v(this.f46438d, 4, 2);
            m58161p();
            throw new C9721b(1009, this.appId + " snapshot attachment is empty");
        }
        this.f46437c.m73043J0(1, 2);
        int iM73026B = this.f46437c.m73026B();
        this.f46448n = iM73026B;
        if (iM73026B == 0) {
            C11839m.m70688i("CloudRestoreV3ModuleDownload", "no file info in cloud. appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
            this.f46438d.setStatus(4).setType(1);
            this.f46435a.m76959w(this.appId, 4, this.f46438d.getUid(), 1, this.f46438d.getSubStatus());
            return;
        }
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore files start, appId = " + this.appId + ", metas size = " + this.f46448n);
        m58162q0();
        m58147A0();
        downloadFilesMultiPrepare();
        m58147A0();
        m58155I0(true);
        m58147A0();
        m58155I0(false);
        m58147A0();
        mergeDbfile();
        m58147A0();
        restoreSafeboxFile();
        m58147A0();
        this.f46435a.m76958v(this.f46438d, 4, 1);
        C11839m.m70688i("CloudRestoreV3ModuleDownload", "restore files end, appId = " + this.appId + " ,uid: " + this.f46438d.getUid());
    }

    /* renamed from: x0 */
    public final void m58167x0(C12810a c12810a, final String str) throws C9721b {
        this.f46438d.m29457B0(String.valueOf(0));
        final String strM76851b = c12810a.m76851b();
        final String strM29503v = this.f46438d.m29503v();
        final String strM76865p = c12810a.m76865p();
        C10546a.m64704a(new C10546a.a() { // from class: dm.o1
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f46372a.m58149C0(str, strM29503v, strM76851b, strM76865p);
            }
        }).m64705b();
    }

    /* renamed from: y0 */
    public final void m58168y0(C12810a c12810a, final String str) throws C9721b {
        this.f46438d.m29457B0(String.valueOf(0));
        String strM76851b = c12810a.m76851b();
        final String str2 = this.f46419B + this.appId + "/" + strM76851b.substring(strM76851b.lastIndexOf("/") + 1);
        C10546a.m64704a(new C10546a.a() { // from class: dm.n1
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f46365a.m58150D0(str, str2);
            }
        }).m64705b();
    }

    /* renamed from: z0 */
    public final String m58169z0(File file) {
        String strM63452a = C10279b.m63452a(file);
        int uid = this.f46438d.getUid();
        if (TextUtils.isEmpty(strM63452a)) {
            C11839m.m70689w("CloudRestoreV3ModuleDownload", "getDbDataByFile filepath is empty");
        } else {
            String strM75680p = C12583q.m75680p(1);
            if (TextUtils.isEmpty(strM75680p) || !strM63452a.startsWith(strM75680p)) {
                String strM75678n = C12583q.m75678n(this.appId, uid);
                if (TextUtils.isEmpty(strM75678n) || !strM63452a.startsWith(strM75678n)) {
                    String strM75679o = C12583q.m75679o(this.appId, uid);
                    if (!TextUtils.isEmpty(strM75679o) && strM63452a.startsWith(strM75679o)) {
                        strM63452a = strM63452a.replaceFirst(strM75679o + File.separator, "");
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Android");
                    String str = File.separator;
                    sb2.append(str);
                    sb2.append(strM63452a.replaceFirst(strM75678n + str, ""));
                    strM63452a = sb2.toString();
                }
            } else {
                strM63452a = C12583q.m75665a(strM63452a, 1, uid).replaceFirst(ICBUtil.RELATIVE_SDATA_PATH + File.separator, "");
            }
        }
        return ICBUtil.hasEmojiCharacter(strM63452a) ? ICBUtil.getEncodedPath(strM63452a) : strM63452a;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        C10574x c10574x = this.f46460z;
        if (c10574x != null) {
            c10574x.mo64711f();
        }
        C10547a0 c10547a0 = this.f46418A;
        if (c10547a0 != null) {
            c10547a0.mo64711f();
        }
        super.cancel(z10);
    }
}
