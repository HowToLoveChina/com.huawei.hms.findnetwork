package p015ak;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import hu.C10344c;
import java.util.LinkedHashMap;
import p399jk.AbstractC10896a;

/* renamed from: ak.g0 */
/* loaded from: classes6.dex */
public class C0216g0 {

    /* renamed from: a */
    public boolean f807a;

    /* renamed from: b */
    public SharedPreferences f808b;

    /* renamed from: ak.g0$b */
    public static class b {

        /* renamed from: a */
        public static final C0216g0 f809a = new C0216g0();
    }

    public /* synthetic */ C0216g0(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C0216g0 m1402e(Context context) {
        if (b.f809a.f808b == null) {
            b.f809a.m1436n(context);
        }
        return b.f809a;
    }

    /* renamed from: A */
    public void m1403A(String str) {
        if ("2".equals(str) && this.f808b != null) {
            AbstractC10896a.m65887i("StartupSourceManager", "refreshHwIdRecomEnterTime");
            this.f808b.edit().putLong("hwid_recomend_enter_time_key", System.currentTimeMillis()).commit();
        }
    }

    /* renamed from: B */
    public void m1404B() {
        m1409G(System.currentTimeMillis());
    }

    /* renamed from: C */
    public final void m1405C(String str) {
        m1420R("activityCode", str);
    }

    /* renamed from: D */
    public void m1406D(Intent intent, String str, String str2) {
        try {
            if (intent == null) {
                AbstractC10896a.m65886e("StartupSourceManager", "setEntranceExtra intent is null");
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean("needRecordSource", true);
            extras.putString("startupSource", str);
            extras.putString("startupSourceId", str2);
            intent.putExtras(extras);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StartupSourceManager", "setEntranceExtra exception: " + e10.toString());
        }
    }

    /* renamed from: E */
    public void m1407E(Intent intent, String str) {
        m1406D(intent, "SOURCE_DIALOG", str);
    }

    /* renamed from: F */
    public void m1408F(Intent intent, String str) {
        m1406D(intent, "SOURCE_NOTIFY", str);
    }

    /* renamed from: G */
    public void m1409G(long j10) {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_update_time", j10).commit();
        }
    }

    /* renamed from: H */
    public final void m1410H(String str) {
        m1420R("latestActivityCode", str);
    }

    /* renamed from: I */
    public final void m1411I(String str) {
        m1420R("latestSalChannel", str);
    }

    /* renamed from: J */
    public void m1412J(String str) {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("latestSource", str).commit();
        }
    }

    /* renamed from: K */
    public void m1413K(String str) {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("latestSourceId", str).commit();
        }
    }

    /* renamed from: L */
    public void m1414L(boolean z10) {
        this.f807a = z10;
    }

    /* renamed from: M */
    public void m1415M(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            return;
        }
        linkedHashMap.put("startupSource", m1433k());
        linkedHashMap.put("startupSourceId", m1434l());
        linkedHashMap.put("latestStartupSource", m1430h());
        linkedHashMap.put("latestStartupSourceId", m1431i());
        m1448z("salChannel", m1432j(), linkedHashMap);
        m1448z("activityCode", m1426c(), linkedHashMap);
        m1448z("latestSalChannel", m1429g(), linkedHashMap);
        m1448z("latestActivityCode", m1425b(), linkedHashMap);
    }

    /* renamed from: N */
    public final void m1416N(String str) {
        m1420R("salChannel", str);
    }

    /* renamed from: O */
    public void m1417O() {
        m1421S("SOURCE_OTHER_APP", "SOURCE_ID_SETTING_BACKUP_AND_RECOVERY");
    }

    /* renamed from: P */
    public void m1418P(String str) {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("source", str).commit();
        }
    }

    /* renamed from: Q */
    public void m1419Q(String str) {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sourceId", str).commit();
        }
    }

    /* renamed from: R */
    public final void m1420R(String str, String str2) {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (str2 == null) {
                str2 = "";
            }
            editorEdit.putString(str, str2).commit();
        }
    }

    /* renamed from: S */
    public synchronized void m1421S(String str, String str2) {
        try {
            long jM1428f = m1428f();
            long jCurrentTimeMillis = System.currentTimeMillis();
            AbstractC10896a.m65887i("StartupSourceManager", "check update source, source: " + str + ", source id: " + str2 + ", last update time: " + jM1428f + ", current time: " + jCurrentTimeMillis);
            if (jCurrentTimeMillis - jM1428f > 1800000) {
                AbstractC10896a.m65887i("StartupSourceManager", "update source, source: " + str + ", source id: " + str2);
                m1418P(str);
                m1419Q(str2);
                m1409G(jCurrentTimeMillis);
            }
            m1412J(str);
            m1413K(str2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: T */
    public synchronized void m1422T(String str, String str2, String str3) {
        try {
            long jM1428f = m1428f();
            long jCurrentTimeMillis = System.currentTimeMillis();
            AbstractC10896a.m65887i("StartupSourceManager", "check update source, source: " + str + ", source id: " + str2 + ", last update time: " + jM1428f + ", current time: " + jCurrentTimeMillis);
            if (jCurrentTimeMillis - jM1428f > 1800000) {
                AbstractC10896a.m65887i("StartupSourceManager", "update source, source: " + str + ", source id: " + str2);
                m1418P(str);
                m1419Q(str2);
                m1405C(str3);
                m1409G(jCurrentTimeMillis);
            }
            m1412J(str);
            m1410H(str3);
            m1413K(str2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: U */
    public synchronized void m1423U(String str, String str2, String str3, String str4) {
        try {
            long jM1428f = m1428f();
            long jCurrentTimeMillis = System.currentTimeMillis();
            AbstractC10896a.m65887i("StartupSourceManager", "check update source, source: " + str + ", source id: " + str2 + ", last update time: " + jM1428f + ", current time: " + jCurrentTimeMillis);
            if (jCurrentTimeMillis - jM1428f > 1800000) {
                AbstractC10896a.m65887i("StartupSourceManager", "update source, source: " + str + ", source id: " + str2);
                m1418P(str);
                m1419Q(str2);
                m1416N(str3);
                m1405C(str4);
                m1409G(jCurrentTimeMillis);
            }
            m1412J(str);
            m1413K(str2);
            m1411I(str3);
            m1410H(str4);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public void m1424a() {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public final String m1425b() {
        return m1435m("latestActivityCode");
    }

    /* renamed from: c */
    public String m1426c() {
        return TextUtils.equals(m1435m("activityCode"), "default") ? m1425b() : m1435m("activityCode");
    }

    /* renamed from: d */
    public long m1427d() {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("hwid_recomend_enter_time_key", 0L);
        }
        return 0L;
    }

    /* renamed from: f */
    public long m1428f() {
        SharedPreferences sharedPreferences = this.f808b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_update_time", 0L);
        }
        return 0L;
    }

    /* renamed from: g */
    public final String m1429g() {
        return m1435m("latestSalChannel");
    }

    /* renamed from: h */
    public String m1430h() {
        SharedPreferences sharedPreferences = this.f808b;
        return sharedPreferences != null ? sharedPreferences.getString("latestSource", "default") : "default";
    }

    /* renamed from: i */
    public String m1431i() {
        SharedPreferences sharedPreferences = this.f808b;
        return sharedPreferences != null ? sharedPreferences.getString("latestSourceId", "default") : "default";
    }

    /* renamed from: j */
    public String m1432j() {
        return TextUtils.equals(m1435m("salChannel"), "default") ? m1429g() : m1435m("salChannel");
    }

    /* renamed from: k */
    public String m1433k() {
        SharedPreferences sharedPreferences = this.f808b;
        return sharedPreferences != null ? sharedPreferences.getString("source", "default") : "default";
    }

    /* renamed from: l */
    public String m1434l() {
        SharedPreferences sharedPreferences = this.f808b;
        return sharedPreferences != null ? sharedPreferences.getString("sourceId", "default") : "default";
    }

    /* renamed from: m */
    public final String m1435m(String str) {
        SharedPreferences sharedPreferences = this.f808b;
        return sharedPreferences != null ? sharedPreferences.getString(str, "default") : "default";
    }

    /* renamed from: n */
    public final void m1436n(Context context) {
        if (context == null) {
            context = C0213f.m1377a();
        }
        this.f808b = C0214f0.m1382b(context, "startup_source_records", 0);
    }

    /* renamed from: o */
    public boolean m1437o() {
        return this.f807a;
    }

    /* renamed from: p */
    public final void m1438p(SafeIntent safeIntent) {
        Bundle extras;
        try {
            extras = safeIntent.getExtras();
        } catch (Exception e10) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseActionExternalLogin error: " + e10);
        }
        if (extras == null) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_DEFAULT");
            return;
        }
        if (extras.containsKey(FaqConstants.FAQ_MODULE)) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_FILE_MANAGER");
            return;
        }
        if (extras.containsKey("start_source")) {
            if ("hwid_login".equals(extras.getString("start_source"))) {
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_ACCOUNT_LOGIN");
                return;
            } else {
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_ACCOUNT_LOGIN_PARAMETER_MISSING");
                return;
            }
        }
        m1421S("SOURCE_OTHER_APP", "SOURCE_ID_DEFAULT");
    }

    /* renamed from: q */
    public final void m1439q(SafeIntent safeIntent) {
        Bundle extras = safeIntent.getExtras();
        if (extras == null) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_APP_MARKET");
            return;
        }
        if (extras.containsKey("startFromLauncher")) {
            m1421S("SOURCE_LAUNCHER", "SOURCE_ID_ICON");
            return;
        }
        if (!extras.containsKey(KpmsConstant.CALLER_PACKAGE_NAME)) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_DEFAULT");
        } else if ("com.huawei.hms.iap".equals(extras.getString(KpmsConstant.CALLER_PACKAGE_NAME))) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_HUAWEI_POINTS");
        } else {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_DEFAULT");
        }
    }

    /* renamed from: r */
    public final void m1440r(SafeIntent safeIntent) {
        Bundle extras = safeIntent.getExtras();
        if (extras == null) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_MY_HUAWEI");
            return;
        }
        if (!extras.containsKey("startSource")) {
            if (extras.containsKey(RemoteMessageConst.FROM)) {
                m1421S("SOURCE_OTHER_APP", extras.getString(RemoteMessageConst.FROM));
                return;
            } else {
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_DEFAULT");
                return;
            }
        }
        String string = extras.getString("startSource");
        if ("hwID".equals(string)) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_ACCOUNT_CENTER");
        } else {
            m1421S("SOURCE_OTHER_APP", string);
        }
    }

    /* renamed from: s */
    public final void m1441s(SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        if (TextUtils.isEmpty(stringExtra)) {
            m1423U("SOURCE_PUSH", "SOURCE_ID_DEFAULT", stringExtra2, stringExtra3);
        } else {
            m1423U("SOURCE_PUSH", stringExtra, stringExtra2, stringExtra3);
        }
    }

    /* renamed from: t */
    public final void m1442t(Intent intent) {
        try {
        } catch (Exception e10) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseActionRemoteControl error: " + e10);
        }
        if (intent == null) {
            AbstractC10896a.m65887i("StartupSourceManager", "intent is null!");
            return;
        }
        Bundle extras = new HiCloudSafeIntent(intent).getExtras();
        if (extras == null) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_SETTING_SAFE_PHONEFINDER");
            return;
        }
        if (extras.containsKey(RemoteMessageConst.FROM)) {
            String string = extras.getString(RemoteMessageConst.FROM);
            if ("com.huawei.hwid".equals(string)) {
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_ACCOUNT_CENTER_PHONEFINDER");
                return;
            } else if ("com.huawei.systemmanager".equals(string)) {
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_SYSTEM_MANAGER_PHONEFINDER");
                return;
            } else {
                m1421S("SOURCE_OTHER_APP", string);
                return;
            }
        }
        m1421S("SOURCE_OTHER_APP", "SOURCE_SETTING_SAFE_PHONEFINDER");
    }

    /* renamed from: u */
    public final void m1443u(SafeIntent safeIntent) {
        Bundle extras = safeIntent.getExtras();
        if (extras == null) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_RESET_PHONE");
            return;
        }
        if (extras.containsKey("android.intent.extra.USER")) {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_CONTACT_USER");
        } else if (extras.containsKey(RemoteMessageConst.FROM)) {
            m1421S("SOURCE_OTHER_APP", extras.getString(RemoteMessageConst.FROM));
        } else {
            m1421S("SOURCE_OTHER_APP", "SOURCE_ID_DEFAULT");
        }
    }

    /* renamed from: v */
    public final boolean m1444v(SafeIntent safeIntent) {
        String action = safeIntent.getAction();
        if (TextUtils.isEmpty(action)) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseActions, but action is null");
            return false;
        }
        action.hashCode();
        switch (action) {
            case "android.intent.action.MAIN":
                m1439q(safeIntent);
                break;
            case "com.huawei.hidisk.push.action":
                m1441s(safeIntent);
                break;
            case "com.huawei.hicloud.action.EXTERNAL_LOGIN_FOR_FILEMANAGER":
            case "com.huawei.hicloud.action.EXTERNAL_LOGIN":
                m1438p(safeIntent);
                break;
            case "com.huawei.android.intent.action.otherapp.HICLOUD_ENTTRANCE":
                m1440r(safeIntent);
                break;
            case "com.huawei.android.remotecontrol.PHONEFINDER_ENTTRANCE":
                m1442t(safeIntent);
                break;
            case "com.huawei.hicloud.action.GALLERY_LOGIN_NEW":
            case "com.huawei.hicloud.action.GALLERY_LOGIN":
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_GALLERY");
                break;
            case "com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE":
                m1443u(safeIntent);
                break;
            case "com.huawei.hicloud.action.FAMILY_CLOUD_SPACE_SHARE":
                m1421S("SOURCE_OTHER_APP", "SOURCE_ID_FAMILY_SHARE");
                break;
            default:
                AbstractC10896a.m65887i("StartupSourceManager", "action not null, but not match");
                break;
        }
        return false;
    }

    /* renamed from: w */
    public final boolean m1445w(Intent intent) {
        Bundle extras = new SafeIntent(intent).getExtras();
        if (extras == null) {
            AbstractC10896a.m65888w("StartupSourceManager", "parseCommonEntrance, no extras");
            return false;
        }
        C10343b c10343b = new C10343b(extras);
        if (c10343b.m63682d("needRecordSource", false)) {
            m1421S(c10343b.m63694p("startupSource"), c10343b.m63694p("startupSourceId"));
            return true;
        }
        AbstractC10896a.m65888w("StartupSourceManager", "parseCommonEntrance, no record flag");
        return false;
    }

    /* renamed from: x */
    public final boolean m1446x(SafeIntent safeIntent) {
        String scheme = safeIntent.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseScheme, but scheme is null");
            return false;
        }
        if ("hicloud".equals(scheme)) {
            Uri data = safeIntent.getData();
            if (data == null) {
                m1421S("SOURCE_SCHEME", "SOURCE_ID_DEFAULT");
                return true;
            }
            String strM63704b = C10344c.m63704b(data, "srcChannel");
            if (TextUtils.isEmpty(strM63704b)) {
                m1422T("SOURCE_SCHEME", m1431i(), data.toString());
                return true;
            }
            m1423U("SOURCE_SCHEME", strM63704b, C10344c.m63704b(data, "salChannel"), C10344c.m63704b(data, "activityCode"));
        } else {
            AbstractC10896a.m65887i("StartupSourceManager", "action not null, but not match");
            m1421S("SOURCE_SCHEME", "SOURCE_ID_DEFAULT");
        }
        return true;
    }

    /* renamed from: y */
    public void m1447y(SafeIntent safeIntent) {
        if (safeIntent == null) {
            AbstractC10896a.m65886e("StartupSourceManager", "parseStartupSource, but intent is null");
            return;
        }
        if (m1445w(safeIntent)) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseStartupSource, parse parseCommonEntrance success");
        } else if (m1444v(safeIntent)) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseStartupSource, parse action success");
        } else if (m1446x(safeIntent)) {
            AbstractC10896a.m65887i("StartupSourceManager", "parseStartupSource, parse scheme success");
        }
    }

    /* renamed from: z */
    public final void m1448z(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap.containsKey(str) || TextUtils.isEmpty(str2) || str2.equals("default")) {
            return;
        }
        linkedHashMap.put(str, str2);
    }

    public C0216g0() {
        this.f807a = false;
        this.f808b = null;
    }
}
