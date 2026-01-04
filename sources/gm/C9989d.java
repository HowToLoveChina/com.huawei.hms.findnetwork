package gm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import ck.C1444b;
import cm.C1457c;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.C2516c0;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import dm.C9195d0;
import dm.C9215i0;
import fk.C9720a;
import fk.C9721b;
import hk.C10278a;
import hm.C10321z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import om.C11963c;
import om.C11965e;
import p015ak.C0209d;
import p015ak.C0213f;
import p262em.C9525y;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12571m;
import p618rm.C12580p;
import p618rm.C12583q;
import p618rm.C12586r;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12594t1;
import p682ul.C13216j;
import p709vj.C13452e;
import p744wl.C13617a;
import p746wn.C13622a;
import p762x4.C13694a;
import p814yl.C14000c0;
import p847zk.C14317j;
import p848zl.C14339h;
import pl.C12164f;
import pm.C12182i;
import sl.C12810a;
import sl.C12811b;
import sl.C12813d;
import sl.C12814e;
import sl.C12815f;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;

/* renamed from: gm.d */
/* loaded from: classes6.dex */
public class C9989d {

    /* renamed from: I */
    public static final Object f48844I = new Object();

    /* renamed from: D */
    public final C12815f f48848D;

    /* renamed from: a */
    public final C4879a f48853a;

    /* renamed from: b */
    public final boolean f48854b;

    /* renamed from: c */
    public final String f48855c;

    /* renamed from: d */
    public final String f48856d;

    /* renamed from: e */
    public final String f48857e;

    /* renamed from: f */
    public final String f48858f;

    /* renamed from: g */
    public final List<List<String>> f48859g;

    /* renamed from: l */
    public final Map<String, Bundle> f48864l;

    /* renamed from: m */
    public final C13029h f48865m;

    /* renamed from: t */
    public long f48872t;

    /* renamed from: u */
    public long f48873u;

    /* renamed from: v */
    public long f48874v;

    /* renamed from: h */
    public final List<String> f48860h = new ArrayList();

    /* renamed from: i */
    public final List<String> f48861i = new ArrayList();

    /* renamed from: j */
    public final List<String> f48862j = new ArrayList();

    /* renamed from: k */
    public final List<String> f48863k = new ArrayList();

    /* renamed from: n */
    public final Deque<CloudBackupStatus> f48866n = new ConcurrentLinkedDeque();

    /* renamed from: o */
    public final List<CloudBackupStatus> f48867o = new ArrayList();

    /* renamed from: p */
    public final List<CloudBackupStatus> f48868p = new ArrayList();

    /* renamed from: q */
    public final Map<CloudBackupStatus, C9721b> f48869q = new ConcurrentHashMap();

    /* renamed from: r */
    public final Vector<CloudBackupStatus> f48870r = new Vector<>();

    /* renamed from: s */
    public final List<CloudBackupStatus> f48871s = new ArrayList();

    /* renamed from: w */
    public long f48875w = 0;

    /* renamed from: x */
    public long f48876x = 0;

    /* renamed from: y */
    public final HashMap<String, App> f48877y = new HashMap<>();

    /* renamed from: z */
    public long f48878z = 0;

    /* renamed from: A */
    public long f48845A = 0;

    /* renamed from: B */
    public long f48846B = 0;

    /* renamed from: C */
    public final C12526j f48847C = new C12526j();

    /* renamed from: E */
    public final C12594t1 f48849E = C12594t1.m75990o();

    /* renamed from: F */
    public final Map<String, Long> f48850F = new ConcurrentHashMap();

    /* renamed from: G */
    public final Map<String, Long> f48851G = new ConcurrentHashMap();

    /* renamed from: H */
    public final Map<String, Long> f48852H = new ConcurrentHashMap();

    public C9989d(C4879a c4879a, List<List<String>> list, Map<String, Bundle> map, boolean z10, boolean z11, C13029h c13029h) throws C9721b {
        this.f48853a = c4879a;
        this.f48859g = list;
        this.f48864l = map;
        String strM29713i0 = c4879a.m29713i0();
        this.f48855c = strM29713i0;
        this.f48854b = z11;
        this.f48865m = c13029h;
        this.f48856d = C12590s0.m75786Q(c13029h);
        this.f48857e = c13029h.m78465h();
        this.f48858f = c13029h.m78444J();
        this.f48848D = new C12815f(strM29713i0);
        c4879a.m29643I0();
    }

    /* renamed from: k0 */
    public static /* synthetic */ boolean m61879k0(String str, BackupItem backupItem) {
        if (backupItem != null) {
            return str.equalsIgnoreCase(backupItem.m29870d());
        }
        return false;
    }

    /* renamed from: l0 */
    public static /* synthetic */ int m61880l0(BackupItem backupItem, BackupItem backupItem2) {
        return C12580p.m75586t(backupItem.m29870d(), backupItem2.m29870d());
    }

    /* renamed from: n0 */
    public static void m61881n0() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 33053;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: A */
    public C13029h m61882A() {
        return this.f48865m;
    }

    /* renamed from: A0 */
    public void m61883A0(long j10) {
        this.f48845A = j10;
    }

    /* renamed from: B */
    public long m61884B() {
        return this.f48873u;
    }

    /* renamed from: C */
    public final Context m61885C() {
        return C0213f.m1377a();
    }

    /* renamed from: D */
    public long m61886D() {
        return this.f48872t;
    }

    /* renamed from: E */
    public final String m61887E(String str, int i10) {
        return C12583q.m75656J(str, i10);
    }

    /* renamed from: F */
    public final String m61888F(String str, int i10) {
        return this.f48853a.m29743s0() + File.separator + str;
    }

    /* renamed from: G */
    public List<CloudBackupStatus> m61889G() {
        return this.f48867o;
    }

    /* renamed from: H */
    public CloudBackupStatus m61890H(int i10) {
        try {
            return C12182i.m73283j().m73292l(i10);
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupV3Operate", "get last module backup status error, = " + e10.toString());
            return null;
        }
    }

    /* renamed from: I */
    public final String m61891I() {
        return this.f48853a.getLocation();
    }

    /* renamed from: J */
    public HashMap<String, App> m61892J() {
        return this.f48877y;
    }

    /* renamed from: K */
    public List<String> m61893K() {
        return this.f48863k;
    }

    /* renamed from: L */
    public long m61894L() {
        return this.f48876x;
    }

    /* renamed from: M */
    public Map<String, Long> m61895M() {
        return this.f48851G;
    }

    /* renamed from: N */
    public Map<String, Long> m61896N() {
        return this.f48852H;
    }

    /* renamed from: O */
    public Map<String, Long> m61897O() {
        return this.f48850F;
    }

    /* renamed from: P */
    public long m61898P() {
        return this.f48846B;
    }

    /* renamed from: Q */
    public List<CloudBackupStatus> m61899Q() {
        return this.f48871s;
    }

    /* renamed from: R */
    public long m61900R() {
        return this.f48874v;
    }

    /* renamed from: S */
    public List<CloudBackupStatus> m61901S() {
        return this.f48868p;
    }

    /* renamed from: T */
    public final String m61902T(String str, int i10) {
        return C12583q.m75662P(str, i10);
    }

    /* renamed from: U */
    public long m61903U() {
        return this.f48875w;
    }

    /* renamed from: V */
    public long m61904V() {
        return this.f48878z;
    }

    /* renamed from: W */
    public long m61905W() {
        return this.f48845A;
    }

    /* renamed from: X */
    public boolean m61906X() {
        return C12182i.m73283j().m73293m();
    }

    /* renamed from: Y */
    public boolean m61907Y() {
        return C12182i.m73283j().m73295o();
    }

    /* renamed from: Z */
    public final void m61908Z() throws C9721b {
        List<BackupOptionItem> listM78397u = this.f48853a.m29722l0().mo1759d().m78397u();
        boolean zIsSupportPMS = this.f48853a.isSupportPMS();
        if (listM78397u != null) {
            for (BackupOptionItem backupOptionItem : listM78397u) {
                if (this.f48866n.contains(this.f48848D.m76928g(backupOptionItem.getAppId()))) {
                    String appId = backupOptionItem.getAppId();
                    if (!this.f48861i.contains(appId) || (backupOptionItem.getBackupSwitch() && zIsSupportPMS)) {
                        long dataBytes = backupOptionItem.getDataBytes();
                        long currentIncrease = backupOptionItem.getCurrentIncrease();
                        long totalIncrease = backupOptionItem.getTotalIncrease();
                        this.f48850F.put(appId, Long.valueOf(dataBytes));
                        this.f48851G.put(appId, Long.valueOf(currentIncrease));
                        this.f48852H.put(appId, Long.valueOf(totalIncrease));
                        C11839m.m70686d("CloudBackupV3Operate", "init size, appId: " + appId + ", estimateIncrease1: " + totalIncrease + ", estimateIncrease2: " + currentIncrease);
                    }
                }
            }
        }
    }

    /* renamed from: a0 */
    public final void m61909a0() throws C9721b {
        C9720a.m60652a(this.f48859g.size() > 0, "cache modules invalid.");
        this.f48860h.addAll(this.f48859g.get(0));
        if (this.f48859g.size() > 1) {
            this.f48861i.addAll(this.f48859g.get(1));
        }
        if (this.f48859g.size() > 2) {
            this.f48862j.addAll(this.f48859g.get(2));
        }
        if (this.f48859g.size() > 3) {
            this.f48863k.addAll(this.f48859g.get(3));
        }
        m61924j();
        List<BackupItem> listM71954i = C11963c.m71954i(this.f48853a.m29713i0());
        listM71954i.sort(new C2516c0());
        m61926k(listM71954i);
        if (listM71954i.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Operate", "backup moudles is empty.");
            throw new C9721b(1036, "backup moudles is empty.");
        }
        for (BackupItem backupItem : listM71954i) {
            String strM29870d = backupItem.m29870d();
            CloudBackupStatus cloudBackupStatusM76928g = this.f48848D.m76928g(strM29870d);
            if (cloudBackupStatusM76928g != null) {
                C11839m.m70688i("CloudBackupV3Operate", "add module: " + strM29870d + ", uid = " + backupItem.m29861N() + ", result = " + this.f48866n.offer(cloudBackupStatusM76928g));
            }
        }
        m61908Z();
    }

    /* renamed from: b0 */
    public void m61910b0() throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        m61934p0();
        this.f48853a.isCancel();
    }

    /* renamed from: c0 */
    public boolean m61911c0() {
        return this.f48854b;
    }

    /* renamed from: d */
    public void m61912d(String str, int i10) {
        if (this.f48853a.getModules().contains(str + i10)) {
            return;
        }
        this.f48853a.addModule(str + i10);
        C11839m.m70688i("CloudBackupV3Operate", "add module, appId = " + str + ", uid = " + i10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* renamed from: d0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m61913d0(com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus r8) throws fk.C9721b {
        /*
            r7 = this;
            java.lang.String r0 = r8.m29870d()
            int r1 = r8.m29859L()
            java.lang.String r2 = "CloudBackupV3Operate"
            switch(r1) {
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L41;
                case 4: goto L36;
                case 5: goto Le;
                case 6: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L5e
        Le:
            long r3 = r8.m29404g1()
            long r5 = r7.f48873u
            boolean r3 = r7.m61925j0(r3, r5)
            if (r3 == 0) goto L5f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "refresh app status: "
            r4.append(r5)
            java.lang.String r5 = r8.m29870d()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            p514o9.C11839m.m70688i(r2, r4)
            r7.m61940s0(r8)
            goto L5f
        L36:
            long r3 = r8.m29404g1()
            long r5 = r7.f48873u
            boolean r3 = r7.m61925j0(r3, r5)
            goto L5f
        L41:
            java.util.List<java.lang.String> r3 = r7.f48860h
            boolean r3 = r3.contains(r0)
            if (r3 != 0) goto L5e
            java.util.List<java.lang.String> r3 = r7.f48863k
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L53
            r3 = 0
            goto L5f
        L53:
            long r3 = r8.m29385X0()
            long r5 = r7.f48872t
            boolean r3 = r7.m61925j0(r3, r5)
            goto L5f
        L5e:
            r3 = 1
        L5f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r4 = "isNeedPrepareData: "
            r7.append(r4)
            r7.append(r3)
            java.lang.String r4 = " appId:"
            r7.append(r4)
            r7.append(r0)
            java.lang.String r0 = ",status:"
            r7.append(r0)
            r7.append(r1)
            java.lang.String r0 = " ,data: "
            r7.append(r0)
            long r0 = r8.m29385X0()
            r7.append(r0)
            java.lang.String r0 = " ,sd: "
            r7.append(r0)
            long r0 = r8.m29402f1()
            r7.append(r0)
            java.lang.String r0 = " ,module: "
            r7.append(r0)
            long r0 = r8.m29404g1()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            p514o9.C11839m.m70688i(r2, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: gm.C9989d.m61913d0(com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus):boolean");
    }

    /* renamed from: e */
    public void m61914e(CloudBackupStatus cloudBackupStatus, C9721b c9721b) {
        this.f48869q.put(cloudBackupStatus, c9721b);
        this.f48870r.add(cloudBackupStatus);
        this.f48866n.offerFirst(cloudBackupStatus);
    }

    /* renamed from: e0 */
    public final boolean m61915e0(C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        return 1104 == iM60659c || 1105 == iM60659c || 1106 == iM60659c || 1107 == iM60659c || 3900 == iM60659c;
    }

    /* renamed from: f */
    public final void m61916f() throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        Map<String, App> mapM29624A0 = this.f48853a.m29624A0();
        while (!this.f48866n.isEmpty()) {
            m61910b0();
            if (m61918g()) {
                if (this.f48853a.m29717j1(mapM29624A0, this.f48866n.peek())) {
                    arrayList.add(this.f48866n.poll());
                } else {
                    CloudBackupStatus cloudBackupStatusPoll = this.f48866n.poll();
                    m61912d(cloudBackupStatusPoll.m29870d(), cloudBackupStatusPoll.m29861N());
                    C11965e.m71974f().m71986o(cloudBackupStatusPoll.m29870d(), cloudBackupStatusPoll.m29861N());
                    this.f48853a.m29599v(cloudBackupStatusPoll.m29870d());
                    this.f48853a.m29600y(cloudBackupStatusPoll.m29861N());
                    this.f48853a.m29655O1();
                    m61910b0();
                    m61933p(cloudBackupStatusPoll);
                }
            } else {
                SystemClock.sleep(500L);
            }
        }
        List<CloudBackupStatus> listM61945v = m61945v(arrayList);
        if (listM61945v.size() > 0) {
            for (CloudBackupStatus cloudBackupStatus : listM61945v) {
                m61912d(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
                C11965e.m71974f().m71986o(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
            }
            this.f48853a.m29599v("");
            this.f48853a.m29600y(0);
            this.f48853a.m29655O1();
            C9525y c9525y = new C9525y(this.f48853a, listM61945v, mapM29624A0);
            C12182i.m73283j().m73285d(c9525y, listM61945v);
            this.f48853a.modulesAwait();
            m61910b0();
            if (c9525y.m59488b0() != null) {
                C9721b c9721bM59488b0 = c9525y.m59488b0();
                if (c9721bM59488b0.m60659c() != 1013) {
                    throw c9525y.m59488b0();
                }
                C11839m.m70688i("CloudBackupV3Operate", "cloudBackupV3Module3rdAppOperate process failed, exception = " + c9721bM59488b0.getMessage());
                Iterator<CloudBackupStatus> it = listM61945v.iterator();
                while (it.hasNext()) {
                    m61932o0(it.next(), c9721bM59488b0);
                }
            }
        }
        m61910b0();
        this.f48853a.modulesAwait();
    }

    /* renamed from: f0 */
    public boolean m61917f0() {
        return this.f48853a.m29726m1();
    }

    /* renamed from: g */
    public final boolean m61918g() {
        CloudBackupStatus cloudBackupStatusM61890H;
        if (C12182i.m73283j().m73296p()) {
            C11839m.m70686d("CloudBackupV3Operate", "cannot add module, inPrepareQueue not empty");
            return false;
        }
        int iM75405m = this.f48847C.m75405m();
        int iM73291k = C12182i.m73283j().m73291k();
        if (iM73291k >= iM75405m) {
            C11839m.m70686d("CloudBackupV3Operate", "cannot add module, backup module size = " + iM73291k);
            return false;
        }
        if (iM73291k > 0 && (cloudBackupStatusM61890H = m61890H(iM73291k - 1)) != null) {
            if (cloudBackupStatusM61890H.m29858I() == 3) {
                if (cloudBackupStatusM61890H.m29859L() <= 3) {
                    C11839m.m70686d("CloudBackupV3Operate", "batch upload, cannot add module, last module " + cloudBackupStatusM61890H.m29870d() + " uid = " + cloudBackupStatusM61890H.m29861N() + ", status = " + cloudBackupStatusM61890H.m29859L());
                    return false;
                }
            } else {
                if (cloudBackupStatusM61890H.m29859L() < 3 || cloudBackupStatusM61890H.m29860M() < 4) {
                    C11839m.m70686d("CloudBackupV3Operate", "cannot add module, last module " + cloudBackupStatusM61890H.m29870d() + " uid = " + cloudBackupStatusM61890H.m29861N() + ", status = " + cloudBackupStatusM61890H.m29859L());
                    return false;
                }
                if (cloudBackupStatusM61890H.m29860M() == 4 && !C12182i.m73283j().m73295o()) {
                    C11839m.m70686d("CloudBackupV3Operate", "cannot add module, last module " + cloudBackupStatusM61890H.m29870d() + " uid = " + cloudBackupStatusM61890H.m29861N() + ", type = " + cloudBackupStatusM61890H.m29860M());
                    return false;
                }
            }
        }
        if (!this.f48853a.m29752v0().isEmpty()) {
            C11839m.m70686d("CloudBackupV3Operate", "has failed modules, cannot prepare app data");
            return false;
        }
        if (!this.f48868p.isEmpty() && m61906X()) {
            CloudBackupStatus cloudBackupStatusPeek = this.f48866n.peek();
            if (this.f48868p.contains(cloudBackupStatusPeek)) {
                C11839m.m70686d("CloudBackupV3Operate", "exist running task, cannot prepare space failed app data, appId = " + cloudBackupStatusPeek.m29870d());
                return false;
            }
        }
        if (!this.f48853a.isAutoBackup() || !this.f48853a.m29684Y0()) {
            return true;
        }
        C11839m.m70686d("CloudBackupV3Operate", "abnormalAutobackupCondition, cannot prepare app data");
        return false;
    }

    /* renamed from: g0 */
    public final boolean m61919g0(String str, int i10) {
        try {
            String strM81914C = C13617a.m81914C(str, i10);
            if (!C10278a.m63442h(strM81914C).exists()) {
                return false;
            }
            PmsMetaStatusOperatorV3 pmsMetaStatusOperatorV3 = new PmsMetaStatusOperatorV3(strM81914C);
            if (pmsMetaStatusOperatorV3.isExistTable()) {
                return pmsMetaStatusOperatorV3.query() != null;
            }
            return false;
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackupV3Operate", "pmsMetaStatus CException: " + e10.toString());
            return false;
        }
    }

    /* renamed from: h */
    public final void m61920h(String str, long j10, boolean z10) throws C9721b {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace == null) {
            C11839m.m70689w("CloudBackupV3Operate", "checkModuleNeedLocalSize getLocalLeftSpace is null.");
            return;
        }
        long jM75856h0 = C12590s0.m75856h0();
        long j11 = j10 + jM75856h0;
        C11839m.m70688i("CloudBackupV3Operate", "checkLocalSapceIsEnough appId: " + str + ",needSize :" + j11 + " ,reservedSize: " + jM75856h0 + " ,localLeftSpace: " + localLeftSpace);
        if (j11 <= 0) {
            return;
        }
        long jLongValue = j11 - localLeftSpace.longValue();
        if (jLongValue <= 0 || !z10) {
            return;
        }
        C12590s0.m75777N2(jLongValue);
        throw new C9721b(1007, "checkModuleNeedLocalSize v3 appId: " + str + " needSize: " + j10 + " ,reservedSize: " + jM75856h0 + " localspace: " + localLeftSpace);
    }

    /* renamed from: h0 */
    public boolean m61921h0(CloudBackupStatus cloudBackupStatus) {
        return this.f48870r.contains(cloudBackupStatus) || this.f48868p.contains(cloudBackupStatus);
    }

    /* renamed from: i */
    public void m61922i(CloudBackupStatus cloudBackupStatus, Map<String, String> map) throws C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        boolean zM61917f0 = true;
        if (!"soundrecorder".equals(strM29870d) && !"callRecorder".equals(strM29870d)) {
            if (this.f48860h.contains(strM29870d)) {
                localTarNeedSize = cloudBackupStatus.m29875i();
            } else if (cloudBackupStatus.m29863P()) {
                if (cloudBackupStatus.m29419m1() && cloudBackupStatus.m29425o1() && PmsCheckUtil.m12611e()) {
                    localTarNeedSize = C12590s0.m75913v1(this.f48853a.isRefurbishment(), this.f48853a.mo29591n()) ? 0L : m61949x(cloudBackupStatus);
                    zM61917f0 = true ^ m61917f0();
                    localTarNeedSize = localTarNeedSize + m61947w(cloudBackupStatus) + ICBUtil.getLocalTarNeedSize(C1444b.m8308n());
                }
            } else if (cloudBackupStatus.m29867U()) {
                localTarNeedSize = ICBUtil.getLocalTarNeedSize(C1444b.m8308n());
            }
        }
        map.put("moduleLocalSpace", String.valueOf(localTarNeedSize));
        this.f48853a.m29670T1(localTarNeedSize);
        C11839m.m70688i("CloudBackupV3Operate", "checkModuleNeedLocalSize " + strM29870d + " needlocalspace : " + localTarNeedSize);
        m61920h(strM29870d, localTarNeedSize, zM61917f0);
    }

    /* renamed from: i0 */
    public boolean m61923i0(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        String strMo29421n = cloudBackupStatus.mo29421n();
        if (!this.f48861i.contains(strM29870d) || !cloudBackupStatus.m29863P()) {
            C11839m.m70688i("CloudBackupV3Operate", "not 3rd app, no need skip foreground, appId : " + strM29870d);
            return false;
        }
        if (!cloudBackupStatus.m29419m1() || !cloudBackupStatus.m29425o1()) {
            C11839m.m70688i("CloudBackupV3Operate", "not support backup app data, no need skip foreground, appId : " + strM29870d);
            return false;
        }
        if (!m61913d0(cloudBackupStatus)) {
            C11839m.m70688i("CloudBackupV3Operate", "not need prepare data, no need skip foreground, appId : " + strM29870d);
            return false;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (!ICBUtil.isForGroundProcess(strMo29421n, m61885C(), cloudBackupStatus.m29861N(), atomicInteger)) {
            m61950x0(strM29870d, "backGround", atomicInteger.get());
            return false;
        }
        m61950x0(strM29870d, "foreGround", atomicInteger.get());
        if (!this.f48867o.contains(cloudBackupStatus) && !cloudBackupAppDataUtil.isDirectlyBackupForegroundApp()) {
            C11839m.m70688i("CloudBackupV3Operate", "is foreground process = " + strM29870d);
            this.f48867o.add(cloudBackupStatus);
            return true;
        }
        if (cloudBackupAppDataUtil.isBackupForegroundApp()) {
            return false;
        }
        cloudBackupStatus.mo29338z0(0).mo29289A0(0).m29374R1(0L).m29342C1(0L).m29423n2(0L).m29436s2(0L).mo29310W(0).mo29308V(0L);
        this.f48848D.m76934m(cloudBackupStatus);
        C11963c.m71970y(cloudBackupStatus, this.f48855c);
        C11839m.m70687e("CloudBackupV3Operate", "backup error, isForeGroundProcess = " + strM29870d + " , uid : " + cloudBackupStatus.m29861N());
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, "ForeGroundProcess is running: " + strM29870d + " , uid : " + cloudBackupStatus.m29861N() + " ,importance: " + atomicInteger.get());
    }

    /* renamed from: j */
    public final void m61924j() {
        if (this.f48862j.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Operate", "checkSafeBoxIntegrity, virtualModules is empty");
        } else if (this.f48862j.contains("safebox") || this.f48862j.contains("safebox1")) {
            C12590s0.m75906t2();
        } else {
            C11839m.m70688i("CloudBackupV3Operate", "checkSafeBoxIntegrity, no SafeBox Module");
        }
    }

    /* renamed from: j0 */
    public final boolean m61925j0(long j10, long j11) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        return j10 <= 0 || jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= j11;
    }

    /* renamed from: k */
    public final List<BackupItem> m61926k(List<BackupItem> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackupItem backupItem = (BackupItem) it.next();
            if (backupItem != null && SplitAppUtil.hasSplitAppSuffix(backupItem.m29870d())) {
                String splitAppType = SplitAppUtil.getSplitAppType(backupItem.m29870d());
                backupItem.mo29413k0(SplitAppUtil.getSplitOriAppId(backupItem.m29870d()));
                backupItem.mo29452y0(splitAppType);
                List arrayList2 = map.get(backupItem.mo29421n()) != null ? (List) map.get(backupItem.mo29421n()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(backupItem);
                    map.put(backupItem.mo29421n(), arrayList2);
                }
                it.remove();
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: gm.b
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C9989d.m61879k0(str, (BackupItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    Object obj = optionalFindFirst.get();
                    List list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: gm.c
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                return C9989d.m61880l0((BackupItem) obj2, (BackupItem) obj3);
                            }
                        });
                        list.removeAll(list2);
                        list.addAll(list.indexOf(obj) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* renamed from: l */
    public void m61927l(String str, String str2, int i10) {
        String str3 = m61891I() + File.separator + str;
        String strM61888F = m61888F(str, i10);
        String strM61887E = m61887E(str, i10);
        C13216j.m79422g(C13617a.m81914C(str, i10));
        C12571m.m75547i(str3);
        C12571m.m75547i(strM61888F);
        C12571m.m75547i(strM61887E);
        C12571m.m75547i(C12586r.m75714e(str, i10));
        if (i10 != 0) {
            C12571m.m75547i(C12583q.m75686v(m61891I(), i10, str2));
            C12571m.m75547i(C12583q.m75653G(str2));
            C12571m.m75547i(C12586r.m75714e(str2, i10));
        }
        C12571m.m75547i(C12583q.m75673i(str));
        C12571m.m75547i(m61902T(str, i10));
        BackupCacheRecord.delete(m61885C(), str);
        C11839m.m70688i("CloudBackupV3Operate", "delete module cache end, appId = " + str + " uid = " + i10);
    }

    /* renamed from: m */
    public final void m61928m(String str, int i10) {
        C12571m.m75547i(m61891I() + File.separator + str);
        C12571m.m75547i(m61902T(str, i10));
        BackupCacheRecord.delete(m61885C(), str);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$List] */
    /* renamed from: m0 */
    public final /* synthetic */ CloudBackupV3Request m61929m0(boolean z10, String str, Lock lock, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.List list = cloudBackupV3Server.backup().device().file().list(String.valueOf(z10));
        list.setFields("nextCursor,files").setCursor(str).setBackupAction(this.f48855c).setBackupDeviceId(this.f48856d).setPageSize(100).setLockId(lock.getLockId());
        return list;
    }

    /* renamed from: n */
    public void m61930n(String str, String str2, int i10) throws C9721b {
        CloudBackupStatus cloudBackupStatusM76017t;
        try {
            cloudBackupStatusM76017t = this.f48849E.m76017t(str, i10, this.f48855c);
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackupV3Operate", "deleteOneModuleCache no rootnode appId:" + str + " ,e: " + e10.toString());
            cloudBackupStatusM76017t = null;
        }
        if (cloudBackupStatusM76017t == null) {
            C11839m.m70688i("CloudBackupV3Operate", "deleteModuleCache cloudBackupStatus is null: " + str);
            m61927l(str, str2, i10);
            return;
        }
        if (m61913d0(cloudBackupStatusM76017t)) {
            boolean zM29863P = cloudBackupStatusM76017t.m29863P();
            boolean zM61919g0 = m61919g0(str, cloudBackupStatusM76017t.m29861N());
            C11839m.m70688i("CloudBackupV3Operate", "deleteOneModuleTemp deleteModuleCache: " + str + "isPmsSupportIncrement :" + zM61919g0);
            if (zM29863P && zM61919g0) {
                m61928m(str, i10);
            } else {
                m61927l(str, str2, i10);
            }
        }
    }

    /* renamed from: o */
    public final void m61931o() {
        if (this.f48867o.isEmpty()) {
            return;
        }
        for (CloudBackupStatus cloudBackupStatus : this.f48867o) {
            C11839m.m70688i("CloudBackupV3Operate", "process foreground app again, appId  = " + cloudBackupStatus.m29870d() + ", add result = " + this.f48866n.offer(cloudBackupStatus));
        }
    }

    /* renamed from: o0 */
    public void m61932o0(CloudBackupStatus cloudBackupStatus, C9721b c9721b) throws C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        synchronized (f48844I) {
            try {
                C11839m.m70688i("CloudBackupV3Operate", "process failed module, appId = " + strM29870d + " ,backupStatus: " + cloudBackupStatus.toString());
                if (m61921h0(cloudBackupStatus)) {
                    m61910b0();
                    C11839m.m70688i("CloudBackupV3Operate", "is retried module, appId = " + strM29870d + " ,backupStatus: " + cloudBackupStatus.toString());
                    this.f48853a.m29656P(cloudBackupStatus, c9721b);
                    throw c9721b;
                }
                m61910b0();
                m61914e(cloudBackupStatus, c9721b);
                C11839m.m70688i("CloudBackupV3Operate", "catch exception, add retry module = " + strM29870d);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public final void m61933p(CloudBackupStatus cloudBackupStatus) {
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        C11839m.m70688i("CloudBackupV3Operate", "one module backup start, appId = " + strM29870d + ", uid = " + iM29861N);
        C12182i.m73283j().m73285d(new C9215i0(this.f48853a, this, cloudBackupStatus, strM29870d, iM29861N), Collections.singletonList(cloudBackupStatus));
        SystemClock.sleep(50L);
    }

    /* renamed from: p0 */
    public void m61934p0() throws C9721b, PackageManager.NameNotFoundException {
        Map<CloudBackupStatus, C9721b> mapM29752v0 = this.f48853a.m29752v0();
        if (mapM29752v0.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<CloudBackupStatus, C9721b>> it = mapM29752v0.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<CloudBackupStatus, C9721b> next = it.next();
            CloudBackupStatus key = next.getKey();
            String strM29870d = key.m29870d();
            C9721b value = next.getValue();
            int iM60659c = value.m60659c();
            if ((iM60659c == 1013 || iM60659c == 1005 || iM60659c == 1006) && !m61921h0(key)) {
                m61930n(strM29870d, key.mo29421n(), key.m29861N());
                it.remove();
                m61914e(key, value);
                C11839m.m70686d("CloudBackupV3Operate", "isCancel skip, add retryModules = " + strM29870d);
                return;
            }
            if (this.f48853a.m29729n1() && m61915e0(value)) {
                C11839m.m70686d("CloudBackupV3Operate", "isCancel skip, isPrepareData, failed appId = " + strM29870d);
                return;
            }
            if (m61906X() && 3001 != value.m60659c()) {
                C11839m.m70686d("CloudBackupV3Operate", "isCancel skip, hasRunningBackupTasks, failed appId = " + strM29870d);
                return;
            }
            m61930n(strM29870d, key.mo29421n(), key.m29861N());
            if (3001 == value.m60659c()) {
                if (this.f48865m != null) {
                    C11839m.m70688i("CloudBackupV3Operate", "refreshModuleBackupSize: " + strM29870d);
                    m61942t0(key);
                }
                C11839m.m70687e("CloudBackupV3Operate", "isCancel, CBError.NOSPACE exception, failed appId = " + strM29870d);
                C12590s0.m75759J0(this.f48853a.m29643I0(), this.f48865m, m61885C(), this.f48855c.equals("auto"), this.f48853a.m29640H0(), true, "2");
            }
            if (!C14339h.m85510i().contains(Integer.valueOf(value.m60659c()))) {
                throw value;
            }
            this.f48853a.m29599v(strM29870d);
            this.f48853a.m29600y(key.m29861N());
            C11839m.m70686d("CloudBackupV3Operate", "FileChangeError: " + value + " ,appId: " + strM29870d);
            throw value;
        }
    }

    /* renamed from: q */
    public final void m61935q() {
        if (this.f48871s.isEmpty()) {
            return;
        }
        for (CloudBackupStatus cloudBackupStatus : this.f48871s) {
            C11839m.m70688i("CloudBackupV3Operate", "process overdue app again, appId  = " + cloudBackupStatus.m29870d() + ", add result = " + this.f48866n.offer(cloudBackupStatus));
        }
    }

    /* renamed from: q0 */
    public final FileList m61936q0(C1457c c1457c, final boolean z10, final String str) throws C9721b {
        final Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.files.list");
        }
        FileList fileList = (FileList) new C14000c0(new C14000c0.a() { // from class: gm.a
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f48838a.m61929m0(z10, str, lockMo8329d, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.files.list", this.f48858f);
        C11839m.m70686d("CloudBackupV3Operate", "queryFilesLostList , fileList = " + fileList);
        return fileList;
    }

    /* renamed from: r */
    public final void m61937r() throws C9721b {
        Lock lockMo8329d;
        List<App> listM29653N1;
        if (this.f48853a.isRefurbishment() || this.f48853a.mo29591n()) {
            return;
        }
        if (!this.f48877y.isEmpty()) {
            this.f48877y.clear();
        }
        C11839m.m70686d("CloudBackupV3Operate", "doQueryLostAppList start");
        try {
            C4879a c4879a = this.f48853a;
            if (c4879a == null || c4879a.m29728n0() == null || this.f48853a.m29728n0().mo8329d() == null || (lockMo8329d = this.f48853a.m29728n0().mo8329d()) == null || (listM29653N1 = this.f48853a.m29653N1(lockMo8329d.getLockId())) == null || listM29653N1.isEmpty()) {
                return;
            }
            for (App app : listM29653N1) {
                if (app != null && !TextUtils.isEmpty(app.getBackupAppName())) {
                    C11839m.m70686d("CloudBackupV3Operate", "doQueryLostAppList appName = " + app.getBackupAppName() + " status = " + app.getBackupAppStatus());
                    int iIntValue = app.getBackupAppStatus().intValue();
                    if (iIntValue == 2 || iIntValue == 3) {
                        this.f48877y.put(app.getBackupAppName(), app);
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Operate", "doQueryLostAppList error: " + e10.getMessage());
            CloudBackupReport.reportLostAppRequestErr(this.f48858f, e10.getMessage());
        }
    }

    /* renamed from: r0 */
    public void m61938r0(String str, long j10, C12164f c12164f) {
        try {
            this.f48846B += j10;
            long jM73088k0 = c12164f.m73088k0(String.valueOf(5));
            long jM73088k02 = c12164f.m73088k0(String.valueOf(6));
            this.f48876x = this.f48876x + jM73088k0 + jM73088k02;
            C11839m.m70688i("CloudBackupV3Operate", "recordReportSize appId: " + str + " nuSize: " + j10 + " ,cbSize: " + jM73088k0 + " ,sbSize: " + jM73088k02);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Operate", "recordReportSizeBeforeUpload error: " + e10.toString());
        }
    }

    /* renamed from: s */
    public final void m61939s(C1457c c1457c, boolean z10) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        if (this.f48853a.isRefurbishment() || this.f48853a.mo29591n()) {
            return;
        }
        C12814e c12814e = new C12814e();
        c12814e.m76914a();
        if (this.f48853a.m29699d1() || this.f48853a.isRefurbishment()) {
            C11839m.m70688i("CloudBackupV3Operate", "doQueryLostFileList isFullBK or isRefurbishment");
            return;
        }
        m61910b0();
        try {
            ArrayList arrayList = new ArrayList();
            C11839m.m70688i("CloudBackupV3Operate", "doQueryLostFileList start");
            String nextCursor = null;
            do {
                m61910b0();
                FileList fileListM61936q0 = m61936q0(c1457c, z10, nextCursor);
                List<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> files = fileListM61936q0.getFiles();
                if (files != null && !files.isEmpty()) {
                    for (com.huawei.hicloud.cloudbackup.p104v3.server.model.File file : files) {
                        C12813d c12813d = new C12813d();
                        int fileStatus = file.getFileStatus();
                        if (fileStatus == 2 || fileStatus == 3) {
                            c12813d.m76912x(file);
                            if (!TextUtils.isEmpty(c12813d.m76896h()) || !TextUtils.isEmpty(c12813d.m76890b())) {
                                arrayList.add(c12813d);
                            }
                        }
                    }
                    try {
                        c12814e.batchReplace(arrayList);
                    } catch (C9721b e10) {
                        C11839m.m70687e("CloudBackupV3Operate", "doQueryLostFileList error: " + e10.getMessage());
                    }
                    arrayList.clear();
                }
                nextCursor = fileListM61936q0.getNextCursor();
            } while (!TextUtils.isEmpty(nextCursor));
        } catch (C9721b e11) {
            C11839m.m70687e("CloudBackupV3Operate", "doQueryLostFileList error: " + e11.getMessage());
            CloudBackupReport.reportLostFileRequestErr(this.f48858f, e11.getMessage());
        }
        C11839m.m70688i("CloudBackupV3Operate", "doQueryLostFileList end");
    }

    /* renamed from: s0 */
    public final void m61940s0(CloudBackupStatus cloudBackupStatus) throws C9721b {
        HashMap map = new HashMap();
        map.put("snapshotvalidflag", FeedbackConst.SDK.INVALID_ACCESS_TOKEN);
        AppRefresh appRefresh = new AppRefresh();
        appRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setBackupAppStatus(1);
        appRefresh.setProperties((Map<String, String>) map);
        if (new C10321z(this.f48855c, this.f48853a.m29636F0(), this.f48853a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f48858f).m63582x0(this.f48853a.m29728n0(), this.f48856d, this.f48857e, cloudBackupStatus.m29398d1(), cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), appRefresh, 0).getBackupAppStatus().intValue() == 1) {
            return;
        }
        throw new C9721b(3911, "Backup.device.bak.app.refresh error. backupAppId = " + cloudBackupStatus.m29398d1(), "Backup.device.bak.app.refresh");
    }

    /* renamed from: t */
    public final void m61941t() {
        if (this.f48868p.isEmpty()) {
            return;
        }
        this.f48866n.addAll(this.f48868p);
    }

    /* renamed from: t0 */
    public void m61942t0(CloudBackupStatus cloudBackupStatus) throws PackageManager.NameNotFoundException {
        String strM29870d = cloudBackupStatus.m29870d();
        Iterator<Long> it = this.f48850F.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        Iterator<Long> it2 = this.f48851G.values().iterator();
        long jLongValue2 = 0;
        while (it2.hasNext()) {
            jLongValue2 += it2.next().longValue();
        }
        if (jLongValue2 <= 0 && cloudBackupStatus.m29863P()) {
            long jM61947w = m61947w(cloudBackupStatus);
            jLongValue2 += jM61947w;
            C11839m.m70688i("CloudBackupV3Operate", "refreshModuleBackupSize appid: " + strM29870d + " apkSize: " + jM61947w);
        }
        cloudBackupStatus.m29861N();
        C11839m.m70686d("CloudBackupV3Operate", String.format(Locale.ENGLISH, "complete calculate %s, total size is %s, increment size is %s", strM29870d, Long.valueOf(jLongValue), Long.valueOf(jLongValue2)));
        this.f48865m.m78456V(String.valueOf(jLongValue2));
        this.f48865m.m78473p0(jLongValue);
        try {
            Long l10 = this.f48851G.get(strM29870d);
            if (l10 != null && l10.longValue() > 0) {
                new C13026e(this.f48853a.isRefurbishment()).m78372G(l10.longValue(), strM29870d);
            }
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Operate", "database error occurred when update the data1: " + e10.toString());
        }
        new C13030i().m78496g(this.f48865m);
    }

    /* renamed from: u */
    public void m61943u() throws C9721b {
        C11839m.m70688i("CloudBackupV3Operate", "cloud backup v3 operate start.");
        m61910b0();
        m61909a0();
        m61910b0();
        C14317j.m85301e(this.f48855c).m85318s(1, CBSBaseReq.CURRENT_API_VERSION);
        if (this.f48853a.isRefurbishment()) {
            C12591s1.m75931a().m75946p(false);
            ICBBroadcastManager.sendCloudBackupStateBroadcast(1, this.f48865m.m78465h(), false);
        } else if (!this.f48853a.mo29591n()) {
            m61881n0();
        }
        C11965e.m71974f().m71981j(true, this.f48853a.m29589l(), this.f48866n, this.f48853a.m29713i0(), this.f48853a.m29722l0().mo1759d());
        boolean zIsAutoBackup = this.f48853a.isAutoBackup();
        this.f48872t = this.f48847C.m75408n0(zIsAutoBackup);
        this.f48873u = this.f48847C.m75406m0(zIsAutoBackup);
        this.f48874v = this.f48847C.m75410o0(zIsAutoBackup);
        this.f48853a.m29742r2(this.f48847C.m75404l0());
        m61939s(this.f48853a.m29728n0(), true);
        m61937r();
        m61916f();
        C11839m.m70688i("CloudBackupV3Operate", "cloud backup v3 prepare apps data end");
        m61910b0();
        m61941t();
        m61910b0();
        m61935q();
        m61910b0();
        m61931o();
        m61910b0();
        m61916f();
        m61910b0();
        m61931o();
        m61910b0();
        m61916f();
        m61910b0();
        C11839m.m70688i("CloudBackupV3Operate", "cloud backup v3 operate end");
    }

    /* renamed from: u0 */
    public void m61944u0(CloudBackupStatus cloudBackupStatus) {
        this.f48867o.remove(cloudBackupStatus);
        this.f48868p.remove(cloudBackupStatus);
        this.f48853a.removeModule(cloudBackupStatus.m29870d() + cloudBackupStatus.m29861N());
    }

    /* renamed from: v */
    public final List<CloudBackupStatus> m61945v(List<CloudBackupStatus> list) {
        ArrayList arrayList = new ArrayList();
        for (CloudBackupStatus cloudBackupStatus : list) {
            String strM29870d = cloudBackupStatus.m29870d();
            if (C0209d.m1184K0(m61885C(), cloudBackupStatus.mo29421n())) {
                arrayList.add(cloudBackupStatus);
            } else {
                C11963c.m71964s(strM29870d, cloudBackupStatus.m29861N(), this.f48853a.m29713i0());
                new C9195d0(this.f48853a, cloudBackupStatus).m57745g("module_delete_from_app_uninstall");
                C11839m.m70688i("CloudBackupV3Operate", "process not backup module, appId = " + strM29870d + ", uid = " + cloudBackupStatus.m29861N());
            }
        }
        return arrayList;
    }

    /* renamed from: v0 */
    public void m61946v0(String str, int i10) {
        this.f48853a.removeModule(str + i10);
        C11839m.m70688i("CloudBackupV3Operate", "remove module, appId = " + str + ", uid = " + i10);
    }

    /* renamed from: w */
    public final long m61947w(CloudBackupStatus cloudBackupStatus) throws PackageManager.NameNotFoundException {
        String strM29870d = cloudBackupStatus.m29870d();
        String strMo29421n = cloudBackupStatus.mo29421n();
        long dirSize = ScanAppDataUtil.getDirSize(C10278a.m63442h(m61891I() + java.io.File.separator + strM29870d));
        if (dirSize > 0) {
            return dirSize;
        }
        C12810a c12810aM76879d = new C12811b().m76879d(strM29870d, "apk");
        if (c12810aM76879d != null) {
            return c12810aM76879d.m76861l();
        }
        long jM82323a = C13694a.m82323a(m61885C(), strMo29421n);
        C11839m.m70688i("CloudBackupV3Operate", "getApkSize attach is empty apksize: " + jM82323a + " ,appId: " + strM29870d);
        return jM82323a;
    }

    /* renamed from: w0 */
    public void m61948w0(CloudBackupStatus cloudBackupStatus) {
        this.f48869q.remove(cloudBackupStatus);
    }

    /* renamed from: x */
    public final long m61949x(CloudBackupStatus cloudBackupStatus) {
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        if (!m61919g0(strM29870d, iM29861N)) {
            return ScanAppDataUtil.get3rdAppDataDirSize(cloudBackupStatus.mo29421n(), iM29861N);
        }
        long jQuerySumToCopySize = new PmsFullBriefFilesInfoOperatorV3(C13617a.m81914C(strM29870d, iM29861N)).querySumToCopySize();
        if (jQuerySumToCopySize <= 0) {
            return ScanAppDataUtil.get3rdAppDataDirSize(cloudBackupStatus.mo29421n(), iM29861N);
        }
        C11839m.m70686d("CloudBackupV3Operate", "appId: " + strM29870d + " pms default size: " + jQuerySumToCopySize);
        return jQuerySumToCopySize;
    }

    /* renamed from: x0 */
    public final void m61950x0(String str, String str2, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strM66627b = C11058a.m66627b("02014");
        linkedHashMap.put("backupTransID", this.f48858f);
        linkedHashMap.put("appId", str);
        linkedHashMap.put("status", str2);
        linkedHashMap.put("importance", String.valueOf(i10));
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, str2, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    /* renamed from: y */
    public String m61951y() {
        return this.f48855c;
    }

    /* renamed from: y0 */
    public void m61952y0(long j10) {
        this.f48875w = j10;
    }

    /* renamed from: z */
    public Map<String, Bundle> m61953z() {
        return this.f48864l;
    }

    /* renamed from: z0 */
    public void m61954z0(long j10) {
        this.f48878z = j10;
    }
}
