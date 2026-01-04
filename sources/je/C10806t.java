package je;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.task.simple.C3067o1;
import com.huawei.android.hicloud.task.simple.C3071p1;
import com.huawei.android.hicloud.task.simple.InitCloudBackupDataTask;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import mn.C11500d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p020ap.C1010e;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10155f;
import p422k9.C11019b;
import p474m9.C11432a;
import p514o9.C11839m;
import p572qb.C12300b0;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import vn.C13470b;

/* renamed from: je.t */
/* loaded from: classes3.dex */
public class C10806t {

    /* renamed from: a */
    public static ArrayList<String> f51582a = new ArrayList<>();

    /* renamed from: je.t$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f51583a;

        public a(Context context) {
            this.f51583a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            C10806t.m65782i(this.f51583a);
        }
    }

    /* renamed from: b */
    public static void m65775b(String str) {
        f51582a.add(str);
    }

    /* renamed from: c */
    public static void m65776c(Context context) {
        C12515a.m75110o().m75172d(new InitCloudBackupDataTask(context));
        HiCloudAllOMConfigManager.getInstance().downloadMultipleConfig(null, false);
        SpaceNoticeV3Manager.getInstance().executeLocalLanguageTask();
        SpaceInsuffNoticeV4Manager.getInstance().executeLocalLanguageTask();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58462w0(context);
            interfaceC9282a.mo58388Q(context);
            interfaceC9282a.mo58375J0(context);
        } else {
            C11839m.m70688i("QuickMigrateUtil", "cloudAlbumRouterImpl is null");
        }
        C11500d.m68648g().m68660m(context);
        C11019b.m66371t().m66376C(context);
        C11019b.m66371t().m66419g(context);
        C13225d.m79490f1().m79560L(context, C13452e.m80781L().m80971t0());
        C11019b.m66371t().m66381E0(context);
    }

    /* renamed from: d */
    public static void m65777d(Context context) {
        Bundle bundle = new Bundle();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        bundle.putBoolean("oobe_contact", c10028cM62182c0.m62388s("addressbook"));
        bundle.putBoolean("oobe_calendar", c10028cM62182c0.m62388s("calendar"));
        bundle.putBoolean("oobe_notepad", c10028cM62182c0.m62388s("notepad"));
        bundle.putBoolean("oobe_browser", c10028cM62182c0.m62388s("browser"));
        bundle.putBoolean("oobe_wlan", c10028cM62182c0.m62388s("wlan"));
        bundle.putBoolean("oobe_backup", true);
        if (!TextUtils.isEmpty(PriorInstallWay.PRIOR_ACTION_LANDING_PAGE)) {
            bundle.putString("channel_of_open_switch", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE);
        }
        C12515a.m75110o().m75172d(new C3071p1(context.getApplicationContext(), bundle));
    }

    /* renamed from: e */
    public static boolean m65778e() {
        return C10028c.m62182c0().m62403v("quick_migrate_task_excuted", false);
    }

    /* renamed from: f */
    public static void m65779f(Context context) {
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_huawei_drive");
        C12515a.m75110o().m75175e(new C3067o1(context, 1, zM62395t1, C10028c.m62182c0().m62373p(), ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(context), C10028c.m62182c0().m62329g0(), zM62395t1 ? 2 : 3), true);
    }

    /* renamed from: g */
    public static void m65780g(Context context) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisCloudAlbumOn", false));
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58396U(context, bundle, 16);
        }
    }

    /* renamed from: h */
    public static void m65781h() {
        C11839m.m70688i("QuickMigrateUtil", "openPhoneFinder");
        C1010e.m6125b().m6135J(C0213f.m1377a());
        C12300b0.m73940b().m73943e(13);
    }

    /* renamed from: i */
    public static void m65782i(Context context) throws InterruptedException {
        C13230i.m79545v();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(strM80971t0);
        linkedHashMapM79499C.put("oobe_contact", String.valueOf(c10028cM62182c0.m62388s("addressbook")));
        linkedHashMapM79499C.put("oobe_calendar", String.valueOf(c10028cM62182c0.m62388s("calendar")));
        linkedHashMapM79499C.put("oobe_notepad", String.valueOf(c10028cM62182c0.m62388s("notepad")));
        linkedHashMapM79499C.put("oobe_browser", String.valueOf(c10028cM62182c0.m62388s("browser")));
        linkedHashMapM79499C.put("oobe_wlan", String.valueOf(c10028cM62182c0.m62388s("wlan")));
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        linkedHashMapM79499C.put("GeneralAblum", String.valueOf(C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisCloudAlbumOn", false)));
        Iterator<String> it = f51582a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean z10 = sharedPreferencesM1382b.getBoolean(next, false);
            linkedHashMapM79499C.put(next, String.valueOf(z10));
            C11839m.m70688i("QuickMigrateUtil", "config;" + next + " configValue;" + z10);
            if (z10) {
                C10155f.m63277b0(context, next, C13622a.m81958d("03003"), 0);
            }
        }
        if (C13470b.m81125a().m81126b()) {
            C13225d.m79490f1().m79565P0(PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, linkedHashMapM79499C);
            return;
        }
        C11839m.m70688i("QuickMigrateUtil", "dataanalyze switch need init");
        C11432a.m68479d();
        C11432a.m68483i(PriorInstallWay.PRIOR_ACTION_LANDING_PAGE);
        C11432a.m68479d();
        C11432a.m68484j(true);
        C11432a.m68479d();
        C11432a.m68482g(linkedHashMapM79499C);
        C11432a.m68479d().m68486c();
    }

    /* renamed from: j */
    public static void m65783j(Context context) {
        C12515a.m75110o().m75172d(new a(context));
    }

    /* renamed from: k */
    public static void m65784k(boolean z10) {
        C10028c.m62182c0().m62377p3("quick_migrate_task_excuted", z10);
    }
}
