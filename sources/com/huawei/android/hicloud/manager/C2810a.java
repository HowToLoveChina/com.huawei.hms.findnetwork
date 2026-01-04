package com.huawei.android.hicloud.manager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Build;
import android.os.Process;
import ck.C1443a;
import ck.C1445c;
import com.huawei.android.hicloud.common.R$string;
import com.huawei.android.hicloud.common.receiver.UserInfoChangeReceiver;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.manager.IconManager;
import com.huawei.android.hicloud.p088ui.StockActivePopupGuideActivity;
import com.huawei.android.hicloud.p088ui.UpgradeEmptyActivity;
import com.huawei.android.hicloud.p088ui.activity.ForcedUpgradeActivity;
import com.huawei.android.os.BuildEx;
import com.huawei.cloud.banner.manager.FrontAppDownloadManager;
import com.huawei.feedback.FeedbackHelper;
import com.huawei.feedback.log.AppLogManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hicloud.account.util.ATTrafficController;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.checker.LevelFrequencyController;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.manager.UnReadNumManager;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotificationParams;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import dj.C9159b;
import dk.C9163d;
import gp.C10028c;
import hk.C10278a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10792i;
import lc.C11268b;
import mc.C11436a;
import mn.C11500d;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0211e;
import p015ak.C0212e0;
import p015ak.C0214f0;
import p015ak.C0236u;
import p015ak.C0239x;
import p015ak.C0240y;
import p015ak.C0241z;
import p020ap.C1006a;
import p020ap.C1007b;
import p052cb.C1405b;
import p052cb.C1411h;
import p258ei.C9494c;
import p280f7.C9663a;
import p284fb.C9681b;
import p292fn.C9728a;
import p292fn.C9729b;
import p311g7.C9888a;
import p335hd.C10140c;
import p335hd.C10141d;
import p335hd.C10148k;
import p336he.C10155f;
import p389j9.C10735a;
import p389j9.C10736b;
import p389j9.C10737c;
import p389j9.C10738d;
import p389j9.C10739e;
import p389j9.C10740f;
import p389j9.C10741g;
import p389j9.C10742h;
import p389j9.C10743i;
import p389j9.C10744j;
import p389j9.C10745k;
import p389j9.C10746l;
import p399jk.AbstractC10896a;
import p431ko.C11080f;
import p459lp.C11327e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12305e;
import p572qb.C12306e0;
import p572qb.C12311h;
import p572qb.C12314i0;
import p572qb.C12315j;
import p572qb.C12332x;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13185b;
import p683um.C13221b;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p745wm.C13620a;
import p766x8.C13731j;
import p783xp.C13843a;
import p837z9.C14163d;
import p846zj.C14303a;
import tj.C13019a;
import tm.C13040c;
import vn.C13472d;

/* renamed from: com.huawei.android.hicloud.manager.a */
/* loaded from: classes3.dex */
public class C2810a {

    /* renamed from: b */
    public static final C2810a f12272b = new C2810a();

    /* renamed from: a */
    public Context f12273a;

    /* renamed from: com.huawei.android.hicloud.manager.a$a */
    public static class a extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11829c.m70527K();
        }
    }

    /* renamed from: m */
    public static C2810a m16477m() {
        return f12272b;
    }

    /* renamed from: A */
    public final void m16478A() {
        Context context = this.f12273a;
        int i10 = R$string.privacy_dialog_location_content;
        C9163d.m57585b("android.permission.ACCESS_COARSE_LOCATION", context.getString(i10));
        C9163d.m57585b("android.permission.ACCESS_FINE_LOCATION", this.f12273a.getString(i10));
        Context context2 = this.f12273a;
        int i11 = R$string.privacy_dialog_phone_content;
        C9163d.m57585b("android.permission.READ_PHONE_NUMBERS", context2.getString(i11));
        C9163d.m57585b("android.permission.READ_PHONE_STATE", this.f12273a.getString(i11));
        C9163d.m57585b("android.permission.CAMERA", this.f12273a.getString(R$string.camera_permissions));
        if (Build.VERSION.SDK_INT >= 34) {
            C9163d.m57585b("android.permission.MANAGE_DEVICE_POLICY_MICROPHONE", this.f12273a.getString(R$string.access_microphone_permission_explain_new));
        }
        Context context3 = this.f12273a;
        int i12 = R$string.privacy_dialog_storage_content;
        C9163d.m57585b("android.permission.READ_EXTERNAL_STORAGE", context3.getString(i12));
        C9163d.m57585b("android.permission.WRITE_EXTERNAL_STORAGE", this.f12273a.getString(i12));
        Context context4 = this.f12273a;
        int i13 = R$string.privacy_dialog_contacts_content;
        C9163d.m57585b("android.permission.READ_CONTACTS", context4.getString(i13));
        C9163d.m57585b("android.permission.WRITE_CONTACTS", this.f12273a.getString(i13));
        C9163d.m57585b("android.permission.CALL_PHONE", this.f12273a.getString(R$string.call_phone_permission_explain));
        C9163d.m57585b("android.permission.READ_SMS", this.f12273a.getString(R$string.privacy_dialog_sms_content));
        Context context5 = this.f12273a;
        int i14 = R$string.privacy_dialog_call_log_content;
        C9163d.m57585b("android.permission.READ_CALL_LOG", context5.getString(i14));
        C9163d.m57585b("android.permission.WRITE_CALL_LOG", this.f12273a.getString(i14));
        Context context6 = this.f12273a;
        int i15 = R$string.privacy_dialog_calendar_content;
        C9163d.m57585b("android.permission.READ_CALENDAR", context6.getString(i15));
        C9163d.m57585b("android.permission.WRITE_CALENDAR", this.f12273a.getString(i15));
        C9163d.m57585b("com.android.permission.GET_INSTALLED_APPS", this.f12273a.getString(R$string.privacy_dialog_application_content));
        C9163d.m57585b("R.string.some_permission_instruction", this.f12273a.getString(R$string.some_permission_instruction));
    }

    /* renamed from: B */
    public final void m16479B() {
        m16507t();
        C1007b.m5980s().m5986F();
    }

    /* renamed from: D */
    public final void m16481D() {
        C11839m.m70688i("CommonDriveManager", "init processGetPushToken");
        if (C10028c.m62182c0().m62221H1()) {
            C13612b.m81829B().m81844G(this.f12273a, m16500l());
        }
    }

    /* renamed from: E */
    public final void m16482E() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f12273a, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("CommonDriveManager", "processSyncStatus, SharedPreferences is null");
            return;
        }
        String[] strArr = {"addressbooksync_retcode", "wlansync_retcode", "calendarsync_retcode", "notepadsync_retcode", "browsersync_retcode"};
        for (int i10 = 0; i10 < 5; i10++) {
            String str = strArr[i10];
            if (4 == sharedPreferencesM1382b.getInt(str, -1)) {
                sharedPreferencesM1382b.edit().putInt(str, -1).commit();
            }
        }
        for (String str2 : new SyncConfigOperator().getAllServicesId()) {
            if (4 == sharedPreferencesM1382b.getInt(str2 + "sync_retcode", -1)) {
                sharedPreferencesM1382b.edit().putInt(str2 + "sync_retcode", -1).commit();
            }
        }
    }

    /* renamed from: F */
    public final void m16483F() {
        if (C13612b.m81829B().isLogin()) {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            if (!c10028cM62182c0.m62403v("support_push_notify_control", false) && (C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12)) {
                c10028cM62182c0.m62336h2("support_push_notify_control", true);
                C12515a.m75110o().m75172d(new C10141d(this.f12273a.getApplicationContext(), true));
                C13223b.m79484l(this.f12273a, 1, 0);
            }
            if ((C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12) && !c10028cM62182c0.m62388s("push_receive_status")) {
                C13223b.m79484l(this.f12273a, 1, 0);
                C12515a.m75110o().m75172d(new C10141d(this.f12273a.getApplicationContext(), true));
            }
        }
    }

    /* renamed from: G */
    public final void m16484G() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f12273a, "deviceNameSp", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("CommonDriveManager", "processUploadStatus, SharedPreferences is null");
            return;
        }
        String[] strArr = {"autosmslistkey_retcode", "autocallloglistkey_retcode", "autorecordingkey_retcode", "autophonemanagerkey_retcode"};
        for (int i10 = 0; i10 < 4; i10++) {
            String str = strArr[i10];
            if (4 == sharedPreferencesM1382b.getInt(str, -10)) {
                sharedPreferencesM1382b.edit().putInt(str, -1).commit();
            }
        }
    }

    /* renamed from: H */
    public final void m16485H() {
        C11839m.m70688i("CommonDriveManager", "refreshSnsNum");
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        if (C0209d.m1202Q0()) {
            if (zM62221H1) {
                UnReadNumManager.getInstance().executeSnsNumTask();
                return;
            } else if (C11829c.m70509D1()) {
                UnReadNumManager.getInstance().refreshLauncherIcon(1);
                return;
            } else {
                UnReadNumManager.getInstance().refreshLauncherIcon(0);
                return;
            }
        }
        if (!C11829c.m70517G0()) {
            C11839m.m70688i("CommonDriveManager", "refreshSnsNum isOverseasRedPointNeedShow false");
            UnReadNumManager.getInstance().refreshLauncherIcon(0);
            return;
        }
        C11839m.m70688i("CommonDriveManager", "refreshSnsNum isOverseasRedPointNeedShow");
        UnReadNumManager.getInstance().refreshLauncherIcon(1);
        C14303a.m85185a().m85195k();
        C14303a.m85185a().m85199o();
        C14303a.m85185a().m85194j(true);
    }

    /* renamed from: I */
    public final void m16486I() {
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.contact", new C10741g(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.backup", new C10738d(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.cloudAlbum", new C10735a(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.browser", new C10737c(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.calendar", new C10739e(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.notepad", new C10743i(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.wlan", new C10746l(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.atlas", new C10736b(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.syncmodule", new C10740f(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.initparam", new C10742h(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.phonefinder", new C10744j(2));
        ATTrafficController.m29104b().m29110g("com.huawei.hidisk.foldersync", new C10745k(2));
    }

    /* renamed from: J */
    public final void m16487J(Context context) {
        if (context == null) {
            C11839m.m70687e("CommonDriveManager", "registerUserInfoChangeReceiver context null");
            return;
        }
        C11839m.m70686d("CommonDriveManager", "Register UserInfoChangeReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hwid.ACTION_HEAD_PIC_CHANGE");
        intentFilter.addAction("com.huawei.hwid.ACTION_ACCOUNTNAME_CHANGE");
        context.registerReceiver(new UserInfoChangeReceiver(), intentFilter, "com.huawei.hicloud.permission.hicloudLogin", null);
    }

    /* renamed from: K */
    public final void m16488K() {
        C11839m.m70688i("CommonDriveManager", "reportDeviceUseInfo");
        C12306e0.m73994c().m73995b();
    }

    /* renamed from: L */
    public final void m16489L(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        context.getSharedPreferences("toHwDriveTab", 0).edit().putBoolean("goToNetTab", true).commit();
        new HwAnimationReflection(context).m15927c(1);
    }

    /* renamed from: b */
    public final void m16490b() {
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("urls_sp_version");
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        boolean zM62395t12 = C10028c.m62182c0().m62395t1("is_already_configed_NV4");
        if (!zM62395t1 && zM80842P0 && zM62395t12) {
            C11839m.m70688i("CommonDriveManager", "refresh urls sp file, start check grs task");
            C12515a.m75110o().m75172d(new C10140c(null, true));
        }
    }

    /* renamed from: c */
    public final void m16491c() {
        C12515a.m75110o().m75175e(new C10148k(this.f12273a, "init"), true);
    }

    /* renamed from: d */
    public final void m16492d() {
        List<NotificationChannel> notificationChannels;
        Context context = this.f12273a;
        if (context != null) {
            C10028c c10028cM62183d0 = C10028c.m62183d0(context);
            if (c10028cM62183d0.m62395t1("cleared_channel_ids")) {
                return;
            }
            try {
                NotificationManager notificationManager = (NotificationManager) this.f12273a.getSystemService("notification");
                if (notificationManager != null && (notificationChannels = notificationManager.getNotificationChannels()) != null && !notificationChannels.isEmpty()) {
                    Iterator<NotificationChannel> it = notificationChannels.iterator();
                    while (it.hasNext()) {
                        notificationManager.deleteNotificationChannel(it.next().getId());
                    }
                }
            } catch (Exception e10) {
                C11839m.m70687e("CommonDriveManager", "get/delete notification channel failed. exception: " + e10.toString());
            }
            c10028cM62183d0.m62377p3("cleared_channel_ids", true);
        }
    }

    /* renamed from: e */
    public final void m16493e() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62324f0("has_clear_more_data_flag") || !c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
            return;
        }
        c10028cM62182c0.m62358m();
        c10028cM62182c0.m62281U2("has_clear_more_data_flag", true);
        C11839m.m70688i("CommonDriveManager", "has_clear_more_data_flag  result true");
    }

    /* renamed from: f */
    public final void m16494f(Context context) {
        try {
            C13452e c13452eM80781L = C13452e.m80781L();
            if (c13452eM80781L.m80927i1() && !c13452eM80781L.m80783A0() && C13843a.m83078b0(context, "com.huawei.contacts.sync") && "9.2.0.308".equals(C0240y.m1681c(context, "com.huawei.contacts.sync"))) {
                C11839m.m70688i("CommonDriveManager", "Clear old version sync risk flag.");
                c13452eM80781L.m80929i3("");
                c13452eM80781L.m80894b3(true);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CommonDriveManager", "clearOldSyncRiskFlag error: " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public final void m16495g() {
        C13452e c13452eM80781L = C13452e.m80781L();
        if (c13452eM80781L.m80787B0()) {
            return;
        }
        C11839m.m70688i("CommonDriveManager", "Clear old version ST invalid by server flag");
        c13452eM80781L.m80899c3(true);
        c13452eM80781L.m80919g3(false);
    }

    /* renamed from: h */
    public final void m16496h() {
        C11839m.m70688i("CommonDriveManager", "deviceUseInfoReport");
        C12305e.m73982f().m73986e();
    }

    /* renamed from: i */
    public final void m16497i() throws SQLException {
        if (this.f12273a == null) {
            return;
        }
        C11839m.m70687e("CommonDriveManager", "commonDbCompat");
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        if (C0212e0.m1355e(this.f12273a, "notify_db_to_common", "is_db_to_common_v1", false)) {
            return;
        }
        C11839m.m70687e("CommonDriveManager", "need insert data to common db");
        if (zM62221H1) {
            C11839m.m70687e("CommonDriveManager", "clear config");
            C11327e.m68059b("HiCloudStaticPage");
            C9681b.m60470l().m60486f(this.f12273a);
            HiCloudNotification.getInstance().clearCloudConfigFileAndDB();
        }
        C0212e0.m1366p(this.f12273a, "notify_db_to_common", "is_db_to_common_v1", true);
        C11839m.m70688i("CommonDriveManager", "commonDbCompat isLogin=" + C13452e.m80781L().m80842P0());
    }

    /* renamed from: j */
    public final void m16498j() {
        m16484G();
        m16482E();
    }

    /* renamed from: k */
    public final void m16499k() {
        C13452e c13452eM80781L = C13452e.m80781L();
        if (c13452eM80781L.m80866V0()) {
            boolean zM80922h1 = c13452eM80781L.m80922h1();
            boolean zM80917g1 = c13452eM80781L.m80917g1();
            if (zM80922h1) {
                C11839m.m70688i("CommonDriveManager", "Clear old ST invalid flag");
                c13452eM80781L.m80924h3(false);
            }
            if ((zM80917g1 || zM80922h1) && C10155f.m63259L(this.f12273a)) {
                C13612b.m81829B().m81874n();
                c13452eM80781L.m80904d3(System.currentTimeMillis());
            }
        }
    }

    /* renamed from: l */
    public final long m16500l() {
        long jM1260h0 = C0209d.m1260h0(0, DisconnectNotificationParams.DEFAULT_NORMAL_ADV_DURATION) * 1000;
        C11839m.m70688i("CommonDriveManager", "getDelayRandomTime:" + jM1260h0);
        return jM1260h0;
    }

    /* renamed from: n */
    public int m16501n(final Context context, final int i10, final String str) {
        if (context == null) {
            C11839m.m70687e("CommonDriveManager", "context is null");
            return -1;
        }
        if (context.getPackageManager() == null) {
            C11839m.m70687e("CommonDriveManager", "gotoHwCloudDrive package manager is null");
            return -1;
        }
        IconManager iconManager = new IconManager(context);
        if (!iconManager.m16463w(iconManager.m16456p())) {
            C13227f.m79492i1().m79567R("mecloud_filemanager_icon_is_not_exist", new LinkedHashMap<>());
            UBAAnalyze.m29943D("CKC", "mecloud_filemanager_icon_is_not_exist");
            if (iconManager.m16434A("filemanagerLastTime")) {
                iconManager.m16450R(new IconManager.CallBack() { // from class: qb.f
                    @Override // com.huawei.android.hicloud.manager.IconManager.CallBack
                    /* renamed from: a */
                    public final void mo16466a() {
                        this.f57011a.m16480C(context, i10, str);
                    }
                });
                return 0;
            }
        }
        return m16480C(context, i10, str);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final int m16480C(Context context, int i10, String str) {
        return !C0209d.m1269j1() ? m16504q(context, i10, str) : m16503p(context, i10, str);
    }

    /* renamed from: p */
    public final int m16503p(Context context, int i10, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i11;
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_HONOR");
        C0209d.m1302r2(intent, "com.hihonor.filemanager");
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.resolveActivity(context.getPackageManager()) == null) {
            return m16504q(context, i10, str);
        }
        C11839m.m70688i("CommonDriveManager", "gotoCloudDrive4Honor , resolveActivity is not null");
        try {
            context.startActivity(hiCloudSafeIntent);
            i11 = 0;
        } catch (Exception e10) {
            C11839m.m70687e("CommonDriveManager", "gotoCloudDrive4Honor startactivity error:" + e10.toString());
            i11 = -1;
        }
        m16489L(context);
        return i11;
    }

    /* renamed from: q */
    public final int m16504q(Context context, int i10, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_COMPATIBLE_NEW");
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        intent.putExtra("fromWhere", "hidisk");
        C9159b.m57571j(intent);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        int i11 = -1;
        if (hiCloudSafeIntent.resolveActivity(context.getPackageManager()) != null) {
            C11839m.m70688i("CommonDriveManager", "resolveActivity is not null");
            try {
                hiCloudSafeIntent.putExtra("from_to", i10);
                hiCloudSafeIntent.putExtra("params", str);
                hiCloudSafeIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                context.startActivity(hiCloudSafeIntent);
                i11 = 0;
            } catch (Exception e10) {
                C11839m.m70687e("CommonDriveManager", "gotoHwCloudDrive startactivity error:" + e10.toString());
            }
            m16489L(context);
        } else {
            C11839m.m70688i("CommonDriveManager", "resolveActivity is null,goto old");
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.VIEW");
            C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            HiCloudSafeIntent hiCloudSafeIntent2 = new HiCloudSafeIntent(intent2);
            if (hiCloudSafeIntent2.resolveActivity(context.getPackageManager()) != null) {
                hiCloudSafeIntent2.setComponent(new ComponentName(NextRestoreConstants.PKG_NAME_FILE_MANAGER, "com.huawei.hidisk.filemanager.FileManager"));
                hiCloudSafeIntent2.putExtra("HiCloud_toHwDriveTab", 2);
                hiCloudSafeIntent2.putExtra("from_to", i10);
                hiCloudSafeIntent2.putExtra("params", str);
                hiCloudSafeIntent2.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                try {
                    context.startActivity(hiCloudSafeIntent2);
                    i11 = 0;
                } catch (Exception e11) {
                    AbstractC10896a.m65886e("CommonDriveManager", "startActivity failed" + e11.toString());
                }
                m16489L(context);
            } else {
                C11839m.m70687e("CommonDriveManager", "FileManager not Install");
            }
        }
        return i11;
    }

    /* renamed from: r */
    public void m16505r(Context context) throws JSONException, IOException, SQLException {
        this.f12273a = context;
        m16510w();
        m16511x();
    }

    /* renamed from: s */
    public final void m16506s() throws JSONException, SQLException {
        C13185b.m79233a().m79235c(C9728a.m60681f());
        C0211e.m1344c().m1349f(C10792i.m65668d());
        UBAAnalyze.m29942C();
        m16486I();
        C10278a.m63450p(C10278a.m63435a(this.f12273a, "com.huawei.libcore.io.ExternalStorageRandomAccessFile") && !C0209d.m1179I1());
        C13612b.m81829B().m81872l0(new C9888a());
        m16479B();
        C10155f.m63276b(this.f12273a);
        C0239x.m1671c().m1678h(String.valueOf(Process.myPid()));
        C11842p.m70723E0(this.f12273a);
        C13452e.m80781L().m80952o1(C13612b.m81829B());
        C13452e.m80781L().m80956p1(C13472d.m81137f());
        C12515a.m75110o().m75172d(new C13620a());
        C1006a.m5936k().m5955a();
        m16481D();
        m16483F();
        if (C1443a.f6214b.booleanValue()) {
            HiAnalyticTools.enableLog(this.f12273a);
        }
        m16513z(this.f12273a);
        m16499k();
        m16495g();
        m16494f(this.f12273a);
        m16498j();
        m16490b();
        m16508u();
        m16493e();
        m16492d();
        C11268b.m67619i().m67620e();
        m16497i();
        int iM1260h0 = C0209d.m1260h0(1, Constants.MILLON);
        C11839m.m70688i("CommonDriveManager", "proportionRandomInt: " + iM1260h0);
        C0236u.m1657h((long) iM1260h0);
        C12314i0.m74036h().activeCloud("");
        UserActiveRecommendManager.getInstance().setActiveInvoker(C12314i0.m74036h());
        UserActiveRecommendManager.getInstance().recommend();
        RecommendCardManager.getInstance().initLocalBroadCast();
        m16485H();
        m16496h();
        m16488K();
        C13452e.m80781L().m80991y0();
        LevelFrequencyController.getInstance().initChecker();
        C9729b.m60694a().m60695b();
        C12311h.m74013c().m74017e();
        m16478A();
        C13221b.m79458e();
    }

    /* renamed from: t */
    public void m16507t() {
        Map<String, String> forcedUpgradeMapping = NotifyConstants.getForcedUpgradeMapping();
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, UpgradeEmptyActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, ForcedUpgradeActivity.class.getName());
        forcedUpgradeMapping.put(NotifyConstants.ActivityName.STOCK_ACTIVE_POPUP_GUIDE_ACTIVITY, StockActivePopupGuideActivity.class.getName());
    }

    /* renamed from: u */
    public final void m16508u() throws SQLException {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f12273a);
        boolean zM62221H1 = c10028cM62183d0.m62221H1();
        boolean zM62395t1 = c10028cM62183d0.m62395t1("is_already_configed_NV4");
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        C11839m.m70688i("CommonDriveManager", "isAgreedHiCloudTerms: " + zM62221H1 + ",isHiCloudLogin =" + zM80842P0);
        m16497i();
        HiCloudAllOMConfigManager.getInstance().checkConfigUpdate(this.f12273a, zM62221H1, zM80842P0);
        if (zM62395t1) {
            C11839m.m70688i("CommonDriveManager", "initGlobalModuleSetting updateConfig.");
            FeedbackHelper.setFeedbackType(c10028cM62183d0.m62262Q());
            HiCloudAllOMConfigManager.getInstance().updateConfig(this.f12273a, zM62221H1, zM80842P0);
        } else {
            C11839m.m70688i("CommonDriveManager", "initGlobalModuleSetting isConfigTag.");
            if (zM62221H1 && zM80842P0) {
                C11500d.m68648g().m68662o(this.f12273a);
            }
            C11327e.m68059b("HiCloudNoticeConfigAllInOne");
            HNUtil.getNotificationSP().edit().putBoolean(HNConstants.C4907SP.IS_UPDATE, true).commit();
        }
        if (zM62221H1 && zM80842P0) {
            if (c10028cM62183d0.m62219H() == 4) {
                C14163d.m84990g().m85015u(this.f12273a);
                C14163d.m84990g().m85016v(this.f12273a);
            } else if (c10028cM62183d0.m62219H() == 3) {
                C14163d.m84990g().m85014t();
            }
            C11500d.m68648g().m68661n(this.f12273a);
        }
        int iM1685c = C0241z.m1685c(C1443a.f6213a);
        if (c10028cM62183d0.m62279U0() > iM1685c || !c10028cM62183d0.m62226I1()) {
            return;
        }
        C11839m.m70688i("CommonDriveManager", "forced upgrade complete, currentVersion: " + iM1685c + " , upgradeVersion: " + c10028cM62183d0.m62279U0());
        c10028cM62183d0.m62231J2("forcedUpdate", 0);
        c10028cM62183d0.m62231J2("endService", 0);
        c10028cM62183d0.m62235K2("upgrade_version_code", 0);
        c10028cM62183d0.m62235K2("cancel_version_code", 0);
        c10028cM62183d0.m62197C2("upgrade_last_notice_time", 0L);
        c10028cM62183d0.m62362m3("notice_times", 0);
        c10028cM62183d0.m62362m3("popup_times", 0);
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("success_time", String.valueOf(1));
        C13227f.m79492i1().m79567R("upgrade_success_time", linkedHashMapM79499C);
        UBAAnalyze.m29945F("CKC", "upgrade_success_time", "success_time", String.valueOf(1));
    }

    /* renamed from: v */
    public final void m16509v(Context context) {
        boolean z10 = C13452e.m80781L().m80842P0() && C10028c.m62183d0(context).m62221H1();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z10) {
            C13040c.m78609F().m78652i0(context, C13452e.m80781L().m80942m(), false);
            C0212e0.m1370t(context, "hianlytics_url", "init_time", jCurrentTimeMillis);
        } else {
            C11829c.m70578g0(context);
        }
        if (z10) {
            C13227f.m79492i1().m79560L(context, C13452e.m80781L().m80971t0());
            DnsKprUtil.m29896e(context);
        }
    }

    /* renamed from: w */
    public final void m16510w() throws IOException {
        C13019a.m78347n().m78352o(this.f12273a);
        C1411h.m8144b(this.f12273a);
        C1405b.m8109e().m8112d(this.f12273a);
        AppLogManager.getInstance().init(this.f12273a);
        C1445c.m8323c(this.f12273a);
        C12315j.m74059f().m74063g();
        m16509v(this.f12273a);
        C13452e.m80781L().m80872W2();
        m16512y(this.f12273a);
    }

    /* renamed from: x */
    public final void m16511x() throws JSONException, SQLException {
        if (!C0209d.m1309t1(this.f12273a)) {
            C11839m.m70688i("CommonDriveManager", "not main process");
            return;
        }
        C11839m.m70688i("CommonDriveManager", "initInMainProcess");
        m16506s();
        m16491c();
        C12515a.m75110o().m75175e(new C11080f(), true);
        C11839m.m70688i("CommonDriveManager", "initInMainProcess end");
    }

    /* renamed from: y */
    public final void m16512y(Context context) {
        if (C10028c.m62183d0(context).m62221H1()) {
            C12515a.m75110o().m75172d(new a());
        }
    }

    /* renamed from: z */
    public final void m16513z(Context context) {
        C11839m.m70688i("CommonDriveManager", "initReceiver");
        C13612b.m81829B().m81849M(context);
        C9663a.m60338a().m60339b(context);
        m16487J(context);
        ForcedUpgradeUtil.getInstance().initReceiver(context);
        C13731j.m82512b();
        C11436a.m68492d().m68497f(context);
        UBAAnalyze.m30004x().m30007j0();
        UBAAnalyze.m30004x().m30008m0();
        C9494c.m59390r().m59397J();
        C12332x.m74156a().m74157b();
        FrontAppDownloadManager.m28137j().m28145l();
    }
}
