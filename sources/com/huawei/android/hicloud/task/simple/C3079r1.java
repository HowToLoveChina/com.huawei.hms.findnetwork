package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.complexutil.C2784e;
import com.huawei.hicloud.base.bean.AgreementInfo;
import com.huawei.hicloud.base.bean.QueryDevConfAgreementRsp;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.bean.SyncConfig;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.DriveModuleConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import dj.C9159b;
import fk.C9721b;
import gp.C10028c;
import io.C10582a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mn.C11500d;
import p011aa.C0085e;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1008c;
import p020ap.C1009d;
import p037bp.C1270a;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p429kk.C11058a;
import p474m9.C11432a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p681uj.C13192i;
import p709vj.C13452e;
import p782xo.C13842a;
import p837z9.C14163d;
import p846zj.C14306d;
import tm.C13040c;
import tm.C13041d;
import vn.C13469a;

/* renamed from: com.huawei.android.hicloud.task.simple.r1 */
/* loaded from: classes3.dex */
public class C3079r1 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13371a;

    /* renamed from: b */
    public Context f13372b;

    /* renamed from: c */
    public int f13373c;

    /* renamed from: h */
    public boolean f13378h;

    /* renamed from: e */
    public C2784e f13375e = new C2784e();

    /* renamed from: f */
    public boolean f13376f = false;

    /* renamed from: g */
    public Map<String, String> f13377g = new HashMap();

    /* renamed from: i */
    public boolean f13379i = false;

    /* renamed from: d */
    public String f13374d = C11058a.m66627b("07021");

    public C3079r1(Context context, Handler handler, boolean z10, int i10) {
        this.f13373c = 0;
        this.f13378h = false;
        this.f13372b = context.getApplicationContext();
        this.f13371a = handler;
        this.f13378h = z10;
        this.f13373c = i10;
    }

    /* renamed from: o */
    private void m18385o() {
        C13040c.m78609F().m78651i();
        C13040c.m78609F().m78652i0(C0213f.m1377a(), C13452e.m80781L().m80942m(), true);
        C13041d.m78675e().m78676a();
        m18397p(12);
    }

    /* renamed from: c */
    public final void m18386c(CountDownLatch countDownLatch) throws InterruptedException {
        try {
            C11839m.m70688i("QueryBasicDevConfInitTask", "awaitParsesyncConfigFinish start");
            C11839m.m70688i("QueryBasicDevConfInitTask", "awaitParsesyncConfigFinish end, awaitResult = " + countDownLatch.await(30000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e10) {
            C11839m.m70687e("QueryBasicDevConfInitTask", "awaitParsesyncConfigFinish exception:" + e10.toString());
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        InterfaceC9282a interfaceC9282a;
        C11839m.m70688i("QueryBasicDevConfInitTask", "call");
        C14306d.m85214o();
        C14163d.m84990g().m85012r();
        try {
            Map<String, String> mapM78631W = C13040c.m78609F().m78631W();
            this.f13377g = mapM78631W;
            if (mapM78631W.size() <= 0) {
                C11839m.m70687e("QueryBasicDevConfInitTask", "urlsMap is null");
                C14163d.m84990g().m85013s();
                m18398q(12, 1000L);
                return;
            }
            C13041d.m78675e().m78683i(this.f13377g);
            try {
                if (!C0209d.m1333z1(this.f13372b)) {
                    m18398q(3, 1000L);
                    if (interfaceC9282a != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (C13192i.m79258g().m79259d() == 2) {
                    m18398q(6, 1000L);
                    C11839m.m70688i("QueryBasicDevConfInitTask", "query config end");
                    C14163d.m84990g().m85013s();
                    if (this.f13379i) {
                        C11839m.m70686d("QueryBasicDevConfInitTask", "request syncconfig success");
                        m18390g();
                        C11432a.m68479d().m68486c();
                        C13842a.m83010i().m83023a();
                        C1009d.m6109e().m6112c();
                        C13469a.m81112f().m81119h();
                    }
                    InterfaceC9282a interfaceC9282a2 = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                    if (interfaceC9282a2 != null) {
                        interfaceC9282a2.mo58462w0(this.f13372b);
                        return;
                    }
                    return;
                }
                if (this.f13376f) {
                    C11839m.m70688i("QueryBasicDevConfInitTask", "query config task is abort");
                    C11839m.m70688i("QueryBasicDevConfInitTask", "query config end");
                    C14163d.m84990g().m85013s();
                    if (this.f13379i) {
                        C11839m.m70686d("QueryBasicDevConfInitTask", "request syncconfig success");
                        m18390g();
                        C11432a.m68479d().m68486c();
                        C13842a.m83010i().m83023a();
                        C1009d.m6109e().m6112c();
                        C13469a.m81112f().m81119h();
                    }
                    InterfaceC9282a interfaceC9282a3 = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                    if (interfaceC9282a3 != null) {
                        interfaceC9282a3.mo58462w0(this.f13372b);
                        return;
                    }
                    return;
                }
                m18395m();
                C11839m.m70688i("QueryBasicDevConfInitTask", "query config end");
                C14163d.m84990g().m85013s();
                if (this.f13379i) {
                    C11839m.m70686d("QueryBasicDevConfInitTask", "request syncconfig success");
                    m18390g();
                    C11432a.m68479d().m68486c();
                    C13842a.m83010i().m83023a();
                    C1009d.m6109e().m6112c();
                    C13469a.m81112f().m81119h();
                }
                InterfaceC9282a interfaceC9282a4 = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                if (interfaceC9282a4 != null) {
                    interfaceC9282a4.mo58462w0(this.f13372b);
                }
            } finally {
                C11839m.m70688i("QueryBasicDevConfInitTask", "query config end");
                C14163d.m84990g().m85013s();
                if (this.f13379i) {
                    C11839m.m70686d("QueryBasicDevConfInitTask", "request syncconfig success");
                    m18390g();
                    C11432a.m68479d().m68486c();
                    C13842a.m83010i().m83023a();
                    C1009d.m6109e().m6112c();
                    C13469a.m81112f().m81119h();
                }
                interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                if (interfaceC9282a != null) {
                    interfaceC9282a.mo58462w0(this.f13372b);
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e("QueryBasicDevConfInitTask", "getServiceUrls exception: " + e10.toString());
            C14163d.m84990g().m85013s();
            m18398q(12, 1000L);
        }
    }

    /* renamed from: d */
    public final boolean m18387d(QueryDevConfAgreementRsp queryDevConfAgreementRsp) {
        boolean z10 = false;
        if (queryDevConfAgreementRsp == null) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "agreement rsp is null");
            return false;
        }
        List<AgreementInfo> agrInfo = queryDevConfAgreementRsp.getAgrInfo();
        if (agrInfo == null || agrInfo.isEmpty()) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "signInfo is null. doNoSign()");
            return true;
        }
        boolean zIsAgree = false;
        boolean zIsAgree2 = false;
        boolean zIsAgree3 = false;
        for (AgreementInfo agreementInfo : agrInfo) {
            int agrType = agreementInfo.getAgrType();
            if (agrType == 125) {
                zIsAgree2 = agreementInfo.isAgree();
            } else if (agrType == 10000) {
                zIsAgree = agreementInfo.isAgree();
            } else if (agrType == 10013) {
                zIsAgree3 = agreementInfo.isAgree();
            }
        }
        boolean z11 = zIsAgree || !"CN".equalsIgnoreCase(C11829c.m70533N());
        C11839m.m70688i("QueryBasicDevConfInitTask", "doCheckSigned result:" + zIsAgree2 + '|' + zIsAgree3 + '|' + z11);
        if (zIsAgree2 && zIsAgree3 && z11) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "All signed, Terms no need to show.");
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            c10028cM62182c0.m62197C2("agr_query_time", 0L);
            c10028cM62182c0.m62377p3("is_hicloud_terms_confirm", true);
            m18397p(9);
        } else {
            z10 = true;
        }
        return z10;
    }

    /* renamed from: e */
    public final void m18388e() {
        C10028c.m62182c0().m62343j();
        SyncModuleConfigManager.getInstance().clearDB();
        DriveModuleConfigManager.getInstance().clearDB();
    }

    /* renamed from: f */
    public final boolean m18389f(C10028c c10028c, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        if (!basicModuleConfigV3Rsp.isGuideSwitch()) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "guideswitch false,return finish");
            m18397p(7);
            return true;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "not owner user");
            m18388e();
            m18397p(7);
            return true;
        }
        if (!m18387d(basicModuleConfigV3Rsp.getQueryDevConfAgreementRsp())) {
            return false;
        }
        C11839m.m70688i("QueryBasicDevConfInitTask", "checkTermSignInfo need showAgreeView");
        m18388e();
        m18397p(10);
        return true;
    }

    /* renamed from: g */
    public final void m18390g() {
        C12515a.m75110o().m75172d(new InitCloudBackupDataTask(this.f13372b));
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.DEV_CONF_INIT;
    }

    /* renamed from: h */
    public final void m18391h(int i10, C10028c c10028c, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws InterruptedException {
        int matchResult = basicModuleConfigV3Rsp.getMatchResult();
        C11839m.m70688i("QueryBasicDevConfInitTask", "v3 config match result = " + matchResult);
        if (matchResult != 0) {
            if (matchResult == 8) {
                C11839m.m70688i("QueryBasicDevConfInitTask", "term no sign");
                m18397p(11);
                return;
            }
            if (matchResult != 2 && matchResult != 3) {
                if (matchResult == 5) {
                    m18388e();
                    m18385o();
                    return;
                } else if (matchResult != 6) {
                    m18388e();
                    m18397p(12);
                    return;
                }
            }
            m18388e();
            C13041d.m78675e().m78676a();
            m18397p(4);
            return;
        }
        int iM62318e = c10028c.m62318e(basicModuleConfigV3Rsp.getDataState());
        if (iM62318e != c10028c.m62373p() && (C0209d.m1161D0() || c10028c.m62423z())) {
            c10028c.m62192B2(iM62318e);
            c10028c.m62361m2(iM62318e);
            m18388e();
            c10028c.m62416x2(basicModuleConfigV3Rsp.getDataState());
            C9062b.m57146k().m57160p();
            m18396n(i10 + 1);
            return;
        }
        if (m18389f(c10028c, basicModuleConfigV3Rsp)) {
            return;
        }
        this.f13379i = true;
        m18399r(c10028c, basicModuleConfigV3Rsp);
        m18394l(basicModuleConfigV3Rsp);
        m18393k(basicModuleConfigV3Rsp);
        HiCloudAllOMConfigManager.getInstance().downloadMultipleConfig(null, true);
        SpaceNoticeV3Manager.getInstance().executeLocalLanguageTask();
        SpaceInsuffNoticeV4Manager.getInstance().executeLocalLanguageTask();
        if (basicModuleConfigV3Rsp.getDataState() == 4) {
            C12515a.m75110o().m75172d(new C0085e());
        } else if (basicModuleConfigV3Rsp.getDataState() == 3) {
            C14163d.m84990g().m85014t();
        }
        c10028c.m62192B2(iM62318e);
        c10028c.m62361m2(iM62318e);
        c10028c.m62376p2(true);
        C11500d.m68648g().m68660m(this.f13372b);
        HashMap<String, String> mapM18404g = C3091v1.m18404g(basicModuleConfigV3Rsp.getUserStatus(), false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (C1008c.m6035v().m6052Q(this.f13372b, countDownLatch)) {
            if (mapM18404g != null) {
                C9159b.m57573l(8, this.f13376f, this.f13373c, this.f13371a, mapM18404g);
                return;
            } else {
                m18397p(8);
                return;
            }
        }
        C11839m.m70689w("QueryBasicDevConfInitTask", "init databaseList fail");
        m18388e();
        m18386c(countDownLatch);
        m18397p(12);
    }

    /* renamed from: j */
    public final boolean m18392j(int i10, C9721b c9721b) {
        if (3102 == c9721b.m60659c()) {
            if (C10028c.m62182c0().m62420y1()) {
                C11839m.m70689w("QueryBasicDevConfInitTask", "can not init param from default server need change to obs mode");
                C10028c.m62182c0().m62361m2(1);
                m18396n(i10 + 1);
                return true;
            }
            C11839m.m70687e("QueryBasicDevConfInitTask", "can not init param from obs server");
            C10028c.m62182c0().m62361m2(0);
        }
        C11839m.m70687e("QueryBasicDevConfInitTask", "CException = " + c9721b.toString() + "code = " + c9721b.m60659c());
        m18388e();
        if (C0209d.m1333z1(this.f13372b)) {
            m18397p(12);
        } else {
            m18397p(3);
        }
        return false;
    }

    /* renamed from: k */
    public final void m18393k(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        NotifyLogger.m29915i("QueryBasicDevConfInitTask", "parseDriveConfig is not support drive function");
    }

    /* renamed from: l */
    public final void m18394l(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws InterruptedException {
        SyncConfig syncConfig = basicModuleConfigV3Rsp.getSyncConfig();
        if (syncConfig == null) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "devConfInit syncConfig null");
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SyncModuleConfigManager.getInstance().parseSyncConfig(syncConfig, countDownLatch);
        m18386c(countDownLatch);
    }

    /* renamed from: m */
    public final void m18395m() {
        try {
            C14163d.m84990g().m84999d(this.f13377g);
            m18396n(0);
        } catch (C9721b e10) {
            C11839m.m70687e("QueryBasicDevConfInitTask", "checkDefaultEncryptMode fail!" + e10.toString());
            m18397p(12);
        }
    }

    /* renamed from: n */
    public final void m18396n(int i10) {
        if (i10 > 2) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "query retry times more than 2");
            m18388e();
            m18397p(12);
            return;
        }
        try {
            C10582a c10582a = new C10582a(this.f13374d);
            C10028c c10028cM62183d0 = C10028c.m62183d0(this.f13372b);
            c10028cM62183d0.m62317d3(System.currentTimeMillis());
            BasicModuleConfigV3Rsp basicModuleConfigV3RspM64919T = c10582a.m64919T(this.f13378h);
            if (basicModuleConfigV3RspM64919T.getMatchResult() == 7) {
                basicModuleConfigV3RspM64919T = c10582a.m64919T(this.f13378h);
            }
            m18391h(i10, c10028cM62183d0, basicModuleConfigV3RspM64919T);
        } catch (C9721b e10) {
            if (m18392j(i10, e10)) {
                return;
            }
            m18388e();
            m18397p(12);
        } catch (Exception e11) {
            C11839m.m70687e("QueryBasicDevConfInitTask", e11.toString());
            m18388e();
            m18397p(12);
        }
    }

    /* renamed from: p */
    public final void m18397p(int i10) {
        if (this.f13376f) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "query dev config task is abort");
            return;
        }
        Message messageObtainMessage = this.f13371a.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = this.f13373c;
        this.f13371a.sendMessage(messageObtainMessage);
    }

    /* renamed from: q */
    public final void m18398q(int i10, long j10) {
        if (this.f13376f) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "query dev config task is abort");
            return;
        }
        Message messageObtainMessage = this.f13371a.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = this.f13373c;
        this.f13371a.sendMessageDelayed(messageObtainMessage, j10);
    }

    /* renamed from: r */
    public final void m18399r(C10028c c10028c, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        c10028c.m62363n(basicModuleConfigV3Rsp);
        c10028c.m62308b2(basicModuleConfigV3Rsp);
        this.f13375e.m16198e(basicModuleConfigV3Rsp, c10028c);
        C14163d.m84990g().m85000e();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("QueryBasicDevConfInitTask", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58388Q(this.f13372b);
            interfaceC9282a.mo58375J0(this.f13372b);
        }
    }

    public void setAbort(boolean z10) {
        this.f13376f = z10;
    }
}
