package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ck.C1443a;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.complexutil.C2784e;
import com.huawei.android.hicloud.p088ui.activity.SiteChangeTipActivity;
import com.huawei.android.hicloud.p088ui.activity.SiteOfflineTipActivity;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import ge.C9908c;
import gp.C10028c;
import io.C10582a;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mc.C11437b;
import mn.C11500d;
import p011aa.C0085e;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p020ap.C1008c;
import p020ap.C1009d;
import p037bp.C1270a;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p252e9.C9429f;
import p335hd.C10148k;
import p429kk.C11058a;
import p429kk.C11060c;
import p446l7.C11258f;
import p474m9.C11432a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p782xo.C13842a;
import p837z9.C14163d;
import p846zj.C14306d;

/* renamed from: com.huawei.android.hicloud.task.simple.x1 */
/* loaded from: classes3.dex */
public class C3097x1 extends AbstractC12367d {

    /* renamed from: a */
    public String f13397a;

    /* renamed from: b */
    public Context f13398b;

    /* renamed from: d */
    public int f13400d;

    /* renamed from: e */
    public CountDownLatch f13401e;

    /* renamed from: f */
    public int f13402f;

    /* renamed from: h */
    public boolean f13404h;

    /* renamed from: i */
    public String f13405i;

    /* renamed from: l */
    public boolean f13408l;

    /* renamed from: c */
    public C2784e f13399c = new C2784e();

    /* renamed from: g */
    public int f13403g = 0;

    /* renamed from: j */
    public int f13406j = -1;

    /* renamed from: k */
    public int f13407k = 0;

    public C3097x1(Context context, Bundle bundle) {
        this.f13397a = "unknown";
        this.f13400d = 0;
        this.f13402f = 0;
        this.f13404h = false;
        this.f13405i = null;
        this.f13408l = false;
        this.f13398b = context.getApplicationContext();
        this.f13405i = C11058a.m66627b("07004");
        if (bundle != null) {
            this.f13400d = bundle.getInt("retryCountForNotGetConfig", 0);
            this.f13402f = bundle.getInt("retryCountForHttpError", 0);
            this.f13404h = bundle.getInt("fromMigration", 0) != 0;
            this.f13397a = bundle.getString("taskStartChannel", "");
            this.f13408l = bundle.getBoolean("isOnlyRefresh", false);
            C11839m.m70688i("QueryBasicRefreshConfigTask", "isFromMigration" + this.f13404h);
        }
    }

    /* renamed from: f */
    private void m18422f() {
        C12515a.m75110o().m75172d(new InitCloudBackupDataTask(this.f13398b));
    }

    /* renamed from: o */
    private void m18423o() throws Throwable {
        m18424p(0);
        C10028c.m62182c0().m62317d3(System.currentTimeMillis());
    }

    /* renamed from: p */
    private void m18424p(int i10) throws Throwable {
        if (i10 > 2) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "query retry times more than 2");
            C10028c.m62182c0().m62317d3(System.currentTimeMillis());
            return;
        }
        try {
            BasicModuleConfigV3Rsp basicModuleConfigV3RspM64924Y = new C10582a(this.f13405i).m64924Y(this.f13397a);
            int matchResult = basicModuleConfigV3RspM64924Y.getMatchResult();
            C11839m.m70688i("QueryBasicRefreshConfigTask", "v3 config match result = " + matchResult);
            m18430k(matchResult, basicModuleConfigV3RspM64924Y, i10);
        } catch (C9721b e10) {
            C11839m.m70687e("QueryBasicRefreshConfigTask", "CException = " + e10.toString() + "code = " + e10.m60659c());
            int iM60659c = e10.m60659c();
            if (m18429j(i10, iM60659c)) {
                return;
            }
            m18426e(iM60659c);
        } catch (Exception e11) {
            C11839m.m70687e("QueryBasicRefreshConfigTask", e11.toString());
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        if (this.f13408l) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "only refresh queryVersion3Config");
            m18423o();
            return;
        }
        C14306d.m85214o();
        C14163d.m84990g().m85012r();
        this.f13401e = new CountDownLatch(1);
        HiCloudAllOMConfigManager.getInstance().downloadMultipleConfig(this.f13401e, false);
        SpaceNoticeV3Manager.getInstance().executeLocalLanguageTask();
        SpaceInsuffNoticeV4Manager.getInstance().executeLocalLanguageTask();
        m18438u();
        C11839m.m70688i("QueryBasicRefreshConfigTask", "doInBackground");
        try {
            if (!C0209d.m1333z1(this.f13398b)) {
                C11839m.m70688i("QueryBasicRefreshConfigTask", "net is unreachable, retryCountForNotGetConfig time is " + this.f13400d + ", configTag = " + C10028c.m62182c0().m62395t1("is_already_configed_NV4"));
                if (this.f13400d >= 2 || C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
                    C10028c.m62182c0().m62317d3(System.currentTimeMillis());
                    m18425d();
                    Intent intent = new Intent("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
                    intent.putExtra("isFromMigration", this.f13404h);
                    C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
                    C13452e.m80781L().m80988x1("from_sysConfRefresh");
                    C11839m.m70688i("QueryBasicRefreshConfigTask", "query config end");
                    m18425d();
                    C14163d.m84990g().m85013s();
                    m18422f();
                    C11432a.m68479d().m68486c();
                    C13842a.m83010i().m83023a();
                    HiCloudNotification.getInstance().executeCheckDatabase();
                    C9429f.m59137a();
                    HiCloudNotification.getInstance().executeFromDailyCheck();
                    HiCloudNotification.getInstance().executeSpaceUsedNotify();
                    m18434q();
                    C12515a.m75110o().m75175e(new C10148k(this.f13398b, "refresh"), true);
                    if (C10028c.m62182c0().m62324f0("has_channels_stop_fail")) {
                        C1008c.m6035v().m6059X(this.f13398b, true);
                    }
                    C1008c.m6035v().m6066c(this.f13398b, "refreshReport");
                    RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, true, false);
                    m18439v();
                    m18435r();
                    return;
                }
                m18425d();
                C11500d c11500dM68648g = C11500d.m68648g();
                Context context = this.f13398b;
                int i10 = this.f13402f;
                int i11 = this.f13400d + 1;
                this.f13400d = i11;
                c11500dM68648g.m68665r(context, i10, i11, "from_job_schedule_not_get_config");
                Intent intent2 = new Intent("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
                intent2.putExtra("isFromMigration", this.f13404h);
                C13108a.m78878b(C0213f.m1377a()).m78881d(intent2);
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
                C11839m.m70688i("QueryBasicRefreshConfigTask", "query config end");
                m18425d();
                C14163d.m84990g().m85013s();
                m18422f();
                C11432a.m68479d().m68486c();
                C13842a.m83010i().m83023a();
                HiCloudNotification.getInstance().executeCheckDatabase();
                C9429f.m59137a();
                HiCloudNotification.getInstance().executeFromDailyCheck();
                HiCloudNotification.getInstance().executeSpaceUsedNotify();
                m18434q();
                C12515a.m75110o().m75175e(new C10148k(this.f13398b, "refresh"), true);
                if (C10028c.m62182c0().m62324f0("has_channels_stop_fail")) {
                    C1008c.m6035v().m6059X(this.f13398b, true);
                }
                C1008c.m6035v().m6066c(this.f13398b, "refreshReport");
                RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, true, false);
                m18439v();
                m18435r();
                return;
            }
            try {
                C14163d.m84990g().m84998c();
                m18423o();
                int i12 = this.f13403g;
                if (i12 == 1) {
                    C11500d c11500dM68648g2 = C11500d.m68648g();
                    Context context2 = this.f13398b;
                    int i13 = this.f13402f;
                    int i14 = this.f13400d + 1;
                    this.f13400d = i14;
                    c11500dM68648g2.m68665r(context2, i13, i14, "from_job_schedule_not_get_config");
                } else if (i12 == 2) {
                    C11500d c11500dM68648g3 = C11500d.m68648g();
                    Context context3 = this.f13398b;
                    int i15 = this.f13402f + 1;
                    this.f13402f = i15;
                    c11500dM68648g3.m68664q(context3, i15, this.f13400d, "from_job_schedule_flow_control");
                }
                Intent intent3 = new Intent("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
                intent3.putExtra("isFromMigration", this.f13404h);
                C13108a.m78878b(C0213f.m1377a()).m78881d(intent3);
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
                C11839m.m70688i("QueryBasicRefreshConfigTask", "query config end");
                m18425d();
                C14163d.m84990g().m85013s();
                m18422f();
                C11432a.m68479d().m68486c();
                C13842a.m83010i().m83023a();
                HiCloudNotification.getInstance().executeCheckDatabase();
                C9429f.m59137a();
                HiCloudNotification.getInstance().executeFromDailyCheck();
                HiCloudNotification.getInstance().executeSpaceUsedNotify();
                m18434q();
                C12515a.m75110o().m75175e(new C10148k(this.f13398b, "refresh"), true);
                if (C10028c.m62182c0().m62324f0("has_channels_stop_fail")) {
                    C1008c.m6035v().m6059X(this.f13398b, true);
                }
                C1008c.m6035v().m6066c(this.f13398b, "refreshReport");
                RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, true, false);
                m18439v();
                m18435r();
            } catch (C9721b e10) {
                C11839m.m70687e("QueryBasicRefreshConfigTask", "checkDefaultEncryptMode fail!" + e10.toString());
                C10028c.m62182c0().m62317d3(System.currentTimeMillis());
                m18425d();
                Intent intent4 = new Intent("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
                intent4.putExtra("isFromMigration", this.f13404h);
                C13108a.m78878b(C0213f.m1377a()).m78881d(intent4);
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
                C11839m.m70688i("QueryBasicRefreshConfigTask", "query config end");
                m18425d();
                C14163d.m84990g().m85013s();
                m18422f();
                C11432a.m68479d().m68486c();
                C13842a.m83010i().m83023a();
                HiCloudNotification.getInstance().executeCheckDatabase();
                C9429f.m59137a();
                HiCloudNotification.getInstance().executeFromDailyCheck();
                HiCloudNotification.getInstance().executeSpaceUsedNotify();
                m18434q();
                C12515a.m75110o().m75175e(new C10148k(this.f13398b, "refresh"), true);
                if (C10028c.m62182c0().m62324f0("has_channels_stop_fail")) {
                    C1008c.m6035v().m6059X(this.f13398b, true);
                }
                C1008c.m6035v().m6066c(this.f13398b, "refreshReport");
                RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, true, false);
                m18439v();
                m18435r();
            }
        } catch (Throwable th2) {
            Intent intent5 = new Intent("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
            intent5.putExtra("isFromMigration", this.f13404h);
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent5);
            C13452e.m80781L().m80988x1("from_sysConfRefresh");
            C11839m.m70688i("QueryBasicRefreshConfigTask", "query config end");
            m18425d();
            C14163d.m84990g().m85013s();
            m18422f();
            C11432a.m68479d().m68486c();
            C13842a.m83010i().m83023a();
            HiCloudNotification.getInstance().executeCheckDatabase();
            C9429f.m59137a();
            HiCloudNotification.getInstance().executeFromDailyCheck();
            HiCloudNotification.getInstance().executeSpaceUsedNotify();
            m18434q();
            C12515a.m75110o().m75175e(new C10148k(this.f13398b, "refresh"), true);
            if (C10028c.m62182c0().m62324f0("has_channels_stop_fail")) {
                C1008c.m6035v().m6059X(this.f13398b, true);
            }
            C1008c.m6035v().m6066c(this.f13398b, "refreshReport");
            RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, true, false);
            m18439v();
            m18435r();
            throw th2;
        }
    }

    /* renamed from: d */
    public final void m18425d() throws InterruptedException {
        try {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "awaitRequestConfigTaskFinish start");
            C11839m.m70688i("QueryBasicRefreshConfigTask", "awaitRequestConfigTaskFinish end, awaitResult = " + this.f13401e.await(30000L, TimeUnit.MILLISECONDS));
            C11839m.m70688i("QueryBasicRefreshConfigTask", "begin show forced Upgrade");
            HiCloudForceUpgradeConfigManager.getInstance().saveForcedUpgradeConfig(new ForcedUpgradeUtil.QueryUpdate() { // from class: com.huawei.android.hicloud.task.simple.w1
                @Override // com.huawei.hicloud.notification.util.ForcedUpgradeUtil.QueryUpdate
                public final void onUpgrade(int i10) throws Throwable {
                    this.f13396a.m18427g(i10);
                }
            });
            C9908c.m61499D().m61522H(false);
        } catch (InterruptedException e10) {
            C11839m.m70687e("QueryBasicRefreshConfigTask", "awaitRequestConfigTaskFinish exception:" + e10.toString());
        }
    }

    /* renamed from: e */
    public final void m18426e(int i10) {
        if (i10 != 1104 && i10 != 1107 && i10 != 3107 && i10 != 3108) {
            switch (i10) {
            }
        }
        C11839m.m70688i("QueryBasicRefreshConfigTask", "checkErrorCode net is unreachable, retry time is" + this.f13400d + ", configTag = " + C10028c.m62182c0().m62395t1("is_already_configed_NV4"));
        if (this.f13400d >= 2 || C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
            this.f13403g = 0;
        } else {
            this.f13403g = 1;
        }
    }

    /* renamed from: g */
    public final /* synthetic */ void m18427g(int i10) throws Throwable {
        try {
            m18437t();
            if (C10028c.m62182c0().m62274T() == 0) {
                ForcedUpgradeUtil.getInstance().isShowForcedUpgrade();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("QueryBasicRefreshConfigTask", "show forced Upgrade exception: " + e10.toString());
        }
    }

    /* renamed from: h */
    public final void m18428h(int i10) {
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_huawei_drive");
        C12515a.m75110o().m75175e(new C3067o1(this.f13398b, 1, zM62395t1, i10, ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this.f13398b), C10028c.m62182c0().m62329g0(), zM62395t1 ? 2 : 3), true);
    }

    /* renamed from: j */
    public final boolean m18429j(int i10, int i11) throws Throwable {
        if (3102 == i11) {
            if (C10028c.m62182c0().m62420y1()) {
                C11839m.m70689w("QueryBasicRefreshConfigTask", "can not init param from default server need change to obs mode");
                C10028c.m62182c0().m62361m2(1);
                m18424p(i10 + 1);
            } else {
                C11839m.m70687e("QueryBasicRefreshConfigTask", "can not init param from obs server");
                C10028c.m62182c0().m62361m2(0);
            }
            return true;
        }
        if (503 != i11) {
            return false;
        }
        if (this.f13402f < 10) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "Http error code 503, retry ");
            this.f13403g = 2;
        }
        C11839m.m70688i("QueryBasicRefreshConfigTask", "retry time more than 10");
        return true;
    }

    /* renamed from: k */
    public final void m18430k(int i10, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp, int i11) throws Throwable {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (i10 != 9) {
            C10028c.m62182c0().m62227I2(0);
        }
        if (i10 == 0) {
            m18431l(basicModuleConfigV3Rsp, i11);
            return;
        }
        if (i10 == 9) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "sendForceUpgradeFromServerCodeBroadcast");
            NotifyUtil.sendForceUpgradeFromServerCodeBroadcast(basicModuleConfigV3Rsp.getForceGradeErrorCode());
            return;
        }
        if (i10 == 2 || i10 == 3) {
            C10028c.m62182c0().m62343j();
            c10028cM62182c0.m62377p3("is_already_configed_NV4", true);
        } else if (i10 == 5) {
            C10028c.m62182c0().m62343j();
            c10028cM62182c0.m62377p3("is_already_configed_NV4", true);
            m18432m();
        } else {
            if (i10 != 6) {
                return;
            }
            C10028c.m62182c0().m62343j();
            c10028cM62182c0.m62377p3("is_already_configed_NV4", true);
            m18433n();
        }
    }

    /* renamed from: l */
    public final void m18431l(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp, int i10) throws Throwable {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        int iM62318e = c10028cM62182c0.m62318e(basicModuleConfigV3Rsp.getDataState());
        if (iM62318e != c10028cM62182c0.m62373p() && (C0209d.m1161D0() || c10028cM62182c0.m62423z())) {
            c10028cM62182c0.m62192B2(iM62318e);
            c10028cM62182c0.m62361m2(iM62318e);
            c10028cM62182c0.m62343j();
            c10028cM62182c0.m62416x2(basicModuleConfigV3Rsp.getDataState());
            C9062b.m57146k().m57160p();
            m18424p(i10 + 1);
            return;
        }
        m18436s(basicModuleConfigV3Rsp);
        this.f13399c.m16198e(basicModuleConfigV3Rsp, c10028cM62182c0);
        C14163d.m84990g().m85009o();
        C14163d.m84990g().m85000e();
        C11839m.m70688i("QueryBasicRefreshConfigTask", "refresh album support flag");
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58415c0(this.f13398b, false);
            interfaceC9282a.mo58436j0(this.f13398b);
            interfaceC9282a.mo58388Q(this.f13398b);
        } else {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "cloudAlbumRouterImpl is null");
        }
        c10028cM62182c0.m62192B2(iM62318e);
        c10028cM62182c0.m62361m2(iM62318e);
        c10028cM62182c0.m62376p2(true);
        m18428h(iM62318e);
        if (basicModuleConfigV3Rsp.getDataState() == 4 && !this.f13404h) {
            C12515a.m75110o().m75172d(new C0085e());
        } else if (basicModuleConfigV3Rsp.getDataState() == 3) {
            C14163d.m84990g().m85014t();
        }
        C2783d.m16080E0();
    }

    /* renamed from: m */
    public final void m18432m() {
        boolean z10;
        if (this.f13398b != null) {
            C13452e.m80781L().m80848Q2("siteChanged");
            boolean zM70596m0 = C11829c.m70596m0(this.f13398b);
            boolean zM1206R1 = C0209d.m1206R1(this.f13398b);
            if (zM70596m0 && zM1206R1) {
                Intent intent = new Intent();
                intent.setClass(this.f13398b, SiteChangeTipActivity.class);
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                this.f13398b.startActivity(intent);
                z10 = false;
            } else {
                z10 = true;
            }
            C11437b.m68501e().m68506f(this.f13398b, z10);
        }
    }

    /* renamed from: n */
    public final void m18433n() {
        if (this.f13398b != null) {
            C11437b.m68501e().m68507g(this.f13398b);
            C13452e.m80781L().m80848Q2("siteOffline");
            boolean zM70596m0 = C11829c.m70596m0(this.f13398b);
            boolean zM1206R1 = C0209d.m1206R1(this.f13398b);
            if (zM70596m0 && zM1206R1) {
                Intent intent = new Intent();
                intent.setClass(this.f13398b, SiteOfflineTipActivity.class);
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                this.f13398b.startActivity(intent);
            }
        }
    }

    /* renamed from: q */
    public final void m18434q() {
        int i10 = C1009d.m6109e().m6118j(this.f13398b) ? 1 : 2;
        if (i10 != C10028c.m62182c0().m62195C0()) {
            C10028c.m62182c0().m62392s3(i10);
            C13227f.m79492i1().m79556H0(i10);
        }
    }

    /* renamed from: r */
    public void m18435r() {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("refresh_task_report_terms_status", Boolean.valueOf(C10028c.m62182c0().m62221H1()));
        C13227f.m79492i1().m79591l0("refresh_task_report_terms_status_event", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "refresh_task_report_terms_status_event", "1", "34");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "refresh_task_report_terms_status_event", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B("refresh_task_report_terms_status_event");
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMapM79499C);
    }

    /* renamed from: s */
    public final void m18436s(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        if (basicModuleConfigV3Rsp != null) {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            c10028cM62182c0.m62363n(basicModuleConfigV3Rsp);
            c10028cM62182c0.m62308b2(basicModuleConfigV3Rsp);
            C11839m.m70688i("QueryBasicRefreshConfigTask", "forcedUpgradeType: " + basicModuleConfigV3Rsp.getForcedUpdate() + " upgradeType: " + basicModuleConfigV3Rsp.getUpgradeType());
            this.f13406j = basicModuleConfigV3Rsp.getForcedUpdate();
            this.f13407k = basicModuleConfigV3Rsp.getUpgradeType();
        }
    }

    /* renamed from: t */
    public final void m18437t() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62226I1()) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "foreced upgrade");
            C9908c.m61499D().m61548i0(this.f13398b);
        } else if (c10028cM62182c0.m62320e1()) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "cancel hicloud");
            c10028cM62182c0.m62235K2("cancel_version_code", C0241z.m1685c(C1443a.f6213a));
        }
    }

    /* renamed from: u */
    public final void m18438u() {
        Boolean boolM80803F0 = C13452e.m80781L().m80803F0();
        boolean zM62238L0 = C10028c.m62182c0().m62238L0();
        if (!boolM80803F0.booleanValue() && C0209d.m1166E1() && zM62238L0) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "signpushguide,again");
            C12515a.m75110o().m75172d(new C11258f(true, C10028c.m62182c0().m62234K0(), C10028c.m62182c0().m62215G0(), true, C2783d.m16077D()));
        }
    }

    /* renamed from: v */
    public final void m18439v() {
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            C11839m.m70689w("QueryBasicRefreshConfigTask", "tryReportLocalData, but backupSwitchStatus is false");
            return;
        }
        long jM62374p0 = C10028c.m62182c0().m62374p0();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jM62374p0 < 259200000) {
            C11839m.m70688i("QueryBasicRefreshConfigTask", "tryReportLocalData, but last report in 3 days");
            return;
        }
        C11839m.m70688i("QueryBasicRefreshConfigTask", "tryReportLocalData, start report");
        C12515a.m75110o().m75175e(new C3063n1(), false);
        C10028c.m62182c0().m62322e3(jCurrentTimeMillis);
    }
}
