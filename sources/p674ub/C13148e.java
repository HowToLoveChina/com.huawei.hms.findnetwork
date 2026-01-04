package p674ub;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.task.simple.C3011a1;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0235t;
import p015ak.C0238w;
import p020ap.C1009d;
import p514o9.C11839m;
import p616rk.C12515a;
import p617rl.C12526j;
import p684un.C13225d;
import p684un.C13230i;
import p694v.C13306h;
import p709vj.C13452e;

/* renamed from: ub.e */
/* loaded from: classes3.dex */
public class C13148e {
    /* renamed from: b */
    public static void m79053b(Context context) {
        C11839m.m70688i("GuideSyncSwitchNotify", "cancelGuideSyncSwitchNotify");
        C13306h.m79781d(context).m79785b(572);
    }

    /* renamed from: c */
    public static void m79054c() {
        C0212e0.m1351a(C0213f.m1377a(), "guide_sync_notify_show_sp");
    }

    /* renamed from: d */
    public static long m79055d() {
        return C0212e0.m1359i(C0213f.m1377a(), "guide_sync_notify_show_sp", "guide_sync_notify_check_time", 0L);
    }

    /* renamed from: e */
    public static long m79056e() {
        return C0212e0.m1359i(C0213f.m1377a(), "guide_sync_notify_show_sp", "guide_sync_notify_show_time", 0L);
    }

    /* renamed from: f */
    public static void m79057f(final Context context) {
        C11839m.m70688i("GuideSyncSwitchNotify", "guideSyncNotify");
        if (!m79058g(context)) {
            C11839m.m70689w("GuideSyncSwitchNotify", "ShowGuideNotify is false");
        } else {
            C12515a.m75110o().m75175e(new C3011a1(false, new Consumer() { // from class: ub.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C13148e.m79059h(context, (List) obj);
                }
            }), true);
        }
    }

    /* renamed from: g */
    public static boolean m79058g(Context context) {
        C11839m.m70688i("GuideSyncSwitchNotify", "isShowGuideNotify");
        if (context == null) {
            return false;
        }
        if (System.currentTimeMillis() < m79055d()) {
            C11839m.m70689w("GuideSyncSwitchNotify", "current time less than notify interval");
            return false;
        }
        if (!C1009d.m6109e().m6118j(context)) {
            C11839m.m70689w("GuideSyncSwitchNotify", "system notification is false");
            return false;
        }
        if (C0209d.m1185K1(context)) {
            C11839m.m70689w("GuideSyncSwitchNotify", "app is foreGround");
            return false;
        }
        if (!new C12526j().m75390f1(8)) {
            C11839m.m70689w("GuideSyncSwitchNotify", "om config disable");
            return false;
        }
        if (System.currentTimeMillis() - m79056e() >= r8.m75393h().getRecommendNotifyInterval() * 86400000) {
            return true;
        }
        C11839m.m70689w("GuideSyncSwitchNotify", "current time less than recommend interval");
        return false;
    }

    /* renamed from: h */
    public static /* synthetic */ void m79059h(Context context, List list) {
        if (!list.isEmpty()) {
            m79062k(context);
            m79061j(System.currentTimeMillis());
        } else {
            C11839m.m70689w("GuideSyncSwitchNotify", "guideAppList is empty");
            m79060i(System.currentTimeMillis() + (new C12526j().m75393h().getNotifyCheckInterval() * C5863b6.g.f26453g));
        }
    }

    /* renamed from: i */
    public static void m79060i(long j10) {
        C11839m.m70688i("GuideSyncSwitchNotify", "showDialogCheckFailTime: " + j10);
        C0212e0.m1370t(C0213f.m1377a(), "guide_sync_notify_show_sp", "guide_sync_notify_check_time", j10);
    }

    /* renamed from: j */
    public static void m79061j(long j10) {
        C11839m.m70688i("GuideSyncSwitchNotify", "showNotifyTime: " + j10);
        C0212e0.m1370t(C0213f.m1377a(), "guide_sync_notify_show_sp", "guide_sync_notify_show_time", j10);
    }

    /* renamed from: k */
    public static void m79062k(Context context) {
        C11839m.m70688i("GuideSyncSwitchNotify", "showGuideSyncNotify");
        String string = context.getString(R$string.HiCloud_app_name);
        String string2 = context.getString(R$string.usage_suggestion_title);
        String string3 = context.getString(R$string.usage_suggestion_msg);
        Intent intent = new Intent(NotifyConstants.Action.ACTION_MAIN_ACTIVITY);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "1");
        intent.putExtra("scene_id", NotifyUtil.getReportSceneId(NotifyConstants.GUIDE_SYNC_SWITCH_NOTIFICATION));
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        NotificationCompat.Builder builderM1647f = NotifyUtil.isSilentNotifyTime() ? C0235t.m1645e().m1647f(context, string, "2", context.getString(com.huawei.hicloud.account.R$string.app_name)) : C0238w.m1663f().m1668i(context, string);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", string);
        builderM1647f.m3824y(R$drawable.logo_about_system).m3811l(string2).m3810k(string3).m3823x(true).m3807h(true).m3825z(new NotificationCompat.C0605b()).m3809j(pendingIntentM1248e0).m3803c(bundle);
        C13306h.m79781d(context).m79787f(572, builderM1647f.m3804d());
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13225d.m79490f1().m79591l0("mecloud_main_notice_switch_suggest_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_main_notice_switch_suggest_show", "1", "cloud_space_home_page_dialog", linkedHashMapM79499C);
    }
}
