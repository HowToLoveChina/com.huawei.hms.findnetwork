package p575qe;

import af.C0188a;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.lockscreen.DeviceAdministratorReceiver;
import com.huawei.android.remotecontrol.lockscreen.UnlockScreenReceiverBroadcast;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.p093ui.LockCallActivity;
import com.huawei.android.remotecontrol.p093ui.PhoneFinderActivity;
import com.huawei.android.remotecontrol.p093ui.activation.ActivationNormalActivity;
import com.huawei.android.remotecontrol.p093ui.activation.CheckPwdActivity;
import com.huawei.android.remotecontrol.p093ui.activation.OOBEPhoneFinderActivity;
import com.huawei.android.remotecontrol.receiver.C4388a;
import com.huawei.android.remotecontrol.receiver.PushCommandReceiver;
import com.huawei.android.remotecontrol.track.C4443e;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import eg.AbstractC9478g;
import gp.C10028c;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p015ak.C0226l0;
import p226df.C9094b;
import p227dg.C9097b;
import p256ef.C9465f;
import p366if.C10481f;
import p394jf.C10814b;
import p394jf.C10818f;
import p422k9.C11019b;
import p451lf.C11274a;
import p520of.C11852b;
import p520of.C11853c;
import p520of.C11860j;
import p521og.C11870c;
import p521og.C11873f;
import p521og.C11875h;
import p521og.C11876i;
import p521og.C11877j;
import p576qf.InterfaceC12348a;
import p611rf.C12505m;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13230i;
import p709vj.C13452e;
import p772xe.C13777b;
import p809yg.C13981a;
import p841ze.C14288b;
import pg.AbstractC12139d;
import pg.C12140e;
import sg.C12797b;
import tm.C13040c;
import tm.C13042e;
import ug.C13171a;

/* renamed from: qe.f */
/* loaded from: classes4.dex */
public class C12347f {

    /* renamed from: e */
    public static final C12347f f57134e = new C12347f();

    /* renamed from: a */
    public boolean f57135a;

    /* renamed from: b */
    public Context f57136b;

    /* renamed from: c */
    public PushCommandReceiver f57137c;

    /* renamed from: d */
    public boolean f57138d = false;

    /* renamed from: qe.f$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C12347f.this.m74305r();
        }
    }

    /* renamed from: qe.f$b */
    public class b implements InterfaceC12348a {

        /* renamed from: a */
        public final /* synthetic */ Context f57140a;

        public b(Context context) {
            this.f57140a = context;
        }

        @Override // p576qf.InterfaceC12348a
        public void onResult(boolean z10) {
            C12347f.this.m74290D(this.f57140a, z10);
        }
    }

    /* renamed from: n */
    public static C12347f m74285n() {
        return f57134e;
    }

    /* renamed from: x */
    public static /* synthetic */ void m74286x(boolean z10) {
        if (z10) {
            return;
        }
        C11860j.m71010N0("updateAccountCountryCode");
    }

    /* renamed from: A */
    public final void m74287A() {
        C11019b.m66371t().m66430l0("OOBEPhoneFinderActivity", OOBEPhoneFinderActivity.class);
        C11019b.m66371t().m66430l0("ActivationNormalActivity", ActivationNormalActivity.class);
        C11019b.m66371t().m66434n0(C11876i.m71195c());
    }

    /* renamed from: B */
    public final void m74288B() {
        if (!C0209d.m1257g1()) {
            C13981a.m83989i("PhoneFinderManager", "not harmony os three");
            return;
        }
        try {
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.f57136b.getSystemService("device_policy");
            ComponentName componentName = new ComponentName(this.f57136b, (Class<?>) DeviceAdministratorReceiver.class);
            if (devicePolicyManager.isAdminActive(componentName)) {
                C13981a.m83989i("PhoneFinderManager", "remove active admin");
                devicePolicyManager.removeActiveAdmin(componentName);
            }
        } catch (Exception e10) {
            C13981a.m83990w("PhoneFinderManager", "remove active admin exception:" + e10.getMessage());
        }
    }

    /* renamed from: C */
    public final void m74289C() {
        int iM71281l = C11877j.m71281l(this.f57136b);
        if (iM71281l == -1) {
            return;
        }
        if (!C13230i.m79506N() || !UBAAnalyze.m29974e("CKP", "HUAWEICLOUD")) {
            C13981a.m83990w("PhoneFinderManager", "HiAnalytics can not report");
            return;
        }
        String strM1572a = C0224k0.a.m1572a("ro.board.platform");
        String strM80790C = C13452e.m80781L().m80790C();
        UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "cal_lock_type", String.valueOf(iM71281l), strM80790C);
        UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "cal_lock_type_cpu", strM1572a, strM80790C);
        new C12797b().m76784j(this.f57136b, "PhoneFinderManager", "001_3007", "cal_lock_type_cpu:" + strM1572a, String.valueOf(iM71281l), "active_type", null, "calLockType", true);
        C11877j.m71306t0(this.f57136b, -1);
    }

    /* renamed from: D */
    public final void m74290D(Context context, boolean z10) {
        if (z10) {
            C11877j.m71320z0(context, true);
            C11877j.m71227P0(context, "");
        }
        new C12797b().m76782h(this.f57136b, "PhoneFinderManager", "01078", 0, z10 ? "update challenge write ta success" : "update challenge write ta error", null, "01078", null, "taWriteError", true);
    }

    /* renamed from: E */
    public final void m74291E(boolean z10) {
        new C12797b().m76782h(this.f57136b, "PhoneFinderManager", "01073", 0, z10 ? "update deviceId write ta success" : "update deviceId write ta error", null, "01073", null, "update deviceId", true);
    }

    /* renamed from: F */
    public void m74292F(Context context) {
        if (context != null) {
            this.f57136b = context.getApplicationContext();
        }
    }

    /* renamed from: G */
    public void m74293G(boolean z10) {
        this.f57138d = z10;
    }

    /* renamed from: H */
    public final void m74294H() {
        if (C11877j.m71236U(this.f57136b)) {
            C13981a.m83989i("PhoneFinderManager", "start lock call activity when phoneFinder init");
            String strM71232S = C11877j.m71232S(this.f57136b, "user_lock_message");
            String strM71232S2 = C11877j.m71232S(this.f57136b, "user_lock_phone");
            String strM71232S3 = C11877j.m71232S(this.f57136b, "user_lock_email");
            Intent intent = new Intent(this.f57136b, (Class<?>) LockCallActivity.class);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.putExtra("hw_frp_token", C11860j.m71009N());
            intent.putExtra("message", strM71232S);
            intent.putExtra("email", strM71232S3);
            intent.putExtra("phoneNum", strM71232S2);
            m74301m().startActivity(intent);
        }
    }

    /* renamed from: I */
    public final void m74295I(String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("PhoneFinderManager", "countryCode is empty");
            return;
        }
        C13981a.m83989i("PhoneFinderManager", "update Account CountryCode");
        C11860j.m71000I0(AbstractC12139d.m72766e(this.f57136b).getDeviceID(), "updateAccountCountryCode");
        AbstractC12139d.m72766e(this.f57136b).setCountryCode(str);
        AbstractC12139d.m72772k(this.f57136b, new InterfaceC12348a() { // from class: qe.a
            @Override // p576qf.InterfaceC12348a
            public final void onResult(boolean z10) {
                C12347f.m74286x(z10);
            }
        });
    }

    /* renamed from: h */
    public final void m74296h() {
        C13981a.m83989i("PhoneFinderManager", "checkAntiTheft");
        if (!C11853c.m70968g().m70972h(this.f57136b)) {
            C13981a.m83989i("PhoneFinderManager", "TA key empty");
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83989i("PhoneFinderManager", "hicloud not login");
            return;
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0)) {
            C13981a.m83989i("PhoneFinderManager", "hicloud userId is empty");
            return;
        }
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this.f57136b);
        if (accountInfoM72766e == null) {
            C13981a.m83989i("PhoneFinderManager", "accountInfo null");
            return;
        }
        if (!strM80971t0.equals(accountInfoM72766e.getUserID4RC())) {
            C13981a.m83989i("PhoneFinderManager", "userId not match");
            return;
        }
        m74298j(accountInfoM72766e);
        if (C11870c.m71156d(accountInfoM72766e.getDeviceTicket())) {
            C13981a.m83987d("PhoneFinderManager", "dt is not empty");
        } else {
            C13981a.m83989i("PhoneFinderManager", "doUpdateDeviceTicket");
            new C12505m().m75087f();
        }
    }

    /* renamed from: i */
    public void m74297i(final Context context, boolean z10) {
        try {
            if (!z10) {
                C13981a.m83989i("PhoneFinderManager", "startUp return");
                return;
            }
            if (C11877j.m71196A(context)) {
                C13981a.m83989i("PhoneFinderManager", "challenge has bean checked");
                return;
            }
            if (System.currentTimeMillis() - C11877j.m71287n(context) < 60000) {
                C13981a.m83989i("PhoneFinderManager", "check time limit");
                return;
            }
            String strM71216K = C11877j.m71216K(context);
            String challengeString = AbstractC12139d.m72766e(context).getChallengeString();
            if (TextUtils.isEmpty(strM71216K) && TextUtils.isEmpty(challengeString)) {
                C13981a.m83989i("PhoneFinderManager", "challenge is empty");
                C11877j.m71320z0(context, true);
                C11877j.m71312v0(context, System.currentTimeMillis());
            } else {
                C11877j.m71312v0(context, System.currentTimeMillis());
                AbstractC12139d.m72766e(context).setChallengeString("");
                AbstractC12139d.m72776o(context, new InterfaceC12348a() { // from class: qe.d
                    @Override // p576qf.InterfaceC12348a
                    public final void onResult(boolean z11) {
                        this.f57131a.m74309v(context, z11);
                    }
                });
            }
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderManager", "checkChallenge err:" + e10.getMessage());
        }
    }

    /* renamed from: j */
    public final void m74298j(AccountInfo accountInfo) {
        String deviceID = accountInfo.getDeviceID();
        if (TextUtils.isEmpty(deviceID) || C11870c.m71156d(deviceID)) {
            return;
        }
        C13981a.m83989i("PhoneFinderManager", "doUpdate deviceId");
        String strM80950o = C13452e.m80781L().m80950o();
        if (TextUtils.isEmpty(strM80950o)) {
            new C12797b().m76782h(this.f57136b, "PhoneFinderManager", "01073", 0, "update deviceId,cloud deviceId is empty", null, "01073", null, "update deviceId", true);
        } else {
            AbstractC12139d.m72766e(this.f57136b).setDeviceID(strM80950o);
            AbstractC12139d.m72772k(this.f57136b, new InterfaceC12348a() { // from class: qe.b
                @Override // p576qf.InterfaceC12348a
                public final void onResult(boolean z10) {
                    this.f57129a.m74310w(z10);
                }
            });
        }
    }

    /* renamed from: k */
    public final void m74299k() {
        try {
            if (!C11877j.m71236U(this.f57136b)) {
                C13981a.m83989i("PhoneFinderManager", "lostMode false");
            } else if (C4452n.m27030j(this.f57136b)) {
                C13981a.m83989i("PhoneFinderManager", "isLocked true");
                C0226l0.m1586f(new Runnable() { // from class: qe.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f57130a.m74294H();
                    }
                });
            } else {
                C13981a.m83989i("PhoneFinderManager", "stopLostMode");
                UnlockScreenReceiverBroadcast.m26253a(this.f57136b, true);
            }
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderManager", "checkLostModeStatus:" + e10.getMessage());
        }
    }

    /* renamed from: l */
    public void m74300l(Context context) {
        C13981a.m83989i("PhoneFinderManager", "clearPhoneFinder");
        if (context == null) {
            context = m74301m();
        }
        C11877j.m71286m1(context, false);
        C10028c.m62182c0().m62321e2(false);
        C9465f.m59265A().m59298Q(context);
        if (C4375j.m26422x(context)) {
            C4375j.m26396J(context, false, null);
        }
        C11877j.m71274i1(context, Boolean.FALSE);
        AbstractC12139d.m72764c(context);
        C13040c.m78609F().m78647g();
        AncillaryDeviceManager.m26080y().m26105t(context);
        C11877j.m71257d(context);
        C11877j.m71260e(context);
        C10481f.m64428d();
        C13777b.m82701b();
        C9097b.m57295e();
        C11860j.m71034Z0(null);
    }

    /* renamed from: m */
    public Context m74301m() {
        return this.f57136b;
    }

    /* renamed from: o */
    public boolean m74302o(Context context) {
        C13981a.m83989i("PhoneFinderManager", "init");
        if (!C0209d.m1309t1(context)) {
            C13981a.m83989i("PhoneFinderManager", "not in main process");
            return false;
        }
        if (this.f57135a) {
            C13981a.m83989i("PhoneFinderManager", "has inited");
            return false;
        }
        this.f57135a = true;
        C12140e.m72777a(context);
        this.f57136b = context.getApplicationContext();
        C11873f.m71178f().m71186i(this.f57136b);
        m74306s(context);
        C4388a.m26498b().m26499c(context);
        m74287A();
        C4443e.m26980d(context);
        C11274a.m67666c().m67667d(context);
        C10818f.m65874a().m65875b(context);
        C10814b.m65858a().m65859b(context);
        C12515a.m75110o().m75172d(new a());
        m74304q();
        return true;
    }

    /* renamed from: p */
    public final void m74303p() {
        String strM80942m;
        C13981a.m83989i("PhoneFinderManager", "initAccount");
        if (!C11853c.m70968g().m70972h(this.f57136b)) {
            C13981a.m83989i("PhoneFinderManager", "TA key is empty");
            return;
        }
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this.f57136b);
        if (TextUtils.isEmpty(accountInfoM72766e.getCountryCode())) {
            C13981a.m83989i("PhoneFinderManager", "countryCode in TA not exist");
            if (C13452e.m80781L().m80842P0() && !TextUtils.isEmpty(accountInfoM72766e.getUserID4RC()) && accountInfoM72766e.getUserID4RC().equals(C13452e.m80781L().m80971t0())) {
                C13981a.m83989i("PhoneFinderManager", "copy countryCode from AccountSetting");
                strM80942m = C13452e.m80781L().m80942m();
            } else {
                strM80942m = "1".equals(accountInfoM72766e.getSiteID()) ? "CN" : "";
            }
            if (C1175a.m7389k(this.f57136b)) {
                m74295I(strM80942m);
            }
        }
    }

    /* renamed from: q */
    public final void m74304q() {
        NotifyConstants.getGotoAppMapping().put(NotifyConstants.FIND_MY_PHONE, PhoneFinderActivity.class);
        NotifyConstants.getForcedUpgradeMapping().put(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, CheckPwdActivity.class.getName());
    }

    /* renamed from: r */
    public final void m74305r() {
        C13981a.m83989i("PhoneFinderManager", "initPhoneFinderAsync");
        if (C13171a.m79199e()) {
            C11877j.m71271h1(m74301m(), C13171a.m79195a());
        }
        C10028c.m62182c0().m62321e2(C1175a.m7389k(m74301m()));
        boolean zM1203Q1 = C0209d.m1203Q1(this.f57136b);
        m74307t(m74301m());
        m74297i(this.f57136b, zM1203Q1);
        C11875h.m71193d(this.f57136b);
        boolean zM7390l = C1175a.m7390l(this.f57136b, C13452e.m80781L().m80971t0());
        if (!C0209d.m1166E1() || zM7390l) {
            C11875h.m71194e(this.f57136b, false);
        } else {
            C11875h.m71192c(this.f57136b);
            C11875h.m71191b(this.f57136b);
        }
        m74299k();
        boolean zM7389k = C1175a.m7389k(this.f57136b);
        if (zM7389k && !C11877j.m71220M(this.f57136b)) {
            C14288b.m85121x0(this.f57136b);
        }
        if (C10028c.m62182c0().m62221H1() && C1175a.m7389k(this.f57136b)) {
            ParamConfig.getInstance();
            AncillaryDeviceManager.m26080y().m26094R();
            C0188a.m1066c(this.f57136b);
        }
        if (!C11877j.m71200C(this.f57136b) && C1175a.m7389k(this.f57136b) && zM1203Q1) {
            C13981a.m83989i("PhoneFinderManager", "need setLogoutIntent2");
            new C9094b().m82860b();
        }
        m74289C();
        m74288B();
        if (zM7390l) {
            C4375j.m26421w(false);
        }
        C11860j.m70983A(this.f57136b);
        if (zM7389k && zM1203Q1) {
            C11852b.m70957b().m70958c(this.f57136b);
        }
    }

    /* renamed from: s */
    public final void m74306s(Context context) {
        if (this.f57137c == null) {
            this.f57137c = new PushCommandReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.push.message");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.update.active.info");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.location.share.message");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.offline.locate.message");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.find.lost.message");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.tag.disconnect.message");
            C13108a.m78878b(context).m78880c(this.f57137c, intentFilter);
        }
    }

    /* renamed from: t */
    public synchronized void m74307t(Context context) {
        C13981a.m83989i("PhoneFinderManager", "initAccountCheckTaKey");
        if (context == null) {
            C13981a.m83988e("PhoneFinderManager", "initAccountCheckTaKey context null");
            return;
        }
        boolean zM7389k = C1175a.m7389k(context);
        C13981a.m83989i("PhoneFinderManager", "phoneFinderSwitch: " + zM7389k);
        if (!C11877j.m71302s(context) && C0209d.m1277l1()) {
            C13981a.m83989i("PhoneFinderManager", "clear sp accountInfo");
            C11877j.m71248a(context);
        }
        if (zM7389k && C0209d.m1203Q1(context) && !C11853c.m70968g().m70972h(context) && C11853c.m70968g().m70971f(context)) {
            AbstractC12139d.m72767f(context, true);
        }
        if (C1175a.m7389k(context)) {
            m74303p();
            m74312z();
            m74296h();
        }
    }

    /* renamed from: u */
    public boolean m74308u() {
        return this.f57138d;
    }

    /* renamed from: v */
    public final /* synthetic */ void m74309v(Context context, boolean z10) {
        m74290D(context, z10);
        if (z10) {
            return;
        }
        C13981a.m83989i("PhoneFinderManager", "repeat update deviceId");
        AbstractC12139d.m72776o(context, new b(context));
    }

    /* renamed from: w */
    public final /* synthetic */ void m74310w(boolean z10) {
        m74291E(z10);
        if (z10) {
            return;
        }
        C13981a.m83989i("PhoneFinderManager", "repeat update deviceId");
        AbstractC12139d.m72772k(this.f57136b, new InterfaceC12348a() { // from class: qe.e
            @Override // p576qf.InterfaceC12348a
            public final void onResult(boolean z11) {
                this.f57133a.m74291E(z11);
            }
        });
    }

    /* renamed from: y */
    public void m74311y(Context context, Intent intent) {
        C13981a.m83989i("PhoneFinderManager", "processRemoteControlMessage");
        if (context == null || intent == null) {
            return;
        }
        if (C11853c.m70968g().m70972h(context) && !TextUtils.isEmpty(AbstractC12139d.m72766e(context).getDeviceID())) {
            m74312z();
            C13108a.m78878b(context).m78881d(intent);
        } else {
            if (!C11853c.m70968g().m70971f(context)) {
                C13981a.m83988e("PhoneFinderManager", "processRemoteControlMessage initAccount fail");
                return;
            }
            AbstractC12139d.m72767f(context, true);
            m74312z();
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    /* renamed from: z */
    public final void m74312z() {
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this.f57136b);
        String countryCode = accountInfoM72766e.getCountryCode();
        if (TextUtils.isEmpty(countryCode)) {
            C13981a.m83989i("PhoneFinderManager", "countryCode in TA not exist");
            if (C13452e.m80781L().m80842P0() && !TextUtils.isEmpty(accountInfoM72766e.getUserID4RC()) && accountInfoM72766e.getUserID4RC().equals(C13452e.m80781L().m80971t0())) {
                C13981a.m83989i("PhoneFinderManager", "copy countryCode from AccountSetting");
                countryCode = C13452e.m80781L().m80942m();
            } else {
                countryCode = "1".equals(accountInfoM72766e.getSiteID()) ? "CN" : "";
            }
        }
        if (C1175a.m7389k(C0213f.m1377a())) {
            C13042e.m78685c().m78689d("key_country_code", C11477c.m68636f(countryCode));
        }
    }
}
