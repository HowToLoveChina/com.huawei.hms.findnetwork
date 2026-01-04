package dm;

import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.PmsDataV3Processor;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileReuse;
import com.huawei.hicloud.cloudbackup.store.database.report.CloudBackupReport;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import fk.C9721b;
import gm.C9989d;
import hk.C10278a;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import om.C11963c;
import om.C11965e;
import p015ak.C0241z;
import p262em.AbstractC9526z;
import p495nm.C11723d;
import p495nm.C11728i;
import p495nm.C11730k;
import p495nm.C11735p;
import p514o9.C11839m;
import p582ql.C12372c;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12571m;
import p618rm.C12586r;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p618rm.C12598v;
import p682ul.C13216j;
import p709vj.C13452e;
import p744wl.C13617a;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import p851zp.InterfaceC14354a;
import p851zp.InterfaceC14355b;
import pl.C12159a;
import pl.C12160b;
import pl.C12161c;
import pl.C12164f;
import pl.C12167i;
import pm.C12182i;
import sl.C12812c;
import sl.C12815f;

/* renamed from: dm.i0 */
/* loaded from: classes6.dex */
public class C9215i0 extends AbstractC9526z {

    /* renamed from: O */
    public static final Object f46235O = new Object();

    /* renamed from: A */
    public C9271x0 f46236A;

    /* renamed from: B */
    public C9276z f46237B;

    /* renamed from: C */
    public CloudBackupStatus f46238C;

    /* renamed from: D */
    public long f46239D;

    /* renamed from: E */
    public long f46240E;

    /* renamed from: F */
    public boolean f46241F;

    /* renamed from: G */
    public String f46242G;

    /* renamed from: H */
    public C11730k f46243H;

    /* renamed from: I */
    public boolean f46244I;

    /* renamed from: J */
    public C12526j f46245J;

    /* renamed from: K */
    public final ReentrantLock f46246K;

    /* renamed from: L */
    public List<C11723d> f46247L;

    /* renamed from: M */
    public final C11735p f46248M;

    /* renamed from: N */
    public final C11728i f46249N;

    /* renamed from: n */
    public CloudBackupAppDataUtil f46250n;

    /* renamed from: o */
    public boolean f46251o;

    /* renamed from: p */
    public String f46252p;

    /* renamed from: q */
    public String f46253q;

    /* renamed from: r */
    public String f46254r;

    /* renamed from: s */
    public int f46255s;

    /* renamed from: t */
    public final Object f46256t;

    /* renamed from: u */
    public long f46257u;

    /* renamed from: v */
    public long f46258v;

    /* renamed from: w */
    public Map<String, Bundle> f46259w;

    /* renamed from: x */
    public C12594t1 f46260x;

    /* renamed from: y */
    public Map<String, String> f46261y;

    /* renamed from: z */
    public boolean f46262z;

    public C9215i0(C4879a c4879a, C9989d c9989d, CloudBackupStatus cloudBackupStatus, String str, int i10) {
        super(c4879a, c9989d);
        this.f46251o = false;
        this.f46256t = new Object();
        this.f46260x = C12594t1.m75990o();
        this.f46261y = new HashMap();
        this.f46262z = true;
        this.f46239D = 0L;
        this.f46240E = 0L;
        this.f46244I = false;
        this.f46245J = new C12526j();
        this.f46246K = new ReentrantLock();
        this.f46247L = new ArrayList();
        C11735p c11735p = new C11735p();
        this.f46248M = c11735p;
        this.f46249N = new C11728i(c11735p);
        this.f47342a = c4879a;
        this.f46243H = c4879a.m29746t0();
        this.f46257u = c9989d.m61886D();
        this.f46258v = c9989d.m61900R();
        this.f46259w = c9989d.m61953z();
        this.f46252p = c9989d.m61951y();
        this.f46238C = cloudBackupStatus;
        List<C11723d> listM29707g0 = c4879a.m29707g0();
        listM29707g0.addAll(this.f46247L);
        c4879a.m29706f2(listM29707g0);
        this.f46253q = this.f47344c.m78465h();
        this.f46254r = str;
        this.f46255s = i10;
        this.f46262z = c9989d.m61917f0();
    }

    /* renamed from: A */
    public final void m57851A(int i10) {
        C12167i c12167i = new C12167i(this.f46253q, this.f46254r, 0, i10);
        if (c12167i.m73162e()) {
            return;
        }
        c12167i.m73159a();
    }

    /* renamed from: B */
    public final void m57852B(boolean z10) {
        if (z10) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "time expired,reset module:" + this.f46254r);
            C12598v.m76045m(this.f47345d, this.f46254r);
        }
    }

    /* renamed from: C */
    public final void m57853C() throws C9721b {
        if (this.f46238C.m29393b1().contains("isDiff")) {
            C12160b c12160b = new C12160b(this.f46253q, this.f46254r, 0, this.f46238C.m29861N());
            List<C12159a> listM72941l = c12160b.m72941l(1);
            listM72941l.addAll(c12160b.m72941l(2));
            boolean zM57882e0 = m57882e0(listM72941l, new C12164f(this.f46253q, this.f46254r, 0, this.f46238C.m29861N()).m73068a0(9));
            C11839m.m70688i("CloudBackupV3ModuleOperate", "checkSnapshotAndDiffDbMeta equals: " + zM57882e0);
            if (zM57882e0) {
                c12160b.m72932c(1);
            } else {
                new C9195d0(this.f47342a, this.f46238C).m57757s("module_reset_from_diffpacket_not_equal");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkSnapshotAndDiffDbMeta snapshot and diff not match");
            }
        }
    }

    /* renamed from: D */
    public final void m57854D() {
        String strM81915D = C13617a.m81915D(this.f46254r, this.f46255s, false);
        if (C10278a.m63442h(strM81915D).exists()) {
            try {
                new PmsFullBriefFilesInfoOperatorV3(strM81915D).dropCaclTarRefRatioTable();
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3ModuleOperate", "fullBrief dropTarTable err: " + e10.getMessage());
            }
        }
        if (C10278a.m63442h(C13617a.m81943y(this.f46253q, this.f46254r, 0, this.f46255s, false)).exists()) {
            try {
                new C12164f(this.f46253q, this.f46254r, 0, this.f46255s).dropCaclTarRefRatioTable();
            } catch (C9721b e11) {
                C11839m.m70687e("CloudBackupV3ModuleOperate", "backupMeta dropTarTable err: " + e11.getMessage());
            }
        }
    }

    /* renamed from: E */
    public void m57855E(CloudBackupStatus cloudBackupStatus, Map<String, String> map) throws ExecutionException, InterruptedException, C9721b {
        synchronized (f46235O) {
            m57853C();
            int iM29859L = cloudBackupStatus.m29859L();
            if (6 != iM29859L && 5 != iM29859L) {
                m59518r(cloudBackupStatus, null, null);
                if (iM29859L != 4) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "do one module creat error, appId = " + cloudBackupStatus.m29870d() + ", status illegal, status = " + iM29859L + ", userId = " + this.f46255s);
                }
                m59511j();
                m57899t0();
                C11839m.m70688i("CloudBackupV3ModuleOperate", "module create task start, appId = " + this.f46254r + ", userId = " + this.f46255s);
                m59511j();
                cloudBackupStatus.mo29289A0(5);
                this.f46237B = new C9276z(this.f47342a, this, this.f47344c, cloudBackupStatus, this.f46252p, map);
                try {
                    C12182i.m73283j().m73284c(cloudBackupStatus, this.f46237B).get();
                    C12182i.m73283j().m73299s(cloudBackupStatus);
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "module create task end, appId = " + this.f46254r + ", userId = " + this.f46255s);
                    return;
                } catch (InterruptedException unused) {
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "create task InterruptedException");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create task InterruptedException, appId = " + this.f46254r);
                } catch (ExecutionException unused2) {
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "create task ExecutionException");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create task ExecutionException, appId = " + this.f46254r);
                }
            }
            C11839m.m70688i("CloudBackupV3ModuleOperate", "no need create, appId = " + cloudBackupStatus.m29870d() + ", userId = " + this.f46255s);
        }
    }

    /* renamed from: F */
    public void m57856F(CloudBackupStatus cloudBackupStatus) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        String strM29870d;
        int iM29859L = cloudBackupStatus.m29859L();
        if (6 == iM29859L) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "no need finish, appId = " + cloudBackupStatus.m29870d() + ", userId = " + this.f46255s);
            return;
        }
        if (5 != iM29859L) {
            C11839m.m70687e("CloudBackupV3ModuleOperate", "do one module finish error, appId = " + cloudBackupStatus.m29870d() + ", status illegal, status = " + iM29859L + ", userId = " + this.f46255s);
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "do one module finish error, appId = " + cloudBackupStatus.m29870d() + ", status illegal, status = " + iM29859L + ", userId = " + this.f46255s);
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "do one module finish start, appId = " + cloudBackupStatus.m29870d() + ", userId = " + this.f46255s);
        if ("safebox".equalsIgnoreCase(cloudBackupStatus.m29870d()) || "safebox1".equalsIgnoreCase(this.f46254r)) {
            cloudBackupStatus.m29361L1(C12590s0.m75906t2());
        }
        m59511j();
        m57863M(cloudBackupStatus, cloudBackupStatus.m29379U0());
        m59511j();
        cloudBackupStatus.mo29338z0(6).mo29289A0(7);
        this.f47348g.m76934m(cloudBackupStatus);
        C11963c.m71970y(cloudBackupStatus, this.f46252p);
        int iM29861N = cloudBackupStatus.m29861N();
        C11965e.m71974f().m71985n(cloudBackupStatus.m29870d(), iM29861N);
        if (iM29861N == 0) {
            strM29870d = cloudBackupStatus.m29870d();
        } else {
            strM29870d = cloudBackupStatus.m29870d() + iM29861N;
        }
        this.f47343b.m61895M().remove(strM29870d);
        this.f47343b.m61927l(cloudBackupStatus.m29870d(), cloudBackupStatus.mo29421n(), iM29861N);
        this.f46244I = true;
        C11839m.m70688i("CloudBackupV3ModuleOperate", "do one module finish end, appId = " + cloudBackupStatus.m29870d() + ", userId = " + this.f46255s);
    }

    /* renamed from: G */
    public void m57857G(PmsDataV3Processor pmsDataV3Processor, CloudBackupStatus cloudBackupStatus, long j10, long j11) throws C9721b {
        m59511j();
        if (cloudBackupStatus.m29860M() != 4) {
            if (cloudBackupStatus.m29875i() > 0) {
                cloudBackupStatus.mo29289A0(4);
            }
            C11963c.m71970y(cloudBackupStatus, this.f46252p);
        }
        C12182i.m73283j().m73288g(cloudBackupStatus, new C9184a1(pmsDataV3Processor, this.f47342a, this, cloudBackupStatus, j10, j11, this.f46249N));
    }

    /* renamed from: H */
    public final void m57858H(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil, Map<String, String> map, Bundle bundle) throws IllegalAccessException, InterruptedException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("CloudBackupV3ModuleOperate", "one module prepare start, appId = " + this.f46254r + ", userId = " + this.f46255s);
        try {
            m59511j();
            if (cloudBackupStatus.m29860M() == -1) {
                new C9195d0(this.f47342a, cloudBackupStatus).m57757s("module_reset_from_app_prepare_reset");
                C12598v.m76045m(this.f47345d, this.f46254r);
            }
            if (cloudBackupStatus.m29863P()) {
                cloudBackupStatus.m29384W1(this.f47342a.m29687Z0(cloudBackupStatus));
            }
            C11965e.m71974f().m71986o(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
            cloudBackupStatus.mo29338z0(1).mo29289A0(1).m29374R1(0L).m29342C1(0L).mo29310W(0).mo29308V(0L);
            m59515n(null, cloudBackupStatus);
            if (this.f47349h) {
                cloudBackupStatus.m29341B1(1);
            }
            this.f47348g.m76934m(cloudBackupStatus);
            C11963c.m71970y(cloudBackupStatus, this.f46252p);
            C12571m.m75547i(C12586r.m75714e(this.f46254r, this.f46255s));
            this.f47343b.m61922i(cloudBackupStatus, map);
            if (!C14333b.m85455K().contains(this.f46254r) && !cloudBackupStatus.m29867U()) {
                C11839m.m70688i("CloudBackupV3ModuleOperate", "need prepare data, appId: " + this.f46254r + ", userId = " + this.f46255s);
                this.f47342a.m29751u2(cloudBackupStatus.m29863P() || cloudBackupStatus.m29867U(), this.f46254r, this.f46255s);
                long jCurrentTimeMillis = System.currentTimeMillis();
                new C9231m0(this.f47342a, this, this.f47344c, this.f46252p, this.f46262z).m58000q(cloudBackupStatus, bundle, cloudBackupAppDataUtil);
                map.put(ParamConstants.CallbackMethod.ON_PREPARE, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            }
            this.f47343b.m61889G().remove(cloudBackupStatus);
            m59511j();
            cloudBackupStatus.mo29338z0(1).m29374R1(System.currentTimeMillis());
            if (4 != cloudBackupStatus.m29860M()) {
                cloudBackupStatus.mo29289A0(2);
            }
            this.f47348g.m76934m(cloudBackupStatus);
            C11963c.m71970y(cloudBackupStatus, this.f46252p);
            C11839m.m70688i("CloudBackupV3ModuleOperate", "one module prepare end, appId = " + this.f46254r + ", userId = " + this.f46255s);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleOperate", "one module prepare error, appId = " + this.f46254r + ", userId = " + this.f46255s + " errCode = " + e10.m60659c() + e10.toString());
            mo57894p(e10);
        }
    }

    /* renamed from: I */
    public final void m57859I(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil, Map<String, String> map) throws InterruptedException {
        try {
            m59511j();
            C11839m.m70688i("CloudBackupV3ModuleOperate", "one module scan start, appId = " + this.f46254r + ", userId = " + this.f46255s);
            long jCurrentTimeMillis = System.currentTimeMillis();
            new C9247q0(this.f47342a, this, cloudBackupStatus, cloudBackupAppDataUtil, cloudBackupAppDataUtil != null ? new ScanAppDataUtil(this.f46254r, cloudBackupStatus.m29861N(), cloudBackupStatus.mo29421n(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()) : null).m58053V(map);
            map.put("scan", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            C11839m.m70688i("CloudBackupV3ModuleOperate", "one module scan end, appId = " + this.f46254r + ", userId = " + this.f46255s);
        } catch (C9721b e10) {
            mo57894p(e10);
        }
    }

    /* renamed from: J */
    public final void m57860J(CloudBackupStatus cloudBackupStatus, Map<String, String> map) throws ExecutionException, InterruptedException, C9721b {
        m59511j();
        m57900u0();
        m59511j();
        C11839m.m70688i("CloudBackupV3ModuleOperate", "module upload task start, appId = " + this.f46254r + ", userId = " + this.f46255s);
        this.f46236A = new C9271x0(this.f47342a, this, this.f47344c, cloudBackupStatus, this.f46252p, map, this.f46249N);
        try {
            C12182i.m73283j().m73288g(cloudBackupStatus, this.f46236A).get();
            C12182i.m73283j().m73302v(cloudBackupStatus);
            C11839m.m70688i("CloudBackupV3ModuleOperate", "module upload task end, appId = " + this.f46254r + ", userId = " + this.f46255s);
        } catch (InterruptedException unused) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "upload task InterruptedException");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "upload task InterruptedException, appId = " + this.f46254r);
        } catch (ExecutionException unused2) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "upload task ExecutionException");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "upload task ExecutionException, appId = " + this.f46254r);
        }
    }

    /* renamed from: K */
    public final void m57861K(String str, CloudBackupStatus cloudBackupStatus) throws C9721b {
        if (!m59513l(cloudBackupStatus.m29404g1(), this.f47350i) && !m59514m(cloudBackupStatus)) {
            C11965e.m71974f().m71985n(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N());
            C11839m.m70688i("CloudBackupV3ModuleOperate", "success status, appId : " + str + ", userId = " + this.f46255s);
            return;
        }
        if (cloudBackupStatus.m29863P() && cloudBackupStatus.m29351H0() == 1 && !this.f47343b.m61899Q().contains(cloudBackupStatus)) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "do overdue 3rd app with data, appId = " + str + ", userId = " + this.f46255s);
            cloudBackupStatus.mo29406h0(-1);
            C11963c.m71970y(cloudBackupStatus, this.f46252p);
            this.f47343b.m61899Q().add(cloudBackupStatus);
            C11965e.m71974f().m71985n(str, cloudBackupStatus.m29861N());
            m57901v();
            return;
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "do overdue begin, appId = " + str + ", userId = " + this.f46255s + ", refresh app status");
        cloudBackupStatus.mo29338z0(0).mo29289A0(-1).mo29406h0(0).m29374R1(0L).m29342C1(0L).m29436s2(0L).m29423n2(0L).mo29310W(0).mo29308V(0L);
        this.f47348g.m76934m(cloudBackupStatus);
        C11963c.m71970y(cloudBackupStatus, this.f46252p);
        m57889k0(cloudBackupStatus);
        this.f47343b.m61899Q().remove(cloudBackupStatus);
    }

    /* renamed from: L */
    public void m57862L() throws ExecutionException, InterruptedException, C9721b {
        this.f46247L = this.f47342a.m29707g0();
        this.f46246K.lock();
        try {
            try {
                this.f46247L = (List) this.f46247L.stream().filter(new Predicate() { // from class: dm.e0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.f46164a.m57879c0((C11723d) obj);
                    }
                }).collect(Collectors.toList());
                if (this.f46238C.m29863P()) {
                    if (this.f46238C.m29411j1()) {
                        C12590s0.m75769L2(this.f46238C.m29870d(), this.f46247L, 0);
                    } else if (this.f46238C.m29409i1()) {
                        C12590s0.m75769L2(this.f46238C.m29870d(), this.f46247L, 1);
                    }
                } else if (!this.f46238C.m29425o1()) {
                    C12590s0.m75769L2(this.f46238C.m29870d(), this.f46247L, 0);
                } else if (this.f46238C.m29875i() == 0) {
                    C12590s0.m75769L2(this.f46238C.m29870d(), this.f46247L, 1);
                }
            } catch (Throwable th2) {
                this.f46246K.unlock();
                throw th2;
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3ModuleOperate", "appsUnbacked modify exception : " + e10.toString());
        }
        this.f46246K.unlock();
        m59511j();
        C11839m.m70688i("CloudBackupV3ModuleOperate", "finish start, appId = " + this.f46254r + ", userId = " + this.f46255s);
        if (this.f46238C.m29859L() == 6) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "no need finish, appId = " + this.f46254r + ", userId = " + this.f46255s);
            return;
        }
        if (m57868R() != null) {
            throw this.f47351j;
        }
        m59511j();
        m57896q0(this.f46261y);
        m57854D();
        m59511j();
        m57898s0();
        m59511j();
        m57855E(this.f46238C, this.f46261y);
        m59511j();
        try {
            m57856F(this.f46238C);
            this.f47342a.m29736p2(false);
            C11839m.m70688i("CloudBackupV3ModuleOperate", "finish end, appId = " + this.f46254r + ", userId = " + this.f46255s);
        } catch (Throwable th3) {
            this.f47342a.m29736p2(false);
            throw th3;
        }
    }

    /* renamed from: M */
    public final void m57863M(CloudBackupStatus cloudBackupStatus, String str) throws C9721b, PackageManager.NameNotFoundException {
        Map<String, String> mapM59504a = m59504a(cloudBackupStatus, true);
        mapM59504a.put("snapshotvalidflag", "valid");
        long jSum = new C12812c().m76887f(this.f46254r).stream().mapToLong(new C9203f0()).sum();
        long jLongValue = m57887i0(cloudBackupStatus, this.f46253q).longValue();
        C11839m.m70688i("CloudBackupV3ModuleOperate", "finishAppRecord appId:" + this.f46254r + ",DataBytes:" + cloudBackupStatus.m29875i() + ",attachSize:" + jSum + ",querySumLength:" + jLongValue);
        if (jLongValue > 0) {
            cloudBackupStatus.mo29323e0(jLongValue);
        }
        AppFinish appFinish = new AppFinish();
        appFinish.setUpdateTime(new C4644l(System.currentTimeMillis())).setFileCount(Integer.valueOf(cloudBackupStatus.m29877l())).setAppTotalSize(Long.valueOf(cloudBackupStatus.m29875i())).setPackageVersion(cloudBackupStatus.m29407h1()).setRuntimeType(Integer.valueOf(cloudBackupStatus.m29400e1())).setAttachmentsSize(Long.valueOf(jSum)).setProperties(mapM59504a);
        Pair<String, Integer> pairM57869S = m57869S();
        if (pairM57869S != null && !TextUtils.isEmpty((CharSequence) pairM57869S.first) && ((Integer) pairM57869S.second).intValue() > 0) {
            appFinish.setFileIdList((String) pairM57869S.first);
            appFinish.setFileIdNum((Integer) pairM57869S.second);
        }
        if (!TextUtils.isEmpty(str)) {
            appFinish.setBloomFilter(str);
        }
        App appM63550M = this.f47354m.m63550M(this.f47342a.m29728n0(), this.f47346e, this.f46253q, cloudBackupStatus.m29398d1(), cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), appFinish, 0);
        if (appM63550M.getBackupAppStatus().intValue() == 0) {
            m59516o(appM63550M, cloudBackupStatus);
            return;
        }
        throw new C9721b(3911, "Backup.device.bak.app.finish error. backupAppId = " + cloudBackupStatus.m29398d1(), "Backup.device.bak.app.finish");
    }

    /* renamed from: N */
    public CloudBackupStatus m57864N() {
        return this.f46238C;
    }

    /* renamed from: O */
    public C9989d m57865O() {
        return this.f47343b;
    }

    /* renamed from: P */
    public long m57866P() {
        return this.f46239D;
    }

    /* renamed from: Q */
    public long m57867Q() {
        return this.f46240E;
    }

    /* renamed from: R */
    public C9721b m57868R() {
        C9721b c9721b;
        synchronized (this.f46256t) {
            c9721b = this.f47351j;
        }
        return c9721b;
    }

    /* renamed from: S */
    public final Pair<String, Integer> m57869S() {
        C12526j c12526j;
        int iM75399j;
        String strJoin;
        int size;
        long length;
        try {
            c12526j = new C12526j();
            iM75399j = c12526j.m75399j();
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3ModuleOperate", "get allServerFilesCount error: " + e10);
        }
        if (iM75399j <= 0) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "not report appFileId");
            return null;
        }
        boolean zM75380c = c12526j.m75380c();
        C12164f c12164f = new C12164f(this.f46253q, this.f46254r, 0, this.f46255s);
        long jM73048M = c12164f.m73048M(this.f46254r);
        if (zM75380c) {
            jM73048M += c12164f.m73105t0(this.f46254r);
        }
        this.f46261y.put("allServerFilesCount", String.valueOf(jM73048M));
        if (jM73048M > iM75399j) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "getFileIdListStr allCount > appFileIdMaxCnt");
            return null;
        }
        List<String> listM73116z = c12164f.m73116z(this.f46254r);
        ArrayList arrayList = new ArrayList();
        if (zM75380c) {
            arrayList.addAll(c12164f.m73034F(this.f46254r));
            C12590s0.m75810W(arrayList);
            listM73116z.addAll(arrayList);
        }
        if (AbstractC14026a.m84159a(listM73116z)) {
            strJoin = null;
            size = 0;
            length = 0;
        } else {
            strJoin = String.join(",", listM73116z);
            length = strJoin.getBytes(StandardCharsets.UTF_8).length;
            size = listM73116z.size();
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "getFileIdListStr appId: " + this.f46254r + " ,appFileIdSupportVfs: " + zM75380c + " ,appFileIdMaxCnt: " + iM75399j + " ,allCount: " + listM73116z.size() + " ,vfsSize: " + arrayList.size() + " ,fileIdLength: " + length);
        if (length > 0 && length < this.f47342a.m29755w0()) {
            return new Pair<>(strJoin, Integer.valueOf(size));
        }
        return null;
    }

    /* renamed from: T */
    public Map<String, String> m57870T() {
        return this.f46261y;
    }

    /* renamed from: U */
    public final boolean m57871U(CloudBackupStatus cloudBackupStatus) {
        int iM29859L = cloudBackupStatus.m29859L();
        return (1 == iM29859L && (cloudBackupStatus.m29385X0() > 0L ? 1 : (cloudBackupStatus.m29385X0() == 0L ? 0 : -1)) <= 0) || (1 == iM29859L && (cloudBackupStatus.m29385X0() > 0L ? 1 : (cloudBackupStatus.m29385X0() == 0L ? 0 : -1)) > 0 && 1 == cloudBackupStatus.m29860M());
    }

    /* renamed from: V */
    public boolean m57872V() {
        return this.f47352k || this.f47342a.isAbort();
    }

    /* renamed from: W */
    public boolean m57873W(InterfaceC9213h2 interfaceC9213h2, String str) {
        boolean zMatches = false;
        if (!this.f46241F) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , isModuleSupportDiff false");
            return false;
        }
        if (TextUtils.isEmpty(this.f46242G)) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , dbDiffDBFileName == null or isEmpty");
            return false;
        }
        if (interfaceC9213h2 == null || !interfaceC9213h2.mo57843d0()) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , file == null || !file.exists()");
            return false;
        }
        if (!str.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , not match sdata , current = " + str);
            return false;
        }
        if (this.f46243H == null) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , diffConfig == null");
            return false;
        }
        long length = interfaceC9213h2.length();
        if (length < this.f46243H.m69991b() * 1048576) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , fileSize < DbIncrBack");
            return false;
        }
        if (length > this.f46243H.m69990a() * 1048576) {
            C11839m.m70686d("CloudBackupV3ModuleOperate", "isFileSupportDiff , fileSize > DBDiffMaxFileSize");
            return false;
        }
        String name = interfaceC9213h2.getName();
        try {
            zMatches = Pattern.matches(this.f46242G, name);
        } catch (PatternSyntaxException e10) {
            C11839m.m70687e("CloudBackupV3ModuleOperate", "isFileSupportDiff pattern syntax exception: " + e10.getMessage());
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "isFileSupportDiff ,regexMatch = " + zMatches + " ,appId : " + this.f46254r + ",fileName: " + name);
        return zMatches;
    }

    /* renamed from: X */
    public boolean m57874X() {
        if (!this.f47342a.m29750u1()) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "isModuleSupportDiff , client.isSupportDiff() false");
            return false;
        }
        if (this.f46250n == null || this.f46254r.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "isModuleSupportDiff , appDataUtil == null || appid.isEmpty()");
            return false;
        }
        AppInfoList appFileInfoList = this.f46250n.getAppFileInfoList();
        if (appFileInfoList == null) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "isModuleSupportDiff , appInfo == null");
            return false;
        }
        CloudBackup cloudBackup = appFileInfoList.getCloudBackup();
        if (cloudBackup == null) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "isModuleSupportDiff , cloudBackup == null");
            return false;
        }
        String dBDiffDBFileName = cloudBackup.getDBDiffDBFileName();
        this.f46242G = dBDiffDBFileName;
        if (TextUtils.isEmpty(dBDiffDBFileName)) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "isModuleSupportDiff , dbDiffDBFileName == null or isEmpty");
            return false;
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "isMatchDBDiffDBFileConfig , appid = " + this.f46254r + "match , isModuleSupport");
        return true;
    }

    /* renamed from: Y */
    public final boolean m57875Y(CloudBackupStatus cloudBackupStatus, int i10, int i11) {
        if (1 == i10 || 2 == i10) {
            return true;
        }
        if (3 != i10 || cloudBackupStatus.m29402f1() > 0) {
            return 3 == i10 && i11 == 0;
        }
        return true;
    }

    /* renamed from: Z */
    public final boolean m57876Z(String str) {
        return this.f47343b.m61893K().contains(str) || C12590s0.m75841d1(str, this.f47342a.mo29591n());
    }

    /* renamed from: a0 */
    public boolean m57877a0() {
        return this.f46251o;
    }

    /* renamed from: b0 */
    public final boolean m57878b0() {
        int iM29859L = this.f46238C.m29859L();
        String strM29870d = this.f46238C.m29870d();
        if (4 != iM29859L) {
            return true;
        }
        File fileM63442h = C10278a.m63442h(ICBUtil.getLocationAPKFilePath(this.f47342a.getLocation(), strM29870d, C12590s0.m75778O(this.f46238C)));
        C11839m.m70688i("CloudBackupV3ModuleOperate", "check status, appId = " + strM29870d + ", status = " + iM29859L + ", apkFile exist: " + fileM63442h.exists());
        return fileM63442h.exists();
    }

    /* renamed from: c0 */
    public final /* synthetic */ boolean m57879c0(C11723d c11723d) {
        return !TextUtils.equals(c11723d.m69946a(), this.f46238C.m29870d());
    }

    @Override // p262em.AbstractC9526z
    /* renamed from: e */
    public void mo57881e(CloudBackupStatus cloudBackupStatus) {
        int iM73026B;
        try {
            Bundle bundle = this.f46259w.get(this.f46254r);
            m57851A(cloudBackupStatus.m29861N());
            if (cloudBackupStatus.m29859L() == 0 || m57871U(cloudBackupStatus)) {
                m57858H(cloudBackupStatus, this.f46250n, this.f46261y, bundle);
            }
            try {
                iM73026B = new C12164f(this.f47345d, this.f46254r, 0, cloudBackupStatus.m29861N()).m73026B();
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3ModuleOperate", "doModulePrepare , get metasNum  CException:" + e10.getMessage());
                iM73026B = 0;
            }
            if (m57875Y(cloudBackupStatus, cloudBackupStatus.m29859L(), iM73026B)) {
                m57859I(cloudBackupStatus, this.f46250n, this.f46261y);
            }
            try {
                this.f47342a.m29751u2(false, this.f46254r, cloudBackupStatus.m29861N());
            } catch (C9721b e11) {
                mo57894p(e11);
            }
        } catch (Throwable th2) {
            try {
                this.f47342a.m29751u2(false, this.f46254r, cloudBackupStatus.m29861N());
            } catch (C9721b e12) {
                mo57894p(e12);
            }
            throw th2;
        }
    }

    /* renamed from: e0 */
    public final boolean m57882e0(List<C12159a> list, List<C12161c> list2) {
        if (list == null || list2 == null || list.isEmpty() || list2.isEmpty()) {
            C11839m.m70689w("CloudBackupV3ModuleOperate", "listEqual diffPacketMetaList or cloudBackupMetas is empty");
            return false;
        }
        HashMap map = new HashMap();
        for (C12159a c12159a : list) {
            if (c12159a.m72865A() == 0) {
                map.put(c12159a.m72867C() + c12159a.m72907j(), c12159a);
            }
        }
        for (C12161c c12161c : list2) {
            String str = c12161c.m72950F() + c12161c.m72991l();
            C12159a c12159a2 = (C12159a) map.get(str);
            if (c12159a2 == null || !TextUtils.equals(c12161c.m72946B(), c12159a2.m72928y())) {
                C11839m.m70688i("CloudBackupV3ModuleOperate", "listEqual path: " + str);
                return false;
            }
        }
        return true;
    }

    @Override // p262em.AbstractC9526z
    /* renamed from: f */
    public void mo57883f() throws Throwable {
        String str;
        String str2;
        this.f47343b.m61912d(this.f46254r, this.f46255s);
        C11839m.m70688i("CloudBackupV3ModuleOperate", "one module backup start, appId = " + this.f46254r + ", userId = " + this.f46255s);
        this.f46261y.put("startTime", String.valueOf(System.currentTimeMillis()));
        try {
            this.f46250n = m59505b(this.f46238C);
            this.f46241F = m57874X();
            this.f46261y.put("isSupportBackup", String.valueOf(this.f46250n != null && PmsCheckUtil.m12611e() && this.f46250n.isAppDataAble()));
            this.f46261y.put("threadId", String.valueOf(Thread.currentThread().getId()));
            this.f46261y.put("status", String.valueOf(this.f46238C.m29859L()));
            this.f47343b.m61948w0(this.f46238C);
            m57903x(this.f46238C);
            m57884f0();
            m57902w();
            m57897r0();
            m57862L();
            String strM80987x0 = C13452e.m80781L().m80987x0();
            if (!TextUtils.isEmpty(strM80987x0)) {
                this.f46261y.put("userType", strM80987x0);
            }
            this.f46261y.put("gradeCode", C12590s0.m75747G0());
            this.f46261y.put("isDBDiffAbout", String.valueOf(this.f47342a.m29701e0()));
            m57896q0(this.f46261y);
            if (this.f46238C.m29393b1().contains("isDiff")) {
                this.f47342a.m29745s2(true);
            }
            this.f46261y.put("isDeleteModuleCacheSuccess", String.valueOf(this.f46244I));
            this.f46261y.put("bakCategory", String.valueOf(this.f47342a.m29587j()));
            if (this.f47342a.m29636F0() != null) {
                this.f46261y.put("occupySpaceType", String.valueOf(this.f47342a.m29636F0()));
            }
            C12590s0.m75733C2(this.f46238C, this.f46261y, this.f46253q, this.f47353l, this.f47342a.isRefurbishment(), this.f47342a.mo29591n(), this.f47342a.m29722l0().mo1759d());
            this.f47343b.m61952y0(this.f47343b.m61903U() + this.f46238C.m29875i());
            long jM1688f = C0241z.m1688f(this.f46261y.get("moduleUploadSize"));
            long jM61905W = this.f47343b.m61905W() + m57867Q() + jM1688f;
            this.f47343b.m61883A0(jM61905W);
            if (this.f46238C.m29859L() == 6) {
                this.f47343b.m61954z0(this.f47343b.m61904V() + m57867Q() + jM1688f);
            } else {
                this.f46261y.remove("tarCount");
                this.f46261y.remove("tarTotalSize");
            }
            str2 = "one module backup finish, totalSucceedUploadSpaceSize = " + jM61905W + ", uploadSize = " + jM1688f + " batchUploadSize = " + m57867Q();
            str = "CloudBackupV3ModuleOperate";
        } catch (Throwable th2) {
            String str3 = " batchUploadSize = ";
            str = "CloudBackupV3ModuleOperate";
            try {
                mo57894p(th2);
                try {
                    m57885g0(this.f46238C, this.f47351j);
                    C11839m.m70689w(str, "one module backup error, appId = " + this.f46254r + ", userId = " + this.f46255s + " errCode = " + this.f47351j.m60659c() + ", errMsg = " + this.f47351j.toString());
                    String strM80987x02 = C13452e.m80781L().m80987x0();
                    if (!TextUtils.isEmpty(strM80987x02)) {
                        this.f46261y.put("userType", strM80987x02);
                    }
                    this.f46261y.put("gradeCode", C12590s0.m75747G0());
                    this.f46261y.put("isDBDiffAbout", String.valueOf(this.f47342a.m29701e0()));
                    m57896q0(this.f46261y);
                    if (this.f46238C.m29393b1().contains("isDiff")) {
                        this.f47342a.m29745s2(true);
                    }
                    this.f46261y.put("isDeleteModuleCacheSuccess", String.valueOf(this.f46244I));
                    this.f46261y.put("bakCategory", String.valueOf(this.f47342a.m29587j()));
                    if (this.f47342a.m29636F0() != null) {
                        this.f46261y.put("occupySpaceType", String.valueOf(this.f47342a.m29636F0()));
                    }
                    C12590s0.m75733C2(this.f46238C, this.f46261y, this.f46253q, this.f47353l, this.f47342a.isRefurbishment(), this.f47342a.mo29591n(), this.f47342a.m29722l0().mo1759d());
                    this.f47343b.m61952y0(this.f47343b.m61903U() + this.f46238C.m29875i());
                    long jM1688f2 = C0241z.m1688f(this.f46261y.get("moduleUploadSize"));
                    long jM61905W2 = this.f47343b.m61905W() + m57867Q() + jM1688f2;
                    this.f47343b.m61883A0(jM61905W2);
                    if (this.f46238C.m29859L() == 6) {
                        this.f47343b.m61954z0(this.f47343b.m61904V() + m57867Q() + jM1688f2);
                    } else {
                        this.f46261y.remove("tarCount");
                        this.f46261y.remove("tarTotalSize");
                    }
                    str2 = "one module backup finish, totalSucceedUploadSpaceSize = " + jM61905W2 + ", uploadSize = " + jM1688f2 + str3 + m57867Q();
                } catch (Throwable th3) {
                    th = th3;
                    str3 = str3;
                    Throwable th4 = th;
                    String strM80987x03 = C13452e.m80781L().m80987x0();
                    if (!TextUtils.isEmpty(strM80987x03)) {
                        this.f46261y.put("userType", strM80987x03);
                    }
                    this.f46261y.put("gradeCode", C12590s0.m75747G0());
                    this.f46261y.put("isDBDiffAbout", String.valueOf(this.f47342a.m29701e0()));
                    m57896q0(this.f46261y);
                    if (this.f46238C.m29393b1().contains("isDiff")) {
                        this.f47342a.m29745s2(true);
                    }
                    this.f46261y.put("isDeleteModuleCacheSuccess", String.valueOf(this.f46244I));
                    this.f46261y.put("bakCategory", String.valueOf(this.f47342a.m29587j()));
                    if (this.f47342a.m29636F0() != null) {
                        this.f46261y.put("occupySpaceType", String.valueOf(this.f47342a.m29636F0()));
                    }
                    C12590s0.m75733C2(this.f46238C, this.f46261y, this.f46253q, this.f47353l, this.f47342a.isRefurbishment(), this.f47342a.mo29591n(), this.f47342a.m29722l0().mo1759d());
                    this.f47343b.m61952y0(this.f47343b.m61903U() + this.f46238C.m29875i());
                    long jM1688f3 = C0241z.m1688f(this.f46261y.get("moduleUploadSize"));
                    long jM61905W3 = this.f47343b.m61905W() + m57867Q() + jM1688f3;
                    this.f47343b.m61883A0(jM61905W3);
                    if (this.f46238C.m29859L() == 6) {
                        this.f47343b.m61954z0(this.f47343b.m61904V() + m57867Q() + jM1688f3);
                    } else {
                        this.f46261y.remove("tarCount");
                        this.f46261y.remove("tarTotalSize");
                    }
                    C11839m.m70686d(str, "one module backup finish, totalSucceedUploadSpaceSize = " + jM61905W3 + ", uploadSize = " + jM1688f3 + str3 + m57867Q());
                    m57890l0();
                    throw th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        C11839m.m70686d(str, str2);
        m57890l0();
    }

    /* renamed from: f0 */
    public void m57884f0() throws ExecutionException, InterruptedException, C9721b {
        m59511j();
        C11839m.m70688i("CloudBackupV3ModuleOperate", "prepare start, appId = " + this.f46254r + ", userId = " + this.f46255s);
        if ((this.f46238C.m29859L() == 0 || m57871U(this.f46238C)) && this.f47343b.m61923i0(this.f46238C, this.f46250n)) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "isSkipForegroundModule is true, appId = " + this.f46254r + ", userId = " + this.f46255s);
            m57901v();
        }
        m59519s();
        m59511j();
        try {
            C12182i.m73283j().m73286e(this, this.f46238C).get();
            C9721b c9721bM57868R = m57868R();
            if (c9721bM57868R != null) {
                throw c9721bM57868R;
            }
            C11839m.m70688i("CloudBackupV3ModuleOperate", "prepare end, appId = " + this.f46254r + ", userId = " + this.f46255s);
        } catch (InterruptedException e10) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "prepare task InterruptedException");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "upload task InterruptedException, appId = " + this.f46254r + ", userId = " + this.f46255s + " msg: " + e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
        } catch (ExecutionException e11) {
            e = e11;
            C11839m.m70688i("CloudBackupV3ModuleOperate", "prepare task ExecutionException " + e.getMessage());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("prepare task ExecutionException, appId = ");
            sb2.append(this.f46254r);
            sb2.append(", userId = ");
            sb2.append(this.f46255s);
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

    /* renamed from: g0 */
    public final void m57885g0(CloudBackupStatus cloudBackupStatus, C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (m57872V()) {
            if (iM60659c != 1002) {
                C11839m.m70688i("CloudBackupV3ModuleOperate", "abort process failed module, appId = " + this.f46254r + ", uid = " + cloudBackupStatus.m29861N());
                return;
            }
            C11839m.m70688i("CloudBackupV3ModuleOperate", "network disable, no need retried module, appId = " + this.f46254r + ", uid = " + cloudBackupStatus.m29861N());
            this.f47342a.m29656P(cloudBackupStatus, c9721b);
            return;
        }
        if (iM60659c == 1998) {
            C11963c.m71964s(this.f46254r, this.f46255s, this.f47342a.m29713i0());
            new C9195d0(this.f47342a, cloudBackupStatus).m57745g("module_delete_from_app_not_backup");
            C11839m.m70688i("CloudBackupV3ModuleOperate", "process not backup module, appId = " + this.f46254r + ", uid = " + cloudBackupStatus.m29861N());
            return;
        }
        if (iM60659c == 3001) {
            this.f47342a.m29663R0();
        }
        try {
            this.f47343b.m61930n(this.f46254r, cloudBackupStatus.mo29421n(), this.f46255s);
            if (this.f47342a.m29696c1(cloudBackupStatus) && this.f47342a.m29752v0().isEmpty()) {
                C11963c.m71964s(this.f46254r, cloudBackupStatus.m29861N(), this.f47342a.m29713i0());
                C11839m.m70688i("CloudBackupV3ModuleOperate", "filter appId: " + this.f46254r);
                this.f47342a.m29659Q(cloudBackupStatus, c9721b.getMessage());
                new C9195d0(this.f47342a, cloudBackupStatus).m57745g("module_delete_from_app_failed_fileter");
                return;
            }
            if (iM60659c != 1013 && iM60659c != 1012) {
                C11839m.m70688i("CloudBackupV3ModuleOperate", "no need retried module, appId = " + this.f46254r + ", uid = " + cloudBackupStatus.m29861N());
                this.f47342a.m29656P(cloudBackupStatus, c9721b);
                return;
            }
            C11839m.m70688i("CloudBackupV3ModuleOperate", "process failed module, appId = " + this.f46254r + ", uid = " + cloudBackupStatus.m29861N());
            this.f47343b.m61932o0(cloudBackupStatus, c9721b);
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "process failed module error, appId = " + this.f46254r + ", uid = " + cloudBackupStatus.m29861N() + ", exception: " + e10.toString());
        }
    }

    /* renamed from: h0 */
    public boolean m57886h0(long j10, CloudBackupStatus cloudBackupStatus, boolean z10) throws InterruptedException, C9721b, SQLException {
        boolean z11;
        CloudSpace cloudSpaceM29643I0 = this.f47342a.m29643I0();
        if ((cloudSpaceM29643I0.getTotal() - cloudSpaceM29643I0.getUsed()) - j10 <= 0) {
            new C9195d0(this.f47342a, cloudBackupStatus).m57751m("file_delete_from_space_not_enough");
            this.f47342a.m29663R0();
        }
        CloudSpace cloudSpaceM29643I02 = this.f47342a.m29643I0();
        if ((cloudSpaceM29643I02.getTotal() - cloudSpaceM29643I02.getUsed()) - j10 > 0) {
            if (z10) {
                this.f47343b.m61901S().remove(cloudBackupStatus);
            }
            return true;
        }
        Iterator<AppInfoList> it = new C12519c().m75300k(cloudBackupStatus.mo29421n()).iterator();
        while (true) {
            if (!it.hasNext()) {
                z11 = false;
                break;
            }
            if (it.next().getIsSkipWhenInsuff()) {
                z11 = true;
                break;
            }
        }
        if (!z11 || this.f47343b.m61901S().contains(cloudBackupStatus)) {
            C11839m.m70687e("CloudBackupV3ModuleOperate", String.format(Locale.ENGLISH, "%s failed to pass space check, task will be canceled", this.f46254r));
            new C12815f(this.f46252p).m76935n(0L, this.f46254r, cloudBackupStatus.m29861N());
            if (!z11 && this.f47343b.m61906X() && !this.f47343b.m61921h0(cloudBackupStatus)) {
                C11839m.m70687e("CloudBackupV3ModuleOperate", this.f46254r + " failed to pass space check, add retry module");
                this.f47342a.m29656P(cloudBackupStatus, new C9721b("1", SNSCode.Status.HWID_UNLOGIN, "failed to pass space check", "processSpace"));
                return false;
            }
            this.f47343b.m61901S().remove(cloudBackupStatus);
            C12590s0.m75759J0(cloudSpaceM29643I02, this.f47344c, m59509h(), this.f46252p.equals("auto"), this.f47342a.m29640H0(), !this.f47342a.m29696c1(cloudBackupStatus), "1");
        }
        this.f47343b.m61901S().add(cloudBackupStatus);
        return false;
    }

    /* renamed from: i0 */
    public final Long m57887i0(CloudBackupStatus cloudBackupStatus, String str) throws C9721b {
        if (!this.f47342a.mo29591n()) {
            return 0L;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        if (C13617a.m81938t(str, strM29870d, 0, cloudBackupStatus.m29861N())) {
            return Long.valueOf(new C12164f(str, strM29870d, 0, iM29861N).m73094n0());
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "queryModuleRealSize appId: " + strM29870d + " snapshot not exist");
        return 0L;
    }

    /* renamed from: j0 */
    public final void m57888j0(long j10, CloudBackupStatus cloudBackupStatus) throws C9721b {
        String strM29870d;
        if (TextUtils.isEmpty(this.f46254r)) {
            return;
        }
        C12372c c12372c = new C12372c();
        if (this.f47349h) {
            c12372c.m74418a(this.f46254r);
            return;
        }
        if (c12372c.m74421d(this.f46254r) != null) {
            return;
        }
        CloudBackupReport cloudBackupReport = new CloudBackupReport();
        cloudBackupReport.mo29313Y(this.f46254r).mo29316a0(cloudBackupStatus.m29871e()).mo29318b0(cloudBackupStatus.m29872f()).m29312X0(cloudBackupStatus.m29349G0()).m29311W0(cloudBackupStatus.m29407h1()).mo29338z0(cloudBackupStatus.m29859L()).mo29289A0(cloudBackupStatus.m29860M()).m29330i1(j10);
        int iM29861N = cloudBackupStatus.m29861N();
        if (iM29861N == 0) {
            strM29870d = cloudBackupStatus.m29870d();
        } else {
            strM29870d = cloudBackupStatus.m29870d() + iM29861N;
        }
        Long l10 = this.f47343b.m61896N().get(strM29870d);
        Long l11 = this.f47343b.m61895M().get(strM29870d);
        if (l10 != null) {
            cloudBackupReport.m29328g1(l10.longValue());
        }
        if (l11 != null) {
            cloudBackupReport.m29329h1(l11.longValue());
        }
        c12372c.m74422e(cloudBackupReport);
    }

    /* renamed from: k0 */
    public final void m57889k0(CloudBackupStatus cloudBackupStatus) throws C9721b {
        HashMap map = new HashMap();
        map.put("snapshotvalidflag", FeedbackConst.SDK.INVALID_ACCESS_TOKEN);
        AppRefresh appRefresh = new AppRefresh();
        appRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setBackupAppStatus(1);
        appRefresh.setProperties((Map<String, String>) map);
        if (this.f47354m.m63582x0(this.f47342a.m29728n0(), this.f47346e, this.f46253q, cloudBackupStatus.m29398d1(), cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), appRefresh, 0).getBackupAppStatus().intValue() == 1) {
            return;
        }
        throw new C9721b(3911, "Backup.device.bak.app.refresh error. backupAppId = " + cloudBackupStatus.m29398d1(), "Backup.device.bak.app.refresh");
    }

    /* renamed from: l0 */
    public final void m57890l0() {
        C11965e.m71974f().m71985n(this.f46254r, this.f46255s);
        C9271x0 c9271x0 = this.f46236A;
        if (c9271x0 != null) {
            c9271x0.cancel(true);
        }
        C9276z c9276z = this.f46237B;
        if (c9276z != null) {
            c9276z.cancel(true);
        }
        C12182i.m73283j().m73300t(this.f46238C);
        this.f47342a.removeModule(this.f46254r + this.f46255s);
        C13216j.m79420e(C13617a.m81942x(this.f46253q, this.f46254r, 0, this.f46238C.m29861N()));
        C12590s0.m75754I(this.f46254r, this.f46255s);
        C11839m.m70688i("CloudBackupV3ModuleOperate", "release end, appId = " + this.f46254r + ", userId = " + this.f46255s);
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public final void m57880d0(String str, long j10, long j11) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "verifyingModuleFiles error fileIds is empty");
        }
        FileReuse fileReuse = new FileReuse();
        fileReuse.setFileIds(str).setFileIdTotalCount(Long.valueOf(j10)).setFileIdCreateTime(Long.valueOf(j11));
        this.f47354m.m63537B0(this.f47342a.m29728n0(), this.f47346e, this.f46253q, fileReuse, this.f46254r, this.f46255s, 0);
    }

    /* renamed from: n0 */
    public void m57892n0(long j10) {
        this.f46239D = j10;
    }

    /* renamed from: o0 */
    public void m57893o0(long j10) {
        this.f46240E = j10;
    }

    @Override // p262em.AbstractC9526z
    /* renamed from: p */
    public void mo57894p(Throwable th2) {
        synchronized (this.f46256t) {
            try {
                if (this.f47351j == null) {
                    if (th2 instanceof C9721b) {
                        this.f47351j = (C9721b) th2;
                    } else {
                        this.f47351j = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error." + th2.toString() + ",stackTrace: " + C12590s0.m75731C0(th2));
                    }
                    C11839m.m70687e("CloudBackupV3ModuleOperate", "appId = " + this.f46254r + ", userId = " + this.f46255s + " backup error." + th2.toString() + "errCode = " + this.f47351j.m60659c() + ", exception" + this.f47351j.toString());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* renamed from: p0 */
    public void m57895p0(boolean z10) {
        this.f46251o = z10;
    }

    /* renamed from: q0 */
    public final void m57896q0(Map<String, String> map) {
        long jQuerySumFreeSizeByRatio;
        if (this.f47342a.m29650M0() && !map.containsKey("tarReferenceRate")) {
            String strM81915D = C13617a.m81915D(this.f46254r, this.f46255s, false);
            File fileM63442h = C10278a.m63442h(strM81915D);
            ArrayList arrayList = new ArrayList();
            if (fileM63442h.exists()) {
                PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(strM81915D);
                arrayList.addAll(pmsFullBriefFilesInfoOperatorV3.queryTarRefRatioByLimit(100));
                jQuerySumFreeSizeByRatio = pmsFullBriefFilesInfoOperatorV3.querySumFreeSizeByRatio(this.f47342a.m29638G0(), this.f47342a.m29652N0());
                C11839m.m70686d("CloudBackupV3ModuleOperate", "fullbrief tarFreeSize: " + jQuerySumFreeSizeByRatio + " ,appid: " + this.f46254r);
            } else {
                jQuerySumFreeSizeByRatio = 0;
            }
            if (C10278a.m63442h(C13617a.m81943y(this.f46253q, this.f46254r, 0, this.f46255s, false)).exists()) {
                int size = 100 - arrayList.size();
                C12164f c12164f = new C12164f(this.f46253q, this.f46254r, 0, this.f46255s);
                if (size > 0) {
                    arrayList.addAll(c12164f.queryTarRefRatioByLimit(size));
                }
                long jQuerySumFreeSizeByRatio2 = jQuerySumFreeSizeByRatio + c12164f.querySumFreeSizeByRatio(this.f47342a.m29638G0(), this.f47342a.m29652N0());
                map.put("tarFreeSize", String.valueOf(jQuerySumFreeSizeByRatio2));
                long jM73028C = c12164f.m73028C();
                long jM73030D = c12164f.m73030D();
                if (this.f46238C.m29351H0() == 1) {
                    map.put("tarCount", String.valueOf(jM73028C));
                    map.put("tarTotalSize", String.valueOf(jM73030D));
                    C11839m.m70686d("CloudBackupV3ModuleOperate", "snapshot tarFreeSize: " + jQuerySumFreeSizeByRatio2 + " tarCount: " + jM73028C + " tarTotalSize: " + jM73030D + " appid: " + this.f46254r);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            map.put("tarReferenceRate", arrayList.toString());
        }
    }

    /* renamed from: r0 */
    public void m57897r0() throws ExecutionException, InterruptedException, C9721b {
        C11839m.m70688i("CloudBackupV3ModuleOperate", "upload start, appId = " + this.f46254r + ", userId = " + this.f46255s);
        m59511j();
        int iM29859L = this.f46238C.m29859L();
        if ((iM29859L == 4 && this.f46238C.m29404g1() > 0) || iM29859L == 5 || iM29859L == 6) {
            C11839m.m70688i("CloudBackupV3ModuleOperate", "no need upload, appId = " + this.f46254r + ", userId = " + this.f46255s);
            return;
        }
        if (m57868R() != null) {
            throw this.f47351j;
        }
        if (iM29859L != 3 && iM29859L != 4) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "upload status illegal, status = " + iM29859L + ", appId = " + this.f46254r + " uid: " + this.f46255s);
        }
        this.f46238C.m29448w2();
        C11963c.m71970y(this.f46238C, this.f46252p);
        m57860J(this.f46238C, this.f46261y);
        C11839m.m70688i("CloudBackupV3ModuleOperate", "upload end, appId = " + this.f46254r + ", userId = " + this.f46255s);
    }

    /* renamed from: s0 */
    public final void m57898s0() {
        try {
            try {
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupV3ModuleOperate", "verifyingModuleFiles error: " + e10);
                this.f46261y.put("verifyingFailed", e10.toString());
            }
            if (!"1".equals(this.f46238C.m29364N0())) {
                C11839m.m70688i("CloudBackupV3ModuleOperate", "verifyingModuleFiles appId: " + this.f46254r + " ,data11: " + this.f46238C.m29364N0());
            } else if (C10278a.m63442h(C13617a.m81942x(this.f47345d, this.f46254r, 0, this.f46255s)).exists()) {
                C12164f c12164f = new C12164f(this.f46253q, this.f46254r, 0, this.f46255s);
                final long jM73024A = c12164f.m73024A(this.f46254r);
                if (jM73024A > 0) {
                    C11839m.m70686d("CloudBackupV3ModuleOperate", "verifyingModuleFiles appId: " + this.f46254r + " ,fileIdsCount: " + jM73024A);
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    long jM73073d = c12164f.m73073d(this.f46254r, this.f47342a.m29755w0(), new InterfaceC14355b() { // from class: dm.g0
                        @Override // p851zp.InterfaceC14355b
                        public final void execute() throws InterruptedException, C9721b {
                            this.f46208a.m59511j();
                        }
                    }, new InterfaceC14354a() { // from class: dm.h0
                        @Override // p851zp.InterfaceC14354a
                        public final void apply(Object obj) throws C9721b {
                            this.f46230a.m57880d0(jM73024A, jCurrentTimeMillis, (String) obj);
                        }
                    });
                    this.f46261y.put("verifyingSuccess", "db:" + jM73024A + ",real:" + jM73073d);
                    return;
                }
                C11839m.m70688i("CloudBackupV3ModuleOperate", "verifyingModuleFiles appId: " + this.f46254r + " ,fileIdsCount <= 0");
            } else {
                C11839m.m70688i("CloudBackupV3ModuleOperate", "verifyingModuleFiles appId: " + this.f46254r + " ,snapshot not exist");
            }
        } finally {
            this.f46238C.m29350G1("2");
        }
    }

    /* renamed from: t0 */
    public final void m57899t0() throws InterruptedException, C9721b {
        while (C12182i.m73283j().m73294n()) {
            m59511j();
            SystemClock.sleep(500L);
        }
    }

    /* renamed from: u0 */
    public final void m57900u0() throws InterruptedException, C9721b {
        while (C12182i.m73283j().m73295o()) {
            m59511j();
            SystemClock.sleep(500L);
        }
    }

    /* renamed from: v */
    public void m57901v() {
        this.f47352k = true;
        C9271x0 c9271x0 = this.f46236A;
        if (c9271x0 != null) {
            c9271x0.cancel(true);
        }
        C9276z c9276z = this.f46237B;
        if (c9276z != null) {
            c9276z.cancel(true);
        }
    }

    /* renamed from: w */
    public final void m57902w() throws C9721b {
        if (this.f47342a.isRefurbishment() || this.f47342a.mo29591n() || !this.f46238C.m29863P() || !C13452e.m80781L().m80887a1() || C12590s0.m75828a1(this.f47342a.m29657P0())) {
            return;
        }
        int iM29351H0 = this.f46238C.m29351H0();
        long j10 = 0;
        if (!this.f47342a.m29690a1() && this.f47342a.m29737q0().contains("applistStrategy")) {
            C12164f c12164f = new C12164f(this.f47345d, this.f46254r, 0, this.f46238C.m29861N());
            if (1 == iM29351H0) {
                long jM73026B = c12164f.m73026B();
                if (jM73026B > 0) {
                    j10 = jM73026B;
                }
            }
            throw new C9721b(1998, "3rd app create no data: " + this.f46254r + ", uid: " + this.f46238C.m29861N(), "3rdAppCreate");
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "check3rdAppDataInvaildInNewBmType metasNum: " + j10 + " ,backupData: " + iM29351H0);
    }

    /* renamed from: x */
    public final void m57903x(CloudBackupStatus cloudBackupStatus) throws C9721b {
        if (cloudBackupStatus.mo29370Q()) {
            SplitAppUtil.checkAppTwinStatus(cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N());
        }
        int iM29859L = cloudBackupStatus.m29859L();
        switch (iM29859L) {
            case 0:
                if (m59514m(cloudBackupStatus)) {
                    cloudBackupStatus.mo29338z0(0).mo29289A0(-1).mo29310W(0).mo29308V(0L);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
                m57905z(cloudBackupStatus);
                break;
            case 4:
                boolean zM59513l = m59513l(cloudBackupStatus.m29404g1(), this.f47350i);
                if (!m59514m(cloudBackupStatus) && !zM59513l) {
                    if (cloudBackupStatus.m29863P() && (cloudBackupStatus.m29351H0() == 0 || !cloudBackupStatus.m29425o1())) {
                        if (this.f46260x.m76021x(this.f46254r, this.f46253q, this.f46255s) > 0 || !m57878b0()) {
                            C11839m.m70688i("CloudBackupV3ModuleOperate", "no need backup data or status illegal, clear snapshot metas, appId = " + this.f46254r);
                            new C9195d0(this.f47342a, cloudBackupStatus).m57745g("module_delete_from_app_no_data");
                            this.f47343b.m61912d(this.f46254r, this.f46255s);
                            cloudBackupStatus.m29405g2("").m29350G1("").mo29338z0(0).mo29289A0(0).m29374R1(0L).m29342C1(0L).mo29310W(0).mo29308V(0L);
                            this.f47348g.m76934m(cloudBackupStatus);
                            C11963c.m71970y(cloudBackupStatus, this.f46252p);
                        }
                        if (cloudBackupStatus.m29351H0() == 0 || cloudBackupStatus.m29875i() == 0) {
                            C12590s0.m75769L2(cloudBackupStatus.m29870d(), this.f46247L, 1);
                            break;
                        }
                    }
                } else {
                    new C9195d0(this.f47342a, cloudBackupStatus).m57757s("module_reset_from_upload_overdue");
                    m57852B(zM59513l);
                    break;
                }
                break;
            case 5:
                boolean zM59513l2 = m59513l(cloudBackupStatus.m29404g1(), this.f47350i);
                if (m59514m(cloudBackupStatus) || zM59513l2) {
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "refresh app status: " + cloudBackupStatus.m29870d());
                    m57889k0(cloudBackupStatus);
                    new C9195d0(this.f47342a, cloudBackupStatus).m57757s("module_reset_from_create_overdue");
                    m57852B(zM59513l2);
                    break;
                }
            case 6:
                m57861K(this.f46254r, cloudBackupStatus);
                break;
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "getCurBackupStatus:  appId: " + this.f46254r + ",uid: " + cloudBackupStatus.m29861N() + ",status: " + iM29859L + ",adjust status: " + cloudBackupStatus.m29859L() + " ,dateInvalid: " + cloudBackupStatus.m29385X0() + " ,sd dateModify: " + cloudBackupStatus.m29402f1() + " ,module dateCreate: " + cloudBackupStatus.m29404g1());
    }

    /* renamed from: y */
    public boolean m57904y(CloudBackupStatus cloudBackupStatus, Long l10, Long l11) throws C9721b, PackageManager.NameNotFoundException {
        if (C12598v.m76043k(this.f47342a)) {
            return false;
        }
        if (!this.f47342a.mo29591n()) {
            String strM75747G0 = C12590s0.m75747G0();
            if (C12590s0.m75869k1(strM75747G0)) {
                if (!C12590s0.m75849f1(strM75747G0)) {
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "no need check space, appId: " + this.f46254r);
                    return false;
                }
                if (this.f47342a.m29737q0().contains(cloudBackupStatus.m29870d())) {
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "base service app,no need check space, appId: " + this.f46254r);
                    return false;
                }
                if (this.f47342a.m29737q0().contains("applistStrategy") && cloudBackupStatus.m29863P() && cloudBackupStatus.m29351H0() != 1) {
                    C11839m.m70688i("CloudBackupV3ModuleOperate", "base service app list,no need check space, appId: " + this.f46254r);
                    return false;
                }
            }
        }
        long jM59518r = m59518r(cloudBackupStatus, l10, l11);
        boolean z10 = l10 == null && l11 == null;
        m57888j0(jM59518r, cloudBackupStatus);
        CloudSpace cloudSpaceM29643I0 = this.f47342a.m29643I0();
        C11839m.m70688i("CloudBackupV3ModuleOperate", String.format(Locale.ENGLISH, "current module: %s, remaining space of user：%s, total size of files %s", this.f46254r, Long.valueOf(cloudSpaceM29643I0.getTotal() - cloudSpaceM29643I0.getUsed()), Long.valueOf(jM59518r)));
        if (m57886h0(jM59518r, cloudBackupStatus, z10)) {
            return false;
        }
        C11839m.m70688i("CloudBackupV3ModuleOperate", "doOneModuleBackup processSpace end skiped appId: " + this.f46254r + ", userId = " + this.f46255s);
        return true;
    }

    /* renamed from: z */
    public final void m57905z(CloudBackupStatus cloudBackupStatus) throws C9721b {
        if ((cloudBackupStatus.m29866T() && !m57876Z(this.f46254r)) || m59514m(cloudBackupStatus)) {
            cloudBackupStatus.mo29338z0(0).m29374R1(0L).m29342C1(0L).mo29289A0(-1).mo29310W(0).mo29308V(0L);
            this.f47348g.m76934m(cloudBackupStatus);
            return;
        }
        if (m57876Z(this.f46254r)) {
            cloudBackupStatus.mo29338z0(0).m29374R1(0L).m29342C1(0L).mo29289A0(-1).mo29310W(0).mo29308V(0L);
            if (this.f47342a.isRefurbishment() || this.f47342a.mo29591n()) {
                cloudBackupStatus.mo29289A0(0);
            }
            this.f47348g.m76934m(cloudBackupStatus);
            return;
        }
        if (m59513l(cloudBackupStatus.m29385X0(), this.f46257u)) {
            cloudBackupStatus.mo29338z0(0).m29374R1(0L).m29342C1(0L).m29423n2(0L).mo29289A0(-1).mo29310W(0).mo29308V(0L);
            this.f47348g.m76934m(cloudBackupStatus);
            return;
        }
        if (3 == cloudBackupStatus.m29859L() && m59513l(cloudBackupStatus.m29402f1(), this.f46258v)) {
            cloudBackupStatus.mo29338z0(2).mo29289A0(3).m29423n2(0L);
            this.f47348g.m76934m(cloudBackupStatus);
        } else if (cloudBackupStatus.m29863P()) {
            if (cloudBackupStatus.m29351H0() == 0 || !cloudBackupStatus.m29425o1()) {
                cloudBackupStatus.mo29338z0(1).m29374R1(0L).m29342C1(0L).m29423n2(0L).mo29310W(0).mo29308V(0L).mo29289A0(1);
                this.f47348g.m76934m(cloudBackupStatus);
            }
            if (cloudBackupStatus.m29351H0() == 0 || cloudBackupStatus.m29875i() == 0) {
                C12590s0.m75769L2(cloudBackupStatus.m29870d(), this.f46247L, 1);
            }
        }
    }
}
