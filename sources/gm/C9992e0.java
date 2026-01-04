package gm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempDBManager;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.provider.QueryAppRestoreFromProvider;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import dm.C9205f2;
import dm.C9209g2;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0214f0;
import p514o9.C11839m;
import p617rl.C12521e;
import p617rl.C12522f;
import p617rl.C12526j;
import p618rm.C12580p;
import p618rm.C12583q;
import p709vj.C13452e;
import p848zl.C14333b;
import sl.C12816g;

/* renamed from: gm.e0 */
/* loaded from: classes6.dex */
public class C9992e0 {

    /* renamed from: u */
    public static final Object f48881u = new Object();

    /* renamed from: v */
    public static final Object f48882v = new Object();

    /* renamed from: b */
    public long f48884b;

    /* renamed from: c */
    public C4880b f48885c;

    /* renamed from: d */
    public Context f48886d;

    /* renamed from: e */
    public String f48887e;

    /* renamed from: f */
    public String f48888f;

    /* renamed from: g */
    public boolean f48889g;

    /* renamed from: h */
    public int f48890h;

    /* renamed from: r */
    public long f48900r;

    /* renamed from: a */
    public ConcurrentHashMap<String, CloudRestoreStatusV3> f48883a = new ConcurrentHashMap<>();

    /* renamed from: i */
    public C12816g f48891i = new C12816g();

    /* renamed from: j */
    public List<String> f48892j = new ArrayList();

    /* renamed from: k */
    public Queue<CloudRestoreStatusV3> f48893k = new ConcurrentLinkedDeque();

    /* renamed from: l */
    public Queue<CloudRestoreStatusV3> f48894l = new ConcurrentLinkedDeque();

    /* renamed from: m */
    public Queue<CloudRestoreStatusV3> f48895m = new ConcurrentLinkedDeque();

    /* renamed from: n */
    public Queue<CloudRestoreStatusV3> f48896n = new ConcurrentLinkedDeque();

    /* renamed from: o */
    public CloudRestoreStatusV3 f48897o = null;

    /* renamed from: p */
    public CloudRestoreStatusV3 f48898p = null;

    /* renamed from: q */
    public boolean f48899q = false;

    /* renamed from: s */
    public List<String> f48901s = new ArrayList();

    /* renamed from: t */
    public String f48902t = ICBUtil.getHwCloudApkInstallCachePath();

    public C9992e0(C4880b c4880b, Context context, String str, boolean z10, int i10, long j10) {
        this.f48885c = c4880b;
        this.f48886d = context;
        this.f48887e = str;
        this.f48889g = z10;
        this.f48890h = i10;
        this.f48900r = j10;
        ICBUtil.dealDefaultMoudles(this.f48892j);
        this.f48888f = str + "/gallery/gallery.db";
    }

    /* renamed from: p */
    public static /* synthetic */ boolean m61962p(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return cloudRestoreStatusV3.getStatus() < 0;
    }

    /* renamed from: q */
    public static /* synthetic */ boolean m61963q(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return cloudRestoreStatusV3.getStatus() >= 0;
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m61964s(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return cloudRestoreStatusV3.getStatus() < 0;
    }

    /* renamed from: t */
    public static /* synthetic */ boolean m61965t(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return cloudRestoreStatusV3.getStatus() >= 0;
    }

    /* renamed from: v */
    public static /* synthetic */ void m61966v(AtomicLong atomicLong, String str, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        long size = cloudRestoreStatusV3.getSize() + cloudRestoreStatusV3.getAsize();
        atomicLong.addAndGet((((100 - cloudRestoreStatusV3.getProgress()) * size) / 100) + size);
    }

    /* renamed from: A */
    public final void m61967A() {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        this.f48884b = localLeftSpace == null ? 0L : localLeftSpace.longValue() - new C12526j().m75428x0();
    }

    /* renamed from: B */
    public final void m61968B() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3Operate", "restore first queue start.");
        try {
            m61971E(this.f48893k);
            e = null;
        } catch (C9721b e10) {
            e = e10;
            this.f48885c.setException(e);
        }
        m61974H(e);
        this.f48885c.isCancel();
        this.f48885c.updateTagsStatus(2);
        m61981l(this.f48900r, this.f48885c.m29772G(), this.f48890h, RestoreCache.getInstance().getEntranceOfRestore());
        this.f48885c.m29807p0(false);
        C11839m.m70688i("CloudRestoreV3Operate", "restore first queue end.");
    }

    /* renamed from: C */
    public final void m61969C() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3Operate", "restore last queue start.");
        m61971E(this.f48896n);
        C11839m.m70688i("CloudRestoreV3Operate", "restore last queue end.");
    }

    /* renamed from: D */
    public final void m61970D() throws InterruptedException, C9721b {
        if (this.f48899q) {
            return;
        }
        C11839m.m70688i("CloudRestoreV3Operate", "restore lancher start");
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
        C11839m.m70686d("CloudRestoreV3Operate", "restore launcher pollQueue.offer " + concurrentLinkedDeque.offer(this.f48897o));
        m61971E(concurrentLinkedDeque);
        this.f48899q = true;
    }

    @SafeVarargs
    /* renamed from: E */
    public final void m61971E(Queue<CloudRestoreStatusV3>... queueArr) throws InterruptedException, C9721b {
        if (queueArr == null) {
            C11839m.m70688i("CloudRestoreV3Operate", "restoreModules exit, queue is empty");
            return;
        }
        C11839m.m70688i("CloudRestoreV3Operate", "restore modules start.");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int size = 0;
        for (Queue<CloudRestoreStatusV3> queue : queueArr) {
            if (queue != null && !queue.isEmpty()) {
                size += queue.size();
                arrayList.add(queue);
            }
        }
        C11839m.m70688i("CloudRestoreV3Operate", "restoreModules start.");
        boolean z10 = false;
        while (i10 < size) {
            this.f48885c.isCancel();
            int i11 = i10 + 1;
            Queue queue2 = (Queue) arrayList.get(i10 % arrayList.size());
            CloudRestoreStatusV3 cloudRestoreStatusV3 = (CloudRestoreStatusV3) queue2.poll();
            if (queue2.isEmpty()) {
                arrayList.remove(queue2);
            }
            if (cloudRestoreStatusV3 == null) {
                C11839m.m70688i("CloudRestoreV3Operate", "restoreModules queue status is null.");
            } else {
                if ("HWlanucher".equals(cloudRestoreStatusV3.getAppId())) {
                    z10 = true;
                }
                if (cloudRestoreStatusV3.isSkipDownload(this.f48889g)) {
                    C11839m.m70688i("CloudRestoreV3Operate", "restoreModules " + cloudRestoreStatusV3.getAppId() + " uid: " + cloudRestoreStatusV3.getUid() + ", no need to restore");
                    if ("HWlanucher".equals(cloudRestoreStatusV3.getAppId())) {
                        this.f48885c.setLauncherLayoutOk(true);
                    }
                } else {
                    m61977h(cloudRestoreStatusV3);
                }
            }
            i10 = i11;
        }
        this.f48885c.isCancel();
        this.f48885c.modulesAwait();
        if (this.f48885c.getException() == null) {
            if (z10) {
                C11839m.m70688i("CloudRestoreV3Operate", "restore HwLauncher end, set isLauncherRestore = true");
                this.f48899q = true;
            }
            C11839m.m70688i("CloudRestoreV3Operate", "restore modules end.");
            return;
        }
        C11839m.m70688i("CloudRestoreV3Operate", "restoreMulti end，but seems error, throw exception." + this.f48885c.getException());
        throw this.f48885c.getException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    /* renamed from: F */
    public void m61972F(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        try {
            try {
                String appId = cloudRestoreStatusV3.getAppId();
                this.f48885c.m29599v(appId);
                this.f48885c.m29600y(cloudRestoreStatusV3.getUid());
                C11839m.m70688i("CloudRestoreV3Operate", "takeQueue start to restore " + appId + " ,uid: " + cloudRestoreStatusV3.getUid());
                new C9209g2(cloudRestoreStatusV3, this.f48885c.m29790Y(), this.f48901s, this.f48887e, this.f48902t, this, this.f48885c).m57830j();
            } catch (C9721b e10) {
                this.f48885c.setException(e10);
            }
        } finally {
            m61989y(cloudRestoreStatusV3.m29468L());
        }
    }

    /* renamed from: G */
    public final void m61973G() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3Operate", "restore second queue start.");
        this.f48885c.isCancel();
        this.f48885c.m29813v0(true);
        m61971E(this.f48894l, this.f48895m);
        this.f48885c.m29813v0(false);
        if (!this.f48885c.m29790Y() && this.f48897o != null) {
            m61970D();
        }
        C11839m.m70688i("CloudRestoreV3Operate", "restore second queue end.");
    }

    /* renamed from: H */
    public final void m61974H(C9721b c9721b) throws C9721b {
        if (this.f48885c.m29793b0()) {
            List<CloudRestoreStatusV3> listM76946j = this.f48891i.m76946j();
            Collections.sort(listM76946j);
            if (this.f48885c.isFirstStageFailed(listM76946j)) {
                this.f48885c.updateTagsStatus(4);
                this.f48885c.sendFirstDoneMessage(false);
                RestoreNotification.getInstance().cancelNotification();
                if (c9721b != null) {
                    throw c9721b;
                }
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore first stage not all done.", "onOperate");
            }
            this.f48885c.updateTagsStatus(2);
            ArrayList arrayList = new ArrayList();
            for (CloudRestoreStatusV3 cloudRestoreStatusV3 : listM76946j) {
                if (this.f48885c.f22528V.contains(cloudRestoreStatusV3.getAppId()) && cloudRestoreStatusV3.isSuccess()) {
                    arrayList.add(cloudRestoreStatusV3.getAppId());
                }
            }
            this.f48885c.callback(Message.obtain(null, 32321, arrayList));
            this.f48885c.sendFirstDoneMessage(true);
            RestoreNotification.getInstance().notifyRestore();
        }
    }

    /* renamed from: I */
    public void m61975I(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (this.f48885c.isAbort()) {
            return;
        }
        RestoreProgress.updateStatus(cloudRestoreStatusV3);
    }

    /* renamed from: J */
    public final void m61976J() throws C9721b {
        boolean z10;
        if (this.f48885c.m29790Y()) {
            this.f48885c.m29815x0(this.f48891i.m76944h());
            if (this.f48885c.m29781P().isEmpty()) {
                return;
            }
            Iterator<CloudRestoreStatusV3> it = this.f48885c.m29781P().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                CloudRestoreStatusV3 next = it.next();
                if (next == null) {
                    C11839m.m70689w("CloudRestoreV3Operate", "waitForHwLauncherNotification status is null.");
                } else if (next.getStatus() > 3 || next.getStatus() == 0) {
                    if (!next.m29500t().isEmpty()) {
                        z10 = true;
                        break;
                    }
                }
            }
            C11839m.m70688i("CloudRestoreV3Operate", "waitForHwLauncherNotification need wait for launcher : " + z10);
            if (z10) {
                try {
                    C11839m.m70688i("CloudRestoreV3Operate", "waitForHwLauncherNotification begin");
                    while (!this.f48885c.m29789X()) {
                        this.f48885c.isCancel();
                        synchronized (this.f48885c.m29780O()) {
                            this.f48885c.m29780O().wait(5000L);
                        }
                    }
                    C11839m.m70688i("CloudRestoreV3Operate", "waitForHwLauncherNotification end");
                } catch (InterruptedException unused) {
                    C11839m.m70688i("CloudRestoreV3Operate", "waitForHwLauncherNotification catch InterruptedException.");
                }
            }
            m61980k();
        }
    }

    /* renamed from: h */
    public void m61977h(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        C11839m.m70688i("CloudRestoreV3Operate", "addTask appId: " + cloudRestoreStatusV3.getAppId() + " ,uid: " + cloudRestoreStatusV3.getUid());
        C9205f2 c9205f2 = new C9205f2(this.f48885c, this, cloudRestoreStatusV3, C12583q.m75663Q(1, cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3.getUid()), this.f48902t);
        this.f48885c.addModule(cloudRestoreStatusV3.m29468L());
        CloudBackupTaskManager.getInstance().addModuleTask(cloudRestoreStatusV3.m29468L(), c9205f2);
    }

    /* renamed from: i */
    public final void m61978i(List<CloudRestoreStatusV3> list) {
        if (this.f48885c.isFromOOBE() && QueryAppRestoreFromProvider.checkPrioritRestoreIcon(this.f48886d)) {
            this.f48885c.f22528V.add("HWlanucher");
        }
        ArrayList arrayList = new ArrayList();
        long j10 = 0;
        long j11 = 0;
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (cloudRestoreStatusV3 == null) {
                C11839m.m70689w("CloudRestoreV3Operate", "addFirstQueue status is null.");
            } else {
                String appId = cloudRestoreStatusV3.getAppId();
                if (cloudRestoreStatusV3.isUnSupport()) {
                    C11839m.m70688i("CloudRestoreV3Operate", "skip unsupport appId: " + appId);
                } else {
                    long asize = 1 == cloudRestoreStatusV3.getAction() ? cloudRestoreStatusV3.getAsize() : cloudRestoreStatusV3.getSize() + cloudRestoreStatusV3.getAsize();
                    C4880b c4880b = this.f48885c;
                    c4880b.m29816y0(c4880b.m29782Q() + asize);
                    int status = cloudRestoreStatusV3.getStatus();
                    if (status != 1 && status != 2 && status != 8) {
                        j10 += asize;
                        if (this.f48885c.f22528V.contains(appId)) {
                            j11 += asize;
                            if ("HWlanucher".equals(appId)) {
                                this.f48897o = cloudRestoreStatusV3;
                            }
                        }
                    }
                    if (this.f48885c.f22528V.contains(appId)) {
                        this.f48893k.add(cloudRestoreStatusV3);
                        arrayList.add(appId);
                    }
                }
            }
        }
        RestoreProgressManager.getInstance().setContentLength(j10);
        RestoreProgressManager.getInstance().setFirstContentLength(j11);
        RestoreProgressManager.getInstance().setFirstCount(this.f48893k.size());
        RestoreProgressManager.getInstance().setRestoreFirstData(arrayList);
    }

    /* renamed from: j */
    public final void m61979j(List<CloudRestoreStatusV3> list) {
        List<String> list2 = this.f48885c.f22529W;
        List<String> listM85489x = C14333b.m85489x();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (!cloudRestoreStatusV3.isUnSupport()) {
                String appId = cloudRestoreStatusV3.getAppId();
                if (list2.contains(appId)) {
                    this.f48894l.add(cloudRestoreStatusV3);
                } else if ("HWlanucher".equals(appId)) {
                    this.f48897o = cloudRestoreStatusV3;
                } else if (listM85489x.contains(appId) || "virtual.hmos.sync.switch.status".equals(appId)) {
                    this.f48896n.add(cloudRestoreStatusV3);
                } else if (!this.f48892j.contains(appId)) {
                    if (HNConstants.DataType.MEDIA.equals(appId)) {
                        this.f48898p = cloudRestoreStatusV3;
                        this.f48894l.add(cloudRestoreStatusV3);
                    } else if ("music".equals(appId)) {
                        this.f48894l.add(cloudRestoreStatusV3);
                    } else if (cloudRestoreStatusV3.is3rdAppType() || cloudRestoreStatusV3.m29480R()) {
                        this.f48895m.add(cloudRestoreStatusV3);
                        this.f48885c.m29781P().add(cloudRestoreStatusV3);
                    } else if (cloudRestoreStatusV3.m29486U()) {
                        this.f48894l.add(cloudRestoreStatusV3);
                    }
                }
            }
        }
    }

    /* renamed from: k */
    public final void m61980k() throws C9721b {
        try {
            List<String> listQueryRestoreAppsOrders = QueryAppRestoreFromProvider.queryRestoreAppsOrders(this.f48886d);
            this.f48901s = listQueryRestoreAppsOrders;
            if (listQueryRestoreAppsOrders == null) {
                C11839m.m70688i("CloudRestoreV3Operate", "app restore order from launcher is null.");
                this.f48901s = new ArrayList();
            }
            if (this.f48901s.isEmpty()) {
                return;
            }
            List<CloudRestoreStatusV3> listM29781P = this.f48885c.m29781P();
            List list = (List) listM29781P.stream().filter(new Predicate() { // from class: gm.b0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9992e0.m61962p((CloudRestoreStatusV3) obj);
                }
            }).collect(Collectors.toList());
            List list2 = (List) listM29781P.stream().filter(new Predicate() { // from class: gm.c0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9992e0.m61963q((CloudRestoreStatusV3) obj);
                }
            }).sorted(new Comparator() { // from class: gm.d0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.f48879a.m61985r((CloudRestoreStatusV3) obj, (CloudRestoreStatusV3) obj2);
                }
            }).collect(Collectors.toList());
            listM29781P.clear();
            listM29781P.addAll(list2);
            listM29781P.addAll(list);
            m61990z();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3Operate", "adjustThirdAppSequence queryRestoreAppsOrders failed.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "queryRestoreAppsOrders failed", "CloudRestore_threadRestoreProcess: " + e10.getMessage());
        }
    }

    /* renamed from: l */
    public void m61981l(long j10, String str, int i10, String str2) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f48886d, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b != null && !sharedPreferencesM1382b.getBoolean("backup_key", false)) {
            CloudBackupReport.reportOpenCloudBackup("10", i10, str2);
            CloudBackupService.getInstance().cloudbackupOpr(true);
        }
        if (j10 == 0) {
            return;
        }
        SettingOperator settingOperator = new SettingOperator();
        long jQueryinitopentime = settingOperator.queryinitopentime();
        String strM80950o = C13452e.m80781L().m80950o();
        if (strM80950o != null && strM80950o.equals(str) && jQueryinitopentime > j10) {
            settingOperator.replace(new Settings[]{new Settings("lastbackuptime", String.valueOf(j10), "2")});
        }
        settingOperator.replace(new Settings[]{new Settings("lastnotifytime", String.valueOf(j10), "2")});
    }

    /* renamed from: m */
    public void m61982m() throws C9721b {
        this.f48885c.isCancel();
        m61984o();
        this.f48885c.isCancel();
        boolean z10 = !this.f48893k.isEmpty();
        long jCurrentTimeMillis = System.currentTimeMillis();
        m61968B();
        if (z10) {
            this.f48885c.mo29598u(jCurrentTimeMillis, "First stage");
        }
        if (this.f48885c.m29790Y()) {
            this.f48885c.isCancel();
            m61970D();
            m61976J();
        }
        this.f48885c.isCancel();
        m61973G();
        this.f48885c.isCancel();
        boolean zHas3rdPause = this.f48885c.has3rdPause();
        if (!zHas3rdPause) {
            m61969C();
        }
        this.f48885c.isCancel();
        if (this.f48885c.hasDefault() || zHas3rdPause) {
            return;
        }
        this.f48885c.updateTagsStatus(3);
    }

    /* renamed from: n */
    public String m61983n() {
        return this.f48887e;
    }

    /* renamed from: o */
    public final void m61984o() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3Operate", "init restore queue start");
        C14333b.m85464T(new C12521e().m75314c());
        C14333b.m85465U(new C12522f().m75318c());
        this.f48885c.isCancel();
        ArrayList arrayList = new ArrayList();
        List<CloudRestoreStatusV3> listM76945i = this.f48891i.m76945i();
        List list = (List) listM76945i.stream().filter(new Predicate() { // from class: gm.y
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9992e0.m61964s((CloudRestoreStatusV3) obj);
            }
        }).collect(Collectors.toList());
        arrayList.addAll((List) listM76945i.stream().filter(new Predicate() { // from class: gm.z
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9992e0.m61965t((CloudRestoreStatusV3) obj);
            }
        }).sorted(new Comparator() { // from class: gm.a0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f48842a.m61986u((CloudRestoreStatusV3) obj, (CloudRestoreStatusV3) obj2);
            }
        }).collect(Collectors.toList()));
        arrayList.addAll(list);
        this.f48885c.isCancel();
        m61978i(arrayList);
        this.f48885c.isCancel();
        m61979j(arrayList);
        boolean z10 = this.f48897o != null && QueryAppRestoreFromProvider.checkPrioritRestoreIcon(this.f48886d);
        C11839m.m70688i("CloudRestoreV3Operate", "initRestoreQueue isLauncherSupported = " + z10);
        this.f48885c.m29808q0(z10);
        this.f48885c.isCancel();
        if (this.f48898p != null) {
            AlbumsTempDBManager.initDataBase(this.f48886d.getApplicationContext(), this.f48888f);
            this.f48885c.m29809r0(true);
        }
        this.f48885c.isCancel();
        C11839m.m70688i("CloudRestoreV3Operate", "init restore queue end");
    }

    /* renamed from: r */
    public final /* synthetic */ int m61985r(CloudRestoreStatusV3 cloudRestoreStatusV3, CloudRestoreStatusV3 cloudRestoreStatusV32) {
        return C12580p.m75579m(cloudRestoreStatusV3, cloudRestoreStatusV32, this.f48901s);
    }

    /* renamed from: u */
    public final /* synthetic */ int m61986u(CloudRestoreStatusV3 cloudRestoreStatusV3, CloudRestoreStatusV3 cloudRestoreStatusV32) {
        return C12580p.m75579m(cloudRestoreStatusV3, cloudRestoreStatusV32, this.f48901s);
    }

    /* renamed from: w */
    public void m61987w(CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        m61967A();
        long size = cloudRestoreStatusV3.getSize() + cloudRestoreStatusV3.getAsize();
        synchronized (f48881u) {
            while (m61988x(size)) {
                try {
                    f48881u.wait();
                } catch (InterruptedException e10) {
                    C11839m.m70686d("CloudRestoreV3Operate", "module sync await error, " + e10.toString());
                }
            }
            this.f48883a.put(cloudRestoreStatusV3.m29468L(), cloudRestoreStatusV3);
        }
    }

    /* renamed from: x */
    public final boolean m61988x(long j10) throws InterruptedException, C9721b {
        this.f48885c.isCancel();
        if (this.f48883a.isEmpty()) {
            return false;
        }
        final AtomicLong atomicLong = new AtomicLong();
        this.f48883a.forEach(new BiConsumer() { // from class: gm.x
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                C9992e0.m61966v(atomicLong, (String) obj, (CloudRestoreStatusV3) obj2);
            }
        });
        return j10 * 2 > this.f48884b - atomicLong.get();
    }

    /* renamed from: y */
    public void m61989y(String str) {
        Object obj = f48881u;
        synchronized (obj) {
            this.f48883a.remove(str);
            m61967A();
            obj.notifyAll();
        }
    }

    /* renamed from: z */
    public final void m61990z() throws C9721b {
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : this.f48885c.m29781P()) {
            if (cloudRestoreStatusV3 != null) {
                Iterator<String> it = this.f48901s.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (cloudRestoreStatusV3.getAppId().equals(it.next())) {
                            cloudRestoreStatusV3.m29464I0(1);
                            break;
                        }
                    }
                }
            }
        }
        this.f48891i.batchReplace(this.f48885c.m29781P());
        this.f48895m.clear();
        for (CloudRestoreStatusV3 cloudRestoreStatusV32 : this.f48885c.m29781P()) {
            if (cloudRestoreStatusV32 == null) {
                C11839m.m70689w("CloudRestoreV3Operate", "refresh3rdLauncherFlag status is null.");
            } else if (!cloudRestoreStatusV32.isUnSupport()) {
                this.f48895m.add(cloudRestoreStatusV32);
            }
        }
    }
}
