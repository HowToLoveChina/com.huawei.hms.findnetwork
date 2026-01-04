package p223db;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.huawei.android.hicloud.exiter.IExitProcessor;
import com.huawei.android.hicloud.p088ui.extend.C3948f;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.BackupBeforeNoticeManager;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import com.huawei.hicloud.notification.manager.DataUpperLimitNoticeManager;
import com.huawei.hicloud.notification.manager.HiCLoudStockActiveManager;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudParamMetaManager;
import com.huawei.hicloud.notification.manager.HiCloudWebViewPolicyManager;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.notification.manager.HomepageSwitchNoticeManager;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.NotifyBlackListManager;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.manager.UnReadNumManager;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.service.C5009e0;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.api.advance.AdvanceNetworkKit;
import com.huawei.openalliance.p169ad.inter.HiAd;
import dj.C9159b;
import gp.C10028c;
import io.C10582a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import je.C10779b0;
import kp.C11126b;
import lb.C11266a;
import mc.C11436a;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0215g;
import p015ak.C0216g0;
import p015ak.C0237v;
import p283fa.C9679b;
import p284fb.C9681b;
import p292fn.C9733f;
import p292fn.C9736i;
import p314gc.C9904a;
import p429kk.C11058a;
import p448l9.C11262a;
import p459lp.C11327e;
import p474m9.C11432a;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p616rk.C12515a;
import p620rp.InterfaceC12614b;
import p657tp.C13053d;
import p657tp.C13055f;
import p664u0.C13108a;
import p674ub.C13152i;
import p681uj.C13195l;
import p681uj.C13196m;
import p681uj.C13198o;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p778xk.C13821b;
import p778xk.C13823d;
import p778xk.C13824e;
import p778xk.C13826g;
import p782xo.C13842a;
import p805yb.C13933c;
import p836z8.C14157f;
import p837z9.C14163d;
import sd.C12778a;
import tm.C13040c;
import tm.C13041d;
import vn.C13469a;

/* renamed from: db.b */
/* loaded from: classes3.dex */
public class C9062b {

    /* renamed from: d */
    public static boolean f45769d = false;

    /* renamed from: e */
    public static boolean f45770e = false;

    /* renamed from: a */
    public ArrayList<IExitProcessor> f45771a;

    /* renamed from: b */
    public List<ExiterSyncData> f45772b;

    /* renamed from: c */
    public boolean f45773c;

    /* renamed from: db.b$b */
    public static class b {

        /* renamed from: a */
        public static C9062b f45774a = new C9062b();
    }

    /* renamed from: db.b$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public String f45775a;

        /* renamed from: b */
        public String f45776b;

        /* renamed from: c */
        public String f45777c;

        /* renamed from: d */
        public boolean f45778d;

        public c(String str, String str2, String str3, boolean z10) {
            this.f45775a = str;
            this.f45776b = str2;
            this.f45777c = str3;
            this.f45778d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C10582a(C11058a.m66627b("07006")).m64947m0(this.f45775a, this.f45776b, this.f45777c, this.f45778d);
        }
    }

    public /* synthetic */ C9062b(a aVar) {
        this();
    }

    /* renamed from: g */
    public static void m57145g(Context context) {
        if (context == null) {
            return;
        }
        File file = new File(context.getFilesDir().getPath() + "/headpic/", "headpic.png");
        if (!file.exists() || file.delete()) {
            return;
        }
        C11839m.m70687e("HiSyncExitManager", "delete file failed");
    }

    /* renamed from: k */
    public static C9062b m57146k() {
        return b.f45774a;
    }

    /* renamed from: m */
    public static boolean m57147m() {
        return f45769d;
    }

    /* renamed from: n */
    public static /* synthetic */ void m57148n(Boolean bool) {
        C11839m.m70688i("HiSyncExitManager", "clear webview cookies:" + bool);
    }

    /* renamed from: s */
    public static void m57149s(boolean z10) {
        f45769d = z10;
    }

    /* renamed from: b */
    public final void m57150b(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.backup.EXITEND");
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: c */
    public final void m57151c() throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        C5009e0.m30044e().m30047b("login out start");
        C9159b.m57575n(false);
        C3948f.m24064g().m24066d();
        m57163t(contextM1377a);
        C13195l.m79272J().m79332s();
        C13196m.m79363o().m79366j();
        C13612b.m81829B().m81888u();
        C13452e.m80781L().m80885a();
        C12515a.m75110o().m75175e(new C12778a(contextM1377a, null), true);
        C10028c.m62182c0().m62343j();
        ScreenListener.m18023c(contextM1377a).m18028g();
        m57145g(contextM1377a);
        ((NotificationManager) contextM1377a.getSystemService("notification")).cancelAll();
        C14163d.m84990g().m85011q(contextM1377a);
        UserKeyUtils.getInstance().clearSyncUser();
        m57153e(contextM1377a);
        C13230i.m79547x();
        C9904a.m61488b().m61489a(contextM1377a);
        C11327e.m68058a();
        HicloudPushGuideManager.getInstance().clear();
        C13041d.m78675e().m78676a();
        HiCloudNotification.getInstance().clearCloudConfigFileAndDB();
        C14157f.m84942g().m84946e();
        C9681b.m60470l().m60486f(contextM1377a);
        C9681b.m60470l().m60485e();
        C13040c.m78609F().m78649h();
        NotificationReportUtil.clearLastDayMillis();
        C9733f.m60705z().m60745h();
        C9733f.m60705z().m60747i();
        C9733f.m60705z().m60749j();
        C13152i.m79070o().m79097g();
        UBAAnalyze.m29942C();
        UBAAnalyze.m29996q();
        HiCloudNotification.getInstance().resetNotifyTime();
        C11266a.m67614b().m67615a();
        C13933c.m83668n().m83673e();
        NotifyBlackListManager.getInstance().clearBackListConfig();
        m57150b(contextM1377a);
        new C11262a().m67600b(contextM1377a);
        C14163d.m84990g().m84994D(contextM1377a);
        C14163d.m84990g().m85001f();
        ForcedUpgradeUtil.getInstance().unregisterReceiver(contextM1377a);
        C11436a.m68492d().m68500j(contextM1377a);
        C9679b.m60452d().m60458h();
        UnReadNumManager.getInstance().refreshLauncherIcon(0);
        C13469a.m81112f().m81116d();
        MessageCenterManager.getInstance().clearAllMessages();
        HiCloudMsgNoticeConfigManager.getInstance().clearAll();
        C13821b.m82867w().m82877d();
        C13826g.m82950l().m82955c();
        C13824e.m82943e().m82944a();
        if (C11829c.m70509D1()) {
            UnReadNumManager.getInstance().refreshLauncherIcon(1);
        }
        C11126b.m66896m().m66900d();
        new C10779b0().m65622a();
        HiCloudParamMetaManager.getInstance().clearAllConfig();
        HiCloudWebViewPolicyManager.getInstance().clearConfigFile();
        CookieManager.getInstance().removeAllCookies(new ValueCallback() { // from class: db.a
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C9062b.m57148n((Boolean) obj);
            }
        });
    }

    /* renamed from: d */
    public void m57152d() {
        C11839m.m70688i("HiSyncExitManager", "clearPersistData");
        if (f45770e) {
            C11839m.m70688i("HiSyncExitManager", "Cleaning is in progress. No repeated cleaning is required.");
            return;
        }
        f45770e = true;
        m57151c();
        ArrayList<IExitProcessor> arrayList = this.f45771a;
        if (arrayList != null && arrayList.size() > 0) {
            C11839m.m70688i("HiSyncExitManager", "clearPersistData, mExitProcessors num: " + this.f45771a.size());
            Iterator<IExitProcessor> it = this.f45771a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                IExitProcessor next = it.next();
                if (next == null) {
                    C11839m.m70687e("HiSyncExitManager", "clearPersistData exitProcessor is null");
                } else {
                    try {
                        next.mo15561a(false);
                        i10++;
                    } catch (Exception e10) {
                        C11839m.m70687e("HiSyncExitManager", "clearPersistData exception: " + e10.toString());
                    }
                }
            }
            C11839m.m70688i("HiSyncExitManager", "clearPersistData, total num: " + this.f45771a.size() + ", success num: " + i10);
        }
        f45770e = false;
    }

    /* renamed from: e */
    public final void m57153e(Context context) {
        C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().clear().commit();
        C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit().clear().commit();
        C0214f0.m1382b(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0).edit().clear().commit();
        C0214f0.m1382b(context, "deviceNameSp", 0).edit().clear().commit();
        C0214f0.m1382b(context, "cloud_photo_cfg", 0).edit().clear().commit();
        C0214f0.m1382b(context, "cloudbackupsms", 0).edit().clear().commit();
        C0214f0.m1382b(context, "cloudbackup", 0).edit().clear().commit();
        C0214f0.m1382b(context, "com.huawei.android.ds_spcace_detail_cache", 0).edit().clear().commit();
        C0214f0.m1382b(context, "show_restore_retry", 0).edit().clear().commit();
        C0214f0.m1382b(context, NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0).edit().clear().commit();
        C0212e0.m1351a(context, "account_bind_box");
        C0212e0.m1351a(context, "more_app_info_sp");
        C0212e0.m1351a(context, "common_config");
        C0212e0.m1351a(context, "syncConfig");
        C0212e0.m1352b(context, FrequencyManager.CHECKBACKUPFAILNOTIFYSP);
        C0212e0.m1352b(context, CloudSpaceNotifyUtil.CHECK_CLOUD_PHOTO_FAIL_NOTIFY_SP);
        SpaceNoticeCommonSpUtil.getInstance().clearAll();
        C10028c.m62182c0().m62338i();
        InterfaceC12614b.get().clearAll();
        C13053d.m78770i().m78762a();
        C13055f.m78779g().m78762a();
        C0212e0.m1353c("reliability_info");
        C0212e0.m1353c("common_account_app");
        C0212e0.m1353c("com.huawei.hidisk.campaign.config_quests");
        C13823d.m82904y().m82920d(context);
        C11432a.m68479d().m68485a();
        C13842a.m83010i().m83027e();
        C13612b.m81829B().m81868i0(context, 0L);
        UserNegFeedbackManager.getInstance(context).clearSp();
        C0216g0.m1402e(context).m1424a();
        C0212e0.m1351a(context, "sp_vip_rights_info");
        C0212e0.m1351a(context, "sp_device_use_info");
        C0212e0.m1351a(context, "sp_have_show_cloud_photo");
        C0237v.m1659a();
        C0212e0.m1351a(context, "checkbox_push_guide_sp");
        C0212e0.m1351a(context, "switch_suggest_dialog_sp");
        C0212e0.m1351a(context, "slientUser");
        C0212e0.m1351a(context, "honor_icon");
        C0212e0.m1351a(context, "hicloud_persona_marketing_sp");
        C0212e0.m1351a(context, "hicloud_user_operation_report_sp");
        C0212e0.m1351a(context, "tempBackupSpFile");
        C0212e0.m1351a(context, "sp_cloud_service_update");
        C0212e0.m1351a(context, "sp_desktop_dialog");
        C0215g.m1384f().m1385a();
        C9736i.m60781c().m60782a();
    }

    /* renamed from: f */
    public final void m57154f() throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        C10028c.m62182c0().m62377p3("is_exit_finish", false);
        C12515a.m75110o().m75183g1();
        if (C11829c.m70530L0() && C11829c.m70538P0()) {
            HiAd.getInstance(contextM1377a.getApplicationContext()).enableUserInfo(false);
        }
        C11836j.m70658k().m70664f();
        UserActiveRecommendManager.getInstance().finishActivity();
        UserActiveRecommendManager.getInstance().clearNotification();
        SpaceNoticeV3Manager.getInstance().clearAllConfigInTask();
        SpaceInsuffNoticeV4Manager.getInstance().clearAllConfigInTask();
        BackupSpaceInsuffNoticeV5Manager.getInstance().clearAllConfigInTask();
        NoticeFreqControlManager.getInstance().clearAllConfigInTask();
        BackupBeforeNoticeManager.getInstance().clearAllConfigInTask();
        DataUpperLimitNoticeManager.getInstance().clearAllConfigInTask();
        HomepageSwitchNoticeManager.getInstance().clearAllConfigInTask();
        HiCloudForceUpgradeConfigManager.getInstance().clearAllConfigInTask();
        m57151c();
        C13612b.m81829B().m81883r0();
    }

    /* renamed from: h */
    public synchronized void m57155h(boolean z10, boolean z11) {
        C11839m.m70688i("HiSyncExitManager", "exitByInterface");
        m57154f();
        ArrayList<IExitProcessor> arrayList = this.f45771a;
        if (arrayList == null || arrayList.size() <= 0) {
            m57156i(z11);
        } else {
            C11839m.m70688i("HiSyncExitManager", "exitByInterface, mExitProcessors num: " + this.f45771a.size());
            Iterator<IExitProcessor> it = this.f45771a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                IExitProcessor next = it.next();
                if (next == null) {
                    C11839m.m70687e("HiSyncExitManager", "exitByInterface exitProcessor is null");
                } else {
                    try {
                        next.mo15563c(z10);
                        i10++;
                    } catch (Exception e10) {
                        C11839m.m70687e("HiSyncExitManager", "exitByInterface exception: " + e10.toString());
                    }
                }
            }
            C11839m.m70688i("HiSyncExitManager", "exitByInterface, total num: " + this.f45771a.size() + ", success num: " + i10);
            m57156i(z11);
        }
    }

    /* renamed from: i */
    public final void m57156i(boolean z10) {
        try {
            NetworkKit.init(C0213f.m1377a(), null);
            AdvanceNetworkKit.getInstance().doAction(AdvanceNetworkKit.ACTION_CLEAN_CONNECTDATA);
        } catch (Exception e10) {
            C11839m.m70687e("HiSyncExitManager", "AdvanceNetworkKit ACTION_CLEAN_CONNECTDATA error: " + e10.getMessage());
        }
        HiCLoudStockActiveManager.getInstance().setProcessExit(false);
        if (z10 || 1 != C13612b.m81829B().m81843F(C0213f.m1377a())) {
            return;
        }
        C11839m.m70688i("HiSyncExitManager", "exit finish, hwid login");
        UserActiveRecommendManager.getInstance().activeCloud("");
    }

    /* renamed from: j */
    public List<ExiterSyncData> m57157j() {
        List<ExiterSyncData> list = this.f45772b;
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: l */
    public boolean m57158l() {
        return this.f45773c;
    }

    /* renamed from: o */
    public final void m57159o() {
    }

    /* renamed from: p */
    public void m57160p() {
        C11839m.m70688i("HiSyncExitManager", "onEncryptModeChange");
        m57159o();
        ArrayList<IExitProcessor> arrayList = this.f45771a;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("HiSyncExitManager", "onEncryptModeChange, mExitProcessors num: " + this.f45771a.size());
        Iterator<IExitProcessor> it = this.f45771a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            IExitProcessor next = it.next();
            if (next == null) {
                C11839m.m70687e("HiSyncExitManager", "onEncryptModeChange exitProcessor is null");
            } else {
                try {
                    next.mo15562b();
                    i10++;
                } catch (Exception e10) {
                    C11839m.m70687e("HiSyncExitManager", "onEncryptModeChange exception: " + e10.toString());
                }
            }
        }
        C11839m.m70688i("HiSyncExitManager", "clearPersistData, total num: " + this.f45771a.size() + ", success num: " + i10);
    }

    /* renamed from: q */
    public void m57161q(IExitProcessor iExitProcessor) {
        ArrayList<IExitProcessor> arrayList = this.f45771a;
        if (arrayList == null || arrayList.contains(iExitProcessor)) {
            return;
        }
        this.f45771a.add(iExitProcessor);
    }

    /* renamed from: r */
    public void m57162r(boolean z10, List<ExiterSyncData> list) {
        this.f45773c = z10;
        if (list == null) {
            this.f45772b = new ArrayList();
        } else {
            this.f45772b = list;
        }
    }

    /* renamed from: t */
    public void m57163t(Context context) {
        C11839m.m70686d("HiSyncExitManager", "unRegisterDeviceToken");
        C13452e c13452eM80781L = C13452e.m80781L();
        if (C13612b.m81829B().m81843F(context) == 1) {
            m57164u(c13452eM80781L.m80970t(), c13452eM80781L.m80954p(), c13452eM80781L.m80931j0(), C10028c.m62182c0().m62221H1());
        }
        if (TextUtils.isEmpty(C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).getString("HiSyncAccountpushToken", null))) {
            return;
        }
        C13198o.m79385c().m79386b(context);
    }

    /* renamed from: u */
    public final void m57164u(String str, String str2, String str3, boolean z10) {
        Executors.newSingleThreadExecutor().execute(new c(str, str2, str3, z10));
    }

    public C9062b() {
        this.f45771a = new ArrayList<>();
        this.f45772b = new ArrayList();
        this.f45773c = false;
    }
}
