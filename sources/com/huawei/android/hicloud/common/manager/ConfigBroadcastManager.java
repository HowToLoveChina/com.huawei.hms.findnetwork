package com.huawei.android.hicloud.common.manager;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.SQLException;
import com.huawei.android.hicloud.cloudbackup.process.CloudAlbumNotificationManager;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.ForceUpgradeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.UpgradeNotifyBar;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import hu.C10343b;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1006a;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p422k9.C11019b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p837z9.C14163d;

/* loaded from: classes3.dex */
public class ConfigBroadcastManager {

    /* renamed from: b */
    public static final ConfigBroadcastManager f11935b = new ConfigBroadcastManager();

    /* renamed from: a */
    public ConfigReceiver f11936a;

    public static class ConfigReceiver extends BroadcastReceiver {

        /* renamed from: com.huawei.android.hicloud.common.manager.ConfigBroadcastManager$ConfigReceiver$a */
        public class C2751a extends AbstractC12367d {

            /* renamed from: a */
            public final /* synthetic */ Context f11937a;

            public C2751a(Context context) {
                this.f11937a = context;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                ConfigReceiver.this.m15607i(this.f11937a);
            }
        }

        /* renamed from: b */
        public final /* synthetic */ void m15600b(Context context, int i10) {
            NotifyLogger.m29915i("ConfigBroadcastManager", "showUpgradeNotification");
            m15607i(context);
        }

        /* renamed from: c */
        public final void m15601c() {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                NotifyLogger.m29915i("ConfigBroadcastManager", "processForcedUpgrade");
                if (!C10028c.m62182c0().m62380q1() || ForcedUpgradeUtil.getInstance().isUserCancelForcedUpgrade()) {
                    NotifyLogger.m29915i("ConfigBroadcastManager", "no need processForcedUpgrade");
                    return;
                }
                m15608j(contextM1377a, 2201);
                NotificationManager notificationManager = (NotificationManager) contextM1377a.getSystemService("notification");
                if (notificationManager != null && C10028c.m62183d0(contextM1377a).m62247N("upgrade_last_notice_time") == 0 && !C0209d.m1241c1()) {
                    notificationManager.cancelAll();
                }
                C12515a.m75110o().m75172d(new C2751a(contextM1377a));
            }
        }

        /* renamed from: d */
        public final void m15602d(SafeIntent safeIntent) {
            NotifyLogger.m29915i("ConfigBroadcastManager", "processForceUpgradeErrorCode");
            int iM63686h = new C10343b(safeIntent.getExtras()).m63686h(NotifyConstants.Broadcacst.FORCE_GRADE_ERROR_CODE);
            NotifyLogger.m29915i("ConfigBroadcastManager", "processForceUpgradeErrorCode, error code is:" + iM63686h);
            C10028c.m62182c0().m62227I2(iM63686h);
            final Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                NotifyLogger.m29915i("ConfigBroadcastManager", "saveForcedUpgradeConfigFromServerCode start");
                HiCloudForceUpgradeConfigManager.getInstance().saveForcedUpgradeConfigFromServerCode(new ForcedUpgradeUtil.QueryUpdate() { // from class: e9.h
                    @Override // com.huawei.hicloud.notification.util.ForcedUpgradeUtil.QueryUpdate
                    public final void onUpgrade(int i10) {
                        this.f47123a.m15600b(contextM1377a, i10);
                    }
                }, iM63686h);
            }
        }

        /* renamed from: e */
        public final void m15603e(SafeIntent safeIntent) {
            C10343b c10343b = new C10343b(safeIntent.getExtras());
            long jM63688j = c10343b.m63688j("needSpace");
            boolean zM63681c = c10343b.m63681c("isAutoSync");
            C12515a.m75110o().m75175e(new C2752a(C0213f.m1377a().getApplicationContext(), zM63681c, jM63688j), false);
        }

        /* renamed from: f */
        public final void m15604f() {
            C14163d.m84990g().m85017w();
        }

        /* renamed from: g */
        public final void m15605g(SafeIntent safeIntent) {
            int intExtra = safeIntent.getIntExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_DOWNLOAD_MAX_NUM, 0);
            int intExtra2 = safeIntent.getIntExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_UPLOAD_MAX_NUM, 0);
            int intExtra3 = safeIntent.getIntExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_UPLOAD_MAX_SIZE, 0);
            int intExtra4 = safeIntent.getIntExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_DOWNLOAD_NUM, 0);
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                NotifyLogger.m29915i("ConfigBroadcastManager", "cloudAlbumRouterImpl is null");
            } else {
                interfaceC9282a.mo58387P0(C0213f.m1377a(), intExtra2, intExtra3, intExtra, intExtra4);
            }
        }

        /* renamed from: h */
        public final void m15606h(SafeIntent safeIntent) {
            C11019b.m66371t().m66418f0(C0213f.m1377a(), safeIntent.getStringExtra("key"), safeIntent.getBooleanExtra("isOn", false));
        }

        /* renamed from: i */
        public void m15607i(Context context) {
            if (context == null) {
                NotifyLogger.m29914e("ConfigBroadcastManager", "showUpgradeNotification context is null");
                return;
            }
            if (!C10028c.m62182c0().m62380q1()) {
                NotifyLogger.m29915i("ConfigBroadcastManager", "no need do forced upgrade");
                return;
            }
            NotifyLogger.m29913d("ConfigBroadcastManager", "showUpgradeNotification");
            C10028c c10028cM62183d0 = C10028c.m62183d0(context);
            long jM62247N = c10028cM62183d0.m62247N("upgrade_last_notice_time");
            int iM62274T = c10028cM62183d0.m62274T();
            NotifyLogger.m29915i("ConfigBroadcastManager", "forcedUpgradeServerCode:" + iM62274T);
            ForceUpgradeConfiguration conformsConfig = HiCloudForceUpgradeConfigManager.getInstance().getConformsConfig();
            if (iM62274T != 0) {
                conformsConfig = HiCloudForceUpgradeConfigManager.getInstance().getConformsConfig(iM62274T);
            }
            if (conformsConfig == null) {
                C10028c.m62182c0().m62254O1();
                NotifyLogger.m29914e("ConfigBroadcastManager", "get notification fail, no need to notify");
                return;
            }
            UpgradeNotifyBar notifyBar = conformsConfig.getNotifyBar();
            NotifyLogger.m29915i("ConfigBroadcastManager", "begin notify");
            String[] remindWays = conformsConfig.getRemindWays();
            ForcedUpgradeUtil forcedUpgradeUtil = new ForcedUpgradeUtil();
            if (forcedUpgradeUtil.containsValue(remindWays, "notifyBar")) {
                forcedUpgradeUtil.showUpgradeNotice(context, jM62247N, notifyBar);
            }
            forcedUpgradeUtil.processAppForegroundShow(context);
        }

        /* renamed from: j */
        public final void m15608j(Context context, int i10) {
            if (context != null) {
                C1008c.m6035v().m6062a(false, i10);
                C1006a.m5936k().m5960f(context);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("com.huawei.hicloud.actoin.RETRY_MIGRATION_TASK".equals(action)) {
                m15604f();
                return;
            }
            if ("com.huawei.hicloud.actoin.ACTION_NOTIFY_SYNC_SWITCH_CHANGED".equals(action)) {
                m15606h(safeIntent);
                return;
            }
            if (NotifyConstants.Broadcacst.ACTION_SYNC_LIMIT_CONFIG.equals(action)) {
                m15605g(safeIntent);
                return;
            }
            if (NotifyConstants.Broadcacst.ACTION_PROCESS_FORCE_UPGRADE.equals(action)) {
                m15601c();
            } else if (NotifyConstants.Broadcacst.ACTION_SHOW_NOTIFY_FOR_ALBUM.equals(action)) {
                m15603e(safeIntent);
            } else if (NotifyConstants.Broadcacst.ACTION_PROCESS_FORCE_UPGRADE_FROM_SERVER_CODE.equals(action)) {
                m15602d(safeIntent);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.manager.ConfigBroadcastManager$a */
    public static class C2752a extends AbstractC12367d {

        /* renamed from: a */
        public Context f11939a;

        /* renamed from: b */
        public boolean f11940b;

        /* renamed from: c */
        public long f11941c;

        public C2752a(Context context, boolean z10, long j10) {
            this.f11939a = context;
            this.f11940b = z10;
            this.f11941c = j10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, SQLException {
            new CloudAlbumNotificationManager(this.f11939a).showNotify(this.f11940b, this.f11941c);
        }
    }

    /* renamed from: a */
    public static ConfigBroadcastManager m15597a() {
        return f11935b;
    }

    /* renamed from: b */
    public void m15598b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("ConfigBroadcastManager", "init context is null");
            return;
        }
        this.f11936a = new ConfigReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.actoin.RETRY_MIGRATION_TASK");
        intentFilter.addAction("com.huawei.hicloud.actoin.ACTION_NOTIFY_SYNC_SWITCH_CHANGED");
        intentFilter.addAction(NotifyConstants.Broadcacst.ACTION_SYNC_LIMIT_CONFIG);
        intentFilter.addAction(NotifyConstants.Broadcacst.ACTION_PROCESS_FORCE_UPGRADE);
        intentFilter.addAction(NotifyConstants.Broadcacst.ACTION_PROCESS_FORCE_UPGRADE_FROM_SERVER_CODE);
        intentFilter.addAction(NotifyConstants.Broadcacst.ACTION_SHOW_NOTIFY_FOR_ALBUM);
        C13108a.m78878b(contextM1377a).m78880c(this.f11936a, intentFilter);
    }
}
