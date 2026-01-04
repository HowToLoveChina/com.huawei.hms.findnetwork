package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.complexutil.C2784e;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.task.HiCloudParamMetaQueryTask;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.service.C5008e;
import dj.C9159b;
import fk.C9721b;
import gp.C10028c;
import io.C10582a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mn.C11500d;
import p011aa.C0085e;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1008c;
import p037bp.C1270a;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p252e9.C9436m;
import p252e9.C9437n;
import p292fn.C9733f;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11076b;
import p431ko.C11079e;
import p459lp.C11326d;
import p474m9.C11432a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13225d;
import p703v8.C13371h;
import p709vj.C13452e;
import p837z9.C14163d;
import p846zj.C14306d;

/* renamed from: com.huawei.android.hicloud.task.simple.v1 */
/* loaded from: classes3.dex */
public class C3091v1 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13387a;

    /* renamed from: b */
    public Context f13388b;

    /* renamed from: c */
    public CountDownLatch f13389c;

    /* renamed from: d */
    public int f13390d;

    /* renamed from: h */
    public boolean f13394h;

    /* renamed from: f */
    public C2784e f13392f = new C2784e();

    /* renamed from: g */
    public boolean f13393g = false;

    /* renamed from: e */
    public String f13391e = C11058a.m66627b("07004");

    public C3091v1(Context context, Handler handler, int i10, boolean z10) {
        this.f13390d = 0;
        this.f13394h = false;
        this.f13388b = context.getApplicationContext();
        this.f13387a = handler;
        this.f13390d = i10;
        this.f13394h = z10;
    }

    /* renamed from: g */
    public static HashMap<String, String> m18404g(String str, boolean z10) throws InterruptedException {
        C11839m.m70688i("QueryBasicInitConfigTask", "dealOtherFlow isFromOOBE:" + z10);
        C11432a.m68479d().m68486c();
        C13225d.m79490f1().m79560L(C0213f.m1377a(), C13452e.m80781L().m80971t0());
        CountDownLatch countDownLatch = new CountDownLatch(4);
        m18405j(countDownLatch);
        HashMap<String, String> mapM57565d = (!GetUserRegisterResp.isInActive(str) || z10) ? null : C9159b.m57565d();
        try {
            countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
            C11839m.m70688i("QueryBasicInitConfigTask", "dealOtherFlow await finish");
        } catch (InterruptedException e10) {
            C11839m.m70687e("QueryBasicInitConfigTask", "awaitOtherQueryCountDownLatchFinish doInBackground exception:" + e10.toString());
        }
        C14306d.m85216q(C11326d.m68046h());
        if (new C5008e(null).m30042d()) {
            C1461a.m8359i("QueryBasicInitConfigTask", "feature config query success");
        }
        if (!m18409n()) {
            m18408m();
        }
        if (mapM57565d == null) {
            C11839m.m70688i("QueryBasicInitConfigTask", "updateNewBM result:" + C9948a.m61631C().m61696t0());
        } else {
            C9948a.m61632n0(0);
        }
        C9436m.m59180d().m59186g();
        m18407l();
        return mapM57565d;
    }

    /* renamed from: j */
    public static void m18405j(CountDownLatch countDownLatch) {
        new C11076b(countDownLatch, new C11076b.a() { // from class: com.huawei.android.hicloud.task.simple.s1
            @Override // p431ko.C11076b.a
            /* renamed from: a */
            public final void mo18400a() throws C9721b {
                C3091v1.m18410o();
            }
        }).execute();
        new C11076b(countDownLatch, new C11076b.a() { // from class: com.huawei.android.hicloud.task.simple.t1
            @Override // p431ko.C11076b.a
            /* renamed from: a */
            public final void mo18400a() {
                UserSpaceUtil.getGradeCodeUseCache("QueryBasicInitConfig");
            }
        }).execute();
        C9733f.m60705z().m60739d0(countDownLatch);
        C12515a.m75110o().m75175e(new HiCloudParamMetaQueryTask(countDownLatch), false);
    }

    /* renamed from: k */
    private void m18406k() {
        C12515a.m75110o().m75172d(new InitCloudBackupDataTask(this.f13388b));
    }

    /* renamed from: l */
    public static void m18407l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.data.state");
        arrayList.add("bs.bm.grade.state");
        arrayList.add("bs.dsu.cloud.usage");
        C12515a.m75110o().m75172d(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.task.simple.u1
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                C3091v1.m18412q(userDataStateInfo);
            }
        }, false, arrayList, "InitConfigTask"));
    }

    /* renamed from: m */
    public static void m18408m() {
        String strM60707B = C9733f.m60705z().m60707B();
        C11839m.m70688i("QueryBasicInitConfigTask", "initReceiveActivityCrad packageId " + strM60707B);
        if (TextUtils.isEmpty(strM60707B)) {
            C11839m.m70688i("QueryBasicInitConfigTask", "packageId is null ");
            return;
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06008"), "getAvailableGradePackages", C13452e.m80781L().m80971t0());
        Filter filter = new Filter();
        filter.setPackageId(strM60707B);
        GetAvailableGradePackagesResp getAvailableGradePackagesRespM61697u = null;
        try {
            getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61697u(c11060cM66626a, filter, null, new ChannelInfo());
        } catch (C9721b e10) {
            C11839m.m70688i("QueryBasicInitConfigTask", "initReceiveActivityCrad  e:" + e10);
        }
        if (getAvailableGradePackagesRespM61697u == null) {
            C11839m.m70688i("QueryBasicInitConfigTask", "packagesResp is null ");
            return;
        }
        List<CloudPackage> spacePackages = getAvailableGradePackagesRespM61697u.getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            C11839m.m70688i("QueryBasicInitConfigTask", "spacePackages is null ");
            return;
        }
        CloudPackage cloudPackage = spacePackages.get(0);
        C10028c.m62182c0().m62366n2(cloudPackage.getCapacity());
        C10028c.m62182c0().m62426z2(cloudPackage.getDurationMonth());
        C11839m.m70688i("QueryBasicInitConfigTask", "initReceiveActivityCrad end ");
    }

    /* renamed from: n */
    public static boolean m18409n() {
        if (!C13452e.m80781L().m80892b1() || C0209d.m1269j1()) {
            C11839m.m70688i("QueryBasicInitConfigTask", "initAvailableData return");
            return true;
        }
        if (!C9733f.m60705z().m60720O("bmEnabled")) {
            C11839m.m70688i("QueryBasicInitConfigTask", "bmEnabled return false");
            return true;
        }
        if (C9733f.m60705z().m60715J()) {
            return false;
        }
        C11839m.m70688i("QueryBasicInitConfigTask", "isBmGuideEnabled return false");
        return true;
    }

    /* renamed from: o */
    public static /* synthetic */ void m18410o() throws C9721b {
        FamilyShareInfoResult familyShareInfoResultM80271a = new C13371h().m80271a();
        C13452e.m80781L().m80856S2(familyShareInfoResultM80271a != null ? familyShareInfoResultM80271a.getSpaceShareEnable() : 0);
    }

    /* renamed from: q */
    public static /* synthetic */ void m18412q(UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo != null) {
            C13452e.m80781L().m80839O1(userDataStateInfo.getDataPeriod());
            C13452e.m80781L().m80893b2(userDataStateInfo.getBmGradeState());
            C0212e0.m1371u(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_size", userDataStateInfo.getBsDsuCloudUsage());
        }
    }

    /* renamed from: r */
    private void m18413r(int i10, C10028c c10028c, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws InterruptedException {
        int matchResult = basicModuleConfigV3Rsp.getMatchResult();
        C11839m.m70688i("QueryBasicInitConfigTask", "v3 config match result = " + matchResult);
        if (matchResult != 0) {
            if (matchResult == 2) {
                C10028c.m62182c0().m62343j();
                m18419f(this.f13389c);
                m18417v(4);
                return;
            } else if (matchResult != 3) {
                C10028c.m62182c0().m62343j();
                m18419f(this.f13389c);
                m18417v(1);
                return;
            } else {
                C10028c.m62182c0().m62343j();
                c10028c.m62377p3("is_already_configed_NV4", true);
                m18419f(this.f13389c);
                m18417v(4);
                return;
            }
        }
        int iM62318e = c10028c.m62318e(basicModuleConfigV3Rsp.getDataState());
        if (iM62318e != c10028c.m62373p() && (C0209d.m1161D0() || c10028c.m62423z())) {
            c10028c.m62192B2(iM62318e);
            c10028c.m62361m2(iM62318e);
            c10028c.m62343j();
            c10028c.m62416x2(basicModuleConfigV3Rsp.getDataState());
            C9062b.m57146k().m57160p();
            m18416u(i10 + 1);
            return;
        }
        c10028c.m62363n(basicModuleConfigV3Rsp);
        if (!this.f13393g) {
            c10028c.m62308b2(basicModuleConfigV3Rsp);
        }
        this.f13392f.m16198e(basicModuleConfigV3Rsp, c10028c);
        C14163d.m84990g().m85000e();
        c10028c.m62192B2(iM62318e);
        c10028c.m62361m2(iM62318e);
        c10028c.m62376p2(true);
        C11839m.m70688i("QueryBasicInitConfigTask", "set encrypt mode success");
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58388Q(this.f13388b);
            interfaceC9282a.mo58375J0(this.f13388b);
        } else {
            C11839m.m70688i("QueryBasicInitConfigTask", "cloudAlbumRouterImpl is null");
        }
        if (basicModuleConfigV3Rsp.getDataState() == 4) {
            C12515a.m75110o().m75172d(new C0085e());
        } else if (basicModuleConfigV3Rsp.getDataState() == 3) {
            C14163d.m84990g().m85014t();
        }
        C11500d.m68648g().m68660m(this.f13388b);
        HashMap<String, String> mapM18404g = m18404g(basicModuleConfigV3Rsp.getUserStatus(), this.f13394h);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!C1008c.m6035v().m6052Q(this.f13388b, countDownLatch)) {
            C11839m.m70689w("QueryBasicInitConfigTask", "init databaseList fail");
            C10028c.m62182c0().m62343j();
            m18419f(countDownLatch);
            m18419f(this.f13389c);
            m18417v(1);
            return;
        }
        boolean zM18419f = m18419f(this.f13389c);
        C9437n.m59190e().m59191c();
        C11839m.m70688i("QueryBasicInitConfigTask", "awaitRequestConfigTaskFinish is over" + zM18419f);
        m18420h(zM18419f, mapM18404g);
    }

    /* renamed from: s */
    private boolean m18414s(int i10, C9721b c9721b) throws InterruptedException {
        if (3102 == c9721b.m60659c()) {
            if (C10028c.m62182c0().m62420y1()) {
                C11839m.m70689w("QueryBasicInitConfigTask", "can not init param from default server need change to obs mode");
                C10028c.m62182c0().m62361m2(1);
                m18416u(i10 + 1);
                return true;
            }
            C11839m.m70687e("QueryBasicInitConfigTask", "can not init param from obs server");
            C10028c.m62182c0().m62361m2(0);
        }
        C11839m.m70687e("QueryBasicInitConfigTask", "CException = " + c9721b.toString() + "code = " + c9721b.m60659c());
        C10028c.m62182c0().m62343j();
        m18419f(this.f13389c);
        if (C0209d.m1333z1(this.f13388b)) {
            m18417v(1);
        } else {
            m18417v(3);
        }
        return false;
    }

    /* renamed from: t */
    private void m18415t() throws InterruptedException {
        try {
            C14163d.m84990g().m84998c();
            m18416u(0);
        } catch (C9721b e10) {
            C11839m.m70687e("QueryBasicInitConfigTask", "checkDefaultEncryptMode fail!" + e10.toString());
            m18419f(this.f13389c);
            m18417v(1);
        }
    }

    /* renamed from: u */
    private void m18416u(int i10) throws InterruptedException {
        if (i10 > 2) {
            C11839m.m70688i("QueryBasicInitConfigTask", "query retry times more than 2");
            C10028c.m62182c0().m62343j();
            m18419f(this.f13389c);
            m18417v(1);
            return;
        }
        try {
            C10582a c10582a = new C10582a(this.f13391e);
            C10028c c10028cM62183d0 = C10028c.m62183d0(this.f13388b);
            c10028cM62183d0.m62317d3(System.currentTimeMillis());
            m18413r(i10, c10028cM62183d0, c10582a.m64923X(this.f13394h));
        } catch (C9721b e10) {
            if (m18414s(i10, e10)) {
                return;
            }
            C10028c.m62182c0().m62343j();
            m18419f(this.f13389c);
            m18417v(1);
        } catch (Exception e11) {
            C11839m.m70687e("QueryBasicInitConfigTask", e11.toString());
            C10028c.m62182c0().m62343j();
            m18419f(this.f13389c);
            m18417v(1);
        }
    }

    /* renamed from: v */
    private void m18417v(int i10) {
        if (this.f13393g) {
            C11839m.m70688i("QueryBasicInitConfigTask", "query config task is abort");
            return;
        }
        Message messageObtainMessage = this.f13387a.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = this.f13390d;
        this.f13387a.sendMessage(messageObtainMessage);
    }

    /* renamed from: y */
    private void m18418y(int i10, long j10) {
        if (this.f13393g) {
            C11839m.m70688i("QueryBasicInitConfigTask", "query config task is abort");
            return;
        }
        Message messageObtainMessage = this.f13387a.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = this.f13390d;
        this.f13387a.sendMessageDelayed(messageObtainMessage, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x006b A[DONT_GENERATE, PHI: r0
  0x006b: PHI (r0v9 dp.a) = (r0v6 dp.a), (r0v8 dp.a), (r0v11 dp.a) binds: [B:60:0x00f1, B:54:0x00bb, B:44:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p616rk.AbstractRunnableC12516b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call() {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.task.simple.C3091v1.call():void");
    }

    /* renamed from: f */
    public final boolean m18419f(CountDownLatch countDownLatch) throws InterruptedException {
        try {
            C11839m.m70688i("QueryBasicInitConfigTask", "awaitRequestConfigTaskFinish start");
            boolean zAwait = countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
            C11839m.m70688i("QueryBasicInitConfigTask", "awaitRequestConfigTaskFinish end, awaitResult = " + zAwait);
            HiCloudForceUpgradeConfigManager.getInstance().saveForcedUpgradeConfig(null);
            return zAwait;
        } catch (InterruptedException e10) {
            C11839m.m70687e("QueryBasicInitConfigTask", "awaitRequestConfigTaskFinish doInBackground exception:" + e10.toString());
            return false;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_BASIC_INIT_CONFIG;
    }

    /* renamed from: h */
    public final void m18420h(boolean z10, HashMap<String, String> map) {
        if (this.f13394h) {
            if (z10) {
                m18417v(2);
            }
        } else if (map != null) {
            C9159b.m57573l(2, this.f13393g, this.f13390d, this.f13387a, map);
        } else {
            m18417v(2);
        }
    }

    public void setAbort(boolean z10) {
        this.f13393g = z10;
    }
}
