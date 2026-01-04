package p572qb;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.p088ui.StockActivePopupGuideActivity;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hicloud.notification.manager.HiCLoudStockActiveManager;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.IStockActiveInvoker;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.router.R$drawable;
import com.huawei.hicloud.router.R$string;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0235t;
import p015ak.C0238w;
import p335hd.C10149l;
import p422k9.C11019b;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;

/* renamed from: qb.i0 */
/* loaded from: classes3.dex */
public class C12314i0 implements IStockActiveInvoker {

    /* renamed from: a */
    public StockActivePopupGuideActivity f57024a;

    /* renamed from: qb.i0$a */
    public class a implements InterfaceC13456i {

        /* renamed from: a */
        public final /* synthetic */ String f57025a;

        public a(String str) {
            this.f57025a = str;
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            if (z10) {
                C12314i0.this.m74037b(this.f57025a);
            } else {
                C11839m.m70688i("StockActiveManager", "account not login");
            }
        }
    }

    /* renamed from: qb.i0$b */
    public static class b {

        /* renamed from: a */
        public static C12314i0 f57027a = new C12314i0(null);
    }

    public /* synthetic */ C12314i0(a aVar) {
        this();
    }

    /* renamed from: h */
    public static C12314i0 m74036h() {
        return b.f57027a;
    }

    @Override // com.huawei.hicloud.notification.util.IStockActiveInvoker
    public void activeCloud(String str) {
        if (C0209d.m1293p1()) {
            C11839m.m70688i("StockActiveManager", "isInkScreen");
            return;
        }
        if (!m74039d()) {
            C11839m.m70688i("StockActiveManager", "last active cloud not more than 24 hours");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        if (!C0209d.m1246d2(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "locked");
            return;
        }
        if (!C0209d.m1333z1(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "no network");
            return;
        }
        if (C0209d.m1173G1(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "privacy user");
            return;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70687e("StockActiveManager", "not owner");
            return;
        }
        if (!C0209d.m1203Q1(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "OOBE not active cloud");
            return;
        }
        if (C0209d.m1269j1()) {
            C13612b.m81829B().mo80999a(contextM1377a, new a(str));
        } else if (1 != C13612b.m81829B().m81843F(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "account not login");
        } else {
            m74037b(str);
        }
    }

    /* renamed from: b */
    public final void m74037b(String str) {
        if (HiCLoudStockActiveManager.getInstance().isProcessExit()) {
            C11839m.m70688i("StockActiveManager", "ProcessExit, not login");
            return;
        }
        if (C13452e.m80781L().m80850R0()) {
            C11839m.m70688i("StockActiveManager", "cloud activated and no fail");
            return;
        }
        if (m74048n()) {
            C11839m.m70688i("StockActiveManager", "isActiveCloudAuto, not active cloud");
        } else {
            if (m74046l()) {
                C11839m.m70689w("StockActiveManager", "HasEnteredMainActivity");
                return;
            }
            C11839m.m70688i("StockActiveManager", "activeCloud");
            C12515a.m75110o().m75172d(new C10149l(str));
        }
    }

    /* renamed from: c */
    public boolean m74038c(int i10) {
        int iM74042g = m74042g();
        C11839m.m70688i("StockActiveManager", "canNotifyByFrequency notifyType: " + i10 + ", frequency: " + iM74042g);
        if (iM74042g == -1) {
            return false;
        }
        long jM74044j = m74044j();
        long jM74045k = m74045k();
        long jCurrentTimeMillis = System.currentTimeMillis() - jM74044j;
        long j10 = iM74042g * 86400000;
        if (jCurrentTimeMillis <= j10 || System.currentTimeMillis() - jM74045k <= j10) {
            C11839m.m70688i("StockActiveManager", "can't notify");
            return false;
        }
        C11839m.m70688i("StockActiveManager", "can notify");
        return true;
    }

    @Override // com.huawei.hicloud.notification.util.IStockActiveInvoker
    public boolean canNotify(int i10) {
        C11839m.m70688i("StockActiveManager", "canNotify notifyType: " + i10);
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return false;
        }
        if (C0209d.m1173G1(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "privacy user");
            return false;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70687e("StockActiveManager", "not owner");
            return false;
        }
        if (!C0209d.m1203Q1(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "OOBE not notify");
            return false;
        }
        if (HiCLoudStockActiveManager.getInstance().isProcessExit()) {
            C11839m.m70688i("StockActiveManager", "ProcessExit, not notify");
            return false;
        }
        if (!m74048n()) {
            C11839m.m70688i("StockActiveManager", "not auto active");
            return false;
        }
        if (!m74038c(i10)) {
            C11839m.m70687e("StockActiveManager", "frequency not ok");
            return false;
        }
        if (m74046l()) {
            C11839m.m70689w("StockActiveManager", "HasEnteredMainActivity");
            return false;
        }
        if (!m74047m()) {
            return true;
        }
        C11839m.m70689w("StockActiveManager", "no more reminders");
        return false;
    }

    @Override // com.huawei.hicloud.notification.util.IStockActiveInvoker
    public void clearNotification() {
        C11839m.m70688i("StockActiveManager", "clearNotification");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
        } else {
            new HiCloudNotificationManager(contextM1377a).cancelNotification(296);
        }
    }

    /* renamed from: d */
    public boolean m74039d() {
        return System.currentTimeMillis() - m74043i() > 86400000;
    }

    /* renamed from: e */
    public void m74040e() throws SQLException {
        HiCLoudStockActiveManager.getInstance().clearConfigFileAndDb();
        C0212e0.m1353c(StockActiveConstants.STOCK_ACTIVE_SP_NAME);
        this.f57024a = null;
    }

    /* renamed from: f */
    public long m74041f() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return 0L;
        }
        long jM1360j = C0212e0.m1360j(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.FIRST_NOTIFY_TIME, 0L);
        C11839m.m70688i("StockActiveManager", "getFirstNotifyTime: " + jM1360j);
        return jM1360j;
    }

    @Override // com.huawei.hicloud.notification.util.IStockActiveInvoker
    public void finishActivity() {
        if (this.f57024a != null) {
            C11839m.m70688i("StockActiveManager", "finish PopupGuideActivity");
            this.f57024a.finish();
            this.f57024a = null;
        }
    }

    /* renamed from: g */
    public int m74042g() {
        long jM74041f = m74041f();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jM74041f == 0) {
            return 7;
        }
        long j10 = jCurrentTimeMillis - jM74041f;
        if (j10 <= 2592000000L) {
            return 7;
        }
        return (j10 <= 2592000000L || j10 > 15552000000L) ? -1 : 30;
    }

    /* renamed from: i */
    public long m74043i() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C0212e0.m1360j(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.LAST_ACTIVE_CLOUD_TIME, 0L);
        }
        C11839m.m70687e("StockActiveManager", "context is null");
        return 0L;
    }

    /* renamed from: j */
    public long m74044j() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return 0L;
        }
        long jM1360j = C0212e0.m1360j(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, "last_send_notification_time", 0L);
        C11839m.m70688i("StockActiveManager", "getLastSendNotificationTime: " + jM1360j);
        return jM1360j;
    }

    /* renamed from: k */
    public long m74045k() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return 0L;
        }
        long jM1360j = C0212e0.m1360j(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.LAST_SHOW_POPUP_TIME, 0L);
        C11839m.m70688i("StockActiveManager", "getLastShowPopupTime: " + jM1360j);
        return jM1360j;
    }

    /* renamed from: l */
    public boolean m74046l() {
        boolean zM1355e = C0212e0.m1355e(C0213f.m1377a(), StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IF_HAS_ENTERED_MAIN_ACTIVITY, false);
        C11839m.m70688i("StockActiveManager", "ifHasEnteredMainActivity: " + zM1355e);
        return zM1355e;
    }

    /* renamed from: m */
    public boolean m74047m() {
        boolean zM1355e = C0212e0.m1355e(C0213f.m1377a(), StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IF_NO_MORE_REMINDERS, false);
        C11839m.m70688i("StockActiveManager", "ifNoMoreReminders: " + zM1355e);
        return zM1355e;
    }

    /* renamed from: n */
    public boolean m74048n() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return false;
        }
        boolean zM1355e = C0212e0.m1355e(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IS_ACTIVE_CLOUD_AUTO, false);
        C11839m.m70688i("StockActiveManager", "isActiveCloudAuto: " + zM1355e);
        return zM1355e;
    }

    /* renamed from: o */
    public final void m74049o() throws Resources.NotFoundException {
        C11839m.m70688i("StockActiveManager", "sendNotification");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(contextM1377a, C11019b.m66371t().m66441r(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY));
        intent.putExtra("is_from_stock_active", true);
        intent.putExtra("is_from_stock_active_notify", true);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C0216g0.m1402e(contextM1377a).m1408F(intent, "SOURCE_ID_STOCK_ACTIVE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent2.setComponent(new ComponentName(contextM1377a, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent2, contextM1377a.getPackageName());
        intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent2.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "7");
        PendingIntent broadcast = PendingIntent.getBroadcast(contextM1377a, 1, intent2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        String[] stockActiveBanner = HiCLoudStockActiveManager.getInstance().getStockActiveBanner();
        if (stockActiveBanner.length != 2) {
            C11839m.m70687e("StockActiveManager", "banner no language");
            return;
        }
        String str = stockActiveBanner[0];
        String str2 = stockActiveBanner[1];
        boolean zIsSilentNotifyTime = NotifyUtil.isSilentNotifyTime();
        C11839m.m70688i("StockActiveManager", "isSilent: " + zIsSilentNotifyTime);
        ((NotificationManager) contextM1377a.getSystemService("notification")).notify(296, (zIsSilentNotifyTime ? C0235t.m1645e().m1647f(contextM1377a, str, "2", contextM1377a.getString(com.huawei.hicloud.account.R$string.app_name)) : C0238w.m1663f().m1668i(contextM1377a, str)).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(contextM1377a.getResources().getString(i10)).m3811l(str).m3810k(str2).m3809j(pendingIntentM1248e0).m3814o(broadcast).m3824y(R$drawable.logo_about_system).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d());
        m74053s();
        UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.SHOW_NOTIFY);
    }

    /* renamed from: p */
    public void m74050p() {
        C11839m.m70688i("StockActiveManager", "setHasEnteredMainActivity");
        C0212e0.m1366p(C0213f.m1377a(), StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IF_HAS_ENTERED_MAIN_ACTIVITY, true);
    }

    /* renamed from: q */
    public void m74051q(boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        C11839m.m70688i("StockActiveManager", "setIsActiveCloudAuto: " + z10);
        C0212e0.m1366p(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IS_ACTIVE_CLOUD_AUTO, z10);
    }

    /* renamed from: r */
    public void m74052r() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("StockActiveManager", "active time: " + jCurrentTimeMillis);
        C0212e0.m1371u(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.LAST_ACTIVE_CLOUD_TIME, jCurrentTimeMillis);
    }

    /* renamed from: s */
    public void m74053s() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("StockActiveManager", "setLastSendNotificationTime: " + jCurrentTimeMillis);
        C0212e0.m1371u(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, "last_send_notification_time", jCurrentTimeMillis);
        if (m74041f() == 0) {
            C11839m.m70688i("StockActiveManager", "setFirstNotifyTime: " + jCurrentTimeMillis);
            C0212e0.m1371u(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.FIRST_NOTIFY_TIME, jCurrentTimeMillis);
        }
    }

    /* renamed from: t */
    public void m74054t() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("StockActiveManager", "setSendShowPopupTime: " + jCurrentTimeMillis);
        C0212e0.m1371u(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.LAST_SHOW_POPUP_TIME, jCurrentTimeMillis);
        if (m74041f() == 0) {
            C11839m.m70688i("StockActiveManager", "setFirstNotifyTime: " + jCurrentTimeMillis);
            C0212e0.m1371u(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.FIRST_NOTIFY_TIME, jCurrentTimeMillis);
        }
    }

    @Override // com.huawei.hicloud.notification.util.IStockActiveInvoker
    public void trySendNotification() throws Resources.NotFoundException {
        C11839m.m70688i("StockActiveManager", "trySendNotification");
        UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.TRY_NOTIFY);
        if (canNotify(1)) {
            m74049o();
        } else {
            C11839m.m70687e("StockActiveManager", "not satisfy reminder condition");
        }
    }

    @Override // com.huawei.hicloud.notification.util.IStockActiveInvoker
    public void tryShowPopup() {
        C11839m.m70688i("StockActiveManager", "tryShowPopup");
        UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.TRY_POPUP_GUIDE);
        if (canNotify(2)) {
            m74057w();
        } else {
            C11839m.m70687e("StockActiveManager", "not satisfy reminder condition");
        }
    }

    /* renamed from: u */
    public void m74055u() {
        C11839m.m70688i("StockActiveManager", "setNoMoreReminders");
        C0212e0.m1366p(C0213f.m1377a(), StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IF_NO_MORE_REMINDERS, true);
    }

    /* renamed from: v */
    public void m74056v(StockActivePopupGuideActivity stockActivePopupGuideActivity) {
        this.f57024a = stockActivePopupGuideActivity;
    }

    /* renamed from: w */
    public final void m74057w() {
        C11839m.m70688i("StockActiveManager", "showPopup");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveManager", "context is null");
            return;
        }
        if (!C0209d.m1265i1(contextM1377a)) {
            C11839m.m70688i("StockActiveManager", "not in home");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(contextM1377a, StockActivePopupGuideActivity.class);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        try {
            contextM1377a.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("StockActiveManager", "startActivity exception: " + e10.toString());
        }
    }

    public C12314i0() {
    }
}
