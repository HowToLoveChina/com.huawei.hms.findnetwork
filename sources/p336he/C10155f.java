package p336he;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0226l0;
import p020ap.C1006a;
import p020ap.C1008c;
import p020ap.C1010e;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p292fn.C9733f;
import p335hd.C10146i;
import p335hd.C10147j;
import p399jk.AbstractC10896a;
import p459lp.C11326d;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13223b;
import p709vj.C13452e;
import p709vj.InterfaceC13454g;
import p742wj.C13612b;
import p783xp.C13843a;
import p836z8.C14157f;
import p846zj.C14306d;
import vn.C13471c;

/* renamed from: he.f */
/* loaded from: classes3.dex */
public class C10155f {

    /* renamed from: he.f$a */
    public class a implements InterfaceC13454g {
        @Override // p709vj.InterfaceC13454g
        /* renamed from: a */
        public void mo63303a(int i10) {
            C11839m.m70688i("BaseSyncUtil", "hwid provider result: " + i10);
            if (i10 != 0) {
                if (i10 == 1 && C13452e.m80781L().m80846Q0()) {
                    C13452e.m80781L().m80945m2(false);
                    return;
                }
                return;
            }
            if (C13452e.m80781L().m80842P0()) {
                C11839m.m70688i("BaseSyncUtil", "hicloud is login, clear account info");
                C13452e.m80781L().m80945m2(true);
                C12515a.m75110o().m75172d(new C10146i(2));
            }
        }
    }

    /* renamed from: A */
    public static boolean m63248A() {
        return C10028c.m62182c0().m62395t1("funcfg_huawei_drive");
    }

    /* renamed from: B */
    public static boolean m63249B() {
        return m63290n();
    }

    /* renamed from: C */
    public static boolean m63250C(Context context) {
        return (context == null || m63288l() || C0209d.m1258g2(context) || !C10028c.m62182c0().m62395t1("funcfg_blocked_down")) ? false : true;
    }

    /* renamed from: D */
    public static boolean m63251D() {
        return C10028c.m62182c0().m62395t1("funcfg_manage_storage");
    }

    /* renamed from: E */
    public static boolean m63252E() {
        return C10028c.m62182c0().m62395t1("funcfg_notes");
    }

    /* renamed from: F */
    public static boolean m63253F() {
        return C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe");
    }

    /* renamed from: G */
    public static boolean m63254G(Context context) {
        return (context == null || m63288l() || !C10028c.m62182c0().m62395t1("funcfg_recordings_down")) ? false : true;
    }

    /* renamed from: H */
    public static boolean m63255H(Context context) {
        return context != null && C11829c.m70523I0(context) && C10028c.m62182c0().m62395t1("funcfg_messaging_down");
    }

    /* renamed from: I */
    public static boolean m63256I() {
        return C9733f.m60705z().m60720O("SpaceExperienceGiftPackageActivity");
    }

    /* renamed from: J */
    public static boolean m63257J() {
        return C9733f.m60705z().m60720O("cloudPhotoObsFlowControl");
    }

    /* renamed from: K */
    public static boolean m63258K() {
        C11839m.m70688i("BaseSyncUtil", "enter isTodayCanShow");
        Context contextM1377a = C0213f.m1377a();
        Pair<Integer, Integer> pairM63282f = m63282f();
        long jM1359i = C0212e0.m1359i(contextM1377a, "sp_desktop_dialog", "key_last_show_time", 0L);
        int iM1357g = C0212e0.m1357g(contextM1377a, "sp_desktop_dialog", "key_last_show_count", 0);
        C11839m.m70688i("BaseSyncUtil", "isTodayCanShow, lastTime: " + jM1359i + ", count: " + iM1357g);
        if (System.currentTimeMillis() - jM1359i >= ((Integer) pairM63282f.first).intValue() * C5863b6.g.f26453g) {
            AbstractC10896a.m65887i("BaseSyncUtil", "isTodayCanShow, the last display was more than the set number of days ago");
            C0212e0.m1368r(contextM1377a, "sp_desktop_dialog", "key_last_show_count", 0);
            return true;
        }
        if (iM1357g >= ((Integer) pairM63282f.second).intValue()) {
            AbstractC10896a.m65887i("BaseSyncUtil", "isTodayCanShow, the number of times exceeded the limit set");
            return false;
        }
        AbstractC10896a.m65887i("BaseSyncUtil", "isTodayCanShow, the number of times does not exceed the upper limit set");
        return true;
    }

    /* renamed from: L */
    public static boolean m63259L(Context context) {
        if (context == null) {
            return true;
        }
        UserManager userManager = (UserManager) context.getSystemService("user");
        return userManager != null && userManager.isUserUnlocked();
    }

    /* renamed from: M */
    public static boolean m63260M(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: N */
    public static boolean m63261N(String str) {
        return str.equals("addressbook") || str.equals("calendar");
    }

    /* renamed from: O */
    public static void m63262O(Context context, boolean z10) {
        C11839m.m70686d("BaseSyncUtil", "onMainSwitchChange");
        if (context == null) {
            C11839m.m70689w("BaseSyncUtil", "context is null");
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s("backup_key")));
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s("addressbook")));
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s("calendar")));
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s("notepad")));
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s("browser")));
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s("wlan")));
        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62216G1(context)));
        arrayList.add(Boolean.valueOf(C1010e.m6125b().m6139e(context)));
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        int i10 = 0;
        if (shownSyncServiceItems.size() > 0) {
            for (int i11 = 0; i11 < shownSyncServiceItems.size(); i11++) {
                SyncConfigService syncConfigService = shownSyncServiceItems.get(i11);
                if (syncConfigService != null) {
                    String id2 = syncConfigService.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        arrayList.add(Boolean.valueOf(c10028cM62182c0.m62388s(id2)));
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((Boolean) it.next()).booleanValue()) {
                i10++;
            }
        }
        if (!(z10 && i10 == 1) && (z10 || i10 != 0)) {
            return;
        }
        try {
            C11839m.m70686d("BaseSyncUtil", "onMainSwitchChange update");
            Uri uri = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/hicloud");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                contentResolver.update(uri, null, null, null);
            }
        } catch (Exception e10) {
            C11839m.m70687e("BaseSyncUtil", "onMainSwitchChange update failed : " + e10.toString());
        }
    }

    /* renamed from: P */
    public static void m63263P(Context context, String str, String str2, int i10) {
        C13223b.m79477e(context, str, true, i10);
        UBAAnalyze.m29944E("CKC", C13471c.m81132e().get(str), i10);
        C10028c.m62182c0().m62336h2(str, true);
        m63262O(context, true);
        C13612b.m81829B().m81870k0(context.getApplicationContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C12515a.m75110o().m75172d(new C10147j(C0213f.m1377a(), arrayList, "03003", str2));
    }

    /* renamed from: Q */
    public static String m63264Q() {
        if (!C13452e.m80781L().m80791C0()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.grade");
            Iterator<C4987f> it = C14157f.m84942g().m84949i(null, arrayList, "RefreshGrade").iterator();
            while (it.hasNext()) {
                C4987f next = it.next();
                try {
                } catch (NumberFormatException unused) {
                    C11839m.m70689w("BaseSyncUtil", next.m30026b() + "--" + next.m30027c());
                }
                if (TextUtils.equals(next.m30026b(), "bs.grade")) {
                    C13452e.m80781L().m80940l1(next.m30027c());
                    return next.m30027c();
                }
                continue;
            }
        }
        return C13452e.m80781L().m80790C();
    }

    /* renamed from: R */
    public static void m63265R(PortraitAndGrade portraitAndGrade) {
        List<PortraitAndGrade.UserTag> userTags;
        Gson gson = new Gson();
        PortraitAndGrade.UserTagList userTagList = portraitAndGrade.getUserTagList();
        PortraitAndGrade.GradeRights gradeRights = portraitAndGrade.getGradeRights();
        if (userTagList != null && (userTags = userTagList.getUserTags()) != null) {
            C13452e.m80781L().m80948n1(gson.toJson(userTags));
            C14306d.m85216q(C11326d.m68046h());
        }
        if (gradeRights != null) {
            String gradeCode = gradeRights.getGradeCode();
            if (TextUtils.isEmpty(gradeCode)) {
                return;
            }
            C13452e.m80781L().m80940l1(gradeCode);
        }
    }

    /* renamed from: S */
    public static void m63266S(Context context, String str, int i10) {
        C10028c.m62182c0().m62336h2(str, false);
        NotifyConstants.putServicesMoudleIntoMap(str, false);
        C13223b.m79477e(context, str, false, i10);
        UBAAnalyze.m29955P("PVC", C13471c.m81131d().get(str), "1", "29", i10);
    }

    /* renamed from: T */
    public static void m63267T(Context context, int i10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", false);
        C1006a.m5936k().m5943G(context, bundle, 14);
        C1008c.m6035v().m6053R(context, false);
    }

    /* renamed from: U */
    public static void m63268U(Context context, String str, int i10) {
        if (str == null) {
            C11839m.m70687e("BaseSyncUtil", "setSyncSwitchOff, moduleName is null");
            return;
        }
        C11839m.m70688i("BaseSyncUtil", "setSyncSwitchOff, moduleName is " + str);
        switch (str) {
            case "addressbook":
                C10028c.m62182c0().m62336h2("addressbook", false);
                C1008c.m6035v().m6103u0(context, "addressbook");
                C1008c.m6035v().m6082k(context, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                C13223b.m79477e(context, "addressbook", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("addressbook"), "1", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, i10);
                break;
            case "gallery":
                m63267T(context, i10);
                break;
            case "calendar":
                C10028c.m62182c0().m62336h2("calendar", false);
                C10028c.m62182c0().m62348k(str);
                C13223b.m79477e(context, "calendar", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("calendar"), "1", "11", i10);
                break;
            case "wlan":
                m63269V(context, i10);
                break;
            case "browser":
                C10028c.m62182c0().m62336h2("browser", false);
                C13223b.m79477e(context, "browser", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("browser"), "1", "20", i10);
                break;
            case "notepad":
                C10028c.m62182c0().m62336h2("notepad", false);
                C13223b.m79477e(context, "notepad", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("notepad"), "1", "10", i10);
                break;
            default:
                m63266S(context, str, i10);
                break;
        }
        m63262O(context, false);
    }

    /* renamed from: V */
    public static void m63269V(Context context, int i10) {
        C10028c.m62182c0().m62336h2("wlan", false);
        C1008c.m6035v().m6061Z("dsswitch");
        C1008c.m6035v().m6103u0(context, "wlan");
        C1008c.m6035v().m6082k(context, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
        C13223b.m79477e(context, "wlan", false, i10);
        UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("wlan"), "1", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, i10);
    }

    /* renamed from: W */
    public static void m63270W(Context context, String str, int i10) {
        m63263P(context, "browser", str, i10);
        C1008c.m6035v().m6065b0(context, 1, "");
    }

    /* renamed from: X */
    public static void m63271X(Context context, String str, int i10) {
        m63263P(context, "calendar", str, i10);
        C1008c.m6035v().m6067c0(context, 1, "");
    }

    /* renamed from: Y */
    public static void m63272Y(Context context, String str, int i10, int i11) {
        if (C13843a.m83073Y(context)) {
            m63273Z(context, str, i11);
            return;
        }
        m63263P(context, "addressbook", str, i11);
        C1008c.m6035v().m6081j0(context);
        C1008c.m6035v().m6069d0(i10);
    }

    /* renamed from: Z */
    public static void m63273Z(Context context, String str, int i10) {
        m63263P(context, "addressbook", str, i10);
        C1008c.m6035v().m6071e0(context, 1, "");
    }

    /* renamed from: a */
    public static boolean m63274a() {
        if (C11829c.m70530L0()) {
            return true;
        }
        NotifyLogger.m29916w("BaseSyncUtil", "checkIsSupportHicloudActives not support pps ads");
        return false;
    }

    /* renamed from: a0 */
    public static void m63275a0(Context context, String str, int i10) {
        m63263P(context, "notepad", str, i10);
        C1008c.m6035v().m6077h0(context, 1, "");
    }

    /* renamed from: b */
    public static void m63276b(Context context) {
        if (C0209d.m1246d2(context) && C0209d.m1203Q1(context)) {
            C13612b.m81829B().m81890v(context, new a());
        } else {
            C11839m.m70688i("BaseSyncUtil", "user locked or startupguide not finished");
        }
    }

    /* renamed from: b0 */
    public static void m63277b0(Context context, String str, String str2, int i10) {
        NotifyConstants.putServicesMoudleIntoMap(str, true);
        m63263P(context, str, str2, i10);
        C1008c.m6035v().m6075g0(context, str, 1, "");
    }

    /* renamed from: c */
    public static void m63278c(Context context, String str, int i10) {
        if (str == null) {
            C11839m.m70687e("BaseSyncUtil", "setSyncSwitchOff, moduleName is null");
            return;
        }
        C11839m.m70688i("BaseSyncUtil", "closeSyncSwitch, moduleName is " + str);
        switch (str) {
            case "addressbook":
                C10028c.m62182c0().m62336h2("addressbook", false);
                C1008c.m6035v().m6103u0(context, "addressbook");
                C1008c.m6035v().m6082k(context, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                C13223b.m79477e(context, "addressbook", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("addressbook"), "1", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, i10);
                break;
            case "gallery":
                m63267T(context, i10);
                break;
            case "calendar":
            case "browser":
            case "notepad":
                C10028c.m62182c0().m62336h2(str, false);
                C13223b.m79477e(context, str, false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get(str), "1", "10", i10);
                break;
            case "wlan":
                m63269V(context, i10);
                break;
            default:
                m63266S(context, str, i10);
                break;
        }
        m63262O(context, false);
    }

    /* renamed from: c0 */
    public static void m63279c0(Context context, String str, int i10) {
        m63263P(context, "wlan", str, i10);
        C1008c.m6035v().m6061Z("dsswitch");
        C1008c.m6035v().m6081j0(context);
        C1008c.m6035v().m6089n0(context);
    }

    /* renamed from: d */
    public static List<NotificationWithActivity> m63280d(List<NotificationWithActivity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("BaseSyncUtil", "getDlAppActivity activityList is null");
            return arrayList;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            if (notificationWithActivity.getActivityType() == 1 && m63274a()) {
                arrayList.add(notificationWithActivity);
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static List<NotificationWithActivity> m63281e(List<NotificationWithActivity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("BaseSyncUtil", "getDlAppActivity activityList is null");
            return arrayList;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            if (notificationWithActivity.getActivityType() != 1) {
                arrayList.add(notificationWithActivity);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static Pair<Integer, Integer> m63282f() {
        InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        Pair<Integer, Integer> pair = new Pair<>(24, 1);
        if (interfaceC9283b != null) {
            pair = interfaceC9283b.mo58517l();
        }
        C11839m.m70688i("BaseSyncUtil", "isTodayCanShow, deskPopupInterval: " + pair.first + ", deskPopupTimes: " + pair.second);
        return pair;
    }

    /* renamed from: g */
    public static String m63283g(String str) {
        C11839m.m70688i("BaseSyncUtil", "getParamValue enter");
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(arrayList, null, "GetParamLocal");
        if (listM84949i == null || listM84949i.isEmpty()) {
            C11839m.m70689w("BaseSyncUtil", "params is null or empty");
            return "";
        }
        C4987f c4987f = listM84949i.get(0);
        if (c4987f == null) {
            C11839m.m70689w("BaseSyncUtil", "paramsValue is null");
            return "";
        }
        String strM30027c = c4987f.m30027c();
        if (strM30027c == null) {
            C11839m.m70689w("BaseSyncUtil", "value is null");
            return "";
        }
        C11839m.m70686d("BaseSyncUtil", "getParamValue, key = " + str + ", value = " + strM30027c);
        return strM30027c;
    }

    /* renamed from: h */
    public static List<Integer> m63284h(List<NotificationWithActivity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("BaseSyncUtil", "getRecommendActivityList activityList is null");
            return arrayList;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            if (!arrayList.contains(Integer.valueOf(notificationWithActivity.getActivityType()))) {
                if (notificationWithActivity.getActivityType() != 1) {
                    arrayList.add(Integer.valueOf(notificationWithActivity.getActivityType()));
                } else if (m63274a()) {
                    arrayList.add(6);
                }
            }
        }
        C11839m.m70688i("BaseSyncUtil", "getRecommendActivityList activityList = " + arrayList.toString());
        return arrayList;
    }

    /* renamed from: i */
    public static boolean m63285i(Context context) {
        return C13843a.m83092n(context) != null || C13843a.m83078b0(context, "com.android.browser");
    }

    /* renamed from: j */
    public static boolean m63286j(Context context) {
        boolean z10;
        if (context == null) {
            C11839m.m70687e("BaseSyncUtil", "isCloudSyncModuleSwitchOpen failed, context is null");
            return false;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        boolean zM62388s2 = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s3 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s4 = c10028cM62182c0.m62388s("browser");
        boolean zM62388s5 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s6 = c10028cM62182c0.m62388s("wlan");
        boolean zM62216G1 = c10028cM62182c0.m62216G1(context);
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        if (shownSyncServiceItems.size() > 0) {
            z10 = false;
            for (int i10 = 0; i10 < shownSyncServiceItems.size(); i10++) {
                SyncConfigService syncConfigService = shownSyncServiceItems.get(i10);
                if (syncConfigService != null) {
                    String id2 = syncConfigService.getId();
                    if (!TextUtils.isEmpty(id2) && c10028cM62182c0.m62388s(id2)) {
                        z10 = true;
                    }
                }
            }
        } else {
            z10 = false;
        }
        return zM62388s || zM62388s2 || zM62388s3 || zM62388s4 || zM62388s5 || zM62388s6 || zM62216G1 || z10;
    }

    /* renamed from: k */
    public static boolean m63287k(List<NotificationWithActivity> list) {
        List<Integer> listM63284h = m63284h(list);
        if (listM63284h.size() != 0) {
            return listM63284h.contains(6);
        }
        NotificationReportUtil.reportPrepareActivityNoSpace("0008", "result = 0007");
        NotifyLogger.m29914e("BaseSyncUtil", "isContainActivity activityTypeList is null");
        return false;
    }

    /* renamed from: l */
    public static boolean m63288l() {
        return C9733f.m60705z().m60763v("disableHistoryData") == 1;
    }

    /* renamed from: m */
    public static boolean m63289m() {
        return !C9733f.m60705z().m60720O("SpaceExperienceGiftPackageActivityStopped");
    }

    /* renamed from: n */
    public static boolean m63290n() {
        return C10028c.m62182c0().m62395t1("funcfg_gallery");
    }

    /* renamed from: o */
    public static boolean m63291o(Context context) {
        if (context == null) {
            return false;
        }
        boolean z10 = m63286j(context) || C1010e.m6125b().m6139e(context) || C1006a.m5936k().m5975v(context);
        C11839m.m70688i("BaseSyncUtil", "isMainSwitchOpen : " + z10);
        return z10;
    }

    /* renamed from: p */
    public static boolean m63292p() {
        if (C13452e.m80781L().m80887a1()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        return m63294r(C14157f.m84942g().m84949i(arrayList, null, "BmTypeLocal"));
    }

    /* renamed from: q */
    public static boolean m63293q(long j10) {
        if (C13452e.m80781L().m80887a1()) {
            return true;
        }
        return ((Boolean) C0226l0.m1582b(new Callable() { // from class: he.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(C10155f.m63292p());
            }
        }, j10, Boolean.FALSE)).booleanValue();
    }

    /* renamed from: r */
    public static boolean m63294r(List<C4987f> list) {
        if (list == null || list.isEmpty()) {
            C13452e.m80781L().m80871W1(true);
            C11839m.m70689w("BaseSyncUtil", "isNewBmType, params is null or empty.");
            return false;
        }
        C4987f c4987f = list.get(0);
        if (c4987f == null) {
            C13452e.m80781L().m80871W1(true);
            C11839m.m70689w("BaseSyncUtil", "isNewBmType, paramsValue is null.");
            return false;
        }
        try {
            C13452e.m80781L().m80871W1(false);
            if (Integer.parseInt(c4987f.m30027c()) == 1) {
                C13452e.m80781L().m80985w2(true);
                return true;
            }
            C13452e.m80781L().m80985w2(false);
            return false;
        } catch (Exception e10) {
            C13452e.m80781L().m80871W1(true);
            C11839m.m70687e("BaseSyncUtil", "isNewBmType, occur err = " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: s */
    public static boolean m63295s() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("bs.bm.type");
        ArrayList arrayList2 = new ArrayList();
        C14157f.m84942g().m84954n(arrayList, arrayList2, "BmType");
        return m63294r(arrayList2);
    }

    /* renamed from: t */
    public static boolean m63296t(Context context) {
        return context != null && m63285i(context) && C10028c.m62182c0().m62395t1("funcfg_browser");
    }

    /* renamed from: u */
    public static boolean m63297u() {
        return C10028c.m62182c0().m62395t1("funcfg_calendar");
    }

    /* renamed from: v */
    public static boolean m63298v(Context context) {
        return context != null && C11829c.m70546T0(context) && C10028c.m62182c0().m62395t1("funcfg_call_log_down");
    }

    /* renamed from: w */
    public static boolean m63299w() {
        return false;
    }

    /* renamed from: x */
    public static boolean m63300x() {
        return false;
    }

    /* renamed from: y */
    public static boolean m63301y() {
        return C10028c.m62182c0().m62395t1("funcfg_cloud_backup");
    }

    /* renamed from: z */
    public static boolean m63302z() {
        return C10028c.m62182c0().m62395t1("funcfg_contacts");
    }
}
