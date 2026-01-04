package com.huawei.hicloud.cloudbackup.p104v3.core;

import am.C0295r;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cl.InterfaceC1450e;
import cm.C1460f;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreFailInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempOperator;
import com.huawei.android.hicloud.cloudbackup.process.C2543k0;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.service.C4877a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import gm.C10000i0;
import gm.C9992e0;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hm.C10309n0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mk.C11476b;
import p015ak.C0224k0;
import p015ak.C0241z;
import p336he.C10153d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p523oi.C11903a;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p682ul.C13216j;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p744wl.C13617a;
import p746wn.C13622a;
import p771xd.C13757a;
import p814yl.C13998b0;
import p847zk.C14317j;
import p848zl.C14333b;
import pm.C12176c;
import pm.C12187n;
import pm.C12188o;
import sl.C12810a;
import sl.C12811b;
import sl.C12816g;
import tl.C13027f;
import tl.C13028g;
import tl.C13029h;
import tl.C13030i;

/* renamed from: com.huawei.hicloud.cloudbackup.v3.core.b */
/* loaded from: classes6.dex */
public class C4880b extends ICBBaseV3Task {

    /* renamed from: Z */
    public static final Object f22505Z = new Object();

    /* renamed from: a0 */
    public static final Object f22506a0 = new Object();

    /* renamed from: D */
    public final String f22510D;

    /* renamed from: I */
    public boolean f22515I;

    /* renamed from: J */
    public boolean f22516J;

    /* renamed from: K */
    public String f22517K;

    /* renamed from: L */
    public String f22518L;

    /* renamed from: M */
    public String f22519M;

    /* renamed from: O */
    public C9992e0 f22521O;

    /* renamed from: T */
    public final boolean f22526T;

    /* renamed from: m */
    public C13029h f22534m;

    /* renamed from: n */
    public final String f22535n;

    /* renamed from: o */
    public int f22536o;

    /* renamed from: p */
    public final boolean f22537p;

    /* renamed from: q */
    public final boolean f22538q;

    /* renamed from: u */
    public C1460f f22542u;

    /* renamed from: v */
    public Lock f22543v;

    /* renamed from: w */
    public String f22544w;

    /* renamed from: x */
    public long f22545x = 0;

    /* renamed from: y */
    public long f22546y = 0;

    /* renamed from: z */
    public boolean f22547z = false;

    /* renamed from: A */
    public boolean f22507A = false;

    /* renamed from: B */
    public boolean f22508B = true;

    /* renamed from: C */
    public boolean f22509C = true;

    /* renamed from: E */
    public long f22511E = 0;

    /* renamed from: F */
    public boolean f22512F = false;

    /* renamed from: G */
    public final Object f22513G = new Object();

    /* renamed from: H */
    public List<CloudRestoreStatusV3> f22514H = new ArrayList();

    /* renamed from: P */
    public final C13028g f22522P = new C13028g();

    /* renamed from: Q */
    public final C13027f f22523Q = new C13027f();

    /* renamed from: R */
    public boolean f22524R = false;

    /* renamed from: S */
    public boolean f22525S = false;

    /* renamed from: U */
    public volatile boolean f22527U = false;

    /* renamed from: V */
    public List<String> f22528V = new ArrayList();

    /* renamed from: W */
    public List<String> f22529W = new ArrayList();

    /* renamed from: X */
    public boolean f22530X = false;

    /* renamed from: Y */
    public List<String> f22531Y = new ArrayList();

    /* renamed from: N */
    public int f22520N = C13452e.m80781L().m80978v();

    /* renamed from: k */
    public final Context f22532k = CacheTask.getContext();

    /* renamed from: s */
    public final String f22540s = getLocation();

    /* renamed from: t */
    public String f22541t = ICBUtil.getHwCloudApkInstallCachePath();

    /* renamed from: l */
    public final String f22533l = C11058a.m66627b("02003");

    /* renamed from: r */
    public final boolean f22539r = isGoogleGmsInstalled();

    /* renamed from: com.huawei.hicloud.cloudbackup.v3.core.b$a */
    public static class a implements CacheTask.IAsyncTask {
        @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask.IAsyncTask
        public void run() {
            RestoreUtil.setLastSuccessTime();
        }
    }

    public C4880b(String str, String str2, String str3, int i10, boolean z10, boolean z11, String str4, boolean z12) {
        this.f22519M = str;
        this.f22518L = str2;
        this.f22535n = str3;
        this.f22536o = i10;
        this.f22537p = z10;
        this.f22538q = z11;
        this.f22517K = str4;
        this.f22526T = z12;
        this.f22510D = C13617a.m81916E(str3);
        ICBUtil.dealSystemModules(this.f22528V, this.f22529W, isFromOOBE());
    }

    private boolean isGoogleGmsInstalled() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f22532k.getPackageManager().getPackageInfo(Constants.GMS_PGK, 16384);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            packageInfo = null;
        }
        boolean z10 = (packageInfo == null || TextUtils.isEmpty(C0224k0.a.m1573b("ro.com.google.gmsversion", ""))) ? false : true;
        C11839m.m70688i("CloudRestoreV3Task", "isGoogleGmsInstalled = " + z10);
        return z10;
    }

    private void lock() throws InterruptedException, C9721b {
        C1460f c1460f = new C1460f(this.f22533l, this.f22519M, this.f22535n);
        this.f22542u = c1460f;
        try {
            this.f22543v = c1460f.m8354k(new C0295r(this));
            isCancel();
            this.f22542u.m8328c();
        } catch (C9721b e10) {
            if (e10.m60659c() != 3911 || !String.valueOf(e10.m60663g()).endsWith(String.valueOf(4041))) {
                throw e10;
            }
            throw new C9721b(3109, "lock 404, record is not exist");
        }
    }

    private C13029h queryTags() throws C9721b {
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(3);
        if (c13029hM78495f == null) {
            c13029hM78495f = createTags();
        } else if (this.f22537p) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            c13029hM78495f.m78483u0(this.f22533l);
            c13029hM78495f.m78450P(jCurrentTimeMillis);
        } else {
            c13030i.m78490a(3);
            c13029hM78495f = createTags();
        }
        c13030i.m78497h(c13029hM78495f);
        return c13029hM78495f;
    }

    /* renamed from: A0 */
    public final void m29766A0() {
        C1460f c1460f;
        synchronized (f22506a0) {
            try {
                c1460f = this.f22542u;
                if (c1460f != null) {
                    this.f22542u = null;
                } else {
                    c1460f = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c1460f == null) {
            C11839m.m70688i("CloudRestoreV3Task", "unlock restoreLockTemp is empty");
        } else {
            c1460f.m8353j();
        }
    }

    /* renamed from: B0 */
    public final void m29767B0(boolean z10) {
        C13467g.m81086c().m81093h("refurbish_restore_notify" + C11476b.m68626h(C13452e.m80781L().m80971t0()), z10);
    }

    /* renamed from: C */
    public final void m29768C(BakRefresh.Summary summary, C12816g c12816g) throws C9721b {
        List<CloudRestoreStatusV3> listM76945i = c12816g.m76945i();
        if (listM76945i.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CloudRestoreStatusV3> it = listM76945i.iterator();
        long j10 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CloudRestoreStatusV3 next = it.next();
            if (!next.is3rdAppType() || next.m29498s() != 0) {
                long size = next.getSize() + next.getAsize();
                String str = next.getAppName() + '&' + next.getCount() + '&' + size;
                j10 += size;
                if (arrayList.toString().length() + str.length() >= ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
                    C11839m.m70688i("CloudRestoreV3Task", "current modules length over 4kb, not report." + next.getAppId());
                    summary.setMessage("current modules length over 4kb, not report.");
                    break;
                }
                arrayList.add(str);
            }
        }
        C11839m.m70688i("CloudRestoreV3Task", "modules length: " + arrayList.toString().length());
        summary.setTotalSize(Long.valueOf(j10)).setAppCount(Long.valueOf((long) listM76945i.size())).setAppList(arrayList);
    }

    /* renamed from: D */
    public final void m29769D(BakRefresh.Summary summary, boolean z10, C12816g c12816g) throws C9721b {
        List<CloudRestoreStatusV3> listM76945i = c12816g.m76945i();
        if (listM76945i.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        long j10 = 0;
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : listM76945i) {
            if (z10 || cloudRestoreStatusV3.getStatus() != 8 || cloudRestoreStatusV3.getType() != 1) {
                long size = cloudRestoreStatusV3.getSize() + cloudRestoreStatusV3.getAsize();
                String str = cloudRestoreStatusV3.getAppName() + '&' + cloudRestoreStatusV3.getAppId() + '&' + cloudRestoreStatusV3.getStatus() + '&' + cloudRestoreStatusV3.getType() + '&' + size + '&' + cloudRestoreStatusV3.m29474O() + '&' + cloudRestoreStatusV3.getMessage();
                j10 += size;
                if (arrayList.toString().length() + str.length() < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
                    arrayList.add(str);
                } else {
                    C11839m.m70688i("CloudRestoreV3Task", "current modules length over 4kb, not report : " + cloudRestoreStatusV3.getAppId());
                }
            }
        }
        C11839m.m70688i("CloudRestoreV3Task", "modules length: " + arrayList.toString().length());
        summary.setTotalSize(Long.valueOf(j10)).setAppList(arrayList);
    }

    /* renamed from: E */
    public final void m29770E() {
        C13029h c13029h;
        if (!this.f22537p || this.f22538q || (c13029h = this.f22534m) == null) {
            C11839m.m70689w("CloudRestoreV3Task", "checkRestoreRetryCount !isRetry || isResumeRetry || tags == null");
            return;
        }
        if (c13029h.m78441G() == 4) {
            C11839m.m70688i("CloudRestoreV3Task", "checkRestoreRetryCount restore done");
            return;
        }
        if (m29792a0()) {
            C13029h c13029h2 = this.f22534m;
            c13029h2.m78453S(c13029h2.m78476r() + 1);
            new C13030i().m78496g(this.f22534m);
        }
        if (ICBUtil.isRestoreRetryTimeExpires(this.f22534m.m78440F())) {
            updateTagsStatus(4);
        }
    }

    /* renamed from: F */
    public final void m29771F(int i10, int i11) {
        RestoreNotification restoreNotification = RestoreNotification.getInstance();
        float fM80911f0 = C13452e.m80781L().m80911f0();
        C11839m.m70688i("CloudRestoreV3Task", "sendRestoreNotification status = " + i10 + "  restoreProgress = " + fM80911f0);
        switch (i10) {
            case 1:
                restoreNotification.sendRestoreNotification();
                break;
            case 2:
            case 3:
                C13452e.m80781L().m80909e3(100.0f);
                restoreNotification.completedNotification(100.0f, i10, i11, RestoreUtil.isNewBmRecord());
                break;
            case 4:
            case 5:
            case 7:
                restoreNotification.completedNotification(fM80911f0, i10, i11, RestoreUtil.isNewBmRecord());
                break;
            case 6:
                restoreNotification.showNetErrNotification(fM80911f0);
                break;
            case 8:
                restoreNotification.cancelNotification();
                break;
        }
    }

    /* renamed from: G */
    public String m29772G() {
        return this.f22519M;
    }

    /* renamed from: H */
    public String m29773H() {
        return this.f22518L;
    }

    /* renamed from: I */
    public String m29774I() {
        return this.f22544w;
    }

    /* renamed from: J */
    public boolean m29775J() {
        return this.f22524R;
    }

    /* renamed from: K */
    public C1460f m29776K() {
        return this.f22542u;
    }

    /* renamed from: L */
    public long m29777L() {
        return this.f22511E;
    }

    /* renamed from: M */
    public long m29778M() {
        return this.f22545x;
    }

    /* renamed from: N */
    public String m29779N() {
        return this.f22510D;
    }

    /* renamed from: O */
    public Object m29780O() {
        return this.f22513G;
    }

    /* renamed from: P */
    public List<CloudRestoreStatusV3> m29781P() {
        return this.f22514H;
    }

    /* renamed from: Q */
    public long m29782Q() {
        return this.f22546y;
    }

    /* renamed from: R */
    public String m29783R() {
        return this.f22533l;
    }

    /* renamed from: S */
    public final void m29784S() {
        if (mo29590m()) {
            this.f22427g = "2";
        } else if (mo29591n()) {
            this.f22427g = "3";
        }
    }

    /* renamed from: T */
    public final boolean m29785T(List<CloudRestoreStatusV3> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<CloudRestoreStatusV3> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getStatus() == -3) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: U */
    public final boolean m29786U(int i10) {
        if (3109 != i10 && 3110 != i10) {
            return false;
        }
        C11839m.m70689w("CloudRestoreV3Task", "not need retry, errorCode: " + i10);
        return true;
    }

    /* renamed from: V */
    public final boolean m29787V() {
        return getErrCode() == 3920;
    }

    /* renamed from: W */
    public boolean m29788W() {
        return this.f22539r;
    }

    /* renamed from: X */
    public boolean m29789X() {
        return this.f22512F;
    }

    /* renamed from: Y */
    public boolean m29790Y() {
        return this.f22516J;
    }

    /* renamed from: Z */
    public boolean m29791Z() {
        return this.f22547z;
    }

    /* renamed from: a0 */
    public final boolean m29792a0() {
        boolean zIsModuleIgnoreRetryErr = isModuleIgnoreRetryErr();
        boolean zIsIgnoreRetryErr = RestoreUtil.isIgnoreRetryErr(this.exception);
        C11839m.m70688i("CloudRestoreV3Task", "isNeedCountRetry moduleHasServerErr: " + zIsModuleIgnoreRetryErr + " ,ignoreRetryErr: " + zIsIgnoreRetryErr);
        return (zIsModuleIgnoreRetryErr || zIsIgnoreRetryErr) ? false : true;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    public void addEntryType(LinkedHashMap<String, String> linkedHashMap) {
        super.addEntryType(linkedHashMap);
        if (linkedHashMap != null) {
            linkedHashMap.put("entryType", String.valueOf(this.f22536o));
            if (!isFromOOBE()) {
                linkedHashMap.put("entranceOfRestore", m29774I());
            }
            linkedHashMap.put("isRefurbishEntrance", String.valueOf(5 == this.f22536o));
        }
    }

    /* renamed from: b0 */
    public boolean m29793b0() {
        return isFromOOBE() && this.f22508B && !this.f22537p && !this.f22547z;
    }

    /* renamed from: c0 */
    public final boolean m29794c0(List<CloudRestoreStatusV3> list) {
        if (this.f22547z) {
            return false;
        }
        boolean zIsPrepareError = isPrepareError();
        boolean zM29787V = m29787V();
        if (!zIsPrepareError && !zM29787V) {
            if (isRestoreDone()) {
                return RestoreUtil.isAllModulesRestoreFailed(list);
            }
            return false;
        }
        C11839m.m70688i("CloudRestoreV3Task", "restore fail no retry, isPrepareError: " + zIsPrepareError + ", isFailNoRetryError: " + zM29787V);
        return true;
    }

    public void checkException(C9721b c9721b) {
        synchronized (f22505Z) {
            try {
                if (this.f22527U) {
                    return;
                }
                this.f22527U = RestoreUtil.isIgnoreRetryErr(c9721b);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final C13029h createTags() {
        C13029h c13029h = new C13029h(3, C11058a.m66627b("02010"));
        c13029h.m78460Z(this.f22518L + "_V3_" + this.f22519M);
        c13029h.m78467i0(this.f22520N);
        c13029h.m78448N(this.f22535n);
        c13029h.m78477r0(0);
        String strValueOf = String.valueOf(this.f22536o);
        if (5 == this.f22536o) {
            strValueOf = strValueOf + CloudRestoreTask.MYHUAWEI_TAG;
        }
        if (this.f22524R) {
            strValueOf = strValueOf + CloudRestoreTask.REFURBISHMENT_TAG;
        }
        if (mo29591n()) {
            strValueOf = strValueOf + "_temp_backup";
        }
        c13029h.m78454T(strValueOf);
        c13029h.m78455U(this.f22517K);
        long jCurrentTimeMillis = System.currentTimeMillis();
        c13029h.m78475q0(jCurrentTimeMillis);
        c13029h.m78447M(604800000 + jCurrentTimeMillis);
        c13029h.m78450P(jCurrentTimeMillis);
        c13029h.m78483u0(this.f22533l);
        return c13029h;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: d */
    public boolean mo29582d(int i10) {
        C11839m.m70688i("CloudRestoreV3Task", "abort check: " + i10);
        if (1001 == i10) {
            this.f22547z = true;
            return false;
        }
        if (i10 == 1004 || !C12187n.m73312i()) {
            return false;
        }
        setErrCode(i10);
        return true;
    }

    /* renamed from: d0 */
    public final void m29795d0() throws C9721b {
        About aboutM84094A;
        C11839m.m70688i("CloudRestoreV3Task", "queryAboutRequest start.");
        if (this.f22526T) {
            C11839m.m70688i("CloudRestoreV3Task", "queryAboutRequest is auto restore");
            return;
        }
        if (!C10028c.m62182c0().m62335h1()) {
            C11839m.m70688i("CloudRestoreV3Task", "getStrategyFormServer do not support about request");
            return;
        }
        try {
            aboutM84094A = new C13998b0().m84094A("cloudOperationType,refEffeDays,refEffeDelayDays", this.f22533l, this.f22524R ? "Refurbishment" : mo29591n() ? "interim" : "");
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreV3Task", "queryAboutRequest error: " + e10.getMessage());
            aboutM84094A = null;
        }
        if (aboutM84094A == null) {
            C11839m.m70687e("CloudRestoreV3Task", "query about request is null");
            return;
        }
        C12176c.m73269l(aboutM84094A);
        C11839m.m70688i("CloudRestoreV3Task", "queryAboutRequest: " + aboutM84094A.getCloudOperationType());
        if (aboutM84094A.getCloudOperationType() != null) {
            if (aboutM84094A.getCloudOperationType().intValue() == 3 || aboutM84094A.getCloudOperationType().intValue() == 1 || aboutM84094A.getCloudOperationType().intValue() == 2) {
                throw new C9721b(3920, "clearing backup restore abort");
            }
        }
    }

    public void deleteFile() {
        C11839m.m70688i("CloudRestoreV3Task", "delete cache file begin.");
        C13617a.m81932n(false);
        C12571m.m75547i(this.f22540s);
        C12571m.m75547i(this.f22541t);
        C12571m.m75547i(ICBUtil.getAndroidDataCacheRootPath());
        C12571m.m75547i(this.f22510D);
        String[] list = C10278a.m63442h(this.f22540s).list();
        if (list != null && list.length > 0) {
            C11839m.m70688i("CloudRestoreV3Task", "use pms move delete cache file.");
            ScanAppDataUtil.executePmsMoveProcess(this.f22540s);
        }
        C11839m.m70688i("CloudRestoreV3Task", "delete cache file end.");
    }

    public final void doFailReport(C11060c c11060c) {
        if (this.f22547z) {
            c11060c.m66665u("001_1001");
            c11060c.m66635A("user canceled.");
            return;
        }
        if (!condition()) {
            c11060c.m66665u("001_1002");
            c11060c.m66635A("net disabled.");
            return;
        }
        if (isAbort()) {
            c11060c.m66665u("001_" + getErrCode());
            c11060c.m66635A("abort by backup condition. current model:" + getCurrent());
            return;
        }
        if (getException() != null) {
            c11060c.m66664t(getException().m60658b());
            c11060c.m66665u("001_" + getException().m60659c());
            c11060c.m66635A(getException().getMessage());
        }
    }

    public final void doSuccessReport(C11060c c11060c) {
        if (this.f22534m != null) {
            c11060c.m66635A("restore success, totalTime: " + (System.currentTimeMillis() - this.f22534m.m78469k()) + " | totalSize: " + this.f22534m.m78439E());
            c11060c.m66665u("0");
        }
    }

    /* renamed from: e0 */
    public final void m29796e0() {
        boolean z10 = C13452e.m80781L().m80916g0() == 3;
        if (this.f22547z) {
            this.f22522P.m78425n(3);
        } else if (z10) {
            this.f22522P.m78425n(1);
        } else if (isNetworkEnabled()) {
            this.f22522P.m78425n(2);
        } else {
            this.f22522P.m78425n(4);
        }
        if (this.f22522P.m78421j() > 0) {
            this.f22522P.m78430s(System.currentTimeMillis());
            long jM78422k = this.f22522P.m78422k();
            long jM78423l = this.f22522P.m78423l();
            if (jM78422k > 0 && jM78423l > 0) {
                this.f22522P.m78431t(1);
                this.f22523Q.m78403a();
            }
            this.f22523Q.m78411i(this.f22522P);
            this.f22523Q.m78404b(System.currentTimeMillis() - 604800000);
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: f */
    public void mo29584f() throws SQLException {
        C11839m.m70688i("CloudRestoreV3Task", "close start.");
        MobileTrafficReport.getInstance().reportRestoreContinue();
        restoreEnd();
        refreshQueryTags();
        List<CloudRestoreStatusV3> listM76946j = new C12816g().m76946j();
        restoreEndUpdateStatus(listM76946j);
        restoreEndNotifyUI(listM76946j);
        m29800i0(listM76946j);
        m29796e0();
        if (5 == this.f22536o) {
            ICBBroadcastManager.sendCloudBackupStateBroadcast(2, this.f22535n, false);
        }
        restoreEndScheduler();
        restoreEndClearStatus();
        m29766A0();
        C11839m.m70688i("CloudRestoreV3Task", "close end.");
    }

    /* renamed from: f0 */
    public void m29797f0(int i10, List<CloudRestoreStatusV3> list) {
        if (this.f22538q) {
            RestoreProgress.initRestoreItemsV3();
        }
        new CloudRestoreClient().refreshStatusV3(i10, list, new C12816g(), this.exception);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: g */
    public void mo29585g(C9721b c9721b) {
        C11839m.m70688i("CloudRestoreV3Task", "error state = " + getState() + " manual abort = " + this.f22547z + " retry = " + this.f22537p);
        if (CacheTask.State.PREPARE.equals(getState())) {
            this.f22509C = true;
        }
    }

    /* renamed from: g0 */
    public void m29798g0(boolean z10, boolean z11) {
        RestoreUtil.registerAutoRestore(z10, z11, this.f22534m);
    }

    public String getBackupId() {
        return this.f22535n;
    }

    public int getEntryType() {
        return this.f22536o;
    }

    public String getLocation() {
        return C10279b.m63452a(C10278a.m63442h(CacheTask.getContext().getFilesDir() + "/cloudrestore"));
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: h */
    public void mo29586h() throws C9721b {
        C11839m.m70688i("CloudRestoreV3Task", "finish start.");
        executeAsyncTask(new CacheTask.AsyncTask(new a()));
        C11839m.m70688i("CloudRestoreV3Task", "finish end.");
    }

    /* renamed from: h0 */
    public final void m29799h0() {
        try {
            if (this.f22543v == null) {
                C11839m.m70689w("CloudRestoreV3Task", "cloud restore lock error.");
                return;
            }
            C9721b exception = getException();
            if (exception != null && 3109 == exception.m60659c()) {
                C11839m.m70689w("CloudRestoreV3Task", "record not exist, not report refresh");
                return;
            }
            C12816g c12816g = new C12816g();
            List<CloudRestoreStatusV3> listM76946j = c12816g.m76946j();
            this.f22530X = isAllModulesSuccess(listM76946j);
            BakRefresh.Summary summary = new BakRefresh.Summary();
            summary.setRetCode(Integer.valueOf(exception == null ? 0 : exception.m60659c())).setMessage(exception == null ? "success" : exception.getMessage()).setRecDeviceDisplayName(BluetoothAdapter.getDefaultAdapter().getName()).setRecDeviceTerminal(Build.MODEL).setBeginTime(new C4644l(this.f22534m.m78469k())).setStartTime(new C4644l(this.f22534m.m78440F())).setEndTime(new C4644l(System.currentTimeMillis()));
            if (this.f22530X) {
                m29768C(summary, c12816g);
            } else {
                m29769D(summary, false, c12816g);
            }
            isNeedSaveRestoreFailInfo(listM76946j);
            BakRefresh bakRefresh = new BakRefresh();
            summary.setFactory(C11903a.m71435l());
            bakRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setUnSuccessRecoverSummary(summary.toString());
            boolean zM75939i = C12591s1.m75931a().m75939i();
            boolean zM29794c0 = m29794c0(listM76946j);
            boolean zM29785T = m29785T(listM76946j);
            int i10 = (!this.f22530X || zM29785T) ? (zM29794c0 || zM29785T) ? 3 : 4 : 2;
            bakRefresh.setRecoverFlag(Integer.valueOf(i10));
            if (zM75939i) {
                boolean zM75934d = C12591s1.m75931a().m75934d();
                C11839m.m70688i("CloudRestoreV3Task", "refurbish is all modules: " + zM75934d);
                if (this.f22530X) {
                    m29767B0(!zM75934d);
                } else {
                    m29767B0(zM29794c0);
                }
            }
            C11839m.m70688i("CloudRestoreV3Task", "cloud restore , recover flag: " + i10 + ", isRestoreSuccess: " + this.f22530X);
            new C10309n0(this.f22533l).m63492F(this.f22519M, this.f22535n, this.f22542u, bakRefresh);
        } catch (Exception e10) {
            C11839m.m70689w("CloudRestoreV3Task", "cloud restore refresh error, " + e10);
        }
    }

    public boolean has3rdPause() {
        return !new C12816g().m76950n(2).isEmpty();
    }

    public boolean hasDefault() {
        return !new C12816g().m76950n(0).isEmpty();
    }

    /* renamed from: i0 */
    public final void m29800i0(List<CloudRestoreStatusV3> list) {
        C12811b c12811b;
        Iterator<CloudRestoreStatusV3> it;
        long j10;
        if (getErrCode() == 1007) {
            boolean zM75529o = C12565k.m75529o();
            C12811b c12811b2 = new C12811b();
            Iterator<CloudRestoreStatusV3> it2 = list.iterator();
            long jM76861l = 0;
            while (it2.hasNext()) {
                CloudRestoreStatusV3 next = it2.next();
                if (!next.isSuccess()) {
                    long size = next.getSize();
                    String appId = next.getAppId();
                    C12810a c12810aM76879d = c12811b2.m76879d(appId, SnapshotDBManager.PREFIX_DATABASE_NAME);
                    if (c12810aM76879d != null && !C10278a.m63442h(C13617a.m81942x(this.f22535n, appId, 1, next.getUid())).exists()) {
                        jM76861l += c12810aM76879d.m76861l();
                        C11839m.m70686d("CloudRestoreV3Task", "snapshot not exist appId: " + appId + " ,size: " + c12810aM76879d.m76861l());
                    }
                    if (C14333b.m85477l().contains(appId)) {
                        jM76861l += 2 * size;
                        C11839m.m70686d("CloudRestoreV3Task", "restoreEndCheckException appId: " + appId + ", size: " + size);
                        c12811b = c12811b2;
                        it = it2;
                    } else if (next.is3rdAppType()) {
                        long jM1688f = C0241z.m1688f(next.m29496q());
                        long j11 = size - jM1688f;
                        if (next.m29498s() == 0) {
                            c12811b = c12811b2;
                            it = it2;
                            j10 = 0;
                            j11 = 0;
                        } else {
                            c12811b = c12811b2;
                            it = it2;
                            j10 = jM1688f;
                        }
                        long asize = next.getAsize();
                        C11839m.m70686d("CloudRestoreV3Task", "restoreEndCheckException appId: " + appId + " ,appDataSize: " + j10 + ", size: " + size + " ,asize: " + asize);
                        if (!zM75529o) {
                            j10 *= 2;
                        }
                        jM76861l = jM76861l + j11 + j10 + (asize * 2);
                    } else {
                        c12811b = c12811b2;
                        it = it2;
                        jM76861l += size;
                        C11839m.m70686d("CloudRestoreV3Task", "restoreEndCheckException appId: " + appId + ", size: " + size);
                    }
                    it2 = it;
                    c12811b2 = c12811b;
                }
            }
            C13466f.m81073d().m81083k("restore_local_space_not_enough_size", jM76861l);
            C11839m.m70688i("CloudRestoreV3Task", "restoreEndCheckException tipsize: " + jM76861l + " ,isSupportMove: " + zM75529o);
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    public void init() throws C9721b {
        C14317j.m85300d().m85310k(2, false);
        super.init();
    }

    public final void initConfig() {
        m29811t0(new C12526j().m75432z0());
        C14333b.m85460P(C0241z.m1685c(m29587j()));
    }

    public void initTempDirs() throws C9721b {
        File fileM63442h = C10278a.m63442h(this.f22540s);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e("CloudRestoreV3Task", "process file init error.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "process file init error.");
        }
        File fileM63442h2 = C10278a.m63442h(this.f22541t);
        if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
            long jM75896r0 = C12590s0.m75896r0(C12583q.m75684t());
            C11839m.m70687e("CloudRestoreV3Task", "process apkPathDir init error. pathAvailSize: " + jM75896r0);
            if (jM75896r0 >= 100000000) {
                throw new C9721b(FamilyShareConstants.StatusCode.USER_JOIN_IS_FROZEN, "process apkPathDir init error.");
            }
            throw new C9721b(1007, "process apkPathDir init error no space.");
        }
        File fileM63442h3 = C10278a.m63442h(this.f22510D + ICBUtil.TAR_LOCAL_DIR);
        if (!fileM63442h3.exists() && !fileM63442h3.mkdirs()) {
            C11839m.m70687e("CloudRestoreV3Task", "process snapshotTarDir init error.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "process snapshotTarDir init error.");
        }
        File fileM63442h4 = C10278a.m63442h(C12583q.m75688x());
        C11839m.m70686d("CloudRestoreV3Task", "tempPmsMoveDir mkdir result: " + (!fileM63442h4.exists() && fileM63442h4.mkdirs()));
    }

    public final boolean isAllModulesSuccess(List<CloudRestoreStatusV3> list) {
        boolean z10 = false;
        if (list.isEmpty()) {
            return false;
        }
        Iterator<CloudRestoreStatusV3> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = true;
                break;
            }
            if (!it.next().isSuccess()) {
                break;
            }
        }
        if (z10) {
            updateTagsStatus(4);
            this.exception = null;
            this.f22426f = true;
        }
        return z10;
    }

    public boolean isFirstStageFailed(List<CloudRestoreStatusV3> list) {
        if (list.isEmpty()) {
            return true;
        }
        boolean z10 = false;
        boolean z11 = true;
        boolean z12 = true;
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (this.f22528V.contains(cloudRestoreStatusV3.getAppId())) {
                z11 = z11 && cloudRestoreStatusV3.isSuccess();
                z12 = z12 && !cloudRestoreStatusV3.isSuccess();
                z10 = true;
            }
        }
        if (!z10) {
            return false;
        }
        if (this.exception != null) {
            z12 = this.f22508B && !this.f22537p;
        }
        return !z11 && z12;
    }

    public boolean isFromOOBE() {
        return 1 == this.f22536o;
    }

    public void isLocalSpaceEnough() throws C9721b {
        C9721b exception = getException();
        if (exception != null && exception.m60659c() == 1007) {
            throw exception;
        }
    }

    public boolean isModuleIgnoreRetryErr() {
        boolean z10;
        synchronized (f22505Z) {
            z10 = this.f22527U;
        }
        return z10;
    }

    public final void isNeedSaveRestoreFailInfo(List<CloudRestoreStatusV3> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (!cloudRestoreStatusV3.isSuccessWithoutUnSupport()) {
                C11839m.m70688i("CloudRestoreV3Task", "isSuccessWithoutUnSupport false  , appId = " + cloudRestoreStatusV3.getAppId() + " , status = " + cloudRestoreStatusV3.getStatus());
                arrayList.add(cloudRestoreStatusV3.getAppId());
            }
        }
        if (arrayList.isEmpty() || 5 != this.f22536o) {
            return;
        }
        C12590s0.m75761J2(new RefurbishRestoreFailInfo(this.f22535n, (String[]) arrayList.toArray(new String[0])));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isNetworkEnabled() {
        /*
            r4 = this;
            int r0 = r4.getErrCode()
            r1 = 1002(0x3ea, float:1.404E-42)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L13
            r1 = 3900(0xf3c, float:5.465E-42)
            if (r0 == r1) goto L13
            switch(r0) {
                case 1104: goto L13;
                case 1105: goto L13;
                case 1106: goto L13;
                case 1107: goto L13;
                default: goto L11;
            }
        L11:
            r0 = r3
            goto L14
        L13:
            r0 = r2
        L14:
            boolean r4 = r4.condition()
            if (r4 == 0) goto L1d
            if (r0 == 0) goto L1d
            r2 = r3
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.cloudbackup.p104v3.core.C4880b.isNetworkEnabled():boolean");
    }

    public final boolean isPrepareError() {
        return (this.f22534m == null || this.f22509C) && !this.f22537p;
    }

    public boolean isRefurbishment() {
        return 5 == this.f22536o || this.f22524R;
    }

    public final boolean isRestoreDone() {
        C13029h c13029h = this.f22534m;
        return c13029h != null && c13029h.m78441G() == 4;
    }

    /* renamed from: j0 */
    public void m29801j0(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        C9992e0 c9992e0 = this.f22521O;
        if (c9992e0 != null) {
            c9992e0.m61972F(cloudRestoreStatusV3);
        }
    }

    /* renamed from: k0 */
    public void m29802k0(String str, int i10) throws C9721b {
        C11839m.m70688i("CloudRestoreV3Task", "resume3rd begin, appId = " + str);
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appId is null.", "resume3rd error");
        }
        if (!this.f22515I) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "not allow to resume app to restore.", "resume3rd error");
        }
        CloudRestoreStatusV3 cloudRestoreStatusV3M76948l = new C12816g().m76948l(str, i10);
        if (cloudRestoreStatusV3M76948l == null) {
            C11839m.m70688i("CloudRestoreV3Task", "resume3rd status null error. appId = " + str);
            return;
        }
        if (this.f22521O == null) {
            this.f22521O = new C9992e0(this, this.f22532k, this.f22540s, this.f22538q, this.f22536o, 0L);
        }
        if (CloudBackupTaskManager.getInstance().getModuleTask(cloudRestoreStatusV3M76948l.m29468L()) != null) {
            C11839m.m70688i("CloudRestoreV3Task", "resume3rd addDownloadTask moduleTask is running. moduleId = " + cloudRestoreStatusV3M76948l.m29468L());
            return;
        }
        this.f22521O.m61977h(cloudRestoreStatusV3M76948l);
        C11839m.m70688i("CloudRestoreV3Task", "resume3rd addDownloadTask success. appId = " + cloudRestoreStatusV3M76948l.m29468L());
    }

    public void keepLock() {
        synchronized (f22506a0) {
            try {
                if (this.f22542u == null) {
                    C11839m.m70688i("CloudRestoreV3Task", "keepLock error, restoreLock == null");
                    return;
                }
                try {
                    try {
                        isRelease();
                        isCancel();
                        this.f22542u.m8328c();
                    } catch (C9721b unused) {
                        C11839m.m70688i("CloudRestoreV3Task", "keepLock error, isRelease = true");
                    }
                } catch (C9721b e10) {
                    setException(e10);
                }
            } finally {
            }
        }
    }

    /* renamed from: l0 */
    public void m29803l0(int i10, int i11) {
        C13452e.m80781L().m80914f3(i10);
        m29771F(i10, i11);
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 3205, i10, i11, Boolean.TRUE));
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: m */
    public boolean mo29590m() {
        return this.f22524R;
    }

    /* renamed from: m0 */
    public void m29804m0(String str) {
        m29814w0(TextUtils.equals(str, "3"));
        m29810s0(TextUtils.equals(str, "2"));
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: n */
    public boolean mo29591n() {
        return this.f22525S;
    }

    /* renamed from: n0 */
    public void m29805n0(List<String> list) {
        this.f22531Y = list;
    }

    public void notifyToRestoreAppByLauncher() {
        this.f22512F = true;
        synchronized (this.f22513G) {
            this.f22513G.notifyAll();
        }
        C11839m.m70688i("CloudRestoreV3Task", "notify to restore third app by HwLaucher end.");
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: o */
    public void mo29592o(Context context, HiCloudSafeIntent hiCloudSafeIntent, Handler handler) {
        int pauseBattery;
        String action = hiCloudSafeIntent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            C11839m.m70688i("CloudRestoreV3Task", "action connectivity change");
            processNetworkChanged(context, handler);
            return;
        }
        if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
            C11839m.m70688i("CloudRestoreV3Task", "action battery change");
            int intExtra = hiCloudSafeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, 0);
            C10153d.m63243g(intExtra);
            int intExtra2 = hiCloudSafeIntent.getIntExtra("status", 1);
            C11839m.m70688i("CloudRestoreV3Task", "batteryStatus: " + intExtra2);
            if (intExtra2 == 2 || intExtra2 == 5 || intExtra >= (pauseBattery = new C12526j().m75325A0().getPauseBattery())) {
                return;
            }
            C11839m.m70689w("CloudRestoreV3Task", "battery level lower than batteryLevel: " + intExtra + " pauseBattery" + pauseBattery);
            abort(1004);
        }
    }

    /* renamed from: o0 */
    public void m29806o0(int i10) {
        this.f22536o = i10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: p */
    public void mo29593p() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3Task", "operator start");
        isCancel();
        C14317j.m85300d().m85318s(2, CBSBaseReq.CURRENT_API_VERSION);
        m29803l0(1, 0);
        RestoreProgressManager.getInstance().init(isFromOOBE());
        C9992e0 c9992e0 = new C9992e0(this, this.f22532k, this.f22540s, this.f22538q, this.f22536o, 0L);
        this.f22521O = c9992e0;
        c9992e0.m61982m();
        C11839m.m70688i("CloudRestoreV3Task", "operator end");
    }

    /* renamed from: p0 */
    public void m29807p0(boolean z10) {
        this.f22508B = z10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: q */
    public void mo29594q() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudRestoreV3Task", "prepare start: " + this.f22533l);
        if (TextUtils.isEmpty(this.f22535n) || TextUtils.isEmpty(this.f22519M)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "deviceId and backupId is invalid.", "CloudRestoreV3Task_prepare");
        }
        m29784S();
        RestoreUtil.setRestoreStatus(CacheTask.getContext(), true);
        this.f22544w = RestoreCache.getInstance().getEntranceOfRestore();
        C12590s0.m75773M2(0L);
        initConfig();
        C13466f.m81073d().m81083k("restore_local_space_not_enough_size", 0L);
        new C13757a().m82647d();
        recordRestoreStart();
        C13466f.m81073d().m81081i("all_moudles_restore_success", false);
        C13466f.m81073d().m81081i("has_moudles_restore_pause", false);
        CloudBackupStateUtil.recordBroadcastBackupId(2, this.f22535n, isRefurbishment());
        CloudBackupReport.initAppMarketVersionCode();
        isCancel();
        m29795d0();
        CBAccess.clearDeleteTask();
        isCancel();
        lock();
        isCancel();
        m29596s();
        if (this.f22524R) {
            m29767B0(false);
        }
        CBAccess.waitCacheClear(new C0295r(this));
        isCancel();
        this.f22534m = queryTags();
        C14317j.m85300d().m85312m(this.f22534m);
        if (5 == this.f22536o) {
            ICBBroadcastManager.unrestrictedCloudStateBroadcast();
            ICBBroadcastManager.sendCloudBackupStateBroadcast(2, this.f22535n, false);
            C13466f.m81073d().m81084l("refurbishRestoreId", this.f22535n);
        }
        new C10000i0(this, this.f22532k, this.f22533l, this.f22519M, this.f22518L, this.f22535n, this.f22537p, this.f22538q, this.f22542u).m62007m();
        isCancel();
        C13452e.m80781L().m80909e3(0.0f);
        RestoreProgress.clearCache();
        RestoreProgress.initRestoreItemsV3();
        this.f22509C = false;
        CloneService.getInstance().doBindService(ParamConstants.CallbackMethod.ON_PREPARE);
        C11839m.m70688i("CloudRestoreV3Task", "prepare end.");
    }

    /* renamed from: q0 */
    public void m29808q0(boolean z10) {
        this.f22516J = z10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: r */
    public void mo29595r(ICBBaseV3Task.ICBBaseReceiver iCBBaseReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        CacheTask.getContext().registerReceiver(iCBBaseReceiver, intentFilter);
        m29798g0(C11829c.m70611r0(), true);
    }

    /* renamed from: r0 */
    public void m29809r0(boolean z10) {
        this.f22507A = z10;
    }

    public final void recordRestoreStart() {
        this.f22522P.m78424m(this.f22535n);
        this.f22522P.m78426o(3);
        this.f22522P.m78432u(System.currentTimeMillis());
        this.f22523Q.m78411i(this.f22522P);
        CloudBackupReport.reportRestoreStart(this.f22533l, m29587j(), this.f22535n, this.f22537p, this.f22538q, isFromOOBE(), this.f22526T);
    }

    public final void refreshQueryTags() {
        try {
            this.f22534m = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3Task", "refreshQueryTags queryTag error " + e10);
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    public void reportEvent() {
        refreshQueryTags();
        m29799h0();
        C11060c c11060cM66626a = C11058a.m66626a(this.f22533l, "success", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66668x("1");
        if (this.f22426f) {
            doSuccessReport(c11060cM66626a);
        } else {
            doFailReport(c11060cM66626a);
        }
        C14317j.m85300d().m85302a(2, c11060cM66626a.m66647c(), isRestoreDone() || m29791Z());
        HashMap map = new HashMap();
        C13029h c13029h = this.f22534m;
        if (c13029h != null) {
            boolean z10 = c13029h.m78441G() == 0 || this.f22534m.m78441G() == 2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z10 ? "[First]" : "[Last]");
            sb2.append(c11060cM66626a.m66652h());
            c11060cM66626a.m66635A(sb2.toString());
            map.put("backupBeginTime", String.valueOf(this.f22534m.m78469k()));
            map.put("backupEndTime", String.valueOf(System.currentTimeMillis()));
            map.put("sizeNeedBackup", String.valueOf(this.f22534m.m78439E()));
            map.put("restoreSize", String.valueOf(this.f22545x));
            map.put("totalRestoreSize", String.valueOf(this.f22546y));
            map.put("backupTransID", this.f22534m.m78436B());
            map.put("entryType", String.valueOf(this.f22536o));
            map.put("entranceOfRestore", m29774I());
            map.put("backupId", this.f22535n);
            map.put("is_refurbish", String.valueOf(this.f22524R));
            map.put("is_temp_backup", String.valueOf(mo29591n()));
            map.put("diffModule", String.join(",", this.f22531Y));
            map.put("bakCategory", String.valueOf(m29587j()));
            if (CloudBackupStateUtil.isFromSystemRetreadTask(2, this.f22535n)) {
                map.put("is_system_retread", String.valueOf(true));
            }
            this.f22534m.m78452R(c11060cM66626a.m66647c());
            this.f22534m.m78446L(getCurrent());
            this.f22534m.m78451Q(c11060cM66626a.m66646b());
            this.f22534m.m78447M(System.currentTimeMillis());
            new C13030i().m78496g(this.f22534m);
            if (!this.f22426f) {
                reportInterruptOrAuto(this.f22534m, "restore_interrupt_times");
                reportInterruptOrAuto(this.f22534m, "restore_interrupt_report");
            }
            reportEachTask(this.f22534m, "restore_each_period", null);
            reportEachTask(this.f22534m, "restore_each_size", String.valueOf(this.f22545x));
            reportEachTask(this.f22534m, "restore_total_size", String.valueOf(this.f22546y));
            if (this.f22524R) {
                C12590s0.m75765K2(new RefurbishRestoreInfo(this.f22535n, this.f22534m.m78440F(), this.f22534m.m78464f(), this.f22534m.m78441G()));
                if (this.f22530X) {
                    C12590s0.m75745F2();
                }
            }
        }
        map.put("userType", C13452e.m80781L().m80987x0());
        map.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, map, false, true);
    }

    public final void restoreEnd() throws SQLException {
        CloudBackupTaskManager.getInstance().shutDown();
        C12188o.m73320c().m73324e();
        CloneService.getInstance().unBindService();
        C13216j.m79423h();
        InterfaceC1450e.get().forEach(new C2543k0());
        RestoreProgressManager.getInstance().release();
        if (this.f22507A) {
            try {
                AlbumsTempOperator albumsTempOperator = new AlbumsTempOperator();
                albumsTempOperator.clear();
                albumsTempOperator.close();
            } catch (C9721b unused) {
                C11839m.m70689w("CloudRestoreV3Task", "onClose closeAlbumTempDb error.");
            }
        }
        if (this.f22426f) {
            C13465e.m81052f().m81070s(true, 0L);
            C13465e.m81052f().m81070s(false, 0L);
        }
    }

    public final void restoreEndClearLauncherIcon(int i10) {
        boolean z10 = (i10 == 2 || i10 == 4 || i10 == 6 || i10 == 7) ? false : true;
        C11839m.m70688i("CloudRestoreV3Task", "restoreEndClearLauncherIcon clear Launcher icon = " + z10);
        if (z10) {
            RestoreUtil.setRestoreStatus(CacheTask.getContext(), false);
            if (TextUtils.equals("HWlanucher", getCurrent())) {
                ICBBroadcastManager.sendDelayCancelRestoreBroadcast(CacheTask.getContext(), 3);
            } else {
                ICBBroadcastManager.sendDelayCancelRestoreBroadcast(CacheTask.getContext(), 1);
            }
        }
    }

    public final void restoreEndClearStatus() {
        boolean zIsNewBmRecord = RestoreUtil.isNewBmRecord();
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C13029h c13029h = this.f22534m;
        if (c13029h != null && c13029h.m78441G() == 4) {
            C11839m.m70688i("CloudRestoreV3Task", "async clear cache task start.");
            C12571m.m75542d(this.f22540s);
            C12571m.m75542d(this.f22541t);
            C12571m.m75542d(ICBUtil.getAndroidDataCacheRootPath());
            C12571m.m75542d(this.f22510D);
        }
        CloudRestoreClient cloudRestoreClient = new CloudRestoreClient();
        cloudRestoreClient.sendClearCacheSuccessMessage();
        C9721b c9721b = this.exception;
        if (c9721b == null) {
            cloudRestoreClient.sendMessage(iM80916g0, getErrCode(), zIsNewBmRecord);
        } else if (String.valueOf(c9721b.m60663g()).endsWith(String.valueOf(4291))) {
            cloudRestoreClient.sendMessage(iM80916g0, 3920, zIsNewBmRecord);
        } else {
            cloudRestoreClient.sendMessage(iM80916g0, getErrCode(), zIsNewBmRecord);
        }
    }

    public final void restoreEndNotifyUI(List<CloudRestoreStatusV3> list) {
        int i10;
        boolean zIsAllModulesRestoreFailed = RestoreUtil.isAllModulesRestoreFailed(list);
        boolean zIsOnlySourceNotExistFailed = RestoreUtil.isOnlySourceNotExistFailed(list);
        if (this.f22547z) {
            i10 = 8;
        } else {
            if (isPrepareError() || m29787V() || zIsOnlySourceNotExistFailed) {
                updateTagsStatus(4);
            } else if (isRestoreDone()) {
                if (!zIsAllModulesRestoreFailed && !m29786U(getErrCode())) {
                    i10 = 3;
                }
            } else if (!isNetworkEnabled()) {
                i10 = 6;
            } else if (has3rdPause()) {
                C13466f.m81073d().m81081i("has_moudles_restore_pause", true);
                i10 = 7;
            } else {
                i10 = (RestoreUtil.isShowRestoreFailedDialog(this.exception) || zIsAllModulesRestoreFailed) ? 4 : 2;
            }
            i10 = 5;
        }
        C11839m.m70688i("CloudRestoreV3Task", "restoreEnd status = " + i10);
        m29797f0(i10, list);
        RestoreUtil.saveRestoreInfoToSp(i10, isFromOOBE());
        C13452e.m80781L().m80914f3(i10);
        callback(Message.obtain((Handler) null, 32998));
        C4877a.m29281i().m29288o();
        restoreEndClearLauncherIcon(i10);
        ICBBroadcastManager.sendBackupRestoreEnd(CacheTask.getContext());
    }

    public final void restoreEndScheduler() {
        boolean zM70611r0 = C11829c.m70611r0();
        if (this.f22547z) {
            m29817z0(zM70611r0);
            return;
        }
        C13029h c13029h = this.f22534m;
        if (c13029h != null) {
            int iM78441G = c13029h.m78441G();
            if (iM78441G != 0 && iM78441G != 1 && iM78441G != 2 && iM78441G != 3) {
                if (iM78441G != 4) {
                    return;
                }
                m29817z0(zM70611r0);
                return;
            }
            C11839m.m70688i("CloudRestoreV3Task", "v3 restore in state: " + iM78441G + "the code is:" + getErrCode());
            if (!RestoreUtil.isRestoreNeedAutoRetry(getErrCode())) {
                m29817z0(zM70611r0);
            } else {
                C11839m.m70688i("CloudRestoreV3Task", "v3 restore in state registerAutoRestore: need load retry timer.");
                m29798g0(zM70611r0, false);
            }
        }
    }

    public final void restoreEndUpdateStatus(List<CloudRestoreStatusV3> list) {
        if (m29793b0() && isFirstStageFailed(list)) {
            C13452e.m80781L().m80890b();
            updateTagsStatus(4);
            RestoreNotification.getInstance().cancelNotification();
            sendFirstDoneMessage(false);
        }
        C13466f.m81073d().m81081i("all_moudles_restore_success", this.f22530X);
        if (this.f22530X || this.f22547z || (getException() != null && m29786U(getException().m60659c()))) {
            updateTagsStatus(4);
        }
        m29770E();
    }

    /* renamed from: s0 */
    public void m29810s0(boolean z10) {
        if (z10) {
            this.f22524R = true;
        }
    }

    public void sendFirstDoneMessage(boolean z10) {
        Message message = new Message();
        message.what = 32997;
        message.arg1 = condition() ? getErrCode() : 1002;
        message.obj = Boolean.valueOf(z10);
        callback(message);
    }

    public void setLauncherLayoutOk(boolean z10) {
        this.f22512F = z10;
    }

    public void setTaskMyHuawei() {
        if (TextUtils.isEmpty(this.f22535n) || CloudBackupStateUtil.checkBroadcastId(2, this.f22535n)) {
            return;
        }
        CloudBackupStateUtil.recordBroadcastBackupId(2, this.f22535n, true);
        ICBBroadcastManager.sendCloudBackupStateBroadcast(2, this.f22535n, false);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: t */
    public void mo29597t() {
        C14317j.m85300d().m85320u(false, 0);
    }

    /* renamed from: t0 */
    public void m29811t0(long j10) {
        this.f22511E = j10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: u */
    public void mo29598u(long j10, String str) {
        C11839m.m70686d("CloudRestoreV3Task", "report each stage time");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", this.f22533l);
        linkedHashMap.put("backupId", this.f22535n);
        linkedHashMap.put("stage", str);
        linkedHashMap.put("time", String.valueOf(System.currentTimeMillis() - j10));
        linkedHashMap.put("backupVersion", CBSBaseReq.CURRENT_API_VERSION);
        C13225d.m79490f1().m79603z0("cloudrestore_each_stage_time", linkedHashMap);
    }

    /* renamed from: u0 */
    public void m29812u0(long j10) {
        this.f22545x = j10;
    }

    public void updateTagsStatus(int i10) {
        C13029h c13029h = this.f22534m;
        if (c13029h != null) {
            c13029h.m78477r0(i10);
            new C13030i().m78496g(this.f22534m);
        }
    }

    /* renamed from: v0 */
    public void m29813v0(boolean z10) {
        this.f22515I = z10;
    }

    /* renamed from: w0 */
    public void m29814w0(boolean z10) {
        this.f22525S = z10;
    }

    /* renamed from: x0 */
    public void m29815x0(List<CloudRestoreStatusV3> list) {
        this.f22514H = list;
    }

    /* renamed from: y0 */
    public void m29816y0(long j10) {
        this.f22546y = j10;
    }

    /* renamed from: z0 */
    public final void m29817z0(boolean z10) {
        if (z10) {
            CloudBackupJobManager.getInstance().unRegisterDsRestoreScheduler();
        } else {
            CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
        }
    }
}
