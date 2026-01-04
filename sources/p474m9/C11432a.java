package p474m9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import gp.C10028c;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: m9.a */
/* loaded from: classes3.dex */
public class C11432a {

    /* renamed from: a */
    public static boolean f53271a = false;

    /* renamed from: b */
    public static String f53272b = "";

    /* renamed from: c */
    public static LinkedHashMap<String, String> f53273c;

    /* renamed from: d */
    public static C11432a f53274d = new C11432a();

    /* renamed from: b */
    public static LinkedHashMap<String, String> m68478b() {
        return f53273c;
    }

    /* renamed from: d */
    public static C11432a m68479d() {
        return f53274d;
    }

    /* renamed from: e */
    public static String m68480e() {
        return f53272b;
    }

    /* renamed from: f */
    public static boolean m68481f() {
        return f53271a;
    }

    /* renamed from: g */
    public static void m68482g(LinkedHashMap<String, String> linkedHashMap) {
        f53273c = linkedHashMap;
    }

    /* renamed from: i */
    public static void m68483i(String str) {
        f53272b = str;
    }

    /* renamed from: j */
    public static void m68484j(boolean z10) {
        f53271a = z10;
    }

    /* renamed from: a */
    public void m68485a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("DataAnalyzeManager", "context is null");
            return;
        }
        C11839m.m70688i("DataAnalyzeManager", "clearHiCloudDataAnalyze");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM1377a, "sp_data_analyze", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("DataAnalyzeManager", "sp is null");
        } else {
            sharedPreferencesM1382b.edit().clear().apply();
        }
    }

    /* renamed from: c */
    public void m68486c() {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i("DataAnalyzeManager", "processHiCloudDataAnalyze user not login.");
            return;
        }
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C11839m.m70688i("DataAnalyzeManager", "processHiCloudDataAnalyze no network");
        } else if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
            C11839m.m70688i("DataAnalyzeManager", "ForcedUpgrade, do not get switch");
        } else {
            C12515a.m75110o().m75172d(new C11433b());
        }
    }

    /* renamed from: h */
    public void m68487h(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("DataAnalyzeManager", "context is null");
            return;
        }
        C11839m.m70688i("DataAnalyzeManager", "setHiCloudDataAnalyze: " + str);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM1377a, "sp_data_analyze", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("DataAnalyzeManager", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        if (TextUtils.isEmpty(str) || !str.equals(FaqConstants.DISABLE_HA_REPORT)) {
            editorEdit.putBoolean("clientLogReport", false);
        } else {
            editorEdit.putBoolean("clientLogReport", true);
        }
        editorEdit.apply();
    }
}
