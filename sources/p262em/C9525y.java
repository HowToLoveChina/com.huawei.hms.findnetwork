package p262em;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.p019pm.PackageInfoCompat;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import dm.C9195d0;
import dm.C9247q0;
import dm.C9276z;
import fk.C9720a;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import om.C11963c;
import om.C11965e;
import p015ak.C0210d0;
import p015ak.C0213f;
import p015ak.C0225l;
import p015ak.C0241z;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12535a;
import p618rm.C12590s0;
import p709vj.C13452e;
import p851zp.InterfaceC14356c;
import p851zp.InterfaceC14358e;
import pm.C12182i;
import sl.C12815f;

/* renamed from: em.y */
/* loaded from: classes6.dex */
public class C9525y extends AbstractC9526z {

    /* renamed from: v */
    public static final Object f47333v = new Object();

    /* renamed from: n */
    public final List<CloudBackupStatus> f47334n;

    /* renamed from: o */
    public List<CloudBackupStatus> f47335o;

    /* renamed from: p */
    public final HashMap<String, Map<String, String>> f47336p;

    /* renamed from: q */
    public final Map<String, PackageInfo> f47337q;

    /* renamed from: r */
    public final Map<String, App> f47338r;

    /* renamed from: s */
    public final String f47339s;

    /* renamed from: t */
    public final long f47340t;

    /* renamed from: u */
    public CloudBackupStatus f47341u;

    public C9525y(C4879a c4879a, List<CloudBackupStatus> list, Map<String, App> map) {
        super(c4879a, c4879a.m29731o0());
        this.f47336p = new HashMap<>();
        this.f47337q = new HashMap();
        this.f47334n = list;
        this.f47339s = c4879a.m29628C0();
        this.f47338r = map;
        this.f47340t = Math.min(new SettingOperator().queryMaxBatchNumber(), new C12526j().m75392g0());
    }

    /* renamed from: g0 */
    public static /* synthetic */ boolean m59456g0(CloudBackupStatus cloudBackupStatus) {
        return 5 == cloudBackupStatus.m29859L() || 6 == cloudBackupStatus.m29859L();
    }

    /* renamed from: p0 */
    public static /* synthetic */ boolean m59457p0(CloudBackupStatus cloudBackupStatus) {
        return cloudBackupStatus.m29859L() == 5;
    }

    /* renamed from: q0 */
    public static /* synthetic */ Map m59458q0(String str) {
        return new HashMap();
    }

    /* renamed from: r0 */
    public static /* synthetic */ boolean m59459r0(CloudBackupStatus cloudBackupStatus) {
        return cloudBackupStatus.m29859L() == 0;
    }

    /* renamed from: u0 */
    public static /* synthetic */ boolean m59462u0(CloudBackupStatus cloudBackupStatus) {
        return TextUtils.isEmpty(cloudBackupStatus.m29398d1());
    }

    /* renamed from: v0 */
    public static /* synthetic */ boolean m59464v0(CloudBackupStatus cloudBackupStatus) {
        return cloudBackupStatus.m29859L() < 3;
    }

    /* renamed from: w0 */
    public static /* synthetic */ boolean m59466w0(CloudBackupStatus cloudBackupStatus) {
        return TextUtils.isEmpty(cloudBackupStatus.m29398d1());
    }

    /* renamed from: x0 */
    public static /* synthetic */ boolean m59468x0(CloudBackupStatus cloudBackupStatus) {
        return cloudBackupStatus.m29859L() == 3;
    }

    /* renamed from: y0 */
    public static /* synthetic */ boolean m59470y0(CloudBackupStatus cloudBackupStatus) {
        return !TextUtils.isEmpty(cloudBackupStatus.m29398d1());
    }

    /* renamed from: A0 */
    public final void m59472A0(CloudBackupStatus cloudBackupStatus) {
        String strM29870d = cloudBackupStatus.m29870d();
        PackageInfo packageInfo = this.f47337q.get(cloudBackupStatus.mo29421n());
        if (packageInfo == null) {
            C11839m.m70689w("CloudBackupV3Module3rdAppOperate", "prepareStatus package info get null ," + strM29870d);
            return;
        }
        long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
        C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "versionCode: " + longVersionCode + " appId: " + strM29870d);
        String str = packageInfo.versionName;
        cloudBackupStatus.m29439t2(String.valueOf(longVersionCode));
        cloudBackupStatus.m29447w1(str);
        cloudBackupStatus.mo29316a0(SplitAppUtil.getSplitAppName(m59509h().getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString(), cloudBackupStatus.mo29357K()));
        if (cloudBackupStatus.m29859L() < 3) {
            cloudBackupStatus.m29453y1(0);
        }
    }

    /* renamed from: B0 */
    public final void m59473B0(List<CloudBackupStatus> list) throws C9721b {
        int i10 = 0;
        while (true) {
            long j10 = i10;
            if (this.f47340t * j10 >= list.size()) {
                return;
            }
            this.f47354m.m63538C(this.f47342a.m29728n0(), this.f47346e, this.f47345d, (List) list.stream().skip(j10 * this.f47340t).limit(this.f47340t).map(new Function() { // from class: em.o
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f47328a.m59501s0((CloudBackupStatus) obj);
                }
            }).collect(Collectors.toList()), new Consumer() { // from class: em.p
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f47329a.m59502t0((Pair) obj);
                }
            });
            i10++;
        }
    }

    /* renamed from: C0 */
    public final void m59474C0(CloudBackupStatus cloudBackupStatus) throws C9721b {
        cloudBackupStatus.mo29338z0(0).mo29289A0(-1).m29374R1(0L).m29342C1(0L).m29436s2(0L).m29423n2(0L).mo29310W(0).mo29308V(0L);
        this.f47348g.m76934m(cloudBackupStatus);
        C11963c.m71970y(cloudBackupStatus, this.f47347f);
    }

    /* renamed from: D0 */
    public void m59475D0() throws ExecutionException, InterruptedException, C9721b, PackageManager.NameNotFoundException, NumberFormatException {
        List<CloudBackupStatus> list = (List) this.f47335o.stream().filter(new Predicate() { // from class: em.t
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59462u0((CloudBackupStatus) obj);
            }
        }).filter(new Predicate() { // from class: em.u
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59464v0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        List<CloudBackupStatus> list2 = (List) this.f47335o.stream().filter(new Predicate() { // from class: em.v
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59466w0((CloudBackupStatus) obj);
            }
        }).filter(new Predicate() { // from class: em.w
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59468x0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        List<CloudBackupStatus> list3 = (List) this.f47335o.stream().filter(new Predicate() { // from class: em.x
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59470y0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        m59480T(list2);
        list3.addAll(list2);
        for (CloudBackupStatus cloudBackupStatus : list3) {
            m59483W(cloudBackupStatus, m59489c0(cloudBackupStatus.m29870d()));
            this.f47343b.m61927l(cloudBackupStatus.m29870d(), cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N());
        }
        for (CloudBackupStatus cloudBackupStatus2 : list) {
            try {
                C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "need clone apk, appid = " + cloudBackupStatus2.m29870d());
                m59519s();
                C12182i.m73283j().m73287f(this, cloudBackupStatus2);
                m59511j();
                new C9247q0(this.f47342a, null, cloudBackupStatus2, new CloudBackupAppDataUtil(cloudBackupStatus2.mo29421n(), this.f47342a.getLocation(), Long.parseLong(cloudBackupStatus2.m29407h1()), this.f47342a.isRefurbishment(), this.f47342a.mo29591n()), null).m58053V(m59489c0(cloudBackupStatus2.m29870d()));
                m59480T(Collections.singletonList(cloudBackupStatus2));
                cloudBackupStatus2.mo29289A0(5);
                m59483W(cloudBackupStatus2, m59489c0(cloudBackupStatus2.m29870d()));
                this.f47343b.m61927l(cloudBackupStatus2.m29870d(), cloudBackupStatus2.mo29421n(), cloudBackupStatus2.m29861N());
            } catch (C9721b e10) {
                this.f47341u = cloudBackupStatus2;
                throw e10;
            }
        }
    }

    /* renamed from: P */
    public final void m59476P() throws C9721b {
        List<CloudBackupStatus> list = (List) this.f47335o.stream().filter(new Predicate() { // from class: em.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f47320a.m59492f0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        m59473B0((List) list.stream().filter(new Predicate() { // from class: em.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59456g0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList()));
        for (CloudBackupStatus cloudBackupStatus : list) {
            m59474C0(cloudBackupStatus);
            new C9195d0(this.f47342a, cloudBackupStatus).m57757s("module_reset_from_module_upload_brief_file_not_exist");
        }
    }

    /* renamed from: Q */
    public final void m59477Q() throws C9721b {
        for (CloudBackupStatus cloudBackupStatus : this.f47335o) {
            int iM29859L = cloudBackupStatus.m29859L();
            String strM29870d = cloudBackupStatus.m29870d();
            if ((iM29859L == 0 && TextUtils.isEmpty(cloudBackupStatus.m29398d1())) || 6 == iM29859L || 5 == iM29859L) {
                C11839m.m70686d("CloudBackupV3Module3rdAppOperate", "no need check status, appId = " + strM29870d + ", status = " + iM29859L);
            } else {
                File fileM63442h = C10278a.m63442h(ICBUtil.getLocationAPKFilePath(this.f47342a.getLocation(), strM29870d, C12590s0.m75778O(cloudBackupStatus)));
                if (fileM63442h.exists()) {
                    C11839m.m70686d("CloudBackupV3Module3rdAppOperate", "check status valid, appId = " + strM29870d + ", status = " + iM29859L + ", is3rdInvalid: , apkFile exist: " + fileM63442h.exists());
                } else {
                    C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "check status illegal, appId = " + strM29870d + ", status = " + iM29859L + ", apkFile exist: " + fileM63442h.exists());
                    m59474C0(cloudBackupStatus);
                    new C9195d0(this.f47342a, cloudBackupStatus).m57757s("module_reset_from_module_app_batch_overdue");
                }
            }
        }
    }

    /* renamed from: R */
    public final void m59478R(CloudBackupStatus cloudBackupStatus) throws InterruptedException, C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        File fileM59506c = m59506c(cloudBackupStatus, this.f47342a.m29731o0().m61953z().get(strM29870d));
        C9720a.m60657f(fileM59506c, "normalApk is null appId: " + strM29870d);
        cloudBackupStatus.mo29321d0(fileM59506c.length());
        cloudBackupStatus.m29405g2("");
        cloudBackupStatus.m29350G1("");
        new C12815f(this.f47347f).m76934m(cloudBackupStatus);
    }

    /* renamed from: S */
    public final void m59479S(List<CloudBackupStatus> list) throws InterruptedException, C9721b {
        m59511j();
        List list2 = (List) list.stream().filter(new Predicate() { // from class: em.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f47321a.m59493h0((CloudBackupStatus) obj);
            }
        }).filter(new Predicate() { // from class: em.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f47322a.m59494i0((CloudBackupStatus) obj);
            }
        }).map(new Function() { // from class: em.j
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f47323a.m59486Z((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        int i10 = 0;
        while (true) {
            long j10 = i10;
            if (this.f47340t * j10 >= list2.size()) {
                return;
            }
            try {
                this.f47354m.m63584z(this.f47342a.m29728n0(), this.f47346e, this.f47345d, this.f47339s, (List) list2.stream().skip(j10 * this.f47340t).limit(this.f47340t).collect(Collectors.toList()), new Consumer() { // from class: em.k
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f47324a.m59495j0((Pair) obj);
                    }
                });
            } catch (C9721b e10) {
                C11839m.m70689w("CloudBackupV3Module3rdAppOperate", "copy error: " + e10.getMessage());
            }
            i10++;
        }
    }

    /* renamed from: T */
    public final void m59480T(List<CloudBackupStatus> list) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        int i10;
        m59511j();
        ArrayList arrayList = new ArrayList();
        Iterator<CloudBackupStatus> it = list.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            CloudBackupStatus next = it.next();
            String strM29870d = next.m29870d();
            Map<String, String> mapM59504a = m59504a(next, false);
            String strM1337e = (next.m29867U() || next.m29866T()) ? "" : C0210d0.m1337e(C0213f.m1377a(), next.mo29421n());
            if (!TextUtils.isEmpty(strM1337e)) {
                mapM59504a.put("signatures", strM1337e);
            }
            C12590s0.m75817X2(next, strM1337e);
            AppCreate appCreate = new AppCreate();
            appCreate.setApkType(Integer.valueOf(next.m29872f())).setBackupAppName(strM29870d).setBackupDeviceId(this.f47346e).setBackupRecordId(this.f47345d).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setCreateTime(new C4644l(System.currentTimeMillis())).setFileCount(Integer.valueOf(next.m29877l())).setAppTotalSize(Long.valueOf(next.m29875i())).setPackageVersion(next.m29407h1()).setRuntimeType(Integer.valueOf(next.m29400e1())).setProperties(mapM59504a);
            if (next.mo29370Q()) {
                appCreate.setSplitApkType(next.mo29357K());
            }
            if (next.m29863P()) {
                appCreate.setPackageFileName(strM29870d + ".apk").setIconFileName(strM29870d + ".icon");
            }
            arrayList.add(new Pair(next, appCreate));
        }
        if (arrayList.size() == 1) {
            CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) ((Pair) arrayList.get(0)).first;
            cloudBackupStatus.m29405g2(this.f47354m.m63542F(this.f47342a.m29728n0(), this.f47346e, this.f47345d, (AppCreate) ((Pair) arrayList.get(0)).second, 0).getId());
            this.f47348g.m76934m(cloudBackupStatus);
        } else {
            while (true) {
                long j10 = i10;
                if (this.f47340t * j10 >= arrayList.size()) {
                    return;
                }
                this.f47354m.m63534A(this.f47342a.m29728n0(), this.f47346e, this.f47345d, (List) arrayList.stream().skip(j10 * this.f47340t).limit(this.f47340t).collect(Collectors.toList()), new Consumer() { // from class: em.n
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f47327a.m59496k0((Pair) obj);
                    }
                });
                i10++;
            }
        }
    }

    /* renamed from: U */
    public void m59481U(Exception exc) {
        C11839m.m70687e("CloudBackupV3Module3rdAppOperate", "dealException: " + exc.getMessage());
        mo57894p(exc);
        CloudBackupStatus cloudBackupStatus = this.f47341u;
        if (cloudBackupStatus != null) {
            this.f47342a.m29599v(cloudBackupStatus.m29870d());
            this.f47342a.m29600y(this.f47341u.m29861N());
            this.f47342a.m29656P(this.f47341u, this.f47351j);
        }
    }

    /* renamed from: V */
    public void m59482V() {
        String strM80987x0 = C13452e.m80781L().m80987x0();
        String strM75747G0 = C12590s0.m75747G0();
        for (CloudBackupStatus cloudBackupStatus : this.f47335o) {
            Map<String, String> mapM59489c0 = m59489c0(cloudBackupStatus.m29870d());
            if (!TextUtils.isEmpty(strM80987x0)) {
                mapM59489c0.put("userType", strM80987x0);
            }
            mapM59489c0.put("bakCategory", String.valueOf(this.f47342a.m29587j()));
            if (this.f47342a.m29636F0() != null) {
                mapM59489c0.put("occupySpaceType", String.valueOf(this.f47342a.m29636F0()));
            }
            mapM59489c0.put("gradeCode", strM75747G0);
            C12590s0.m75733C2(cloudBackupStatus, mapM59489c0, this.f47345d, this.f47353l, this.f47342a.isRefurbishment(), this.f47342a.mo29591n(), this.f47342a.m29722l0().mo1759d());
            this.f47343b.m61952y0(this.f47343b.m61903U() + cloudBackupStatus.m29875i());
            long jM1688f = C0241z.m1688f(mapM59489c0.get("moduleUploadSize"));
            this.f47343b.m61883A0(this.f47343b.m61905W() + jM1688f);
            if (cloudBackupStatus.m29859L() == 6) {
                this.f47343b.m61954z0(this.f47343b.m61904V() + jM1688f);
            }
            C12182i.m73283j().m73300t(cloudBackupStatus);
            this.f47343b.m61946v0(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
        }
    }

    /* renamed from: W */
    public void m59483W(CloudBackupStatus cloudBackupStatus, Map<String, String> map) throws ExecutionException, InterruptedException, C9721b {
        synchronized (f47333v) {
            int iM29859L = cloudBackupStatus.m29859L();
            if (6 != iM29859L && 5 != iM29859L) {
                m59518r(cloudBackupStatus, null, null);
                C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "module create task start, appId = " + cloudBackupStatus.m29870d() + ", userId = " + cloudBackupStatus.m29861N());
                m59511j();
                cloudBackupStatus.m29436s2(System.currentTimeMillis());
                try {
                    C12182i.m73283j().m73284c(cloudBackupStatus, new C9276z(this.f47342a, this, this.f47344c, cloudBackupStatus, this.f47347f, map)).get();
                    m59511j();
                    C12182i.m73283j().m73299s(cloudBackupStatus);
                    C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "module create task end, appId = " + cloudBackupStatus.m29870d() + ", userId = " + cloudBackupStatus.m29861N());
                    return;
                } catch (InterruptedException e10) {
                    C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "create task InterruptedException");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create task InterruptedException, appId = " + cloudBackupStatus.m29870d() + " msg: " + e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
                } catch (ExecutionException e11) {
                    e = e11;
                    C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "create task ExecutionException");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("create task ExecutionException, appId = ");
                    sb2.append(cloudBackupStatus.m29870d());
                    sb2.append(" msg: ");
                    sb2.append(e.getMessage());
                    sb2.append(" stack: ");
                    if (e.getCause() != null) {
                        e = e.getCause();
                    }
                    sb2.append(C12590s0.m75731C0(e));
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, sb2.toString());
                }
            }
            C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "no need create, appId = " + cloudBackupStatus.m29870d() + ", userId = " + cloudBackupStatus.m29861N());
        }
    }

    /* renamed from: X */
    public void m59484X() throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        m59511j();
        List<CloudBackupStatus> list = (List) this.f47335o.stream().filter(new Predicate() { // from class: em.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59457p0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        m59485Y(list);
        for (CloudBackupStatus cloudBackupStatus : list) {
            cloudBackupStatus.mo29338z0(6).mo29289A0(7);
            this.f47348g.m76934m(cloudBackupStatus);
            C11963c.m71970y(cloudBackupStatus, this.f47347f);
            int iM29861N = cloudBackupStatus.m29861N();
            C11965e.m71974f().m71985n(cloudBackupStatus.m29870d(), iM29861N);
            this.f47343b.m61895M().remove(iM29861N == 0 ? cloudBackupStatus.m29870d() : cloudBackupStatus.m29870d() + iM29861N);
            C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "do one module finish end, appId = " + cloudBackupStatus.m29870d() + ", uid = " + iM29861N);
        }
    }

    /* renamed from: Y */
    public final void m59485Y(List<CloudBackupStatus> list) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        m59511j();
        ArrayList arrayList = new ArrayList();
        for (CloudBackupStatus cloudBackupStatus : list) {
            cloudBackupStatus.m29384W1(this.f47342a.m29687Z0(cloudBackupStatus));
            Map<String, String> mapM59504a = m59504a(cloudBackupStatus, true);
            mapM59504a.put("snapshotvalidflag", "valid");
            AppFinish appFinish = new AppFinish();
            appFinish.setUpdateTime(new C4644l(System.currentTimeMillis())).setFileCount(Integer.valueOf(cloudBackupStatus.m29877l())).setAppTotalSize(Long.valueOf(cloudBackupStatus.m29875i())).setPackageVersion(cloudBackupStatus.m29407h1()).setRuntimeType(Integer.valueOf(cloudBackupStatus.m29400e1())).setProperties(mapM59504a);
            arrayList.add(new Pair(cloudBackupStatus, appFinish));
        }
        int i10 = 0;
        while (true) {
            long j10 = i10;
            if (this.f47340t * j10 >= arrayList.size()) {
                return;
            }
            this.f47354m.m63536B(this.f47342a.m29728n0(), this.f47346e, this.f47345d, (List) arrayList.stream().skip(j10 * this.f47340t).limit(this.f47340t).collect(Collectors.toList()), new Consumer() { // from class: em.m
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f47326a.m59500o0((Pair) obj);
                }
            });
            i10++;
        }
    }

    /* renamed from: Z */
    public final Pair<AppCreate, Pair<CloudBackupStatus, App>> m59486Z(CloudBackupStatus cloudBackupStatus) {
        AppCreate appCreate = new AppCreate();
        appCreate.setApkType(Integer.valueOf(cloudBackupStatus.m29872f())).setBackupAppName(cloudBackupStatus.m29870d()).setBackupDeviceId(this.f47346e).setBackupRecordId(this.f47345d).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setCreateTime(new C4644l(System.currentTimeMillis())).setFileCount(Integer.valueOf(cloudBackupStatus.m29877l())).setAppTotalSize(Long.valueOf(cloudBackupStatus.m29875i())).setPackageVersion(cloudBackupStatus.m29407h1()).setPackageFileName(cloudBackupStatus.m29870d() + ".apk").setIconFileName(cloudBackupStatus.m29870d() + ".icon").setRuntimeType(Integer.valueOf(cloudBackupStatus.m29400e1()));
        if (cloudBackupStatus.mo29370Q()) {
            appCreate.setSplitApkType(cloudBackupStatus.mo29357K());
        }
        return new Pair<>(appCreate, new Pair(cloudBackupStatus, this.f47338r.get(cloudBackupStatus.m29870d())));
    }

    /* renamed from: a0 */
    public final AppRefresh m59487a0() {
        HashMap map = new HashMap();
        map.put("snapshotvalidflag", FeedbackConst.SDK.INVALID_ACCESS_TOKEN);
        AppRefresh appRefresh = new AppRefresh();
        appRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setBackupAppStatus(1);
        appRefresh.setProperties((Map<String, String>) map);
        return appRefresh;
    }

    /* renamed from: b0 */
    public C9721b m59488b0() {
        return this.f47351j;
    }

    /* renamed from: c0 */
    public final Map<String, String> m59489c0(String str) {
        return this.f47336p.computeIfAbsent(str, new Function() { // from class: em.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C9525y.m59458q0((String) obj);
            }
        });
    }

    /* renamed from: d0 */
    public final boolean m59490d0(Map<String, App> map, Map<String, PackageInfo> map2, CloudBackupStatus cloudBackupStatus) {
        App app;
        PackageInfo packageInfo = map2.get(cloudBackupStatus.mo29421n());
        if (packageInfo == null || map == null || (app = map.get(cloudBackupStatus.m29870d())) == null) {
            return false;
        }
        long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
        cloudBackupStatus.m29439t2(String.valueOf(longVersionCode));
        String backupAppName = app.getBackupAppName();
        int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
        long jM1688f = C0241z.m1688f(app.getPackageVersion());
        C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "curUid: " + iM1685c + ", curAppId: " + backupAppName + ", versionCode: " + longVersionCode + ", backupVersionCode: " + jM1688f);
        return longVersionCode != 0 && longVersionCode <= jM1688f;
    }

    @Override // p262em.AbstractC9526z
    /* renamed from: e */
    public void mo57881e(CloudBackupStatus cloudBackupStatus) throws InterruptedException {
        try {
            cloudBackupStatus.m29384W1(this.f47342a.m29687Z0(cloudBackupStatus));
            m59478R(cloudBackupStatus);
        } catch (C9721b e10) {
            mo57894p(e10);
        }
    }

    /* renamed from: e0 */
    public final boolean m59491e0(CloudBackupStatus cloudBackupStatus) {
        C4879a c4879a = this.f47342a;
        if (c4879a == null || c4879a.m29731o0() == null || this.f47342a.m29731o0().m61892J() == null || cloudBackupStatus == null) {
            return false;
        }
        boolean zContainsKey = this.f47342a.m29731o0().m61892J().containsKey(cloudBackupStatus.m29870d());
        m59489c0(cloudBackupStatus.m29870d()).put("leftSpaceSize", zContainsKey ? "1" : "0");
        C11839m.m70686d("CloudBackupV3Module3rdAppOperate", cloudBackupStatus.m29870d() + " isAppLost : " + zContainsKey);
        return zContainsKey;
    }

    @Override // p262em.AbstractC9526z
    /* renamed from: f */
    public void mo57883f() {
        List<CloudBackupStatus> list;
        Consumer consumer;
        try {
            m59509h().getPackageManager().getInstalledPackages(16384).forEach(new Consumer() { // from class: em.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f47318a.m59497l0((PackageInfo) obj);
                }
            });
            int i10 = 0;
            while (true) {
                long j10 = i10;
                if (this.f47340t * j10 >= this.f47334n.size()) {
                    break;
                }
                this.f47335o = (List) this.f47334n.stream().skip(j10 * this.f47340t).limit(this.f47340t).collect(Collectors.toList());
                C0225l.m1578b(new InterfaceC14356c() { // from class: em.l
                    @Override // p851zp.InterfaceC14356c
                    public final Object execute() {
                        return this.f47325a.m59498m0();
                    }
                }, new Consumer() { // from class: em.q
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f47330a.m59481U((Exception) obj);
                    }
                }, new InterfaceC14358e() { // from class: em.r
                    @Override // p851zp.InterfaceC14358e
                    public final void execute() {
                        this.f47331a.m59482V();
                    }
                });
                m59511j();
                i10++;
            }
            list = this.f47334n;
            consumer = new Consumer() { // from class: em.s
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f47332a.m59499n0((CloudBackupStatus) obj);
                }
            };
        } catch (Throwable th2) {
            try {
                mo57894p(th2);
                C11839m.m70689w("CloudBackupV3Module3rdAppOperate", "backup error, errCode:" + this.f47351j.m60659c() + " errMsg:" + this.f47351j.toString() + " throwable:" + th2.getMessage());
                list = this.f47334n;
                consumer = new Consumer() { // from class: em.s
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f47332a.m59499n0((CloudBackupStatus) obj);
                    }
                };
            } catch (Throwable th3) {
                this.f47334n.forEach(new Consumer() { // from class: em.s
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f47332a.m59499n0((CloudBackupStatus) obj);
                    }
                });
                throw th3;
            }
        }
        list.forEach(consumer);
    }

    /* renamed from: f0 */
    public final /* synthetic */ boolean m59492f0(CloudBackupStatus cloudBackupStatus) {
        return m59513l(cloudBackupStatus.m29404g1(), this.f47350i);
    }

    /* renamed from: h0 */
    public final /* synthetic */ boolean m59493h0(CloudBackupStatus cloudBackupStatus) {
        return !m59491e0(cloudBackupStatus);
    }

    /* renamed from: i0 */
    public final /* synthetic */ boolean m59494i0(CloudBackupStatus cloudBackupStatus) {
        return m59490d0(this.f47338r, this.f47337q, cloudBackupStatus);
    }

    /* renamed from: j0 */
    public final /* synthetic */ void m59495j0(Pair pair) {
        try {
            App app = (App) pair.first;
            CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) pair.second;
            cloudBackupStatus.m29405g2(app.getId());
            this.f47348g.m76934m(cloudBackupStatus);
            C12535a.m75457b(this.f47342a, cloudBackupStatus, this.f47339s, app.getAttachments());
            if (TextUtils.isEmpty(cloudBackupStatus.m29398d1()) || !C12535a.m75462j(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N())) {
                cloudBackupStatus.m29405g2("");
                cloudBackupStatus.m29350G1("");
                this.f47348g.m76934m(cloudBackupStatus);
            } else {
                C11839m.m70688i("CloudBackupV3Module3rdAppOperate", "copy app record id: " + app.getId() + ", app: " + cloudBackupStatus.m29870d());
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Module3rdAppOperate", "copy error: " + e10.getMessage());
        }
    }

    /* renamed from: k0 */
    public final /* synthetic */ void m59496k0(Pair pair) {
        try {
            App app = (App) pair.first;
            CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) pair.second;
            cloudBackupStatus.m29405g2(app.getId());
            this.f47348g.m76934m(cloudBackupStatus);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Module3rdAppOperate", "create error: " + e10.getMessage());
            mo57894p(e10);
        }
    }

    /* renamed from: l0 */
    public final /* synthetic */ void m59497l0(PackageInfo packageInfo) {
        this.f47337q.put(packageInfo.packageName, packageInfo);
    }

    /* renamed from: m0 */
    public final /* synthetic */ Boolean m59498m0() throws Exception {
        m59503z0();
        m59475D0();
        m59484X();
        return Boolean.TRUE;
    }

    /* renamed from: n0 */
    public final /* synthetic */ void m59499n0(CloudBackupStatus cloudBackupStatus) {
        C11965e.m71974f().m71985n(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
        C12182i.m73283j().m73300t(cloudBackupStatus);
        this.f47343b.m61946v0(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
    }

    /* renamed from: o0 */
    public final /* synthetic */ void m59500o0(Pair pair) {
        m59516o((App) pair.first, (CloudBackupStatus) pair.second);
    }

    @Override // p262em.AbstractC9526z
    /* renamed from: p */
    public void mo57894p(Throwable th2) {
        if (this.f47351j == null) {
            if (th2 instanceof C9721b) {
                this.f47351j = (C9721b) th2;
                return;
            }
            this.f47351j = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error." + th2.toString() + ",stackTrace: " + C12590s0.m75731C0(th2));
        }
    }

    /* renamed from: s0 */
    public final /* synthetic */ Pair m59501s0(CloudBackupStatus cloudBackupStatus) {
        return new Pair(cloudBackupStatus, m59487a0());
    }

    /* renamed from: t0 */
    public final /* synthetic */ void m59502t0(Pair pair) {
        App app = (App) pair.first;
        CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) pair.second;
        if (app.getBackupAppStatus().intValue() != 1) {
            mo57894p(new C9721b(3911, "Backup.device.bak.app.refresh error. backupAppId = " + cloudBackupStatus.m29398d1(), "Backup.device.bak.app.refresh"));
        }
    }

    /* renamed from: z0 */
    public void m59503z0() throws InterruptedException, C9721b {
        m59476P();
        m59477Q();
        m59511j();
        this.f47335o.forEach(new Consumer() { // from class: em.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f47319a.m59472A0((CloudBackupStatus) obj);
            }
        });
        List<CloudBackupStatus> list = (List) this.f47335o.stream().filter(new Predicate() { // from class: em.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9525y.m59459r0((CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList());
        m59479S(list);
        for (CloudBackupStatus cloudBackupStatus : list) {
            cloudBackupStatus.mo29338z0(1).mo29289A0(2).mo29310W(0).mo29308V(0L);
            this.f47348g.m76934m(cloudBackupStatus);
            C11963c.m71970y(cloudBackupStatus, this.f47347f);
        }
    }
}
