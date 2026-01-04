package p521og;

import android.content.ComponentName;
import android.content.Context;
import bf.C1175a;
import com.huawei.android.remotecontrol.p093ui.SmartSuggestionPhoneFinderActivity;
import gp.C10028c;
import p015ak.C0209d;
import p015ak.C0219i;
import p809yg.C13981a;

/* renamed from: og.h */
/* loaded from: classes4.dex */
public class C11875h {
    /* renamed from: a */
    public static boolean m71190a(Context context) {
        if (!C0209d.m1166E1()) {
            C13981a.m83989i("SettingsSuggestUtil", "canSmartSuggestPhoneFinder: is not OwnerUser");
            return false;
        }
        if (C0209d.m1173G1(context)) {
            C13981a.m83989i("SettingsSuggestUtil", "canSmartSuggestPhoneFinder: isPrivacyUser");
            return false;
        }
        if (C0219i.m1467e()) {
            return false;
        }
        if (!C1175a.m7389k(context)) {
            return true;
        }
        C13981a.m83989i("SettingsSuggestUtil", "canSmartSuggestPhoneFinder: phonefinder switch is open");
        return false;
    }

    /* renamed from: b */
    public static void m71191b(Context context) {
        if (context == null) {
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!C0209d.m1166E1() || ((!C0209d.m1202Q0() && !c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe")) || (C0209d.m1202Q0() && !c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe")))) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), "com.huawei.android.remotecontrol.ui.PhoneFinderForSettingActivity"), 2, 1);
        }
        m71193d(context);
    }

    /* renamed from: c */
    public static void m71192c(Context context) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!C11877j.m71198B(context) && c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe") && C0209d.m1166E1()) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), "com.huawei.android.remotecontrol.ui.PhoneFinderForSettingActivity"), 1, 1);
        }
        m71193d(context);
    }

    /* renamed from: d */
    public static void m71193d(Context context) {
        if (context == null) {
            C13981a.m83990w("SettingsSuggestUtil", "setSuggestActivityEnabled: context is null");
            return;
        }
        try {
            ComponentName componentName = new ComponentName(context.getPackageName(), SmartSuggestionPhoneFinderActivity.class.getName());
            if (m71190a(context)) {
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            } else {
                C13981a.m83989i("SettingsSuggestUtil", "setSuggestActivityEnabled: set SmartSuggestionPhoneFinderActivity disabled");
                context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (IllegalArgumentException unused) {
            C13981a.m83990w("SettingsSuggestUtil", "SmartSuggestionPhoneFinderActivity is not exist!");
        }
    }

    /* renamed from: e */
    public static void m71194e(Context context, boolean z10) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), "com.huawei.android.remotecontrol.ui.PhoneFinderForSettingActivity"), z10 ? 1 : 2, 1);
        m71193d(context);
    }
}
