package com.huawei.android.hicloud.common.account;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.AccountLogoutActivity;
import com.huawei.android.hicloud.p088ui.activity.DataMigrateDialogActivity;
import com.huawei.android.hicloud.p088ui.activity.GalleryLoginActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import mc.C11437b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p020ap.C1008c;
import p020ap.C1010e;
import p037bp.C1270a;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9285d;
import p335hd.C10148k;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p674ub.C13152i;
import p684un.C13223b;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p837z9.C14163d;

/* loaded from: classes3.dex */
public class AccountBroadcastManager {

    /* renamed from: b */
    public static final AccountBroadcastManager f11914b = new AccountBroadcastManager();

    /* renamed from: a */
    public AccountReceiver f11915a;

    public class AccountReceiver extends BroadcastReceiver {
        public AccountReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("com.huawei.hidisk.HANDLE_AIDL_LOGIN_RESULT".equals(action)) {
                AccountBroadcastManager.this.m15556v();
                return;
            }
            if ("com.huawei.hicloud.intent.action.RE_LOGIN_TO_GALLERY".equals(action)) {
                AccountBroadcastManager.this.m15540D();
                return;
            }
            if ("com.huawei.hicloud.intent.action.RE_LOGIN_TO_SYNC".equals(action)) {
                AccountBroadcastManager.this.m15541E();
                return;
            }
            if ("com.huawei.hicloud.action.VALIDATE_HWID_REPORT".equals(action)) {
                AccountBroadcastManager.this.m15546J();
                return;
            }
            if ("com.huawei.hicloud.action.PRIVACY_SPACE_TO_EXIT".equals(action)) {
                AccountBroadcastManager.this.m15544H();
                return;
            }
            if ("com.huawei.hicloud.action.PROCESS_AUTH_FAILED".equals(action)) {
                AccountBroadcastManager.this.m15557w();
                return;
            }
            if ("com.huawei.hicloud.action.PROCESS_SYNC_RISK".equals(action)) {
                AccountBroadcastManager.this.m15545I();
                return;
            }
            if ("com.huawei.hicloud.action.ON_LOGIN".equals(action)) {
                AccountBroadcastManager.this.m15537A(safeIntent);
                return;
            }
            if ("com.huawei.hicloud.action.NOTIFY_MIGRATION".equals(action)) {
                AccountBroadcastManager.this.m15560z();
                return;
            }
            if ("com.huawei.hicloud.action.SITE_NOT_MATCH".equals(action)) {
                AccountBroadcastManager.this.m15543G();
            } else if ("com.huawei.hicloud.action.PROCESS_FORCE_UPGRADE".equals(action)) {
                AccountBroadcastManager.this.m15558x();
            } else {
                AccountBroadcastManager.this.m15538B(action, safeIntent);
            }
        }
    }

    public static class ShowSyncRiskTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f11917a;

        public ShowSyncRiskTask(Context context) {
            this.f11917a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            C2987p.m17953c(this.f11917a);
        }
    }

    /* renamed from: m */
    public static AccountBroadcastManager m15536m() {
        return f11914b;
    }

    /* renamed from: A */
    public final void m15537A(SafeIntent safeIntent) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        C10343b c10343b = new C10343b(safeIntent.getExtras());
        C1010e.m6125b().m6126A(C0213f.m1377a());
        UserKeyUtils.getInstance().clearSyncUser();
        if (m15553s(contextM1377a)) {
            C11839m.m70688i("AccountBroadcastManager", "need register push");
            C13612b.m81829B().m81870k0(contextM1377a.getApplicationContext());
        }
        C1010e.m6125b().m6158x(c10343b.m63694p(JsbMapKeyNames.H5_USER_ID), contextM1377a, c10343b.m63683e());
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("AccountBroadcastManager", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58448p0(contextM1377a, c10343b.m63683e());
            C12515a.m75110o().m75175e(new C10148k(C0213f.m1377a(), "login"), true);
        }
        C1008c.m6035v().m6070e(C0213f.m1377a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    /* renamed from: B */
    public final void m15538B(String str, SafeIntent safeIntent) {
        if ("com.huawei.hicloud.actoin.NOTIFY_ACCOUNT_INFO".equals(str)) {
            m15559y();
            return;
        }
        if ("com.huawei.hicloud.actoin.ACTION_SHOW_MIGRATION".equals(str)) {
            m15542F();
            return;
        }
        if ("com.huawei.hicloud.actoin.ACTION_ACCOUNT_INCONSISTENT_EXIT_APP".equals(str)) {
            m15555u();
            return;
        }
        if ("com.huawei.hicloud.actoin.PUSH_TOKEN_SUCCESS".equals(str)) {
            m15539C(safeIntent.getStringExtra("push_token"));
            return;
        }
        if ("om.huawei.hicloud.actoin.URGENCY_NOTICE".equals(str)) {
            C13152i.m79070o().m79091a(safeIntent.getStringExtra("push_token"), "SCallback");
            return;
        }
        if (!"com.huawei.hicloud.actoin.ACTION_SEND_BACKUP_CYCLE_NOTIFY".equals(str)) {
            if ("com.huawei.hicloud.actoin.OPEN_PUSH_SUCCESS".equals(str)) {
                C11839m.m70688i("AccountBroadcastManager", "receive open push success local broadcast");
                C10028c.m62182c0().m62336h2("push_receive_status", true);
                return;
            } else {
                if ("com.huawei.hicloud.actoin.ACTION_ACCOUNT_INCONSISTENT_CLEAR_DATA".equals(str)) {
                    C9062b.m57146k().m57152d();
                    return;
                }
                return;
            }
        }
        int intExtra = safeIntent.getIntExtra("un_backup_weeks", 0);
        boolean booleanExtra = safeIntent.getBooleanExtra("is_show_local", false);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList = (List) safeIntent.getSerializableExtra("user_tags_key");
        } catch (Exception e10) {
            C11839m.m70688i("AccountBroadcastManager", "processOtherAction get userTags error " + e10.getMessage());
        }
        new BackupNotificationManager(C0213f.m1377a()).sendCycleNotification(intExtra, booleanExtra, arrayList);
    }

    /* renamed from: C */
    public final void m15539C(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("AccountBroadcastManager", "processPushTokenSuccess context is null");
            return;
        }
        C11839m.m70688i("AccountBroadcastManager", "onNewToken");
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d == null || TextUtils.isEmpty(str)) {
            return;
        }
        interfaceC9285d.mo17174g(contextM1377a, str, false);
    }

    /* renamed from: D */
    public final void m15540D() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("AccountBroadcastManager", "processReloginToGallery context is null");
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) GalleryLoginActivity.class);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        contextM1377a.startActivity(intent);
    }

    /* renamed from: E */
    public final void m15541E() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("AccountBroadcastManager", "processReloginToGallery context is null");
            return;
        }
        C11839m.m70688i("AccountBroadcastManager", "sync risk effective, go to SyncRiskManagementActivity");
        Intent intent = new Intent(contextM1377a, (Class<?>) MainActivity.class);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        contextM1377a.startActivity(intent);
    }

    /* renamed from: F */
    public final void m15542F() {
        long j10;
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("AccountBroadcastManager", "showMigrationNotificationAndDialog context is null");
            return;
        }
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70689w("AccountBroadcastManager", "can not show Migration notice because of st invalid");
            return;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70689w("AccountBroadcastManager", "can not show Migration notice because of SyncRiskEffective");
            return;
        }
        C14163d c14163dM84990g = C14163d.m84990g();
        long jM85002h = c14163dM84990g.m85002h();
        int iM85005k = c14163dM84990g.m85005k();
        long jM85003i = c14163dM84990g.m85003i();
        int iM85006l = c14163dM84990g.m85006l();
        if (iM85005k >= 3) {
            C11839m.m70689w("AccountBroadcastManager", "Do not show Migration notification, notifyCount: " + iM85005k);
            j10 = jM85003i;
        } else {
            j10 = jM85003i;
            if (System.currentTimeMillis() - jM85002h < 24 * C5863b6.g.f26453g) {
                C11839m.m70689w("AccountBroadcastManager", "Do not show Migration notification, lastNotifyTime: " + jM85002h);
            } else if (C0209d.m1185K1(contextM1377a)) {
                C11839m.m70688i("AccountBroadcastManager", "not need show notification, hicloud on the top");
            } else {
                new BackupNotificationManager(contextM1377a.getApplicationContext()).sendDataMigrationNotification(contextM1377a);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C11839m.m70688i("AccountBroadcastManager", "showMigrationNotificationAndDialog, show notification, currentTime: " + jCurrentTimeMillis);
                c14163dM84990g.m84991A(jCurrentTimeMillis);
                c14163dM84990g.m84993C(iM85005k + 1);
            }
        }
        if (iM85006l >= 3) {
            C11839m.m70689w("AccountBroadcastManager", "Do not show Migration desktop dialog, showCount: " + iM85006l);
            return;
        }
        if (System.currentTimeMillis() - j10 < 24 * C5863b6.g.f26453g) {
            C11839m.m70689w("AccountBroadcastManager", "Do not show Migration desktop dialog, lastShowTime: " + j10);
            return;
        }
        if (!C0209d.m1265i1(contextM1377a)) {
            C11839m.m70688i("AccountBroadcastManager", "not need show migrate dialog, home is not on the top");
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        C11839m.m70688i("AccountBroadcastManager", "showMigrationNotificationAndDialog, show desktop dialog, currentTime: " + jCurrentTimeMillis2);
        c14163dM84990g.m84992B(jCurrentTimeMillis2);
        c14163dM84990g.m85020z(iM85006l + 1);
        Intent intent = new Intent();
        intent.setClass(contextM1377a, DataMigrateDialogActivity.class);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        contextM1377a.startActivity(intent);
    }

    /* renamed from: G */
    public final void m15543G() {
        C11437b.m68501e().m68506f(C0213f.m1377a(), true);
    }

    /* renamed from: H */
    public final void m15544H() {
        C9062b.m57146k().m57155h(false, false);
    }

    /* renamed from: I */
    public final void m15545I() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            C11839m.m70688i("AccountBroadcastManager", "processSyncRisk");
            m15547K(contextM1377a, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED);
            NotificationManager notificationManager = (NotificationManager) contextM1377a.getSystemService("notification");
            if (notificationManager != null && C10028c.m62183d0(contextM1377a).m62247N("sync_risk_notify_time") == 0) {
                notificationManager.cancelAll();
            }
            m15554t(contextM1377a);
        }
    }

    /* renamed from: J */
    public final void m15546J() {
        C13452e.m80781L().m80789B2("gallery_login");
        C13223b.m79473a(C0213f.m1377a(), "click_gallery_notify", "1");
        UBAAnalyze.m29954O("PVC", "click_gallery_notify", "4", "14");
        C13622a.m81973s(C0213f.m1377a(), HNConstants.DataType.MEDIA, "click");
    }

    /* renamed from: K */
    public final void m15547K(Context context, int i10) {
        if (context != null) {
            C1008c.m6035v().m6062a(false, i10);
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70688i("AccountBroadcastManager", "cloudAlbumRouterImpl is null");
            } else {
                interfaceC9282a.mo58444n0(context);
            }
        }
    }

    /* renamed from: n */
    public void m15548n() {
        m15550p();
        m15551q();
        m15549o();
        m15552r();
    }

    /* renamed from: o */
    public void m15549o() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        C13612b.m81829B().m81875n0(new Intent(contextM1377a, (Class<?>) AccountLogoutActivity.class));
    }

    /* renamed from: p */
    public final void m15550p() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("AccountBroadcastManager", "init context is null");
            return;
        }
        this.f11915a = new AccountReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hidisk.HANDLE_AIDL_LOGIN_RESULT");
        intentFilter.addAction("com.huawei.hicloud.intent.action.RE_LOGIN_TO_GALLERY");
        intentFilter.addAction("com.huawei.hicloud.intent.action.RE_LOGIN_TO_SYNC");
        intentFilter.addAction("com.huawei.hicloud.action.VALIDATE_HWID_REPORT");
        intentFilter.addAction("com.huawei.hicloud.action.PRIVACY_SPACE_TO_EXIT");
        intentFilter.addAction("com.huawei.hicloud.action.PROCESS_AUTH_FAILED");
        intentFilter.addAction("com.huawei.hicloud.action.PROCESS_SYNC_RISK");
        intentFilter.addAction("com.huawei.hicloud.action.ON_LOGIN");
        intentFilter.addAction("com.huawei.hicloud.action.NOTIFY_MIGRATION");
        intentFilter.addAction("com.huawei.hicloud.action.SITE_NOT_MATCH");
        intentFilter.addAction("com.huawei.hicloud.action.PROCESS_FORCE_UPGRADE");
        intentFilter.addAction("com.huawei.hicloud.actoin.NOTIFY_ACCOUNT_INFO");
        intentFilter.addAction("com.huawei.hicloud.actoin.ACTION_SHOW_MIGRATION");
        intentFilter.addAction("com.huawei.hicloud.actoin.ACTION_ACCOUNT_INCONSISTENT_EXIT_APP");
        intentFilter.addAction("com.huawei.hicloud.actoin.ACTION_ACCOUNT_INCONSISTENT_CLEAR_DATA");
        intentFilter.addAction("om.huawei.hicloud.actoin.URGENCY_NOTICE");
        intentFilter.addAction("com.huawei.hicloud.actoin.PUSH_TOKEN_SUCCESS");
        intentFilter.addAction("com.huawei.hicloud.actoin.ACTION_SEND_BACKUP_CYCLE_NOTIFY");
        intentFilter.addAction("com.huawei.hicloud.actoin.OPEN_PUSH_SUCCESS");
        C13108a.m78878b(contextM1377a).m78880c(this.f11915a, intentFilter);
    }

    /* renamed from: q */
    public void m15551q() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) MainActivity.class);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "4");
        intent.putExtra("entry_key", "click_notification");
        C13230i.m79525e1(intent, "4", "4");
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_ST_INVALID_NOTIFY");
        C13612b.m81829B().m81877o0(intent);
    }

    /* renamed from: r */
    public void m15552r() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        Intent intent = new Intent(contextM1377a, (Class<?>) MainActivity.class);
        intent.putExtra("entry_key", "click_desktop");
        C0216g0.m1402e(contextM1377a).m1407E(intent, "SOURCE_ID_ST_INVALID_DIALOG");
        C13612b.m81829B().m81887t0(intent);
    }

    /* renamed from: s */
    public final boolean m15553s(Context context) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62388s("addressbook") || c10028cM62182c0.m62388s("wlan") || c10028cM62182c0.m62388s("notepad") || c10028cM62182c0.m62388s("calendar")) {
            C11839m.m70688i("AccountBroadcastManager", "sync need push");
            return true;
        }
        if (C1010e.m6125b().m6139e(context)) {
            C11839m.m70688i("AccountBroadcastManager", "phonefinder need push");
            return true;
        }
        C11839m.m70688i("AccountBroadcastManager", "no need register push");
        return false;
    }

    /* renamed from: t */
    public final void m15554t(Context context) {
        if (!C13612b.m81829B().isLogin()) {
            C11839m.m70689w("AccountBroadcastManager", "notifySyncRisk, Cloud hasn't login, don't notify");
            return;
        }
        C11839m.m70688i("AccountBroadcastManager", "notifySyncRisk background");
        if (!C13612b.m81829B().m81851O(context, true)) {
            C12515a.m75110o().m75172d(new ShowSyncRiskTask(context));
        } else {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        }
    }

    /* renamed from: u */
    public final void m15555u() {
        C9062b.m57146k().m57155h(true, false);
    }

    /* renamed from: v */
    public final void m15556v() {
        C1010e.m6125b().m6126A(C0213f.m1377a());
    }

    /* renamed from: w */
    public final void m15557w() {
        m15547K(C0213f.m1377a(), 2001);
    }

    /* renamed from: x */
    public final void m15558x() {
        ForcedUpgradeUtil.getInstance().processForcedUpgrade(C0213f.m1377a());
    }

    /* renamed from: y */
    public final void m15559y() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && C13612b.m81829B().isLogin()) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70688i("AccountBroadcastManager", "cloudAlbumRouterImpl is null");
            } else if (interfaceC9282a.mo58390R(contextM1377a.getApplicationContext())) {
                return;
            }
            C11839m.m70688i("AccountBroadcastManager", "Notify login success to cloud album");
            Bundle bundleM81840C = C13612b.m81829B().m81840C();
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58448p0(contextM1377a.getApplicationContext(), bundleM81840C);
                C12515a.m75110o().m75175e(new C10148k(C0213f.m1377a(), "login"), true);
            }
        }
    }

    /* renamed from: z */
    public final void m15560z() {
        C14163d.m84990g().m85017w();
    }
}
